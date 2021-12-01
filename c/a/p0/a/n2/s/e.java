package c.a.p0.a.n2.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.k;
import c.a.p0.a.n2.m;
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
    public static final boolean f7112j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f7113b;

    /* renamed from: c  reason: collision with root package name */
    public String f7114c;

    /* renamed from: d  reason: collision with root package name */
    public String f7115d;

    /* renamed from: e  reason: collision with root package name */
    public String f7116e;

    /* renamed from: f  reason: collision with root package name */
    public String f7117f;

    /* renamed from: g  reason: collision with root package name */
    public String f7118g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f7119h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f7120i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2120427930, "Lc/a/p0/a/n2/s/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2120427930, "Lc/a/p0/a/n2/s/e;");
                return;
            }
        }
        f7112j = k.a;
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
            if (this.f7119h == null) {
                this.f7119h = new JSONObject();
            }
            try {
                this.f7119h.put(str, obj);
            } catch (JSONException e2) {
                if (f7112j) {
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
        if (this.f7119h == null) {
            this.f7119h = new JSONObject();
        }
        JSONObject optJSONObject = this.f7119h.optJSONObject("extlog");
        this.f7120i = optJSONObject;
        if (optJSONObject == null) {
            this.f7120i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f7120i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f7112j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f7119h.put("extlog", this.f7120i);
        } catch (JSONException e3) {
            if (f7112j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f7119h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f7119h.toString());
            } catch (JSONException e2) {
                if (f7112j) {
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
            if (f7112j) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.f7119h == null) {
            this.f7119h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f7119h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f7112j) {
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
                if (!TextUtils.isEmpty(this.f7113b)) {
                    jSONObject.put("type", this.f7113b);
                }
                if (!TextUtils.isEmpty(this.f7116e)) {
                    jSONObject.put("value", this.f7116e);
                }
                if (TextUtils.isEmpty(this.f7114c)) {
                    this.f7114c = "NA";
                }
                jSONObject.put("source", this.f7114c);
                if (!TextUtils.isEmpty(this.f7118g)) {
                    String b2 = m.b(this.f7118g);
                    this.f7118g = b2;
                    jSONObject.put("page", b2);
                }
                if (this.f7119h == null) {
                    this.f7119h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f7117f)) {
                    this.f7119h.put("appid", this.f7117f);
                }
                if (!TextUtils.isEmpty(this.f7115d)) {
                    this.f7119h.put("launchid", this.f7115d);
                }
                m.a(this.f7119h);
                jSONObject.put("ext", this.f7119h);
                return jSONObject;
            } catch (JSONException e2) {
                if (f7112j) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
