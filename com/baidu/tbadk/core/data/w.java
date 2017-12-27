package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String aLk;
    private String aLl;
    private String aLm;
    private String aLn;
    private int aLo;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.aLk = headSdk.head_pic;
            this.aLl = headSdk.head_text;
            this.aLm = headSdk.sdk_name;
            this.aLn = headSdk.sdk_params;
            this.aLo = headSdk.head_type.intValue();
        }
    }
}
