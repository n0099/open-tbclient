package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String bla;
    private int blb;
    private int blc;

    public a(String str, int i, int i2) {
        super(1021154);
        this.bla = "";
        this.blb = 1;
        this.blc = 1;
        this.bla = str;
        this.blb = i;
        this.blc = i2;
        setParams();
    }

    public int Ni() {
        return this.blb;
    }

    private void setParams() {
        addParam("anchor_id", this.bla);
        addParam("open_status", this.blb);
        addParam("check_status", this.blc);
    }
}
