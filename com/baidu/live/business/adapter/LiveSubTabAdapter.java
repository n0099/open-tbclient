package com.baidu.live.business.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b.a.w.c.a.e;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 =2\u00020\u0001:\u0001=B/\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010)\u001a\u00020\u0012\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00107\u001a\u000201¢\u0006\u0004\b;\u0010<J\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u0011J\u0017\u0010!\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u0011J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010\u0011J\u0015\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010)\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\u0016\u0010,\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R&\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00030-j\b\u0012\u0004\u0012\u00020\u0003`.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0019\u00104\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b4\u00103\u001a\u0004\b5\u00106R\"\u00107\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00103\u001a\u0004\b8\u00106\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/baidu/live/business/adapter/LiveSubTabAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "list", "", "addNew", "(Ljava/util/List;)V", "", "getItemCount", "()I", "position", "getItemViewType", "(I)I", "Lcom/baidu/live/business/base/LiveFeedBaseHolder;", "holder", "handleHasMore", "(Lcom/baidu/live/business/base/LiveFeedBaseHolder;)V", "", "isShow", "liveRoomEntity", "Landroid/content/Context;", "context", "liveUbcLog", "(ZLcom/baidu/live/business/model/data/LiveRoomEntity;Landroid/content/Context;I)V", "onBindViewHolder", "(Lcom/baidu/live/business/base/LiveFeedBaseHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/baidu/live/business/base/LiveFeedBaseHolder;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "hasMore", "setHasMore", "(Z)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "isImmer", "Z", "()Z", "mHasMore", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mList", "Ljava/util/ArrayList;", "", "secondLevelTab", "Ljava/lang/String;", "source", "getSource", "()Ljava/lang/String;", "thirdLevelTab", "getThirdLevelTab", "setThirdLevelTab", "(Ljava/lang/String;)V", "<init>", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class LiveSubTabAdapter extends RecyclerView.Adapter<LiveFeedBaseHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int TYPE_FOOTER = -1;
    public static final int TYPE_GAME_16_9 = 3;
    public static final int TYPE_SHOPPING_4_5 = 1;
    public static final int TYPE_SHOW_4_5 = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<LiveRoomEntity> f39559a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39560b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f39561c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f39562d;

    /* renamed from: e  reason: collision with root package name */
    public final String f39563e;

    /* renamed from: f  reason: collision with root package name */
    public final String f39564f;

    /* renamed from: g  reason: collision with root package name */
    public String f39565g;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabAdapter f39566e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LiveRoomEntity f39567f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f39568g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ LiveFeedBaseHolder f39569h;

        public b(LiveSubTabAdapter liveSubTabAdapter, LiveRoomEntity liveRoomEntity, int i2, LiveFeedBaseHolder liveFeedBaseHolder) {
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
            this.f39566e = liveSubTabAdapter;
            this.f39567f = liveRoomEntity;
            this.f39568g = i2;
            this.f39569h = liveFeedBaseHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LiveRoomEntity liveRoomEntity = this.f39567f;
                String str = (liveRoomEntity == null || (str = liveRoomEntity.cmd) == null) ? "" : "";
                LiveFeedPageSdk.l("FeedItemClick: position: " + this.f39568g + "  scheme: " + str);
                LiveFeedPageSdk e2 = LiveFeedPageSdk.e();
                Intrinsics.checkNotNullExpressionValue(e2, "LiveFeedPageSdk.getInstance()");
                if (e2.f() == null || (i2 = this.f39568g) < 0 || i2 >= this.f39566e.f39559a.size()) {
                    return;
                }
                View view2 = this.f39569h.itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
                if (view2.getContext() != null) {
                    LiveFeedPageSdk e3 = LiveFeedPageSdk.e();
                    Intrinsics.checkNotNullExpressionValue(e3, "LiveFeedPageSdk.getInstance()");
                    b.a.w.d.b.b f2 = e3.f();
                    View view3 = this.f39569h.itemView;
                    Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
                    f2.invokeScheme(view3.getContext(), str);
                    LiveSubTabAdapter liveSubTabAdapter = this.f39566e;
                    LiveRoomEntity liveRoomEntity2 = this.f39567f;
                    View view4 = this.f39569h.itemView;
                    Intrinsics.checkNotNullExpressionValue(view4, "holder.itemView");
                    Context context = view4.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
                    liveSubTabAdapter.b(false, liveRoomEntity2, context, this.f39568g);
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
        this.f39561c = context;
        this.f39562d = z;
        this.f39563e = source;
        this.f39564f = secondLevelTab;
        this.f39565g = thirdLevelTab;
        this.f39559a = new ArrayList<>();
    }

    public final void a(LiveFeedBaseHolder liveFeedBaseHolder) {
        LiveBaseItemView liveBaseItemView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, liveFeedBaseHolder) == null) && (liveBaseItemView = liveFeedBaseHolder.mRoot) != null && (liveBaseItemView instanceof LiveLoadMoreView)) {
            if (liveBaseItemView != null) {
                ((LiveLoadMoreView) liveBaseItemView).onDarkModeChange(this.f39562d);
                if (this.f39560b) {
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
                LiveFeedPageSdk e2 = LiveFeedPageSdk.e();
                Intrinsics.checkNotNullExpressionValue(e2, "LiveFeedPageSdk.getInstance()");
                if (Intrinsics.areEqual("quanmin", e2.d())) {
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
        this.f39559a.clear();
        this.f39559a.addAll(list);
        notifyDataSetChanged();
    }

    public final void b(boolean z, LiveRoomEntity liveRoomEntity, Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), liveRoomEntity, context, Integer.valueOf(i2)}) == null) {
            if (liveRoomEntity.needLogShow || !z) {
                b.a.w.b.f.b.c(liveRoomEntity.nid, z, !z);
                String str = this.f39562d ? "chenjinshi" : "zhibopindao";
                if (z) {
                    b.a.w.b.c.a.s(context, this.f39563e, str, i2 + 1, this.f39564f, this.f39565g, liveRoomEntity);
                } else {
                    b.a.w.b.c.a.n(context, this.f39563e, str, i2 + 1, this.f39564f, this.f39565g, liveRoomEntity);
                }
                liveRoomEntity.needLogShow = false;
            }
        }
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39561c : (Context) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<LiveRoomEntity> arrayList = this.f39559a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size() + 1;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 + 1 < getItemCount()) {
                return this.f39559a.get(i2).showTpl;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39563e : (String) invokeV.objValue;
    }

    public final String getThirdLevelTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39565g : (String) invokeV.objValue;
    }

    public final boolean isImmer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39562d : invokeV.booleanValue;
    }

    public final void setHasMore(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f39560b = z;
        }
    }

    public final void setThirdLevelTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f39565g = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(LiveFeedBaseHolder holder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, holder, i2) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            int i3 = i2 + 1;
            if (i3 < getItemCount()) {
                LiveRoomEntity liveRoomEntity = this.f39559a.get(i2);
                Intrinsics.checkNotNullExpressionValue(liveRoomEntity, "mList[position]");
                LiveRoomEntity liveRoomEntity2 = liveRoomEntity;
                holder.mRoot.setData(liveRoomEntity2, i2);
                holder.itemView.setOnClickListener(new b(this, liveRoomEntity2, i2, holder));
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, parent, i2)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i2 == -1) {
                LiveLoadMoreView liveLoadMoreView = new LiveLoadMoreView(this.f39561c);
                liveLoadMoreView.onDarkModeChange(this.f39562d);
                Unit unit = Unit.INSTANCE;
                return new LiveFeedBaseHolder(liveLoadMoreView);
            } else if (i2 == 1) {
                Live4Ratio5ItemView live4Ratio5ItemView = new Live4Ratio5ItemView(this.f39561c);
                live4Ratio5ItemView.setIsImmersion(this.f39562d);
                Unit unit2 = Unit.INSTANCE;
                return new LiveFeedBaseHolder(live4Ratio5ItemView);
            } else if (i2 != 2) {
                Live16Ratio9ItemView live16Ratio9ItemView = new Live16Ratio9ItemView(this.f39561c);
                live16Ratio9ItemView.setIsImmersion(this.f39562d);
                Unit unit3 = Unit.INSTANCE;
                return new LiveFeedBaseHolder(live16Ratio9ItemView);
            } else {
                Live4Ratio5ItemView live4Ratio5ItemView2 = new Live4Ratio5ItemView(this.f39561c);
                live4Ratio5ItemView2.setIsImmersion(this.f39562d);
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
        if (interceptable == null || interceptable.invokeL(1048590, this, holder) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048592, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewDetachedFromWindow((LiveSubTabAdapter) holder);
            holder.onViewDetached();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(LiveFeedBaseHolder holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewRecycled((LiveSubTabAdapter) holder);
            holder.onViewRecycled();
        }
    }
}
