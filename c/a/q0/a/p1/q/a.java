package c.a.q0.a.p1.q;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.q0.a.d0.c;
import c.a.q0.a.e0.d;
import c.a.q0.a.k;
import c.a.q0.a.p1.f;
import c.a.q0.a.z2.d0;
import c.a.q0.a.z2.o0;
import c.a.q0.a.z2.w;
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
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final String f7748h;

    /* renamed from: i  reason: collision with root package name */
    public static final MediaType f7749i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f7750b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f7751c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7752d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f7753e;

    /* renamed from: f  reason: collision with root package name */
    public b f7754f;

    /* renamed from: g  reason: collision with root package name */
    public ResponseCallback<JSONObject> f7755g;

    /* renamed from: c.a.q0.a.p1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0450a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0450a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (this.a.f7754f == null) {
                    d.i("IsBlockDomainRequest", "isblockdomain request success, but IsBlockDomainRequestCallback is empty.");
                } else if (jSONObject == null) {
                    this.a.f7754f.onFail("response is empty");
                } else if (jSONObject.optInt("errno", -1) == 0) {
                    this.a.f7754f.a(jSONObject.optJSONObject("data"));
                } else {
                    String optString = jSONObject.optString("tipmsg", "");
                    b bVar = this.a.f7754f;
                    if (TextUtils.isEmpty(optString)) {
                        optString = "errno is non-zero";
                    }
                    bVar.onFail(optString);
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
                if (this.a.f7754f != null) {
                    this.a.f7754f.onFail(exc.getMessage());
                    return;
                }
                d.i("IsBlockDomainRequest", "IsBlockDomainRequestCallback is empty and isblockdomain request failed : \n" + Log.getStackTraceString(exc));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(JSONObject jSONObject);

        void onFail(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-245026706, "Lc/a/q0/a/p1/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-245026706, "Lc/a/q0/a/p1/q/a;");
                return;
            }
        }
        boolean z = k.a;
        f7748h = String.format("%s/ma/isblockdomain", c.a.q0.a.d0.a.b());
        f7749i = f.a;
    }

    public a() {
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
        this.a = f7748h;
        this.f7750b = new HashMap();
        this.f7751c = new HashMap();
        this.f7752d = false;
        this.f7753e = new JSONObject();
        this.f7755g = new C0450a(this);
        e();
        f();
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f7750b.put(str, str2);
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback) == null) {
            if (!this.f7752d) {
                responseCallback.onFail(new InvalidParameterException("error: invalid url"));
                return;
            }
            this.a = o0.b(this.a, this.f7751c);
            c.a.q0.p.d.a aVar = new c.a.q0.p.d.a(this.a, RequestBody.create(f7749i, this.f7753e.toString()), responseCallback);
            aVar.f10980c = this.f7750b;
            aVar.f10984g = true;
            d.b("IsBlockDomainRequest", "start isblockdomain request : " + this.f7753e);
            c.a.q0.p.e.a.g().e(aVar);
        }
    }

    public void d(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f7754f = bVar;
            c(this.f7755g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String i2 = c.a.q0.q.j.f.i(f7748h);
            this.a = i2;
            this.a = c.b(i2);
            String N = c.a.q0.a.d2.d.J().r().N();
            String str = this.a;
            if (TextUtils.isEmpty(N)) {
                N = "";
            }
            this.a = c.a(str, "src_app", N);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b("Referer", d0.b());
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f7753e.put("url", str);
            this.f7752d = true;
        } catch (JSONException unused) {
            d.i("IsBlockDomainRequest", "set url need to check failed");
        }
    }
}
