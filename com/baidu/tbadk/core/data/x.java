package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class x {
    private String afS;
    private String afT;
    private String afU;
    private String afV;
    private int afW;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.afS = headSdk.head_pic;
            this.afT = headSdk.head_text;
            this.afU = headSdk.sdk_name;
            this.afV = headSdk.sdk_params;
            this.afW = headSdk.head_type.intValue();
        }
    }
}
