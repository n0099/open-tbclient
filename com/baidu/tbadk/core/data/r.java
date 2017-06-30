package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class r {
    public int Ul;
    public String Um;
    public String Un;
    public long Uo;
    public boolean Up;
    public int Uq;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.Ul = declareInfo.declare_id.intValue();
            this.Um = declareInfo.declare_url;
            this.Un = declareInfo.declare_text;
            this.Up = declareInfo.is_declare.intValue() == 1;
            this.Uo = declareInfo.declare_num.longValue();
            this.Up = this.Uo > 0 ? this.Up : false;
        }
    }
}
