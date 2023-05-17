package com.baidu.live.business.view.emotion;
/* loaded from: classes3.dex */
public class EmotionStrategy {
    public static EmotionStrategy sInstance;
    public float emptyHeight;
    public int emptyImageRes;
    public int emptyImageRes1;
    public int emptyImageRes2;
    public int emptyImageRes3;
    public float emptyWidth;
    public float errorHeight;
    public int errorImageRes;
    public int errorImageRes1;
    public int errorImageRes2;
    public int errorImageRes3;
    public float errorWidth;
    public float minorHeight;
    public int minorImageRes;
    public int minorImageRes1;
    public int minorImageRes2;
    public int minorImageRes3;
    public float minorWidth;
    public float networkHeight;
    public int networkImageRes;
    public int networkImageRes1;
    public int networkImageRes2;
    public int networkImageRes3;
    public float networkWidth;
    public int placeHolderRes;
    public int placeHolderRes1;
    public int placeHolderRes2;
    public int placeHolderRes3;
    public int recEmptyImageRes;
    public int recErrorImageRes;
    public int recNetworkImageRes;
    public int recPlaceHolderRes;
    public int videoBarPlaceHolderRes;

    /* loaded from: classes3.dex */
    public static class Holder {
        public static final EmotionStrategy INSTANCE = new EmotionStrategy();
    }

    public static EmotionStrategy getInstance() {
        if (sInstance == null) {
            sInstance = Holder.INSTANCE;
        }
        return sInstance;
    }

    public void setEmptyImageRes(int i, int i2, int i3, int i4, float f, float f2) {
        this.emptyImageRes = i;
        this.emptyImageRes1 = i2;
        this.emptyImageRes2 = i3;
        this.emptyImageRes3 = i4;
        this.emptyWidth = f;
        this.emptyHeight = f2;
    }

    public void setErrorImageRes(int i, int i2, int i3, int i4, float f, float f2) {
        this.errorImageRes = i;
        this.errorImageRes1 = i2;
        this.errorImageRes2 = i3;
        this.errorImageRes3 = i4;
        this.errorWidth = f;
        this.errorHeight = f2;
    }

    public void setMinorImageRes(int i, int i2, int i3, int i4, float f, float f2) {
        this.minorImageRes = i;
        this.minorImageRes1 = i2;
        this.minorImageRes2 = i3;
        this.minorImageRes3 = i4;
        this.minorWidth = f;
        this.minorHeight = f2;
    }

    public void setNetworkImageRes(int i, int i2, int i3, int i4, float f, float f2) {
        this.networkImageRes = i;
        this.networkImageRes1 = i2;
        this.networkImageRes2 = i3;
        this.networkImageRes3 = i4;
        this.networkWidth = f;
        this.networkHeight = f2;
    }

    public void setPlaceHolderRes(int i, int i2, int i3, int i4) {
        this.placeHolderRes = i;
        this.placeHolderRes1 = i2;
        this.placeHolderRes2 = i3;
        this.placeHolderRes3 = i4;
    }

    public void setRecEmptyImageRes(int i, float f, float f2) {
        this.recEmptyImageRes = i;
        this.emptyWidth = f;
        this.emptyHeight = f2;
    }

    public void setRecErrorImageRes(int i, float f, float f2) {
        this.recErrorImageRes = i;
        this.errorWidth = f;
        this.errorHeight = f2;
    }

    public void setRecNetworkImageRes(int i, float f, float f2) {
        this.recNetworkImageRes = i;
        this.networkWidth = f;
        this.networkHeight = f2;
    }

    public void setRecPlaceHolderRes(int i) {
        this.recPlaceHolderRes = i;
    }

    public void setVideoBarPlaceHolderRes(int i) {
        this.videoBarPlaceHolderRes = i;
    }
}
