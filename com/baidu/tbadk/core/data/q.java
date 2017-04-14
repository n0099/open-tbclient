package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int Vg;
    public String Vh;
    public String Vi;
    public long Vj;
    public boolean Vk;
    public int Vl;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.Vg = declareInfo.declare_id.intValue();
            this.Vh = declareInfo.declare_url;
            this.Vi = declareInfo.declare_text;
            this.Vk = declareInfo.is_declare.intValue() == 1;
            this.Vj = declareInfo.declare_num.longValue();
            this.Vk = this.Vj > 0 ? this.Vk : false;
        }
    }
}
