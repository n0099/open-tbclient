package com.baidu.live.alablmsdk.module.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.alablmsdk.module.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public long axT;
    public String order;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imuk", this.axT);
            jSONObject.put(IMConstants.SERVICE_TYPE_ORDER, this.order);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imuk", this.axT);
            jSONObject.put(IMConstants.SERVICE_TYPE_ORDER, this.order);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static String a(b bVar) {
        if (bVar != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(bVar.toJSON());
            return jSONArray.toString();
        }
        return "";
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axT = jSONObject.optLong("imuk");
            this.order = jSONObject.optString(IMConstants.SERVICE_TYPE_ORDER);
        }
    }

    public static String b(c cVar) {
        if (cVar == null || cVar.axT == 0) {
            return "";
        }
        b bVar = new b();
        bVar.axT = cVar.axT;
        bVar.order = cVar.order;
        return bVar.toJsonString();
    }

    public static b eE(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            b bVar = new b();
            bVar.parse(jSONObject);
            return bVar;
        } catch (JSONException e) {
            return null;
        }
    }

    public static void a(c cVar, a aVar) {
        b aB;
        if (cVar != null && cVar.axT != 0 && cVar.axT != 0 && aVar != null && aVar != null && (aB = aVar.aB(cVar.axT)) != null) {
            cVar.order = aB.order;
            com.baidu.live.alablmsdk.a.b.a.d(" addUserExtInfo add order , user=" + cVar.toString());
        }
    }
}
