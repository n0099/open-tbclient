package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int UC;
    public String UD;
    public String UE;
    public long UF;
    public boolean UG;
    public int UH;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.UC = declareInfo.declare_id.intValue();
            this.UD = declareInfo.declare_url;
            this.UE = declareInfo.declare_text;
            this.UG = declareInfo.is_declare.intValue() == 1;
            this.UF = declareInfo.declare_num.longValue();
            this.UG = this.UF > 0 ? this.UG : false;
        }
    }
}
