package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private String bre;
    private int brf;
    private int brg;

    public a(String str, int i, int i2) {
        super(1021154);
        this.bre = "";
        this.brf = 1;
        this.brg = 1;
        this.bre = str;
        this.brf = i;
        this.brg = i2;
        setParams();
    }

    public int MP() {
        return this.brf;
    }

    private void setParams() {
        addParam("anchor_id", this.bre);
        addParam("open_status", this.brf);
        addParam("check_status", this.brg);
    }
}
