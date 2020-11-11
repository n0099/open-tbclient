package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ct {
    public List<a> aSA = new ArrayList();
    public ArrayList<String> aSB;
    public String aSC;
    public int aSz;
    public int mStep;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.mStep = jSONObject.optInt("step");
            this.aSC = jSONObject.optString(Message.RULE);
            this.aSz = jSONObject.optInt("num_fields");
            JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.MessageColumns.COLUME_TIPS);
            if (optJSONArray != null) {
                this.aSB = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.aSB.add(optJSONArray.getString(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sweet_moments");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length() && (optJSONObject = optJSONArray2.optJSONObject(i2)) != null; i2++) {
                    a aVar = new a();
                    aVar.aSD = optJSONObject.optInt("end_time");
                    aVar.aSE = optJSONObject.optString("uk_1");
                    aVar.aSF = optJSONObject.optString("avatar_1");
                    aVar.aSG = optJSONObject.optString("uk_2");
                    aVar.aSH = optJSONObject.optString("avatar_2");
                    this.aSA.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public int aSD;
        public String aSE;
        public String aSF;
        public String aSG;
        public String aSH;

        public a() {
        }
    }
}
