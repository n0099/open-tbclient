package com.baidu.live.feed.search.presenter;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine;", "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;", "getState", "()Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;", "state", "", "setState", "(Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;)V", "searchState", "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;", "<init>", "()V", "SearchState", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveSearchStateMachine {
    public SearchState a = SearchState.STATE_INIT;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "STATE_INIT", "STATE_INPUT", "STATE_RESULT", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public enum SearchState {
        STATE_INIT,
        STATE_INPUT,
        STATE_RESULT
    }

    public final SearchState a() {
        return this.a;
    }

    public final void b(SearchState searchState) {
        this.a = searchState;
    }
}
