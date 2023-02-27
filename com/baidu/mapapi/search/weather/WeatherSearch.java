package com.baidu.mapapi.search.weather;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
/* loaded from: classes2.dex */
public class WeatherSearch extends n {
    public com.baidu.platform.core.i.a a = new com.baidu.platform.core.i.e();

    public static WeatherSearch newInstance() {
        BMapManager.init();
        return new WeatherSearch();
    }

    public void destroy() {
        com.baidu.platform.core.i.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
        BMapManager.destroy();
    }

    public boolean request(WeatherSearchOption weatherSearchOption) {
        com.baidu.platform.core.i.a aVar = this.a;
        if (aVar != null) {
            if (weatherSearchOption != null) {
                return aVar.a(weatherSearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public void setWeatherSearchResultListener(OnGetWeatherResultListener onGetWeatherResultListener) {
        com.baidu.platform.core.i.a aVar = this.a;
        if (aVar != null) {
            if (onGetWeatherResultListener != null) {
                aVar.a(onGetWeatherResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }
}
