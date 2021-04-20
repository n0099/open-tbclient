package a.a.a.a.u;

import a.a.a.a.s.e;
import android.util.Pair;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m extends b {
    public m(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.b
    public Pair<o, JSONObject> c(Object obj) {
        List<AdInfo> list;
        AdInfo adInfo;
        JSONObject jSONObject;
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 == null || !(obj2 instanceof AdTemplate) || (list = ((AdTemplate) obj2).adInfoList) == null || list.isEmpty() || (adInfo = list.get(0)) == null) {
                return null;
            }
            try {
                jSONObject = new JSONObject(a.a.a.a.a.a(adInfo));
            } catch (JSONException unused) {
                jSONObject = null;
            }
            return new Pair<>(a.a.a.a.a.a(adInfo), jSONObject);
        } catch (Exception e2) {
            a.a.a.a.v.d.a(e2);
            return null;
        }
    }
}
