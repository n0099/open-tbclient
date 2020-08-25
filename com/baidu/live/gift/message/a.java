package com.baidu.live.gift.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private String loc;

    public a(String str) {
        super(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        this.loc = str;
    }

    public String getLoc() {
        return this.loc;
    }
}
