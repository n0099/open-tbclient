package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class w {
    private String aLi;
    private String aLj;
    private String aLk;
    private String aLl;
    private int aLm;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.aLi = headSdk.head_pic;
            this.aLj = headSdk.head_text;
            this.aLk = headSdk.sdk_name;
            this.aLl = headSdk.sdk_params;
            this.aLm = headSdk.head_type.intValue();
        }
    }
}
