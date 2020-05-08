package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String aQi;
    private int aQj;
    private int aQk;

    public a(String str, int i, int i2) {
        super(1021154);
        this.aQi = "";
        this.aQj = 1;
        this.aQk = 1;
        this.aQi = str;
        this.aQj = i;
        this.aQk = i2;
        setParams();
    }

    public int DL() {
        return this.aQj;
    }

    private void setParams() {
        addParam("anchor_id", this.aQi);
        addParam("open_status", this.aQj);
        addParam("check_status", this.aQk);
    }
}
