package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class z {
    private String cOV;
    private String cOW;
    private String cOX;
    private String cOY;
    private int cOZ;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.cOV = headSdk.head_pic;
            this.cOW = headSdk.head_text;
            this.cOX = headSdk.sdk_name;
            this.cOY = headSdk.sdk_params;
            this.cOZ = headSdk.head_type.intValue();
        }
    }
}
