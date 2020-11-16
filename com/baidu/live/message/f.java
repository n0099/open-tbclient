package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class f extends HttpMessage {
    private String aZJ;
    private String bmp;
    private String bmq;

    public f(String str, String str2, String str3, String str4, String str5) {
        super(1021120);
        this.aZJ = str;
        this.bmp = str4;
        this.bmq = str5;
        addParam("scene_from", this.aZJ);
        addParam("live_id", str2);
        addParam("anchor_uk", EncryptionHelper.getEncryptionUserId(str3));
    }

    public String II() {
        return this.bmq;
    }
}
