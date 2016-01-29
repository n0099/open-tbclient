package com.baidu.adp.lib.c;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    private int mDefaultType;
    private String mName;
    private a mSwitchListener;
    private int mMaxCrashTimes = 0;
    private String[] tV = null;
    private int mOffType = 0;

    /* loaded from: classes.dex */
    public interface a {
        void b(String str, int i, boolean z);
    }

    public c(String str, int i, a aVar) {
        this.mName = null;
        this.mSwitchListener = null;
        this.mDefaultType = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.mSwitchListener = aVar;
        this.mDefaultType = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.mMaxCrashTimes = i;
        this.tV = strArr;
        this.mOffType = i2;
    }

    public String getName() {
        return this.mName;
    }

    public int getMaxCrashTimes() {
        return this.mMaxCrashTimes;
    }

    public String[] gB() {
        return this.tV;
    }

    public int getOffType() {
        return this.mOffType;
    }

    public int getDefaultType() {
        return this.mDefaultType;
    }

    public void b(int i, boolean z) {
        if (this.mSwitchListener != null) {
            this.mSwitchListener.b(this.mName, i, z);
        }
    }
}
