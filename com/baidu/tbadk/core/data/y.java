package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String Wa;
    private String Wb;
    private String Wc;
    private String Wd;
    private int We;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Wa = headSdk.head_pic;
            this.Wb = headSdk.head_text;
            this.Wc = headSdk.sdk_name;
            this.Wd = headSdk.sdk_params;
            this.We = headSdk.head_type.intValue();
        }
    }
}
