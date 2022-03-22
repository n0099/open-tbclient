package c.a.n0.c.a.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import c.a.n0.a.k.e.i.i;
import c.a.n0.c.a.g;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
    public Callback f8157d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f8158e;

    /* renamed from: f  reason: collision with root package name */
    public String f8159f;

    /* renamed from: g  reason: collision with root package name */
    public String f8160g;

    /* renamed from: h  reason: collision with root package name */
    public String f8161h;
    public String i;
    public int j;

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (c.a.n0.c.a.a.a) {
                    Log.d("BDTLS", "Bdtls Request API onFailure = " + exc.getMessage());
                }
                if (this.a.f8157d != null) {
                    if (exc instanceof IOException) {
                        this.a.f8157d.onFailure(null, (IOException) exc);
                    } else {
                        this.a.f8157d.onFailure(null, new IOException(exc));
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.a.n(null, response);
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
        k = c.a.n0.a.a.a;
    }

    public d(c.a.n0.a.t1.e eVar, JSONObject jSONObject, String str, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, jSONObject, str, callback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8157d = callback;
        this.f8159f = str;
        m(jSONObject);
        d(this.f8158e.optString("method"));
    }

    @Override // c.a.n0.c.a.k.c
    public void e(IOException iOException) {
        Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iOException) == null) || (callback = this.f8157d) == null) {
            return;
        }
        callback.onFailure(null, iOException);
    }

    @Override // c.a.n0.c.a.k.c
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (c.a.n0.c.a.a.a) {
                Log.d("BdtlsRequestApi", "onRequestError=" + i);
            }
            Callback callback = this.f8157d;
            if (callback != null) {
                callback.onFailure(null, new IOException("request error  code : " + i));
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
                jSONObject = new JSONObject(this.f8158e.toString());
                try {
                    Uri parse = Uri.parse(this.f8161h);
                    String path = parse.getPath();
                    String query = parse.getQuery();
                    if (TextUtils.isEmpty(this.i)) {
                        str = c.a.n0.c.a.b.f8117b;
                    } else {
                        str = this.i + "/bdtls";
                    }
                    StringBuilder sb = new StringBuilder(str + "/" + this.f8160g);
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
                        Log.d("BdtlsRequestApi", "bdtls url is : " + sb.toString());
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
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = jSONObject;
                    if (k) {
                        Log.e("BdtlsRequestApi", "Bdtls request data is invalid", e);
                    }
                    jSONObject = jSONObject2;
                    httpRequest = (HttpRequest) i.C(jSONObject, this.f8159f).first;
                    if (httpRequest == null) {
                        callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
                    }
                    l(httpRequest);
                }
            } catch (JSONException e3) {
                e = e3;
            }
            httpRequest = (HttpRequest) i.C(jSONObject, this.f8159f).first;
            if (httpRequest == null && (callback = this.f8157d) != null) {
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
            this.f8158e = jSONObject;
            this.f8161h = jSONObject.optString("url");
            JSONObject optJSONObject = this.f8158e.optJSONObject("ext");
            if (optJSONObject != null) {
                this.i = optJSONObject.optString("customHost");
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
                this.f8157d.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
                return;
            }
            g.l().m().k();
            if (this.a) {
                ResponseBody body = response.body();
                String g2 = g(body.bytes());
                if (c.a.n0.c.a.a.a) {
                    Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g2);
                }
                if (this.f8155b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName(IMAudioTransRequest.CHARSET));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    Callback callback = this.f8157d;
                    if (callback != null) {
                        callback.onResponse(call, build);
                    }
                    this.j = 0;
                    return;
                } else if (this.j < 3) {
                    p();
                    return;
                } else {
                    this.f8157d.onFailure(call, new IOException("Url or serviceId is invalid"));
                    this.j = 0;
                    return;
                }
            }
            Callback callback2 = this.f8157d;
            if (callback2 != null) {
                callback2.onResponse(call, response);
            }
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f8160g = str;
            JSONObject jSONObject = this.f8158e;
            a(jSONObject != null ? jSONObject.optString("data") : "");
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j++;
            o(this.f8160g);
        }
    }
}
