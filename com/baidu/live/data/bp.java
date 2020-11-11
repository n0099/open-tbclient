package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bp extends BaseData {
    public int aPS;
    public int aPT;
    public int aPU;
    public int aPV;
    public int aPW;
    public int aPX;
    public int aPY;
    public int aPZ;
    public int aQa;
    public int aQb;
    public int aQc;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPS = jSONObject.optInt("switch");
            this.aPT = jSONObject.optInt("show_scene_zan");
            this.aPU = jSONObject.optInt("show_scene_sendtext");
            this.aPV = jSONObject.optInt("show_scene_sendfreegift");
            this.aPW = jSONObject.optInt("show_scene_follow");
            this.aPX = jSONObject.optInt("show_scene_placeorder");
            this.aPY = jSONObject.optInt("show_scene_barrage");
            this.aPZ = jSONObject.optInt("show_scene_guardclub");
            this.aQa = jSONObject.optInt("show_scene_redpacket");
            this.aQb = jSONObject.optInt("condition");
            this.aQc = jSONObject.optInt("show_every_days");
        }
    }
}
