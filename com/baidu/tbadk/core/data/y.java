package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String byH;
    private String byI;
    private String byJ;
    private String byK;
    private int byL;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.byH = headSdk.head_pic;
            this.byI = headSdk.head_text;
            this.byJ = headSdk.sdk_name;
            this.byK = headSdk.sdk_params;
            this.byL = headSdk.head_type.intValue();
        }
    }
}
