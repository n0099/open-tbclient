package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hx9;
import com.baidu.tieba.ny;
import com.baidu.tieba.vy;
import com.baidu.tieba.w05;
import com.baidu.tieba.yx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AutoVideoCardViewHolder<T extends w05> extends ThreadCardViewHolder<T> implements hx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(ny<T> nyVar) {
        super(nyVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nyVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ny) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        if (nyVar.g() instanceof vy) {
            this.k = (vy) nyVar.g();
        }
    }

    @Override // com.baidu.tieba.hx9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            vy vyVar = this.k;
            if (vyVar == null) {
                return 0;
            }
            return vyVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hx9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            vy vyVar = this.k;
            if (vyVar == null) {
                return null;
            }
            return vyVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hx9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            vy vyVar = this.k;
            if (vyVar == null) {
                return null;
            }
            return vyVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hx9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            vy vyVar = this.k;
            if (vyVar == null) {
                return false;
            }
            return vyVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hx9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            vy vyVar = this.k;
            if (vyVar == null) {
                return false;
            }
            return vyVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hx9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            vy vyVar = this.k;
            if (vyVar == null) {
                return false;
            }
            return vyVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hx9
    public void startPlay() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (vyVar = this.k) != null) {
            vyVar.startPlay();
        }
    }

    @Override // com.baidu.tieba.hx9
    public void stopPlay() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (vyVar = this.k) != null) {
            vyVar.stopPlay();
        }
    }

    public vy x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.k;
        }
        return (vy) invokeV.objValue;
    }

    public void y(yx9 yx9Var) {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, yx9Var) == null) && (vyVar = this.k) != null) {
            vyVar.D(yx9Var);
        }
    }
}
