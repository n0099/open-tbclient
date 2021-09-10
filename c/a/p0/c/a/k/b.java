package c.a.p0.c.a.k;

import android.text.TextUtils;
import c.a.p0.a.e2.c.h;
import c.a.p0.c.a.f;
import c.a.p0.c.a.g;
import c.a.p0.m.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* loaded from: classes.dex */
public class b<T> extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f10361d;

    /* renamed from: e  reason: collision with root package name */
    public String f10362e;

    /* renamed from: f  reason: collision with root package name */
    public ResponseCallback<T> f10363f;

    /* renamed from: g  reason: collision with root package name */
    public int f10364g;

    /* renamed from: h  reason: collision with root package name */
    public a.C0618a f10365h;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f10366a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f10367b;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10367b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (c.a.p0.c.a.a.f10311a) {
                    r0 = "BdtlsPostRequest onSuccess=" + str;
                }
                if (TextUtils.equals(str, "recovery")) {
                    if (!g.l().m().b()) {
                        this.f10367b.f10363f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    g.l().m().a();
                    this.f10367b.i(true);
                    this.f10367b.p();
                    return;
                }
                g.l().m().k();
                b bVar = this.f10367b;
                if (!bVar.f10368a) {
                    if (bVar.f10363f != null) {
                        this.f10367b.f10363f.onSuccess(this.f10366a, i2);
                        this.f10367b.f10364g = 0;
                    }
                } else if (bVar.f10369b == 1) {
                    f.a("application");
                    if (this.f10367b.f10363f != null) {
                        this.f10367b.f10363f.onSuccess(this.f10366a, i2);
                    }
                    this.f10367b.f10364g = 0;
                } else if (b.m(bVar) >= 3) {
                    this.f10367b.f10363f.onFail(new IOException("request fail : " + this.f10366a));
                    this.f10367b.f10364g = 0;
                } else {
                    b bVar2 = this.f10367b;
                    bVar2.q(bVar2.f10361d, this.f10367b.f10362e, this.f10367b.f10363f);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (c.a.p0.c.a.a.f10311a) {
                    String str = "BdtlsPostRequest onFail=" + exc.getMessage();
                }
                if (this.f10367b.f10363f != null) {
                    this.f10367b.f10363f.onFail(exc);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                Headers headers = response.headers();
                String str = headers.get("Bdtls");
                if (headers != null && TextUtils.equals(str, "recovery")) {
                    g.l().m().s(0);
                    return "recovery";
                }
                b bVar = this.f10367b;
                if (!bVar.f10368a) {
                    if (bVar.f10363f != null) {
                        this.f10366a = (T) this.f10367b.f10363f.parseResponse(response, i2);
                        return "";
                    }
                    return "";
                }
                ResponseBody body = response.body();
                String g2 = this.f10367b.g(body.bytes());
                if (c.a.p0.c.a.a.f10311a) {
                    String str2 = "BdtlsPostRequest parseResponse=" + g2;
                }
                if (this.f10367b.f10369b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName("utf-8"));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    if (this.f10367b.f10363f != null) {
                        this.f10366a = (T) this.f10367b.f10363f.parseResponse(build, i2);
                    }
                }
                return g2;
            }
            return (String) invokeLI.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10361d = null;
        this.f10362e = null;
        this.f10363f = null;
    }

    public static /* synthetic */ int m(b bVar) {
        int i2 = bVar.f10364g;
        bVar.f10364g = i2 + 1;
        return i2;
    }

    @Override // c.a.p0.c.a.k.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.c.a.k.c
    public void e(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) || (responseCallback = this.f10363f) == null) {
            return;
        }
        responseCallback.onFail(iOException);
    }

    @Override // c.a.p0.c.a.k.c
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (c.a.p0.c.a.a.f10311a) {
                String str = "onRequestError=" + i2;
            }
            ResponseCallback<T> responseCallback = this.f10363f;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i2));
            }
        }
    }

    @Override // c.a.p0.c.a.k.c
    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.f10361d;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.f10368a) {
                hashMap.put("Bdtls", "Bdtls");
            }
            if (c.a.p0.c.a.a.f10311a) {
                String str2 = "BdtlsPostRequest url=" + str;
            }
            h a2 = c.a.p0.a.c1.a.p().a();
            PostByteRequest.PostByteRequestBuilder postByteRequest = c.a.p0.m.e.a.g().postByteRequest();
            a.C0618a c0618a = this.f10365h;
            if (c0618a != null) {
                postByteRequest.connectionTimeout(c0618a.f11850a).readTimeout(this.f10365h.f11851b).writeTimeout(this.f10365h.f11852c);
            }
            postByteRequest.mediaType("application/json").url(str).cookieManager(a2).headers(hashMap).content(bArr).build().executeAsync(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q(this.f10361d, this.f10362e, this.f10363f);
        }
    }

    public void q(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, responseCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f10361d = str;
        this.f10362e = str2;
        this.f10363f = responseCallback;
        if (c.a.p0.c.a.a.f10311a) {
            String str3 = "requestPost url=" + str;
            String str4 = "requestPost body=" + str2;
        }
        a(this.f10362e);
    }
}
