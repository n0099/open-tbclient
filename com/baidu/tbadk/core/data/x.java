package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class x {
    private String Qo;
    private String Qp;
    private String Qq;
    private String Qr;
    private int Qs;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Qo = headSdk.head_pic;
            this.Qp = headSdk.head_text;
            this.Qq = headSdk.sdk_name;
            this.Qr = headSdk.sdk_params;
            this.Qs = headSdk.head_type.intValue();
        }
    }

    public String pQ() {
        return this.Qo;
    }

    public String pR() {
        return this.Qp;
    }

    public String pS() {
        return this.Qr;
    }

    public int pT() {
        return this.Qs;
    }
}
