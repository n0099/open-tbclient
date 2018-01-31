package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String aLl;
    private String aLm;
    private String aLn;
    private String aLo;
    private int aLp;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.aLl = headSdk.head_pic;
            this.aLm = headSdk.head_text;
            this.aLn = headSdk.sdk_name;
            this.aLo = headSdk.sdk_params;
            this.aLp = headSdk.head_type.intValue();
        }
    }
}
