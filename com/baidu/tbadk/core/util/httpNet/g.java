package com.baidu.tbadk.core.util.httpNet;
/* loaded from: classes.dex */
public class g {
    public int FY;
    public int FZ;
    public String Ga = null;
    public boolean ee = false;
    public String mErrorString;

    public boolean mf() {
        return this.FY == 200;
    }

    public boolean jq() {
        return this.FY == 200 && this.FZ == 0;
    }

    public boolean mm() {
        return this.FY == 200 || this.FY == 206;
    }
}
