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
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.de0;
import com.baidu.tieba.mb0;
import com.baidu.tieba.nd0;
import com.baidu.tieba.ob0;
import com.baidu.tieba.od0;
import com.baidu.tieba.rb0;
import com.baidu.tieba.sb0;
import com.baidu.tieba.ub0;
import com.baidu.tieba.zd0;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002 \u0001\u0018\u0000 ¥\u00022\u00020\u0001:\u0004¥\u0002¦\u0002B.\b\u0007\u0012\b\u0010\u009f\u0002\u001a\u00030\u009e\u0002\u0012\f\b\u0002\u0010¡\u0002\u001a\u0005\u0018\u00010 \u0002\u0012\t\b\u0002\u0010¢\u0002\u001a\u00020\u0012¢\u0006\u0006\b£\u0002\u0010¤\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001e\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0012¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J!\u0010*\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u000b¢\u0006\u0004\b,\u0010\rJ\u000f\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010\bJA\u00105\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00122\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u00010\u00152\b\u00104\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u0010\bJ\u000f\u00108\u001a\u00020\u000bH\u0002¢\u0006\u0004\b8\u0010\rJ\r\u00109\u001a\u00020\u000b¢\u0006\u0004\b9\u0010\rJ\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010\rJ\r\u0010;\u001a\u00020\u0004¢\u0006\u0004\b;\u0010\bJ\r\u0010<\u001a\u00020\u0004¢\u0006\u0004\b<\u0010\bJ\r\u0010=\u001a\u00020\u0004¢\u0006\u0004\b=\u0010\bJ\u0017\u0010?\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0004¢\u0006\u0004\bA\u0010\bJ\u0017\u0010C\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010B¢\u0006\u0004\bC\u0010DJ\u0019\u0010F\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010E¢\u0006\u0004\bF\u0010GJ\u0015\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0012¢\u0006\u0004\bI\u0010\"J\r\u0010J\u001a\u00020\u0004¢\u0006\u0004\bJ\u0010\bJ\r\u0010K\u001a\u00020\u0004¢\u0006\u0004\bK\u0010\bJ\r\u0010L\u001a\u00020\u0004¢\u0006\u0004\bL\u0010\bJ\r\u0010M\u001a\u00020\u0004¢\u0006\u0004\bM\u0010\bJ%\u0010N\u001a\u00020\u00042\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bN\u0010OJ\u0017\u0010R\u001a\u00020\u00042\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\u0004¢\u0006\u0004\bV\u0010\bJ\u0017\u0010W\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\bW\u0010\"J\u0017\u0010Y\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u000bH\u0002¢\u0006\u0004\bY\u0010UJ\u000f\u0010Z\u001a\u00020\u0004H\u0002¢\u0006\u0004\bZ\u0010\bJ\u0017\u0010\\\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\\\u0010@J#\u0010_\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u000b2\b\b\u0002\u0010^\u001a\u00020\u000bH\u0007¢\u0006\u0004\b_\u0010`J\u0015\u0010b\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u000b¢\u0006\u0004\bb\u0010UJ\u0017\u0010e\u001a\u00020\u00042\b\u0010d\u001a\u0004\u0018\u00010c¢\u0006\u0004\be\u0010fJ\r\u0010g\u001a\u00020\u0004¢\u0006\u0004\bg\u0010\bJ\r\u0010h\u001a\u00020\u0004¢\u0006\u0004\bh\u0010\bJ\u000f\u0010i\u001a\u00020\u0004H\u0002¢\u0006\u0004\bi\u0010\bJ\u0015\u0010k\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u000b¢\u0006\u0004\bk\u0010UJ\r\u0010l\u001a\u00020\u0004¢\u0006\u0004\bl\u0010\bJ\u001f\u0010o\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u000b2\b\u0010n\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bo\u0010pJ\u000f\u0010q\u001a\u00020\u0004H\u0002¢\u0006\u0004\bq\u0010\bR%\u0010x\u001a\n s*\u0004\u0018\u00010r0r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR$\u0010z\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR,\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R,\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018F@\u0006¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001a\u0010¡\u0001\u001a\u00030 \u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R \u0010¤\u0001\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b£\u0001\u0010u\u001a\u0005\b¤\u0001\u0010\rR'\u0010¥\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0005\b¥\u0001\u0010\r\"\u0005\b§\u0001\u0010UR\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001c\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001b\u0010´\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R,\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010½\u0001\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u00ad\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001c\u0010Ä\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R+\u0010Æ\u0001\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Î\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010¦\u0001R\u0019\u0010Ï\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010¦\u0001R\u0019\u0010Ð\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010¦\u0001R\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Í\u0001R\u001b\u0010Õ\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Í\u0001R\u001b\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010µ\u0001R,\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R*\u0010Þ\u0001\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÞ\u0001\u0010Í\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0005\bá\u0001\u0010fR\u001b\u0010â\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010Í\u0001R\u001b\u0010ã\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010Í\u0001R\u001c\u0010å\u0001\u001a\u0005\u0018\u00010ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001c\u0010è\u0001\u001a\u0005\u0018\u00010ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u001b\u0010ê\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010µ\u0001R\u001c\u0010ì\u0001\u001a\u0005\u0018\u00010ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R,\u0010ï\u0001\u001a\u0005\u0018\u00010î\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0006\bñ\u0001\u0010ò\u0001\"\u0006\bó\u0001\u0010ô\u0001R\u001c\u0010ö\u0001\u001a\u0005\u0018\u00010õ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u001f\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001b\u0010ú\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010µ\u0001R\u001c\u0010û\u0001\u001a\u0005\u0018\u00010ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010é\u0001R\u001b\u0010ü\u0001\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u001b\u0010þ\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010Í\u0001R,\u0010\u0080\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001b\u0010\u0086\u0002\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0002\u0010Í\u0001R\u001b\u0010\u0087\u0002\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010Í\u0001R*\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0088\u0002\u0010µ\u0001\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0005\b\u008b\u0002\u0010@R\u001c\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u008c\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010\u008e\u0002R\u001b\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R,\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0091\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0002\u0010\u0093\u0002\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002\"\u0006\b\u0096\u0002\u0010\u0097\u0002R\u001c\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0098\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R\u001c\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009b\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002¨\u0006§\u0002"}, d2 = {"Lcom/baidu/live/business/LiveTabFeedView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/live/feedpage/interfaces/ILiveFeedOther$LiveFeedStatusListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addLiveFeedStatusListener", "(Lcom/baidu/live/feedpage/interfaces/ILiveFeedOther$LiveFeedStatusListener;)V", "adjustCollapsingHeight", "()V", "animPause", "animResume", "", "canSlideDown", "()Z", "canSlideUp", "", "Lcom/baidu/live/business/model/data/LiveTabEntity;", "tabInfoList", "", "defaultTabPosition", "(Ljava/util/List;)I", "", "key", "getKeyWithUid", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/baidu/live/business/model/data/LiveFollowWrapData;", "followWrapData", "useNewStyle", "Lcom/baidu/live/business/model/data/LiveFeedConfig;", "config", "handleFollowData", "(Lcom/baidu/live/business/model/data/LiveFollowWrapData;ZLcom/baidu/live/business/model/data/LiveFeedConfig;)V", CriusAttrConstants.POSITION, "handleSubTab", "(I)V", "Lcom/baidu/live/business/model/data/LiveFeedData;", "feedData", "handleTabData", "(Lcom/baidu/live/business/model/data/LiveFeedData;)V", "Lcom/baidu/live/business/model/data/LiveFeedToolWrapData;", "toolWrapData", "feedConfig", "handleToolData", "(Lcom/baidu/live/business/model/data/LiveFeedToolWrapData;Lcom/baidu/live/business/model/data/LiveFeedConfig;)V", "hasMore", "initBanner", "scene", "isHKTopBar", "bdUniqueId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "subTabType", "thirdTabType", "initUiScene", "(Ljava/lang/String;ZILandroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;)V", "initView", "isAppBarTopState", "isFirstTabIndicatorVisible", "isHkTab", "notifyFragmentNetChange", "notifyPause", "notifyResume", "uiMode", "onDarkModeChange", "(Ljava/lang/String;)V", MissionEvent.MESSAGE_DESTROY, "Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnLoadMoreListener;", "onExternalLoadMore", "(Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnLoadMoreListener;)V", "Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnRefreshListener;", "onExternalRefresh", "(Lcom/baidu/live/feedpage/interfaces/ILiveFeedRefresh$OnRefreshListener;)V", "textSizeLevel", "onFontSizeChanged", "onPageHint", "onPageShow", MissionEvent.MESSAGE_PAUSE, "onResume", "onTabSelectedEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveBannerWrapData;", "liveBannerWrapData", "refreshBanner", "(Lcom/baidu/live/business/model/data/LiveBannerWrapData;)V", "refreshSpaceView", "(Z)V", "resetView", "selectSubTip", "scroll", "setAppBarScroll", "setAppBarScrollToTop", "roomId", "setCurrentRoom", "expanded", "animate", "setExpanded", "(ZZ)V", "isNewTabStyle", "setTabStyle", "Landroid/view/View;", "view", "show", "(Landroid/view/View;)V", "showContentView", "showErrorView", "showExpandTabPanel", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "showHideSearchGuideView", "showLoadingView", "isMinor", "ufoUrl", "showMinorModel", "(ZLjava/lang/String;)V", "updateSubTabInfo", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "kotlin.jvm.PlatformType", "accountManager$delegate", "Lkotlin/Lazy;", "getAccountManager", "()Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "accountManager", "Lcom/baidu/live/business/listener/TabFeedActionListener;", "feedActionListener", "Lcom/baidu/live/business/listener/TabFeedActionListener;", "getFeedActionListener", "()Lcom/baidu/live/business/listener/TabFeedActionListener;", "setFeedActionListener", "(Lcom/baidu/live/business/listener/TabFeedActionListener;)V", "Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "feedBannerListener", "Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "getFeedBannerListener", "()Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "setFeedBannerListener", "(Lcom/baidu/live/business/listener/LiveFeedBannerListener;)V", "Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "feedFollowListener", "Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "getFeedFollowListener", "()Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "setFeedFollowListener", "(Lcom/baidu/live/business/listener/LiveFeedFollowListener;)V", "Lcom/baidu/live/feedfollow/view/LiveFeedFollowView;", "getFeedFollowView", "()Lcom/baidu/live/feedfollow/view/LiveFeedFollowView;", "feedFollowView", "Lcom/baidu/live/business/model/ILiveFeedModel;", "feedModel", "Lcom/baidu/live/business/model/ILiveFeedModel;", "getFeedModel", "()Lcom/baidu/live/business/model/ILiveFeedModel;", "setFeedModel", "(Lcom/baidu/live/business/model/ILiveFeedModel;)V", "Lcom/baidu/live/business/listener/LiveFeedToolListener;", "feedToolListener", "Lcom/baidu/live/business/listener/LiveFeedToolListener;", "getFeedToolListener", "()Lcom/baidu/live/business/listener/LiveFeedToolListener;", "setFeedToolListener", "(Lcom/baidu/live/business/listener/LiveFeedToolListener;)V", "com/baidu/live/business/LiveTabFeedView$followListener$1", "followListener", "Lcom/baidu/live/business/LiveTabFeedView$followListener$1;", "isHitTabAbTest$delegate", "isHitTabAbTest", "isViewPagerInFistPage", "Z", "setViewPagerInFistPage", "Lcom/baidu/live/framework/appbar/AppBarLayout;", "mAppBarLayout", "Lcom/baidu/live/framework/appbar/AppBarLayout;", "Landroid/widget/ImageView;", "mBackBtn", "Landroid/widget/ImageView;", "Lcom/baidu/live/business/view/banner/BannerView;", "mBannerView", "Lcom/baidu/live/business/view/banner/BannerView;", "Landroid/widget/Space;", "mContentTopSpace", "Landroid/widget/Space;", "mCurPlayingRoomId", "Ljava/lang/String;", "Lcom/baidu/live/business/view/emotion/ErrorView;", "mErrorView", "Lcom/baidu/live/business/view/emotion/ErrorView;", "getMErrorView", "()Lcom/baidu/live/business/view/emotion/ErrorView;", "setMErrorView", "(Lcom/baidu/live/business/view/emotion/ErrorView;)V", "mExpandTabBtn", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabView;", "mExpandTabView", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabView;", "Lcom/baidu/live/business/view/FakeStartLiveButton;", "mFakeStartLiveButton", "Lcom/baidu/live/business/view/FakeStartLiveButton;", "mFeedFollowView", "Lcom/baidu/live/feedfollow/view/LiveFeedFollowView;", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getMFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setMFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "mImmersionDivider", "Landroid/view/View;", "mIsBannerOk", "mIsHKTopBar", "mIsNewTabStyle", "Lcom/baidu/live/business/view/emotion/LoadingView;", "mLoadingView", "Lcom/baidu/live/business/view/emotion/LoadingView;", "mRootContainer", "mRootView", "mScene", "Lcom/baidu/live/business/view/smarttab/SmartTabLayout;", "mSmartTabLayout", "Lcom/baidu/live/business/view/smarttab/SmartTabLayout;", "getMSmartTabLayout", "()Lcom/baidu/live/business/view/smarttab/SmartTabLayout;", "setMSmartTabLayout", "(Lcom/baidu/live/business/view/smarttab/SmartTabLayout;)V", "mSmartTabLayoutContainer", "getMSmartTabLayoutContainer", "()Landroid/view/View;", "setMSmartTabLayoutContainer", "mSmartTabLeftCover", "mSmartTabRightCover", "Landroid/widget/TextView;", "mStartLiveBtn", "Landroid/widget/TextView;", "Landroid/widget/LinearLayout;", "mStartLiveContainer", "Landroid/widget/LinearLayout;", "mSubTabType", "Lcom/baidu/live/business/adapter/LiveFeedPageSubTipAdapter;", "mSubTipAdapter", "Lcom/baidu/live/business/adapter/LiveFeedPageSubTipAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "mSubTipLayout", "Landroidx/recyclerview/widget/RecyclerView;", "getMSubTipLayout", "()Landroidx/recyclerview/widget/RecyclerView;", "setMSubTipLayout", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/baidu/live/business/BaiduLiveTabAdapter;", "mTabAdapter", "Lcom/baidu/live/business/BaiduLiveTabAdapter;", "mTabInfo", "Ljava/util/List;", "mThirdTabType", "mTopBaseContainer", "mTopContentContainer", "Landroid/widget/FrameLayout;", "mTopSpaceView", "Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;", "mViewPager", "Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;", "getMViewPager", "()Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;", "setMViewPager", "(Lcom/baidu/live/business/view/viewpager/NestedNoScrollViewPager;)V", "mainLayout", "minorLayout", "minorUfoUrl", "getMinorUfoUrl", "()Ljava/lang/String;", "setMinorUfoUrl", "Lcom/baidu/live/business/view/emotion/MinorView;", "minorView", "Lcom/baidu/live/business/view/emotion/MinorView;", "pagerStatusListener", "Lcom/baidu/live/feedpage/interfaces/ILiveFeedOther$LiveFeedStatusListener;", "Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;", "subTabPageListener", "Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;", "getSubTabPageListener", "()Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;", "setSubTabPageListener", "(Lcom/baidu/live/business/base/LiveBaseFragment$LiveSubTabFragmentListener;)V", "Landroid/view/ViewGroup;", "tabOverallRegion", "Landroid/view/ViewGroup;", "Lcom/baidu/live/business/view/tool/LiveFeedPageToolFloatLayout;", "toolFloatLayout", "Lcom/baidu/live/business/view/tool/LiveFeedPageToolFloatLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "Scene", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveTabFeedView extends FrameLayout {
    public static final /* synthetic */ KProperty[] d0 = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveTabFeedView.class), "accountManager", "getAccountManager()Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveTabFeedView.class), "isHitTabAbTest", "isHitTabAbTest()Z"))};
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

    /* renamed from: T  reason: collision with root package name */
    public LiveFeedFollowListener f1042T;
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

    @JvmOverloads
    public LiveTabFeedView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public LiveTabFeedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final AccountManagerService getAccountManager() {
        Lazy lazy = this.a0;
        KProperty kProperty = d0[0];
        return (AccountManagerService) lazy.getValue();
    }

    public final boolean J() {
        Lazy lazy = this.b0;
        KProperty kProperty = d0[1];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    @JvmOverloads
    public final void setExpanded() {
        setExpanded$default(this, false, false, 3, null);
    }

    @JvmOverloads
    public final void setExpanded(boolean z) {
        setExpanded$default(this, z, false, 2, null);
    }

    /* loaded from: classes3.dex */
    public static final class a implements LiveFeedFollowListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onClickFollow(LiveFollowEntity liveFollowEntity, int i) {
            LiveFeedFollowListener feedFollowListener = LiveTabFeedView.this.getFeedFollowListener();
            if (feedFollowListener != null) {
                feedFollowListener.onClickFollow(liveFollowEntity, i);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onFollowShow(LiveFollowEntity liveFollowEntity, int i) {
            LiveFeedFollowListener feedFollowListener = LiveTabFeedView.this.getFeedFollowListener();
            if (feedFollowListener != null) {
                feedFollowListener.onFollowShow(liveFollowEntity, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        public final /* synthetic */ int b;

        public b(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaiduLiveTabAdapter baiduLiveTabAdapter = LiveTabFeedView.this.h;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.r(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements BannerView.g {
        public c() {
        }

        @Override // com.baidu.live.business.view.banner.BannerView.g
        public final void a(LiveBannerEntity liveBannerEntity) {
            LiveFeedBannerListener feedBannerListener = LiveTabFeedView.this.getFeedBannerListener();
            if (feedBannerListener != null) {
                feedBannerListener.onClickBanner(liveBannerEntity);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements BannerView.i {
        public d() {
        }

        @Override // com.baidu.live.business.view.banner.BannerView.i
        public final void onBannerShow(LiveBannerEntity it) {
            LiveFeedBannerListener feedBannerListener = LiveTabFeedView.this.getFeedBannerListener();
            if (feedBannerListener != null) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                feedBannerListener.onBannerShow(it);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements LiveSubTabFragment.l {
        public e() {
        }

        @Override // com.baidu.live.business.LiveSubTabFragment.l
        public final void a(boolean z) {
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = LiveTabFeedView.this.D;
            if (liveFeedPageToolFloatLayout != null) {
                liveFeedPageToolFloatLayout.b(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements LiveFeedPageSubTipAdapter.b {
        public f() {
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter.b
        public final void a(View view2, int i) {
            LiveTabFeedView.this.d0(i);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements LiveExpandTabView.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public g() {
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabView.b
        public void a(LiveTabEntity liveTabEntity) {
            LiveExpandTabView liveExpandTabView = LiveTabFeedView.this.x;
            if (liveExpandTabView != null) {
                liveExpandTabView.c();
            }
            LiveTabFeedView.this.setExpanded(false, true);
            LiveTabFeedView.Z(LiveTabFeedView.this, liveTabEntity.type, null, 2, null);
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabView.b
        public void b() {
            LiveExpandTabView liveExpandTabView = LiveTabFeedView.this.x;
            if (liveExpandTabView != null) {
                liveExpandTabView.c();
            }
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabView.b
        public void onDismiss() {
            LiveTabFeedView.this.setAppBarScroll(true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements SmartTabLayout.d {
        public h() {
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.d
        public final void a(int i, int i2) {
            View view2;
            View view3;
            SmartTabLayout mSmartTabLayout = LiveTabFeedView.this.getMSmartTabLayout();
            if (mSmartTabLayout == null || mSmartTabLayout.canScrollHorizontally(-1)) {
                if ((!Intrinsics.areEqual(LiveTabFeedView.this.F, "recommend")) && (view2 = LiveTabFeedView.this.v) != null) {
                    view2.setVisibility(0);
                }
            } else {
                View view4 = LiveTabFeedView.this.v;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
            }
            SmartTabLayout mSmartTabLayout2 = LiveTabFeedView.this.getMSmartTabLayout();
            if (mSmartTabLayout2 == null || mSmartTabLayout2.canScrollHorizontally(1)) {
                if ((!Intrinsics.areEqual(LiveTabFeedView.this.F, "recommend")) && (view3 = LiveTabFeedView.this.w) != null) {
                    view3.setVisibility(0);
                    return;
                }
                return;
            }
            View view5 = LiveTabFeedView.this.w;
            if (view5 != null) {
                view5.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements ub0 {
        public i() {
        }

        @Override // com.baidu.tieba.ub0
        public final void a(View view2) {
            LiveTabFeedView liveTabFeedView = LiveTabFeedView.this;
            liveTabFeedView.f0(liveTabFeedView.r);
            TabFeedActionListener feedActionListener = LiveTabFeedView.this.getFeedActionListener();
            if (feedActionListener != null) {
                feedActionListener.onClickErrorRefresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements ub0 {
        public j() {
        }

        @Override // com.baidu.tieba.ub0
        public final void a(View view2) {
            ILiveFeedPageInvoke invoker;
            if (!TextUtils.isEmpty(LiveTabFeedView.this.getMinorUfoUrl()) && (invoker = LiveFeedPageSdk.getInstance().getInvoker()) != null) {
                invoker.invokeScheme(LiveTabFeedView.this.getContext(), LiveTabFeedView.this.getMinorUfoUrl());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            TabFeedActionListener feedActionListener = LiveTabFeedView.this.getFeedActionListener();
            if (feedActionListener != null) {
                feedActionListener.onClickStartLive(view2, LiveTabFeedView.this.z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            if (LiveTabFeedView.this.getContext() instanceof Activity) {
                Context context = LiveTabFeedView.this.getContext();
                if (context != null) {
                    if (!((Activity) context).isFinishing()) {
                        Context context2 = LiveTabFeedView.this.getContext();
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

    /* loaded from: classes3.dex */
    public static final class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            LiveExpandTabView liveExpandTabView = LiveTabFeedView.this.x;
            if (liveExpandTabView != null) {
                liveExpandTabView.setTabs(LiveTabFeedView.this.M, rb0.a());
            }
            LiveTabFeedView.this.i0();
            LiveTabFeedView.this.setAppBarScroll(false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class n implements LiveFeedPageToolFloatLayout.d {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public n() {
        }

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void onItemShow(String str) {
            LiveFeedToolListener feedToolListener = LiveTabFeedView.this.getFeedToolListener();
            if (feedToolListener != null) {
                feedToolListener.onItemShow(str);
            }
        }

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void onSearchShowing(boolean z) {
            TabFeedActionListener feedActionListener = LiveTabFeedView.this.getFeedActionListener();
            if (feedActionListener != null) {
                feedActionListener.onSearchShowing(z);
            }
        }

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void a(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                if (invoker != null) {
                    invoker.invokeScheme(LiveTabFeedView.this.getContext(), str2);
                }
            }
            LiveFeedToolListener feedToolListener = LiveTabFeedView.this.getFeedToolListener();
            if (feedToolListener != null) {
                feedToolListener.onItemClick(str);
            }
        }

        @Override // com.baidu.live.business.view.tool.LiveFeedPageToolFloatLayout.d
        public void b() {
            TabFeedActionListener feedActionListener = LiveTabFeedView.this.getFeedActionListener();
            if (feedActionListener != null) {
                feedActionListener.onClickSearch();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            TabFeedActionListener feedActionListener = LiveTabFeedView.this.getFeedActionListener();
            if (feedActionListener != null) {
                feedActionListener.onClickStartLive(view2, LiveTabFeedView.this.z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class p implements SmartTabLayout.e {
        public p() {
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.e
        public final void a(int i) {
            Integer num;
            BaiduLiveTabAdapter baiduLiveTabAdapter;
            StringBuilder sb = new StringBuilder();
            sb.append("二级 tab 点击：");
            sb.append(i);
            sb.append("   current：");
            NestedNoScrollViewPager mViewPager = LiveTabFeedView.this.getMViewPager();
            if (mViewPager != null) {
                num = Integer.valueOf(mViewPager.getCurrentItem());
            } else {
                num = null;
            }
            sb.append(num);
            LiveFeedPageSdk.liveLog(sb.toString());
            if (LiveTabFeedView.this.J() && LiveTabFeedView.this.I) {
                LiveTabFeedView.this.setExpanded(false, true);
            }
            NestedNoScrollViewPager mViewPager2 = LiveTabFeedView.this.getMViewPager();
            if (mViewPager2 != null && mViewPager2.getCurrentItem() == i && (baiduLiveTabAdapter = LiveTabFeedView.this.h) != null) {
                baiduLiveTabAdapter.c(i, true, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class q extends AppBarLayout.Behavior.a {
        public final /* synthetic */ boolean a;

        public q(boolean z) {
            this.a = z;
        }

        @Override // com.baidu.live.framework.appbar.AppBarLayout.BaseBehavior.b
        public boolean a(AppBarLayout appBarLayout) {
            return this.a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class r implements Runnable {
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public r(boolean z, boolean z2) {
            this.b = z;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppBarLayout appBarLayout = LiveTabFeedView.this.f;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(this.b, this.c);
            }
        }
    }

    @JvmOverloads
    public LiveTabFeedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.F = LiveFeedPageSdk.HOST_LIVE_TAB;
        this.M = new ArrayList();
        this.P = true;
        this.a0 = LazyKt__LazyJVMKt.lazy(new Function0<AccountManagerService>() { // from class: com.baidu.live.business.LiveTabFeedView$accountManager$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountManagerService invoke() {
                return (AccountManagerService) ServiceManager.getService(AccountManagerService.Companion.getSERVICE_REFERENCE());
            }
        });
        this.b0 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.live.business.LiveTabFeedView$isHitTabAbTest$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                AbConfigService abConfigService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
                if (abConfigService != null && abConfigService.getSwitch("live_feed_page_update_tab_android", false)) {
                    return true;
                }
                return false;
            }
        });
        this.c0 = new a();
        G();
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
        int i2;
        BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
        if (baiduLiveTabAdapter != null) {
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

    public final void j0(boolean z) {
        LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.D;
        if (liveFeedPageToolFloatLayout != null) {
            liveFeedPageToolFloatLayout.setSearchGuideShowing(z);
        }
    }

    public final void q(ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        int i2;
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

    public final void setCurrentRoom(String str) {
        this.N = str;
    }

    public final void setFeedActionListener(TabFeedActionListener tabFeedActionListener) {
        this.R = tabFeedActionListener;
    }

    public final void setFeedBannerListener(LiveFeedBannerListener liveFeedBannerListener) {
        this.S = liveFeedBannerListener;
    }

    public final void setFeedFollowListener(LiveFeedFollowListener liveFeedFollowListener) {
        this.f1042T = liveFeedFollowListener;
    }

    public final void setFeedModel(ILiveFeedModel iLiveFeedModel) {
        this.Q = iLiveFeedModel;
    }

    public final void setFeedToolListener(LiveFeedToolListener liveFeedToolListener) {
        this.V = liveFeedToolListener;
    }

    public final void setMErrorView(ErrorView errorView) {
        this.s = errorView;
    }

    public final void setMFragmentManager(FragmentManager fragmentManager) {
        this.O = fragmentManager;
    }

    public final void setMSmartTabLayout(SmartTabLayout smartTabLayout) {
        this.k = smartTabLayout;
    }

    public final void setMSmartTabLayoutContainer(View view2) {
        this.j = view2;
    }

    public final void setMSubTipLayout(RecyclerView recyclerView) {
        this.l = recyclerView;
    }

    public final void setMViewPager(NestedNoScrollViewPager nestedNoScrollViewPager) {
        this.g = nestedNoScrollViewPager;
    }

    public final void setMinorUfoUrl(String str) {
        this.L = str;
    }

    public final void setSubTabPageListener(LiveBaseFragment.a aVar) {
        this.U = aVar;
    }

    public final void setViewPagerInFistPage(boolean z) {
        this.P = z;
    }

    public final String x(String str) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        AccountManagerService accountManager = getAccountManager();
        objArr[1] = (accountManager == null || (r4 = accountManager.getUid()) == null) ? "" : "";
        String format = String.format("%s_%s", Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public final void C(LiveFeedToolWrapData liveFeedToolWrapData, LiveFeedConfig liveFeedConfig) {
        LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = this.D;
        if (liveFeedPageToolFloatLayout != null) {
            liveFeedPageToolFloatLayout.setData(liveFeedToolWrapData, liveFeedConfig);
        }
    }

    @JvmOverloads
    public final void setExpanded(boolean z, boolean z2) {
        AppBarLayout appBarLayout = this.f;
        if (appBarLayout != null) {
            appBarLayout.post(new r(z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAppBarScroll(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
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

    public final void b0(boolean z) {
        if (this.u != null) {
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
        if (Intrinsics.areEqual(LiveFeedPageSdk.VIDEO_BAR, this.F)) {
            RecyclerView recyclerView = this.l;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
        } else if (!od0.c(this.M)) {
            if (i2 >= 0 && i2 < this.M.size()) {
                List<LiveTabEntity.TabLabelInfo> list = this.M.get(i2).subTabList;
                if (!od0.c(list)) {
                    LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
                    if (liveFeedPageSubTipAdapter != null) {
                        liveFeedPageSubTipAdapter.t(list, this.K);
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.live.business.BaiduLiveTabAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B(LiveFeedData liveFeedData) {
        String str;
        LiveTabEntity f2;
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
        if (!od0.c(this.M)) {
            rb0.c(w);
            NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
            if (nestedNoScrollViewPager != null) {
                nestedNoScrollViewPager.setCurrentItem(w);
            }
        }
        NestedNoScrollViewPager nestedNoScrollViewPager2 = this.g;
        if (nestedNoScrollViewPager2 != null) {
            nestedNoScrollViewPager2.post(new b(w));
        }
        BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.h;
        if (baiduLiveTabAdapter2 != null && (f2 = baiduLiveTabAdapter2.f(w)) != null) {
            str = f2.type;
        } else {
            str = null;
        }
        this.J = str;
    }

    public final int w(List<? extends LiveTabEntity> list) {
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

    public final boolean D() {
        int i2;
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

    public final boolean I() {
        SmartTabLayout smartTabLayout = this.k;
        if (smartTabLayout != null && !smartTabLayout.canScrollHorizontally(-1)) {
            return true;
        }
        return false;
    }

    public final boolean K() {
        LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
        if (Intrinsics.areEqual(LiveFeedPageSdk.HOST_HAOKAN, liveFeedPageSdk.getHost()) && !this.G && Intrinsics.areEqual(this.F, LiveFeedPageSdk.HOST_LIVE_TAB)) {
            return true;
        }
        return false;
    }

    public final boolean L() {
        return this.P;
    }

    public final void M() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
        if (nestedNoScrollViewPager != null && (baiduLiveTabAdapter = this.h) != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter.j(nestedNoScrollViewPager.getCurrentItem());
        }
    }

    public final void N() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
        if (nestedNoScrollViewPager != null && (baiduLiveTabAdapter = this.h) != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter.k(nestedNoScrollViewPager.getCurrentItem());
        }
    }

    public final void O() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
        if (nestedNoScrollViewPager != null && (baiduLiveTabAdapter = this.h) != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter.l(nestedNoScrollViewPager.getCurrentItem());
        }
    }

    public final void Q() {
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

    public final void U() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
        if (nestedNoScrollViewPager != null && (baiduLiveTabAdapter = this.h) != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter.p(nestedNoScrollViewPager.getCurrentItem());
        }
        LiveExpandTabView liveExpandTabView = this.x;
        if (liveExpandTabView != null) {
            liveExpandTabView.c();
        }
    }

    public final void V() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager = this.g;
        if (nestedNoScrollViewPager != null && (baiduLiveTabAdapter = this.h) != null) {
            if (nestedNoScrollViewPager == null) {
                Intrinsics.throwNpe();
            }
            baiduLiveTabAdapter.q(nestedNoScrollViewPager.getCurrentItem());
        }
    }

    public final void W() {
        LoadingView loadingView = this.r;
        if (loadingView != null) {
            loadingView.d();
        }
        s();
        N();
        LiveExpandTabView liveExpandTabView = this.x;
        if (liveExpandTabView != null) {
            liveExpandTabView.c();
        }
    }

    public final void X() {
        LoadingView loadingView = this.r;
        if (loadingView != null) {
            loadingView.e();
        }
        t();
        O();
    }

    public final void c0() {
        Q();
        rb0.b();
        SmartTabLayout smartTabLayout = this.k;
        if (smartTabLayout != null) {
            smartTabLayout.E();
        }
        LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
        if (liveFeedPageSubTipAdapter != null) {
            liveFeedPageSubTipAdapter.q();
        }
        LiveFeedFollowView liveFeedFollowView = this.m;
        if (liveFeedFollowView != null) {
            liveFeedFollowView.g();
        }
    }

    public final void g0() {
        f0(this.e);
    }

    public final TabFeedActionListener getFeedActionListener() {
        return this.R;
    }

    public final LiveFeedBannerListener getFeedBannerListener() {
        return this.S;
    }

    public final LiveFeedFollowListener getFeedFollowListener() {
        return this.f1042T;
    }

    public final LiveFeedFollowView getFeedFollowView() {
        return this.m;
    }

    public final ILiveFeedModel getFeedModel() {
        return this.Q;
    }

    public final LiveFeedToolListener getFeedToolListener() {
        return this.V;
    }

    public final ErrorView getMErrorView() {
        return this.s;
    }

    public final FragmentManager getMFragmentManager() {
        return this.O;
    }

    public final SmartTabLayout getMSmartTabLayout() {
        return this.k;
    }

    public final View getMSmartTabLayoutContainer() {
        return this.j;
    }

    public final RecyclerView getMSubTipLayout() {
        return this.l;
    }

    public final NestedNoScrollViewPager getMViewPager() {
        return this.g;
    }

    public final String getMinorUfoUrl() {
        return this.L;
    }

    public final LiveBaseFragment.a getSubTabPageListener() {
        return this.U;
    }

    public final void h0() {
        f0(this.s);
    }

    public final void k0() {
        f0(this.r);
    }

    public final void s() {
        BannerView bannerView = this.q;
        if (bannerView != null) {
            bannerView.w();
        }
    }

    public final void t() {
        BannerView bannerView;
        if (this.H && (bannerView = this.q) != null) {
            bannerView.x();
        }
    }

    public final boolean u() {
        return !H();
    }

    public final boolean v() {
        int i2;
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

    public final void E() {
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
        bannerView2.setIndicatorMargin(0, 0, 0, (int) mb0.c(context.getResources(), 7.0f));
        Context context2 = bannerView2.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        bannerView2.setLargeIndicatorItemSize((int) mb0.c(context2.getResources(), 4.0f));
        Context context3 = bannerView2.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context3, "context");
        bannerView2.setSmallIndicatorItemSize((int) mb0.c(context3.getResources(), 4.0f));
        Context context4 = bannerView2.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context4, "context");
        bannerView2.setIndicatorInterval((int) mb0.c(context4.getResources(), 6.0f));
        bannerView2.setAspectRatio(0.336f);
        bannerView2.setScene(this.F);
        bannerView2.setOnBannerClickListener(new c());
        bannerView2.setOnBannerShowListener(new d());
        this.q = bannerView2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout2 = this.p;
        if (frameLayout2 != null) {
            frameLayout2.addView(this.q, layoutParams);
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
                            recyclerView.setPadding(0, mb0.b(getContext(), 15.0f), 0, mb0.b(getContext(), 12.0f));
                        }
                        LiveFeedFollowView liveFeedFollowView = this.m;
                        if (liveFeedFollowView != null && liveFeedFollowView != null) {
                            liveFeedFollowView.setPadding(0, 0, 0, mb0.b(getContext(), 9.0f));
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
                        if (nd0.a() && (view2 = this.a) != null) {
                            view2.setPadding(0, nd0.e(getContext()), 0, 0);
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
                            recyclerView2.setPadding(0, mb0.b(getContext(), 15.0f), 0, mb0.b(getContext(), 12.0f));
                        }
                        LiveFeedFollowView liveFeedFollowView2 = this.m;
                        if (liveFeedFollowView2 != null && liveFeedFollowView2 != null) {
                            liveFeedFollowView2.setPadding(0, 0, 0, mb0.b(getContext(), 9.0f));
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
                                layoutParams2.height = mb0.b(getContext(), 11.0f);
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
                                smartTabLayout6.setCustomTextsSize(mb0.b(getContext(), 16.0f));
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
                            ob0.e("last_time_enter_zhibo_channel_" + getAccountManager().getUid(), System.currentTimeMillis());
                        }
                        LiveFeedPageSdk liveFeedPageSdk6 = LiveFeedPageSdk.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk6, "LiveFeedPageSdk.getInstance()");
                        if (Intrinsics.areEqual("baidu", liveFeedPageSdk6.getHost())) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (ob0.a(x("need_to_check"), true) && ob0.a(x("user_clicked_add_channel_btn"), false)) {
                                long c2 = ob0.c(x("user_click_add_channel_time"), 0L);
                                if (c2 != 0 && currentTimeMillis > c2 && ob0.c(x("days_no_visit_live_channel"), 0L) != 0) {
                                    if (currentTimeMillis - c2 < ob0.c(x("days_no_visit_live_channel"), 0L)) {
                                        ob0.d(x("need_to_check"), false);
                                        ob0.d(x("need_insert_live_channel_to_end"), false);
                                    } else {
                                        ob0.d(x("need_to_check"), false);
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
                                    layoutParams4.width = mb0.b(getContext(), 60.0f);
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
                                    layoutParams4.width = mb0.b(getContext(), 26.0f);
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
                layoutParams6.bottomMargin = mb0.b(getContext(), 15.0f);
            } else {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                layoutParams6.bottomMargin = zd0.e(mb0.c(context.getResources(), 10.0f), 0, 0, 6, null);
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
                float c3 = mb0.c(context2.getResources(), 38.0f);
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                zd0.j(imageView7, c3, mb0.c(context3.getResources(), 38.0f), 0, 0, 12, null);
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = new BaiduLiveTabAdapter(this.O, i2, this.F, this.K, this.Q, this.U);
            this.h = baiduLiveTabAdapter;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.s(new e());
            }
            NestedNoScrollViewPager nestedNoScrollViewPager4 = this.g;
            if (nestedNoScrollViewPager4 != null) {
                nestedNoScrollViewPager4.setAdapter(this.h);
            }
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = new LiveFeedPageSubTipAdapter(getContext(), this.F);
            this.n = liveFeedPageSubTipAdapter;
            if (liveFeedPageSubTipAdapter != null) {
                liveFeedPageSubTipAdapter.r(new f());
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
                liveExpandTabView.d(str4);
            }
            LiveExpandTabView liveExpandTabView2 = this.x;
            if (liveExpandTabView2 != null) {
                liveExpandTabView2.setLiveExpandTabViewListener(new g());
            }
            f0(this.r);
            P("day");
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void G() {
        this.a = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05c3, (ViewGroup) this, true);
        this.b = findViewById(R.id.obfuscated_res_0x7f09166e);
        this.c = findViewById(R.id.obfuscated_res_0x7f091735);
        this.d = (MinorView) findViewById(R.id.obfuscated_res_0x7f091597);
        this.e = findViewById(R.id.obfuscated_res_0x7f091599);
        this.f = (AppBarLayout) findViewById(R.id.obfuscated_res_0x7f09158f);
        this.o = (Space) findViewById(R.id.obfuscated_res_0x7f091592);
        this.p = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091591);
        this.i = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0915a2);
        this.j = findViewById(R.id.obfuscated_res_0x7f0915a0);
        this.k = (SmartTabLayout) findViewById(R.id.obfuscated_res_0x7f09159f);
        this.l = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0915a4);
        this.m = (LiveFeedFollowView) findViewById(R.id.obfuscated_res_0x7f09159a);
        this.t = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091590);
        this.u = findViewById(R.id.obfuscated_res_0x7f09159b);
        this.v = findViewById(R.id.obfuscated_res_0x7f0915a1);
        this.w = findViewById(R.id.obfuscated_res_0x7f0915a3);
        this.y = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09159c);
        this.z = (TextView) findViewById(R.id.obfuscated_res_0x7f09159d);
        this.B = findViewById(R.id.obfuscated_res_0x7f09159e);
        this.A = (FakeStartLiveButton) findViewById(R.id.obfuscated_res_0x7f09152c);
        this.r = (LoadingView) findViewById(R.id.obfuscated_res_0x7f091596);
        this.E = (ImageView) findViewById(R.id.obfuscated_res_0x7f091594);
        this.x = (LiveExpandTabView) findViewById(R.id.obfuscated_res_0x7f091523);
        MinorView minorView = this.d;
        if (minorView != null) {
            minorView.c(this.F);
        }
        MinorView minorView2 = this.d;
        if (minorView2 != null) {
            minorView2.setActionCallback(new j());
        }
        FakeStartLiveButton fakeStartLiveButton = this.A;
        if (fakeStartLiveButton != null) {
            fakeStartLiveButton.setOnClickListener(new k());
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09152d);
        this.C = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new l());
        }
        View view2 = this.v;
        if (view2 != null) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            zd0.m(view2, mb0.c(context.getResources(), 8.0f), 0, 0, 6, null);
        }
        View view3 = this.w;
        if (view3 != null) {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            zd0.m(view3, mb0.c(context2.getResources(), 26.0f), 0, 0, 6, null);
        }
        ImageView imageView2 = this.E;
        if (imageView2 != null) {
            Context context3 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            float c2 = mb0.c(context3.getResources(), 26.0f);
            Context context4 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context4, "context");
            zd0.j(imageView2, c2, mb0.c(context4.getResources(), 26.0f), 0, 0, 12, null);
        }
        ImageView imageView3 = this.E;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new m());
        }
        LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout = (LiveFeedPageToolFloatLayout) findViewById(R.id.obfuscated_res_0x7f091549);
        this.D = liveFeedPageToolFloatLayout;
        if (liveFeedPageToolFloatLayout != null) {
            liveFeedPageToolFloatLayout.setCallback(new n());
        }
        LinearLayout linearLayout = this.y;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new o());
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
        staggeredGridLayoutManager.setOrientation(0);
        RecyclerView recyclerView = this.l;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        }
        NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) findViewById(R.id.obfuscated_res_0x7f0915a5);
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
            smartTabLayout3.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.business.LiveTabFeedView$initView$8
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i2, float f2, int i3) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i2) {
                    Fragment fragment;
                    String str;
                    Fragment fragment2;
                    SmartTabLayout mSmartTabLayout;
                    LiveTabEntity f2;
                    Fragment fragment3;
                    LiveFeedPageSdk.liveLog("二级 tab 滑动/点击切换：" + i2);
                    int a2 = rb0.a();
                    BaiduLiveTabAdapter baiduLiveTabAdapter = LiveTabFeedView.this.h;
                    Fragment fragment4 = null;
                    if (baiduLiveTabAdapter != null) {
                        fragment = baiduLiveTabAdapter.getItem(a2);
                    } else {
                        fragment = null;
                    }
                    boolean z = false;
                    if (fragment instanceof LiveBaseFragment) {
                        BaiduLiveTabAdapter baiduLiveTabAdapter2 = LiveTabFeedView.this.h;
                        if (baiduLiveTabAdapter2 != null) {
                            fragment3 = baiduLiveTabAdapter2.getItem(a2);
                        } else {
                            fragment3 = null;
                        }
                        if (fragment3 != null) {
                            ((LiveBaseFragment) fragment3).M1(false);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.base.LiveBaseFragment");
                        }
                    }
                    LiveTabFeedView liveTabFeedView = LiveTabFeedView.this;
                    BaiduLiveTabAdapter baiduLiveTabAdapter3 = liveTabFeedView.h;
                    if (baiduLiveTabAdapter3 != null && (f2 = baiduLiveTabAdapter3.f(i2)) != null) {
                        str = f2.type;
                    } else {
                        str = null;
                    }
                    liveTabFeedView.J = str;
                    rb0.c(i2);
                    BaiduLiveTabAdapter baiduLiveTabAdapter4 = LiveTabFeedView.this.h;
                    if (baiduLiveTabAdapter4 != null) {
                        fragment2 = baiduLiveTabAdapter4.getItem(i2);
                    } else {
                        fragment2 = null;
                    }
                    if (fragment2 instanceof LiveBaseFragment) {
                        BaiduLiveTabAdapter baiduLiveTabAdapter5 = LiveTabFeedView.this.h;
                        if (baiduLiveTabAdapter5 != null) {
                            fragment4 = baiduLiveTabAdapter5.getItem(i2);
                        }
                        if (fragment4 != null) {
                            ((LiveBaseFragment) fragment4).M1(true);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.business.base.LiveBaseFragment");
                        }
                    }
                    LiveTabFeedView.this.A(i2);
                    SmartTabLayout mSmartTabLayout2 = LiveTabFeedView.this.getMSmartTabLayout();
                    if (mSmartTabLayout2 != null) {
                        mSmartTabLayout2.B("day");
                    }
                    if (LiveTabFeedView.this.I && Intrinsics.areEqual(LiveFeedPageSdk.HOST_LIVE_TAB, LiveTabFeedView.this.F) && (mSmartTabLayout = LiveTabFeedView.this.getMSmartTabLayout()) != null) {
                        mSmartTabLayout.A();
                    }
                    SmartTabLayout mSmartTabLayout3 = LiveTabFeedView.this.getMSmartTabLayout();
                    if (mSmartTabLayout3 != null) {
                        mSmartTabLayout3.setScrollLineVisibility(i2);
                    }
                    BaiduLiveTabAdapter baiduLiveTabAdapter6 = LiveTabFeedView.this.h;
                    if (baiduLiveTabAdapter6 != null) {
                        baiduLiveTabAdapter6.c(i2, true, true);
                    }
                    LiveTabFeedView liveTabFeedView2 = LiveTabFeedView.this;
                    if (i2 == 0) {
                        z = true;
                    }
                    liveTabFeedView2.setViewPagerInFistPage(z);
                }
            });
        }
        SmartTabLayout smartTabLayout4 = this.k;
        if (smartTabLayout4 != null) {
            smartTabLayout4.setOnTabClickListener(new p());
        }
        SmartTabLayout smartTabLayout5 = this.k;
        if (smartTabLayout5 != null) {
            smartTabLayout5.setOnScrollChangeListener(new h());
        }
        ErrorView errorView = (ErrorView) findViewById(R.id.obfuscated_res_0x7f091593);
        this.s = errorView;
        if (errorView != null) {
            errorView.setActionCallback(new i());
        }
    }

    public final boolean H() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
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

    public final void e0() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
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

    public final void i0() {
        ViewGroup.LayoutParams layoutParams;
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

    public final void r() {
        int i2;
        int i3;
        float f2;
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
            linearLayout.setMinimumHeight(mb0.b(context, f2));
        }
    }

    public final void P(String str) {
        View view2 = this.a;
        if (view2 != null) {
            view2.setBackgroundColor(de0.f().a(getContext(), this.F, "color_main_bg"));
        }
        View view3 = this.u;
        if (view3 != null) {
            view3.setBackgroundColor(de0.f().a(getContext(), this.F, "color_F5F5F52"));
        }
        TextView textView = this.z;
        if (textView != null) {
            textView.setTextColor(de0.f().a(getContext(), this.F, "color_1F1F1F"));
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
            de0 f2 = de0.f();
            Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
            liveFeedPageToolFloatLayout.d(f2.r());
        }
        ImageView imageView = this.E;
        if (imageView != null) {
            sb0 sb0Var = sb0.a;
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            imageView.setBackgroundDrawable(sb0Var.b(context, this.F));
        }
        LiveExpandTabView liveExpandTabView = this.x;
        if (liveExpandTabView != null) {
            liveExpandTabView.e(str);
        }
        View view4 = this.v;
        if (view4 != null) {
            sb0 sb0Var2 = sb0.a;
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            view4.setBackgroundDrawable(sb0Var2.a(context2, this.F, str));
        }
        View view5 = this.w;
        if (view5 != null) {
            sb0 sb0Var3 = sb0.a;
            Context context3 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            view5.setBackgroundDrawable(sb0Var3.d(context3, this.F, str));
        }
    }

    public final void T(int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view2 = this.v;
        if (view2 != null) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            zd0.m(view2, mb0.c(context.getResources(), 8.0f), 0, 0, 6, null);
        }
        View view3 = this.w;
        if (view3 != null) {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            zd0.m(view3, mb0.c(context2.getResources(), 26.0f), 0, 0, 6, null);
        }
        ImageView imageView = this.E;
        if (imageView != null) {
            Context context3 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            float c2 = mb0.c(context3.getResources(), 26.0f);
            Context context4 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context4, "context");
            zd0.j(imageView, c2, mb0.c(context4.getResources(), 26.0f), 0, 0, 12, null);
        }
        LiveExpandTabView liveExpandTabView = this.x;
        if (liveExpandTabView != null) {
            liveExpandTabView.h();
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
                layoutParams2.bottomMargin = zd0.e(mb0.c(context5.getResources(), 10.0f), 0, 0, 6, null);
            }
            LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout3 = this.D;
            if (liveFeedPageToolFloatLayout3 != null) {
                liveFeedPageToolFloatLayout3.setLayoutParams(layoutParams2);
            }
            ImageView imageView2 = this.C;
            if (imageView2 != null) {
                Context context6 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context6, "context");
                float c3 = mb0.c(context6.getResources(), 38.0f);
                Context context7 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context7, "context");
                zd0.j(imageView2, c3, mb0.c(context7.getResources(), 38.0f), 0, 0, 12, null);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void Y(String str, String str2) {
        Integer num;
        int i2;
        NestedNoScrollViewPager nestedNoScrollViewPager;
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
                LiveFeedPageSdk.liveLog("D8800088 selectedPos = " + i2 + ", LiveTabUtil.getCurFragPos() = " + rb0.a());
                if (i2 != -1 && i2 != rb0.a() && (nestedNoScrollViewPager = this.g) != null) {
                    nestedNoScrollViewPager.setCurrentItem(i2);
                }
            }
        } else if (!Intrinsics.areEqual(str2, this.K)) {
            this.K = str2;
            LiveFeedPageSdk.liveLog("D8800088 onTabSelectedEvent 3333级Tab不一致，需要重新设定");
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
            if (liveFeedPageSubTipAdapter != null) {
                i3 = liveFeedPageSubTipAdapter.l(this.K);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("D8800088 selectedPos = ");
            sb.append(i3);
            sb.append(", mSubTipAdapter.getSelectPos() = ");
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter2 = this.n;
            if (liveFeedPageSubTipAdapter2 != null) {
                num = Integer.valueOf(liveFeedPageSubTipAdapter2.m());
            } else {
                num = null;
            }
            sb.append(num);
            LiveFeedPageSdk.liveLog(sb.toString());
            d0(i3);
        }
    }

    public final void a0(LiveBannerWrapData liveBannerWrapData) {
        BannerView bannerView;
        if (this.q != null && this.p != null) {
            int i2 = 0;
            if (!Intrinsics.areEqual(this.F, LiveFeedPageSdk.IMMERSION) && !Intrinsics.areEqual(this.F, "recommend")) {
                if (liveBannerWrapData != null) {
                    if (!od0.c(liveBannerWrapData.bannerList)) {
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

    public final void d0(int i2) {
        int i3;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.n;
        boolean z = false;
        if (liveFeedPageSubTipAdapter != null) {
            i3 = liveFeedPageSubTipAdapter.m();
        } else {
            i3 = 0;
        }
        LiveFeedPageSdk.liveLog("三级 Tab 点击 pre: " + i3 + GlideException.IndentedAppendable.INDENT + i2);
        LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter2 = this.n;
        if (liveFeedPageSubTipAdapter2 != null) {
            liveFeedPageSubTipAdapter2.s(i2);
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

    public final void setTabStyle(boolean z) {
        ImageView imageView;
        ViewGroup.LayoutParams layoutParams;
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
                layoutParams2.setMargins(mb0.b(getContext(), 12.0f), 0, mb0.b(getContext(), 6.0f), 0);
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

    public final void f0(View view2) {
        int i2;
        int i3;
        ErrorView errorView;
        int i4;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener2;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener3;
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

    public final void l0(boolean z, String str) {
        View view2;
        View view3;
        View view4;
        View view5;
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

    public final void m0() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity liveTabEntity;
        String str;
        BaiduLiveTabAdapter baiduLiveTabAdapter = this.h;
        if (baiduLiveTabAdapter != null && (nestedNoScrollViewPager = this.g) != null) {
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
                    tabLabelInfo = liveFeedPageSubTipAdapter.n();
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

    public final void y(LiveFollowWrapData liveFollowWrapData, boolean z, LiveFeedConfig liveFeedConfig) {
        if (liveFollowWrapData != null) {
            if (!od0.c(liveFollowWrapData.followList)) {
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
                    liveFeedFollowView4.setPadding(0, 0, 0, mb0.b(getContext(), 6.0f));
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
