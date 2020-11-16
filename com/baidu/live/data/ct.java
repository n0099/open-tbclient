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
    public int aQO;
    public List<a> aQP = new ArrayList();
    public ArrayList<String> aQQ;
    public String aQR;
    public int mStep;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.mStep = jSONObject.optInt("step");
            this.aQR = jSONObject.optString(Message.RULE);
            this.aQO = jSONObject.optInt("num_fields");
            JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.MessageColumns.COLUME_TIPS);
            if (optJSONArray != null) {
                this.aQQ = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.aQQ.add(optJSONArray.getString(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sweet_moments");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length() && (optJSONObject = optJSONArray2.optJSONObject(i2)) != null; i2++) {
                    a aVar = new a();
                    aVar.aQS = optJSONObject.optInt("end_time");
                    aVar.aQT = optJSONObject.optString("uk_1");
                    aVar.aQU = optJSONObject.optString("avatar_1");
                    aVar.aQV = optJSONObject.optString("uk_2");
                    aVar.aQW = optJSONObject.optString("avatar_2");
                    this.aQP.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public int aQS;
        public String aQT;
        public String aQU;
        public String aQV;
        public String aQW;

        public a() {
        }
    }
}
