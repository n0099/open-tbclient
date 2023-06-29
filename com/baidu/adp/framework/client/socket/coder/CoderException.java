package com.baidu.adp.framework.client.socket.coder;

import com.baidu.tieba.oa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CoderException extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4477017113691535623L;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mErrorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoderException(int i) {
        super(oa.i(i));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mErrorCode;
        }
        return invokeV.intValue;
    }
}
