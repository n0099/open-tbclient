package b.a.p0.a.j2.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.j2.j;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
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

    /* renamed from: a  reason: collision with root package name */
    public String f6383a;

    /* renamed from: b  reason: collision with root package name */
    public String f6384b;

    /* renamed from: c  reason: collision with root package name */
    public String f6385c;

    /* renamed from: d  reason: collision with root package name */
    public String f6386d;

    /* renamed from: e  reason: collision with root package name */
    public String f6387e;

    /* renamed from: f  reason: collision with root package name */
    public String f6388f;

    /* renamed from: g  reason: collision with root package name */
    public String f6389g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f6390h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f6391i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865030554, "Lb/a/p0/a/j2/p/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865030554, "Lb/a/p0/a/j2/p/e;");
                return;
            }
        }
        j = k.f6397a;
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
        this.f6383a = "swan";
    }

    public void a(@NonNull String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (this.f6390h == null) {
                this.f6390h = new JSONObject();
            }
            try {
                this.f6390h.put(str, obj);
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
        if (this.f6390h == null) {
            this.f6390h = new JSONObject();
        }
        JSONObject optJSONObject = this.f6390h.optJSONObject("extlog");
        this.f6391i = optJSONObject;
        if (optJSONObject == null) {
            this.f6391i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f6391i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f6390h.put("extlog", this.f6391i);
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
            if (this.f6390h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f6390h.toString());
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
        if (this.f6390h == null) {
            this.f6390h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f6390h.put(next, jSONObject.opt(next));
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
                if (!TextUtils.isEmpty(this.f6383a)) {
                    jSONObject.put("from", this.f6383a);
                }
                if (!TextUtils.isEmpty(this.f6384b)) {
                    jSONObject.put("type", this.f6384b);
                }
                if (!TextUtils.isEmpty(this.f6387e)) {
                    jSONObject.put("value", this.f6387e);
                }
                if (TextUtils.isEmpty(this.f6385c)) {
                    this.f6385c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                jSONObject.put("source", this.f6385c);
                if (!TextUtils.isEmpty(this.f6389g)) {
                    String a2 = j.a(this.f6389g);
                    this.f6389g = a2;
                    jSONObject.put("page", a2);
                }
                if (this.f6390h == null) {
                    this.f6390h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f6388f)) {
                    this.f6390h.put("appid", this.f6388f);
                }
                if (!TextUtils.isEmpty(this.f6386d)) {
                    this.f6390h.put("launchid", this.f6386d);
                }
                jSONObject.put("ext", this.f6390h);
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
