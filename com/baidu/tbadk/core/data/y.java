package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String Vq;
    private String Vr;
    private String Vs;
    private String Vt;
    private int Vu;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Vq = headSdk.head_pic;
            this.Vr = headSdk.head_text;
            this.Vs = headSdk.sdk_name;
            this.Vt = headSdk.sdk_params;
            this.Vu = headSdk.head_type.intValue();
        }
    }
}
