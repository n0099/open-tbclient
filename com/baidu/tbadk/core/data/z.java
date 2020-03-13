package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class z {
    private String cOW;
    private String cOX;
    private String cOY;
    private String cOZ;
    private int cPa;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.cOW = headSdk.head_pic;
            this.cOX = headSdk.head_text;
            this.cOY = headSdk.sdk_name;
            this.cOZ = headSdk.sdk_params;
            this.cPa = headSdk.head_type.intValue();
        }
    }
}
