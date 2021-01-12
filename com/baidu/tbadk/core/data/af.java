package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class af {
    private int eLA;
    private String eLw;
    private String eLx;
    private String eLy;
    private String eLz;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.eLw = headSdk.head_pic;
            this.eLx = headSdk.head_text;
            this.eLy = headSdk.sdk_name;
            this.eLz = headSdk.sdk_params;
            this.eLA = headSdk.head_type.intValue();
        }
    }
}
