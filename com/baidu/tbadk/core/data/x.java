package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class x {
    private String agi;
    private String agj;
    private String agk;
    private String agl;
    private int agm;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.agi = headSdk.head_pic;
            this.agj = headSdk.head_text;
            this.agk = headSdk.sdk_name;
            this.agl = headSdk.sdk_params;
            this.agm = headSdk.head_type.intValue();
        }
    }
}
