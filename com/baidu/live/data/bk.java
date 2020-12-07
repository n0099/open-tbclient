package com.baidu.live.data;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.o;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bk extends BaseData {
    public int aLG;
    public ArrayList<o> aQx = new ArrayList<>();
    public ad aQy = new ad();
    public y aQz = new y();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        o.a aVar;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.aLG = optJSONObject.optInt("interval");
                }
                if (this.aLG <= 0) {
                    this.aLG = 5;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("im_rate");
                if (optJSONObject2 == null) {
                    aVar = null;
                } else {
                    aVar = new o.a(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("live_activity_new");
                long optLong = jSONObject.optLong("time", 0L);
                if (optJSONObject3 != null) {
                    JSONArray optJSONArray = optJSONObject3.optJSONArray("activity_info");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                            if (optJSONObject4 != null) {
                                o oVar = new o();
                                oVar.a(aVar);
                                oVar.parseJson(optJSONObject4);
                                oVar.serverTime = optLong;
                                this.aQx.add(oVar);
                            }
                        }
                    }
                    this.aQy.parseJson(optJSONObject3.optJSONObject("gongyanfang_pkpanel"));
                    this.aQz.parserJson(optJSONObject3.optJSONObject("lottery_info"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
