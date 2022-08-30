package com.baidu.live.business;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.LiveSubTabFragment;
import com.baidu.live.business.adapter.LiveFeedPageConcernAdapter;
import com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.listener.LiveFeedBannerListener;
import com.baidu.live.business.listener.LiveFeedFollowListener;
import com.baidu.live.business.listener.LiveFeedToolListener;
import com.baidu.live.business.listener.TabFeedActionListener;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveBannerWrapData;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.live.business.model.data.LiveFeedToolWrapData;
import com.baidu.live.business.model.data.LiveFollowEntity;
import com.baidu.live.business.model.data.LiveFollowWrapData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.view.FakeStartLiveButton;
import com.baidu.live.business.view.banner.BannerEntity;
import com.baidu.live.business.view.banner.BannerView;
import com.baidu.live.business.view.emotion.ErrorView;
import com.baidu.live.business.view.emotion.LoadingView;
import com.baidu.live.business.view.expandtab.LiveExpandTabView;
import com.baidu.live.business.view.recyclerview.InterceptTouchRecyclerView;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout;
import com.baidu.live.business.view.viewpager.NestedNoScrollViewPager;
import com.baidu.live.feedpage.interfaces.ILiveFeedOther;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.live.framework.appbar.AppBarLayout;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.bb0;
import com.baidu.tieba.la0;
import com.baidu.tieba.ma0;
import com.baidu.tieba.n80;
import com.baidu.tieba.p80;
import com.baidu.tieba.s80;
import com.baidu.tieba.t80;
import com.baidu.tieba.xa0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0096\u0001\u0018\u0000 \u009a\u00022\u00020\u0001:\u0004\u009a\u0002\u009b\u0002B.\b\u0007\u0012\b\u0010\u0094\u0002\u001a\u00030\u0093\u0002\u0012\f\b\u0002\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0095\u0002\u0012\t\b\u0002\u0010\u0097\u0002\u001a\u00020\u0012¢\u0006\u0006\b\u0098\u0002\u0010\u0099\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J!\u0010)\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u000b¢\u0006\u0004\b+\u0010\rJ\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\bJA\u00104\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00122\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u00010\u00152\b\u00103\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0004H\u0002¢\u0006\u0004\b6\u0010\bJ\u000f\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0004\b7\u0010\rJ\r\u00108\u001a\u00020\u000b¢\u0006\u0004\b8\u0010\rJ\r\u00109\u001a\u00020\u0004¢\u0006\u0004\b9\u0010\bJ\r\u0010:\u001a\u00020\u0004¢\u0006\u0004\b:\u0010\bJ\r\u0010;\u001a\u00020\u0004¢\u0006\u0004\b;\u0010\bJ\u0017\u0010=\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u0004¢\u0006\u0004\b?\u0010\bJ\u0017\u0010A\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010@¢\u0006\u0004\bA\u0010BJ\u0019\u0010D\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010C¢\u0006\u0004\bD\u0010EJ\u0015\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0012¢\u0006\u0004\bG\u0010 J\r\u0010H\u001a\u00020\u0004¢\u0006\u0004\bH\u0010\bJ\r\u0010I\u001a\u00020\u0004¢\u0006\u0004\bI\u0010\bJ\r\u0010J\u001a\u00020\u0004¢\u0006\u0004\bJ\u0010\bJ\r\u0010K\u001a\u00020\u0004¢\u0006\u0004\bK\u0010\bJ%\u0010L\u001a\u00020\u00042\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bL\u0010MJ\u0017\u0010P\u001a\u00020\u00042\b\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\bR\u0010SJ\r\u0010T\u001a\u00020\u0004¢\u0006\u0004\bT\u0010\bJ\u0017\u0010U\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0012H\u0002¢\u0006\u0004\bU\u0010 J\u0017\u0010W\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u000bH\u0002¢\u0006\u0004\bW\u0010SJ\u000f\u0010X\u001a\u00020\u0004H\u0002¢\u0006\u0004\bX\u0010\bJ\u0017\u0010Z\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bZ\u0010>J#\u0010]\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u000b2\b\b\u0002\u0010\\\u001a\u00020\u000bH\u0007¢\u0006\u0004\b]\u0010^J\u0015\u0010`\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u000b¢\u0006\u0004\b`\u0010SJ\u0017\u0010c\u001a\u00020\u00042\b\u0010b\u001a\u0004\u0018\u00010a¢\u0006\u0004\bc\u0010dJ\r\u0010e\u001a\u00020\u0004¢\u0006\u0004\be\u0010\bJ\r\u0010f\u001a\u00020\u0004¢\u0006\u0004\bf\u0010\bJ\u000f\u0010g\u001a\u00020\u0004H\u0002¢\u0006\u0004\bg\u0010\bJ\u0015\u0010i\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u000b¢\u0006\u0004\bi\u0010SJ\r\u0010j\u001a\u00020\u0004¢\u0006\u0004\bj\u0010\bJ\u000f\u0010k\u001a\u00020\u0004H\u0002¢\u0006\u0004\bk\u0010\bR%\u0010r\u001a\n m*\u0004\u0018\u00010l0l8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR$\u0010t\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR%\u0010{\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R,\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R,\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R \u0010\u009a\u0001\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0099\u0001\u0010o\u001a\u0005\b\u009a\u0001\u0010\rR'\u0010\u009b\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0005\b\u009b\u0001\u0010\r\"\u0005\b\u009d\u0001\u0010SR\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R,\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001b\u0010´\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R,\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010½\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010£\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R+\u0010Ä\u0001\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R\u001b\u0010Ê\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0019\u0010Ì\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010\u009c\u0001R\u0019\u0010Í\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010\u009c\u0001R\u0019\u0010Î\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u009c\u0001R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010Ï\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u001b\u0010Ò\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ë\u0001R\u001b\u0010Ó\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ë\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010µ\u0001R,\u0010Ö\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R*\u0010Ü\u0001\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÜ\u0001\u0010Ë\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0005\bß\u0001\u0010dR\u001b\u0010à\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010Ë\u0001R\u001b\u0010á\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010Ë\u0001R\u001c\u0010ã\u0001\u001a\u0005\u0018\u00010â\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u001c\u0010æ\u0001\u001a\u0005\u0018\u00010å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u001b\u0010è\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010µ\u0001R\u001c\u0010ê\u0001\u001a\u0005\u0018\u00010é\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R,\u0010í\u0001\u001a\u0005\u0018\u00010ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bí\u0001\u0010î\u0001\u001a\u0006\bï\u0001\u0010ð\u0001\"\u0006\bñ\u0001\u0010ò\u0001R\u001c\u0010ô\u0001\u001a\u0005\u0018\u00010ó\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0001\u0010õ\u0001R\u001f\u0010ö\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u001b\u0010ø\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010µ\u0001R\u001c\u0010ù\u0001\u001a\u0005\u0018\u00010å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ç\u0001R\u001b\u0010ú\u0001\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u001b\u0010ü\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010Ë\u0001R,\u0010þ\u0001\u001a\u0005\u0018\u00010ý\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002\"\u0006\b\u0082\u0002\u0010\u0083\u0002R\u001b\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0002\u0010\u0085\u0002R,\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0086\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R\u001c\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008d\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R\u001c\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0002\u0010\u0092\u0002¨\u0006\u009c\u0002"}, d2 = {"Lcom/baidu/live/business/LiveTabFeedView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/live/feedpage/interfaces/ILiveFeedOther$LiveFeedStatusListener;", "listener", "", "addLiveFeedStatusListener", "(Lcom/baidu/live/feedpage/interfaces/ILiveFeedOther$LiveFeedStatusListener;)V", "adjustCollapsingHeight", "()V", "animPause", "animResume", "", "canSlideDown", "()Z", "canSlideUp", "", "Lcom/baidu/live/business/model/data/LiveTabEntity;", "tabInfoList", "", "defaultTabPosition", "(Ljava/util/List;)I", "", "key", "getKeyWithUid", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/baidu/live/business/model/data/LiveFollowWrapData;", "liveFollowWrapData", "useNewStyle", "handleFollowData", "(Lcom/baidu/live/business/model/data/LiveFollowWrapData;Z)V", CriusAttrConstants.POSITION, "handleSubTab", "(I)V", "Lcom/baidu/live/business/model/data/LiveFeedData;", "feedData", "handleTabData", "(Lcom/baidu/live/business/model/data/LiveFeedData;)V", "Lcom/baidu/live/business/model/data/LiveFeedToolWrapData;", "toolWrapData", "Lcom/baidu/live/business/model/data/LiveFeedConfig;", "feedConfig", "handleToolData", "(Lcom/baidu/live/business/model/data/LiveFeedToolWrapData;Lcom/baidu/live/business/model/data/LiveFeedConfig;)V", "hasMore", "initBanner", "scene", "isHKTopBar", "bdUniqueId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "subTabType", "thirdTabType", "initUiScene", "(Ljava/lang/String;ZILandroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;)V", "initView", "isAppBarTopState", "isFirstTabIndicatorVisible", "notifyFragmentNetChange", "notifyPause", "notifyResume", "uiMode", "onDarkModeChange", "(Ljava/lang/String;)V", MissionEvent.MESSAGE_DESTROY, "Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnLoadMoreListener;", "onExternalLoadMore", "(Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnLoadMoreListener;)V", "Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnRefreshListener;", "onExternalRefresh", "(Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnRefreshListener;)V", "textSizeLevel", "onFontSizeChanged", "onPageHint", "onPageShow", MissionEvent.MESSAGE_PAUSE, "onResume", "onTabSelectedEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveBannerWrapData;", "liveBannerWrapData", "refreshBanner", "(Lcom/baidu/live/business/model/data/LiveBannerWrapData;)V", "refreshSpaceView", "(Z)V", "resetView", "selectSubTip", "scroll", "setAppBarScroll", "setAppBarScrollToTop", ILiveNPSPlugin.PARAMS_ROOM_ID, "setCurrentRoom", "expanded", "animate", "setExpanded", "(ZZ)V", "isNewTabStyle", "setTabStyle", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "show", "(Landroid/view/View;)V", "showContentView", "showErrorView", "showExpandTabPanel", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "showHideSearchGuideView", "showLoadingView", "updateSubTabInfo", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "kotlin.jvm.PlatformType", "accountManager$delegate", "Lkotlin/Lazy;", "getAccountManager", "()Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "accountManager", "Lcom/baidu/live/business/listener/TabFeedActionListener;", "feedActionListener", "Lcom/baidu/live/business/listener/TabFeedActionListener;", "getFeedActionListener", "()Lcom/baidu/live/business/listener/TabFeedActionListener;", "setFeedActionListener", "(Lcom/baidu/live/business/listener/TabFeedActionListener;)V", "Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "feedBannerListener", "Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "getFeedBannerListener", "()Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "setFeedBannerListener", "(Lcom/baidu/live/business/listener/LiveFeedBannerListener;)V", "Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "feedFollowListener", "Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "getFeedFollowListener", "()Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "setFeedFollowListener", "(Lcom/baidu/live/business/listener/LiveFeedFollowListener;)V", "Lcom/baidu/live/business/model/ILiveFeedModel;", "feedModel", "Lcom/baidu/live/business/model/ILiveFeedModel;", "getFeedModel", "()Lcom/baidu/live/business/model/ILiveFeedModel;", "setFeedModel", "(Lcom/baidu/live/business/model/ILiveFeedModel;)V", "Lcom/baidu/live/business/listener/LiveFeedToolListener;", "feedToolListener", "Lcom/baidu/live/business/listener/LiveFeedToolListener;", "getFeedToolListener", "()Lcom/baidu/live/business/listener/LiveFeedToolListener;", "setFeedToolListener", "(Lcom/baidu/live/business/listener/LiveFeedToolListener;)V", "com/baidu/live/business/LiveTabFeedView$followListener$1", "followListener", "Lcom/baidu/live/business/LiveTabFeedView$followListener$1;", "isHitTabAbTest$delegate", "isHitTabAbTest", "isViewPagerInFistPage", "Z", "setViewPagerInFistPage", "Lcom/baidu/live/framework/appbar/AppBarLayout;", "mAppBarLayout", "Lcom/baidu/live/framework/appbar/AppBarLayout;", "Landroid/widget/ImageView;", "mBackBtn", "Landroid/widget/ImageView;", "Lcom/baidu/live/business/view/banner/BannerView;", "mBannerView", "Lcom/baidu/live/business/view/banner/BannerView;", "Lcom/baidu/live/business/adapter/LiveFeedPageConcernAdapter;", "mConcernListAdapter", "Lcom/baidu/live/business/adapter/LiveFeedPageConcernAdapter;", "Lcom/baidu/live/business/view/recyclerview/InterceptTouchRecyclerView;", "mConcernListRecyclerView", "Lcom/baidu/live/business/view/recyclerview/InterceptTouchRecyclerView;", "getMConcernListRecyclerView", "()Lcom/baidu/live/business/view/recyclerview/InterceptTouchRecyclerView;", "setMConcernListRecyclerView", "(Lcom/baidu/live/business/view/recyclerview/InterceptTouchRecyclerView;)V", "Landroid/widget/Space;", "mContentTopSpace", "Landroid/widget/Space;", "mCurPlayingRoomId", "Ljava/lang/String;", "Lcom/baidu/live/business/view/emotion/ErrorView;", "mErrorView", "Lcom/baidu/live/business/view/emotion/ErrorView;", "getMErrorView", "()Lcom/baidu/live/business/view/emotion/ErrorView;", "setMErrorView", "(Lcom/baidu/live/business/view/emotion/ErrorView;)V", "mExpandTabBtn", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabView;", "mExpandTabView", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabView;", "Lcom/baidu/live/business/view/FakeStartLiveButton;", "mFakeStartLiveButton", "Lcom/baidu/live/business/view/FakeStartLiveButton;", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getMFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setMFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "mImmersionDivider", "Landroid/view/View;", "mIsBannerOk", "mIsHKTopBar", "mIsNewTabStyle", "Lcom/baidu/live/business/view/emotion/LoadingView;", "mLoadingView", "Lcom/baidu/live/business/view/emotion/LoadingView;", "mRootContainer", "mRootView", "mScene", "Lcom/baidu/live/business/view/smarttab/SmartTabLayout;", "mSmartTabLayout", "Lcom/baidu/live/business/view/smarttab/SmartTabLayout;", "getMSmartTabLayout", "()Lcom/baidu/live/business/view/smarttab/SmartTabLayout;", "setMSmartTabLayout", "(Lcom/baidu/live/business/view/smarttab/SmartTabLayout;)V", "mSmartTabLayoutContainer", "getMSmartTabLayoutContainer", "()Landroid/view/View;", "setMSmartTabLayoutContainer", "mSmartTabLeftCover", "mSmartTabRightCover", "Landroid/widget/TextView;", "mStartLiveBtn", "Landroid/widget/TextView;", "Landroid/widget/LinearLayout;", "mStartLiveContainer", "Landroid/widget/LinearLayout;", "mSubTabType", "Lcom/baidu/live/business/adapter/LiveFeedPageSubTipAdapter;", "mSubTipAdapter", "Lcom/baidu/live/business/adapter/LiveFeedPageSubTipAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "mSubTipLayout", "Landroidx/recyclerview/widget/RecyclerView;", "getMSubTipLayout", "()Landroidx/recyclerview/widget/RecyclerView;", "setMSubTipLayout", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/baidu/live/business/BaiduLiveTabAdapter;", "mTabAdapter", "Lcom/baidu/live/business/BaiduLiveTabAdapter;", "mTabInfo", "Ljava/util/List;", "mThirdTabType", "mTopBaseContainer", "mTopContentContainer", "Landroid/widget/FrameLayout;", "mTopSpaceView", "Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;", "mViewPager", "Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;", "getMViewPager", "()Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;", "setMViewPager", "(Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;)V", "pagerStatusListener", "Lcom/baidu/live/feedpage/interfaces/ILiveFeedOther$LiveFeedStatusListener;", "Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;", "subTabPageListener", "Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;", "getSubTabPageListener", "()Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;", "setSubTabPageListener", "(Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;)V", "Landroid/view/ViewGroup;", "tabOverallRegion", "Landroid/view/ViewGroup;", "Lcom/baidu/live/business/view/tool/LiveFeedPageToolFloatLayout;", "toolFloatLayout", "Lcom/baidu/live/business/view/tool/LiveFeedPageToolFloatLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "Scene", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveTabFeedView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ KProperty[] a0;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public LiveFeedPageToolFloatLayout B;
    public ImageView C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public String H;
    public String I;
    public List<? extends LiveTabEntity> J;
    public String K;
    public FragmentManager L;
    public boolean M;
    public ILiveFeedModel N;
    public TabFeedActionListener O;
    public LiveFeedBannerListener P;
    public LiveFeedFollowListener Q;
    public LiveBaseFragment.a R;
    public LiveFeedToolListener S;
    public ILiveFeedOther.LiveFeedStatusListener T;
    public final Lazy U;
    public final Lazy V;
    public a W;
    public View a;
    public View b;
    public AppBarLayout c;
    public NestedNoScrollViewPager d;
    public BaiduLiveTabAdapter e;
    public ViewGroup f;
    public View g;
    public SmartTabLayout h;
    public RecyclerView i;
    public InterceptTouchRecyclerView j;
    public LiveFeedPageSubTipAdapter k;
    public LiveFeedPageConcernAdapter l;
    public Space m;
    public FrameLayout n;
    public BannerView o;
    public LoadingView p;
    public ErrorView q;
    public LinearLayout r;
    public View s;
    public View t;
    public View u;
    public LiveExpandTabView v;
    public LinearLayout w;
    public TextView x;
    public FakeStartLiveButton y;
    public View z;

    /* loaded from: classes2.dex */
    public static final class a implements LiveFeedPageConcernAdapter.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.d
        public void a(LiveFollowEntity liveFollowEntity, int i) {
            LiveFeedFollowListener feedFollowListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, liveFollowEntity, i) == null) || (feedFollowListener = this.a.getFeedFollowListener()) == null) {
                return;
            }
            feedFollowListener.onFollowShow(liveFollowEntity, i);
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.d
        public void b(LiveFollowEntity liveFollowEntity, int i) {
            LiveFeedFollowListener feedFollowListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFollowEntity, i) == null) || (feedFollowListener = this.a.getFeedFollowListener()) == null) {
                return;
            }
            feedFollowListener.onClickFollow(liveFollowEntity, i);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;
        public final /* synthetic */ int b;

        public b(LiveTabFeedView liveTabFeedView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaiduLiveTabAdapter baiduLiveTabAdapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (baiduLiveTabAdapter = this.a.e) == null) {
                return;
            }
            baiduLiveTabAdapter.r(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements BannerView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public c(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.g
        public final void a(LiveBannerEntity liveBannerEntity) {
            LiveFeedBannerListener feedBannerListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) || (feedBannerListener = this.a.getFeedBannerListener()) == null) {
                return;
            }
            feedBannerListener.onClickBanner(liveBannerEntity);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements BannerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public d(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.i
        public final void onBannerShow(LiveBannerEntity it) {
            LiveFeedBannerListener feedBannerListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, it) == null) || (feedBannerListener = this.a.getFeedBannerListener()) == null) {
                return;
            }
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            feedBannerListener.onBannerShow(it);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements LiveSubTabFragment.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public e(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.LiveSubTabFragment.m
        public final void a(boolean z) {
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (liveFeedPageToolFloatLayout = this.a.B) == null) {
                return;
            }
            liveFeedPageToolFloatLayout.b(z);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements LiveFeedPageSubTipAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public f(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter.b
        public final void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                this.a.b0(i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements LiveExpandTabView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public g(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabView.b
        public void a(LiveTabEntity liveTabEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveTabEntity) == null) {
                LiveExpandTabView liveExpandTabView = this.a.v;
                if (liveExpandTabView != null) {
                    liveExpandTabView.b();
                }
                this.a.setExpanded(false, true);
                LiveTabFeedView.X(this.a, liveTabEntity.type, null, 2, null);
            }
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabView.b
        public void b() {
            LiveExpandTabView liveExpandTabView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (liveExpandTabView = this.a.v) == null) {
                return;
            }
            liveExpandTabView.b();
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabView.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.setAppBarScroll(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public h(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LiveTabFeedView liveTabFeedView = this.a;
                liveTabFeedView.d0(liveTabFeedView.p);
                TabFeedActionListener feedActionListener = this.a.getFeedActionListener();
                if (feedActionListener != null) {
                    feedActionListener.onClickErrorRefresh();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public i(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            TabFeedActionListener feedActionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (feedActionListener = this.a.getFeedActionListener()) == null) {
                return;
            }
            feedActionListener.onClickStartLive(view2, this.a.x);
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public j(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.getContext() instanceof Activity)) {
                Context context = this.a.getContext();
                if (context == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                }
                if (((Activity) context).isFinishing()) {
                    return;
                }
                Context context2 = this.a.getContext();
                if (context2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                }
                ((Activity) context2).finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public k(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LiveExpandTabView liveExpandTabView = this.a.v;
                if (liveExpandTabView != null) {
                    liveExpandTabView.setTabs(this.a.J, s80.a());
                }
                this.a.g0();
                this.a.setAppBarScroll(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class l implements LiveFeedPageToolFloatLayout.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public l(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                    ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                    if (invoker != null) {
                        invoker.invokeScheme(this.a.getContext(), str2);
                    }
                }
                LiveFeedToolListener feedToolListener = this.a.getFeedToolListener();
                if (feedToolListener != null) {
                    feedToolListener.onItemClick(str);
                }
            }
        }

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void b() {
            TabFeedActionListener feedActionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (feedActionListener = this.a.getFeedActionListener()) == null) {
                return;
            }
            feedActionListener.onClickSearch();
        }

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void onItemShow(String str) {
            LiveFeedToolListener feedToolListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (feedToolListener = this.a.getFeedToolListener()) == null) {
                return;
            }
            feedToolListener.onItemShow(str);
        }

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void onSearchShowing(boolean z) {
            TabFeedActionListener feedActionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (feedActionListener = this.a.getFeedActionListener()) == null) {
                return;
            }
            feedActionListener.onSearchShowing(z);
        }
    }

    /* loaded from: classes2.dex */
    public static final class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public m(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            TabFeedActionListener feedActionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (feedActionListener = this.a.getFeedActionListener()) == null) {
                return;
            }
            feedActionListener.onClickStartLive(view2, this.a.x);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements SmartTabLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public n(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.e
        public final void a(int i) {
            BaiduLiveTabAdapter baiduLiveTabAdapter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("二级 tab 点击：");
                sb.append(i);
                sb.append("   current：");
                NestedNoScrollViewPager mViewPager = this.a.getMViewPager();
                sb.append(mViewPager != null ? Integer.valueOf(mViewPager.getCurrentItem()) : null);
                LiveFeedPageSdk.liveLog(sb.toString());
                if (this.a.I() && this.a.G) {
                    this.a.setExpanded(false, true);
                }
                NestedNoScrollViewPager mViewPager2 = this.a.getMViewPager();
                if (mViewPager2 == null || mViewPager2.getCurrentItem() != i || (baiduLiveTabAdapter = this.a.e) == null) {
                    return;
                }
                baiduLiveTabAdapter.c(i, true, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class o implements SmartTabLayout.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public o(LiveTabFeedView liveTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.d
        public final void a(int i, int i2) {
            View view2;
            View view3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                SmartTabLayout mSmartTabLayout = this.a.getMSmartTabLayout();
                if (mSmartTabLayout == null || mSmartTabLayout.canScrollHorizontally(-1)) {
                    if ((!Intrinsics.areEqual(this.a.D, "recommend")) && (view2 = this.a.t) != null) {
                        view2.setVisibility(0);
                    }
                } else {
                    View view4 = this.a.t;
                    if (view4 != null) {
                        view4.setVisibility(8);
                    }
                }
                SmartTabLayout mSmartTabLayout2 = this.a.getMSmartTabLayout();
                if (mSmartTabLayout2 == null || mSmartTabLayout2.canScrollHorizontally(1)) {
                    if (!(!Intrinsics.areEqual(this.a.D, "recommend")) || (view3 = this.a.u) == null) {
                        return;
                    }
                    view3.setVisibility(0);
                    return;
                }
                View view5 = this.a.u;
                if (view5 != null) {
                    view5.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class p extends AppBarLayout.Behavior.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public p(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        @Override // com.baidu.live.framework.appbar.AppBarLayout.BaseBehavior.b
        public boolean a(AppBarLayout appBarLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, appBarLayout)) == null) ? this.a : invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public q(LiveTabFeedView liveTabFeedView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFeedView, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabFeedView;
            this.b = z;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppBarLayout appBarLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (appBarLayout = this.a.c) == null) {
                return;
            }
            appBarLayout.setExpanded(this.b, this.c);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053619223, "Lcom/baidu/live/business/LiveTabFeedView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1053619223, "Lcom/baidu/live/business/LiveTabFeedView;");
                return;
            }
        }
        a0 = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveTabFeedView.class), "accountManager", "getAccountManager()Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveTabFeedView.class), "isHitTabAbTest", "isHitTabAbTest()Z"))};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveTabFeedView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveTabFeedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public /* synthetic */ LiveTabFeedView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static /* synthetic */ void X(LiveTabFeedView liveTabFeedView, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        liveTabFeedView.W(str, str2);
    }

    private final AccountManagerService getAccountManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            Lazy lazy = this.U;
            KProperty kProperty = a0[0];
            return (AccountManagerService) lazy.getValue();
        }
        return (AccountManagerService) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAppBarScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, this, z) == null) {
            AppBarLayout appBarLayout = this.c;
            if ((appBarLayout != null ? appBarLayout.getLayoutParams() : null) instanceof CoordinatorLayout.e) {
                AppBarLayout appBarLayout2 = this.c;
                ViewGroup.LayoutParams layoutParams = appBarLayout2 != null ? appBarLayout2.getLayoutParams() : null;
                if (layoutParams != null) {
                    CoordinatorLayout.Behavior e2 = ((CoordinatorLayout.e) layoutParams).e();
                    AppBarLayout.Behavior behavior = e2 instanceof AppBarLayout.Behavior ? e2 : null;
                    if (behavior != null) {
                        behavior.m0(new p(z));
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.LayoutParams");
            }
        }
    }

    public static /* synthetic */ void setExpanded$default(LiveTabFeedView liveTabFeedView, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        liveTabFeedView.setExpanded(z, z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.live.business.BaiduLiveTabAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    public final void A(LiveFeedData liveFeedData) {
        LiveTabEntity f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, liveFeedData) == null) {
            List<LiveTabEntity> list = liveFeedData.tabWrapData.tabList;
            Intrinsics.checkExpressionValueIsNotNull(list, "feedData.tabWrapData.tabList");
            this.J = list;
            int w = w(list);
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.e;
            if (baiduLiveTabAdapter != 0) {
                baiduLiveTabAdapter.t(this.J, liveFeedData.feedWrapData, liveFeedData.feedConfig, liveFeedData.reserveWrapData, this.K);
            }
            SmartTabLayout smartTabLayout = this.h;
            if (smartTabLayout != null) {
                smartTabLayout.setViewPager(this.d, liveFeedData.feedConfig);
            }
            if (!ma0.c(this.J)) {
                s80.c(w);
                NestedNoScrollViewPager nestedNoScrollViewPager = this.d;
                if (nestedNoScrollViewPager != null) {
                    nestedNoScrollViewPager.setCurrentItem(w);
                }
            }
            NestedNoScrollViewPager nestedNoScrollViewPager2 = this.d;
            if (nestedNoScrollViewPager2 != null) {
                nestedNoScrollViewPager2.post(new b(this, w));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.e;
            this.H = (baiduLiveTabAdapter2 == null || (f2 = baiduLiveTabAdapter2.f(w)) == null) ? null : f2.type;
        }
    }

    public final void B(LiveFeedToolWrapData liveFeedToolWrapData, LiveFeedConfig liveFeedConfig) {
        LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedToolWrapData, liveFeedConfig) == null) || (liveFeedPageToolFloatLayout = this.B) == null) {
            return;
        }
        liveFeedPageToolFloatLayout.setData(liveFeedToolWrapData, liveFeedConfig);
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.e;
            if (baiduLiveTabAdapter != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager = this.d;
                if (baiduLiveTabAdapter.i(nestedNoScrollViewPager != null ? nestedNoScrollViewPager.getCurrentItem() : 0)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (Intrinsics.areEqual("recommend", this.D)) {
                FrameLayout frameLayout = this.n;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                BannerView bannerView = this.o;
                if (bannerView != null) {
                    bannerView.setVisibility(8);
                    return;
                }
                return;
            }
            BannerView bannerView2 = new BannerView(getContext());
            bannerView2.setShowRoundPicture(true, 10);
            bannerView2.setIndicatorGravity(81);
            Context context = bannerView2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            bannerView2.setIndicatorMargin(0, 0, 0, (int) n80.c(context.getResources(), 7.0f));
            Context context2 = bannerView2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            bannerView2.setLargeIndicatorItemSize((int) n80.c(context2.getResources(), 4.0f));
            Context context3 = bannerView2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            bannerView2.setSmallIndicatorItemSize((int) n80.c(context3.getResources(), 4.0f));
            Context context4 = bannerView2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context4, "context");
            bannerView2.setIndicatorInterval((int) n80.c(context4.getResources(), 6.0f));
            bannerView2.setAspectRatio(0.336f);
            bannerView2.setScene(this.D);
            bannerView2.setOnBannerClickListener(new c(this));
            bannerView2.setOnBannerShowListener(new d(this));
            this.o = bannerView2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout2 = this.n;
            if (frameLayout2 != null) {
                frameLayout2.addView(this.o, layoutParams);
            }
        }
    }

    public final void E(String str, boolean z, int i2, FragmentManager fragmentManager, String str2, String str3) {
        ImageView imageView;
        View view2;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        ImageView imageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), fragmentManager, str2, str3}) == null) {
            this.D = str;
            this.E = z;
            this.L = fragmentManager;
            this.H = str2;
            this.I = str3;
            String str4 = LiveFeedPageSdk.HOST_LIVE_TAB;
            if (str != null) {
                switch (str.hashCode()) {
                    case 989204668:
                        if (str.equals("recommend")) {
                            ImageView imageView3 = this.A;
                            if (imageView3 != null) {
                                imageView3.setVisibility(8);
                            }
                            View view3 = this.z;
                            if (view3 != null) {
                                view3.setVisibility(0);
                            }
                            SmartTabLayout smartTabLayout = this.h;
                            if (smartTabLayout != null) {
                                smartTabLayout.setShowBottomLine(true);
                            }
                            NestedNoScrollViewPager nestedNoScrollViewPager = this.d;
                            if (nestedNoScrollViewPager != null) {
                                nestedNoScrollViewPager.setCanScrollHorizontally(true);
                            }
                            SmartTabLayout smartTabLayout2 = this.h;
                            if (smartTabLayout2 != null) {
                                smartTabLayout2.setDarkModeCompatColor("color_white3", "color_sub_tab_normal");
                            }
                            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.B;
                            if (liveFeedPageToolFloatLayout != null) {
                                liveFeedPageToolFloatLayout.setVisibility(8);
                            }
                            RecyclerView recyclerView = this.i;
                            if (recyclerView != null && recyclerView != null) {
                                recyclerView.setPadding(0, n80.b(getContext(), 15.0f), 0, n80.b(getContext(), 12.0f));
                            }
                            InterceptTouchRecyclerView interceptTouchRecyclerView = this.j;
                            if (interceptTouchRecyclerView != null && interceptTouchRecyclerView != null) {
                                interceptTouchRecyclerView.setPadding(0, 0, 0, n80.b(getContext(), 9.0f));
                                break;
                            }
                        }
                        break;
                    case 1137617387:
                        if (str.equals(LiveFeedPageSdk.IMMERSION)) {
                            ImageView imageView4 = this.A;
                            if (imageView4 != null) {
                                imageView4.setVisibility(0);
                            }
                            if (la0.a() && (view2 = this.a) != null) {
                                view2.setPadding(0, la0.e(getContext()), 0, 0);
                            }
                            View view4 = this.z;
                            if (view4 != null) {
                                view4.setVisibility(0);
                            }
                            SmartTabLayout smartTabLayout3 = this.h;
                            if (smartTabLayout3 != null) {
                                smartTabLayout3.setShowBottomLine(true);
                            }
                            NestedNoScrollViewPager nestedNoScrollViewPager2 = this.d;
                            if (nestedNoScrollViewPager2 != null) {
                                nestedNoScrollViewPager2.setCanScrollHorizontally(true);
                            }
                            SmartTabLayout smartTabLayout4 = this.h;
                            if (smartTabLayout4 != null) {
                                smartTabLayout4.setDarkModeCompatColor("color_white3", "color_sub_tab_normal");
                            }
                            RecyclerView recyclerView2 = this.i;
                            if (recyclerView2 != null && recyclerView2 != null) {
                                recyclerView2.setPadding(0, n80.b(getContext(), 15.0f), 0, n80.b(getContext(), 12.0f));
                            }
                            InterceptTouchRecyclerView interceptTouchRecyclerView2 = this.j;
                            if (interceptTouchRecyclerView2 != null && interceptTouchRecyclerView2 != null) {
                                interceptTouchRecyclerView2.setPadding(0, 0, 0, n80.b(getContext(), 9.0f));
                            }
                            View view5 = this.u;
                            if (view5 != null) {
                                view5.setVisibility(0);
                            }
                            View view6 = this.t;
                            if (view6 != null) {
                                view6.setVisibility(0);
                            }
                            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual("baidu", liveFeedPageSdk.getHost()) && I() && this.G && (imageView = this.C) != null) {
                                imageView.setVisibility(0);
                                break;
                            }
                        }
                        break;
                    case 1333267023:
                        if (str.equals(LiveFeedPageSdk.VIDEO_BAR)) {
                            Space space = this.m;
                            if (space != null) {
                                if (space == null || (layoutParams = space.getLayoutParams()) == null) {
                                    layoutParams = null;
                                } else {
                                    layoutParams.height = n80.b(getContext(), 11.0f);
                                }
                                space.setLayoutParams(layoutParams);
                            }
                            ImageView imageView5 = this.A;
                            if (imageView5 != null) {
                                imageView5.setVisibility(8);
                            }
                            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout2 = this.B;
                            if (liveFeedPageToolFloatLayout2 != null) {
                                liveFeedPageToolFloatLayout2.setVisibility(8);
                            }
                            ViewGroup viewGroup = this.f;
                            if (viewGroup != null) {
                                viewGroup.setVisibility(8);
                            }
                            RecyclerView recyclerView3 = this.i;
                            if (recyclerView3 != null) {
                                recyclerView3.setVisibility(8);
                            }
                            NestedNoScrollViewPager nestedNoScrollViewPager3 = this.d;
                            if (nestedNoScrollViewPager3 != null) {
                                nestedNoScrollViewPager3.setCanScrollHorizontally(false);
                                break;
                            }
                        }
                        break;
                    case 1418021314:
                        if (str.equals(LiveFeedPageSdk.HOST_LIVE_TAB)) {
                            ImageView imageView6 = this.A;
                            if (imageView6 != null) {
                                imageView6.setVisibility(8);
                            }
                            View view7 = this.z;
                            if (view7 != null) {
                                view7.setVisibility(8);
                            }
                            LiveFeedPageSdk liveFeedPageSdk2 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk2, "LiveFeedPageSdk.getInstance()");
                            boolean z2 = Intrinsics.areEqual(LiveFeedPageSdk.HOST_HAOKAN, liveFeedPageSdk2.getHost()) && !this.E;
                            LinearLayout linearLayout = this.w;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(z2 ? 0 : 8);
                            }
                            SmartTabLayout smartTabLayout5 = this.h;
                            if (smartTabLayout5 != null) {
                                smartTabLayout5.setDarkModeCompatColor("color_FF33551", "color_sub_tab_normal");
                            }
                            LiveFeedPageSdk liveFeedPageSdk3 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk3, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_HAOKAN, liveFeedPageSdk3.getHost())) {
                                SmartTabLayout smartTabLayout6 = this.h;
                                if (smartTabLayout6 != null) {
                                    smartTabLayout6.setCustomTextsSize(n80.b(getContext(), 16.0f));
                                }
                                if (this.E) {
                                    SmartTabLayout smartTabLayout7 = this.h;
                                    if (smartTabLayout7 != null) {
                                        smartTabLayout7.setShowBottomLine(false);
                                    }
                                } else {
                                    SmartTabLayout smartTabLayout8 = this.h;
                                    if (smartTabLayout8 != null) {
                                        smartTabLayout8.setShowBottomLine(true);
                                    }
                                    SmartTabLayout smartTabLayout9 = this.h;
                                    if (smartTabLayout9 != null) {
                                        smartTabLayout9.setSelectedIndicatorColors(Color.parseColor("#222222"));
                                    }
                                }
                            }
                            LiveFeedPageSdk liveFeedPageSdk4 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk4, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual("baidu", liveFeedPageSdk4.getHost()) && I() && this.G && (imageView2 = this.C) != null) {
                                imageView2.setVisibility(0);
                            }
                            LiveFeedPageSdk liveFeedPageSdk5 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk5, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual("baidu", liveFeedPageSdk5.getHost()) && getAccountManager() != null) {
                                p80.e("last_time_enter_zhibo_channel_" + getAccountManager().getUid(), System.currentTimeMillis());
                            }
                            LiveFeedPageSdk liveFeedPageSdk6 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk6, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual("baidu", liveFeedPageSdk6.getHost())) {
                                long currentTimeMillis = System.currentTimeMillis();
                                if (p80.a(x("need_to_check"), true) && p80.a(x("user_clicked_add_channel_btn"), false)) {
                                    long c2 = p80.c(x("user_click_add_channel_time"), 0L);
                                    if (c2 != 0 && currentTimeMillis > c2 && p80.c(x("days_no_visit_live_channel"), 0L) != 0) {
                                        if (currentTimeMillis - c2 < p80.c(x("days_no_visit_live_channel"), 0L)) {
                                            p80.d(x("need_to_check"), false);
                                            p80.d(x("need_insert_live_channel_to_end"), false);
                                        } else {
                                            p80.d(x("need_to_check"), false);
                                        }
                                    }
                                }
                            }
                            View view8 = this.u;
                            if (view8 != null) {
                                view8.setVisibility(0);
                            }
                            View view9 = this.t;
                            if (view9 != null) {
                                view9.setVisibility(0);
                            }
                            View view10 = this.u;
                            if (view10 != null) {
                                if (z2) {
                                    ViewGroup.LayoutParams layoutParams3 = view10 != null ? view10.getLayoutParams() : null;
                                    if (layoutParams3 != null) {
                                        layoutParams2 = (RelativeLayout.LayoutParams) layoutParams3;
                                        layoutParams2.width = n80.b(getContext(), 60.0f);
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                                    }
                                } else {
                                    ViewGroup.LayoutParams layoutParams4 = view10 != null ? view10.getLayoutParams() : null;
                                    if (layoutParams4 != null) {
                                        layoutParams2 = (RelativeLayout.LayoutParams) layoutParams4;
                                        layoutParams2.width = n80.b(getContext(), 26.0f);
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                                    }
                                }
                                view10.setLayoutParams(layoutParams2);
                                break;
                            }
                        }
                        break;
                }
            }
            SmartTabLayout smartTabLayout10 = this.h;
            if (smartTabLayout10 != null) {
                smartTabLayout10.setScene(this.D);
            }
            LoadingView loadingView = this.p;
            if (loadingView != null) {
                loadingView.c(this.D);
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout3 = this.B;
            ViewGroup.LayoutParams layoutParams5 = liveFeedPageToolFloatLayout3 != null ? liveFeedPageToolFloatLayout3.getLayoutParams() : null;
            if (layoutParams5 != null) {
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
                if (Intrinsics.areEqual(LiveFeedPageSdk.IMMERSION, this.D)) {
                    layoutParams6.bottomMargin = n80.b(getContext(), 15.0f);
                } else {
                    Context context = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    layoutParams6.bottomMargin = xa0.e(n80.c(context.getResources(), 10.0f), 0, 0, 6, null);
                }
                LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout4 = this.B;
                if (liveFeedPageToolFloatLayout4 != null) {
                    liveFeedPageToolFloatLayout4.setLayoutParams(layoutParams6);
                }
                LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout5 = this.B;
                if (liveFeedPageToolFloatLayout5 != null) {
                    liveFeedPageToolFloatLayout5.setImmersion(Intrinsics.areEqual(LiveFeedPageSdk.IMMERSION, this.D));
                }
                ImageView imageView7 = this.A;
                if (imageView7 != null) {
                    Context context2 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                    float c3 = n80.c(context2.getResources(), 38.0f);
                    Context context3 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                    xa0.j(imageView7, c3, n80.c(context3.getResources(), 38.0f), 0, 0, 12, null);
                }
                BaiduLiveTabAdapter baiduLiveTabAdapter = new BaiduLiveTabAdapter(this.L, i2, this.D, this.I, this.N, this.R);
                this.e = baiduLiveTabAdapter;
                if (baiduLiveTabAdapter != null) {
                    baiduLiveTabAdapter.s(new e(this));
                }
                NestedNoScrollViewPager nestedNoScrollViewPager4 = this.d;
                if (nestedNoScrollViewPager4 != null) {
                    nestedNoScrollViewPager4.setAdapter(this.e);
                }
                LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = new LiveFeedPageSubTipAdapter(getContext(), this.D);
                this.k = liveFeedPageSubTipAdapter;
                if (liveFeedPageSubTipAdapter != null) {
                    liveFeedPageSubTipAdapter.k(new f(this));
                }
                RecyclerView recyclerView4 = this.i;
                if (recyclerView4 != null) {
                    recyclerView4.setAdapter(this.k);
                }
                LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(getContext(), this.D);
                this.l = liveFeedPageConcernAdapter;
                if (liveFeedPageConcernAdapter != null) {
                    liveFeedPageConcernAdapter.l(this.W);
                }
                InterceptTouchRecyclerView interceptTouchRecyclerView3 = this.j;
                if (interceptTouchRecyclerView3 != null) {
                    interceptTouchRecyclerView3.setAdapter(this.l);
                }
                D();
                LiveExpandTabView liveExpandTabView = this.v;
                if (liveExpandTabView != null) {
                    String str5 = this.D;
                    if (str5 != null) {
                        str4 = str5;
                    }
                    liveExpandTabView.c(str4);
                }
                LiveExpandTabView liveExpandTabView2 = this.v;
                if (liveExpandTabView2 != null) {
                    liveExpandTabView2.setLiveExpandTabViewListener(new g(this));
                }
                d0(this.p);
                N("day");
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0538, (ViewGroup) this, true);
            this.b = findViewById(R.id.obfuscated_res_0x7f09139f);
            this.c = (AppBarLayout) findViewById(R.id.obfuscated_res_0x7f091396);
            this.m = (Space) findViewById(R.id.obfuscated_res_0x7f091399);
            this.n = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091398);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0913a8);
            this.g = findViewById(R.id.obfuscated_res_0x7f0913a6);
            this.h = (SmartTabLayout) findViewById(R.id.obfuscated_res_0x7f0913a5);
            this.i = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0913aa);
            this.j = (InterceptTouchRecyclerView) findViewById(R.id.obfuscated_res_0x7f0913a0);
            this.r = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091397);
            this.s = findViewById(R.id.obfuscated_res_0x7f0913a1);
            this.t = findViewById(R.id.obfuscated_res_0x7f0913a7);
            this.u = findViewById(R.id.obfuscated_res_0x7f0913a9);
            this.w = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0913a2);
            this.x = (TextView) findViewById(R.id.obfuscated_res_0x7f0913a3);
            this.z = findViewById(R.id.obfuscated_res_0x7f0913a4);
            this.y = (FakeStartLiveButton) findViewById(R.id.obfuscated_res_0x7f091333);
            this.p = (LoadingView) findViewById(R.id.obfuscated_res_0x7f09139d);
            this.C = (ImageView) findViewById(R.id.obfuscated_res_0x7f09139b);
            this.v = (LiveExpandTabView) findViewById(R.id.obfuscated_res_0x7f09132a);
            FakeStartLiveButton fakeStartLiveButton = this.y;
            if (fakeStartLiveButton != null) {
                fakeStartLiveButton.setOnClickListener(new i(this));
            }
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091334);
            this.A = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new j(this));
            }
            View view2 = this.t;
            if (view2 != null) {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                xa0.m(view2, n80.c(context.getResources(), 8.0f), 0, 0, 6, null);
            }
            View view3 = this.u;
            if (view3 != null) {
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                xa0.m(view3, n80.c(context2.getResources(), 26.0f), 0, 0, 6, null);
            }
            ImageView imageView2 = this.C;
            if (imageView2 != null) {
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                float c2 = n80.c(context3.getResources(), 26.0f);
                Context context4 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                xa0.j(imageView2, c2, n80.c(context4.getResources(), 26.0f), 0, 0, 12, null);
            }
            ImageView imageView3 = this.C;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new k(this));
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = (LiveFeedPageToolFloatLayout) findViewById(R.id.obfuscated_res_0x7f091350);
            this.B = liveFeedPageToolFloatLayout;
            if (liveFeedPageToolFloatLayout != null) {
                liveFeedPageToolFloatLayout.setCallback(new l(this));
            }
            LinearLayout linearLayout = this.w;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new m(this));
            }
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager.setOrientation(0);
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(staggeredGridLayoutManager);
            }
            StaggeredGridLayoutManager staggeredGridLayoutManager2 = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager2.setOrientation(0);
            InterceptTouchRecyclerView interceptTouchRecyclerView = this.j;
            if (interceptTouchRecyclerView != null) {
                interceptTouchRecyclerView.setLayoutManager(staggeredGridLayoutManager2);
            }
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) findViewById(R.id.obfuscated_res_0x7f0913ab);
            nestedNoScrollViewPager.setId(FrameLayout.generateViewId());
            nestedNoScrollViewPager.setOffscreenPageLimit(1);
            nestedNoScrollViewPager.setSaveEnabled(false);
            this.d = nestedNoScrollViewPager;
            SmartTabLayout smartTabLayout = this.h;
            if (smartTabLayout != null) {
                smartTabLayout.setAllTabIsBold(false);
            }
            SmartTabLayout smartTabLayout2 = this.h;
            if (smartTabLayout2 != null) {
                smartTabLayout2.setTabSelectedColorEnable(true);
            }
            SmartTabLayout smartTabLayout3 = this.h;
            if (smartTabLayout3 != null) {
                smartTabLayout3.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.live.business.LiveTabFeedView$initView$7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveTabFeedView a;

                    /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
                        this.a = this;
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        }
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int i2, float f2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                        }
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int i2) {
                        SmartTabLayout mSmartTabLayout;
                        LiveTabEntity f2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                            LiveFeedPageSdk.liveLog("二级 tab 滑动/点击切换：" + i2);
                            int a2 = s80.a();
                            BaiduLiveTabAdapter baiduLiveTabAdapter = this.a.e;
                            if ((baiduLiveTabAdapter != null ? baiduLiveTabAdapter.getItem(a2) : null) instanceof LiveBaseFragment) {
                                BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.a.e;
                                Fragment item = baiduLiveTabAdapter2 != null ? baiduLiveTabAdapter2.getItem(a2) : null;
                                if (item == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.base.LiveBaseFragment");
                                }
                                ((LiveBaseFragment) item).w1(false);
                            }
                            LiveTabFeedView liveTabFeedView = this.a;
                            BaiduLiveTabAdapter baiduLiveTabAdapter3 = liveTabFeedView.e;
                            liveTabFeedView.H = (baiduLiveTabAdapter3 == null || (f2 = baiduLiveTabAdapter3.f(i2)) == null) ? null : f2.type;
                            s80.c(i2);
                            BaiduLiveTabAdapter baiduLiveTabAdapter4 = this.a.e;
                            if ((baiduLiveTabAdapter4 != null ? baiduLiveTabAdapter4.getItem(i2) : null) instanceof LiveBaseFragment) {
                                BaiduLiveTabAdapter baiduLiveTabAdapter5 = this.a.e;
                                Fragment item2 = baiduLiveTabAdapter5 != null ? baiduLiveTabAdapter5.getItem(i2) : null;
                                if (item2 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.base.LiveBaseFragment");
                                }
                                ((LiveBaseFragment) item2).w1(true);
                            }
                            this.a.z(i2);
                            SmartTabLayout mSmartTabLayout2 = this.a.getMSmartTabLayout();
                            if (mSmartTabLayout2 != null) {
                                mSmartTabLayout2.B("day");
                            }
                            if (this.a.G && Intrinsics.areEqual(LiveFeedPageSdk.HOST_LIVE_TAB, this.a.D) && (mSmartTabLayout = this.a.getMSmartTabLayout()) != null) {
                                mSmartTabLayout.A();
                            }
                            SmartTabLayout mSmartTabLayout3 = this.a.getMSmartTabLayout();
                            if (mSmartTabLayout3 != null) {
                                mSmartTabLayout3.setScrollLineVisibility(i2);
                            }
                            BaiduLiveTabAdapter baiduLiveTabAdapter6 = this.a.e;
                            if (baiduLiveTabAdapter6 != null) {
                                baiduLiveTabAdapter6.c(i2, true, true);
                            }
                            this.a.setViewPagerInFistPage(i2 == 0);
                        }
                    }
                });
            }
            SmartTabLayout smartTabLayout4 = this.h;
            if (smartTabLayout4 != null) {
                smartTabLayout4.setOnTabClickListener(new n(this));
            }
            SmartTabLayout smartTabLayout5 = this.h;
            if (smartTabLayout5 != null) {
                smartTabLayout5.setOnScrollChangeListener(new o(this));
            }
            ErrorView errorView = (ErrorView) findViewById(R.id.obfuscated_res_0x7f09139a);
            this.q = errorView;
            if (errorView != null) {
                errorView.setActionCallback(new h(this));
            }
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AppBarLayout appBarLayout = this.c;
            if ((appBarLayout != null ? appBarLayout.getLayoutParams() : null) instanceof CoordinatorLayout.e) {
                AppBarLayout appBarLayout2 = this.c;
                ViewGroup.LayoutParams layoutParams = appBarLayout2 != null ? appBarLayout2.getLayoutParams() : null;
                if (layoutParams != null) {
                    CoordinatorLayout.Behavior e2 = ((CoordinatorLayout.e) layoutParams).e();
                    AppBarLayout.Behavior behavior = e2 instanceof AppBarLayout.Behavior ? e2 : null;
                    return behavior != null && behavior.E() == 0;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.LayoutParams");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SmartTabLayout smartTabLayout = this.h;
            return (smartTabLayout == null || smartTabLayout.canScrollHorizontally(-1)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Lazy lazy = this.V;
            KProperty kProperty = a0[1];
            return ((Boolean) lazy.getValue()).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public final void K() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (nestedNoScrollViewPager = this.d) == null || (baiduLiveTabAdapter = this.e) == null) {
            return;
        }
        if (nestedNoScrollViewPager == null) {
            Intrinsics.throwNpe();
        }
        baiduLiveTabAdapter.j(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void L() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (nestedNoScrollViewPager = this.d) == null || (baiduLiveTabAdapter = this.e) == null) {
            return;
        }
        if (nestedNoScrollViewPager == null) {
            Intrinsics.throwNpe();
        }
        baiduLiveTabAdapter.k(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void M() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (nestedNoScrollViewPager = this.d) == null || (baiduLiveTabAdapter = this.e) == null) {
            return;
        }
        if (nestedNoScrollViewPager == null) {
            Intrinsics.throwNpe();
        }
        baiduLiveTabAdapter.l(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            View view2 = this.a;
            if (view2 != null) {
                view2.setBackgroundColor(bb0.f().a(getContext(), this.D, "color_main_bg"));
            }
            View view3 = this.s;
            if (view3 != null) {
                view3.setBackgroundColor(bb0.f().a(getContext(), this.D, "color_F5F5F52"));
            }
            TextView textView = this.x;
            if (textView != null) {
                textView.setTextColor(bb0.f().a(getContext(), this.D, "color_1F1F1F"));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.e;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.m(str);
            }
            ErrorView errorView = this.q;
            if (errorView != null) {
                errorView.c(this.D);
            }
            LoadingView loadingView = this.p;
            if (loadingView != null) {
                loadingView.c(this.D);
            }
            BannerView bannerView = this.o;
            if (bannerView != null) {
                bannerView.u(str);
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.l;
            if (liveFeedPageConcernAdapter != null) {
                liveFeedPageConcernAdapter.notifyDataSetChanged();
            }
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.k;
            if (liveFeedPageSubTipAdapter != null) {
                liveFeedPageSubTipAdapter.notifyDataSetChanged();
            }
            SmartTabLayout smartTabLayout = this.h;
            if (smartTabLayout != null) {
                smartTabLayout.B(str);
            }
            SmartTabLayout smartTabLayout2 = this.h;
            if (smartTabLayout2 != null) {
                smartTabLayout2.A();
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.B;
            if (liveFeedPageToolFloatLayout != null) {
                bb0 f2 = bb0.f();
                Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
                liveFeedPageToolFloatLayout.d(f2.q());
            }
            ImageView imageView = this.C;
            if (imageView != null) {
                t80 t80Var = t80.a;
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                imageView.setBackgroundDrawable(t80Var.b(context, this.D));
            }
            LiveExpandTabView liveExpandTabView = this.v;
            if (liveExpandTabView != null) {
                liveExpandTabView.d(str);
            }
            View view4 = this.t;
            if (view4 != null) {
                t80 t80Var2 = t80.a;
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                view4.setBackgroundDrawable(t80Var2.a(context2, this.D, str));
            }
            View view5 = this.u;
            if (view5 != null) {
                t80 t80Var3 = t80.a;
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                view5.setBackgroundDrawable(t80Var3.d(context3, this.D, str));
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            BannerView bannerView = this.o;
            if (bannerView != null) {
                bannerView.v();
            }
            LoadingView loadingView = this.p;
            if (loadingView != null) {
                loadingView.a();
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.e;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.onDestroy();
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.B;
            if (liveFeedPageToolFloatLayout != null) {
                liveFeedPageToolFloatLayout.f();
            }
        }
    }

    public final void P(ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, onLoadMoreListener) == null) || (baiduLiveTabAdapter = this.e) == null) {
            return;
        }
        NestedNoScrollViewPager nestedNoScrollViewPager = this.d;
        baiduLiveTabAdapter.n(nestedNoScrollViewPager != null ? nestedNoScrollViewPager.getCurrentItem() : 0, onLoadMoreListener);
    }

    public final void Q(ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onRefreshListener) == null) {
            if (Intrinsics.areEqual(this.D, LiveFeedPageSdk.VIDEO_BAR)) {
                c0();
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.e;
            if (baiduLiveTabAdapter != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager = this.d;
                baiduLiveTabAdapter.d(nestedNoScrollViewPager != null ? nestedNoScrollViewPager.getCurrentItem() : 0, true, true, onRefreshListener);
            }
        }
    }

    public final void R(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            View view2 = this.t;
            if (view2 != null) {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                xa0.m(view2, n80.c(context.getResources(), 8.0f), 0, 0, 6, null);
            }
            View view3 = this.u;
            if (view3 != null) {
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                xa0.m(view3, n80.c(context2.getResources(), 26.0f), 0, 0, 6, null);
            }
            ImageView imageView = this.C;
            if (imageView != null) {
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                float c2 = n80.c(context3.getResources(), 26.0f);
                Context context4 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                xa0.j(imageView, c2, n80.c(context4.getResources(), 26.0f), 0, 0, 12, null);
            }
            LiveExpandTabView liveExpandTabView = this.v;
            if (liveExpandTabView != null) {
                liveExpandTabView.e();
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.l;
            if (liveFeedPageConcernAdapter != null) {
                liveFeedPageConcernAdapter.notifyDataSetChanged();
            }
            SmartTabLayout smartTabLayout = this.h;
            if (smartTabLayout != null) {
                smartTabLayout.C();
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.B;
            if (liveFeedPageToolFloatLayout != null) {
                liveFeedPageToolFloatLayout.e();
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.e;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.o();
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout2 = this.B;
            ViewGroup.LayoutParams layoutParams = liveFeedPageToolFloatLayout2 != null ? liveFeedPageToolFloatLayout2.getLayoutParams() : null;
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_LIVE_TAB, this.D)) {
                    Context context5 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context5, "context");
                    layoutParams2.bottomMargin = xa0.e(n80.c(context5.getResources(), 10.0f), 0, 0, 6, null);
                }
                LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout3 = this.B;
                if (liveFeedPageToolFloatLayout3 != null) {
                    liveFeedPageToolFloatLayout3.setLayoutParams(layoutParams2);
                }
                ImageView imageView2 = this.A;
                if (imageView2 != null) {
                    Context context6 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context6, "context");
                    float c3 = n80.c(context6.getResources(), 38.0f);
                    Context context7 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context7, "context");
                    xa0.j(imageView2, c3, n80.c(context7.getResources(), 38.0f), 0, 0, 12, null);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    public final void S() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            NestedNoScrollViewPager nestedNoScrollViewPager = this.d;
            if (nestedNoScrollViewPager != null && (baiduLiveTabAdapter = this.e) != null) {
                if (nestedNoScrollViewPager == null) {
                    Intrinsics.throwNpe();
                }
                baiduLiveTabAdapter.p(nestedNoScrollViewPager.getCurrentItem());
            }
            LiveExpandTabView liveExpandTabView = this.v;
            if (liveExpandTabView != null) {
                liveExpandTabView.b();
            }
        }
    }

    public final void T() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (nestedNoScrollViewPager = this.d) == null || (baiduLiveTabAdapter = this.e) == null) {
            return;
        }
        if (nestedNoScrollViewPager == null) {
            Intrinsics.throwNpe();
        }
        baiduLiveTabAdapter.q(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LoadingView loadingView = this.p;
            if (loadingView != null) {
                loadingView.d();
            }
            s();
            L();
            LiveExpandTabView liveExpandTabView = this.v;
            if (liveExpandTabView != null) {
                liveExpandTabView.b();
            }
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LoadingView loadingView = this.p;
            if (loadingView != null) {
                loadingView.e();
            }
            t();
            M();
        }
    }

    public final void W(String str, String str2) {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (TextUtils.isEmpty(str) || !Intrinsics.areEqual(str, this.H) || TextUtils.isEmpty(str2) || !Intrinsics.areEqual(str2, this.I)) {
                if (!Intrinsics.areEqual(str, this.H)) {
                    if (this.e != null) {
                        LiveFeedPageSdk.liveLog("D8800088 onTabSelectedEvent 二级Tab不一致，需要重新设定");
                        this.H = str;
                        this.I = str2;
                        BaiduLiveTabAdapter baiduLiveTabAdapter = this.e;
                        int e2 = baiduLiveTabAdapter != null ? baiduLiveTabAdapter.e(str) : -1;
                        LiveFeedPageSdk.liveLog("D8800088 selectedPos = " + e2 + ", LiveTabUtil.getCurFragPos() = " + s80.a());
                        if (e2 == -1 || e2 == s80.a() || (nestedNoScrollViewPager = this.d) == null) {
                            return;
                        }
                        nestedNoScrollViewPager.setCurrentItem(e2);
                    }
                } else if (!Intrinsics.areEqual(str2, this.I)) {
                    this.I = str2;
                    LiveFeedPageSdk.liveLog("D8800088 onTabSelectedEvent 3333级Tab不一致，需要重新设定");
                    LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.k;
                    int e3 = liveFeedPageSubTipAdapter != null ? liveFeedPageSubTipAdapter.e(this.I) : -1;
                    StringBuilder sb = new StringBuilder();
                    sb.append("D8800088 selectedPos = ");
                    sb.append(e3);
                    sb.append(", mSubTipAdapter.getSelectPos() = ");
                    LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter2 = this.k;
                    sb.append(liveFeedPageSubTipAdapter2 != null ? Integer.valueOf(liveFeedPageSubTipAdapter2.f()) : null);
                    LiveFeedPageSdk.liveLog(sb.toString());
                    b0(e3);
                }
            }
        }
    }

    public final void Y(LiveBannerWrapData liveBannerWrapData) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, liveBannerWrapData) == null) || this.o == null || this.n == null) {
            return;
        }
        int i2 = 0;
        if (!Intrinsics.areEqual(this.D, LiveFeedPageSdk.IMMERSION) && !Intrinsics.areEqual(this.D, "recommend")) {
            if (liveBannerWrapData != null) {
                if (!ma0.c(liveBannerWrapData.bannerList)) {
                    List<LiveBannerEntity> list = liveBannerWrapData.bannerList;
                    BannerView bannerView2 = this.o;
                    if (bannerView2 != null && bannerView2.r(list) && (bannerView = this.o) != null) {
                        BannerEntity bannerEntity = new BannerEntity();
                        bannerEntity.mBannerList = list;
                        bannerEntity.mBroadcastInterval = 5000;
                        bannerView.setBannerEntity(bannerEntity);
                    }
                    BannerView bannerView3 = this.o;
                    if (bannerView3 != null) {
                        bannerView3.setVisibility(0);
                    }
                    this.F = true;
                } else {
                    this.F = false;
                    BannerView bannerView4 = this.o;
                    if (bannerView4 != null) {
                        bannerView4.setVisibility(8);
                    }
                }
            } else {
                this.F = false;
                BannerView bannerView5 = this.o;
                if (bannerView5 != null) {
                    bannerView5.setVisibility(8);
                }
            }
            FrameLayout frameLayout = this.n;
            if (frameLayout != null) {
                BannerView bannerView6 = this.o;
                frameLayout.setVisibility((bannerView6 == null || bannerView6.getVisibility() != 0) ? 8 : 8);
                return;
            }
            return;
        }
        FrameLayout frameLayout2 = this.n;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        BannerView bannerView7 = this.o;
        if (bannerView7 != null) {
            bannerView7.setVisibility(8);
        }
        s();
        this.F = false;
    }

    public final void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || this.s == null) {
            return;
        }
        InterceptTouchRecyclerView interceptTouchRecyclerView = this.j;
        boolean z2 = true;
        if (interceptTouchRecyclerView != null && (interceptTouchRecyclerView == null || interceptTouchRecyclerView.getVisibility() != 0)) {
            z2 = false;
        }
        if (z2 && !Intrinsics.areEqual(LiveFeedPageSdk.IMMERSION, this.D) && !Intrinsics.areEqual("recommend", this.D) && !z) {
            View view2 = this.s;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view3 = this.s;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            O();
            s80.b();
            SmartTabLayout smartTabLayout = this.h;
            if (smartTabLayout != null) {
                smartTabLayout.E();
            }
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.k;
            if (liveFeedPageSubTipAdapter != null) {
                liveFeedPageSubTipAdapter.j();
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.l;
            if (liveFeedPageConcernAdapter != null) {
                liveFeedPageConcernAdapter.i();
            }
        }
    }

    public final void b0(int i2) {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.k;
            int f2 = liveFeedPageSubTipAdapter != null ? liveFeedPageSubTipAdapter.f() : 0;
            LiveFeedPageSdk.liveLog("三级 Tab 点击 pre: " + f2 + GlideException.IndentedAppendable.INDENT + i2);
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter2 = this.k;
            if (liveFeedPageSubTipAdapter2 != null) {
                liveFeedPageSubTipAdapter2.l(i2);
            }
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter3 = this.k;
            if (liveFeedPageSubTipAdapter3 != null) {
                liveFeedPageSubTipAdapter3.notifyDataSetChanged();
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.e;
            if (baiduLiveTabAdapter2 == null || (nestedNoScrollViewPager = this.d) == null) {
                return;
            }
            if (f2 != i2 && baiduLiveTabAdapter2 != null) {
                if (nestedNoScrollViewPager == null) {
                    Intrinsics.throwNpe();
                }
                baiduLiveTabAdapter2.p(nestedNoScrollViewPager.getCurrentItem());
            }
            j0();
            if (f2 != i2 && (baiduLiveTabAdapter = this.e) != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager2 = this.d;
                if (nestedNoScrollViewPager2 == null) {
                    Intrinsics.throwNpe();
                }
                baiduLiveTabAdapter.q(nestedNoScrollViewPager2.getCurrentItem());
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter3 = this.e;
            if (baiduLiveTabAdapter3 != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager3 = this.d;
                if (nestedNoScrollViewPager3 == null) {
                    Intrinsics.throwNpe();
                }
                baiduLiveTabAdapter3.c(nestedNoScrollViewPager3.getCurrentItem(), true, f2 == i2);
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            AppBarLayout appBarLayout = this.c;
            if ((appBarLayout != null ? appBarLayout.getLayoutParams() : null) instanceof CoordinatorLayout.e) {
                AppBarLayout appBarLayout2 = this.c;
                ViewGroup.LayoutParams layoutParams = appBarLayout2 != null ? appBarLayout2.getLayoutParams() : null;
                if (layoutParams != null) {
                    CoordinatorLayout.Behavior e2 = ((CoordinatorLayout.e) layoutParams).e();
                    AppBarLayout.Behavior behavior = e2 instanceof AppBarLayout.Behavior ? e2 : null;
                    if (behavior == null || behavior.E() == 0) {
                        return;
                    }
                    behavior.G(0);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.LayoutParams");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
        if (r5.E == false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d0(View view2) {
        ErrorView errorView;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener2;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view2) == null) {
            int i2 = 0;
            if (Intrinsics.areEqual(LiveFeedPageSdk.VIDEO_BAR, this.D)) {
                ErrorView errorView2 = this.q;
                if (errorView2 != null) {
                    errorView2.d(8);
                }
                LoadingView loadingView = this.p;
                if (loadingView != null) {
                    loadingView.setVisibility(8);
                }
                if (Intrinsics.areEqual(view2, this.q) && (liveFeedStatusListener3 = this.T) != null) {
                    liveFeedStatusListener3.onError();
                }
                if (Intrinsics.areEqual(view2, this.p) && (liveFeedStatusListener2 = this.T) != null) {
                    liveFeedStatusListener2.onLoading();
                }
                if (Intrinsics.areEqual(view2, this.b) && (liveFeedStatusListener = this.T) != null) {
                    liveFeedStatusListener.onLoadSuccess();
                }
            } else {
                ErrorView errorView3 = this.q;
                if (errorView3 != null) {
                    errorView3.e(Intrinsics.areEqual(view2, errorView3) ? 0 : 8, this.D);
                }
                LoadingView loadingView2 = this.p;
                if (loadingView2 != null) {
                    loadingView2.setVisibility(Intrinsics.areEqual(view2, loadingView2) ? 0 : 8);
                }
            }
            View view3 = this.b;
            if (view3 != null) {
                view3.setVisibility(Intrinsics.areEqual(view2, view3) ? 0 : 4);
            }
            FakeStartLiveButton fakeStartLiveButton = this.y;
            if (fakeStartLiveButton == null || (errorView = this.q) == null || fakeStartLiveButton == null) {
                return;
            }
            if (errorView != null && errorView.getVisibility() == 0) {
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_HAOKAN, liveFeedPageSdk.getHost())) {
                }
            }
            i2 = 8;
            fakeStartLiveButton.setVisibility(i2);
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            d0(this.b);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            d0(this.q);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            int[] iArr = new int[2];
            View view2 = this.g;
            if (view2 != null) {
                view2.getLocationOnScreen(iArr);
            }
            int[] iArr2 = new int[2];
            View view3 = this.b;
            if (view3 != null) {
                view3.getLocationOnScreen(iArr2);
            }
            int i2 = iArr[1] - iArr2[1];
            LiveExpandTabView liveExpandTabView = this.v;
            if (liveExpandTabView != null) {
                ViewGroup.LayoutParams layoutParams = liveExpandTabView != null ? liveExpandTabView.getLayoutParams() : null;
                if (layoutParams == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = i2;
                liveExpandTabView.setLayoutParams(layoutParams2);
            }
            LiveExpandTabView liveExpandTabView2 = this.v;
            if (liveExpandTabView2 != null) {
                liveExpandTabView2.setVisibility(0);
            }
        }
    }

    public final TabFeedActionListener getFeedActionListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.O : (TabFeedActionListener) invokeV.objValue;
    }

    public final LiveFeedBannerListener getFeedBannerListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.P : (LiveFeedBannerListener) invokeV.objValue;
    }

    public final LiveFeedFollowListener getFeedFollowListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.Q : (LiveFeedFollowListener) invokeV.objValue;
    }

    public final ILiveFeedModel getFeedModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.N : (ILiveFeedModel) invokeV.objValue;
    }

    public final LiveFeedToolListener getFeedToolListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.S : (LiveFeedToolListener) invokeV.objValue;
    }

    public final InterceptTouchRecyclerView getMConcernListRecyclerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.j : (InterceptTouchRecyclerView) invokeV.objValue;
    }

    public final ErrorView getMErrorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.q : (ErrorView) invokeV.objValue;
    }

    public final FragmentManager getMFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.L : (FragmentManager) invokeV.objValue;
    }

    public final SmartTabLayout getMSmartTabLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.h : (SmartTabLayout) invokeV.objValue;
    }

    public final View getMSmartTabLayoutContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.g : (View) invokeV.objValue;
    }

    public final RecyclerView getMSubTipLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.i : (RecyclerView) invokeV.objValue;
    }

    public final NestedNoScrollViewPager getMViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.d : (NestedNoScrollViewPager) invokeV.objValue;
    }

    public final LiveBaseFragment.a getSubTabPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.R : (LiveBaseFragment.a) invokeV.objValue;
    }

    public final void h0(boolean z) {
        LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048621, this, z) == null) || (liveFeedPageToolFloatLayout = this.B) == null) {
            return;
        }
        liveFeedPageToolFloatLayout.setSearchGuideShowing(z);
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            d0(this.p);
        }
    }

    public final void j0() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity liveTabEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (baiduLiveTabAdapter = this.e) == null || (nestedNoScrollViewPager = this.d) == null) {
            return;
        }
        if (baiduLiveTabAdapter != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            liveTabEntity = baiduLiveTabAdapter.f(nestedNoScrollViewPager.getCurrentItem());
        } else {
            liveTabEntity = null;
        }
        if (liveTabEntity == null || TextUtils.isEmpty(liveTabEntity.type)) {
            return;
        }
        LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.k;
        LiveTabEntity.TabLabelInfo g2 = liveFeedPageSubTipAdapter != null ? liveFeedPageSubTipAdapter.g() : null;
        this.I = g2 != null ? g2.type : "";
        BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.e;
        if (baiduLiveTabAdapter2 != null) {
            String str = liveTabEntity.type;
            String str2 = g2 != null ? g2.type : "";
            NestedNoScrollViewPager nestedNoScrollViewPager2 = this.d;
            if (nestedNoScrollViewPager2 == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter2.u(str, str2, nestedNoScrollViewPager2.getCurrentItem());
        }
    }

    public final void q(ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, liveFeedStatusListener) == null) {
            this.T = liveFeedStatusListener;
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.e;
            if (baiduLiveTabAdapter != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager = this.d;
                baiduLiveTabAdapter.b(nestedNoScrollViewPager != null ? nestedNoScrollViewPager.getCurrentItem() : 0, liveFeedStatusListener);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            int i2 = (Intrinsics.areEqual(LiveFeedPageSdk.IMMERSION, this.D) || Intrinsics.areEqual("recommend", this.D)) ? 93 : 81;
            int i3 = Intrinsics.areEqual(LiveFeedPageSdk.VIDEO_BAR, this.D) ? 0 : 42;
            LinearLayout linearLayout = this.r;
            if (linearLayout != null) {
                Context context = getContext();
                RecyclerView recyclerView = this.i;
                linearLayout.setMinimumHeight(n80.b(context, (recyclerView == null || recyclerView.getVisibility() != 0) ? i3 : i2));
            }
        }
    }

    public final void s() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (bannerView = this.o) == null) {
            return;
        }
        bannerView.w();
    }

    public final void setCurrentRoom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.K = str;
        }
    }

    @JvmOverloads
    public final void setExpanded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            setExpanded$default(this, false, false, 3, null);
        }
    }

    @JvmOverloads
    public final void setExpanded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            setExpanded$default(this, z, false, 2, null);
        }
    }

    @JvmOverloads
    public final void setExpanded(boolean z, boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (appBarLayout = this.c) == null) {
            return;
        }
        appBarLayout.post(new q(this, z, z2));
    }

    public final void setFeedActionListener(TabFeedActionListener tabFeedActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, tabFeedActionListener) == null) {
            this.O = tabFeedActionListener;
        }
    }

    public final void setFeedBannerListener(LiveFeedBannerListener liveFeedBannerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, liveFeedBannerListener) == null) {
            this.P = liveFeedBannerListener;
        }
    }

    public final void setFeedFollowListener(LiveFeedFollowListener liveFeedFollowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, liveFeedFollowListener) == null) {
            this.Q = liveFeedFollowListener;
        }
    }

    public final void setFeedModel(ILiveFeedModel iLiveFeedModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, iLiveFeedModel) == null) {
            this.N = iLiveFeedModel;
        }
    }

    public final void setFeedToolListener(LiveFeedToolListener liveFeedToolListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, liveFeedToolListener) == null) {
            this.S = liveFeedToolListener;
        }
    }

    public final void setMConcernListRecyclerView(InterceptTouchRecyclerView interceptTouchRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, interceptTouchRecyclerView) == null) {
            this.j = interceptTouchRecyclerView;
        }
    }

    public final void setMErrorView(ErrorView errorView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, errorView) == null) {
            this.q = errorView;
        }
    }

    public final void setMFragmentManager(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, fragmentManager) == null) {
            this.L = fragmentManager;
        }
    }

    public final void setMSmartTabLayout(SmartTabLayout smartTabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, smartTabLayout) == null) {
            this.h = smartTabLayout;
        }
    }

    public final void setMSmartTabLayoutContainer(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, view2) == null) {
            this.g = view2;
        }
    }

    public final void setMSubTipLayout(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, recyclerView) == null) {
            this.i = recyclerView;
        }
    }

    public final void setMViewPager(NestedNoScrollViewPager nestedNoScrollViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, nestedNoScrollViewPager) == null) {
            this.d = nestedNoScrollViewPager;
        }
    }

    public final void setSubTabPageListener(LiveBaseFragment.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, aVar) == null) {
            this.R = aVar;
        }
    }

    public final void setTabStyle(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.G = z;
            if (z && Intrinsics.areEqual(LiveFeedPageSdk.HOST_LIVE_TAB, this.D)) {
                View view2 = this.g;
                ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
                if (layoutParams != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.setMargins(n80.b(getContext(), 12.0f), 0, n80.b(getContext(), 6.0f), 0);
                    View view3 = this.g;
                    if (view3 != null) {
                        view3.setLayoutParams(layoutParams2);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
            }
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            if (Intrinsics.areEqual("baidu", liveFeedPageSdk.getHost())) {
                if ((Intrinsics.areEqual(this.D, LiveFeedPageSdk.HOST_LIVE_TAB) || Intrinsics.areEqual(this.D, LiveFeedPageSdk.IMMERSION)) && I() && this.G && (imageView = this.C) != null) {
                    imageView.setVisibility(0);
                }
            }
        }
    }

    public final void setViewPagerInFistPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.M = z;
        }
    }

    public final void t() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && this.F && (bannerView = this.o) != null) {
            bannerView.x();
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? !G() : invokeV.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.e;
            if (baiduLiveTabAdapter != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager = this.d;
                if (baiduLiveTabAdapter.h(nestedNoScrollViewPager != null ? nestedNoScrollViewPager.getCurrentItem() : 0)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int w(List<? extends LiveTabEntity> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, list)) == null) {
            int size = list.size();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                LiveTabEntity liveTabEntity = list.get(i4);
                if (liveTabEntity != null) {
                    if (!TextUtils.isEmpty(this.H) && i2 == 0 && Intrinsics.areEqual(this.H, liveTabEntity.type)) {
                        LiveFeedPageSdk.liveLog("scheme指定找到了二级Tab = " + liveTabEntity.name);
                        i2 = i4;
                    }
                    if (liveTabEntity.selected && i3 == 0) {
                        i3 = i4;
                    }
                }
            }
            return i2 != 0 ? i2 : i3;
        }
        return invokeL.intValue;
    }

    public final String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, str)) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            AccountManagerService accountManager = getAccountManager();
            objArr[1] = (accountManager == null || (r5 = accountManager.getUid()) == null) ? "" : "";
            String format = String.format("%s_%s", Arrays.copyOf(objArr, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            return format;
        }
        return (String) invokeL.objValue;
    }

    public final void y(LiveFollowWrapData liveFollowWrapData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048651, this, liveFollowWrapData, z) == null) {
            if (liveFollowWrapData != null) {
                if (!ma0.c(liveFollowWrapData.followList)) {
                    LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.l;
                    if (liveFeedPageConcernAdapter != null) {
                        liveFeedPageConcernAdapter.j(liveFollowWrapData.followList);
                    }
                    LiveFeedPageConcernAdapter liveFeedPageConcernAdapter2 = this.l;
                    if (liveFeedPageConcernAdapter2 != null) {
                        liveFeedPageConcernAdapter2.k(liveFollowWrapData.livingFollowList);
                    }
                    LiveFeedPageConcernAdapter liveFeedPageConcernAdapter3 = this.l;
                    if (liveFeedPageConcernAdapter3 != null) {
                        liveFeedPageConcernAdapter3.m(z);
                    }
                    InterceptTouchRecyclerView interceptTouchRecyclerView = this.j;
                    if (interceptTouchRecyclerView != null) {
                        interceptTouchRecyclerView.setVisibility(0);
                    }
                    InterceptTouchRecyclerView interceptTouchRecyclerView2 = this.j;
                    if (interceptTouchRecyclerView2 != null && this.G && interceptTouchRecyclerView2 != null) {
                        interceptTouchRecyclerView2.setPadding(0, 0, 0, n80.b(getContext(), 6.0f));
                    }
                } else {
                    LiveFeedPageConcernAdapter liveFeedPageConcernAdapter4 = this.l;
                    if (liveFeedPageConcernAdapter4 != null) {
                        liveFeedPageConcernAdapter4.j(new ArrayList());
                    }
                    LiveFeedPageConcernAdapter liveFeedPageConcernAdapter5 = this.l;
                    if (liveFeedPageConcernAdapter5 != null) {
                        liveFeedPageConcernAdapter5.k(new ArrayList());
                    }
                    InterceptTouchRecyclerView interceptTouchRecyclerView3 = this.j;
                    if (interceptTouchRecyclerView3 != null) {
                        interceptTouchRecyclerView3.setVisibility(8);
                    }
                }
            }
            Z(z);
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            if (Intrinsics.areEqual(LiveFeedPageSdk.VIDEO_BAR, this.D)) {
                RecyclerView recyclerView = this.i;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
            } else if (!ma0.c(this.J)) {
                if (i2 >= 0 && i2 < this.J.size()) {
                    List<LiveTabEntity.TabLabelInfo> list = this.J.get(i2).subTabList;
                    if (!ma0.c(list)) {
                        LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.k;
                        if (liveFeedPageSubTipAdapter != null) {
                            liveFeedPageSubTipAdapter.m(list, this.I);
                        }
                        j0();
                        RecyclerView recyclerView2 = this.i;
                        if (recyclerView2 != null) {
                            recyclerView2.setVisibility(0);
                        }
                    } else {
                        RecyclerView recyclerView3 = this.i;
                        if (recyclerView3 != null) {
                            recyclerView3.setVisibility(8);
                        }
                    }
                }
            } else {
                RecyclerView recyclerView4 = this.i;
                if (recyclerView4 != null) {
                    recyclerView4.setVisibility(8);
                }
            }
            r();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveTabFeedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.D = LiveFeedPageSdk.HOST_LIVE_TAB;
        this.J = new ArrayList();
        this.M = true;
        this.U = LazyKt__LazyJVMKt.lazy(LiveTabFeedView$accountManager$2.INSTANCE);
        this.V = LazyKt__LazyJVMKt.lazy(LiveTabFeedView$isHitTabAbTest$2.INSTANCE);
        this.W = new a(this);
        F();
    }
}
