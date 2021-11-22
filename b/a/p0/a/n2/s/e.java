package b.a.p0.a.n2.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
import b.a.p0.a.n2.m;
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
    public String f7379a;

    /* renamed from: b  reason: collision with root package name */
    public String f7380b;

    /* renamed from: c  reason: collision with root package name */
    public String f7381c;

    /* renamed from: d  reason: collision with root package name */
    public String f7382d;

    /* renamed from: e  reason: collision with root package name */
    public String f7383e;

    /* renamed from: f  reason: collision with root package name */
    public String f7384f;

    /* renamed from: g  reason: collision with root package name */
    public String f7385g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f7386h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f7387i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1609893753, "Lb/a/p0/a/n2/s/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1609893753, "Lb/a/p0/a/n2/s/e;");
                return;
            }
        }
        j = k.f6863a;
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
        this.f7379a = "swan";
    }

    public void a(@NonNull String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (this.f7386h == null) {
                this.f7386h = new JSONObject();
            }
            try {
                this.f7386h.put(str, obj);
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
        if (this.f7386h == null) {
            this.f7386h = new JSONObject();
        }
        JSONObject optJSONObject = this.f7386h.optJSONObject("extlog");
        this.f7387i = optJSONObject;
        if (optJSONObject == null) {
            this.f7387i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f7387i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f7386h.put("extlog", this.f7387i);
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
            if (this.f7386h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f7386h.toString());
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
        if (this.f7386h == null) {
            this.f7386h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f7386h.put(next, jSONObject.opt(next));
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
                if (!TextUtils.isEmpty(this.f7379a)) {
                    jSONObject.put("from", this.f7379a);
                }
                if (!TextUtils.isEmpty(this.f7380b)) {
                    jSONObject.put("type", this.f7380b);
                }
                if (!TextUtils.isEmpty(this.f7383e)) {
                    jSONObject.put("value", this.f7383e);
                }
                if (TextUtils.isEmpty(this.f7381c)) {
                    this.f7381c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                jSONObject.put("source", this.f7381c);
                if (!TextUtils.isEmpty(this.f7385g)) {
                    String b2 = m.b(this.f7385g);
                    this.f7385g = b2;
                    jSONObject.put("page", b2);
                }
                if (this.f7386h == null) {
                    this.f7386h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f7384f)) {
                    this.f7386h.put("appid", this.f7384f);
                }
                if (!TextUtils.isEmpty(this.f7382d)) {
                    this.f7386h.put("launchid", this.f7382d);
                }
                m.a(this.f7386h);
                jSONObject.put("ext", this.f7386h);
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
