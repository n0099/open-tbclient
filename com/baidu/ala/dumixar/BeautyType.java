package com.baidu.ala.dumixar;

import com.baidu.ar.FilterType;
/* loaded from: classes3.dex */
public enum BeautyType {
    babyFace(0.5f, FilterType.babyFace),
    webCelebrityFace(0.5f, FilterType.webCelebrityFace),
    normalFace(0.5f, FilterType.normalFace),
    lutFile(FilterType.lutFile),
    lutIntensity(FilterType.lutIntensity),
    lipsMask(FilterType.lipsMask),
    lips(FilterType.lips),
    cheeks(FilterType.cheeks),
    highlight(FilterType.highlight),
    whiten(0.5f, FilterType.whiten),
    smooth(0.5f, FilterType.smooth),
    eye(0.5f, FilterType.eye),
    thinFace(0.5f, FilterType.thinFace),
    threeCounts(0.5f, FilterType.threeCounts),
    chinHeight(0.5f, FilterType.chinHeight),
    chinWidth(0.0f, FilterType.chinWidth),
    noseBridgeWidth(0.3f, FilterType.noseBridgeWidth),
    noseWingWidth(0.3f, FilterType.noseWingWidth),
    eyeDistance(0.5f, FilterType.eyeDistance),
    mouthWidth(0.5f, FilterType.mouthWidth),
    eyebrowDistance(0.5f, FilterType.eyebrowDistance),
    upCount(0.5f, FilterType.upCount),
    middleCount(0.5f, FilterType.middleCount),
    downCount(0.5f, FilterType.downCount),
    faceWidth(0.5f, FilterType.faceWidth),
    jawAngleWidth(0.0f, FilterType.jawAngleWidth),
    eyeAngle(0.5f, FilterType.eyeAngle),
    anchorPoints(FilterType.customLandmarkIndex),
    faceLeftAndRight(FilterType.faceThinLR),
    chin(FilterType.faceThinC),
    chinLeftAndRight(FilterType.faceThinLRCU),
    chinLeftAndRightLower(FilterType.faceThinLRC),
    chinRadius(FilterType.faceThinCRadius),
    chinUpRadius(FilterType.faceThinCUpRadius),
    chinCloseRadius(FilterType.faceThinCCloseRadius),
    faceLeftAndRightRadius(FilterType.faceThinLRRadius),
    top1(FilterType.faceWidth1Ratio),
    top2(FilterType.faceWidth2Ratio),
    top3(FilterType.faceWidthRatio),
    top4(FilterType.faceWidthCURatio),
    top5(FilterType.faceWidthCRatio),
    top1Radius(FilterType.faceWidth1Radius),
    top2Radius(FilterType.faceWidth2Radius),
    top3Radius(FilterType.faceWidthRadius),
    top4Radius(FilterType.faceWidthCURadius),
    top5Radius(FilterType.faceWidthCRadius),
    globalScaleValue(FilterType.globalScaleValue);
    
    public String icon;
    public FilterType type;
    public float value;

    BeautyType(float f, FilterType filterType) {
        this.value = f;
        this.type = filterType;
    }

    BeautyType(FilterType filterType) {
        this.type = filterType;
    }

    public String getTypeValue() {
        return this.type.getTypeValue();
    }
}
