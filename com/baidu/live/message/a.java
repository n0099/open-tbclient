package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String awo;
    private int awp;
    private int awq;

    public a(String str, int i, int i2) {
        super(1021154);
        this.awo = "";
        this.awp = 1;
        this.awq = 1;
        this.awo = str;
        this.awp = i;
        this.awq = i2;
        setParams();
    }

    public int yN() {
        return this.awp;
    }

    private void setParams() {
        addParam("anchor_id", this.awo);
        addParam("open_status", this.awp);
        addParam("check_status", this.awq);
    }
}
