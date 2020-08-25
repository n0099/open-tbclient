package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private String ber;
    private int bes;
    private int beu;

    public a(String str, int i, int i2) {
        super(1021154);
        this.ber = "";
        this.bes = 1;
        this.beu = 1;
        this.ber = str;
        this.bes = i;
        this.beu = i2;
        setParams();
    }

    public int LB() {
        return this.bes;
    }

    private void setParams() {
        addParam("anchor_id", this.ber);
        addParam("open_status", this.bes);
        addParam("check_status", this.beu);
    }
}
