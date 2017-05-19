package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String Vn;
    private String Vo;
    private String Vp;
    private String Vq;
    private int Vr;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Vn = headSdk.head_pic;
            this.Vo = headSdk.head_text;
            this.Vp = headSdk.sdk_name;
            this.Vq = headSdk.sdk_params;
            this.Vr = headSdk.head_type.intValue();
        }
    }
}
