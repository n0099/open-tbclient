package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int Um;
    public String Un;
    public String Uo;
    public long Up;
    public boolean Uq;
    public int Ur;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.Um = declareInfo.declare_id.intValue();
            this.Un = declareInfo.declare_url;
            this.Uo = declareInfo.declare_text;
            this.Uq = declareInfo.is_declare.intValue() == 1;
            this.Up = declareInfo.declare_num.longValue();
            this.Uq = this.Up > 0 ? this.Uq : false;
        }
    }
}
