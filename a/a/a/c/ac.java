package a.a.a.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: e  reason: collision with root package name */
    public int f1388e;

    /* renamed from: h  reason: collision with root package name */
    public String f1391h;

    /* renamed from: a  reason: collision with root package name */
    public String f1384a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f1385b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f1386c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f1387d = "";

    /* renamed from: f  reason: collision with root package name */
    public String f1389f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f1390g = 0;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f1384a);
            jSONObject.put("id", this.f1385b);
            jSONObject.put("image", this.f1386c);
            jSONObject.put("url", this.f1387d);
            jSONObject.put("progress", this.f1388e);
            jSONObject.put("downloadPerSize", this.f1389f);
            jSONObject.put("status", this.f1390g);
            jSONObject.put("savePath", this.f1391h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
