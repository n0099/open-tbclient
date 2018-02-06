package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String aMF;
    private String aMG;
    private String aMH;
    private String aMI;
    private int aMJ;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.aMF = headSdk.head_pic;
            this.aMG = headSdk.head_text;
            this.aMH = headSdk.sdk_name;
            this.aMI = headSdk.sdk_params;
            this.aMJ = headSdk.head_type.intValue();
        }
    }
}
