package com.baidu.mapapi.search.district;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.platform.core.a.d;
import com.baidu.platform.core.a.e;
/* loaded from: classes2.dex */
public class DistrictSearch extends l {

    /* renamed from: a  reason: collision with root package name */
    public e f7188a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7189b = false;

    public DistrictSearch() {
        this.f7188a = null;
        this.f7188a = new d();
    }

    public static DistrictSearch newInstance() {
        BMapManager.init();
        return new DistrictSearch();
    }

    public void destroy() {
        if (this.f7189b) {
            return;
        }
        this.f7189b = true;
        this.f7188a.a();
        BMapManager.destroy();
    }

    public boolean searchDistrict(DistrictSearchOption districtSearchOption) {
        String str;
        if (this.f7188a != null) {
            if (districtSearchOption == null || (str = districtSearchOption.mCityName) == null || str.equals("")) {
                throw new IllegalArgumentException("option or city name can not be null or empty.");
            }
            return this.f7188a.a(districtSearchOption);
        }
        throw new IllegalStateException("searcher is null, please call newInstance first.");
    }

    public void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        e eVar = this.f7188a;
        if (eVar == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (onGetDistricSearchResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        eVar.a(onGetDistricSearchResultListener);
    }
}
