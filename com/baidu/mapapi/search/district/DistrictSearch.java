package com.baidu.mapapi.search.district;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.platform.core.a.d;
import com.baidu.platform.core.a.e;
/* loaded from: classes6.dex */
public class DistrictSearch extends l {

    /* renamed from: a  reason: collision with root package name */
    private e f2864a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2865b = false;

    DistrictSearch() {
        this.f2864a = null;
        this.f2864a = new d();
    }

    public static DistrictSearch newInstance() {
        BMapManager.init();
        return new DistrictSearch();
    }

    public void destroy() {
        if (this.f2865b) {
            return;
        }
        this.f2865b = true;
        this.f2864a.a();
        BMapManager.destroy();
    }

    public boolean searchDistrict(DistrictSearchOption districtSearchOption) {
        if (this.f2864a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (districtSearchOption == null || districtSearchOption.mCityName == null || districtSearchOption.mCityName.equals("")) {
            throw new IllegalArgumentException("option or city name can not be null or empty.");
        }
        return this.f2864a.a(districtSearchOption);
    }

    public void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        if (this.f2864a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (onGetDistricSearchResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        this.f2864a.a(onGetDistricSearchResultListener);
    }
}
