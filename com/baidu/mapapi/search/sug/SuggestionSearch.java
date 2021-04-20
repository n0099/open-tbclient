package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
/* loaded from: classes2.dex */
public class SuggestionSearch extends l {

    /* renamed from: b  reason: collision with root package name */
    public boolean f7375b = false;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.core.f.a f7374a = new com.baidu.platform.core.f.b();

    public static SuggestionSearch newInstance() {
        BMapManager.init();
        return new SuggestionSearch();
    }

    public void destroy() {
        if (this.f7375b) {
            return;
        }
        this.f7375b = true;
        this.f7374a.a();
        BMapManager.destroy();
    }

    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        com.baidu.platform.core.f.a aVar = this.f7374a;
        if (aVar != null) {
            if (suggestionSearchOption == null || suggestionSearchOption.mKeyword == null || suggestionSearchOption.mCity == null) {
                throw new IllegalArgumentException("option or keyword or city can not be null");
            }
            return aVar.a(suggestionSearchOption);
        }
        throw new IllegalStateException("suggestionsearch is null, please call newInstance() first.");
    }

    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        com.baidu.platform.core.f.a aVar = this.f7374a;
        if (aVar == null) {
            throw new IllegalStateException("suggestionsearch is null, please call newInstance() first.");
        }
        if (onGetSuggestionResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        aVar.a(onGetSuggestionResultListener);
    }
}
