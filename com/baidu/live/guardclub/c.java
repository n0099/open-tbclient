package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private int baB;
    private a bat;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void eu(int i) {
        this.baB = i;
    }

    public void a(a aVar) {
        this.bat = aVar;
    }

    public a IN() {
        return this.bat;
    }

    public void setParams() {
        addParam("scene_from", p.Fz());
        addParam("guard_club_id", this.baB);
        addParam("client_type", 2);
    }
}
