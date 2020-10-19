package com.baidu.platform.core.c;

import android.util.Log;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
/* loaded from: classes7.dex */
public class e extends com.baidu.platform.base.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PoiDetailSearchOption poiDetailSearchOption) {
        a(poiDetailSearchOption);
    }

    private void a(PoiDetailSearchOption poiDetailSearchOption) {
        if (poiDetailSearchOption == null) {
            Log.e(e.class.getSimpleName(), "Option is null");
            return;
        }
        if (!poiDetailSearchOption.isSearchByUids()) {
            poiDetailSearchOption.poiUids(poiDetailSearchOption.getUid());
        }
        this.f2814a.a("uids", poiDetailSearchOption.getUids());
        this.f2814a.a("output", "json");
        this.f2814a.a("scope", "2");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.b();
    }
}
