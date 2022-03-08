package com.baidu.nadcore.download.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.e0.b;
import c.a.b0.j.d.d;
import c.a.b0.j.d.f;
import c.a.b0.j.d.g;
import c.a.b0.j.f.c;
import c.a.b0.s.t;
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
    public static final List<String> f35617b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends c.a.b0.u.p.c<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.j.d.a f35618b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f35619c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f35620d;

        public a(RelativeLayout relativeLayout, c.a.b0.j.d.a aVar, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativeLayout, aVar, context, str};
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
            this.f35618b = aVar;
            this.f35619c = context;
            this.f35620d = str;
        }

        @Override // c.a.b0.u.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.b0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, g gVar, int i2) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, gVar, i2) == null) || gVar == null) {
                return;
            }
            int i3 = gVar.a;
            if (i3 == 1) {
                LPDownloadManager.d(this.a, this.f35618b).o();
            } else if (i3 != 2 && i3 != 3) {
                b.a().b(this.f35619c, R.string.nad_download_lp_forbid_tip);
            } else if ((this.f35619c instanceof Activity) && (tVar = gVar.f1643b) != null) {
                LPDownloadManager.g(this.f35618b, tVar);
                LPDownloadManager.d(this.a, this.f35618b).x(gVar, (Activity) this.f35619c);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.s(ClogBuilder.LogType.FREE_SHOW).n(this.f35618b.n.a).q(ClogBuilder.Page.DOWNLOAD_RECTIFY).i(String.valueOf(gVar.a)).j(this.f35620d);
            c.a.b0.a0.a.b(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.b0.u.p.b
        /* renamed from: f */
        public g d(Headers headers, String str, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? g.a(c.a.b0.x.b.b(str).optJSONObject("data")) : (g) invokeLLI.objValue;
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
        f35617b = new ArrayList<String>() { // from class: com.baidu.nadcore.download.presenter.LPDownloadManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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

    public static c.a.b0.j.d.a c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject b2 = c.a.b0.x.b.b(str);
            String optString = b2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = b2.optString("lp_url", "");
            }
            c.a.b0.j.d.a query = c.a.b0.j.b.a.a().query(optString);
            if (query != null) {
                return query;
            }
            c.a.b0.j.d.a aVar = new c.a.b0.j.d.a();
            aVar.f1617g = b2.optString("url", "");
            aVar.g(optString);
            aVar.o.f1621b = b2.optString(Constant.KEY_BUSINESS);
            aVar.o.f1622c = b2.optString("content_type");
            aVar.o.f1623d = b2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            aVar.o.f1625f = b2.optInt("close_v_dl");
            aVar.n.a = b2.optString("log_ext");
            aVar.n.f1640j = b2.optString(LegoListActivityConfig.AD_ID);
            aVar.n.f1637g = b2.optString("app_icon");
            aVar.n.f1638h = b2.optString("app_name");
            return aVar;
        }
        return (c.a.b0.j.d.a) invokeL.objValue;
    }

    public static c d(RelativeLayout relativeLayout, c.a.b0.j.d.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, relativeLayout, aVar)) == null) {
            c cVar = new c(aVar, c.a.b0.j.j.c.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW));
            if (a == null) {
                a = new LruCache<>(32);
            }
            c.a.b0.x.c.e(a, aVar.d(), cVar);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull c.a.b0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, context, relativeLayout, str, aVar) == null) {
            for (String str2 : f35617b) {
                if (aVar.f1617g.startsWith(str2) || str.startsWith(str2)) {
                    d(relativeLayout, aVar).o();
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", aVar.n.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", aVar.f1617g);
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
            c.a.b0.j.d.a c2 = c(str);
            if (c2.e()) {
                return false;
            }
            String optString = c.a.b0.x.b.b(str).optString("lp_url", "");
            c cVar = (c) c.a.b0.x.c.b(a, c2.d());
            if (cVar != null && !cVar.w()) {
                if (z && c2.f1613c != AdDownloadStatus.DOWNLOADING) {
                    cVar.o();
                }
                return true;
            }
            e(context, relativeLayout, optString, c2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull c.a.b0.j.d.a aVar, @NonNull t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, aVar, tVar) == null) {
            aVar.f1617g = tVar.f1975j;
            d dVar = aVar.n;
            dVar.f1637g = tVar.f1967b;
            dVar.f1638h = tVar.f1968c;
        }
    }
}
