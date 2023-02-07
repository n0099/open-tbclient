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
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.cl0;
import com.baidu.tieba.er0;
import com.baidu.tieba.g41;
import com.baidu.tieba.gl0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.il0;
import com.baidu.tieba.jl0;
import com.baidu.tieba.mm0;
import com.baidu.tieba.ms0;
import com.baidu.tieba.n21;
import com.baidu.tieba.ol0;
import com.baidu.tieba.tk0;
import com.baidu.tieba.vl0;
import com.baidu.tieba.y11;
import com.baidu.tieba.z11;
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
    public static LruCache<String, ol0> a;
    public static Map<String, Integer> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends ms0<jl0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ cl0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;

        @Override // com.baidu.tieba.ks0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        public a(RelativeLayout relativeLayout, cl0 cl0Var, String str, int i, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, cl0Var, str, Integer.valueOf(i), context};
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
            this.b = cl0Var;
            this.c = str;
            this.d = i;
            this.e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ls0
        /* renamed from: f */
        public jl0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                return jl0.a(y11.c(str).optJSONObject("data"));
            }
            return (jl0) invokeLLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ls0
        /* renamed from: e */
        public void b(Headers headers, jl0 jl0Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(1048579, this, headers, jl0Var, i) != null) || jl0Var == null) {
                return;
            }
            int i2 = jl0Var.a;
            if (i2 == 1) {
                ol0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(jl0Var);
                d.z(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                g41.a().a(this.e, R.string.nad_download_lp_forbid_tip);
            } else {
                er0 er0Var = jl0Var.b;
                if (er0Var != null) {
                    if (this.d == 1) {
                        LPDownloadManager.g(this.b, er0Var);
                        ol0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                        d2.y(jl0Var);
                        d2.z(false);
                        d2.B(this.a, jl0Var, this.e);
                    } else if (this.e instanceof Activity) {
                        LPDownloadManager.g(this.b, er0Var);
                        ol0 d3 = LPDownloadManager.d(this.a, this.b, this.c);
                        d3.y(jl0Var);
                        d3.z(false);
                        d3.A(this.a, jl0Var, (Activity) this.e);
                    }
                }
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(jl0Var.a)).l(this.c);
            n21.b(clogBuilder);
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

    public static void g(@NonNull cl0 cl0Var, @NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, cl0Var, er0Var) == null) {
            cl0Var.g = er0Var.j;
            gl0 gl0Var = cl0Var.p;
            gl0Var.g = er0Var.b;
            gl0Var.h = er0Var.c;
        }
    }

    public static cl0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c2 = y11.c(str);
            String optString = c2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c2.optString("lp_url", "");
            }
            cl0 query = tk0.b().query(optString);
            if (query != null) {
                return query;
            }
            cl0 cl0Var = new cl0();
            cl0Var.g = c2.optString("url", "");
            cl0Var.h(optString);
            cl0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
            cl0Var.q.j = c2.optString("da_area", "");
            cl0Var.q.b = c2.optString("business");
            cl0Var.q.d = c2.optString("content_type");
            cl0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            cl0Var.q.g = c2.optInt("close_v_dl");
            cl0Var.p.a = c2.optString("log_ext");
            cl0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
            cl0Var.p.g = c2.optString("app_icon");
            cl0Var.p.h = c2.optString("app_name");
            return cl0Var;
        }
        return (cl0) invokeL.objValue;
    }

    public static ol0 d(RelativeLayout relativeLayout, cl0 cl0Var, String str) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, cl0Var, str)) == null) {
            vl0<?> a2 = mm0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
            Map<String, Integer> map = b;
            if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                Integer num = map.get(str);
                DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) a2;
                if (num != null) {
                    i = num.intValue();
                } else {
                    i = -1;
                }
                defaultDownloadViewLP.setAbsorbColor(i);
            }
            ol0 ol0Var = new ol0(cl0Var, a2);
            if (a == null) {
                a = new LruCache<>(32);
            }
            z11.e(a, cl0Var.e(), ol0Var);
            return ol0Var;
        }
        return (ol0) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull cl0 cl0Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, relativeLayout, str, cl0Var, Integer.valueOf(i)}) == null) {
            for (String str2 : c) {
                if (cl0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    ol0 d = d(relativeLayout, cl0Var, str);
                    d.z(true);
                    d.m();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", cl0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", cl0Var.g);
            new il0().b(linkedHashMap, new a(relativeLayout, cl0Var, str, i, context));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            cl0 c2 = c(str);
            if (c2.f()) {
                return false;
            }
            JSONObject c3 = y11.c(str);
            String optString = c3.optString("lp_url", "");
            int optInt = c3.optInt("lp_check_mode", 0);
            ol0 ol0Var = (ol0) z11.b(a, c2.e());
            if (ol0Var != null) {
                if (z && c2.c != AdDownloadStatus.DOWNLOADING && ol0Var.w()) {
                    ol0Var.m();
                }
                if (ol0Var.x()) {
                    vl0<?> a2 = mm0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
                    Map<String, Integer> map = b;
                    if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                        Integer num = map.get(optString);
                        DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) a2;
                        if (num != null) {
                            i = num.intValue();
                        } else {
                            i = -1;
                        }
                        defaultDownloadViewLP.setAbsorbColor(i);
                    }
                    ol0Var.t(a2);
                    if (!ol0Var.w()) {
                        if (optInt == 1) {
                            ol0Var.B(relativeLayout, ol0Var.v(), context);
                        } else if (context instanceof Activity) {
                            ol0Var.A(relativeLayout, ol0Var.v(), (Activity) context);
                        }
                    }
                }
                return true;
            } else if (gm0.a(str, optString)) {
                ol0 d = d(relativeLayout, c2, optString);
                d.z(true);
                d.m();
                return true;
            } else {
                e(context, relativeLayout, optString, c2, optInt);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }
}
