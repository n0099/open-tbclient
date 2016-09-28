package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class v {
    private String QM;
    private String QN;
    private String QO;
    private String QP;
    private int QR;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.QM = headSdk.head_pic;
            this.QN = headSdk.head_text;
            this.QO = headSdk.sdk_name;
            this.QP = headSdk.sdk_params;
            this.QR = headSdk.head_type.intValue();
        }
    }

    public String pT() {
        return this.QM;
    }

    public String pU() {
        return this.QN;
    }

    public String pV() {
        return this.QP;
    }

    public int pW() {
        return this.QR;
    }
}
