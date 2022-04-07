package com.baidu.ar.face.detector;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public void a(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)}) == null) {
            int i = this.pr;
            int i2 = this.pq;
            if (i < i2) {
                int i3 = i + 1;
                this.pr = i3;
                this.py = (((i3 - 1) * this.py) + d) / i3;
                return;
            }
            if (i == i2) {
                this.pr = i + 1;
            }
            this.pr = 0;
            this.py = 0.0d;
        }
    }

    public void b(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)}) == null) {
            int i = this.ps;
            int i2 = this.pq;
            if (i < i2) {
                int i3 = i + 1;
                this.ps = i3;
                this.px = (((i3 - 1) * this.px) + d) / i3;
                return;
            }
            if (i == i2) {
                this.ps = i + 1;
            }
            this.ps = 0;
            this.px = 0.0d;
        }
    }

    public void c(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d)}) == null) {
            int i = this.pt;
            int i2 = this.pq;
            if (i < i2) {
                int i3 = i + 1;
                this.pt = i3;
                this.pz = (((i3 - 1) * this.pz) + d) / i3;
                return;
            }
            if (i == i2) {
                this.pt = i + 1;
            }
            this.pt = 0;
            this.pz = 0.0d;
        }
    }

    public void d(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d)}) == null) {
            int i = this.pu;
            int i2 = this.pq;
            if (i < i2) {
                int i3 = i + 1;
                this.pu = i3;
                this.pA = (((i3 - 1) * this.pA) + d) / i3;
                return;
            }
            if (i == i2) {
                this.pu = i + 1;
            }
            this.pu = 0;
            this.pA = 0.0d;
        }
    }

    public void e(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d)}) == null) {
            int i = this.pv;
            int i2 = this.pq;
            if (i < i2) {
                int i3 = i + 1;
                this.pv = i3;
                this.pB = (((i3 - 1) * this.pB) + d) / i3;
                return;
            }
            if (i == i2) {
                this.pv = i + 1;
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

    public void f(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d)}) == null) {
            int i = this.pw;
            int i2 = this.pq;
            if (i < i2) {
                int i3 = i + 1;
                this.pw = i3;
                this.pC = (((i3 - 1) * this.pC) + d) / i3;
                return;
            }
            if (i == i2) {
                this.pw = i + 1;
            }
            this.pw = 0;
            this.pC = 0.0d;
        }
    }
}
