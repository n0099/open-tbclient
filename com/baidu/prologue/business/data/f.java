package com.baidu.prologue.business.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.prologue.a.c.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static void h(e eVar) {
        j.setLong("last_show_time", System.currentTimeMillis() / 1000);
        i(eVar);
    }

    public static long getLastShowTime() {
        return j.getLong("last_show_time", 0L);
    }

    private static void i(e eVar) {
        boolean z = false;
        String string = j.getString("today_show_list", "");
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (TextUtils.equals(optJSONObject.optString("k"), eVar.bzX)) {
                        optJSONObject.put("t", TextUtils.concat(valueOf, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, optJSONObject.optString("t")).toString());
                        jSONArray.put(i, optJSONObject);
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", eVar.bzX);
                jSONObject.put("t", valueOf);
                jSONArray.put(jSONObject);
            }
            j.setString("today_show_list", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray Ol() {
        int i = 0;
        String string = j.getString("today_show_list", "");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(string);
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray2.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                try {
                    if (com.baidu.prologue.a.c.b.a(Long.valueOf(Long.valueOf(optJSONObject.optString("t").split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0]).longValue()), Long.valueOf(System.currentTimeMillis()))) {
                        jSONArray.put(optJSONObject);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        j.setString("today_show_list", jSONArray.toString());
        return jSONArray;
    }
}
