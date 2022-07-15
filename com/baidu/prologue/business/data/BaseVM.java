package com.baidu.prologue.business.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.repackage.fy0;
import com.repackage.hh0;
import com.repackage.iy0;
import com.repackage.jy0;
import com.repackage.ky0;
import com.repackage.oy0;
import com.repackage.py0;
import com.repackage.ra1;
import com.repackage.ta1;
import com.repackage.ya1;
import com.repackage.za1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseVM {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = null;
    public static String c = "";
    public transient /* synthetic */ FieldHolder $fh;
    public final za1 a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            VIDEO = new Area(HlsPlaylistParser.TYPE_VIDEO, 2, "video");
            GIF = new Area("GIF", 3, NativeConstants.TYPE_GIF);
            DEEPLINK_RESULT_APP = new Area("DEEPLINK_RESULT_APP", 4, "APP");
            DEEPLINK_RESULT_H5 = new Area("DEEPLINK_RESULT_H5", 5, "URL");
            Area area = new Area("UNKNOW", 6, "unknow");
            UNKNOW = area;
            $VALUES = new Area[]{SKIP_BUTTON, IMAGE, VIDEO, GIF, DEEPLINK_RESULT_APP, DEEPLINK_RESULT_H5, area};
        }

        public Area(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    /* loaded from: classes2.dex */
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

        public CloseType(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2081679651, "Lcom/baidu/prologue/business/data/BaseVM;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2081679651, "Lcom/baidu/prologue/business/data/BaseVM;");
        }
    }

    public BaseVM(za1 za1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {za1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = za1Var;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(ta1.a)) {
            return;
        }
        iy0.b(new ClogBuilder().y(ClogBuilder.LogType.DEEP_LINK).u(ClogBuilder.Page.NA_SPLASH).j(str).p(ta1.a));
    }

    public static void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            i(i, "");
        }
    }

    public static void i(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str) == null) {
            String string = fy0.a().b("splash_sp_name").getString("empty_ext_info", "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (i == 32 && !TextUtils.isEmpty(c)) {
                str = c;
            }
            ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.SHOW).u(ClogBuilder.Page.NA_SPLASH).k(String.valueOf(i)).p(string);
            if (!TextUtils.isEmpty(str)) {
                p.l(str);
            }
            String q = ya1.q();
            if (!TextUtils.isEmpty(q)) {
                p.m(q);
            }
            p.n(ra1.a() == 0 ? "0" : "1");
            iy0.b(p);
        }
    }

    public static void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            iy0.b(new ClogBuilder().y(ClogBuilder.LogType.CHECK).u(ClogBuilder.Page.NA_SPLASH).k("13").l(String.valueOf(i)).m(hh0.c().a().l()));
        }
    }

    public static void m(String str, long j, long j2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2, str3}) == null) {
            long currentTimeMillis = System.currentTimeMillis() - j2;
            long j3 = j2 - j;
            oy0 b2 = new py0().g("1006").c("f1", Long.valueOf(j)).b("f2", str).b("f3", str2);
            iy0.b((py0) b2.b("f4", currentTimeMillis + "").b("f5", str3).b("f6", String.valueOf(ra1.a())).b("f10", String.valueOf(j3)));
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            b = "";
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            b = str;
        }
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || str.startsWith(ya1.j()) || !ya1.l()) ? false : true : invokeL.booleanValue;
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
            ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.CLICK).u(ClogBuilder.Page.NA_SPLASH).p(this.a.d);
            if (!TextUtils.isEmpty(str)) {
                p.m(str);
            }
            iy0.b(p);
        }
    }

    public void e(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) {
            iy0.b(new ClogBuilder().y(ClogBuilder.LogType.CLOSE).u(ClogBuilder.Page.NA_SPLASH).p(this.a.d).l(String.valueOf(j)).k(hh0.b().getResources().getConfiguration().orientation == 1 ? "1" : "0").m(str));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            ClogBuilder u = new ClogBuilder().y(ClogBuilder.LogType.DISCARD).u(ClogBuilder.Page.NA_SPLASH);
            za1 za1Var = this.a;
            iy0.b(u.p(za1Var == null ? "" : za1Var.d).k("10").m(str));
        }
    }

    public void j(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.SHOW).u(ClogBuilder.Page.NA_SPLASH).p(this.a.d);
            if (jSONObject != null) {
                if (jSONObject.has("adRenderCostTime")) {
                    p.l(jSONObject.optString("adRenderCostTime"));
                }
                if (jSONObject.has("adLoadCostTime")) {
                    p.s(jSONObject.optString("adLoadCostTime"));
                }
                if (jSONObject.has("adShowScene")) {
                    p.k(jSONObject.optString("adShowScene"));
                }
                if (jSONObject.has("adSplashType")) {
                    p.m(jSONObject.optString("adSplashType"));
                }
            }
            iy0.b(p);
        }
    }

    public void l() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (strArr = this.a.r) == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String optString = new JSONObject(str).optString("url");
                if (!TextUtils.isEmpty(optString)) {
                    jy0.a(new ky0(ClogBuilder.LogType.CLICK, optString.replace("__GESTURE__", String.valueOf(b)), ta1.a, a(optString)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void n() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (strArr = this.a.q) == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String optString = new JSONObject(str).optString("url");
                if (!TextUtils.isEmpty(optString)) {
                    jy0.a(new ky0(ClogBuilder.LogType.SHOW, optString, ta1.a, a(optString)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
