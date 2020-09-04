package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class e extends HttpMessage {
    private String aTg;
    private String beF;
    private String beG;

    public e(String str, String str2, String str3) {
        super(1021120);
        this.aTg = str;
        this.beF = str2;
        this.beG = str3;
        addParam("scene_from", this.aTg);
    }

    public String Ha() {
        return this.beG;
    }
}
