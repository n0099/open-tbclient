package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class ae {
    private String evi;
    private String evj;
    private String evk;
    private String evl;
    private int evm;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.evi = headSdk.head_pic;
            this.evj = headSdk.head_text;
            this.evk = headSdk.sdk_name;
            this.evl = headSdk.sdk_params;
            this.evm = headSdk.head_type.intValue();
        }
    }
}
