package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class f extends HttpMessage {
    private double aXy;
    private double aXz;
    private String bdj;
    private String brx;
    private String bry;

    public f(String str, String str2, String str3, String str4, String str5) {
        super(1021120);
        this.bdj = str;
        this.brx = str4;
        this.bry = str5;
        addParam("scene_from", this.bdj);
        addParam("live_id", str2);
        addParam("anchor_uk", EncryptionHelper.getEncryptionUserId(str3));
    }

    public String KI() {
        return this.bry;
    }

    public void b(double d, double d2) {
        this.aXy = d;
        this.aXz = d2;
        addParam("lng", this.aXy);
        addParam("lat", this.aXz);
    }
}
