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
import com.repackage.bk0;
import com.repackage.ez0;
import com.repackage.hj0;
import com.repackage.jp0;
import com.repackage.mo0;
import com.repackage.rj0;
import com.repackage.u01;
import com.repackage.uj0;
import com.repackage.uk0;
import com.repackage.uy0;
import com.repackage.vy0;
import com.repackage.wj0;
import com.repackage.xj0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public static LruCache<String, bk0> a;
    public static final List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends jp0<xj0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ rj0 b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;

        public a(RelativeLayout relativeLayout, rj0 rj0Var, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, rj0Var, context, str};
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
            this.b = rj0Var;
            this.c = context;
            this.d = str;
        }

        @Override // com.repackage.hp0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ip0
        /* renamed from: e */
        public void b(Headers headers, xj0 xj0Var, int i) {
            mo0 mo0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, xj0Var, i) == null) || xj0Var == null) {
                return;
            }
            int i2 = xj0Var.a;
            if (i2 == 1) {
                LPDownloadManager.d(this.a, this.b).l();
            } else if (i2 != 2 && i2 != 3) {
                u01.a().b(this.c, R.string.obfuscated_res_0x7f0f0b8d);
            } else if ((this.c instanceof Activity) && (mo0Var = xj0Var.b) != null) {
                LPDownloadManager.g(this.b, mo0Var);
                LPDownloadManager.d(this.a, this.b).v(xj0Var, (Activity) this.c);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.w(ClogBuilder.LogType.FREE_SHOW).n(this.b.p.a).s(ClogBuilder.Page.DOWNLOAD_RECTIFY).i(String.valueOf(xj0Var.a)).j(this.d);
            ez0.c(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ip0
        /* renamed from: f */
        public xj0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? xj0.a(uy0.c(str).optJSONObject("data")) : (xj0) invokeLLI.objValue;
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

    public static rj0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c = uy0.c(str);
            String optString = c.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c.optString("lp_url", "");
            }
            rj0 query = hj0.a().query(optString);
            if (query != null) {
                return query;
            }
            rj0 rj0Var = new rj0();
            rj0Var.g = c.optString("url", "");
            rj0Var.g(optString);
            rj0Var.q.b = c.optString(Constant.KEY_BUSINESS);
            rj0Var.q.c = c.optString("content_type");
            rj0Var.q.d = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            rj0Var.q.f = c.optInt("close_v_dl");
            rj0Var.p.a = c.optString("log_ext");
            rj0Var.p.j = c.optString(LegoListActivityConfig.AD_ID);
            rj0Var.p.g = c.optString("app_icon");
            rj0Var.p.h = c.optString("app_name");
            return rj0Var;
        }
        return (rj0) invokeL.objValue;
    }

    public static bk0 d(RelativeLayout relativeLayout, rj0 rj0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, rj0Var)) == null) {
            bk0 bk0Var = new bk0(rj0Var, uk0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW));
            if (a == null) {
                a = new LruCache<>(32);
            }
            vy0.e(a, rj0Var.d(), bk0Var);
            return bk0Var;
        }
        return (bk0) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, context, relativeLayout, str, rj0Var) == null) {
            for (String str2 : b) {
                if (rj0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    d(relativeLayout, rj0Var).l();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", rj0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", rj0Var.g);
            new wj0().b(linkedHashMap, new a(relativeLayout, rj0Var, context, str));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            rj0 c = c(str);
            if (c.e()) {
                return false;
            }
            String optString = uy0.c(str).optString("lp_url", "");
            bk0 bk0Var = (bk0) vy0.b(a, c.d());
            if (bk0Var != null && !bk0Var.u()) {
                if (z && c.c != AdDownloadStatus.DOWNLOADING) {
                    bk0Var.l();
                }
                return true;
            }
            e(context, relativeLayout, optString, c);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull rj0 rj0Var, @NonNull mo0 mo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, rj0Var, mo0Var) == null) {
            rj0Var.g = mo0Var.j;
            uj0 uj0Var = rj0Var.p;
            uj0Var.g = mo0Var.b;
            uj0Var.h = mo0Var.c;
        }
    }
}
