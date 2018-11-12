package com.baidu.platform.core.c;

import android.util.Log;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
/* loaded from: classes4.dex */
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
        this.a.a("uids", poiDetailSearchOption.getUids());
        this.a.a("output", NetworkDef.DataType.JSON);
        this.a.a("scope", "2");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.b();
    }
}
