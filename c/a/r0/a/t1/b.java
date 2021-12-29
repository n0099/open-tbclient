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
    public static final String f9008h;

    /* renamed from: i  reason: collision with root package name */
    public static final MediaType f9009i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f9010b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f9011c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9012d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f9013e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC0549b f9014f;

    /* renamed from: g  reason: collision with root package name */
    public ResponseCallback<JSONObject> f9015g;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (this.a.f9014f == null) {
                    c.a.r0.a.e0.d.i("PayCheckRequest", "paycheck request success, but PayCheckRequestCallback is empty.");
                } else if (jSONObject == null) {
                    this.a.f9014f.onFail("response is empty");
                } else if (jSONObject.optInt("errno", -1) == 0) {
                    this.a.f9014f.a(jSONObject.optJSONObject("data"));
                } else {
                    String optString = jSONObject.optString("tipmsg", "");
                    InterfaceC0549b interfaceC0549b = this.a.f9014f;
                    if (TextUtils.isEmpty(optString)) {
                        optString = "errno is non-zero";
                    }
                    interfaceC0549b.onFail(optString);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (this.a.f9014f != null) {
                    this.a.f9014f.onFail(exc.getMessage());
                    return;
                }
                c.a.r0.a.e0.d.i("PayCheckRequest", "PayCheckRequestCallback is empty and paycheck request failed : \n" + Log.getStackTraceString(exc));
            }
        }
    }

    /* renamed from: c.a.r0.a.t1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0549b {
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
        f9008h = String.format("%s/ma/pay_check", c.a.r0.a.d0.a.b());
        f9009i = c.a.r0.a.p1.f.a;
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
        this.a = f9008h;
        this.f9010b = new HashMap();
        this.f9011c = new HashMap();
        this.f9012d = false;
        this.f9013e = new JSONObject();
        this.f9015g = new a(this);
        e();
        f();
        g();
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f9010b.put(str, str2);
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback) == null) {
            if (!this.f9012d) {
                responseCallback.onFail(new InvalidParameterException("error: invalid url"));
                return;
            }
            this.a = o0.b(this.a, this.f9011c);
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(this.a, RequestBody.create(f9009i, this.f9013e.toString()), responseCallback);
            aVar.f11715c = this.f9010b;
            aVar.f11719g = true;
            c.a.r0.a.e0.d.b("PayCheckRequest", "start paycheck request : " + this.f9013e);
            c.a.r0.p.e.a.g().e(aVar);
        }
    }

    public void d(@NonNull InterfaceC0549b interfaceC0549b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0549b) == null) {
            this.f9014f = interfaceC0549b;
            c(this.f9015g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String i2 = c.a.r0.q.j.f.i(f9008h);
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
                JSONObject jSONObject = this.f9013e;
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
            this.f9013e.put("order_info", jSONObject);
            this.f9012d = true;
        } catch (JSONException e2) {
            c.a.r0.a.e0.d.i("PayCheckRequest", "set order info failed: \n" + Log.getStackTraceString(e2));
        }
    }
}
