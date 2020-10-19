package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bl extends BaseData {
    public int aOA;
    public int aOq;
    public int aOr;
    public int aOs;
    public int aOt;
    public int aOu;
    public int aOv;
    public int aOw;
    public int aOx;
    public int aOy;
    public int aOz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOq = jSONObject.optInt("switch");
            this.aOr = jSONObject.optInt("show_scene_zan");
            this.aOs = jSONObject.optInt("show_scene_sendtext");
            this.aOt = jSONObject.optInt("show_scene_sendfreegift");
            this.aOu = jSONObject.optInt("show_scene_follow");
            this.aOv = jSONObject.optInt("show_scene_placeorder");
            this.aOw = jSONObject.optInt("show_scene_barrage");
            this.aOx = jSONObject.optInt("show_scene_guardclub");
            this.aOy = jSONObject.optInt("show_scene_redpacket");
            this.aOz = jSONObject.optInt("condition");
            this.aOA = jSONObject.optInt("show_every_days");
        }
    }
}
