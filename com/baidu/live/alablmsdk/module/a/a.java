package com.baidu.live.alablmsdk.module.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public boolean ayA;
    public String ayB;
    private List<b> ayC = new ArrayList();
    public String ayz;

    public static JSONObject yF() {
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

    public String u(JSONObject jSONObject) {
        JSONObject t = t(jSONObject);
        return t != null ? t.toString() : "";
    }

    public JSONObject t(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.ayB)) {
                jSONObject2.put("blm_status_check_info", this.ayB);
            }
            if (!TextUtils.isEmpty(this.ayz)) {
                jSONObject2.put("user_ext_info", new JSONArray(this.ayz));
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("blm_internal_info", jSONObject2);
            }
        } catch (JSONException e) {
        }
        com.baidu.live.alablmsdk.a.b.a.d(" complementExtJsonToStr=" + jSONObject.toString());
        return jSONObject;
    }

    public JSONObject eP(String str) {
        com.baidu.live.alablmsdk.a.b.a.d(" parseAndRemoveInternalInfo 原始数据 " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return v(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject v(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("blm_internal_info");
        if (optJSONObject != null) {
            if (optJSONObject.has("blm_status_check_info")) {
                this.ayA = true;
            }
            this.ayB = optJSONObject.optString("blm_status_check_info");
            this.ayz = optJSONObject.optString("user_ext_info");
            if (this.ayz != null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.ayz);
                    int length = jSONArray.length();
                    if (this.ayC == null) {
                        this.ayC = new ArrayList();
                    }
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string) && (jSONObject2 = new JSONObject(string)) != null) {
                            b bVar = new b();
                            bVar.parse(jSONObject2);
                            this.ayC.add(bVar);
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
        if (j == 0 || com.baidu.live.alablmsdk.a.a.isEmpty(this.ayC)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ayC.size()) {
                return null;
            }
            b bVar = this.ayC.get(i2);
            if (bVar == null || bVar.ayk != j) {
                i = i2 + 1;
            } else {
                return bVar;
            }
        }
    }
}
