package b.a.p0.h.y.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.j2.k;
import b.a.p0.a.n1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.response.ResponseException;
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
/* loaded from: classes4.dex */
public class c extends b.a.p0.h.y.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> l;
    public static final Set<String> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10817a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f10818b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f10819c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.y.b f10820d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10821e;

        public a(c cVar, String str, long j, String str2, b.a.p0.h.y.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, Long.valueOf(j), str2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10821e = cVar;
            this.f10817a = str;
            this.f10818b = j;
            this.f10819c = str2;
            this.f10820d = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f10820d.cancelTag(this.f10821e.f10788g);
                this.f10821e.V(this.f10817a, 0, iOException.getMessage(), this.f10818b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!response.isSuccessful()) {
                    this.f10821e.V(this.f10817a, response.code(), response.message(), this.f10818b);
                    return;
                }
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(this.f10821e.H(response.headers()));
                    this.f10821e.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (b.a.p0.h.y.a.f10785i) {
                        e2.printStackTrace();
                    }
                }
                String str = this.f10819c;
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
                    this.f10821e.W(this.f10817a, response);
                } else {
                    this.f10821e.U(this.f10817a, response);
                }
                int code = response.code();
                String message = response.message();
                if (b.a.p0.h.y.a.f10785i) {
                    String str2 = "onResponse: id:" + this.f10821e.f10788g + ",respCode: " + code + ", url=" + this.f10817a + ", msg=" + message;
                }
                k.J(code, this.f10817a, 1, message, this.f10818b, System.currentTimeMillis());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2086004762, "Lb/a/p0/h/y/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2086004762, "Lb/a/p0/h/y/f/c;");
                return;
            }
        }
        l = Sets.newHashSet("text", "arraybuffer");
        m = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.l0.c cVar, b.a.p0.a.y.b.a aVar) {
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
                super((b.a.p0.a.l0.c) objArr2[0], (b.a.p0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10786e = 1;
    }

    @NonNull
    public static String T(@NonNull b.a.p0.a.y.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, aVar)) == null) {
            String lowerCase = aVar.B("responseType").toLowerCase(Locale.US);
            return !l.contains(lowerCase) ? "text" : lowerCase;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.h.y.a
    public void B(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.B(str, i2, str2);
            b.a.p0.h.f0.e.h(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String y = y();
            if (TextUtils.isEmpty(y)) {
                if (b.a.p0.h.y.a.f10785i) {
                    String str = "buildRequest url =" + y;
                }
                return null;
            }
            String B = this.f10787f.B("method");
            if (TextUtils.isEmpty(B)) {
                B = "GET";
            }
            String upperCase = B.toUpperCase(Locale.US);
            if (!m.contains(upperCase)) {
                B(y, -1, "request:method is invalid");
                return null;
            }
            HashMap hashMap = new HashMap();
            Request.Builder builder = new Request.Builder();
            F(builder, this.f10787f.w("header"), hashMap, true);
            if (b.a.p0.h.y.a.f10785i) {
                String str2 = "lowerCaseHeaderMap =" + hashMap;
            }
            Object C = this.f10787f.C("data", null);
            if (C == null) {
                C = this.f10787f.t("data", null);
            }
            boolean z = C != null;
            if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                return builder.url(y).method(upperCase, null).tag(this.f10788g).build();
            }
            RequestBody R = (z || HttpMethod.requiresRequestBody(upperCase)) ? R(C, hashMap) : null;
            if (HttpMethod.requiresRequestBody(upperCase) && R == null) {
                return null;
            }
            return builder.url(y).method(upperCase, R).tag(this.f10788g).build();
        }
        return (Request) invokeV.objValue;
    }

    @Nullable
    public final RequestBody R(Object obj, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, map)) == null) {
            String str = map.get("content-type");
            MediaType mediaType = f.f6891a;
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
                if (b.a.p0.h.y.a.f10785i) {
                    String str2 = "createBody = " + obj;
                }
                return RequestBody.create(mediaType, (String) obj);
            } else {
                return RequestBody.create(mediaType, "");
            }
        }
        return (RequestBody) invokeLL.objValue;
    }

    public void S(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, request) == null) {
            String T = T(this.f10787f);
            String httpUrl = request.url().toString();
            if (b.a.p0.a.a2.e.i() == null) {
                B("", -1, "request:swanApp is null");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            k.y(httpUrl, 1, null);
            b.a.p0.h.y.b bVar = (b.a.p0.h.y.b) b.a.p0.a.a2.e.i().W();
            bVar.call(request, new a(this, httpUrl, currentTimeMillis, T, bVar));
        }
    }

    public final void U(String str, Response response) {
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, response) == null) || response == null) {
            return;
        }
        try {
            b.a.p0.h.y.f.a aVar = new b.a.p0.h.y.f.a();
            aVar.statusCode = response.code();
            aVar.header = H(response.headers());
            ResponseBody body = response.body();
            if (body != null && (bytes = body.bytes()) != null) {
                aVar.data = new JsArrayBuffer(bytes, bytes.length);
            }
            C(aVar);
        } catch (IOException | JSONException e2) {
            if (b.a.p0.h.y.a.f10785i) {
                Log.getStackTraceString(e2);
            }
            B(str, -1, e2.getMessage());
        }
    }

    public final void V(String str, int i2, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j)}) == null) {
            if (b.a.p0.h.y.a.f10785i) {
                String str3 = "onFailure: " + str2;
            }
            if (ResponseException.CANCELED.equalsIgnoreCase(str2)) {
                str2 = "request:fail abort";
            }
            String str4 = str2;
            B(str, i2, str4);
            if (SwanAppNetworkUtils.i(null)) {
                k.J(i2, str, 1, str4, j, System.currentTimeMillis());
            }
        }
    }

    public final void W(String str, Response response) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, response) == null) || response == null) {
            return;
        }
        ResponseBody body = response.body();
        try {
            d dVar = new d();
            dVar.statusCode = response.code();
            dVar.header = H(response.headers());
            if (body != null) {
                dVar.data = body.string();
                if (b.a.p0.h.y.a.f10785i) {
                    String str2 = "onStringResponse = " + dVar.data;
                }
            }
            C(dVar);
        } catch (IOException | JSONException e2) {
            if (b.a.p0.h.y.a.f10785i) {
                Log.getStackTraceString(e2);
            }
            B(str, -1, e2.getMessage());
        }
    }

    public void start() {
        Request Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f10787f == null || (Q = Q()) == null) {
            return;
        }
        S(Q);
    }
}
