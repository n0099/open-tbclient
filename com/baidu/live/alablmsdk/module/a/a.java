package com.baidu.live.alablmsdk.module.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aAa;
    private List<b> aAb = new ArrayList();
    public String azY;
    public boolean azZ;

    public static JSONObject Bn() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("blm_status_check_info", "");
            jSONObject.put("user_ext_info", jSONObject2);
        } catch (JSONException e) {
        }
        com.baidu.live.alablmsdk.a.b.ag(" structureStatusCheckInfo " + jSONObject.toString(), "");
        return jSONObject;
    }

    public String o(JSONObject jSONObject) {
        JSONObject n = n(jSONObject);
        return n != null ? n.toString() : "";
    }

    public JSONObject n(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.aAa)) {
                jSONObject2.put("blm_status_check_info", this.aAa);
            }
            if (!TextUtils.isEmpty(this.azY)) {
                jSONObject2.put("user_ext_info", new JSONArray(this.azY));
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("blm_internal_info", jSONObject2);
            }
        } catch (JSONException e) {
        }
        com.baidu.live.alablmsdk.a.b.d(" complementExtJsonToStr=" + jSONObject.toString());
        return jSONObject;
    }

    public JSONObject fI(String str) {
        com.baidu.live.alablmsdk.a.b.d(" parseAndRemoveInternalInfo 原始数据 " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return p(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject p(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("blm_internal_info");
        if (optJSONObject != null) {
            if (optJSONObject.has("blm_status_check_info")) {
                this.azZ = true;
            }
            this.aAa = optJSONObject.optString("blm_status_check_info");
            this.azY = optJSONObject.optString("user_ext_info");
            if (this.azY != null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.azY);
                    int length = jSONArray.length();
                    if (this.aAb == null) {
                        this.aAb = new ArrayList();
                    }
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string) && (jSONObject2 = new JSONObject(string)) != null) {
                            b bVar = new b();
                            bVar.parse(jSONObject2);
                            this.aAb.add(bVar);
                        }
                    }
                } catch (JSONException e) {
                }
            }
            jSONObject.remove("blm_internal_info");
        }
        com.baidu.live.alablmsdk.a.b.d(" parseAndRemoveInternalInfo 处理后数据 " + jSONObject.toString());
        return jSONObject;
    }

    public b ae(long j) {
        if (j == 0 || com.baidu.live.alablmsdk.a.a.isEmpty(this.aAb)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aAb.size()) {
                return null;
            }
            b bVar = this.aAb.get(i2);
            if (bVar == null || bVar.azK != j) {
                i = i2 + 1;
            } else {
                return bVar;
            }
        }
    }
}
