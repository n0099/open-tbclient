package a.a.a.a.w;

import a.a.a.a.u.e;
import android.util.Pair;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends b {
    public f(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.w.b
    public Pair<p, JSONObject> c(Object obj) {
        Field declaredField;
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField2 = obj.getClass().getDeclaredField("a");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return null;
            }
            Field declaredField3 = obj2.getClass().getDeclaredField("f");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj2);
            if (obj3 == null || (declaredField = obj3.getClass().getSuperclass().getDeclaredField("E")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj4 = declaredField.get(obj3);
            if (obj4 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj4;
                return new Pair<>(a.a.a.a.a.a(jSONObject), jSONObject);
            }
            return null;
        } catch (Exception unused) {
            a.a.a.a.x.d.b();
            return null;
        }
    }
}
