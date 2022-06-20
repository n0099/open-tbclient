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
import com.repackage.ao0;
import com.repackage.dn0;
import com.repackage.ii0;
import com.repackage.li0;
import com.repackage.lj0;
import com.repackage.lx0;
import com.repackage.lz0;
import com.repackage.mx0;
import com.repackage.ni0;
import com.repackage.oi0;
import com.repackage.si0;
import com.repackage.vx0;
import com.repackage.yh0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public static LruCache<String, si0> a;
    public static final List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends ao0<oi0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ ii0 b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;

        public a(RelativeLayout relativeLayout, ii0 ii0Var, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, ii0Var, context, str};
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
            this.b = ii0Var;
            this.c = context;
            this.d = str;
        }

        @Override // com.repackage.yn0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zn0
        /* renamed from: e */
        public void b(Headers headers, oi0 oi0Var, int i) {
            dn0 dn0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, oi0Var, i) == null) || oi0Var == null) {
                return;
            }
            int i2 = oi0Var.a;
            if (i2 == 1) {
                LPDownloadManager.d(this.a, this.b).l();
            } else if (i2 != 2 && i2 != 3) {
                lz0.a().b(this.c, R.string.obfuscated_res_0x7f0f0b97);
            } else if ((this.c instanceof Activity) && (dn0Var = oi0Var.b) != null) {
                LPDownloadManager.g(this.b, dn0Var);
                LPDownloadManager.d(this.a, this.b).u(oi0Var, (Activity) this.c);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.w(ClogBuilder.LogType.FREE_SHOW).n(this.b.p.a).s(ClogBuilder.Page.DOWNLOAD_RECTIFY).i(String.valueOf(oi0Var.a)).j(this.d);
            vx0.c(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zn0
        /* renamed from: f */
        public oi0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? oi0.a(lx0.c(str).optJSONObject("data")) : (oi0) invokeLLI.objValue;
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

    public static ii0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c = lx0.c(str);
            String optString = c.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c.optString("lp_url", "");
            }
            ii0 query = yh0.a().query(optString);
            if (query != null) {
                return query;
            }
            ii0 ii0Var = new ii0();
            ii0Var.g = c.optString("url", "");
            ii0Var.g(optString);
            ii0Var.q.b = c.optString(Constant.KEY_BUSINESS);
            ii0Var.q.c = c.optString("content_type");
            ii0Var.q.d = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            ii0Var.q.f = c.optInt("close_v_dl");
            ii0Var.p.a = c.optString("log_ext");
            ii0Var.p.j = c.optString(LegoListActivityConfig.AD_ID);
            ii0Var.p.g = c.optString("app_icon");
            ii0Var.p.h = c.optString("app_name");
            return ii0Var;
        }
        return (ii0) invokeL.objValue;
    }

    public static si0 d(RelativeLayout relativeLayout, ii0 ii0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, ii0Var)) == null) {
            si0 si0Var = new si0(ii0Var, lj0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW));
            if (a == null) {
                a = new LruCache<>(32);
            }
            mx0.e(a, ii0Var.d(), si0Var);
            return si0Var;
        }
        return (si0) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, context, relativeLayout, str, ii0Var) == null) {
            for (String str2 : b) {
                if (ii0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    d(relativeLayout, ii0Var).l();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", ii0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", ii0Var.g);
            new ni0().b(linkedHashMap, new a(relativeLayout, ii0Var, context, str));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            ii0 c = c(str);
            if (c.e()) {
                return false;
            }
            String optString = lx0.c(str).optString("lp_url", "");
            si0 si0Var = (si0) mx0.b(a, c.d());
            if (si0Var != null && !si0Var.t()) {
                if (z && c.c != AdDownloadStatus.DOWNLOADING) {
                    si0Var.l();
                }
                return true;
            }
            e(context, relativeLayout, optString, c);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull ii0 ii0Var, @NonNull dn0 dn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ii0Var, dn0Var) == null) {
            ii0Var.g = dn0Var.j;
            li0 li0Var = ii0Var.p;
            li0Var.g = dn0Var.b;
            li0Var.h = dn0Var.c;
        }
    }
}
