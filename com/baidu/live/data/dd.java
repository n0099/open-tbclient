package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class dd {
    public int aTe;
    public List<a> aTf = new ArrayList();
    public ArrayList<String> aTg;
    public String aTh;
    public String aTi;
    public int mStep;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.mStep = jSONObject.optInt("step");
            this.aTh = jSONObject.optString(Message.RULE);
            this.aTe = jSONObject.optInt("num_fields");
            this.aTi = jSONObject.optString("step_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.MessageColumns.COLUME_TIPS);
            if (optJSONArray != null) {
                this.aTg = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.aTg.add(optJSONArray.getString(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sweet_moments");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length() && (optJSONObject = optJSONArray2.optJSONObject(i2)) != null; i2++) {
                    a aVar = new a();
                    aVar.aTj = optJSONObject.optInt("end_time");
                    aVar.aTk = optJSONObject.optString("uk_1");
                    aVar.aTl = optJSONObject.optString("avatar_1");
                    aVar.aTm = optJSONObject.optString("uk_2");
                    aVar.aTn = optJSONObject.optString("avatar_2");
                    this.aTf.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a {
        public int aTj;
        public String aTk;
        public String aTl;
        public String aTm;
        public String aTn;

        public a() {
        }
    }
}
