package com.baidu.live.guardclub;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.utils.p;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private boolean aRk;
    private int aRl;
    private long awn;

    public b() {
        super(1021137);
        this.aRl = 2;
        this.aRk = false;
    }

    public boolean Cd() {
        return this.aRk;
    }

    public void Ce() {
        this.aRk = true;
    }

    public void af(long j) {
        this.awn = j;
    }

    public void setParams() {
        addParam("scene_from", p.yU());
        addParam("anchor_id", EncryptionHelper.getEncryptionUserId(this.awn + ""));
        addParam("client_type", this.aRl);
    }
}
