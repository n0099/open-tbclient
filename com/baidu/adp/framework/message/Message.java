package com.baidu.adp.framework.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
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
    public long encodedBinarySize;
    public final int mCmd;
    public Object mExtra;
    public Object mSelf;
    public long mStartTime;
    public BdUniqueId mTag;
    public int squencedId;

    public Message(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExtra = null;
        this.mSelf = null;
        this.mStartTime = 0L;
        this.encodedBinarySize = 0L;
        this.squencedId = 0;
        this.mCmd = i2;
        check();
        this.clientLogID = BdStatisticsManager.getInstance().getClientLogId();
    }

    private void check() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && !checkCmd(this.mCmd)) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public abstract boolean checkCmd(int i2);

    public abstract /* synthetic */ T encodeInBackGround();

    public long getClientLogID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.clientLogID : invokeV.longValue;
    }

    public int getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCmd : invokeV.intValue;
    }

    public long getEncodedBinarySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.encodedBinarySize : invokeV.longValue;
    }

    public Object getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mExtra : invokeV.objValue;
    }

    public Object getSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSelf : invokeV.objValue;
    }

    public int getSquencedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.squencedId : invokeV.intValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mStartTime : invokeV.longValue;
    }

    public BdUniqueId getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTag : (BdUniqueId) invokeV.objValue;
    }

    public void setClientLogID(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.clientLogID = j;
        }
    }

    public void setEncodedBinarySize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.encodedBinarySize = j;
        }
    }

    public void setExtra(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, obj) == null) {
            this.mExtra = obj;
        }
    }

    public void setSelf(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            this.mSelf = obj;
        }
    }

    public void setSquencedId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.squencedId = i2;
        }
    }

    public void setStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.mStartTime = j;
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            this.mTag = bdUniqueId;
        }
    }

    public Message(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mExtra = null;
        this.mSelf = null;
        this.mStartTime = 0L;
        this.encodedBinarySize = 0L;
        this.squencedId = 0;
        this.mCmd = i2;
        this.mTag = bdUniqueId;
        check();
        this.clientLogID = BdStatisticsManager.getInstance().getClientLogId();
    }
}
