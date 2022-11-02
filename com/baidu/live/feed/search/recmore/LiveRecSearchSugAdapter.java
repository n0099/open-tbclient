package com.baidu.live.feed.search.recmore;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u001a\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001f¨\u0006\""}, d2 = {"Lcom/baidu/live/feed/search/recmore/LiveRecSearchSugAdapter;", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "createAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", CriusAttrConstants.POSITION, "", "setFollowStatus", "(I)V", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSuggestListener", "(Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;)V", "", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "searchResultList", "Lcom/baidu/live/feed/search/model/data/LiveSearchSuggestion;", "suggestionList", "", "text", "setSuggestions", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "adapter", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;", "<init>", "()V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveRecSearchSugAdapter implements ILiveRecSearchSugAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveFeedSearchSuggestionAdapter adapter;
    public ILiveRecSearchSugAdapter.OnSuggestionListener listener;

    public LiveRecSearchSugAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public RecyclerView.Adapter<RecyclerView.ViewHolder> getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.adapter;
        }
        return (RecyclerView.Adapter) invokeV.objValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public RecyclerView.Adapter<RecyclerView.ViewHolder> createAdapter(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = new LiveFeedSearchSuggestionAdapter(context, "recommend");
            liveFeedSearchSuggestionAdapter.setSuggestionListener(new LiveFeedSearchSuggestionAdapter.OnSuggestionListener(this) { // from class: com.baidu.live.feed.search.recmore.LiveRecSearchSugAdapter$createAdapter$$inlined$apply$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveRecSearchSugAdapter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.listener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void jumpAuthorView(String str) {
                    ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) && onSuggestionListener != null) {
                        onSuggestionListener.jumpAuthorView(str);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.listener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResultClick(LiveSearchResultInfo liveSearchResultInfo) {
                    ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, liveSearchResultInfo) == null) && onSuggestionListener != null) {
                        onSuggestionListener.onResultClick(liveSearchResultInfo);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.listener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
                    ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveSearchResultInfo, i) == null) && onSuggestionListener != null) {
                        onSuggestionListener.onFollowClick(liveSearchResultInfo, i);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.listener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onSuggestionClick(String str, int i) {
                    ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLI(1048579, this, str, i) == null) && onSuggestionListener != null) {
                        onSuggestionListener.onSuggestionClick(str, i);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.listener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onSuggestionSelect(String str, int i) {
                    ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLI(1048580, this, str, i) == null) && onSuggestionListener != null) {
                        onSuggestionListener.onSuggestionSelect(str, i);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.listener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onUbcResult(List<? extends LiveSearchResultInfo> list, int i, String str) {
                    ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLIL(1048581, this, list, i, str) == null) && onSuggestionListener != null) {
                        onSuggestionListener.onUbcResult(list, i, str);
                    }
                }
            });
            this.adapter = liveFeedSearchSuggestionAdapter;
            return liveFeedSearchSuggestionAdapter;
        }
        return (RecyclerView.Adapter) invokeL.objValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public void setFollowStatus(int i) {
        LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (liveFeedSearchSuggestionAdapter = this.adapter) != null) {
            liveFeedSearchSuggestionAdapter.setFollowStatus(i);
        }
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public void setSuggestListener(ILiveRecSearchSugAdapter.OnSuggestionListener onSuggestionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onSuggestionListener) == null) {
            this.listener = onSuggestionListener;
        }
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchSugAdapter
    public void setSuggestions(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2, String str) {
        LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, list, list2, str) == null) && (liveFeedSearchSuggestionAdapter = this.adapter) != null) {
            liveFeedSearchSuggestionAdapter.setSuggestions(list, list2, str);
        }
    }
}
