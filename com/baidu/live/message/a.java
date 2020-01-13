package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class a extends HttpMessage {
    private String asd;
    private int ase;
    private int asf;

    public a(String str, int i, int i2) {
        super(1021154);
        this.asd = "";
        this.ase = 1;
        this.asf = 1;
        this.asd = str;
        this.ase = i;
        this.asf = i2;
        setParams();
    }

    public int wv() {
        return this.ase;
    }

    private void setParams() {
        addParam("anchor_id", this.asd);
        addParam("open_status", this.ase);
        addParam("check_status", this.asf);
    }
}
