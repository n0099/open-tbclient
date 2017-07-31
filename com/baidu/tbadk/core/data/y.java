package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String WM;
    private String WN;
    private String WO;
    private String WP;
    private int WQ;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.WM = headSdk.head_pic;
            this.WN = headSdk.head_text;
            this.WO = headSdk.sdk_name;
            this.WP = headSdk.sdk_params;
            this.WQ = headSdk.head_type.intValue();
        }
    }
}
