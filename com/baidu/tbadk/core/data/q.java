package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int Vi;
    public String Vj;
    public String Vk;
    public long Vl;
    public boolean Vm;
    public int Vn;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.Vi = declareInfo.declare_id.intValue();
            this.Vj = declareInfo.declare_url;
            this.Vk = declareInfo.declare_text;
            this.Vm = declareInfo.is_declare.intValue() == 1;
            this.Vl = declareInfo.declare_num.longValue();
            this.Vm = this.Vl > 0 ? this.Vm : false;
        }
    }
}
