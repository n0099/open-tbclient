package com.baidu.nadcore.download.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.DefaultDownloadViewLP;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.LruCache;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.ap0;
import com.baidu.tieba.ck0;
import com.baidu.tieba.ek0;
import com.baidu.tieba.fk0;
import com.baidu.tieba.il0;
import com.baidu.tieba.kk0;
import com.baidu.tieba.kz0;
import com.baidu.tieba.lz0;
import com.baidu.tieba.n11;
import com.baidu.tieba.pj0;
import com.baidu.tieba.rk0;
import com.baidu.tieba.uz0;
import com.baidu.tieba.yj0;
import com.baidu.tieba.yp0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public static LruCache<String, kk0> a;
    public static Map<String, Integer> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends yp0<fk0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ yj0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ int e;

        public a(RelativeLayout relativeLayout, yj0 yj0Var, String str, Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, yj0Var, str, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = relativeLayout;
            this.b = yj0Var;
            this.c = str;
            this.d = context;
            this.e = i;
        }

        @Override // com.baidu.tieba.wp0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xp0
        /* renamed from: e */
        public void b(Headers headers, fk0 fk0Var, int i) {
            ap0 ap0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, fk0Var, i) == null) || fk0Var == null) {
                return;
            }
            int i2 = fk0Var.a;
            if (i2 == 1) {
                kk0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(fk0Var);
                d.z(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                n11.a().a(this.d, R.string.obfuscated_res_0x7f0f0bb6);
            } else if ((this.d instanceof Activity) && (ap0Var = fk0Var.b) != null) {
                LPDownloadManager.g(this.b, ap0Var);
                kk0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                d2.y(fk0Var);
                d2.z(false);
                d2.A(this.a, fk0Var, (Activity) this.d, this.e);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(fk0Var.a)).l(this.c);
            uz0.b(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xp0
        /* renamed from: f */
        public fk0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? fk0.a(kz0.c(str).optJSONObject("data")) : (fk0) invokeLLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-614438789, "Lcom/baidu/nadcore/download/presenter/LPDownloadManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-614438789, "Lcom/baidu/nadcore/download/presenter/LPDownloadManager;");
                return;
            }
        }
        c = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("https://cover.baidu.com");
                add("http://cover.baidu.com");
            }
        };
    }

    public static yj0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c2 = kz0.c(str);
            String optString = c2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c2.optString("lp_url", "");
            }
            yj0 query = pj0.b().query(optString);
            if (query != null) {
                return query;
            }
            yj0 yj0Var = new yj0();
            yj0Var.g = c2.optString("url", "");
            yj0Var.h(optString);
            yj0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
            yj0Var.q.j = c2.optString("da_area", "");
            yj0Var.q.b = c2.optString(Constant.KEY_BUSINESS);
            yj0Var.q.d = c2.optString("content_type");
            yj0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            yj0Var.q.g = c2.optInt("close_v_dl");
            yj0Var.p.a = c2.optString("log_ext");
            yj0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
            yj0Var.p.g = c2.optString("app_icon");
            yj0Var.p.h = c2.optString("app_name");
            return yj0Var;
        }
        return (yj0) invokeL.objValue;
    }

    public static kk0 d(RelativeLayout relativeLayout, yj0 yj0Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, yj0Var, str)) == null) {
            rk0<?> a2 = il0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
            Map<String, Integer> map = b;
            if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                Integer num = map.get(str);
                ((DefaultDownloadViewLP) a2).setAbsorbColor(num != null ? num.intValue() : -1);
            }
            kk0 kk0Var = new kk0(yj0Var, a2);
            if (a == null) {
                a = new LruCache<>(32);
            }
            lz0.e(a, yj0Var.e(), kk0Var);
            return kk0Var;
        }
        return (kk0) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull yj0 yj0Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, relativeLayout, str, yj0Var, Integer.valueOf(i)}) == null) {
            for (String str2 : c) {
                if (yj0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    kk0 d = d(relativeLayout, yj0Var, str);
                    d.z(true);
                    d.m();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", yj0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", yj0Var.g);
            new ek0().b(linkedHashMap, new a(relativeLayout, yj0Var, str, context, i));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            yj0 c2 = c(str);
            if (c2.f()) {
                return false;
            }
            JSONObject c3 = kz0.c(str);
            String optString = c3.optString("lp_url", "");
            int optInt = c3.optInt("lp_check_mode", 0);
            kk0 kk0Var = (kk0) lz0.b(a, c2.e());
            if (kk0Var != null) {
                if (z && c2.c != AdDownloadStatus.DOWNLOADING && kk0Var.w()) {
                    kk0Var.m();
                }
                if (kk0Var.x()) {
                    rk0<?> a2 = il0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
                    Map<String, Integer> map = b;
                    if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                        Integer num = map.get(optString);
                        ((DefaultDownloadViewLP) a2).setAbsorbColor(num != null ? num.intValue() : -1);
                    }
                    kk0Var.t(a2);
                    if (!kk0Var.w() && (context instanceof Activity)) {
                        kk0Var.A(relativeLayout, kk0Var.v(), (Activity) context, optInt);
                    }
                }
                return true;
            }
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull yj0 yj0Var, @NonNull ap0 ap0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, yj0Var, ap0Var) == null) {
            yj0Var.g = ap0Var.j;
            ck0 ck0Var = yj0Var.p;
            ck0Var.g = ap0Var.b;
            ck0Var.h = ap0Var.c;
        }
    }
}
