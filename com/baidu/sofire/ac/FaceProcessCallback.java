package com.baidu.sofire.ac;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import java.util.HashMap;
/* loaded from: classes9.dex */
public interface FaceProcessCallback {
    void animStop();

    void onBegin();

    void onBeginBuildData();

    void onBeginCollectFaceInfo();

    void onCollectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i2);

    void onConfigCamera(Camera camera, Rect rect, Rect rect2);

    void onDeviceCheckResult(int i2);

    void onEnd(int i2, RequestInfo requestInfo);

    void onTestFrame(Bitmap bitmap);

    void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum);

    void setFaceInfo(FaceExtInfo faceExtInfo);

    void viewReset();
}
