package a.a.a.a.u;

import a.a.a.a.s.e;
import android.util.Pair;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n extends b {
    public n(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.b
    public Pair<o, JSONObject> c(Object obj) {
        List<AdTemplate> list;
        AdInfo adInfo;
        JSONObject jSONObject;
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null && (obj2 instanceof AdResultData) && (list = ((AdResultData) obj2).adTemplateList) != null && !list.isEmpty()) {
                AdTemplate adTemplate = list.get(0);
                List<AdInfo> list2 = adTemplate == null ? null : adTemplate.adInfoList;
                if (list2 == null || list2.isEmpty() || (adInfo = list2.get(0)) == null) {
                    return null;
                }
                try {
                    jSONObject = new JSONObject(a.a.a.a.a.a(adInfo));
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                return new Pair<>(a.a.a.a.a.a(adInfo), jSONObject);
            }
            return null;
        } catch (Exception e2) {
            a.a.a.a.v.d.a(e2);
            return null;
        }
    }
}
