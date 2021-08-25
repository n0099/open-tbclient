package c.a.o0.a.e2.c.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1513078737, "Lc/a/o0/a/e2/c/j/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1513078737, "Lc/a/o0/a/e2/c/j/g;");
                return;
            }
        }
        r = k.f7049a;
    }

    public g(Activity activity, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    @Override // c.a.o0.a.e2.c.j.h
    public SwanInterfaceType A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SwanInterfaceType.OPEN_DATA : (SwanInterfaceType) invokeV.objValue;
    }

    @Override // c.a.o0.a.e2.c.j.h
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.o0.a.e2.c.b.b() && !R() : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.e2.c.j.h
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q++;
        }
    }

    public JSONObject Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                c.a.o0.a.a2.e N = N();
                jSONObject.put("ma_id", N.D());
                jSONObject.put("scope", this.n);
                jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject.put("host_key_hash", c.a.o0.a.e2.c.d.g());
                jSONObject.put("app_key", N.D());
                if (N.N() != null && N.N().T() != null) {
                    jSONObject.put("scene", N.N().T());
                }
                if (this.p) {
                    jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
                }
                String l = c.a.o0.a.c1.a.n().l();
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

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q >= B() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.e2.c.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: S */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            JSONObject c2 = c.a.o0.a.e2.c.d.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    c.a.o0.a.e2.c.d.l(c2);
                    c.a.o0.a.e2.c.d.s("MaOpenDataRequest", c2.toString());
                }
                if (r) {
                    throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
                }
            }
            return c2;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // c.a.o0.a.e2.c.c
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            w("data", Q().toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar)) == null) ? c.a.o0.a.c1.a.n().s(this.m, hVar.C()) : (HttpRequest) invokeL.objValue;
    }
}
