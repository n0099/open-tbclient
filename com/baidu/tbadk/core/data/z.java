package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class z {
    private String dot;
    private String dou;
    private String dov;
    private String dow;
    private int dox;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.dot = headSdk.head_pic;
            this.dou = headSdk.head_text;
            this.dov = headSdk.sdk_name;
            this.dow = headSdk.sdk_params;
            this.dox = headSdk.head_type.intValue();
        }
    }
}
