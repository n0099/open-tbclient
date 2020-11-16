package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class af {
    private String ezs;
    private String ezt;
    private String ezu;
    private String ezv;
    private int ezw;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.ezs = headSdk.head_pic;
            this.ezt = headSdk.head_text;
            this.ezu = headSdk.sdk_name;
            this.ezv = headSdk.sdk_params;
            this.ezw = headSdk.head_type.intValue();
        }
    }
}
