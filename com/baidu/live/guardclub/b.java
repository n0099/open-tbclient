package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private boolean aOE;
    private int aOF;
    private long aul;

    public b() {
        super(1021137);
        this.aOF = 2;
        this.aOE = false;
    }

    public boolean BD() {
        return this.aOE;
    }

    public void BE() {
        this.aOE = true;
    }

    public void af(long j) {
        this.aul = j;
    }

    public void setParams() {
        addParam("scene_from", q.yu());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aul + ""));
        addParam("client_type", this.aOF);
    }
}
