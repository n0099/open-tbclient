package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class z {
    private String cKR;
    private String cKS;
    private String cKT;
    private String cKU;
    private int cKV;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.cKR = headSdk.head_pic;
            this.cKS = headSdk.head_text;
            this.cKT = headSdk.sdk_name;
            this.cKU = headSdk.sdk_params;
            this.cKV = headSdk.head_type.intValue();
        }
    }
}
