package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadSdk;
/* loaded from: classes.dex */
public class t {
    private String NY;
    private String NZ;
    private String Oa;
    private String Ob;
    private int Oc;

    public void a(HeadSdk headSdk) {
        if (headSdk != null) {
            this.NY = headSdk.head_pic;
            this.NZ = headSdk.head_text;
            this.Oa = headSdk.sdk_name;
            this.Ob = headSdk.sdk_params;
            this.Oc = headSdk.head_type.intValue();
        }
    }

    public String oF() {
        return this.NY;
    }

    public String oG() {
        return this.NZ;
    }

    public String oH() {
        return this.Ob;
    }

    public int oI() {
        return this.Oc;
    }
}
