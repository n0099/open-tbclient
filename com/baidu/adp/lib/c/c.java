package com.baidu.adp.lib.c;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    private int mDefaultType;
    private String mName;
    private a mSwitchListener;
    private int mMaxCrashTimes = 0;
    private String[] mO = null;
    private int mOffType = 0;
    private String[] mP = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
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
        this.mO = strArr;
        this.mOffType = i2;
    }

    public void g(String[] strArr) {
        this.mP = strArr;
    }

    public String[] getSwitchLibs() {
        return this.mP;
    }

    public String getName() {
        return this.mName;
    }

    public int getMaxCrashTimes() {
        return this.mMaxCrashTimes;
    }

    public String[] dK() {
        return this.mO;
    }

    public int getOffType() {
        return this.mOffType;
    }

    public int getDefaultType() {
        return this.mDefaultType;
    }

    public void d(int i, boolean z) {
        if (this.mSwitchListener != null) {
            this.mSwitchListener.a(this.mName, i, z);
        }
    }
}
