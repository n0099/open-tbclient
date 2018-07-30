package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String afB;
    private String afC;
    private String afD;
    private String afE;
    private int afF;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.afB = headSdk.head_pic;
            this.afC = headSdk.head_text;
            this.afD = headSdk.sdk_name;
            this.afE = headSdk.sdk_params;
            this.afF = headSdk.head_type.intValue();
        }
    }
}
