package a.a.a.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public int e;
    public String h;

    /* renamed from: a  reason: collision with root package name */
    public String f1033a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f1034b = "";
    public String c = "";
    public String d = "";
    public String f = "";
    public int g = 0;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f1033a);
            jSONObject.put("id", this.f1034b);
            jSONObject.put("image", this.c);
            jSONObject.put("url", this.d);
            jSONObject.put("progress", this.e);
            jSONObject.put("downloadPerSize", this.f);
            jSONObject.put("status", this.g);
            jSONObject.put("savePath", this.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
