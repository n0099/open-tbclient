package c.a.r0.a.t1;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.r0.a.z2.d0;
import c.a.r0.a.z2.o0;
import c.a.r0.a.z2.w;
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
    public static final String f8953h;

    /* renamed from: i  reason: collision with root package name */
    public static final MediaType f8954i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f8955b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f8956c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8957d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f8958e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC0567b f8959f;

    /* renamed from: g  reason: collision with root package name */
    public ResponseCallback<JSONObject> f8960g;

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
                if (this.a.f8959f != null) {
                    this.a.f8959f.onFail(exc.getMessage());
                    return;
                }
                c.a.r0.a.e0.d.i("PayCheckRequest", "PayCheckRequestCallback is empty and paycheck request failed : \n" + Log.getStackTraceString(exc));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) {
                if (this.a.f8959f == null) {
                    c.a.r0.a.e0.d.i("PayCheckRequest", "paycheck request success, but PayCheckRequestCallback is empty.");
                } else if (jSONObject == null) {
                    this.a.f8959f.onFail("response is empty");
                } else if (jSONObject.optInt("errno", -1) == 0) {
                    this.a.f8959f.a(jSONObject.optJSONObject("data"));
                } else {
                    String optString = jSONObject.optString("tipmsg", "");
                    InterfaceC0567b interfaceC0567b = this.a.f8959f;
                    if (TextUtils.isEmpty(optString)) {
                        optString = "errno is non-zero";
                    }
                    interfaceC0567b.onFail(optString);
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

    /* renamed from: c.a.r0.a.t1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0567b {
        void a(JSONObject jSONObject);

        void onFail(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(437092050, "Lc/a/r0/a/t1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(437092050, "Lc/a/r0/a/t1/b;");
                return;
            }
        }
        boolean z = c.a.r0.a.k.a;
        f8953h = String.format("%s/ma/pay_check", c.a.r0.a.d0.a.b());
        f8954i = c.a.r0.a.p1.f.a;
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
        this.a = f8953h;
        this.f8955b = new HashMap();
        this.f8956c = new HashMap();
        this.f8957d = false;
        this.f8958e = new JSONObject();
        this.f8960g = new a(this);
        e();
        f();
        g();
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f8955b.put(str, str2);
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback) == null) {
            if (!this.f8957d) {
                responseCallback.onFail(new InvalidParameterException("error: invalid url"));
                return;
            }
            this.a = o0.b(this.a, this.f8956c);
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(this.a, RequestBody.create(f8954i, this.f8958e.toString()), responseCallback);
            aVar.f11592c = this.f8955b;
            aVar.f11596g = true;
            c.a.r0.a.e0.d.b("PayCheckRequest", "start paycheck request : " + this.f8958e);
            c.a.r0.p.e.a.g().e(aVar);
        }
    }

    public void d(@NonNull InterfaceC0567b interfaceC0567b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0567b) == null) {
            this.f8959f = interfaceC0567b;
            c(this.f8960g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String i2 = c.a.r0.q.j.f.i(f8953h);
            this.a = i2;
            this.a = c.a.r0.a.d0.c.b(i2);
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
            String N = c.a.r0.a.d2.d.J().r().N();
            try {
                JSONObject jSONObject = this.f8958e;
                if (TextUtils.isEmpty(N)) {
                    N = "";
                }
                jSONObject.put("appkey", N);
            } catch (JSONException e2) {
                c.a.r0.a.e0.d.i("PayCheckRequest", "set post data 'appkey' failed: \n" + Log.getStackTraceString(e2));
            }
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f8958e.put("order_info", jSONObject);
            this.f8957d = true;
        } catch (JSONException e2) {
            c.a.r0.a.e0.d.i("PayCheckRequest", "set order info failed: \n" + Log.getStackTraceString(e2));
        }
    }
}
