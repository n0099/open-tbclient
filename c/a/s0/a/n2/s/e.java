package c.a.s0.a.n2.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.s0.a.k;
import c.a.s0.a.n2.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f8218j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f8219b;

    /* renamed from: c  reason: collision with root package name */
    public String f8220c;

    /* renamed from: d  reason: collision with root package name */
    public String f8221d;

    /* renamed from: e  reason: collision with root package name */
    public String f8222e;

    /* renamed from: f  reason: collision with root package name */
    public String f8223f;

    /* renamed from: g  reason: collision with root package name */
    public String f8224g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f8225h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f8226i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1733179773, "Lc/a/s0/a/n2/s/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1733179773, "Lc/a/s0/a/n2/s/e;");
                return;
            }
        }
        f8218j = k.a;
    }

    public e() {
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
        this.a = "swan";
    }

    public void a(@NonNull String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (this.f8225h == null) {
                this.f8225h = new JSONObject();
            }
            try {
                this.f8225h.put(str, obj);
            } catch (JSONException e2) {
                if (f8218j) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.f8225h == null) {
            this.f8225h = new JSONObject();
        }
        JSONObject optJSONObject = this.f8225h.optJSONObject("extlog");
        this.f8226i = optJSONObject;
        if (optJSONObject == null) {
            this.f8226i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f8226i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f8218j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f8225h.put("extlog", this.f8226i);
        } catch (JSONException e3) {
            if (f8218j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f8225h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f8225h.toString());
            } catch (JSONException e2) {
                if (f8218j) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            e(new JSONObject(str));
        } catch (JSONException e2) {
            if (f8218j) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.f8225h == null) {
            this.f8225h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f8225h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f8218j) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.a)) {
                    jSONObject.put("from", this.a);
                }
                if (!TextUtils.isEmpty(this.f8219b)) {
                    jSONObject.put("type", this.f8219b);
                }
                if (!TextUtils.isEmpty(this.f8222e)) {
                    jSONObject.put("value", this.f8222e);
                }
                if (TextUtils.isEmpty(this.f8220c)) {
                    this.f8220c = "NA";
                }
                jSONObject.put("source", this.f8220c);
                if (!TextUtils.isEmpty(this.f8224g)) {
                    String b2 = m.b(this.f8224g);
                    this.f8224g = b2;
                    jSONObject.put("page", b2);
                }
                if (this.f8225h == null) {
                    this.f8225h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f8223f)) {
                    this.f8225h.put("appid", this.f8223f);
                }
                if (!TextUtils.isEmpty(this.f8221d)) {
                    this.f8225h.put("launchid", this.f8221d);
                }
                m.a(this.f8225h);
                jSONObject.put("ext", this.f8225h);
                return jSONObject;
            } catch (JSONException e2) {
                if (f8218j) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
