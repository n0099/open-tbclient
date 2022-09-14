package com.baidu.live.feed.search.recmore;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter;
import com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u0010\u0018J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001d\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J/\u0010/\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010.\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/baidu/live/feed/search/recmore/LiveRecMoreAdapter;", "Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter;", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "searchResultVideoList", "", "addNew", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "createAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "getFooterStatus", "()I", CriusAttrConstants.POSITION, "", "isBottomView", "(I)Z", "isEmptyList", "()Z", "resetData", "()V", "list", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "resultList", "isRec", "setData", "(Ljava/util/List;Ljava/util/List;Z)V", "setFollowStatus", "(I)V", "status", "setFooterStatus", "showMore", "setIsShowMore", "(Z)V", "Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter$OnItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setItemListener", "(Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter$OnItemClickListener;)V", "", EMABTest.TYPE_STRING, "showNoResult", "(Ljava/lang/String;)V", "showNullText", "showRecommend", "(Ljava/util/List;Ljava/lang/String;Z)V", "Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter;", "adapter", "Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter;", "mListener", "Lcom/baidu/live/feed/search/recmore/ILiveRecMoreAdapter$OnItemClickListener;", "<init>", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveRecMoreAdapter implements ILiveRecMoreAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveRecommendMoreAdapter adapter;
    public ILiveRecMoreAdapter.OnItemClickListener mListener;

    public LiveRecMoreAdapter() {
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

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public void addNew(List<? extends LiveRoomEntity> list) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || (liveRecommendMoreAdapter = this.adapter) == null) {
            return;
        }
        liveRecommendMoreAdapter.addNew(list);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public RecyclerView.Adapter<RecyclerView.ViewHolder> createAdapter(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            LiveRecommendMoreAdapter liveRecommendMoreAdapter = new LiveRecommendMoreAdapter(context, "recommend");
            liveRecommendMoreAdapter.setListener(new LiveRecommendMoreAdapter.OnItemClickListener(this) { // from class: com.baidu.live.feed.search.recmore.LiveRecMoreAdapter$createAdapter$$inlined$apply$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveRecMoreAdapter this$0;

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
                    r0 = r4.this$0.mListener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void jumpAuthorView(String str) {
                    ILiveRecMoreAdapter.OnItemClickListener onItemClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || onItemClickListener == null) {
                        return;
                    }
                    onItemClickListener.jumpAuthorView(str);
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.mListener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
                    ILiveRecMoreAdapter.OnItemClickListener onItemClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveSearchResultInfo, i) == null) || onItemClickListener == null) {
                        return;
                    }
                    onItemClickListener.onFollowClick(liveSearchResultInfo, i);
                }

                @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
                public void onItemShow(LiveRoomEntity liveRoomEntity, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, liveRoomEntity, i) == null) {
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.mListener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onRecItemClick(LiveRoomEntity liveRoomEntity, int i) {
                    ILiveRecMoreAdapter.OnItemClickListener onItemClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048579, this, liveRoomEntity, i) == null) || onItemClickListener == null) {
                        return;
                    }
                    onItemClickListener.onRecItemClick(liveRoomEntity, i);
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.mListener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onRetryLoadMore() {
                    ILiveRecMoreAdapter.OnItemClickListener onItemClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || onItemClickListener == null) {
                        return;
                    }
                    onItemClickListener.onRetryLoadMore();
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.mListener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onSearchResultItemClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
                    ILiveRecMoreAdapter.OnItemClickListener onItemClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048581, this, liveSearchResultInfo, i) == null) || onItemClickListener == null) {
                        return;
                    }
                    onItemClickListener.onSearchResultItemClick(liveSearchResultInfo, i);
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.mListener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onShowMoreClick() {
                    ILiveRecMoreAdapter.OnItemClickListener onItemClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048582, this) == null) || onItemClickListener == null) {
                        return;
                    }
                    onItemClickListener.onShowMoreClick();
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r1 = r7.this$0.mListener;
                 */
                @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onUbcResult(boolean z, List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, int i, String str) {
                    ILiveRecMoreAdapter.OnItemClickListener onItemClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i), str}) == null) || onItemClickListener == null) {
                        return;
                    }
                    onItemClickListener.onUbcResult(z, list, list2, i, str);
                }

                @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
                public void onUbcResultClick(boolean z, List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) {
                    }
                }
            });
            this.adapter = liveRecommendMoreAdapter;
            return liveRecommendMoreAdapter;
        }
        return (RecyclerView.Adapter) invokeL.objValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public int getFooterStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LiveRecommendMoreAdapter liveRecommendMoreAdapter = this.adapter;
            if (liveRecommendMoreAdapter != null) {
                return liveRecommendMoreAdapter.getFooterStatus();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public boolean isBottomView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            LiveRecommendMoreAdapter liveRecommendMoreAdapter = this.adapter;
            if (liveRecommendMoreAdapter != null) {
                return liveRecommendMoreAdapter.isBottomView(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public boolean isEmptyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LiveRecommendMoreAdapter liveRecommendMoreAdapter = this.adapter;
            if (liveRecommendMoreAdapter != null) {
                return liveRecommendMoreAdapter.isEmptyList();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public void resetData() {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (liveRecommendMoreAdapter = this.adapter) == null) {
            return;
        }
        liveRecommendMoreAdapter.resetData();
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public void setData(List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, boolean z) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048582, this, list, list2, z) == null) || (liveRecommendMoreAdapter = this.adapter) == null) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        liveRecommendMoreAdapter.setData(list, list2, z);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public void setFollowStatus(int i) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (liveRecommendMoreAdapter = this.adapter) == null) {
            return;
        }
        liveRecommendMoreAdapter.setFollowStatus(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r5 != 4) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setFooterStatus(int i) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) {
            return;
        }
        int i2 = 4;
        if (i != 1) {
            if (i == 2) {
                i2 = 2;
            } else if (i == 3) {
                i2 = 3;
            }
            liveRecommendMoreAdapter = this.adapter;
            if (liveRecommendMoreAdapter == null) {
                liveRecommendMoreAdapter.setFooterStatus(i2);
                return;
            }
            return;
        }
        i2 = 1;
        liveRecommendMoreAdapter = this.adapter;
        if (liveRecommendMoreAdapter == null) {
        }
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public void setIsShowMore(boolean z) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (liveRecommendMoreAdapter = this.adapter) == null) {
            return;
        }
        liveRecommendMoreAdapter.setShowMore(z);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public void setItemListener(ILiveRecMoreAdapter.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onItemClickListener) == null) {
            this.mListener = onItemClickListener;
        }
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public void showNoResult(String str) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (liveRecommendMoreAdapter = this.adapter) == null) {
            return;
        }
        liveRecommendMoreAdapter.showNoResult(str);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecMoreAdapter
    public void showRecommend(List<? extends LiveRoomEntity> list, String str, boolean z) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048588, this, list, str, z) == null) || (liveRecommendMoreAdapter = this.adapter) == null) {
            return;
        }
        liveRecommendMoreAdapter.showRecommend(list, str, z);
    }
}
