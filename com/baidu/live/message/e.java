package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class e extends HttpMessage {
    private String aTe;
    private String beD;
    private String beE;

    public e(String str, String str2, String str3) {
        super(1021120);
        this.aTe = str;
        this.beD = str2;
        this.beE = str3;
        addParam("scene_from", this.aTe);
    }

    public String Ha() {
        return this.beE;
    }
}
