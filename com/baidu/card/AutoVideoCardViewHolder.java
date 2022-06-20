package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.by;
import com.repackage.h58;
import com.repackage.jy;
import com.repackage.x58;
import com.repackage.ym4;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends ym4> extends ThreadCardViewHolder<T> implements h58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jy j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(by<T> byVar) {
        super(byVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((by) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        if (byVar.g() instanceof jy) {
            this.j = (jy) byVar.g();
        }
    }

    @Override // com.repackage.h58
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            jy jyVar = this.j;
            if (jyVar == null) {
                return 0;
            }
            return jyVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.h58
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            jy jyVar = this.j;
            if (jyVar == null) {
                return null;
            }
            return jyVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.h58
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            jy jyVar = this.j;
            if (jyVar == null) {
                return null;
            }
            return jyVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.h58
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            jy jyVar = this.j;
            if (jyVar == null) {
                return false;
            }
            return jyVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.h58
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            jy jyVar = this.j;
            if (jyVar == null) {
                return false;
            }
            return jyVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.h58
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            jy jyVar = this.j;
            if (jyVar == null) {
                return false;
            }
            return jyVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.h58
    public void startPlay() {
        jy jyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (jyVar = this.j) == null) {
            return;
        }
        jyVar.startPlay();
    }

    @Override // com.repackage.h58
    public void stopPlay() {
        jy jyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (jyVar = this.j) == null) {
            return;
        }
        jyVar.stopPlay();
    }

    public jy v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (jy) invokeV.objValue;
    }

    public void w(x58 x58Var) {
        jy jyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, x58Var) == null) || (jyVar = this.j) == null) {
            return;
        }
        jyVar.y(x58Var);
    }
}
