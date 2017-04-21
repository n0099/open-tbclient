package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String VU;
    private String VV;
    private String VW;
    private String VX;
    private int VY;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.VU = headSdk.head_pic;
            this.VV = headSdk.head_text;
            this.VW = headSdk.sdk_name;
            this.VX = headSdk.sdk_params;
            this.VY = headSdk.head_type.intValue();
        }
    }

    public String qG() {
        return this.VU;
    }

    public String qH() {
        return this.VV;
    }

    public String qI() {
        return this.VX;
    }

    public int qJ() {
        return this.VY;
    }
}
