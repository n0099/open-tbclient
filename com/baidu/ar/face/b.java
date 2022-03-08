package com.baidu.ar.face;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.face.a.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "b";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean nE;
    public boolean nF;
    public boolean nG;
    public int nH;
    public int nI;
    public boolean nJ;
    public boolean nK;
    public int nL;
    public int nM;
    public boolean needExpression;
    public boolean needHeadPose;
    public boolean needSkeleton;
    public boolean needTriggers;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1979842235, "Lcom/baidu/ar/face/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1979842235, "Lcom/baidu/ar/face/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.needHeadPose = false;
        this.needSkeleton = false;
        this.needTriggers = false;
        this.needExpression = false;
        this.nE = false;
        this.nF = true;
        this.nG = true;
        this.nH = 180;
        this.nI = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
        this.nJ = true;
        this.nK = false;
        this.nL = 4;
        this.nM = 4;
    }

    public void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.needHeadPose = false;
            this.needSkeleton = false;
            this.needTriggers = false;
            this.needExpression = false;
            this.nE = false;
            this.nM = this.nL;
            this.nF = i2 != 0;
            this.nG = true;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            boolean z = false;
            this.needHeadPose = this.needHeadPose;
            this.needSkeleton = this.needSkeleton;
            this.needTriggers = this.needTriggers;
            this.needExpression = this.needExpression;
            this.nE = this.nE;
            this.nF = (this.nF || i2 != 0) ? true : true;
            this.nG = true;
        }
    }

    public a.C1756a a(a.b bVar) {
        InterceptResult invokeL;
        a.C1756a c1756a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            int i2 = bVar.qg;
            if (i2 == 0) {
                this.nL = 1;
                c1756a = bVar.qd;
            } else if (i2 == 1) {
                this.nL = 1;
                c1756a = bVar.qe;
            } else if (i2 != 2) {
                com.baidu.ar.h.b.b(TAG, "createFaceParams() device not support!!!");
                c1756a = null;
            } else {
                this.nL = 4;
                c1756a = bVar.qf;
            }
            this.nM = this.nL;
            return c1756a;
        }
        return (a.C1756a) invokeL.objValue;
    }

    public void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            this.needHeadPose = c.b(str, false);
            this.needSkeleton = c.c(str, false);
            this.needTriggers = c.d(str, false);
            this.needExpression = c.e(str, false);
            this.nE = c.f(str, false);
            this.nF = c.g(str, i2 != 0);
            int c2 = c.c(str, 1);
            this.nM = c2;
            if (c2 <= 1 || ARAuth.checkFeatureAuth(FeatureCodes.FACE_MULTI)) {
                return;
            }
            this.nM = 1;
        }
    }

    public boolean dA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.nJ : invokeV.booleanValue;
    }

    public boolean dB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.nK : invokeV.booleanValue;
    }

    public int dC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.nL : invokeV.intValue;
    }

    public int dD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.nM : invokeV.intValue;
    }

    public void dr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.nH = 180;
            this.nI = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
        }
    }

    public void ds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.nM = 1;
        }
    }

    public boolean dt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.needHeadPose : invokeV.booleanValue;
    }

    public boolean du() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.needSkeleton : invokeV.booleanValue;
    }

    public boolean dv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.needTriggers : invokeV.booleanValue;
    }

    public boolean dw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.needExpression : invokeV.booleanValue;
    }

    public boolean dx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.nE : invokeV.booleanValue;
    }

    public boolean dy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.nF : invokeV.booleanValue;
    }

    public boolean dz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.nG : invokeV.booleanValue;
    }

    public int getAlgoImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.nI : invokeV.intValue;
    }

    public int getAlgoImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.nH : invokeV.intValue;
    }

    public void setAlgoImageHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.nI = i2;
        }
    }

    public void setAlgoImageWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.nH = i2;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.nJ = z;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.nK = z;
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.nF = i2 != 0;
        }
    }
}
