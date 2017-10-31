package com.baidu.sofire.rp.a;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static String b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", bVar.a);
            jSONObject.put("1", bVar.c);
            jSONObject.put("2", bVar.d);
            jSONObject.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, bVar.e);
            jSONObject.put("4", bVar.b);
        } catch (Throwable th) {
            com.baidu.sofire.rp.f.b.a();
        }
        return jSONObject.toString();
    }

    public static b bZ(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a = jSONObject.optString("0");
            bVar.c = jSONObject.optString("1");
            bVar.d = jSONObject.optString("2");
            bVar.e = jSONObject.optString(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            bVar.b = jSONObject.optString("4");
            return bVar;
        } catch (Exception e) {
            com.baidu.sofire.rp.f.b.a();
            return null;
        }
    }

    public final int hashCode() {
        return (((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + 31) * 31)) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.d == null) {
                if (bVar.d != null) {
                    return false;
                }
            } else if (!this.d.equals(bVar.d)) {
                return false;
            }
            if (this.e == null) {
                if (bVar.e != null) {
                    return false;
                }
            } else if (!this.e.equals(bVar.e)) {
                return false;
            }
            return this.b == null ? bVar.b == null : this.b.equals(bVar.b);
        }
        return false;
    }
}
