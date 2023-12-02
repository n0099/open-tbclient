package com.baidu.prologue.business.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.af1;
import com.baidu.tieba.az0;
import com.baidu.tieba.bf1;
import com.baidu.tieba.dz0;
import com.baidu.tieba.e01;
import com.baidu.tieba.ez0;
import com.baidu.tieba.fz0;
import com.baidu.tieba.hf0;
import com.baidu.tieba.ij0;
import com.baidu.tieba.jz0;
import com.baidu.tieba.kz0;
import com.baidu.tieba.te1;
import com.baidu.tieba.ue1;
import com.baidu.tieba.ve1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BaseVM {
    public static /* synthetic */ Interceptable $ic = null;
    public static String c = null;
    public static String d = "";
    public static long e;
    public transient /* synthetic */ FieldHolder $fh;
    public final bf1 a;
    public long b;

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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            GIF = new Area("GIF", 3, "gif");
            DEEPLINK_RESULT_APP = new Area("DEEPLINK_RESULT_APP", 4, GrsBaseInfo.CountryCodeSource.APP);
            DEEPLINK_RESULT_H5 = new Area("DEEPLINK_RESULT_H5", 5, "URL");
            Area area = new Area("UNKNOW", 6, DownloadStatisticConstants.UBC_VALUE_UNKNOW);
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Area) Enum.valueOf(Area.class, str);
            }
            return (Area) invokeL.objValue;
        }

        public static Area[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Area[]) $VALUES.clone();
            }
            return (Area[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CloseType) Enum.valueOf(CloseType.class, str);
            }
            return (CloseType) invokeL.objValue;
        }

        public static CloseType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CloseType[]) $VALUES.clone();
            }
            return (CloseType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ String g;

        public a(long j, long j2, String str, String str2, String str3, boolean z, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), str, str2, str3, Boolean.valueOf(z), str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = j2;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = z;
            this.g = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.a;
                long j2 = currentTimeMillis - j;
                long j3 = j - this.b;
                jz0 b = new kz0().g("1038").c("f1", Long.valueOf(this.b)).b("f2", this.c).b("f3", this.d);
                kz0 kz0Var = (kz0) b.b("f4", j2 + "").b("f5", this.e).b("f6", String.valueOf(te1.b())).b("f10", String.valueOf(j3));
                if (TextUtils.equals("query", this.e)) {
                    kz0Var.c("f7", Integer.valueOf(this.f ? 1 : 0));
                    if (!TextUtils.isEmpty(this.g)) {
                        kz0Var.c("f8", Integer.valueOf(ue1.b(this.g)));
                        kz0Var.b("f9", ue1.c(this.g));
                    }
                }
                String string = az0.a().b("splash_sp_name").getString("empty_ext_info", "");
                if (!TextUtils.isEmpty(string)) {
                    kz0Var.h(string);
                }
                dz0.e(kz0Var);
            }
        }
    }

    public BaseVM(bf1 bf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bf1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = bf1Var;
    }

    public static void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            i(i, "");
        }
    }

    public static void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            i(8192, String.valueOf(i));
        }
    }

    public static void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            c = str;
        }
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(af1.j()) && af1.k()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            d(str);
            l();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(ve1.a)) {
            dz0.e(new ClogBuilder().y(ClogBuilder.LogType.DEEP_LINK).u(ClogBuilder.Page.NA_SPLASH).j(str).p(ve1.a));
        }
    }

    public static void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            dz0.e(new ClogBuilder().y(ClogBuilder.LogType.CHECK).u(ClogBuilder.Page.NA_SPLASH).k("13").l(String.valueOf(i)).m(hf0.c().a().t()));
        }
    }

    public void g(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            ClogBuilder u = new ClogBuilder().y(ClogBuilder.LogType.DISCARD).u(ClogBuilder.Page.NA_SPLASH);
            bf1 bf1Var = this.a;
            if (bf1Var == null) {
                str2 = "";
            } else {
                str2 = bf1Var.d;
            }
            dz0.e(u.p(str2).k("10").m(str));
        }
    }

    public static void i(int i, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str) == null) {
            String string = az0.a().b("splash_sp_name").getString("empty_ext_info", "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int a2 = ij0.b().a().a("splash_min_log_interval", 0);
            if (a2 > 0 && currentTimeMillis - e < a2) {
                return;
            }
            e = currentTimeMillis;
            if (i == 32 && !TextUtils.isEmpty(d)) {
                str = d;
            }
            ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.SHOW).u(ClogBuilder.Page.NA_SPLASH).k(String.valueOf(i)).p(string);
            if (!TextUtils.isEmpty(str)) {
                p.l(str);
            }
            String p2 = af1.p();
            if (!TextUtils.isEmpty(p2)) {
                p.m(p2);
            }
            if (te1.b() == 0) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            p.n(str2);
            dz0.e(p);
        }
    }

    public static void n(String str, long j, long j2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2, str3}) == null) {
            o(str, j, j2, str2, str3, false, "");
        }
    }

    public static void o(String str, long j, long j2, String str2, String str3, boolean z, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2, str3, Boolean.valueOf(z), str4}) == null) {
            e01.c(new a(j2, j, str, str2, str3, z, str4), "splash reportPerformance", 3);
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            dz0.e(new ClogBuilder().y(ClogBuilder.LogType.CHECK).u(ClogBuilder.Page.NA_SPLASH).k("14").l("14002"));
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c = "";
        }
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject != null) {
                this.b = jSONObject.optLong("show_time");
            }
            if (this.a.q()) {
                long currentTimeMillis = System.currentTimeMillis();
                int a2 = ij0.b().a().a("splash_min_log_interval", 0);
                if (a2 > 0 && currentTimeMillis - e < a2) {
                    return;
                }
            }
            j(jSONObject);
            p();
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.CLICK).u(ClogBuilder.Page.NA_SPLASH).n(String.valueOf(te1.b())).o(this.a.O).p(this.a.d);
            if (!TextUtils.isEmpty(str)) {
                p.m(str);
            }
            dz0.e(p);
        }
    }

    public void e(String str, long j) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) {
            boolean z = true;
            if (hf0.b().getResources().getConfiguration().orientation != 1) {
                z = false;
            }
            ClogBuilder l = new ClogBuilder().y(ClogBuilder.LogType.CLOSE).u(ClogBuilder.Page.NA_SPLASH).p(this.a.d).l(String.valueOf(j));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            dz0.e(l.k(str2).m(str));
        }
    }

    public void j(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.SHOW).u(ClogBuilder.Page.NA_SPLASH).n(String.valueOf(te1.b())).o(this.a.O).p(this.a.d);
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
            dz0.e(p);
        }
    }

    public void l() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (strArr = this.a.r) == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    String replace = new JSONObject(str).optString("url").replace("__GESTURE__", String.valueOf(c)).replace("__SHOWTIME__", String.valueOf(this.b)).replace("__LAUNCH_TYPE__", String.valueOf(te1.b())).replace("__GESTURE_PARAM__", this.a.a());
                    if (!TextUtils.isEmpty(replace)) {
                        ez0.a(new fz0(ClogBuilder.LogType.CLICK, replace, ve1.a, a(replace), this.a.V));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void p() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (strArr = this.a.q) == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    String replace = new JSONObject(str).optString("url").replace("__GESTURE__", String.valueOf(this.a.G)).replace("__SHOWTIME__", String.valueOf(this.b)).replace("__LAUNCH_TYPE__", String.valueOf(te1.b())).replace("__GESTURE_PARAM__", this.a.a());
                    if (!TextUtils.isEmpty(replace)) {
                        ez0.a(new fz0(ClogBuilder.LogType.SHOW, replace, ve1.a, a(replace), this.a.V));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else {
                return;
            }
        }
    }
}
