package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String bmv;
    private int bmw;
    private int bmx;

    public a(String str, int i, int i2) {
        super(1021154);
        this.bmv = "";
        this.bmw = 1;
        this.bmx = 1;
        this.bmv = str;
        this.bmw = i;
        this.bmx = i2;
        setParams();
    }

    public int NC() {
        return this.bmw;
    }

    private void setParams() {
        addParam("anchor_id", this.bmv);
        addParam("open_status", this.bmw);
        addParam("check_status", this.bmx);
    }
}
