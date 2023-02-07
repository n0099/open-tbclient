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
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.LiveSubTabFragment;
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
import com.baidu.live.business.view.emotion.MinorView;
import com.baidu.live.business.view.expandtab.LiveExpandTabView;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout;
import com.baidu.live.business.view.viewpager.NestedNoScrollViewPager;
import com.baidu.live.feedfollow.view.LiveFeedFollowView;
import com.baidu.live.feedpage.interfaces.ILiveFeedOther;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.live.framework.appbar.AppBarLayout;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.bd0;
import com.baidu.tieba.fd0;
import com.baidu.tieba.oa0;
import com.baidu.tieba.pc0;
import com.baidu.tieba.qa0;
import com.baidu.tieba.qc0;
import com.baidu.tieba.ta0;
import com.baidu.tieba.ua0;
import com.baidu.tieba.wa0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002 \u0001\u0018\u0000 ¥\u00022\u00020\u0001:\u0004¥\u0002¦\u0002B.\b\u0007\u0012\b\u0010\u009f\u0002\u001a\u00030\u009e\u0002\u0012\f\b\u0002\u0010¡\u0002\u001a\u0005\u0018\u00010 \u0002\u0012\t\b\u0002\u0010¢\u0002\u001a\u00020\u0012¢\u0006\u0006\b£\u0002\u0010¤\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001e\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0012¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J!\u0010*\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u000b¢\u0006\u0004\b,\u0010\rJ\u000f\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010\bJA\u00105\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00122\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u00010\u00152\b\u00104\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u0010\bJ\u000f\u00108\u001a\u00020\u000bH\u0002¢\u0006\u0004\b8\u0010\rJ\r\u00109\u001a\u00020\u000b¢\u0006\u0004\b9\u0010\rJ\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010\rJ\r\u0010;\u001a\u00020\u0004¢\u0006\u0004\b;\u0010\bJ\r\u0010<\u001a\u00020\u0004¢\u0006\u0004\b<\u0010\bJ\r\u0010=\u001a\u00020\u0004¢\u0006\u0004\b=\u0010\bJ\u0017\u0010?\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0004¢\u0006\u0004\bA\u0010\bJ\u0017\u0010C\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010B¢\u0006\u0004\bC\u0010DJ\u0019\u0010F\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010E¢\u0006\u0004\bF\u0010GJ\u0015\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0012¢\u0006\u0004\bI\u0010\"J\r\u0010J\u001a\u00020\u0004¢\u0006\u0004\bJ\u0010\bJ\r\u0010K\u001a\u00020\u0004¢\u0006\u0004\bK\u0010\bJ\r\u0010L\u001a\u00020\u0004¢\u0006\u0004\bL\u0010\bJ\r\u0010M\u001a\u00020\u0004¢\u0006\u0004\bM\u0010\bJ%\u0010N\u001a\u00020\u00042\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bN\u0010OJ\u0017\u0010R\u001a\u00020\u00042\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\u0004¢\u0006\u0004\bV\u0010\bJ\u0017\u0010W\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\bW\u0010\"J\u0017\u0010Y\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u000bH\u0002¢\u0006\u0004\bY\u0010UJ\u000f\u0010Z\u001a\u00020\u0004H\u0002¢\u0006\u0004\bZ\u0010\bJ\u0017\u0010\\\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\\\u0010@J#\u0010_\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u000b2\b\b\u0002\u0010^\u001a\u00020\u000bH\u0007¢\u0006\u0004\b_\u0010`J\u0015\u0010b\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u000b¢\u0006\u0004\bb\u0010UJ\u0017\u0010e\u001a\u00020\u00042\b\u0010d\u001a\u0004\u0018\u00010c¢\u0006\u0004\be\u0010fJ\r\u0010g\u001a\u00020\u0004¢\u0006\u0004\bg\u0010\bJ\r\u0010h\u001a\u00020\u0004¢\u0006\u0004\bh\u0010\bJ\u000f\u0010i\u001a\u00020\u0004H\u0002¢\u0006\u0004\bi\u0010\bJ\u0015\u0010k\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u000b¢\u0006\u0004\bk\u0010UJ\r\u0010l\u001a\u00020\u0004¢\u0006\u0004\bl\u0010\bJ\u001f\u0010o\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u000b2\b\u0010n\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bo\u0010pJ\u000f\u0010q\u001a\u00020\u0004H\u0002¢\u0006\u0004\bq\u0010\bR%\u0010x\u001a\n s*\u0004\u0018\u00010r0r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR$\u0010z\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR,\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R,\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018F@\u0006¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001a\u0010¡\u0001\u001a\u00030 \u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R \u0010¤\u0001\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b£\u0001\u0010u\u001a\u0005\b¤\u0001\u0010\rR'\u0010¥\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0005\b¥\u0001\u0010\r\"\u0005\b§\u0001\u0010UR\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001c\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001b\u0010´\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R,\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010½\u0001\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u00ad\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001c\u0010Ä\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R+\u0010Æ\u0001\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Î\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010¦\u0001R\u0019\u0010Ï\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010¦\u0001R\u0019\u0010Ð\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010¦\u0001R\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Í\u0001R\u001b\u0010Õ\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Í\u0001R\u001b\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010µ\u0001R,\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R*\u0010Þ\u0001\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÞ\u0001\u0010Í\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0005\bá\u0001\u0010fR\u001b\u0010â\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010Í\u0001R\u001b\u0010ã\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010Í\u0001R\u001c\u0010å\u0001\u001a\u0005\u0018\u00010ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001c\u0010è\u0001\u001a\u0005\u0018\u00010ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u001b\u0010ê\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010µ\u0001R\u001c\u0010ì\u0001\u001a\u0005\u0018\u00010ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R,\u0010ï\u0001\u001a\u0005\u0018\u00010î\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0006\bñ\u0001\u0010ò\u0001\"\u0006\bó\u0001\u0010ô\u0001R\u001c\u0010ö\u0001\u001a\u0005\u0018\u00010õ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u001f\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001b\u0010ú\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010µ\u0001R\u001c\u0010û\u0001\u001a\u0005\u0018\u00010ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010é\u0001R\u001b\u0010ü\u0001\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u001b\u0010þ\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010Í\u0001R,\u0010\u0080\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001b\u0010\u0086\u0002\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0002\u0010Í\u0001R\u001b\u0010\u0087\u0002\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010Í\u0001R*\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0088\u0002\u0010µ\u0001\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0005\b\u008b\u0002\u0010@R\u001c\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u008c\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010\u008e\u0002R\u001b\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R,\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0091\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0002\u0010\u0093\u0002\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002\"\u0006\b\u0096\u0002\u0010\u0097\u0002R\u001c\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0098\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R\u001c\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009b\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002¨\u0006§\u0002"}, d2 = {"Lcom/baidu/live/business/LiveTabFeedView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/live/feedpage/interfaces/ILiveFeedOther$LiveFeedStatusListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addLiveFeedStatusListener", "(Lcom/baidu/live/feedpage/interfaces/ILiveFeedOther$LiveFeedStatusListener;)V", "adjustCollapsingHeight", "()V", "animPause", "animResume", "", "canSlideDown", "()Z", "canSlideUp", "", "Lcom/baidu/live/business/model/data/LiveTabEntity;", "tabInfoList", "", "defaultTabPosition", "(Ljava/util/List;)I", "", "key", "getKeyWithUid", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/baidu/live/business/model/data/LiveFollowWrapData;", "followWrapData", "useNewStyle", "Lcom/baidu/live/business/model/data/LiveFeedConfig;", "config", "handleFollowData", "(Lcom/baidu/live/business/model/data/LiveFollowWrapData;ZLcom/baidu/live/business/model/data/LiveFeedConfig;)V", CriusAttrConstants.POSITION, "handleSubTab", "(I)V", "Lcom/baidu/live/business/model/data/LiveFeedData;", "feedData", "handleTabData", "(Lcom/baidu/live/business/model/data/LiveFeedData;)V", "Lcom/baidu/live/business/model/data/LiveFeedToolWrapData;", "toolWrapData", "feedConfig", "handleToolData", "(Lcom/baidu/live/business/model/data/LiveFeedToolWrapData;Lcom/baidu/live/business/model/data/LiveFeedConfig;)V", "hasMore", "initBanner", "scene", "isHKTopBar", "bdUniqueId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "subTabType", "thirdTabType", "initUiScene", "(Ljava/lang/String;ZILandroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;)V", "initView", "isAppBarTopState", "isFirstTabIndicatorVisible", "isHkTab", "notifyFragmentNetChange", "notifyPause", "notifyResume", "uiMode", "onDarkModeChange", "(Ljava/lang/String;)V", MissionEvent.MESSAGE_DESTROY, "Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnLoadMoreListener;", "onExternalLoadMore", "(Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnLoadMoreListener;)V", "Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnRefreshListener;", "onExternalRefresh", "(Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnRefreshListener;)V", "textSizeLevel", "onFontSizeChanged", "onPageHint", "onPageShow", MissionEvent.MESSAGE_PAUSE, "onResume", "onTabSelectedEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveBannerWrapData;", "liveBannerWrapData", "refreshBanner", "(Lcom/baidu/live/business/model/data/LiveBannerWrapData;)V", "refreshSpaceView", "(Z)V", "resetView", "selectSubTip", "scroll", "setAppBarScroll", "setAppBarScrollToTop", "roomId", "setCurrentRoom", "expanded", "animate", "setExpanded", "(ZZ)V", "isNewTabStyle", "setTabStyle", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "show", "(Landroid/view/View;)V", "showContentView", "showErrorView", "showExpandTabPanel", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "showHideSearchGuideView", "showLoadingView", "isMinor", "ufoUrl", "showMinorModel", "(ZLjava/lang/String;)V", "updateSubTabInfo", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "kotlin.jvm.PlatformType", "accountManager$delegate", "Lkotlin/Lazy;", "getAccountManager", "()Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "accountManager", "Lcom/baidu/live/business/listener/TabFeedActionListener;", "feedActionListener", "Lcom/baidu/live/business/listener/TabFeedActionListener;", "getFeedActionListener", "()Lcom/baidu/live/business/listener/TabFeedActionListener;", "setFeedActionListener", "(Lcom/baidu/live/business/listener/TabFeedActionListener;)V", "Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "feedBannerListener", "Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "getFeedBannerListener", "()Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "setFeedBannerListener", "(Lcom/baidu/live/business/listener/LiveFeedBannerListener;)V", "Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "feedFollowListener", "Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "getFeedFollowListener", "()Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "setFeedFollowListener", "(Lcom/baidu/live/business/listener/LiveFeedFollowListener;)V", "Lcom/baidu/live/feedfollow/view/LiveFeedFollowView;", "getFeedFollowView", "()Lcom/baidu/live/feedfollow/view/LiveFeedFollowView;", "feedFollowView", "Lcom/baidu/live/business/model/ILiveFeedModel;", "feedModel", "Lcom/baidu/live/business/model/ILiveFeedModel;", "getFeedModel", "()Lcom/baidu/live/business/model/ILiveFeedModel;", "setFeedModel", "(Lcom/baidu/live/business/model/ILiveFeedModel;)V", "Lcom/baidu/live/business/listener/LiveFeedToolListener;", "feedToolListener", "Lcom/baidu/live/business/listener/LiveFeedToolListener;", "getFeedToolListener", "()Lcom/baidu/live/business/listener/LiveFeedToolListener;", "setFeedToolListener", "(Lcom/baidu/live/business/listener/LiveFeedToolListener;)V", "com/baidu/live/business/LiveTabFeedView$followListener$1", "followListener", "Lcom/baidu/live/business/LiveTabFeedView$followListener$1;", "isHitTabAbTest$delegate", "isHitTabAbTest", "isViewPagerInFistPage", "Z", "setViewPagerInFistPage", "Lcom/baidu/live/framework/appbar/AppBarLayout;", "mAppBarLayout", "Lcom/baidu/live/framework/appbar/AppBarLayout;", "Landroid/widget/ImageView;", "mBackBtn", "Landroid/widget/ImageView;", "Lcom/baidu/live/business/view/banner/BannerView;", "mBannerView", "Lcom/baidu/live/business/view/banner/BannerView;", "Landroid/widget/Space;", "mContentTopSpace", "Landroid/widget/Space;", "mCurPlayingRoomId", "Ljava/lang/String;", "Lcom/baidu/live/business/view/emotion/ErrorView;", "mErrorView", "Lcom/baidu/live/business/view/emotion/ErrorView;", "getMErrorView", "()Lcom/baidu/live/business/view/emotion/ErrorView;", "setMErrorView", "(Lcom/baidu/live/business/view/emotion/ErrorView;)V", "mExpandTabBtn", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabView;", "mExpandTabView", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabView;", "Lcom/baidu/live/business/view/FakeStartLiveButton;", "mFakeStartLiveButton", "Lcom/baidu/live/business/view/FakeStartLiveButton;", "mFeedFollowView", "Lcom/baidu/live/feedfollow/view/LiveFeedFollowView;", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getMFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setMFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "mImmersionDivider", "Landroid/view/View;", "mIsBannerOk", "mIsHKTopBar", "mIsNewTabStyle", "Lcom/baidu/live/business/view/emotion/LoadingView;", "mLoadingView", "Lcom/baidu/live/business/view/emotion/LoadingView;", "mRootContainer", "mRootView", "mScene", "Lcom/baidu/live/business/view/smarttab/SmartTabLayout;", "mSmartTabLayout", "Lcom/baidu/live/business/view/smarttab/SmartTabLayout;", "getMSmartTabLayout", "()Lcom/baidu/live/business/view/smarttab/SmartTabLayout;", "setMSmartTabLayout", "(Lcom/baidu/live/business/view/smarttab/SmartTabLayout;)V", "mSmartTabLayoutContainer", "getMSmartTabLayoutContainer", "()Landroid/view/View;", "setMSmartTabLayoutContainer", "mSmartTabLeftCover", "mSmartTabRightCover", "Landroid/widget/TextView;", "mStartLiveBtn", "Landroid/widget/TextView;", "Landroid/widget/LinearLayout;", "mStartLiveContainer", "Landroid/widget/LinearLayout;", "mSubTabType", "Lcom/baidu/live/business/adapter/LiveFeedPageSubTipAdapter;", "mSubTipAdapter", "Lcom/baidu/live/business/adapter/LiveFeedPageSubTipAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "mSubTipLayout", "Landroidx/recyclerview/widget/RecyclerView;", "getMSubTipLayout", "()Landroidx/recyclerview/widget/RecyclerView;", "setMSubTipLayout", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/baidu/live/business/BaiduLiveTabAdapter;", "mTabAdapter", "Lcom/baidu/live/business/BaiduLiveTabAdapter;", "mTabInfo", "Ljava/util/List;", "mThirdTabType", "mTopBaseContainer", "mTopContentContainer", "Landroid/widget/FrameLayout;", "mTopSpaceView", "Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;", "mViewPager", "Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;", "getMViewPager", "()Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;", "setMViewPager", "(Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;)V", "mainLayout", "minorLayout", "minorUfoUrl", "getMinorUfoUrl", "()Ljava/lang/String;", "setMinorUfoUrl", "Lcom/baidu/live/business/view/emotion/MinorView;", "minorView", "Lcom/baidu/live/business/view/emotion/MinorView;", "pagerStatusListener", "Lcom/baidu/live/feedpage/interfaces/ILiveFeedOther$LiveFeedStatusListener;", "Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;", "subTabPageListener", "Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;", "getSubTabPageListener", "()Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;", "setSubTabPageListener", "(Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;)V", "Landroid/view/ViewGroup;", "tabOverallRegion", "Landroid/view/ViewGroup;", "Lcom/baidu/live/business/view/tool/LiveFeedPageToolFloatLayout;", "toolFloatLayout", "Lcom/baidu/live/business/view/tool/LiveFeedPageToolFloatLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "Scene", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveTabFeedView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ KProperty[] d0;
    public transient /* synthetic */ FieldHolder $fh;
    public FakeStartLiveButton A;
    public View B;
    public ImageView C;
    public LiveFeedPageToolFloatLayout D;
    public ImageView E;
    public String F;
    public boolean G;
    public boolean H;
    public boolean I;
    public String J;
    public String K;
    public String L;
    public List<? extends LiveTabEntity> M;
    public String N;
    public FragmentManager O;
    public boolean P;
    public ILiveFeedModel Q;
    public TabFeedActionListener R;
    public LiveFeedBannerListener S;
    public LiveFeedFollowListener T;
    public LiveBaseFragment.a U;
    public LiveFeedToolListener V;
    public ILiveFeedOther.LiveFeedStatusListener W;
    public View a;
    public final Lazy a0;
    public View b;
    public final Lazy b0;
    public View c;
    public a c0;
    public MinorView d;
    public View e;
    public AppBarLayout f;
    public NestedNoScrollViewPager g;
    public BaiduLiveTabAdapter h;
    public ViewGroup i;
    public View j;
    public SmartTabLayout k;
    public RecyclerView l;
    public LiveFeedFollowView m;
    public LiveFeedPageSubTipAdapter n;
    public Space o;
    public FrameLayout p;
    public BannerView q;
    public LoadingView r;
    public ErrorView s;
    public LinearLayout t;
    public View u;
    public View v;
    public View w;
    public LiveExpandTabView x;
    public LinearLayout y;
    public TextView z;

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
        d0 = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveTabFeedView.class), "accountManager", "getAccountManager()Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveTabFeedView.class), "isHitTabAbTest", "isHitTabAbTest()Z"))};
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

    private final AccountManagerService getAccountManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            Lazy lazy = this.a0;
            KProperty kProperty = d0[0];
            return (AccountManagerService) lazy.getValue();
        }
        return (AccountManagerService) invokeV.objValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Lazy lazy = this.b0;
            KProperty kProperty = d0[1];
            return ((Boolean) lazy.getValue()).booleanValue();
        }
        return invokeV.booleanValue;
    }

    @JvmOverloads
    public final void setExpanded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            setExpanded$default(this, false, false, 3, null);
        }
    }

    @JvmOverloads
    public final void setExpanded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            setExpanded$default(this, z, false, 2, null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements LiveFeedFollowListener {
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

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onClickFollow(LiveFollowEntity liveFollowEntity, int i) {
            LiveFeedFollowListener feedFollowListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, liveFollowEntity, i) == null) && (feedFollowListener = this.a.getFeedFollowListener()) != null) {
                feedFollowListener.onClickFollow(liveFollowEntity, i);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onFollowShow(LiveFollowEntity liveFollowEntity, int i) {
            LiveFeedFollowListener feedFollowListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFollowEntity, i) == null) && (feedFollowListener = this.a.getFeedFollowListener()) != null) {
                feedFollowListener.onFollowShow(liveFollowEntity, i);
            }
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (baiduLiveTabAdapter = this.a.h) != null) {
                baiduLiveTabAdapter.r(this.b);
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) && (feedBannerListener = this.a.getFeedBannerListener()) != null) {
                feedBannerListener.onClickBanner(liveBannerEntity);
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, it) == null) && (feedBannerListener = this.a.getFeedBannerListener()) != null) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                feedBannerListener.onBannerShow(it);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements LiveSubTabFragment.l {
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

        @Override // com.baidu.live.business.LiveSubTabFragment.l
        public final void a(boolean z) {
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (liveFeedPageToolFloatLayout = this.a.D) != null) {
                liveFeedPageToolFloatLayout.b(z);
            }
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
            if (interceptable != null && interceptable.invokeLI(1048576, this, view2, i) != null) {
                return;
            }
            this.a.d0(i);
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
            if (interceptable != null && interceptable.invokeL(1048576, this, liveTabEntity) != null) {
                return;
            }
            LiveExpandTabView liveExpandTabView = this.a.x;
            if (liveExpandTabView != null) {
                liveExpandTabView.b();
            }
            this.a.setExpanded(false, true);
            LiveTabFeedView.Z(this.a, liveTabEntity.type, null, 2, null);
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabView.b
        public void b() {
            LiveExpandTabView liveExpandTabView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (liveExpandTabView = this.a.x) != null) {
                liveExpandTabView.b();
            }
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabView.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.a.setAppBarScroll(true);
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements SmartTabLayout.d {
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

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.d
        public final void a(int i, int i2) {
            View view2;
            View view3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                SmartTabLayout mSmartTabLayout = this.a.getMSmartTabLayout();
                if (mSmartTabLayout == null || mSmartTabLayout.canScrollHorizontally(-1)) {
                    if ((!Intrinsics.areEqual(this.a.F, "recommend")) && (view2 = this.a.v) != null) {
                        view2.setVisibility(0);
                    }
                } else {
                    View view4 = this.a.v;
                    if (view4 != null) {
                        view4.setVisibility(8);
                    }
                }
                SmartTabLayout mSmartTabLayout2 = this.a.getMSmartTabLayout();
                if (mSmartTabLayout2 == null || mSmartTabLayout2.canScrollHorizontally(1)) {
                    if ((!Intrinsics.areEqual(this.a.F, "recommend")) && (view3 = this.a.w) != null) {
                        view3.setVisibility(0);
                        return;
                    }
                    return;
                }
                View view5 = this.a.w;
                if (view5 != null) {
                    view5.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements wa0 {
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

        @Override // com.baidu.tieba.wa0
        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LiveTabFeedView liveTabFeedView = this.a;
                liveTabFeedView.f0(liveTabFeedView.r);
                TabFeedActionListener feedActionListener = this.a.getFeedActionListener();
                if (feedActionListener != null) {
                    feedActionListener.onClickErrorRefresh();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements wa0 {
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

        @Override // com.baidu.tieba.wa0
        public final void a(View view2) {
            ILiveFeedPageInvoke invoker;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.getMinorUfoUrl()) && (invoker = LiveFeedPageSdk.getInstance().getInvoker()) != null) {
                invoker.invokeScheme(this.a.getContext(), this.a.getMinorUfoUrl());
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
            TabFeedActionListener feedActionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (feedActionListener = this.a.getFeedActionListener()) != null) {
                feedActionListener.onClickStartLive(view2, this.a.z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

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

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.getContext() instanceof Activity)) {
                Context context = this.a.getContext();
                if (context != null) {
                    if (!((Activity) context).isFinishing()) {
                        Context context2 = this.a.getContext();
                        if (context2 != null) {
                            ((Activity) context2).finish();
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
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
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            LiveExpandTabView liveExpandTabView = this.a.x;
            if (liveExpandTabView != null) {
                liveExpandTabView.setTabs(this.a.M, ta0.a());
            }
            this.a.i0();
            this.a.setAppBarScroll(false);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements LiveFeedPageToolFloatLayout.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
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

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void onItemShow(String str) {
            LiveFeedToolListener feedToolListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (feedToolListener = this.a.getFeedToolListener()) != null) {
                feedToolListener.onItemShow(str);
            }
        }

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void onSearchShowing(boolean z) {
            TabFeedActionListener feedActionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (feedActionListener = this.a.getFeedActionListener()) != null) {
                feedActionListener.onSearchShowing(z);
            }
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (feedActionListener = this.a.getFeedActionListener()) != null) {
                feedActionListener.onClickSearch();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class o implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            TabFeedActionListener feedActionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (feedActionListener = this.a.getFeedActionListener()) != null) {
                feedActionListener.onClickStartLive(view2, this.a.z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class p implements SmartTabLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;

        public p(LiveTabFeedView liveTabFeedView) {
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
            Integer num;
            BaiduLiveTabAdapter baiduLiveTabAdapter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("二级 tab 点击：");
                sb.append(i);
                sb.append("   current：");
                NestedNoScrollViewPager mViewPager = this.a.getMViewPager();
                if (mViewPager != null) {
                    num = Integer.valueOf(mViewPager.getCurrentItem());
                } else {
                    num = null;
                }
                sb.append(num);
                LiveFeedPageSdk.liveLog(sb.toString());
                if (this.a.J() && this.a.I) {
                    this.a.setExpanded(false, true);
                }
                NestedNoScrollViewPager mViewPager2 = this.a.getMViewPager();
                if (mViewPager2 != null && mViewPager2.getCurrentItem() == i && (baiduLiveTabAdapter = this.a.h) != null) {
                    baiduLiveTabAdapter.c(i, true, true);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class q extends AppBarLayout.Behavior.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public q(boolean z) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, appBarLayout)) == null) {
                return this.a;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFeedView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public r(LiveTabFeedView liveTabFeedView, boolean z, boolean z2) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (appBarLayout = this.a.f) != null) {
                appBarLayout.setExpanded(this.b, this.c);
            }
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
        this.F = LiveFeedPageSdk.HOST_LIVE_TAB;
        this.M = new ArrayList();
        this.P = true;
        this.a0 = LazyKt__LazyJVMKt.lazy(LiveTabFeedView$accountManager$2.INSTANCE);
        this.b0 = LazyKt__LazyJVMKt.lazy(LiveTabFeedView$isHitTabAbTest$2.INSTANCE);
        this.c0 = new a(this);
        G();
    }

    public final void y(LiveFollowWrapData liveFollowWrapData, boolean z, LiveFeedConfig liveFeedConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{liveFollowWrapData, Boolean.valueOf(z), liveFeedConfig}) == null) {
            if (liveFollowWrapData != null) {
                if (!qc0.c(liveFollowWrapData.followList)) {
                    LiveFeedFollowView liveFeedFollowView = this.m;
                    if (liveFeedFollowView != null) {
                        List<LiveFollowEntity> list = liveFollowWrapData.followList;
                        Intrinsics.checkExpressionValueIsNotNull(list, "followWrapData.followList");
                        liveFeedFollowView.setConcernList(list, liveFollowWrapData.followMore, liveFeedConfig);
                    }
                    LiveFeedFollowView liveFeedFollowView2 = this.m;
                    if (liveFeedFollowView2 != null) {
                        liveFeedFollowView2.setUseNewStyle(z);
                    }
                    LiveFeedFollowView liveFeedFollowView3 = this.m;
                    if (liveFeedFollowView3 != null) {
                        liveFeedFollowView3.setVisibility(0);
                    }
                    LiveFeedFollowView liveFeedFollowView4 = this.m;
                    if (liveFeedFollowView4 != null && this.I && liveFeedFollowView4 != null) {
                        liveFeedFollowView4.setPadding(0, 0, 0, oa0.b(getContext(), 6.0f));
                    }
                } else {
                    LiveFeedFollowView liveFeedFollowView5 = this.m;
                    if (liveFeedFollowView5 != null) {
                        liveFeedFollowView5.setConcernList(new ArrayList(), null, null);
                    }
                    LiveFeedFollowView liveFeedFollowView6 = this.m;
                    if (liveFeedFollowView6 != null) {
                        liveFeedFollowView6.setVisibility(8);
                    }
                }
            }
            b0(z);
        }
    }

    public /* synthetic */ LiveTabFeedView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static /* synthetic */ void Z(LiveTabFeedView liveTabFeedView, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        liveTabFeedView.Y(str, str2);
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

    public final void R(ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, onLoadMoreListener) == null) && (baiduLiveTabAdapter = this.h) != null) {
            NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
            if (nestedNoScrollViewPager != null) {
                i2 = nestedNoScrollViewPager.getCurrentItem();
            } else {
                i2 = 0;
            }
            baiduLiveTabAdapter.n(i2, onLoadMoreListener);
        }
    }

    public final void S(ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onRefreshListener) == null) {
            if (Intrinsics.areEqual(this.F, LiveFeedPageSdk.VIDEO_BAR)) {
                e0();
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
            if (baiduLiveTabAdapter != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
                if (nestedNoScrollViewPager != null) {
                    i2 = nestedNoScrollViewPager.getCurrentItem();
                } else {
                    i2 = 0;
                }
                baiduLiveTabAdapter.d(i2, true, true, onRefreshListener);
            }
        }
    }

    public final void j0(boolean z) {
        LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (liveFeedPageToolFloatLayout = this.D) != null) {
            liveFeedPageToolFloatLayout.setSearchGuideShowing(z);
        }
    }

    public final void q(ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, liveFeedStatusListener) == null) {
            this.W = liveFeedStatusListener;
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
            if (baiduLiveTabAdapter != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
                if (nestedNoScrollViewPager != null) {
                    i2 = nestedNoScrollViewPager.getCurrentItem();
                } else {
                    i2 = 0;
                }
                baiduLiveTabAdapter.b(i2, liveFeedStatusListener);
            }
        }
    }

    public final void setCurrentRoom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.N = str;
        }
    }

    public final void setFeedActionListener(TabFeedActionListener tabFeedActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, tabFeedActionListener) == null) {
            this.R = tabFeedActionListener;
        }
    }

    public final void setFeedBannerListener(LiveFeedBannerListener liveFeedBannerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, liveFeedBannerListener) == null) {
            this.S = liveFeedBannerListener;
        }
    }

    public final void setFeedFollowListener(LiveFeedFollowListener liveFeedFollowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, liveFeedFollowListener) == null) {
            this.T = liveFeedFollowListener;
        }
    }

    public final void setFeedModel(ILiveFeedModel iLiveFeedModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, iLiveFeedModel) == null) {
            this.Q = iLiveFeedModel;
        }
    }

    public final void setFeedToolListener(LiveFeedToolListener liveFeedToolListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, liveFeedToolListener) == null) {
            this.V = liveFeedToolListener;
        }
    }

    public final void setMErrorView(ErrorView errorView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, errorView) == null) {
            this.s = errorView;
        }
    }

    public final void setMFragmentManager(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, fragmentManager) == null) {
            this.O = fragmentManager;
        }
    }

    public final void setMSmartTabLayout(SmartTabLayout smartTabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, smartTabLayout) == null) {
            this.k = smartTabLayout;
        }
    }

    public final void setMSmartTabLayoutContainer(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, view2) == null) {
            this.j = view2;
        }
    }

    public final void setMSubTipLayout(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, recyclerView) == null) {
            this.l = recyclerView;
        }
    }

    public final void setMViewPager(NestedNoScrollViewPager nestedNoScrollViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, nestedNoScrollViewPager) == null) {
            this.g = nestedNoScrollViewPager;
        }
    }

    public final void setMinorUfoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.L = str;
        }
    }

    public final void setSubTabPageListener(LiveBaseFragment.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, aVar) == null) {
            this.U = aVar;
        }
    }

    public final void setViewPagerInFistPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.P = z;
        }
    }

    public final void C(LiveFeedToolWrapData liveFeedToolWrapData, LiveFeedConfig liveFeedConfig) {
        LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, liveFeedToolWrapData, liveFeedConfig) == null) && (liveFeedPageToolFloatLayout = this.D) != null) {
            liveFeedPageToolFloatLayout.setData(liveFeedToolWrapData, liveFeedConfig);
        }
    }

    @JvmOverloads
    public final void setExpanded(boolean z, boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (appBarLayout = this.f) != null) {
            appBarLayout.post(new r(this, z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAppBarScroll(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, this, z) == null) {
            AppBarLayout appBarLayout = this.f;
            AppBarLayout.Behavior behavior = null;
            if (appBarLayout != null) {
                layoutParams = appBarLayout.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof CoordinatorLayout.e) {
                AppBarLayout appBarLayout2 = this.f;
                if (appBarLayout2 != null) {
                    layoutParams2 = appBarLayout2.getLayoutParams();
                } else {
                    layoutParams2 = null;
                }
                if (layoutParams2 != null) {
                    CoordinatorLayout.Behavior e2 = ((CoordinatorLayout.e) layoutParams2).e();
                    if (e2 instanceof AppBarLayout.Behavior) {
                        behavior = e2;
                    }
                    AppBarLayout.Behavior behavior2 = behavior;
                    if (behavior2 != null) {
                        behavior2.m0(new q(z));
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.LayoutParams");
            }
        }
    }

    public final void b0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && this.u != null) {
            LiveFeedFollowView liveFeedFollowView = this.m;
            boolean z2 = true;
            if (liveFeedFollowView != null && (liveFeedFollowView == null || liveFeedFollowView.getVisibility() != 0)) {
                z2 = false;
            }
            if (z2 && !Intrinsics.areEqual(LiveFeedPageSdk.IMMERSION, this.F) && !Intrinsics.areEqual("recommend", this.F) && !z) {
                View view2 = this.u;
                if (view2 != null) {
                    view2.setVisibility(0);
                    return;
                }
                return;
            }
            View view3 = this.u;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
    }

    public final int w(List<? extends LiveTabEntity> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, list)) == null) {
            int size = list.size();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                LiveTabEntity liveTabEntity = list.get(i4);
                if (liveTabEntity != null) {
                    if (!TextUtils.isEmpty(this.J) && i2 == 0 && Intrinsics.areEqual(this.J, liveTabEntity.type)) {
                        LiveFeedPageSdk.liveLog("scheme指定找到了二级Tab = " + liveTabEntity.name);
                        i2 = i4;
                    }
                    if (liveTabEntity.selected && i3 == 0) {
                        i3 = i4;
                    }
                }
            }
            if (i2 == 0) {
                return i3;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static /* synthetic */ void z(LiveTabFeedView liveTabFeedView, LiveFollowWrapData liveFollowWrapData, boolean z, LiveFeedConfig liveFeedConfig, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            liveFeedConfig = null;
        }
        liveTabFeedView.y(liveFollowWrapData, z, liveFeedConfig);
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (Intrinsics.areEqual(LiveFeedPageSdk.VIDEO_BAR, this.F)) {
                RecyclerView recyclerView = this.l;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
            } else if (!qc0.c(this.M)) {
                if (i2 >= 0 && i2 < this.M.size()) {
                    List<LiveTabEntity.TabLabelInfo> list = this.M.get(i2).subTabList;
                    if (!qc0.c(list)) {
                        LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
                        if (liveFeedPageSubTipAdapter != null) {
                            liveFeedPageSubTipAdapter.m(list, this.K);
                        }
                        m0();
                        RecyclerView recyclerView2 = this.l;
                        if (recyclerView2 != null) {
                            recyclerView2.setVisibility(0);
                        }
                    } else {
                        RecyclerView recyclerView3 = this.l;
                        if (recyclerView3 != null) {
                            recyclerView3.setVisibility(8);
                        }
                    }
                }
            } else {
                RecyclerView recyclerView4 = this.l;
                if (recyclerView4 != null) {
                    recyclerView4.setVisibility(8);
                }
            }
            r();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.live.business.BaiduLiveTabAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B(LiveFeedData liveFeedData) {
        String str;
        LiveTabEntity f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedData) == null) {
            List<LiveTabEntity> list = liveFeedData.tabWrapData.tabList;
            Intrinsics.checkExpressionValueIsNotNull(list, "feedData.tabWrapData.tabList");
            this.M = list;
            int w = w(list);
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
            if (baiduLiveTabAdapter != 0) {
                baiduLiveTabAdapter.t(this.M, liveFeedData.feedWrapData, liveFeedData.feedConfig, liveFeedData.reserveWrapData, this.N);
            }
            SmartTabLayout smartTabLayout = this.k;
            if (smartTabLayout != null) {
                smartTabLayout.setViewPager(this.g, liveFeedData.feedConfig);
            }
            if (!qc0.c(this.M)) {
                ta0.c(w);
                NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
                if (nestedNoScrollViewPager != null) {
                    nestedNoScrollViewPager.setCurrentItem(w);
                }
            }
            NestedNoScrollViewPager nestedNoScrollViewPager2 = this.g;
            if (nestedNoScrollViewPager2 != null) {
                nestedNoScrollViewPager2.post(new b(this, w));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.h;
            if (baiduLiveTabAdapter2 != null && (f2 = baiduLiveTabAdapter2.f(w)) != null) {
                str = f2.type;
            } else {
                str = null;
            }
            this.J = str;
        }
    }

    public final void d0(int i2) {
        int i3;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
            boolean z = false;
            if (liveFeedPageSubTipAdapter != null) {
                i3 = liveFeedPageSubTipAdapter.f();
            } else {
                i3 = 0;
            }
            LiveFeedPageSdk.liveLog("三级 Tab 点击 pre: " + i3 + GlideException.IndentedAppendable.INDENT + i2);
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter2 = this.n;
            if (liveFeedPageSubTipAdapter2 != null) {
                liveFeedPageSubTipAdapter2.l(i2);
            }
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter3 = this.n;
            if (liveFeedPageSubTipAdapter3 != null) {
                liveFeedPageSubTipAdapter3.notifyDataSetChanged();
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.h;
            if (baiduLiveTabAdapter2 != null && (nestedNoScrollViewPager = this.g) != null) {
                if (i3 != i2 && baiduLiveTabAdapter2 != null) {
                    if (nestedNoScrollViewPager == null) {
                        Intrinsics.throwNpe();
                    }
                    baiduLiveTabAdapter2.p(nestedNoScrollViewPager.getCurrentItem());
                }
                m0();
                if (i3 != i2 && (baiduLiveTabAdapter = this.h) != null) {
                    NestedNoScrollViewPager nestedNoScrollViewPager2 = this.g;
                    if (nestedNoScrollViewPager2 == null) {
                        Intrinsics.throwNpe();
                    }
                    baiduLiveTabAdapter.q(nestedNoScrollViewPager2.getCurrentItem());
                }
                BaiduLiveTabAdapter baiduLiveTabAdapter3 = this.h;
                if (baiduLiveTabAdapter3 != null) {
                    NestedNoScrollViewPager nestedNoScrollViewPager3 = this.g;
                    if (nestedNoScrollViewPager3 == null) {
                        Intrinsics.throwNpe();
                    }
                    int currentItem = nestedNoScrollViewPager3.getCurrentItem();
                    if (i3 == i2) {
                        z = true;
                    }
                    baiduLiveTabAdapter3.c(currentItem, true, z);
                }
            }
        }
    }

    public final void setTabStyle(boolean z) {
        ImageView imageView;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.I = z;
            if (z && Intrinsics.areEqual(LiveFeedPageSdk.HOST_LIVE_TAB, this.F)) {
                View view2 = this.j;
                if (view2 != null) {
                    layoutParams = view2.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.setMargins(oa0.b(getContext(), 12.0f), 0, oa0.b(getContext(), 6.0f), 0);
                    View view3 = this.j;
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
                if ((Intrinsics.areEqual(this.F, LiveFeedPageSdk.HOST_LIVE_TAB) || Intrinsics.areEqual(this.F, LiveFeedPageSdk.IMMERSION)) && J() && this.I && (imageView = this.E) != null) {
                    imageView.setVisibility(0);
                }
            }
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
            if (baiduLiveTabAdapter != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
                if (nestedNoScrollViewPager != null) {
                    i2 = nestedNoScrollViewPager.getCurrentItem();
                } else {
                    i2 = 0;
                }
                if (baiduLiveTabAdapter.i(i2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SmartTabLayout smartTabLayout = this.k;
            if (smartTabLayout != null && !smartTabLayout.canScrollHorizontally(-1)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.P;
        }
        return invokeV.booleanValue;
    }

    public final void M() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (nestedNoScrollViewPager = this.g) != null && (baiduLiveTabAdapter = this.h) != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter.j(nestedNoScrollViewPager.getCurrentItem());
        }
    }

    public final void N() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (nestedNoScrollViewPager = this.g) != null && (baiduLiveTabAdapter = this.h) != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter.k(nestedNoScrollViewPager.getCurrentItem());
        }
    }

    public final void O() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (nestedNoScrollViewPager = this.g) != null && (baiduLiveTabAdapter = this.h) != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter.l(nestedNoScrollViewPager.getCurrentItem());
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            BannerView bannerView = this.q;
            if (bannerView != null) {
                bannerView.v();
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.a();
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.onDestroy();
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.D;
            if (liveFeedPageToolFloatLayout != null) {
                liveFeedPageToolFloatLayout.f();
            }
        }
    }

    public final void U() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
            if (nestedNoScrollViewPager != null && (baiduLiveTabAdapter = this.h) != null) {
                if (nestedNoScrollViewPager == null) {
                    Intrinsics.throwNpe();
                }
                baiduLiveTabAdapter.p(nestedNoScrollViewPager.getCurrentItem());
            }
            LiveExpandTabView liveExpandTabView = this.x;
            if (liveExpandTabView != null) {
                liveExpandTabView.b();
            }
        }
    }

    public final void V() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (nestedNoScrollViewPager = this.g) != null && (baiduLiveTabAdapter = this.h) != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter.q(nestedNoScrollViewPager.getCurrentItem());
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.d();
            }
            s();
            N();
            LiveExpandTabView liveExpandTabView = this.x;
            if (liveExpandTabView != null) {
                liveExpandTabView.b();
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.e();
            }
            t();
            O();
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            Q();
            ta0.b();
            SmartTabLayout smartTabLayout = this.k;
            if (smartTabLayout != null) {
                smartTabLayout.E();
            }
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
            if (liveFeedPageSubTipAdapter != null) {
                liveFeedPageSubTipAdapter.j();
            }
            LiveFeedFollowView liveFeedFollowView = this.m;
            if (liveFeedFollowView != null) {
                liveFeedFollowView.g();
            }
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            f0(this.e);
        }
    }

    public final TabFeedActionListener getFeedActionListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.R;
        }
        return (TabFeedActionListener) invokeV.objValue;
    }

    public final LiveFeedBannerListener getFeedBannerListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.S;
        }
        return (LiveFeedBannerListener) invokeV.objValue;
    }

    public final LiveFeedFollowListener getFeedFollowListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.T;
        }
        return (LiveFeedFollowListener) invokeV.objValue;
    }

    public final LiveFeedFollowView getFeedFollowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.m;
        }
        return (LiveFeedFollowView) invokeV.objValue;
    }

    public final ILiveFeedModel getFeedModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.Q;
        }
        return (ILiveFeedModel) invokeV.objValue;
    }

    public final LiveFeedToolListener getFeedToolListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.V;
        }
        return (LiveFeedToolListener) invokeV.objValue;
    }

    public final ErrorView getMErrorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.s;
        }
        return (ErrorView) invokeV.objValue;
    }

    public final FragmentManager getMFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.O;
        }
        return (FragmentManager) invokeV.objValue;
    }

    public final SmartTabLayout getMSmartTabLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.k;
        }
        return (SmartTabLayout) invokeV.objValue;
    }

    public final View getMSmartTabLayoutContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public final RecyclerView getMSubTipLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.l;
        }
        return (RecyclerView) invokeV.objValue;
    }

    public final NestedNoScrollViewPager getMViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.g;
        }
        return (NestedNoScrollViewPager) invokeV.objValue;
    }

    public final String getMinorUfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    public final LiveBaseFragment.a getSubTabPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.U;
        }
        return (LiveBaseFragment.a) invokeV.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            f0(this.s);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            f0(this.r);
        }
    }

    public final void s() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && (bannerView = this.q) != null) {
            bannerView.w();
        }
    }

    public final void t() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && this.H && (bannerView = this.q) != null) {
            bannerView.x();
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return !H();
        }
        return invokeV.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
            if (baiduLiveTabAdapter != null) {
                NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
                if (nestedNoScrollViewPager != null) {
                    i2 = nestedNoScrollViewPager.getCurrentItem();
                } else {
                    i2 = 0;
                }
                if (baiduLiveTabAdapter.h(i2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (Intrinsics.areEqual("recommend", this.F)) {
                FrameLayout frameLayout = this.p;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                BannerView bannerView = this.q;
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
            bannerView2.setIndicatorMargin(0, 0, 0, (int) oa0.c(context.getResources(), 7.0f));
            Context context2 = bannerView2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            bannerView2.setLargeIndicatorItemSize((int) oa0.c(context2.getResources(), 4.0f));
            Context context3 = bannerView2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            bannerView2.setSmallIndicatorItemSize((int) oa0.c(context3.getResources(), 4.0f));
            Context context4 = bannerView2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context4, "context");
            bannerView2.setIndicatorInterval((int) oa0.c(context4.getResources(), 6.0f));
            bannerView2.setAspectRatio(0.336f);
            bannerView2.setScene(this.F);
            bannerView2.setOnBannerClickListener(new c(this));
            bannerView2.setOnBannerShowListener(new d(this));
            this.q = bannerView2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout2 = this.p;
            if (frameLayout2 != null) {
                frameLayout2.addView(this.q, layoutParams);
            }
        }
    }

    public final void F(String str, boolean z, int i2, FragmentManager fragmentManager, String str2, String str3) {
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView;
        View view2;
        ViewGroup.LayoutParams layoutParams2;
        boolean z2;
        ViewGroup.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        ViewGroup.LayoutParams layoutParams5;
        ImageView imageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), fragmentManager, str2, str3}) == null) {
            this.F = str;
            this.G = z;
            this.O = fragmentManager;
            this.J = str2;
            this.K = str3;
            String str4 = LiveFeedPageSdk.HOST_LIVE_TAB;
            if (str != null) {
                int i3 = 8;
                switch (str.hashCode()) {
                    case 989204668:
                        if (str.equals("recommend")) {
                            ImageView imageView3 = this.C;
                            if (imageView3 != null) {
                                imageView3.setVisibility(8);
                            }
                            View view3 = this.B;
                            if (view3 != null) {
                                view3.setVisibility(0);
                            }
                            SmartTabLayout smartTabLayout = this.k;
                            if (smartTabLayout != null) {
                                smartTabLayout.setShowBottomLine(true);
                            }
                            NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
                            if (nestedNoScrollViewPager != null) {
                                nestedNoScrollViewPager.setCanScrollHorizontally(true);
                            }
                            SmartTabLayout smartTabLayout2 = this.k;
                            if (smartTabLayout2 != null) {
                                smartTabLayout2.setDarkModeCompatColor("color_white3", "color_sub_tab_normal");
                            }
                            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.D;
                            if (liveFeedPageToolFloatLayout != null) {
                                liveFeedPageToolFloatLayout.setVisibility(8);
                            }
                            RecyclerView recyclerView = this.l;
                            if (recyclerView != null && recyclerView != null) {
                                recyclerView.setPadding(0, oa0.b(getContext(), 15.0f), 0, oa0.b(getContext(), 12.0f));
                            }
                            LiveFeedFollowView liveFeedFollowView = this.m;
                            if (liveFeedFollowView != null && liveFeedFollowView != null) {
                                liveFeedFollowView.setPadding(0, 0, 0, oa0.b(getContext(), 9.0f));
                                break;
                            }
                        }
                        break;
                    case 1137617387:
                        if (str.equals(LiveFeedPageSdk.IMMERSION)) {
                            ImageView imageView4 = this.C;
                            if (imageView4 != null) {
                                imageView4.setVisibility(0);
                            }
                            if (pc0.a() && (view2 = this.a) != null) {
                                view2.setPadding(0, pc0.e(getContext()), 0, 0);
                            }
                            View view4 = this.B;
                            if (view4 != null) {
                                view4.setVisibility(0);
                            }
                            SmartTabLayout smartTabLayout3 = this.k;
                            if (smartTabLayout3 != null) {
                                smartTabLayout3.setShowBottomLine(true);
                            }
                            NestedNoScrollViewPager nestedNoScrollViewPager2 = this.g;
                            if (nestedNoScrollViewPager2 != null) {
                                nestedNoScrollViewPager2.setCanScrollHorizontally(true);
                            }
                            SmartTabLayout smartTabLayout4 = this.k;
                            if (smartTabLayout4 != null) {
                                smartTabLayout4.setDarkModeCompatColor("color_white3", "color_sub_tab_normal");
                            }
                            RecyclerView recyclerView2 = this.l;
                            if (recyclerView2 != null && recyclerView2 != null) {
                                recyclerView2.setPadding(0, oa0.b(getContext(), 15.0f), 0, oa0.b(getContext(), 12.0f));
                            }
                            LiveFeedFollowView liveFeedFollowView2 = this.m;
                            if (liveFeedFollowView2 != null && liveFeedFollowView2 != null) {
                                liveFeedFollowView2.setPadding(0, 0, 0, oa0.b(getContext(), 9.0f));
                            }
                            View view5 = this.w;
                            if (view5 != null) {
                                view5.setVisibility(0);
                            }
                            View view6 = this.v;
                            if (view6 != null) {
                                view6.setVisibility(0);
                            }
                            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual("baidu", liveFeedPageSdk.getHost()) && J() && this.I && (imageView = this.E) != null) {
                                imageView.setVisibility(0);
                                break;
                            }
                        }
                        break;
                    case 1333267023:
                        if (str.equals(LiveFeedPageSdk.VIDEO_BAR)) {
                            Space space = this.o;
                            if (space != null) {
                                if (space != null && (layoutParams2 = space.getLayoutParams()) != null) {
                                    layoutParams2.height = oa0.b(getContext(), 11.0f);
                                } else {
                                    layoutParams2 = null;
                                }
                                space.setLayoutParams(layoutParams2);
                            }
                            ImageView imageView5 = this.C;
                            if (imageView5 != null) {
                                imageView5.setVisibility(8);
                            }
                            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout2 = this.D;
                            if (liveFeedPageToolFloatLayout2 != null) {
                                liveFeedPageToolFloatLayout2.setVisibility(8);
                            }
                            ViewGroup viewGroup = this.i;
                            if (viewGroup != null) {
                                viewGroup.setVisibility(8);
                            }
                            RecyclerView recyclerView3 = this.l;
                            if (recyclerView3 != null) {
                                recyclerView3.setVisibility(8);
                            }
                            NestedNoScrollViewPager nestedNoScrollViewPager3 = this.g;
                            if (nestedNoScrollViewPager3 != null) {
                                nestedNoScrollViewPager3.setCanScrollHorizontally(false);
                                break;
                            }
                        }
                        break;
                    case 1418021314:
                        if (str.equals(LiveFeedPageSdk.HOST_LIVE_TAB)) {
                            ImageView imageView6 = this.C;
                            if (imageView6 != null) {
                                imageView6.setVisibility(8);
                            }
                            View view7 = this.B;
                            if (view7 != null) {
                                view7.setVisibility(8);
                            }
                            LiveFeedPageSdk liveFeedPageSdk2 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk2, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_HAOKAN, liveFeedPageSdk2.getHost()) && !this.G) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            LinearLayout linearLayout = this.y;
                            if (linearLayout != null) {
                                if (z2) {
                                    i3 = 0;
                                }
                                linearLayout.setVisibility(i3);
                            }
                            SmartTabLayout smartTabLayout5 = this.k;
                            if (smartTabLayout5 != null) {
                                smartTabLayout5.setDarkModeCompatColor("color_FF33551", "color_sub_tab_normal");
                            }
                            LiveFeedPageSdk liveFeedPageSdk3 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk3, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_HAOKAN, liveFeedPageSdk3.getHost())) {
                                SmartTabLayout smartTabLayout6 = this.k;
                                if (smartTabLayout6 != null) {
                                    smartTabLayout6.setCustomTextsSize(oa0.b(getContext(), 16.0f));
                                }
                                if (this.G) {
                                    SmartTabLayout smartTabLayout7 = this.k;
                                    if (smartTabLayout7 != null) {
                                        smartTabLayout7.setShowBottomLine(false);
                                    }
                                } else {
                                    SmartTabLayout smartTabLayout8 = this.k;
                                    if (smartTabLayout8 != null) {
                                        smartTabLayout8.setShowBottomLine(true);
                                    }
                                    SmartTabLayout smartTabLayout9 = this.k;
                                    if (smartTabLayout9 != null) {
                                        smartTabLayout9.setSelectedIndicatorColors(Color.parseColor("#222222"));
                                    }
                                }
                            }
                            LiveFeedPageSdk liveFeedPageSdk4 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk4, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual("baidu", liveFeedPageSdk4.getHost()) && J() && this.I && (imageView2 = this.E) != null) {
                                imageView2.setVisibility(0);
                            }
                            LiveFeedPageSdk liveFeedPageSdk5 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk5, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual("baidu", liveFeedPageSdk5.getHost()) && getAccountManager() != null) {
                                qa0.e("last_time_enter_zhibo_channel_" + getAccountManager().getUid(), System.currentTimeMillis());
                            }
                            LiveFeedPageSdk liveFeedPageSdk6 = LiveFeedPageSdk.getInstance();
                            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk6, "LiveFeedPageSdk.getInstance()");
                            if (Intrinsics.areEqual("baidu", liveFeedPageSdk6.getHost())) {
                                long currentTimeMillis = System.currentTimeMillis();
                                if (qa0.a(x("need_to_check"), true) && qa0.a(x("user_clicked_add_channel_btn"), false)) {
                                    long c2 = qa0.c(x("user_click_add_channel_time"), 0L);
                                    if (c2 != 0 && currentTimeMillis > c2 && qa0.c(x("days_no_visit_live_channel"), 0L) != 0) {
                                        if (currentTimeMillis - c2 < qa0.c(x("days_no_visit_live_channel"), 0L)) {
                                            qa0.d(x("need_to_check"), false);
                                            qa0.d(x("need_insert_live_channel_to_end"), false);
                                        } else {
                                            qa0.d(x("need_to_check"), false);
                                        }
                                    }
                                }
                            }
                            View view8 = this.w;
                            if (view8 != null) {
                                view8.setVisibility(0);
                            }
                            View view9 = this.v;
                            if (view9 != null) {
                                view9.setVisibility(0);
                            }
                            View view10 = this.w;
                            if (view10 != null) {
                                if (z2) {
                                    if (view10 != null) {
                                        layoutParams5 = view10.getLayoutParams();
                                    } else {
                                        layoutParams5 = null;
                                    }
                                    if (layoutParams5 != null) {
                                        layoutParams4 = (RelativeLayout.LayoutParams) layoutParams5;
                                        layoutParams4.width = oa0.b(getContext(), 60.0f);
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                                    }
                                } else {
                                    if (view10 != null) {
                                        layoutParams3 = view10.getLayoutParams();
                                    } else {
                                        layoutParams3 = null;
                                    }
                                    if (layoutParams3 != null) {
                                        layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                                        layoutParams4.width = oa0.b(getContext(), 26.0f);
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                                    }
                                }
                                view10.setLayoutParams(layoutParams4);
                                break;
                            }
                        }
                        break;
                }
            }
            SmartTabLayout smartTabLayout10 = this.k;
            if (smartTabLayout10 != null) {
                smartTabLayout10.setScene(this.F);
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.c(this.F);
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout3 = this.D;
            if (liveFeedPageToolFloatLayout3 != null) {
                layoutParams = liveFeedPageToolFloatLayout3.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams;
                if (Intrinsics.areEqual(LiveFeedPageSdk.IMMERSION, this.F)) {
                    layoutParams6.bottomMargin = oa0.b(getContext(), 15.0f);
                } else {
                    Context context = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    layoutParams6.bottomMargin = bd0.e(oa0.c(context.getResources(), 10.0f), 0, 0, 6, null);
                }
                LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout4 = this.D;
                if (liveFeedPageToolFloatLayout4 != null) {
                    liveFeedPageToolFloatLayout4.setLayoutParams(layoutParams6);
                }
                LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout5 = this.D;
                if (liveFeedPageToolFloatLayout5 != null) {
                    liveFeedPageToolFloatLayout5.setImmersion(Intrinsics.areEqual(LiveFeedPageSdk.IMMERSION, this.F));
                }
                ImageView imageView7 = this.C;
                if (imageView7 != null) {
                    Context context2 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                    float c3 = oa0.c(context2.getResources(), 38.0f);
                    Context context3 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                    bd0.j(imageView7, c3, oa0.c(context3.getResources(), 38.0f), 0, 0, 12, null);
                }
                BaiduLiveTabAdapter baiduLiveTabAdapter = new BaiduLiveTabAdapter(this.O, i2, this.F, this.K, this.Q, this.U);
                this.h = baiduLiveTabAdapter;
                if (baiduLiveTabAdapter != null) {
                    baiduLiveTabAdapter.s(new e(this));
                }
                NestedNoScrollViewPager nestedNoScrollViewPager4 = this.g;
                if (nestedNoScrollViewPager4 != null) {
                    nestedNoScrollViewPager4.setAdapter(this.h);
                }
                LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = new LiveFeedPageSubTipAdapter(getContext(), this.F);
                this.n = liveFeedPageSubTipAdapter;
                if (liveFeedPageSubTipAdapter != null) {
                    liveFeedPageSubTipAdapter.k(new f(this));
                }
                RecyclerView recyclerView4 = this.l;
                if (recyclerView4 != null) {
                    recyclerView4.setAdapter(this.n);
                }
                LiveFeedFollowView liveFeedFollowView3 = this.m;
                if (liveFeedFollowView3 != null) {
                    String str5 = this.F;
                    if (str5 == null) {
                        str5 = LiveFeedPageSdk.HOST_LIVE_TAB;
                    }
                    liveFeedFollowView3.d(str5);
                }
                LiveFeedFollowView liveFeedFollowView4 = this.m;
                if (liveFeedFollowView4 != null) {
                    liveFeedFollowView4.setFollowListener(this.c0);
                }
                E();
                LiveExpandTabView liveExpandTabView = this.x;
                if (liveExpandTabView != null) {
                    String str6 = this.F;
                    if (str6 != null) {
                        str4 = str6;
                    }
                    liveExpandTabView.c(str4);
                }
                LiveExpandTabView liveExpandTabView2 = this.x;
                if (liveExpandTabView2 != null) {
                    liveExpandTabView2.setLiveExpandTabViewListener(new g(this));
                }
                f0(this.r);
                P("day");
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0569, (ViewGroup) this, true);
            this.b = findViewById(R.id.obfuscated_res_0x7f09156a);
            this.c = findViewById(R.id.obfuscated_res_0x7f091628);
            this.d = (MinorView) findViewById(R.id.obfuscated_res_0x7f09149d);
            this.e = findViewById(R.id.obfuscated_res_0x7f09149f);
            this.f = (AppBarLayout) findViewById(R.id.obfuscated_res_0x7f091495);
            this.o = (Space) findViewById(R.id.obfuscated_res_0x7f091498);
            this.p = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091497);
            this.i = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914a8);
            this.j = findViewById(R.id.obfuscated_res_0x7f0914a6);
            this.k = (SmartTabLayout) findViewById(R.id.obfuscated_res_0x7f0914a5);
            this.l = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0914aa);
            this.m = (LiveFeedFollowView) findViewById(R.id.obfuscated_res_0x7f0914a0);
            this.t = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091496);
            this.u = findViewById(R.id.obfuscated_res_0x7f0914a1);
            this.v = findViewById(R.id.obfuscated_res_0x7f0914a7);
            this.w = findViewById(R.id.obfuscated_res_0x7f0914a9);
            this.y = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914a2);
            this.z = (TextView) findViewById(R.id.obfuscated_res_0x7f0914a3);
            this.B = findViewById(R.id.obfuscated_res_0x7f0914a4);
            this.A = (FakeStartLiveButton) findViewById(R.id.obfuscated_res_0x7f091434);
            this.r = (LoadingView) findViewById(R.id.obfuscated_res_0x7f09149c);
            this.E = (ImageView) findViewById(R.id.obfuscated_res_0x7f09149a);
            this.x = (LiveExpandTabView) findViewById(R.id.obfuscated_res_0x7f09142b);
            MinorView minorView = this.d;
            if (minorView != null) {
                minorView.c(this.F);
            }
            MinorView minorView2 = this.d;
            if (minorView2 != null) {
                minorView2.setActionCallback(new j(this));
            }
            FakeStartLiveButton fakeStartLiveButton = this.A;
            if (fakeStartLiveButton != null) {
                fakeStartLiveButton.setOnClickListener(new k(this));
            }
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091435);
            this.C = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new l(this));
            }
            View view2 = this.v;
            if (view2 != null) {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                bd0.m(view2, oa0.c(context.getResources(), 8.0f), 0, 0, 6, null);
            }
            View view3 = this.w;
            if (view3 != null) {
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                bd0.m(view3, oa0.c(context2.getResources(), 26.0f), 0, 0, 6, null);
            }
            ImageView imageView2 = this.E;
            if (imageView2 != null) {
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                float c2 = oa0.c(context3.getResources(), 26.0f);
                Context context4 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                bd0.j(imageView2, c2, oa0.c(context4.getResources(), 26.0f), 0, 0, 12, null);
            }
            ImageView imageView3 = this.E;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new m(this));
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = (LiveFeedPageToolFloatLayout) findViewById(R.id.obfuscated_res_0x7f091451);
            this.D = liveFeedPageToolFloatLayout;
            if (liveFeedPageToolFloatLayout != null) {
                liveFeedPageToolFloatLayout.setCallback(new n(this));
            }
            LinearLayout linearLayout = this.y;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new o(this));
            }
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager.setOrientation(0);
            RecyclerView recyclerView = this.l;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(staggeredGridLayoutManager);
            }
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) findViewById(R.id.obfuscated_res_0x7f0914ab);
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_HAOKAN, liveFeedPageSdk.getHost())) {
                nestedNoScrollViewPager.setId(ViewCompat.generateViewId());
            }
            nestedNoScrollViewPager.setOffscreenPageLimit(1);
            nestedNoScrollViewPager.setSaveEnabled(false);
            this.g = nestedNoScrollViewPager;
            SmartTabLayout smartTabLayout = this.k;
            if (smartTabLayout != null) {
                smartTabLayout.setAllTabIsBold(false);
            }
            SmartTabLayout smartTabLayout2 = this.k;
            if (smartTabLayout2 != null) {
                smartTabLayout2.setTabSelectedColorEnable(true);
            }
            SmartTabLayout smartTabLayout3 = this.k;
            if (smartTabLayout3 != null) {
                smartTabLayout3.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.live.business.LiveTabFeedView$initView$8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveTabFeedView a;

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
                    public void onPageSelected(int i2) {
                        Fragment fragment;
                        String str;
                        Fragment fragment2;
                        SmartTabLayout mSmartTabLayout;
                        LiveTabEntity f2;
                        Fragment fragment3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                            LiveFeedPageSdk.liveLog("二级 tab 滑动/点击切换：" + i2);
                            int a2 = ta0.a();
                            BaiduLiveTabAdapter baiduLiveTabAdapter = this.a.h;
                            Fragment fragment4 = null;
                            if (baiduLiveTabAdapter != null) {
                                fragment = baiduLiveTabAdapter.getItem(a2);
                            } else {
                                fragment = null;
                            }
                            boolean z = false;
                            if (fragment instanceof LiveBaseFragment) {
                                BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.a.h;
                                if (baiduLiveTabAdapter2 != null) {
                                    fragment3 = baiduLiveTabAdapter2.getItem(a2);
                                } else {
                                    fragment3 = null;
                                }
                                if (fragment3 != null) {
                                    ((LiveBaseFragment) fragment3).H1(false);
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.base.LiveBaseFragment");
                                }
                            }
                            LiveTabFeedView liveTabFeedView = this.a;
                            BaiduLiveTabAdapter baiduLiveTabAdapter3 = liveTabFeedView.h;
                            if (baiduLiveTabAdapter3 != null && (f2 = baiduLiveTabAdapter3.f(i2)) != null) {
                                str = f2.type;
                            } else {
                                str = null;
                            }
                            liveTabFeedView.J = str;
                            ta0.c(i2);
                            BaiduLiveTabAdapter baiduLiveTabAdapter4 = this.a.h;
                            if (baiduLiveTabAdapter4 != null) {
                                fragment2 = baiduLiveTabAdapter4.getItem(i2);
                            } else {
                                fragment2 = null;
                            }
                            if (fragment2 instanceof LiveBaseFragment) {
                                BaiduLiveTabAdapter baiduLiveTabAdapter5 = this.a.h;
                                if (baiduLiveTabAdapter5 != null) {
                                    fragment4 = baiduLiveTabAdapter5.getItem(i2);
                                }
                                if (fragment4 != null) {
                                    ((LiveBaseFragment) fragment4).H1(true);
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.base.LiveBaseFragment");
                                }
                            }
                            this.a.A(i2);
                            SmartTabLayout mSmartTabLayout2 = this.a.getMSmartTabLayout();
                            if (mSmartTabLayout2 != null) {
                                mSmartTabLayout2.B("day");
                            }
                            if (this.a.I && Intrinsics.areEqual(LiveFeedPageSdk.HOST_LIVE_TAB, this.a.F) && (mSmartTabLayout = this.a.getMSmartTabLayout()) != null) {
                                mSmartTabLayout.A();
                            }
                            SmartTabLayout mSmartTabLayout3 = this.a.getMSmartTabLayout();
                            if (mSmartTabLayout3 != null) {
                                mSmartTabLayout3.setScrollLineVisibility(i2);
                            }
                            BaiduLiveTabAdapter baiduLiveTabAdapter6 = this.a.h;
                            if (baiduLiveTabAdapter6 != null) {
                                baiduLiveTabAdapter6.c(i2, true, true);
                            }
                            LiveTabFeedView liveTabFeedView2 = this.a;
                            if (i2 == 0) {
                                z = true;
                            }
                            liveTabFeedView2.setViewPagerInFistPage(z);
                        }
                    }
                });
            }
            SmartTabLayout smartTabLayout4 = this.k;
            if (smartTabLayout4 != null) {
                smartTabLayout4.setOnTabClickListener(new p(this));
            }
            SmartTabLayout smartTabLayout5 = this.k;
            if (smartTabLayout5 != null) {
                smartTabLayout5.setOnScrollChangeListener(new h(this));
            }
            ErrorView errorView = (ErrorView) findViewById(R.id.obfuscated_res_0x7f091499);
            this.s = errorView;
            if (errorView != null) {
                errorView.setActionCallback(new i(this));
            }
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AppBarLayout appBarLayout = this.f;
            AppBarLayout.Behavior behavior = null;
            if (appBarLayout != null) {
                layoutParams = appBarLayout.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (!(layoutParams instanceof CoordinatorLayout.e)) {
                return false;
            }
            AppBarLayout appBarLayout2 = this.f;
            if (appBarLayout2 != null) {
                layoutParams2 = appBarLayout2.getLayoutParams();
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                CoordinatorLayout.Behavior e2 = ((CoordinatorLayout.e) layoutParams2).e();
                if (e2 instanceof AppBarLayout.Behavior) {
                    behavior = e2;
                }
                AppBarLayout.Behavior behavior2 = behavior;
                if (behavior2 == null || behavior2.E() != 0) {
                    return false;
                }
                return true;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.LayoutParams");
        }
        return invokeV.booleanValue;
    }

    public final void e0() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            AppBarLayout appBarLayout = this.f;
            AppBarLayout.Behavior behavior = null;
            if (appBarLayout != null) {
                layoutParams = appBarLayout.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof CoordinatorLayout.e) {
                AppBarLayout appBarLayout2 = this.f;
                if (appBarLayout2 != null) {
                    layoutParams2 = appBarLayout2.getLayoutParams();
                } else {
                    layoutParams2 = null;
                }
                if (layoutParams2 != null) {
                    CoordinatorLayout.Behavior e2 = ((CoordinatorLayout.e) layoutParams2).e();
                    if (e2 instanceof AppBarLayout.Behavior) {
                        behavior = e2;
                    }
                    AppBarLayout.Behavior behavior2 = behavior;
                    if (behavior2 != null && behavior2.E() != 0) {
                        behavior2.G(0);
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.LayoutParams");
            }
        }
    }

    public final void i0() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            int[] iArr = new int[2];
            View view2 = this.j;
            if (view2 != null) {
                view2.getLocationOnScreen(iArr);
            }
            int[] iArr2 = new int[2];
            View view3 = this.e;
            if (view3 != null) {
                view3.getLocationOnScreen(iArr2);
            }
            int i2 = iArr[1] - iArr2[1];
            LiveExpandTabView liveExpandTabView = this.x;
            if (liveExpandTabView != null) {
                if (liveExpandTabView != null) {
                    layoutParams = liveExpandTabView.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = i2;
                    liveExpandTabView.setLayoutParams(layoutParams2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
            }
            LiveExpandTabView liveExpandTabView2 = this.x;
            if (liveExpandTabView2 != null) {
                liveExpandTabView2.setVisibility(0);
            }
        }
    }

    public final void m0() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity liveTabEntity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (baiduLiveTabAdapter = this.h) != null && (nestedNoScrollViewPager = this.g) != null) {
            LiveTabEntity.TabLabelInfo tabLabelInfo = null;
            if (baiduLiveTabAdapter != null) {
                if (nestedNoScrollViewPager == null) {
                    Intrinsics.throwNpe();
                }
                liveTabEntity = baiduLiveTabAdapter.f(nestedNoScrollViewPager.getCurrentItem());
            } else {
                liveTabEntity = null;
            }
            if (liveTabEntity != null && !TextUtils.isEmpty(liveTabEntity.type)) {
                LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
                if (liveFeedPageSubTipAdapter != null) {
                    tabLabelInfo = liveFeedPageSubTipAdapter.g();
                }
                String str2 = "";
                if (tabLabelInfo == null) {
                    str = "";
                } else {
                    str = tabLabelInfo.type;
                }
                this.K = str;
                BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.h;
                if (baiduLiveTabAdapter2 != null) {
                    String str3 = liveTabEntity.type;
                    if (tabLabelInfo != null) {
                        str2 = tabLabelInfo.type;
                    }
                    NestedNoScrollViewPager nestedNoScrollViewPager2 = this.g;
                    if (nestedNoScrollViewPager2 == null) {
                        Intrinsics.throwNpe();
                    }
                    baiduLiveTabAdapter2.u(str3, str2, nestedNoScrollViewPager2.getCurrentItem());
                }
            }
        }
    }

    public final void r() {
        int i2;
        int i3;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (!Intrinsics.areEqual(LiveFeedPageSdk.IMMERSION, this.F) && !Intrinsics.areEqual("recommend", this.F)) {
                i2 = 81;
            } else {
                i2 = 93;
            }
            if (Intrinsics.areEqual(LiveFeedPageSdk.VIDEO_BAR, this.F)) {
                i3 = 0;
            } else {
                i3 = 42;
            }
            LinearLayout linearLayout = this.t;
            if (linearLayout != null) {
                Context context = getContext();
                RecyclerView recyclerView = this.l;
                if (recyclerView != null && recyclerView.getVisibility() == 0) {
                    f2 = i2;
                } else {
                    f2 = i3;
                }
                linearLayout.setMinimumHeight(oa0.b(context, f2));
            }
        }
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_HAOKAN, liveFeedPageSdk.getHost()) && !this.G && Intrinsics.areEqual(this.F, LiveFeedPageSdk.HOST_LIVE_TAB)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            View view2 = this.a;
            if (view2 != null) {
                view2.setBackgroundColor(fd0.f().a(getContext(), this.F, "color_main_bg"));
            }
            View view3 = this.u;
            if (view3 != null) {
                view3.setBackgroundColor(fd0.f().a(getContext(), this.F, "color_F5F5F52"));
            }
            TextView textView = this.z;
            if (textView != null) {
                textView.setTextColor(fd0.f().a(getContext(), this.F, "color_1F1F1F"));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.m(str);
            }
            ErrorView errorView = this.s;
            if (errorView != null) {
                errorView.c(this.F);
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.c(this.F);
            }
            MinorView minorView = this.d;
            if (minorView != null) {
                minorView.c(this.F);
            }
            BannerView bannerView = this.q;
            if (bannerView != null) {
                bannerView.u(str);
            }
            LiveFeedFollowView liveFeedFollowView = this.m;
            if (liveFeedFollowView != null) {
                liveFeedFollowView.f(str);
            }
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
            if (liveFeedPageSubTipAdapter != null) {
                liveFeedPageSubTipAdapter.notifyDataSetChanged();
            }
            SmartTabLayout smartTabLayout = this.k;
            if (smartTabLayout != null) {
                smartTabLayout.B(str);
            }
            SmartTabLayout smartTabLayout2 = this.k;
            if (smartTabLayout2 != null) {
                smartTabLayout2.A();
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.D;
            if (liveFeedPageToolFloatLayout != null) {
                fd0 f2 = fd0.f();
                Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
                liveFeedPageToolFloatLayout.d(f2.r());
            }
            ImageView imageView = this.E;
            if (imageView != null) {
                ua0 ua0Var = ua0.a;
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                imageView.setBackgroundDrawable(ua0Var.b(context, this.F));
            }
            LiveExpandTabView liveExpandTabView = this.x;
            if (liveExpandTabView != null) {
                liveExpandTabView.d(str);
            }
            View view4 = this.v;
            if (view4 != null) {
                ua0 ua0Var2 = ua0.a;
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                view4.setBackgroundDrawable(ua0Var2.a(context2, this.F, str));
            }
            View view5 = this.w;
            if (view5 != null) {
                ua0 ua0Var3 = ua0.a;
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                view5.setBackgroundDrawable(ua0Var3.d(context3, this.F, str));
            }
        }
    }

    public final void T(int i2) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            View view2 = this.v;
            if (view2 != null) {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                bd0.m(view2, oa0.c(context.getResources(), 8.0f), 0, 0, 6, null);
            }
            View view3 = this.w;
            if (view3 != null) {
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                bd0.m(view3, oa0.c(context2.getResources(), 26.0f), 0, 0, 6, null);
            }
            ImageView imageView = this.E;
            if (imageView != null) {
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                float c2 = oa0.c(context3.getResources(), 26.0f);
                Context context4 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                bd0.j(imageView, c2, oa0.c(context4.getResources(), 26.0f), 0, 0, 12, null);
            }
            LiveExpandTabView liveExpandTabView = this.x;
            if (liveExpandTabView != null) {
                liveExpandTabView.e();
            }
            LiveFeedFollowView liveFeedFollowView = this.m;
            if (liveFeedFollowView != null) {
                liveFeedFollowView.h(i2);
            }
            SmartTabLayout smartTabLayout = this.k;
            if (smartTabLayout != null) {
                smartTabLayout.C();
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.D;
            if (liveFeedPageToolFloatLayout != null) {
                liveFeedPageToolFloatLayout.e();
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.o();
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout2 = this.D;
            if (liveFeedPageToolFloatLayout2 != null) {
                layoutParams = liveFeedPageToolFloatLayout2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_LIVE_TAB, this.F)) {
                    Context context5 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context5, "context");
                    layoutParams2.bottomMargin = bd0.e(oa0.c(context5.getResources(), 10.0f), 0, 0, 6, null);
                }
                LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout3 = this.D;
                if (liveFeedPageToolFloatLayout3 != null) {
                    liveFeedPageToolFloatLayout3.setLayoutParams(layoutParams2);
                }
                ImageView imageView2 = this.C;
                if (imageView2 != null) {
                    Context context6 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context6, "context");
                    float c3 = oa0.c(context6.getResources(), 38.0f);
                    Context context7 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context7, "context");
                    bd0.j(imageView2, c3, oa0.c(context7.getResources(), 38.0f), 0, 0, 12, null);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    public final void Y(String str, String str2) {
        Integer num;
        int i2;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, str2) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(str, this.J) && !TextUtils.isEmpty(str2) && Intrinsics.areEqual(str2, this.K)) {
                return;
            }
            int i3 = -1;
            if (!Intrinsics.areEqual(str, this.J)) {
                if (this.h != null) {
                    LiveFeedPageSdk.liveLog("D8800088 onTabSelectedEvent 二级Tab不一致，需要重新设定");
                    this.J = str;
                    this.K = str2;
                    BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
                    if (baiduLiveTabAdapter != null) {
                        i2 = baiduLiveTabAdapter.e(str);
                    } else {
                        i2 = -1;
                    }
                    LiveFeedPageSdk.liveLog("D8800088 selectedPos = " + i2 + ", LiveTabUtil.getCurFragPos() = " + ta0.a());
                    if (i2 != -1 && i2 != ta0.a() && (nestedNoScrollViewPager = this.g) != null) {
                        nestedNoScrollViewPager.setCurrentItem(i2);
                    }
                }
            } else if (!Intrinsics.areEqual(str2, this.K)) {
                this.K = str2;
                LiveFeedPageSdk.liveLog("D8800088 onTabSelectedEvent 3333级Tab不一致，需要重新设定");
                LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
                if (liveFeedPageSubTipAdapter != null) {
                    i3 = liveFeedPageSubTipAdapter.e(this.K);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("D8800088 selectedPos = ");
                sb.append(i3);
                sb.append(", mSubTipAdapter.getSelectPos() = ");
                LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter2 = this.n;
                if (liveFeedPageSubTipAdapter2 != null) {
                    num = Integer.valueOf(liveFeedPageSubTipAdapter2.f());
                } else {
                    num = null;
                }
                sb.append(num);
                LiveFeedPageSdk.liveLog(sb.toString());
                d0(i3);
            }
        }
    }

    public final void a0(LiveBannerWrapData liveBannerWrapData) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, liveBannerWrapData) == null) && this.q != null && this.p != null) {
            int i2 = 0;
            if (!Intrinsics.areEqual(this.F, LiveFeedPageSdk.IMMERSION) && !Intrinsics.areEqual(this.F, "recommend")) {
                if (liveBannerWrapData != null) {
                    if (!qc0.c(liveBannerWrapData.bannerList)) {
                        List<LiveBannerEntity> list = liveBannerWrapData.bannerList;
                        BannerView bannerView2 = this.q;
                        if (bannerView2 != null && bannerView2.r(list) && (bannerView = this.q) != null) {
                            BannerEntity bannerEntity = new BannerEntity();
                            bannerEntity.mBannerList = list;
                            bannerEntity.mBroadcastInterval = 5000;
                            bannerView.setBannerEntity(bannerEntity);
                        }
                        BannerView bannerView3 = this.q;
                        if (bannerView3 != null) {
                            bannerView3.setVisibility(0);
                        }
                        this.H = true;
                    } else {
                        this.H = false;
                        BannerView bannerView4 = this.q;
                        if (bannerView4 != null) {
                            bannerView4.setVisibility(8);
                        }
                    }
                } else {
                    this.H = false;
                    BannerView bannerView5 = this.q;
                    if (bannerView5 != null) {
                        bannerView5.setVisibility(8);
                    }
                }
                FrameLayout frameLayout = this.p;
                if (frameLayout != null) {
                    BannerView bannerView6 = this.q;
                    frameLayout.setVisibility((bannerView6 == null || bannerView6.getVisibility() != 0) ? 8 : 8);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.p;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            BannerView bannerView7 = this.q;
            if (bannerView7 != null) {
                bannerView7.setVisibility(8);
            }
            s();
            this.H = false;
        }
    }

    public final void f0(View view2) {
        int i2;
        int i3;
        ErrorView errorView;
        int i4;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener2;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            int i5 = 0;
            if (Intrinsics.areEqual(LiveFeedPageSdk.VIDEO_BAR, this.F)) {
                ErrorView errorView2 = this.s;
                if (errorView2 != null) {
                    errorView2.d(8);
                }
                LoadingView loadingView = this.r;
                if (loadingView != null) {
                    loadingView.setVisibility(8);
                }
                if (Intrinsics.areEqual(view2, this.s) && (liveFeedStatusListener3 = this.W) != null) {
                    liveFeedStatusListener3.onError();
                }
                if (Intrinsics.areEqual(view2, this.r) && (liveFeedStatusListener2 = this.W) != null) {
                    liveFeedStatusListener2.onLoading();
                }
                if (Intrinsics.areEqual(view2, this.e) && (liveFeedStatusListener = this.W) != null) {
                    liveFeedStatusListener.onLoadSuccess();
                }
            } else {
                ErrorView errorView3 = this.s;
                if (errorView3 != null) {
                    if (Intrinsics.areEqual(view2, errorView3)) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    errorView3.e(i3, this.F);
                }
                LoadingView loadingView2 = this.r;
                if (loadingView2 != null) {
                    if (Intrinsics.areEqual(view2, loadingView2)) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    loadingView2.setVisibility(i2);
                }
            }
            View view3 = this.e;
            if (view3 != null) {
                if (Intrinsics.areEqual(view2, view3)) {
                    i4 = 0;
                } else {
                    i4 = 4;
                }
                view3.setVisibility(i4);
            }
            FakeStartLiveButton fakeStartLiveButton = this.A;
            if (fakeStartLiveButton != null && (errorView = this.s) != null && fakeStartLiveButton != null) {
                fakeStartLiveButton.setVisibility((errorView != null && errorView.getVisibility() == 0 && K()) ? 8 : 8);
            }
        }
    }

    public final void l0(boolean z, String str) {
        View view2;
        View view3;
        View view4;
        View view5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048626, this, z, str) == null) {
            if (z) {
                View view6 = this.b;
                if ((view6 == null || view6.getVisibility() != 8) && (view4 = this.b) != null) {
                    view4.setVisibility(8);
                }
                View view7 = this.c;
                if ((view7 == null || view7.getVisibility() != 0) && (view5 = this.c) != null) {
                    view5.setVisibility(0);
                }
                if (!TextUtils.isEmpty(str)) {
                    this.L = str;
                    return;
                }
                return;
            }
            View view8 = this.b;
            if ((view8 == null || view8.getVisibility() != 0) && (view2 = this.b) != null) {
                view2.setVisibility(0);
            }
            View view9 = this.c;
            if ((view9 == null || view9.getVisibility() != 8) && (view3 = this.c) != null) {
                view3.setVisibility(8);
            }
        }
    }

    public final String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, str)) == null) {
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
}
