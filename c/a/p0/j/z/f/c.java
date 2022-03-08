package c.a.p0.j.z.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.d2.n;
import c.a.p0.a.f1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class c extends c.a.p0.j.z.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> l;
    public static final Set<String> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f10779b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f10780c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.j.z.b f10781d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10782e;

        public a(c cVar, String str, long j2, String str2, c.a.p0.j.z.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, Long.valueOf(j2), str2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10782e = cVar;
            this.a = str;
            this.f10779b = j2;
            this.f10780c = str2;
            this.f10781d = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f10781d.cancelTag(this.f10782e.f10757g);
                this.f10782e.W(this.a, 0, iOException.getMessage(), this.f10779b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!response.isSuccessful()) {
                    this.f10782e.W(this.a, response.code(), response.message(), this.f10779b);
                    return;
                }
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(this.f10782e.I(response.headers()));
                    this.f10782e.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (c.a.p0.j.z.a.f10753i) {
                        e2.printStackTrace();
                    }
                }
                String str = this.f10780c;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 3556653) {
                    if (hashCode == 1154818009 && str.equals("arraybuffer")) {
                        c2 = 0;
                    }
                } else if (str.equals("text")) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    this.f10782e.X(this.a, response);
                } else {
                    this.f10782e.V(this.a, response);
                }
                int code = response.code();
                String message = response.message();
                if (c.a.p0.j.z.a.f10753i) {
                    String str2 = "onResponse: id:" + this.f10782e.f10757g + ",respCode: " + code + ", url=" + this.a + ", msg=" + message;
                }
                n.O(code, this.a, 1, message, this.f10779b, System.currentTimeMillis());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1359170428, "Lc/a/p0/j/z/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1359170428, "Lc/a/p0/j/z/f/c;");
                return;
            }
        }
        l = Sets.newHashSet("text", "arraybuffer");
        m = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.p0.a.b0.c cVar, c.a.p0.a.o.b.a aVar) {
        super(cVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.a.b0.c) objArr2[0], (c.a.p0.a.o.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10755e = 1;
    }

    @NonNull
    public static String U(@NonNull c.a.p0.a.o.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, aVar)) == null) {
            String lowerCase = aVar.B("responseType").toLowerCase(Locale.US);
            return !l.contains(lowerCase) ? "text" : lowerCase;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.j.z.a
    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.C(str, i2, str2);
            c.a.p0.j.g0.e.h(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String z = z();
            if (TextUtils.isEmpty(z)) {
                if (c.a.p0.j.z.a.f10753i) {
                    String str = "buildRequest url =" + z;
                }
                return null;
            }
            String B = this.f10756f.B("method");
            if (TextUtils.isEmpty(B)) {
                B = "GET";
            }
            String upperCase = B.toUpperCase(Locale.US);
            if (!m.contains(upperCase)) {
                C(z, -1, "request:method is invalid");
                return null;
            }
            HashMap hashMap = new HashMap();
            Request.Builder builder = new Request.Builder();
            G(builder, this.f10756f.w("header"), hashMap, true);
            if (c.a.p0.j.z.a.f10753i) {
                String str2 = "lowerCaseHeaderMap =" + hashMap;
            }
            Object C = this.f10756f.C("data", null);
            if (C == null) {
                C = this.f10756f.t("data", null);
            }
            boolean z2 = C != null;
            if (z2 && !HttpMethod.permitsRequestBody(upperCase)) {
                return builder.url(z).method(upperCase, null).tag(this.f10757g).build();
            }
            RequestBody S = (z2 || HttpMethod.requiresRequestBody(upperCase)) ? S(C, hashMap) : null;
            if (HttpMethod.requiresRequestBody(upperCase) && S == null) {
                return null;
            }
            return builder.url(z).method(upperCase, S).tag(this.f10757g).build();
        }
        return (Request) invokeV.objValue;
    }

    @Nullable
    public final RequestBody S(Object obj, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, map)) == null) {
            String str = map.get("content-type");
            MediaType mediaType = f.a;
            if (!TextUtils.isEmpty(str)) {
                mediaType = MediaType.parse(str);
            }
            if (obj instanceof JsArrayBuffer) {
                byte[] buffer = ((JsArrayBuffer) obj).buffer();
                if (buffer == null) {
                    return RequestBody.create(mediaType, "");
                }
                return RequestBody.create(mediaType, buffer);
            } else if (obj instanceof String) {
                if (c.a.p0.j.z.a.f10753i) {
                    String str2 = "createBody = " + obj;
                }
                return RequestBody.create(mediaType, (String) obj);
            } else {
                return RequestBody.create(mediaType, "");
            }
        }
        return (RequestBody) invokeLL.objValue;
    }

    public void T(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, request) == null) {
            String U = U(this.f10756f);
            String httpUrl = request.url().toString();
            if (c.a.p0.a.t1.e.L() == null) {
                C("", -1, "request:swanApp is null");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            n.B(httpUrl, 1, null);
            c.a.p0.j.z.b bVar = (c.a.p0.j.z.b) c.a.p0.a.t1.e.L().h0();
            bVar.call(request, new a(this, httpUrl, currentTimeMillis, U, bVar));
        }
    }

    public final void V(String str, Response response) {
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, response) == null) || response == null) {
            return;
        }
        try {
            c.a.p0.j.z.f.a aVar = new c.a.p0.j.z.f.a();
            aVar.statusCode = response.code();
            aVar.header = I(response.headers());
            ResponseBody body = response.body();
            if (body != null && (bytes = body.bytes()) != null) {
                aVar.data = new JsArrayBuffer(bytes, bytes.length);
            }
            D(aVar);
        } catch (IOException | JSONException e2) {
            if (c.a.p0.j.z.a.f10753i) {
                Log.getStackTraceString(e2);
            }
            C(str, -1, e2.getMessage());
        }
    }

    public final void W(String str, int i2, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2)}) == null) {
            if (c.a.p0.j.z.a.f10753i) {
                String str3 = "onFailure: " + str2;
            }
            if ("Canceled".equalsIgnoreCase(str2)) {
                str2 = "request:fail abort";
            }
            String str4 = str2;
            C(str, i2, str4);
            if (SwanAppNetworkUtils.i(null)) {
                n.O(i2, str, 1, str4, j2, System.currentTimeMillis());
            }
        }
    }

    public final void X(String str, Response response) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, response) == null) || response == null) {
            return;
        }
        ResponseBody body = response.body();
        try {
            d dVar = new d();
            dVar.statusCode = response.code();
            dVar.header = I(response.headers());
            if (body != null) {
                dVar.data = body.string();
                if (c.a.p0.j.z.a.f10753i) {
                    String str2 = "onStringResponse = " + dVar.data;
                }
            }
            D(dVar);
        } catch (IOException | JSONException e2) {
            if (c.a.p0.j.z.a.f10753i) {
                Log.getStackTraceString(e2);
            }
            C(str, -1, e2.getMessage());
        }
    }

    public void start() {
        Request R;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f10756f == null || (R = R()) == null) {
            return;
        }
        T(R);
    }
}
