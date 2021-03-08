package com.baidu.live.data;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.t;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class br extends BaseData {
    public ArrayList<t> aQX = new ArrayList<>();
    public ai aQY = new ai();
    public ad aQZ = new ad();
    public int interval;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        t.a aVar;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.interval = optJSONObject.optInt("interval");
                }
                if (this.interval <= 0) {
                    this.interval = 5;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("im_rate");
                if (optJSONObject2 == null) {
                    aVar = null;
                } else {
                    aVar = new t.a(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("live_activity_new");
                long optLong = jSONObject.optLong("time", 0L);
                if (optJSONObject3 != null) {
                    JSONArray optJSONArray = optJSONObject3.optJSONArray("activity_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                            if (optJSONObject4 != null) {
                                t tVar = new t();
                                tVar.a(aVar);
                                tVar.parseJson(optJSONObject4);
                                tVar.serverTime = optLong;
                                this.aQX.add(tVar);
                            }
                        }
                    }
                    this.aQY.parseJson(optJSONObject3.optJSONObject("gongyanfang_pkpanel"));
                    this.aQZ.parserJson(optJSONObject3.optJSONObject("lottery_info"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
