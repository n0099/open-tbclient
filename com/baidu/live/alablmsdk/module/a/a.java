package com.baidu.live.alablmsdk.module.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aBJ;
    public boolean aBK;
    public String aBL;
    private List<b> aBM = new ArrayList();

    public static JSONObject BW() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("blm_status_check_info", "");
            jSONObject.put("user_ext_info", jSONObject2);
        } catch (JSONException e) {
        }
        com.baidu.live.alablmsdk.a.b.ah(" structureStatusCheckInfo " + jSONObject.toString(), "");
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
            if (!TextUtils.isEmpty(this.aBL)) {
                jSONObject2.put("blm_status_check_info", this.aBL);
            }
            if (!TextUtils.isEmpty(this.aBJ)) {
                jSONObject2.put("user_ext_info", new JSONArray(this.aBJ));
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("blm_internal_info", jSONObject2);
            }
        } catch (JSONException e) {
        }
        com.baidu.live.alablmsdk.a.b.d(" complementExtJsonToStr=" + jSONObject.toString());
        return jSONObject;
    }

    public JSONObject fO(String str) {
        com.baidu.live.alablmsdk.a.b.d(" parseAndRemoveInternalInfo 原始数据 " + str);
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
                this.aBK = true;
            }
            this.aBL = optJSONObject.optString("blm_status_check_info");
            this.aBJ = optJSONObject.optString("user_ext_info");
            if (this.aBJ != null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.aBJ);
                    int length = jSONArray.length();
                    if (this.aBM == null) {
                        this.aBM = new ArrayList();
                    }
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string) && (jSONObject2 = new JSONObject(string)) != null) {
                            b bVar = new b();
                            bVar.parse(jSONObject2);
                            this.aBM.add(bVar);
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
        if (j == 0 || com.baidu.live.alablmsdk.a.a.isEmpty(this.aBM)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aBM.size()) {
                return null;
            }
            b bVar = this.aBM.get(i2);
            if (bVar == null || bVar.aBv != j) {
                i = i2 + 1;
            } else {
                return bVar;
            }
        }
    }
}
