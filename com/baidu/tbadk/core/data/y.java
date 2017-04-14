package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String VS;
    private String VT;
    private String VU;
    private String VV;
    private int VW;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.VS = headSdk.head_pic;
            this.VT = headSdk.head_text;
            this.VU = headSdk.sdk_name;
            this.VV = headSdk.sdk_params;
            this.VW = headSdk.head_type.intValue();
        }
    }

    public String qG() {
        return this.VS;
    }

    public String qH() {
        return this.VT;
    }

    public String qI() {
        return this.VV;
    }

    public int qJ() {
        return this.VW;
    }
}
