package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String aMu;
    private String aMv;
    private String aMw;
    private String aMx;
    private int aMy;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.aMu = headSdk.head_pic;
            this.aMv = headSdk.head_text;
            this.aMw = headSdk.sdk_name;
            this.aMx = headSdk.sdk_params;
            this.aMy = headSdk.head_type.intValue();
        }
    }
}
