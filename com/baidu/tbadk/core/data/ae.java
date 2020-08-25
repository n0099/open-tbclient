package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes2.dex */
public class ae {
    private String dYs;
    private String dYt;
    private String dYu;
    private String dYv;
    private int dYw;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.dYs = headSdk.head_pic;
            this.dYt = headSdk.head_text;
            this.dYu = headSdk.sdk_name;
            this.dYv = headSdk.sdk_params;
            this.dYw = headSdk.head_type.intValue();
        }
    }
}
