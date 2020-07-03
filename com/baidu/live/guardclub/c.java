package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private a aRm;
    private int aRu;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void cu(int i) {
        this.aRu = i;
    }

    public void a(a aVar) {
        this.aRm = aVar;
    }

    public a Cf() {
        return this.aRm;
    }

    public void setParams() {
        addParam("scene_from", p.yU());
        addParam("guard_club_id", this.aRu);
        addParam("client_type", 2);
    }
}
