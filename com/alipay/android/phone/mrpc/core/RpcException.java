package com.alipay.android.phone.mrpc.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes.dex */
public class RpcException extends RuntimeException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2875437994101380406L;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCode;
    public String mMsg;
    public String mOperationType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RpcException(Integer num, String str) {
        super(a(num, str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, str};
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
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RpcException(Integer num, String str, Throwable th) {
        super(a(num, str), th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, str, th};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RpcException(Integer num, Throwable th) {
        super(th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, th};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Throwable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mCode = num.intValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RpcException(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mCode = 0;
        this.mMsg = str;
    }

    public static String a(Integer num, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, num, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("RPCException: ");
            if (num != null) {
                sb.append(PreferencesUtil.LEFT_MOUNT);
                sb.append(num);
                sb.append(PreferencesUtil.RIGHT_MOUNT);
            }
            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCode : invokeV.intValue;
    }

    public String getMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMsg : (String) invokeV.objValue;
    }

    public String getOperationType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOperationType : (String) invokeV.objValue;
    }

    public void setOperationType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mOperationType = str;
        }
    }
}
