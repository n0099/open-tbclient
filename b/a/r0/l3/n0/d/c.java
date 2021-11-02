package b.a.r0.l3.n0.d;

import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f20721a;

    /* renamed from: b  reason: collision with root package name */
    public int f20722b;

    /* renamed from: c  reason: collision with root package name */
    public String f20723c;

    /* renamed from: d  reason: collision with root package name */
    public String f20724d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20725e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20726f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20727g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20728h;

    /* renamed from: i  reason: collision with root package name */
    public String f20729i;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20722b = -1;
        this.f20727g = true;
        this.f20728h = false;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20724d : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20723c : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20721a : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f20728h) {
                return m();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", this.f20722b);
                jSONObject.put("message", this.f20723c);
                if (StringHelper.isJSONObject(this.f20724d)) {
                    jSONObject.put("data", new JSONObject(this.f20724d));
                } else if (StringHelper.isJSONArray(this.f20724d)) {
                    jSONObject.put("data", new JSONArray(this.f20724d));
                } else {
                    jSONObject.put("data", this.f20724d);
                }
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20729i : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20722b : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20727g : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20722b > 0 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20725e : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f20726f : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f20722b != -1 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f20728h : invokeV.booleanValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return StringUtil.ARRAY_START + "\"status\":\"" + this.f20722b + "\",\"message\":\"" + this.f20723c + "\",\"data\":" + this.f20724d + "}";
        }
        return (String) invokeV.objValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f20727g = z;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f20724d = str;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            u(TbadkCoreApplication.getInst().getString(R.string.na_business_error));
            y(401);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            u(str);
            y(401);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f20725e = z;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f20726f = z;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f20723c = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && k.isEmpty(this.f20723c)) {
            this.f20723c = str;
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f20721a = str;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f20729i = str;
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f20722b = i2;
            if (i2 == 0) {
                u(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
            } else if (i2 == 101) {
                u(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
            } else if (i2 == 301) {
                u(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
            } else if (i2 == 201) {
                u(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
            } else if (i2 != 202) {
            } else {
                u(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
            }
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && this.f20722b == -1) {
            x(i2);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f20728h = z;
        }
    }
}
