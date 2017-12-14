package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class v {
    private String WJ;
    private String WK;
    private String WL;
    private String WM;
    private int WN;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.WJ = headSdk.head_pic;
            this.WK = headSdk.head_text;
            this.WL = headSdk.sdk_name;
            this.WM = headSdk.sdk_params;
            this.WN = headSdk.head_type.intValue();
        }
    }
}
