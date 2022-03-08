package com.baidu.pass.main.facesdk.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BDFaceDriverMonitorInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float calling;
    public float drinking;
    public float eating;
    public float normal;
    public float smoking;

    public BDFaceDriverMonitorInfo(float f2, float f3, float f4, float f5, float f6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.normal = 0.0f;
        this.calling = 0.0f;
        this.drinking = 0.0f;
        this.eating = 0.0f;
        this.smoking = 0.0f;
        this.normal = f2;
        this.calling = f3;
        this.drinking = f4;
        this.eating = f5;
        this.smoking = f6;
    }
}
