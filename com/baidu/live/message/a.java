package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private String bvS;
    private int bvT;
    private int bvU;

    public a(String str, int i, int i2) {
        super(1021154);
        this.bvS = "";
        this.bvT = 1;
        this.bvU = 1;
        this.bvS = str;
        this.bvT = i;
        this.bvU = i2;
        setParams();
    }

    public int QK() {
        return this.bvT;
    }

    private void setParams() {
        addParam("anchor_id", this.bvS);
        addParam("open_status", this.bvT);
        addParam("check_status", this.bvU);
    }
}
