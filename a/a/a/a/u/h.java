package a.a.a.a.u;

import a.a.a.a.s.e;
import android.util.Pair;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends b {
    public h(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.b
    public Pair<o, JSONObject> c(Object obj) {
        Object obj2;
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("c");
            declaredField.setAccessible(true);
            obj2 = declaredField.get(obj);
        } catch (Exception e2) {
            a.a.a.a.v.d.a(e2);
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
        Field declaredField3 = obj3.getClass().getDeclaredField("h");
        declaredField3.setAccessible(true);
        Object obj4 = declaredField3.get(obj3);
        if (obj4 != null && (obj4 instanceof String[])) {
            String[] strArr = (String[]) obj4;
            if (strArr.length == 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strArr[0]);
            return new Pair<>(a.a.a.a.a.a(jSONObject), jSONObject);
        }
        return null;
    }
}
