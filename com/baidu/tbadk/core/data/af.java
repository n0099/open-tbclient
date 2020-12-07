package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class af {
    private String eGr;
    private String eGs;
    private String eGt;
    private String eGu;
    private int eGv;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.eGr = headSdk.head_pic;
            this.eGs = headSdk.head_text;
            this.eGt = headSdk.sdk_name;
            this.eGu = headSdk.sdk_params;
            this.eGv = headSdk.head_type.intValue();
        }
    }
}
