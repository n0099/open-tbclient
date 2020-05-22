package com.baidu.live.data;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.i;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class as extends BaseData {
    public ArrayList<i> aAo = new ArrayList<>();
    public int avZ;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        i.a aVar;
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.avZ = optJSONObject.optInt("interval");
                }
                if (this.avZ <= 0) {
                    this.avZ = 5;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("im_rate");
                if (optJSONObject2 == null) {
                    aVar = null;
                } else {
                    aVar = new i.a(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("live_activity_new");
                long optLong = jSONObject.optLong("time", 0L);
                if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("activity_info")) != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                        if (optJSONObject4 != null) {
                            i iVar = new i();
                            iVar.a(aVar);
                            iVar.parseJson(optJSONObject4);
                            iVar.serverTime = optLong;
                            this.aAo.add(iVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
