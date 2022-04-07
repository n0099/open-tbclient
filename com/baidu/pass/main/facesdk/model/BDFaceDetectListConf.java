package com.baidu.pass.main.facesdk.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BDFaceDetectListConf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean usingAlign;
    public boolean usingAttribute;
    public boolean usingDetect;
    public boolean usingEmotion;
    public boolean usingEyeClose;
    public boolean usingHeadPose;
    public boolean usingMouthClose;
    public boolean usingQuality;

    public BDFaceDetectListConf() {
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
        this.usingDetect = false;
        this.usingAlign = true;
        this.usingQuality = false;
        this.usingHeadPose = false;
        this.usingAttribute = false;
        this.usingEmotion = false;
        this.usingEyeClose = false;
        this.usingMouthClose = false;
    }
}
