package com.baidu.adp.lib.featureSwitch;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int mDefaultType;
    private String mName;
    private a mSwitchListener;
    private int mMaxCrashTimes = 0;
    private String[] qe = null;
    private int mOffType = 0;
    private String[] qf = null;
    private boolean qg = false;

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
        this.qe = strArr;
        this.mOffType = i2;
    }

    public void D(boolean z) {
        this.qg = z;
    }

    public boolean fD() {
        return this.qg;
    }

    public void g(String[] strArr) {
        this.qf = strArr;
    }

    public String[] getSwitchLibs() {
        return this.qf;
    }

    public String getName() {
        return this.mName;
    }

    public int getMaxCrashTimes() {
        return this.mMaxCrashTimes;
    }

    public String[] fE() {
        return this.qe;
    }

    public int getOffType() {
        return this.mOffType;
    }

    public int getDefaultType() {
        return this.mDefaultType;
    }

    public void f(int i, boolean z) {
        if (this.mSwitchListener != null) {
            this.mSwitchListener.a(this.mName, i, z);
        }
    }
}
