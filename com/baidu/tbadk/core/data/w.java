package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String arO;
    private String arP;
    private String arQ;
    private String arR;
    private int arS;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.arO = headSdk.head_pic;
            this.arP = headSdk.head_text;
            this.arQ = headSdk.sdk_name;
            this.arR = headSdk.sdk_params;
            this.arS = headSdk.head_type.intValue();
        }
    }
}
