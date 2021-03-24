package a.a.a.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: e  reason: collision with root package name */
    public int f1402e;

    /* renamed from: h  reason: collision with root package name */
    public String f1405h;

    /* renamed from: a  reason: collision with root package name */
    public String f1398a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f1399b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f1400c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f1401d = "";

    /* renamed from: f  reason: collision with root package name */
    public String f1403f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f1404g = 0;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f1398a);
            jSONObject.put("id", this.f1399b);
            jSONObject.put("image", this.f1400c);
            jSONObject.put("url", this.f1401d);
            jSONObject.put("progress", this.f1402e);
            jSONObject.put("downloadPerSize", this.f1403f);
            jSONObject.put("status", this.f1404g);
            jSONObject.put("savePath", this.f1405h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
