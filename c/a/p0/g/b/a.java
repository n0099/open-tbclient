package c.a.p0.g.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.f.d.u;
import c.a.p0.a.p2.q0;
import c.a.p0.a.p2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class a implements u {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.p0.g.o.c<JSONObject> f9801b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f9802c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1187457032, "Lc/a/p0/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1187457032, "Lc/a/p0/g/b/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f9801b = new c.a.p0.g.o.c<>();
        f9802c = TimeUnit.MINUTES.toMillis(2L);
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
            }
        }
    }

    @Override // c.a.p0.a.f.d.u
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
        }
    }

    @Override // c.a.p0.a.f.d.u
    public File b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            return null;
        }
        return (File) invokeLL.objValue;
    }

    @Override // c.a.p0.a.f.d.u
    public JSONObject c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if (a) {
                String str2 = "getIMUnReadMessageList params=" + str;
            }
            String str3 = c.a.p0.a.t1.d.J().getAppId() + c.a.p0.a.t1.d.J().r().M().c(context);
            JSONObject c2 = f9801b.c(str3);
            if (a) {
                String str4 = "getIMUnReadMessageList k=" + str3;
            }
            if (c2 != null) {
                if (a) {
                    String str5 = "getIMUnReadMessageList ret with cache=" + c2;
                }
                return c2;
            } else if (q0.O()) {
                return null;
            } else {
                JSONObject f2 = f(context, str);
                if (a) {
                    String str6 = "getIMUnReadMessageList ret with request=" + f2;
                }
                return f9801b.a(str3, f2, f9802c);
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    @Override // c.a.p0.a.f.d.u
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f9801b.b();
        }
    }

    public final JSONObject e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            w.f(jSONObject2, "pa_type", 7);
            w.f(jSONObject2, "pa_unread_sums", Integer.valueOf(i2));
            jSONArray.put(jSONObject2);
            w.f(jSONObject, "un_read_list", jSONArray);
            return jSONObject;
        }
        return (JSONObject) invokeI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        r9 = r4.optString("pa_uid");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject f(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        ResponseBody responseBody;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048581, this, context, str)) != null) {
            return (JSONObject) invokeLL.objValue;
        }
        c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
        ResponseBody responseBody2 = null;
        if (a0 == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    str2 = null;
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject.optInt("pa_type") == 7) {
                    break;
                }
                i3++;
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String n = c.a.p0.a.s0.a.o().n();
            c.a.p0.p.d.a aVar = new c.a.p0.p.d.a(n, new Request.Builder().url(n).post(new FormBody.Builder().add("appkey", a0.N()).add(com.alipay.sdk.cons.b.k, str2).build()).build().body(), null);
            aVar.f10920f = true;
            aVar.f10921g = true;
            aVar.f10922h = true;
            aVar.f10916b = "POST";
            HttpRequestBuilder a2 = c.a.p0.p.e.b.a(aVar);
            c.a.p0.p.e.a.g().u(a2, aVar);
            try {
                Response executeSync = a2.build().executeSync();
                if (!executeSync.isSuccessful()) {
                    c.a.p0.w.d.d(null);
                    return null;
                }
                responseBody = executeSync.body();
                if (responseBody == null) {
                    c.a.p0.w.d.d(responseBody);
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(responseBody.string());
                    if (!"0".equals(jSONObject.optString("errno"))) {
                        c.a.p0.w.d.d(responseBody);
                        return null;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                    if (optJSONObject2 != null) {
                        i2 = optJSONObject2.optInt("num");
                    }
                    JSONObject e2 = e(i2);
                    c.a.p0.a.s0.a.K().i(e2);
                    c.a.p0.w.d.d(responseBody);
                    return e2;
                } catch (IOException | JSONException unused) {
                    c.a.p0.w.d.d(responseBody);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    responseBody2 = responseBody;
                    c.a.p0.w.d.d(responseBody2);
                    throw th;
                }
            } catch (IOException | JSONException unused2) {
                responseBody = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (JSONException unused3) {
        }
    }
}
