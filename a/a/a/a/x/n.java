package a.a.a.a.x;

import a.a.a.a.v.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class n extends b {
    public n(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.x.b
    public p c(Object obj) {
        List<AdInfo> list;
        AdInfo adInfo;
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 == null || !(obj2 instanceof AdTemplate) || (list = ((AdTemplate) obj2).adInfoList) == null || list.isEmpty() || (adInfo = list.get(0)) == null) {
                return null;
            }
            return a.a.a.a.a.a(adInfo);
        } catch (Exception e2) {
            a.a.a.a.y.d.a(e2);
            return null;
        }
    }
}
