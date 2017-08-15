package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int Wc;
    public String Wd;
    public String We;
    public long Wf;
    public boolean Wg;
    public int mDefaultImageId;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.Wc = declareInfo.declare_id.intValue();
            this.Wd = declareInfo.declare_url;
            this.We = declareInfo.declare_text;
            this.Wg = declareInfo.is_declare.intValue() == 1;
            this.Wf = declareInfo.declare_num.longValue();
            this.Wg = this.Wf > 0 ? this.Wg : false;
        }
    }
}
