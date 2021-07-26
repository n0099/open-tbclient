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
/* loaded from: classes2.dex */
public class SessionAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f8624a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f8625b;

    /* renamed from: c  reason: collision with root package name */
    public a f8626c;

    /* renamed from: d  reason: collision with root package name */
    public a f8627d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8628e;

    /* renamed from: f  reason: collision with root package name */
    public long f8629f;

    /* renamed from: g  reason: collision with root package name */
    public Session f8630g;

    /* renamed from: h  reason: collision with root package name */
    public int f8631h;

    /* renamed from: i  reason: collision with root package name */
    public int f8632i;
    public long j;
    public LaunchInfo k;
    public LaunchInfo l;
    public Callback mCallback;

    /* loaded from: classes2.dex */
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
        this.f8624a = false;
        this.f8625b = new HashMap();
        this.f8626c = new a();
        this.f8627d = new a();
        this.f8628e = false;
        this.f8629f = 0L;
        this.f8630g = new Session();
        this.f8631h = 0;
        this.f8632i = 0;
        this.j = 0L;
    }

    private void a(Context context, long j, long j2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (j2 - j > ((long) getSessionTimeOut())) {
                if (j > 0) {
                    if (2 == i3) {
                        this.f8630g.setEndTime(j);
                    }
                    LaunchInfo launchInfo = this.l;
                    a(context, j2, false, false, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
                }
                this.f8630g.setTrackStartTime(this.j);
                this.f8630g.setInvokeType(i2);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && !TextUtils.isEmpty(str) && this.f8625b.containsKey(str)) {
            this.f8625b.remove(str);
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
        this.f8630g.setTrackEndTime(j);
        a(context);
    }

    public void autoTrackSessionStartTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j) == null) || context == null) {
            return;
        }
        this.f8630g.setTrackStartTime(j);
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
            long j2 = this.f8629f;
            if (j2 <= 0 || j - j2 <= getSessionTimeOut()) {
                return;
            }
            a(context, -1L, false, false, 0);
        }
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f8630g.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8632i : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f8630g.getStartTime() : invokeV.longValue;
    }

    public int getSessionTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f8631h <= 0) {
                this.f8631h = 30000;
            }
            return this.f8631h;
        }
        return invokeV.intValue;
    }

    public boolean isSessionStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f8630g.getStartTime() > 0 : invokeV.booleanValue;
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j, ExtraInfo extraInfo, boolean z) {
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, str2, str3, Long.valueOf(j), extraInfo, Boolean.valueOf(z)}) == null) {
            this.f8628e = false;
            if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
                return;
            }
            if (!a2.f8635c) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPageStart(), 请检查邻近页面埋点: " + str);
                return;
            }
            a(context, a2.f8633a, str, a2.f8634b, j, str2, "", str3, false, extraInfo, z);
            b(str);
            this.f8629f = j;
        }
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j, boolean z, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, str3, Long.valueOf(j), Boolean.valueOf(z), extraInfo}) == null) {
            this.f8628e = false;
            a aVar = z ? this.f8627d : this.f8626c;
            if (aVar.f8635c) {
                a(context, aVar.f8633a, str, aVar.f8634b, j, str2, str3, str, z, extraInfo, false);
                aVar.f8635c = false;
                this.f8629f = j;
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
        if (!a2.f8635c) {
            bc c2 = bc.c();
            c2.c("[WARNING] 遗漏StatService.onResume(Fragment), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, a2.f8633a, str, a2.f8634b, j, str2, str3, null, false, null, false);
        b(str);
        this.f8629f = j;
    }

    public void onPageStart(Context context, String str, int i2, long j) {
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            onSessionStart(context, j, false);
            if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
                return;
            }
            if (a2.f8635c) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPageEnd(), 请检查邻近页面埋点: " + str);
            }
            if (!this.f8628e) {
                a(context, this.f8629f, j, i2, 3);
                this.f8628e = true;
            }
            a2.f8635c = true;
            a2.f8634b = j;
        }
    }

    public void onPageStartAct(Context context, String str, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            onSessionStart(context, j, false);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = z ? this.f8627d : this.f8626c;
            if (aVar.f8635c && !z) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPause(Activity), 请检查邻近页面埋点: " + str);
            }
            if (!this.f8628e) {
                a(context, this.f8629f, j, 1, 1);
                this.f8628e = true;
            }
            aVar.f8635c = true;
            aVar.f8633a = str;
            aVar.f8634b = j;
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
            if (a2.f8635c) {
                bc c2 = bc.c();
                c2.c("[WARNING] 遗漏StatService.onPause(Fragment), 请检查邻近页面埋点: " + str);
            }
            a(context, this.f8629f, j, 2, 2);
            a2.f8635c = true;
            a2.f8633a = str;
            a2.f8634b = j;
        }
    }

    public void onSessionStart(Context context, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.f8624a) {
            return;
        }
        DataCore.instance().init(context);
        try {
            Thread.sleep(3000L);
        } catch (Exception unused) {
        }
        LaunchInfo launchInfo = this.k;
        a(context, j, z, true, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
        this.f8624a = true;
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
            this.f8631h = i2 * 1000;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f8633a;

        /* renamed from: b  reason: collision with root package name */
        public long f8634b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8635c;

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
            this.f8635c = false;
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
            this.f8635c = false;
            this.f8633a = str;
        }
    }

    private void a(Context context, String str, String str2, long j, long j2, String str3, String str4, String str5, boolean z, ExtraInfo extraInfo, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{context, str, str2, Long.valueOf(j), Long.valueOf(j2), str3, str4, str5, Boolean.valueOf(z), extraInfo, Boolean.valueOf(z2)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) {
            return;
        }
        this.f8630g.addPageView(new Session.a(str3, str4, str5, j2 - j, j, z, extraInfo, z2));
        this.f8630g.setEndTime(j2);
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
        this.f8624a = false;
        this.f8625b = new HashMap();
        this.f8626c = new a();
        this.f8627d = new a();
        this.f8628e = false;
        this.f8629f = 0L;
        this.f8630g = new Session();
        this.f8631h = 0;
        this.f8632i = 0;
        this.j = 0L;
        this.mCallback = callback;
    }

    private a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (!this.f8625b.containsKey(str)) {
                this.f8625b.put(str, new a(str));
            }
            return this.f8625b.get(str);
        }
        return (a) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, long j, boolean z, boolean z2, int i2) {
        String launcherHomePkgName;
        String str;
        Callback callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            if (this.f8630g.hasEnd()) {
                DataCore.instance().putSession(this.f8630g);
                DataCore.instance().flush(context);
                av.a(this.f8630g.getPageSessionHead());
                this.f8630g.setEndTime(0L);
            }
            boolean z3 = j > 0;
            long startTime = z3 ? j : this.f8630g.getStartTime();
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
                    this.f8630g.reset();
                    this.f8630g.setStartTime(j);
                    if (convertedJson != null) {
                        this.f8630g.setLaunchInfo(convertedJson);
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
        if ((interceptable == null || interceptable.invokeL(65539, this, context) == null) && this.f8630g.hasStart()) {
            String jSONObject = this.f8630g.constructJSONObject().toString();
            this.f8632i = jSONObject.getBytes().length;
            String u = bw.u(context);
            bo.a(context, u + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
        }
    }
}
