package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SocketMessage extends Message<byte[]> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String GLOBAL_ENCODE_NAME = "toByteArray";
    public transient /* synthetic */ FieldHolder $fh;
    public Object mData;
    public String mEncodeName;
    public Object mExtraData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1642741040, "Lcom/baidu/adp/framework/message/SocketMessage;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1642741040, "Lcom/baidu/adp/framework/message/SocketMessage;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mData = null;
        this.mExtraData = null;
        this.mEncodeName = null;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketMessage(int i, BdUniqueId bdUniqueId) {
        super(i, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), bdUniqueId};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mData = null;
        this.mExtraData = null;
        this.mEncodeName = null;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketMessage(int i, Object obj) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), obj};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mData = null;
        this.mExtraData = null;
        this.mEncodeName = null;
        this.mData = obj;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return FrameHelper.c(i);
        }
        return invokeI.booleanValue;
    }

    public void setData(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            this.mData = obj;
        }
    }

    public void setExtraData(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            this.mExtraData = obj;
        }
    }

    public byte[] encodeExtraDataInBackGround() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.mExtraData;
            if (obj != null && (obj instanceof byte[])) {
                return (byte[]) obj;
            }
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public Object getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mData;
        }
        return invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.Message
    public byte[] encodeInBackGround() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object data = getData();
            if (data instanceof byte[]) {
                return (byte[]) data;
            }
            if (data == null) {
                return null;
            }
            try {
                Object invoke = data.getClass().getMethod(this.mEncodeName, new Class[0]).invoke(data, new Object[0]);
                if (invoke == null || !(invoke instanceof byte[])) {
                    return null;
                }
                return (byte[]) invoke;
            } catch (Throwable th) {
                BdLog.detailException("SocketMessage encode error. cmd:" + getCmd(), th);
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }
}
