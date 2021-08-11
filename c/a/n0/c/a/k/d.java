package c.a.n0.c.a.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import c.a.n0.a.k;
import c.a.n0.a.u.e.j.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Callback f10097d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10098e;

    /* renamed from: f  reason: collision with root package name */
    public String f10099f;

    /* renamed from: g  reason: collision with root package name */
    public String f10100g;

    /* renamed from: h  reason: collision with root package name */
    public String f10101h;

    /* renamed from: i  reason: collision with root package name */
    public String f10102i;

    /* renamed from: j  reason: collision with root package name */
    public int f10103j;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10104a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10104a = dVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (c.a.n0.c.a.a.f10037a) {
                    String str = "Bdtls Request API onFailure = " + exc.getMessage();
                }
                if (this.f10104a.f10097d != null) {
                    if (exc instanceof IOException) {
                        this.f10104a.f10097d.onFailure(null, (IOException) exc);
                    } else {
                        this.f10104a.f10097d.onFailure(null, new IOException(exc));
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f10104a.n(null, response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2090585252, "Lc/a/n0/c/a/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2090585252, "Lc/a/n0/c/a/k/d;");
                return;
            }
        }
        k = k.f6803a;
    }

    public d(c.a.n0.a.a2.e eVar, JSONObject jSONObject, String str, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, jSONObject, str, callback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10097d = callback;
        this.f10099f = str;
        m(jSONObject);
        d(this.f10098e.optString("method"));
    }

    @Override // c.a.n0.c.a.k.c
    public void e(IOException iOException) {
        Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iOException) == null) || (callback = this.f10097d) == null) {
            return;
        }
        callback.onFailure(null, iOException);
    }

    @Override // c.a.n0.c.a.k.c
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (c.a.n0.c.a.a.f10037a) {
                String str = "onRequestError=" + i2;
            }
            Callback callback = this.f10097d;
            if (callback != null) {
                callback.onFailure(null, new IOException("request error  code : " + i2));
            }
        }
    }

    @Override // c.a.n0.c.a.k.c
    public void h(byte[] bArr) {
        JSONObject jSONObject;
        HttpRequest httpRequest;
        Callback callback;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject = new JSONObject(this.f10098e.toString());
                try {
                    Uri parse = Uri.parse(this.f10101h);
                    String path = parse.getPath();
                    String query = parse.getQuery();
                    if (TextUtils.isEmpty(this.f10102i)) {
                        str = c.a.n0.c.a.b.f10039b;
                    } else {
                        str = this.f10102i + "/bdtls";
                    }
                    StringBuilder sb = new StringBuilder(str + "/" + this.f10100g);
                    String str3 = "";
                    if (TextUtils.isEmpty(path)) {
                        path = "";
                    }
                    sb.append(path);
                    if (!TextUtils.isEmpty(query)) {
                        str3 = "?" + query;
                    }
                    sb.append(str3);
                    if (k) {
                        String str4 = "bdtls url is : " + sb.toString();
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("header");
                    if (this.f10094a) {
                        if (TextUtils.equals(b(), "GET")) {
                            str2 = Base64.encodeToString(bArr, 2);
                        } else {
                            jSONObject.putOpt("data", bArr);
                            str2 = "Bdtls";
                        }
                        optJSONObject.put("Bdtls", str2);
                    }
                    jSONObject.putOpt("header", optJSONObject);
                    jSONObject.putOpt("url", sb.toString());
                } catch (JSONException unused) {
                    jSONObject2 = jSONObject;
                    boolean z = k;
                    jSONObject = jSONObject2;
                    httpRequest = (HttpRequest) g.u(jSONObject, this.f10099f).first;
                    if (httpRequest == null) {
                        callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
                    }
                    l(httpRequest);
                }
            } catch (JSONException unused2) {
            }
            httpRequest = (HttpRequest) g.u(jSONObject, this.f10099f).first;
            if (httpRequest == null && (callback = this.f10097d) != null) {
                callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
            }
            l(httpRequest);
        }
    }

    public final void l(HttpRequest httpRequest) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, httpRequest) == null) || httpRequest == null) {
            return;
        }
        httpRequest.executeAsync(new a(this));
    }

    public final void m(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            this.f10098e = jSONObject;
            this.f10101h = jSONObject.optString("url");
            JSONObject optJSONObject = this.f10098e.optJSONObject("ext");
            if (optJSONObject != null) {
                this.f10102i = optJSONObject.optString("customHost");
            }
        }
    }

    public final void n(Call call, Response response) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, call, response) == null) {
            Headers headers = response.headers();
            if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                c.a.n0.c.a.g.l().m().s(0);
                if (c.a.n0.c.a.g.l().m().b()) {
                    c.a.n0.c.a.g.l().m().a();
                    i(true);
                    p();
                    return;
                }
                this.f10097d.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
                return;
            }
            c.a.n0.c.a.g.l().m().k();
            if (this.f10094a) {
                ResponseBody body = response.body();
                String g2 = g(body.bytes());
                if (c.a.n0.c.a.a.f10037a) {
                    String str = "BdtlsPostRequest parseResponse=" + g2;
                }
                if (this.f10095b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName("utf-8"));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    Callback callback = this.f10097d;
                    if (callback != null) {
                        callback.onResponse(call, build);
                    }
                    this.f10103j = 0;
                    return;
                } else if (this.f10103j < 3) {
                    p();
                    return;
                } else {
                    this.f10097d.onFailure(call, new IOException("Url or serviceId is invalid"));
                    this.f10103j = 0;
                    return;
                }
            }
            Callback callback2 = this.f10097d;
            if (callback2 != null) {
                callback2.onResponse(call, response);
            }
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f10100g = str;
            JSONObject jSONObject = this.f10098e;
            a(jSONObject != null ? jSONObject.optString("data") : "");
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f10103j++;
            o(this.f10100g);
        }
    }
}
