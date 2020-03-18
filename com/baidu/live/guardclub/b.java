package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private long Xj;
    private boolean aqg;
    private int aqh;

    public b() {
        super(1021137);
        this.aqh = 2;
        this.aqg = false;
    }

    public boolean vI() {
        return this.aqg;
    }

    public void vJ() {
        this.aqg = true;
    }

    public void D(long j) {
        this.Xj = j;
    }

    public void setParams() {
        addParam("scene_from", q.sN());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.Xj + ""));
        addParam("client_type", this.aqh);
    }
}
