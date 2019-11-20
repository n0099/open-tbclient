package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String bYo;
    private String bYp;
    private String bYq;
    private String bYr;
    private int bYs;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.bYo = headSdk.head_pic;
            this.bYp = headSdk.head_text;
            this.bYq = headSdk.sdk_name;
            this.bYr = headSdk.sdk_params;
            this.bYs = headSdk.head_type.intValue();
        }
    }
}
