package com.baidu.android.imsdk.chatmessage.sync;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DialogRecord {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_COMPLETE = 1;
    public static final int STATE_NEED_FETCHING = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int category;
    public long contacter;
    public long dialogueMsgid;
    public int jumpToRecent;
    public long maxMsgid;
    public int state;
    public long updateTime;

    public DialogRecord() {
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
        this.jumpToRecent = 1;
        this.dialogueMsgid = 0L;
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.category : invokeV.intValue;
    }

    public long getContacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.contacter : invokeV.longValue;
    }

    public long getDialogueMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dialogueMsgid : invokeV.longValue;
    }

    public int getJumpToRecent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.jumpToRecent : invokeV.intValue;
    }

    public long getMaxMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.maxMsgid : invokeV.longValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.state : invokeV.intValue;
    }

    public long getUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.updateTime : invokeV.longValue;
    }

    public DialogRecord setCategory(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.category = i2;
            return this;
        }
        return (DialogRecord) invokeI.objValue;
    }

    public DialogRecord setContacter(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
            this.contacter = j;
            return this;
        }
        return (DialogRecord) invokeJ.objValue;
    }

    public DialogRecord setDialogueMsgid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            this.dialogueMsgid = j;
            return this;
        }
        return (DialogRecord) invokeJ.objValue;
    }

    public DialogRecord setJumpToRecent(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.jumpToRecent = i2;
            return this;
        }
        return (DialogRecord) invokeI.objValue;
    }

    public DialogRecord setMaxMsgid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            if (j > this.maxMsgid) {
                this.maxMsgid = j;
            }
            return this;
        }
        return (DialogRecord) invokeJ.objValue;
    }

    public DialogRecord setState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.state = i2;
            return this;
        }
        return (DialogRecord) invokeI.objValue;
    }

    public DialogRecord setUpdateTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
            this.updateTime = j;
            return this;
        }
        return (DialogRecord) invokeJ.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "DialogRecord[category=" + this.category + ",contacter=" + this.contacter + ",maxMsgid=" + this.maxMsgid + ",state=" + this.state + ",updateTime=" + this.updateTime + ",jumpToRecent=" + this.jumpToRecent + ",dialogueMsgid=" + this.dialogueMsgid + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
