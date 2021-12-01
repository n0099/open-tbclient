package com.alibaba.fastjson.serializer;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.utility.FileUtil;
/* loaded from: classes7.dex */
public class SerialContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int features;
    public final Object fieldName;
    public final Object object;
    public final SerialContext parent;

    public SerialContext(SerialContext serialContext, Object obj, Object obj2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {serialContext, obj, obj2, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parent = serialContext;
        this.object = obj;
        this.fieldName = obj2;
        this.features = i2;
    }

    public Object getFieldName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.fieldName : invokeV.objValue;
    }

    public Object getObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.object : invokeV.objValue;
    }

    public SerialContext getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.parent : (SerialContext) invokeV.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? toString() : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.parent == null) {
                return "$";
            }
            StringBuilder sb = new StringBuilder();
            toString(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void toString(StringBuilder sb) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sb) == null) {
            SerialContext serialContext = this.parent;
            if (serialContext == null) {
                sb.append('$');
                return;
            }
            serialContext.toString(sb);
            Object obj = this.fieldName;
            if (obj == null) {
                sb.append(".null");
            } else if (obj instanceof Integer) {
                sb.append('[');
                sb.append(((Integer) this.fieldName).intValue());
                sb.append(']');
            } else {
                sb.append('.');
                String obj2 = this.fieldName.toString();
                int i2 = 0;
                while (true) {
                    if (i2 >= obj2.length()) {
                        z = false;
                        break;
                    }
                    char charAt = obj2.charAt(i2);
                    if ((charAt < '0' || charAt > '9') && ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && charAt <= 128))) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    for (int i3 = 0; i3 < obj2.length(); i3++) {
                        char charAt2 = obj2.charAt(i3);
                        if (charAt2 == '\\') {
                            sb.append(FileUtil.WINDOWS_SEPARATOR);
                            sb.append(FileUtil.WINDOWS_SEPARATOR);
                            sb.append(FileUtil.WINDOWS_SEPARATOR);
                        } else if ((charAt2 >= '0' && charAt2 <= '9') || ((charAt2 >= 'A' && charAt2 <= 'Z') || ((charAt2 >= 'a' && charAt2 <= 'z') || charAt2 > 128))) {
                            sb.append(charAt2);
                        } else if (charAt2 == '\"') {
                            sb.append(FileUtil.WINDOWS_SEPARATOR);
                            sb.append(FileUtil.WINDOWS_SEPARATOR);
                            sb.append(FileUtil.WINDOWS_SEPARATOR);
                        } else {
                            sb.append(FileUtil.WINDOWS_SEPARATOR);
                            sb.append(FileUtil.WINDOWS_SEPARATOR);
                        }
                        sb.append(charAt2);
                    }
                    return;
                }
                sb.append(obj2);
            }
        }
    }
}
