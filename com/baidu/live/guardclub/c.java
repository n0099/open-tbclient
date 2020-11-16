package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private a beL;
    private int beT;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void ew(int i) {
        this.beT = i;
    }

    public void a(a aVar) {
        this.beL = aVar;
    }

    public a JU() {
        return this.beL;
    }

    public void setParams() {
        addParam("scene_from", p.GI());
        addParam("guard_club_id", this.beT);
        addParam("client_type", 2);
    }
}
