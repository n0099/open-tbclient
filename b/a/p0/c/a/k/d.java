package b.a.p0.c.a.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import b.a.p0.a.k;
import b.a.p0.a.u.e.i.i;
import b.a.p0.c.a.g;
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
    public Callback f10180d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10181e;

    /* renamed from: f  reason: collision with root package name */
    public String f10182f;

    /* renamed from: g  reason: collision with root package name */
    public String f10183g;

    /* renamed from: h  reason: collision with root package name */
    public String f10184h;

    /* renamed from: i  reason: collision with root package name */
    public String f10185i;
    public int j;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10186a;

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
            this.f10186a = dVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (b.a.p0.c.a.a.f10122a) {
                    String str = "Bdtls Request API onFailure = " + exc.getMessage();
                }
                if (this.f10186a.f10180d != null) {
                    if (exc instanceof IOException) {
                        this.f10186a.f10180d.onFailure(null, (IOException) exc);
                    } else {
                        this.f10186a.f10180d.onFailure(null, new IOException(exc));
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
                this.f10186a.n(null, response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1397894813, "Lb/a/p0/c/a/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1397894813, "Lb/a/p0/c/a/k/d;");
                return;
            }
        }
        k = k.f6863a;
    }

    public d(b.a.p0.a.d2.e eVar, JSONObject jSONObject, String str, Callback callback) {
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
        this.f10180d = callback;
        this.f10182f = str;
        m(jSONObject);
        d(this.f10181e.optString("method"));
    }

    @Override // b.a.p0.c.a.k.c
    public void e(IOException iOException) {
        Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iOException) == null) || (callback = this.f10180d) == null) {
            return;
        }
        callback.onFailure(null, iOException);
    }

    @Override // b.a.p0.c.a.k.c
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (b.a.p0.c.a.a.f10122a) {
                String str = "onRequestError=" + i2;
            }
            Callback callback = this.f10180d;
            if (callback != null) {
                callback.onFailure(null, new IOException("request error  code : " + i2));
            }
        }
    }

    @Override // b.a.p0.c.a.k.c
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
                jSONObject = new JSONObject(this.f10181e.toString());
                try {
                    Uri parse = Uri.parse(this.f10184h);
                    String path = parse.getPath();
                    String query = parse.getQuery();
                    if (TextUtils.isEmpty(this.f10185i)) {
                        str = b.a.p0.c.a.b.f10124b;
                    } else {
                        str = this.f10185i + "/bdtls";
                    }
                    StringBuilder sb = new StringBuilder(str + "/" + this.f10183g);
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
                    if (this.f10177a) {
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
                    httpRequest = (HttpRequest) i.C(jSONObject, this.f10182f).first;
                    if (httpRequest == null) {
                        callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
                    }
                    l(httpRequest);
                }
            } catch (JSONException unused2) {
            }
            httpRequest = (HttpRequest) i.C(jSONObject, this.f10182f).first;
            if (httpRequest == null && (callback = this.f10180d) != null) {
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
            this.f10181e = jSONObject;
            this.f10184h = jSONObject.optString("url");
            JSONObject optJSONObject = this.f10181e.optJSONObject("ext");
            if (optJSONObject != null) {
                this.f10185i = optJSONObject.optString("customHost");
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
                this.f10180d.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
                return;
            }
            g.l().m().k();
            if (this.f10177a) {
                ResponseBody body = response.body();
                String g2 = g(body.bytes());
                if (b.a.p0.c.a.a.f10122a) {
                    String str = "BdtlsPostRequest parseResponse=" + g2;
                }
                if (this.f10178b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName("utf-8"));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    Callback callback = this.f10180d;
                    if (callback != null) {
                        callback.onResponse(call, build);
                    }
                    this.j = 0;
                    return;
                } else if (this.j < 3) {
                    p();
                    return;
                } else {
                    this.f10180d.onFailure(call, new IOException("Url or serviceId is invalid"));
                    this.j = 0;
                    return;
                }
            }
            Callback callback2 = this.f10180d;
            if (callback2 != null) {
                callback2.onResponse(call, response);
            }
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f10183g = str;
            JSONObject jSONObject = this.f10181e;
            a(jSONObject != null ? jSONObject.optString("data") : "");
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j++;
            o(this.f10183g);
        }
    }
}
