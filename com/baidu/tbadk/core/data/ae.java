package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class ae {
    private String emI;
    private String emJ;
    private String emK;
    private String emL;
    private int emM;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.emI = headSdk.head_pic;
            this.emJ = headSdk.head_text;
            this.emK = headSdk.sdk_name;
            this.emL = headSdk.sdk_params;
            this.emM = headSdk.head_type.intValue();
        }
    }
}
