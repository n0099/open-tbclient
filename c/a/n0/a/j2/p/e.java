package c.a.n0.a.j2.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.j2.j;
import c.a.n0.a.k;
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

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f6788j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f6789a;

    /* renamed from: b  reason: collision with root package name */
    public String f6790b;

    /* renamed from: c  reason: collision with root package name */
    public String f6791c;

    /* renamed from: d  reason: collision with root package name */
    public String f6792d;

    /* renamed from: e  reason: collision with root package name */
    public String f6793e;

    /* renamed from: f  reason: collision with root package name */
    public String f6794f;

    /* renamed from: g  reason: collision with root package name */
    public String f6795g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f6796h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f6797i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1633730169, "Lc/a/n0/a/j2/p/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1633730169, "Lc/a/n0/a/j2/p/e;");
                return;
            }
        }
        f6788j = k.f6803a;
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
        this.f6789a = "swan";
    }

    public void a(@NonNull String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (this.f6796h == null) {
                this.f6796h = new JSONObject();
            }
            try {
                this.f6796h.put(str, obj);
            } catch (JSONException e2) {
                if (f6788j) {
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
        if (this.f6796h == null) {
            this.f6796h = new JSONObject();
        }
        JSONObject optJSONObject = this.f6796h.optJSONObject("extlog");
        this.f6797i = optJSONObject;
        if (optJSONObject == null) {
            this.f6797i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f6797i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f6788j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f6796h.put("extlog", this.f6797i);
        } catch (JSONException e3) {
            if (f6788j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f6796h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f6796h.toString());
            } catch (JSONException e2) {
                if (f6788j) {
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
            if (f6788j) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.f6796h == null) {
            this.f6796h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f6796h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f6788j) {
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
                if (!TextUtils.isEmpty(this.f6789a)) {
                    jSONObject.put("from", this.f6789a);
                }
                if (!TextUtils.isEmpty(this.f6790b)) {
                    jSONObject.put("type", this.f6790b);
                }
                if (!TextUtils.isEmpty(this.f6793e)) {
                    jSONObject.put("value", this.f6793e);
                }
                if (TextUtils.isEmpty(this.f6791c)) {
                    this.f6791c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                jSONObject.put("source", this.f6791c);
                if (!TextUtils.isEmpty(this.f6795g)) {
                    String a2 = j.a(this.f6795g);
                    this.f6795g = a2;
                    jSONObject.put("page", a2);
                }
                if (this.f6796h == null) {
                    this.f6796h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f6794f)) {
                    this.f6796h.put("appid", this.f6794f);
                }
                if (!TextUtils.isEmpty(this.f6792d)) {
                    this.f6796h.put("launchid", this.f6792d);
                }
                jSONObject.put("ext", this.f6796h);
                return jSONObject;
            } catch (JSONException e2) {
                if (f6788j) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
