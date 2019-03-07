package cn.jiguang.d.b.a;

import android.text.TextUtils;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class f {
    int a;
    long c;
    long d;
    long e;
    int f;
    double g;
    double h;
    long i;
    int j;
    c lw;

    public static LinkedList<f> J(String str) {
        LinkedList<f> linkedList = new LinkedList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(d(jSONArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
            }
        }
        return linkedList;
    }

    private static f d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        try {
            f fVar = new f();
            fVar.a = jSONObject.getInt("type");
            fVar.lw = c.a(jSONObject.getString("addr"));
            fVar.d = jSONObject.getLong("rtime");
            fVar.e = jSONObject.getLong("interval");
            fVar.f = jSONObject.getInt("net");
            fVar.j = jSONObject.getInt("code");
            fVar.c = jSONObject.optInt("uid");
            fVar.g = jSONObject.optDouble("lat");
            fVar.h = jSONObject.optDouble("lng");
            fVar.i = jSONObject.optLong("ltime");
            return fVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.a);
            jSONObject.put("addr", this.lw.toString());
            jSONObject.put("rtime", this.d);
            jSONObject.put("interval", this.e);
            jSONObject.put("net", this.f);
            jSONObject.put("code", this.j);
            if (this.c != 0) {
                jSONObject.put("uid", this.c);
            }
            double d = this.g;
            double d2 = this.h;
            if (d > -90.0d && d < 90.0d && d2 > -180.0d && d2 < 180.0d) {
                jSONObject.put("lat", this.g);
                jSONObject.put("lng", this.h);
                jSONObject.put("ltime", this.i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
