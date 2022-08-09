package com.baidu.live.feed.search.recmore;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u0000 12\u00020\u0001:\u000212J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001d\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0012H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000eH&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000eH&¢\u0006\u0004\b\"\u0010 J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012H&¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H&¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H&¢\u0006\u0004\b,\u0010-J/\u0010/\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010.\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020\u0012H&¢\u0006\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter;", "Lkotlin/Any;", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "searchResultVideoList", "", "addNew", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "createAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "getFooterStatus", "()I", CriusAttrConstants.POSITION, "", "isBottomView", "(I)Z", "isEmptyList", "()Z", "resetData", "()V", "list", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "resultList", "isRec", "setData", "(Ljava/util/List;Ljava/util/List;Z)V", "setFollowStatus", "(I)V", "status", "setFooterStatus", "showMore", "setIsShowMore", "(Z)V", "Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter$OnItemClickListener;", "listener", "setItemListener", "(Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter$OnItemClickListener;)V", "", EMABTest.TYPE_STRING, "showNoResult", "(Ljava/lang/String;)V", "showNullText", "showRecommend", "(Ljava/util/List;Ljava/lang/String;Z)V", "Companion", "OnItemClickListener", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILiveRecMoreAdapter {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int STATUS_ERROR = 4;
    public static final int STATUS_GONE = 1;
    public static final int STATUS_LOADING = 2;
    public static final int STATUS_NO_MORE = 3;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter$Companion;", "", "STATUS_ERROR", "I", "STATUS_GONE", "STATUS_LOADING", "STATUS_NO_MORE", "<init>", "()V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STATUS_ERROR = 4;
        public static final int STATUS_GONE = 1;
        public static final int STATUS_LOADING = 2;
        public static final int STATUS_NO_MORE = 3;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1388036873, "Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1388036873, "Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0011JG\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00172\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter$OnItemClickListener;", "Lkotlin/Any;", "", "jumpScheme", "", "jumpAuthorView", "(Ljava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "itemInfo", "", CriusAttrConstants.POSITION, "onFollowClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;I)V", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "onRecItemClick", "(Lcom/baidu/live/business/model/data/LiveRoomEntity;I)V", "onRetryLoadMore", "()V", "resultInfo", "onSearchResultItemClick", "onShowMoreClick", "", "resultType", "", "lists", "resultList", "type", "onUbcResult", "(ZLjava/util/List;Ljava/util/List;ILjava/lang/String;)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void jumpAuthorView(String str);

        void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i);

        void onRecItemClick(LiveRoomEntity liveRoomEntity, int i);

        void onRetryLoadMore();

        void onSearchResultItemClick(LiveSearchResultInfo liveSearchResultInfo, int i);

        void onShowMoreClick();

        void onUbcResult(boolean z, List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, int i, String str);
    }

    void addNew(List<? extends LiveRoomEntity> list);

    RecyclerView.Adapter<RecyclerView.ViewHolder> createAdapter(Context context);

    int getFooterStatus();

    boolean isBottomView(int i);

    boolean isEmptyList();

    void resetData();

    void setData(List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, boolean z);

    void setFollowStatus(int i);

    void setFooterStatus(int i);

    void setIsShowMore(boolean z);

    void setItemListener(OnItemClickListener onItemClickListener);

    void showNoResult(String str);

    void showRecommend(List<? extends LiveRoomEntity> list, String str, boolean z);
}
