package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String byI;
    private String byJ;
    private String byK;
    private String byL;
    private int byM;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.byI = headSdk.head_pic;
            this.byJ = headSdk.head_text;
            this.byK = headSdk.sdk_name;
            this.byL = headSdk.sdk_params;
            this.byM = headSdk.head_type.intValue();
        }
    }
}
