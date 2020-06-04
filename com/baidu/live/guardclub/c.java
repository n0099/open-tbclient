package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private a aOG;
    private int aOO;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void co(int i) {
        this.aOO = i;
    }

    public void a(a aVar) {
        this.aOG = aVar;
    }

    public a BF() {
        return this.aOG;
    }

    public void setParams() {
        addParam("scene_from", q.yu());
        addParam("guard_club_id", this.aOO);
        addParam("client_type", 2);
    }
}
