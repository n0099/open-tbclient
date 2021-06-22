package com.baidu.pass.main.facesdk.model;

import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
/* loaded from: classes2.dex */
public class BDFaceGazeInfo {
    public float leftEyeConf;
    public BDFaceSDKCommon.BDFaceGazeDirection leftEyeGaze;
    public float rightEyeConf;
    public BDFaceSDKCommon.BDFaceGazeDirection rightEyeGaze;

    public BDFaceGazeInfo(int i2, float f2, int i3, float f3) {
        this.leftEyeGaze = BDFaceSDKCommon.BDFaceGazeDirection.values()[i2];
        this.leftEyeConf = f2;
        this.rightEyeGaze = BDFaceSDKCommon.BDFaceGazeDirection.values()[i3];
        this.rightEyeConf = f3;
    }
}
