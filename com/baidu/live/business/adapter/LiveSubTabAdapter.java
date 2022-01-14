package com.baidu.live.business.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import c.a.x.c.a.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.Live16Ratio9ItemView;
import com.baidu.live.business.Live4Ratio5ItemView;
import com.baidu.live.business.LiveLoadMoreView;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.base.LiveFeedBaseHolder;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 D2\u00020\u0001:\u0002DEB/\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010)\u001a\u00020\u0012\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010>\u001a\u000208¢\u0006\u0004\bB\u0010CJ\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u0011J\u0017\u0010!\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u0011J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010\u0011J\u0015\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010)\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010*R&\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u000304j\b\u0012\u0004\u0012\u00020\u0003`58\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0019\u0010;\u001a\u0002088\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010:\u001a\u0004\b<\u0010=R\"\u0010>\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010:\u001a\u0004\b?\u0010=\"\u0004\b@\u0010A¨\u0006F"}, d2 = {"Lcom/baidu/live/business/adapter/LiveSubTabAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "list", "", "addNew", "(Ljava/util/List;)V", "", "getItemCount", "()I", "position", "getItemViewType", "(I)I", "Lcom/baidu/live/business/base/LiveFeedBaseHolder;", "holder", "handleHasMore", "(Lcom/baidu/live/business/base/LiveFeedBaseHolder;)V", "", "isShow", "liveRoomEntity", "Landroid/content/Context;", "context", "liveUbcLog", "(ZLcom/baidu/live/business/model/data/LiveRoomEntity;Landroid/content/Context;I)V", "onBindViewHolder", "(Lcom/baidu/live/business/base/LiveFeedBaseHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/baidu/live/business/base/LiveFeedBaseHolder;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "hasMore", "setHasMore", "(Z)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "isImmer", "Z", "()Z", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "itemViewListener", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "getItemViewListener", "()Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "setItemViewListener", "(Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;)V", "mHasMore", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mList", "Ljava/util/ArrayList;", "", "secondLevelTab", "Ljava/lang/String;", "source", "getSource", "()Ljava/lang/String;", "thirdLevelTab", "getThirdLevelTab", "setThirdLevelTab", "(Ljava/lang/String;)V", "<init>", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "ItemViewListener", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class LiveSubTabAdapter extends RecyclerView.Adapter<LiveFeedBaseHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int TYPE_FOOTER = -1;
    public static final int TYPE_GAME_16_9 = 3;
    public static final int TYPE_SHOPPING_4_5 = 1;
    public static final int TYPE_SHOW_4_5 = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<LiveRoomEntity> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34746b;

    /* renamed from: c  reason: collision with root package name */
    public b f34747c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f34748d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f34749e;

    /* renamed from: f  reason: collision with root package name */
    public final String f34750f;

    /* renamed from: g  reason: collision with root package name */
    public final String f34751g;

    /* renamed from: h  reason: collision with root package name */
    public String f34752h;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(int i2);

        void b(ViewGroup viewGroup, int i2, LiveRoomEntity liveRoomEntity);
    }

    /* loaded from: classes10.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabAdapter f34753e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LiveRoomEntity f34754f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f34755g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ LiveFeedBaseHolder f34756h;

        public c(LiveSubTabAdapter liveSubTabAdapter, LiveRoomEntity liveRoomEntity, int i2, LiveFeedBaseHolder liveFeedBaseHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabAdapter, liveRoomEntity, Integer.valueOf(i2), liveFeedBaseHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34753e = liveSubTabAdapter;
            this.f34754f = liveRoomEntity;
            this.f34755g = i2;
            this.f34756h = liveFeedBaseHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LiveRoomEntity liveRoomEntity = this.f34754f;
                String str = (liveRoomEntity == null || (str = liveRoomEntity.cmd) == null) ? "" : "";
                LiveFeedPageSdk.m("FeedItemClick: position: " + this.f34755g + "  scheme: " + str);
                LiveFeedPageSdk f2 = LiveFeedPageSdk.f();
                Intrinsics.checkNotNullExpressionValue(f2, "LiveFeedPageSdk.getInstance()");
                if (f2.g() == null || (i2 = this.f34755g) < 0 || i2 >= this.f34753e.a.size()) {
                    return;
                }
                View view2 = this.f34756h.itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
                if (view2.getContext() != null) {
                    LiveFeedPageSdk f3 = LiveFeedPageSdk.f();
                    Intrinsics.checkNotNullExpressionValue(f3, "LiveFeedPageSdk.getInstance()");
                    c.a.x.d.b.c g2 = f3.g();
                    View view3 = this.f34756h.itemView;
                    Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
                    g2.invokeScheme(view3.getContext(), str);
                    LiveSubTabAdapter liveSubTabAdapter = this.f34753e;
                    LiveRoomEntity liveRoomEntity2 = this.f34754f;
                    View view4 = this.f34756h.itemView;
                    Intrinsics.checkNotNullExpressionValue(view4, "holder.itemView");
                    Context context = view4.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
                    liveSubTabAdapter.b(false, liveRoomEntity2, context, this.f34755g);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(780576551, "Lcom/baidu/live/business/adapter/LiveSubTabAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(780576551, "Lcom/baidu/live/business/adapter/LiveSubTabAdapter;");
                return;
            }
        }
        Companion = new a(null);
    }

    public LiveSubTabAdapter(Context context, boolean z, String source, String secondLevelTab, String thirdLevelTab) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), source, secondLevelTab, thirdLevelTab};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(secondLevelTab, "secondLevelTab");
        Intrinsics.checkNotNullParameter(thirdLevelTab, "thirdLevelTab");
        this.f34748d = context;
        this.f34749e = z;
        this.f34750f = source;
        this.f34751g = secondLevelTab;
        this.f34752h = thirdLevelTab;
        this.a = new ArrayList<>();
    }

    public final void a(LiveFeedBaseHolder liveFeedBaseHolder) {
        LiveBaseItemView liveBaseItemView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, liveFeedBaseHolder) == null) && (liveBaseItemView = liveFeedBaseHolder.mRoot) != null && (liveBaseItemView instanceof LiveLoadMoreView)) {
            if (liveBaseItemView != null) {
                ((LiveLoadMoreView) liveBaseItemView).onDarkModeChange(this.f34749e);
                if (this.f34746b) {
                    LiveBaseItemView liveBaseItemView2 = liveFeedBaseHolder.mRoot;
                    if (liveBaseItemView2 != null) {
                        ((LiveLoadMoreView) liveBaseItemView2).setLoadMoreLabel(e.live_feed_page_load_more_label);
                        LiveBaseItemView liveBaseItemView3 = liveFeedBaseHolder.mRoot;
                        if (liveBaseItemView3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                        }
                        ((LiveLoadMoreView) liveBaseItemView3).setAnimViewVisibility(0);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                }
                LiveFeedPageSdk f2 = LiveFeedPageSdk.f();
                Intrinsics.checkNotNullExpressionValue(f2, "LiveFeedPageSdk.getInstance()");
                if (Intrinsics.areEqual("quanmin", f2.e())) {
                    LiveBaseItemView liveBaseItemView4 = liveFeedBaseHolder.mRoot;
                    if (liveBaseItemView4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                    }
                    ((LiveLoadMoreView) liveBaseItemView4).setLoadMoreLabel(e.live_feed_page_load_no_more_label_qm);
                } else {
                    LiveBaseItemView liveBaseItemView5 = liveFeedBaseHolder.mRoot;
                    if (liveBaseItemView5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                    }
                    ((LiveLoadMoreView) liveBaseItemView5).setLoadMoreLabel(e.live_feed_page_load_no_more_label);
                }
                LiveBaseItemView liveBaseItemView6 = liveFeedBaseHolder.mRoot;
                if (liveBaseItemView6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                }
                ((LiveLoadMoreView) liveBaseItemView6).setAnimViewVisibility(8);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
        }
    }

    public final void addNew(List<? extends LiveRoomEntity> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public final void b(boolean z, LiveRoomEntity liveRoomEntity, Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), liveRoomEntity, context, Integer.valueOf(i2)}) == null) {
            if (liveRoomEntity.needLogShow || !z) {
                c.a.x.b.f.b.c(liveRoomEntity.nid, z, !z);
                String str = this.f34749e ? "chenjinshi" : "zhibopindao";
                if (z) {
                    c.a.x.b.c.a.u(context, this.f34750f, str, i2 + 1, this.f34751g, this.f34752h, liveRoomEntity);
                } else {
                    c.a.x.b.c.a.o(context, this.f34750f, str, i2 + 1, this.f34751g, this.f34752h, liveRoomEntity);
                }
                liveRoomEntity.needLogShow = false;
            }
        }
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34748d : (Context) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<LiveRoomEntity> arrayList = this.a;
            if (arrayList == null || arrayList.isEmpty()) {
                return 0;
            }
            return this.a.size() + 1;
        }
        return invokeV.intValue;
    }

    public final b getItemViewListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34747c : (b) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 + 1 < getItemCount()) {
                return this.a.get(i2).showTpl;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34750f : (String) invokeV.objValue;
    }

    public final String getThirdLevelTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34752h : (String) invokeV.objValue;
    }

    public final boolean isImmer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34749e : invokeV.booleanValue;
    }

    public final void setHasMore(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f34746b = z;
        }
    }

    public final void setItemViewListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.f34747c = bVar;
        }
    }

    public final void setThirdLevelTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f34752h = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(LiveFeedBaseHolder holder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, holder, i2) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            int i3 = i2 + 1;
            if (i3 < getItemCount()) {
                LiveRoomEntity liveRoomEntity = this.a.get(i2);
                Intrinsics.checkNotNullExpressionValue(liveRoomEntity, "mList[position]");
                LiveRoomEntity liveRoomEntity2 = liveRoomEntity;
                holder.mRoot.setData(liveRoomEntity2, i2);
                holder.itemView.setOnClickListener(new c(this, liveRoomEntity2, i2, holder));
                b bVar = this.f34747c;
                if (bVar != null) {
                    LiveBaseItemView liveBaseItemView = holder.mRoot;
                    Intrinsics.checkNotNullExpressionValue(liveBaseItemView, "holder.mRoot");
                    bVar.b(liveBaseItemView.getVideoContainer(), i2, liveRoomEntity2);
                }
                View view = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
                b(true, liveRoomEntity2, context, i2);
            } else if (i3 == getItemCount()) {
                a(holder);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LiveFeedBaseHolder onCreateViewHolder(ViewGroup parent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, parent, i2)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i2 == -1) {
                LiveLoadMoreView liveLoadMoreView = new LiveLoadMoreView(this.f34748d);
                liveLoadMoreView.onDarkModeChange(this.f34749e);
                Unit unit = Unit.INSTANCE;
                return new LiveFeedBaseHolder(liveLoadMoreView);
            } else if (i2 == 1) {
                Live4Ratio5ItemView live4Ratio5ItemView = new Live4Ratio5ItemView(this.f34748d);
                live4Ratio5ItemView.setIsImmersion(this.f34749e);
                Unit unit2 = Unit.INSTANCE;
                return new LiveFeedBaseHolder(live4Ratio5ItemView);
            } else if (i2 != 2) {
                Live16Ratio9ItemView live16Ratio9ItemView = new Live16Ratio9ItemView(this.f34748d);
                live16Ratio9ItemView.setIsImmersion(this.f34749e);
                Unit unit3 = Unit.INSTANCE;
                return new LiveFeedBaseHolder(live16Ratio9ItemView);
            } else {
                Live4Ratio5ItemView live4Ratio5ItemView2 = new Live4Ratio5ItemView(this.f34748d);
                live4Ratio5ItemView2.setIsImmersion(this.f34749e);
                Unit unit4 = Unit.INSTANCE;
                return new LiveFeedBaseHolder(live4Ratio5ItemView2);
            }
        }
        return (LiveFeedBaseHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(LiveFeedBaseHolder holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewAttachedToWindow((LiveSubTabAdapter) holder);
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "holder.itemView.layoutParams");
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) && getItemViewType(holder.getLayoutPosition()) == -1) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
            holder.onViewAttached();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(LiveFeedBaseHolder holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewDetachedFromWindow((LiveSubTabAdapter) holder);
            holder.onViewDetached();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(LiveFeedBaseHolder holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewRecycled((LiveSubTabAdapter) holder);
            holder.onViewRecycled();
            b bVar = this.f34747c;
            if (bVar != null) {
                bVar.a(holder.getAdapterPosition());
            }
        }
    }
}
