package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String aQc;
    private int aQd;
    private int aQe;

    public a(String str, int i, int i2) {
        super(1021154);
        this.aQc = "";
        this.aQd = 1;
        this.aQe = 1;
        this.aQc = str;
        this.aQd = i;
        this.aQe = i2;
        setParams();
    }

    public int DM() {
        return this.aQd;
    }

    private void setParams() {
        addParam("anchor_id", this.aQc);
        addParam("open_status", this.aQd);
        addParam("check_status", this.aQe);
    }
}
