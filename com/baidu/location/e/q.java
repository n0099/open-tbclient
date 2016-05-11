package com.baidu.location.e;

import com.baidu.appsearchlib.Info;
import com.baidu.location.e.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
enum q extends m.b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    @Override // com.baidu.location.e.m.b
    List<String> a(JSONObject jSONObject, String str, int i) {
        JSONArray jSONArray;
        Iterator<String> keys = jSONObject.keys();
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (keys.hasNext()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            String next = keys.next();
            m.b.b(stringBuffer, next, str, 1);
            try {
                jSONArray = jSONObject.getJSONArray(next);
            } catch (JSONException e) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String string = jSONObject2.has(Info.kBaiduPIDKey) ? jSONObject2.getString(Info.kBaiduPIDKey) : null;
                        String string2 = jSONObject2.has("ne") ? jSONObject2.getString("ne") : null;
                        String string3 = jSONObject2.has("tp") ? jSONObject2.getString("tp") : null;
                        Integer valueOf = jSONObject2.has("rk") ? Integer.valueOf(jSONObject2.getInt("rk")) : null;
                        Double valueOf2 = jSONObject2.has("x") ? Double.valueOf(jSONObject2.getDouble("x")) : null;
                        Double valueOf3 = jSONObject2.has("y") ? Double.valueOf(jSONObject2.getDouble("y")) : null;
                        if (stringBuffer2.length() > 0) {
                            stringBuffer2.append(",");
                        }
                        stringBuffer2.append("(\"").append(string).append("\",\"").append(next).append("\",\"").append(string2).append("\",\"").append(string3).append("\",").append(valueOf2).append(",").append(valueOf3).append(",").append(valueOf).append(")");
                    } catch (JSONException e2) {
                    }
                    if (i2 % 50 == 49) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCPOI", stringBuffer2.toString()));
                        stringBuffer2.setLength(0);
                    }
                }
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCPOI", stringBuffer2.toString()));
                }
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer));
        }
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCPOI WHERE pid NOT IN (SELECT pid FROM RGCPOI LIMIT %d);", Integer.valueOf(i)));
        return arrayList;
    }
}
