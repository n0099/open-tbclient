package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bs extends BaseData {
    public int aRW;
    public int aRX;
    public int aRY;
    public int aRZ;
    public int aSa;
    public int aSb;
    public int aSc;
    public int aSd;
    public int aSe;
    public int aSf;
    public int aSg;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRW = jSONObject.optInt("switch");
            this.aRX = jSONObject.optInt("show_scene_zan");
            this.aRY = jSONObject.optInt("show_scene_sendtext");
            this.aRZ = jSONObject.optInt("show_scene_sendfreegift");
            this.aSa = jSONObject.optInt("show_scene_follow");
            this.aSb = jSONObject.optInt("show_scene_placeorder");
            this.aSc = jSONObject.optInt("show_scene_barrage");
            this.aSd = jSONObject.optInt("show_scene_guardclub");
            this.aSe = jSONObject.optInt("show_scene_redpacket");
            this.aSf = jSONObject.optInt("condition");
            this.aSg = jSONObject.optInt("show_every_days");
        }
    }
}
