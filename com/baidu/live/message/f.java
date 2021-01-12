package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes10.dex */
public class f extends HttpMessage {
    private double aUq;
    private double aUr;
    private String bae;
    private String brr;
    private String brs;

    public f(String str, String str2, String str3, String str4, String str5) {
        super(1021120);
        this.bae = str;
        this.brr = str4;
        this.brs = str5;
        addParam("scene_from", this.bae);
        addParam("live_id", str2);
        addParam("anchor_uk", EncryptionHelper.getEncryptionUserId(str3));
    }

    public String Go() {
        return this.brs;
    }

    public void b(double d, double d2) {
        this.aUq = d;
        this.aUr = d2;
        addParam("lng", this.aUq);
        addParam("lat", this.aUr);
    }
}
