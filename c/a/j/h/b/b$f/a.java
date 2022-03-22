package c.a.j.h.b.b$f;

import android.text.TextUtils;
import c.a.j.h.b.b;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
    public String f3202c;

    /* renamed from: d  reason: collision with root package name */
    public String f3203d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback<T> f3204e;

    /* renamed from: f  reason: collision with root package name */
    public int f3205f;

    /* renamed from: c.a.j.h.b.b$f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0172a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3206b;

        public C0172a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3206b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public String parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, response, i)) == null) {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    b.h.b().i().b(0);
                    return "recovery";
                }
                a aVar = this.f3206b;
                if (!aVar.a) {
                    if (aVar.f3204e != null) {
                        this.a = (T) this.f3206b.f3204e.parseResponse(response, i);
                        return "";
                    }
                    return "";
                }
                ResponseBody body = response.body();
                String g2 = this.f3206b.g(body.bytes());
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest parseResponse=" + g2);
                if (this.f3206b.f3207b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName(IMAudioTransRequest.CHARSET));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    if (this.f3206b.f3204e != null) {
                        this.a = (T) this.f3206b.f3204e.parseResponse(build, i);
                    }
                }
                return g2;
            }
            return (String) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest onSuccess=" + str);
                if (TextUtils.equals(str, "recovery")) {
                    if (!b.h.b().i().m()) {
                        this.f3206b.f3204e.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    b.h.b().i().f();
                    this.f3206b.e(true);
                    this.f3206b.k();
                    return;
                }
                b.h.b().i().n();
                a aVar = this.f3206b;
                if (!aVar.a) {
                    if (aVar.f3204e != null) {
                        this.f3206b.f3204e.onSuccess(this.a, i);
                        this.f3206b.f3205f = 0;
                    }
                } else if (aVar.f3207b == 1) {
                    if (aVar.f3204e != null) {
                        this.f3206b.f3204e.onSuccess(this.a, i);
                    }
                    this.f3206b.f3205f = 0;
                } else if (a.m(aVar) >= 3) {
                    ResponseCallback responseCallback = this.f3206b.f3204e;
                    responseCallback.onFail(new IOException("request fail : " + this.a));
                    this.f3206b.f3205f = 0;
                } else {
                    a aVar2 = this.f3206b;
                    aVar2.j(aVar2.f3202c, this.f3206b.f3203d, this.f3206b.f3204e);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest onFail=" + exc.getMessage());
                if (this.f3206b.f3204e != null) {
                    this.f3206b.f3204e.onFail(exc);
                }
            }
        }
    }

    public a() {
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
        this.f3202c = null;
        this.f3203d = null;
        this.f3204e = null;
    }

    public static /* synthetic */ int m(a aVar) {
        int i = aVar.f3205f;
        aVar.f3205f = i + 1;
        return i;
    }

    @Override // c.a.j.h.b.b$f.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // c.a.j.h.b.b$f.b
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("onRequestError=" + i);
            ResponseCallback<T> responseCallback = this.f3204e;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i));
            }
        }
    }

    @Override // c.a.j.h.b.b$f.b
    public void c(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iOException) == null) || (responseCallback = this.f3204e) == null) {
            return;
        }
        responseCallback.onFail(iOException);
    }

    @Override // c.a.j.h.b.b$f.b
    public void f(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.f3202c;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.a) {
                hashMap.put("Bdtls", "Bdtls");
                hashMap.put("Bdtls-Content-Type", "json");
            }
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("BdtlsPostRequest url=" + str);
            HttpManager.getDefault(c.a.j.h.b.b.f3162c.h().getAppContext()).postByteRequest().mediaType("application/json").url(str).cookieManager(CookieManager.WEBKIT_COOKIES).headers(hashMap).content(bArr).build().executeAsync(new C0172a(this));
        }
    }

    public void j(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, responseCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f3202c = str;
        this.f3203d = str2;
        this.f3204e = responseCallback;
        DebugTrace debugTrace = DebugTrace.a;
        debugTrace.a("requestPost url=" + str);
        DebugTrace debugTrace2 = DebugTrace.a;
        debugTrace2.a("requestPost body=" + str2);
        d(this.f3203d);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j(this.f3202c, this.f3203d, this.f3204e);
        }
    }
}
