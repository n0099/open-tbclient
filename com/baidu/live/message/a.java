package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String aYY;
    private int aYZ;
    private int aZa;

    public a(String str, int i, int i2) {
        super(1021154);
        this.aYY = "";
        this.aYZ = 1;
        this.aZa = 1;
        this.aYY = str;
        this.aYZ = i;
        this.aZa = i2;
        setParams();
    }

    public int FN() {
        return this.aYZ;
    }

    private void setParams() {
        addParam("anchor_id", this.aYY);
        addParam("open_status", this.aYZ);
        addParam("check_status", this.aZa);
    }
}
