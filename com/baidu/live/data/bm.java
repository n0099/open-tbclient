package com.baidu.live.data;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.p;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bm extends BaseData {
    public int aHx;
    public ArrayList<p> aMz = new ArrayList<>();
    public ae aMA = new ae();
    public z aMB = new z();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        p.a aVar;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.aHx = optJSONObject.optInt("interval");
                }
                if (this.aHx <= 0) {
                    this.aHx = 5;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("im_rate");
                if (optJSONObject2 == null) {
                    aVar = null;
                } else {
                    aVar = new p.a(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("live_activity_new");
                long optLong = jSONObject.optLong("time", 0L);
                if (optJSONObject3 != null) {
                    JSONArray optJSONArray = optJSONObject3.optJSONArray("activity_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                            if (optJSONObject4 != null) {
                                p pVar = new p();
                                pVar.a(aVar);
                                pVar.parseJson(optJSONObject4);
                                pVar.serverTime = optLong;
                                this.aMz.add(pVar);
                            }
                        }
                    }
                    this.aMA.parseJson(optJSONObject3.optJSONObject("gongyanfang_pkpanel"));
                    this.aMB.parserJson(optJSONObject3.optJSONObject("lottery_info"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
