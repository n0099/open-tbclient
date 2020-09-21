package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long aDf;
    private boolean baq;
    private int bas;

    public b() {
        super(1021137);
        this.bas = 2;
        this.baq = false;
    }

    public boolean IL() {
        return this.baq;
    }

    public void IM() {
        this.baq = true;
    }

    public void af(long j) {
        this.aDf = j;
    }

    public void setParams() {
        addParam("scene_from", p.Fz());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.aDf + ""));
        addParam("client_type", this.bas);
    }
}
