package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class x {
    private String Ri;
    private String Rj;
    private String Rk;
    private String Rl;
    private int Rm;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Ri = headSdk.head_pic;
            this.Rj = headSdk.head_text;
            this.Rk = headSdk.sdk_name;
            this.Rl = headSdk.sdk_params;
            this.Rm = headSdk.head_type.intValue();
        }
    }

    public String pW() {
        return this.Ri;
    }

    public String pX() {
        return this.Rj;
    }

    public String pY() {
        return this.Rl;
    }

    public int pZ() {
        return this.Rm;
    }
}
