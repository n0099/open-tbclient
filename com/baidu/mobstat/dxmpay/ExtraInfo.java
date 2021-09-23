package com.baidu.mobstat.dxmpay;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ExtraInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f43762a;

    /* renamed from: b  reason: collision with root package name */
    public String f43763b;

    /* renamed from: c  reason: collision with root package name */
    public String f43764c;

    /* renamed from: d  reason: collision with root package name */
    public String f43765d;

    /* renamed from: e  reason: collision with root package name */
    public String f43766e;

    /* renamed from: f  reason: collision with root package name */
    public String f43767f;

    /* renamed from: g  reason: collision with root package name */
    public String f43768g;

    /* renamed from: h  reason: collision with root package name */
    public String f43769h;

    /* renamed from: i  reason: collision with root package name */
    public String f43770i;

    /* renamed from: j  reason: collision with root package name */
    public String f43771j;

    public ExtraInfo() {
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
        this.f43762a = "";
        this.f43763b = "";
        this.f43764c = "";
        this.f43765d = "";
        this.f43766e = "";
        this.f43767f = "";
        this.f43768g = "";
        this.f43769h = "";
        this.f43770i = "";
        this.f43771j = "";
    }

    public static boolean a(String str, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            if (str == null) {
                return false;
            }
            try {
                i3 = str.getBytes().length;
            } catch (Exception unused) {
                i3 = 0;
            }
            return i3 > i2;
        }
        return invokeLI.booleanValue;
    }

    public JSONObject dumpToJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.f43762a)) {
                    jSONObject.put("v1", this.f43762a);
                }
                if (!TextUtils.isEmpty(this.f43763b)) {
                    jSONObject.put("v2", this.f43763b);
                }
                if (!TextUtils.isEmpty(this.f43764c)) {
                    jSONObject.put("v3", this.f43764c);
                }
                if (!TextUtils.isEmpty(this.f43765d)) {
                    jSONObject.put("v4", this.f43765d);
                }
                if (!TextUtils.isEmpty(this.f43766e)) {
                    jSONObject.put("v5", this.f43766e);
                }
                if (!TextUtils.isEmpty(this.f43767f)) {
                    jSONObject.put("v6", this.f43767f);
                }
                if (!TextUtils.isEmpty(this.f43768g)) {
                    jSONObject.put("v7", this.f43768g);
                }
                if (!TextUtils.isEmpty(this.f43769h)) {
                    jSONObject.put(V8Engine.TYPE_V8, this.f43769h);
                }
                if (!TextUtils.isEmpty(this.f43770i)) {
                    jSONObject.put("v9", this.f43770i);
                }
                if (!TextUtils.isEmpty(this.f43771j)) {
                    jSONObject.put("v10", this.f43771j);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String getV1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43762a : (String) invokeV.objValue;
    }

    public String getV10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43771j : (String) invokeV.objValue;
    }

    public String getV2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43763b : (String) invokeV.objValue;
    }

    public String getV3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43764c : (String) invokeV.objValue;
    }

    public String getV4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43765d : (String) invokeV.objValue;
    }

    public String getV5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f43766e : (String) invokeV.objValue;
    }

    public String getV6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43767f : (String) invokeV.objValue;
    }

    public String getV7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f43768g : (String) invokeV.objValue;
    }

    public String getV8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f43769h : (String) invokeV.objValue;
    }

    public String getV9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f43770i : (String) invokeV.objValue;
    }

    public void setV1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f43762a = a(str);
        }
    }

    public void setV10(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f43771j = a(str);
        }
    }

    public void setV2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f43763b = a(str);
        }
    }

    public void setV3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f43764c = a(str);
        }
    }

    public void setV4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f43765d = a(str);
        }
    }

    public void setV5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f43766e = a(str);
        }
    }

    public void setV6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f43767f = a(str);
        }
    }

    public void setV7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f43768g = a(str);
        }
    }

    public void setV8(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f43769h = a(str);
        }
    }

    public void setV9(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f43770i = a(str);
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            return a(str, 1024) ? "" : str;
        }
        return (String) invokeL.objValue;
    }
}
