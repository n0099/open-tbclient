package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String Ws;
    private String Wt;
    private String Wu;
    private String Wv;
    private int Ww;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.Ws = headSdk.head_pic;
            this.Wt = headSdk.head_text;
            this.Wu = headSdk.sdk_name;
            this.Wv = headSdk.sdk_params;
            this.Ww = headSdk.head_type.intValue();
        }
    }
}
