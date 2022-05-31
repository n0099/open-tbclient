package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d48;
import com.repackage.fy;
import com.repackage.om4;
import com.repackage.t48;
import com.repackage.xx;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends om4> extends ThreadCardViewHolder<T> implements d48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fy j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(xx<T> xxVar) {
        super(xxVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xxVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xx) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        if (xxVar.g() instanceof fy) {
            this.j = (fy) xxVar.g();
        }
    }

    @Override // com.repackage.d48
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fy fyVar = this.j;
            if (fyVar == null) {
                return 0;
            }
            return fyVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.d48
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            fy fyVar = this.j;
            if (fyVar == null) {
                return null;
            }
            return fyVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.d48
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            fy fyVar = this.j;
            if (fyVar == null) {
                return null;
            }
            return fyVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.d48
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            fy fyVar = this.j;
            if (fyVar == null) {
                return false;
            }
            return fyVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.d48
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            fy fyVar = this.j;
            if (fyVar == null) {
                return false;
            }
            return fyVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.d48
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            fy fyVar = this.j;
            if (fyVar == null) {
                return false;
            }
            return fyVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.d48
    public void startPlay() {
        fy fyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (fyVar = this.j) == null) {
            return;
        }
        fyVar.startPlay();
    }

    @Override // com.repackage.d48
    public void stopPlay() {
        fy fyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (fyVar = this.j) == null) {
            return;
        }
        fyVar.stopPlay();
    }

    public fy w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (fy) invokeV.objValue;
    }

    public void x(t48 t48Var) {
        fy fyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, t48Var) == null) || (fyVar = this.j) == null) {
            return;
        }
        fyVar.y(t48Var);
    }
}
