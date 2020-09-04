package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private String beu;
    private int bev;
    private int bew;

    public a(String str, int i, int i2) {
        super(1021154);
        this.beu = "";
        this.bev = 1;
        this.bew = 1;
        this.beu = str;
        this.bev = i;
        this.bew = i2;
        setParams();
    }

    public int LB() {
        return this.bev;
    }

    private void setParams() {
        addParam("anchor_id", this.beu);
        addParam("open_status", this.bev);
        addParam("check_status", this.bew);
    }
}
