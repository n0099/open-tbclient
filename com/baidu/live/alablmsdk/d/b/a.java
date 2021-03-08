package com.baidu.live.alablmsdk.d.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public long aBi = -1;
    public long aBj = 0;
    public long aBk = 0;
    public String content = "";

    public static a fa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.aBi = jSONObject.optLong("cmd", 0L);
            aVar.aBj = jSONObject.optLong("f", 0L);
            aVar.aBk = jSONObject.optLong("t", 0L);
            aVar.content = jSONObject.optString("c", "");
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return aVar;
        }
    }

    public static byte[] a(long j, long j2, String str) {
        a aVar = new a();
        aVar.aBi = 0L;
        aVar.aBj = j;
        aVar.aBk = j2;
        aVar.content = str;
        return aVar.toString().getBytes();
    }

    public static byte[] b(long j, long j2, boolean z) {
        a aVar = new a();
        aVar.aBi = z ? 1L : 2L;
        aVar.aBj = j;
        aVar.aBk = j2;
        aVar.content = "";
        return aVar.toString().getBytes();
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", this.aBi);
            jSONObject.put("f", this.aBj);
            jSONObject.put("t", this.aBk);
            jSONObject.put("c", this.content);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
