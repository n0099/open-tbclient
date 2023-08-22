package com.baidu.searchbox.live.list.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.list.controller.RecyleController;
import com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixAudioFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixConsultFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixMediaFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixNewMediaFakeShell;
import com.baidu.searchbox.live.shell.list.template.MixShopFakeShell;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.searchbox.live.widget.PagerLayoutManager;
import com.baidu.searchbox.live.widget.PagerRecyclerView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u0001:\u0003HIJB'\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\bF\u0010GJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0013J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\n !*\u0004\u0018\u00010 0 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0019\u0010-\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u00105\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u00104R\u0019\u00107\u001a\u0002068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010E\u001a\u00020A8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010&\u001a\u0004\bC\u0010D¨\u0006K"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/RecyleController;", "Lcom/baidu/searchbox/live/list/controller/IListManager;", "", "sizeBefore", "", DownloadStatisticConstants.UBC_VALUE_CLEAR, "(I)V", "Landroid/view/View;", "createView", "()Landroid/view/View;", "", "handleClosedLiveRoom", "()Ljava/util/Set;", "", "", "roomIdList", "onCloseRoom", "(Ljava/util/List;)V", MissionEvent.MESSAGE_DESTROY, "()V", "size", "onListChange", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "itemModel", "resetCurRoom", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "scrollToNextLiveRoom", "scrollToPreLiveRoom", "", "isCanScroll", "setIsScrollable", "(Z)V", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "Lcom/baidu/searchbox/live/list/controller/RecyleController$ListAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getAdapter", "()Lcom/baidu/searchbox/live/list/controller/RecyleController$ListAdapter;", "adapter", "closeRoomIdList", "Ljava/util/List;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/baidu/searchbox/live/widget/PagerLayoutManager;", "layoutManger$delegate", "getLayoutManger", "()Lcom/baidu/searchbox/live/widget/PagerLayoutManager;", "layoutManger", "Lcom/baidu/searchbox/live/list/controller/ListController;", "listController", "Lcom/baidu/searchbox/live/list/controller/ListController;", "getListController", "()Lcom/baidu/searchbox/live/list/controller/ListController;", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "Lcom/baidu/searchbox/live/widget/PagerRecyclerView;", "recyclerView$delegate", "getRecyclerView", "()Lcom/baidu/searchbox/live/widget/PagerRecyclerView;", "recyclerView", "<init>", "(Lcom/baidu/searchbox/live/list/controller/ListController;Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "Companion", "ListAdapter", "LiveHolder", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class RecyleController implements IListManager {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(RecyleController.class), "recyclerView", "getRecyclerView()Lcom/baidu/searchbox/live/widget/PagerRecyclerView;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(RecyleController.class), "layoutManger", "getLayoutManger()Lcom/baidu/searchbox/live/widget/PagerLayoutManager;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(RecyleController.class), "adapter", "getAdapter()Lcom/baidu/searchbox/live/list/controller/RecyleController$ListAdapter;"))};
    public static final Companion Companion = new Companion(null);
    public static final int LIVE_TYPE_AUDIO = 7;
    public static final int LIVE_TYPE_CONSULT = 5;
    public static final int LIVE_TYPE_DATE = 8;
    public static final int LIVE_TYPE_MEDIA = 0;
    public static final int LIVE_TYPE_NEW_MEDIA = 3;
    public static final int LIVE_TYPE_SHOPPING = 4;
    public static final int LIVE_TYPE_SHOW = 1;
    public static final int LIVE_TYPE_YY = 6;
    public static final int TYPE_CACHE_SIZE = 2;
    public final Context context;
    public final ListController listController;
    public final IMixActivityInterface mixActivity;
    public final MiniUniqueId mixUniqueId;
    public AbConfigService abService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
    public final List<String> closeRoomIdList = new ArrayList();
    public final Lazy recyclerView$delegate = LazyKt__LazyJVMKt.lazy(new RecyleController$recyclerView$2(this));
    public final Lazy layoutManger$delegate = LazyKt__LazyJVMKt.lazy(new RecyleController$layoutManger$2(this));
    public final Lazy adapter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ListAdapter>() { // from class: com.baidu.searchbox.live.list.controller.RecyleController$adapter$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RecyleController.ListAdapter invoke() {
            MiniUniqueId miniUniqueId;
            IMixActivityInterface iMixActivityInterface;
            Context context = RecyleController.this.getContext();
            List<LiveContainer.LiveItemModel> itemData = RecyleController.this.getListController().getItemData();
            miniUniqueId = RecyleController.this.mixUniqueId;
            List<WeakReference<AbstractMixFakeShell>> shellList = RecyleController.this.getListController().getShellList();
            iMixActivityInterface = RecyleController.this.mixActivity;
            return new RecyleController.ListAdapter(context, itemData, miniUniqueId, shellList, iMixActivityInterface);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final ListAdapter getAdapter() {
        Lazy lazy = this.adapter$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (ListAdapter) lazy.getValue();
    }

    private final PagerLayoutManager getLayoutManger() {
        Lazy lazy = this.layoutManger$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (PagerLayoutManager) lazy.getValue();
    }

    private final PagerRecyclerView getRecyclerView() {
        Lazy lazy = this.recyclerView$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (PagerRecyclerView) lazy.getValue();
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void onDestroy() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/RecyleController$Companion;", "", "LIVE_TYPE_AUDIO", "I", "LIVE_TYPE_CONSULT", "LIVE_TYPE_DATE", "LIVE_TYPE_MEDIA", "LIVE_TYPE_NEW_MEDIA", "LIVE_TYPE_SHOPPING", "LIVE_TYPE_SHOW", "LIVE_TYPE_YY", "TYPE_CACHE_SIZE", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0006\u0010&\u001a\u00020%\u0012\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u001c\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0019\u0010&\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010,\u001a\n +*\u0004\u0018\u00010*0*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\"\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001f¨\u00063"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/RecyleController$ListAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "", "viewName", "Landroid/view/View;", "inflateLiveView", "(Ljava/lang/String;)Landroid/view/View;", "Lcom/baidu/searchbox/live/list/controller/RecyleController$LiveHolder;", "holder", "", "onBindViewHolder", "(Lcom/baidu/searchbox/live/list/controller/RecyleController$LiveHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/baidu/searchbox/live/list/controller/RecyleController$LiveHolder;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "getMixUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "kotlin.jvm.PlatformType", "pluginInvokeService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;", "shellList", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/baidu/live/arch/utils/MiniUniqueId;Ljava/util/List;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class ListAdapter extends RecyclerView.Adapter<LiveHolder> {
        public final Context context;
        public final List<LiveContainer.LiveItemModel> data;
        public final IMixActivityInterface mixActivity;
        public final MiniUniqueId mixUniqueId;
        public final PluginInvokeService pluginInvokeService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        public final List<WeakReference<AbstractMixFakeShell>> shellList;

        public ListAdapter(Context context, List<LiveContainer.LiveItemModel> list, MiniUniqueId miniUniqueId, List<WeakReference<AbstractMixFakeShell>> list2, IMixActivityInterface iMixActivityInterface) {
            this.context = context;
            this.data = list;
            this.mixUniqueId = miniUniqueId;
            this.shellList = list2;
            this.mixActivity = iMixActivityInterface;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private final View inflateLiveView(String str) {
            View createContainerView;
            switch (str.hashCode()) {
                case -1290662271:
                    if (str.equals(MixConstants.LIVE_AUDIO_COMPONENT)) {
                        MixAudioFakeShell mixAudioFakeShell = new MixAudioFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                        this.shellList.add(new WeakReference<>(mixAudioFakeShell));
                        createContainerView = mixAudioFakeShell.createContainerView();
                        break;
                    }
                    MixMediaFakeShell mixMediaFakeShell = new MixMediaFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                    this.shellList.add(new WeakReference<>(mixMediaFakeShell));
                    createContainerView = mixMediaFakeShell.createContainerView();
                    break;
                case -308259055:
                    if (str.equals(MixConstants.LIVE_YY_COMPONENT)) {
                        MixYYFakeShell mixYYFakeShell = new MixYYFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                        this.shellList.add(new WeakReference<>(mixYYFakeShell));
                        createContainerView = mixYYFakeShell.createContainerView();
                        break;
                    }
                    MixMediaFakeShell mixMediaFakeShell2 = new MixMediaFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                    this.shellList.add(new WeakReference<>(mixMediaFakeShell2));
                    createContainerView = mixMediaFakeShell2.createContainerView();
                    break;
                case -180546576:
                    if (str.equals(MixConstants.LIVE_COMPONENT_NEW_MEDIA)) {
                        MixNewMediaFakeShell mixNewMediaFakeShell = new MixNewMediaFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                        this.shellList.add(new WeakReference<>(mixNewMediaFakeShell));
                        createContainerView = mixNewMediaFakeShell.createContainerView();
                        break;
                    }
                    MixMediaFakeShell mixMediaFakeShell22 = new MixMediaFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                    this.shellList.add(new WeakReference<>(mixMediaFakeShell22));
                    createContainerView = mixMediaFakeShell22.createContainerView();
                    break;
                case 1018636823:
                    if (str.equals(MixConstants.LIVE_COMPONENT_CONSULT)) {
                        MixConsultFakeShell mixConsultFakeShell = new MixConsultFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                        this.shellList.add(new WeakReference<>(mixConsultFakeShell));
                        createContainerView = mixConsultFakeShell.createContainerView();
                        break;
                    }
                    MixMediaFakeShell mixMediaFakeShell222 = new MixMediaFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                    this.shellList.add(new WeakReference<>(mixMediaFakeShell222));
                    createContainerView = mixMediaFakeShell222.createContainerView();
                    break;
                case 1736280221:
                    if (str.equals(MixConstants.LIVE_COMPONENT_SHOPPING)) {
                        MixShopFakeShell mixShopFakeShell = new MixShopFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                        this.shellList.add(new WeakReference<>(mixShopFakeShell));
                        createContainerView = mixShopFakeShell.createContainerView();
                        break;
                    }
                    MixMediaFakeShell mixMediaFakeShell2222 = new MixMediaFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                    this.shellList.add(new WeakReference<>(mixMediaFakeShell2222));
                    createContainerView = mixMediaFakeShell2222.createContainerView();
                    break;
                default:
                    MixMediaFakeShell mixMediaFakeShell22222 = new MixMediaFakeShell(this.context, this.mixUniqueId, this.mixActivity);
                    this.shellList.add(new WeakReference<>(mixMediaFakeShell22222));
                    createContainerView = mixMediaFakeShell22222.createContainerView();
                    break;
            }
            if (createContainerView != null) {
                createContainerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            return createContainerView;
        }

        public final Context getContext() {
            return this.context;
        }

        public final List<LiveContainer.LiveItemModel> getData() {
            return this.data;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.data.size();
        }

        public final MiniUniqueId getMixUniqueId() {
            return this.mixUniqueId;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            String templateId;
            String liveType = this.data.get(i).getLiveType();
            int hashCode = liveType.hashCode();
            if (hashCode != 48) {
                if (hashCode != 51 || !liveType.equals("3")) {
                    return 0;
                }
                return 6;
            } else if (!liveType.equals("0") || (templateId = this.data.get(i).getTemplateId()) == null) {
                return 0;
            } else {
                switch (templateId.hashCode()) {
                    case 48:
                        templateId.equals("0");
                        return 0;
                    case 49:
                        if (!templateId.equals("1")) {
                            return 0;
                        }
                        return 3;
                    case 50:
                        if (!templateId.equals("2")) {
                            return 0;
                        }
                        return 4;
                    case 51:
                        if (!templateId.equals("3")) {
                            return 0;
                        }
                        return 5;
                    case 52:
                    default:
                        return 0;
                    case 53:
                        if (!templateId.equals("5")) {
                            return 0;
                        }
                        return 7;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(LiveHolder liveHolder, int i) {
            MediaLivePluginLogger.Companion.getInstance().logBindMixShellDataStart();
            StringBuilder sb = new StringBuilder();
            sb.append("ListComponent onBindViewHolder pos:");
            sb.append(i);
            sb.append(" context:");
            View view2 = liveHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            sb.append(view2.getContext().hashCode());
            ListLogKt.log("MixLiveCell_fake_list", sb.toString());
            liveHolder.getView().setTag(Integer.valueOf(i));
            View view3 = liveHolder.getView();
            if (!(view3 instanceof LiveContainer)) {
                view3 = null;
            }
            LiveContainer liveContainer = (LiveContainer) view3;
            if (liveContainer != null) {
                LiveContainer.LiveItemModel liveItemModel = this.data.get(i);
                liveItemModel.getRuntimeStatus().setPosition(i);
                liveContainer.bindData(liveItemModel);
            }
            MediaLivePluginLogger.Companion.getInstance().logBindMixShellDataEnd();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public LiveHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ListLogKt.log("MixLiveCell_fake_list", "ListComponent onCreateViewHolder type:" + i + " context:" + viewGroup.getContext().hashCode());
            if (i != 0) {
                if (i != 1) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    if (i == 7) {
                                        MediaLivePlayLogger.Companion.getInstance().popLaunchInfo(null);
                                        MediaLivePluginLogger.Companion.getInstance().logLiveRoomLeave("audioLive");
                                        View inflateLiveView = inflateLiveView(MixConstants.LIVE_AUDIO_COMPONENT);
                                        if (inflateLiveView != null) {
                                            return new LiveHolder(inflateLiveView);
                                        }
                                    }
                                } else {
                                    MediaLivePlayLogger.Companion.getInstance().popLaunchInfo(null);
                                    MediaLivePluginLogger.Companion.getInstance().logLiveRoomLeave("yyLive");
                                    View inflateLiveView2 = inflateLiveView(MixConstants.LIVE_YY_COMPONENT);
                                    if (inflateLiveView2 != null) {
                                        return new LiveHolder(inflateLiveView2);
                                    }
                                }
                            } else {
                                MediaLivePlayLogger.Companion.getInstance().logStartCreateMediaComponent();
                                MediaLivePluginLogger.Companion.getInstance().logCreateMixShellStart();
                                View inflateLiveView3 = inflateLiveView(MixConstants.LIVE_COMPONENT_CONSULT);
                                if (inflateLiveView3 != null) {
                                    MediaLivePluginLogger.Companion.getInstance().logCreateMixShellEnd();
                                    return new LiveHolder(inflateLiveView3);
                                }
                            }
                        } else {
                            MediaLivePlayLogger.Companion.getInstance().logStartCreateMediaComponent();
                            MediaLivePluginLogger.Companion.getInstance().logCreateMixShellStart();
                            View inflateLiveView4 = inflateLiveView(MixConstants.LIVE_COMPONENT_SHOPPING);
                            if (inflateLiveView4 != null) {
                                MediaLivePluginLogger.Companion.getInstance().logCreateMixShellEnd();
                                return new LiveHolder(inflateLiveView4);
                            }
                        }
                    } else {
                        MediaLivePlayLogger.Companion.getInstance().logStartCreateMediaComponent();
                        MediaLivePluginLogger.Companion.getInstance().logCreateMixShellStart();
                        View inflateLiveView5 = inflateLiveView(MixConstants.LIVE_COMPONENT_NEW_MEDIA);
                        if (inflateLiveView5 != null) {
                            MediaLivePluginLogger.Companion.getInstance().logCreateMixShellEnd();
                            return new LiveHolder(inflateLiveView5);
                        }
                    }
                } else {
                    MediaLivePlayLogger.Companion.getInstance().popLaunchInfo(null);
                    MediaLivePluginLogger.Companion.getInstance().logLiveRoomLeave("liveShow");
                    View inflateLiveView6 = inflateLiveView(MixConstants.LIVE_MEDIA_COMPONENT);
                    if (inflateLiveView6 != null) {
                        return new LiveHolder(inflateLiveView6);
                    }
                }
            } else {
                MediaLivePlayLogger.Companion.getInstance().logStartCreateMediaComponent();
                MediaLivePluginLogger.Companion.getInstance().logCreateMixShellStart();
                View inflateLiveView7 = inflateLiveView(MixConstants.LIVE_MEDIA_COMPONENT);
                if (inflateLiveView7 != null) {
                    MediaLivePluginLogger.Companion.getInstance().logCreateMixShellEnd();
                    return new LiveHolder(inflateLiveView7);
                }
            }
            MediaLivePluginLogger.Companion.getInstance().logCreateMixShellStart();
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            MediaLivePluginLogger.Companion.getInstance().logCreateMixShellEnd();
            return new LiveHolder(frameLayout);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/RecyleController$LiveHolder;", "androidx/recyclerview/widget/RecyclerView$ViewHolder", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class LiveHolder extends RecyclerView.ViewHolder {

        /* renamed from: view  reason: collision with root package name */
        public final View f1063view;

        public LiveHolder(View view2) {
            super(view2);
            this.f1063view = view2;
        }

        public final View getView() {
            return this.f1063view;
        }
    }

    public RecyleController(ListController listController, Context context, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface) {
        this.listController = listController;
        this.context = context;
        this.mixUniqueId = miniUniqueId;
        this.mixActivity = iMixActivityInterface;
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void clear(int i) {
        getAdapter().notifyItemRangeRemoved(0, i);
        try {
            getRecyclerView().removeAllViews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void onCloseRoom(List<String> list) {
        this.closeRoomIdList.addAll(list);
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void onListChange(int i) {
        getAdapter().notifyItemRangeInserted(i, this.listController.getItemData().size() - i);
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void resetCurRoom(LiveContainer.LiveItemModel liveItemModel) {
        getAdapter().notifyItemInserted(this.listController.getItemData().indexOf(liveItemModel));
        getRecyclerView().setVisibility(0);
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void setIsScrollable(boolean z) {
        getLayoutManger().setIsCanScroll(z);
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public View createView() {
        getRecyclerView().setLayoutManager(getLayoutManger());
        getRecyclerView().setAdapter(getAdapter());
        getRecyclerView().setVisibility(8);
        return getRecyclerView();
    }

    public final Context getContext() {
        return this.context;
    }

    public final ListController getListController() {
        return this.listController;
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void scrollToNextLiveRoom() {
        getLayoutManger().snapToNext();
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void scrollToPreLiveRoom() {
        getLayoutManger().snapToPre();
    }

    public final Set<Integer> handleClosedLiveRoom() {
        if (this.closeRoomIdList.isEmpty()) {
            return new LinkedHashSet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<LiveContainer.LiveItemModel> it = this.listController.getItemData().iterator();
        while (it.hasNext()) {
            String roomId = it.next().getRoomId();
            if (this.closeRoomIdList.contains(roomId)) {
                List<LiveContainer.LiveItemModel> itemData = this.listController.getItemData();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(itemData, 10));
                int i = 0;
                for (Object obj : itemData) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(((LiveContainer.LiveItemModel) obj).getRoomId(), roomId)) {
                        linkedHashSet.add(Integer.valueOf(i));
                    }
                    arrayList.add(Unit.INSTANCE);
                    i = i2;
                }
                it.remove();
            }
        }
        this.closeRoomIdList.clear();
        return linkedHashSet;
    }
}
