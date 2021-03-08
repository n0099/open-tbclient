package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private String bwh;
    private int bwi;
    private int bwj;

    public a(String str, int i, int i2) {
        super(1021154);
        this.bwh = "";
        this.bwi = 1;
        this.bwj = 1;
        this.bwh = str;
        this.bwi = i;
        this.bwj = i2;
        setParams();
    }

    public int Oq() {
        return this.bwi;
    }

    private void setParams() {
        addParam("anchor_id", this.bwh);
        addParam("open_status", this.bwi);
        addParam("check_status", this.bwj);
    }
}
