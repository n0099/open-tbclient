package com.baidu.tbadk;

import d.a.m0.l.d;
/* loaded from: classes3.dex */
public class TbDebugSingleton {
    public static volatile TbDebugSingleton mInstance;
    public d mUrlSwitchMap = null;

    public static TbDebugSingleton getInstance() {
        if (mInstance == null) {
            synchronized (TbDebugSingleton.class) {
                if (mInstance == null) {
                    mInstance = new TbDebugSingleton();
                }
            }
        }
        return mInstance;
    }

    public d getUrlSwitchMap() {
        return this.mUrlSwitchMap;
    }

    public void setUrlSwitchMap(d dVar) {
        this.mUrlSwitchMap = dVar;
    }
}
