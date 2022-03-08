package c.a.p0.q.i;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static CookieManager a;

    /* renamed from: b  reason: collision with root package name */
    public static String f10965b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.q.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0759a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f10966b;

        public C0759a(Map map, e eVar) {
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
            this.a = map;
            this.f10966b = eVar;
        }

        @Override // c.a.p0.q.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                PostByteRequest.PostByteRequestBuilder postByteRequest = c.a.p0.p.e.a.g().postByteRequest();
                c.a.p0.q.d.a(postByteRequest, this.a);
                postByteRequest.url(f.j(str, this.a)).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
                if (map != null) {
                    postByteRequest.addHeaders(map);
                }
                if (!TextUtils.isEmpty(a.f10965b)) {
                    postByteRequest.userAgent(a.f10965b);
                }
                postByteRequest.cookieManager(a.a).enableStat(true).build().executeStat(this.f10966b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f10967b;

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
            this.a = map;
            this.f10967b = eVar;
        }

        @Override // c.a.p0.q.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                GetRequest.GetRequestBuilder requestSubFrom = c.a.p0.p.e.a.g().getRequest().url(f.j(str, this.a)).requestSubFrom(10);
                if (!TextUtils.isEmpty(a.f10965b)) {
                    requestSubFrom.userAgent(a.f10965b);
                }
                if (map != null) {
                    requestSubFrom.addHeaders(map);
                }
                requestSubFrom.cookieManager(a.a).enableStat(true).build().executeStat(this.f10967b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-900956985, "Lc/a/p0/q/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-900956985, "Lc/a/p0/q/i/a;");
                return;
            }
        }
        a = c.a.p0.q.c.b().f();
        c.a.p0.p.a b2 = c.a.p0.p.b.b();
        if (b2 == null || !c.a.p0.p.e.a.g().c()) {
            return;
        }
        f10965b = b2.a();
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
        c.a.p0.q.a b2 = c.a.p0.q.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.j(str, map), null, new b(map, eVar));
            return;
        }
        GetRequest.GetRequestBuilder requestSubFrom = c.a.p0.p.e.a.g().getRequest().url(f.j(str, map)).requestSubFrom(10);
        if (!TextUtils.isEmpty(f10965b)) {
            requestSubFrom.userAgent(f10965b);
        }
        if (map2 != null) {
            requestSubFrom.addHeaders(map2);
        }
        requestSubFrom.cookieManager(a).enableStat(true).build().executeStat(eVar);
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
        c.a.p0.q.a b2 = c.a.p0.q.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.j(str, map), jSONObject.toString(), new C0759a(map, eVar));
            return;
        }
        c.a.p0.p.c.h postStringRequest = c.a.p0.p.e.a.g().postStringRequest();
        c.a.p0.q.d.a(postStringRequest, map);
        postStringRequest.url(f.j(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
        if (map2 != null) {
            postStringRequest.addHeaders(map2);
        }
        if (!TextUtils.isEmpty(f10965b)) {
            postStringRequest.userAgent(f10965b);
        }
        postStringRequest.cookieManager(a).enableStat(true).build().executeStat(eVar);
    }
}
