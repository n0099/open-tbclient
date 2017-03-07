package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String VB;
    private String VC;
    private String VD;
    private String VE;
    private int VF;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.VB = headSdk.head_pic;
            this.VC = headSdk.head_text;
            this.VD = headSdk.sdk_name;
            this.VE = headSdk.sdk_params;
            this.VF = headSdk.head_type.intValue();
        }
    }

    public String qi() {
        return this.VB;
    }

    public String qj() {
        return this.VC;
    }

    public String qk() {
        return this.VE;
    }

    public int ql() {
        return this.VF;
    }
}
