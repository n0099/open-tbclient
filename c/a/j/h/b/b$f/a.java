package c.a.j.h.b.b$f;

import android.text.TextUtils;
import c.a.j.h.b.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
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
public class a<T> extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f3717c;

    /* renamed from: d  reason: collision with root package name */
    public String f3718d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback<T> f3719e;

    /* renamed from: f  reason: collision with root package name */
    public int f3720f;

    /* renamed from: c.a.j.h.b.b$f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0166a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3721b;

        public C0166a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3721b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public String parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, response, i2)) == null) {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    b.h.b().i().b(0);
                    return "recovery";
                }
                a aVar = this.f3721b;
                if (!aVar.a) {
                    if (aVar.f3719e != null) {
                        this.a = (T) this.f3721b.f3719e.parseResponse(response, i2);
                        return "";
                    }
                    return "";
                }
                ResponseBody body = response.body();
                String g2 = this.f3721b.g(body.bytes());
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest parseResponse=" + g2);
                if (this.f3721b.f3722b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName("utf-8"));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    if (this.f3721b.f3719e != null) {
                        this.a = (T) this.f3721b.f3719e.parseResponse(build, i2);
                    }
                }
                return g2;
            }
            return (String) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest onSuccess=" + str);
                if (TextUtils.equals(str, "recovery")) {
                    if (!b.h.b().i().m()) {
                        this.f3721b.f3719e.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    b.h.b().i().f();
                    this.f3721b.e(true);
                    this.f3721b.k();
                    return;
                }
                b.h.b().i().n();
                a aVar = this.f3721b;
                if (!aVar.a) {
                    if (aVar.f3719e != null) {
                        this.f3721b.f3719e.onSuccess(this.a, i2);
                        this.f3721b.f3720f = 0;
                    }
                } else if (aVar.f3722b == 1) {
                    if (aVar.f3719e != null) {
                        this.f3721b.f3719e.onSuccess(this.a, i2);
                    }
                    this.f3721b.f3720f = 0;
                } else if (a.m(aVar) >= 3) {
                    ResponseCallback responseCallback = this.f3721b.f3719e;
                    responseCallback.onFail(new IOException("request fail : " + this.a));
                    this.f3721b.f3720f = 0;
                } else {
                    a aVar2 = this.f3721b;
                    aVar2.j(aVar2.f3717c, this.f3721b.f3718d, this.f3721b.f3719e);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest onFail=" + exc.getMessage());
                if (this.f3721b.f3719e != null) {
                    this.f3721b.f3719e.onFail(exc);
                }
            }
        }
    }

    public a() {
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
        this.f3717c = null;
        this.f3718d = null;
        this.f3719e = null;
    }

    public static /* synthetic */ int m(a aVar) {
        int i2 = aVar.f3720f;
        aVar.f3720f = i2 + 1;
        return i2;
    }

    @Override // c.a.j.h.b.b$f.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // c.a.j.h.b.b$f.b
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("onRequestError=" + i2);
            ResponseCallback<T> responseCallback = this.f3719e;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i2));
            }
        }
    }

    @Override // c.a.j.h.b.b$f.b
    public void c(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iOException) == null) || (responseCallback = this.f3719e) == null) {
            return;
        }
        responseCallback.onFail(iOException);
    }

    @Override // c.a.j.h.b.b$f.b
    public void f(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.f3717c;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.a) {
                hashMap.put("Bdtls", "Bdtls");
                hashMap.put("Bdtls-Content-Type", "json");
            }
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("BdtlsPostRequest url=" + str);
            HttpManager.getDefault(c.a.j.h.b.b.f3674c.h().getAppContext()).postByteRequest().mediaType("application/json").url(str).cookieManager(CookieManager.WEBKIT_COOKIES).headers(hashMap).content(bArr).build().executeAsync(new C0166a(this));
        }
    }

    public void j(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, responseCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f3717c = str;
        this.f3718d = str2;
        this.f3719e = responseCallback;
        DebugTrace debugTrace = DebugTrace.a;
        debugTrace.a("requestPost url=" + str);
        DebugTrace debugTrace2 = DebugTrace.a;
        debugTrace2.a("requestPost body=" + str2);
        d(this.f3718d);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j(this.f3717c, this.f3718d, this.f3719e);
        }
    }
}
