package com.baidu.platform.core.a;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;
/* loaded from: classes6.dex */
public class d extends com.baidu.platform.base.a implements e {

    /* renamed from: b  reason: collision with root package name */
    private OnGetDistricSearchResultListener f4482b = null;

    @Override // com.baidu.platform.core.a.e
    public void a() {
        this.f4133a.lock();
        this.f4482b = null;
        this.f4133a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public void a(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        this.f4133a.lock();
        this.f4482b = onGetDistricSearchResultListener;
        this.f4133a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public boolean a(DistrictSearchOption districtSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.DISTRICT_SEARCH);
        return a(new a(districtSearchOption), this.f4482b, bVar);
    }
}
