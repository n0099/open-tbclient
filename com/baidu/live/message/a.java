package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private String buH;
    private int buI;
    private int buJ;

    public a(String str, int i, int i2) {
        super(1021154);
        this.buH = "";
        this.buI = 1;
        this.buJ = 1;
        this.buH = str;
        this.buI = i;
        this.buJ = i2;
        setParams();
    }

    public int On() {
        return this.buI;
    }

    private void setParams() {
        addParam("anchor_id", this.buH);
        addParam("open_status", this.buI);
        addParam("check_status", this.buJ);
    }
}
