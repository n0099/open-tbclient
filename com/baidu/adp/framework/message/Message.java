package com.baidu.adp.framework.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class Message<T> extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long clientLogID;
    public final int mCmd;
    public Object mExtra;
    public Object mSelf;
    public long mStartTime;
    public BdUniqueId mTag;
    public int squencedId;

    public abstract boolean checkCmd(int i);

    public abstract /* synthetic */ T encodeInBackGround();

    public Message(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExtra = null;
        this.mSelf = null;
        this.mStartTime = 0L;
        this.squencedId = 0;
        this.mCmd = i;
        check();
        this.clientLogID = zg.b().a();
    }

    public Message(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mExtra = null;
        this.mSelf = null;
        this.mStartTime = 0L;
        this.squencedId = 0;
        this.mCmd = i;
        this.mTag = bdUniqueId;
        check();
        this.clientLogID = zg.b().a();
    }

    private void check() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, this) != null) || checkCmd(this.mCmd)) {
            return;
        }
        throw new InvalidParameterException("cmd invalid");
    }

    public long getClientLogID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.clientLogID;
        }
        return invokeV.longValue;
    }

    public int getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCmd;
        }
        return invokeV.intValue;
    }

    public Object getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mExtra;
        }
        return invokeV.objValue;
    }

    public Object getSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mSelf;
        }
        return invokeV.objValue;
    }

    public int getSquencedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.squencedId;
        }
        return invokeV.intValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mStartTime;
        }
        return invokeV.longValue;
    }

    public BdUniqueId getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mTag;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void setClientLogID(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.clientLogID = j;
        }
    }

    public void setExtra(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
            this.mExtra = obj;
        }
    }

    public void setSelf(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, obj) == null) {
            this.mSelf = obj;
        }
    }

    public void setSquencedId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.squencedId = i;
        }
    }

    public void setStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.mStartTime = j;
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            this.mTag = bdUniqueId;
        }
    }
}
