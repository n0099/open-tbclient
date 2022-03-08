package c.a.p0.a.j1;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.d0;
import c.a.p0.a.p2.o0;
import c.a.p0.a.p2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final String f5781h;

    /* renamed from: i  reason: collision with root package name */
    public static final MediaType f5782i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f5783b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f5784c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5785d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f5786e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC0335b f5787f;

    /* renamed from: g  reason: collision with root package name */
    public ResponseCallback<JSONObject> f5788g;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.a.f5787f != null) {
                    this.a.f5787f.onFail(exc.getMessage());
                    return;
                }
                c.a.p0.a.u.d.i("PayCheckRequest", "PayCheckRequestCallback is empty and paycheck request failed : \n" + Log.getStackTraceString(exc));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) {
                if (this.a.f5787f == null) {
                    c.a.p0.a.u.d.i("PayCheckRequest", "paycheck request success, but PayCheckRequestCallback is empty.");
                } else if (jSONObject == null) {
                    this.a.f5787f.onFail("response is empty");
                } else if (jSONObject.optInt("errno", -1) == 0) {
                    this.a.f5787f.a(jSONObject.optJSONObject("data"));
                } else {
                    String optString = jSONObject.optString("tipmsg", "");
                    InterfaceC0335b interfaceC0335b = this.a.f5787f;
                    if (TextUtils.isEmpty(optString)) {
                        optString = "errno is non-zero";
                    }
                    interfaceC0335b.onFail(optString);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* renamed from: c.a.p0.a.j1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0335b {
        void a(JSONObject jSONObject);

        void onFail(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820883850, "Lc/a/p0/a/j1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(820883850, "Lc/a/p0/a/j1/b;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
        f5781h = String.format("%s/ma/pay_check", c.a.p0.a.t.a.b());
        f5782i = c.a.p0.a.f1.f.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = f5781h;
        this.f5783b = new HashMap();
        this.f5784c = new HashMap();
        this.f5785d = false;
        this.f5786e = new JSONObject();
        this.f5788g = new a(this);
        e();
        f();
        g();
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f5783b.put(str, str2);
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback) == null) {
            if (!this.f5785d) {
                responseCallback.onFail(new InvalidParameterException("error: invalid url"));
                return;
            }
            this.a = o0.b(this.a, this.f5784c);
            c.a.p0.p.d.a aVar = new c.a.p0.p.d.a(this.a, RequestBody.create(f5782i, this.f5786e.toString()), responseCallback);
            aVar.f10917c = this.f5783b;
            aVar.f10921g = true;
            c.a.p0.a.u.d.b("PayCheckRequest", "start paycheck request : " + this.f5786e);
            c.a.p0.p.e.a.g().e(aVar);
        }
    }

    public void d(@NonNull InterfaceC0335b interfaceC0335b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0335b) == null) {
            this.f5787f = interfaceC0335b;
            c(this.f5788g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String i2 = c.a.p0.q.i.f.i(f5781h);
            this.a = i2;
            this.a = c.a.p0.a.t.c.b(i2);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b("Referer", d0.b());
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String N = c.a.p0.a.t1.d.J().r().N();
            try {
                JSONObject jSONObject = this.f5786e;
                if (TextUtils.isEmpty(N)) {
                    N = "";
                }
                jSONObject.put("appkey", N);
            } catch (JSONException e2) {
                c.a.p0.a.u.d.i("PayCheckRequest", "set post data 'appkey' failed: \n" + Log.getStackTraceString(e2));
            }
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f5786e.put("order_info", jSONObject);
            this.f5785d = true;
        } catch (JSONException e2) {
            c.a.p0.a.u.d.i("PayCheckRequest", "set order info failed: \n" + Log.getStackTraceString(e2));
        }
    }
}
