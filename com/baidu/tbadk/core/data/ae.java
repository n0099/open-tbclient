package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class ae {
    private String eaG;
    private String eaH;
    private String eaI;
    private String eaJ;
    private int eaK;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.eaG = headSdk.head_pic;
            this.eaH = headSdk.head_text;
            this.eaI = headSdk.sdk_name;
            this.eaJ = headSdk.sdk_params;
            this.eaK = headSdk.head_type.intValue();
        }
    }
}
