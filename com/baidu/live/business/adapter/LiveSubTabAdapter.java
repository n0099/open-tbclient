package com.baidu.live.business.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.Live16Ratio9ItemView;
import com.baidu.live.business.Live16Ratio9TopicView;
import com.baidu.live.business.Live4Ratio5BannerItemView;
import com.baidu.live.business.Live4Ratio5ItemView;
import com.baidu.live.business.Live4Ratio5TopicView;
import com.baidu.live.business.LiveLoadMoreView;
import com.baidu.live.business.LiveReserveHeaderView;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.base.LiveFeedBaseHolder;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.j90;
import com.baidu.tieba.kb0;
import com.baidu.tieba.zb0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001-\u0018\u0000 O2\u00020\u0001:\u0002OPB'\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010E\u001a\u00020\u0005\u0012\u0006\u0010H\u001a\u00020\u0005\u0012\u0006\u0010I\u001a\u00020\u0005¢\u0006\u0004\bM\u0010NJ)\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0017H\u0016¢\u0006\u0004\b!\u0010 J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010%\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0019\u00101\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R&\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00030Aj\b\u0012\u0004\u0012\u00020\u0003`B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0019\u0010E\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bE\u00105\u001a\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u00105R\"\u0010I\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00105\u001a\u0004\bJ\u0010G\"\u0004\bK\u0010L¨\u0006Q"}, d2 = {"Lcom/baidu/live/business/adapter/LiveSubTabAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "list", "", "curRoomId", "", "addNew", "(Ljava/util/List;Ljava/lang/String;)V", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "roomEntity", "getTopicRoomType", "(Lcom/baidu/live/business/model/data/LiveRoomEntity;)I", "Lcom/baidu/live/business/base/LiveFeedBaseHolder;", "holder", "handleHasMore", "(Lcom/baidu/live/business/base/LiveFeedBaseHolder;)V", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/baidu/live/business/base/LiveFeedBaseHolder;", "onViewAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onViewDetachedFromWindow", "onViewRecycled", "Lcom/baidu/live/business/model/data/LiveFeedConfig;", "feedConfig", "setFeedConfig", "(Lcom/baidu/live/business/model/data/LiveFeedConfig;)V", "", "hasMore", "setHasMore", "(Z)V", "updateData", "(Ljava/util/List;)V", "com/baidu/live/business/adapter/LiveSubTabAdapter$bannerListener$1", "bannerListener", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$bannerListener$1;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/lang/String;", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "itemViewListener", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "getItemViewListener", "()Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "setItemViewListener", "(Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;)V", "mFeedConfig", "Lcom/baidu/live/business/model/data/LiveFeedConfig;", "mHasMore", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mList", "Ljava/util/ArrayList;", "scene", "getScene", "()Ljava/lang/String;", "secondLevelTab", "thirdLevelTab", "getThirdLevelTab", "setThirdLevelTab", "(Ljava/lang/String;)V", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "ItemViewListener", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveSubTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public boolean b;
    public LiveFeedConfig c;
    public String d;
    public a e;
    public final Context g;
    public final String h;
    public final String i;
    public String j;
    public ArrayList<LiveRoomEntity> a = new ArrayList<>();
    public b f = new b();

    /* loaded from: classes2.dex */
    public interface a {
        void onBannerItemClick(LiveBannerEntity liveBannerEntity);

        void onBannerItemShow(LiveBannerEntity liveBannerEntity);

        void onHeaderReserveClick(String str);

        void onItemLabelClickListener(String str, int i, LiveRoomEntity liveRoomEntity);

        void onItemViewClick(LiveRoomEntity liveRoomEntity, int i);

        void onItemViewRecycled(int i);

        void onItemViewShow(LiveRoomEntity liveRoomEntity, int i);
    }

    /* loaded from: classes2.dex */
    public static final class b implements Live4Ratio5BannerItemView.c {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.live.business.Live4Ratio5BannerItemView.c
        public void a(LiveBannerEntity liveBannerEntity) {
            a g = LiveSubTabAdapter.this.g();
            if (g != null) {
                g.onBannerItemShow(liveBannerEntity);
            }
        }

        @Override // com.baidu.live.business.Live4Ratio5BannerItemView.c
        public void b(LiveBannerEntity liveBannerEntity) {
            a g = LiveSubTabAdapter.this.g();
            if (g != null) {
                g.onBannerItemClick(liveBannerEntity);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ int b;
        public final /* synthetic */ RecyclerView.ViewHolder c;

        public c(int i, RecyclerView.ViewHolder viewHolder) {
            this.b = i;
            this.c = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            a g;
            if (((LiveRoomEntity) LiveSubTabAdapter.this.a.get(this.b)).reserveHeaderInfo != null && (g = LiveSubTabAdapter.this.g()) != null) {
                LiveBaseItemView liveBaseItemView = ((LiveFeedBaseHolder) this.c).a;
                if (liveBaseItemView != null) {
                    g.onHeaderReserveClick(((LiveReserveHeaderView) liveBaseItemView).getTip());
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveReserveHeaderView");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements LiveBaseItemView.b {
        public final /* synthetic */ LiveRoomEntity b;
        public final /* synthetic */ int c;

        public d(LiveRoomEntity liveRoomEntity, int i) {
            this.b = liveRoomEntity;
            this.c = i;
        }

        @Override // com.baidu.live.business.base.LiveBaseItemView.b
        public void a(int i) {
            a g;
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) kb0.b(this.b.topicRoomList, i);
            if (liveRoomEntity != null && (g = LiveSubTabAdapter.this.g()) != null) {
                g.onItemViewClick(liveRoomEntity, this.c);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseItemView.b
        public void b(int i) {
            a g;
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) kb0.b(this.b.topicRoomList, i);
            if (liveRoomEntity != null && (g = LiveSubTabAdapter.this.g()) != null) {
                g.onItemViewShow(liveRoomEntity, this.c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ LiveRoomEntity b;
        public final /* synthetic */ int c;

        public e(LiveRoomEntity liveRoomEntity, int i) {
            this.b = liveRoomEntity;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            a g = LiveSubTabAdapter.this.g();
            if (g != null) {
                g.onItemViewClick(this.b, this.c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements LiveBaseItemView.a {
        public final /* synthetic */ int b;
        public final /* synthetic */ LiveRoomEntity c;

        public f(int i, LiveRoomEntity liveRoomEntity) {
            this.b = i;
            this.c = liveRoomEntity;
        }

        @Override // com.baidu.live.business.base.LiveBaseItemView.a
        public final void a(String it) {
            a g;
            if (!j90.a() && (g = LiveSubTabAdapter.this.g()) != null) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                g.onItemLabelClickListener(it, this.b, this.c);
            }
        }
    }

    public LiveSubTabAdapter(Context context, String str, String str2, String str3) {
        this.g = context;
        this.h = str;
        this.i = str2;
        this.j = str3;
    }

    public final int h(LiveRoomEntity liveRoomEntity) {
        int topicItemShowTpl = liveRoomEntity.getTopicItemShowTpl();
        if (topicItemShowTpl != 2 && topicItemShowTpl != 1) {
            return 6;
        }
        return 5;
    }

    public final void k(LiveFeedConfig liveFeedConfig) {
        this.c = liveFeedConfig;
    }

    public final void l(boolean z) {
        this.b = z;
    }

    public final void m(a aVar) {
        this.e = aVar;
    }

    public final void n(String str) {
        this.j = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (viewHolder instanceof LiveFeedBaseHolder) {
            ((LiveFeedBaseHolder) viewHolder).b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (viewHolder instanceof LiveFeedBaseHolder) {
            ((LiveFeedBaseHolder) viewHolder).c();
        }
        a aVar = this.e;
        if (aVar != null) {
            aVar.onItemViewRecycled(viewHolder.getAdapterPosition());
        }
    }

    public final void updateData(List<? extends LiveRoomEntity> list) {
        if (list == null) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
    }

    public static /* synthetic */ void f(LiveSubTabAdapter liveSubTabAdapter, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        liveSubTabAdapter.e(list, str);
    }

    public final void e(List<? extends LiveRoomEntity> list, String str) {
        updateData(list);
        if (!Intrinsics.areEqual(this.d, str)) {
            this.d = str;
        }
        notifyDataSetChanged();
    }

    public final a g() {
        return this.e;
    }

    public final Context getContext() {
        return this.g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<LiveRoomEntity> arrayList = this.a;
        if (arrayList != null && !arrayList.isEmpty()) {
            return this.a.size() + 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i + 1 < getItemCount()) {
            LiveRoomEntity liveRoomEntity = this.a.get(i);
            Intrinsics.checkExpressionValueIsNotNull(liveRoomEntity, "mList[position]");
            LiveRoomEntity liveRoomEntity2 = liveRoomEntity;
            if (this.a.get(i).reserveHeaderInfo != null) {
                return -2;
            }
            if (liveRoomEntity2.isTopicRoom()) {
                return h(liveRoomEntity2);
            }
            return liveRoomEntity2.showTpl;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        View view2 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkExpressionValueIsNotNull(layoutParams, "holder.itemView.layoutParams");
        if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            int layoutPosition = viewHolder.getLayoutPosition();
            if (getItemViewType(layoutPosition) == -2 || getItemViewType(layoutPosition) == -1) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
        if (viewHolder instanceof LiveFeedBaseHolder) {
            ((LiveFeedBaseHolder) viewHolder).a();
        }
    }

    public final void i(LiveFeedBaseHolder liveFeedBaseHolder) {
        if (liveFeedBaseHolder.a == null) {
            return;
        }
        if (Intrinsics.areEqual(this.h, LiveFeedPageSdk.VIDEO_BAR)) {
            LiveBaseItemView liveBaseItemView = liveFeedBaseHolder.a;
            if (liveBaseItemView != null) {
                ((LiveLoadMoreView) liveBaseItemView).setVisibility(8);
                LiveBaseItemView liveBaseItemView2 = liveFeedBaseHolder.a;
                if (liveBaseItemView2 != null) {
                    ((LiveLoadMoreView) liveBaseItemView2).d();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
        }
        LiveBaseItemView liveBaseItemView3 = liveFeedBaseHolder.a;
        if (liveBaseItemView3 instanceof LiveLoadMoreView) {
            if (liveBaseItemView3 != null) {
                ((LiveLoadMoreView) liveBaseItemView3).g(this.h);
                if (this.b) {
                    LiveBaseItemView liveBaseItemView4 = liveFeedBaseHolder.a;
                    if (liveBaseItemView4 != null) {
                        ((LiveLoadMoreView) liveBaseItemView4).setLoadMoreLabel(R.string.obfuscated_res_0x7f0f0ac5);
                        LiveBaseItemView liveBaseItemView5 = liveFeedBaseHolder.a;
                        if (liveBaseItemView5 != null) {
                            ((LiveLoadMoreView) liveBaseItemView5).setAnimViewVisibility(0);
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                }
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_QUANMIN, liveFeedPageSdk.getHost())) {
                    LiveBaseItemView liveBaseItemView6 = liveFeedBaseHolder.a;
                    if (liveBaseItemView6 != null) {
                        ((LiveLoadMoreView) liveBaseItemView6).setLoadMoreLabel(R.string.obfuscated_res_0x7f0f0ac7);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                    }
                } else {
                    LiveBaseItemView liveBaseItemView7 = liveFeedBaseHolder.a;
                    if (liveBaseItemView7 != null) {
                        ((LiveLoadMoreView) liveBaseItemView7).setLoadMoreLabel(R.string.obfuscated_res_0x7f0f0ac6);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                    }
                }
                LiveBaseItemView liveBaseItemView8 = liveFeedBaseHolder.a;
                if (liveBaseItemView8 != null) {
                    ((LiveLoadMoreView) liveBaseItemView8).setAnimViewVisibility(8);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public LiveFeedBaseHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != -2) {
            if (i != -1) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    Live16Ratio9ItemView live16Ratio9ItemView = new Live16Ratio9ItemView(this.g);
                                    live16Ratio9ItemView.setScene(this.h);
                                    live16Ratio9ItemView.setFeedConfig(this.c);
                                    return new LiveFeedBaseHolder(live16Ratio9ItemView);
                                }
                                Live16Ratio9TopicView live16Ratio9TopicView = new Live16Ratio9TopicView(this.g);
                                live16Ratio9TopicView.setScene(this.h);
                                live16Ratio9TopicView.setFeedConfig(this.c);
                                return new LiveFeedBaseHolder(live16Ratio9TopicView);
                            }
                            Live4Ratio5TopicView live4Ratio5TopicView = new Live4Ratio5TopicView(this.g);
                            live4Ratio5TopicView.setScene(this.h);
                            live4Ratio5TopicView.setFeedConfig(this.c);
                            return new LiveFeedBaseHolder(live4Ratio5TopicView);
                        }
                        Live4Ratio5BannerItemView live4Ratio5BannerItemView = new Live4Ratio5BannerItemView(this.g);
                        live4Ratio5BannerItemView.setScene(this.h);
                        live4Ratio5BannerItemView.setBannerClickListener(this.f);
                        return new LiveFeedBaseHolder(live4Ratio5BannerItemView);
                    }
                    Live4Ratio5ItemView live4Ratio5ItemView = new Live4Ratio5ItemView(this.g);
                    live4Ratio5ItemView.setScene(this.h);
                    live4Ratio5ItemView.setFeedConfig(this.c);
                    return new LiveFeedBaseHolder(live4Ratio5ItemView);
                }
                Live4Ratio5ItemView live4Ratio5ItemView2 = new Live4Ratio5ItemView(this.g);
                live4Ratio5ItemView2.setScene(this.h);
                live4Ratio5ItemView2.setFeedConfig(this.c);
                return new LiveFeedBaseHolder(live4Ratio5ItemView2);
            }
            LiveLoadMoreView liveLoadMoreView = new LiveLoadMoreView(this.g);
            liveLoadMoreView.setScene(this.h);
            return new LiveFeedBaseHolder(liveLoadMoreView);
        }
        LiveReserveHeaderView liveReserveHeaderView = new LiveReserveHeaderView(this.g);
        liveReserveHeaderView.setScene(this.h);
        zb0 f2 = zb0.f();
        Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
        liveReserveHeaderView.f(f2.r());
        return new LiveFeedBaseHolder(liveReserveHeaderView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        LiveFeedBaseHolder liveFeedBaseHolder = (LiveFeedBaseHolder) viewHolder;
        if (liveFeedBaseHolder.getItemViewType() == -2) {
            LiveBaseItemView liveBaseItemView = liveFeedBaseHolder.a;
            if (liveBaseItemView instanceof LiveReserveHeaderView) {
                if (liveBaseItemView != null) {
                    ((LiveReserveHeaderView) liveBaseItemView).setData(this.a.get(i).reserveHeaderInfo);
                    LiveBaseItemView liveBaseItemView2 = liveFeedBaseHolder.a;
                    if (liveBaseItemView2 != null) {
                        zb0 f2 = zb0.f();
                        Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
                        ((LiveReserveHeaderView) liveBaseItemView2).f(f2.r());
                        LiveBaseItemView liveBaseItemView3 = liveFeedBaseHolder.a;
                        if (liveBaseItemView3 != null) {
                            ((LiveReserveHeaderView) liveBaseItemView3).setOnClickListener(new c(i, viewHolder));
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveReserveHeaderView");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveReserveHeaderView");
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.LiveReserveHeaderView");
            }
            return;
        }
        int i2 = i + 1;
        if (i2 < getItemCount()) {
            LiveRoomEntity liveRoomEntity = this.a.get(i);
            LiveRoomEntity liveRoomEntity2 = liveRoomEntity;
            liveRoomEntity2.belongSubTab = this.i;
            liveRoomEntity2.belongThirdTab = this.j;
            Intrinsics.checkExpressionValueIsNotNull(liveRoomEntity, "mList[position].apply {\n…irdLevelTab\n            }");
            liveFeedBaseHolder.a.setData(liveRoomEntity2, i);
            liveFeedBaseHolder.a.setIsCurViewing(Intrinsics.areEqual(this.d, liveRoomEntity2.roomId));
            if (liveFeedBaseHolder.getItemViewType() != 5 && liveFeedBaseHolder.getItemViewType() != 6) {
                viewHolder.itemView.setOnClickListener(new e(liveRoomEntity2, i));
                a aVar = this.e;
                if (aVar != null) {
                    aVar.onItemViewShow(liveRoomEntity2, i);
                }
            } else {
                liveFeedBaseHolder.a.setOnTopicItemClickListener(new d(liveRoomEntity2, i));
            }
            liveFeedBaseHolder.a.setOnLabelClickListener(new f(i, liveRoomEntity2));
        } else if (i2 == getItemCount()) {
            i(liveFeedBaseHolder);
        }
    }
}
