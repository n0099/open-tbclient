package com.baidu.platform.core.f;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.platform.base.SearchType;
/* loaded from: classes15.dex */
public class b extends com.baidu.platform.base.a implements a {

    /* renamed from: b  reason: collision with root package name */
    private OnGetSuggestionResultListener f4777b = null;

    @Override // com.baidu.platform.core.f.a
    public void a() {
        this.f4170a.lock();
        this.f4777b = null;
        this.f4170a.unlock();
    }

    @Override // com.baidu.platform.core.f.a
    public void a(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        this.f4170a.lock();
        this.f4777b = onGetSuggestionResultListener;
        this.f4170a.unlock();
    }

    @Override // com.baidu.platform.core.f.a
    public boolean a(SuggestionSearchOption suggestionSearchOption) {
        c cVar = new c();
        cVar.a(SearchType.SUGGESTION_SEARCH_TYPE);
        return a(new d(suggestionSearchOption), this.f4777b, cVar);
    }
}
