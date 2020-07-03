package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String aZa;
    private int aZb;
    private int aZc;

    public a(String str, int i, int i2) {
        super(1021154);
        this.aZa = "";
        this.aZb = 1;
        this.aZc = 1;
        this.aZa = str;
        this.aZb = i;
        this.aZc = i2;
        setParams();
    }

    public int FT() {
        return this.aZb;
    }

    private void setParams() {
        addParam("anchor_id", this.aZa);
        addParam("open_status", this.aZb);
        addParam("check_status", this.aZc);
    }
}
