package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String bme;
    private int bmf;
    private int bmg;

    public a(String str, int i, int i2) {
        super(1021154);
        this.bme = "";
        this.bmf = 1;
        this.bmg = 1;
        this.bme = str;
        this.bmf = i;
        this.bmg = i2;
        setParams();
    }

    public int Nt() {
        return this.bmf;
    }

    private void setParams() {
        addParam("anchor_id", this.bme);
        addParam("open_status", this.bmf);
        addParam("check_status", this.bmg);
    }
}
