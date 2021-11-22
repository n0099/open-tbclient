package b.a.p0.q.j;

import android.annotation.SuppressLint;
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
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CookieManager f11777a;

    /* renamed from: b  reason: collision with root package name */
    public static String f11778b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.q.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0645a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f11779a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f11780b;

        public C0645a(Map map, e eVar) {
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
            this.f11779a = map;
            this.f11780b = eVar;
        }

        @Override // b.a.p0.q.j.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                PostByteRequest.PostByteRequestBuilder postByteRequest = b.a.p0.p.e.a.g().postByteRequest();
                b.a.p0.q.d.a(postByteRequest, this.f11779a);
                postByteRequest.url(f.j(str, this.f11779a)).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
                if (map != null) {
                    postByteRequest.addHeaders(map);
                }
                if (!TextUtils.isEmpty(a.f11778b)) {
                    postByteRequest.userAgent(a.f11778b);
                }
                postByteRequest.cookieManager(a.f11777a).enableStat(true).build().executeStat(this.f11780b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f11781a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f11782b;

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
            this.f11781a = map;
            this.f11782b = eVar;
        }

        @Override // b.a.p0.q.j.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                GetRequest.GetRequestBuilder requestSubFrom = b.a.p0.p.e.a.g().getRequest().url(f.j(str, this.f11781a)).requestSubFrom(10);
                if (!TextUtils.isEmpty(a.f11778b)) {
                    requestSubFrom.userAgent(a.f11778b);
                }
                if (map != null) {
                    requestSubFrom.addHeaders(map);
                }
                requestSubFrom.cookieManager(a.f11777a).enableStat(true).build().executeStat(this.f11782b);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-607524187, "Lb/a/p0/q/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-607524187, "Lb/a/p0/q/j/a;");
                return;
            }
        }
        f11777a = b.a.p0.q.c.b().f();
        b.a.p0.p.a b2 = b.a.p0.p.b.b();
        if (b2 == null || !b.a.p0.p.e.a.g().c()) {
            return;
        }
        f11778b = b2.a();
    }

    @SuppressLint({"BDThrowableCheck"})
    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, str, map, map2, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (eVar != null) {
            eVar.onStart();
        }
        b.a.p0.q.a b2 = b.a.p0.q.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.j(str, map), null, new b(map, eVar));
            return;
        }
        GetRequest.GetRequestBuilder requestSubFrom = b.a.p0.p.e.a.g().getRequest().url(f.j(str, map)).requestSubFrom(10);
        if (!TextUtils.isEmpty(f11778b)) {
            requestSubFrom.userAgent(f11778b);
        }
        if (map2 != null) {
            requestSubFrom.addHeaders(map2);
        }
        requestSubFrom.cookieManager(f11777a).enableStat(true).build().executeStat(eVar);
    }

    @SuppressLint({"BDThrowableCheck"})
    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65538, null, str, map, map2, jSONObject, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (eVar != null) {
            eVar.onStart();
        }
        b.a.p0.q.a b2 = b.a.p0.q.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.j(str, map), jSONObject.toString(), new C0645a(map, eVar));
            return;
        }
        b.a.p0.p.c.h postStringRequest = b.a.p0.p.e.a.g().postStringRequest();
        b.a.p0.q.d.a(postStringRequest, map);
        postStringRequest.url(f.j(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
        if (map2 != null) {
            postStringRequest.addHeaders(map2);
        }
        if (!TextUtils.isEmpty(f11778b)) {
            postStringRequest.userAgent(f11778b);
        }
        postStringRequest.cookieManager(f11777a).enableStat(true).build().executeStat(eVar);
    }
}
