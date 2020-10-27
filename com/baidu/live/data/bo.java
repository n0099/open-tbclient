package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bo extends BaseData {
    public int aOV;
    public int aOW;
    public int aOX;
    public int aOY;
    public int aOZ;
    public int aPa;
    public int aPb;
    public int aPc;
    public int aPd;
    public int aPe;
    public int aPf;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOV = jSONObject.optInt("switch");
            this.aOW = jSONObject.optInt("show_scene_zan");
            this.aOX = jSONObject.optInt("show_scene_sendtext");
            this.aOY = jSONObject.optInt("show_scene_sendfreegift");
            this.aOZ = jSONObject.optInt("show_scene_follow");
            this.aPa = jSONObject.optInt("show_scene_placeorder");
            this.aPb = jSONObject.optInt("show_scene_barrage");
            this.aPc = jSONObject.optInt("show_scene_guardclub");
            this.aPd = jSONObject.optInt("show_scene_redpacket");
            this.aPe = jSONObject.optInt("condition");
            this.aPf = jSONObject.optInt("show_every_days");
        }
    }
}
