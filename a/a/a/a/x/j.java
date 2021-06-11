package a.a.a.a.x;

import a.a.a.a.v.e;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends b {
    public j(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.x.b
    public p c(Object obj) {
        Object obj2;
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            obj2 = declaredField.get(obj);
        } catch (Exception e2) {
            a.a.a.a.y.d.a(e2);
        }
        if (obj2 == null) {
            return null;
        }
        Field declaredField2 = obj2.getClass().getDeclaredField("a");
        declaredField2.setAccessible(true);
        Object obj3 = declaredField2.get(obj2);
        if (obj3 == null) {
            return null;
        }
        Field declaredField3 = obj3.getClass().getDeclaredField("g");
        declaredField3.setAccessible(true);
        Object obj4 = declaredField3.get(obj3);
        if (obj4 == null) {
            return null;
        }
        Field declaredField4 = obj4.getClass().getSuperclass().getDeclaredField("E");
        declaredField4.setAccessible(true);
        JSONObject jSONObject = (JSONObject) declaredField4.get(obj4);
        if (jSONObject != null) {
            return a.a.a.a.a.a(jSONObject);
        }
        return null;
    }
}
