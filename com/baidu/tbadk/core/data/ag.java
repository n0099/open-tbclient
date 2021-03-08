package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class ag {
    private String ePj;
    private String ePk;
    private String ePl;
    private String ePm;
    private int ePn;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.ePj = headSdk.head_pic;
            this.ePk = headSdk.head_text;
            this.ePl = headSdk.sdk_name;
            this.ePm = headSdk.sdk_params;
            this.ePn = headSdk.head_type.intValue();
        }
    }
}
