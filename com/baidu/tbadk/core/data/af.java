package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class af {
    private String eQh;
    private String eQi;
    private String eQj;
    private String eQk;
    private int eQl;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.eQh = headSdk.head_pic;
            this.eQi = headSdk.head_text;
            this.eQj = headSdk.sdk_name;
            this.eQk = headSdk.sdk_params;
            this.eQl = headSdk.head_type.intValue();
        }
    }
}
