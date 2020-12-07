package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private a bja;
    private int bjk;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void eS(int i) {
        this.bjk = i;
    }

    public void a(a aVar) {
        this.bja = aVar;
    }

    public a LX() {
        return this.bja;
    }

    public void setParams() {
        addParam("scene_from", p.Iz());
        addParam("guard_club_id", this.bjk);
        addParam("client_type", 2);
    }
}
