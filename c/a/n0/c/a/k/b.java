package c.a.n0.c.a.k;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.x1.c.h;
import c.a.n0.c.a.f;
import c.a.n0.c.a.g;
import c.a.n0.p.d.a;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
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
    public String f8149d;

    /* renamed from: e  reason: collision with root package name */
    public String f8150e;

    /* renamed from: f  reason: collision with root package name */
    public ResponseCallback<T> f8151f;

    /* renamed from: g  reason: collision with root package name */
    public int f8152g;

    /* renamed from: h  reason: collision with root package name */
    public a.C0751a f8153h;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8154b;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8154b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (c.a.n0.c.a.a.a) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str);
                }
                if (TextUtils.equals(str, "recovery")) {
                    if (!g.l().m().b()) {
                        this.f8154b.f8151f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    g.l().m().a();
                    this.f8154b.i(true);
                    this.f8154b.p();
                    return;
                }
                g.l().m().k();
                b bVar = this.f8154b;
                if (!bVar.a) {
                    if (bVar.f8151f != null) {
                        this.f8154b.f8151f.onSuccess(this.a, i);
                        this.f8154b.f8152g = 0;
                    }
                } else if (bVar.f8155b == 1) {
                    f.a(MimeTypes.BASE_TYPE_APPLICATION);
                    if (this.f8154b.f8151f != null) {
                        this.f8154b.f8151f.onSuccess(this.a, i);
                    }
                    this.f8154b.f8152g = 0;
                } else if (b.m(bVar) >= 3) {
                    ResponseCallback responseCallback = this.f8154b.f8151f;
                    responseCallback.onFail(new IOException("request fail : " + this.a));
                    this.f8154b.f8152g = 0;
                } else {
                    b bVar2 = this.f8154b;
                    bVar2.q(bVar2.f8149d, this.f8154b.f8150e, this.f8154b.f8151f);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (c.a.n0.c.a.a.a) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (this.f8154b.f8151f != null) {
                    this.f8154b.f8151f.onFail(exc);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                Headers headers = response.headers();
                String str = headers.get("Bdtls");
                if (headers != null && TextUtils.equals(str, "recovery")) {
                    g.l().m().s(0);
                    return "recovery";
                }
                b bVar = this.f8154b;
                if (!bVar.a) {
                    if (bVar.f8151f != null) {
                        this.a = (T) this.f8154b.f8151f.parseResponse(response, i);
                        return "";
                    }
                    return "";
                }
                ResponseBody body = response.body();
                String g2 = this.f8154b.g(body.bytes());
                if (c.a.n0.c.a.a.a) {
                    Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g2);
                }
                if (this.f8154b.f8155b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName(IMAudioTransRequest.CHARSET));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    if (this.f8154b.f8151f != null) {
                        this.a = (T) this.f8154b.f8151f.parseResponse(build, i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8149d = null;
        this.f8150e = null;
        this.f8151f = null;
    }

    public static /* synthetic */ int m(b bVar) {
        int i = bVar.f8152g;
        bVar.f8152g = i + 1;
        return i;
    }

    @Override // c.a.n0.c.a.k.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.c.a.k.c
    public void e(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) || (responseCallback = this.f8151f) == null) {
            return;
        }
        responseCallback.onFail(iOException);
    }

    @Override // c.a.n0.c.a.k.c
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (c.a.n0.c.a.a.a) {
                Log.d("BDTLS", "onRequestError=" + i);
            }
            ResponseCallback<T> responseCallback = this.f8151f;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i));
            }
        }
    }

    @Override // c.a.n0.c.a.k.c
    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.f8149d;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.a) {
                hashMap.put("Bdtls", "Bdtls");
            }
            if (c.a.n0.c.a.a.a) {
                Log.d("BDTLS", "BdtlsPostRequest url=" + str);
            }
            h a2 = c.a.n0.a.s0.a.q().a();
            PostByteRequest.PostByteRequestBuilder postByteRequest = c.a.n0.p.e.a.g().postByteRequest();
            a.C0751a c0751a = this.f8153h;
            if (c0751a != null) {
                postByteRequest.connectionTimeout(c0751a.a).readTimeout(this.f8153h.f9113b).writeTimeout(this.f8153h.f9114c);
            }
            postByteRequest.mediaType("application/json").url(str).cookieManager(a2).headers(hashMap).content(bArr).build().executeAsync(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q(this.f8149d, this.f8150e, this.f8151f);
        }
    }

    public void q(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, responseCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f8149d = str;
        this.f8150e = str2;
        this.f8151f = responseCallback;
        if (c.a.n0.c.a.a.a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f8150e);
    }
}
