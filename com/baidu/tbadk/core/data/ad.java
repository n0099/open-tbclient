package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class ad {
    private String dOZ;
    private String dPa;
    private String dPb;
    private String dPc;
    private int dPd;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.dOZ = headSdk.head_pic;
            this.dPa = headSdk.head_text;
            this.dPb = headSdk.sdk_name;
            this.dPc = headSdk.sdk_params;
            this.dPd = headSdk.head_type.intValue();
        }
    }
}
