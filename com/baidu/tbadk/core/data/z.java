package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class z {
    private String cOU;
    private String cOV;
    private String cOW;
    private String cOX;
    private int cOY;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.cOU = headSdk.head_pic;
            this.cOV = headSdk.head_text;
            this.cOW = headSdk.sdk_name;
            this.cOX = headSdk.sdk_params;
            this.cOY = headSdk.head_type.intValue();
        }
    }
}
