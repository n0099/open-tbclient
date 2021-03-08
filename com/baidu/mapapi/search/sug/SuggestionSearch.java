package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
/* loaded from: classes4.dex */
public class SuggestionSearch extends l {
    private boolean b = false;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.platform.core.f.a f2149a = new com.baidu.platform.core.f.b();

    private SuggestionSearch() {
    }

    public static SuggestionSearch newInstance() {
        BMapManager.init();
        return new SuggestionSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f2149a.a();
        BMapManager.destroy();
    }

    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        if (this.f2149a == null) {
            throw new IllegalStateException("suggestionsearch is null, please call newInstance() first.");
        }
        if (suggestionSearchOption == null || suggestionSearchOption.mKeyword == null || suggestionSearchOption.mCity == null) {
            throw new IllegalArgumentException("option or keyword or city can not be null");
        }
        return this.f2149a.a(suggestionSearchOption);
    }

    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        if (this.f2149a == null) {
            throw new IllegalStateException("suggestionsearch is null, please call newInstance() first.");
        }
        if (onGetSuggestionResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        this.f2149a.a(onGetSuggestionResultListener);
    }
}
