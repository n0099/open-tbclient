package com.baidu.nadcore.download.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
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
import com.baidu.tieba.b21;
import com.baidu.tieba.dk0;
import com.baidu.tieba.fl0;
import com.baidu.tieba.i01;
import com.baidu.tieba.mk0;
import com.baidu.tieba.mq0;
import com.baidu.tieba.op0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.sk0;
import com.baidu.tieba.tk0;
import com.baidu.tieba.wl0;
import com.baidu.tieba.yk0;
import com.baidu.tieba.yz0;
import com.baidu.tieba.zz0;
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
    public static LruCache a;
    public static Map b;
    public static final List c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public final class a extends mq0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;
        public final /* synthetic */ mk0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ int e;

        @Override // com.baidu.tieba.kq0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        public a(RelativeLayout relativeLayout, mk0 mk0Var, String str, Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, mk0Var, str, context, Integer.valueOf(i)};
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
            this.b = mk0Var;
            this.c = str;
            this.d = context;
            this.e = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq0
        /* renamed from: f */
        public tk0 d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                return tk0.a(yz0.c(str).optJSONObject("data"));
            }
            return (tk0) invokeLLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq0
        /* renamed from: e */
        public void b(Headers headers, tk0 tk0Var, int i) {
            op0 op0Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(1048579, this, headers, tk0Var, i) != null) || tk0Var == null) {
                return;
            }
            int i2 = tk0Var.a;
            if (i2 == 1) {
                yk0 d = LPDownloadManager.d(this.a, this.b, this.c);
                d.y(tk0Var);
                d.z(true);
                d.m();
            } else if (i2 != 2 && i2 != 3) {
                b21.a().a(this.d, R.string.obfuscated_res_0x7f0f0bc5);
            } else if ((this.d instanceof Activity) && (op0Var = tk0Var.b) != null) {
                LPDownloadManager.g(this.b, op0Var);
                yk0 d2 = LPDownloadManager.d(this.a, this.b, this.c);
                d2.y(tk0Var);
                d2.z(false);
                d2.A(this.a, tk0Var, (Activity) this.d, this.e);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).p(this.b.p.a).u(ClogBuilder.Page.DOWNLOAD_RECTIFY).k(String.valueOf(tk0Var.a)).l(this.c);
            i01.b(clogBuilder);
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
        c = new ArrayList() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
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

    public static void g(mk0 mk0Var, op0 op0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, mk0Var, op0Var) == null) {
            mk0Var.g = op0Var.j;
            qk0 qk0Var = mk0Var.p;
            qk0Var.g = op0Var.b;
            qk0Var.h = op0Var.c;
        }
    }

    public static mk0 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject c2 = yz0.c(str);
            String optString = c2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = c2.optString("lp_url", "");
            }
            mk0 query = dk0.b().query(optString);
            if (query != null) {
                return query;
            }
            mk0 mk0Var = new mk0();
            mk0Var.g = c2.optString("url", "");
            mk0Var.h(optString);
            mk0Var.q.a = c2.optString(BdVideoAd.AD_VIDEO_DAPAGE, "");
            mk0Var.q.j = c2.optString("da_area", "");
            mk0Var.q.b = c2.optString(Constant.KEY_BUSINESS);
            mk0Var.q.d = c2.optString("content_type");
            mk0Var.q.e = c2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            mk0Var.q.g = c2.optInt("close_v_dl");
            mk0Var.p.a = c2.optString("log_ext");
            mk0Var.p.j = c2.optString(LegoListActivityConfig.AD_ID);
            mk0Var.p.g = c2.optString("app_icon");
            mk0Var.p.h = c2.optString("app_name");
            return mk0Var;
        }
        return (mk0) invokeL.objValue;
    }

    public static yk0 d(RelativeLayout relativeLayout, mk0 mk0Var, String str) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, mk0Var, str)) == null) {
            fl0 a2 = wl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
            Map map = b;
            if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                Integer num = (Integer) map.get(str);
                DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) a2;
                if (num != null) {
                    i = num.intValue();
                } else {
                    i = -1;
                }
                defaultDownloadViewLP.setAbsorbColor(i);
            }
            yk0 yk0Var = new yk0(mk0Var, a2);
            if (a == null) {
                a = new LruCache(32);
            }
            zz0.e(a, mk0Var.e(), yk0Var);
            return yk0Var;
        }
        return (yk0) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(Context context, RelativeLayout relativeLayout, String str, mk0 mk0Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, relativeLayout, str, mk0Var, Integer.valueOf(i)}) == null) {
            for (String str2 : c) {
                if (mk0Var.g.startsWith(str2) || str.startsWith(str2)) {
                    yk0 d = d(relativeLayout, mk0Var, str);
                    d.z(true);
                    d.m();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", mk0Var.p.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", mk0Var.g);
            new sk0().b(linkedHashMap, new a(relativeLayout, mk0Var, str, context, i));
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
            mk0 c2 = c(str);
            if (c2.f()) {
                return false;
            }
            JSONObject c3 = yz0.c(str);
            String optString = c3.optString("lp_url", "");
            int optInt = c3.optInt("lp_check_mode", 0);
            yk0 yk0Var = (yk0) zz0.b(a, c2.e());
            if (yk0Var != null) {
                if (z && c2.c != AdDownloadStatus.DOWNLOADING && yk0Var.w()) {
                    yk0Var.m();
                }
                if (yk0Var.x()) {
                    fl0 a2 = wl0.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW);
                    Map map = b;
                    if (map != null && (a2 instanceof DefaultDownloadViewLP)) {
                        Integer num = (Integer) map.get(optString);
                        DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) a2;
                        if (num != null) {
                            i = num.intValue();
                        } else {
                            i = -1;
                        }
                        defaultDownloadViewLP.setAbsorbColor(i);
                    }
                    yk0Var.t(a2);
                    if (!yk0Var.w() && (context instanceof Activity)) {
                        yk0Var.A(relativeLayout, yk0Var.v(), (Activity) context, optInt);
                    }
                }
                return true;
            }
            e(context, relativeLayout, optString, c2, optInt);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
