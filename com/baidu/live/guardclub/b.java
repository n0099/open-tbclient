package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    private long anchorId;
    private boolean bfN;
    private int bfO;

    public b() {
        super(1021137);
        this.bfO = 2;
        this.bfN = false;
    }

    public boolean Hz() {
        return this.bfN;
    }

    public void HA() {
        this.bfN = true;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setParams() {
        addParam("scene_from", q.Ef());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bfO);
    }
}
