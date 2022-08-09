package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dy;
import com.repackage.fo4;
import com.repackage.j88;
import com.repackage.ly;
import com.repackage.z88;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends fo4> extends ThreadCardViewHolder<T> implements j88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(dy<T> dyVar) {
        super(dyVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dyVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((dy) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        if (dyVar.g() instanceof ly) {
            this.j = (ly) dyVar.g();
        }
    }

    @Override // com.repackage.j88
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ly lyVar = this.j;
            if (lyVar == null) {
                return 0;
            }
            return lyVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.j88
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ly lyVar = this.j;
            if (lyVar == null) {
                return null;
            }
            return lyVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.j88
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ly lyVar = this.j;
            if (lyVar == null) {
                return null;
            }
            return lyVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.j88
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ly lyVar = this.j;
            if (lyVar == null) {
                return false;
            }
            return lyVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.j88
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ly lyVar = this.j;
            if (lyVar == null) {
                return false;
            }
            return lyVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.j88
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ly lyVar = this.j;
            if (lyVar == null) {
                return false;
            }
            return lyVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.j88
    public void startPlay() {
        ly lyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lyVar = this.j) == null) {
            return;
        }
        lyVar.startPlay();
    }

    @Override // com.repackage.j88
    public void stopPlay() {
        ly lyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (lyVar = this.j) == null) {
            return;
        }
        lyVar.stopPlay();
    }

    public ly t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (ly) invokeV.objValue;
    }

    public void u(z88 z88Var) {
        ly lyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, z88Var) == null) || (lyVar = this.j) == null) {
            return;
        }
        lyVar.z(z88Var);
    }
}
