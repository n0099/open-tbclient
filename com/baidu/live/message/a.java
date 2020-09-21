package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String bhk;
    private int bhl;
    private int bhm;

    public a(String str, int i, int i2) {
        super(1021154);
        this.bhk = "";
        this.bhl = 1;
        this.bhm = 1;
        this.bhk = str;
        this.bhl = i;
        this.bhm = i2;
        setParams();
    }

    public int Md() {
        return this.bhl;
    }

    private void setParams() {
        addParam("anchor_id", this.bhk);
        addParam("open_status", this.bhl);
        addParam("check_status", this.bhm);
    }
}
