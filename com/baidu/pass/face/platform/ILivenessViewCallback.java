package com.baidu.pass.face.platform;

import com.baidu.pass.face.platform.model.FaceExtInfo;
/* loaded from: classes2.dex */
public interface ILivenessViewCallback {
    void animStop();

    void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum);

    void setFaceInfo(FaceExtInfo faceExtInfo);

    void viewReset();
}
