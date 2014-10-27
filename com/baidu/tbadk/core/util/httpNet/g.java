package com.baidu.tbadk.core.util.httpNet;
/* loaded from: classes.dex */
public class g {
    public int FX;
    public int FY;
    public String FZ = null;
    public boolean ee = false;
    public String mErrorString;

    public boolean mf() {
        return this.FX == 200;
    }

    public boolean jq() {
        return this.FX == 200 && this.FY == 0;
    }

    public boolean mm() {
        return this.FX == 200 || this.FX == 206;
    }
}
