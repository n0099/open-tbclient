package com.baidu.live.alablmsdk.module.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public boolean aAa;
    public String aAb;
    private List<b> aAc = new ArrayList();
    public String azZ;

    public static JSONObject yI() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("blm_status_check_info", "");
            jSONObject.put("user_ext_info", jSONObject2);
        } catch (JSONException e) {
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" structureStatusCheckInfo " + jSONObject.toString(), "");
        return jSONObject;
    }

    public String w(JSONObject jSONObject) {
        JSONObject v = v(jSONObject);
        return v != null ? v.toString() : "";
    }

    public JSONObject v(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.aAb)) {
                jSONObject2.put("blm_status_check_info", this.aAb);
            }
            if (!TextUtils.isEmpty(this.azZ)) {
                jSONObject2.put("user_ext_info", new JSONArray(this.azZ));
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("blm_internal_info", jSONObject2);
            }
        } catch (JSONException e) {
        }
        com.baidu.live.alablmsdk.a.b.a.d(" complementExtJsonToStr=" + jSONObject.toString());
        return jSONObject;
    }

    public JSONObject eV(String str) {
        com.baidu.live.alablmsdk.a.b.a.d(" parseAndRemoveInternalInfo 原始数据 " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return x(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject x(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("blm_internal_info");
        if (optJSONObject != null) {
            if (optJSONObject.has("blm_status_check_info")) {
                this.aAa = true;
            }
            this.aAb = optJSONObject.optString("blm_status_check_info");
            this.azZ = optJSONObject.optString("user_ext_info");
            if (this.azZ != null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.azZ);
                    int length = jSONArray.length();
                    if (this.aAc == null) {
                        this.aAc = new ArrayList();
                    }
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string) && (jSONObject2 = new JSONObject(string)) != null) {
                            b bVar = new b();
                            bVar.parse(jSONObject2);
                            this.aAc.add(bVar);
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

    public b aF(long j) {
        if (j == 0 || com.baidu.live.alablmsdk.a.a.isEmpty(this.aAc)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aAc.size()) {
                return null;
            }
            b bVar = this.aAc.get(i2);
            if (bVar == null || bVar.azK != j) {
                i = i2 + 1;
            } else {
                return bVar;
            }
        }
    }
}
