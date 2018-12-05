package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String arl;
    private String arm;
    private String arn;
    private String aro;
    private int arp;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.arl = headSdk.head_pic;
            this.arm = headSdk.head_text;
            this.arn = headSdk.sdk_name;
            this.aro = headSdk.sdk_params;
            this.arp = headSdk.head_type.intValue();
        }
    }
}
