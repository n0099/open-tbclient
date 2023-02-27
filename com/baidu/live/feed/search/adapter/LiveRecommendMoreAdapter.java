package com.baidu.live.feed.search.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.Live16Ratio9ItemView;
import com.baidu.live.business.Live4Ratio5ItemView;
import com.baidu.live.business.base.LiveFeedBaseHolder;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter;
import com.baidu.live.feed.search.holder.LiveSearchNullDataViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchResultViewHolder;
import com.baidu.live.feed.search.holder.ShowAllViewHolder;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.jd0;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u0000 m2\u00020\u0001:\u0003mnoB\u0017\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010e\u001a\u00020'¢\u0006\u0004\bk\u0010lJ\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b!\u0010\u001fJ\r\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J5\u0010/\u001a\u00020\u00052\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u00022\u0006\u0010.\u001a\u00020\u0010¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\b¢\u0006\u0004\b4\u00102J\r\u00105\u001a\u00020\u0005¢\u0006\u0004\b5\u0010#J\u0015\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020'¢\u0006\u0004\b7\u0010*J/\u00108\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u00106\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0010¢\u0006\u0004\b8\u00109J\u001d\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020\b¢\u0006\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0019\u0010A\u001a\u00020@8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010?R\"\u0010H\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bH\u0010\u0014\"\u0004\bJ\u0010KR,\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR \u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010[R,\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010\u0007R%\u0010a\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020`0_8\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0019\u0010e\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\be\u0010F\u001a\u0004\bf\u0010gR$\u00106\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010F\u001a\u0004\bh\u0010g\"\u0004\bi\u0010*R \u0010j\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010N¨\u0006p"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "list", "", "addNew", "(Ljava/util/List;)V", "", "getFooterStatus", "()I", "getItemCount", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "getRecommendPosition", "", "isBottomView", "(I)Z", "isEmptyList", "()Z", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onViewAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onViewDetachedFromWindow", "onViewRecycled", "resetData", "()V", "Lcom/baidu/live/feed/search/holder/LiveSearchResultViewHolder;", "resultDataProcess", "(ILcom/baidu/live/feed/search/holder/LiveSearchResultViewHolder;)V", "", "roomId", "setCurrentRoom", "(Ljava/lang/String;)V", "lists", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "resultList", "isRecommend", "setData", "(Ljava/util/List;Ljava/util/List;Z)V", "setFollowStatus", "(I)V", "status", "setFooterStatus", "showMoreClick", "showNullText", "showNoResult", "showRecommend", "(Ljava/util/List;Ljava/lang/String;Z)V", "content", "num", "wordNumCheck", "(Ljava/lang/String;I)Ljava/lang/String;", "Num", "I", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentRoomId", "Ljava/lang/String;", "footerStatus", "isShowMore", "Z", "setShowMore", "(Z)V", "Ljava/util/ArrayList;", "itemNum", "Ljava/util/ArrayList;", "getItemNum", "()Ljava/util/ArrayList;", "setItemNum", "(Ljava/util/ArrayList;)V", "Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter$OnItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter$OnItemClickListener;", "getListener", "()Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter$OnItemClickListener;", "setListener", "(Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter$OnItemClickListener;)V", "", "Ljava/util/List;", "getResultList", "()Ljava/util/List;", "setResultList", "", "", "resultMap", "Ljava/util/Map;", "getResultMap", "()Ljava/util/Map;", "scene", "getScene", "()Ljava/lang/String;", "getShowNullText", "setShowNullText", "typeList", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "MoreFooterHolder", "OnItemClickListener", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveRecommendMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_TYPE_FOOTER = 6;
    public static final int ITEM_TYPE_GAME_16_9 = 5;
    public static final int ITEM_TYPE_MID = 2;
    public static final int ITEM_TYPE_NULL = 7;
    public static final int ITEM_TYPE_SEARCH = 1;
    public static final int ITEM_TYPE_SHOPPING_4_5 = 3;
    public static final int ITEM_TYPE_SHOW_4_5 = 4;
    public int Num;
    public final Context context;
    public String currentRoomId;
    public boolean isShowMore;
    public ArrayList<Integer> itemNum;
    public OnItemClickListener listener;
    public List<LiveRoomEntity> lists;
    public List<? extends LiveSearchResultInfo> resultList;
    public final String scene;
    public String showNullText;
    public int footerStatus = 1;
    public ArrayList<Integer> typeList = new ArrayList<>();
    public final Map<String, Object> resultMap = new HashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0012JG\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00182\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00182\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00182\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00182\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter$OnItemClickListener;", "Lkotlin/Any;", "", "jumpScheme", "", "jumpAuthorView", "(Ljava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "itemInfo", "", CriusAttrConstants.POSITION, "onFollowClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;I)V", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "onItemShow", "(Lcom/baidu/live/business/model/data/LiveRoomEntity;I)V", "onRecItemClick", "onRetryLoadMore", "()V", "resultInfo", "onSearchResultItemClick", "onShowMoreClick", "", "resultType", "", "lists", "resultList", "type", "onUbcResult", "(ZLjava/util/List;Ljava/util/List;ILjava/lang/String;)V", "onUbcResultClick", "(ZLjava/util/List;Ljava/util/List;I)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void jumpAuthorView(String str);

        void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i);

        void onItemShow(LiveRoomEntity liveRoomEntity, int i);

        void onRecItemClick(LiveRoomEntity liveRoomEntity, int i);

        void onRetryLoadMore();

        void onSearchResultItemClick(LiveSearchResultInfo liveSearchResultInfo, int i);

        void onShowMoreClick();

        void onUbcResult(boolean z, List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, int i, String str);

        void onUbcResultClick(boolean z, List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, int i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0019\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter$MoreFooterHolder;", "androidx/recyclerview/widget/RecyclerView$ViewHolder", "", "status", "", "setStatus", "(I)V", "Landroid/widget/TextView;", "errorView", "Landroid/widget/TextView;", "getErrorView", "()Landroid/widget/TextView;", "setErrorView", "(Landroid/widget/TextView;)V", "Landroid/view/View;", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "noMoreView", "getNoMoreView", "setNoMoreView", NativeConstants.TYPE_VIEW, "getView", "<init>", "Companion", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class MoreFooterHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int STATUS_ERROR = 4;
        public static final int STATUS_GONE = 1;
        public static final int STATUS_LOADING = 2;
        public static final int STATUS_NO_MORE = 3;
        public TextView errorView;
        public View loadingView;
        public View noMoreView;

        /* renamed from: view  reason: collision with root package name */
        public final View f1035view;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter$MoreFooterHolder$Companion;", "", "STATUS_ERROR", "I", "STATUS_GONE", "STATUS_LOADING", "STATUS_NO_MORE", "<init>", "()V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes2.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public MoreFooterHolder(View view2) {
            super(view2);
            this.f1035view = view2;
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091509);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.l…mend_more_footer_loading)");
            this.loadingView = findViewById;
            View findViewById2 = this.f1035view.findViewById(R.id.obfuscated_res_0x7f09150a);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.l…mmend_more_footer_nomore)");
            this.noMoreView = findViewById2;
            View findViewById3 = this.f1035view.findViewById(R.id.obfuscated_res_0x7f091507);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.l…ommend_more_footer_error)");
            this.errorView = (TextView) findViewById3;
        }

        public final TextView getErrorView() {
            return this.errorView;
        }

        public final View getLoadingView() {
            return this.loadingView;
        }

        public final View getNoMoreView() {
            return this.noMoreView;
        }

        public final View getView() {
            return this.f1035view;
        }

        public final void setErrorView(TextView textView) {
            this.errorView = textView;
        }

        public final void setLoadingView(View view2) {
            this.loadingView = view2;
        }

        public final void setNoMoreView(View view2) {
            this.noMoreView = view2;
        }

        public final void setStatus(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            View itemView = this.itemView;
                            Intrinsics.checkExpressionValueIsNotNull(itemView, "itemView");
                            itemView.setVisibility(0);
                            this.loadingView.setVisibility(8);
                            this.noMoreView.setVisibility(8);
                            this.errorView.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    View itemView2 = this.itemView;
                    Intrinsics.checkExpressionValueIsNotNull(itemView2, "itemView");
                    itemView2.setVisibility(0);
                    this.loadingView.setVisibility(8);
                    this.noMoreView.setVisibility(0);
                    this.errorView.setVisibility(8);
                    return;
                }
                View itemView3 = this.itemView;
                Intrinsics.checkExpressionValueIsNotNull(itemView3, "itemView");
                itemView3.setVisibility(0);
                this.loadingView.setVisibility(0);
                this.noMoreView.setVisibility(8);
                this.errorView.setVisibility(8);
                return;
            }
            View itemView4 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(itemView4, "itemView");
            itemView4.setVisibility(8);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003¨\u0006\f"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter$Companion;", "", "ITEM_TYPE_FOOTER", "I", "ITEM_TYPE_GAME_16_9", "ITEM_TYPE_MID", "ITEM_TYPE_NULL", "ITEM_TYPE_SEARCH", "ITEM_TYPE_SHOPPING_4_5", "ITEM_TYPE_SHOW_4_5", "<init>", "()V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LiveRecommendMoreAdapter(Context context, String str) {
        this.context = context;
        this.scene = str;
    }

    public final String wordNumCheck(String str, int i) {
        if (str.length() > i) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(StringHelper.STRING_MORE);
            return sb.toString();
        }
        return str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == getItemCount() - 1) {
            return 6;
        }
        ArrayList<Integer> arrayList = this.typeList;
        return ((arrayList == null || (r3 = arrayList.get(i)) == null) ? 6 : 6).intValue();
    }

    public final boolean isBottomView(int i) {
        if (getItemViewType(i) == 6) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (!(viewHolder instanceof LiveFeedBaseHolder)) {
            viewHolder = null;
        }
        LiveFeedBaseHolder liveFeedBaseHolder = (LiveFeedBaseHolder) viewHolder;
        if (liveFeedBaseHolder != null) {
            liveFeedBaseHolder.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (!(viewHolder instanceof LiveFeedBaseHolder)) {
            viewHolder = null;
        }
        LiveFeedBaseHolder liveFeedBaseHolder = (LiveFeedBaseHolder) viewHolder;
        if (liveFeedBaseHolder != null) {
            liveFeedBaseHolder.b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (!(viewHolder instanceof LiveFeedBaseHolder)) {
            viewHolder = null;
        }
        LiveFeedBaseHolder liveFeedBaseHolder = (LiveFeedBaseHolder) viewHolder;
        if (liveFeedBaseHolder != null) {
            liveFeedBaseHolder.c();
        }
    }

    public final void setCurrentRoom(String str) {
        if (!Intrinsics.areEqual(this.currentRoomId, str)) {
            this.currentRoomId = str;
            notifyDataSetChanged();
        }
    }

    public final void setFollowStatus(int i) {
        LiveSearchResultInfo liveSearchResultInfo;
        List<? extends LiveSearchResultInfo> list = this.resultList;
        if (list != null) {
            if (list != null && (liveSearchResultInfo = list.get(i)) != null) {
                liveSearchResultInfo.hasFollowed = true;
            }
            notifyDataSetChanged();
        }
    }

    public final void setFooterStatus(int i) {
        this.footerStatus = i;
        notifyItemChanged(getItemCount() - 1);
    }

    public final void setItemNum(ArrayList<Integer> arrayList) {
        this.itemNum = arrayList;
    }

    public final void setListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public final void setResultList(List<? extends LiveSearchResultInfo> list) {
        this.resultList = list;
    }

    public final void setShowMore(boolean z) {
        this.isShowMore = z;
    }

    public final void setShowNullText(String str) {
        this.showNullText = str;
    }

    public final void showNoResult(String str) {
        this.showNullText = str;
        ArrayList<Integer> arrayList = this.typeList;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<Integer> arrayList2 = this.typeList;
        if (arrayList2 != null) {
            arrayList2.add(7);
        }
        this.Num = 1;
        notifyDataSetChanged();
    }

    public final void addNew(List<? extends LiveRoomEntity> list) {
        Integer num;
        LiveRoomEntity liveRoomEntity;
        int itemCount = getItemCount();
        List<LiveRoomEntity> list2 = this.lists;
        if (list2 != null) {
            list2.addAll(list);
        }
        this.Num += list.size();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> arrayList = this.typeList;
            if (arrayList != null) {
                List<LiveRoomEntity> list3 = this.lists;
                if (list3 != null && (liveRoomEntity = list3.get(i)) != null) {
                    num = Integer.valueOf(liveRoomEntity.showTpl + 2);
                } else {
                    num = null;
                }
                arrayList.add(num);
            }
        }
        notifyItemRangeChanged(itemCount - 1, list.size());
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getFooterStatus() {
        return this.footerStatus;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Num + 1;
    }

    public final ArrayList<Integer> getItemNum() {
        return this.itemNum;
    }

    public final OnItemClickListener getListener() {
        return this.listener;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.baidu.live.business.model.data.LiveSearchResultInfo>, java.util.List<com.baidu.live.business.model.data.LiveSearchResultInfo> */
    public final List<LiveSearchResultInfo> getResultList() {
        return this.resultList;
    }

    public final Map<String, Object> getResultMap() {
        return this.resultMap;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getShowNullText() {
        return this.showNullText;
    }

    public final boolean isEmptyList() {
        List<LiveRoomEntity> list = this.lists;
        if (list != null) {
            return list.isEmpty();
        }
        return true;
    }

    public final boolean isShowMore() {
        return this.isShowMore;
    }

    public final void resetData() {
        this.lists = null;
        notifyDataSetChanged();
    }

    public final int getRecommendPosition(int i) {
        Integer num;
        Integer num2;
        ArrayList<Integer> arrayList = this.typeList;
        Integer num3 = null;
        if (arrayList != null) {
            num = arrayList.get(0);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 7 && i != 0) {
            return i - 1;
        }
        if (this.isShowMore) {
            List<? extends LiveSearchResultInfo> list = this.resultList;
            if (list != null) {
                num3 = Integer.valueOf(list.size());
            }
            if (num3 == null) {
                Intrinsics.throwNpe();
            }
            return i - num3.intValue();
        }
        List<? extends LiveSearchResultInfo> list2 = this.resultList;
        if (list2 != null) {
            num2 = Integer.valueOf(list2.size());
        } else {
            num2 = null;
        }
        if (num2 == null) {
            Intrinsics.throwNpe();
        }
        if (num2.intValue() > 3) {
            return i - 4;
        }
        List<? extends LiveSearchResultInfo> list3 = this.resultList;
        if (list3 != null) {
            num3 = Integer.valueOf(list3.size());
        }
        if (num3 == null) {
            Intrinsics.throwNpe();
        }
        return i - num3.intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        List<? extends LiveSearchResultInfo> list;
        OnItemClickListener onItemClickListener;
        final LiveRoomEntity liveRoomEntity;
        List<? extends LiveSearchResultInfo> list2;
        OnItemClickListener onItemClickListener2;
        int itemViewType = getItemViewType(i);
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                if (itemViewType != 6) {
                    if (itemViewType != 7) {
                        LiveFeedBaseHolder liveFeedBaseHolder = (LiveFeedBaseHolder) viewHolder;
                        final Ref.IntRef intRef = new Ref.IntRef();
                        int recommendPosition = getRecommendPosition(i);
                        intRef.element = recommendPosition;
                        List<LiveRoomEntity> list3 = this.lists;
                        if (list3 != null) {
                            liveRoomEntity = list3.get(recommendPosition);
                        } else {
                            liveRoomEntity = null;
                        }
                        liveFeedBaseHolder.a.setData(liveRoomEntity, intRef.element);
                        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter$onBindViewHolder$3
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                List<? extends LiveRoomEntity> list4;
                                List<LiveSearchResultInfo> resultList;
                                LiveRecommendMoreAdapter.OnItemClickListener listener;
                                list4 = LiveRecommendMoreAdapter.this.lists;
                                if (list4 != null && (resultList = LiveRecommendMoreAdapter.this.getResultList()) != null && (listener = LiveRecommendMoreAdapter.this.getListener()) != null) {
                                    listener.onUbcResult(false, list4, resultList, intRef.element, "clk");
                                }
                                LiveRecommendMoreAdapter.OnItemClickListener listener2 = LiveRecommendMoreAdapter.this.getListener();
                                if (listener2 != null) {
                                    listener2.onRecItemClick(liveRoomEntity, i);
                                }
                            }
                        });
                        List<LiveRoomEntity> list4 = this.lists;
                        if (list4 != null && (list2 = this.resultList) != null && (onItemClickListener2 = this.listener) != null) {
                            onItemClickListener2.onUbcResult(false, list4, list2, intRef.element, "show");
                            return;
                        }
                        return;
                    }
                    LiveSearchNullDataViewHolder liveSearchNullDataViewHolder = (LiveSearchNullDataViewHolder) viewHolder;
                    liveSearchNullDataViewHolder.b.setText(this.showNullText);
                    StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                    layoutParams.setFullSpan(true);
                    View view2 = liveSearchNullDataViewHolder.itemView;
                    Intrinsics.checkExpressionValueIsNotNull(view2, "nullDataHolder.itemView");
                    view2.setLayoutParams(layoutParams);
                    return;
                }
                MoreFooterHolder moreFooterHolder = (MoreFooterHolder) viewHolder;
                moreFooterHolder.setStatus(this.footerStatus);
                StaggeredGridLayoutManager.LayoutParams layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                layoutParams2.setFullSpan(true);
                View view3 = moreFooterHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view3, "footerHolder.itemView");
                view3.setLayoutParams(layoutParams2);
                return;
            }
            ShowAllViewHolder showAllViewHolder = (ShowAllViewHolder) viewHolder;
            showAllViewHolder.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter$onBindViewHolder$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    LiveRecommendMoreAdapter.this.setShowMore(true);
                    LiveRecommendMoreAdapter.this.showMoreClick();
                }
            });
            showAllViewHolder.a(i);
            StaggeredGridLayoutManager.LayoutParams layoutParams3 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
            layoutParams3.setFullSpan(true);
            View view4 = showAllViewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view4, "itemHolder.itemView");
            view4.setLayoutParams(layoutParams3);
            return;
        }
        LiveSearchResultViewHolder liveSearchResultViewHolder = (LiveSearchResultViewHolder) viewHolder;
        resultDataProcess(i, liveSearchResultViewHolder);
        liveSearchResultViewHolder.a(i);
        List<LiveRoomEntity> list5 = this.lists;
        if (list5 != null && (list = this.resultList) != null && (onItemClickListener = this.listener) != null) {
            onItemClickListener.onUbcResult(true, list5, list, i, "show");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            View view2 = View.inflate(this.context, R.layout.obfuscated_res_0x7f0d0594, null);
            Context context = this.context;
            Intrinsics.checkExpressionValueIsNotNull(view2, "view");
            return new LiveSearchResultViewHolder(context, view2, this.scene);
        } else if (i == 2) {
            return new ShowAllViewHolder(this.context, View.inflate(this.context, R.layout.obfuscated_res_0x7f0d0596, null), this.scene);
        } else if (i == 3) {
            Live4Ratio5ItemView live4Ratio5ItemView = new Live4Ratio5ItemView(this.context);
            live4Ratio5ItemView.setScene(this.scene);
            return new LiveFeedBaseHolder(live4Ratio5ItemView);
        } else if (i == 4) {
            Live4Ratio5ItemView live4Ratio5ItemView2 = new Live4Ratio5ItemView(this.context);
            live4Ratio5ItemView2.setScene(this.scene);
            return new LiveFeedBaseHolder(live4Ratio5ItemView2);
        } else if (i == 5) {
            Live16Ratio9ItemView live16Ratio9ItemView = new Live16Ratio9ItemView(this.context);
            live16Ratio9ItemView.setScene(this.scene);
            return new LiveFeedBaseHolder(live16Ratio9ItemView);
        } else if (i == 7) {
            return new LiveSearchNullDataViewHolder(View.inflate(this.context, R.layout.obfuscated_res_0x7f0d0595, null));
        } else {
            View view3 = View.inflate(this.context, R.layout.obfuscated_res_0x7f0d0593, null);
            Intrinsics.checkExpressionValueIsNotNull(view3, "view");
            return new MoreFooterHolder(view3);
        }
    }

    public final void resultDataProcess(final int i, LiveSearchResultViewHolder liveSearchResultViewHolder) {
        String str;
        String str2;
        LiveSearchResultInfo liveSearchResultInfo;
        String str3;
        String str4;
        boolean z;
        String str5;
        LiveSearchResultInfo liveSearchResultInfo2;
        LiveSearchResultInfo liveSearchResultInfo3;
        LiveSearchResultInfo liveSearchResultInfo4;
        LiveSearchResultInfo liveSearchResultInfo5;
        String str6;
        String str7;
        LiveSearchResultInfo liveSearchResultInfo6;
        String str8;
        LiveSearchResultInfo liveSearchResultInfo7;
        List<? extends LiveSearchResultInfo> list = this.resultList;
        Boolean bool = null;
        if (list != null && (liveSearchResultInfo7 = list.get(i)) != null) {
            str = liveSearchResultInfo7.description;
        } else {
            str = null;
        }
        if (str != null) {
            liveSearchResultViewHolder.g().setVisibility(0);
            liveSearchResultViewHolder.h().setVisibility(8);
            TextView g = liveSearchResultViewHolder.g();
            List<? extends LiveSearchResultInfo> list2 = this.resultList;
            if (list2 != null && (liveSearchResultInfo6 = list2.get(i)) != null && (str8 = liveSearchResultInfo6.displayName) != null) {
                str7 = wordNumCheck(str8, 8);
            } else {
                str7 = null;
            }
            g.setText(str7);
        } else {
            liveSearchResultViewHolder.g().setVisibility(8);
            liveSearchResultViewHolder.h().setVisibility(0);
            TextView h = liveSearchResultViewHolder.h();
            List<? extends LiveSearchResultInfo> list3 = this.resultList;
            if (list3 != null && (liveSearchResultInfo = list3.get(i)) != null && (str3 = liveSearchResultInfo.displayName) != null) {
                str2 = wordNumCheck(str3, 8);
            } else {
                str2 = null;
            }
            h.setText(str2);
        }
        TextView c = liveSearchResultViewHolder.c();
        List<? extends LiveSearchResultInfo> list4 = this.resultList;
        if (list4 != null && (liveSearchResultInfo5 = list4.get(i)) != null && (str6 = liveSearchResultInfo5.description) != null) {
            str4 = wordNumCheck(str6, 14);
        } else {
            str4 = null;
        }
        c.setText(str4);
        CharSequence text = liveSearchResultViewHolder.c().getText();
        if (text != null && text.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            liveSearchResultViewHolder.c().setVisibility(8);
            liveSearchResultViewHolder.g().setGravity(16);
        }
        SimpleDraweeView b = liveSearchResultViewHolder.b();
        List<? extends LiveSearchResultInfo> list5 = this.resultList;
        if (list5 != null && (liveSearchResultInfo4 = list5.get(i)) != null) {
            str5 = liveSearchResultInfo4.avatar;
        } else {
            str5 = null;
        }
        b.setImageURI(str5);
        List<? extends LiveSearchResultInfo> list6 = this.resultList;
        if (list6 != null && (liveSearchResultInfo3 = list6.get(i)) != null && liveSearchResultInfo3.hasFollowed) {
            if (Intrinsics.areEqual("recommend", this.scene)) {
                liveSearchResultViewHolder.d().setVisibility(8);
            } else {
                liveSearchResultViewHolder.d().setVisibility(0);
                liveSearchResultViewHolder.d().setText("已关注");
                liveSearchResultViewHolder.d().setTypeface(Typeface.DEFAULT);
                liveSearchResultViewHolder.d().setTextColor(jd0.f().a(liveSearchResultViewHolder.getContext(), this.scene, "color_8585852"));
                jd0 f = jd0.f();
                Intrinsics.checkExpressionValueIsNotNull(f, "UIModeUtils.getInstance()");
                String r = f.r();
                if (Intrinsics.areEqual(r, "day")) {
                    liveSearchResultViewHolder.d().setBackgroundResource(R.drawable.obfuscated_res_0x7f080d81);
                } else if (Intrinsics.areEqual(r, LiveFeedPageSdk.UI_MODE_NIGHT)) {
                    liveSearchResultViewHolder.d().setBackgroundResource(R.drawable.obfuscated_res_0x7f080d82);
                }
            }
        } else {
            liveSearchResultViewHolder.d().setVisibility(0);
            liveSearchResultViewHolder.d().setText("关注");
            liveSearchResultViewHolder.d().setTypeface(Typeface.DEFAULT_BOLD);
            liveSearchResultViewHolder.d().setTextColor(jd0.f().a(liveSearchResultViewHolder.getContext(), this.scene, "color_white3"));
            jd0 f2 = jd0.f();
            Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
            String r2 = f2.r();
            if (Intrinsics.areEqual(r2, "day")) {
                liveSearchResultViewHolder.d().setBackgroundResource(R.drawable.obfuscated_res_0x7f080d7f);
            } else if (Intrinsics.areEqual(r2, LiveFeedPageSdk.UI_MODE_NIGHT)) {
                liveSearchResultViewHolder.d().setBackgroundResource(R.drawable.obfuscated_res_0x7f080d80);
            }
        }
        liveSearchResultViewHolder.f().setVisibility(8);
        liveSearchResultViewHolder.e().setVisibility(8);
        List<? extends LiveSearchResultInfo> list7 = this.resultList;
        if (list7 != null && (liveSearchResultInfo2 = list7.get(i)) != null) {
            bool = Boolean.valueOf(liveSearchResultInfo2.hasLiving);
        }
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        if (bool.booleanValue()) {
            liveSearchResultViewHolder.f().setVisibility(0);
            liveSearchResultViewHolder.e().setVisibility(0);
            jd0 f3 = jd0.f();
            Intrinsics.checkExpressionValueIsNotNull(f3, "UIModeUtils.getInstance()");
            String r3 = f3.r();
            if (Intrinsics.areEqual(r3, "day")) {
                liveSearchResultViewHolder.f().setAnimation("lottie/liveshow_rank_avatar_live_tag_day.json");
            } else if (Intrinsics.areEqual(r3, LiveFeedPageSdk.UI_MODE_NIGHT)) {
                liveSearchResultViewHolder.f().setAnimation("lottie/liveshow_rank_avatar_live_tag_night.json");
            }
            liveSearchResultViewHolder.f().playAnimation();
        } else {
            liveSearchResultViewHolder.f().setVisibility(8);
            liveSearchResultViewHolder.e().setVisibility(8);
        }
        liveSearchResultViewHolder.i().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter$resultDataProcess$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveSearchResultInfo liveSearchResultInfo8;
                List<? extends LiveRoomEntity> list8;
                List<LiveSearchResultInfo> resultList;
                LiveRecommendMoreAdapter.OnItemClickListener listener;
                List<LiveSearchResultInfo> resultList2 = LiveRecommendMoreAdapter.this.getResultList();
                if (resultList2 != null) {
                    liveSearchResultInfo8 = resultList2.get(i);
                } else {
                    liveSearchResultInfo8 = null;
                }
                list8 = LiveRecommendMoreAdapter.this.lists;
                if (list8 != null && (resultList = LiveRecommendMoreAdapter.this.getResultList()) != null && (listener = LiveRecommendMoreAdapter.this.getListener()) != null) {
                    listener.onUbcResult(true, list8, resultList, i, "clk");
                }
                if (liveSearchResultInfo8 != null) {
                    if (liveSearchResultInfo8.hasLiving) {
                        LiveRecommendMoreAdapter.OnItemClickListener listener2 = LiveRecommendMoreAdapter.this.getListener();
                        if (listener2 != null) {
                            listener2.onSearchResultItemClick(liveSearchResultInfo8, i);
                            return;
                        }
                        return;
                    }
                    LiveRecommendMoreAdapter.OnItemClickListener listener3 = LiveRecommendMoreAdapter.this.getListener();
                    if (listener3 != null) {
                        String str9 = liveSearchResultInfo8.cmd;
                        if (str9 == null) {
                            str9 = "";
                        }
                        listener3.jumpAuthorView(str9);
                    }
                }
            }
        });
        liveSearchResultViewHolder.d().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter$resultDataProcess$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Boolean bool2;
                List<? extends LiveRoomEntity> list8;
                List<LiveSearchResultInfo> resultList;
                LiveRecommendMoreAdapter.OnItemClickListener listener;
                LiveRecommendMoreAdapter.OnItemClickListener listener2;
                List<LiveSearchResultInfo> resultList2 = LiveRecommendMoreAdapter.this.getResultList();
                if (resultList2 == null) {
                    Intrinsics.throwNpe();
                }
                LiveSearchResultInfo liveSearchResultInfo8 = resultList2.get(i);
                LiveSearchResultInfo liveSearchResultInfo9 = null;
                if (liveSearchResultInfo8 != null) {
                    bool2 = Boolean.valueOf(liveSearchResultInfo8.hasFollowed);
                } else {
                    bool2 = null;
                }
                if (bool2 == null) {
                    Intrinsics.throwNpe();
                }
                if (!bool2.booleanValue()) {
                    List<LiveSearchResultInfo> resultList3 = LiveRecommendMoreAdapter.this.getResultList();
                    if (resultList3 == null) {
                        Intrinsics.throwNpe();
                    }
                    LiveSearchResultInfo liveSearchResultInfo10 = resultList3.get(i);
                    if (liveSearchResultInfo10 != null && (listener2 = LiveRecommendMoreAdapter.this.getListener()) != null) {
                        listener2.onFollowClick(liveSearchResultInfo10, i);
                        return;
                    }
                    return;
                }
                List<LiveSearchResultInfo> resultList4 = LiveRecommendMoreAdapter.this.getResultList();
                if (resultList4 != null) {
                    liveSearchResultInfo9 = resultList4.get(i);
                }
                list8 = LiveRecommendMoreAdapter.this.lists;
                if (list8 != null && (resultList = LiveRecommendMoreAdapter.this.getResultList()) != null && (listener = LiveRecommendMoreAdapter.this.getListener()) != null) {
                    listener.onUbcResult(true, list8, resultList, i, "clk");
                }
                if (liveSearchResultInfo9 != null) {
                    if (liveSearchResultInfo9.hasLiving) {
                        LiveRecommendMoreAdapter.OnItemClickListener listener3 = LiveRecommendMoreAdapter.this.getListener();
                        if (listener3 != null) {
                            listener3.onSearchResultItemClick(liveSearchResultInfo9, i);
                            return;
                        }
                        return;
                    }
                    LiveRecommendMoreAdapter.OnItemClickListener listener4 = LiveRecommendMoreAdapter.this.getListener();
                    if (listener4 != null) {
                        String str9 = liveSearchResultInfo9.cmd;
                        if (str9 == null) {
                            str9 = "";
                        }
                        listener4.jumpAuthorView(str9);
                    }
                }
            }
        });
        StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        layoutParams.setFullSpan(true);
        View view2 = liveSearchResultViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        view2.setLayoutParams(layoutParams);
    }

    public final void setData(List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, boolean z) {
        Integer num;
        Integer num2;
        if (this.lists == null) {
            this.lists = new ArrayList();
        }
        List<LiveRoomEntity> list3 = this.lists;
        if (list3 != null) {
            list3.clear();
        }
        List<LiveRoomEntity> list4 = this.lists;
        if (list4 != null) {
            list4.addAll(list);
        }
        this.resultList = list2;
        ArrayList<Integer> arrayList = this.typeList;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<Integer> arrayList2 = this.itemNum;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        int i = 0;
        this.Num = 0;
        if (list2.size() > 3) {
            this.resultMap.put("1", Integer.valueOf(list2.size()));
            for (int i2 = 0; i2 < 3; i2++) {
                ArrayList<Integer> arrayList3 = this.typeList;
                if (arrayList3 != null) {
                    arrayList3.add(1);
                }
            }
            ArrayList<Integer> arrayList4 = this.typeList;
            if (arrayList4 != null) {
                arrayList4.add(2);
            }
            this.resultMap.put("2", 1);
            int size = list.size();
            while (i < size) {
                ArrayList<Integer> arrayList5 = this.typeList;
                if (arrayList5 != null) {
                    LiveRoomEntity liveRoomEntity = list.get(i);
                    if (liveRoomEntity != null) {
                        num2 = Integer.valueOf(liveRoomEntity.showTpl + 2);
                    } else {
                        num2 = null;
                    }
                    arrayList5.add(num2);
                }
                i++;
            }
            this.Num = list.size() + 4;
        } else {
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ArrayList<Integer> arrayList6 = this.typeList;
                if (arrayList6 != null) {
                    arrayList6.add(1);
                }
            }
            int size3 = list.size();
            while (i < size3) {
                ArrayList<Integer> arrayList7 = this.typeList;
                if (arrayList7 != null) {
                    LiveRoomEntity liveRoomEntity2 = list.get(i);
                    if (liveRoomEntity2 != null) {
                        num = Integer.valueOf(liveRoomEntity2.showTpl + 2);
                    } else {
                        num = null;
                    }
                    arrayList7.add(num);
                }
                i++;
            }
            this.Num = list.size() + list2.size();
        }
        notifyDataSetChanged();
    }

    public final void showMoreClick() {
        Integer num;
        LiveRoomEntity liveRoomEntity;
        ArrayList<Integer> arrayList = this.typeList;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<Integer> arrayList2 = this.itemNum;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        List<? extends LiveSearchResultInfo> list = this.resultList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        int size = list.size();
        List<LiveRoomEntity> list2 = this.lists;
        if (list2 == null) {
            Intrinsics.throwNpe();
        }
        this.Num = size + list2.size();
        List<? extends LiveSearchResultInfo> list3 = this.resultList;
        if (list3 == null) {
            Intrinsics.throwNpe();
        }
        int size2 = list3.size();
        for (int i = 0; i < size2; i++) {
            ArrayList<Integer> arrayList3 = this.typeList;
            if (arrayList3 != null) {
                arrayList3.add(1);
            }
        }
        List<LiveRoomEntity> list4 = this.lists;
        if (list4 == null) {
            Intrinsics.throwNpe();
        }
        int size3 = list4.size();
        for (int i2 = 0; i2 < size3; i2++) {
            ArrayList<Integer> arrayList4 = this.typeList;
            if (arrayList4 != null) {
                List<LiveRoomEntity> list5 = this.lists;
                if (list5 != null && (liveRoomEntity = list5.get(i2)) != null) {
                    num = Integer.valueOf(liveRoomEntity.showTpl + 2);
                } else {
                    num = null;
                }
                arrayList4.add(num);
            }
        }
        List<LiveRoomEntity> list6 = this.lists;
        if (list6 == null) {
            Intrinsics.throwNpe();
        }
        int size4 = list6.size();
        List<? extends LiveSearchResultInfo> list7 = this.resultList;
        if (list7 == null) {
            Intrinsics.throwNpe();
        }
        this.Num = size4 + list7.size();
        notifyDataSetChanged();
    }

    public final void showRecommend(List<? extends LiveRoomEntity> list, String str, boolean z) {
        Integer num;
        LiveRoomEntity liveRoomEntity;
        if (list != null) {
            List<LiveRoomEntity> list2 = this.lists;
            if (list2 != null) {
                list2.clear();
            }
            List<LiveRoomEntity> list3 = this.lists;
            if (list3 != null) {
                list3.addAll(list);
            }
            this.showNullText = str;
            ArrayList<Integer> arrayList = this.typeList;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.Num = list.size() + 1;
            ArrayList<Integer> arrayList2 = this.typeList;
            if (arrayList2 != null) {
                arrayList2.add(7);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> arrayList3 = this.typeList;
                if (arrayList3 != null) {
                    List<LiveRoomEntity> list4 = this.lists;
                    if (list4 != null && (liveRoomEntity = list4.get(i)) != null) {
                        num = Integer.valueOf(liveRoomEntity.showTpl + 2);
                    } else {
                        num = null;
                    }
                    arrayList3.add(num);
                }
            }
            notifyDataSetChanged();
        }
    }
}
