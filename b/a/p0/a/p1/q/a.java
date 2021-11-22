package b.a.p0.a.p1.q;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import b.a.p0.a.d0.c;
import b.a.p0.a.e0.d;
import b.a.p0.a.k;
import b.a.p0.a.p1.f;
import b.a.p0.a.z2.d0;
import b.a.p0.a.z2.o0;
import b.a.p0.a.z2.w;
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
    public static final String f7773h;

    /* renamed from: i  reason: collision with root package name */
    public static final MediaType f7774i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f7775a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f7776b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f7777c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7778d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f7779e;

    /* renamed from: f  reason: collision with root package name */
    public b f7780f;

    /* renamed from: g  reason: collision with root package name */
    public ResponseCallback<JSONObject> f7781g;

    /* renamed from: b.a.p0.a.p1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0360a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7782a;

        public C0360a(a aVar) {
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
            this.f7782a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (this.f7782a.f7780f == null) {
                    d.i("IsBlockDomainRequest", "isblockdomain request success, but IsBlockDomainRequestCallback is empty.");
                } else if (jSONObject == null) {
                    this.f7782a.f7780f.onFail("response is empty");
                } else if (jSONObject.optInt("errno", -1) == 0) {
                    this.f7782a.f7780f.a(jSONObject.optJSONObject("data"));
                } else {
                    String optString = jSONObject.optString("tipmsg", "");
                    b bVar = this.f7782a.f7780f;
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
                if (this.f7782a.f7780f != null) {
                    this.f7782a.f7780f.onFail(exc.getMessage());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(136424752, "Lb/a/p0/a/p1/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(136424752, "Lb/a/p0/a/p1/q/a;");
                return;
            }
        }
        boolean z = k.f6863a;
        f7773h = String.format("%s/ma/isblockdomain", b.a.p0.a.d0.a.b());
        f7774i = f.f7732a;
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
        this.f7775a = f7773h;
        this.f7776b = new HashMap();
        this.f7777c = new HashMap();
        this.f7778d = false;
        this.f7779e = new JSONObject();
        this.f7781g = new C0360a(this);
        e();
        f();
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f7776b.put(str, str2);
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback) == null) {
            if (!this.f7778d) {
                responseCallback.onFail(new InvalidParameterException("error: invalid url"));
                return;
            }
            this.f7775a = o0.b(this.f7775a, this.f7777c);
            b.a.p0.p.d.a aVar = new b.a.p0.p.d.a(this.f7775a, RequestBody.create(f7774i, this.f7779e.toString()), responseCallback);
            aVar.f11722c = this.f7776b;
            aVar.f11726g = true;
            d.b("IsBlockDomainRequest", "start isblockdomain request : " + this.f7779e);
            b.a.p0.p.e.a.g().e(aVar);
        }
    }

    public void d(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f7780f = bVar;
            c(this.f7781g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String i2 = b.a.p0.q.j.f.i(f7773h);
            this.f7775a = i2;
            this.f7775a = c.b(i2);
            String N = b.a.p0.a.d2.d.J().r().N();
            String str = this.f7775a;
            if (TextUtils.isEmpty(N)) {
                N = "";
            }
            this.f7775a = c.a(str, "src_app", N);
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
            this.f7779e.put("url", str);
            this.f7778d = true;
        } catch (JSONException unused) {
            d.i("IsBlockDomainRequest", "set url need to check failed");
        }
    }
}
