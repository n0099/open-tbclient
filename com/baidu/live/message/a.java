package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String bnP;
    private int bnQ;
    private int bnR;

    public a(String str, int i, int i2) {
        super(1021154);
        this.bnP = "";
        this.bnQ = 1;
        this.bnR = 1;
        this.bnP = str;
        this.bnQ = i;
        this.bnR = i2;
        setParams();
    }

    public int Oc() {
        return this.bnQ;
    }

    private void setParams() {
        addParam("anchor_id", this.bnP);
        addParam("open_status", this.bnQ);
        addParam("check_status", this.bnR);
    }
}
