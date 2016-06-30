package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class s {
    private String NR;
    private String NT;
    private String NU;
    private String NV;
    private int NW;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.NR = headSdk.head_pic;
            this.NT = headSdk.head_text;
            this.NU = headSdk.sdk_name;
            this.NV = headSdk.sdk_params;
            this.NW = headSdk.head_type.intValue();
        }
    }

    public String oQ() {
        return this.NR;
    }

    public String oR() {
        return this.NT;
    }

    public String oS() {
        return this.NV;
    }

    public int oT() {
        return this.NW;
    }
}
