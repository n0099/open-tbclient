package com.baidu.tbadk.core.util.httpNet;
/* loaded from: classes.dex */
public class e {
    public int KB;
    public int KC;
    public String KD = null;
    public boolean gi = false;
    public String mErrorString;

    public boolean pc() {
        return this.KB == 200;
    }

    public boolean ma() {
        return this.KB == 200 && this.KC == 0;
    }

    public boolean pj() {
        return this.KB == 200 || this.KB == 206;
    }
}
