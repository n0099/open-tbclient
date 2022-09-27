package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ab8;
import com.baidu.tieba.az;
import com.baidu.tieba.ka8;
import com.baidu.tieba.sy;
import com.baidu.tieba.yq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends yq4> extends ThreadCardViewHolder<T> implements ka8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public az j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(sy<T> syVar) {
        super(syVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {syVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((sy) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        if (syVar.g() instanceof az) {
            this.j = (az) syVar.g();
        }
    }

    @Override // com.baidu.tieba.ka8
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            az azVar = this.j;
            if (azVar == null) {
                return 0;
            }
            return azVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ka8
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            az azVar = this.j;
            if (azVar == null) {
                return null;
            }
            return azVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ka8
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            az azVar = this.j;
            if (azVar == null) {
                return null;
            }
            return azVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ka8
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            az azVar = this.j;
            if (azVar == null) {
                return false;
            }
            return azVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka8
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            az azVar = this.j;
            if (azVar == null) {
                return false;
            }
            return azVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka8
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            az azVar = this.j;
            if (azVar == null) {
                return false;
            }
            return azVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka8
    public void startPlay() {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (azVar = this.j) == null) {
            return;
        }
        azVar.startPlay();
    }

    @Override // com.baidu.tieba.ka8
    public void stopPlay() {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (azVar = this.j) == null) {
            return;
        }
        azVar.stopPlay();
    }

    public az t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (az) invokeV.objValue;
    }

    public void u(ab8 ab8Var) {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, ab8Var) == null) || (azVar = this.j) == null) {
            return;
        }
        azVar.z(ab8Var);
    }
}
