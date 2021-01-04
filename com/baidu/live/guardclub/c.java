package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    private a bkF;
    private int bkP;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void eQ(int i) {
        this.bkP = i;
    }

    public void a(a aVar) {
        this.bkF = aVar;
    }

    public a Lw() {
        return this.bkF;
    }

    public void setParams() {
        addParam("scene_from", q.Ia());
        addParam("guard_club_id", this.bkP);
        addParam("client_type", 2);
    }
}
