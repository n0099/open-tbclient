package com.baidu.ala.dumixar;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ARNetKey2BeautyType {
    public static HashMap<String, BeautyType> sKeyMap = new HashMap<>();

    static {
        sKeyMap.put("spear", BeautyType.anchorPoints);
        sKeyMap.put("faceLeftAndRight", BeautyType.faceLeftAndRight);
        sKeyMap.put("chin", BeautyType.chin);
        sKeyMap.put("chinLeftAndRight", BeautyType.chinLeftAndRight);
        sKeyMap.put("chinLeftAndRightLower", BeautyType.chinLeftAndRightLower);
        sKeyMap.put("chinRadius", BeautyType.chinRadius);
        sKeyMap.put("chinUpRadius", BeautyType.chinUpRadius);
        sKeyMap.put("chinCloseRadius", BeautyType.chinCloseRadius);
        sKeyMap.put("faceLeftAndRightRadius", BeautyType.faceLeftAndRightRadius);
        sKeyMap.put("top1", BeautyType.top1);
        sKeyMap.put("top2", BeautyType.top2);
        sKeyMap.put("top3", BeautyType.top3);
        sKeyMap.put("top4", BeautyType.top4);
        sKeyMap.put("top5", BeautyType.top5);
        sKeyMap.put("top1Radius", BeautyType.top1Radius);
        sKeyMap.put("top2Radius", BeautyType.top2Radius);
        sKeyMap.put("top3Radius", BeautyType.top3Radius);
        sKeyMap.put("top4Radius", BeautyType.top4Radius);
        sKeyMap.put("top5Radius", BeautyType.top5Radius);
        sKeyMap.put("threeCounts", BeautyType.threeCounts);
        sKeyMap.put("chinWidth", BeautyType.chinWidth);
        sKeyMap.put("noseWingWidth", BeautyType.noseWingWidth);
        sKeyMap.put("eyeDistance", BeautyType.eyeDistance);
        sKeyMap.put("mouthWidth", BeautyType.mouthWidth);
        sKeyMap.put("eyebrowDistance", BeautyType.eyebrowDistance);
        sKeyMap.put("jawAngleWidth", BeautyType.jawAngleWidth);
        sKeyMap.put("eyeAngle", BeautyType.eyeAngle);
        sKeyMap.put("upCount", BeautyType.upCount);
        sKeyMap.put("whiten", BeautyType.whiten);
        sKeyMap.put("smooth", BeautyType.smooth);
        sKeyMap.put(LivenessStat.TYPE_LIVING_EYE, BeautyType.eye);
        sKeyMap.put("thinFace", BeautyType.thinFace);
        sKeyMap.put("faceWidth", BeautyType.faceWidth);
        sKeyMap.put("chinHeight", BeautyType.chinHeight);
        sKeyMap.put("noseBridgeWidth", BeautyType.noseBridgeWidth);
        sKeyMap.put("middleCount", BeautyType.middleCount);
        sKeyMap.put("downCount", BeautyType.downCount);
    }

    public static BeautyType getBeautyType(String str) {
        return sKeyMap.get(str);
    }
}
