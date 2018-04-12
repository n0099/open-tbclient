package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class x {
    private String XQ;
    private String XR;
    private String XS;
    private String XT;
    private int XU;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.XQ = headSdk.head_pic;
            this.XR = headSdk.head_text;
            this.XS = headSdk.sdk_name;
            this.XT = headSdk.sdk_params;
            this.XU = headSdk.head_type.intValue();
        }
    }
}
