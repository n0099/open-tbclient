package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b00;
import com.repackage.j00;
import com.repackage.m78;
import com.repackage.pn4;
import com.repackage.w68;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends pn4> extends ThreadCardViewHolder<T> implements w68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j00 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(b00<T> b00Var) {
        super(b00Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b00Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b00) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        if (b00Var.g() instanceof j00) {
            this.j = (j00) b00Var.g();
        }
    }

    @Override // com.repackage.w68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j00 j00Var = this.j;
            if (j00Var == null) {
                return 0;
            }
            return j00Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.w68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            j00 j00Var = this.j;
            if (j00Var == null) {
                return null;
            }
            return j00Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.w68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            j00 j00Var = this.j;
            if (j00Var == null) {
                return null;
            }
            return j00Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.w68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            j00 j00Var = this.j;
            if (j00Var == null) {
                return false;
            }
            return j00Var.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            j00 j00Var = this.j;
            if (j00Var == null) {
                return false;
            }
            return j00Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            j00 j00Var = this.j;
            if (j00Var == null) {
                return false;
            }
            return j00Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public void startPlay() {
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (j00Var = this.j) == null) {
            return;
        }
        j00Var.startPlay();
    }

    @Override // com.repackage.w68
    public void stopPlay() {
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (j00Var = this.j) == null) {
            return;
        }
        j00Var.stopPlay();
    }

    public j00 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (j00) invokeV.objValue;
    }

    public void x(m78 m78Var) {
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, m78Var) == null) || (j00Var = this.j) == null) {
            return;
        }
        j00Var.y(m78Var);
    }
}
