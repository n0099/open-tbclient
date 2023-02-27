package com.baidu.live.business.refresh;
/* loaded from: classes2.dex */
public class LoadAnimStrategy {
    public static LoadAnimStrategy sInstance;
    public String loadMoreLottieRecRes;
    public String loadMoreLottieRes;
    public String loadMoreLottieRes1;
    public String loadMoreLottieRes2;
    public String loadMoreLottieRes3;
    public int loadMoreLottieResId;
    public int loadMoreLottieResId1;
    public int loadMoreLottieResId2;
    public int loadMoreLottieResId3;
    public int loadMoreLottieResRecId;
    public float loadingLottieHeight;
    public String loadingLottieImgRes;
    public String loadingLottieRecRes;
    public int loadingLottieRecResId;
    public String loadingLottieRes;
    public String loadingLottieRes1;
    public String loadingLottieRes2;
    public String loadingLottieRes3;
    public int loadingLottieResId;
    public int loadingLottieResId1;
    public int loadingLottieResId2;
    public int loadingLottieResId3;
    public float loadingLottieWidth;
    public int loopEndFrame;
    public int loopStartFrame;
    public int lottieTotalFrame;
    public String pullDownLottieRecRes;
    public int pullDownLottieRecResId;
    public String pullDownLottieRes;
    public String pullDownLottieRes1;
    public String pullDownLottieRes2;
    public String pullDownLottieRes3;
    public int pullDownLottieResId;
    public int pullDownLottieResId1;
    public int pullDownLottieResId2;
    public int pullDownLottieResId3;
    public int pullEndFrame;

    /* loaded from: classes2.dex */
    public static class Holder {
        public static final LoadAnimStrategy INSTANCE = new LoadAnimStrategy();
    }

    public static LoadAnimStrategy getInstance() {
        if (sInstance == null) {
            sInstance = Holder.INSTANCE;
        }
        return sInstance;
    }

    public void setLoadMoreAnimStrategy(String str, String str2, String str3, String str4) {
        this.loadMoreLottieRes = str;
        this.loadMoreLottieRes1 = str2;
        this.loadMoreLottieRes2 = str3;
        this.loadMoreLottieRes3 = str4;
    }

    public void setLoadMoreAnimStrategyId(int i, int i2, int i3, int i4) {
        this.loadMoreLottieResId = i;
        this.loadMoreLottieResId1 = i2;
        this.loadMoreLottieResId2 = i3;
        this.loadMoreLottieResId3 = i4;
    }

    public void setRecLoadingLottieRes(String str, String str2, float f, float f2) {
        this.loadingLottieRecRes = str;
        this.loadingLottieImgRes = str2;
        this.loadingLottieWidth = f;
        this.loadingLottieHeight = f2;
    }

    public void setRecLoadingLottieResId(int i, String str, float f, float f2) {
        this.loadingLottieRecResId = i;
        this.loadingLottieImgRes = str;
        this.loadingLottieWidth = f;
        this.loadingLottieHeight = f2;
    }

    public void setLoadingLottieRes(String str, String str2, String str3, String str4, String str5, float f, float f2) {
        this.loadingLottieRes = str;
        this.loadingLottieRes1 = str2;
        this.loadingLottieRes2 = str3;
        this.loadingLottieRes3 = str4;
        this.loadingLottieImgRes = str5;
        this.loadingLottieWidth = f;
        this.loadingLottieHeight = f2;
    }

    public void setLoadingLottieResId(int i, int i2, int i3, int i4, String str, float f, float f2) {
        this.loadingLottieResId = i;
        this.loadingLottieResId1 = i2;
        this.loadingLottieResId2 = i3;
        this.loadingLottieResId3 = i4;
        this.loadingLottieImgRes = str;
        this.loadingLottieWidth = f;
        this.loadingLottieHeight = f2;
    }

    public void setPullDownAnimStrategy(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4) {
        this.pullDownLottieRes = str;
        this.pullDownLottieRes1 = str2;
        this.pullDownLottieRes2 = str3;
        this.pullDownLottieRes3 = str4;
        this.pullEndFrame = i;
        this.loopStartFrame = i2;
        this.loopEndFrame = i3;
        this.lottieTotalFrame = i4;
    }

    public void setRecLoadMoreAnimStrategy(String str) {
        this.loadMoreLottieRecRes = str;
    }

    public void setRecLoadMoreAnimStrategyId(int i) {
        this.loadMoreLottieResRecId = i;
    }

    public void setRecPullDownAnimStrategy(String str, int i, int i2, int i3, int i4) {
        this.pullDownLottieRecRes = str;
        this.pullEndFrame = i;
        this.loopStartFrame = i2;
        this.loopEndFrame = i3;
        this.lottieTotalFrame = i4;
    }

    public void setRecPullDownAnimStrategyId(int i, int i2, int i3, int i4, int i5) {
        this.pullDownLottieRecResId = i;
        this.pullEndFrame = i2;
        this.loopStartFrame = i3;
        this.loopEndFrame = i4;
        this.lottieTotalFrame = i5;
    }
}
