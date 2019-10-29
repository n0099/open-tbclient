package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class y {
    private String bZf;
    private String bZg;
    private String bZh;
    private String bZi;
    private int bZj;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.bZf = headSdk.head_pic;
            this.bZg = headSdk.head_text;
            this.bZh = headSdk.sdk_name;
            this.bZi = headSdk.sdk_params;
            this.bZj = headSdk.head_type.intValue();
        }
    }
}
