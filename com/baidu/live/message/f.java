package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes11.dex */
public class f extends HttpMessage {
    private double aZd;
    private double aZe;
    private String beU;
    private String bwf;
    private String bwg;

    public f(String str, String str2, String str3, String str4, String str5) {
        super(1021120);
        this.beU = str;
        this.bwf = str4;
        this.bwg = str5;
        addParam("scene_from", this.beU);
        addParam("live_id", str2);
        addParam("anchor_uk", EncryptionHelper.getEncryptionUserId(str3));
    }

    public String Kj() {
        return this.bwg;
    }

    public void b(double d, double d2) {
        this.aZd = d;
        this.aZe = d2;
        addParam("lng", this.aZd);
        addParam("lat", this.aZe);
    }
}
