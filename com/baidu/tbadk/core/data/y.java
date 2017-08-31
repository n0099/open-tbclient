package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String VY;
    private String VZ;
    private String Wa;
    private String Wb;
    private int Wc;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.VY = headSdk.head_pic;
            this.VZ = headSdk.head_text;
            this.Wa = headSdk.sdk_name;
            this.Wb = headSdk.sdk_params;
            this.Wc = headSdk.head_type.intValue();
        }
    }
}
