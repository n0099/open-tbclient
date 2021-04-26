package com.baidu.platform.core.f;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.platform.base.SearchType;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.base.a implements a {

    /* renamed from: b  reason: collision with root package name */
    public OnGetSuggestionResultListener f10351b = null;

    @Override // com.baidu.platform.core.f.a
    public void a() {
        this.f9717a.lock();
        this.f10351b = null;
        this.f9717a.unlock();
    }

    @Override // com.baidu.platform.core.f.a
    public void a(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        this.f9717a.lock();
        this.f10351b = onGetSuggestionResultListener;
        this.f9717a.unlock();
    }

    @Override // com.baidu.platform.core.f.a
    public boolean a(SuggestionSearchOption suggestionSearchOption) {
        c cVar = new c();
        cVar.a(SearchType.SUGGESTION_SEARCH_TYPE);
        return a(new d(suggestionSearchOption), this.f10351b, cVar);
    }
}
