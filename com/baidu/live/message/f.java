package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class f extends HttpMessage {
    private String bac;
    private String bmG;
    private String bmH;

    public f(String str, String str2, String str3, String str4, String str5) {
        super(1021120);
        this.bac = str;
        this.bmG = str4;
        this.bmH = str5;
        addParam("scene_from", this.bac);
        addParam("live_id", str2);
        addParam("anchor_uk", EncryptionHelper.getEncryptionUserId(str3));
    }

    public String IQ() {
        return this.bmH;
    }
}
