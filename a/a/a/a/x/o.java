package a.a.a.a.x;

import a.a.a.a.v.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b {
    public o(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.x.b
    public p c(Object obj) {
        List<AdTemplate> list;
        AdInfo adInfo;
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null && (obj2 instanceof AdResultData) && (list = ((AdResultData) obj2).adTemplateList) != null && !list.isEmpty()) {
                AdTemplate adTemplate = list.get(0);
                List<AdInfo> list2 = adTemplate == null ? null : adTemplate.adInfoList;
                if (list2 == null || list2.isEmpty() || (adInfo = list2.get(0)) == null) {
                    return null;
                }
                return a.a.a.a.a.a(adInfo);
            }
            return null;
        } catch (Exception e2) {
            a.a.a.a.y.d.a(e2);
            return null;
        }
    }
}
