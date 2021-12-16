package c.a.q0.c.a.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import c.a.q0.a.k;
import c.a.q0.a.u.e.i.i;
import c.a.q0.c.a.g;
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
/* loaded from: classes6.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f9764k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Callback f9765d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f9766e;

    /* renamed from: f  reason: collision with root package name */
    public String f9767f;

    /* renamed from: g  reason: collision with root package name */
    public String f9768g;

    /* renamed from: h  reason: collision with root package name */
    public String f9769h;

    /* renamed from: i  reason: collision with root package name */
    public String f9770i;

    /* renamed from: j  reason: collision with root package name */
    public int f9771j;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (c.a.q0.c.a.a.a) {
                    String str = "Bdtls Request API onFailure = " + exc.getMessage();
                }
                if (this.a.f9765d != null) {
                    if (exc instanceof IOException) {
                        this.a.f9765d.onFailure(null, (IOException) exc);
                    } else {
                        this.a.f9765d.onFailure(null, new IOException(exc));
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
                this.a.n(null, response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1108495263, "Lc/a/q0/c/a/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1108495263, "Lc/a/q0/c/a/k/d;");
                return;
            }
        }
        f9764k = k.a;
    }

    public d(c.a.q0.a.d2.e eVar, JSONObject jSONObject, String str, Callback callback) {
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
        this.f9765d = callback;
        this.f9767f = str;
        m(jSONObject);
        d(this.f9766e.optString("method"));
    }

    @Override // c.a.q0.c.a.k.c
    public void e(IOException iOException) {
        Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iOException) == null) || (callback = this.f9765d) == null) {
            return;
        }
        callback.onFailure(null, iOException);
    }

    @Override // c.a.q0.c.a.k.c
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (c.a.q0.c.a.a.a) {
                String str = "onRequestError=" + i2;
            }
            Callback callback = this.f9765d;
            if (callback != null) {
                callback.onFailure(null, new IOException("request error  code : " + i2));
            }
        }
    }

    @Override // c.a.q0.c.a.k.c
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
                jSONObject = new JSONObject(this.f9766e.toString());
                try {
                    Uri parse = Uri.parse(this.f9769h);
                    String path = parse.getPath();
                    String query = parse.getQuery();
                    if (TextUtils.isEmpty(this.f9770i)) {
                        str = c.a.q0.c.a.b.f9718b;
                    } else {
                        str = this.f9770i + "/bdtls";
                    }
                    StringBuilder sb = new StringBuilder(str + "/" + this.f9768g);
                    String str3 = "";
                    if (TextUtils.isEmpty(path)) {
                        path = "";
                    }
                    sb.append(path);
                    if (!TextUtils.isEmpty(query)) {
                        str3 = "?" + query;
                    }
                    sb.append(str3);
                    if (f9764k) {
                        String str4 = "bdtls url is : " + sb.toString();
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("header");
                    if (this.a) {
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
                    boolean z = f9764k;
                    jSONObject = jSONObject2;
                    httpRequest = (HttpRequest) i.C(jSONObject, this.f9767f).first;
                    if (httpRequest == null) {
                        callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
                    }
                    l(httpRequest);
                }
            } catch (JSONException unused2) {
            }
            httpRequest = (HttpRequest) i.C(jSONObject, this.f9767f).first;
            if (httpRequest == null && (callback = this.f9765d) != null) {
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
            this.f9766e = jSONObject;
            this.f9769h = jSONObject.optString("url");
            JSONObject optJSONObject = this.f9766e.optJSONObject("ext");
            if (optJSONObject != null) {
                this.f9770i = optJSONObject.optString("customHost");
            }
        }
    }

    public final void n(Call call, Response response) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, call, response) == null) {
            Headers headers = response.headers();
            if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                g.l().m().s(0);
                if (g.l().m().b()) {
                    g.l().m().a();
                    i(true);
                    p();
                    return;
                }
                this.f9765d.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
                return;
            }
            g.l().m().k();
            if (this.a) {
                ResponseBody body = response.body();
                String g2 = g(body.bytes());
                if (c.a.q0.c.a.a.a) {
                    String str = "BdtlsPostRequest parseResponse=" + g2;
                }
                if (this.f9762b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName("utf-8"));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    Callback callback = this.f9765d;
                    if (callback != null) {
                        callback.onResponse(call, build);
                    }
                    this.f9771j = 0;
                    return;
                } else if (this.f9771j < 3) {
                    p();
                    return;
                } else {
                    this.f9765d.onFailure(call, new IOException("Url or serviceId is invalid"));
                    this.f9771j = 0;
                    return;
                }
            }
            Callback callback2 = this.f9765d;
            if (callback2 != null) {
                callback2.onResponse(call, response);
            }
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f9768g = str;
            JSONObject jSONObject = this.f9766e;
            a(jSONObject != null ? jSONObject.optString("data") : "");
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f9771j++;
            o(this.f9768g);
        }
    }
}
