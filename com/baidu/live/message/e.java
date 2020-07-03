package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class e extends HttpMessage {
    private String aMw;
    private String aZl;
    private String aZm;

    public e(String str, String str2, String str3) {
        super(1021120);
        this.aMw = str;
        this.aZl = str2;
        this.aZm = str3;
        addParam("scene_from", this.aMw);
    }

    public String AV() {
        return this.aZm;
    }
}
