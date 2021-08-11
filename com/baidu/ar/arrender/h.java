package com.baidu.ar.arrender;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int hP;
    public int hQ;
    public long hR;

    public h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hP = 33;
        this.hQ = 0;
        this.hR = 0L;
        if (i2 > 0) {
            this.hP = 1000 / i2;
        }
    }

    public boolean bP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.hR == 0) {
                this.hR = currentTimeMillis;
            }
            long j2 = currentTimeMillis % 1000;
            if (currentTimeMillis / 1000 != this.hR / 1000) {
                this.hR = currentTimeMillis;
                this.hQ = 0;
            }
            int i2 = this.hQ;
            if (this.hP * i2 < j2) {
                this.hQ = i2 + 1;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
