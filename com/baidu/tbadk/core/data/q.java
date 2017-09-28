package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int Vu;
    public String Vv;
    public String Vw;
    public long Vx;
    public boolean Vy;
    public int Vz;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.Vu = declareInfo.declare_id.intValue();
            this.Vv = declareInfo.declare_url;
            this.Vw = declareInfo.declare_text;
            this.Vy = declareInfo.is_declare.intValue() == 1;
            this.Vx = declareInfo.declare_num.longValue();
            this.Vy = this.Vx > 0 ? this.Vy : false;
        }
    }
}
