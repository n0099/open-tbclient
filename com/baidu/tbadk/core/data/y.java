package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String bGW;
    private String bGX;
    private String bGY;
    private String bGZ;
    private int bHa;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.bGW = headSdk.head_pic;
            this.bGX = headSdk.head_text;
            this.bGY = headSdk.sdk_name;
            this.bGZ = headSdk.sdk_params;
            this.bHa = headSdk.head_type.intValue();
        }
    }
}
