package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String Rf;
    private String Rg;
    private String Rh;
    private String Ri;
    private int Rj;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Rf = headSdk.head_pic;
            this.Rg = headSdk.head_text;
            this.Rh = headSdk.sdk_name;
            this.Ri = headSdk.sdk_params;
            this.Rj = headSdk.head_type.intValue();
        }
    }

    public String pX() {
        return this.Rf;
    }

    public String pY() {
        return this.Rg;
    }

    public String pZ() {
        return this.Ri;
    }

    public int qa() {
        return this.Rj;
    }
}
