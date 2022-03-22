package com.baidu.nadcore.download.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.e0.b;
import c.a.a0.j.d.d;
import c.a.a0.j.d.f;
import c.a.a0.j.d.g;
import c.a.a0.j.f.c;
import c.a.a0.s.t;
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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LPDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public static LruCache<String, c> a;

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f27497b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends c.a.a0.u.p.c<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.a0.j.d.a f27498b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f27499c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f27500d;

        public a(RelativeLayout relativeLayout, c.a.a0.j.d.a aVar, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, aVar, context, str};
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
            this.f27498b = aVar;
            this.f27499c = context;
            this.f27500d = str;
        }

        @Override // c.a.a0.u.p.a
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, g gVar, int i) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, gVar, i) == null) || gVar == null) {
                return;
            }
            int i2 = gVar.a;
            if (i2 == 1) {
                LPDownloadManager.d(this.a, this.f27498b).p();
            } else if (i2 != 2 && i2 != 3) {
                b.a().b(this.f27499c, R.string.obfuscated_res_0x7f0f0b78);
            } else if ((this.f27499c instanceof Activity) && (tVar = gVar.f1270b) != null) {
                LPDownloadManager.g(this.f27498b, tVar);
                LPDownloadManager.d(this.a, this.f27498b).y(gVar, (Activity) this.f27499c);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.s(ClogBuilder.LogType.FREE_SHOW).n(this.f27498b.n.a).q(ClogBuilder.Page.DOWNLOAD_RECTIFY).i(String.valueOf(gVar.a)).j(this.f27500d);
            c.a.a0.a0.a.b(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.u.p.b
        /* renamed from: f */
        public g d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? g.a(c.a.a0.x.b.b(str).optJSONObject("data")) : (g) invokeLLI.objValue;
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
        f27497b = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
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

    public static c.a.a0.j.d.a c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject b2 = c.a.a0.x.b.b(str);
            String optString = b2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = b2.optString("lp_url", "");
            }
            c.a.a0.j.d.a query = c.a.a0.j.b.a.a().query(optString);
            if (query != null) {
                return query;
            }
            c.a.a0.j.d.a aVar = new c.a.a0.j.d.a();
            aVar.f1250g = b2.optString("url", "");
            aVar.g(optString);
            aVar.o.f1252b = b2.optString(Constant.KEY_BUSINESS);
            aVar.o.f1253c = b2.optString("content_type");
            aVar.o.f1254d = b2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            aVar.o.f1256f = b2.optInt("close_v_dl");
            aVar.n.a = b2.optString("log_ext");
            aVar.n.j = b2.optString(LegoListActivityConfig.AD_ID);
            aVar.n.f1266g = b2.optString("app_icon");
            aVar.n.f1267h = b2.optString("app_name");
            return aVar;
        }
        return (c.a.a0.j.d.a) invokeL.objValue;
    }

    public static c d(RelativeLayout relativeLayout, c.a.a0.j.d.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, aVar)) == null) {
            c cVar = new c(aVar, c.a.a0.j.j.c.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW));
            if (a == null) {
                a = new LruCache<>(32);
            }
            c.a.a0.x.c.e(a, aVar.d(), cVar);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull c.a.a0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, context, relativeLayout, str, aVar) == null) {
            for (String str2 : f27497b) {
                if (aVar.f1250g.startsWith(str2) || str.startsWith(str2)) {
                    d(relativeLayout, aVar).p();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", aVar.n.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", aVar.f1250g);
            new f().b(linkedHashMap, new a(relativeLayout, aVar, context, str));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            c.a.a0.j.d.a c2 = c(str);
            if (c2.e()) {
                return false;
            }
            String optString = c.a.a0.x.b.b(str).optString("lp_url", "");
            c cVar = (c) c.a.a0.x.c.b(a, c2.d());
            if (cVar != null && !cVar.x()) {
                if (z && c2.f1246c != AdDownloadStatus.DOWNLOADING) {
                    cVar.p();
                }
                return true;
            }
            e(context, relativeLayout, optString, c2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull c.a.a0.j.d.a aVar, @NonNull t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, aVar, tVar) == null) {
            aVar.f1250g = tVar.j;
            d dVar = aVar.n;
            dVar.f1266g = tVar.f1586b;
            dVar.f1267h = tVar.f1587c;
        }
    }
}
