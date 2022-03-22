package c.a.n0.a.d2.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.d2.m;
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
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f4188b;

    /* renamed from: c  reason: collision with root package name */
    public String f4189c;

    /* renamed from: d  reason: collision with root package name */
    public String f4190d;

    /* renamed from: e  reason: collision with root package name */
    public String f4191e;

    /* renamed from: f  reason: collision with root package name */
    public String f4192f;

    /* renamed from: g  reason: collision with root package name */
    public String f4193g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f4194h;
    public JSONObject i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1631271710, "Lc/a/n0/a/d2/s/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1631271710, "Lc/a/n0/a/d2/s/e;");
                return;
            }
        }
        j = c.a.n0.a.a.a;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (this.f4194h == null) {
                this.f4194h = new JSONObject();
            }
            try {
                this.f4194h.put(str, obj);
            } catch (JSONException e2) {
                if (j) {
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
        if (this.f4194h == null) {
            this.f4194h = new JSONObject();
        }
        JSONObject optJSONObject = this.f4194h.optJSONObject("extlog");
        this.i = optJSONObject;
        if (optJSONObject == null) {
            this.i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f4194h.put("extlog", this.i);
        } catch (JSONException e3) {
            if (j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f4194h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f4194h.toString());
            } catch (JSONException e2) {
                if (j) {
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
            if (j) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.f4194h == null) {
            this.f4194h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f4194h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
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
                if (!TextUtils.isEmpty(this.f4188b)) {
                    jSONObject.put("type", this.f4188b);
                }
                if (!TextUtils.isEmpty(this.f4191e)) {
                    jSONObject.put("value", this.f4191e);
                }
                if (TextUtils.isEmpty(this.f4189c)) {
                    this.f4189c = "NA";
                }
                jSONObject.put("source", this.f4189c);
                if (!TextUtils.isEmpty(this.f4193g)) {
                    String b2 = m.b(this.f4193g);
                    this.f4193g = b2;
                    jSONObject.put("page", b2);
                }
                if (this.f4194h == null) {
                    this.f4194h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f4192f)) {
                    this.f4194h.put("appid", this.f4192f);
                }
                if (!TextUtils.isEmpty(this.f4190d)) {
                    this.f4194h.put("launchid", this.f4190d);
                }
                m.a(this.f4194h);
                jSONObject.put("ext", this.f4194h);
                return jSONObject;
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
