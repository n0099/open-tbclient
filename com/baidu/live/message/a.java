package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String awn;
    private int awo;
    private int awp;

    public a(String str, int i, int i2) {
        super(1021154);
        this.awn = "";
        this.awo = 1;
        this.awp = 1;
        this.awn = str;
        this.awo = i;
        this.awp = i2;
        setParams();
    }

    public int yM() {
        return this.awo;
    }

    private void setParams() {
        addParam("anchor_id", this.awn);
        addParam("open_status", this.awo);
        addParam("check_status", this.awp);
    }
}
