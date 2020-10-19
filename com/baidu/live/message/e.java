package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
/* loaded from: classes4.dex */
public class e extends HttpMessage {
    private String aYF;
    private String bll;
    private String blm;

    public e(String str, String str2, String str3, String str4, String str5) {
        super(1021120);
        this.aYF = str;
        this.bll = str4;
        this.blm = str5;
        addParam("scene_from", this.aYF);
        addParam("live_id", str2);
        addParam("anchor_uk", EncryptionHelper.getEncryptionUserId(str3));
    }

    public String Ix() {
        return this.blm;
    }
}
