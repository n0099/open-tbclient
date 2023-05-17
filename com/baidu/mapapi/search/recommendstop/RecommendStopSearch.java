package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
import com.baidu.platform.core.e.b;
/* loaded from: classes3.dex */
public class RecommendStopSearch extends n {
    public boolean b = false;
    public com.baidu.platform.core.e.a a = new b();

    public static RecommendStopSearch newInstance() {
        BMapManager.init();
        return new RecommendStopSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        com.baidu.platform.core.e.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
        BMapManager.destroy();
    }

    public boolean requestRecommendStop(RecommendStopSearchOption recommendStopSearchOption) {
        if (this.a != null) {
            if (recommendStopSearchOption != null && recommendStopSearchOption.getLocation() != null) {
                return this.a.a(recommendStopSearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: option or location can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RecommendStopSearch is null, please call newInstance() first.");
    }

    public void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener onGetRecommendStopResultListener) {
        com.baidu.platform.core.e.a aVar = this.a;
        if (aVar != null) {
            if (onGetRecommendStopResultListener != null) {
                aVar.a(onGetRecommendStopResultListener);
                return;
            }
            throw new IllegalStateException("BDMapSDKException: OnGetRecommendStopResultListener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RecommendStopSearch is null, please call newInstance() first.");
    }
}
