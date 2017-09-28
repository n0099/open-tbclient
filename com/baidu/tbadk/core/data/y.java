package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String Wm;
    private String Wn;
    private String Wo;
    private String Wp;
    private int Wq;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Wm = headSdk.head_pic;
            this.Wn = headSdk.head_text;
            this.Wo = headSdk.sdk_name;
            this.Wp = headSdk.sdk_params;
            this.Wq = headSdk.head_type.intValue();
        }
    }
}
