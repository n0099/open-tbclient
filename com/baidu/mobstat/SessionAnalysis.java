package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Session;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SessionAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f43030a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f43031b;

    /* renamed from: c  reason: collision with root package name */
    public a f43032c;

    /* renamed from: d  reason: collision with root package name */
    public a f43033d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43034e;

    /* renamed from: f  reason: collision with root package name */
    public long f43035f;

    /* renamed from: g  reason: collision with root package name */
    public Session f43036g;

    /* renamed from: h  reason: collision with root package name */
    public int f43037h;

    /* renamed from: i  reason: collision with root package name */
    public int f43038i;

    /* renamed from: j  reason: collision with root package name */
    public long f43039j;
    public LaunchInfo k;
    public LaunchInfo l;
    public Callback mCallback;

    /* loaded from: classes5.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public SessionAnalysis() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43030a = false;
        this.f43031b = new HashMap();
        this.f43032c = new a();
        this.f43033d = new a();
        this.f43034e = false;
        this.f43035f = 0L;
        this.f43036g = new Session();
        this.f43037h = 0;
        this.f43038i = 0;
        this.f43039j = 0L;
    }

    private void a(Context context, long j2, long j3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (j3 - j2 > ((long) getSessionTimeOut())) {
                if (j2 > 0) {
                    if (2 == i3) {
                        this.f43036g.setEndTime(j2);
                    }
                    LaunchInfo launchInfo = this.l;
                    a(context, j3, false, false, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
                }
                this.f43036g.setTrackStartTime(this.f43039j);
                this.f43036g.setInvokeType(i2);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && !TextUtils.isEmpty(str) && this.f43031b.containsKey(str)) {
            this.f43031b.remove(str);
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

    public void autoTrackSessionEndTime(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, j2) == null) || context == null) {
            return;
        }
        this.f43036g.setTrackEndTime(j2);
        a(context);
    }

    public void autoTrackSessionStartTime(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j2) == null) || context == null) {
            return;
        }
        this.f43036g.setTrackStartTime(j2);
        this.f43039j = j2;
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

    public void doSendLogCheck(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, context, j2) == null) {
            long j3 = this.f43035f;
            if (j3 <= 0 || j2 - j3 <= getSessionTimeOut()) {
                return;
            }
            a(context, -1L, false, false, 0);
        }
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43036g.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f43038i : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43036g.getStartTime() : invokeV.longValue;
    }

    public int getSessionTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f43037h <= 0) {
                this.f43037h = 30000;
            }
            return this.f43037h;
        }
        return invokeV.intValue;
    }

    public boolean isSessionStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f43036g.getStartTime() > 0 : invokeV.booleanValue;
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j2, ExtraInfo extraInfo, boolean z) {
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, str2, str3, Long.valueOf(j2), extraInfo, Boolean.valueOf(z)}) == null) {
            this.f43034e = false;
            if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
                return;
            }
            if (!a2.f43042c) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPageStart(), 请检查邻近页面埋点: " + str);
                return;
            }
            a(context, a2.f43040a, str, a2.f43041b, j2, str2, "", str3, false, extraInfo, z);
            b(str);
            this.f43035f = j2;
        }
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j2, boolean z, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, str3, Long.valueOf(j2), Boolean.valueOf(z), extraInfo}) == null) {
            this.f43034e = false;
            a aVar = z ? this.f43033d : this.f43032c;
            if (aVar.f43042c) {
                a(context, aVar.f43040a, str, aVar.f43041b, j2, str2, str3, str, z, extraInfo, false);
                aVar.f43042c = false;
                this.f43035f = j2;
            } else if (z) {
            } else {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onResume(Activity), 请检查邻近页面埋点: " + str);
            }
        }
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j2) {
        a a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, str, str2, str3, Long.valueOf(j2)}) == null) || TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
            return;
        }
        if (!a2.f43042c) {
            bc c2 = bc.c();
            c2.c("[WARNING] 遗漏StatService.onResume(Fragment), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, a2.f43040a, str, a2.f43041b, j2, str2, str3, null, false, null, false);
        b(str);
        this.f43035f = j2;
    }

    public void onPageStart(Context context, String str, int i2, long j2) {
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            onSessionStart(context, j2, false);
            if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
                return;
            }
            if (a2.f43042c) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPageEnd(), 请检查邻近页面埋点: " + str);
            }
            if (!this.f43034e) {
                a(context, this.f43035f, j2, i2, 3);
                this.f43034e = true;
            }
            a2.f43042c = true;
            a2.f43041b = j2;
        }
    }

    public void onPageStartAct(Context context, String str, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            onSessionStart(context, j2, false);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = z ? this.f43033d : this.f43032c;
            if (aVar.f43042c && !z) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPause(Activity), 请检查邻近页面埋点: " + str);
            }
            if (!this.f43034e) {
                a(context, this.f43035f, j2, 1, 1);
                this.f43034e = true;
            }
            aVar.f43042c = true;
            aVar.f43040a = str;
            aVar.f43041b = j2;
        }
    }

    public void onPageStartFrag(Context context, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, str, Long.valueOf(j2)}) == null) {
            onSessionStart(context, j2, false);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a a2 = a(str);
            if (a2.f43042c) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPause(Fragment), 请检查邻近页面埋点: " + str);
            }
            a(context, this.f43035f, j2, 2, 2);
            a2.f43042c = true;
            a2.f43040a = str;
            a2.f43041b = j2;
        }
    }

    public void onSessionStart(Context context, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Long.valueOf(j2), Boolean.valueOf(z)}) == null) || this.f43030a) {
            return;
        }
        DataCore.instance().init(context);
        try {
            Thread.sleep(3000L);
        } catch (Exception unused) {
        }
        LaunchInfo launchInfo = this.k;
        a(context, j2, z, true, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
        this.f43030a = true;
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (i2 < 1) {
                i2 = 30;
                bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[30] is used");
            } else if (i2 > 600) {
                bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[600] is used");
                i2 = 600;
            }
            this.f43037h = i2 * 1000;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f43040a;

        /* renamed from: b  reason: collision with root package name */
        public long f43041b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43042c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43042c = false;
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f43042c = false;
            this.f43040a = str;
        }
    }

    private void a(Context context, String str, String str2, long j2, long j3, String str3, String str4, String str5, boolean z, ExtraInfo extraInfo, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{context, str, str2, Long.valueOf(j2), Long.valueOf(j3), str3, str4, str5, Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) {
            return;
        }
        this.f43036g.addPageView(new Session.a(str3, str4, str5, j3 - j2, j2, z, extraInfo, z2));
        this.f43036g.setEndTime(j3);
        a(context);
    }

    public SessionAnalysis(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43030a = false;
        this.f43031b = new HashMap();
        this.f43032c = new a();
        this.f43033d = new a();
        this.f43034e = false;
        this.f43035f = 0L;
        this.f43036g = new Session();
        this.f43037h = 0;
        this.f43038i = 0;
        this.f43039j = 0L;
        this.mCallback = callback;
    }

    private a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (!this.f43031b.containsKey(str)) {
                this.f43031b.put(str, new a(str));
            }
            return this.f43031b.get(str);
        }
        return (a) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, long j2, boolean z, boolean z2, int i2) {
        String launcherHomePkgName;
        String str;
        Callback callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{context, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            if (this.f43036g.hasEnd()) {
                DataCore.instance().putSession(this.f43036g);
                DataCore.instance().flush(context);
                av.a(this.f43036g.getPageSessionHead());
                this.f43036g.setEndTime(0L);
            }
            boolean z3 = j2 > 0;
            long startTime = z3 ? j2 : this.f43036g.getStartTime();
            String str2 = "";
            if (i2 == 0) {
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
                JSONObject convertedJson = LaunchInfo.getConvertedJson(i2, str2, str);
                if (z3) {
                    this.f43036g.reset();
                    this.f43036g.setStartTime(j2);
                    if (convertedJson != null) {
                        this.f43036g.setLaunchInfo(convertedJson);
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
            JSONObject convertedJson2 = LaunchInfo.getConvertedJson(i2, str2, str);
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
        if ((interceptable == null || interceptable.invokeL(65539, this, context) == null) && this.f43036g.hasStart()) {
            String jSONObject = this.f43036g.constructJSONObject().toString();
            this.f43038i = jSONObject.getBytes().length;
            String u = bw.u(context);
            bo.a(context, u + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
        }
    }
}
