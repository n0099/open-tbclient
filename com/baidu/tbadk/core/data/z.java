package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class z {
    private String dop;
    private String doq;
    private String dor;
    private String dos;
    private int dot;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.dop = headSdk.head_pic;
            this.doq = headSdk.head_text;
            this.dor = headSdk.sdk_name;
            this.dos = headSdk.sdk_params;
            this.dot = headSdk.head_type.intValue();
        }
    }
}
