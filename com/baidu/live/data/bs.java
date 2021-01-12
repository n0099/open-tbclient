package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bs extends BaseData {
    public int aNj;
    public int aNk;
    public int aNl;
    public int aNm;
    public int aNn;
    public int aNo;
    public int aNp;
    public int aNq;
    public int aNr;
    public int aNs;
    public int aNt;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNj = jSONObject.optInt("switch");
            this.aNk = jSONObject.optInt("show_scene_zan");
            this.aNl = jSONObject.optInt("show_scene_sendtext");
            this.aNm = jSONObject.optInt("show_scene_sendfreegift");
            this.aNn = jSONObject.optInt("show_scene_follow");
            this.aNo = jSONObject.optInt("show_scene_placeorder");
            this.aNp = jSONObject.optInt("show_scene_barrage");
            this.aNq = jSONObject.optInt("show_scene_guardclub");
            this.aNr = jSONObject.optInt("show_scene_redpacket");
            this.aNs = jSONObject.optInt("condition");
            this.aNt = jSONObject.optInt("show_every_days");
        }
    }
}
