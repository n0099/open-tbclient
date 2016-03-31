package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class q {
    private String Tf;
    private String Tg;
    private String Th;
    private String Ti;
    private int Tj;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Tf = headSdk.head_pic;
            this.Tg = headSdk.head_text;
            this.Th = headSdk.sdk_name;
            this.Ti = headSdk.sdk_params;
            this.Tj = headSdk.head_type.intValue();
        }
    }

    public String rG() {
        return this.Tf;
    }

    public String rH() {
        return this.Tg;
    }

    public int rI() {
        return this.Tj;
    }
}
