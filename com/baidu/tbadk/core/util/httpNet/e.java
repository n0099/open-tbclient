package com.baidu.tbadk.core.util.httpNet;
/* loaded from: classes.dex */
public class e {
    public int Ki;
    public int Kj;
    public String Kk = null;
    public boolean gg = false;
    public String mErrorString;

    public boolean oZ() {
        return this.Ki == 200;
    }

    public boolean ma() {
        return this.Ki == 200 && this.Kj == 0;
    }

    public boolean pg() {
        return this.Ki == 200 || this.Ki == 206;
    }
}
