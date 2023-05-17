package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
/* loaded from: classes3.dex */
public class SuggestionSearch extends n {
    public boolean b = false;
    public com.baidu.platform.core.h.a a = new com.baidu.platform.core.h.b();

    public static SuggestionSearch newInstance() {
        BMapManager.init();
        return new SuggestionSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.a();
        BMapManager.destroy();
    }

    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        com.baidu.platform.core.h.a aVar = this.a;
        if (aVar != null) {
            if (suggestionSearchOption != null && suggestionSearchOption.mKeyword != null && suggestionSearchOption.mCity != null) {
                return aVar.a(suggestionSearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or keyword or city can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
    }

    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        com.baidu.platform.core.h.a aVar = this.a;
        if (aVar != null) {
            if (onGetSuggestionResultListener != null) {
                aVar.a(onGetSuggestionResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
    }
}
