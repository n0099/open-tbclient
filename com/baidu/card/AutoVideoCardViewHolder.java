package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c68;
import com.repackage.cy;
import com.repackage.ky;
import com.repackage.on4;
import com.repackage.s68;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends on4> extends ThreadCardViewHolder<T> implements c68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ky j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(cy<T> cyVar) {
        super(cyVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cyVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((cy) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        if (cyVar.g() instanceof ky) {
            this.j = (ky) cyVar.g();
        }
    }

    @Override // com.repackage.c68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ky kyVar = this.j;
            if (kyVar == null) {
                return 0;
            }
            return kyVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.c68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ky kyVar = this.j;
            if (kyVar == null) {
                return null;
            }
            return kyVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.c68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ky kyVar = this.j;
            if (kyVar == null) {
                return null;
            }
            return kyVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.c68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ky kyVar = this.j;
            if (kyVar == null) {
                return false;
            }
            return kyVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.c68
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ky kyVar = this.j;
            if (kyVar == null) {
                return false;
            }
            return kyVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.c68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ky kyVar = this.j;
            if (kyVar == null) {
                return false;
            }
            return kyVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.c68
    public void startPlay() {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (kyVar = this.j) == null) {
            return;
        }
        kyVar.startPlay();
    }

    @Override // com.repackage.c68
    public void stopPlay() {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (kyVar = this.j) == null) {
            return;
        }
        kyVar.stopPlay();
    }

    public ky u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (ky) invokeV.objValue;
    }

    public void v(s68 s68Var) {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, s68Var) == null) || (kyVar = this.j) == null) {
            return;
        }
        kyVar.z(s68Var);
    }
}
