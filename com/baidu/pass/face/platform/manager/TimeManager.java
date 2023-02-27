package com.baidu.pass.face.platform.manager;
/* loaded from: classes2.dex */
public class TimeManager {
    public static TimeManager instance;
    public int mActiveAnimTime;

    public static TimeManager getInstance() {
        if (instance == null) {
            synchronized (TimeManager.class) {
                if (instance == null) {
                    instance = new TimeManager();
                }
            }
        }
        return instance;
    }

    public int getActiveAnimTime() {
        return this.mActiveAnimTime;
    }

    public void setActiveAnimTime(int i) {
        this.mActiveAnimTime = i;
    }
}
