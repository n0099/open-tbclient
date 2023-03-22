package com.baidu.live.feed.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter;
import com.baidu.live.feed.search.holder.LiveSearchHotRankBottomViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchHotRankHeaderViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchHotRankItemViewHolder;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.c90;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b%\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\n2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "release", "()V", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "data", "updateData", "(Ljava/util/List;)V", "Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", "getCallback", "()Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", "setCallback", "(Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;)V", "", "entities", "Ljava/util/List;", "<init>", "Callback", "ViewType", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveSearchHotRankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
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
        public static final int BOTTOM = 2;
        public static final int HEADER = 0;
        public static final ViewType INSTANCE = new ViewType();
        public static final int ITEM = 1;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<LiveRoomEntity> list;
        List<LiveRoomEntity> list2 = this.entities;
        if (list2 == null || list2 == null || !(!list2.isEmpty()) || (list = this.entities) == null) {
            return 0;
        }
        return list.size() + 2;
    }

    public final void release() {
        this.callback = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i != getItemCount() - 1) {
            return 1;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (viewHolder instanceof LiveSearchHotRankItemViewHolder) {
            ((LiveSearchHotRankItemViewHolder) viewHolder).c();
        }
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    public final void updateData(List<? extends LiveRoomEntity> list) {
        List<LiveRoomEntity> list2;
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int i) {
        int i2;
        final LiveRoomEntity liveRoomEntity;
        if (i < getItemCount() && viewHolder.getItemViewType() == 1 && (viewHolder instanceof LiveSearchHotRankItemViewHolder) && i - 1 >= 0) {
            List<LiveRoomEntity> list = this.entities;
            Context context = null;
            if (list != null) {
                liveRoomEntity = list.get(i2);
            } else {
                liveRoomEntity = null;
            }
            LiveSearchHotRankItemViewHolder liveSearchHotRankItemViewHolder = (LiveSearchHotRankItemViewHolder) viewHolder;
            liveSearchHotRankItemViewHolder.a(liveRoomEntity);
            liveSearchHotRankItemViewHolder.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter$onBindViewHolder$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    String str;
                    LiveSearchHotRankAdapter.Callback callback = LiveSearchHotRankAdapter.this.getCallback();
                    Context context2 = null;
                    if (callback != null) {
                        LiveRoomEntity liveRoomEntity2 = liveRoomEntity;
                        if (liveRoomEntity2 != null) {
                            str = liveRoomEntity2.cmd;
                        } else {
                            str = null;
                        }
                        callback.onItemClick(str);
                    }
                    View view3 = ((LiveSearchHotRankItemViewHolder) viewHolder).a;
                    Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
                    Context context3 = view3.getContext();
                    if (context3 != null) {
                        context2 = context3.getApplicationContext();
                    }
                    c90.I(context2, i, liveRoomEntity);
                }
            });
            if (liveRoomEntity != null && liveRoomEntity.needLogShow) {
                liveRoomEntity.needLogShow = false;
                View view2 = liveSearchHotRankItemViewHolder.a;
                Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
                Context context2 = view2.getContext();
                if (context2 != null) {
                    context = context2.getApplicationContext();
                }
                c90.J(context, i, liveRoomEntity);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 0) {
            if (i != 2) {
                return new LiveSearchHotRankItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d059a, viewGroup, false));
            }
            return new LiveSearchHotRankBottomViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0599, viewGroup, false));
        }
        return new LiveSearchHotRankHeaderViewHolder(new ImageView(viewGroup.getContext()));
    }
}
