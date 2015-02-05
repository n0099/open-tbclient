package com.baidu.tbadk.core.util.httpNet;
/* loaded from: classes.dex */
public class e {
    public int Ky;
    public int Kz;
    public String mErrorString;
    public String KA = null;
    public boolean gi = false;

    public boolean oV() {
        return this.Ky == 200;
    }

    public boolean lT() {
        return this.Ky == 200 && this.Kz == 0;
    }

    public boolean pc() {
        return this.Ky == 200 || this.Ky == 206;
    }
}
