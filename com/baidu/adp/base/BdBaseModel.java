package com.baidu.adp.base;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class BdBaseModel<T> extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public static final int MODE_INVALID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int mErrorCode;
    public String mErrorString;
    public i9 mLoadDataCallBack;
    public int mLoadDataMode;
    public boolean mNeedShowSeverToast;
    public BdUniqueId unique_id;

    public abstract boolean cancelLoadData();

    public abstract boolean loadData();

    public BdBaseModel() {
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
        this.mNeedShowSeverToast = true;
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
    }

    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().removeMessage(this.unique_id);
        }
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mErrorCode;
        }
        return invokeV.intValue;
    }

    public String getErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mErrorString;
        }
        return (String) invokeV.objValue;
    }

    public int getLoadDataMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mLoadDataMode;
        }
        return invokeV.intValue;
    }

    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.unique_id;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdBaseModel(BdPageContext<T> bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNeedShowSeverToast = true;
        this.mLoadDataMode = 0;
        this.unique_id = null;
        this.mLoadDataCallBack = null;
        this.mErrorCode = 0;
        this.mErrorString = null;
        if (bdPageContext == null) {
            return;
        }
        this.unique_id = bdPageContext.getUniqueId();
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.unique_id);
            }
            MessageManager.getInstance().registerListener(i, messageListener);
        }
    }

    public void registerListener(int i, NetMessageListener netMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, netMessageListener) == null) {
            if (netMessageListener != null && netMessageListener.getTag() == null) {
                netMessageListener.setTag(this.unique_id);
            }
            MessageManager.getInstance().registerListener(i, netMessageListener);
        }
    }

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.unique_id);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, message) != null) || message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.unique_id);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    public void setErrorCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.mErrorCode = i;
        }
    }

    public void setErrorString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mErrorString = str;
        }
    }

    public void setLoadDataCallBack(i9 i9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, i9Var) == null) {
            this.mLoadDataCallBack = i9Var;
        }
    }

    public void setNeedShowSeverToast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mNeedShowSeverToast = z;
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            this.unique_id = bdUniqueId;
        }
    }

    public void registerListener(NetMessageListener netMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, netMessageListener) == null) {
            if (netMessageListener != null && netMessageListener.getTag() == null) {
                netMessageListener.setTag(this.unique_id);
            }
            MessageManager.getInstance().registerListener(netMessageListener);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, netMessage) != null) || netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.unique_id);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }
}
