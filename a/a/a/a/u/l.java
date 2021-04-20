package a.a.a.a.u;

import a.a.a.a.s.e;
import android.util.Pair;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l extends b {
    public l(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.b
    public Pair<o, JSONObject> c(Object obj) {
        Object a2 = a.a.a.a.a.a("com.kwad.sdk.core.response.model.AdInfo", obj);
        JSONObject jSONObject = null;
        if (a2 == null) {
            return null;
        }
        String a3 = a.a.a.a.a.a(a2);
        AdInfo adInfo = (AdInfo) a2;
        try {
            jSONObject = new JSONObject(a3);
        } catch (JSONException unused) {
        }
        return new Pair<>(a.a.a.a.a.a(adInfo), jSONObject);
    }
}
