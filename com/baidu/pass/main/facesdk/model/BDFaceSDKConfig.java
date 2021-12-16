package com.baidu.pass.main.facesdk.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BDFaceSDKConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float detectInterval;
    public boolean isAttribute;
    public boolean isCheckBlur;
    public boolean isCropFace;
    public boolean isEmotion;
    public boolean isEyeClose;
    public boolean isHeadPose;
    public boolean isIllumination;
    public boolean isMouthClose;
    public boolean isOcclusion;
    public int maxDetectNum;
    public int minFaceSize;
    public float notNIRFaceThreshold;
    public float notRGBFaceThreshold;
    public float scaleRatio;
    public float trackInterval;

    public BDFaceSDKConfig() {
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
        this.scaleRatio = -1.0f;
        this.maxDetectNum = 10;
        this.minFaceSize = 0;
        this.notRGBFaceThreshold = 0.5f;
        this.notNIRFaceThreshold = 0.5f;
        this.detectInterval = 0.0f;
        this.trackInterval = 500.0f;
        this.isCheckBlur = false;
        this.isOcclusion = false;
        this.isIllumination = false;
        this.isHeadPose = false;
        this.isAttribute = false;
        this.isEmotion = false;
        this.isCropFace = false;
        this.isEyeClose = false;
        this.isMouthClose = false;
    }
}
