package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String amX;
    private String amY;
    private String amZ;
    private String ana;
    private int anb;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.amX = headSdk.head_pic;
            this.amY = headSdk.head_text;
            this.amZ = headSdk.sdk_name;
            this.ana = headSdk.sdk_params;
            this.anb = headSdk.head_type.intValue();
        }
    }
}
