package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String aic;
    private String aid;
    private String aie;
    private String aif;
    private int aig;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.aic = headSdk.head_pic;
            this.aid = headSdk.head_text;
            this.aie = headSdk.sdk_name;
            this.aif = headSdk.sdk_params;
            this.aig = headSdk.head_type.intValue();
        }
    }
}
