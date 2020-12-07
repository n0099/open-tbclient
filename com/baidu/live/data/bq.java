package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bq extends BaseData {
    public int aRh;
    public int aRi;
    public int aRj;
    public int aRk;
    public int aRl;
    public int aRm;
    public int aRn;
    public int aRo;
    public int aRp;
    public int aRq;
    public int aRr;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRh = jSONObject.optInt("switch");
            this.aRi = jSONObject.optInt("show_scene_zan");
            this.aRj = jSONObject.optInt("show_scene_sendtext");
            this.aRk = jSONObject.optInt("show_scene_sendfreegift");
            this.aRl = jSONObject.optInt("show_scene_follow");
            this.aRm = jSONObject.optInt("show_scene_placeorder");
            this.aRn = jSONObject.optInt("show_scene_barrage");
            this.aRo = jSONObject.optInt("show_scene_guardclub");
            this.aRp = jSONObject.optInt("show_scene_redpacket");
            this.aRq = jSONObject.optInt("condition");
            this.aRr = jSONObject.optInt("show_every_days");
        }
    }
}
