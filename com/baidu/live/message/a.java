package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class a extends HttpMessage {
    private String arr;
    private int ars;
    private int art;

    public a(String str, int i, int i2) {
        super(1021154);
        this.arr = "";
        this.ars = 1;
        this.art = 1;
        this.arr = str;
        this.ars = i;
        this.art = i2;
        setParams();
    }

    public int we() {
        return this.ars;
    }

    private void setParams() {
        addParam("anchor_id", this.arr);
        addParam("open_status", this.ars);
        addParam("check_status", this.art);
    }
}
