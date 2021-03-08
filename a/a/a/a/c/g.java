package a.a.a.a.c;

import a.a.a.a.a.e;
import android.util.Pair;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g extends c {
    public g(e.a aVar) {
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
            Field declaredField2 = obj2.getClass().getDeclaredField("c");
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            if (obj3 != null && (obj3 instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj3;
                return new Pair<>(a.a.a.a.a.r(jSONObject), jSONObject);
            }
            return null;
        } catch (Exception e) {
            a.a.a.a.v.d.b();
            return null;
        }
    }
}
