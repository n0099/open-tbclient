package com.baidu.live.feed.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter;
import com.baidu.live.feed.search.holder.LiveSearchHotRankBottomViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchHotRankHeaderViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchHotRankItemViewHolder;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.k90;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b%\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\n2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "release", "()V", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "data", "updateData", "(Ljava/util/List;)V", "Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", "getCallback", "()Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", "setCallback", "(Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;)V", "", "entities", "Ljava/util/List;", "<init>", "Callback", "ViewType", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveSearchHotRankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Callback callback;
    public List<LiveRoomEntity> entities;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", "Lkotlin/Any;", "", "cmd", "", "onItemClick", "(Ljava/lang/String;)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface Callback {
        void onItemClick(String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$ViewType;", "", "BOTTOM", "I", "HEADER", "ITEM", "<init>", "()V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class ViewType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BOTTOM = 2;
        public static final int HEADER = 0;
        public static final ViewType INSTANCE;
        public static final int ITEM = 1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(774200909, "Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$ViewType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(774200909, "Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$ViewType;");
                    return;
                }
            }
            INSTANCE = new ViewType();
        }

        public ViewType() {
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

    public LiveSearchHotRankAdapter() {
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

    public final Callback getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.callback : (Callback) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        List<LiveRoomEntity> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<LiveRoomEntity> list2 = this.entities;
            if (list2 == null || list2 == null || !(!list2.isEmpty()) || (list = this.entities) == null) {
                return 0;
            }
            return list.size() + 2;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 0) {
                return 0;
            }
            return i == getItemCount() - 1 ? 2 : 1;
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, viewHolder, i) == null) && i < getItemCount() && viewHolder.getItemViewType() == 1 && (viewHolder instanceof LiveSearchHotRankItemViewHolder) && i - 1 >= 0) {
            List<LiveRoomEntity> list = this.entities;
            final LiveRoomEntity liveRoomEntity = list != null ? list.get(i2) : null;
            LiveSearchHotRankItemViewHolder liveSearchHotRankItemViewHolder = (LiveSearchHotRankItemViewHolder) viewHolder;
            liveSearchHotRankItemViewHolder.a(liveRoomEntity);
            liveSearchHotRankItemViewHolder.a.setOnClickListener(new View.OnClickListener(this, liveRoomEntity, viewHolder, i) { // from class: com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter$onBindViewHolder$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ LiveRoomEntity $entity;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecyclerView.ViewHolder $holder;
                public final /* synthetic */ int $position;
                public final /* synthetic */ LiveSearchHotRankAdapter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, liveRoomEntity, viewHolder, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$entity = liveRoomEntity;
                    this.$holder = viewHolder;
                    this.$position = i;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        LiveSearchHotRankAdapter.Callback callback = this.this$0.getCallback();
                        if (callback != null) {
                            LiveRoomEntity liveRoomEntity2 = this.$entity;
                            callback.onItemClick(liveRoomEntity2 != null ? liveRoomEntity2.cmd : null);
                        }
                        View view3 = ((LiveSearchHotRankItemViewHolder) this.$holder).a;
                        Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
                        Context context = view3.getContext();
                        k90.I(context != null ? context.getApplicationContext() : null, this.$position, this.$entity);
                    }
                }
            });
            if (liveRoomEntity == null || !liveRoomEntity.needLogShow) {
                return;
            }
            liveRoomEntity.needLogShow = false;
            View view2 = liveSearchHotRankItemViewHolder.a;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            Context context = view2.getContext();
            k90.J(context != null ? context.getApplicationContext() : null, i, liveRoomEntity);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            if (i != 0) {
                if (i != 2) {
                    return new LiveSearchHotRankItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0557, viewGroup, false));
                }
                return new LiveSearchHotRankBottomViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0556, viewGroup, false));
            }
            return new LiveSearchHotRankHeaderViewHolder(new ImageView(viewGroup.getContext()));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viewHolder) == null) {
            super.onViewRecycled(viewHolder);
            if (viewHolder instanceof LiveSearchHotRankItemViewHolder) {
                ((LiveSearchHotRankItemViewHolder) viewHolder).c();
            }
        }
    }

    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.callback = null;
        }
    }

    public final void setCallback(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, callback) == null) {
            this.callback = callback;
        }
    }

    public final void updateData(List<? extends LiveRoomEntity> list) {
        List<LiveRoomEntity> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            if (this.entities == null) {
                this.entities = new ArrayList();
            }
            List<LiveRoomEntity> list3 = this.entities;
            if (list3 != null) {
                list3.clear();
            }
            if (list != null && (list2 = this.entities) != null) {
                list2.addAll(list);
            }
            notifyDataSetChanged();
        }
    }
}
