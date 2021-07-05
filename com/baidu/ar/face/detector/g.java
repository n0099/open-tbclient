package com.baidu.ar.face.detector;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] ot;
    public int ou;
    public int ov;
    public int ow;
    public boolean ox;

    public g() {
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
        this.ot = new int[]{3, 10, 10, 10, 10};
        this.ou = 4;
        this.ov = 0;
        this.ox = false;
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.ov = i2;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.ou = i2;
        }
    }

    public boolean a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            FaceAlgoData faceAlgoData = fVar.ob;
            if (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || fVar.ob.getFaceFrame().getProcessResult() == 200 || dS() > 0) {
                return false;
            }
            E(0);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) {
            this.ot = iArr;
        }
    }

    public boolean dO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.ow;
            if (i2 == 0) {
                this.ow = i2 + 1;
                return true;
            } else if (this.ox) {
                return false;
            } else {
                int i3 = i2 + 1;
                this.ow = i3;
                int i4 = i3 - 1;
                int[] iArr = this.ot;
                int i5 = this.ov;
                int i6 = this.ou;
                if (i5 > i6) {
                    i5 = i6;
                }
                if (i4 > iArr[i5]) {
                    this.ow = 0;
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void dP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.ox = true;
        }
    }

    public void dQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.ox = false;
        }
    }

    public int dR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.ou : invokeV.intValue;
    }

    public int dS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.ov : invokeV.intValue;
    }
}
