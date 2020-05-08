package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private boolean aIV;
    private int aIW;
    private long aps;

    public b() {
        super(1021137);
        this.aIW = 2;
        this.aIV = false;
    }

    public boolean An() {
        return this.aIV;
    }

    public void Ao() {
        this.aIV = true;
    }

    public void ab(long j) {
        this.aps = j;
    }

    public void setParams() {
        addParam("scene_from", q.xf());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aps + ""));
        addParam("client_type", this.aIW);
    }
}
