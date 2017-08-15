package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String WO;
    private String WP;
    private String WQ;
    private String WR;
    private int WS;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.WO = headSdk.head_pic;
            this.WP = headSdk.head_text;
            this.WQ = headSdk.sdk_name;
            this.WR = headSdk.sdk_params;
            this.WS = headSdk.head_type.intValue();
        }
    }
}
