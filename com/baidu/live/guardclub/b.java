package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes7.dex */
public class b extends HttpMessage {
    private long aCw;
    private boolean aXT;
    private int aXU;

    public b() {
        super(1021137);
        this.aXU = 2;
        this.aXT = false;
    }

    public boolean Ii() {
        return this.aXT;
    }

    public void Ij() {
        this.aXT = true;
    }

    public void ag(long j) {
        this.aCw = j;
    }

    public void setParams() {
        addParam("scene_from", p.EZ());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aCw + ""));
        addParam("client_type", this.aXU);
    }
}
