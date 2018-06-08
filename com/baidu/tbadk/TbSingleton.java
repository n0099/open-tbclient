package com.baidu.tbadk;
/* loaded from: classes.dex */
public class TbSingleton {
    private static TbSingleton mInstance = null;
    private boolean isRecommendPage;

    private TbSingleton() {
    }

    public static TbSingleton getInstance() {
        if (mInstance == null) {
            synchronized (TbSingleton.class) {
                if (mInstance == null) {
                    mInstance = new TbSingleton();
                }
            }
        }
        return mInstance;
    }

    public void setIsRecommendPage(boolean z) {
        this.isRecommendPage = z;
    }

    public boolean isRecommendPage() {
        return this.isRecommendPage;
    }
}
