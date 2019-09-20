package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String bHu;
    private String bHv;
    private String bHw;
    private String bHx;
    private int bHy;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.bHu = headSdk.head_pic;
            this.bHv = headSdk.head_text;
            this.bHw = headSdk.sdk_name;
            this.bHx = headSdk.sdk_params;
            this.bHy = headSdk.head_type.intValue();
        }
    }
}
