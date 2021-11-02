package b.a.p0.n.i;

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
import com.baidubce.AbstractBceClient;
import java.security.InvalidParameterException;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11079a;

    /* renamed from: b  reason: collision with root package name */
    public static CookieManager f11080b;

    /* renamed from: c  reason: collision with root package name */
    public static String f11081c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.n.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0616a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f11082a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f11083b;

        public C0616a(Map map, e eVar) {
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
            this.f11082a = map;
            this.f11083b = eVar;
        }

        @Override // b.a.p0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                PostByteRequest.PostByteRequestBuilder postByteRequest = b.a.p0.m.e.a.g().postByteRequest();
                b.a.p0.n.d.a(postByteRequest, this.f11082a);
                postByteRequest.url(f.i(str, this.f11082a)).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
                if (map != null) {
                    postByteRequest.addHeaders(map);
                }
                if (!TextUtils.isEmpty(a.f11081c)) {
                    postByteRequest.userAgent(a.f11081c);
                }
                postByteRequest.cookieManager(a.f11080b).enableStat(true).build().executeStat(this.f11083b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f11084a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f11085b;

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
            this.f11084a = map;
            this.f11085b = eVar;
        }

        @Override // b.a.p0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                GetRequest.GetRequestBuilder requestSubFrom = b.a.p0.m.e.a.g().getRequest().url(f.i(str, this.f11084a)).requestSubFrom(10);
                if (!TextUtils.isEmpty(a.f11081c)) {
                    requestSubFrom.userAgent(a.f11081c);
                }
                if (map != null) {
                    requestSubFrom.addHeaders(map);
                }
                requestSubFrom.cookieManager(a.f11080b).enableStat(true).build().executeStat(this.f11085b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-693441431, "Lb/a/p0/n/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-693441431, "Lb/a/p0/n/i/a;");
                return;
            }
        }
        f11079a = b.a.p0.n.c.f11048a;
        f11080b = b.a.p0.n.c.b().g();
        b.a.p0.m.a b2 = b.a.p0.m.b.b();
        if (b2 == null || !b.a.p0.m.e.a.g().c()) {
            return;
        }
        f11081c = b2.a();
    }

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, str, map, map2, eVar) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f11079a) {
                    throw new InvalidParameterException("PMS request URL is empty");
                }
                return;
            }
            if (eVar != null) {
                eVar.onStart();
            }
            b.a.p0.n.a b2 = b.a.p0.n.c.b();
            if (PMSConstants.a(b2)) {
                b2.m(f.i(str, map), null, new b(map, eVar));
                return;
            }
            GetRequest.GetRequestBuilder requestSubFrom = b.a.p0.m.e.a.g().getRequest().url(f.i(str, map)).requestSubFrom(10);
            if (!TextUtils.isEmpty(f11081c)) {
                requestSubFrom.userAgent(f11081c);
            }
            if (map2 != null) {
                requestSubFrom.addHeaders(map2);
            }
            requestSubFrom.cookieManager(f11080b).enableStat(true).build().executeStat(eVar);
        }
    }

    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, str, map, map2, jSONObject, eVar) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f11079a) {
                    throw new InvalidParameterException("PMS request URL is empty");
                }
                return;
            }
            if (eVar != null) {
                eVar.onStart();
            }
            b.a.p0.n.a b2 = b.a.p0.n.c.b();
            if (PMSConstants.a(b2)) {
                b2.m(f.i(str, map), jSONObject.toString(), new C0616a(map, eVar));
                return;
            }
            b.a.p0.m.c.h postStringRequest = b.a.p0.m.e.a.g().postStringRequest();
            b.a.p0.n.d.a(postStringRequest, map);
            postStringRequest.url(f.i(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
            if (map2 != null) {
                postStringRequest.addHeaders(map2);
            }
            if (!TextUtils.isEmpty(f11081c)) {
                postStringRequest.userAgent(f11081c);
            }
            postStringRequest.cookieManager(f11080b).enableStat(true).build().executeStat(eVar);
        }
    }
}
