package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int Wd;
    public String We;
    public String Wf;
    public long Wg;
    public boolean Wh;
    public int mDefaultImageId;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.Wd = declareInfo.declare_id.intValue();
            this.We = declareInfo.declare_url;
            this.Wf = declareInfo.declare_text;
            this.Wh = declareInfo.is_declare.intValue() == 1;
            this.Wg = declareInfo.declare_num.longValue();
            this.Wh = this.Wg > 0 ? this.Wh : false;
        }
    }
}
