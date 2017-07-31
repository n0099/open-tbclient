package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int Wa;
    public String Wb;
    public String Wc;
    public long Wd;
    public boolean We;
    public int mDefaultImageId;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.Wa = declareInfo.declare_id.intValue();
            this.Wb = declareInfo.declare_url;
            this.Wc = declareInfo.declare_text;
            this.We = declareInfo.is_declare.intValue() == 1;
            this.Wd = declareInfo.declare_num.longValue();
            this.We = this.Wd > 0 ? this.We : false;
        }
    }
}
