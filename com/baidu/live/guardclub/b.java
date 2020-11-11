package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long anchorId;
    private boolean bgx;
    private int bgy;

    public b() {
        super(1021137);
        this.bgy = 2;
        this.bgx = false;
    }

    public boolean KB() {
        return this.bgx;
    }

    public void KC() {
        this.bgx = true;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setParams() {
        addParam("scene_from", p.Hr());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.bgy);
    }
}
