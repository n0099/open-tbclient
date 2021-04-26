package com.baidu.platform.core.a;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.base.a implements e {

    /* renamed from: b  reason: collision with root package name */
    public OnGetDistricSearchResultListener f10333b = null;

    @Override // com.baidu.platform.core.a.e
    public void a() {
        this.f9717a.lock();
        this.f10333b = null;
        this.f9717a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public void a(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        this.f9717a.lock();
        this.f10333b = onGetDistricSearchResultListener;
        this.f9717a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public boolean a(DistrictSearchOption districtSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.DISTRICT_SEARCH);
        return a(new a(districtSearchOption), this.f10333b, bVar);
    }
}
