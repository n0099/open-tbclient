package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private long WZ;
    private boolean apV;
    private int apW;

    public b() {
        super(1021137);
        this.apW = 2;
        this.apV = false;
    }

    public boolean vD() {
        return this.apV;
    }

    public void vE() {
        this.apV = true;
    }

    public void D(long j) {
        this.WZ = j;
    }

    public void setParams() {
        addParam("scene_from", q.sI());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.WZ + ""));
        addParam("client_type", this.apW);
    }
}
