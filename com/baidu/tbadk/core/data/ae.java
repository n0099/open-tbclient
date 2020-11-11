package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class ae {
    private String eBb;
    private String eBc;
    private String eBd;
    private String eBe;
    private int eBf;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.eBb = headSdk.head_pic;
            this.eBc = headSdk.head_text;
            this.eBd = headSdk.sdk_name;
            this.eBe = headSdk.sdk_params;
            this.eBf = headSdk.head_type.intValue();
        }
    }
}
