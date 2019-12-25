package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class z {
    private String cKG;
    private String cKH;
    private String cKI;
    private String cKJ;
    private int cKK;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.cKG = headSdk.head_pic;
            this.cKH = headSdk.head_text;
            this.cKI = headSdk.sdk_name;
            this.cKJ = headSdk.sdk_params;
            this.cKK = headSdk.head_type.intValue();
        }
    }
}
