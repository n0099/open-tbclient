package com.baidu.mapapi.search.district;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
import com.baidu.platform.core.b.d;
import com.baidu.platform.core.b.e;
/* loaded from: classes2.dex */
public class DistrictSearch extends n {
    public e a;
    public boolean b = false;

    public DistrictSearch() {
        this.a = null;
        this.a = new d();
    }

    public static DistrictSearch newInstance() {
        BMapManager.init();
        return new DistrictSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.a();
        BMapManager.destroy();
    }

    public boolean searchDistrict(DistrictSearchOption districtSearchOption) {
        String str;
        if (this.a != null) {
            if (districtSearchOption != null && (str = districtSearchOption.mCityName) != null && !str.equals("")) {
                return this.a.a(districtSearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or city name can not be null or empty.");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        e eVar = this.a;
        if (eVar != null) {
            if (onGetDistricSearchResultListener != null) {
                eVar.a(onGetDistricSearchResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }
}
