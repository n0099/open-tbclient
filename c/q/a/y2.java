package c.q.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes9.dex */
public class y2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public JSONStringer f30529b;

    /* renamed from: c  reason: collision with root package name */
    public String f30530c;

    public y2(c3 c3Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c3Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30529b = new JSONStringer();
        this.f30530c = "";
        this.a = context;
    }

    public y2 a(int i2, long j2) {
        JSONStringer object;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            try {
                object = new JSONStringer().object();
                this.f30529b = object;
                l("e", "bce");
                l("timeis", c3.e());
                k("co", i2);
                k("dr", j2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeCommon.objValue;
    }

    public y2 b(g3 g3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g3Var)) == null) {
            try {
                this.f30529b = c3.d("ao", g3Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeL.objValue;
    }

    public y2 c(g3 g3Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, g3Var, i2)) == null) {
            try {
                this.f30529b = c3.d("rle", g3Var);
                k("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeLI.objValue;
    }

    public y2 d(g3 g3Var, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, g3Var, i2, i3)) == null) {
            try {
                this.f30529b = c3.d("asr", g3Var);
                k("width", i2);
                k("height", i3);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeLII.objValue;
    }

    public y2 e(g3 g3Var, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{g3Var, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            try {
                this.f30529b = c3.d("bpe", g3Var);
                k("co", i2);
                k("dr", j2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeCommon.objValue;
    }

    public y2 f(g3 g3Var, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, g3Var, i2, str)) == null) {
            try {
                this.f30529b = c3.d("wbe", g3Var);
                k("co", i2);
                l("msg", c3.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeLIL.objValue;
    }

    public y2 g(g3 g3Var, long j2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{g3Var, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            try {
                this.f30529b = c3.d("be", g3Var);
                k("dr", j2);
                k("co", i2);
                k("num", i3);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeCommon.objValue;
    }

    public y2 h(g3 g3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, g3Var, str)) == null) {
            try {
                this.f30529b = c3.d("ac", g3Var);
                l("msg", c3.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeLL.objValue;
    }

    public y2 i(g3 g3Var, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, g3Var, str, i2)) == null) {
            try {
                this.f30529b = c3.d("dplop", g3Var);
                l("msg", c3.b(str));
                k("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeLLI.objValue;
    }

    public y2 j(g3 g3Var, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, g3Var, str, i2, i3)) == null) {
            try {
                this.f30529b = c3.d("wdre", g3Var);
                try {
                    str = r0.g(str);
                } catch (Exception unused) {
                }
                l("pkg", str);
                k("vsc", i2);
                k("co", i3);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (y2) invokeLLII.objValue;
    }

    public y2 k(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j2)) == null) {
            try {
                this.f30529b.key(str).value(j2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeLJ.objValue;
    }

    public y2 l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.f30529b.key(str).value(str2);
                }
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeLL.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.f30529b.toString())) {
                    this.f30529b.endObject();
                    this.f30530c = this.f30529b.toString();
                }
                JSONObject jSONObject = new JSONObject(this.f30530c);
                String optString = jSONObject.optString("e");
                if (n(optString)) {
                    return;
                }
                boolean z = !r0.u(c3.a, optString);
                jSONArray.put(jSONObject);
                t2.b(new v2(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (m2.G(this.a) < 0) {
                return false;
            }
            return r0.u(c3.a, str) ? m2.G(this.a) < 1 : r0.u(c3.f30298b, str) ? m2.G(this.a) < 2 : r0.u(c3.f30299c, str) ? m2.G(this.a) < 3 : r0.u(c3.f30300d, str) && m2.G(this.a) < 4;
        }
        return invokeL.booleanValue;
    }

    public y2 o(g3 g3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, g3Var)) == null) {
            try {
                this.f30529b = c3.d("as", g3Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeL.objValue;
    }

    public y2 p(g3 g3Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, g3Var, i2)) == null) {
            try {
                this.f30529b = c3.d("wde", g3Var);
                k("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeLI.objValue;
    }

    public y2 q(g3 g3Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, g3Var, i2)) == null) {
            try {
                this.f30529b = c3.d("wdin", g3Var);
                k("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (y2) invokeLI.objValue;
    }
}
