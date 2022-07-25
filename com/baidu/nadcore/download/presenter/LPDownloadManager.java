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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dj0;
import com.repackage.ii0;
import com.repackage.iy0;
import com.repackage.kj0;
import com.repackage.no0;
import com.repackage.qn0;
import com.repackage.si0;
import com.repackage.wi0;
import com.repackage.yi0;
import com.repackage.yj0;
import com.repackage.yx0;
import com.repackage.yz0;
import com.repackage.zi0;
import com.repackage.zx0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public static LruCache<String, dj0> a;
    public static Map<String, Integer> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends no0<zi0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ si0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;

        public a(RelativeLayout relativeLayout, si0 si0Var, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, si0Var, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = relativeLayout;
            this.b = si0Var;
            this.c = str;
            this.d = context;
        }

        @Override // com.repackage.lo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mo0
        /* renamed from: e */
        public void b(Headers headers, zi0 zi0Var, int i) {
            qn0 qn0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, zi0Var, i) == null) || zi0Var == null) {
                return;
            }
            int i2 = zi0Var.a;
            if (i2 == 1) {
                dj0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(zi0Var);
                d.z(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                yz0.a().b(this.d, R.string.obfuscated_res_0x7f0f0b74);
            } else if ((this.d instanceof Activity) && (qn0Var = zi0Var.b) != null) {
                LPDownloadManager.g(this.b, qn0Var);
                dj0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                d2.y(zi0Var);
                d2.z(false);
                d2.A(zi0Var, (Activity) this.d);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(zi0Var.a)).l(this.c);
            iy0.b(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mo0
        /* renamed from: f */
        public zi0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? zi0.a(yx0.c(str).optJSONObject("data")) : (zi0) invokeLLI.objValue;
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

    public static si0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c2 = yx0.c(str);
            String optString = c2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c2.optString("lp_url", "");
            }
            si0 query = ii0.a().query(optString);
            if (query != null) {
                return query;
            }
            si0 si0Var = new si0();
            si0Var.g = c2.optString("url", "");
            si0Var.g(optString);
            si0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
            si0Var.q.j = c2.optString("da_area", "");
            si0Var.q.b = c2.optString(Constant.KEY_BUSINESS);
            si0Var.q.d = c2.optString("content_type");
            si0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            si0Var.q.g = c2.optInt("close_v_dl");
            si0Var.p.a = c2.optString("log_ext");
            si0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
            si0Var.p.g = c2.optString("app_icon");
            si0Var.p.h = c2.optString("app_name");
            return si0Var;
        }
        return (si0) invokeL.objValue;
    }

    public static dj0 d(RelativeLayout relativeLayout, si0 si0Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, si0Var, str)) == null) {
            kj0<?> a2 = yj0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
            Map<String, Integer> map = b;
            if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                Integer num = map.get(str);
                ((DefaultDownloadViewLP) a2).setAbsorbColor(num != null ? num.intValue() : -1);
            }
            dj0 dj0Var = new dj0(si0Var, a2);
            if (a == null) {
                a = new LruCache<>(32);
            }
            zx0.e(a, si0Var.d(), dj0Var);
            return dj0Var;
        }
        return (dj0) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, context, relativeLayout, str, si0Var) == null) {
            for (String str2 : c) {
                if (si0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    dj0 d = d(relativeLayout, si0Var, str);
                    d.z(true);
                    d.m();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", si0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", si0Var.g);
            new yi0().b(linkedHashMap, new a(relativeLayout, si0Var, str, context));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            si0 c2 = c(str);
            if (c2.e()) {
                return false;
            }
            String optString = yx0.c(str).optString("lp_url", "");
            dj0 dj0Var = (dj0) zx0.b(a, c2.d());
            if (dj0Var != null) {
                if (z && c2.c != AdDownloadStatus.DOWNLOADING && dj0Var.w()) {
                    dj0Var.m();
                }
                if (dj0Var.x()) {
                    kj0<?> a2 = yj0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
                    Map<String, Integer> map = b;
                    if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                        Integer num = map.get(optString);
                        ((DefaultDownloadViewLP) a2).setAbsorbColor(num != null ? num.intValue() : -1);
                    }
                    dj0Var.t(a2);
                    if (!dj0Var.w() && (context instanceof Activity)) {
                        dj0Var.A(dj0Var.v(), (Activity) context);
                    }
                }
                return true;
            }
            e(context, relativeLayout, optString, c2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull si0 si0Var, @NonNull qn0 qn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, si0Var, qn0Var) == null) {
            si0Var.g = qn0Var.j;
            wi0 wi0Var = si0Var.p;
            wi0Var.g = qn0Var.b;
            wi0Var.h = qn0Var.c;
        }
    }
}
