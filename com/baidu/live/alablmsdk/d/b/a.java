package com.baidu.live.alablmsdk.d.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public long azI = -1;
    public long azJ = 0;
    public long azK = 0;
    public String content = "";

    public static a eU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.azI = jSONObject.optLong("cmd", 0L);
            aVar.azJ = jSONObject.optLong("f", 0L);
            aVar.azK = jSONObject.optLong("t", 0L);
            aVar.content = jSONObject.optString("c", "");
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return aVar;
        }
    }

    public static byte[] a(long j, long j2, String str) {
        a aVar = new a();
        aVar.azI = 0L;
        aVar.azJ = j;
        aVar.azK = j2;
        aVar.content = str;
        return aVar.toString().getBytes();
    }

    public static byte[] b(long j, long j2, boolean z) {
        a aVar = new a();
        aVar.azI = z ? 1L : 2L;
        aVar.azJ = j;
        aVar.azK = j2;
        aVar.content = "";
        return aVar.toString().getBytes();
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", this.azI);
            jSONObject.put("f", this.azJ);
            jSONObject.put("t", this.azK);
            jSONObject.put("c", this.content);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
