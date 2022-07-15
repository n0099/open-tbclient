package com.baidu.nadcore.sweetsqlite;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sy0;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class IntegerColumn extends Column implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6464317274646219935L;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntegerColumn(sy0 sy0Var) {
        super(sy0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sy0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((sy0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.value = 0;
            this.isAssignedValue = false;
        }
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.value : invokeV.intValue;
    }

    public IntegerColumn setDefaultValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.value = i;
            return this;
        }
        return (IntegerColumn) invokeI.objValue;
    }

    public IntegerColumn setValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.isAssignedValue = true;
            this.value = i;
            return this;
        }
        return (IntegerColumn) invokeI.objValue;
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public String stringValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.value) : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.field.b + ":" + this.value + ":" + this.field.c + ":" + this.field.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public int type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
