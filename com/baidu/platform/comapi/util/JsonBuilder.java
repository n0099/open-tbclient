package com.baidu.platform.comapi.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsonBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public StringBuilder a;
    public boolean b;

    public JsonBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new StringBuilder();
        this.b = false;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.b) {
            this.a.append(",");
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.b = false;
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.b = true;
        }
    }

    public JsonBuilder arrayValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a();
            this.a.append(PreferencesUtil.LEFT_MOUNT);
            b();
            return this;
        }
        return (JsonBuilder) invokeV.objValue;
    }

    public JsonBuilder endArrayValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.a.append(PreferencesUtil.RIGHT_MOUNT);
            c();
            return this;
        }
        return (JsonBuilder) invokeV.objValue;
    }

    public JsonBuilder endObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.a.append("}");
            c();
            return this;
        }
        return (JsonBuilder) invokeV.objValue;
    }

    public String getJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.toString();
        }
        return (String) invokeV.objValue;
    }

    public JsonBuilder object() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            a();
            this.a.append("{");
            b();
            return this;
        }
        return (JsonBuilder) invokeV.objValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.setLength(0);
            this.b = false;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return getJson();
        }
        return (String) invokeV.objValue;
    }

    public JsonBuilder key(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            a();
            this.a.append(JSONObject.quote(str));
            this.a.append(":");
            b();
            return this;
        }
        return (JsonBuilder) invokeL.objValue;
    }

    public JsonBuilder objectValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            a();
            this.a.append(str);
            c();
            return this;
        }
        return (JsonBuilder) invokeL.objValue;
    }

    public JsonBuilder value(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            a();
            this.a.append(i);
            c();
            return this;
        }
        return (JsonBuilder) invokeI.objValue;
    }

    public JsonBuilder valueDirect(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            a();
            this.a.append(str);
            c();
            return this;
        }
        return (JsonBuilder) invokeL.objValue;
    }

    public JsonBuilder putObjectValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            if (str2 != null) {
                key(str).objectValue(str2);
            }
            return this;
        }
        return (JsonBuilder) invokeLL.objValue;
    }

    public JsonBuilder putStringValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if (str2 != null) {
                key(str).value(str2);
            }
            return this;
        }
        return (JsonBuilder) invokeLL.objValue;
    }

    public JsonBuilder value(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d)})) == null) {
            a();
            this.a.append(String.format("%f", Double.valueOf(d)));
            c();
            return this;
        }
        return (JsonBuilder) invokeCommon.objValue;
    }

    public JsonBuilder value(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
            a();
            this.a.append(j);
            c();
            return this;
        }
        return (JsonBuilder) invokeJ.objValue;
    }

    public JsonBuilder value(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj instanceof Number) {
                Number number = (Number) obj;
                if (obj instanceof Byte) {
                    return value((int) number.byteValue());
                }
                if (obj instanceof Short) {
                    return value((int) number.shortValue());
                }
                if (obj instanceof Integer) {
                    return value(number.intValue());
                }
                if (obj instanceof Long) {
                    return value(number.longValue());
                }
                if (obj instanceof Float) {
                    return value(number.floatValue());
                }
                if (obj instanceof Double) {
                    return value(number.doubleValue());
                }
            }
            return value(obj.toString());
        }
        return (JsonBuilder) invokeL.objValue;
    }

    public JsonBuilder value(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            a();
            this.a.append(JSONObject.quote(str));
            c();
            return this;
        }
        return (JsonBuilder) invokeL.objValue;
    }

    public JsonBuilder value(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            a();
            this.a.append(z);
            c();
            return this;
        }
        return (JsonBuilder) invokeZ.objValue;
    }
}
