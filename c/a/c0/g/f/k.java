package c.a.c0.g.f;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.p.p;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.LruCache;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public static LruCache<String, c> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.c0.r.p.c<c.a.c0.g.d.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.g.d.a f1560b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f1561c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1562d;

        public a(RelativeLayout relativeLayout, c.a.c0.g.d.a aVar, Context context, String str) {
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
            this.f1560b = aVar;
            this.f1561c = context;
            this.f1562d = str;
        }

        @Override // c.a.c0.r.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.c0.r.p.b
        /* renamed from: e */
        public void b(Headers headers, c.a.c0.g.d.g gVar, int i2) {
            p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, gVar, i2) == null) || gVar == null) {
                return;
            }
            int i3 = gVar.a;
            if (i3 == 1) {
                k.d(this.a, this.f1560b).o();
            } else if (i3 != 2 && i3 != 3) {
                c.a.c0.b0.b.a().b(this.f1561c, c.a.c0.c0.g.nad_download_lp_forbid_tip);
            } else if ((this.f1561c instanceof Activity) && (pVar = gVar.f1545b) != null) {
                k.g(this.f1560b, pVar);
                k.d(this.a, this.f1560b).x(gVar, (Activity) this.f1561c);
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.r(ClogBuilder.LogType.FREE_SHOW).m(this.f1560b.n.a).p(ClogBuilder.Page.DOWNLOAD_RECTIFY).h(String.valueOf(gVar.a)).i(this.f1562d);
            c.a.c0.x.a.b(clogBuilder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.c0.r.p.b
        /* renamed from: f */
        public c.a.c0.g.d.g d(Headers headers, String str, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? c.a.c0.g.d.g.a(c.a.c0.u.b.b(str).optJSONObject("data")) : (c.a.c0.g.d.g) invokeLLI.objValue;
        }
    }

    public static c.a.c0.g.d.a c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            JSONObject b2 = c.a.c0.u.b.b(str);
            String optString = b2.optString("key", "");
            if (TextUtils.isEmpty(optString)) {
                optString = b2.optString("lp_url", "");
            }
            c.a.c0.g.d.a query = c.a.c0.g.b.a.a().query(optString);
            if (query != null) {
                return query;
            }
            c.a.c0.g.d.a aVar = new c.a.c0.g.d.a();
            aVar.f1517g = b2.optString("url", "");
            aVar.g(optString);
            aVar.o.f1522b = b2.optString(Constant.KEY_BUSINESS);
            aVar.o.f1523c = b2.optString("content_type");
            aVar.o.f1524d = b2.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            aVar.o.f1526f = b2.optInt("close_v_dl");
            aVar.n.a = b2.optString("log_ext");
            aVar.n.f1542j = b2.optString(LegoListActivityConfig.AD_ID);
            aVar.n.f1539g = b2.optString("app_icon");
            aVar.n.f1540h = b2.optString("app_name");
            return aVar;
        }
        return (c.a.c0.g.d.a) invokeL.objValue;
    }

    public static c d(RelativeLayout relativeLayout, c.a.c0.g.d.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, relativeLayout, aVar)) == null) {
            c cVar = new c(aVar, c.a.c0.g.j.c.a(relativeLayout, IDownloadViewCreator.ViewType.LP_DOWNLOAD_VIEW));
            if (a == null) {
                a = new LruCache<>(32);
            }
            c.a.c0.u.c.e(a, aVar.d(), cVar);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public static void e(@NonNull Context context, @NonNull RelativeLayout relativeLayout, String str, @NonNull c.a.c0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, relativeLayout, str, aVar) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ext", aVar.n.a);
            linkedHashMap.put("charge_url", str);
            linkedHashMap.put("apk_url", aVar.f1517g);
            new c.a.c0.g.d.f().b(linkedHashMap, new a(relativeLayout, aVar, context, str));
        }
    }

    public static boolean f(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, relativeLayout, str, Boolean.valueOf(z)})) == null) {
            if (context == null || relativeLayout == null || TextUtils.isEmpty(str)) {
                return false;
            }
            c.a.c0.g.d.a c2 = c(str);
            if (c2.e()) {
                return false;
            }
            String optString = c.a.c0.u.b.b(str).optString("lp_url", "");
            c cVar = (c) c.a.c0.u.c.b(a, c2.d());
            if (cVar != null && !cVar.w()) {
                if (z && c2.f1513c != AdDownloadStatus.DOWNLOADING) {
                    cVar.o();
                }
                return true;
            }
            e(context, relativeLayout, optString, c2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull c.a.c0.g.d.a aVar, @NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, aVar, pVar) == null) {
            String str = pVar.f1837j;
            aVar.f1517g = str;
            aVar.g(str);
            c.a.c0.g.d.d dVar = aVar.n;
            dVar.f1539g = pVar.f1829b;
            dVar.f1540h = pVar.f1830c;
        }
    }
}
