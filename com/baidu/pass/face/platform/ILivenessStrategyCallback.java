package com.baidu.pass.face.platform;

import com.baidu.pass.face.platform.model.ImageInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public interface ILivenessStrategyCallback {
    void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i);
}
