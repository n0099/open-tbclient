package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long anchorId;
    private boolean bdL;
    private int bdM;

    public b() {
        super(1021137);
        this.bdM = 2;
        this.bdL = false;
    }

    public boolean JI() {
        return this.bdL;
    }

    public void JJ() {
        this.bdL = true;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setParams() {
        addParam("scene_from", p.Gv());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bdM);
    }
}
