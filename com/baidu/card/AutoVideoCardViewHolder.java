package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kz;
import com.repackage.m78;
import com.repackage.sz;
import com.repackage.w68;
import com.repackage.zn4;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends zn4> extends ThreadCardViewHolder<T> implements w68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sz j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(kz<T> kzVar) {
        super(kzVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kzVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((kz) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        if (kzVar.g() instanceof sz) {
            this.j = (sz) kzVar.g();
        }
    }

    @Override // com.repackage.w68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            sz szVar = this.j;
            if (szVar == null) {
                return 0;
            }
            return szVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.w68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            sz szVar = this.j;
            if (szVar == null) {
                return null;
            }
            return szVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.w68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            sz szVar = this.j;
            if (szVar == null) {
                return null;
            }
            return szVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.w68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            sz szVar = this.j;
            if (szVar == null) {
                return false;
            }
            return szVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            sz szVar = this.j;
            if (szVar == null) {
                return false;
            }
            return szVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            sz szVar = this.j;
            if (szVar == null) {
                return false;
            }
            return szVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public void startPlay() {
        sz szVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (szVar = this.j) == null) {
            return;
        }
        szVar.startPlay();
    }

    @Override // com.repackage.w68
    public void stopPlay() {
        sz szVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (szVar = this.j) == null) {
            return;
        }
        szVar.stopPlay();
    }

    public sz w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (sz) invokeV.objValue;
    }

    public void x(m78 m78Var) {
        sz szVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, m78Var) == null) || (szVar = this.j) == null) {
            return;
        }
        szVar.y(m78Var);
    }
}
