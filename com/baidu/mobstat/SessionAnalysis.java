package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Session;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SessionAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Map b;
    public a c;
    public a d;
    public boolean e;
    public long f;
    public Session g;
    public int h;
    public int i;
    public long j;
    public boolean k;
    public LaunchInfo l;
    public LaunchInfo m;
    public Callback mCallback;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public void doSendNewSessionLog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public long b;
        public boolean c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = false;
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = false;
            this.a = str;
        }
    }

    public SessionAnalysis() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = new HashMap();
        this.c = new a();
        this.d = new a();
        this.e = false;
        this.f = 0L;
        this.g = new Session();
        this.h = 0;
        this.i = 0;
        this.j = 0L;
        this.k = true;
    }

    public SessionAnalysis(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = new HashMap();
        this.c = new a();
        this.d = new a();
        this.e = false;
        this.f = 0L;
        this.g = new Session();
        this.h = 0;
        this.i = 0;
        this.j = 0L;
        this.k = true;
        this.mCallback = callback;
    }

    private a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (!this.b.containsKey(str)) {
                this.b.put(str, new a(str));
            }
            return (a) this.b.get(str);
        }
        return (a) invokeL.objValue;
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && !TextUtils.isEmpty(str) && this.b.containsKey(str)) {
            this.b.remove(str);
        }
    }

    public void setAutoSend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.k = z;
        }
    }

    public void setSessionTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            if (i < 1) {
                i = 30;
                bb.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[30] is used");
            } else if (i > 600) {
                bb.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[600] is used");
                i = 600;
            }
            this.h = i * 1000;
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, context) == null) && this.g.hasStart()) {
            String jSONObject = this.g.constructJSONObject().toString();
            this.i = jSONObject.getBytes().length;
            String s = bw.s(context);
            bn.a(context, s + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
        }
    }

    public void clearLastSessionCache(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, context) != null) || context == null) {
            return;
        }
        String jSONObject = new JSONObject().toString();
        String s = bw.s(context);
        bn.a(context, s + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
    }

    private void a(Context context, long j, long j2, int i, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            int i3 = 0;
            if (j2 - j > getSessionTimeOut()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return;
            }
            if (j > 0) {
                if (2 == i2) {
                    this.g.setEndTime(j);
                }
                LaunchInfo launchInfo = this.m;
                if (launchInfo != null) {
                    i3 = launchInfo.getLaunchType(context);
                }
                a(context, j2, false, false, i3);
            }
            this.g.setTrackStartTime(this.j);
            this.g.setInvokeType(i);
        }
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j) {
        a a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048589, this, new Object[]{context, str, str2, str3, Long.valueOf(j)}) != null) || TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
            return;
        }
        if (!a2.c) {
            bb c = bb.c();
            c.c("[WARNING] 遗漏StatService.onResume(Fragment), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, a2.a, str, a2.b, j, str2, str3, null, false, null, false);
        b(str);
        this.f = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, long j, boolean z, boolean z2, int i) {
        boolean z3;
        long startTime;
        String launcherHomePkgName;
        String str;
        JSONObject jSONObject;
        Callback callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            if (this.g.hasEnd()) {
                DataCore.instance().putSession(this.g);
                DataCore.instance().flush(context);
                au.a(this.g.getPageSessionHead());
                this.g.setEndTime(0L);
            }
            if (j > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                startTime = j;
            } else {
                startTime = this.g.getStartTime();
            }
            String str2 = "";
            if (i != 0) {
                if (z2) {
                    LaunchInfo launchInfo = this.l;
                    if (launchInfo != null) {
                        str2 = launchInfo.getPushContent();
                        launcherHomePkgName = this.l.getRefererPkgName();
                    }
                    str = "";
                } else {
                    LaunchInfo launchInfo2 = this.m;
                    if (launchInfo2 != null) {
                        str2 = launchInfo2.getPushContent();
                        launcherHomePkgName = this.m.getRefererPkgName();
                    }
                    str = "";
                }
                if (!bu.a().e()) {
                    jSONObject = LaunchInfo.getConvertedJson(i, str2, str);
                } else {
                    jSONObject = null;
                }
                JSONObject jSONObject2 = jSONObject;
                if (z3) {
                    this.g.reset();
                    this.g.setStartTime(j);
                    if (jSONObject2 != null) {
                        this.g.setLaunchInfo(jSONObject2);
                    }
                }
                DataCore.instance().saveLogData(context, z3, z, startTime, z2, jSONObject2);
                callback = this.mCallback;
                if (callback != null) {
                    callback.onCallback(DataCore.instance().getLogData());
                }
                if (!z3 || this.k) {
                    LogSender.instance().onSend(context);
                }
                clearLastSessionCache(context);
            }
            launcherHomePkgName = LaunchInfo.getLauncherHomePkgName(context);
            String str3 = launcherHomePkgName;
            str = str2;
            str2 = str3;
            if (!bu.a().e()) {
            }
            JSONObject jSONObject22 = jSONObject;
            if (z3) {
            }
            DataCore.instance().saveLogData(context, z3, z, startTime, z2, jSONObject22);
            callback = this.mCallback;
            if (callback != null) {
            }
            if (!z3) {
            }
            LogSender.instance().onSend(context);
            clearLastSessionCache(context);
        }
    }

    private void a(Context context, String str, String str2, long j, long j2, String str3, String str4, String str5, boolean z, ExtraInfo extraInfo, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, this, new Object[]{context, str, str2, Long.valueOf(j), Long.valueOf(j2), str3, str4, str5, Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2)}) != null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) {
            return;
        }
        this.g.addPageView(new Session.a(str3, str4, str5, j2 - j, j, z, extraInfo, z2, DataCore.instance().getPagePy()));
        this.g.setEndTime(j2);
        a(context);
        if (!TextUtils.isEmpty(DataCore.instance().getTempPyd())) {
            DataCore.instance().flush(context);
        }
    }

    public void autoTrackLaunchInfo(LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, launchInfo, z) == null) {
            if (z) {
                this.l = launchInfo;
            } else {
                this.m = launchInfo;
            }
        }
    }

    public void autoTrackSessionEndTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, j) != null) || context == null) {
            return;
        }
        this.g.setTrackEndTime(j);
        a(context);
    }

    public void autoTrackSessionStartTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j) != null) || context == null) {
            return;
        }
        this.g.setTrackStartTime(j);
        this.j = j;
    }

    public void doSendLogCheck(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, context, j) == null) {
            long j2 = this.f;
            if (j2 > 0 && j - j2 > getSessionTimeOut()) {
                a(context, -1L, false, false, 0);
            }
        }
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g.getPageSessionHead();
        }
        return (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g.getStartTime();
        }
        return invokeV.longValue;
    }

    public int getSessionTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.h <= 0) {
                this.h = 30000;
            }
            return this.h;
        }
        return invokeV.intValue;
    }

    public boolean isSessionStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.g.getStartTime() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j, ExtraInfo extraInfo, boolean z) {
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, str3, Long.valueOf(j), extraInfo, Boolean.valueOf(z)}) == null) {
            this.e = false;
            if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
                return;
            }
            if (!a2.c) {
                bb c = bb.c();
                c.c("[WARNING] 遗漏StatService.onPageStart(), 请检查邻近页面埋点: " + str);
                return;
            }
            a(context, a2.a, str, a2.b, j, str2, "", str3, false, extraInfo, z);
            b(str);
            this.f = j;
        }
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j, boolean z, ExtraInfo extraInfo) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, str, str2, str3, Long.valueOf(j), Boolean.valueOf(z), extraInfo}) == null) {
            this.e = false;
            if (z) {
                aVar = this.d;
            } else {
                aVar = this.c;
            }
            a aVar2 = aVar;
            if (!aVar2.c) {
                if (!z) {
                    bb c = bb.c();
                    c.c("[WARNING] 遗漏StatService.onResume(Activity), 请检查邻近页面埋点: " + str);
                    return;
                }
                return;
            }
            a(context, aVar2.a, str, aVar2.b, j, str2, str3, str, z, extraInfo, false);
            aVar2.c = false;
            this.f = j;
        }
    }

    public void onPageStart(Context context, String str, int i, long j) {
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            onSessionStart(context, j, false);
            if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
                return;
            }
            if (a2.c) {
                bb c = bb.c();
                c.c("[WARNING] 遗漏StatService.onPageEnd(), 请检查邻近页面埋点: " + str);
            }
            if (!this.e) {
                a(context, this.f, j, i, 3);
                this.e = true;
            }
            a2.c = true;
            a2.b = j;
        }
    }

    public void onPageStartAct(Context context, String str, long j, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            onSessionStart(context, j, false);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z) {
                aVar = this.d;
            } else {
                aVar = this.c;
            }
            if (aVar.c && !z) {
                bb c = bb.c();
                c.c("[WARNING] 遗漏StatService.onPause(Activity), 请检查邻近页面埋点: " + str);
            }
            if (!this.e) {
                a(context, this.f, j, 1, 1);
                this.e = true;
            }
            aVar.c = true;
            aVar.a = str;
            aVar.b = j;
        }
    }

    public void onPageStartFrag(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, str, Long.valueOf(j)}) == null) {
            onSessionStart(context, j, false);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a a2 = a(str);
            if (a2.c) {
                bb c = bb.c();
                c.c("[WARNING] 遗漏StatService.onPause(Fragment), 请检查邻近页面埋点: " + str);
            }
            a(context, this.f, j, 2, 2);
            a2.c = true;
            a2.a = str;
            a2.b = j;
        }
    }

    public void onSessionStart(Context context, long j, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048593, this, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z)}) != null) || this.a) {
            return;
        }
        DataCore.instance().init(context);
        try {
            Thread.sleep(3000L);
        } catch (Exception unused) {
        }
        LaunchInfo launchInfo = this.l;
        if (launchInfo != null) {
            i = launchInfo.getLaunchType(context);
        } else {
            i = 0;
        }
        a(context, j, z, true, i);
        this.a = true;
    }
}
