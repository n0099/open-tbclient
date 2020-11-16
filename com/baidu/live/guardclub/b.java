package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long anchorId;
    private boolean beJ;
    private int beK;

    public b() {
        super(1021137);
        this.beK = 2;
        this.beJ = false;
    }

    public boolean JS() {
        return this.beJ;
    }

    public void JT() {
        this.beJ = true;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setParams() {
        addParam("scene_from", p.GI());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.beK);
    }
}
