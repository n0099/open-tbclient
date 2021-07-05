package com.baidu.ar.b.a;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.b.b.b;
import com.baidu.ar.c.c;
import com.baidu.ar.d.e;
import com.baidu.ar.d.j;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlgoHandleController cb;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cb = null;
    }

    public abstract b a(Bundle bundle);

    public void a(AlgoHandleController algoHandleController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, algoHandleController) == null) {
            this.cb = algoHandleController;
        }
    }

    @Override // com.baidu.ar.d.j
    public void ao() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (eVar = this.mv) == null) {
            return;
        }
        eVar.a(new l(getName(), true));
    }

    @Override // com.baidu.ar.d.j
    public boolean ap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int au = au();
            if (com.baidu.ar.b.a.as().c(au)) {
                return !com.baidu.ar.b.a.as().f(au);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ar.d.j
    public void aq() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.mv) == null) {
            return;
        }
        eVar.b(new l(getName(), true));
    }

    public abstract com.baidu.ar.b.b.a at();

    public abstract int au();

    public void av() {
        com.baidu.ar.b.b.a at;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (at = at()) == null) {
            return;
        }
        c.cd().R(at.getTag());
        c.cd().c((com.baidu.ar.c.a) at);
    }

    public void b(long j) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) || (algoHandleController = this.cb) == null) {
            return;
        }
        algoHandleController.destroyHandle(j);
    }

    public final void b(Bundle bundle) {
        b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) || (a2 = a(bundle)) == null) {
            return;
        }
        c.cd().c((com.baidu.ar.c.a) a2);
    }

    @Override // com.baidu.ar.d.j
    public boolean c(FramePixels framePixels) {
        InterceptResult invokeL;
        com.baidu.ar.b.b.c d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, framePixels)) == null) {
            if (!com.baidu.ar.b.a.as().c(au()) || framePixels == null || (d2 = d(framePixels)) == null) {
                return false;
            }
            return c.cd().c((com.baidu.ar.c.a) d2);
        }
        return invokeL.booleanValue;
    }

    public abstract com.baidu.ar.b.b.c d(FramePixels framePixels);
}
