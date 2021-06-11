package a.a.a.a.x;

import a.a.a.a.v.e;
import com.qq.e.ads.nativ.NativeUnifiedADDataAdapter;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends b {
    public h(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.x.b
    public p c(Object obj) {
        Field declaredField;
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof NativeUnifiedADDataAdapter) {
                NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = (NativeUnifiedADDataAdapter) obj;
                Field declaredField2 = nativeUnifiedADDataAdapter.getClass().getDeclaredField("a");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(nativeUnifiedADDataAdapter);
                if (obj2 == null) {
                    return null;
                }
                Field declaredField3 = obj2.getClass().getDeclaredField("t");
                declaredField3.setAccessible(true);
                Object obj3 = declaredField3.get(obj2);
                if (obj3 == null || (declaredField = obj3.getClass().getSuperclass().getDeclaredField("E")) == null) {
                    return null;
                }
                declaredField.setAccessible(true);
                Object obj4 = declaredField.get(obj3);
                if (obj4 instanceof JSONObject) {
                    return a.a.a.a.a.a((JSONObject) obj4);
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            a.a.a.a.y.d.a(e2);
            return null;
        }
    }
}
