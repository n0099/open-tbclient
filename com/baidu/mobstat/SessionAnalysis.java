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
/* loaded from: classes4.dex */
public class SessionAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f27144b;

    /* renamed from: c  reason: collision with root package name */
    public a f27145c;

    /* renamed from: d  reason: collision with root package name */
    public a f27146d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27147e;

    /* renamed from: f  reason: collision with root package name */
    public long f27148f;

    /* renamed from: g  reason: collision with root package name */
    public Session f27149g;

    /* renamed from: h  reason: collision with root package name */
    public int f27150h;
    public int i;
    public long j;
    public LaunchInfo k;
    public LaunchInfo l;
    public Callback mCallback;

    /* loaded from: classes4.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
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
        this.f27144b = new HashMap();
        this.f27145c = new a();
        this.f27146d = new a();
        this.f27147e = false;
        this.f27148f = 0L;
        this.f27149g = new Session();
        this.f27150h = 0;
        this.i = 0;
        this.j = 0L;
    }

    private void a(Context context, long j, long j2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (j2 - j > ((long) getSessionTimeOut())) {
                if (j > 0) {
                    if (2 == i2) {
                        this.f27149g.setEndTime(j);
                    }
                    LaunchInfo launchInfo = this.l;
                    a(context, j2, false, false, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
                }
                this.f27149g.setTrackStartTime(this.j);
                this.f27149g.setInvokeType(i);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && !TextUtils.isEmpty(str) && this.f27144b.containsKey(str)) {
            this.f27144b.remove(str);
        }
    }

    public void autoTrackLaunchInfo(LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, launchInfo, z) == null) {
            if (z) {
                this.k = launchInfo;
            } else {
                this.l = launchInfo;
            }
        }
    }

    public void autoTrackSessionEndTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, j) == null) || context == null) {
            return;
        }
        this.f27149g.setTrackEndTime(j);
        a(context);
    }

    public void autoTrackSessionStartTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j) == null) || context == null) {
            return;
        }
        this.f27149g.setTrackStartTime(j);
        this.j = j;
    }

    public void clearLastSessionCache(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, context) == null) || context == null) {
            return;
        }
        String jSONObject = new JSONObject().toString();
        String u = bw.u(context);
        bo.a(context, u + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
    }

    public void doSendLogCheck(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, context, j) == null) {
            long j2 = this.f27148f;
            if (j2 <= 0 || j - j2 <= getSessionTimeOut()) {
                return;
            }
            a(context, -1L, false, false, 0);
        }
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27149g.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f27149g.getStartTime() : invokeV.longValue;
    }

    public int getSessionTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f27150h <= 0) {
                this.f27150h = 30000;
            }
            return this.f27150h;
        }
        return invokeV.intValue;
    }

    public boolean isSessionStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f27149g.getStartTime() > 0 : invokeV.booleanValue;
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j, ExtraInfo extraInfo, boolean z) {
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, str2, str3, Long.valueOf(j), extraInfo, Boolean.valueOf(z)}) == null) {
            this.f27147e = false;
            if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
                return;
            }
            if (!a2.f27152c) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPageStart(), 请检查邻近页面埋点: " + str);
                return;
            }
            a(context, a2.a, str, a2.f27151b, j, str2, "", str3, false, extraInfo, z);
            b(str);
            this.f27148f = j;
        }
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j, boolean z, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, str3, Long.valueOf(j), Boolean.valueOf(z), extraInfo}) == null) {
            this.f27147e = false;
            a aVar = z ? this.f27146d : this.f27145c;
            if (aVar.f27152c) {
                a(context, aVar.a, str, aVar.f27151b, j, str2, str3, str, z, extraInfo, false);
                aVar.f27152c = false;
                this.f27148f = j;
            } else if (z) {
            } else {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onResume(Activity), 请检查邻近页面埋点: " + str);
            }
        }
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j) {
        a a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, str, str2, str3, Long.valueOf(j)}) == null) || TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
            return;
        }
        if (!a2.f27152c) {
            bc c2 = bc.c();
            c2.c("[WARNING] 遗漏StatService.onResume(Fragment), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, a2.a, str, a2.f27151b, j, str2, str3, null, false, null, false);
        b(str);
        this.f27148f = j;
    }

    public void onPageStart(Context context, String str, int i, long j) {
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            onSessionStart(context, j, false);
            if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
                return;
            }
            if (a2.f27152c) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPageEnd(), 请检查邻近页面埋点: " + str);
            }
            if (!this.f27147e) {
                a(context, this.f27148f, j, i, 3);
                this.f27147e = true;
            }
            a2.f27152c = true;
            a2.f27151b = j;
        }
    }

    public void onPageStartAct(Context context, String str, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            onSessionStart(context, j, false);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = z ? this.f27146d : this.f27145c;
            if (aVar.f27152c && !z) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPause(Activity), 请检查邻近页面埋点: " + str);
            }
            if (!this.f27147e) {
                a(context, this.f27148f, j, 1, 1);
                this.f27147e = true;
            }
            aVar.f27152c = true;
            aVar.a = str;
            aVar.f27151b = j;
        }
    }

    public void onPageStartFrag(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, str, Long.valueOf(j)}) == null) {
            onSessionStart(context, j, false);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a a2 = a(str);
            if (a2.f27152c) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPause(Fragment), 请检查邻近页面埋点: " + str);
            }
            a(context, this.f27148f, j, 2, 2);
            a2.f27152c = true;
            a2.a = str;
            a2.f27151b = j;
        }
    }

    public void onSessionStart(Context context, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.a) {
            return;
        }
        DataCore.instance().init(context);
        try {
            Thread.sleep(3000L);
        } catch (Exception unused) {
        }
        LaunchInfo launchInfo = this.k;
        a(context, j, z, true, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
        this.a = true;
    }

    public void setSessionTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            if (i < 1) {
                i = 30;
                bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[30] is used");
            } else if (i > 600) {
                bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[600] is used");
                i = 600;
            }
            this.f27150h = i * 1000;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public long f27151b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f27152c;

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
            this.f27152c = false;
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
            this.f27152c = false;
            this.a = str;
        }
    }

    private void a(Context context, String str, String str2, long j, long j2, String str3, String str4, String str5, boolean z, ExtraInfo extraInfo, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{context, str, str2, Long.valueOf(j), Long.valueOf(j2), str3, str4, str5, Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) {
            return;
        }
        this.f27149g.addPageView(new Session.a(str3, str4, str5, j2 - j, j, z, extraInfo, z2));
        this.f27149g.setEndTime(j2);
        a(context);
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
        this.f27144b = new HashMap();
        this.f27145c = new a();
        this.f27146d = new a();
        this.f27147e = false;
        this.f27148f = 0L;
        this.f27149g = new Session();
        this.f27150h = 0;
        this.i = 0;
        this.j = 0L;
        this.mCallback = callback;
    }

    private a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (!this.f27144b.containsKey(str)) {
                this.f27144b.put(str, new a(str));
            }
            return this.f27144b.get(str);
        }
        return (a) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, long j, boolean z, boolean z2, int i) {
        String launcherHomePkgName;
        String str;
        Callback callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            if (this.f27149g.hasEnd()) {
                DataCore.instance().putSession(this.f27149g);
                DataCore.instance().flush(context);
                av.a(this.f27149g.getPageSessionHead());
                this.f27149g.setEndTime(0L);
            }
            boolean z3 = j > 0;
            long startTime = z3 ? j : this.f27149g.getStartTime();
            String str2 = "";
            if (i == 0) {
                launcherHomePkgName = LaunchInfo.getLauncherHomePkgName(context);
            } else {
                if (z2) {
                    LaunchInfo launchInfo = this.k;
                    if (launchInfo != null) {
                        str2 = launchInfo.getPushContent();
                        launcherHomePkgName = this.k.getRefererPkgName();
                    }
                    str = "";
                } else {
                    LaunchInfo launchInfo2 = this.l;
                    if (launchInfo2 != null) {
                        str2 = launchInfo2.getPushContent();
                        launcherHomePkgName = this.l.getRefererPkgName();
                    }
                    str = "";
                }
                JSONObject convertedJson = LaunchInfo.getConvertedJson(i, str2, str);
                if (z3) {
                    this.f27149g.reset();
                    this.f27149g.setStartTime(j);
                    if (convertedJson != null) {
                        this.f27149g.setLaunchInfo(convertedJson);
                    }
                }
                DataCore.instance().saveLogData(context, z3, z, startTime, z2, convertedJson);
                callback = this.mCallback;
                if (callback != null) {
                    callback.onCallback(DataCore.instance().getLogData());
                }
                LogSender.instance().onSend(context);
                clearLastSessionCache(context);
            }
            String str3 = launcherHomePkgName;
            str = str2;
            str2 = str3;
            JSONObject convertedJson2 = LaunchInfo.getConvertedJson(i, str2, str);
            if (z3) {
            }
            DataCore.instance().saveLogData(context, z3, z, startTime, z2, convertedJson2);
            callback = this.mCallback;
            if (callback != null) {
            }
            LogSender.instance().onSend(context);
            clearLastSessionCache(context);
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, context) == null) && this.f27149g.hasStart()) {
            String jSONObject = this.f27149g.constructJSONObject().toString();
            this.i = jSONObject.getBytes().length;
            String u = bw.u(context);
            bo.a(context, u + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
        }
    }
}
