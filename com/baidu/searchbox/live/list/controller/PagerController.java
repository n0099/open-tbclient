package com.baidu.searchbox.live.list.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.list.controller.PagerController;
import com.baidu.searchbox.live.livepager.AlaLoopViewPager;
import com.baidu.searchbox.live.livepager.AlaLoopViewPagerAdapter;
import com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.MixShellScrollInterface;
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
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 b2\u00020\u0001:\u0003bcdB'\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010V\u001a\u00020U¢\u0006\u0004\b`\u0010aJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u001b\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0006J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u001eJ\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b#\u0010\u0006J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000fH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\u001eJ\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u001eJ\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0002H\u0002¢\u0006\u0004\b+\u0010\u0006J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0014H\u0016¢\u0006\u0004\b-\u0010.R\u001d\u00104\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001d\u00109\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u0019\u0010;\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0019\u0010F\u001a\u00020E8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001d\u0010S\u001a\u00020O8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u00101\u001a\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010NR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010AR\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010A¨\u0006e"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/PagerController;", "Lcom/baidu/searchbox/live/list/controller/IListManager;", "", "vec", "", "afterPageChanged", "(I)V", "beforePageChanged", "sizeBefore", "clear", "Landroid/view/View;", "createView", "()Landroid/view/View;", "getCurrentLiveIndex", "()I", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getCurrentLiveInfo", "()Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getNextLiveInfo", "getPreLiveInfo", "", "isFirstLive", "()Z", "isLastLive", "", "", "closeRoomIdList", "onCloseRoom", "(Ljava/util/List;)V", MissionEvent.MESSAGE_DESTROY, "()V", "size", "onListChange", "onPageChanged", "onPageTurn", "prePageChanged", "itemModel", "resetCurRoom", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "resetCurRoomInternal", "scrollToNextLiveRoom", "scrollToPreLiveRoom", "index", "setCurrentLiveIndex", "isCanScroll", "setIsScrollable", "(Z)V", "Lcom/baidu/searchbox/live/list/controller/PagerController$ListPagerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getAdapter", "()Lcom/baidu/searchbox/live/list/controller/PagerController$ListPagerAdapter;", "adapter", "Lcom/baidu/searchbox/live/livepager/AlaLoopViewPager;", "alaLoopViewPager$delegate", "getAlaLoopViewPager", "()Lcom/baidu/searchbox/live/livepager/AlaLoopViewPager;", "alaLoopViewPager", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;", "curPagerHolder", "Lcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/baidu/searchbox/live/list/controller/ListController;", "listController", "Lcom/baidu/searchbox/live/list/controller/ListController;", "getListController", "()Lcom/baidu/searchbox/live/list/controller/ListController;", "Lcom/baidu/searchbox/live/livepager/AlaVerticalViewPagerNew$Callback;", "mCallBack", "Lcom/baidu/searchbox/live/livepager/AlaVerticalViewPagerNew$Callback;", "mCurrentLiveIndex", "I", "Lcom/baidu/searchbox/live/livepager/AlaLoopViewPagerAdapter;", "mPagerAdapter$delegate", "getMPagerAdapter", "()Lcom/baidu/searchbox/live/livepager/AlaLoopViewPagerAdapter;", "mPagerAdapter", "mSelectedPosition", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "nextPagerHolder", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageChangedListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "prePagerHolder", "<init>", "(Lcom/baidu/searchbox/live/list/controller/ListController;Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "Companion", "ListPagerAdapter", "PagerHolder", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PagerController implements IListManager {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int DEFAULT_SELECT_PAGE = 0;
    public static final int LIVE_TYPE_AUDIO = 7;
    public static final int LIVE_TYPE_CONSULT = 5;
    public static final int LIVE_TYPE_DATE = 8;
    public static final int LIVE_TYPE_MEDIA = 0;
    public static final int LIVE_TYPE_NEW_MEDIA = 3;
    public static final int LIVE_TYPE_SHOPPING = 4;
    public static final int LIVE_TYPE_SHOW = 1;
    public static final int LIVE_TYPE_YY = 6;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy adapter$delegate;
    public final Lazy alaLoopViewPager$delegate;
    public final Context context;
    public PagerHolder curPagerHolder;
    public final Handler handler;
    public final ListController listController;
    public final AlaVerticalViewPagerNew.Callback mCallBack;
    public int mCurrentLiveIndex;
    public final Lazy mPagerAdapter$delegate;
    public int mSelectedPosition;
    public final IMixActivityInterface mixActivity;
    public final MiniUniqueId mixUniqueId;
    public PagerHolder nextPagerHolder;
    public final ViewPager.OnPageChangeListener onPageChangedListener;
    public PagerHolder prePagerHolder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/PagerController$Companion;", "", "DEFAULT_SELECT_PAGE", "I", "LIVE_TYPE_AUDIO", "LIVE_TYPE_CONSULT", "LIVE_TYPE_DATE", "LIVE_TYPE_MEDIA", "LIVE_TYPE_NEW_MEDIA", "LIVE_TYPE_SHOPPING", "LIVE_TYPE_SHOW", "LIVE_TYPE_YY", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000BI\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010$\u0012\u0006\u00102\u001a\u000201\u0012\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:090$\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010 \u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010*\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0019\u00102\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:090$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010&¨\u0006>"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/PagerController$ListPagerAdapter;", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "info", "Landroid/view/View;", "generateViewItem", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)Landroid/view/View;", "", "getItemViewType", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)I", "", "viewName", "randomViewId", "inflateLiveView", "(Ljava/lang/String;I)Landroid/view/View;", "Lcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;", "holder", CriusAttrConstants.POSITION, "", "onBindViewHolder", "(Lcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;Ljava/lang/Integer;)V", "Landroid/view/ViewGroup;", "parent", "itemModel", "vec", "mSelectedPosition", "onCreateViewHolder", "(Landroid/view/ViewGroup;Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;III)Lcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;", MissionEvent.MESSAGE_DESTROY, "()V", "onDestroyViewHolder", "(Lcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "Lcom/baidu/searchbox/live/livepager/AlaLoopViewPagerAdapter;", "mPagerAdapter", "Lcom/baidu/searchbox/live/livepager/AlaLoopViewPagerAdapter;", "getMPagerAdapter", "()Lcom/baidu/searchbox/live/livepager/AlaLoopViewPagerAdapter;", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "getMixUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "Lcom/baidu/searchbox/live/list/controller/PagerCache;", "pagerCache", "Lcom/baidu/searchbox/live/list/controller/PagerCache;", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;", "shellList", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/baidu/live/arch/utils/MiniUniqueId;Ljava/util/List;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;Lcom/baidu/searchbox/live/livepager/AlaLoopViewPagerAdapter;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class ListPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context context;
        public final List<LiveContainer.LiveItemModel> data;
        public final AlaLoopViewPagerAdapter mPagerAdapter;
        public final IMixActivityInterface mixActivity;
        public final MiniUniqueId mixUniqueId;
        public final PagerCache pagerCache;
        public final List<WeakReference<AbstractMixFakeShell>> shellList;

        public ListPagerAdapter(Context context, List<LiveContainer.LiveItemModel> list, MiniUniqueId miniUniqueId, List<WeakReference<AbstractMixFakeShell>> list2, IMixActivityInterface iMixActivityInterface, AlaLoopViewPagerAdapter alaLoopViewPagerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, list, miniUniqueId, list2, iMixActivityInterface, alaLoopViewPagerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = context;
            this.data = list;
            this.mixUniqueId = miniUniqueId;
            this.shellList = list2;
            this.mixActivity = iMixActivityInterface;
            this.mPagerAdapter = alaLoopViewPagerAdapter;
            this.pagerCache = new PagerCache();
        }

        private final View generateViewItem(LiveContainer.LiveItemModel liveItemModel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, liveItemModel)) == null) {
                int abs = Math.abs((int) System.currentTimeMillis());
                View view2 = null;
                if (Intrinsics.areEqual(liveItemModel.getLiveType(), "3")) {
                    MediaLivePlayLogger.Companion.getInstance().popLaunchInfo(null);
                    MediaLivePluginLogger.Companion.getInstance().logLiveRoomLeave("yyLive");
                    view2 = inflateLiveView(MixConstants.LIVE_YY_COMPONENT, abs);
                } else if (Intrinsics.areEqual(liveItemModel.getTemplateId(), "1")) {
                    MediaLivePlayLogger.Companion.getInstance().logStartCreateMediaComponent();
                    MediaLivePluginLogger.Companion.getInstance().logCreateMixShellStart();
                    View inflateLiveView = inflateLiveView(MixConstants.LIVE_COMPONENT_NEW_MEDIA, abs);
                    if (inflateLiveView != null) {
                        MediaLivePluginLogger.Companion.getInstance().logCreateMixShellEnd();
                        return inflateLiveView;
                    }
                } else if (Intrinsics.areEqual(liveItemModel.getTemplateId(), "2")) {
                    MediaLivePlayLogger.Companion.getInstance().logStartCreateMediaComponent();
                    MediaLivePluginLogger.Companion.getInstance().logCreateMixShellStart();
                    View inflateLiveView2 = inflateLiveView(MixConstants.LIVE_COMPONENT_SHOPPING, abs);
                    if (inflateLiveView2 != null) {
                        MediaLivePluginLogger.Companion.getInstance().logCreateMixShellEnd();
                        return inflateLiveView2;
                    }
                } else if (Intrinsics.areEqual(liveItemModel.getTemplateId(), "5")) {
                    MediaLivePlayLogger.Companion.getInstance().popLaunchInfo(null);
                    MediaLivePluginLogger.Companion.getInstance().logLiveRoomLeave("audioLive");
                    view2 = inflateLiveView(MixConstants.LIVE_AUDIO_COMPONENT, abs);
                } else if (Intrinsics.areEqual(liveItemModel.getTemplateId(), "3")) {
                    MediaLivePlayLogger.Companion.getInstance().logStartCreateMediaComponent();
                    MediaLivePluginLogger.Companion.getInstance().logCreateMixShellStart();
                    View inflateLiveView3 = inflateLiveView(MixConstants.LIVE_COMPONENT_CONSULT, abs);
                    if (inflateLiveView3 != null) {
                        MediaLivePluginLogger.Companion.getInstance().logCreateMixShellEnd();
                        return inflateLiveView3;
                    }
                } else {
                    MediaLivePlayLogger.Companion.getInstance().logStartCreateMediaComponent();
                    MediaLivePluginLogger.Companion.getInstance().logCreateMixShellStart();
                    View inflateLiveView4 = inflateLiveView(MixConstants.LIVE_MEDIA_COMPONENT, abs);
                    if (inflateLiveView4 != null) {
                        MediaLivePluginLogger.Companion.getInstance().logCreateMixShellEnd();
                        return inflateLiveView4;
                    }
                }
                return view2 == null ? new View(this.context) : view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private final View inflateLiveView(String str, int i) {
            InterceptResult invokeLI;
            View createContainerView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, str, i)) == null) {
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
            return (View) invokeLI.objValue;
        }

        public final Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.context : (Context) invokeV.objValue;
        }

        public final List<LiveContainer.LiveItemModel> getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.data : (List) invokeV.objValue;
        }

        public final int getItemViewType(LiveContainer.LiveItemModel liveItemModel) {
            InterceptResult invokeL;
            String templateId;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, liveItemModel)) == null) {
                String liveType = liveItemModel.getLiveType();
                int hashCode = liveType.hashCode();
                if (hashCode != 48) {
                    return (hashCode == 51 && liveType.equals("3")) ? 6 : 0;
                } else if (!liveType.equals("0") || (templateId = liveItemModel.getTemplateId()) == null) {
                    return 0;
                } else {
                    switch (templateId.hashCode()) {
                        case 48:
                            templateId.equals("0");
                            return 0;
                        case 49:
                            return templateId.equals("1") ? 3 : 0;
                        case 50:
                            return templateId.equals("2") ? 4 : 0;
                        case 51:
                            return templateId.equals("3") ? 5 : 0;
                        case 52:
                        default:
                            return 0;
                        case 53:
                            return templateId.equals("5") ? 7 : 0;
                    }
                }
            }
            return invokeL.intValue;
        }

        public final AlaLoopViewPagerAdapter getMPagerAdapter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPagerAdapter : (AlaLoopViewPagerAdapter) invokeV.objValue;
        }

        public final MiniUniqueId getMixUniqueId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mixUniqueId : (MiniUniqueId) invokeV.objValue;
        }

        public final void onBindViewHolder(PagerHolder pagerHolder, Integer num) {
            LiveContainer.LiveItemModel curRoomModel;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, pagerHolder, num) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onBindViewHolder ");
                sb.append(pagerHolder != null ? Integer.valueOf(pagerHolder.getIndex()) : null);
                sb.append(" shell:");
                sb.append(pagerHolder != null ? pagerHolder.getShellContainer() : null);
                sb.append(" page:");
                sb.append(pagerHolder != null ? pagerHolder.getMPage() : null);
                sb.append(" pos:");
                sb.append(num);
                ListLogKt.log(MixTagConstants.MIX_PAGER, sb.toString());
                MediaLivePluginLogger.Companion.getInstance().logBindMixShellDataStart();
                View shellContainer = pagerHolder != null ? pagerHolder.getShellContainer() : null;
                LiveContainer liveContainer = shellContainer instanceof LiveContainer ? shellContainer : null;
                if (liveContainer != null && (curRoomModel = pagerHolder.getCurRoomModel()) != null) {
                    liveContainer.bindData(curRoomModel);
                }
                MediaLivePluginLogger.Companion.getInstance().logBindMixShellDataEnd();
            }
        }

        public final PagerHolder onCreateViewHolder(ViewGroup viewGroup, LiveContainer.LiveItemModel liveItemModel, int i, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{viewGroup, liveItemModel, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                PagerHolder pagerHolder = this.pagerCache.get(getItemViewType(liveItemModel));
                if (pagerHolder == null) {
                    pagerHolder = new PagerHolder();
                }
                pagerHolder.setCreateVec(i2);
                AlaLoopViewPagerAdapter alaLoopViewPagerAdapter = this.mPagerAdapter;
                if (alaLoopViewPagerAdapter == null) {
                    Intrinsics.throwNpe();
                }
                pagerHolder.setMPage(alaLoopViewPagerAdapter.getPageBySelectedPosition(i3));
                pagerHolder.setCurRoomModel(liveItemModel);
                pagerHolder.setIndex(i);
                pagerHolder.setShellContainer(generateViewItem(liveItemModel));
                ListLogKt.log(MixTagConstants.MIX_PAGER, "onCreateViewHolder " + pagerHolder.getIndex() + " shell:" + pagerHolder.getShellContainer() + " page:" + pagerHolder.getMPage() + " pos:" + i);
                return pagerHolder;
            }
            return (PagerHolder) invokeCommon.objValue;
        }

        public final void onDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.pagerCache.clear();
            }
        }

        public final void onDestroyViewHolder(PagerHolder pagerHolder) {
            LiveContainer.LiveItemModel curRoomModel;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pagerHolder) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onDestroyViewHolder ");
                sb.append(pagerHolder != null ? Integer.valueOf(pagerHolder.getIndex()) : null);
                sb.append(" page:");
                sb.append(pagerHolder != null ? pagerHolder.getMPage() : null);
                ListLogKt.log(MixTagConstants.MIX_PAGER, sb.toString());
                if (pagerHolder == null || (curRoomModel = pagerHolder.getCurRoomModel()) == null) {
                    return;
                }
                this.pagerCache.put(getItemViewType(curRoomModel), pagerHolder);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\"\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0005\"\u0004\b\u0014\u0010\u0007R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;", "", "createVec", "I", "getCreateVec", "()I", "setCreateVec", "(I)V", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "curRoomModel", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getCurRoomModel", "()Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "setCurRoomModel", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "destroyVec", "getDestroyVec", "setDestroyVec", "index", "getIndex", "setIndex", "Landroid/widget/FrameLayout;", "mPage", "Landroid/widget/FrameLayout;", "getMPage", "()Landroid/widget/FrameLayout;", "setMPage", "(Landroid/widget/FrameLayout;)V", "Landroid/view/View;", "shellContainer", "Landroid/view/View;", "getShellContainer", "()Landroid/view/View;", "setShellContainer", "(Landroid/view/View;)V", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class PagerHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int createVec;
        public LiveContainer.LiveItemModel curRoomModel;
        public int destroyVec;
        public int index;
        public FrameLayout mPage;
        public View shellContainer;

        public PagerHolder() {
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

        public final int getCreateVec() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.createVec : invokeV.intValue;
        }

        public final LiveContainer.LiveItemModel getCurRoomModel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.curRoomModel : (LiveContainer.LiveItemModel) invokeV.objValue;
        }

        public final int getDestroyVec() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.destroyVec : invokeV.intValue;
        }

        public final int getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.index : invokeV.intValue;
        }

        public final FrameLayout getMPage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPage : (FrameLayout) invokeV.objValue;
        }

        public final View getShellContainer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.shellContainer : (View) invokeV.objValue;
        }

        public final void setCreateVec(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.createVec = i;
            }
        }

        public final void setCurRoomModel(LiveContainer.LiveItemModel liveItemModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, liveItemModel) == null) {
                this.curRoomModel = liveItemModel;
            }
        }

        public final void setDestroyVec(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.destroyVec = i;
            }
        }

        public final void setIndex(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.index = i;
            }
        }

        public final void setMPage(FrameLayout frameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, frameLayout) == null) {
                this.mPage = frameLayout;
            }
        }

        public final void setShellContainer(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
                this.shellContainer = view2;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1917845849, "Lcom/baidu/searchbox/live/list/controller/PagerController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1917845849, "Lcom/baidu/searchbox/live/list/controller/PagerController;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PagerController.class), "alaLoopViewPager", "getAlaLoopViewPager()Lcom/baidu/searchbox/live/livepager/AlaLoopViewPager;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PagerController.class), "mPagerAdapter", "getMPagerAdapter()Lcom/baidu/searchbox/live/livepager/AlaLoopViewPagerAdapter;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PagerController.class), "adapter", "getAdapter()Lcom/baidu/searchbox/live/list/controller/PagerController$ListPagerAdapter;"))};
        Companion = new Companion(null);
    }

    public PagerController(ListController listController, Context context, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listController, context, miniUniqueId, iMixActivityInterface};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.listController = listController;
        this.context = context;
        this.mixUniqueId = miniUniqueId;
        this.mixActivity = iMixActivityInterface;
        this.handler = new Handler(Looper.getMainLooper());
        this.alaLoopViewPager$delegate = LazyKt__LazyJVMKt.lazy(new PagerController$alaLoopViewPager$2(this));
        this.mPagerAdapter$delegate = LazyKt__LazyJVMKt.lazy(new PagerController$mPagerAdapter$2(this));
        this.adapter$delegate = LazyKt__LazyJVMKt.lazy(new PagerController$adapter$2(this));
        this.mCallBack = PagerController$mCallBack$1.INSTANCE;
        this.onPageChangedListener = new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.searchbox.live.list.controller.PagerController$onPageChangedListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean isStop;
            public int prePositionOffsetPixels;
            public final /* synthetic */ PagerController this$0;

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.isStop = true;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                AlaLoopViewPager alaLoopViewPager;
                AlaLoopViewPagerAdapter mPagerAdapter;
                int i4;
                AlaLoopViewPager alaLoopViewPager2;
                int currentLiveIndex;
                int currentLiveIndex2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    MixShellScrollInterface mixShellScrollInterface = (MixShellScrollInterface) ServiceLocator.Companion.getGlobalService(MixShellScrollInterface.class);
                    if (mixShellScrollInterface != null) {
                        currentLiveIndex2 = this.this$0.getCurrentLiveIndex();
                        mixShellScrollInterface.pageScrolledStateChangedAction(i3, currentLiveIndex2);
                    }
                    alaLoopViewPager = this.this$0.getAlaLoopViewPager();
                    if (alaLoopViewPager == null || i3 != 0) {
                        return;
                    }
                    this.isStop = true;
                    this.prePositionOffsetPixels = 0;
                    StringBuilder sb = new StringBuilder();
                    sb.append("list size ");
                    sb.append(this.this$0.getListController().getItemData().size());
                    sb.append(" adapter count ");
                    mPagerAdapter = this.this$0.getMPagerAdapter();
                    sb.append(mPagerAdapter.getCount());
                    ListLogKt.log(MixTagConstants.MIX_PAGER, sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onPageScrollStateChanged ");
                    i4 = this.this$0.mSelectedPosition;
                    sb2.append(i4);
                    sb2.append(WebvttCueParser.CHAR_SPACE);
                    alaLoopViewPager2 = this.this$0.getAlaLoopViewPager();
                    sb2.append(alaLoopViewPager2.getCurrentItem());
                    sb2.append(WebvttCueParser.CHAR_SPACE);
                    currentLiveIndex = this.this$0.getCurrentLiveIndex();
                    sb2.append(currentLiveIndex);
                    ListLogKt.log(MixTagConstants.MIX_PAGER, sb2.toString());
                    this.this$0.afterPageChanged(0);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
                int currentLiveIndex;
                int i5;
                AlaLoopViewPager alaLoopViewPager;
                int currentLiveIndex2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i3), Float.valueOf(f), Integer.valueOf(i4)}) == null) {
                    boolean z = false;
                    if (i4 != 0) {
                        this.prePositionOffsetPixels = i4;
                        if (this.isStop) {
                            boolean z2 = ((double) f) < 0.5d;
                            this.this$0.prePageChanged(z2 ? 1 : -1);
                            onStartPageScrolledOffset(z2, i3);
                            this.isStop = false;
                            z = z2;
                        } else if (i4 > i4) {
                            z = true;
                        }
                    }
                    currentLiveIndex = this.this$0.getCurrentLiveIndex();
                    MixShellScrollInterface mixShellScrollInterface = (MixShellScrollInterface) ServiceLocator.Companion.getGlobalService(MixShellScrollInterface.class);
                    if (mixShellScrollInterface != null) {
                        mixShellScrollInterface.pageScrolledAction(currentLiveIndex, z, true);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("onPageScrolled ");
                    sb.append(i3);
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    sb.append(f);
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    sb.append(i4);
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    i5 = this.this$0.mSelectedPosition;
                    sb.append(i5);
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    alaLoopViewPager = this.this$0.getAlaLoopViewPager();
                    sb.append(alaLoopViewPager.getCurrentItem());
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    currentLiveIndex2 = this.this$0.getCurrentLiveIndex();
                    sb.append(currentLiveIndex2);
                    ListLogKt.log(MixTagConstants.MIX_PAGER, sb.toString());
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                AlaLoopViewPagerAdapter mPagerAdapter;
                int i4;
                AlaLoopViewPager alaLoopViewPager;
                int currentLiveIndex;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i3) == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("list size ");
                    sb.append(this.this$0.getListController().getItemData().size());
                    sb.append(" adapter count ");
                    mPagerAdapter = this.this$0.getMPagerAdapter();
                    sb.append(mPagerAdapter.getCount());
                    ListLogKt.log(MixTagConstants.MIX_PAGER, sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onPageSelected ");
                    sb2.append(i3);
                    sb2.append(WebvttCueParser.CHAR_SPACE);
                    i4 = this.this$0.mSelectedPosition;
                    sb2.append(i4);
                    sb2.append(WebvttCueParser.CHAR_SPACE);
                    alaLoopViewPager = this.this$0.getAlaLoopViewPager();
                    sb2.append(alaLoopViewPager.getCurrentItem());
                    sb2.append(WebvttCueParser.CHAR_SPACE);
                    currentLiveIndex = this.this$0.getCurrentLiveIndex();
                    sb2.append(currentLiveIndex);
                    ListLogKt.log(MixTagConstants.MIX_PAGER, sb2.toString());
                    this.this$0.onPageTurn();
                }
            }

            public final void onStartPageScrolledOffset(boolean z, int i3) {
                int currentLiveIndex;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
                    currentLiveIndex = this.this$0.getCurrentLiveIndex();
                    ListLogKt.log(MixTagConstants.MIX_PAGER, "onStartPageScrolledOffset isUp" + z + " position" + i3 + " pos" + currentLiveIndex);
                    MixShellScrollInterface mixShellScrollInterface = (MixShellScrollInterface) ServiceLocator.Companion.getGlobalService(MixShellScrollInterface.class);
                    if (mixShellScrollInterface != null) {
                        mixShellScrollInterface.pageStartScrolledOffsetAction(z, currentLiveIndex);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListPagerAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            Lazy lazy = this.adapter$delegate;
            KProperty kProperty = $$delegatedProperties[2];
            return (ListPagerAdapter) lazy.getValue();
        }
        return (ListPagerAdapter) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlaLoopViewPager getAlaLoopViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            Lazy lazy = this.alaLoopViewPager$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (AlaLoopViewPager) lazy.getValue();
        }
        return (AlaLoopViewPager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentLiveIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) ? this.mCurrentLiveIndex : invokeV.intValue;
    }

    private final LiveContainer.LiveItemModel getCurrentLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            if (this.mCurrentLiveIndex >= this.listController.getItemData().size()) {
                this.mCurrentLiveIndex = this.listController.getItemData().size() - 1;
            }
            if (this.mCurrentLiveIndex < 0) {
                this.mCurrentLiveIndex = 0;
            }
            if (this.listController.getItemData().size() <= this.mCurrentLiveIndex) {
                return this.listController.getCurRoomModel();
            }
            return this.listController.getItemData().get(this.mCurrentLiveIndex);
        }
        return (LiveContainer.LiveItemModel) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlaLoopViewPagerAdapter getMPagerAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            Lazy lazy = this.mPagerAdapter$delegate;
            KProperty kProperty = $$delegatedProperties[1];
            return (AlaLoopViewPagerAdapter) lazy.getValue();
        }
        return (AlaLoopViewPagerAdapter) invokeV.objValue;
    }

    private final LiveContainer.LiveItemModel getNextLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            int currentLiveIndex = getCurrentLiveIndex();
            int size = this.listController.getItemData().size();
            if (size == 0) {
                return this.listController.getCurRoomModel();
            }
            return this.listController.getItemData().get((currentLiveIndex + 1) % size);
        }
        return (LiveContainer.LiveItemModel) invokeV.objValue;
    }

    private final LiveContainer.LiveItemModel getPreLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            int currentLiveIndex = getCurrentLiveIndex();
            int size = this.listController.getItemData().size();
            if (size == 0) {
                return this.listController.getCurRoomModel();
            }
            return this.listController.getItemData().get(((currentLiveIndex + size) - 1) % size);
        }
        return (LiveContainer.LiveItemModel) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFirstLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            if (this.listController.getCurRoomModel() != null) {
                LiveContainer.LiveItemModel curRoomModel = this.listController.getCurRoomModel();
                if (!TextUtils.isEmpty(curRoomModel != null ? curRoomModel.getRoomId() : null) && this.listController.getItemData().size() > 0) {
                    LiveContainer.LiveItemModel liveItemModel = this.listController.getItemData().get(0);
                    String roomId = liveItemModel != null ? liveItemModel.getRoomId() : null;
                    if (!TextUtils.isEmpty(roomId)) {
                        LiveContainer.LiveItemModel curRoomModel2 = this.listController.getCurRoomModel();
                        if (Intrinsics.areEqual(roomId, curRoomModel2 != null ? curRoomModel2.getRoomId() : null)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLastLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            if (this.listController.getCurRoomModel() != null) {
                LiveContainer.LiveItemModel curRoomModel = this.listController.getCurRoomModel();
                if (!TextUtils.isEmpty(curRoomModel != null ? curRoomModel.getRoomId() : null) && this.listController.getItemData().size() > 0) {
                    LiveContainer.LiveItemModel liveItemModel = this.listController.getItemData().get(this.listController.getItemData().size() - 1);
                    String roomId = liveItemModel != null ? liveItemModel.getRoomId() : null;
                    if (!TextUtils.isEmpty(roomId)) {
                        LiveContainer.LiveItemModel curRoomModel2 = this.listController.getCurRoomModel();
                        if (Intrinsics.areEqual(roomId, curRoomModel2 != null ? curRoomModel2.getRoomId() : null)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private final void onPageChanged(final int i) {
        FrameLayout mPage;
        View shellContainer;
        View shellContainer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65566, this, i) == null) {
            ListLogKt.log(MixTagConstants.MIX_PAGER, "onPageChanged vec " + i);
            ListLogKt.log(MixTagConstants.MIX_PAGER, "onPageChanged index " + getCurrentLiveIndex());
            final LiveContainer.LiveItemModel curRoomModel = this.listController.getCurRoomModel();
            if (curRoomModel != null) {
                PagerHolder pagerHolder = this.nextPagerHolder;
                if (pagerHolder != null && pagerHolder != null && pagerHolder.getIndex() == getCurrentLiveIndex()) {
                    PagerHolder pagerHolder2 = this.nextPagerHolder;
                    if (Intrinsics.areEqual(pagerHolder2 != null ? pagerHolder2.getCurRoomModel() : null, this.listController.getCurRoomModel())) {
                        ListLogKt.log(MixTagConstants.MIX_PAGER, "onPageChanged real pre");
                        this.curPagerHolder = this.nextPagerHolder;
                        this.handler.post(new Runnable(curRoomModel, this, i) { // from class: com.baidu.searchbox.live.list.controller.PagerController$onPageChanged$$inlined$let$lambda$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LiveContainer.LiveItemModel $it;
                            public final /* synthetic */ int $vec$inlined;
                            public final /* synthetic */ PagerController this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {curRoomModel, this, Integer.valueOf(i)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.$it = curRoomModel;
                                this.this$0 = this;
                                this.$vec$inlined = i;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                PagerController.ListPagerAdapter adapter;
                                PagerController.PagerHolder pagerHolder3;
                                PagerController.PagerHolder pagerHolder4;
                                int currentLiveIndex;
                                PagerController.PagerHolder pagerHolder5;
                                int currentLiveIndex2;
                                int i2;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    adapter = this.this$0.getAdapter();
                                    pagerHolder3 = this.this$0.curPagerHolder;
                                    pagerHolder4 = this.this$0.curPagerHolder;
                                    adapter.onBindViewHolder(pagerHolder3, pagerHolder4 != null ? Integer.valueOf(pagerHolder4.getIndex()) : null);
                                    ListController listController = this.this$0.getListController();
                                    currentLiveIndex = this.this$0.getCurrentLiveIndex();
                                    listController.onBeforeSelect(currentLiveIndex);
                                    pagerHolder5 = this.this$0.curPagerHolder;
                                    View shellContainer3 = pagerHolder5 != null ? pagerHolder5.getShellContainer() : null;
                                    LiveContainer liveContainer = shellContainer3 instanceof LiveContainer ? shellContainer3 : null;
                                    if (liveContainer != null) {
                                        i2 = this.this$0.mSelectedPosition;
                                        liveContainer.onSelected(i2, this.$it, true);
                                    }
                                    ListController listController2 = this.this$0.getListController();
                                    currentLiveIndex2 = this.this$0.getCurrentLiveIndex();
                                    listController2.onAfterSelect(currentLiveIndex2);
                                }
                            }
                        });
                    }
                }
                ListLogKt.log(MixTagConstants.MIX_PAGER, "onPageChanged real new");
                this.curPagerHolder = getAdapter().onCreateViewHolder(null, curRoomModel, getCurrentLiveIndex(), i, this.mSelectedPosition);
                ListPagerAdapter adapter = getAdapter();
                PagerHolder pagerHolder3 = this.curPagerHolder;
                adapter.onBindViewHolder(pagerHolder3, pagerHolder3 != null ? Integer.valueOf(pagerHolder3.getIndex()) : null);
                PagerHolder pagerHolder4 = this.curPagerHolder;
                if (((pagerHolder4 == null || (shellContainer2 = pagerHolder4.getShellContainer()) == null) ? null : shellContainer2.getParent()) != null) {
                    PagerHolder pagerHolder5 = this.curPagerHolder;
                    ViewParent parent = (pagerHolder5 == null || (shellContainer = pagerHolder5.getShellContainer()) == null) ? null : shellContainer.getParent();
                    if (parent == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    ViewGroup viewGroup = (ViewGroup) parent;
                    PagerHolder pagerHolder6 = this.curPagerHolder;
                    viewGroup.removeView(pagerHolder6 != null ? pagerHolder6.getShellContainer() : null);
                }
                PagerHolder pagerHolder7 = this.curPagerHolder;
                if (pagerHolder7 != null && (mPage = pagerHolder7.getMPage()) != null) {
                    PagerHolder pagerHolder8 = this.curPagerHolder;
                    mPage.addView(pagerHolder8 != null ? pagerHolder8.getShellContainer() : null);
                }
                this.handler.post(new Runnable(curRoomModel, this, i) { // from class: com.baidu.searchbox.live.list.controller.PagerController$onPageChanged$$inlined$let$lambda$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveContainer.LiveItemModel $it;
                    public final /* synthetic */ int $vec$inlined;
                    public final /* synthetic */ PagerController this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {curRoomModel, this, Integer.valueOf(i)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$it = curRoomModel;
                        this.this$0 = this;
                        this.$vec$inlined = i;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        PagerController.ListPagerAdapter adapter2;
                        PagerController.PagerHolder pagerHolder32;
                        PagerController.PagerHolder pagerHolder42;
                        int currentLiveIndex;
                        PagerController.PagerHolder pagerHolder52;
                        int currentLiveIndex2;
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            adapter2 = this.this$0.getAdapter();
                            pagerHolder32 = this.this$0.curPagerHolder;
                            pagerHolder42 = this.this$0.curPagerHolder;
                            adapter2.onBindViewHolder(pagerHolder32, pagerHolder42 != null ? Integer.valueOf(pagerHolder42.getIndex()) : null);
                            ListController listController = this.this$0.getListController();
                            currentLiveIndex = this.this$0.getCurrentLiveIndex();
                            listController.onBeforeSelect(currentLiveIndex);
                            pagerHolder52 = this.this$0.curPagerHolder;
                            View shellContainer3 = pagerHolder52 != null ? pagerHolder52.getShellContainer() : null;
                            LiveContainer liveContainer = shellContainer3 instanceof LiveContainer ? shellContainer3 : null;
                            if (liveContainer != null) {
                                i2 = this.this$0.mSelectedPosition;
                                liveContainer.onSelected(i2, this.$it, true);
                            }
                            ListController listController2 = this.this$0.getListController();
                            currentLiveIndex2 = this.this$0.getCurrentLiveIndex();
                            listController2.onAfterSelect(currentLiveIndex2);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPageTurn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            ListLogKt.log(MixTagConstants.MIX_PAGER, "onPageTurn ");
            int currentItem = getAlaLoopViewPager().getCurrentItem();
            if (this.mSelectedPosition == currentItem) {
                ListLogKt.log(MixTagConstants.MIX_PAGER, "post not change");
            } else if (this.listController.getItemData().size() <= 1) {
                getAlaLoopViewPager().setCurrentItem(this.mSelectedPosition);
                this.listController.fetchMoreLiveIfNeed(getCurrentLiveIndex());
                ListLogKt.log(MixTagConstants.MIX_PAGER, "unable recyle scroll");
            } else {
                int i = this.mSelectedPosition;
                int i2 = -1;
                if (currentItem - i != 2 && currentItem - i != -1) {
                    i2 = 1;
                }
                if (isFirstLive() && i2 < 0) {
                    getAlaLoopViewPager().setCurrentItem(this.mSelectedPosition);
                    ListLogKt.log(MixTagConstants.MIX_PAGER, "unable first scroll");
                } else if (isLastLive() && i2 > 0) {
                    getAlaLoopViewPager().setCurrentItem(this.mSelectedPosition);
                    this.listController.fetchMoreLiveIfNeed(getCurrentLiveIndex());
                    ListLogKt.log(MixTagConstants.MIX_PAGER, "unable last scroll");
                } else {
                    this.mSelectedPosition = currentItem;
                    if (i2 < 0) {
                        setCurrentLiveIndex(getCurrentLiveIndex() - 1);
                    } else if (i2 > 0) {
                        setCurrentLiveIndex(getCurrentLiveIndex() + 1);
                    }
                    beforePageChanged(i2);
                    this.listController.setCurRoomModel(getCurrentLiveInfo());
                    onPageChanged(i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prePageChanged(int i) {
        LiveContainer.LiveItemModel nextLiveInfo;
        FrameLayout mPage;
        View shellContainer;
        FrameLayout mPage2;
        View shellContainer2;
        View shellContainer3;
        FrameLayout mPage3;
        View shellContainer4;
        FrameLayout mPage4;
        View shellContainer5;
        View shellContainer6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65568, this, i) == null) {
            ListLogKt.log(MixTagConstants.MIX_PAGER, "prePageChanged vec:" + i);
            ViewParent viewParent = null;
            if (i >= 0) {
                if (i <= 0 || (nextLiveInfo = getNextLiveInfo()) == null) {
                    return;
                }
                this.nextPagerHolder = getAdapter().onCreateViewHolder(null, nextLiveInfo, getCurrentLiveIndex() + 1, i, getMPagerAdapter().getNextItemIndex(this.mSelectedPosition));
                ListPagerAdapter adapter = getAdapter();
                PagerHolder pagerHolder = this.nextPagerHolder;
                adapter.onBindViewHolder(pagerHolder, pagerHolder != null ? Integer.valueOf(pagerHolder.getIndex()) : null);
                PagerHolder pagerHolder2 = this.nextPagerHolder;
                if (((pagerHolder2 == null || (shellContainer3 = pagerHolder2.getShellContainer()) == null) ? null : shellContainer3.getParent()) != null) {
                    PagerHolder pagerHolder3 = this.nextPagerHolder;
                    ViewParent parent = (pagerHolder3 == null || (shellContainer2 = pagerHolder3.getShellContainer()) == null) ? null : shellContainer2.getParent();
                    if (parent == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    ViewGroup viewGroup = (ViewGroup) parent;
                    PagerHolder pagerHolder4 = this.nextPagerHolder;
                    viewGroup.removeView(pagerHolder4 != null ? pagerHolder4.getShellContainer() : null);
                }
                PagerHolder pagerHolder5 = this.nextPagerHolder;
                if (pagerHolder5 != null && (mPage2 = pagerHolder5.getMPage()) != null) {
                    PagerHolder pagerHolder6 = this.nextPagerHolder;
                    mPage2.addView(pagerHolder6 != null ? pagerHolder6.getShellContainer() : null);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("prePageChanged vec:");
                sb.append(i);
                sb.append(" index:");
                PagerHolder pagerHolder7 = this.nextPagerHolder;
                sb.append(pagerHolder7 != null ? Integer.valueOf(pagerHolder7.getIndex()) : null);
                sb.append(" \n shell:");
                PagerHolder pagerHolder8 = this.nextPagerHolder;
                sb.append(pagerHolder8 != null ? pagerHolder8.getShellContainer() : null);
                sb.append(" shellParent:");
                PagerHolder pagerHolder9 = this.nextPagerHolder;
                sb.append((pagerHolder9 == null || (shellContainer = pagerHolder9.getShellContainer()) == null) ? null : shellContainer.getParent());
                sb.append("  \n page:{");
                PagerHolder pagerHolder10 = this.nextPagerHolder;
                sb.append(pagerHolder10 != null ? pagerHolder10.getMPage() : null);
                sb.append("} parent:{");
                PagerHolder pagerHolder11 = this.nextPagerHolder;
                if (pagerHolder11 != null && (mPage = pagerHolder11.getMPage()) != null) {
                    viewParent = mPage.getParent();
                }
                sb.append(viewParent);
                sb.append('}');
                ListLogKt.log(MixTagConstants.MIX_PAGER, sb.toString());
                return;
            }
            LiveContainer.LiveItemModel preLiveInfo = getPreLiveInfo();
            if (preLiveInfo != null) {
                this.nextPagerHolder = getAdapter().onCreateViewHolder(null, preLiveInfo, getCurrentLiveIndex() - 1, i, getMPagerAdapter().getPreItemIndex(this.mSelectedPosition));
                ListPagerAdapter adapter2 = getAdapter();
                PagerHolder pagerHolder12 = this.nextPagerHolder;
                adapter2.onBindViewHolder(pagerHolder12, pagerHolder12 != null ? Integer.valueOf(pagerHolder12.getIndex()) : null);
                PagerHolder pagerHolder13 = this.nextPagerHolder;
                if (((pagerHolder13 == null || (shellContainer6 = pagerHolder13.getShellContainer()) == null) ? null : shellContainer6.getParent()) != null) {
                    PagerHolder pagerHolder14 = this.nextPagerHolder;
                    ViewParent parent2 = (pagerHolder14 == null || (shellContainer5 = pagerHolder14.getShellContainer()) == null) ? null : shellContainer5.getParent();
                    if (parent2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    ViewGroup viewGroup2 = (ViewGroup) parent2;
                    PagerHolder pagerHolder15 = this.nextPagerHolder;
                    viewGroup2.removeView(pagerHolder15 != null ? pagerHolder15.getShellContainer() : null);
                }
                PagerHolder pagerHolder16 = this.nextPagerHolder;
                if (pagerHolder16 != null && (mPage4 = pagerHolder16.getMPage()) != null) {
                    PagerHolder pagerHolder17 = this.nextPagerHolder;
                    mPage4.addView(pagerHolder17 != null ? pagerHolder17.getShellContainer() : null);
                }
                this.handler.post(new Runnable(this) { // from class: com.baidu.searchbox.live.list.controller.PagerController$prePageChanged$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PagerController this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        PagerController.ListPagerAdapter adapter3;
                        PagerController.PagerHolder pagerHolder18;
                        PagerController.PagerHolder pagerHolder19;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            adapter3 = this.this$0.getAdapter();
                            pagerHolder18 = this.this$0.nextPagerHolder;
                            pagerHolder19 = this.this$0.nextPagerHolder;
                            adapter3.onBindViewHolder(pagerHolder18, pagerHolder19 != null ? Integer.valueOf(pagerHolder19.getIndex()) : null);
                        }
                    }
                });
                StringBuilder sb2 = new StringBuilder();
                sb2.append("prePageChanged vec:");
                sb2.append(i);
                sb2.append(" index:");
                PagerHolder pagerHolder18 = this.nextPagerHolder;
                sb2.append(pagerHolder18 != null ? Integer.valueOf(pagerHolder18.getIndex()) : null);
                sb2.append(" \n shell:");
                PagerHolder pagerHolder19 = this.nextPagerHolder;
                sb2.append(pagerHolder19 != null ? pagerHolder19.getShellContainer() : null);
                sb2.append(" shellParent:");
                PagerHolder pagerHolder20 = this.nextPagerHolder;
                sb2.append((pagerHolder20 == null || (shellContainer4 = pagerHolder20.getShellContainer()) == null) ? null : shellContainer4.getParent());
                sb2.append("  \n page:{");
                PagerHolder pagerHolder21 = this.nextPagerHolder;
                sb2.append(pagerHolder21 != null ? pagerHolder21.getMPage() : null);
                sb2.append("} parent:{");
                PagerHolder pagerHolder22 = this.nextPagerHolder;
                if (pagerHolder22 != null && (mPage3 = pagerHolder22.getMPage()) != null) {
                    viewParent = mPage3.getParent();
                }
                sb2.append(viewParent);
                sb2.append('}');
                ListLogKt.log(MixTagConstants.MIX_PAGER, sb2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetCurRoomInternal(LiveContainer.LiveItemModel liveItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, liveItemModel) == null) {
            setCurrentLiveIndex(CollectionsKt___CollectionsKt.indexOf((List<? extends LiveContainer.LiveItemModel>) this.listController.getItemData(), this.listController.getCurRoomModel()));
            ListLogKt.log(MixTagConstants.MIX_PAGER, "resetCurRoom " + getCurrentLiveIndex());
            this.mSelectedPosition = 0;
            getAlaLoopViewPager().setCurrentItem(this.mSelectedPosition);
            this.listController.setCurRoomModel(liveItemModel);
            beforePageChanged(0);
            onPageChanged(0);
            afterPageChanged(0);
            getAlaLoopViewPager().setVisibility(0);
        }
    }

    private final void setCurrentLiveIndex(int i) {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, this, i) == null) {
            this.mCurrentLiveIndex = i;
            if (this.listController.getItemData().size() == 0) {
                size = 0;
            } else {
                int i2 = this.mCurrentLiveIndex;
                if (i2 < 0) {
                    size = this.listController.getItemData().size() + this.mCurrentLiveIndex;
                } else {
                    size = i2 % this.listController.getItemData().size();
                }
            }
            this.mCurrentLiveIndex = size;
            this.listController.setCurrentPosition(size);
        }
    }

    public final void afterPageChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            PagerHolder pagerHolder = this.prePagerHolder;
            if (pagerHolder != null) {
                View shellContainer = pagerHolder.getShellContainer();
                if (!(shellContainer instanceof LiveContainer)) {
                    shellContainer = null;
                }
                if (((LiveContainer) shellContainer) != null) {
                    ListLogKt.log(MixTagConstants.MIX_PAGER, "afterPageChanged removeAllViews page:" + pagerHolder.getMPage());
                    FrameLayout mPage = pagerHolder.getMPage();
                    if (mPage != null) {
                        mPage.removeView(pagerHolder.getShellContainer());
                    }
                }
                getAdapter().onDestroyViewHolder(pagerHolder);
            }
            this.prePagerHolder = null;
        }
    }

    public final void beforePageChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            PagerHolder pagerHolder = this.curPagerHolder;
            this.prePagerHolder = pagerHolder;
            if (pagerHolder != null) {
                pagerHolder.setDestroyVec(i);
            }
            PagerHolder pagerHolder2 = this.prePagerHolder;
            if (pagerHolder2 != null) {
                View shellContainer = pagerHolder2 != null ? pagerHolder2.getShellContainer() : null;
                if (!(shellContainer instanceof LiveContainer)) {
                    shellContainer = null;
                }
                LiveContainer liveContainer = (LiveContainer) shellContainer;
                if (liveContainer != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("beforePageChanged onDeselected ");
                    PagerHolder pagerHolder3 = this.prePagerHolder;
                    sb.append(pagerHolder3 != null ? Integer.valueOf(pagerHolder3.getIndex()) : null);
                    sb.append(" page:");
                    sb.append(pagerHolder2.getMPage());
                    ListLogKt.log(MixTagConstants.MIX_PAGER, sb.toString());
                    PagerHolder pagerHolder4 = this.prePagerHolder;
                    if (pagerHolder4 == null) {
                        Intrinsics.throwNpe();
                    }
                    int index = pagerHolder4.getIndex();
                    PagerHolder pagerHolder5 = this.prePagerHolder;
                    if (pagerHolder5 == null) {
                        Intrinsics.throwNpe();
                    }
                    LiveContainer.LiveItemModel curRoomModel = pagerHolder5.getCurRoomModel();
                    if (curRoomModel == null) {
                        Intrinsics.throwNpe();
                    }
                    liveContainer.onDeselected(index, curRoomModel);
                }
            }
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void clear(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public View createView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            getAlaLoopViewPager().setAdapter(getMPagerAdapter());
            getAlaLoopViewPager().setVisibility(8);
            return getAlaLoopViewPager();
        }
        return (View) invokeV.objValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.context : (Context) invokeV.objValue;
    }

    public final ListController getListController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.listController : (ListController) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void onCloseRoom(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Iterator<LiveContainer.LiveItemModel> it = this.listController.getItemData().iterator();
            while (it.hasNext()) {
                if (list.contains(it.next().getRoomId())) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            AlaLoopViewPagerAdapter mPagerAdapter = getMPagerAdapter();
            if (mPagerAdapter != null) {
                mPagerAdapter.onDestroy();
            }
            this.handler.removeCallbacksAndMessages(null);
            this.curPagerHolder = null;
            this.prePagerHolder = null;
            this.nextPagerHolder = null;
            getAdapter().onDestroy();
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void onListChange(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            setCurrentLiveIndex(CollectionsKt___CollectionsKt.indexOf((List<? extends LiveContainer.LiveItemModel>) this.listController.getItemData(), this.listController.getCurRoomModel()));
            PagerHolder pagerHolder = this.curPagerHolder;
            if (pagerHolder != null) {
                pagerHolder.setIndex(getCurrentLiveIndex());
            }
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void resetCurRoom(final LiveContainer.LiveItemModel liveItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, liveItemModel) == null) {
            if (MiniPluginManager.INSTANCE.getPluginMgrService().getPluginVersionCode("com.baidu.live.media.business") < 509999999) {
                this.handler.post(new Runnable(this, liveItemModel) { // from class: com.baidu.searchbox.live.list.controller.PagerController$resetCurRoom$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveContainer.LiveItemModel $itemModel;
                    public final /* synthetic */ PagerController this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, liveItemModel};
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
                        this.$itemModel = liveItemModel;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.resetCurRoomInternal(this.$itemModel);
                        }
                    }
                });
            } else {
                resetCurRoomInternal(liveItemModel);
            }
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void scrollToNextLiveRoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AlaLoopViewPager alaLoopViewPager = getAlaLoopViewPager();
            if (alaLoopViewPager != null) {
                AlaLoopViewPager alaLoopViewPager2 = getAlaLoopViewPager();
                alaLoopViewPager.setCurrentItem((alaLoopViewPager2 != null ? Integer.valueOf(alaLoopViewPager2.getCurrentItem()) : null).intValue() + 1, true);
            }
            onPageTurn();
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void scrollToPreLiveRoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            AlaLoopViewPager alaLoopViewPager = getAlaLoopViewPager();
            if (alaLoopViewPager != null) {
                AlaLoopViewPager alaLoopViewPager2 = getAlaLoopViewPager();
                alaLoopViewPager.setCurrentItem((alaLoopViewPager2 != null ? Integer.valueOf(alaLoopViewPager2.getCurrentItem()) : null).intValue() - 1, true);
            }
            onPageTurn();
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListManager
    public void setIsScrollable(boolean z) {
        AlaLoopViewPager alaLoopViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (alaLoopViewPager = getAlaLoopViewPager()) == null) {
            return;
        }
        alaLoopViewPager.setIsScrollable(z);
    }
}
