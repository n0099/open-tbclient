package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    private a bfP;
    private int bfZ;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void dk(int i) {
        this.bfZ = i;
    }

    public void a(a aVar) {
        this.bfP = aVar;
    }

    public a HB() {
        return this.bfP;
    }

    public void setParams() {
        addParam("scene_from", q.Ef());
        addParam("guard_club_id", this.bfZ);
        addParam("client_type", 2);
    }
}
