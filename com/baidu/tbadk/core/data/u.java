package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class u {
    private String QJ;
    private String QK;
    private String QL;
    private String QM;
    private int QN;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.QJ = headSdk.head_pic;
            this.QK = headSdk.head_text;
            this.QL = headSdk.sdk_name;
            this.QM = headSdk.sdk_params;
            this.QN = headSdk.head_type.intValue();
        }
    }

    public String pI() {
        return this.QJ;
    }

    public String pJ() {
        return this.QK;
    }

    public String pK() {
        return this.QM;
    }

    public int pL() {
        return this.QN;
    }
}
