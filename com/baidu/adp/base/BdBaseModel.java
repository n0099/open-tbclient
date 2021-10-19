package com.baidu.adp.base;

import androidx.core.view.InputDeviceCompat;
import c.a.e.a.e;
import c.a.e.a.f;
import c.a.e.c.g.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class BdBaseModel<T> extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public static final int MODE_INVALID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int mErrorCode;
    public String mErrorString;
    public e mLoadDataCallBack;
    public int mLoadDataMode;
    public BdUniqueId unique_id;

    public BdBaseModel() {
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
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
    }

    private void check() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
        }
    }

    public abstract boolean cancelLoadData();

    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            check();
            MessageManager.getInstance().removeMessage(this.unique_id);
        }
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mErrorCode : invokeV.intValue;
    }

    public String getErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mErrorString : (String) invokeV.objValue;
    }

    public int getLoadDataMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLoadDataMode : invokeV.intValue;
    }

    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.unique_id : (BdUniqueId) invokeV.objValue;
    }

    public abstract boolean loadData();

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, messageListener) == null) {
            check();
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.unique_id);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, message) == null) || message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.unique_id);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    public void setErrorCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mErrorCode = i2;
        }
    }

    public void setErrorString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mErrorString = str;
        }
    }

    public void setLoadDataCallBack(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.mLoadDataCallBack = eVar;
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            this.unique_id = bdUniqueId;
        }
    }

    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, netMessage) == null) || netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.unique_id);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void registerListener(int i2, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, messageListener) == null) {
            check();
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.unique_id);
            }
            MessageManager.getInstance().registerListener(i2, messageListener);
        }
    }

    public BdBaseModel(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
        if (fVar == null) {
            return;
        }
        this.unique_id = fVar.getUniqueId();
    }

    public void registerListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            check();
            if (aVar != null && aVar.getTag() == null) {
                aVar.setTag(this.unique_id);
            }
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public void registerListener(int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, aVar) == null) {
            check();
            if (aVar != null && aVar.getTag() == null) {
                aVar.setTag(this.unique_id);
            }
            MessageManager.getInstance().registerListener(i2, aVar);
        }
    }
}
