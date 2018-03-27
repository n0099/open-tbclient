package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String aMv;
    private String aMw;
    private String aMx;
    private String aMy;
    private int aMz;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.aMv = headSdk.head_pic;
            this.aMw = headSdk.head_text;
            this.aMx = headSdk.sdk_name;
            this.aMy = headSdk.sdk_params;
            this.aMz = headSdk.head_type.intValue();
        }
    }
}
