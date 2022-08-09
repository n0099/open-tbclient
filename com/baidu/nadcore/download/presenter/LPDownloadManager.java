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
import com.repackage.aj0;
import com.repackage.ei0;
import com.repackage.hj0;
import com.repackage.hy0;
import com.repackage.lo0;
import com.repackage.nn0;
import com.repackage.oi0;
import com.repackage.si0;
import com.repackage.ui0;
import com.repackage.vi0;
import com.repackage.vj0;
import com.repackage.xx0;
import com.repackage.xz0;
import com.repackage.yx0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public static LruCache<String, aj0> a;
    public static Map<String, Integer> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends lo0<vi0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ oi0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ int e;

        public a(RelativeLayout relativeLayout, oi0 oi0Var, String str, Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, oi0Var, str, context, Integer.valueOf(i)};
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
            this.b = oi0Var;
            this.c = str;
            this.d = context;
            this.e = i;
        }

        @Override // com.repackage.jo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ko0
        /* renamed from: e */
        public void b(Headers headers, vi0 vi0Var, int i) {
            nn0 nn0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, vi0Var, i) == null) || vi0Var == null) {
                return;
            }
            int i2 = vi0Var.a;
            if (i2 == 1) {
                aj0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(vi0Var);
                d.z(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                xz0.a().a(this.d, R.string.obfuscated_res_0x7f0f0b99);
            } else if ((this.d instanceof Activity) && (nn0Var = vi0Var.b) != null) {
                LPDownloadManager.g(this.b, nn0Var);
                aj0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                d2.y(vi0Var);
                d2.z(false);
                d2.A(this.a, vi0Var, (Activity) this.d, this.e);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(vi0Var.a)).l(this.c);
            hy0.b(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ko0
        /* renamed from: f */
        public vi0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? vi0.a(xx0.c(str).optJSONObject("data")) : (vi0) invokeLLI.objValue;
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

    public static oi0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c2 = xx0.c(str);
            String optString = c2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c2.optString("lp_url", "");
            }
            oi0 query = ei0.a().query(optString);
            if (query != null) {
                return query;
            }
            oi0 oi0Var = new oi0();
            oi0Var.g = c2.optString("url", "");
            oi0Var.h(optString);
            oi0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
            oi0Var.q.j = c2.optString("da_area", "");
            oi0Var.q.b = c2.optString(Constant.KEY_BUSINESS);
            oi0Var.q.d = c2.optString("content_type");
            oi0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            oi0Var.q.g = c2.optInt("close_v_dl");
            oi0Var.p.a = c2.optString("log_ext");
            oi0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
            oi0Var.p.g = c2.optString("app_icon");
            oi0Var.p.h = c2.optString("app_name");
            return oi0Var;
        }
        return (oi0) invokeL.objValue;
    }

    public static aj0 d(RelativeLayout relativeLayout, oi0 oi0Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, oi0Var, str)) == null) {
            hj0<?> a2 = vj0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
            Map<String, Integer> map = b;
            if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                Integer num = map.get(str);
                ((DefaultDownloadViewLP) a2).setAbsorbColor(num != null ? num.intValue() : -1);
            }
            aj0 aj0Var = new aj0(oi0Var, a2);
            if (a == null) {
                a = new LruCache<>(32);
            }
            yx0.e(a, oi0Var.e(), aj0Var);
            return aj0Var;
        }
        return (aj0) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull oi0 oi0Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, relativeLayout, str, oi0Var, Integer.valueOf(i)}) == null) {
            for (String str2 : c) {
                if (oi0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    aj0 d = d(relativeLayout, oi0Var, str);
                    d.z(true);
                    d.m();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", oi0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", oi0Var.g);
            new ui0().b(linkedHashMap, new a(relativeLayout, oi0Var, str, context, i));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            oi0 c2 = c(str);
            if (c2.f()) {
                return false;
            }
            JSONObject c3 = xx0.c(str);
            String optString = c3.optString("lp_url", "");
            int optInt = c3.optInt("lp_check_mode", 0);
            aj0 aj0Var = (aj0) yx0.b(a, c2.e());
            if (aj0Var != null) {
                if (z && c2.c != AdDownloadStatus.DOWNLOADING && aj0Var.w()) {
                    aj0Var.m();
                }
                if (aj0Var.x()) {
                    hj0<?> a2 = vj0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
                    Map<String, Integer> map = b;
                    if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                        Integer num = map.get(optString);
                        ((DefaultDownloadViewLP) a2).setAbsorbColor(num != null ? num.intValue() : -1);
                    }
                    aj0Var.t(a2);
                    if (!aj0Var.w() && (context instanceof Activity)) {
                        aj0Var.A(relativeLayout, aj0Var.v(), (Activity) context, optInt);
                    }
                }
                return true;
            }
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull oi0 oi0Var, @NonNull nn0 nn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, oi0Var, nn0Var) == null) {
            oi0Var.g = nn0Var.j;
            si0 si0Var = oi0Var.p;
            si0Var.g = nn0Var.b;
            si0Var.h = nn0Var.c;
        }
    }
}
