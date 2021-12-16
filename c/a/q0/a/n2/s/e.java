package c.a.q0.a.n2.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.q0.a.k;
import c.a.q0.a.n2.m;
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
    public static final boolean f7421j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f7422b;

    /* renamed from: c  reason: collision with root package name */
    public String f7423c;

    /* renamed from: d  reason: collision with root package name */
    public String f7424d;

    /* renamed from: e  reason: collision with root package name */
    public String f7425e;

    /* renamed from: f  reason: collision with root package name */
    public String f7426f;

    /* renamed from: g  reason: collision with root package name */
    public String f7427g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f7428h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f7429i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1991345211, "Lc/a/q0/a/n2/s/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1991345211, "Lc/a/q0/a/n2/s/e;");
                return;
            }
        }
        f7421j = k.a;
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
            if (this.f7428h == null) {
                this.f7428h = new JSONObject();
            }
            try {
                this.f7428h.put(str, obj);
            } catch (JSONException e2) {
                if (f7421j) {
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
        if (this.f7428h == null) {
            this.f7428h = new JSONObject();
        }
        JSONObject optJSONObject = this.f7428h.optJSONObject("extlog");
        this.f7429i = optJSONObject;
        if (optJSONObject == null) {
            this.f7429i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f7429i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f7421j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f7428h.put("extlog", this.f7429i);
        } catch (JSONException e3) {
            if (f7421j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f7428h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f7428h.toString());
            } catch (JSONException e2) {
                if (f7421j) {
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
            if (f7421j) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.f7428h == null) {
            this.f7428h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f7428h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f7421j) {
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
                if (!TextUtils.isEmpty(this.f7422b)) {
                    jSONObject.put("type", this.f7422b);
                }
                if (!TextUtils.isEmpty(this.f7425e)) {
                    jSONObject.put("value", this.f7425e);
                }
                if (TextUtils.isEmpty(this.f7423c)) {
                    this.f7423c = "NA";
                }
                jSONObject.put("source", this.f7423c);
                if (!TextUtils.isEmpty(this.f7427g)) {
                    String b2 = m.b(this.f7427g);
                    this.f7427g = b2;
                    jSONObject.put("page", b2);
                }
                if (this.f7428h == null) {
                    this.f7428h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f7426f)) {
                    this.f7428h.put("appid", this.f7426f);
                }
                if (!TextUtils.isEmpty(this.f7424d)) {
                    this.f7428h.put("launchid", this.f7424d);
                }
                m.a(this.f7428h);
                jSONObject.put("ext", this.f7428h);
                return jSONObject;
            } catch (JSONException e2) {
                if (f7421j) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
