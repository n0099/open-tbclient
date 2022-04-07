package com.baidu.ar.arrender;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int hP;
    public int hQ;
    public long hR;

    public h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hP = 33;
        this.hQ = 0;
        this.hR = 0L;
        if (i > 0) {
            this.hP = 1000 / i;
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
            long j = currentTimeMillis % 1000;
            if (currentTimeMillis / 1000 != this.hR / 1000) {
                this.hR = currentTimeMillis;
                this.hQ = 0;
            }
            int i = this.hQ;
            if (this.hP * i < j) {
                this.hQ = i + 1;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
