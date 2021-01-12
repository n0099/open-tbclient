package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cx {
    public int aQb;
    public List<a> aQc = new ArrayList();
    public ArrayList<String> aQd;
    public String aQe;
    public String aQf;
    public int mStep;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.mStep = jSONObject.optInt("step");
            this.aQe = jSONObject.optString(Message.RULE);
            this.aQb = jSONObject.optInt("num_fields");
            this.aQf = jSONObject.optString("step_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.MessageColumns.COLUME_TIPS);
            if (optJSONArray != null) {
                this.aQd = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.aQd.add(optJSONArray.getString(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sweet_moments");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length() && (optJSONObject = optJSONArray2.optJSONObject(i2)) != null; i2++) {
                    a aVar = new a();
                    aVar.aQg = optJSONObject.optInt("end_time");
                    aVar.aQh = optJSONObject.optString("uk_1");
                    aVar.aQi = optJSONObject.optString("avatar_1");
                    aVar.aQj = optJSONObject.optString("uk_2");
                    aVar.aQk = optJSONObject.optString("avatar_2");
                    this.aQc.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public int aQg;
        public String aQh;
        public String aQi;
        public String aQj;
        public String aQk;

        public a() {
        }
    }
}
