package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    private long anchorId;
    private boolean bkw;
    private int bkx;

    public b() {
        super(1021137);
        this.bkx = 2;
        this.bkw = false;
    }

    public boolean IS() {
        return this.bkw;
    }

    public void IT() {
        this.bkw = true;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setParams() {
        addParam("scene_from", q.Fy());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bkx);
    }
}
