package com.baidu.sapi2.dto.loginhistory;

import com.baidu.sapi2.utils.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LoginHistoryItem implements Serializable {
    public ArrayList<String> actionTimes = new ArrayList<>();
    public String bduss;

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bduss", this.bduss);
            jSONObject.put("times", new JSONArray((Collection) this.actionTimes));
            return jSONObject;
        } catch (JSONException e) {
            Log.e(e);
            return null;
        }
    }

    public static JSONArray toJSONArray(List<LoginHistoryItem> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (LoginHistoryItem loginHistoryItem : list) {
            JSONObject jSONObject = loginHistoryItem.toJSONObject();
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
