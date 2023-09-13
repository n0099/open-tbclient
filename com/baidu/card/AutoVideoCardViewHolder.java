package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b15;
import com.baidu.tieba.oy;
import com.baidu.tieba.pz9;
import com.baidu.tieba.wy;
import com.baidu.tieba.yy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AutoVideoCardViewHolder<T extends b15> extends ThreadCardViewHolder<T> implements yy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wy k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(oy<T> oyVar) {
        super(oyVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oyVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((oy) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        if (oyVar.g() instanceof wy) {
            this.k = (wy) oyVar.g();
        }
    }

    @Override // com.baidu.tieba.yy9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wy wyVar = this.k;
            if (wyVar == null) {
                return 0;
            }
            return wyVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            wy wyVar = this.k;
            if (wyVar == null) {
                return null;
            }
            return wyVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            wy wyVar = this.k;
            if (wyVar == null) {
                return null;
            }
            return wyVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            wy wyVar = this.k;
            if (wyVar == null) {
                return false;
            }
            return wyVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yy9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            wy wyVar = this.k;
            if (wyVar == null) {
                return false;
            }
            return wyVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yy9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            wy wyVar = this.k;
            if (wyVar == null) {
                return false;
            }
            return wyVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yy9
    public void startPlay() {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (wyVar = this.k) != null) {
            wyVar.startPlay();
        }
    }

    @Override // com.baidu.tieba.yy9
    public void stopPlay() {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (wyVar = this.k) != null) {
            wyVar.stopPlay();
        }
    }

    public wy u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.k;
        }
        return (wy) invokeV.objValue;
    }

    public void x(pz9 pz9Var) {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pz9Var) == null) && (wyVar = this.k) != null) {
            wyVar.C(pz9Var);
        }
    }
}
