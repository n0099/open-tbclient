package a.a.a.a.x;

import a.a.a.a.v.e;
import com.baidu.mobstat.Config;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l extends b {
    public l(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.x.b
    public p c(Object obj) {
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
            Field declaredField3 = obj3.getClass().getDeclaredField("b");
            declaredField3.setAccessible(true);
            Object obj4 = declaredField3.get(obj3);
            if (obj4 == null) {
                return null;
            }
            Field declaredField4 = obj4.getClass().getDeclaredField(Config.APP_KEY);
            declaredField4.setAccessible(true);
            Object obj5 = declaredField4.get(obj4);
            if (obj5 == null) {
                return null;
            }
            Field declaredField5 = obj5.getClass().getDeclaredField("E");
            declaredField5.setAccessible(true);
            JSONObject jSONObject = (JSONObject) declaredField5.get(obj5);
            if (jSONObject == null) {
                return null;
            }
            return a.a.a.a.a.a(jSONObject);
        } catch (Exception e2) {
            a.a.a.a.y.d.a(e2);
            return null;
        }
    }
}
