package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bl extends BaseData {
    public int aLl;
    public int aLm;
    public int aLn;
    public int aLo;
    public int aLp;
    public int aLq;
    public int aLr;
    public int aLs;
    public int aLt;
    public int aLu;
    public int aLv;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLl = jSONObject.optInt("switch");
            this.aLm = jSONObject.optInt("show_scene_zan");
            this.aLn = jSONObject.optInt("show_scene_sendtext");
            this.aLo = jSONObject.optInt("show_scene_sendfreegift");
            this.aLp = jSONObject.optInt("show_scene_follow");
            this.aLq = jSONObject.optInt("show_scene_placeorder");
            this.aLr = jSONObject.optInt("show_scene_barrage");
            this.aLs = jSONObject.optInt("show_scene_guardclub");
            this.aLt = jSONObject.optInt("show_scene_redpacket");
            this.aLu = jSONObject.optInt("condition");
            this.aLv = jSONObject.optInt("show_every_days");
        }
    }
}
