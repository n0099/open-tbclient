package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class x {
    private String XR;
    private String XS;
    private String XT;
    private String XU;
    private int XV;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.XR = headSdk.head_pic;
            this.XS = headSdk.head_text;
            this.XT = headSdk.sdk_name;
            this.XU = headSdk.sdk_params;
            this.XV = headSdk.head_type.intValue();
        }
    }
}
