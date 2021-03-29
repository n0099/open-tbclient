package com.baidu.platform.core.a;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.base.a implements e {

    /* renamed from: b  reason: collision with root package name */
    public OnGetDistricSearchResultListener f10407b = null;

    @Override // com.baidu.platform.core.a.e
    public void a() {
        this.f9808a.lock();
        this.f10407b = null;
        this.f9808a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public void a(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        this.f9808a.lock();
        this.f10407b = onGetDistricSearchResultListener;
        this.f9808a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public boolean a(DistrictSearchOption districtSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.DISTRICT_SEARCH);
        return a(new a(districtSearchOption), this.f10407b, bVar);
    }
}
