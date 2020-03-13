package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String awp;
    private int awq;
    private int awr;

    public a(String str, int i, int i2) {
        super(1021154);
        this.awp = "";
        this.awq = 1;
        this.awr = 1;
        this.awp = str;
        this.awq = i;
        this.awr = i2;
        setParams();
    }

    public int yN() {
        return this.awq;
    }

    private void setParams() {
        addParam("anchor_id", this.awp);
        addParam("open_status", this.awq);
        addParam("check_status", this.awr);
    }
}
