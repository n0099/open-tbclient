package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private boolean aSD;
    private int aSE;
    private long axs;

    public b() {
        super(1021137);
        this.aSE = 2;
        this.aSD = false;
    }

    public boolean CF() {
        return this.aSD;
    }

    public void CG() {
        this.aSD = true;
    }

    public void af(long j) {
        this.axs = j;
    }

    public void setParams() {
        addParam("scene_from", p.zw());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.axs + ""));
        addParam("client_type", this.aSE);
    }
}
