package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String WP;
    private String WQ;
    private String WR;
    private String WS;
    private int WT;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.WP = headSdk.head_pic;
            this.WQ = headSdk.head_text;
            this.WR = headSdk.sdk_name;
            this.WS = headSdk.sdk_params;
            this.WT = headSdk.head_type.intValue();
        }
    }
}
