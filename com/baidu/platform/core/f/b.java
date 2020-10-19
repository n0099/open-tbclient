package com.baidu.platform.core.f;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.platform.base.SearchType;
/* loaded from: classes7.dex */
public class b extends com.baidu.platform.base.a implements a {
    private OnGetSuggestionResultListener b = null;

    @Override // com.baidu.platform.core.f.a
    public void a() {
        this.f2810a.lock();
        this.b = null;
        this.f2810a.unlock();
    }

    @Override // com.baidu.platform.core.f.a
    public void a(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        this.f2810a.lock();
        this.b = onGetSuggestionResultListener;
        this.f2810a.unlock();
    }

    @Override // com.baidu.platform.core.f.a
    public boolean a(SuggestionSearchOption suggestionSearchOption) {
        c cVar = new c();
        cVar.a(SearchType.SUGGESTION_SEARCH_TYPE);
        return a(new d(suggestionSearchOption), this.b, cVar);
    }
}
