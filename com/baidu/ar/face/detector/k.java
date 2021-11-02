package com.baidu.ar.face.detector;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double pA;
    public double pB;
    public double pC;
    public int pq;
    public int pr;
    public int ps;
    public int pt;
    public int pu;
    public int pv;
    public int pw;
    public double px;
    public double py;
    public double pz;

    public k() {
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
        this.pq = 300;
        this.pr = 0;
        this.ps = 0;
        this.pt = 0;
        this.pu = 0;
        this.pv = 0;
        this.pw = 0;
    }

    public void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) {
            int i2 = this.pr;
            int i3 = this.pq;
            if (i2 < i3) {
                int i4 = i2 + 1;
                this.pr = i4;
                this.py = (((i4 - 1) * this.py) + d2) / i4;
                return;
            }
            if (i2 == i3) {
                this.pr = i2 + 1;
            }
            this.pr = 0;
            this.py = 0.0d;
        }
    }

    public void b(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
            int i2 = this.ps;
            int i3 = this.pq;
            if (i2 < i3) {
                int i4 = i2 + 1;
                this.ps = i4;
                this.px = (((i4 - 1) * this.px) + d2) / i4;
                return;
            }
            if (i2 == i3) {
                this.ps = i2 + 1;
            }
            this.ps = 0;
            this.px = 0.0d;
        }
    }

    public void c(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)}) == null) {
            int i2 = this.pt;
            int i3 = this.pq;
            if (i2 < i3) {
                int i4 = i2 + 1;
                this.pt = i4;
                this.pz = (((i4 - 1) * this.pz) + d2) / i4;
                return;
            }
            if (i2 == i3) {
                this.pt = i2 + 1;
            }
            this.pt = 0;
            this.pz = 0.0d;
        }
    }

    public void d(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)}) == null) {
            int i2 = this.pu;
            int i3 = this.pq;
            if (i2 < i3) {
                int i4 = i2 + 1;
                this.pu = i4;
                this.pA = (((i4 - 1) * this.pA) + d2) / i4;
                return;
            }
            if (i2 == i3) {
                this.pu = i2 + 1;
            }
            this.pu = 0;
            this.pA = 0.0d;
        }
    }

    public void e(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)}) == null) {
            int i2 = this.pv;
            int i3 = this.pq;
            if (i2 < i3) {
                int i4 = i2 + 1;
                this.pv = i4;
                this.pB = (((i4 - 1) * this.pB) + d2) / i4;
                return;
            }
            if (i2 == i3) {
                this.pv = i2 + 1;
            }
            this.pv = 0;
            this.pB = 0.0d;
        }
    }

    public void ez() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.pr = 0;
            this.ps = 0;
            this.pt = 0;
            this.pu = 0;
            this.pv = 0;
            this.pw = 0;
        }
    }

    public void f(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)}) == null) {
            int i2 = this.pw;
            int i3 = this.pq;
            if (i2 < i3) {
                int i4 = i2 + 1;
                this.pw = i4;
                this.pC = (((i4 - 1) * this.pC) + d2) / i4;
                return;
            }
            if (i2 == i3) {
                this.pw = i2 + 1;
            }
            this.pw = 0;
            this.pC = 0.0d;
        }
    }
}
