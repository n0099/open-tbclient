package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class e extends HttpMessage {
    private String aJQ;
    private String aWC;
    private String aWD;

    public e(String str, String str2, String str3) {
        super(1021120);
        this.aJQ = str;
        this.aWC = str2;
        this.aWD = str3;
        addParam("scene_from", this.aJQ);
    }

    public String Av() {
        return this.aWD;
    }
}
