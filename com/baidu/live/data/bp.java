package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bp extends BaseData {
    public int aOh;
    public int aOi;
    public int aOj;
    public int aOk;
    public int aOl;
    public int aOm;
    public int aOn;
    public int aOo;
    public int aOp;
    public int aOq;
    public int aOr;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOh = jSONObject.optInt("switch");
            this.aOi = jSONObject.optInt("show_scene_zan");
            this.aOj = jSONObject.optInt("show_scene_sendtext");
            this.aOk = jSONObject.optInt("show_scene_sendfreegift");
            this.aOl = jSONObject.optInt("show_scene_follow");
            this.aOm = jSONObject.optInt("show_scene_placeorder");
            this.aOn = jSONObject.optInt("show_scene_barrage");
            this.aOo = jSONObject.optInt("show_scene_guardclub");
            this.aOp = jSONObject.optInt("show_scene_redpacket");
            this.aOq = jSONObject.optInt("condition");
            this.aOr = jSONObject.optInt("show_every_days");
        }
    }
}
