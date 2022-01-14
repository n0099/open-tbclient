package com.baidu.searchbox.player.callback;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class UniversalPlayerCallbackManager extends VideoPlayerCallbackBaseManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IUniversalPlayerCallback mUniversalCallback;

    public UniversalPlayerCallbackManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public IUniversalPlayerCallback getUniversalPlayerCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mUniversalCallback : (IUniversalPlayerCallback) invokeV.objValue;
    }

    @PublicMethod
    public void onBeforeSwitchToFull() {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onBeforeSwitchToFull();
    }

    @PublicMethod
    public void onBeforeSwitchToHalf() {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onBeforeSwitchToHalf();
    }

    @PublicMethod
    public void onGestureActionEnd() {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onGestureActionEnd();
    }

    @PublicMethod
    public void onGestureActionStart() {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onGestureActionStart();
    }

    @PublicMethod
    public boolean onGestureDoubleClick(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            IUniversalPlayerCallback iUniversalPlayerCallback = this.mUniversalCallback;
            if (iUniversalPlayerCallback != null) {
                return iUniversalPlayerCallback.onGestureDoubleClick(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @PublicMethod
    public void onPanelVisibilityChanged(boolean z) {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onPanelVisibilityChanged(z);
    }

    @PublicMethod
    public void onPauseBtnClick() {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onPauseBtnClick();
    }

    @PublicMethod
    public void onReplayBtnClick() {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onReplayBtnClick();
    }

    @PublicMethod
    public void onStartBtnClick() {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onStartBtnClick();
    }

    @PublicMethod
    public void onVideoSwitchToFull() {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onVideoSwitchToFull();
    }

    @PublicMethod
    public void onVideoSwitchToHalf() {
        IUniversalPlayerCallback iUniversalPlayerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (iUniversalPlayerCallback = this.mUniversalCallback) == null) {
            return;
        }
        iUniversalPlayerCallback.onVideoSwitchToHalf();
    }

    @Override // com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager
    @PublicMethod
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.release();
            this.mUniversalCallback = null;
        }
    }

    public void setUniversalPlayerCallback(IUniversalPlayerCallback iUniversalPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iUniversalPlayerCallback) == null) {
            this.mUniversalCallback = iUniversalPlayerCallback;
        }
    }
}
