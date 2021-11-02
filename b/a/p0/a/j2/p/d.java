package b.a.p0.a.j2.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
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
public class d extends f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean x;
    public static int y;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean v;
    public JSONObject w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865030585, "Lb/a/p0/a/j2/p/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865030585, "Lb/a/p0/a/j2/p/d;");
                return;
            }
        }
        x = k.f6397a;
        y = 35;
    }

    public d() {
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
        this.v = false;
        this.f6385c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
    }

    @Override // b.a.p0.a.j2.p.f, b.a.p0.a.j2.p.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f6390h == null) {
                this.f6390h = new JSONObject();
            }
            try {
                if (this.w != null) {
                    if (this.v) {
                        String z = q0.z(y);
                        if (!TextUtils.isEmpty(z)) {
                            this.w.put("stacktrace", z);
                        }
                    }
                    if (this.w.length() != 0) {
                        this.f6390h.put("info", this.w);
                    }
                }
                ExtensionCore L = b.a.p0.a.h0.u.g.M().L();
                if (L != null) {
                    this.f6390h.put("extension_ver", L.extensionCoreVersionName);
                }
            } catch (JSONException e2) {
                if (x) {
                    e2.printStackTrace();
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public d l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (str != null && str2 != null) {
                if (this.w == null) {
                    this.w = new JSONObject();
                }
                try {
                    this.w.put(str, str2);
                } catch (JSONException e2) {
                    if (x) {
                        e2.printStackTrace();
                    }
                }
            }
            return this;
        }
        return (d) invokeLL.objValue;
    }

    public d m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f6388f = str;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.v = z;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public d o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f6384b = String.valueOf(i2);
            return this;
        }
        return (d) invokeI.objValue;
    }

    public d p(@NonNull b.a.p0.a.q2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            this.f6384b = String.valueOf(aVar.a());
            String sb = aVar.f().toString();
            if (!TextUtils.isEmpty(sb)) {
                l("detail", sb);
            }
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f6383a = str;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d r(b.a.p0.a.f1.e.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar == null) {
                return this;
            }
            if (!TextUtils.isEmpty(eVar.S())) {
                this.f6385c = eVar.S();
            }
            if (!TextUtils.isEmpty(eVar.G())) {
                this.f6388f = eVar.G();
            }
            if (!TextUtils.isEmpty(eVar.V())) {
                this.p = eVar.V();
            }
            if (!TextUtils.isEmpty(eVar.d0())) {
                this.s = eVar.d0();
            }
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.f6389g = str;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f6385c = str;
            return this;
        }
        return (d) invokeL.objValue;
    }
}
