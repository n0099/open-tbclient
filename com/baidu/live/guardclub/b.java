package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long anchorId;
    private boolean biY;
    private int biZ;

    public b() {
        super(1021137);
        this.biZ = 2;
        this.biY = false;
    }

    public boolean LV() {
        return this.biY;
    }

    public void LW() {
        this.biY = true;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setParams() {
        addParam("scene_from", p.Iz());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.anchorId + ""));
        addParam("client_type", this.biZ);
    }
}
