package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String bFU;
    private String bFV;
    private String bFW;
    private String bFX;
    private int bFY;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.bFU = headSdk.head_pic;
            this.bFV = headSdk.head_text;
            this.bFW = headSdk.sdk_name;
            this.bFX = headSdk.sdk_params;
            this.bFY = headSdk.head_type.intValue();
        }
    }
}
