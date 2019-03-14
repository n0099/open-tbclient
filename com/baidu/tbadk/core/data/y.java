package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String byE;
    private String byF;
    private String byG;
    private String byH;
    private int byI;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.byE = headSdk.head_pic;
            this.byF = headSdk.head_text;
            this.byG = headSdk.sdk_name;
            this.byH = headSdk.sdk_params;
            this.byI = headSdk.head_type.intValue();
        }
    }
}
