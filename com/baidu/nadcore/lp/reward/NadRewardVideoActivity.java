package com.baidu.nadcore.lp.reward;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.business.uitemplate.NadEnhanceButtonDownloadView;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper;
import com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView;
import com.baidu.nadcore.lp.reward.view.NadRewardBigCardView;
import com.baidu.nadcore.lp.reward.view.NadRewardEnhanceButtonView;
import com.baidu.nadcore.lp.reward.view.NadRewardFestivalContainer;
import com.baidu.nadcore.lp.reward.view.NadRewardFloatingLayerView;
import com.baidu.nadcore.lp.reward.view.NadRewardImageView;
import com.baidu.nadcore.lp.reward.view.NadRewardInterceptFrameLayout;
import com.baidu.nadcore.lp.reward.view.NadRewardLottieDialog;
import com.baidu.nadcore.lp.reward.view.NadRewardSuspendDialog;
import com.baidu.nadcore.lp.reward.view.NadRewardVideoAdOverContainer;
import com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.videoextra.NadHighLightTextView;
import com.baidu.nadcore.videoextra.NadIconTextButton;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.R;
import com.baidu.tieba.aj0;
import com.baidu.tieba.al0;
import com.baidu.tieba.aq0;
import com.baidu.tieba.bl0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.ce0;
import com.baidu.tieba.co0;
import com.baidu.tieba.cx0;
import com.baidu.tieba.d91;
import com.baidu.tieba.df0;
import com.baidu.tieba.do0;
import com.baidu.tieba.eo0;
import com.baidu.tieba.eq0;
import com.baidu.tieba.ez0;
import com.baidu.tieba.g21;
import com.baidu.tieba.gd0;
import com.baidu.tieba.go0;
import com.baidu.tieba.hn0;
import com.baidu.tieba.il0;
import com.baidu.tieba.in0;
import com.baidu.tieba.io0;
import com.baidu.tieba.j41;
import com.baidu.tieba.jl0;
import com.baidu.tieba.kl0;
import com.baidu.tieba.l11;
import com.baidu.tieba.lk0;
import com.baidu.tieba.ll0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.m41;
import com.baidu.tieba.ml0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.pk0;
import com.baidu.tieba.q31;
import com.baidu.tieba.q41;
import com.baidu.tieba.qc0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.r31;
import com.baidu.tieba.r41;
import com.baidu.tieba.rk0;
import com.baidu.tieba.rn0;
import com.baidu.tieba.sn0;
import com.baidu.tieba.so;
import com.baidu.tieba.ti0;
import com.baidu.tieba.tk0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.uk0;
import com.baidu.tieba.un0;
import com.baidu.tieba.ve0;
import com.baidu.tieba.vk0;
import com.baidu.tieba.w11;
import com.baidu.tieba.wm0;
import com.baidu.tieba.wn0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xk0;
import com.baidu.tieba.xm0;
import com.baidu.tieba.y01;
import com.baidu.tieba.z11;
import com.google.android.material.badge.BadgeDrawable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\bô\u0001\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u0015J\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 J+\u0010$\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J)\u0010+\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010*\u001a\u00020\u0002H\u0002¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0013¢\u0006\u0004\b-\u0010\u0015J\u000f\u0010.\u001a\u00020\u0013H\u0002¢\u0006\u0004\b.\u0010\u0015J\u000f\u0010/\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u0010\u0015J\u000f\u00100\u001a\u00020\u0013H\u0002¢\u0006\u0004\b0\u0010\u0015J\u000f\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b1\u0010\u0015J\u000f\u00102\u001a\u00020\u0013H\u0002¢\u0006\u0004\b2\u0010\u0015J\u000f\u00103\u001a\u00020\u0013H\u0002¢\u0006\u0004\b3\u0010\u0015J\u000f\u00104\u001a\u00020\u0013H\u0002¢\u0006\u0004\b4\u0010\u0015J\u000f\u00105\u001a\u00020\u0013H\u0002¢\u0006\u0004\b5\u0010\u0015J\u000f\u00106\u001a\u00020\u0013H\u0002¢\u0006\u0004\b6\u0010\u0015J\u000f\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0004\b7\u0010\u0015J\u000f\u00108\u001a\u00020\u0013H\u0002¢\u0006\u0004\b8\u0010\u0015J\u000f\u00109\u001a\u00020\u0013H\u0002¢\u0006\u0004\b9\u0010\u0015J\u000f\u0010:\u001a\u00020\u0013H\u0002¢\u0006\u0004\b:\u0010\u0015J\u000f\u0010;\u001a\u00020\u0013H\u0002¢\u0006\u0004\b;\u0010\u0015J\u000f\u0010<\u001a\u00020\u0013H\u0002¢\u0006\u0004\b<\u0010\u0015J\u000f\u0010=\u001a\u00020\u0013H\u0002¢\u0006\u0004\b=\u0010\u0015J\u000f\u0010>\u001a\u00020\u0013H\u0002¢\u0006\u0004\b>\u0010\u0015J!\u0010@\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0002H\u0002¢\u0006\u0004\bB\u0010\u0004J\u0017\u0010C\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u0002H\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0002H\u0002¢\u0006\u0004\bE\u0010\u0004J\u000f\u0010F\u001a\u00020\u0013H\u0016¢\u0006\u0004\bF\u0010\u0015J\u000f\u0010G\u001a\u00020\u0013H\u0016¢\u0006\u0004\bG\u0010\u0015J\u0019\u0010J\u001a\u00020\u00132\b\u0010I\u001a\u0004\u0018\u00010HH\u0014¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0013H\u0014¢\u0006\u0004\bL\u0010\u0015J\u0019\u0010O\u001a\u00020\u00132\b\u0010N\u001a\u0004\u0018\u00010MH\u0014¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0013H\u0014¢\u0006\u0004\bQ\u0010\u0015J\u000f\u0010R\u001a\u00020\u0013H\u0014¢\u0006\u0004\bR\u0010\u0015J\u000f\u0010S\u001a\u00020\u0013H\u0014¢\u0006\u0004\bS\u0010\u0015J\u000f\u0010T\u001a\u00020\u0013H\u0014¢\u0006\u0004\bT\u0010\u0015J\u000f\u0010U\u001a\u00020\u0013H\u0002¢\u0006\u0004\bU\u0010\u0015J\u000f\u0010V\u001a\u00020\u0002H\u0002¢\u0006\u0004\bV\u0010\u0004J\u000f\u0010W\u001a\u00020\u0013H\u0002¢\u0006\u0004\bW\u0010\u0015JC\u0010]\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u00052\"\u0010\\\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050Zj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`[H\u0002¢\u0006\u0004\b]\u0010^J\u0019\u0010_\u001a\u00020\u00022\b\u0010I\u001a\u0004\u0018\u00010HH\u0014¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\u0013H\u0002¢\u0006\u0004\ba\u0010\u0015J\u000f\u0010b\u001a\u00020\u0013H\u0002¢\u0006\u0004\bb\u0010\u0015J\u000f\u0010c\u001a\u00020\u0013H\u0002¢\u0006\u0004\bc\u0010\u0015J\u000f\u0010d\u001a\u00020\u0013H\u0002¢\u0006\u0004\bd\u0010\u0015J\u000f\u0010e\u001a\u00020\u0013H\u0002¢\u0006\u0004\be\u0010\u0015J\u0017\u0010g\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\u0002H\u0002¢\u0006\u0004\bg\u0010DJ\u000f\u0010h\u001a\u00020\u0013H\u0002¢\u0006\u0004\bh\u0010\u0015J\u000f\u0010i\u001a\u00020\u0002H\u0002¢\u0006\u0004\bi\u0010\u0004J\u000f\u0010j\u001a\u00020\u0013H\u0002¢\u0006\u0004\bj\u0010\u0015J\u000f\u0010k\u001a\u00020\u0002H\u0002¢\u0006\u0004\bk\u0010\u0004J/\u0010p\u001a\u00020\u00132\u0006\u0010l\u001a\u00020\u00022\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010o\u001a\u0004\u0018\u00010nH\u0002¢\u0006\u0004\bp\u0010qJ\u0017\u0010s\u001a\u00020\u00022\u0006\u0010r\u001a\u00020nH\u0002¢\u0006\u0004\bs\u0010tJ\u000f\u0010u\u001a\u00020\u0002H\u0002¢\u0006\u0004\bu\u0010\u0004J\u000f\u0010v\u001a\u00020\u0002H\u0002¢\u0006\u0004\bv\u0010\u0004J\u000f\u0010w\u001a\u00020\u0013H\u0002¢\u0006\u0004\bw\u0010\u0015J\u0017\u0010x\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\bx\u0010\u001cJ\u000f\u0010y\u001a\u00020\u0002H\u0002¢\u0006\u0004\by\u0010\u0004J\u000f\u0010z\u001a\u00020\u0013H\u0002¢\u0006\u0004\bz\u0010\u0015J\u0017\u0010}\u001a\u00020\u00132\u0006\u0010|\u001a\u00020{H\u0002¢\u0006\u0004\b}\u0010~R\"\u0010\u0084\u0001\u001a\u00020\u007f8B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0017\u0010\u0085\u0001R \u0010\u0087\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0086\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R#\u0010\u008d\u0001\u001a\u00030\u0089\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u0081\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0090\u0001R\u0019\u0010\u0097\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0095\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R#\u0010¨\u0001\u001a\u00030¤\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¥\u0001\u0010\u0081\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R#\u0010\u00ad\u0001\u001a\u00030©\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bª\u0001\u0010\u0081\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0019\u0010±\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010\u0095\u0001R#\u0010¶\u0001\u001a\u00030²\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b³\u0001\u0010\u0081\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010¸\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u001b\u0010º\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001c\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001c\u0010À\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001b\u0010Â\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001a\u0010Ä\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010¹\u0001R\u001b\u0010Å\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Ã\u0001R\u001c\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001a\u0010É\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010¹\u0001R\u001c\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0019\u0010Í\u0001\u001a\u00020{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u001a\u0010Ï\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010¹\u0001R\u0019\u0010Ð\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010\u0095\u0001R\u001a\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0019\u0010Ö\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010\u0095\u0001R\u001c\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\u001c\u0010Û\u0001\u001a\u0005\u0018\u00010Ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u001c\u0010Þ\u0001\u001a\u0005\u0018\u00010Ý\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R#\u0010ä\u0001\u001a\u00030à\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bá\u0001\u0010\u0081\u0001\u001a\u0006\bâ\u0001\u0010ã\u0001R\u001b\u0010å\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010Ã\u0001R#\u0010ê\u0001\u001a\u00030æ\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bç\u0001\u0010\u0081\u0001\u001a\u0006\bè\u0001\u0010é\u0001R\u001c\u0010ì\u0001\u001a\u0005\u0018\u00010ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001c\u0010ï\u0001\u001a\u0005\u0018\u00010î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R#\u0010ó\u0001\u001a\u00030à\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bñ\u0001\u0010\u0081\u0001\u001a\u0006\bò\u0001\u0010ã\u0001¨\u0006õ\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/NadRewardVideoActivity;", "Lcom/baidu/nadcore/appframework/BaseActivity;", "", "bigCardNineSpliteScreenShowing", "()Z", "", "dialogDataJson", "isTaskDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "buildDialog", "(Ljava/lang/String;Z)Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "rewardDataJson", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "buildLottieDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "suspendCmd", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "buildSuspendDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "", "chargeClick", "()V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "checkDownloadInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)Z", "suspendDialogShowMoment", "checkShowSuspendMoment", "(Ljava/lang/String;)Z", "computeDailyRewardShownIndex", "finish", "getSessionInfo", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "cmd", "handleDialogRoute", "(Landroid/content/Context;Lcom/baidu/nadcore/model/AdRewardVideoLpModel;Ljava/lang/String;)V", "Lcom/baidu/nadcore/videoextra/model/NadIconTextButtonModel;", "svButtonModel", "handleSvButtonRoute", "(Lcom/baidu/nadcore/videoextra/model/NadIconTextButtonModel;)V", "downloadInvokePanelPop", "handleUserInfoContainerRoute", "(Landroid/content/Context;Lcom/baidu/nadcore/model/AdRewardVideoLpModel;Z)V", "init", "initBigCard", "initBottomArrow", "initCloseIcon", "initCountDownView", "initCriusView", "initFloatingLayer", "initImageStyle", "initPanelPop", "initRewardTask", "initRootView", "initSvButton", "initSvTitle", "initTailFrame", "initTopTag", "initTopTagText", "initUserInfoContainer", "initVideoPlayer", "scheme", "isAppInstalled", "(Ljava/lang/String;Landroid/content/Context;)Z", "isDialogShowing", "isNewSession", "(Z)V", "isPanelPopShow", "onAttachedToWindow", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreateEx", "(Landroid/os/Bundle;)V", "onDestroyEx", "Landroid/content/Intent;", "intent", "onNewIntentEx", "(Landroid/content/Intent;)V", "onPauseEx", "onResumeEx", "onStartEx", "onStopEx", "onTaskComplete", "parseData", "pauseVideoPlayAndCountDown", "status", "message", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "postRewardVideoNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "preCreate", "(Landroid/os/Bundle;)Z", "recomputeCountDownSecond", "registerBackForegroundEvent", "resetStatus", "resumeVideoPlayAndCountDown", "setAppInfo", "playEnd", "setVideoContainerMask", "showBigCard", "showDialog", "showImageStylePage", "showLottieDialog", "autoPopup", "chargeModify", "", "chargeDuration", "showPanelPop", "(ZLjava/lang/String;Ljava/lang/Long;)V", "remainSecond", "showRetainDialog", "(J)Z", "showRewardDialog", "showSuspendDialog", "showSuspendDialogDelay", "showTaskDialog", "tailNineSplitScreenShowing", "triggerTask", "", "progress", "updateVideoSize", "(F)V", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer$delegate", "Lkotlin/Lazy;", "getAdInfoContainer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "", "appDownloadInfoArray", "[Ljava/lang/String;", "Lcom/baidu/nadcore/widget/uiwidget/SimpleAdInfoView;", "appInfoView$delegate", "getAppInfoView", "()Lcom/baidu/nadcore/widget/uiwidget/SimpleAdInfoView;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "arrowView", "Lcom/baidu/nadcore/widget/AdImageView;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCard", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCardShown", "Z", "closeIcon", "countDownFinished", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "countDownView", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Lcom/baidu/nadcore/lp/reward/ioc/INadRewardCriusPopContainer;", "criusViewContainer", "Lcom/baidu/nadcore/lp/reward/ioc/INadRewardCriusPopContainer;", "Landroid/widget/LinearLayout;", "criusViewGroup", "Landroid/widget/LinearLayout;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFestivalContainer;", "festivalContainer", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFestivalContainer;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "flRootView$delegate", "getFlRootView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "flRootView", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFloatingLayerView;", "floatingLayer$delegate", "getFloatingLayer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardFloatingLayerView;", "floatingLayer", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "hasMore", "Lcom/baidu/nadcore/lp/reward/view/NadRewardImageView;", "imageStyleView$delegate", "getImageStyleView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardImageView;", "imageStyleView", "", "inSessionCount", "I", "lottieDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "retainDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "rewardCount", "rewardDialog", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardResponse", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardShownIndex", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "rewardTaskHelper", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "screenHW", "F", "sessionCount", "shouldCharge", "Ljava/lang/Runnable;", "shouldChargeTask", "Ljava/lang/Runnable;", "suspendDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "suspendDialogShown", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "svButton", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "svTitle", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "tailFrame", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "Landroid/widget/FrameLayout;", "tailFrameContainer$delegate", "getTailFrameContainer", "()Landroid/widget/FrameLayout;", "tailFrameContainer", "taskDialog", "Landroid/view/View;", "topMask$delegate", "getTopMask", "()Landroid/view/View;", "topMask", "Landroid/widget/ImageView;", "topTag", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "topTagText", "Landroid/widget/TextView;", "videoContainer$delegate", "getVideoContainer", "videoContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardVideoActivity extends BaseActivity {
    public AdImageView B;
    public ImageView C;
    public AbsRewardCountDownView D;
    public uk0 E;
    public j41 F;
    public NadHighLightTextView H;
    public NadIconTextButton I;
    public aq0 J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardVideoDialog M;
    public NadRewardSuspendDialog N;
    public NadRewardLottieDialog O;
    public NadRewardBigCardView P;
    public in0 R;
    public qk0 S;

    /* renamed from: T  reason: collision with root package name */
    public float f1046T;
    public int U;
    public int V;
    public int W;
    public boolean Y;
    public NadRewardTaskHelper Z;
    public Handler a0;
    public boolean b0;
    public boolean d0;
    public boolean e0;
    public boolean f0;
    public TextView g0;
    public vk0 h0;
    public NadRewardFestivalContainer i0;
    public LinearLayout j0;
    public AdImageView z;
    public final Lazy u = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardInterceptFrameLayout>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$flRootView$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NadRewardInterceptFrameLayout invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.fl_root);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fl_root)");
            return (NadRewardInterceptFrameLayout) findViewById;
        }
    });
    public final Lazy v = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$videoContainer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FrameLayout invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.fl_video_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fl_video_container)");
            return (FrameLayout) findViewById;
        }
    });
    public final Lazy w = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$topMask$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.top_mask);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.top_mask)");
            return findViewById;
        }
    });
    public final Lazy x = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardVideoAdOverContainer>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$adInfoContainer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NadRewardVideoAdOverContainer invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.ad_info_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_info_container)");
            return (NadRewardVideoAdOverContainer) findViewById;
        }
    });
    public final Lazy y = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$tailFrameContainer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FrameLayout invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.tail_frame_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tail_frame_container)");
            return (FrameLayout) findViewById;
        }
    });
    public final Lazy A = LazyKt__LazyJVMKt.lazy(new Function0<SimpleAdInfoView>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$appInfoView$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SimpleAdInfoView invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.app_info_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.app_info_view)");
            return (SimpleAdInfoView) findViewById;
        }
    });
    public final Lazy G = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardImageView>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$imageStyleView$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NadRewardImageView invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.image_style_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.image_style_view)");
            return (NadRewardImageView) findViewById;
        }
    });
    public final Lazy Q = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardFloatingLayerView>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$floatingLayer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NadRewardFloatingLayerView invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.floating_layer_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.floating_layer_view)");
            return (NadRewardFloatingLayerView) findViewById;
        }
    });
    public int X = 1;
    public Runnable c0 = new u();

    public final NadRewardVideoAdOverContainer P2() {
        return (NadRewardVideoAdOverContainer) this.x.getValue();
    }

    public final SimpleAdInfoView Q2() {
        return (SimpleAdInfoView) this.A.getValue();
    }

    public final NadRewardInterceptFrameLayout R2() {
        return (NadRewardInterceptFrameLayout) this.u.getValue();
    }

    public final NadRewardFloatingLayerView S2() {
        return (NadRewardFloatingLayerView) this.Q.getValue();
    }

    public final NadRewardImageView T2() {
        return (NadRewardImageView) this.G.getValue();
    }

    public final FrameLayout V2() {
        return (FrameLayout) this.y.getValue();
    }

    public final View W2() {
        return (View) this.w.getValue();
    }

    public final FrameLayout X2() {
        return (FrameLayout) this.v.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ NadRewardFestivalContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public j(NadRewardFestivalContainer nadRewardFestivalContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = nadRewardFestivalContainer;
            this.b = nadRewardVideoActivity;
        }

        /* loaded from: classes3.dex */
        public static final class a implements il0.a {
            public a() {
            }

            @Override // com.baidu.tieba.il0.a
            public void onFail(Exception exc) {
                ll0.k(NadRewardVideoActivity.I1(j.this.b).f.d, "4");
                Toast.makeText(j.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.il0.a
            public void a(wn0 wn0Var) {
                String str;
                NadRewardVideoActivity.I1(j.this.b).h().E(wn0Var);
                String str2 = null;
                if (wn0Var != null) {
                    str = wn0Var.f();
                } else {
                    str = null;
                }
                if (!TextUtils.equals(str, "1")) {
                    j.this.b.L3();
                    String str3 = NadRewardVideoActivity.I1(j.this.b).f.d;
                    if (wn0Var != null) {
                        str2 = wn0Var.a();
                    }
                    ll0.l(str3, "4", str2);
                    return;
                }
                j.this.a.setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = j.this.b;
                if (wn0Var != null) {
                    str2 = wn0Var.d();
                }
                Toast.makeText(nadRewardVideoActivity, str2, 0).show();
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            String str2 = null;
            if (NadRewardVideoActivity.I1(this.b).h().k() != null) {
                wn0 k = NadRewardVideoActivity.I1(this.b).h().k();
                if (k != null) {
                    str = k.f();
                } else {
                    str = null;
                }
                if (TextUtils.equals(str, "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    wn0 k2 = NadRewardVideoActivity.I1(nadRewardVideoActivity).h().k();
                    if (k2 != null) {
                        str2 = k2.d();
                    }
                    Toast.makeText(nadRewardVideoActivity, str2, 0).show();
                    return;
                }
                this.b.L3();
                return;
            }
            il0 il0Var = il0.a;
            do0 h = NadRewardVideoActivity.I1(this.b).h();
            eo0 m = NadRewardVideoActivity.I1(this.b).h().m();
            if (m != null) {
                str2 = m.b();
            }
            il0Var.d(h, str2, new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class o implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public o(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        /* loaded from: classes3.dex */
        public static final class a implements il0.a {
            public a() {
            }

            @Override // com.baidu.tieba.il0.a
            public void onFail(Exception exc) {
                ll0.k(NadRewardVideoActivity.I1(o.this.b).f.d, "4");
                Toast.makeText(o.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.il0.a
            public void a(wn0 wn0Var) {
                String str;
                NadRewardVideoActivity.I1(o.this.b).h().E(wn0Var);
                String str2 = null;
                if (wn0Var != null) {
                    str = wn0Var.f();
                } else {
                    str = null;
                }
                if (!Intrinsics.areEqual(str, "1")) {
                    o.this.b.L3();
                    String str3 = NadRewardVideoActivity.I1(o.this.b).f.d;
                    if (wn0Var != null) {
                        str2 = wn0Var.a();
                    }
                    ll0.l(str3, "4", str2);
                    return;
                }
                o.this.a.setFestivalEntranceContainerInvisible();
                Toast.makeText(o.this.b, wn0Var.d(), 0).show();
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.I1(this.b).h().k() != null) {
                wn0 k = NadRewardVideoActivity.I1(this.b).h().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    wn0 k2 = NadRewardVideoActivity.I1(nadRewardVideoActivity).h().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.L3();
                return;
            }
            il0 il0Var = il0.a;
            do0 h = NadRewardVideoActivity.I1(this.b).h();
            eo0 m = NadRewardVideoActivity.I1(this.b).h().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            il0Var.d(h, str, new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class t extends xi0<aj0> {

        /* loaded from: classes3.dex */
        public static final class a implements il0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.il0.a
            public void onFail(Exception exc) {
                ll0.k(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.il0.a
            public void a(wn0 wn0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.P2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (wn0Var != null) {
                    str = wn0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (wn0Var != null) {
                    str2 = wn0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d;
                    if (wn0Var != null) {
                        str3 = wn0Var.a();
                    }
                    ll0.l(str4, "5", str3);
                }
            }
        }

        public t(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(aj0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j().b()) {
                il0 il0Var = il0.a;
                do0 h = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).h();
                wn0 k = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).h().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                il0Var.d(h, str, new a());
                NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j().e(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public a(String str, boolean z) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements NadRewardVideoDialog.a {
        public b(String str, boolean z) {
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.a
        public final void a() {
            NadRewardVideoActivity.this.L2();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoDialog a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public c(NadRewardVideoDialog nadRewardVideoDialog, NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z) {
            this.a = nadRewardVideoDialog;
            this.b = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            tm0 tm0Var;
            un0 e = NadRewardVideoActivity.I1(this.b).e();
            if (e != null && e.g()) {
                un0 e2 = NadRewardVideoActivity.I1(this.b).e();
                Intrinsics.checkNotNull(e2);
                tm0Var = e2.b();
            } else {
                xm0 xm0Var = NadRewardVideoActivity.I1(this.b).m;
                if (xm0Var != null) {
                    tm0Var = xm0Var.p;
                } else {
                    tm0Var = null;
                }
            }
            ti0.a().b(new gd0(tm0Var));
            this.a.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public d(String str) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements NadRewardVideoDialog.a {
        public e(String str) {
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.a
        public final void a() {
            NadRewardVideoActivity.this.L2();
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public f(String str) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements NadRewardVideoDialog.a {
        public g(String str) {
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.a
        public final void a() {
            NadRewardVideoActivity.this.L2();
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public final /* synthetic */ AdImageView a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public h(AdImageView adImageView, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = adImageView;
            this.b = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity nadRewardVideoActivity = this.b;
            Context context = this.a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            NadRewardVideoActivity.b3(nadRewardVideoActivity, context, NadRewardVideoActivity.I1(this.b), false, 4, null);
            ll0.f(NadRewardVideoActivity.I1(this.b));
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            boolean z;
            if (z11.a()) {
                return;
            }
            String str2 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d;
            qk0 qk0Var = NadRewardVideoActivity.this.S;
            if (qk0Var != null) {
                str = qk0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            ll0.s(str2, !z);
            if (NadRewardVideoActivity.this.J3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements tk0 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public k() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends xi0<m41> {
        public l(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(m41 event) {
            Intrinsics.checkNotNullParameter(event, "event");
            int i = event.a;
            if (i != 0) {
                if (i == 5) {
                    aq0 aq0Var = NadRewardVideoActivity.this.J;
                    if (aq0Var != null) {
                        aq0Var.resume();
                    }
                    AdImageView adImageView = NadRewardVideoActivity.this.B;
                    if (adImageView != null) {
                        ExtensionsKt.f(adImageView, true);
                    }
                    TextView textView = NadRewardVideoActivity.this.g0;
                    if (textView != null) {
                        ExtensionsKt.f(textView, true);
                    }
                    AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
                    if (absRewardCountDownView != null) {
                        absRewardCountDownView.bringToFront();
                    }
                    AdImageView adImageView2 = NadRewardVideoActivity.this.B;
                    if (adImageView2 != null) {
                        adImageView2.bringToFront();
                    }
                    TextView textView2 = NadRewardVideoActivity.this.g0;
                    if (textView2 != null) {
                        textView2.bringToFront();
                        return;
                    }
                    return;
                } else if (i == 8) {
                    NadRewardVideoActivity.this.onBackPressed();
                    return;
                } else {
                    return;
                }
            }
            NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j().f(true);
            aq0 aq0Var2 = NadRewardVideoActivity.this.J;
            if (aq0Var2 != null) {
                aq0Var2.pause();
            }
            AdImageView adImageView3 = NadRewardVideoActivity.this.B;
            if (adImageView3 != null) {
                ExtensionsKt.f(adImageView3, false);
            }
            TextView textView3 = NadRewardVideoActivity.this.g0;
            if (textView3 != null) {
                ExtensionsKt.f(textView3, false);
            }
            NadRewardVideoActivity.this.S2().l();
        }
    }

    /* loaded from: classes3.dex */
    public static final class m implements View.OnClickListener {
        public final /* synthetic */ r31 b;

        public m(r31 r31Var) {
            this.b = r31Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            ll0.y(NadRewardVideoActivity.I1(NadRewardVideoActivity.this));
            NadRewardVideoActivity.this.Z2(this.b);
        }
    }

    /* loaded from: classes3.dex */
    public static final class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j().d(true);
            NadRewardVideoActivity.this.L2();
            if (jl0.a.f() && (view2 instanceof NadRewardEnhanceButtonView)) {
                qe0.c(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.c, NadRewardVideoActivity.this);
                return;
            }
            NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
            NadRewardVideoActivity.b3(nadRewardVideoActivity, nadRewardVideoActivity, NadRewardVideoActivity.I1(nadRewardVideoActivity), false, 4, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class p extends eq0 {
        public p() {
        }

        @Override // com.baidu.tieba.eq0, com.baidu.tieba.xp0
        public void onEnd(int i) {
            String str;
            nn0 nn0Var;
            String str2;
            nn0 nn0Var2;
            nn0 nn0Var3;
            nn0 nn0Var4;
            NadRewardBigCardView nadRewardBigCardView;
            String str3;
            Long l = null;
            if (NadRewardVideoActivity.I1(NadRewardVideoActivity.this).b() != null) {
                sn0 c = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).c();
                if (c != null && c.b()) {
                    if (!jl0.a.f()) {
                        j41 j41Var = NadRewardVideoActivity.this.F;
                        if ((j41Var == null || !j41Var.isShowing()) && (nadRewardBigCardView = NadRewardVideoActivity.this.P) != null) {
                            nadRewardBigCardView.u(true);
                        }
                    } else {
                        rn0 b = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).b();
                        if (b != null) {
                            str3 = b.e();
                        } else {
                            str3 = null;
                        }
                        sn0 c2 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).c();
                        if (c2 != null) {
                            l = Long.valueOf(c2.d());
                        }
                        qe0.c(l11.c(str3, l, NadRewardVideoActivity.I1(NadRewardVideoActivity.this).e), NadRewardVideoActivity.this);
                    }
                }
                NadRewardVideoActivity.this.H3(true);
                NadRewardVideoActivity.this.I3();
            } else {
                if (!NadRewardVideoActivity.this.d0) {
                    ln0 ln0Var = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j;
                    if (ln0Var != null && (nn0Var4 = ln0Var.i) != null) {
                        nn0Var4.y = null;
                    }
                    ln0 ln0Var2 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j;
                    if (ln0Var2 != null && (nn0Var3 = ln0Var2.i) != null) {
                        nn0Var3.x = null;
                    }
                    ln0 ln0Var3 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j;
                    if (ln0Var3 != null && (nn0Var2 = ln0Var3.i) != null) {
                        nn0Var2.z = null;
                    }
                }
                uk0 uk0Var = NadRewardVideoActivity.this.E;
                if (uk0Var != null) {
                    uk0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardVideoActivity.this.P;
                if (nadRewardBigCardView2 != null) {
                    nadRewardBigCardView2.setVisibility(false);
                }
                NadRewardVideoActivity.this.V2().bringToFront();
                NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j().h(true);
                String str4 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d;
                String str5 = "0";
                if (!NadRewardVideoActivity.this.d0) {
                    str = "0";
                } else {
                    str = "1";
                }
                ln0 ln0Var4 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j;
                if (ln0Var4 != null && (nn0Var = ln0Var4.i) != null && (str2 = nn0Var.a) != null) {
                    str5 = str2;
                }
                ll0.B(str4, str, str5);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.B;
            if (adImageView != null) {
                adImageView.bringToFront();
            }
            TextView textView = NadRewardVideoActivity.this.g0;
            if (textView != null) {
                textView.bringToFront();
            }
            NadRewardVideoActivity.this.S2().l();
        }

        @Override // com.baidu.tieba.eq0, com.baidu.tieba.xp0
        public void onStart() {
            NadRewardVideoActivity.this.H3(false);
            uk0 uk0Var = NadRewardVideoActivity.this.E;
            if (uk0Var != null) {
                uk0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }

        @Override // com.baidu.tieba.eq0, com.baidu.tieba.xp0
        public void onUpdateProgress(int i, int i2, int i3) {
            NadRewardVideoActivity.this.S2().j(i);
        }
    }

    /* loaded from: classes3.dex */
    public static final class q extends cx0 {
        @Override // com.baidu.tieba.cx0, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (bl0.b().a()) {
                return 2;
            }
            return 1;
        }
    }

    /* loaded from: classes3.dex */
    public static final class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (NadRewardVideoActivity.this.R2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                nadRewardVideoActivity.f1046T = nadRewardVideoActivity.R2().getMeasuredHeight() / NadRewardVideoActivity.this.R2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class s implements al0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public s() {
        }

        @Override // com.baidu.tieba.al0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.S = null;
            NadRewardVideoActivity.this.d0 = false;
        }

        @Override // com.baidu.tieba.al0.b
        public void a(qk0 qk0Var) {
            boolean z;
            View view2;
            AdDownloadStatus adDownloadStatus;
            String c;
            boolean z2;
            int i;
            NadRewardVideoActivity.this.S = qk0Var;
            if (qk0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.V++;
            g21.e("nad_reward_sp", "key_reward_count", NadRewardVideoActivity.this.V);
            boolean z3 = false;
            if (qk0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.d(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).h().b(qk0Var.d()));
                }
                ll0.d(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d, qk0Var.d(), NadRewardVideoActivity.this.U2(), qk0Var.f(), qk0Var.h());
                if (qk0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    ll0.C(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d, "2", qk0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(qk0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                } else {
                    i = 0;
                }
                if (i <= 0) {
                    ll0.p(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            ll0.g(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d, "1", qk0Var.d(), NadRewardVideoActivity.this.U2());
            NadRewardVideoActivity.this.d0 = !qk0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.I1(NadRewardVideoActivity.this).h().t());
            tn0 f = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).h().f();
            if (f != null && (c = f.c()) != null) {
                if (c.length() > 0) {
                    z3 = true;
                }
                if (z3) {
                    tn0 f2 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).h().f();
                    Intrinsics.checkNotNull(f2);
                    hashMap.put("completeInfo", f2.c());
                }
            }
            NadRewardVideoActivity.this.B3("0", "任务完成回调", hashMap);
            d91<View> transitionButtonView = NadRewardVideoActivity.this.P2().getTransitionButtonView();
            NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = null;
            if (transitionButtonView != null) {
                view2 = transitionButtonView.getRealView();
            } else {
                view2 = null;
            }
            if (view2 instanceof NadEnhanceButtonDownloadView) {
                nadEnhanceButtonDownloadView = view2;
            }
            NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView2 = nadEnhanceButtonDownloadView;
            if (nadEnhanceButtonDownloadView2 == null || (adDownloadStatus = nadEnhanceButtonDownloadView2.getDownloadStatus()) == null) {
                adDownloadStatus = AdDownloadStatus.NONE;
            }
            Intrinsics.checkNotNullExpressionValue(adDownloadStatus, "(adInfoContainer.transit… ?: AdDownloadStatus.NONE");
            NadRewardTaskHelper nadRewardTaskHelper = NadRewardVideoActivity.this.Z;
            if (nadRewardTaskHelper != null) {
                String str = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d;
                Intrinsics.checkNotNullExpressionValue(str, "adModel.common.extraParam");
                nadRewardTaskHelper.t(qk0Var, adDownloadStatus, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardVideoActivity.this.b0 = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class v implements PopupWindow.OnDismissListener {
        public v(boolean z, long j, String str) {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            aq0 aq0Var = NadRewardVideoActivity.this.J;
            if (aq0Var != null) {
                aq0Var.resume();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.B;
            if (adImageView != null) {
                ExtensionsKt.f(adImageView, true);
            }
            TextView textView = NadRewardVideoActivity.this.g0;
            if (textView != null) {
                ExtensionsKt.f(textView, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class w implements q41 {
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public w(boolean z, long j, String str) {
            this.b = z;
            this.c = j;
            this.d = str;
        }

        @Override // com.baidu.tieba.q41
        public void a() {
            ll0.j(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d);
        }

        @Override // com.baidu.tieba.q41
        public void d() {
            ll0.t(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d);
        }

        @Override // com.baidu.tieba.q41
        public void b() {
            if (!this.b) {
                return;
            }
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if ((TextUtils.equals(this.d, "1") || TextUtils.equals(this.d, "2")) && NadRewardVideoActivity.this.b0) {
                in0 I1 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                ll0.v(I1, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                return;
            }
            in0 I12 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            ll0.v(I12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
        }

        @Override // com.baidu.tieba.q41
        public void c() {
            if (!this.b) {
                return;
            }
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (TextUtils.equals(this.d, "2") && NadRewardVideoActivity.this.b0) {
                in0 I1 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                ll0.v(I1, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                return;
            }
            in0 I12 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            ll0.v(I12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
        }
    }

    public final void C3() {
        long j2;
        int i2;
        String d2;
        Integer intOrNull;
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        go0 p2 = in0Var.h().p();
        if (p2 != null && p2.f() != null) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            go0 p3 = in0Var2.h().p();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            AbsRewardCountDownView absRewardCountDownView = this.D;
            if (absRewardCountDownView != null) {
                j2 = absRewardCountDownView.getMillisUntilFinished();
            } else {
                j2 = 0;
            }
            int seconds = (int) timeUnit.toSeconds(j2);
            int i3 = 0;
            if (p3 != null && (d2 = p3.d()) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(d2)) != null) {
                i2 = intOrNull.intValue();
            } else {
                i2 = 0;
            }
            int i4 = seconds - i2;
            if (i4 > 0) {
                i3 = i4;
            }
            AbsRewardCountDownView absRewardCountDownView2 = this.D;
            if (absRewardCountDownView2 != null) {
                absRewardCountDownView2.c();
            }
            AbsRewardCountDownView absRewardCountDownView3 = this.D;
            if (absRewardCountDownView3 != null) {
                in0 in0Var3 = this.R;
                if (in0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, in0Var3.h(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        NadRewardVideoActivity.this.f0 = true;
                        NadRewardVideoActivity.this.y3();
                    }
                });
            }
        }
    }

    public final void I3() {
        if (this.e0 || x3()) {
            return;
        }
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        sn0 c2 = in0Var.c();
        if (c2 != null && c2.b()) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ln0 ln0Var = in0Var2.j;
            if (ln0Var != null) {
                int i2 = ln0Var.c;
                in0 in0Var3 = this.R;
                if (in0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == in0Var3.h().s()) {
                    return;
                }
            }
        }
        this.e0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        NadRewardBigCardView nadRewardBigCardView2 = this.P;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.bringToFront();
        }
        uk0 uk0Var = this.E;
        if (uk0Var != null) {
            uk0Var.setVisibility(false);
        }
        NadHighLightTextView nadHighLightTextView = this.H;
        if (nadHighLightTextView != null) {
            ExtensionsKt.f(nadHighLightTextView, false);
        }
        NadIconTextButton nadIconTextButton = this.I;
        if (nadIconTextButton != null) {
            ExtensionsKt.f(nadIconTextButton, false);
        }
        S2().l();
        P2().setFestivalEntranceContainerInvisible();
    }

    public final void R3() {
        String str;
        String c2;
        Integer intOrNull;
        int i2 = 0;
        this.Y = false;
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        go0 p2 = in0Var.h().p();
        if (p2 != null && p2.f() != null) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final go0 p3 = in0Var2.h().p();
            if (p3 != null) {
                str = p3.b();
            } else {
                str = null;
            }
            if (!N2(str)) {
                AbsRewardCountDownView absRewardCountDownView = this.D;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.setSuspendShowTime(-1);
                }
                AbsRewardCountDownView absRewardCountDownView2 = this.D;
                if (absRewardCountDownView2 != null) {
                    absRewardCountDownView2.setSuspendShowCallback(null);
                    return;
                }
                return;
            }
            in0 in0Var3 = this.R;
            if (in0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = in0Var3.h().s();
            if (p3 != null && (c2 = p3.c()) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(c2)) != null) {
                i2 = intOrNull.intValue();
            }
            AbsRewardCountDownView absRewardCountDownView3 = this.D;
            if (absRewardCountDownView3 != null) {
                absRewardCountDownView3.f(s2 - i2, new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$showSuspendDialogDelay$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        boolean Q3;
                        String str2;
                        Q3 = NadRewardVideoActivity.this.Q3();
                        if (Q3) {
                            String str3 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.d;
                            String valueOf = String.valueOf(NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j().c());
                            go0 go0Var = p3;
                            if (go0Var != null) {
                                str2 = go0Var.b();
                            } else {
                                str2 = null;
                            }
                            ll0.i(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void g3() {
        if (this.D == null) {
            xk0 a2 = bl0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            View inflate = LayoutInflater.from(this).inflate(a2.g(), (ViewGroup) R2(), true);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…youtId, flRootView, true)");
            this.D = (AbsRewardCountDownView) inflate.findViewById(R.id.reward_countdown);
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.bringToFront();
        }
        AbsRewardCountDownView absRewardCountDownView2 = this.D;
        if (absRewardCountDownView2 != null) {
            absRewardCountDownView2.c();
        }
        AbsRewardCountDownView absRewardCountDownView3 = this.D;
        if (absRewardCountDownView3 != null) {
            in0 in0Var = this.R;
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = in0Var.h().s();
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, in0Var2.h(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$1
                {
                    super(0);
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    sn0 c2;
                    String str;
                    Long l2;
                    Long l3;
                    NadRewardVideoActivity.this.f0 = true;
                    NadRewardVideoActivity.this.y3();
                    Long l4 = null;
                    if (NadRewardVideoActivity.I1(NadRewardVideoActivity.this).r() && (c2 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).c()) != null && c2.n()) {
                        if (jl0.a.f()) {
                            String g2 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).g();
                            sn0 c3 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).c();
                            if (c3 != null) {
                                l3 = Long.valueOf(c3.o());
                            } else {
                                l3 = null;
                            }
                            qe0.c(l11.c(g2, l3, NadRewardVideoActivity.I1(NadRewardVideoActivity.this).e), NadRewardVideoActivity.this);
                            ll0.A(NadRewardVideoActivity.I1(NadRewardVideoActivity.this));
                        } else {
                            NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                            sn0 c4 = NadRewardVideoActivity.I1(nadRewardVideoActivity).c();
                            if (c4 != null) {
                                str = c4.m();
                            } else {
                                str = null;
                            }
                            sn0 c5 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).c();
                            if (c5 != null) {
                                l2 = Long.valueOf(c5.o());
                            } else {
                                l2 = null;
                            }
                            nadRewardVideoActivity.M3(true, str, l2);
                        }
                    }
                    sn0 c6 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).c();
                    if (c6 != null && c6.i() && jl0.a.f()) {
                        String str2 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).f.c;
                        sn0 c7 = NadRewardVideoActivity.I1(NadRewardVideoActivity.this).c();
                        if (c7 != null) {
                            l4 = Long.valueOf(c7.j());
                        }
                        qe0.c(l11.e(str2, l4, NadRewardVideoActivity.I1(NadRewardVideoActivity.this).e), NadRewardVideoActivity.this);
                        ll0.o(NadRewardVideoActivity.I1(NadRewardVideoActivity.this));
                    }
                }
            });
        }
    }

    public final void n3() {
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        r31 a2 = r31.a(in0Var.l());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.I == null) {
                this.I = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((w11.c.e(this) * 9) / 16) / 2) + w11.c.a(this, 26.0f);
                R2().addView(this.I, layoutParams);
            }
            NadIconTextButton nadIconTextButton = this.I;
            if (nadIconTextButton != null) {
                nadIconTextButton.e(a2);
                nadIconTextButton.setOnClickListener(new m(a2));
                nadIconTextButton.setVisibility(0);
                return;
            }
            return;
        }
        NadIconTextButton nadIconTextButton2 = this.I;
        if (nadIconTextButton2 != null) {
            ExtensionsKt.f(nadIconTextButton2, false);
        }
    }

    public final void o3() {
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        q31 a2 = q31.a(in0Var.m());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.H == null) {
                this.H = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((w11.c.e(this) * 9) / 16) / 2) + w11.c.a(this, 52.0f);
                layoutParams.setMarginStart(w11.c.a(this, 9.0f));
                layoutParams.setMarginEnd(w11.c.a(this, 8.0f));
                R2().addView(this.H, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.H;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(w11.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
                nadHighLightTextView.setAlpha(0.8f);
                nadHighLightTextView.setGravity(17);
                nadHighLightTextView.e(a2);
                nadHighLightTextView.setVisibility(0);
                return;
            }
            return;
        }
        NadHighLightTextView nadHighLightTextView2 = this.H;
        if (nadHighLightTextView2 != null) {
            ExtensionsKt.f(nadHighLightTextView2, false);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void u1() {
        super.u1();
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.c();
        }
        aq0 aq0Var = this.J;
        if (aq0Var != null) {
            aq0Var.release();
        }
        this.J = null;
        NadRewardVideoDialog nadRewardVideoDialog = this.K;
        if (nadRewardVideoDialog != null) {
            nadRewardVideoDialog.onDestroy();
        }
        NadRewardVideoDialog nadRewardVideoDialog2 = this.L;
        if (nadRewardVideoDialog2 != null) {
            nadRewardVideoDialog2.onDestroy();
        }
        NadRewardVideoDialog nadRewardVideoDialog3 = this.M;
        if (nadRewardVideoDialog3 != null) {
            nadRewardVideoDialog3.onDestroy();
        }
        NadRewardSuspendDialog nadRewardSuspendDialog = this.N;
        if (nadRewardSuspendDialog != null) {
            nadRewardSuspendDialog.onDestroy();
        }
        NadRewardLottieDialog nadRewardLottieDialog = this.O;
        if (nadRewardLottieDialog != null) {
            nadRewardLottieDialog.onDestroy();
        }
        P2().C();
        NadRewardTaskHelper nadRewardTaskHelper = this.Z;
        if (nadRewardTaskHelper != null) {
            nadRewardTaskHelper.F();
        }
        Handler handler = this.a0;
        if (handler != null) {
            handler.removeCallbacks(this.c0);
        }
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.t();
        }
        S2().l();
        vk0 vk0Var = this.h0;
        if (vk0Var != null) {
            vk0Var.release();
        }
        NadRewardFestivalContainer nadRewardFestivalContainer = this.i0;
        if (nadRewardFestivalContainer != null) {
            nadRewardFestivalContainer.f();
        }
        ti0.a().a(this);
        ml0.e.a();
    }

    public static final /* synthetic */ in0 I1(NadRewardVideoActivity nadRewardVideoActivity) {
        in0 in0Var = nadRewardVideoActivity.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return in0Var;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean D1(Bundle bundle) {
        if (!super.D1(bundle)) {
            return false;
        }
        getWindow().setSoftInputMode(19);
        getWindow().setFormat(-3);
        requestWindowFeature(1);
        setEnableSliding(false);
        setCurrentActivityNoTransparent();
        return true;
    }

    public final void H3(boolean z) {
        int i2;
        ViewGroup.LayoutParams layoutParams = W2().getLayoutParams();
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            i2 = nadRewardBigCardView.getHeight();
        } else {
            i2 = 0;
        }
        if (z) {
            layoutParams.height = w11.c.c(this) - i2;
        } else {
            layoutParams.height = w11.c.a(this, 33.0f);
        }
        W2().setLayoutParams(layoutParams);
    }

    public final boolean M2(in0 in0Var) {
        tm0 tm0Var;
        String str;
        xm0 xm0Var = in0Var.m;
        if (xm0Var != null && (tm0Var = xm0Var.p) != null && tm0Var.e) {
            if (xm0Var != null && tm0Var != null) {
                str = tm0Var.a;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean S3(String str) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        NadRewardVideoDialog H2 = H2(str, true);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        H2.show(supportFragmentManager, (String) null);
        this.K = H2;
        A3();
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void v1(Intent intent) {
        super.v1(intent);
        setIntent(intent);
        if (!z3()) {
            y01.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
            return;
        }
        g21.e("nad_reward_sp", "key_in_session_count", g21.a("nad_reward_sp", "key_in_session_count", 1) + 1);
        c3();
        K3();
    }

    public final void w3(boolean z) {
        g21.e("nad_reward_sp", "key_is_new_session", z ? 1 : 0);
    }

    public static /* synthetic */ NadRewardVideoDialog I2(NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nadRewardVideoActivity.H2(str, z);
    }

    public static /* synthetic */ void N3(NadRewardVideoActivity nadRewardVideoActivity, boolean z, String str, Long l2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            l2 = 0L;
        }
        nadRewardVideoActivity.M3(z, str, l2);
    }

    public static /* synthetic */ void b3(NadRewardVideoActivity nadRewardVideoActivity, Context context, in0 in0Var, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        nadRewardVideoActivity.a3(context, in0Var, z);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void A1() {
        super.A1();
        w3(false);
    }

    public final void A3() {
        aq0 aq0Var = this.J;
        if (aq0Var != null) {
            aq0Var.pause();
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B1() {
        super.B1();
        w3(true);
    }

    public final void D3() {
        ti0.a().c(this, new t(aj0.class));
    }

    public final void E3() {
        this.f0 = false;
        this.e0 = false;
        this.S = null;
        this.b0 = false;
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.c();
        }
        P2().C();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r0 != true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F3() {
        ViewGroup view2;
        boolean z;
        if (!x3()) {
            uk0 uk0Var = this.E;
            if (uk0Var != null && (view2 = uk0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            aq0 aq0Var = this.J;
            if (aq0Var != null) {
                aq0Var.resume();
            }
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.b();
        }
    }

    public final boolean G2() {
        boolean z;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView == null) {
            return false;
        }
        if (nadRewardBigCardView.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        sn0 c2 = in0Var.c();
        if (c2 == null || !c2.b()) {
            return false;
        }
        return true;
    }

    public final void G3() {
        SimpleAdInfoView Q2 = Q2();
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ce0.a(in0Var.i)) {
            Q2.setVisibility(0);
        } else {
            Q2.setVisibility(8);
        }
        in0 in0Var2 = this.R;
        if (in0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        Q2.setAdInfo(in0Var2.i);
    }

    public final void O2() {
        int a2 = g21.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.X = a2;
        g21.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
    }

    public final boolean T3() {
        ViewGroup view2;
        boolean z;
        uk0 uk0Var = this.E;
        if (uk0Var == null || (view2 = uk0Var.getView()) == null) {
            return false;
        }
        if (view2.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        sn0 c2 = in0Var.c();
        if (c2 == null || !c2.u()) {
            return false;
        }
        return true;
    }

    public final void U3() {
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ll0.w(in0Var, U2());
        O2();
        in0 in0Var2 = this.R;
        if (in0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        qe0.c(in0Var2.f.l, this);
        R3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        in0 in0Var = this.R;
        if (in0Var != null) {
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            tn0 f2 = in0Var.h().f();
            if (f2 != null) {
                str = f2.b();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                qe0.c(str, this);
            }
        }
        super.finish();
    }

    public final void i3() {
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var.d() == null) {
            return;
        }
        final NadRewardFloatingLayerView S2 = S2();
        in0 in0Var2 = this.R;
        if (in0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        S2.setData(in0Var2);
        S2.setTriggerCallback(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initFloatingLayer$$inlined$apply$lambda$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String cmd) {
                Intrinsics.checkNotNullParameter(cmd, "cmd");
                if (jl0.a.f()) {
                    jl0 jl0Var = jl0.a;
                    NadRewardVideoActivity nadRewardVideoActivity = this;
                    jl0Var.d(nadRewardVideoActivity, NadRewardVideoActivity.I1(nadRewardVideoActivity), jl0.a.c(cmd, NadRewardVideoActivity.I1(this)));
                } else if (!Intrinsics.areEqual(cmd, "__CONVERT_CMD__")) {
                    qe0.b(cmd);
                } else {
                    NadRewardVideoActivity nadRewardVideoActivity2 = this;
                    Context context = NadRewardFloatingLayerView.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    nadRewardVideoActivity2.a3(context, NadRewardVideoActivity.I1(this), true);
                }
            }
        });
        S2.setVisibility(0);
    }

    public final void k3() {
        ml0.e.a();
        ti0.a().c(this, new l(m41.class));
    }

    public final void l3() {
        if (this.Z == null) {
            this.Z = new NadRewardTaskHelper();
        }
        NadRewardTaskHelper nadRewardTaskHelper = this.Z;
        if (nadRewardTaskHelper != null) {
            in0 in0Var = this.R;
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(in0Var);
        }
    }

    public final void m3() {
        NadRewardInterceptFrameLayout R2 = R2();
        boolean z = true;
        R2.setClickable(true);
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!in0Var.p()) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (!in0Var2.r()) {
                z = false;
            }
        }
        R2.setEnableIntercept(z);
        R2.setInterceptCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initRootView$$inlined$apply$lambda$1
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                NadRewardVideoActivity.b3(nadRewardVideoActivity, nadRewardVideoActivity, NadRewardVideoActivity.I1(nadRewardVideoActivity), false, 4, null);
                ll0.z(NadRewardVideoActivity.I1(NadRewardVideoActivity.this));
            }
        });
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        K3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (z11.a() || J3()) {
            return;
        }
        try {
            super.onBackPressed();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void w1() {
        super.w1();
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        aq0 aq0Var = this.J;
        if (aq0Var != null) {
            aq0Var.pause();
        }
    }

    public final boolean x3() {
        if (jl0.a.f()) {
            return ml0.e.b();
        }
        j41 j41Var = this.F;
        if (j41Var != null && j41Var.isShowing()) {
            return true;
        }
        return false;
    }

    public final void y3() {
        al0 c2 = bl0.c();
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        c2.a(in0Var, new co0(this.U, this.V), new s());
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void z1() {
        super.z1();
        if (v3()) {
            return;
        }
        F3();
    }

    public final void B3(String str, String str2, HashMap<String, String> hashMap) {
        rk0 rk0Var = new rk0();
        rk0Var.a = str;
        rk0Var.b = hashMap;
        ti0.a().b(rk0Var);
    }

    public final NadRewardVideoDialog H2(final String str, final boolean z) {
        boolean z2;
        Integer num;
        String valueOf;
        boolean z3;
        final NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = in0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.f3(str, str2);
        pk0 Q2 = nadRewardVideoDialog.Q2();
        boolean z4 = false;
        if (Q2 != null) {
            if (z && !this.d0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Q2.L(z3);
        }
        pk0 Q22 = nadRewardVideoDialog.Q2();
        if (Q22 != null) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            Q22.K(in0Var2.h().r());
        }
        pk0 Q23 = nadRewardVideoDialog.Q2();
        if (Q23 != null) {
            in0 in0Var3 = this.R;
            if (in0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (in0Var3.h().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                in0 in0Var4 = this.R;
                if (in0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = in0Var4.h().i();
            } else {
                in0 in0Var5 = this.R;
                if (in0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                io0 q2 = in0Var5.h().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            Q23.G(valueOf);
        }
        pk0 Q24 = nadRewardVideoDialog.Q2();
        if (Q24 != null) {
            in0 in0Var6 = this.R;
            if (in0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            un0 e2 = in0Var6.e();
            if (e2 != null && e2.g()) {
                z4 = true;
            }
            Q24.I(z4);
        }
        nadRewardVideoDialog.d3(new a(str, z));
        nadRewardVideoDialog.i3(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NadRewardVideoActivity.this.F3();
            }
        });
        nadRewardVideoDialog.b3(new b(str, z));
        nadRewardVideoDialog.e3(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                invoke2(str3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str3) {
                this.Y2(NadRewardVideoDialog.this.getContext(), NadRewardVideoActivity.I1(this), str3);
                if (jl0.a.b(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                }
            }
        });
        nadRewardVideoDialog.j3(new c(nadRewardVideoDialog, this, str, z));
        return nadRewardVideoDialog;
    }

    public final NadRewardLottieDialog J2(final String str) {
        D3();
        NadRewardLottieDialog nadRewardLottieDialog = new NadRewardLottieDialog();
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = in0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.f3(str, str2);
        in0 in0Var2 = this.R;
        if (in0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.u3(in0Var2.h().k());
        nadRewardLottieDialog.d3(new d(str));
        nadRewardLottieDialog.i3(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NadRewardVideoActivity.this.F3();
            }
        });
        nadRewardLottieDialog.b3(new e(str));
        nadRewardLottieDialog.k3(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NadRewardVideoActivity.I1(NadRewardVideoActivity.this).j().e(true);
            }
        });
        return nadRewardLottieDialog;
    }

    public final boolean O3(long j2) {
        boolean z;
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var.h().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        in0 in0Var2 = this.R;
        if (in0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog I2 = I2(this, in0Var2.h().n(j2), false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        I2.show(supportFragmentManager, (String) null);
        this.L = I2;
        A3();
        return true;
    }

    public final boolean J3() {
        S2().l();
        NadRewardTaskHelper nadRewardTaskHelper = this.Z;
        if (nadRewardTaskHelper != null && nadRewardTaskHelper.A()) {
            in0 in0Var = this.R;
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return S3(in0Var.h().c());
        } else if (this.f0) {
            return P3();
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            AbsRewardCountDownView absRewardCountDownView = this.D;
            if (absRewardCountDownView != null) {
                return O3(timeUnit.toSeconds(absRewardCountDownView.getMillisUntilFinished()));
            }
            return false;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0018: IGET  (r1v3 int A[REMOVE]) = (r3v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.U int), ('_' char), (wrap: int : 0x0022: IGET  (r2v1 int A[REMOVE]) = (r3v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.V int), ('_' char), (wrap: int : 0x002a: IGET  (r1v5 int A[REMOVE]) = (r3v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.W int)] */
    public final String U2() {
        this.W = g21.a("nad_reward_sp", "key_in_session_count", 1);
        this.U = g21.a("nad_reward_sp", "key_session_count", 1);
        StringBuilder sb = new StringBuilder();
        sb.append(this.U);
        sb.append('_');
        sb.append(this.V);
        sb.append('_');
        sb.append(this.W);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…nSessionCount).toString()");
        return sb2;
    }

    public final void c3() {
        E3();
        m3();
        q3();
        e3();
        g3();
        t3();
        s3();
        f3();
        o3();
        n3();
        p3();
        d3();
        j3();
        i3();
        k3();
        l3();
        U3();
        r3();
        h3();
    }

    public final void j3() {
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var.r()) {
            T2().setVisibility(0);
            NadRewardImageView T2 = T2();
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            T2.setData(in0Var2);
            T2().setClickCallBack(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initImageStyle$1
                {
                    super(0);
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                    NadRewardVideoActivity.b3(nadRewardVideoActivity, nadRewardVideoActivity, NadRewardVideoActivity.I1(nadRewardVideoActivity), false, 4, null);
                }
            });
            G3();
            return;
        }
        T2().setVisibility(8);
        Q2().setVisibility(8);
    }

    public final boolean v3() {
        NadRewardVideoDialog nadRewardVideoDialog = this.L;
        if (nadRewardVideoDialog != null && nadRewardVideoDialog.isVisible()) {
            return true;
        }
        NadRewardVideoDialog nadRewardVideoDialog2 = this.M;
        if (nadRewardVideoDialog2 != null && nadRewardVideoDialog2.isVisible()) {
            return true;
        }
        NadRewardSuspendDialog nadRewardSuspendDialog = this.N;
        if (nadRewardSuspendDialog != null && nadRewardSuspendDialog.isVisible()) {
            return true;
        }
        NadRewardLottieDialog nadRewardLottieDialog = this.O;
        if (nadRewardLottieDialog != null && nadRewardLottieDialog.isVisible()) {
            return true;
        }
        NadRewardVideoDialog nadRewardVideoDialog3 = this.K;
        if (nadRewardVideoDialog3 != null && nadRewardVideoDialog3.isVisible()) {
            return true;
        }
        return false;
    }

    public final NadRewardSuspendDialog K2(final String str) {
        String str2;
        String str3;
        NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = in0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.f3(str, str4);
        pk0 Q2 = nadRewardSuspendDialog.Q2();
        String str5 = null;
        if (Q2 != null) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            go0 p2 = in0Var2.h().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            Q2.F(str3);
        }
        pk0 Q22 = nadRewardSuspendDialog.Q2();
        if (Q22 != null) {
            in0 in0Var3 = this.R;
            if (in0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            go0 p3 = in0Var3.h().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            Q22.J(str2);
        }
        pk0 Q23 = nadRewardSuspendDialog.Q2();
        if (Q23 != null) {
            in0 in0Var4 = this.R;
            if (in0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            go0 p4 = in0Var4.h().p();
            if (p4 != null) {
                str5 = p4.g();
            }
            Q23.M(str5);
        }
        nadRewardSuspendDialog.d3(new f(str));
        nadRewardSuspendDialog.i3(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NadRewardVideoActivity.this.F3();
            }
        });
        nadRewardSuspendDialog.b3(new g(str));
        nadRewardSuspendDialog.l3(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NadRewardVideoActivity.this.C3();
            }
        });
        return nadRewardSuspendDialog;
    }

    public final void Z2(r31 r31Var) {
        String str;
        if (jl0.a.f()) {
            jl0 jl0Var = jl0.a;
            String str2 = r31Var.c;
            in0 in0Var = this.R;
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qe0.c(jl0Var.c(str2, in0Var), this);
        } else if (jl0.a.b(r31Var.c)) {
            N3(this, false, null, null, 6, null);
        } else if (Intrinsics.areEqual(r31Var.c, "__CONVERT_CMD__")) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (in0Var2.q()) {
                in0 in0Var3 = this.R;
                if (in0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qe0.c(in0Var3.g(), this);
                return;
            }
            in0 in0Var4 = this.R;
            if (in0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str3 = null;
            if (in0Var4.p()) {
                jl0 jl0Var2 = jl0.a;
                in0 in0Var5 = this.R;
                if (in0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xm0 xm0Var = in0Var5.m;
                if (xm0Var != null) {
                    str = xm0Var.t;
                } else {
                    str = null;
                }
                if (jl0Var2.b(str)) {
                    N3(this, false, null, null, 6, null);
                    return;
                }
            }
            in0 in0Var6 = this.R;
            if (in0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            xm0 xm0Var2 = in0Var6.m;
            if (xm0Var2 != null) {
                str3 = xm0Var2.t;
            }
            qe0.c(str3, this);
        } else {
            qe0.c(r31Var.c, this);
        }
    }

    public final void K3() {
        String str;
        boolean z;
        String str2;
        Long l2 = null;
        if (jl0.a.f()) {
            in0 in0Var = this.R;
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            un0 e2 = in0Var.e();
            if (e2 != null && e2.g()) {
                in0 in0Var2 = this.R;
                if (in0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                String o2 = in0Var2.o();
                in0 in0Var3 = this.R;
                if (in0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                un0 e3 = in0Var3.e();
                if (e3 != null) {
                    l2 = Long.valueOf(e3.a());
                }
                in0 in0Var4 = this.R;
                if (in0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qe0.c(l11.c(o2, l2, in0Var4.e), this);
                return;
            }
            return;
        }
        in0 in0Var5 = this.R;
        if (in0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        un0 e4 = in0Var5.e();
        if (e4 != null) {
            str = e4.e();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            j41 j41Var = this.F;
            if (j41Var != null) {
                j41Var.f();
            }
            this.F = null;
            return;
        }
        j41 j41Var2 = this.F;
        if (j41Var2 != null) {
            j41Var2.f();
        }
        in0 in0Var6 = this.R;
        if (in0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        un0 e5 = in0Var6.e();
        if (e5 != null) {
            str2 = e5.d();
        } else {
            str2 = null;
        }
        in0 in0Var7 = this.R;
        if (in0Var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        un0 e6 = in0Var7.e();
        if (e6 != null) {
            l2 = Long.valueOf(e6.a());
        }
        M3(true, str2, l2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        if (r0 == true) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean L3() {
        String str;
        ViewGroup view2;
        boolean z;
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var.h().k() != null) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (in0Var2.h().m() != null) {
                in0 in0Var3 = this.R;
                if (in0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                eo0 m2 = in0Var3.h().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !so.a(this) && !v3() && !x3()) {
                    uk0 uk0Var = this.E;
                    if (uk0Var != null && (view2 = uk0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    in0 in0Var4 = this.R;
                    if (in0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    do0 h2 = in0Var4.h();
                    in0 in0Var5 = this.R;
                    if (in0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    wn0 k2 = in0Var5.h().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    in0 in0Var6 = this.R;
                    if (in0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    wn0 k3 = in0Var6.h().k();
                    Intrinsics.checkNotNull(k3);
                    NadRewardLottieDialog J2 = J2(h2.j(c2, k3.a()));
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    J2.show(supportFragmentManager, (String) null);
                    this.O = J2;
                    A3();
                    return true;
                }
            }
        }
        return false;
    }

    public final void d3() {
        String g2;
        Integer intOrNull;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        int i2 = 0;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(false);
        }
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var.b() == null) {
            this.P = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        in0 in0Var2 = this.R;
        if (in0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(in0Var2);
        nadRewardBigCardView2.setBigCardShowProgress(new Function1<Float, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initBigCard$$inlined$apply$lambda$1
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                invoke(f2.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f2) {
                NadRewardVideoActivity.this.V3(f2);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.P = nadRewardBigCardView2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = -w11.c.c(this);
        R2().addView(this.P, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.P;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.P;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        in0 in0Var3 = this.R;
        if (in0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = in0Var3.h().s();
        in0 in0Var4 = this.R;
        if (in0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        rn0 b2 = in0Var4.b();
        if (b2 != null && (g2 = b2.g()) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(g2)) != null) {
            i2 = intOrNull.intValue();
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.a(s2 - i2, new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initBigCard$2
                {
                    super(0);
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    NadRewardVideoActivity.this.I3();
                }
            });
        }
    }

    public final void e3() {
        int a2;
        xk0 a3 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        boolean z = true;
        View inflate = LayoutInflater.from(this).inflate(a3.z(), (ViewGroup) R2(), true);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…youtId, flRootView, true)");
        AdImageView adImageView = (AdImageView) inflate.findViewById(R.id.reward_arrow);
        this.z = adImageView;
        if (adImageView != null) {
            adImageView.setImageResource(R.drawable.nad_reward_up_arrow);
        }
        AdImageView adImageView2 = this.z;
        if (adImageView2 != null) {
            in0 in0Var = this.R;
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            sn0 c2 = in0Var.c();
            if (c2 == null || !c2.e()) {
                in0 in0Var2 = this.R;
                if (in0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (!in0Var2.r()) {
                    z = false;
                }
            }
            if (z) {
                adImageView2.setVisibility(0);
            } else {
                adImageView2.setVisibility(8);
                adImageView2 = null;
            }
            if (adImageView2 != null) {
                ViewGroup.LayoutParams layoutParams = adImageView2.getLayoutParams();
                if (layoutParams != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    in0 in0Var3 = this.R;
                    if (in0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (in0Var3.r()) {
                        a2 = w11.c.a(adImageView2.getContext(), 23.0f);
                    } else {
                        a2 = w11.c.a(adImageView2.getContext(), 4.0f);
                    }
                    layoutParams2.bottomMargin = a2;
                    adImageView2.setOnClickListener(new h(adImageView2, this));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
    }

    public final void p3() {
        nn0 nn0Var;
        nn0 nn0Var2;
        String str;
        nn0 nn0Var3;
        String str2;
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ln0 ln0Var = in0Var.j;
        uk0 uk0Var = null;
        if (ln0Var != null) {
            nn0Var = ln0Var.i;
        } else {
            nn0Var = null;
        }
        if (nn0Var != null) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            sn0 c2 = in0Var2.c();
            if (c2 == null || c2.s()) {
                in0 in0Var3 = this.R;
                if (in0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ln0 ln0Var2 = in0Var3.j;
                if (ln0Var2 != null && (nn0Var2 = ln0Var2.i) != null) {
                    in0 in0Var4 = this.R;
                    if (in0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ln0 ln0Var3 = in0Var4.j;
                    if (ln0Var3 != null && (nn0Var3 = ln0Var3.i) != null && (str2 = nn0Var3.y) != null) {
                        qk0 qk0Var = this.S;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (qk0Var == null || (r4 = qk0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    nn0Var2.y = str;
                }
                uk0 uk0Var2 = this.E;
                if (uk0Var2 != null) {
                    uk0Var2.setVisibility(false);
                }
                uk0.a aVar = uk0.k0;
                in0 in0Var5 = this.R;
                if (in0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                uk0 a2 = aVar.a(in0Var5, this);
                this.E = a2;
                if (a2 != null) {
                    in0 in0Var6 = this.R;
                    if (in0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(in0Var6);
                }
                uk0 uk0Var3 = this.E;
                if (uk0Var3 instanceof View) {
                    uk0Var = uk0Var3;
                }
                View view2 = (View) uk0Var;
                if (view2 != null) {
                    V2().removeAllViews();
                    V2().addView(view2);
                    V2().bringToFront();
                }
                uk0 uk0Var4 = this.E;
                if (uk0Var4 != null) {
                    uk0Var4.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
                        {
                            super(0);
                        }

                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            uk0 uk0Var5 = NadRewardVideoActivity.this.E;
                            if (uk0Var5 != null) {
                                uk0Var5.setVisibility(false);
                            }
                            aq0 aq0Var = NadRewardVideoActivity.this.J;
                            if (aq0Var != null) {
                                aq0Var.start();
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        uk0 uk0Var5 = this.E;
        if (uk0Var5 != null) {
            uk0Var5.setVisibility(false);
        }
    }

    public final void r3() {
        String str;
        String str2;
        String str3;
        if (this.g0 == null) {
            xk0 a2 = bl0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            this.g0 = (TextView) LayoutInflater.from(this).inflate(a2.s(), (ViewGroup) R2(), true).findViewById(R.id.top_tag_text);
        }
        TextView textView = this.g0;
        if (textView != null) {
            in0 in0Var = this.R;
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            hn0 n2 = in0Var.n();
            String str4 = null;
            if (n2 != null) {
                str = n2.b();
            } else {
                str = null;
            }
            if (true ^ TextUtils.isEmpty(str)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView = null;
            }
            if (textView != null && textView.getVisibility() == 0) {
                in0 in0Var2 = this.R;
                if (in0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                hn0 n3 = in0Var2.n();
                if (n3 != null) {
                    str2 = n3.b();
                } else {
                    str2 = null;
                }
                textView.setText(str2);
                in0 in0Var3 = this.R;
                if (in0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                hn0 n4 = in0Var3.n();
                if (n4 != null) {
                    str3 = n4.c();
                } else {
                    str3 = null;
                }
                textView.setTextColor(Color.parseColor(str3));
                in0 in0Var4 = this.R;
                if (in0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                hn0 n5 = in0Var4.n();
                if (n5 != null) {
                    str4 = n5.a();
                }
                textView.setBackgroundColor(Color.parseColor(str4));
            }
        }
    }

    public final void L2() {
        boolean z;
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = in0Var.e;
        Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
        ArrayList<MonitorUrl> arrayList = new ArrayList();
        for (Object obj : list) {
            String str = ((MonitorUrl) obj).clickUrl;
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                arrayList.add(obj);
            }
        }
        for (MonitorUrl monitorUrl : arrayList) {
            ez0.b(monitorUrl.clickUrl);
        }
    }

    public final boolean P3() {
        String str;
        boolean z;
        if (!this.d0) {
            return false;
        }
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        do0 h2 = in0Var.h();
        qk0 qk0Var = this.S;
        if (qk0Var != null) {
            str = qk0Var.e();
        } else {
            str = null;
        }
        String l2 = h2.l(str);
        if (l2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || Intrinsics.areEqual(l2, "{}")) {
            return false;
        }
        NadRewardVideoDialog I2 = I2(this, l2, false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        I2.show(supportFragmentManager, (String) null);
        this.M = I2;
        A3();
        return true;
    }

    public final boolean Q3() {
        JSONObject jSONObject;
        String f2;
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        go0 p2 = in0Var.h().p();
        if (p2 == null || p2.f() == null || this.Y || x3()) {
            return false;
        }
        in0 in0Var2 = this.R;
        if (in0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        go0 p3 = in0Var2.h().p();
        if (p3 != null && (f2 = p3.f()) != null) {
            jSONObject = ExtensionsKt.a(f2);
        } else {
            jSONObject = null;
        }
        NadRewardSuspendDialog K2 = K2(String.valueOf(jSONObject));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        K2.show(supportFragmentManager, (String) null);
        this.Y = true;
        this.N = K2;
        A3();
        return true;
    }

    public final void f3() {
        if (this.B == null) {
            xk0 a2 = bl0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            View inflate = LayoutInflater.from(this).inflate(a2.u(), (ViewGroup) R2(), true);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…youtId, flRootView, true)");
            this.B = (AdImageView) inflate.findViewById(R.id.reward_close_icon);
        }
        AdImageView adImageView = this.B;
        if (adImageView != null) {
            int a3 = w11.c.a(adImageView.getContext(), 10.0f);
            adImageView.setPadding(a3, a3, a3, a3);
            adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            adImageView.setOnClickListener(new i());
        }
    }

    public final void q3() {
        boolean z = true;
        if (this.C == null) {
            xk0 a2 = bl0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            this.C = (ImageView) LayoutInflater.from(this).inflate(a2.a(), (ViewGroup) R2(), true).findViewById(R.id.top_tag);
        }
        ImageView imageView = this.C;
        if (imageView != null) {
            in0 in0Var = this.R;
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            un0 e2 = in0Var.e();
            if ((e2 == null || !e2.g()) ? false : false) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public final void M3(boolean z, String str, Long l2) {
        boolean z2;
        long j2;
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var.f().length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.F = null;
            return;
        }
        j41 j41Var = this.F;
        if (j41Var != null && j41Var.isShowing()) {
            return;
        }
        if (z) {
            Handler handler = this.a0;
            if (handler != null) {
                Runnable runnable = this.c0;
                if (l2 != null) {
                    j2 = l2.longValue();
                } else {
                    j2 = 0;
                }
                handler.postDelayed(runnable, j2);
            }
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (in0Var2.r()) {
                in0 in0Var3 = this.R;
                if (in0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ll0.A(in0Var3);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        xk0 a2 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        j41 j41Var2 = new j41(this, a2.B());
        j41Var2.setOnDismissListener(new v(z, currentTimeMillis, str));
        j41Var2.j(new w(z, currentTimeMillis, str));
        Resources resources = getResources();
        xk0 a3 = bl0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        double dimension = 1 - (resources.getDimension(a3.w()) / w11.c.c(this));
        in0 in0Var4 = this.R;
        if (in0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String f2 = in0Var4.f();
        in0 in0Var5 = this.R;
        if (in0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        r41 r41Var = new r41(f2, dimension, 0, in0Var5.f.d);
        r41Var.O(true);
        r41Var.N(false);
        r41Var.R(true);
        r41Var.Q(!z);
        r41Var.F(z);
        r41Var.G(z);
        r41Var.H(true);
        in0 in0Var6 = this.R;
        if (in0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!TextUtils.isEmpty(in0Var6.f.l)) {
            in0 in0Var7 = this.R;
            if (in0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            r41Var.E(in0Var7.f.k);
        }
        Unit unit = Unit.INSTANCE;
        j41Var2.i(r41Var);
        j41Var2.k();
        Unit unit2 = Unit.INSTANCE;
        this.F = j41Var2;
        aq0 aq0Var = this.J;
        if (aq0Var != null) {
            aq0Var.pause();
        }
        AdImageView adImageView = this.B;
        if (adImageView != null) {
            ExtensionsKt.f(adImageView, false);
        }
        TextView textView = this.g0;
        if (textView != null) {
            ExtensionsKt.f(textView, false);
        }
        in0 in0Var8 = this.R;
        if (in0Var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        in0Var8.j().f(true);
        S2().l();
    }

    public final boolean N2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null).contains(String.valueOf(this.X))) {
            return false;
        }
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        in0Var.j().g(this.X);
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void t1(Bundle bundle) {
        super.t1(bundle);
        setContentView(R.layout.nad_reward_video_lp_activity);
        R2().post(new r());
        this.a0 = new Handler(Looper.getMainLooper());
        if (!z3()) {
            finish();
            return;
        }
        g21.e("nad_reward_sp", "key_session_count", g21.a("nad_reward_sp", "key_session_count", 0) + 1);
        g21.e("nad_reward_sp", "key_in_session_count", 1);
        g21.e("nad_reward_sp", "key_reward_count", 0);
        c3();
    }

    public final void V3(float f2) {
        float f3;
        boolean z;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            f3 = nadRewardBigCardView.getHeight();
        } else {
            f3 = 0.0f;
        }
        float e2 = ((w11.c.e(this) / w11.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ln0 ln0Var = in0Var.j;
        if (ln0Var != null) {
            if (ln0Var.f > 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int i2 = (int) (e2 * f2);
                layoutParams.leftMargin = i2;
                layoutParams.rightMargin = i2;
            }
        }
        X2().setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        layoutParams2.bottomMargin = (int) ((f2 - 1) * f3);
        NadRewardBigCardView nadRewardBigCardView2 = this.P;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.setLayoutParams(layoutParams2);
        }
    }

    public final void Y2(Context context, in0 in0Var, String str) {
        String str2;
        String str3;
        tm0 tm0Var;
        tm0 tm0Var2;
        tm0 tm0Var3;
        if (jl0.a.f()) {
            jl0.a.d(context, in0Var, str);
            return;
        }
        boolean z = true;
        if (in0Var.q() && M2(in0Var)) {
            xm0 xm0Var = in0Var.m;
            String str4 = null;
            if (xm0Var != null && (tm0Var3 = xm0Var.p) != null) {
                str2 = tm0Var3.a;
            } else {
                str2 = null;
            }
            if (l11.f(str2)) {
                xm0 xm0Var2 = in0Var.m;
                if (xm0Var2 != null && (tm0Var2 = xm0Var2.p) != null) {
                    str3 = tm0Var2.b;
                } else {
                    str3 = null;
                }
                if (str3 != null && str3.length() != 0) {
                    z = false;
                }
                if (!z) {
                    qe0.b(str3);
                    return;
                } else if (context != null) {
                    xm0 xm0Var3 = in0Var.m;
                    if (xm0Var3 != null && (tm0Var = xm0Var3.p) != null) {
                        str4 = tm0Var.a;
                    }
                    Intrinsics.checkNotNull(str4);
                    df0.b(context, str4);
                    return;
                } else {
                    return;
                }
            }
        }
        if (jl0.a.b(str)) {
            j41 j41Var = this.F;
            if ((j41Var == null || !j41Var.isShowing()) && !T3() && !G2()) {
                N3(this, false, null, null, 6, null);
                return;
            }
            return;
        }
        if (in0Var.q()) {
            str = l11.b(in0Var, in0Var.g());
        }
        qe0.b(str);
    }

    public final void a3(Context context, in0 in0Var, boolean z) {
        String str;
        String str2;
        boolean z2;
        tm0 tm0Var;
        tm0 tm0Var2;
        tm0 tm0Var3;
        if (jl0.a.f()) {
            jl0.e(jl0.a, context, in0Var, null, 4, null);
        } else if (in0Var.q()) {
            if (M2(in0Var)) {
                xm0 xm0Var = in0Var.m;
                String str3 = null;
                if (xm0Var != null && (tm0Var3 = xm0Var.p) != null) {
                    str = tm0Var3.a;
                } else {
                    str = null;
                }
                if (l11.f(str)) {
                    xm0 xm0Var2 = in0Var.m;
                    if (xm0Var2 != null && (tm0Var2 = xm0Var2.p) != null) {
                        str2 = tm0Var2.b;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        qe0.b(str2);
                        return;
                    }
                    xm0 xm0Var3 = in0Var.m;
                    if (xm0Var3 != null && (tm0Var = xm0Var3.p) != null) {
                        str3 = tm0Var.a;
                    }
                    Intrinsics.checkNotNull(str3);
                    df0.b(context, str3);
                    return;
                }
            }
            if (z) {
                N3(this, false, null, null, 6, null);
            } else {
                qe0.b(l11.b(in0Var, in0Var.g()));
            }
        } else if (jl0.a.b(in0Var.f.c)) {
            N3(this, false, null, null, 6, null);
        } else {
            qe0.b(in0Var.f.c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h3() {
        View view2;
        ViewParent viewParent;
        int a2;
        vk0 vk0Var;
        ViewParent viewParent2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ViewParent viewParent3;
        vk0 vk0Var2;
        vk0 vk0Var3;
        View view3;
        ViewParent viewParent4;
        View view4;
        View view5;
        View view6;
        boolean z;
        ViewParent viewParent5;
        R2().removeViewInLayout(this.j0);
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var.i() == null) {
            return;
        }
        vk0 vk0Var4 = (vk0) ServiceManager.getService(vk0.a);
        this.h0 = vk0Var4;
        if (vk0Var4 == null) {
            return;
        }
        if (vk0Var4 != null) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            vk0Var4.b(in0Var2, this);
        }
        vk0 vk0Var5 = this.h0;
        ViewParent viewParent6 = null;
        if (vk0Var5 != null) {
            view2 = vk0Var5.getView();
        } else {
            view2 = null;
        }
        if (view2 == null) {
            return;
        }
        NadRewardFestivalContainer nadRewardFestivalContainer = new NadRewardFestivalContainer(this);
        in0 in0Var3 = this.R;
        if (in0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardFestivalContainer.setData(in0Var3);
        nadRewardFestivalContainer.setVisibility(4);
        nadRewardFestivalContainer.setContainer(P2());
        nadRewardFestivalContainer.setFestivalClickCallback(new j(nadRewardFestivalContainer, this));
        Unit unit = Unit.INSTANCE;
        this.i0 = nadRewardFestivalContainer;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = w11.c.a(this, 10.0f);
        NadRewardFestivalContainer nadRewardFestivalContainer2 = this.i0;
        if (nadRewardFestivalContainer2 != null) {
            viewParent = nadRewardFestivalContainer2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            NadRewardFestivalContainer nadRewardFestivalContainer3 = this.i0;
            if (nadRewardFestivalContainer3 != null) {
                viewParent5 = nadRewardFestivalContainer3.getParent();
            } else {
                viewParent5 = null;
            }
            if (viewParent5 != null) {
                ((ViewGroup) viewParent5).removeView(this.i0);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        LinearLayout linearLayout3 = this.j0;
        if (linearLayout3 == null) {
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.removeAllViews();
            linearLayout4.setOrientation(1);
            linearLayout4.addView(this.i0, layoutParams);
            Unit unit2 = Unit.INSTANCE;
            this.j0 = linearLayout4;
        } else if (linearLayout3 != null) {
            linearLayout3.removeAllViews();
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        AdImageView adImageView = this.z;
        if (adImageView != null) {
            if (adImageView.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a2 = w11.c.a(this, 30.0f);
                layoutParams2.bottomMargin = a2;
                vk0Var = this.h0;
                if (vk0Var == null && (view6 = vk0Var.getView()) != null) {
                    viewParent2 = view6.getParent();
                } else {
                    viewParent2 = null;
                }
                if (viewParent2 instanceof ViewGroup) {
                    vk0 vk0Var6 = this.h0;
                    if (vk0Var6 != null && (view5 = vk0Var6.getView()) != null) {
                        viewParent4 = view5.getParent();
                    } else {
                        viewParent4 = null;
                    }
                    if (viewParent4 != null) {
                        ViewGroup viewGroup = (ViewGroup) viewParent4;
                        vk0 vk0Var7 = this.h0;
                        if (vk0Var7 != null) {
                            view4 = vk0Var7.getView();
                        } else {
                            view4 = null;
                        }
                        viewGroup.removeView(view4);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                }
                linearLayout = this.j0;
                if (linearLayout != null) {
                    vk0 vk0Var8 = this.h0;
                    if (vk0Var8 != null) {
                        view3 = vk0Var8.getView();
                    } else {
                        view3 = null;
                    }
                    linearLayout.addView(view3, layoutParams2);
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = BadgeDrawable.BOTTOM_START;
                linearLayout2 = this.j0;
                if (linearLayout2 == null) {
                    viewParent3 = linearLayout2.getParent();
                } else {
                    viewParent3 = null;
                }
                if (viewParent3 instanceof ViewGroup) {
                    LinearLayout linearLayout5 = this.j0;
                    if (linearLayout5 != null) {
                        viewParent6 = linearLayout5.getParent();
                    }
                    if (viewParent6 != null) {
                        ((ViewGroup) viewParent6).removeView(this.j0);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                }
                R2().addView(this.j0, layoutParams3);
                vk0Var2 = this.h0;
                if (vk0Var2 != null) {
                    vk0Var2.a(new k());
                }
                vk0Var3 = this.h0;
                if (vk0Var3 == null) {
                    vk0Var3.show();
                    return;
                }
                return;
            }
        }
        a2 = w11.c.a(this, 7.0f);
        layoutParams2.bottomMargin = a2;
        vk0Var = this.h0;
        if (vk0Var == null) {
        }
        viewParent2 = null;
        if (viewParent2 instanceof ViewGroup) {
        }
        linearLayout = this.j0;
        if (linearLayout != null) {
        }
        FrameLayout.LayoutParams layoutParams32 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams32.gravity = BadgeDrawable.BOTTOM_START;
        linearLayout2 = this.j0;
        if (linearLayout2 == null) {
        }
        if (viewParent3 instanceof ViewGroup) {
        }
        R2().addView(this.j0, layoutParams32);
        vk0Var2 = this.h0;
        if (vk0Var2 != null) {
        }
        vk0Var3 = this.h0;
        if (vk0Var3 == null) {
        }
    }

    public final void s3() {
        int i2;
        wm0 wm0Var;
        int i3;
        nn0 nn0Var;
        NadRewardVideoAdOverContainer P2 = P2();
        P2.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
        in0 in0Var = this.R;
        if (in0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        boolean z = true;
        if (in0Var.h().C()) {
            in0 in0Var2 = this.R;
            if (in0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = in0Var2.f.c;
            Context context = P2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (u3(str, context)) {
                in0 in0Var3 = this.R;
                if (in0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xm0 xm0Var = in0Var3.m;
                if (xm0Var != null) {
                    xm0Var.g = true;
                }
                in0 in0Var4 = this.R;
                if (in0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ln0 ln0Var = in0Var4.j;
                if (ln0Var != null && (nn0Var = ln0Var.i) != null) {
                    nn0Var.D = true;
                }
            }
        }
        in0 in0Var5 = this.R;
        if (in0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var5.e() != null) {
            in0 in0Var6 = this.R;
            if (in0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            un0 e2 = in0Var6.e();
            if (e2 != null && e2.g()) {
                in0 in0Var7 = this.R;
                if (in0Var7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xm0 xm0Var2 = in0Var7.m;
                if (xm0Var2 != null) {
                    xm0Var2.e = true;
                }
                in0 in0Var8 = this.R;
                if (in0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xm0 xm0Var3 = in0Var8.m;
                if (xm0Var3 != null) {
                    in0 in0Var9 = this.R;
                    if (in0Var9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (in0Var9.q()) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    xm0Var3.a = i3;
                }
                in0 in0Var10 = this.R;
                if (in0Var10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xm0 xm0Var4 = in0Var10.m;
                if (xm0Var4 != null) {
                    in0 in0Var11 = this.R;
                    if (in0Var11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    un0 e3 = in0Var11.e();
                    Intrinsics.checkNotNull(e3);
                    xm0Var4.p = e3.b();
                }
                in0 in0Var12 = this.R;
                if (in0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xm0 xm0Var5 = in0Var12.m;
                if (xm0Var5 != null && (wm0Var = xm0Var5.q) != null) {
                    in0 in0Var13 = this.R;
                    if (in0Var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    wm0Var.d = in0Var13.f.d;
                }
            }
        }
        in0 in0Var14 = this.R;
        if (in0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        P2.setData(in0Var14);
        in0 in0Var15 = this.R;
        if (in0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var15.e() != null) {
            z = false;
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        P2.setVisibility(i2);
        in0 in0Var16 = this.R;
        if (in0Var16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (in0Var16.p()) {
            P2.setBottomLineHeight(w11.c.a(P2.getContext(), 33.0f));
        } else {
            P2.setBottomLineHeight(w11.c.a(P2.getContext(), 10.0f));
        }
        P2.setOnUiClickListener(new n());
        P2.setFeedbackBtnVisibility(false);
        P2.setFestivalClickCallback(new o(P2, this));
    }

    public final void t3() {
        boolean z;
        JSONObject put;
        bq0 bq0Var = new bq0();
        bq0Var.a = 2;
        boolean z2 = false;
        if (this.J == null) {
            this.J = aq0.a.a(this, 0, bq0Var);
        }
        aq0 aq0Var = this.J;
        if (aq0Var != null) {
            aq0Var.attachToContainer(X2());
            q qVar = new q();
            qVar.n(true);
            aq0Var.d(qVar);
            in0 in0Var = this.R;
            if (in0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ln0 ln0Var = in0Var.j;
            if (ln0Var != null && ln0Var.g) {
                aq0Var.setVideoScalingMode(0);
            } else {
                aq0Var.setVideoScalingMode(2);
            }
            aq0Var.a(new p());
        }
        FrameLayout X2 = X2();
        X2.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = 0;
        X2.setLayoutParams(layoutParams);
        in0 in0Var2 = this.R;
        if (in0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        JSONObject jSONObject = null;
        if (in0Var2.j == null) {
            X2().setVisibility(8);
            this.J = null;
            return;
        }
        in0 in0Var3 = this.R;
        if (in0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ln0 ln0Var2 = in0Var3.j;
        Intrinsics.checkNotNull(ln0Var2);
        String str = ln0Var2.j;
        Intrinsics.checkNotNullExpressionValue(str, "adModel.videoInfo!!.videoJson");
        if (str.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject optJSONObject = jSONObject2.optJSONObject(BasicVideoParserKt.EXT_LOG);
                if (optJSONObject != null && (put = optJSONObject.put(BdVideoAd.AD_VIDEO_DAPAGE, ClogBuilder.Page.WELFAREMAXLP.type)) != null) {
                    in0 in0Var4 = this.R;
                    if (in0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    jSONObject = put.put("ad_extra_param", in0Var4.f.d);
                }
                jSONObject2.putOpt(BasicVideoParserKt.EXT_LOG, String.valueOf(jSONObject));
                in0 in0Var5 = this.R;
                if (in0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ln0 ln0Var3 = in0Var5.j;
                Intrinsics.checkNotNull(ln0Var3);
                ln0Var3.j = jSONObject2.toString();
            } catch (Exception unused) {
            }
        }
        aq0 aq0Var2 = this.J;
        if (aq0Var2 != null) {
            in0 in0Var6 = this.R;
            if (in0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ln0 ln0Var4 = in0Var6.j;
            Intrinsics.checkNotNull(ln0Var4);
            aq0Var2.c(ln0Var4);
        }
        if (NetUtil.a(this)) {
            in0 in0Var7 = this.R;
            if (in0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            sn0 c2 = in0Var7.c();
            if (c2 != null) {
                z2 = c2.s();
            }
            aq0 aq0Var3 = this.J;
            if (aq0Var3 != null) {
                aq0Var3.setLooping(!z2);
            }
            aq0 aq0Var4 = this.J;
            if (aq0Var4 != null) {
                aq0Var4.start();
                return;
            }
            return;
        }
        y01.a().a(this, R.string.nad_reward_video_lp_no_network);
    }

    public final boolean u3(String str, Context context) {
        Object m859constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new ve0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m859constructorimpl = Result.m859constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m859constructorimpl = Result.m859constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m865isFailureimpl(m859constructorimpl)) {
            m859constructorimpl = null;
        }
        String str3 = (String) m859constructorimpl;
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str3));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
        if (queryIntentActivities.size() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean z3() {
        Object m859constructorimpl;
        nn0 nn0Var;
        String str;
        nn0 nn0Var2;
        Boolean bool;
        boolean z;
        nn0 nn0Var3;
        Serializable serializable;
        String str2 = null;
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = getIntent();
            if (intent != null) {
                serializable = intent.getSerializableExtra("params");
            } else {
                serializable = null;
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m859constructorimpl = Result.m859constructorimpl(ResultKt.createFailure(th));
        }
        if (serializable != null) {
            m859constructorimpl = Result.m859constructorimpl(kl0.a.d((HashMap) serializable));
            if (Result.m866isSuccessimpl(m859constructorimpl)) {
                in0 in0Var = (in0) m859constructorimpl;
                this.R = in0Var;
                if (in0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ln0 ln0Var = in0Var.j;
                if (ln0Var != null && (nn0Var3 = ln0Var.i) != null) {
                    jl0 jl0Var = jl0.a;
                    String str3 = nn0Var3.f;
                    in0 in0Var2 = this.R;
                    if (in0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    nn0Var3.f = jl0Var.c(str3, in0Var2);
                    jl0 jl0Var2 = jl0.a;
                    String str4 = nn0Var3.g;
                    in0 in0Var3 = this.R;
                    if (in0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    nn0Var3.g = jl0Var2.c(str4, in0Var3);
                }
                in0 in0Var4 = this.R;
                if (in0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                rn0 b2 = in0Var4.b();
                if (b2 != null) {
                    jl0 jl0Var3 = jl0.a;
                    String e2 = b2.e();
                    in0 in0Var5 = this.R;
                    if (in0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    b2.j(jl0Var3.c(e2, in0Var5));
                }
                in0 in0Var6 = this.R;
                if (in0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xm0 xm0Var = in0Var6.m;
                boolean z2 = true;
                if (xm0Var != null) {
                    xm0Var.d = true;
                }
                in0 in0Var7 = this.R;
                if (in0Var7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xm0 xm0Var2 = in0Var7.m;
                if (xm0Var2 != null) {
                    in0 in0Var8 = this.R;
                    if (in0Var8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    sn0 c2 = in0Var8.c();
                    if (c2 != null) {
                        z = c2.f();
                    } else {
                        z = false;
                    }
                    xm0Var2.f = z;
                }
                in0 in0Var9 = this.R;
                if (in0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ln0 ln0Var2 = in0Var9.j;
                if (ln0Var2 != null && (nn0Var2 = ln0Var2.i) != null) {
                    in0 in0Var10 = this.R;
                    if (in0Var10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    sn0 c3 = in0Var10.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.u());
                    } else {
                        bool = null;
                    }
                    nn0Var2.E = bool;
                }
                in0 in0Var11 = this.R;
                if (in0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ln0 ln0Var3 = in0Var11.j;
                if (ln0Var3 != null && (nn0Var = ln0Var3.i) != null) {
                    in0 in0Var12 = this.R;
                    if (in0Var12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    sn0 c4 = in0Var12.c();
                    if (c4 != null) {
                        str = c4.t();
                    } else {
                        str = null;
                    }
                    nn0Var.F = str;
                }
                lk0 lk0Var = (lk0) ServiceManager.getService(lk0.a);
                in0 in0Var13 = this.R;
                if (in0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (in0Var13.h().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && lk0Var != null) {
                    in0 in0Var14 = this.R;
                    if (in0Var14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    do0 h2 = in0Var14.h();
                    String a2 = lk0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    h2.F(a2);
                }
                in0 in0Var15 = this.R;
                if (in0Var15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xm0 xm0Var3 = in0Var15.m;
                if (xm0Var3 != null) {
                    in0 in0Var16 = this.R;
                    if (in0Var16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = in0Var16.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    xm0Var3.h = list;
                }
                in0 in0Var17 = this.R;
                if (in0Var17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                tn0 f2 = in0Var17.h().f();
                if (f2 != null) {
                    str2 = f2.d();
                }
                this.d0 = Intrinsics.areEqual(str2, "0");
            }
            Throwable m862exceptionOrNullimpl = Result.m862exceptionOrNullimpl(m859constructorimpl);
            if (m862exceptionOrNullimpl != null && qc0.a) {
                y01.a().showToast(this, m862exceptionOrNullimpl.getMessage());
            }
            return Result.m866isSuccessimpl(m859constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }
}
