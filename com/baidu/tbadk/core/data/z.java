package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class z {
    private String cPj;
    private String cPk;
    private String cPl;
    private String cPm;
    private int cPn;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.cPj = headSdk.head_pic;
            this.cPk = headSdk.head_text;
            this.cPl = headSdk.sdk_name;
            this.cPm = headSdk.sdk_params;
            this.cPn = headSdk.head_type.intValue();
        }
    }
}
