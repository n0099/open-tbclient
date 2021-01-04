package com.baidu.live.yuyingift.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private String loc;

    public a(String str) {
        super(1031065);
        this.loc = str;
    }

    public String getLoc() {
        return this.loc;
    }
}
