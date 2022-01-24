package com.baidu.prologue.business.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.a0.a;
import c.a.c0.a0.c.d;
import c.a.c0.a0.c.e;
import c.a.i0.a.c.i;
import c.a.i0.b.f.b;
import c.a.i0.b.f.f;
import c.a.i0.b.f.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class BaseVM {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static String f37909b;
    public transient /* synthetic */ FieldHolder $fh;
    public final g a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class Area {
        public static final /* synthetic */ Area[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Area DEEPLINK_RESULT_APP;
        public static final Area DEEPLINK_RESULT_H5;
        public static final Area GIF;
        public static final Area IMAGE;
        public static final Area SKIP_BUTTON;
        public static final Area UNKNOW;
        public static final Area VIDEO;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-918999134, "Lcom/baidu/prologue/business/data/BaseVM$Area;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-918999134, "Lcom/baidu/prologue/business/data/BaseVM$Area;");
                    return;
                }
            }
            SKIP_BUTTON = new Area("SKIP_BUTTON", 0, "skip_button");
            IMAGE = new Area("IMAGE", 1, "image");
            VIDEO = new Area("VIDEO", 2, "video");
            GIF = new Area("GIF", 3, "gif");
            DEEPLINK_RESULT_APP = new Area("DEEPLINK_RESULT_APP", 4, "APP");
            DEEPLINK_RESULT_H5 = new Area("DEEPLINK_RESULT_H5", 5, "URL");
            Area area = new Area("UNKNOW", 6, "unknow");
            UNKNOW = area;
            $VALUES = new Area[]{SKIP_BUTTON, IMAGE, VIDEO, GIF, DEEPLINK_RESULT_APP, DEEPLINK_RESULT_H5, area};
        }

        public Area(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static Area valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Area) Enum.valueOf(Area.class, str) : (Area) invokeL.objValue;
        }

        public static Area[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Area[]) $VALUES.clone() : (Area[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class CloseType {
        public static final /* synthetic */ CloseType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CloseType CLICK_AD_AREA;
        public static final CloseType CLICK_SKIP_BUTTON;
        public static final CloseType COUNTDOWN_TIME_FINISH;
        public static final CloseType OTHER;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-585798827, "Lcom/baidu/prologue/business/data/BaseVM$CloseType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-585798827, "Lcom/baidu/prologue/business/data/BaseVM$CloseType;");
                    return;
                }
            }
            COUNTDOWN_TIME_FINISH = new CloseType("COUNTDOWN_TIME_FINISH", 0, "0");
            CLICK_SKIP_BUTTON = new CloseType("CLICK_SKIP_BUTTON", 1, "1");
            CLICK_AD_AREA = new CloseType("CLICK_AD_AREA", 2, "2");
            CloseType closeType = new CloseType("OTHER", 3, "3");
            OTHER = closeType;
            $VALUES = new CloseType[]{COUNTDOWN_TIME_FINISH, CLICK_SKIP_BUTTON, CLICK_AD_AREA, closeType};
        }

        public CloseType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static CloseType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CloseType) Enum.valueOf(CloseType.class, str) : (CloseType) invokeL.objValue;
        }

        public static CloseType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CloseType[]) $VALUES.clone() : (CloseType[]) invokeV.objValue;
        }
    }

    public BaseVM(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gVar;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(b.a)) {
            return;
        }
        a.b(new ClogBuilder().r(ClogBuilder.LogType.DEEP_LINK).p(ClogBuilder.Page.NA_SPLASH).g(str).m(b.a));
    }

    public static void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            i(i2, "");
        }
    }

    public static void i(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i2, str) == null) {
            String f2 = i.f("empty_ext_info", "");
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            ClogBuilder m = new ClogBuilder().r(ClogBuilder.LogType.SHOW).p(ClogBuilder.Page.NA_SPLASH).h(String.valueOf(i2)).m(f2);
            if (!TextUtils.isEmpty(str)) {
                m.i(str);
            }
            a.b(m);
        }
    }

    public static void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) {
            a.b(new ClogBuilder().r(ClogBuilder.LogType.CHECK).p(ClogBuilder.Page.NA_SPLASH).h("13").i(String.valueOf(i2)).j(c.a.c0.h.a.c().a().l()));
        }
    }

    public static void m(String str, long j2, long j3, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) {
            long currentTimeMillis = System.currentTimeMillis() - j3;
            long j4 = j3 - j2;
            d a = new e().f("1006").b("f1", Long.valueOf(j2)).a("f2", str).a("f3", str2);
            a.b((e) a.a("f4", currentTimeMillis + "").a("f5", str3).a("f6", String.valueOf(c.a.i0.b.e.a())).a("f10", String.valueOf(j4)));
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            f37909b = "";
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            f37909b = str;
        }
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || str.startsWith(f.h()) || !f.j()) ? false : true : invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            d(str);
            l();
        }
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            j(jSONObject);
            n();
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ClogBuilder m = new ClogBuilder().r(ClogBuilder.LogType.CLICK).p(ClogBuilder.Page.NA_SPLASH).m(this.a.f3924d);
            if (!TextUtils.isEmpty(str)) {
                m.j(str);
            }
            a.b(m);
        }
    }

    public void e(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, str, j2) == null) {
            a.b(new ClogBuilder().r(ClogBuilder.LogType.CLOSE).p(ClogBuilder.Page.NA_SPLASH).m(this.a.f3924d).i(String.valueOf(j2)).h(c.a.c0.h.a.b().getResources().getConfiguration().orientation == 1 ? "1" : "0").j(str));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            ClogBuilder p = new ClogBuilder().r(ClogBuilder.LogType.DISCARD).p(ClogBuilder.Page.NA_SPLASH);
            g gVar = this.a;
            a.b(p.m(gVar == null ? "" : gVar.f3924d).h("10").j(str));
        }
    }

    public void j(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            ClogBuilder m = new ClogBuilder().r(ClogBuilder.LogType.SHOW).p(ClogBuilder.Page.NA_SPLASH).m(this.a.f3924d);
            if (jSONObject != null) {
                if (jSONObject.has("adRenderCostTime")) {
                    m.i(jSONObject.optString("adRenderCostTime"));
                }
                if (jSONObject.has("adLoadCostTime")) {
                    m.o(jSONObject.optString("adLoadCostTime"));
                }
                if (jSONObject.has("adShowScene")) {
                    m.h(jSONObject.optString("adShowScene"));
                }
                if (jSONObject.has("adSplashType")) {
                    m.j(jSONObject.optString("adSplashType"));
                }
            }
            a.b(m);
        }
    }

    public void l() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (strArr = this.a.q) == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String optString = new JSONObject(str).optString("url");
                if (!TextUtils.isEmpty(optString)) {
                    c.a.c0.a0.b.a.a(new c.a.c0.a0.b.b(ClogBuilder.LogType.CLICK, optString.replace("__GESTURE__", String.valueOf(f37909b)), b.a, a(optString)));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void n() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (strArr = this.a.p) == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String optString = new JSONObject(str).optString("url");
                if (!TextUtils.isEmpty(optString)) {
                    c.a.c0.a0.b.a.a(new c.a.c0.a0.b.b(ClogBuilder.LogType.SHOW, optString, b.a, a(optString)));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
