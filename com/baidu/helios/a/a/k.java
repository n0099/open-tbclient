package com.baidu.helios.a.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String optString = jSONObject.optString(str);
        String optString2 = jSONObject2.optString(str);
        return TextUtils.isEmpty(optString) ? !TextUtils.isEmpty(optString2) : !optString.equals(optString2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONArray b(JSONArray jSONArray, final String str) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(optJSONObject);
            }
        }
        Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.baidu.helios.a.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString(str, "").compareTo(jSONObject2.optString(str, ""));
            }
        });
        return new JSONArray((Collection) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject.optLong(str, -1L) != jSONObject2.optLong(str, -1L);
    }
}
