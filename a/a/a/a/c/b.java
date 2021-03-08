package a.a.a.a.c;

import a.a.a.a.a.e;
import android.util.Pair;
import com.qq.e.comm.constants.Constants;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends c {
    public b(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c.c
    public Pair<p, JSONObject> j(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 == null) {
                return null;
            }
            Field declaredField2 = obj2.getClass().getDeclaredField("k");
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            if (obj3 != null && (obj3 instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj3;
                return new Pair<>(new p(jSONObject.optString("brandName"), jSONObject.optString("title"), jSONObject.optString("description"), null, jSONObject.optString("appname"), null, null, jSONObject.optString("imageSrc"), null, null, jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY), jSONObject.optString("deepLinkUrl"), null), jSONObject);
            }
            return null;
        } catch (Exception e) {
            a.a.a.a.v.d.a(e);
            return null;
        }
    }
}
