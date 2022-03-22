package com.baidu.pass.face.platform;

import com.baidu.pass.face.platform.model.ImageInfo;
import java.util.HashMap;
/* loaded from: classes4.dex */
public interface IDetectStrategyCallback {
    void onDetectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2);
}
