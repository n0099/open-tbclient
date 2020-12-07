package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cv {
    public int aTQ;
    public List<a> aTR = new ArrayList();
    public ArrayList<String> aTS;
    public String aTT;
    public int mStep;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.mStep = jSONObject.optInt("step");
            this.aTT = jSONObject.optString(Message.RULE);
            this.aTQ = jSONObject.optInt("num_fields");
            JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.MessageColumns.COLUME_TIPS);
            if (optJSONArray != null) {
                this.aTS = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.aTS.add(optJSONArray.getString(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sweet_moments");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length() && (optJSONObject = optJSONArray2.optJSONObject(i2)) != null; i2++) {
                    a aVar = new a();
                    aVar.aTU = optJSONObject.optInt("end_time");
                    aVar.aTV = optJSONObject.optString("uk_1");
                    aVar.aTW = optJSONObject.optString("avatar_1");
                    aVar.aTX = optJSONObject.optString("uk_2");
                    aVar.aTY = optJSONObject.optString("avatar_2");
                    this.aTR.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public int aTU;
        public String aTV;
        public String aTW;
        public String aTX;
        public String aTY;

        public a() {
        }
    }
}
