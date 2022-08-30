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
import com.baidu.tieba.bj0;
import com.baidu.tieba.fi0;
import com.baidu.tieba.ij0;
import com.baidu.tieba.iy0;
import com.baidu.tieba.mo0;
import com.baidu.tieba.on0;
import com.baidu.tieba.pi0;
import com.baidu.tieba.ti0;
import com.baidu.tieba.vi0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.wj0;
import com.baidu.tieba.yx0;
import com.baidu.tieba.yz0;
import com.baidu.tieba.zx0;
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
    public static LruCache<String, bj0> a;
    public static Map<String, Integer> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends mo0<wi0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ pi0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ int e;

        public a(RelativeLayout relativeLayout, pi0 pi0Var, String str, Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, pi0Var, str, context, Integer.valueOf(i)};
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
            this.b = pi0Var;
            this.c = str;
            this.d = context;
            this.e = i;
        }

        @Override // com.baidu.tieba.ko0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lo0
        /* renamed from: e */
        public void b(Headers headers, wi0 wi0Var, int i) {
            on0 on0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, wi0Var, i) == null) || wi0Var == null) {
                return;
            }
            int i2 = wi0Var.a;
            if (i2 == 1) {
                bj0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(wi0Var);
                d.z(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                yz0.a().a(this.d, R.string.obfuscated_res_0x7f0f0b9d);
            } else if ((this.d instanceof Activity) && (on0Var = wi0Var.b) != null) {
                LPDownloadManager.g(this.b, on0Var);
                bj0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                d2.y(wi0Var);
                d2.z(false);
                d2.A(this.a, wi0Var, (Activity) this.d, this.e);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(wi0Var.a)).l(this.c);
            iy0.b(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lo0
        /* renamed from: f */
        public wi0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? wi0.a(yx0.c(str).optJSONObject("data")) : (wi0) invokeLLI.objValue;
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

    public static pi0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c2 = yx0.c(str);
            String optString = c2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c2.optString("lp_url", "");
            }
            pi0 query = fi0.a().query(optString);
            if (query != null) {
                return query;
            }
            pi0 pi0Var = new pi0();
            pi0Var.g = c2.optString("url", "");
            pi0Var.h(optString);
            pi0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
            pi0Var.q.j = c2.optString("da_area", "");
            pi0Var.q.b = c2.optString(Constant.KEY_BUSINESS);
            pi0Var.q.d = c2.optString("content_type");
            pi0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            pi0Var.q.g = c2.optInt("close_v_dl");
            pi0Var.p.a = c2.optString("log_ext");
            pi0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
            pi0Var.p.g = c2.optString("app_icon");
            pi0Var.p.h = c2.optString("app_name");
            return pi0Var;
        }
        return (pi0) invokeL.objValue;
    }

    public static bj0 d(RelativeLayout relativeLayout, pi0 pi0Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, pi0Var, str)) == null) {
            ij0<?> a2 = wj0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
            Map<String, Integer> map = b;
            if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                Integer num = map.get(str);
                ((DefaultDownloadViewLP) a2).setAbsorbColor(num != null ? num.intValue() : -1);
            }
            bj0 bj0Var = new bj0(pi0Var, a2);
            if (a == null) {
                a = new LruCache<>(32);
            }
            zx0.e(a, pi0Var.e(), bj0Var);
            return bj0Var;
        }
        return (bj0) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull pi0 pi0Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, relativeLayout, str, pi0Var, Integer.valueOf(i)}) == null) {
            for (String str2 : c) {
                if (pi0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    bj0 d = d(relativeLayout, pi0Var, str);
                    d.z(true);
                    d.m();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", pi0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", pi0Var.g);
            new vi0().b(linkedHashMap, new a(relativeLayout, pi0Var, str, context, i));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            pi0 c2 = c(str);
            if (c2.f()) {
                return false;
            }
            JSONObject c3 = yx0.c(str);
            String optString = c3.optString("lp_url", "");
            int optInt = c3.optInt("lp_check_mode", 0);
            bj0 bj0Var = (bj0) zx0.b(a, c2.e());
            if (bj0Var != null) {
                if (z && c2.c != AdDownloadStatus.DOWNLOADING && bj0Var.w()) {
                    bj0Var.m();
                }
                if (bj0Var.x()) {
                    ij0<?> a2 = wj0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
                    Map<String, Integer> map = b;
                    if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                        Integer num = map.get(optString);
                        ((DefaultDownloadViewLP) a2).setAbsorbColor(num != null ? num.intValue() : -1);
                    }
                    bj0Var.t(a2);
                    if (!bj0Var.w() && (context instanceof Activity)) {
                        bj0Var.A(relativeLayout, bj0Var.v(), (Activity) context, optInt);
                    }
                }
                return true;
            }
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull pi0 pi0Var, @NonNull on0 on0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, pi0Var, on0Var) == null) {
            pi0Var.g = on0Var.j;
            ti0 ti0Var = pi0Var.p;
            ti0Var.g = on0Var.b;
            ti0Var.h = on0Var.c;
        }
    }
}
