package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String byC;
    private String byD;
    private String byE;
    private String byF;
    private int byG;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.byC = headSdk.head_pic;
            this.byD = headSdk.head_text;
            this.byE = headSdk.sdk_name;
            this.byF = headSdk.sdk_params;
            this.byG = headSdk.head_type.intValue();
        }
    }
}
