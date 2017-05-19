package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public String UB;
    public String UC;
    public long UD;
    public boolean UE;
    public int UF;
    public int Uz;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.Uz = declareInfo.declare_id.intValue();
            this.UB = declareInfo.declare_url;
            this.UC = declareInfo.declare_text;
            this.UE = declareInfo.is_declare.intValue() == 1;
            this.UD = declareInfo.declare_num.longValue();
            this.UE = this.UD > 0 ? this.UE : false;
        }
    }
}
