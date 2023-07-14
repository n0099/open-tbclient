package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.av9;
import com.baidu.tieba.iu9;
import com.baidu.tieba.mz;
import com.baidu.tieba.t15;
import com.baidu.tieba.uz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AutoVideoCardViewHolder<T extends t15> extends ThreadCardViewHolder<T> implements iu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uz k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(mz<T> mzVar) {
        super(mzVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mzVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mz) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        if (mzVar.g() instanceof uz) {
            this.k = (uz) mzVar.g();
        }
    }

    @Override // com.baidu.tieba.iu9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            uz uzVar = this.k;
            if (uzVar == null) {
                return 0;
            }
            return uzVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            uz uzVar = this.k;
            if (uzVar == null) {
                return null;
            }
            return uzVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            uz uzVar = this.k;
            if (uzVar == null) {
                return null;
            }
            return uzVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            uz uzVar = this.k;
            if (uzVar == null) {
                return false;
            }
            return uzVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            uz uzVar = this.k;
            if (uzVar == null) {
                return false;
            }
            return uzVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            uz uzVar = this.k;
            if (uzVar == null) {
                return false;
            }
            return uzVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public void startPlay() {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (uzVar = this.k) != null) {
            uzVar.startPlay();
        }
    }

    @Override // com.baidu.tieba.iu9
    public void stopPlay() {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (uzVar = this.k) != null) {
            uzVar.stopPlay();
        }
    }

    public uz x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.k;
        }
        return (uz) invokeV.objValue;
    }

    public void y(av9 av9Var) {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, av9Var) == null) && (uzVar = this.k) != null) {
            uzVar.E(av9Var);
        }
    }
}
