package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bx extends BaseData {
    public int aQk;
    public int aQl;
    public int aQm;
    public int aQn;
    public int aQo;
    public int aQp;
    public int aQq;
    public int aQr;
    public int aQs;
    public int aQt;
    public int aQu;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQk = jSONObject.optInt("switch");
            this.aQl = jSONObject.optInt("show_scene_zan");
            this.aQm = jSONObject.optInt("show_scene_sendtext");
            this.aQn = jSONObject.optInt("show_scene_sendfreegift");
            this.aQo = jSONObject.optInt("show_scene_follow");
            this.aQp = jSONObject.optInt("show_scene_placeorder");
            this.aQq = jSONObject.optInt("show_scene_barrage");
            this.aQr = jSONObject.optInt("show_scene_guardclub");
            this.aQs = jSONObject.optInt("show_scene_redpacket");
            this.aQt = jSONObject.optInt("condition");
            this.aQu = jSONObject.optInt("show_every_days");
        }
    }
}
