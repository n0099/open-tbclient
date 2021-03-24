package a.a.a.a.u;

import a.a.a.a.s.e;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c {
    public f(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.c
    public Pair<p, JSONObject> c(Object obj) {
        Object obj2;
        Method method;
        JSONObject jSONObject;
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            obj2 = declaredField.get(obj);
        } catch (Exception unused) {
            a.a.a.a.v.d.b();
        }
        if (obj2 == null) {
            return null;
        }
        Field declaredField2 = obj2.getClass().getDeclaredField("i");
        declaredField2.setAccessible(true);
        Object obj3 = declaredField2.get(obj2);
        if (obj3 == null || (method = obj3.getClass().getMethod(ExifInterface.LONGITUDE_EAST, new Class[0])) == null) {
            return null;
        }
        Object invoke = method.invoke(obj3, new Object[0]);
        if ((invoke instanceof JSONObject) && (jSONObject = (JSONObject) invoke) != null) {
            return new Pair<>(a.a.a.a.a.a(jSONObject), jSONObject);
        }
        return null;
    }
}
