package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private a aIX;
    private int aJf;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void cf(int i) {
        this.aJf = i;
    }

    public void a(a aVar) {
        this.aIX = aVar;
    }

    public a Ap() {
        return this.aIX;
    }

    public void setParams() {
        addParam("scene_from", q.xf());
        addParam("guard_club_id", this.aJf);
        addParam("client_type", 2);
    }
}
