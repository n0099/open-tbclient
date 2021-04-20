package a.a.a.a.u;

import a.a.a.a.s.e;
import android.util.Pair;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends b {
    public j(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.b
    public Pair<o, JSONObject> c(Object obj) {
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
            Field declaredField2 = obj2.getClass().getDeclaredField("b");
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            if (obj3 == null) {
                return null;
            }
            Field declaredField3 = obj3.getClass().getDeclaredField("d");
            declaredField3.setAccessible(true);
            Object obj4 = declaredField3.get(obj3);
            if (obj4 == null) {
                return null;
            }
            Field declaredField4 = obj4.getClass().getDeclaredField("a");
            declaredField4.setAccessible(true);
            Object obj5 = declaredField4.get(obj4);
            if (obj5 == null) {
                return null;
            }
            Field declaredField5 = obj5.getClass().getDeclaredField("c");
            declaredField5.setAccessible(true);
            Object obj6 = declaredField5.get(obj5);
            if (obj6 != null && (obj6 instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj6;
                jSONObject.toString();
                return new Pair<>(a.a.a.a.a.a(jSONObject), jSONObject);
            }
            return null;
        } catch (Exception e2) {
            a.a.a.a.v.d.a(e2);
            return null;
        }
    }
}
