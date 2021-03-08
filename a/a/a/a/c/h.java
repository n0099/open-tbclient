package a.a.a.a.c;

import a.a.a.a.a.e;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.qq.e.ads.nativ.NativeUnifiedADDataAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h extends c {
    public h(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c.c
    public Pair<p, JSONObject> j(Object obj) {
        Method method;
        if (obj == null) {
            return null;
        }
        try {
        } catch (Exception e) {
            a.a.a.a.v.d.a(e);
        }
        if (obj instanceof NativeUnifiedADDataAdapter) {
            NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = (NativeUnifiedADDataAdapter) obj;
            Field declaredField = nativeUnifiedADDataAdapter.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(nativeUnifiedADDataAdapter);
            if (obj2 == null) {
                return null;
            }
            Field declaredField2 = obj2.getClass().getDeclaredField("r");
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            if (obj3 != null && (method = obj3.getClass().getMethod(ExifInterface.LONGITUDE_EAST, new Class[0])) != null) {
                Object invoke = method.invoke(obj3, new Object[0]);
                if (invoke instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) invoke;
                    if (jSONObject != null) {
                        return new Pair<>(a.a.a.a.a.r(jSONObject), jSONObject);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
