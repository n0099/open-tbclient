package com.baidu.live.entereffect.http;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private boolean isHost;

    public a(boolean z) {
        super(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.isHost = z;
    }

    public boolean isHost() {
        return this.isHost;
    }
}
