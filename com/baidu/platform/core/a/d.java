package com.baidu.platform.core.a;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.base.a implements e {

    /* renamed from: b  reason: collision with root package name */
    public OnGetDistricSearchResultListener f9369b = null;

    @Override // com.baidu.platform.core.a.e
    public void a() {
        this.f9338a.lock();
        this.f9369b = null;
        this.f9338a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public void a(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        this.f9338a.lock();
        this.f9369b = onGetDistricSearchResultListener;
        this.f9338a.unlock();
    }

    @Override // com.baidu.platform.core.a.e
    public boolean a(DistrictSearchOption districtSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.DISTRICT_SEARCH);
        return a(new a(districtSearchOption), this.f9369b, bVar);
    }
}
