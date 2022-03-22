package c.a.n0.a.x1.c.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends h<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity m;
    public final String n;
    public final String o;
    public boolean p;
    public int q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(293930598, "Lc/a/n0/a/x1/c/j/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(293930598, "Lc/a/n0/a/x1/c/j/g;");
                return;
            }
        }
        r = c.a.n0.a.a.a;
    }

    public g(Activity activity, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = activity;
        this.n = str;
        this.o = str2;
        this.p = z;
    }

    @Override // c.a.n0.a.x1.c.j.h
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.n0.a.x1.c.b.b() && !Q() : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x1.c.j.h
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q++;
        }
    }

    public JSONObject P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                c.a.n0.a.t1.e M = M();
                jSONObject.put("ma_id", M.N());
                jSONObject.put("scope", this.n);
                jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject.put("host_key_hash", c.a.n0.a.x1.c.d.g());
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, M.N());
                if (M.X() != null && M.X().T() != null) {
                    jSONObject.put("scene", M.X().T());
                }
                if (this.p) {
                    jSONObject.put("action_type", "1");
                }
                String l = c.a.n0.a.s0.a.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject.put("host_api_key", l);
                }
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("provider_appkey", this.o);
                }
            } catch (JSONException e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q >= A() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.x1.c.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: R */
    public JSONObject m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            JSONObject c2 = c.a.n0.a.x1.c.d.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    c.a.n0.a.x1.c.d.m(c2);
                    c.a.n0.a.x1.c.d.t("MaOpenDataRequest", c2.toString());
                }
                if (r) {
                    throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
                }
            }
            return c2;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // c.a.n0.a.x1.c.c
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            v("data", P().toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x1.c.j.h
    public HttpRequest w(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hVar)) == null) ? c.a.n0.a.s0.a.o().u(this.m, hVar.B()) : (HttpRequest) invokeL.objValue;
    }

    @Override // c.a.n0.a.x1.c.j.h
    public SwanInterfaceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? SwanInterfaceType.OPEN_DATA : (SwanInterfaceType) invokeV.objValue;
    }
}
