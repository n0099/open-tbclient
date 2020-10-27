package com.baidu.live.entereffect.http;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String id;
    private boolean isHost;

    public a(boolean z, String str) {
        super(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.isHost = z;
        this.id = str;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public String getId() {
        return this.id;
    }
}
