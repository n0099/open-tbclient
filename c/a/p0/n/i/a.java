package c.a.p0.n.i;

import android.text.TextUtils;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11889a;

    /* renamed from: b  reason: collision with root package name */
    public static CookieManager f11890b;

    /* renamed from: c  reason: collision with root package name */
    public static String f11891c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.n.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0621a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f11892a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f11893b;

        public C0621a(Map map, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11892a = map;
            this.f11893b = eVar;
        }

        @Override // c.a.p0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                PostByteRequest.PostByteRequestBuilder postByteRequest = c.a.p0.m.e.a.g().postByteRequest();
                c.a.p0.n.d.a(postByteRequest, this.f11892a);
                postByteRequest.url(f.i(str, this.f11892a)).content(bArr).mediaType(MediaType.parse("application/json; charset=utf-8")).requestFrom(6).requestSubFrom(10);
                if (map != null) {
                    postByteRequest.addHeaders(map);
                }
                if (!TextUtils.isEmpty(a.f11891c)) {
                    postByteRequest.userAgent(a.f11891c);
                }
                postByteRequest.cookieManager(a.f11890b).enableStat(true).build().executeStat(this.f11893b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f11894a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f11895b;

        public b(Map map, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11894a = map;
            this.f11895b = eVar;
        }

        @Override // c.a.p0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                GetRequest.GetRequestBuilder requestSubFrom = c.a.p0.m.e.a.g().getRequest().url(f.i(str, this.f11894a)).requestSubFrom(10);
                if (!TextUtils.isEmpty(a.f11891c)) {
                    requestSubFrom.userAgent(a.f11891c);
                }
                if (map != null) {
                    requestSubFrom.addHeaders(map);
                }
                requestSubFrom.cookieManager(a.f11890b).enableStat(true).build().executeStat(this.f11895b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-986844438, "Lc/a/p0/n/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-986844438, "Lc/a/p0/n/i/a;");
                return;
            }
        }
        f11889a = c.a.p0.n.c.f11856a;
        f11890b = c.a.p0.n.c.b().g();
        c.a.p0.m.a b2 = c.a.p0.m.b.b();
        if (b2 == null || !c.a.p0.m.e.a.g().c()) {
            return;
        }
        f11891c = b2.a();
    }

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, str, map, map2, eVar) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f11889a) {
                    throw new InvalidParameterException("PMS request URL is empty");
                }
                return;
            }
            if (eVar != null) {
                eVar.onStart();
            }
            c.a.p0.n.a b2 = c.a.p0.n.c.b();
            if (PMSConstants.a(b2)) {
                b2.m(f.i(str, map), null, new b(map, eVar));
                return;
            }
            GetRequest.GetRequestBuilder requestSubFrom = c.a.p0.m.e.a.g().getRequest().url(f.i(str, map)).requestSubFrom(10);
            if (!TextUtils.isEmpty(f11891c)) {
                requestSubFrom.userAgent(f11891c);
            }
            if (map2 != null) {
                requestSubFrom.addHeaders(map2);
            }
            requestSubFrom.cookieManager(f11890b).enableStat(true).build().executeStat(eVar);
        }
    }

    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, str, map, map2, jSONObject, eVar) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f11889a) {
                    throw new InvalidParameterException("PMS request URL is empty");
                }
                return;
            }
            if (eVar != null) {
                eVar.onStart();
            }
            c.a.p0.n.a b2 = c.a.p0.n.c.b();
            if (PMSConstants.a(b2)) {
                b2.m(f.i(str, map), jSONObject.toString(), new C0621a(map, eVar));
                return;
            }
            c.a.p0.m.c.h postStringRequest = c.a.p0.m.e.a.g().postStringRequest();
            c.a.p0.n.d.a(postStringRequest, map);
            postStringRequest.url(f.i(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse("application/json; charset=utf-8")).requestFrom(6).requestSubFrom(10);
            if (map2 != null) {
                postStringRequest.addHeaders(map2);
            }
            if (!TextUtils.isEmpty(f11891c)) {
                postStringRequest.userAgent(f11891c);
            }
            postStringRequest.cookieManager(f11890b).enableStat(true).build().executeStat(eVar);
        }
    }
}
