package a.a.a.a.u;

import a.a.a.a.s.e;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.qq.e.ads.nativ.NativeUnifiedADDataAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends c {
    public h(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.c
    public Pair<p, JSONObject> c(Object obj) {
        Method method;
        JSONObject jSONObject;
        if (obj == null) {
            return null;
        }
        try {
        } catch (Exception e2) {
            a.a.a.a.v.d.a(e2);
        }
        if (obj instanceof NativeUnifiedADDataAdapter) {
            NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = (NativeUnifiedADDataAdapter) obj;
            Field declaredField = nativeUnifiedADDataAdapter.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(nativeUnifiedADDataAdapter);
            if (obj2 == null) {
                return null;
            }
            Field declaredField2 = obj2.getClass().getDeclaredField(r.f7664a);
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
        return null;
    }
}
