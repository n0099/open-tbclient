package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    private int bkI;
    private a bky;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void dq(int i) {
        this.bkI = i;
    }

    public void a(a aVar) {
        this.bky = aVar;
    }

    public a IU() {
        return this.bky;
    }

    public void setParams() {
        addParam("scene_from", q.Fy());
        addParam("guard_club_id", this.bkI);
        addParam("client_type", 2);
    }
}
