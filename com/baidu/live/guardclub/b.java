package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    private long anchorId;
    private boolean bkD;
    private int bkE;

    public b() {
        super(1021137);
        this.bkE = 2;
        this.bkD = false;
    }

    public boolean Lu() {
        return this.bkD;
    }

    public void Lv() {
        this.bkD = true;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setParams() {
        addParam("scene_from", q.Ia());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bkE);
    }
}
