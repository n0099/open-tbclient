package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.l0;
import d.a.k.t0;
import d.a.p0.s.q.a;
import d.a.q0.n2.e;
import d.a.q0.n2.o;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends a> extends ThreadCardViewHolder<T> implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoVideoCardViewHolder(l0<T> l0Var) {
        super(l0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((l0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = null;
        if (l0Var.f() instanceof t0) {
            this.n = (t0) l0Var.f();
        }
    }

    @Override // d.a.q0.n2.e
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            t0 t0Var = this.n;
            if (t0Var == null) {
                return false;
            }
            return t0Var.C();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            t0 t0Var = this.n;
            if (t0Var == null) {
                return 0;
            }
            return t0Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // d.a.q0.n2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            t0 t0Var = this.n;
            if (t0Var == null) {
                return null;
            }
            return t0Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.n2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            t0 t0Var = this.n;
            if (t0Var == null) {
                return null;
            }
            return t0Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.q0.n2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            t0 t0Var = this.n;
            if (t0Var == null) {
                return false;
            }
            return t0Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            t0 t0Var = this.n;
            if (t0Var == null) {
                return false;
            }
            return t0Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n2.e
    public void startPlay() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (t0Var = this.n) == null) {
            return;
        }
        t0Var.startPlay();
    }

    @Override // d.a.q0.n2.e
    public void stopPlay() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (t0Var = this.n) == null) {
            return;
        }
        t0Var.stopPlay();
    }

    public t0 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (t0) invokeV.objValue;
    }

    public void u(o oVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, oVar) == null) || (t0Var = this.n) == null) {
            return;
        }
        t0Var.z(oVar);
    }
}
