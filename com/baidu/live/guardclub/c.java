package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private a apY;
    private int aqg;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void bQ(int i) {
        this.aqg = i;
    }

    public void a(a aVar) {
        this.apY = aVar;
    }

    public a vF() {
        return this.apY;
    }

    public void setParams() {
        addParam("scene_from", q.sI());
        addParam("guard_club_id", this.aqg);
        addParam("client_type", 2);
    }
}
