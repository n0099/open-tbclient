package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String brl;
    private int brm;
    private int brn;

    public a(String str, int i, int i2) {
        super(1021154);
        this.brl = "";
        this.brm = 1;
        this.brn = 1;
        this.brl = str;
        this.brm = i;
        this.brn = i2;
        setParams();
    }

    public int PM() {
        return this.brm;
    }

    private void setParams() {
        addParam("anchor_id", this.brl);
        addParam("open_status", this.brm);
        addParam("check_status", this.brn);
    }
}
