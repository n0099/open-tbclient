package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String bGV;
    private String bGW;
    private String bGX;
    private String bGY;
    private int bGZ;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.bGV = headSdk.head_pic;
            this.bGW = headSdk.head_text;
            this.bGX = headSdk.sdk_name;
            this.bGY = headSdk.sdk_params;
            this.bGZ = headSdk.head_type.intValue();
        }
    }
}
