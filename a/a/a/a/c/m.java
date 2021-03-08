package a.a.a.a.c;

import a.a.a.a.a.e;
import android.util.Pair;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m extends c {
    public m(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c.c
    public Pair<p, JSONObject> j(Object obj) {
        JSONObject jSONObject;
        Object c = a.a.a.a.a.c("com.kwad.sdk.core.response.model.AdInfo", obj);
        if (c == null) {
            return null;
        }
        String a2 = a.a.a.a.a.a(c);
        AdInfo adInfo = (AdInfo) c;
        try {
            jSONObject = new JSONObject(a2);
        } catch (JSONException e) {
            jSONObject = null;
        }
        return new Pair<>(a.a.a.a.a.ai(adInfo), jSONObject);
    }
}
