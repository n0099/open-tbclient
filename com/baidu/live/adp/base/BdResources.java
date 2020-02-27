package com.baidu.live.adp.base;

import android.content.res.Resources;
/* loaded from: classes3.dex */
public class BdResources {
    private static volatile BdResources mInstance = null;
    private Resources mCurrentResources = null;

    public static BdResources getInstance() {
        if (mInstance == null) {
            synchronized (BdResources.class) {
                if (mInstance == null) {
                    mInstance = new BdResources();
                }
            }
        }
        return mInstance;
    }

    public synchronized void setHostResources(Resources resources) {
        this.mCurrentResources = resources;
    }

    public synchronized Resources getResources() {
        return this.mCurrentResources;
    }
}
