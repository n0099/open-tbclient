package com.baidu.tbadk.core.data;

import tbclient.DeclareInfo;
/* loaded from: classes.dex */
public class q {
    public int UM;
    public String UN;
    public String UO;
    public long UQ;
    public boolean UR;
    public int US;

    public void a(DeclareInfo declareInfo) {
        if (declareInfo != null) {
            this.UM = declareInfo.declare_id.intValue();
            this.UN = declareInfo.declare_url;
            this.UO = declareInfo.declare_text;
            this.UR = declareInfo.is_declare.intValue() == 1;
            this.UQ = declareInfo.declare_num.longValue();
            this.UR = this.UQ > 0 ? this.UR : false;
        }
    }
}
