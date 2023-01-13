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
import com.baidu.tieba.am0;
import com.baidu.tieba.cl0;
import com.baidu.tieba.e11;
import com.baidu.tieba.hk0;
import com.baidu.tieba.iq0;
import com.baidu.tieba.ir0;
import com.baidu.tieba.jl0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.u01;
import com.baidu.tieba.uk0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.v01;
import com.baidu.tieba.wk0;
import com.baidu.tieba.x21;
import com.baidu.tieba.xk0;
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
    public static LruCache<String, cl0> a;
    public static Map<String, Integer> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends ir0<xk0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ qk0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ int e;

        @Override // com.baidu.tieba.gr0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        public a(RelativeLayout relativeLayout, qk0 qk0Var, String str, Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, qk0Var, str, context, Integer.valueOf(i)};
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
            this.b = qk0Var;
            this.c = str;
            this.d = context;
            this.e = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: f */
        public xk0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                return xk0.a(u01.c(str).optJSONObject("data"));
            }
            return (xk0) invokeLLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: e */
        public void b(Headers headers, xk0 xk0Var, int i) {
            iq0 iq0Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(1048579, this, headers, xk0Var, i) != null) || xk0Var == null) {
                return;
            }
            int i2 = xk0Var.a;
            if (i2 == 1) {
                cl0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(xk0Var);
                d.z(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                x21.a().a(this.d, R.string.nad_download_lp_forbid_tip);
            } else if ((this.d instanceof Activity) && (iq0Var = xk0Var.b) != null) {
                LPDownloadManager.g(this.b, iq0Var);
                cl0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                d2.y(xk0Var);
                d2.z(false);
                d2.A(this.a, xk0Var, (Activity) this.d, this.e);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(xk0Var.a)).l(this.c);
            e11.b(clogBuilder);
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

    public static void g(@NonNull qk0 qk0Var, @NonNull iq0 iq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, qk0Var, iq0Var) == null) {
            qk0Var.g = iq0Var.j;
            uk0 uk0Var = qk0Var.p;
            uk0Var.g = iq0Var.b;
            uk0Var.h = iq0Var.c;
        }
    }

    public static qk0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c2 = u01.c(str);
            String optString = c2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c2.optString("lp_url", "");
            }
            qk0 query = hk0.b().query(optString);
            if (query != null) {
                return query;
            }
            qk0 qk0Var = new qk0();
            qk0Var.g = c2.optString("url", "");
            qk0Var.h(optString);
            qk0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
            qk0Var.q.j = c2.optString("da_area", "");
            qk0Var.q.b = c2.optString("business");
            qk0Var.q.d = c2.optString("content_type");
            qk0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            qk0Var.q.g = c2.optInt("close_v_dl");
            qk0Var.p.a = c2.optString("log_ext");
            qk0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
            qk0Var.p.g = c2.optString("app_icon");
            qk0Var.p.h = c2.optString("app_name");
            return qk0Var;
        }
        return (qk0) invokeL.objValue;
    }

    public static cl0 d(RelativeLayout relativeLayout, qk0 qk0Var, String str) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, qk0Var, str)) == null) {
            jl0<?> a2 = am0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
            cl0 cl0Var = new cl0(qk0Var, a2);
            if (a == null) {
                a = new LruCache<>(32);
            }
            v01.e(a, qk0Var.e(), cl0Var);
            return cl0Var;
        }
        return (cl0) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull qk0 qk0Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, relativeLayout, str, qk0Var, Integer.valueOf(i)}) == null) {
            for (String str2 : c) {
                if (qk0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    cl0 d = d(relativeLayout, qk0Var, str);
                    d.z(true);
                    d.m();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", qk0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", qk0Var.g);
            new wk0().b(linkedHashMap, new a(relativeLayout, qk0Var, str, context, i));
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
            qk0 c2 = c(str);
            if (c2.f()) {
                return false;
            }
            JSONObject c3 = u01.c(str);
            String optString = c3.optString("lp_url", "");
            int optInt = c3.optInt("lp_check_mode", 0);
            cl0 cl0Var = (cl0) v01.b(a, c2.e());
            if (cl0Var != null) {
                if (z && c2.c != AdDownloadStatus.DOWNLOADING && cl0Var.w()) {
                    cl0Var.m();
                }
                if (cl0Var.x()) {
                    jl0<?> a2 = am0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                    cl0Var.t(a2);
                    if (!cl0Var.w() && (context instanceof Activity)) {
                        cl0Var.A(relativeLayout, cl0Var.v(), (Activity) context, optInt);
                    }
                }
                return true;
            } else if (ul0.a(str, optString)) {
                cl0 d = d(relativeLayout, c2, optString);
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
