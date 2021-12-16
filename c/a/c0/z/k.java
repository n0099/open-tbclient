package c.a.c0.z;

import android.content.ContentValues;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public abstract class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ContentValues a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? h.b(b().c()) : (ContentValues) invokeV.objValue;
    }

    public abstract j b();

    public String toString() {
        InterceptResult invokeV;
        Column[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(StringUtils.LF);
            for (Column column : b().c()) {
                sb.append("|");
                sb.append(column.field.f2150e);
                sb.append("| ");
                sb.append(column.isAssignedValue ? 1 : 0);
                sb.append(" | ");
                sb.append(column.stringValue());
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
