package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private int awA;
    private int awB;
    private String awz;

    public a(String str, int i, int i2) {
        super(1021154);
        this.awz = "";
        this.awA = 1;
        this.awB = 1;
        this.awz = str;
        this.awA = i;
        this.awB = i2;
        setParams();
    }

    public int yS() {
        return this.awA;
    }

    private void setParams() {
        addParam("anchor_id", this.awz);
        addParam("open_status", this.awA);
        addParam("check_status", this.awB);
    }
}
