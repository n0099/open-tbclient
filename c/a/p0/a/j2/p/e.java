package c.a.p0.a.j2.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.j2.j;
import c.a.p0.a.k;
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
    public static final boolean f7062j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f7063a;

    /* renamed from: b  reason: collision with root package name */
    public String f7064b;

    /* renamed from: c  reason: collision with root package name */
    public String f7065c;

    /* renamed from: d  reason: collision with root package name */
    public String f7066d;

    /* renamed from: e  reason: collision with root package name */
    public String f7067e;

    /* renamed from: f  reason: collision with root package name */
    public String f7068f;

    /* renamed from: g  reason: collision with root package name */
    public String f7069g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f7070h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f7071i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1375564731, "Lc/a/p0/a/j2/p/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1375564731, "Lc/a/p0/a/j2/p/e;");
                return;
            }
        }
        f7062j = k.f7077a;
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
        this.f7063a = "swan";
    }

    public void a(@NonNull String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (this.f7070h == null) {
                this.f7070h = new JSONObject();
            }
            try {
                this.f7070h.put(str, obj);
            } catch (JSONException e2) {
                if (f7062j) {
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
        if (this.f7070h == null) {
            this.f7070h = new JSONObject();
        }
        JSONObject optJSONObject = this.f7070h.optJSONObject("extlog");
        this.f7071i = optJSONObject;
        if (optJSONObject == null) {
            this.f7071i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f7071i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f7062j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f7070h.put("extlog", this.f7071i);
        } catch (JSONException e3) {
            if (f7062j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f7070h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f7070h.toString());
            } catch (JSONException e2) {
                if (f7062j) {
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
            if (f7062j) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.f7070h == null) {
            this.f7070h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f7070h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f7062j) {
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
                if (!TextUtils.isEmpty(this.f7063a)) {
                    jSONObject.put("from", this.f7063a);
                }
                if (!TextUtils.isEmpty(this.f7064b)) {
                    jSONObject.put("type", this.f7064b);
                }
                if (!TextUtils.isEmpty(this.f7067e)) {
                    jSONObject.put("value", this.f7067e);
                }
                if (TextUtils.isEmpty(this.f7065c)) {
                    this.f7065c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                jSONObject.put("source", this.f7065c);
                if (!TextUtils.isEmpty(this.f7069g)) {
                    String a2 = j.a(this.f7069g);
                    this.f7069g = a2;
                    jSONObject.put("page", a2);
                }
                if (this.f7070h == null) {
                    this.f7070h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f7068f)) {
                    this.f7070h.put("appid", this.f7068f);
                }
                if (!TextUtils.isEmpty(this.f7066d)) {
                    this.f7070h.put("launchid", this.f7066d);
                }
                jSONObject.put("ext", this.f7070h);
                return jSONObject;
            } catch (JSONException e2) {
                if (f7062j) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
