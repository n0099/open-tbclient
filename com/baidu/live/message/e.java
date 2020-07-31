package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class e extends HttpMessage {
    private String aNR;
    private String aZj;
    private String aZk;

    public e(String str, String str2, String str3) {
        super(1021120);
        this.aNR = str;
        this.aZj = str2;
        this.aZk = str3;
        addParam("scene_from", this.aNR);
    }

    public String Bx() {
        return this.aZk;
    }
}
