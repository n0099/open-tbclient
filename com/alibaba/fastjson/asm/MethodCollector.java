package com.alibaba.fastjson.asm;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MethodCollector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentParameter;
    public boolean debugInfoPresent;
    public final int ignoreCount;
    public final int paramCount;
    public final StringBuilder result;

    public MethodCollector(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ignoreCount = i2;
        this.paramCount = i3;
        this.result = new StringBuilder();
        this.currentParameter = 0;
        this.debugInfoPresent = i3 == 0;
    }

    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result.length() != 0 ? this.result.substring(1) : "" : (String) invokeV.objValue;
    }

    public void visitLocalVariable(String str, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) || i2 < (i3 = this.ignoreCount) || i2 >= i3 + this.paramCount) {
            return;
        }
        if (!str.equals("arg" + this.currentParameter)) {
            this.debugInfoPresent = true;
        }
        this.result.append(',');
        this.result.append(str);
        this.currentParameter++;
    }
}
