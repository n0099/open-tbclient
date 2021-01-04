package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cx {
    public int aUO;
    public List<a> aUP = new ArrayList();
    public ArrayList<String> aUQ;
    public String aUR;
    public String aUS;
    public int mStep;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.mStep = jSONObject.optInt("step");
            this.aUR = jSONObject.optString(Message.RULE);
            this.aUO = jSONObject.optInt("num_fields");
            this.aUS = jSONObject.optString("step_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.MessageColumns.COLUME_TIPS);
            if (optJSONArray != null) {
                this.aUQ = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.aUQ.add(optJSONArray.getString(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sweet_moments");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length() && (optJSONObject = optJSONArray2.optJSONObject(i2)) != null; i2++) {
                    a aVar = new a();
                    aVar.aUT = optJSONObject.optInt("end_time");
                    aVar.aUU = optJSONObject.optString("uk_1");
                    aVar.aUV = optJSONObject.optString("avatar_1");
                    aVar.aUW = optJSONObject.optString("uk_2");
                    aVar.aUX = optJSONObject.optString("avatar_2");
                    this.aUP.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a {
        public int aUT;
        public String aUU;
        public String aUV;
        public String aUW;
        public String aUX;

        public a() {
        }
    }
}
