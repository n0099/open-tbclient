package com.baidu.live.recmore;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.adapter.LiveSubTabAdapter;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.recmore.ILiveRecSubTabAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u000fJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/baidu/live/recmore/LiveRecSubTabAdapter;", "Lcom/baidu/live/recmore/ILiveRecSubTabAdapter;", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "subList", "", "addNew", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "createAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "notifyDataSetChanged", "()V", "Lcom/baidu/live/recmore/ILiveRecSubTabAdapter$ItemViewListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setItemListener", "(Lcom/baidu/live/recmore/ILiveRecSubTabAdapter$ItemViewListener;)V", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter;", "adapter", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter;", "mListener", "Lcom/baidu/live/recmore/ILiveRecSubTabAdapter$ItemViewListener;", "<init>", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveRecSubTabAdapter implements ILiveRecSubTabAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveSubTabAdapter adapter;
    public ILiveRecSubTabAdapter.ItemViewListener mListener;

    public LiveRecSubTabAdapter() {
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

    @Override // com.baidu.live.recmore.ILiveRecSubTabAdapter
    public void notifyDataSetChanged() {
        LiveSubTabAdapter liveSubTabAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (liveSubTabAdapter = this.adapter) != null) {
            liveSubTabAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecSubTabAdapter
    public void addNew(List<LiveRoomEntity> list) {
        LiveSubTabAdapter liveSubTabAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && (liveSubTabAdapter = this.adapter) != null) {
            LiveSubTabAdapter.f(liveSubTabAdapter, list, null, 2, null);
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecSubTabAdapter
    public RecyclerView.Adapter<RecyclerView.ViewHolder> createAdapter(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            LiveSubTabAdapter liveSubTabAdapter = new LiveSubTabAdapter(context, "recommend", "", "");
            liveSubTabAdapter.m(new LiveSubTabAdapter.a(this) { // from class: com.baidu.live.recmore.LiveRecSubTabAdapter$createAdapter$$inlined$apply$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveRecSubTabAdapter this$0;

                @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
                public void onBannerItemClick(LiveBannerEntity liveBannerEntity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, liveBannerEntity) == null) {
                    }
                }

                @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
                public void onBannerItemShow(LiveBannerEntity liveBannerEntity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveBannerEntity) == null) {
                    }
                }

                @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
                public void onHeaderReserveClick(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    }
                }

                public void onHeaderReserveShow(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, str) == null) {
                    }
                }

                @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
                public void onItemLabelClickListener(String str, int i, LiveRoomEntity liveRoomEntity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048580, this, str, i, liveRoomEntity) == null) {
                    }
                }

                @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
                public void onItemViewRecycled(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048582, this, i) == null) {
                    }
                }

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
                @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onItemViewClick(LiveRoomEntity liveRoomEntity, int i) {
                    ILiveRecSubTabAdapter.ItemViewListener itemViewListener;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLI(1048581, this, liveRoomEntity, i) == null) && itemViewListener != null) {
                        itemViewListener.onItemViewClick(liveRoomEntity, i);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.mListener;
                 */
                @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onItemViewShow(LiveRoomEntity liveRoomEntity, int i) {
                    ILiveRecSubTabAdapter.ItemViewListener itemViewListener;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLI(1048583, this, liveRoomEntity, i) == null) && itemViewListener != null) {
                        itemViewListener.onItemViewShow(liveRoomEntity, i);
                    }
                }
            });
            this.adapter = liveSubTabAdapter;
            return liveSubTabAdapter;
        }
        return (RecyclerView.Adapter) invokeL.objValue;
    }

    @Override // com.baidu.live.recmore.ILiveRecSubTabAdapter
    public void setItemListener(ILiveRecSubTabAdapter.ItemViewListener itemViewListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, itemViewListener) == null) {
            this.mListener = itemViewListener;
        }
    }
}
