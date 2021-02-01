package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes11.dex */
public class f extends HttpMessage {
    private double aXv;
    private double aXw;
    private String bdl;
    private String buU;
    private String buV;

    public f(String str, String str2, String str3, String str4, String str5) {
        super(1021120);
        this.bdl = str;
        this.buU = str4;
        this.buV = str5;
        addParam("scene_from", this.bdl);
        addParam("live_id", str2);
        addParam("anchor_uk", EncryptionHelper.getEncryptionUserId(str3));
    }

    public String HE() {
        return this.buV;
    }

    public void b(double d, double d2) {
        this.aXv = d;
        this.aXw = d2;
        addParam("lng", this.aXv);
        addParam("lat", this.aXw);
    }
}
