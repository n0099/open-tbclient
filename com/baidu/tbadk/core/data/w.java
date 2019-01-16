package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String arN;
    private String arO;
    private String arP;
    private String arQ;
    private int arR;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.arN = headSdk.head_pic;
            this.arO = headSdk.head_text;
            this.arP = headSdk.sdk_name;
            this.arQ = headSdk.sdk_params;
            this.arR = headSdk.head_type.intValue();
        }
    }
}
