package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private int bgH;
    private a bgz;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void eA(int i) {
        this.bgH = i;
    }

    public void a(a aVar) {
        this.bgz = aVar;
    }

    public a KD() {
        return this.bgz;
    }

    public void setParams() {
        addParam("scene_from", p.Hr());
        addParam("guard_club_id", this.bgH);
        addParam("client_type", 2);
    }
}
