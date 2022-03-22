package c.m.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.d.D;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes3.dex */
public class t2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public JSONStringer f23575b;

    /* renamed from: c  reason: collision with root package name */
    public String f23576c;

    public t2(x2 x2Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x2Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23575b = new JSONStringer();
        this.f23576c = "";
        this.a = context;
    }

    public t2 a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.f23575b = x2.c();
                l("e", "bce");
                l("timeis", x2.e());
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeCommon.objValue;
    }

    public t2 b(b3 b3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b3Var)) == null) {
            try {
                this.f23575b = x2.d("ao", b3Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeL.objValue;
    }

    public t2 c(b3 b3Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, b3Var, i)) == null) {
            try {
                this.f23575b = x2.d("rle", b3Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeLI.objValue;
    }

    public t2 d(b3 b3Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, b3Var, i, i2)) == null) {
            try {
                this.f23575b = x2.d("asr", b3Var);
                k("width", i);
                k("height", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeLII.objValue;
    }

    public t2 e(b3 b3Var, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{b3Var, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.f23575b = x2.d("bpe", b3Var);
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeCommon.objValue;
    }

    public t2 f(b3 b3Var, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, b3Var, i, str)) == null) {
            try {
                this.f23575b = x2.d("wbe", b3Var);
                k("co", i);
                l("msg", x2.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeLIL.objValue;
    }

    public t2 g(b3 b3Var, long j, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{b3Var, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                this.f23575b = x2.d("be", b3Var);
                k("dr", j);
                k("co", i);
                k("num", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeCommon.objValue;
    }

    public t2 h(b3 b3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, b3Var, str)) == null) {
            try {
                this.f23575b = x2.d(D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, b3Var);
                l("msg", x2.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeLL.objValue;
    }

    public t2 i(b3 b3Var, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, b3Var, str, i)) == null) {
            try {
                this.f23575b = x2.d("dplop", b3Var);
                l("msg", x2.b(str));
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeLLI.objValue;
    }

    public t2 j(b3 b3Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, b3Var, str, i, i2)) == null) {
            try {
                this.f23575b = x2.d("wdre", b3Var);
                try {
                    str = r0.g(str);
                } catch (Exception unused) {
                }
                l("pkg", str);
                k("vsc", i);
                k("co", i2);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (t2) invokeLLII.objValue;
    }

    public t2 k(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            try {
                this.f23575b.key(str).value(j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeLJ.objValue;
    }

    public t2 l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.f23575b.key(str).value(str2);
                }
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeLL.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.f23575b.toString())) {
                    this.f23575b.endObject();
                    this.f23576c = this.f23575b.toString();
                }
                JSONObject jSONObject = new JSONObject(this.f23576c);
                String optString = jSONObject.optString("e");
                if (n(optString)) {
                    return;
                }
                boolean z = !r0.u(x2.a, optString);
                jSONArray.put(jSONObject);
                o2.b(new q2(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (h2.G(this.a) < 0) {
                return false;
            }
            return r0.u(x2.a, str) ? h2.G(this.a) < 1 : r0.u(x2.f23608b, str) ? h2.G(this.a) < 2 : r0.u(x2.f23609c, str) ? h2.G(this.a) < 3 : r0.u(x2.f23610d, str) && h2.G(this.a) < 4;
        }
        return invokeL.booleanValue;
    }

    public t2 o(b3 b3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, b3Var)) == null) {
            try {
                this.f23575b = x2.d("as", b3Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeL.objValue;
    }

    public t2 p(b3 b3Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, b3Var, i)) == null) {
            try {
                this.f23575b = x2.d("wde", b3Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeLI.objValue;
    }

    public t2 q(b3 b3Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, b3Var, i)) == null) {
            try {
                this.f23575b = x2.d("wdin", b3Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (t2) invokeLI.objValue;
    }
}
