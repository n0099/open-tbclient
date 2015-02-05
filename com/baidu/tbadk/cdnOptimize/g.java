package com.baidu.tbadk.cdnOptimize;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public ArrayList<ArrayList<String>> BH;
    public int BF = 0;
    public String errorString = null;
    public String imageUrl = null;
    public String BG = null;
    boolean BI = false;
    public String BJ = null;

    public void parseJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.BF = optJSONObject.optInt("errorno");
                    this.errorString = optJSONObject.optString("errmsg");
                }
                if (1 == jSONObject.optInt("cdn_switch")) {
                    this.BI = true;
                } else {
                    this.BI = false;
                }
                this.BJ = jSONObject.optString("cdn_domain");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("cdn_img_info");
                if (optJSONObject2 != null) {
                    this.imageUrl = optJSONObject2.optString("img_url");
                    this.BG = optJSONObject2.optString("img_md5");
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ip_list");
                if (optJSONArray2 != null) {
                    int length = optJSONArray2.length();
                    ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                        if (jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray("ip")) != null) {
                            int length2 = optJSONArray.length();
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            for (int i2 = 0; i2 < length2; i2++) {
                                String string = optJSONArray.getString(i2);
                                if (string != null && string.length() > 0) {
                                    arrayList2.add(string);
                                }
                            }
                            if (arrayList2.size() > 0) {
                                arrayList.add(arrayList2);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.BH = arrayList;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
