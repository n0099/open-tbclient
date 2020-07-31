package com.baidu.platform.core.a;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;
/* loaded from: classes10.dex */
public class d extends com.baidu.platform.base.a implements e {
    private OnGetDistricSearchResultListener b = null;

    @Override // com.baidu.platform.core.a.e
    public void a() {
        this.a.lock();
        this.b = null;
        this.a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public void a(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        this.a.lock();
        this.b = onGetDistricSearchResultListener;
        this.a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public boolean a(DistrictSearchOption districtSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.DISTRICT_SEARCH);
        return a(new a(districtSearchOption), this.b, bVar);
    }
}
