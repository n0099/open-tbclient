package com.baidu.live.feed.search.recmore;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u001a\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001f¨\u0006\""}, d2 = {"Lcom/baidu/live/feed/search/recmore/LiveRecSearchSugAdapter;", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "createAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", CriusAttrConstants.POSITION, "", "setFollowStatus", "(I)V", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSuggestListener", "(Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;)V", "", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "searchResultList", "Lcom/baidu/live/feed/search/model/data/LiveSearchSuggestion;", "suggestionList", "", "text", "setSuggestions", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "adapter", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;", "<init>", "()V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveRecSearchSugAdapter implements ILiveRecSearchSugAdapter {
    public LiveFeedSearchSuggestionAdapter adapter;
    public ILiveRecSearchSugAdapter.OnSuggestionListener listener;

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public RecyclerView.Adapter<RecyclerView.ViewHolder> getAdapter() {
        return this.adapter;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public RecyclerView.Adapter<RecyclerView.ViewHolder> createAdapter(Context context) {
        LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = new LiveFeedSearchSuggestionAdapter(context, "recommend");
        liveFeedSearchSuggestionAdapter.setSuggestionListener(new LiveFeedSearchSuggestionAdapter.OnSuggestionListener() { // from class: com.baidu.live.feed.search.recmore.LiveRecSearchSugAdapter$createAdapter$$inlined$apply$lambda$1
            @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
            public void jumpAuthorView(String str) {
                ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                onSuggestionListener = LiveRecSearchSugAdapter.this.listener;
                if (onSuggestionListener != null) {
                    onSuggestionListener.jumpAuthorView(str);
                }
            }

            @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
            public void onResultClick(LiveSearchResultInfo liveSearchResultInfo) {
                ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                onSuggestionListener = LiveRecSearchSugAdapter.this.listener;
                if (onSuggestionListener != null) {
                    onSuggestionListener.onResultClick(liveSearchResultInfo);
                }
            }

            @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
            public void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
                ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                onSuggestionListener = LiveRecSearchSugAdapter.this.listener;
                if (onSuggestionListener != null) {
                    onSuggestionListener.onFollowClick(liveSearchResultInfo, i);
                }
            }

            @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
            public void onSuggestionClick(String str, int i) {
                ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                onSuggestionListener = LiveRecSearchSugAdapter.this.listener;
                if (onSuggestionListener != null) {
                    onSuggestionListener.onSuggestionClick(str, i);
                }
            }

            @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
            public void onSuggestionSelect(String str, int i) {
                ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                onSuggestionListener = LiveRecSearchSugAdapter.this.listener;
                if (onSuggestionListener != null) {
                    onSuggestionListener.onSuggestionSelect(str, i);
                }
            }

            @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
            public void onUbcResult(List<? extends LiveSearchResultInfo> list, int i, String str) {
                ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                onSuggestionListener = LiveRecSearchSugAdapter.this.listener;
                if (onSuggestionListener != null) {
                    onSuggestionListener.onUbcResult(list, i, str);
                }
            }
        });
        this.adapter = liveFeedSearchSuggestionAdapter;
        return liveFeedSearchSuggestionAdapter;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public void setFollowStatus(int i) {
        LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = this.adapter;
        if (liveFeedSearchSuggestionAdapter != null) {
            liveFeedSearchSuggestionAdapter.setFollowStatus(i);
        }
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public void setSuggestListener(ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener) {
        this.listener = onSuggestionListener;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public void setSuggestions(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2, String str) {
        LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = this.adapter;
        if (liveFeedSearchSuggestionAdapter != null) {
            liveFeedSearchSuggestionAdapter.setSuggestions(list, list2, str);
        }
    }
}
