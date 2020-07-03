package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class ac {
    private String dIO;
    private String dIP;
    private String dIQ;
    private String dIR;
    private int dIS;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.dIO = headSdk.head_pic;
            this.dIP = headSdk.head_text;
            this.dIQ = headSdk.sdk_name;
            this.dIR = headSdk.sdk_params;
            this.dIS = headSdk.head_type.intValue();
        }
    }
}
