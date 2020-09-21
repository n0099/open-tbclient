package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveWishListData implements Serializable {
    private static final long serialVersionUID = 5768965545624138311L;
    public long expire_time;
    public int finish_num;
    public String gift_name;
    public String gift_url;
    public int process_num;
    public String wish_id;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.wish_id = jSONObject.optString("wish_id");
            this.gift_name = jSONObject.optString("gift_name");
            this.gift_url = jSONObject.optString("gift_url");
            this.process_num = jSONObject.optInt("process_num");
            this.finish_num = jSONObject.optInt("finish_num");
            this.expire_time = jSONObject.optLong("expire_time");
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wish_id", this.wish_id);
            jSONObject.put("gift_name", this.gift_name);
            jSONObject.put("gift_url", this.gift_url);
            jSONObject.put("process_num", this.process_num);
            jSONObject.put("finish_num", this.finish_num);
            jSONObject.put("expire_time", this.expire_time);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject toJsonObject() {
        return toJson();
    }

    public static String toListString(ArrayList<AlaLiveWishListData> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                jSONArray.put(arrayList.get(i2).toJson());
                i = i2 + 1;
            } else {
                return jSONArray.toString();
            }
        }
    }

    public static ArrayList<AlaLiveWishListData> toWishListData(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<AlaLiveWishListData> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                AlaLiveWishListData alaLiveWishListData = new AlaLiveWishListData();
                alaLiveWishListData.parserJson(jSONObject);
                arrayList.add(alaLiveWishListData);
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return arrayList;
        }
    }
}
