package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    private a biY;
    private int bji;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void dp(int i) {
        this.bji = i;
    }

    public void a(a aVar) {
        this.biY = aVar;
    }

    public a IR() {
        return this.biY;
    }

    public void setParams() {
        addParam("scene_from", q.Fv());
        addParam("guard_club_id", this.bji);
        addParam("client_type", 2);
    }
}
