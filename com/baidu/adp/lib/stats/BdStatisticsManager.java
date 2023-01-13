package com.baidu.adp.lib.stats;

import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.ej;
import com.baidu.tieba.gh;
import com.baidu.tieba.gj;
import com.baidu.tieba.hh;
import com.baidu.tieba.ii;
import com.baidu.tieba.jh;
import com.baidu.tieba.kh;
import com.baidu.tieba.lh;
import com.baidu.tieba.mc;
import com.baidu.tieba.mh;
import com.baidu.tieba.oh;
import com.baidu.tieba.ph;
import com.baidu.tieba.uf;
import com.baidu.tieba.uh;
import com.baidu.tieba.wh;
import com.baidu.tieba.zh;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes.dex */
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
    public hh mBdLogSetting;
    public jh mCommonData;
    public Context mContext;
    public boolean mIsMainProcess;
    public wh.b mLogSwitchInitCallback;
    public c mMultiProcessReceiver;
    public String mNotUploadWriteFileDir;
    public String mProcessNameMd5;
    public String mTrackLogWriteFileDir;
    public long mUploadInterval;
    public String mWriteFileDir;
    public ej permissionUtil;

    public void net(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i), Integer.valueOf(i2), str4, objArr}) == null) {
        }
    }

    public void op(boolean z, String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Boolean.valueOf(z), str, str2, str3, Long.valueOf(j), Integer.valueOf(i), str4, objArr}) == null) {
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        removeMessages(2);
                        BdStatisticsManager.getInstance().checkLogToUpload();
                    }
                } else if (BdStatisticsManager.getInstance().permissionUtil != null) {
                    if (BdStatisticsManager.getInstance().permissionUtil.isAgreePrivacyPolicy() || BdStatisticsManager.getInstance().permissionUtil.isBrowseMode()) {
                        BdStatisticsManager.getInstance().forceUploadAllLog();
                        BdStatisticsManager.getInstance().startOrNextUploadTimer();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements wh.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdStatisticsManager;
        }

        @Override // com.baidu.tieba.wh.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.isSwitchReady = true;
            if (this.a.mIsMainProcess) {
                ii.i().f();
            }
            BdStatisticsManager.mHandler.removeMessages(2);
            if (BdBaseApplication.getInst().checkInterrupt()) {
                return;
            }
            BdStatisticsManager.mHandler.sendMessageDelayed(BdStatisticsManager.mHandler.obtainMessage(2), 15000L);
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdStatisticsManager;
        }

        public /* synthetic */ c(BdStatisticsManager bdStatisticsManager, a aVar) {
            this(bdStatisticsManager);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.baidu.adp.stats.uploadallfile".equals(action) && !this.this$0.mIsMainProcess) {
                ii.i().t(false);
            }
            if ("com.baidu.adp.stats.upload.alertlog".equals(action) && this.this$0.mIsMainProcess) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("alert_type");
                String string2 = extras.getString("alert_log");
                if (!TextUtils.isEmpty(string)) {
                    this.this$0.alert(string, string2);
                }
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLogToUpload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            ii.i().e();
        }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            return BdBaseApplication.getInst().getSharedPreferences("alert", 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static BdStatisticsManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void startOrNextUploadTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            mHandler.removeMessages(1);
            Handler handler = mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(1), this.mUploadInterval);
        }
    }

    public void forceUploadAllLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ii.i().q();
        }
    }

    public void forceUploadAllLogIgnoreSwitchImmediately() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || BdBaseApplication.getInst().checkInterrupt()) {
            return;
        }
        ii.i().t(true);
    }

    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mAppVersion;
        }
        return (String) invokeV.objValue;
    }

    public hh getBdLogSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mBdLogSetting;
        }
        return (hh) invokeV.objValue;
    }

    public long getClientLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return uh.b().a();
        }
        return invokeV.longValue;
    }

    public String getCurNetworkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return kh.a(BdBaseApplication.getInst());
        }
        return (String) invokeV.objValue;
    }

    public String getNotUploadWriteDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mNotUploadWriteFileDir;
        }
        return (String) invokeV.objValue;
    }

    public String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mProcessNameMd5;
        }
        return (String) invokeV.objValue;
    }

    public String getTrackLogWriteDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mTrackLogWriteFileDir;
        }
        return (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return ii.i().k();
        }
        return (String) invokeV.objValue;
    }

    public long getUploadInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mUploadInterval;
        }
        return invokeV.longValue;
    }

    public String getWriteDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mWriteFileDir;
        }
        return (String) invokeV.objValue;
    }

    public boolean isMainProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mIsMainProcess;
        }
        return invokeV.booleanValue;
    }

    public boolean isSwitchReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.isSwitchReady;
        }
        return invokeV.booleanValue;
    }

    public void save() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            ii.i().p();
        }
    }

    public BdStatisticsManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mWriteFileDir = "newStat";
        this.mNotUploadWriteFileDir = "newStat/notUpload";
        this.isSwitchReady = false;
        this.mUploadInterval = AppConfig.TIMESTAMP_AVAILABLE_DURATION;
        this.mLogSwitchInitCallback = new b(this);
    }

    public void forceUploadAllLogIgnoreSwitch() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || BdBaseApplication.getInst().checkInterrupt()) {
            return;
        }
        ii.i().t(false);
        if (this.mIsMainProcess) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    private void setUploadTime(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        EditorHelper.putLong(getConfig(), str, System.currentTimeMillis());
    }

    public gh getStatsItem(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            return new gh(str);
        }
        return (gh) invokeL.objValue;
    }

    public void resetSwitch(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, str) == null) && !TextUtils.isEmpty(str)) {
            new BdStatSwitchData().parserJson(str);
        }
    }

    public void saveAndUploadlog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, str) != null) || BdBaseApplication.getInst().checkInterrupt()) {
            return;
        }
        ph j = ii.i().j(str);
        ii.i().B(j);
        ii.i().w(j);
    }

    public void setAndroidId(String str) {
        jh jhVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, str) == null) && (jhVar = this.mCommonData) != null) {
            jhVar.v = str;
        }
    }

    public void setCommonDataMac(String str) {
        jh jhVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, str) == null) && (jhVar = this.mCommonData) != null) {
            jhVar.u = str;
        }
    }

    public void setCuid(String str) {
        jh jhVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, str) == null) && (jhVar = this.mCommonData) != null) {
            jhVar.g = str;
        }
    }

    public void setCuidGalaxy2(String str) {
        jh jhVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, str) == null) && (jhVar = this.mCommonData) != null) {
            jhVar.h = str;
        }
    }

    public void setOaid(String str) {
        jh jhVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, str) == null) && (jhVar = this.mCommonData) != null) {
            jhVar.t = str;
        }
    }

    public void setPermissionUtil(ej ejVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, ejVar) == null) {
            this.permissionUtil = ejVar;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048626, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        ii.i().C(str);
    }

    public void debug(String str, gh ghVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, str, ghVar) != null) || ghVar == null) {
            return;
        }
        debug(str, -1L, null, ghVar);
    }

    public void performance(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, objArr) == null) {
            addLog("pfmonitor", str, -1L, null, null, objArr);
        }
    }

    private void addLog(String str, String str2, long j, String str3, gh ghVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, str2, Long.valueOf(j), str3, ghVar, objArr}) == null) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || lh.c().a(str)) {
                return;
            }
            if (j == -1) {
                ii.i().D(str, str2, null, str3, ghVar, objArr);
            } else {
                ii.i().D(str, str2, String.valueOf(j), str3, ghVar, objArr);
            }
        }
    }

    private void alert(String str, String str2, Object[] objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65545, this, str, str2, objArr) != null) || !wh.o().u("alert", str) || checkUploadRecently(str)) {
            return;
        }
        setUploadTime(str);
        ph j = ii.i().j("alert");
        gh ghVar = new gh("alert");
        ghVar.b("module", "alert");
        if (!TextUtils.isEmpty(str)) {
            ghVar.b("st", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            ghVar.b("alert_log", str2);
        }
        ghVar.b("t", String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            ghVar.c(objArr);
        }
        j.a(ghVar);
        oh.a(ghVar);
        if (mh.e()) {
            ghVar.d(this.mCommonData);
            zh.m().q(j, ghVar.f().c().toString());
        }
        BdLog.i("alert item = " + ghVar.toString());
        zh.m().p(j, ghVar.toString());
    }

    private boolean checkUploadRecently(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (System.currentTimeMillis() - getConfig().getLong(str, 0L) >= wh.o().m(str, 24) * 60 * 60 * 1000) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private String formatProcessNameMd5(String str) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            String d = gj.d(str.getBytes("UTF-8"));
            if (!TextUtils.isEmpty(d) && d.length() > 8) {
                return d.substring(d.length() - 8);
            }
            return d;
        }
        return (String) invokeL.objValue;
    }

    private String getProcessNameMd5() {
        InterceptResult invokeV;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            Context context = this.mContext;
            if (context == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 28 && (context instanceof Application)) {
                Application application = (Application) context;
                String processName = Application.getProcessName();
                try {
                    return formatProcessNameMd5(processName);
                } catch (UnsupportedEncodingException e) {
                    BdLog.e(e.getMessage());
                    return processName;
                }
            } else if (this.permissionUtil.isBrowseMode()) {
                return String.valueOf(Process.myPid());
            } else {
                ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    int myPid = Process.myPid();
                    for (int i = 0; i < runningAppProcesses.size(); i++) {
                        if (runningAppProcesses.get(i).pid == myPid) {
                            String str = runningAppProcesses.get(i).processName;
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    return formatProcessNameMd5(str);
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
        }
        return (String) invokeV.objValue;
    }

    public void addEntryToTmpSwitchConfDic(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, bdUploadStatMsgData) == null) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null || BdBaseApplication.getInst().checkInterrupt()) {
                return;
            }
            forceUploadAllLogIgnoreSwitch();
            wh.o().k(str, str2, bdUploadStatMsgData);
        }
    }

    public void aladinPortErr(String str, String str2, int i, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), str3, objArr}) != null) || lh.c().a("aladin_port_error")) {
            return;
        }
        op(true, "aladin_port_error", str, str2, 0L, i, str3, objArr);
    }

    public void db(String str, String str2, int i, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), str3, objArr}) != null) || lh.c().a("db")) {
            return;
        }
        op(true, "db", str, str2, 0L, i, str3, objArr);
    }

    public void file(String str, String str2, int i, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i), str3, objArr}) != null) || lh.c().a("file")) {
            return;
        }
        op(true, "file", str, str2, 0L, i, str3, objArr);
    }

    public void imgErr(String str, String str2, int i, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048604, this, new Object[]{str, str2, Integer.valueOf(i), str3, objArr}) != null) || lh.c().a("img")) {
            return;
        }
        op(true, "img", str, str2, 0L, i, str3, objArr);
    }

    public void liveErr(String str, String str2, int i, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048608, this, new Object[]{str, str2, Integer.valueOf(i), str3, objArr}) != null) || lh.c().a("live")) {
            return;
        }
        op(true, "live", str, str2, 0L, i, str3, objArr);
    }

    public void voiceErr(String str, String str2, int i, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048628, this, new Object[]{str, str2, Integer.valueOf(i), str3, objArr}) != null) || lh.c().a("voice")) {
            return;
        }
        op(true, "voice", str, str2, 0L, i, str3, objArr);
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
            gh ghVar = new gh("crash");
            ghVar.b("module", "crash");
            if (!TextUtils.isEmpty(str)) {
                ghVar.b("crash_type", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                ghVar.b("ci", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                ghVar.b("f", str3);
            }
            ghVar.b("t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                ghVar.c(objArr);
            }
            addLog("crash", "crash", -1L, null, ghVar, new Object[0]);
        }
    }

    public void debug(String str, long j, String str2, gh ghVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), str2, ghVar}) == null) {
            addLog("dbg", str, j, str2, ghVar, new Object[0]);
        }
    }

    public void error(String str, long j, String str2, gh ghVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j), str2, ghVar}) == null) {
            addLog("error", str, j, str2, ghVar, new Object[0]);
        }
    }

    public void newDebug(String str, long j, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{str, Long.valueOf(j), str2, objArr}) == null) {
            addLog("dbg", str, j, str2, null, objArr);
        }
    }

    public void debug(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, objArr) == null) {
            addLog("dbg", str, -1L, null, null, objArr);
        }
    }

    public void error(String str, long j, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), str2, objArr}) == null) {
            addLog("error", str, j, str2, null, objArr);
        }
    }

    public void error(String str, String str2, String str3, int i, String str4, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4, objArr}) == null) {
            op(true, str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void op(String str, String str2, long j, int i, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{str, str2, Long.valueOf(j), Integer.valueOf(i), str3, objArr}) == null) {
            op(true, "d", str, str2, j, i, str3, objArr);
        }
    }

    public void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Integer.valueOf(i), objArr}) == null) {
            eventStatLogTime(context, str, str2, i, objArr);
        }
    }

    public long eventStatLogTime(Context context, String str, String str2, int i, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{context, str, str2, Integer.valueOf(i), objArr})) == null) {
            gh ghVar = new gh("stat");
            ghVar.b("module", "stat");
            if (!TextUtils.isEmpty(str)) {
                ghVar.b("op_key", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                ghVar.b(Config.PLATFORM_TYPE, str2);
            }
            ghVar.b("co", String.valueOf(i));
            long currentTimeMillis = System.currentTimeMillis();
            ghVar.b("t", String.valueOf(currentTimeMillis));
            if (objArr != null && objArr.length > 0) {
                ghVar.c(objArr);
                ghVar.a("mi", 0);
            }
            addLog("stat", null, -1L, null, ghVar, new Object[0]);
            return currentTimeMillis;
        }
        return invokeCommon.longValue;
    }

    public void init(Context context, boolean z, String str, String str2, String str3, String str4, jh jhVar, hh hhVar, long j, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{context, Boolean.valueOf(z), str, str2, str3, str4, jhVar, hhVar, Long.valueOf(j), str5}) == null) {
            this.mContext = context;
            this.mWriteFileDir = str3;
            this.mNotUploadWriteFileDir = this.mWriteFileDir + "/notUpload";
            this.mTrackLogWriteFileDir = "trackLog";
            this.mIsMainProcess = z;
            this.mBdLogSetting = hhVar;
            this.mCommonData = jhVar;
            mc.f().g(str2);
            wh.o().r(z, str, this.mContext, this.mLogSwitchInitCallback);
            zh.m().n(jhVar, str4, str5);
            ii.i().l(jhVar);
            if (jhVar != null) {
                this.mAppVersion = jhVar.c;
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
            } catch (Exception e) {
                BdLog.e(e);
            }
            if (j >= 60000) {
                this.mUploadInterval = j;
            }
            boolean checkInterrupt = BdBaseApplication.getInst().checkInterrupt();
            if (BdBaseApplication.getInst().checkInLater30Min()) {
                long random = (((int) (Math.random() * 30.0d)) + 1) * 60 * 1000;
                if (random > this.mUploadInterval) {
                    this.mUploadInterval = random;
                }
                startOrNextUploadTimer();
            } else if (checkInterrupt) {
                if (!BdBaseApplication.getInst().checkNewUser()) {
                    this.mUploadInterval = 3600000L;
                    startOrNextUploadTimer();
                }
            } else {
                startOrNextUploadTimer();
            }
        }
    }

    public void log(String str, Object... objArr) {
        ph j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048609, this, str, objArr) == null) && (j = ii.i().j(str)) != null && wh.o().v(str, null)) {
            gh ghVar = new gh(str);
            if (objArr != null && objArr.length > 0) {
                ghVar.c(objArr);
            }
            j.a(ghVar);
            oh.e(j, ghVar);
        }
    }

    public void performance(String str, gh ghVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048615, this, str, ghVar) != null) || ghVar == null) {
            return;
        }
        Address l = uf.n().l(false, false);
        if (l != null) {
            ghVar.b("location", l.getLocality());
        }
        addLog("pfmonitor", str, -1L, null, ghVar, new Object[0]);
    }

    public void net(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i), Integer.valueOf(i2), str3, objArr}) == null) {
            net("d", str, str2, j, j2, j3, j4, j5, i, i2, str3, objArr);
        }
    }

    public void setUser(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048627, this, str, str2, str3) == null) {
            zh.m().o(str, str2, str3);
        }
    }
}
