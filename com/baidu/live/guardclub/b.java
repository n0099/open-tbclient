package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes7.dex */
public class b extends HttpMessage {
    private long aCu;
    private boolean aXR;
    private int aXS;

    public b() {
        super(1021137);
        this.aXS = 2;
        this.aXR = false;
    }

    public boolean Ii() {
        return this.aXR;
    }

    public void Ij() {
        this.aXR = true;
    }

    public void ag(long j) {
        this.aCu = j;
    }

    public void setParams() {
        addParam("scene_from", p.EZ());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aCu + ""));
        addParam("client_type", this.aXS);
    }
}
