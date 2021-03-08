package a.a.a.a.c;

import a.a.a.a.a.e;
import android.util.Pair;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l extends c {
    public l(e.a aVar) {
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
            Field declaredField2 = obj2.getClass().getDeclaredField("a");
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            if (obj3 == null) {
                return null;
            }
            Field declaredField3 = obj3.getClass().getDeclaredField("c");
            declaredField3.setAccessible(true);
            Object obj4 = declaredField3.get(obj3);
            if (obj4 == null) {
                return null;
            }
            Field declaredField4 = obj4.getClass().getDeclaredField("h");
            declaredField4.setAccessible(true);
            Object obj5 = declaredField4.get(obj4);
            if (obj5 != null && (obj5 instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj5;
                jSONObject.toString();
                return new Pair<>(a.a.a.a.a.r(jSONObject), jSONObject);
            }
            return null;
        } catch (Exception e) {
            a.a.a.a.v.d.a(e);
            return null;
        }
    }
}
