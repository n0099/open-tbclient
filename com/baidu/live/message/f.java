package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes10.dex */
public class f extends HttpMessage {
    private double aYV;
    private double aYW;
    private String beN;
    private String bwu;
    private String bwv;

    public f(String str, String str2, String str3, String str4, String str5) {
        super(1021120);
        this.beN = str;
        this.bwu = str4;
        this.bwv = str5;
        addParam("scene_from", this.beN);
        addParam("live_id", str2);
        addParam("anchor_uk", EncryptionHelper.getEncryptionUserId(str3));
    }

    public String HH() {
        return this.bwv;
    }

    public void b(double d, double d2) {
        this.aYV = d;
        this.aYW = d2;
        addParam("lng", this.aYV);
        addParam("lat", this.aYW);
    }
}
