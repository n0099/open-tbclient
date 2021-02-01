package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class ag {
    private String eNI;
    private String eNJ;
    private String eNK;
    private String eNL;
    private int eNM;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.eNI = headSdk.head_pic;
            this.eNJ = headSdk.head_text;
            this.eNK = headSdk.sdk_name;
            this.eNL = headSdk.sdk_params;
            this.eNM = headSdk.head_type.intValue();
        }
    }
}
