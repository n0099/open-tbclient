package com.baidu.mobstat;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.disk.DefaultDiskStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExtraInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8530a;

    /* renamed from: b  reason: collision with root package name */
    public String f8531b;

    /* renamed from: c  reason: collision with root package name */
    public String f8532c;

    /* renamed from: d  reason: collision with root package name */
    public String f8533d;

    /* renamed from: e  reason: collision with root package name */
    public String f8534e;

    /* renamed from: f  reason: collision with root package name */
    public String f8535f;

    /* renamed from: g  reason: collision with root package name */
    public String f8536g;

    /* renamed from: h  reason: collision with root package name */
    public String f8537h;

    /* renamed from: i  reason: collision with root package name */
    public String f8538i;
    public String j;

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
        this.f8530a = "";
        this.f8531b = "";
        this.f8532c = "";
        this.f8533d = "";
        this.f8534e = "";
        this.f8535f = "";
        this.f8536g = "";
        this.f8537h = "";
        this.f8538i = "";
        this.j = "";
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
                if (!TextUtils.isEmpty(this.f8530a)) {
                    jSONObject.put("v1", this.f8530a);
                }
                if (!TextUtils.isEmpty(this.f8531b)) {
                    jSONObject.put(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, this.f8531b);
                }
                if (!TextUtils.isEmpty(this.f8532c)) {
                    jSONObject.put("v3", this.f8532c);
                }
                if (!TextUtils.isEmpty(this.f8533d)) {
                    jSONObject.put("v4", this.f8533d);
                }
                if (!TextUtils.isEmpty(this.f8534e)) {
                    jSONObject.put("v5", this.f8534e);
                }
                if (!TextUtils.isEmpty(this.f8535f)) {
                    jSONObject.put("v6", this.f8535f);
                }
                if (!TextUtils.isEmpty(this.f8536g)) {
                    jSONObject.put("v7", this.f8536g);
                }
                if (!TextUtils.isEmpty(this.f8537h)) {
                    jSONObject.put(V8Engine.TYPE_V8, this.f8537h);
                }
                if (!TextUtils.isEmpty(this.f8538i)) {
                    jSONObject.put("v9", this.f8538i);
                }
                if (!TextUtils.isEmpty(this.j)) {
                    jSONObject.put("v10", this.j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f8530a : (String) invokeV.objValue;
    }

    public String getV10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String getV2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f8531b : (String) invokeV.objValue;
    }

    public String getV3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8532c : (String) invokeV.objValue;
    }

    public String getV4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f8533d : (String) invokeV.objValue;
    }

    public String getV5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8534e : (String) invokeV.objValue;
    }

    public String getV6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f8535f : (String) invokeV.objValue;
    }

    public String getV7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f8536g : (String) invokeV.objValue;
    }

    public String getV8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f8537h : (String) invokeV.objValue;
    }

    public String getV9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f8538i : (String) invokeV.objValue;
    }

    public void setV1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f8530a = a(str);
        }
    }

    public void setV10(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.j = a(str);
        }
    }

    public void setV2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f8531b = a(str);
        }
    }

    public void setV3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f8532c = a(str);
        }
    }

    public void setV4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f8533d = a(str);
        }
    }

    public void setV5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f8534e = a(str);
        }
    }

    public void setV6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f8535f = a(str);
        }
    }

    public void setV7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f8536g = a(str);
        }
    }

    public void setV8(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f8537h = a(str);
        }
    }

    public void setV9(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f8538i = a(str);
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
