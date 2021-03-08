package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bx extends BaseData {
    public int aRK;
    public int aRL;
    public int aRM;
    public int aRN;
    public int aRO;
    public int aRP;
    public int aRQ;
    public int aRR;
    public int aRS;
    public int aRT;
    public int aRU;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRK = jSONObject.optInt("switch");
            this.aRL = jSONObject.optInt("show_scene_zan");
            this.aRM = jSONObject.optInt("show_scene_sendtext");
            this.aRN = jSONObject.optInt("show_scene_sendfreegift");
            this.aRO = jSONObject.optInt("show_scene_follow");
            this.aRP = jSONObject.optInt("show_scene_placeorder");
            this.aRQ = jSONObject.optInt("show_scene_barrage");
            this.aRR = jSONObject.optInt("show_scene_guardclub");
            this.aRS = jSONObject.optInt("show_scene_redpacket");
            this.aRT = jSONObject.optInt("condition");
            this.aRU = jSONObject.optInt("show_every_days");
        }
    }
}
