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
import com.baidu.tieba.ck0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.dr0;
import com.baidu.tieba.el0;
import com.baidu.tieba.lk0;
import com.baidu.tieba.p01;
import com.baidu.tieba.pk0;
import com.baidu.tieba.pl0;
import com.baidu.tieba.q01;
import com.baidu.tieba.rk0;
import com.baidu.tieba.s21;
import com.baidu.tieba.sk0;
import com.baidu.tieba.vl0;
import com.baidu.tieba.xk0;
import com.baidu.tieba.z01;
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
    public static LruCache<String, xk0> a;
    public static Map<String, Integer> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends dr0<sk0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ lk0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ int e;

        @Override // com.baidu.tieba.br0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        public a(RelativeLayout relativeLayout, lk0 lk0Var, String str, Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, lk0Var, str, context, Integer.valueOf(i)};
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
            this.b = lk0Var;
            this.c = str;
            this.d = context;
            this.e = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cr0
        /* renamed from: f */
        public sk0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                return sk0.a(p01.c(str).optJSONObject("data"));
            }
            return (sk0) invokeLLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cr0
        /* renamed from: e */
        public void b(Headers headers, sk0 sk0Var, int i) {
            dq0 dq0Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(1048579, this, headers, sk0Var, i) != null) || sk0Var == null) {
                return;
            }
            int i2 = sk0Var.a;
            if (i2 == 1) {
                xk0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(sk0Var);
                d.z(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                s21.a().a(this.d, R.string.obfuscated_res_0x7f0f0bd1);
            } else if ((this.d instanceof Activity) && (dq0Var = sk0Var.b) != null) {
                LPDownloadManager.g(this.b, dq0Var);
                xk0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                d2.y(sk0Var);
                d2.z(false);
                d2.A(this.a, sk0Var, (Activity) this.d, this.e);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(sk0Var.a)).l(this.c);
            z01.b(clogBuilder);
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

    public static void g(@NonNull lk0 lk0Var, @NonNull dq0 dq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, lk0Var, dq0Var) == null) {
            lk0Var.g = dq0Var.j;
            pk0 pk0Var = lk0Var.p;
            pk0Var.g = dq0Var.b;
            pk0Var.h = dq0Var.c;
        }
    }

    public static lk0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c2 = p01.c(str);
            String optString = c2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c2.optString("lp_url", "");
            }
            lk0 query = ck0.b().query(optString);
            if (query != null) {
                return query;
            }
            lk0 lk0Var = new lk0();
            lk0Var.g = c2.optString("url", "");
            lk0Var.h(optString);
            lk0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
            lk0Var.q.j = c2.optString("da_area", "");
            lk0Var.q.b = c2.optString(Constant.KEY_BUSINESS);
            lk0Var.q.d = c2.optString("content_type");
            lk0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            lk0Var.q.g = c2.optInt("close_v_dl");
            lk0Var.p.a = c2.optString("log_ext");
            lk0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
            lk0Var.p.g = c2.optString("app_icon");
            lk0Var.p.h = c2.optString("app_name");
            return lk0Var;
        }
        return (lk0) invokeL.objValue;
    }

    public static xk0 d(RelativeLayout relativeLayout, lk0 lk0Var, String str) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, lk0Var, str)) == null) {
            el0<?> a2 = vl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
            xk0 xk0Var = new xk0(lk0Var, a2);
            if (a == null) {
                a = new LruCache<>(32);
            }
            q01.e(a, lk0Var.e(), xk0Var);
            return xk0Var;
        }
        return (xk0) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull lk0 lk0Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, relativeLayout, str, lk0Var, Integer.valueOf(i)}) == null) {
            for (String str2 : c) {
                if (lk0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    xk0 d = d(relativeLayout, lk0Var, str);
                    d.z(true);
                    d.m();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", lk0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", lk0Var.g);
            new rk0().b(linkedHashMap, new a(relativeLayout, lk0Var, str, context, i));
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
            lk0 c2 = c(str);
            if (c2.f()) {
                return false;
            }
            JSONObject c3 = p01.c(str);
            String optString = c3.optString("lp_url", "");
            int optInt = c3.optInt("lp_check_mode", 0);
            xk0 xk0Var = (xk0) q01.b(a, c2.e());
            if (xk0Var != null) {
                if (z && c2.c != AdDownloadStatus.DOWNLOADING && xk0Var.w()) {
                    xk0Var.m();
                }
                if (xk0Var.x()) {
                    el0<?> a2 = vl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
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
                    xk0Var.t(a2);
                    if (!xk0Var.w() && (context instanceof Activity)) {
                        xk0Var.A(relativeLayout, xk0Var.v(), (Activity) context, optInt);
                    }
                }
                return true;
            } else if (pl0.a(str, optString)) {
                xk0 d = d(relativeLayout, c2, optString);
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
