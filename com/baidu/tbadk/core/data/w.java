package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String anK;
    private String anL;
    private String anM;
    private String anN;
    private int anO;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.anK = headSdk.head_pic;
            this.anL = headSdk.head_text;
            this.anM = headSdk.sdk_name;
            this.anN = headSdk.sdk_params;
            this.anO = headSdk.head_type.intValue();
        }
    }
}
