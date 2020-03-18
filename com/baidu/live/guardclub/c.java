package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private a aqi;
    private int aqq;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void bQ(int i) {
        this.aqq = i;
    }

    public void a(a aVar) {
        this.aqi = aVar;
    }

    public a vK() {
        return this.aqi;
    }

    public void setParams() {
        addParam("scene_from", q.sN());
        addParam("guard_club_id", this.aqq);
        addParam("client_type", 2);
    }
}
