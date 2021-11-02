package b.a.p0.c.a.k;

import android.text.TextUtils;
import b.a.p0.a.e2.c.h;
import b.a.p0.c.a.f;
import b.a.p0.c.a.g;
import b.a.p0.m.d.a;
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
    public String f9590d;

    /* renamed from: e  reason: collision with root package name */
    public String f9591e;

    /* renamed from: f  reason: collision with root package name */
    public ResponseCallback<T> f9592f;

    /* renamed from: g  reason: collision with root package name */
    public int f9593g;

    /* renamed from: h  reason: collision with root package name */
    public a.C0613a f9594h;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f9595a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f9596b;

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
            this.f9596b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (b.a.p0.c.a.a.f9542a) {
                    r0 = "BdtlsPostRequest onSuccess=" + str;
                }
                if (TextUtils.equals(str, "recovery")) {
                    if (!g.l().m().b()) {
                        this.f9596b.f9592f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    g.l().m().a();
                    this.f9596b.i(true);
                    this.f9596b.p();
                    return;
                }
                g.l().m().k();
                b bVar = this.f9596b;
                if (!bVar.f9597a) {
                    if (bVar.f9592f != null) {
                        this.f9596b.f9592f.onSuccess(this.f9595a, i2);
                        this.f9596b.f9593g = 0;
                    }
                } else if (bVar.f9598b == 1) {
                    f.a("application");
                    if (this.f9596b.f9592f != null) {
                        this.f9596b.f9592f.onSuccess(this.f9595a, i2);
                    }
                    this.f9596b.f9593g = 0;
                } else if (b.m(bVar) >= 3) {
                    this.f9596b.f9592f.onFail(new IOException("request fail : " + this.f9595a));
                    this.f9596b.f9593g = 0;
                } else {
                    b bVar2 = this.f9596b;
                    bVar2.q(bVar2.f9590d, this.f9596b.f9591e, this.f9596b.f9592f);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (b.a.p0.c.a.a.f9542a) {
                    String str = "BdtlsPostRequest onFail=" + exc.getMessage();
                }
                if (this.f9596b.f9592f != null) {
                    this.f9596b.f9592f.onFail(exc);
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
                b bVar = this.f9596b;
                if (!bVar.f9597a) {
                    if (bVar.f9592f != null) {
                        this.f9595a = (T) this.f9596b.f9592f.parseResponse(response, i2);
                        return "";
                    }
                    return "";
                }
                ResponseBody body = response.body();
                String g2 = this.f9596b.g(body.bytes());
                if (b.a.p0.c.a.a.f9542a) {
                    String str2 = "BdtlsPostRequest parseResponse=" + g2;
                }
                if (this.f9596b.f9598b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName("utf-8"));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    if (this.f9596b.f9592f != null) {
                        this.f9595a = (T) this.f9596b.f9592f.parseResponse(build, i2);
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
        this.f9590d = null;
        this.f9591e = null;
        this.f9592f = null;
    }

    public static /* synthetic */ int m(b bVar) {
        int i2 = bVar.f9593g;
        bVar.f9593g = i2 + 1;
        return i2;
    }

    @Override // b.a.p0.c.a.k.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.c.a.k.c
    public void e(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) || (responseCallback = this.f9592f) == null) {
            return;
        }
        responseCallback.onFail(iOException);
    }

    @Override // b.a.p0.c.a.k.c
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (b.a.p0.c.a.a.f9542a) {
                String str = "onRequestError=" + i2;
            }
            ResponseCallback<T> responseCallback = this.f9592f;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i2));
            }
        }
    }

    @Override // b.a.p0.c.a.k.c
    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.f9590d;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.f9597a) {
                hashMap.put("Bdtls", "Bdtls");
            }
            if (b.a.p0.c.a.a.f9542a) {
                String str2 = "BdtlsPostRequest url=" + str;
            }
            h a2 = b.a.p0.a.c1.a.p().a();
            PostByteRequest.PostByteRequestBuilder postByteRequest = b.a.p0.m.e.a.g().postByteRequest();
            a.C0613a c0613a = this.f9594h;
            if (c0613a != null) {
                postByteRequest.connectionTimeout(c0613a.f11042a).readTimeout(this.f9594h.f11043b).writeTimeout(this.f9594h.f11044c);
            }
            postByteRequest.mediaType("application/json").url(str).cookieManager(a2).headers(hashMap).content(bArr).build().executeAsync(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q(this.f9590d, this.f9591e, this.f9592f);
        }
    }

    public void q(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, responseCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f9590d = str;
        this.f9591e = str2;
        this.f9592f = responseCallback;
        if (b.a.p0.c.a.a.f9542a) {
            String str3 = "requestPost url=" + str;
            String str4 = "requestPost body=" + str2;
        }
        a(this.f9591e);
    }
}
