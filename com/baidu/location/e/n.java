package com.baidu.location.e;

import com.baidu.location.e.m;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
enum n extends m.b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    @Override // com.baidu.location.e.m.b
    List<String> a(JSONObject jSONObject, String str, int i) {
        int i2 = 0;
        Iterator<String> keys = jSONObject.keys();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i3 = i2;
            if (!keys.hasNext()) {
                break;
            }
            String next = keys.next();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                String string = jSONObject2.has("cy") ? jSONObject2.getString("cy") : null;
                String string2 = jSONObject2.has("cyc") ? jSONObject2.getString("cyc") : null;
                String string3 = jSONObject2.has("prov") ? jSONObject2.getString("prov") : null;
                String string4 = jSONObject2.has("ctc") ? jSONObject2.getString("ctc") : null;
                String string5 = jSONObject2.has("ct") ? jSONObject2.getString("ct") : null;
                String string6 = jSONObject2.has("dist") ? jSONObject2.getString("dist") : null;
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                stringBuffer.append("(\"").append(next).append("\",\"").append(string).append("\",\"").append(string2).append("\",\"").append(string3).append("\",\"").append(string5).append("\",\"").append(string4).append("\",\"").append(string6).append("\",").append(System.currentTimeMillis() / 1000).append(",\"\")");
                m.b.b(stringBuffer2, next, str, 0);
            } catch (JSONException e) {
            }
            if (i3 % 50 == 49 && stringBuffer.length() > 0) {
                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCAREA", stringBuffer));
                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer2));
                stringBuffer.setLength(0);
            }
            i2 = i3 + 1;
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCAREA", stringBuffer));
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer2));
            stringBuffer.setLength(0);
        }
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCAREA WHERE gridkey NOT IN (SELECT gridkey FROM RGCAREA LIMIT %d);", Integer.valueOf(i)));
        return arrayList;
    }
}
