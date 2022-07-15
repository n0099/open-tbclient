package com.baidu.live.business.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.Live16Ratio9ItemView;
import com.baidu.live.business.Live4Ratio5ItemView;
import com.baidu.live.business.LiveLoadMoreView;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.base.LiveFeedBaseHolder;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a90;
import com.repackage.e80;
import com.repackage.j90;
import com.repackage.u80;
import com.repackage.z80;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 D2\u00020\u0001:\u0002DEB/\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010)\u001a\u00020\u0012\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010>\u001a\u000208¢\u0006\u0004\bB\u0010CJ\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u0011J\u0017\u0010!\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u0011J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010\u0011J\u0015\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010)\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010*R&\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u000304j\b\u0012\u0004\u0012\u00020\u0003`58\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0019\u0010;\u001a\u0002088\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010:\u001a\u0004\b<\u0010=R\"\u0010>\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010:\u001a\u0004\b?\u0010=\"\u0004\b@\u0010A¨\u0006F"}, d2 = {"Lcom/baidu/live/business/adapter/LiveSubTabAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "list", "", "addNew", "(Ljava/util/List;)V", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "Lcom/baidu/live/business/base/LiveFeedBaseHolder;", "holder", "handleHasMore", "(Lcom/baidu/live/business/base/LiveFeedBaseHolder;)V", "", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "liveRoomEntity", "Landroid/content/Context;", "context", "liveUbcLog", "(ZLcom/baidu/live/business/model/data/LiveRoomEntity;Landroid/content/Context;I)V", "onBindViewHolder", "(Lcom/baidu/live/business/base/LiveFeedBaseHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/baidu/live/business/base/LiveFeedBaseHolder;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "hasMore", "setHasMore", "(Z)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "isImmer", "Z", "()Z", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "itemViewListener", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "getItemViewListener", "()Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "setItemViewListener", "(Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;)V", "mHasMore", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mList", "Ljava/util/ArrayList;", "", "secondLevelTab", "Ljava/lang/String;", "source", "getSource", "()Ljava/lang/String;", "thirdLevelTab", "getThirdLevelTab", "setThirdLevelTab", "(Ljava/lang/String;)V", "<init>", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "ItemViewListener", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveSubTabAdapter extends RecyclerView.Adapter<LiveFeedBaseHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<LiveRoomEntity> a;
    public boolean b;
    public a c;
    public final Context d;
    public final boolean e;
    public final String f;
    public final String g;
    public String h;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i);
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabAdapter a;
        public final /* synthetic */ LiveRoomEntity b;
        public final /* synthetic */ int c;
        public final /* synthetic */ LiveFeedBaseHolder d;

        public b(LiveSubTabAdapter liveSubTabAdapter, LiveRoomEntity liveRoomEntity, int i, LiveFeedBaseHolder liveFeedBaseHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabAdapter, liveRoomEntity, Integer.valueOf(i), liveFeedBaseHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveSubTabAdapter;
            this.b = liveRoomEntity;
            this.c = i;
            this.d = liveFeedBaseHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LiveRoomEntity liveRoomEntity = this.b;
                String str = "";
                String str2 = (liveRoomEntity == null || (str2 = liveRoomEntity.cmd) == null) ? "" : "";
                LiveRoomEntity liveRoomEntity2 = this.b;
                if (!TextUtils.isEmpty(liveRoomEntity2 != null ? liveRoomEntity2.beginTime : null)) {
                    String b = new z80(str2).b("params");
                    boolean z = true;
                    if (!(b == null || b.length() == 0)) {
                        try {
                            JSONObject jSONObject = new JSONObject(URLDecoder.decode(b, "UTF-8"));
                            JSONObject optJSONObject = jSONObject.optJSONObject("extLog");
                            if (optJSONObject == null) {
                                optJSONObject = new JSONObject();
                            }
                            LiveRoomEntity liveRoomEntity3 = this.b;
                            optJSONObject.put("live_union_id", liveRoomEntity3 != null ? liveRoomEntity3.beginTime : null);
                            optJSONObject.put("auto_play", "1");
                            jSONObject.put("extLog", optJSONObject);
                            String removedUrl = a90.a(str2, "params");
                            Intrinsics.checkNotNullExpressionValue(removedUrl, "removedUrl");
                            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) removedUrl, "?", 0, false, 6, (Object) null);
                            if (removedUrl != null) {
                                String substring = removedUrl.substring(0, indexOf$default);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                if (StringsKt__StringsKt.indexOf$default((CharSequence) removedUrl, "?", 0, false, 6, (Object) null) + 1 < removedUrl.length()) {
                                    str = removedUrl.substring(StringsKt__StringsKt.indexOf$default((CharSequence) removedUrl, "?", 0, false, 6, (Object) null) + 1, removedUrl.length());
                                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                }
                                String encode = URLEncoder.encode(jSONObject.toString());
                                StringBuilder sb = new StringBuilder();
                                sb.append(substring);
                                sb.append("?params=" + encode);
                                if (str.length() <= 0) {
                                    z = false;
                                }
                                if (z) {
                                    sb.append(str);
                                }
                                String sb2 = sb.toString();
                                Intrinsics.checkNotNullExpressionValue(sb2, "newScheme.toString()");
                                str2 = sb2;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                LiveFeedPageSdk.m("FeedItemClick: position: " + this.c + "  scheme: " + str2);
                LiveFeedPageSdk f = LiveFeedPageSdk.f();
                Intrinsics.checkNotNullExpressionValue(f, "LiveFeedPageSdk.getInstance()");
                if (f.g() == null || (i = this.c) < 0 || i >= this.a.a.size()) {
                    return;
                }
                View view3 = this.d.itemView;
                Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
                if (view3.getContext() != null) {
                    LiveFeedPageSdk f2 = LiveFeedPageSdk.f();
                    Intrinsics.checkNotNullExpressionValue(f2, "LiveFeedPageSdk.getInstance()");
                    j90 g = f2.g();
                    if (g != null) {
                        View view4 = this.d.itemView;
                        Intrinsics.checkNotNullExpressionValue(view4, "holder.itemView");
                        g.invokeScheme(view4.getContext(), str2);
                    }
                    LiveSubTabAdapter liveSubTabAdapter = this.a;
                    LiveRoomEntity liveRoomEntity4 = this.b;
                    View view5 = this.d.itemView;
                    Intrinsics.checkNotNullExpressionValue(view5, "holder.itemView");
                    Context context = view5.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
                    liveSubTabAdapter.h(false, liveRoomEntity4, context, this.c);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(780576551, "Lcom/baidu/live/business/adapter/LiveSubTabAdapter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(780576551, "Lcom/baidu/live/business/adapter/LiveSubTabAdapter;");
        }
    }

    public LiveSubTabAdapter(Context context, boolean z, String source, String secondLevelTab, String thirdLevelTab) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), source, secondLevelTab, thirdLevelTab};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(secondLevelTab, "secondLevelTab");
        Intrinsics.checkNotNullParameter(thirdLevelTab, "thirdLevelTab");
        this.d = context;
        this.e = z;
        this.f = source;
        this.g = secondLevelTab;
        this.h = thirdLevelTab;
        this.a = new ArrayList<>();
    }

    public final void f(List<? extends LiveRoomEntity> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public final void g(LiveFeedBaseHolder liveFeedBaseHolder) {
        LiveBaseItemView liveBaseItemView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedBaseHolder) == null) && (liveBaseItemView = liveFeedBaseHolder.a) != null && (liveBaseItemView instanceof LiveLoadMoreView)) {
            if (liveBaseItemView != null) {
                ((LiveLoadMoreView) liveBaseItemView).e(this.e);
                if (this.b) {
                    LiveBaseItemView liveBaseItemView2 = liveFeedBaseHolder.a;
                    if (liveBaseItemView2 != null) {
                        ((LiveLoadMoreView) liveBaseItemView2).setLoadMoreLabel(R.string.obfuscated_res_0x7f0f09fa);
                        LiveBaseItemView liveBaseItemView3 = liveFeedBaseHolder.a;
                        if (liveBaseItemView3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                        }
                        ((LiveLoadMoreView) liveBaseItemView3).setAnimViewVisibility(0);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                }
                LiveFeedPageSdk f = LiveFeedPageSdk.f();
                Intrinsics.checkNotNullExpressionValue(f, "LiveFeedPageSdk.getInstance()");
                if (Intrinsics.areEqual("quanmin", f.e())) {
                    LiveBaseItemView liveBaseItemView4 = liveFeedBaseHolder.a;
                    if (liveBaseItemView4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                    }
                    ((LiveLoadMoreView) liveBaseItemView4).setLoadMoreLabel(R.string.obfuscated_res_0x7f0f09fc);
                } else {
                    LiveBaseItemView liveBaseItemView5 = liveFeedBaseHolder.a;
                    if (liveBaseItemView5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                    }
                    ((LiveLoadMoreView) liveBaseItemView5).setLoadMoreLabel(R.string.obfuscated_res_0x7f0f09fb);
                }
                LiveBaseItemView liveBaseItemView6 = liveFeedBaseHolder.a;
                if (liveBaseItemView6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                }
                ((LiveLoadMoreView) liveBaseItemView6).setAnimViewVisibility(8);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
        }
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (Context) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<LiveRoomEntity> arrayList = this.a;
            if (arrayList == null || arrayList.isEmpty()) {
                return 0;
            }
            return this.a.size() + 1;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i + 1 < getItemCount()) {
                return this.a.get(i).showTpl;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final void h(boolean z, LiveRoomEntity liveRoomEntity, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), liveRoomEntity, context, Integer.valueOf(i)}) == null) {
            if (liveRoomEntity.needLogShow || !z) {
                u80.c(liveRoomEntity.nid, z, !z);
                String str = this.e ? "chenjinshi" : "zhibopindao";
                if (z) {
                    e80.v(context, this.f, str, i + 1, this.g, this.h, liveRoomEntity);
                } else {
                    e80.p(context, this.f, str, i + 1, this.g, this.h, liveRoomEntity);
                }
                liveRoomEntity.needLogShow = false;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(LiveFeedBaseHolder holder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            int i2 = i + 1;
            if (i2 < getItemCount()) {
                LiveRoomEntity liveRoomEntity = this.a.get(i);
                Intrinsics.checkNotNullExpressionValue(liveRoomEntity, "mList[position]");
                LiveRoomEntity liveRoomEntity2 = liveRoomEntity;
                holder.a.setData(liveRoomEntity2, i);
                holder.itemView.setOnClickListener(new b(this, liveRoomEntity2, i, holder));
                View view2 = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
                Context context = view2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
                h(true, liveRoomEntity2, context, i);
            } else if (i2 == getItemCount()) {
                g(holder);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public LiveFeedBaseHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i == -1) {
                LiveLoadMoreView liveLoadMoreView = new LiveLoadMoreView(this.d);
                liveLoadMoreView.e(this.e);
                Unit unit = Unit.INSTANCE;
                return new LiveFeedBaseHolder(liveLoadMoreView);
            } else if (i == 1) {
                Live4Ratio5ItemView live4Ratio5ItemView = new Live4Ratio5ItemView(this.d);
                live4Ratio5ItemView.setIsImmersion(this.e);
                Unit unit2 = Unit.INSTANCE;
                return new LiveFeedBaseHolder(live4Ratio5ItemView);
            } else if (i != 2) {
                Live16Ratio9ItemView live16Ratio9ItemView = new Live16Ratio9ItemView(this.d);
                live16Ratio9ItemView.setIsImmersion(this.e);
                Unit unit3 = Unit.INSTANCE;
                return new LiveFeedBaseHolder(live16Ratio9ItemView);
            } else {
                Live4Ratio5ItemView live4Ratio5ItemView2 = new Live4Ratio5ItemView(this.d);
                live4Ratio5ItemView2.setIsImmersion(this.e);
                Unit unit4 = Unit.INSTANCE;
                return new LiveFeedBaseHolder(live4Ratio5ItemView2);
            }
        }
        return (LiveFeedBaseHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onViewAttachedToWindow(LiveFeedBaseHolder holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewAttachedToWindow(holder);
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "holder.itemView.layoutParams");
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) && getItemViewType(holder.getLayoutPosition()) == -1) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
            holder.b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onViewDetachedFromWindow(LiveFeedBaseHolder holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewDetachedFromWindow(holder);
            holder.c();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onViewRecycled(LiveFeedBaseHolder holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewRecycled(holder);
            holder.d();
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(holder.getAdapterPosition());
            }
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.b = z;
        }
    }

    public final void o(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.h = str;
        }
    }
}
