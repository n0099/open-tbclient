package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long anchorId;
    private boolean bfc;
    private int bfd;

    public b() {
        super(1021137);
        this.bfd = 2;
        this.bfc = false;
    }

    public boolean Kb() {
        return this.bfc;
    }

    public void Kc() {
        this.bfc = true;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setParams() {
        addParam("scene_from", p.GQ());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bfd);
    }
}
