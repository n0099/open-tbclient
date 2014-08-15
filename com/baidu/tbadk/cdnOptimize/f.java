package com.baidu.tbadk.cdnOptimize;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public ArrayList<ArrayList<String>> e;
    public int a = 0;
    public String b = null;
    public String c = null;
    public String d = null;
    boolean f = false;
    public String g = null;

    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.a = optJSONObject.optInt("errorno");
                    this.b = optJSONObject.optString("errmsg");
                }
                if (1 == jSONObject.optInt("cdn_switch")) {
                    this.f = true;
                } else {
                    this.f = false;
                }
                this.g = jSONObject.optString("cdn_domain");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("cdn_img_info");
                if (optJSONObject2 != null) {
                    this.c = optJSONObject2.optString("img_url");
                    this.d = optJSONObject2.optString("img_md5");
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
                        this.e = arrayList;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
