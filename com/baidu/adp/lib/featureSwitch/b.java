package com.baidu.adp.lib.featureSwitch;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int mDefaultType;
    private String mName;
    private a mSwitchListener;
    private int mMaxCrashTimes = 0;
    private String[] Jh = null;
    private int mOffType = 0;
    private String[] Ji = null;
    private boolean Jj = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
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
        this.Jh = strArr;
        this.mOffType = i2;
    }

    public void ac(boolean z) {
        this.Jj = z;
    }

    public boolean kh() {
        return this.Jj;
    }

    public void g(String[] strArr) {
        this.Ji = strArr;
    }

    public String[] getSwitchLibs() {
        return this.Ji;
    }

    public String getName() {
        return this.mName;
    }

    public int getMaxCrashTimes() {
        return this.mMaxCrashTimes;
    }

    public String[] ki() {
        return this.Jh;
    }

    public int getOffType() {
        return this.mOffType;
    }

    public int getDefaultType() {
        return this.mDefaultType;
    }

    public void i(int i, boolean z) {
        if (this.mSwitchListener != null) {
            this.mSwitchListener.a(this.mName, i, z);
        }
    }
}
