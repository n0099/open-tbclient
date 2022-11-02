package com.baidu.live.feed.search.recmore;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u001a\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "createAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", CriusAttrConstants.POSITION, "", "setFollowStatus", "(I)V", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSuggestListener", "(Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;)V", "", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "searchResultList", "Lcom/baidu/live/feed/search/model/data/LiveSearchSuggestion;", "suggestionList", "", "text", "setSuggestions", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "OnSuggestionListener", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILiveRecSearchSugAdapter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\u0011J/\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;", "Lkotlin/Any;", "", "jumpScheme", "", "jumpAuthorView", "(Ljava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "itemInfo", "", CriusAttrConstants.POSITION, "onFollowClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;I)V", "onResultClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;)V", "content", "onSuggestionClick", "(Ljava/lang/String;I)V", "onSuggestionSelect", "", "resultList", "ubcType", "onUbcResult", "(Ljava/util/List;ILjava/lang/String;)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnSuggestionListener {
        void jumpAuthorView(String str);

        void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i);

        void onResultClick(LiveSearchResultInfo liveSearchResultInfo);

        void onSuggestionClick(String str, int i);

        void onSuggestionSelect(String str, int i);

        void onUbcResult(List<? extends LiveSearchResultInfo> list, int i, String str);
    }

    RecyclerView.Adapter<RecyclerView.ViewHolder> createAdapter(Context context);

    RecyclerView.Adapter<RecyclerView.ViewHolder> getAdapter();

    void setFollowStatus(int i);

    void setSuggestListener(OnSuggestionListener onSuggestionListener);

    void setSuggestions(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2, String str);
}
