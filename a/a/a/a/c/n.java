package a.a.a.a.c;

import a.a.a.a.a.e;
import android.util.Pair;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n extends c {
    public n(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c.c
    public Pair<p, JSONObject> j(Object obj) {
        JSONObject jSONObject;
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null && (obj2 instanceof AdTemplate)) {
                List<AdInfo> list = ((AdTemplate) obj2).adInfoList;
                if (list == null || list.isEmpty()) {
                    return null;
                }
                AdInfo adInfo = list.get(0);
                if (adInfo == null) {
                    return null;
                }
                try {
                    jSONObject = new JSONObject(a.a.a.a.a.a(adInfo));
                } catch (JSONException e) {
                    jSONObject = null;
                }
                return new Pair<>(a.a.a.a.a.ai(adInfo), jSONObject);
            }
            return null;
        } catch (Exception e2) {
            a.a.a.a.v.d.a(e2);
            return null;
        }
    }
}
