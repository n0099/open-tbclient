package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private boolean aIP;
    private int aIQ;
    private long apl;

    public b() {
        super(1021137);
        this.aIQ = 2;
        this.aIP = false;
    }

    public boolean Ao() {
        return this.aIP;
    }

    public void Ap() {
        this.aIP = true;
    }

    public void ab(long j) {
        this.apl = j;
    }

    public void setParams() {
        addParam("scene_from", q.xg());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.apl + ""));
        addParam("client_type", this.aIQ);
    }
}
