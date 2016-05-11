package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class q {
    private String NT;
    private String NU;
    private String NV;
    private String NW;
    private int NX;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.NT = headSdk.head_pic;
            this.NU = headSdk.head_text;
            this.NV = headSdk.sdk_name;
            this.NW = headSdk.sdk_params;
            this.NX = headSdk.head_type.intValue();
        }
    }

    public String oZ() {
        return this.NT;
    }

    public String pa() {
        return this.NU;
    }

    public int pb() {
        return this.NX;
    }
}
