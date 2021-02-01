package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    private long anchorId;
    private boolean biW;
    private int biX;

    public b() {
        super(1021137);
        this.biX = 2;
        this.biW = false;
    }

    public boolean IP() {
        return this.biW;
    }

    public void IQ() {
        this.biW = true;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setParams() {
        addParam("scene_from", q.Fv());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.biX);
    }
}
