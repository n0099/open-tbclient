package c.a.r0.a.p1.q;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.r0.a.d0.c;
import c.a.r0.a.e0.d;
import c.a.r0.a.k;
import c.a.r0.a.p1.f;
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
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final String f8483h;

    /* renamed from: i  reason: collision with root package name */
    public static final MediaType f8484i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f8485b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f8486c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8487d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f8488e;

    /* renamed from: f  reason: collision with root package name */
    public b f8489f;

    /* renamed from: g  reason: collision with root package name */
    public ResponseCallback<JSONObject> f8490g;

    /* renamed from: c.a.r0.a.p1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0500a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0500a(a aVar) {
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
                if (this.a.f8489f == null) {
                    d.i("IsBlockDomainRequest", "isblockdomain request success, but IsBlockDomainRequestCallback is empty.");
                } else if (jSONObject == null) {
                    this.a.f8489f.onFail("response is empty");
                } else if (jSONObject.optInt("errno", -1) == 0) {
                    this.a.f8489f.a(jSONObject.optJSONObject("data"));
                } else {
                    String optString = jSONObject.optString("tipmsg", "");
                    b bVar = this.a.f8489f;
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
                if (this.a.f8489f != null) {
                    this.a.f8489f.onFail(exc.getMessage());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-115943987, "Lc/a/r0/a/p1/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-115943987, "Lc/a/r0/a/p1/q/a;");
                return;
            }
        }
        boolean z = k.a;
        f8483h = String.format("%s/ma/isblockdomain", c.a.r0.a.d0.a.b());
        f8484i = f.a;
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
        this.a = f8483h;
        this.f8485b = new HashMap();
        this.f8486c = new HashMap();
        this.f8487d = false;
        this.f8488e = new JSONObject();
        this.f8490g = new C0500a(this);
        e();
        f();
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f8485b.put(str, str2);
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback) == null) {
            if (!this.f8487d) {
                responseCallback.onFail(new InvalidParameterException("error: invalid url"));
                return;
            }
            this.a = o0.b(this.a, this.f8486c);
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(this.a, RequestBody.create(f8484i, this.f8488e.toString()), responseCallback);
            aVar.f11715c = this.f8485b;
            aVar.f11719g = true;
            d.b("IsBlockDomainRequest", "start isblockdomain request : " + this.f8488e);
            c.a.r0.p.e.a.g().e(aVar);
        }
    }

    public void d(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f8489f = bVar;
            c(this.f8490g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String i2 = c.a.r0.q.j.f.i(f8483h);
            this.a = i2;
            this.a = c.b(i2);
            String N = c.a.r0.a.d2.d.J().r().N();
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
            this.f8488e.put("url", str);
            this.f8487d = true;
        } catch (JSONException unused) {
            d.i("IsBlockDomainRequest", "set url need to check failed");
        }
    }
}
