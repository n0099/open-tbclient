package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String dCt;
    private String dCu;
    private String dCv;
    private String dCw;
    private int dCx;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.dCt = headSdk.head_pic;
            this.dCu = headSdk.head_text;
            this.dCv = headSdk.sdk_name;
            this.dCw = headSdk.sdk_params;
            this.dCx = headSdk.head_type.intValue();
        }
    }
}
