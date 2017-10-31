package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int VA;
    public String VB;
    public String VC;
    public long VD;
    public boolean VE;
    public int VF;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.VA = declareInfo.declare_id.intValue();
            this.VB = declareInfo.declare_url;
            this.VC = declareInfo.declare_text;
            this.VE = declareInfo.is_declare.intValue() == 1;
            this.VD = declareInfo.declare_num.longValue();
            this.VE = this.VD > 0 ? this.VE : false;
        }
    }
}
