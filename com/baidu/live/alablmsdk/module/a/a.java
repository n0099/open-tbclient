package com.baidu.live.alablmsdk.module.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aCE;
    public boolean aCF;
    public String aCG;
    private List<b> aCH = new ArrayList();

    public static JSONObject CV() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("blm_status_check_info", "");
            jSONObject.put("user_ext_info", jSONObject2);
        } catch (JSONException e) {
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" structureStatusCheckInfo " + jSONObject.toString(), "");
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
            if (!TextUtils.isEmpty(this.aCG)) {
                jSONObject2.put("blm_status_check_info", this.aCG);
            }
            if (!TextUtils.isEmpty(this.aCE)) {
                jSONObject2.put("user_ext_info", new JSONArray(this.aCE));
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("blm_internal_info", jSONObject2);
            }
        } catch (JSONException e) {
        }
        com.baidu.live.alablmsdk.a.b.a.d(" complementExtJsonToStr=" + jSONObject.toString());
        return jSONObject;
    }

    public JSONObject ge(String str) {
        com.baidu.live.alablmsdk.a.b.a.d(" parseAndRemoveInternalInfo 原始数据 " + str);
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
                this.aCF = true;
            }
            this.aCG = optJSONObject.optString("blm_status_check_info");
            this.aCE = optJSONObject.optString("user_ext_info");
            if (this.aCE != null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.aCE);
                    int length = jSONArray.length();
                    if (this.aCH == null) {
                        this.aCH = new ArrayList();
                    }
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string) && (jSONObject2 = new JSONObject(string)) != null) {
                            b bVar = new b();
                            bVar.parse(jSONObject2);
                            this.aCH.add(bVar);
                        }
                    }
                } catch (JSONException e) {
                }
            }
            jSONObject.remove("blm_internal_info");
        }
        com.baidu.live.alablmsdk.a.b.a.d(" parseAndRemoveInternalInfo 处理后数据 " + jSONObject.toString());
        return jSONObject;
    }

    public b aC(long j) {
        if (j == 0 || com.baidu.live.alablmsdk.a.a.isEmpty(this.aCH)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aCH.size()) {
                return null;
            }
            b bVar = this.aCH.get(i2);
            if (bVar == null || bVar.aCp != j) {
                i = i2 + 1;
            } else {
                return bVar;
            }
        }
    }
}
