package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class ae {
    private int dYA;
    private String dYw;
    private String dYx;
    private String dYy;
    private String dYz;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.dYw = headSdk.head_pic;
            this.dYx = headSdk.head_text;
            this.dYy = headSdk.sdk_name;
            this.dYz = headSdk.sdk_params;
            this.dYA = headSdk.head_type.intValue();
        }
    }
}
