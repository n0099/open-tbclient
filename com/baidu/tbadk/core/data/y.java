package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String bFT;
    private String bFU;
    private String bFV;
    private String bFW;
    private int bFX;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.bFT = headSdk.head_pic;
            this.bFU = headSdk.head_text;
            this.bFV = headSdk.sdk_name;
            this.bFW = headSdk.sdk_params;
            this.bFX = headSdk.head_type.intValue();
        }
    }
}
