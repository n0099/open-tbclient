package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String aWr;
    private int aWs;
    private int aWt;

    public a(String str, int i, int i2) {
        super(1021154);
        this.aWr = "";
        this.aWs = 1;
        this.aWt = 1;
        this.aWr = str;
        this.aWs = i;
        this.aWt = i2;
        setParams();
    }

    public int Fj() {
        return this.aWs;
    }

    private void setParams() {
        addParam("anchor_id", this.aWr);
        addParam("open_status", this.aWs);
        addParam("check_status", this.aWt);
    }
}
