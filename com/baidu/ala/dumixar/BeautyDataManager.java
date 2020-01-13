package com.baidu.ala.dumixar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class BeautyDataManager {
    public static final float CHINHEIGHT = 0.25f;
    public static final float CHINWIDTH = 0.5f;
    public static final float DOWNCOUNT = 0.5f;
    public static final float EYE = 0.0f;
    public static final float EYEANGLE = 0.5f;
    public static final float EYEBROWDISTANCE = 0.5f;
    public static final float EYEDISTANCE = 0.5f;
    public static final float FACEWIDTH = 0.4f;
    public static final float JAWANGLEWIDTH = 0.35f;
    public static final float MIDDLECOUNT = 0.65f;
    public static final float MOUTHWIDTH = 0.2f;
    public static final float NOSEBRIDGEWIDTH = 0.21f;
    public static final float NOSEWINGWIDTH = 0.2f;
    public static final float SMOOTH = 0.68f;
    public static final float THINFACE = 0.35f;
    public static final float THREECOUNTS = 0.5f;
    public static final float UPCOUNT = 0.5f;
    public static final float WHITEN = 0.0f;
    private static BeautyDataManager sInstance = new BeautyDataManager();
    private HashMap<String, Object> mDefaultBeautyParams;

    public static BeautyDataManager getInstance() {
        return sInstance;
    }

    private BeautyDataManager() {
    }

    public HashMap<BeautyType, Object> getBeautyTypes(HashMap<BeautyType, Object> hashMap) {
        hashMap.put(BeautyType.whiten, Float.valueOf(0.0f));
        hashMap.put(BeautyType.smooth, Float.valueOf(0.68f));
        hashMap.put(BeautyType.eye, Float.valueOf(0.0f));
        hashMap.put(BeautyType.thinFace, Float.valueOf(0.35f));
        hashMap.put(BeautyType.threeCounts, Float.valueOf(0.5f));
        hashMap.put(BeautyType.chinHeight, Float.valueOf(0.25f));
        hashMap.put(BeautyType.chinWidth, Float.valueOf(0.5f));
        hashMap.put(BeautyType.noseBridgeWidth, Float.valueOf(0.21f));
        hashMap.put(BeautyType.noseWingWidth, Float.valueOf(0.2f));
        hashMap.put(BeautyType.eyeDistance, Float.valueOf(0.5f));
        hashMap.put(BeautyType.mouthWidth, Float.valueOf(0.2f));
        hashMap.put(BeautyType.eyebrowDistance, Float.valueOf(0.5f));
        hashMap.put(BeautyType.downCount, Float.valueOf(0.5f));
        hashMap.put(BeautyType.jawAngleWidth, Float.valueOf(0.35f));
        hashMap.put(BeautyType.eyeAngle, Float.valueOf(0.5f));
        hashMap.put(BeautyType.faceWidth, Float.valueOf(0.4f));
        hashMap.put(BeautyType.middleCount, Float.valueOf(0.65f));
        hashMap.put(BeautyType.upCount, Float.valueOf(0.5f));
        return hashMap;
    }

    public HashMap<BeautyType, Object> getFaceThinTypes(boolean z) {
        HashMap<BeautyType, Object> hashMap = new HashMap<>();
        if (z && this.mDefaultBeautyParams != null && !this.mDefaultBeautyParams.isEmpty()) {
            hashMap.putAll(convertParams(this.mDefaultBeautyParams));
        } else {
            hashMap.put(BeautyType.anchorPoints, new float[]{72.0f, 83.0f, 73.0f, 82.0f, 75.0f, 80.0f, 4.0f, 8.0f, 5.0f, 7.0f, 6.0f});
            hashMap.put(BeautyType.faceLeftAndRight, Float.valueOf(0.9f));
            hashMap.put(BeautyType.chin, Float.valueOf(0.9f));
            hashMap.put(BeautyType.chinLeftAndRight, Float.valueOf(0.95f));
            hashMap.put(BeautyType.chinLeftAndRightLower, Float.valueOf(0.96f));
            hashMap.put(BeautyType.chinRadius, Float.valueOf(1.5f));
            hashMap.put(BeautyType.chinUpRadius, Float.valueOf(1.2f));
            hashMap.put(BeautyType.chinCloseRadius, Float.valueOf(1.2f));
            hashMap.put(BeautyType.faceLeftAndRightRadius, Float.valueOf(1.0f));
            hashMap.put(BeautyType.top1, Float.valueOf(0.9f));
            hashMap.put(BeautyType.top2, Float.valueOf(0.9f));
            hashMap.put(BeautyType.top3, Float.valueOf(0.9f));
            hashMap.put(BeautyType.top4, Float.valueOf(0.85f));
            hashMap.put(BeautyType.top5, Float.valueOf(0.85f));
            hashMap.put(BeautyType.top1Radius, Float.valueOf(0.7f));
            hashMap.put(BeautyType.top2Radius, Float.valueOf(0.7f));
            hashMap.put(BeautyType.top3Radius, Float.valueOf(0.7f));
            hashMap.put(BeautyType.top4Radius, Float.valueOf(0.7f));
            hashMap.put(BeautyType.top5Radius, Float.valueOf(0.7f));
        }
        return hashMap;
    }

    public HashMap<BeautyType, Object> convertParams(HashMap<String, Object> hashMap) {
        BeautyType beautyType;
        HashMap<BeautyType, Object> hashMap2 = new HashMap<>();
        if (hashMap == null || hashMap.isEmpty()) {
            return hashMap2;
        }
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null && (beautyType = ARNetKey2BeautyType.getBeautyType(entry.getKey())) != null) {
                if (entry.getValue() instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) entry.getValue();
                    if (jSONArray != null && jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.opt(i));
                        }
                        entry.setValue(arrayList);
                    }
                } else if (entry.getValue() instanceof String) {
                    try {
                        entry.setValue(Float.valueOf(Float.valueOf((String) entry.getValue()).floatValue()));
                    } catch (NumberFormatException e) {
                    }
                }
                hashMap2.put(beautyType, entry.getValue());
            }
        }
        return hashMap2;
    }

    public void setDefaultBeautyParams(HashMap<String, Object> hashMap) {
        this.mDefaultBeautyParams = hashMap;
    }
}
