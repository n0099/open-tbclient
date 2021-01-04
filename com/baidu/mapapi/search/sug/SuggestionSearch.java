package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
/* loaded from: classes15.dex */
public class SuggestionSearch extends l {

    /* renamed from: b  reason: collision with root package name */
    private boolean f3060b = false;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.platform.core.f.a f3059a = new com.baidu.platform.core.f.b();

    private SuggestionSearch() {
    }

    public static SuggestionSearch newInstance() {
        BMapManager.init();
        return new SuggestionSearch();
    }

    public void destroy() {
        if (this.f3060b) {
            return;
        }
        this.f3060b = true;
        this.f3059a.a();
        BMapManager.destroy();
    }

    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        if (this.f3059a == null) {
            throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
        }
        if (suggestionSearchOption == null || suggestionSearchOption.mKeyword == null || suggestionSearchOption.mCity == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or keyword or city can not be null");
        }
        return this.f3059a.a(suggestionSearchOption);
    }

    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        if (this.f3059a == null) {
            throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
        }
        if (onGetSuggestionResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        this.f3059a.a(onGetSuggestionResultListener);
    }
}
