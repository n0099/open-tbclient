package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class dd {
    public int aUE;
    public List<a> aUF = new ArrayList();
    public ArrayList<String> aUG;
    public String aUH;
    public String aUI;
    public int mStep;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.mStep = jSONObject.optInt("step");
            this.aUH = jSONObject.optString(Message.RULE);
            this.aUE = jSONObject.optInt("num_fields");
            this.aUI = jSONObject.optString("step_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.MessageColumns.COLUME_TIPS);
            if (optJSONArray != null) {
                this.aUG = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.aUG.add(optJSONArray.getString(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sweet_moments");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length() && (optJSONObject = optJSONArray2.optJSONObject(i2)) != null; i2++) {
                    a aVar = new a();
                    aVar.aUJ = optJSONObject.optInt("end_time");
                    aVar.aUK = optJSONObject.optString("uk_1");
                    aVar.aUL = optJSONObject.optString("avatar_1");
                    aVar.aUM = optJSONObject.optString("uk_2");
                    aVar.aUN = optJSONObject.optString("avatar_2");
                    this.aUF.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public int aUJ;
        public String aUK;
        public String aUL;
        public String aUM;
        public String aUN;

        public a() {
        }
    }
}
