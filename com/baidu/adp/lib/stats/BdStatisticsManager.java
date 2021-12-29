package com.baidu.adp.lib.stats;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.n.d;
import c.a.d.f.n.e;
import c.a.d.f.n.f;
import c.a.d.f.n.i;
import c.a.d.f.n.m.a;
import c.a.d.f.n.o.g;
import c.a.d.f.p.r;
import c.a.d.f.p.t;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes9.dex */
public class BdStatisticsManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMG_OVER_TIME = 2000;
    public static final int INIT_UPLOAD_TIME_INTERVAL = 15000;
    public static final String MAIN_PROCESS_MD5 = "44f94582";
    public static final int MIN_UPLOAD_TIMER_INTERVAL = 60000;
    public static final int OLD_TIMER_INTERVAL = 3600000;
    public static final byte UPLOAD_INIT = 2;
    public static final byte UPLOAD_TIMER = 1;
    public static final int UPLOAD_TIMER_INTERVAL = 120000;
    public static final Handler mHandler;
    public static BdStatisticsManager statisticsManager;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSwitchReady;
    public String mAppVersion;
    public c.a.d.f.n.b mBdLogSetting;
    public d mCommonData;
    public Context mContext;
    public boolean mIsMainProcess;
    public a.b mLogSwitchInitCallback;
    public c mMultiProcessReceiver;
    public String mNotUploadWriteFileDir;
    public String mProcessNameMd5;
    public String mTrackLogWriteFileDir;
    public long mUploadInterval;
    public String mWriteFileDir;
    public r permissionUtil;

    /* loaded from: classes9.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    removeMessages(2);
                    BdStatisticsManager.getInstance().checkLogToUpload();
                } else if (BdStatisticsManager.getInstance().permissionUtil == null || !BdStatisticsManager.getInstance().permissionUtil.isAgreePrivacyPolicy()) {
                } else {
                    BdStatisticsManager.getInstance().forceUploadAllLog();
                    BdStatisticsManager.getInstance().startOrNextUploadTimer();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdStatisticsManager a;

        public b(BdStatisticsManager bdStatisticsManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdStatisticsManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdStatisticsManager;
        }

        @Override // c.a.d.f.n.m.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.isSwitchReady = true;
                if (this.a.mIsMainProcess) {
                    g.i().f();
                }
                BdStatisticsManager.mHandler.removeMessages(2);
                if (BdBaseApplication.getInst().checkInterrupt()) {
                    return;
                }
                BdStatisticsManager.mHandler.sendMessageDelayed(BdStatisticsManager.mHandler.obtainMessage(2), 15000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdStatisticsManager this$0;

        public c(BdStatisticsManager bdStatisticsManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdStatisticsManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdStatisticsManager;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.baidu.adp.stats.uploadallfile".equals(action) && !this.this$0.mIsMainProcess) {
                g.i().t(false);
            }
            if ("com.baidu.adp.stats.upload.alertlog".equals(action) && this.this$0.mIsMainProcess) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("alert_type");
                String string2 = extras.getString("alert_log");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                this.this$0.alert(string, string2);
            }
        }

        public /* synthetic */ c(BdStatisticsManager bdStatisticsManager, a aVar) {
            this(bdStatisticsManager);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(51792605, "Lcom/baidu/adp/lib/stats/BdStatisticsManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(51792605, "Lcom/baidu/adp/lib/stats/BdStatisticsManager;");
                return;
            }
        }
        mHandler = new a(Looper.getMainLooper());
    }

    public BdStatisticsManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSwitchReady = false;
        this.mUploadInterval = AppConfig.TIMESTAMP_AVAILABLE_DURATION;
        this.mLogSwitchInitCallback = new b(this);
    }

    private void addLog(String str, String str2, long j2, String str3, c.a.d.f.n.a aVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, str2, Long.valueOf(j2), str3, aVar, objArr}) == null) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || f.c().a(str)) {
                return;
            }
            if (j2 == -1) {
                g.i().D(str, str2, null, str3, aVar, objArr);
            } else {
                g.i().D(str, str2, String.valueOf(j2), str3, aVar, objArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLogToUpload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            g.i().e();
        }
    }

    private boolean checkUploadRecently(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return System.currentTimeMillis() - getConfig().getLong(str, 0L) < ((long) (((c.a.d.f.n.m.a.o().m(str, 24) * 60) * 60) * 1000));
        }
        return invokeL.booleanValue;
    }

    public static void clearInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            statisticsManager = null;
        }
    }

    private SharedPreferences getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? BdBaseApplication.getInst().getSharedPreferences("alert", 0) : (SharedPreferences) invokeV.objValue;
    }

    public static BdStatisticsManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (statisticsManager == null) {
                synchronized (BdStatisticsManager.class) {
                    if (statisticsManager == null) {
                        statisticsManager = new BdStatisticsManager();
                    }
                }
            }
            return statisticsManager;
        }
        return (BdStatisticsManager) invokeV.objValue;
    }

    private String getProcessNameMd5() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            Context context = this.mContext;
            if (context != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                int myPid = Process.myPid();
                for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
                    if (runningAppProcesses.get(i2).pid == myPid) {
                        String str = runningAppProcesses.get(i2).processName;
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                String d2 = t.d(str.getBytes("UTF-8"));
                                return (TextUtils.isEmpty(d2) || d2.length() <= 8) ? d2 : d2.substring(d2.length() - 8);
                            } catch (UnsupportedEncodingException e2) {
                                BdLog.e(e2.getMessage());
                                return str;
                            }
                        }
                    }
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    private void setUploadTime(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        EditorHelper.putLong(getConfig(), str, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOrNextUploadTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            mHandler.removeMessages(1);
            Handler handler = mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(1), this.mUploadInterval);
        }
    }

    public void addEntryToTmpSwitchConfDic(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, bdUploadStatMsgData) == null) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null || BdBaseApplication.getInst().checkInterrupt()) {
                return;
            }
            forceUploadAllLogIgnoreSwitch();
            c.a.d.f.n.m.a.o().k(str, str2, bdUploadStatMsgData);
        }
    }

    public void aladinPortErr(String str, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i2), str3, objArr}) == null) || f.c().a("aladin_port_error")) {
            return;
        }
        op(true, "aladin_port_error", str, str2, 0L, i2, str3, objArr);
    }

    public void alert(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            BdLog.i("type = " + str + "; log = " + str2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2) && str2.getBytes().length > 524288) {
                str2 = str2.substring(0, 1024);
            }
            if (isMainProcess()) {
                alert(str, str2, null);
                return;
            }
            Intent intent = new Intent("com.baidu.adp.stats.upload.alertlog");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            intent.putExtra("alert_type", str);
            intent.putExtra("alert_log", str2);
            Context context = this.mContext;
            if (context != null) {
                context.sendBroadcast(intent);
                BdLog.i("not MainProcess");
                return;
            }
            BdLog.e("mContext == null");
        }
    }

    public void crash(String str, String str2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, objArr) == null) {
            c.a.d.f.n.a aVar = new c.a.d.f.n.a("crash");
            aVar.b("module", "crash");
            if (!TextUtils.isEmpty(str)) {
                aVar.b("crash_type", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                aVar.b("ci", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                aVar.b("f", str3);
            }
            aVar.b("t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                aVar.c(objArr);
            }
            addLog("crash", "crash", -1L, null, aVar, new Object[0]);
        }
    }

    public void db(String str, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i2), str3, objArr}) == null) || f.c().a(IMTrackDatabase.DbEnum.TABLE_NAME)) {
            return;
        }
        op(true, IMTrackDatabase.DbEnum.TABLE_NAME, str, str2, 0L, i2, str3, objArr);
    }

    public void debug(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, objArr) == null) {
            addLog("dbg", str, -1L, null, null, objArr);
        }
    }

    public void error(String str, long j2, String str2, c.a.d.f.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j2), str2, aVar}) == null) {
            addLog("error", str, j2, str2, aVar, new Object[0]);
        }
    }

    public void eventStat(Context context, String str, String str2, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Integer.valueOf(i2), objArr}) == null) {
            c.a.d.f.n.a aVar = new c.a.d.f.n.a("stat");
            aVar.b("module", "stat");
            if (!TextUtils.isEmpty(str)) {
                aVar.b("op_key", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                aVar.b("pt", str2);
            }
            aVar.b("co", String.valueOf(i2));
            aVar.b("t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                aVar.c(objArr);
                aVar.a("mi", 0);
            }
            addLog("stat", null, -1L, null, aVar, new Object[0]);
        }
    }

    public void file(String str, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, str2, Integer.valueOf(i2), str3, objArr}) == null) || f.c().a("file")) {
            return;
        }
        op(true, "file", str, str2, 0L, i2, str3, objArr);
    }

    public void forceUploadAllLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            g.i().q();
        }
    }

    public void forceUploadAllLogIgnoreSwitch() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || BdBaseApplication.getInst().checkInterrupt()) {
            return;
        }
        g.i().t(false);
        if (this.mIsMainProcess) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    public void forceUploadAllLogIgnoreSwitchImmediately() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || BdBaseApplication.getInst().checkInterrupt()) {
            return;
        }
        g.i().t(true);
    }

    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mAppVersion : (String) invokeV.objValue;
    }

    public c.a.d.f.n.b getBdLogSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mBdLogSetting : (c.a.d.f.n.b) invokeV.objValue;
    }

    public long getClientLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? c.a.d.f.n.k.a.b().a() : invokeV.longValue;
    }

    public String getCurNetworkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? e.a(BdBaseApplication.getInst()) : (String) invokeV.objValue;
    }

    public String getNotUploadWriteDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mNotUploadWriteFileDir : (String) invokeV.objValue;
    }

    public String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mProcessNameMd5 : (String) invokeV.objValue;
    }

    public c.a.d.f.n.a getStatsItem(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? new c.a.d.f.n.a(str) : (c.a.d.f.n.a) invokeL.objValue;
    }

    public String getTrackLogWriteDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mTrackLogWriteFileDir : (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? g.i().k() : (String) invokeV.objValue;
    }

    public long getUploadInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mUploadInterval : invokeV.longValue;
    }

    public String getWriteDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mWriteFileDir : (String) invokeV.objValue;
    }

    public void imgErr(String str, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{str, str2, Integer.valueOf(i2), str3, objArr}) == null) || f.c().a("img")) {
            return;
        }
        op(true, "img", str, str2, 0L, i2, str3, objArr);
    }

    public void imgNet(String str, String str2, long j2, long j3, long j4, long j5, long j6, int i2, int i3, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i2), Integer.valueOf(i3), str3, objArr}) == null) {
            if ((i3 == 0 || i3 == 200) && (j4 <= 2000 || !CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(e.a(this.mContext)))) {
                return;
            }
            net("img", str, str2, j2, j3, j4, j5, j6, i2, i3, str3, objArr);
        }
    }

    public void init(Context context, boolean z, String str, String str2, String str3, String str4, d dVar, c.a.d.f.n.b bVar, long j2, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{context, Boolean.valueOf(z), str, str2, str3, str4, dVar, bVar, Long.valueOf(j2), str5}) == null) {
            this.mContext = context;
            this.mWriteFileDir = str3;
            this.mNotUploadWriteFileDir = this.mWriteFileDir + "/notUpload";
            this.mTrackLogWriteFileDir = "trackLog";
            this.mIsMainProcess = z;
            this.mBdLogSetting = bVar;
            this.mCommonData = dVar;
            c.a.d.f.a.d.f().g(str2);
            c.a.d.f.n.m.a.o().r(z, str, this.mContext, this.mLogSwitchInitCallback);
            c.a.d.f.n.n.b.m().n(dVar, str4, str5);
            g.i().l(dVar);
            if (dVar != null) {
                this.mAppVersion = dVar.f2918c;
            }
            if (TextUtils.isEmpty(this.mProcessNameMd5)) {
                String processNameMd5 = getProcessNameMd5();
                this.mProcessNameMd5 = processNameMd5;
                if (z && processNameMd5 == null) {
                    this.mProcessNameMd5 = MAIN_PROCESS_MD5;
                }
            }
            try {
                if (this.mMultiProcessReceiver == null && this.mContext != null && !BdBaseApplication.getInst().checkInterrupt()) {
                    this.mMultiProcessReceiver = new c(this, null);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                    intentFilter.addAction("com.baidu.adp.stats.upload.alertlog");
                    this.mContext.registerReceiver(this.mMultiProcessReceiver, intentFilter);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (j2 >= 60000) {
                this.mUploadInterval = j2;
            }
            boolean checkInterrupt = BdBaseApplication.getInst().checkInterrupt();
            if (BdBaseApplication.getInst().checkInLater30Min()) {
                long random = (((int) (Math.random() * 30.0d)) + 1) * 60 * 1000;
                if (random > this.mUploadInterval) {
                    this.mUploadInterval = random;
                }
                startOrNextUploadTimer();
            } else if (checkInterrupt) {
                if (BdBaseApplication.getInst().checkNewUser()) {
                    return;
                }
                this.mUploadInterval = 3600000L;
                startOrNextUploadTimer();
            } else {
                startOrNextUploadTimer();
            }
        }
    }

    public boolean isMainProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mIsMainProcess : invokeV.booleanValue;
    }

    public boolean isSwitchReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.isSwitchReady : invokeV.booleanValue;
    }

    public void liveErr(String str, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{str, str2, Integer.valueOf(i2), str3, objArr}) == null) || f.c().a("live")) {
            return;
        }
        op(true, "live", str, str2, 0L, i2, str3, objArr);
    }

    public void log(String str, Object... objArr) {
        c.a.d.f.n.j.a j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048609, this, str, objArr) == null) && (j2 = g.i().j(str)) != null && c.a.d.f.n.m.a.o().v(str, null)) {
            c.a.d.f.n.a aVar = new c.a.d.f.n.a(str);
            if (objArr != null && objArr.length > 0) {
                aVar.c(objArr);
            }
            j2.a(aVar);
            i.e(j2, aVar);
        }
    }

    public void net(String str, String str2, long j2, long j3, long j4, long j5, long j6, int i2, int i3, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i2), Integer.valueOf(i3), str3, objArr}) == null) {
            net("d", str, str2, j2, j3, j4, j5, j6, i2, i3, str3, objArr);
        }
    }

    public void net(String str, String str2, String str3, long j2, long j3, long j4, long j5, long j6, int i2, int i3, String str4, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i2), Integer.valueOf(i3), str4, objArr}) == null) {
        }
    }

    public void newDebug(String str, long j2, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{str, Long.valueOf(j2), str2, objArr}) == null) {
            addLog("dbg", str, j2, str2, null, objArr);
        }
    }

    public void op(String str, String str2, long j2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{str, str2, Long.valueOf(j2), Integer.valueOf(i2), str3, objArr}) == null) {
            op(true, "d", str, str2, j2, i2, str3, objArr);
        }
    }

    public void op(boolean z, String str, String str2, String str3, long j2, int i2, String str4, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Boolean.valueOf(z), str, str2, str3, Long.valueOf(j2), Integer.valueOf(i2), str4, objArr}) == null) {
        }
    }

    public void performance(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, objArr) == null) {
            addLog("pfmonitor", str, -1L, null, null, objArr);
        }
    }

    public void resetSwitch(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        new BdStatSwitchData().parserJson(str);
    }

    public void save() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            g.i().p();
        }
    }

    public void saveAndUploadlog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || BdBaseApplication.getInst().checkInterrupt()) {
            return;
        }
        c.a.d.f.n.j.a j2 = g.i().j(str);
        g.i().B(j2);
        g.i().w(j2);
    }

    public void setAndroidId(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (dVar = this.mCommonData) == null) {
            return;
        }
        dVar.v = str;
    }

    public void setCommonDataMac(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, str) == null) || (dVar = this.mCommonData) == null) {
            return;
        }
        dVar.u = str;
    }

    public void setCuid(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, str) == null) || (dVar = this.mCommonData) == null) {
            return;
        }
        dVar.f2922g = str;
    }

    public void setCuidGalaxy2(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, str) == null) || (dVar = this.mCommonData) == null) {
            return;
        }
        dVar.f2923h = str;
    }

    public void setOaid(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, str) == null) || (dVar = this.mCommonData) == null) {
            return;
        }
        dVar.t = str;
    }

    public void setPermissionUtil(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, rVar) == null) {
            this.permissionUtil = rVar;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        g.i().C(str);
    }

    public void setUser(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048627, this, str, str2, str3) == null) {
            c.a.d.f.n.n.b.m().q(str, str2, str3);
        }
    }

    public void voiceErr(String str, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{str, str2, Integer.valueOf(i2), str3, objArr}) == null) || f.c().a("voice")) {
            return;
        }
        op(true, "voice", str, str2, 0L, i2, str3, objArr);
    }

    public void voiceNet(String str, String str2, long j2, long j3, long j4, long j5, long j6, int i2, int i3, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i2), Integer.valueOf(i3), str3, objArr}) == null) {
            net("voice", str, str2, j2, j3, j4, j5, j6, i2, i3, str3, objArr);
        }
    }

    public void debug(String str, c.a.d.f.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) || aVar == null) {
            return;
        }
        debug(str, -1L, null, aVar);
    }

    public void error(String str, long j2, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j2), str2, objArr}) == null) {
            addLog("error", str, j2, str2, null, objArr);
        }
    }

    public void performance(String str, c.a.d.f.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048615, this, str, aVar) == null) || aVar == null) {
            return;
        }
        Address l = c.a.d.f.i.a.n().l(false, false);
        if (l != null) {
            aVar.b("location", l.getLocality());
        }
        addLog("pfmonitor", str, -1L, null, aVar, new Object[0]);
    }

    public void debug(String str, long j2, String str2, c.a.d.f.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), str2, aVar}) == null) {
            addLog("dbg", str, j2, str2, aVar, new Object[0]);
        }
    }

    public void error(String str, String str2, String str3, int i2, String str4, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4, objArr}) == null) {
            op(true, str, str2, str3, 0L, i2, str4, objArr);
        }
    }

    private void alert(String str, String str2, Object[] objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65545, this, str, str2, objArr) == null) && c.a.d.f.n.m.a.o().u("alert", str) && !checkUploadRecently(str)) {
            setUploadTime(str);
            c.a.d.f.n.j.a j2 = g.i().j("alert");
            c.a.d.f.n.a aVar = new c.a.d.f.n.a("alert");
            aVar.b("module", "alert");
            if (!TextUtils.isEmpty(str)) {
                aVar.b("st", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                aVar.b("alert_log", str2);
            }
            aVar.b("t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                aVar.c(objArr);
            }
            j2.a(aVar);
            i.a(aVar);
            if (c.a.d.f.n.g.e()) {
                aVar.d(this.mCommonData);
                c.a.d.f.n.n.b.m().s(j2, aVar.f().c().toString());
            }
            BdLog.i("alert item = " + aVar.toString());
            c.a.d.f.n.n.b.m().r(j2, aVar.toString());
        }
    }
}
