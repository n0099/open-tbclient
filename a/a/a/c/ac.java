package a.a.a.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: e  reason: collision with root package name */
    public int f1406e;

    /* renamed from: h  reason: collision with root package name */
    public String f1409h;

    /* renamed from: a  reason: collision with root package name */
    public String f1402a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f1403b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f1404c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f1405d = "";

    /* renamed from: f  reason: collision with root package name */
    public String f1407f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f1408g = 0;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f1402a);
            jSONObject.put("id", this.f1403b);
            jSONObject.put("image", this.f1404c);
            jSONObject.put("url", this.f1405d);
            jSONObject.put("progress", this.f1406e);
            jSONObject.put("downloadPerSize", this.f1407f);
            jSONObject.put("status", this.f1408g);
            jSONObject.put("savePath", this.f1409h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
