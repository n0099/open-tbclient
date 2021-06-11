package a.a.a.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: e  reason: collision with root package name */
    public int f1419e;

    /* renamed from: h  reason: collision with root package name */
    public String f1422h;

    /* renamed from: a  reason: collision with root package name */
    public String f1415a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f1416b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f1417c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f1418d = "";

    /* renamed from: f  reason: collision with root package name */
    public String f1420f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f1421g = 0;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f1415a);
            jSONObject.put("id", this.f1416b);
            jSONObject.put("image", this.f1417c);
            jSONObject.put("url", this.f1418d);
            jSONObject.put("progress", this.f1419e);
            jSONObject.put("downloadPerSize", this.f1420f);
            jSONObject.put("status", this.f1421g);
            jSONObject.put("savePath", this.f1422h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
