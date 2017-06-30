package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class z {
    private String Va;
    private String Vb;
    private String Vc;
    private String Vd;
    private int Ve;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Va = headSdk.head_pic;
            this.Vb = headSdk.head_text;
            this.Vc = headSdk.sdk_name;
            this.Vd = headSdk.sdk_params;
            this.Ve = headSdk.head_type.intValue();
        }
    }
}
