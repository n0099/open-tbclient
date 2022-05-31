package com.baidu.nadcore.download.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.LruCache;
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
import com.repackage.ei0;
import com.repackage.hi0;
import com.repackage.hj0;
import com.repackage.hx0;
import com.repackage.hz0;
import com.repackage.ix0;
import com.repackage.ji0;
import com.repackage.ki0;
import com.repackage.oi0;
import com.repackage.rx0;
import com.repackage.uh0;
import com.repackage.wn0;
import com.repackage.zm0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public static LruCache<String, oi0> a;
    public static final List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends wn0<ki0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ ei0 b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;

        public a(RelativeLayout relativeLayout, ei0 ei0Var, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, ei0Var, context, str};
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
            this.b = ei0Var;
            this.c = context;
            this.d = str;
        }

        @Override // com.repackage.un0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vn0
        /* renamed from: e */
        public void b(Headers headers, ki0 ki0Var, int i) {
            zm0 zm0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, ki0Var, i) == null) || ki0Var == null) {
                return;
            }
            int i2 = ki0Var.a;
            if (i2 == 1) {
                LPDownloadManager.d(this.a, this.b).l();
            } else if (i2 != 2 && i2 != 3) {
                hz0.a().b(this.c, R.string.obfuscated_res_0x7f0f0b93);
            } else if ((this.c instanceof Activity) && (zm0Var = ki0Var.b) != null) {
                LPDownloadManager.g(this.b, zm0Var);
                LPDownloadManager.d(this.a, this.b).v(ki0Var, (Activity) this.c);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.w(ClogBuilder.LogType.FREE_SHOW).n(this.b.p.a).s(ClogBuilder.Page.DOWNLOAD_RECTIFY).i(String.valueOf(ki0Var.a)).j(this.d);
            rx0.c(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vn0
        /* renamed from: f */
        public ki0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? ki0.a(hx0.c(str).optJSONObject("data")) : (ki0) invokeLLI.objValue;
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
        b = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
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

    public static ei0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c = hx0.c(str);
            String optString = c.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c.optString("lp_url", "");
            }
            ei0 query = uh0.a().query(optString);
            if (query != null) {
                return query;
            }
            ei0 ei0Var = new ei0();
            ei0Var.g = c.optString("url", "");
            ei0Var.g(optString);
            ei0Var.q.b = c.optString(Constant.KEY_BUSINESS);
            ei0Var.q.c = c.optString("content_type");
            ei0Var.q.d = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            ei0Var.q.f = c.optInt("close_v_dl");
            ei0Var.p.a = c.optString("log_ext");
            ei0Var.p.j = c.optString(LegoListActivityConfig.AD_ID);
            ei0Var.p.g = c.optString("app_icon");
            ei0Var.p.h = c.optString("app_name");
            return ei0Var;
        }
        return (ei0) invokeL.objValue;
    }

    public static oi0 d(RelativeLayout relativeLayout, ei0 ei0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, ei0Var)) == null) {
            oi0 oi0Var = new oi0(ei0Var, hj0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW));
            if (a == null) {
                a = new LruCache<>(32);
            }
            ix0.e(a, ei0Var.d(), oi0Var);
            return oi0Var;
        }
        return (oi0) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, context, relativeLayout, str, ei0Var) == null) {
            for (String str2 : b) {
                if (ei0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    d(relativeLayout, ei0Var).l();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", ei0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", ei0Var.g);
            new ji0().b(linkedHashMap, new a(relativeLayout, ei0Var, context, str));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            ei0 c = c(str);
            if (c.e()) {
                return false;
            }
            String optString = hx0.c(str).optString("lp_url", "");
            oi0 oi0Var = (oi0) ix0.b(a, c.d());
            if (oi0Var != null && !oi0Var.u()) {
                if (z && c.c != AdDownloadStatus.DOWNLOADING) {
                    oi0Var.l();
                }
                return true;
            }
            e(context, relativeLayout, optString, c);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull ei0 ei0Var, @NonNull zm0 zm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ei0Var, zm0Var) == null) {
            ei0Var.g = zm0Var.j;
            hi0 hi0Var = ei0Var.p;
            hi0Var.g = zm0Var.b;
            hi0Var.h = zm0Var.c;
        }
    }
}
