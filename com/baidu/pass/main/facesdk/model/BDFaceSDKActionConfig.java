package com.baidu.pass.main.facesdk.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BDFaceSDKActionConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float eyeCloseThreshold;
    public float eyeOpenThreshold;
    public float lookDownThreshold;
    public float lookUpThreshold;
    public float mouthCloseThreshold;
    public float mouthOpenThreshold;
    public float shakeThreshold;
    public float turnLeftThreshold;
    public float turnRightThreshold;

    public BDFaceSDKActionConfig() {
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
        this.eyeCloseThreshold = 0.7f;
        this.eyeOpenThreshold = 0.3f;
        this.mouthCloseThreshold = 0.7f;
        this.mouthOpenThreshold = 0.3f;
        this.lookUpThreshold = 8.0f;
        this.lookDownThreshold = -8.0f;
        this.turnLeftThreshold = 8.0f;
        this.turnRightThreshold = -8.0f;
        this.shakeThreshold = 10.0f;
    }
}
