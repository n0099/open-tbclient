package com.baidu.nadcore.lp.reward;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.business.uitemplate.NadEnhanceButtonDownloadView;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper;
import com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView;
import com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder;
import com.baidu.nadcore.lp.reward.view.NadRewardInterceptFrameLayout;
import com.baidu.nadcore.lp.reward.view.NadRewardLottieDialog;
import com.baidu.nadcore.lp.reward.view.NadRewardSuspendDialog;
import com.baidu.nadcore.lp.reward.view.NadRewardVideoAdOverContainer;
import com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog;
import com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.nadcore.videoextra.NadHighLightTextView;
import com.baidu.nadcore.videoextra.NadIconTextButton;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.ExpandIconView;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.R;
import com.baidu.tieba.ar0;
import com.baidu.tieba.b51;
import com.baidu.tieba.bj0;
import com.baidu.tieba.cp0;
import com.baidu.tieba.cr0;
import com.baidu.tieba.dp0;
import com.baidu.tieba.ep0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.g41;
import com.baidu.tieba.gr0;
import com.baidu.tieba.hr0;
import com.baidu.tieba.i51;
import com.baidu.tieba.ir0;
import com.baidu.tieba.j71;
import com.baidu.tieba.jj0;
import com.baidu.tieba.jt0;
import com.baidu.tieba.kj0;
import com.baidu.tieba.ko0;
import com.baidu.tieba.kt0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.nd1;
import com.baidu.tieba.nr0;
import com.baidu.tieba.nt0;
import com.baidu.tieba.o21;
import com.baidu.tieba.oh0;
import com.baidu.tieba.oo0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.or0;
import com.baidu.tieba.ot;
import com.baidu.tieba.p71;
import com.baidu.tieba.po0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.q61;
import com.baidu.tieba.q71;
import com.baidu.tieba.qo0;
import com.baidu.tieba.qr0;
import com.baidu.tieba.r61;
import com.baidu.tieba.rr0;
import com.baidu.tieba.s41;
import com.baidu.tieba.sm0;
import com.baidu.tieba.so0;
import com.baidu.tieba.t01;
import com.baidu.tieba.wi0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.wo0;
import com.baidu.tieba.xo0;
import com.baidu.tieba.xq0;
import com.baidu.tieba.yg0;
import com.baidu.tieba.zm0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\b®\u0001\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0011J\u000f\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u0011J\u000f\u0010\u001d\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001d\u0010\u0011J\u000f\u0010\u001e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u0011J\u000f\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010\u0011J\u000f\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\u0011J\u000f\u0010\"\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010\u0011J\u000f\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b#\u0010\u0011J\u000f\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010\u0011J\u000f\u0010%\u001a\u00020\u000fH\u0002¢\u0006\u0004\b%\u0010\u0011J\u000f\u0010&\u001a\u00020\u000fH\u0002¢\u0006\u0004\b&\u0010\u0011J\u000f\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\b'\u0010\u0011J!\u0010*\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0013H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000fH\u0016¢\u0006\u0004\b.\u0010\u0011J\u000f\u0010/\u001a\u00020\u000fH\u0016¢\u0006\u0004\b/\u0010\u0011J\u0019\u00102\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u000100H\u0014¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u000fH\u0014¢\u0006\u0004\b4\u0010\u0011J\u0019\u00107\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u000105H\u0014¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u000fH\u0014¢\u0006\u0004\b9\u0010\u0011J\u000f\u0010:\u001a\u00020\u000fH\u0014¢\u0006\u0004\b:\u0010\u0011J\u000f\u0010;\u001a\u00020\u000fH\u0002¢\u0006\u0004\b;\u0010\u0011J\u000f\u0010<\u001a\u00020\u0013H\u0002¢\u0006\u0004\b<\u0010-J\u000f\u0010=\u001a\u00020\u000fH\u0002¢\u0006\u0004\b=\u0010\u0011JC\u0010C\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00022\"\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020@j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`AH\u0002¢\u0006\u0004\bC\u0010DJ\u0019\u0010E\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u000100H\u0014¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u000fH\u0002¢\u0006\u0004\bG\u0010\u0011J\u000f\u0010H\u001a\u00020\u000fH\u0002¢\u0006\u0004\bH\u0010\u0011J\u000f\u0010I\u001a\u00020\u000fH\u0002¢\u0006\u0004\bI\u0010\u0011J\u000f\u0010J\u001a\u00020\u000fH\u0002¢\u0006\u0004\bJ\u0010\u0011J\u000f\u0010K\u001a\u00020\u0013H\u0002¢\u0006\u0004\bK\u0010-J\u000f\u0010L\u001a\u00020\u000fH\u0002¢\u0006\u0004\bL\u0010\u0011J\u000f\u0010M\u001a\u00020\u0013H\u0002¢\u0006\u0004\bM\u0010-J\u000f\u0010N\u001a\u00020\u000fH\u0002¢\u0006\u0004\bN\u0010\u0011J\u0017\u0010Q\u001a\u00020\u00132\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0013H\u0002¢\u0006\u0004\bS\u0010-J\u000f\u0010T\u001a\u00020\u0013H\u0002¢\u0006\u0004\bT\u0010-J\u000f\u0010U\u001a\u00020\u000fH\u0002¢\u0006\u0004\bU\u0010\u0011J\u0017\u0010W\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u0002H\u0002¢\u0006\u0004\bW\u0010\u0015J\u000f\u0010X\u001a\u00020\u000fH\u0002¢\u0006\u0004\bX\u0010\u0011R\u001d\u0010^\u001a\u00020Y8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b`\u0010aR\u001d\u0010f\u001a\u00020b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010[\u001a\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u001d\u0010q\u001a\u00020m8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010[\u001a\u0004\bo\u0010pR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010v\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010z\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010wR\u0018\u0010|\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010~\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010\u007fR\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0082\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001a\u0010\u008e\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u0082\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0090\u0001R\u001c\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R \u0010¢\u0001\u001a\u00020m8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b \u0001\u0010[\u001a\u0005\b¡\u0001\u0010pR\u001a\u0010£\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b£\u0001\u0010\u007fR\"\u0010¨\u0001\u001a\u00030¤\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¥\u0001\u0010[\u001a\u0006\b¦\u0001\u0010§\u0001R\"\u0010\u00ad\u0001\u001a\u00030©\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bª\u0001\u0010[\u001a\u0006\b«\u0001\u0010¬\u0001¨\u0006¯\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/NadRewardVideoActivity;", "Lcom/baidu/nadcore/appframework/BaseActivity;", "", "dialogDataJson", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "buildDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "rewardDataJson", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "buildLottieDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "suspendCmd", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "buildSuspendDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "", "chargeClick", "()V", "scheme", "", "checkRewardPanelPop", "(Ljava/lang/String;)Z", "suspendDialogShowMoment", "checkShowSuspendMoment", "computeDailyRewardShownIndex", "finish", "getSessionInfo", "()Ljava/lang/String;", "init", "initBottomArrow", "initCloseIcon", "initCountDownView", "initRewardTask", "initSessionCountByTime", "initSvButton", "initSvTitle", "initTailFrame", "initTopTag", "initUserInfoContainer", "initVideoPlayer", "Landroid/content/Context;", "context", "isAppInstalled", "(Ljava/lang/String;Landroid/content/Context;)Z", "isDialogShowing", "()Z", "onAttachedToWindow", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreateEx", "(Landroid/os/Bundle;)V", "onDestroyEx", "Landroid/content/Intent;", IntentData.KEY, "onNewIntentEx", "(Landroid/content/Intent;)V", "onPauseEx", "onResumeEx", "onTaskComplete", "parseData", "pauseVideoPlayAndCountDown", "status", "message", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "postRewardVideoNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "preCreate", "(Landroid/os/Bundle;)Z", "recomputeCountDownSecond", "registerBackForegroundEvent", "resetStatus", "resumeVideoPlayAndCountDown", "showDialog", "showImageStylePage", "showLottieDialog", "showPanelPop", "", "remainSecond", "showRetainDialog", "(J)Z", "showRewardDialog", "showSuspendDialog", "showSuspendDialogDelay", "cmd", "showTaskDialog", "triggerTask", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer$delegate", "Lkotlin/Lazy;", "getAdInfoContainer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/uiwidget/ExpandIconView;", "arrowView$delegate", "getArrowView", "()Lcom/baidu/nadcore/widget/uiwidget/ExpandIconView;", "arrowView", "Lcom/baidu/nadcore/widget/AdImageView;", "closeIcon", "Lcom/baidu/nadcore/widget/AdImageView;", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "countDownView", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Landroid/widget/FrameLayout;", "flRootView$delegate", "getFlRootView", "()Landroid/widget/FrameLayout;", "flRootView", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "imageStylePanelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "lottieDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "panelPop", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "retainDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "rewardCount", "I", "rewardDialog", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardResponse", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardShownIndex", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "rewardTaskHelper", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "", "screenHW", "F", "sessionCount", "shouldCharge", "Z", "Ljava/lang/Runnable;", "shouldChargeTask", "Ljava/lang/Runnable;", "suspendDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "suspendDialogShown", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "svButton", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "svTitle", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "tailFrame", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "tailFrameContainer$delegate", "getTailFrameContainer", "tailFrameContainer", "taskDialog", "Landroid/widget/ImageView;", "topTag$delegate", "getTopTag", "()Landroid/widget/ImageView;", "topTag", "Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "videoContainer$delegate", "getVideoContainer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "videoContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardVideoActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy A;
    public AbsRewardCountDownView B;
    public so0 C;
    public j71 D;
    public j71 E;
    public NadHighLightTextView F;
    public NadIconTextButton G;
    public jt0 H;
    public NadRewardVideoDialog I;
    public NadRewardVideoDialog J;
    public NadRewardVideoDialog K;
    public NadRewardSuspendDialog L;
    public NadRewardLottieDialog M;
    public xq0 N;
    public po0 O;
    public float P;
    public int Q;
    public int R;
    public int S;
    public boolean T;
    public NadRewardTaskHelper U;
    public Handler V;
    public boolean W;
    public Runnable X;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public AdImageView z;

    public final NadRewardVideoAdOverContainer D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (NadRewardVideoAdOverContainer) this.w.getValue() : (NadRewardVideoAdOverContainer) invokeV.objValue;
    }

    public final ExpandIconView E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (ExpandIconView) this.y.getValue() : (ExpandIconView) invokeV.objValue;
    }

    public final FrameLayout F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (FrameLayout) this.u.getValue() : (FrameLayout) invokeV.objValue;
    }

    public final FrameLayout H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (FrameLayout) this.x.getValue() : (FrameLayout) invokeV.objValue;
    }

    public final ImageView I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (ImageView) this.A.getValue() : (ImageView) invokeV.objValue;
    }

    public final NadRewardInterceptFrameLayout J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (NadRewardInterceptFrameLayout) this.v.getValue() : (NadRewardInterceptFrameLayout) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static final class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public l(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoAdOverContainer, nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        /* loaded from: classes2.dex */
        public static final class a implements cp0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // com.baidu.tieba.cp0.a
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                    ep0.i(NadRewardVideoActivity.X1(this.a.b).f.d, "4");
                    Toast.makeText(this.a.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
                }
            }

            @Override // com.baidu.tieba.cp0.a
            public void a(ir0 ir0Var) {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ir0Var) == null) {
                    NadRewardVideoActivity.X1(this.a.b).f().E(ir0Var);
                    String str2 = null;
                    if (ir0Var != null) {
                        str = ir0Var.f();
                    } else {
                        str = null;
                    }
                    if (!Intrinsics.areEqual(str, "1")) {
                        this.a.b.i3();
                        String str3 = NadRewardVideoActivity.X1(this.a.b).f.d;
                        if (ir0Var != null) {
                            str2 = ir0Var.a();
                        }
                        ep0.j(str3, "4", str2);
                        return;
                    }
                    this.a.a.setFestivalEntranceContainerInvisible();
                    Toast.makeText(this.a.b, ir0Var.d(), 0).show();
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (NadRewardVideoActivity.X1(this.b).f().k() != null) {
                    ir0 k = NadRewardVideoActivity.X1(this.b).f().k();
                    Intrinsics.checkNotNull(k);
                    if (Intrinsics.areEqual(k.f(), "1")) {
                        NadRewardVideoActivity nadRewardVideoActivity = this.b;
                        ir0 k2 = NadRewardVideoActivity.X1(nadRewardVideoActivity).f().k();
                        Intrinsics.checkNotNull(k2);
                        Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                        return;
                    }
                    this.b.i3();
                    return;
                }
                cp0 cp0Var = cp0.a;
                nr0 f = NadRewardVideoActivity.X1(this.b).f();
                or0 m = NadRewardVideoActivity.X1(this.b).f().m();
                if (m != null) {
                    str = m.b();
                } else {
                    str = null;
                }
                cp0Var.d(f, str, new a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class q extends wm0<zm0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity b;

        /* loaded from: classes2.dex */
        public static final class a implements cp0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
            }

            @Override // com.baidu.tieba.cp0.a
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                    ep0.i(NadRewardVideoActivity.X1(this.a.b).f.d, "5");
                    Toast.makeText(this.a.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
                }
            }

            @Override // com.baidu.tieba.cp0.a
            public void a(ir0 ir0Var) {
                String str;
                String str2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ir0Var) == null) {
                    this.a.b.D2().setFestivalEntranceContainerInvisible();
                    NadRewardVideoActivity nadRewardVideoActivity = this.a.b;
                    String str3 = null;
                    if (ir0Var != null) {
                        str = ir0Var.d();
                    } else {
                        str = null;
                    }
                    Toast.makeText(nadRewardVideoActivity, str, 0).show();
                    if (ir0Var != null) {
                        str2 = ir0Var.f();
                    } else {
                        str2 = null;
                    }
                    if (!Intrinsics.areEqual(str2, "1")) {
                        String str4 = NadRewardVideoActivity.X1(this.a.b).f.d;
                        if (ir0Var != null) {
                            str3 = ir0Var.a();
                        }
                        ep0.j(str4, "5", str3);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(NadRewardVideoActivity nadRewardVideoActivity, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nadRewardVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wm0
        public void onEvent(zm0 event) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.a && NadRewardVideoActivity.X1(this.b).g().b()) {
                    cp0 cp0Var = cp0.a;
                    nr0 f = NadRewardVideoActivity.X1(this.b).f();
                    ir0 k = NadRewardVideoActivity.X1(this.b).f().k();
                    if (k != null) {
                        str = k.b();
                    } else {
                        str = null;
                    }
                    cp0Var.d(f, str, new a(this));
                    NadRewardVideoActivity.X1(this.b).g().f(false);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public a(NadRewardVideoActivity nadRewardVideoActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements NadRewardVideoDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public b(NadRewardVideoActivity nadRewardVideoActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.a
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.z2();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoDialog a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public c(NadRewardVideoDialog nadRewardVideoDialog, NadRewardVideoActivity nadRewardVideoActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoDialog, nadRewardVideoActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoDialog;
            this.b = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            oh0 oh0Var;
            lq0 lq0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (NadRewardVideoActivity.X1(this.b).c() != null) {
                    hr0 c = NadRewardVideoActivity.X1(this.b).c();
                    Intrinsics.checkNotNull(c);
                    oh0Var = new oh0(c.b());
                } else {
                    pq0 pq0Var = NadRewardVideoActivity.X1(this.b).m;
                    if (pq0Var != null) {
                        lq0Var = pq0Var.p;
                    } else {
                        lq0Var = null;
                    }
                    oh0Var = new oh0(lq0Var);
                }
                sm0.a().a(oh0Var);
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public d(NadRewardVideoActivity nadRewardVideoActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements NadRewardVideoDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public e(NadRewardVideoActivity nadRewardVideoActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.a
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.z2();
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public f(NadRewardVideoActivity nadRewardVideoActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements NadRewardVideoDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public g(NadRewardVideoActivity nadRewardVideoActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.a
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.z2();
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public h(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.j3();
            ep0.f(NadRewardVideoActivity.X1(this.a));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public i(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str2 = NadRewardVideoActivity.X1(this.a).f.d;
                po0 po0Var = this.a.O;
                if (po0Var != null) {
                    str = po0Var.d();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                ep0.n(str2, !z);
                if (this.a.g3()) {
                    return;
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;
        public final /* synthetic */ r61 b;

        public j(NadRewardVideoActivity nadRewardVideoActivity, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
            this.b = r61Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ep0.p(NadRewardVideoActivity.X1(this.a));
                if (!this.a.A2(this.b.c)) {
                    if (Intrinsics.areEqual(this.b.c, "__CONVERT_CMD__")) {
                        if (NadRewardVideoActivity.X1(this.a).l()) {
                            wi0.c(NadRewardVideoActivity.X1(this.a).e(), this.a);
                            return;
                        }
                        String str2 = null;
                        if (NadRewardVideoActivity.X1(this.a).k()) {
                            NadRewardVideoActivity nadRewardVideoActivity = this.a;
                            pq0 pq0Var = NadRewardVideoActivity.X1(nadRewardVideoActivity).m;
                            if (pq0Var != null) {
                                str = pq0Var.t;
                            } else {
                                str = null;
                            }
                            if (nadRewardVideoActivity.A2(str)) {
                                this.a.j3();
                                return;
                            }
                        }
                        pq0 pq0Var2 = NadRewardVideoActivity.X1(this.a).m;
                        if (pq0Var2 != null) {
                            str2 = pq0Var2.t;
                        }
                        wi0.c(str2, this.a);
                        return;
                    }
                    wi0.c(this.b.c, this.a);
                    return;
                }
                this.a.j3();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public k(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoAdOverContainer, nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            pq0 pq0Var;
            lq0 lq0Var;
            String str;
            boolean z;
            String str2;
            String str3;
            lq0 lq0Var2;
            lq0 lq0Var3;
            lq0 lq0Var4;
            lq0 lq0Var5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (NadRewardVideoActivity.X1(this.b).k()) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    if (nadRewardVideoActivity.A2(NadRewardVideoActivity.X1(nadRewardVideoActivity).f.c)) {
                        this.b.j3();
                    }
                }
                if (NadRewardVideoActivity.X1(this.b).l() && (pq0Var = NadRewardVideoActivity.X1(this.b).m) != null && (lq0Var = pq0Var.p) != null && lq0Var.e) {
                    pq0 pq0Var2 = NadRewardVideoActivity.X1(this.b).m;
                    String str4 = null;
                    if (pq0Var2 != null && (lq0Var5 = pq0Var2.p) != null) {
                        str = lq0Var5.b;
                    } else {
                        str = null;
                    }
                    boolean z2 = false;
                    if (str != null && str.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        pq0 pq0Var3 = NadRewardVideoActivity.X1(this.b).m;
                        if (pq0Var3 != null && (lq0Var4 = pq0Var3.p) != null) {
                            str2 = lq0Var4.a;
                        } else {
                            str2 = null;
                        }
                        if (!((str2 == null || str2.length() == 0) ? true : true)) {
                            pq0 pq0Var4 = NadRewardVideoActivity.X1(this.b).m;
                            if (pq0Var4 != null && (lq0Var3 = pq0Var4.p) != null) {
                                str3 = lq0Var3.a;
                            } else {
                                str3 = null;
                            }
                            if (s41.d(str3)) {
                                Context context = this.a.getContext();
                                pq0 pq0Var5 = NadRewardVideoActivity.X1(this.b).m;
                                if (pq0Var5 != null && (lq0Var2 = pq0Var5.p) != null) {
                                    str4 = lq0Var2.a;
                                }
                                Intrinsics.checkNotNull(str4);
                                jj0.b(context, str4);
                            }
                        }
                    }
                    wi0.b(s41.b(NadRewardVideoActivity.X1(this.b), NadRewardVideoActivity.X1(this.b).e()));
                }
                this.b.z2();
                NadRewardVideoActivity.X1(this.b).g().e(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class m extends nt0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public m(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // com.baidu.tieba.nt0, com.baidu.tieba.gt0
        public void onEnd(int i) {
            String str;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                so0 so0Var = this.a.C;
                if (so0Var != null) {
                    so0Var.setVisibility(true);
                }
                AbsRewardCountDownView absRewardCountDownView = this.a.B;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.bringToFront();
                }
                AdImageView adImageView = this.a.z;
                if (adImageView != null) {
                    adImageView.bringToFront();
                }
                NadRewardVideoActivity.X1(this.a).g().i(true);
                String str2 = NadRewardVideoActivity.X1(this.a).f.d;
                po0 po0Var = this.a.O;
                String str3 = null;
                if (po0Var != null) {
                    str = po0Var.f();
                } else {
                    str = null;
                }
                ar0 ar0Var = NadRewardVideoActivity.X1(this.a).j;
                if (ar0Var != null && (cr0Var = ar0Var.h) != null) {
                    str3 = cr0Var.a;
                }
                ep0.r(str2, str, str3);
            }
        }

        @Override // com.baidu.tieba.nt0, com.baidu.tieba.gt0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                so0 so0Var = this.a.C;
                if (so0Var != null) {
                    so0Var.setVisibility(false);
                }
                AbsRewardCountDownView absRewardCountDownView = this.a.B;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.bringToFront();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class n extends t01 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
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

        @Override // com.baidu.tieba.t01, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (xo0.a().a()) {
                    return 2;
                }
                return 1;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public o(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.F2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = this.a;
                nadRewardVideoActivity.P = nadRewardVideoActivity.F2().getMeasuredHeight() / this.a.F2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class p implements wo0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public p(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // com.baidu.tieba.wo0.b
        public void a(po0 po0Var) {
            boolean z;
            AdDownloadStatus adDownloadStatus;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, po0Var) != null) {
                return;
            }
            this.a.O = po0Var;
            if (po0Var == null) {
                return;
            }
            boolean z2 = true;
            this.a.R++;
            if (po0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = this.a.B;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.e(NadRewardVideoActivity.X1(this.a).f().b(po0Var.d()));
                }
                ep0.d(NadRewardVideoActivity.X1(this.a).f.d, po0Var.d(), this.a.G2(), po0Var.f(), po0Var.h());
                if (po0Var.h().length() <= 0) {
                    z2 = false;
                }
                if (z2) {
                    ep0.s(NadRewardVideoActivity.X1(this.a).f.d, "2", po0Var.h());
                }
            }
            ep0.g(NadRewardVideoActivity.X1(this.a).f.d, "1", po0Var.d());
            NadRewardVideoActivity.X1(this.a).g().j(po0Var.c());
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.X1(this.a).f().t());
            this.a.b3("0", "任务完成回调", hashMap);
            nd1<View> transitionButtonView = this.a.D2().getTransitionButtonView();
            Intrinsics.checkNotNullExpressionValue(transitionButtonView, "adInfoContainer.transitionButtonView");
            View realView = transitionButtonView.getRealView();
            if (!(realView instanceof NadEnhanceButtonDownloadView)) {
                realView = null;
            }
            NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = (NadEnhanceButtonDownloadView) realView;
            if (nadEnhanceButtonDownloadView == null || (adDownloadStatus = nadEnhanceButtonDownloadView.getDownloadStatus()) == null) {
                adDownloadStatus = AdDownloadStatus.NONE;
            }
            Intrinsics.checkNotNullExpressionValue(adDownloadStatus, "(adInfoContainer.transit… ?: AdDownloadStatus.NONE");
            NadRewardTaskHelper nadRewardTaskHelper = this.a.U;
            if (nadRewardTaskHelper != null) {
                String str = NadRewardVideoActivity.X1(this.a).f.d;
                Intrinsics.checkNotNullExpressionValue(str, "adModel.common.extraParam");
                nadRewardTaskHelper.t(po0Var, adDownloadStatus, str);
            }
        }

        @Override // com.baidu.tieba.wo0.b
        public void onFail(Exception e) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.a.O = null;
                NadRewardVideoActivity.X1(this.a).g().j(false);
                ep0.k(NadRewardVideoActivity.X1(this.a).f.d, "1");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public r(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.W = true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class s implements p71 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ NadRewardVideoActivity b;
        public final /* synthetic */ long c;

        @Override // com.baidu.tieba.p71
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.tieba.p71
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        public s(Boolean bool, NadRewardVideoActivity nadRewardVideoActivity, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bool, nadRewardVideoActivity, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bool;
            this.b = nadRewardVideoActivity;
            this.c = j;
        }

        @Override // com.baidu.tieba.p71
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
                if (Intrinsics.areEqual(this.a, Boolean.TRUE) && this.b.W) {
                    xq0 X1 = NadRewardVideoActivity.X1(this.b);
                    String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                    Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                    ep0.m(X1, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                    return;
                }
                xq0 X12 = NadRewardVideoActivity.X1(this.b);
                String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                ep0.m(X12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
            }
        }

        @Override // com.baidu.tieba.p71
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
                if (this.b.W) {
                    xq0 X1 = NadRewardVideoActivity.X1(this.b);
                    String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                    Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                    ep0.m(X1, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                    return;
                }
                xq0 X12 = NadRewardVideoActivity.X1(this.b);
                String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                ep0.m(X12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
            }
        }

        @Override // com.baidu.tieba.p71
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.g3();
            }
        }

        @Override // com.baidu.tieba.p71
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.g3();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class t implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public t(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            jt0 jt0Var = this.a.H;
            if (jt0Var != null) {
                jt0Var.resume();
            }
            AdImageView adImageView = this.a.z;
            if (adImageView != null) {
                ExtensionsKt.e(adImageView, true);
            }
        }
    }

    public NadRewardVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$flRootView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardVideoActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.fl_root);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fl_root)");
                    return (FrameLayout) findViewById;
                }
                return (FrameLayout) invokeV.objValue;
            }
        });
        this.v = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardInterceptFrameLayout>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$videoContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardVideoActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NadRewardInterceptFrameLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.fl_video_container);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fl_video_container)");
                    return (NadRewardInterceptFrameLayout) findViewById;
                }
                return (NadRewardInterceptFrameLayout) invokeV.objValue;
            }
        });
        this.w = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardVideoAdOverContainer>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$adInfoContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardVideoActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NadRewardVideoAdOverContainer invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.ad_info_container);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_info_container)");
                    return (NadRewardVideoAdOverContainer) findViewById;
                }
                return (NadRewardVideoAdOverContainer) invokeV.objValue;
            }
        });
        this.x = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$tailFrameContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardVideoActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.tail_frame_container);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tail_frame_container)");
                    return (FrameLayout) findViewById;
                }
                return (FrameLayout) invokeV.objValue;
            }
        });
        this.y = LazyKt__LazyJVMKt.lazy(new Function0<ExpandIconView>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$arrowView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardVideoActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpandIconView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.iv_arrow);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_arrow)");
                    return (ExpandIconView) findViewById;
                }
                return (ExpandIconView) invokeV.objValue;
            }
        });
        this.A = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$topTag$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardVideoActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.top_tag);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.top_tag)");
                    return (ImageView) findViewById;
                }
                return (ImageView) invokeV.objValue;
            }
        });
        this.S = 1;
        this.X = new r(this);
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.z == null) {
                this.z = new AdImageView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = BadgeDrawable.TOP_END;
                layoutParams.setMarginEnd(b51.c.a(this, 5.0f));
                layoutParams.height = b51.c.a(this, 39.0f);
                layoutParams.width = b51.c.a(this, 39.0f);
                F2().addView(this.z, layoutParams);
            }
            AdImageView adImageView = this.z;
            if (adImageView != null) {
                int a2 = b51.c.a(adImageView.getContext(), 10.0f);
                adImageView.setPadding(a2, a2, a2, a2);
                adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
                adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                adImageView.setOnClickListener(new i(this));
            }
        }
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.B == null) {
                NadVideoRewardCountDownView nadVideoRewardCountDownView = new NadVideoRewardCountDownView(this, null, 0, 6, null);
                AbsRewardCountDownView.b(nadVideoRewardCountDownView, F2(), 0, false, null, 14, null);
                Unit unit = Unit.INSTANCE;
                this.B = nadVideoRewardCountDownView;
            }
            AbsRewardCountDownView absRewardCountDownView = this.B;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
            AbsRewardCountDownView absRewardCountDownView2 = this.B;
            if (absRewardCountDownView2 != null) {
                absRewardCountDownView2.d();
            }
            AbsRewardCountDownView absRewardCountDownView3 = this.B;
            if (absRewardCountDownView3 != null) {
                xq0 xq0Var = this.N;
                if (xq0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                int s2 = xq0Var.f().s();
                xq0 xq0Var2 = this.N;
                if (xq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(s2, xq0Var2.f(), new Function0<Unit>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NadRewardVideoActivity this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
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
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.this$0.Y2();
                        }
                    }
                });
            }
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            r61 a2 = r61.a(xq0Var.i());
            if (a2 != null && !TextUtils.isEmpty(a2.b)) {
                if (this.G == null) {
                    this.G = new NadIconTextButton(this);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = (((b51.c.e(this) * 9) / 16) / 2) + b51.c.a(this, 26.0f);
                    F2().addView(this.G, layoutParams);
                }
                NadIconTextButton nadIconTextButton = this.G;
                if (nadIconTextButton != null) {
                    nadIconTextButton.update(a2);
                    nadIconTextButton.setOnClickListener(new j(this, a2));
                    nadIconTextButton.setVisibility(0);
                    return;
                }
                return;
            }
            NadIconTextButton nadIconTextButton2 = this.G;
            if (nadIconTextButton2 != null) {
                ExtensionsKt.e(nadIconTextButton2, false);
            }
        }
    }

    public final void c3() {
        long j2;
        int i2;
        String d2;
        Integer intOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qr0 p2 = xq0Var.f().p();
            if (p2 != null && p2.f() != null) {
                xq0 xq0Var2 = this.N;
                if (xq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qr0 p3 = xq0Var2.f().p();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                AbsRewardCountDownView absRewardCountDownView = this.B;
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
                AbsRewardCountDownView absRewardCountDownView2 = this.B;
                if (absRewardCountDownView2 != null) {
                    absRewardCountDownView2.d();
                }
                AbsRewardCountDownView absRewardCountDownView3 = this.B;
                if (absRewardCountDownView3 != null) {
                    xq0 xq0Var3 = this.N;
                    if (xq0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    absRewardCountDownView3.setData(i3, xq0Var3.f(), new Function0<Unit>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ NadRewardVideoActivity this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
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
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.this$0.Y2();
                            }
                        }
                    });
                }
            }
        }
    }

    public final boolean l3() {
        InterceptResult invokeV;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            po0 po0Var = this.O;
            if (po0Var != null && po0Var.c()) {
                return false;
            }
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nr0 f2 = xq0Var.f();
            po0 po0Var2 = this.O;
            if (po0Var2 != null) {
                str = po0Var2.e();
            } else {
                str = null;
            }
            String l2 = f2.l(str);
            if (l2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z || Intrinsics.areEqual(l2, StringUtil.EMPTY_ARRAY)) {
                return false;
            }
            NadRewardVideoDialog w2 = w2(l2);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            w2.show(supportFragmentManager, (String) null);
            this.K = w2;
            a3();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean m3() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        String f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qr0 p2 = xq0Var.f().p();
            if (p2 == null || p2.f() == null || this.T) {
                return false;
            }
            j71 j71Var = this.D;
            if (j71Var != null && j71Var.isShowing()) {
                return false;
            }
            xq0 xq0Var2 = this.N;
            if (xq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qr0 p3 = xq0Var2.f().p();
            if (p3 != null && (f2 = p3.f()) != null) {
                jSONObject = ExtensionsKt.a(f2);
            } else {
                jSONObject = null;
            }
            NadRewardSuspendDialog y2 = y2(String.valueOf(jSONObject));
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            y2.show(supportFragmentManager, (String) null);
            this.T = true;
            this.L = y2;
            a3();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n3() {
        String str;
        String c2;
        Integer intOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            int i2 = 0;
            this.T = false;
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qr0 p2 = xq0Var.f().p();
            if (p2 != null && p2.f() != null) {
                xq0 xq0Var2 = this.N;
                if (xq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                final qr0 p3 = xq0Var2.f().p();
                if (p3 != null) {
                    str = p3.b();
                } else {
                    str = null;
                }
                if (!B2(str)) {
                    AbsRewardCountDownView absRewardCountDownView = this.B;
                    if (absRewardCountDownView != null) {
                        absRewardCountDownView.setSuspendShowTime(-1);
                    }
                    AbsRewardCountDownView absRewardCountDownView2 = this.B;
                    if (absRewardCountDownView2 != null) {
                        absRewardCountDownView2.setSuspendShowCallback(null);
                        return;
                    }
                    return;
                }
                xq0 xq0Var3 = this.N;
                if (xq0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                int s2 = xq0Var3.f().s();
                if (p3 != null && (c2 = p3.c()) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(c2)) != null) {
                    i2 = intOrNull.intValue();
                }
                AbsRewardCountDownView absRewardCountDownView3 = this.B;
                if (absRewardCountDownView3 != null) {
                    absRewardCountDownView3.g(s2 - i2, new Function0<Unit>(this, p3) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$showSuspendDialogDelay$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ qr0 $suspendDialogData;
                        public final /* synthetic */ NadRewardVideoActivity this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, p3};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.$suspendDialogData = p3;
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
                            boolean m3;
                            String str2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                m3 = this.this$0.m3();
                                if (m3) {
                                    String str3 = NadRewardVideoActivity.X1(this.this$0).f.d;
                                    String valueOf = String.valueOf(NadRewardVideoActivity.X1(this.this$0).g().c());
                                    qr0 qr0Var = this.$suspendDialogData;
                                    if (qr0Var != null) {
                                        str2 = qr0Var.b();
                                    } else {
                                        str2 = null;
                                    }
                                    ep0.h(str3, "3", valueOf, str2);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public static final /* synthetic */ xq0 X1(NadRewardVideoActivity nadRewardVideoActivity) {
        xq0 xq0Var = nadRewardVideoActivity.N;
        if (xq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return xq0Var;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void A1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            super.A1(intent);
            setIntent(intent);
            if (!Z2()) {
                g41.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
                return;
            }
            K2();
            h3();
        }
    }

    public final boolean A2(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z || !kj0.o(str)) {
                return false;
            }
            return Intrinsics.areEqual(new bj0(str).a(), "rewardWebPanel");
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean I1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundle)) == null) {
            if (!super.I1(bundle)) {
                return false;
            }
            getWindow().setSoftInputMode(19);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            setEnableSliding(false);
            setCurrentActivityNoTransparent();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean o3(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return false;
            }
            NadRewardVideoDialog w2 = w2(str);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            w2.show(supportFragmentManager, (String) null);
            this.I = w2;
            a3();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void y1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            super.y1(bundle);
            setContentView(R.layout.nad_reward_video_lp_activity);
            F2().post(new o(this));
            this.V = new Handler(Looper.getMainLooper());
            if (!Z2()) {
                finish();
                return;
            }
            P2();
            K2();
        }
    }

    public final boolean B2(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z || !StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null).contains(String.valueOf(this.S))) {
                return false;
            }
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            xq0Var.g().h(this.S);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean k3(long j2) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048617, this, j2)) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (xq0Var.f().o().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return false;
            }
            xq0 xq0Var2 = this.N;
            if (xq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            NadRewardVideoDialog w2 = w2(xq0Var2.f().n(j2));
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            w2.show(supportFragmentManager, (String) null);
            this.J = w2;
            a3();
            return true;
        }
        return invokeJ.booleanValue;
    }

    public final NadRewardLottieDialog x2(final String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
            d3();
            NadRewardLottieDialog nadRewardLottieDialog = new NadRewardLottieDialog();
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str2 = xq0Var.f.d;
            Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
            nadRewardLottieDialog.d2(str, str2);
            xq0 xq0Var2 = this.N;
            if (xq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardLottieDialog.s2(xq0Var2.f().k());
            nadRewardLottieDialog.b2(new d(this, str));
            nadRewardLottieDialog.g2(new Function0<Unit>(this, str) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $rewardDataJson$inlined;
                public final /* synthetic */ NadRewardVideoActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$rewardDataJson$inlined = str;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.f3();
                    }
                }
            });
            nadRewardLottieDialog.Z1(new e(this, str));
            nadRewardLottieDialog.i2(new Function0<Unit>(this, str) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $rewardDataJson$inlined;
                public final /* synthetic */ NadRewardVideoActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$rewardDataJson$inlined = str;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        NadRewardVideoActivity.X1(this.this$0).g().f(true);
                    }
                }
            });
            return nadRewardLottieDialog;
        }
        return (NadRewardLottieDialog) invokeL.objValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.C1();
            AbsRewardCountDownView absRewardCountDownView = this.B;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.f();
            }
            jt0 jt0Var = this.H;
            if (jt0Var != null) {
                jt0Var.pause();
            }
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int a2 = i51.a("nad_reward_sp", "key_reward_shown_index", 1);
            this.S = a2;
            i51.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.F1();
            if (X2()) {
                return;
            }
            f3();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0009: IGET  (r1v2 int A[REMOVE]) = (r4v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.Q int), ('_' char), (wrap: int : 0x0013: IGET  (r1v4 int A[REMOVE]) = (r4v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.R int)] */
    public final String G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.Q);
            sb.append('_');
            sb.append(this.R);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…d(rewardCount).toString()");
            return sb2;
        }
        return (String) invokeV.objValue;
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.U == null) {
                this.U = new NadRewardTaskHelper();
            }
            NadRewardTaskHelper nadRewardTaskHelper = this.U;
            if (nadRewardTaskHelper != null) {
                xq0 xq0Var = this.N;
                if (xq0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                nadRewardTaskHelper.H(xq0Var);
            }
        }
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int a2 = i51.a("nad_reward_sp", "key_session_count", 1);
            this.Q = a2;
            i51.e("nad_reward_sp", "key_session_count", a2 + 1);
        }
    }

    public final void T2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ImageView I2 = I2();
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (xq0Var.c() != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                I2.setVisibility(0);
            } else {
                I2.setVisibility(8);
            }
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            wo0 b2 = xo0.b();
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            b2.a(xq0Var, new mr0(this.Q, this.R), new p(this));
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            jt0 jt0Var = this.H;
            if (jt0Var != null) {
                jt0Var.pause();
            }
            AbsRewardCountDownView absRewardCountDownView = this.B;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.f();
            }
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            sm0.a().b(this, new q(this, zm0.class));
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.O = null;
            this.W = false;
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onAttachedToWindow();
            h3();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            j71 j71Var = this.D;
            if ((j71Var != null && j71Var.isShowing()) || g3()) {
                return;
            }
            super.onBackPressed();
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ep0.o(xq0Var);
            C2();
            xq0 xq0Var2 = this.N;
            if (xq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            wi0.c(xq0Var2.f.m, this);
            n3();
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            e3();
            T2();
            L2();
            N2();
            V2();
            U2();
            M2();
            R2();
            Q2();
            S2();
            O2();
            p3();
        }
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ExpandIconView E2 = E2();
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fr0 b2 = xq0Var.b();
            boolean z = true;
            if ((b2 == null || !b2.b()) ? false : false) {
                E2.setVisibility(0);
            } else {
                E2.setVisibility(8);
                E2 = null;
            }
            if (E2 != null) {
                E2.setOnClickListener(new h(this));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
        if (r0 != true) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f3() {
        ViewGroup view2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            j71 j71Var = this.D;
            if (j71Var == null || !j71Var.isShowing()) {
                so0 so0Var = this.C;
                if (so0Var != null && (view2 = so0Var.getView()) != null) {
                    if (view2.getVisibility() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                jt0 jt0Var = this.H;
                if (jt0Var != null) {
                    jt0Var.resume();
                }
            }
            AbsRewardCountDownView absRewardCountDownView = this.B;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.c();
            }
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var != null) {
                if (xq0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                gr0 f2 = xq0Var.f().f();
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
                    wi0.c(str, this);
                }
            }
            super.finish();
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            q61 a2 = q61.a(xq0Var.j());
            if (a2 != null && !TextUtils.isEmpty(a2.a)) {
                if (this.F == null) {
                    this.F = new NadHighLightTextView(this);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 17;
                    layoutParams.bottomMargin = (((b51.c.e(this) * 9) / 16) / 2) + b51.c.a(this, 52.0f);
                    layoutParams.setMarginStart(b51.c.a(this, 9.0f));
                    layoutParams.setMarginEnd(b51.c.a(this, 8.0f));
                    F2().addView(this.F, layoutParams);
                }
                NadHighLightTextView nadHighLightTextView = this.F;
                if (nadHighLightTextView != null) {
                    nadHighLightTextView.setLineSpacing(b51.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
                    nadHighLightTextView.setAlpha(0.8f);
                    nadHighLightTextView.setGravity(17);
                    nadHighLightTextView.update(a2);
                    nadHighLightTextView.setVisibility(0);
                    return;
                }
                return;
            }
            NadHighLightTextView nadHighLightTextView2 = this.F;
            if (nadHighLightTextView2 != null) {
                ExtensionsKt.e(nadHighLightTextView2, false);
            }
        }
    }

    public final void j3() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (xq0Var.d().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.D = null;
                return;
            }
            j71 j71Var = this.D;
            if (j71Var != null && j71Var.isShowing()) {
                return;
            }
            j71 j71Var2 = new j71(this);
            j71Var2.setOnDismissListener(new t(this));
            xq0 xq0Var2 = this.N;
            if (xq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String d2 = xq0Var2.d();
            xq0 xq0Var3 = this.N;
            if (xq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            q71 q71Var = new q71(d2, 0.9d, 0, xq0Var3.f.d);
            q71Var.x(false);
            q71Var.z(true);
            xq0 xq0Var4 = this.N;
            if (xq0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (!TextUtils.isEmpty(xq0Var4.f.m)) {
                xq0 xq0Var5 = this.N;
                if (xq0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                q71Var.t(xq0Var5.f.l);
            }
            Unit unit = Unit.INSTANCE;
            j71Var2.e(q71Var);
            j71Var2.h();
            Unit unit2 = Unit.INSTANCE;
            this.D = j71Var2;
            jt0 jt0Var = this.H;
            if (jt0Var != null) {
                jt0Var.pause();
            }
            AdImageView adImageView = this.z;
            if (adImageView != null) {
                ExtensionsKt.e(adImageView, false);
            }
            xq0 xq0Var6 = this.N;
            if (xq0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            xq0Var6.g().g(true);
        }
    }

    public final void S2() {
        cr0 cr0Var;
        cr0 cr0Var2;
        String str;
        cr0 cr0Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ar0 ar0Var = xq0Var.j;
            NadRewardHalfTailHolder nadRewardHalfTailHolder = null;
            if (ar0Var != null) {
                cr0Var = ar0Var.h;
            } else {
                cr0Var = null;
            }
            if (cr0Var != null) {
                xq0 xq0Var2 = this.N;
                if (xq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fr0 b2 = xq0Var2.b();
                if (b2 == null || b2.k()) {
                    xq0 xq0Var3 = this.N;
                    if (xq0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ar0 ar0Var2 = xq0Var3.j;
                    if (ar0Var2 != null && (cr0Var2 = ar0Var2.h) != null) {
                        xq0 xq0Var4 = this.N;
                        if (xq0Var4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        ar0 ar0Var3 = xq0Var4.j;
                        if (ar0Var3 != null && (cr0Var3 = ar0Var3.h) != null && (str2 = cr0Var3.x) != null) {
                            po0 po0Var = this.O;
                            str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (po0Var == null || (r4 = po0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                        } else {
                            str = null;
                        }
                        cr0Var2.x = str;
                    }
                    so0 so0Var = this.C;
                    if (so0Var != null) {
                        so0Var.setVisibility(false);
                    }
                    so0.a aVar = so0.k0;
                    xq0 xq0Var5 = this.N;
                    if (xq0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    so0 a2 = aVar.a(xq0Var5, this);
                    this.C = a2;
                    if (a2 != null) {
                        xq0 xq0Var6 = this.N;
                        if (xq0Var6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        a2.setData(xq0Var6);
                    }
                    so0 so0Var2 = this.C;
                    if (!(so0Var2 instanceof View)) {
                        so0Var2 = null;
                    }
                    View view2 = (View) so0Var2;
                    if (view2 != null) {
                        H2().removeAllViews();
                        H2().addView(view2);
                        H2().bringToFront();
                    }
                    so0 so0Var3 = this.C;
                    if (so0Var3 != null) {
                        so0Var3.setOnReplayClickListener(new Function0<Unit>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NadRewardVideoActivity this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
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
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    so0 so0Var4 = this.this$0.C;
                                    if (so0Var4 != null) {
                                        so0Var4.setVisibility(false);
                                    }
                                    jt0 jt0Var = this.this$0.H;
                                    if (jt0Var != null) {
                                        jt0Var.start();
                                    }
                                }
                            }
                        });
                    }
                    so0 so0Var4 = this.C;
                    if (so0Var4 instanceof NadRewardHalfTailHolder) {
                        nadRewardHalfTailHolder = so0Var4;
                    }
                    NadRewardHalfTailHolder nadRewardHalfTailHolder2 = nadRewardHalfTailHolder;
                    if (nadRewardHalfTailHolder2 != null) {
                        nadRewardHalfTailHolder2.setShowPanelPopCallback(new Function1<Boolean, Unit>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$$inlined$run$lambda$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NadRewardVideoActivity this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z) {
                                AdImageView adImageView;
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (adImageView = this.this$0.z) != null) {
                                    ExtensionsKt.e(adImageView, z);
                                }
                            }
                        });
                        nadRewardHalfTailHolder2.setPanelPopDismissCallback(new Function0<Unit>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$$inlined$run$lambda$2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NadRewardVideoActivity this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
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
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    AdImageView adImageView = this.this$0.z;
                                    if (adImageView != null) {
                                        ExtensionsKt.e(adImageView, true);
                                    }
                                    AdImageView adImageView2 = this.this$0.z;
                                    if (adImageView2 != null) {
                                        adImageView2.bringToFront();
                                    }
                                    AbsRewardCountDownView absRewardCountDownView = this.this$0.B;
                                    if (absRewardCountDownView != null) {
                                        absRewardCountDownView.bringToFront();
                                    }
                                }
                            }
                        });
                        nadRewardHalfTailHolder2.setBackBtnCallback(new Function0<Unit>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$$inlined$run$lambda$3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NadRewardVideoActivity this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
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
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    this.this$0.g3();
                                }
                            }
                        });
                        nadRewardHalfTailHolder2.setCloseClickCallback(new Function0<Unit>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$$inlined$run$lambda$4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NadRewardVideoActivity this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
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
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    this.this$0.g3();
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            so0 so0Var5 = this.C;
            if (so0Var5 != null) {
                so0Var5.setVisibility(false);
            }
        }
    }

    public final void U2() {
        oq0 oq0Var;
        int i2;
        cr0 cr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            NadRewardVideoAdOverContainer D2 = D2();
            D2.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (xq0Var.f().C()) {
                xq0 xq0Var2 = this.N;
                if (xq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                String str = xq0Var2.f.c;
                Context context = D2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (W2(str, context)) {
                    xq0 xq0Var3 = this.N;
                    if (xq0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    pq0 pq0Var = xq0Var3.m;
                    if (pq0Var != null) {
                        pq0Var.g = true;
                    }
                    xq0 xq0Var4 = this.N;
                    if (xq0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ar0 ar0Var = xq0Var4.j;
                    if (ar0Var != null && (cr0Var = ar0Var.h) != null) {
                        cr0Var.C = true;
                    }
                }
            }
            xq0 xq0Var5 = this.N;
            if (xq0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (xq0Var5.c() != null) {
                xq0 xq0Var6 = this.N;
                if (xq0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                pq0 pq0Var2 = xq0Var6.m;
                if (pq0Var2 != null) {
                    pq0Var2.e = true;
                }
                xq0 xq0Var7 = this.N;
                if (xq0Var7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                pq0 pq0Var3 = xq0Var7.m;
                if (pq0Var3 != null) {
                    xq0 xq0Var8 = this.N;
                    if (xq0Var8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (xq0Var8.l()) {
                        i2 = 2;
                    } else {
                        i2 = 0;
                    }
                    pq0Var3.a = i2;
                }
                xq0 xq0Var9 = this.N;
                if (xq0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                pq0 pq0Var4 = xq0Var9.m;
                if (pq0Var4 != null) {
                    xq0 xq0Var10 = this.N;
                    if (xq0Var10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    hr0 c2 = xq0Var10.c();
                    Intrinsics.checkNotNull(c2);
                    pq0Var4.p = c2.b();
                }
                xq0 xq0Var11 = this.N;
                if (xq0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                pq0 pq0Var5 = xq0Var11.m;
                if (pq0Var5 != null && (oq0Var = pq0Var5.q) != null) {
                    xq0 xq0Var12 = this.N;
                    if (xq0Var12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    oq0Var.d = xq0Var12.f.d;
                }
            }
            xq0 xq0Var13 = this.N;
            if (xq0Var13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            D2.setData(xq0Var13);
            xq0 xq0Var14 = this.N;
            if (xq0Var14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (xq0Var14.k()) {
                D2.setBottomLineHeight(b51.c.a(D2.getContext(), 37.0f));
            } else {
                D2.setBottomLineHeight(b51.c.a(D2.getContext(), 0.0f));
            }
            D2.setOnUiClickListener(new k(D2, this));
            D2.setFeedbackBtnVisibility(false);
            D2.setFestivalClickCallback(new l(D2, this));
        }
    }

    public final void V2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.H == null) {
                kt0 kt0Var = new kt0();
                kt0Var.a = 2;
                jt0 b2 = jt0.a.b(this, 0, kt0Var);
                this.H = b2;
                if (b2 != null) {
                    b2.attachToContainer(J2());
                }
            }
            jt0 jt0Var = this.H;
            if (jt0Var != null) {
                jt0Var.d(new n());
                xq0 xq0Var = this.N;
                if (xq0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ar0 ar0Var = xq0Var.j;
                if (ar0Var != null && ar0Var.f) {
                    jt0Var.setVideoScalingMode(0);
                } else {
                    jt0Var.setVideoScalingMode(2);
                }
                jt0Var.a(new m(this));
            }
            xq0 xq0Var2 = this.N;
            if (xq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (xq0Var2.j == null) {
                J2().setVisibility(8);
                this.H = null;
                return;
            }
            jt0 jt0Var2 = this.H;
            if (jt0Var2 != null) {
                xq0 xq0Var3 = this.N;
                if (xq0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ar0 ar0Var2 = xq0Var3.j;
                Intrinsics.checkNotNull(ar0Var2);
                jt0Var2.c(ar0Var2);
            }
            if (NetUtil.a(this)) {
                xq0 xq0Var4 = this.N;
                if (xq0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fr0 b3 = xq0Var4.b();
                if (b3 != null) {
                    z = b3.k();
                } else {
                    z = false;
                }
                jt0 jt0Var3 = this.H;
                if (jt0Var3 != null) {
                    jt0Var3.setLooping(!z);
                }
                jt0 jt0Var4 = this.H;
                if (jt0Var4 != null) {
                    jt0Var4.start();
                }
            } else {
                g41.a().a(this, R.string.nad_reward_video_lp_no_network);
            }
            NadRewardInterceptFrameLayout J2 = J2();
            J2.setVisibility(0);
            xq0 xq0Var5 = this.N;
            if (xq0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            J2.setEnableIntercept(xq0Var5.k());
            J2.setInterceptCallback(new Function0<Unit>(this) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initVideoPlayer$$inlined$apply$lambda$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NadRewardVideoActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.j3();
                        ep0.q(NadRewardVideoActivity.X1(this.this$0));
                    }
                }
            });
        }
    }

    public final void h3() {
        String str;
        boolean z;
        Boolean bool;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            hr0 c2 = xq0Var.c();
            String str2 = null;
            if (c2 != null) {
                str = c2.c();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                j71 j71Var = this.E;
                if (j71Var != null) {
                    j71Var.a(0);
                }
                this.E = null;
                return;
            }
            j71 j71Var2 = this.E;
            if (j71Var2 != null) {
                j71Var2.a(0);
            }
            long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.V;
            if (handler != null) {
                Runnable runnable = this.X;
                xq0 xq0Var2 = this.N;
                if (xq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                hr0 c3 = xq0Var2.c();
                if (c3 != null) {
                    j2 = c3.a();
                } else {
                    j2 = 0;
                }
                handler.postDelayed(runnable, j2);
            }
            j71 j71Var3 = new j71(this);
            xq0 xq0Var3 = this.N;
            if (xq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            hr0 c4 = xq0Var3.c();
            if (c4 != null) {
                bool = Boolean.valueOf(c4.d());
            } else {
                bool = null;
            }
            j71Var3.f(new s(bool, this, currentTimeMillis));
            xq0 xq0Var4 = this.N;
            if (xq0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            hr0 c5 = xq0Var4.c();
            if (c5 != null) {
                str2 = c5.c();
            }
            String str3 = str2;
            xq0 xq0Var5 = this.N;
            if (xq0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            q71 q71Var = new q71(str3, 0.93d, 0, xq0Var5.f.d);
            q71Var.x(false);
            q71Var.y(true);
            q71Var.u(true);
            q71Var.v(true);
            Unit unit = Unit.INSTANCE;
            j71Var3.e(q71Var);
            j71Var3.h();
            Unit unit2 = Unit.INSTANCE;
            this.E = j71Var3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0074, code lost:
        if (r0 == true) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i3() {
        InterceptResult invokeV;
        String str;
        j71 j71Var;
        ViewGroup view2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (xq0Var.f().k() != null) {
                xq0 xq0Var2 = this.N;
                if (xq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (xq0Var2.f().m() != null) {
                    xq0 xq0Var3 = this.N;
                    if (xq0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    or0 m2 = xq0Var3.f().m();
                    if (m2 != null) {
                        str = m2.a();
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str) && !ot.a(this) && !X2() && ((j71Var = this.D) == null || !j71Var.isShowing())) {
                        so0 so0Var = this.C;
                        if (so0Var != null && (view2 = so0Var.getView()) != null) {
                            if (view2.getVisibility() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        xq0 xq0Var4 = this.N;
                        if (xq0Var4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        nr0 f2 = xq0Var4.f();
                        xq0 xq0Var5 = this.N;
                        if (xq0Var5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        ir0 k2 = xq0Var5.f().k();
                        Intrinsics.checkNotNull(k2);
                        String c2 = k2.c();
                        xq0 xq0Var6 = this.N;
                        if (xq0Var6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        ir0 k3 = xq0Var6.f().k();
                        Intrinsics.checkNotNull(k3);
                        NadRewardLottieDialog x2 = x2(f2.j(c2, k3.a()));
                        FragmentManager supportFragmentManager = getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                        x2.show(supportFragmentManager, (String) null);
                        this.M = x2;
                        a3();
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean W2(String str, Context context) {
        InterceptResult invokeLL;
        Object m773constructorimpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, str, context)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            HashMap<String, String> d2 = new bj0(str).d();
            Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
            String str2 = d2.get("params");
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            try {
                Result.Companion companion = Result.Companion;
                Intrinsics.checkNotNull(str2);
                m773constructorimpl = Result.m773constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m779isFailureimpl(m773constructorimpl)) {
                m773constructorimpl = null;
            }
            String str3 = (String) m773constructorimpl;
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str3));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            NadRewardVideoDialog nadRewardVideoDialog = this.J;
            if (nadRewardVideoDialog != null && nadRewardVideoDialog.isVisible()) {
                return true;
            }
            NadRewardVideoDialog nadRewardVideoDialog2 = this.K;
            if (nadRewardVideoDialog2 != null && nadRewardVideoDialog2.isVisible()) {
                return true;
            }
            NadRewardSuspendDialog nadRewardSuspendDialog = this.L;
            if (nadRewardSuspendDialog != null && nadRewardSuspendDialog.isVisible()) {
                return true;
            }
            NadRewardLottieDialog nadRewardLottieDialog = this.M;
            if (nadRewardLottieDialog != null && nadRewardLottieDialog.isVisible()) {
                return true;
            }
            NadRewardVideoDialog nadRewardVideoDialog3 = this.I;
            if (nadRewardVideoDialog3 != null && nadRewardVideoDialog3.isVisible()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            NadRewardTaskHelper nadRewardTaskHelper = this.U;
            if (nadRewardTaskHelper != null && nadRewardTaskHelper.A()) {
                xq0 xq0Var = this.N;
                if (xq0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                return o3(xq0Var.f().c());
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            AbsRewardCountDownView absRewardCountDownView = this.B;
            if (absRewardCountDownView != null) {
                long seconds = timeUnit.toSeconds(absRewardCountDownView.getMillisUntilFinished());
                if (seconds <= 0) {
                    return l3();
                }
                return k3(seconds);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.z1();
            AbsRewardCountDownView absRewardCountDownView = this.B;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.d();
            }
            jt0 jt0Var = this.H;
            if (jt0Var != null) {
                jt0Var.release();
            }
            this.H = null;
            NadRewardVideoDialog nadRewardVideoDialog = this.I;
            if (nadRewardVideoDialog != null) {
                nadRewardVideoDialog.onDestroy();
            }
            NadRewardVideoDialog nadRewardVideoDialog2 = this.J;
            if (nadRewardVideoDialog2 != null) {
                nadRewardVideoDialog2.onDestroy();
            }
            NadRewardVideoDialog nadRewardVideoDialog3 = this.K;
            if (nadRewardVideoDialog3 != null) {
                nadRewardVideoDialog3.onDestroy();
            }
            NadRewardSuspendDialog nadRewardSuspendDialog = this.L;
            if (nadRewardSuspendDialog != null) {
                nadRewardSuspendDialog.onDestroy();
            }
            NadRewardLottieDialog nadRewardLottieDialog = this.M;
            if (nadRewardLottieDialog != null) {
                nadRewardLottieDialog.onDestroy();
            }
            D2().y();
            NadRewardTaskHelper nadRewardTaskHelper = this.U;
            if (nadRewardTaskHelper != null) {
                nadRewardTaskHelper.F();
            }
            Handler handler = this.V;
            if (handler != null) {
                handler.removeCallbacks(this.X);
            }
        }
    }

    public final void z2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            List<MonitorUrl> list = xq0Var.e;
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
                o21.b(monitorUrl.clickUrl);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
        if (r4 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009b, code lost:
        if (r4 != null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Z2() {
        InterceptResult invokeV;
        Object m773constructorimpl;
        cr0 cr0Var;
        cr0 cr0Var2;
        Boolean bool;
        boolean z;
        cr0 cr0Var3;
        String str;
        String replace$default;
        String str2;
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            String str3 = null;
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
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            if (serializable != null) {
                m773constructorimpl = Result.m773constructorimpl(dp0.a.d((HashMap) serializable));
                if (Result.m780isSuccessimpl(m773constructorimpl)) {
                    xq0 xq0Var = (xq0) m773constructorimpl;
                    this.N = xq0Var;
                    if (xq0Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ar0 ar0Var = xq0Var.j;
                    if (ar0Var != null && (cr0Var3 = ar0Var.h) != null) {
                        xq0 xq0Var2 = this.N;
                        if (xq0Var2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        String str4 = "";
                        if (xq0Var2.l()) {
                            String str5 = cr0Var3.f;
                            if (str5 != null) {
                                xq0 xq0Var3 = this.N;
                                if (xq0Var3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                                }
                                replace$default = StringsKt__StringsJVMKt.replace$default(str5, "__CONVERT_CMD__", xq0Var3.e(), false, 4, (Object) null);
                            }
                            cr0Var3.f = str4;
                        } else {
                            String str6 = cr0Var3.f;
                            if (str6 != null) {
                                xq0 xq0Var4 = this.N;
                                if (xq0Var4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                                }
                                pq0 pq0Var = xq0Var4.m;
                                if (pq0Var == null || (str2 = pq0Var.t) == null) {
                                    str = "";
                                } else {
                                    str = str2;
                                }
                                replace$default = StringsKt__StringsJVMKt.replace$default(str6, "__CONVERT_CMD__", str, false, 4, (Object) null);
                            }
                            cr0Var3.f = str4;
                        }
                    }
                    xq0 xq0Var5 = this.N;
                    if (xq0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    pq0 pq0Var2 = xq0Var5.m;
                    boolean z2 = true;
                    if (pq0Var2 != null) {
                        pq0Var2.d = true;
                    }
                    xq0 xq0Var6 = this.N;
                    if (xq0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    pq0 pq0Var3 = xq0Var6.m;
                    if (pq0Var3 != null) {
                        xq0 xq0Var7 = this.N;
                        if (xq0Var7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        fr0 b2 = xq0Var7.b();
                        if (b2 != null) {
                            z = b2.c();
                        } else {
                            z = false;
                        }
                        pq0Var3.f = z;
                    }
                    xq0 xq0Var8 = this.N;
                    if (xq0Var8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ar0 ar0Var2 = xq0Var8.j;
                    if (ar0Var2 != null && (cr0Var2 = ar0Var2.h) != null) {
                        xq0 xq0Var9 = this.N;
                        if (xq0Var9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        fr0 b3 = xq0Var9.b();
                        if (b3 != null) {
                            bool = Boolean.valueOf(b3.m());
                        } else {
                            bool = null;
                        }
                        cr0Var2.D = bool;
                    }
                    xq0 xq0Var10 = this.N;
                    if (xq0Var10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ar0 ar0Var3 = xq0Var10.j;
                    if (ar0Var3 != null && (cr0Var = ar0Var3.h) != null) {
                        xq0 xq0Var11 = this.N;
                        if (xq0Var11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        fr0 b4 = xq0Var11.b();
                        if (b4 != null) {
                            str3 = b4.l();
                        }
                        cr0Var.E = str3;
                    }
                    ko0 ko0Var = (ko0) ServiceManager.getService(ko0.a);
                    xq0 xq0Var12 = this.N;
                    if (xq0Var12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (xq0Var12.f().u().length() != 0) {
                        z2 = false;
                    }
                    if (z2 && ko0Var != null) {
                        xq0 xq0Var13 = this.N;
                        if (xq0Var13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        nr0 f2 = xq0Var13.f();
                        String a2 = ko0Var.a();
                        Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                        f2.F(a2);
                    }
                    xq0 xq0Var14 = this.N;
                    if (xq0Var14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    pq0 pq0Var4 = xq0Var14.m;
                    if (pq0Var4 != null) {
                        xq0 xq0Var15 = this.N;
                        if (xq0Var15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        List<MonitorUrl> list = xq0Var15.e;
                        Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                        pq0Var4.h = list;
                    }
                }
                Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
                if (m776exceptionOrNullimpl != null && yg0.a) {
                    g41.a().showToast(this, m776exceptionOrNullimpl.getMessage());
                }
                return Result.m780isSuccessimpl(m773constructorimpl);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
        }
        return invokeV.booleanValue;
    }

    public final void b3(String str, String str2, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048607, this, str, str2, hashMap) == null) {
            qo0 qo0Var = new qo0();
            qo0Var.a = str;
            qo0Var.b = hashMap;
            sm0.a().a(qo0Var);
        }
    }

    public final NadRewardVideoDialog w2(final String str) {
        InterceptResult invokeL;
        boolean z;
        Integer num;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            final NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str2 = xq0Var.f.d;
            Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
            nadRewardVideoDialog.d2(str, str2);
            oo0 O1 = nadRewardVideoDialog.O1();
            if (O1 != null) {
                xq0 xq0Var2 = this.N;
                if (xq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                O1.M(xq0Var2.g().d());
            }
            oo0 O12 = nadRewardVideoDialog.O1();
            if (O12 != null) {
                xq0 xq0Var3 = this.N;
                if (xq0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                O12.L(xq0Var3.f().r());
            }
            oo0 O13 = nadRewardVideoDialog.O1();
            boolean z2 = true;
            if (O13 != null) {
                xq0 xq0Var4 = this.N;
                if (xq0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (xq0Var4.f().i().length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    xq0 xq0Var5 = this.N;
                    if (xq0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    valueOf = xq0Var5.f().i();
                } else {
                    xq0 xq0Var6 = this.N;
                    if (xq0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    rr0 q2 = xq0Var6.f().q();
                    if (q2 != null) {
                        num = Integer.valueOf(q2.b());
                    } else {
                        num = null;
                    }
                    valueOf = String.valueOf(num);
                }
                O13.I(valueOf);
            }
            oo0 O14 = nadRewardVideoDialog.O1();
            if (O14 != null) {
                xq0 xq0Var7 = this.N;
                if (xq0Var7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (xq0Var7.c() == null) {
                    z2 = false;
                }
                O14.H(z2);
            }
            nadRewardVideoDialog.b2(new a(this, str));
            nadRewardVideoDialog.g2(new Function0<Unit>(this, str) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ String $dialogDataJson$inlined;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NadRewardVideoActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$dialogDataJson$inlined = str;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.f3();
                    }
                }
            });
            nadRewardVideoDialog.Z1(new b(this, str));
            nadRewardVideoDialog.c2(new Function1<String, Unit>(nadRewardVideoDialog, this, str) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ String $dialogDataJson$inlined;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NadRewardVideoDialog $this_apply;
                public final /* synthetic */ NadRewardVideoActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nadRewardVideoDialog, this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$this_apply = nadRewardVideoDialog;
                    this.this$0 = this;
                    this.$dialogDataJson$inlined = str;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                    invoke2(str3);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
                    if (r5.m() == true) goto L25;
                 */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(String str3) {
                    pq0 pq0Var;
                    lq0 lq0Var;
                    String str4;
                    boolean z3;
                    String str5;
                    String str6;
                    lq0 lq0Var2;
                    lq0 lq0Var3;
                    lq0 lq0Var4;
                    lq0 lq0Var5;
                    j71 j71Var;
                    ViewGroup view2;
                    boolean z4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3) == null) {
                        boolean z5 = false;
                        if (NadRewardVideoActivity.X1(this.this$0).k() && this.this$0.A2(str3)) {
                            this.$this_apply.dismiss();
                            so0 so0Var = this.this$0.C;
                            if (so0Var != null && (view2 = so0Var.getView()) != null) {
                                if (view2.getVisibility() == 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    fr0 b2 = NadRewardVideoActivity.X1(this.this$0).b();
                                    if (b2 != null) {
                                    }
                                }
                            }
                            j71Var = this.this$0.E;
                            if (j71Var == null || !j71Var.isShowing()) {
                                this.this$0.j3();
                            }
                        }
                        if (NadRewardVideoActivity.X1(this.this$0).l() && (pq0Var = NadRewardVideoActivity.X1(this.this$0).m) != null && (lq0Var = pq0Var.p) != null && lq0Var.e) {
                            pq0 pq0Var2 = NadRewardVideoActivity.X1(this.this$0).m;
                            String str7 = null;
                            if (pq0Var2 != null && (lq0Var5 = pq0Var2.p) != null) {
                                str4 = lq0Var5.b;
                            } else {
                                str4 = null;
                            }
                            if (str4 != null && str4.length() != 0) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            if (z3) {
                                pq0 pq0Var3 = NadRewardVideoActivity.X1(this.this$0).m;
                                if (pq0Var3 != null && (lq0Var4 = pq0Var3.p) != null) {
                                    str5 = lq0Var4.a;
                                } else {
                                    str5 = null;
                                }
                                if (!((str5 == null || str5.length() == 0) ? true : true)) {
                                    pq0 pq0Var4 = NadRewardVideoActivity.X1(this.this$0).m;
                                    if (pq0Var4 != null && (lq0Var3 = pq0Var4.p) != null) {
                                        str6 = lq0Var3.a;
                                    } else {
                                        str6 = null;
                                    }
                                    if (s41.d(str6)) {
                                        Context context = this.$this_apply.getContext();
                                        if (context != null) {
                                            pq0 pq0Var5 = NadRewardVideoActivity.X1(this.this$0).m;
                                            if (pq0Var5 != null && (lq0Var2 = pq0Var5.p) != null) {
                                                str7 = lq0Var2.a;
                                            }
                                            Intrinsics.checkNotNull(str7);
                                            jj0.b(context, str7);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            wi0.b(s41.b(NadRewardVideoActivity.X1(this.this$0), NadRewardVideoActivity.X1(this.this$0).e()));
                        }
                    }
                }
            });
            nadRewardVideoDialog.h2(new c(nadRewardVideoDialog, this, str));
            return nadRewardVideoDialog;
        }
        return (NadRewardVideoDialog) invokeL.objValue;
    }

    public final NadRewardSuspendDialog y2(final String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
            xq0 xq0Var = this.N;
            if (xq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str4 = xq0Var.f.d;
            Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
            nadRewardSuspendDialog.d2(str, str4);
            oo0 O1 = nadRewardSuspendDialog.O1();
            String str5 = null;
            if (O1 != null) {
                xq0 xq0Var2 = this.N;
                if (xq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qr0 p2 = xq0Var2.f().p();
                if (p2 != null) {
                    str3 = p2.a();
                } else {
                    str3 = null;
                }
                O1.G(str3);
            }
            oo0 O12 = nadRewardSuspendDialog.O1();
            if (O12 != null) {
                xq0 xq0Var3 = this.N;
                if (xq0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qr0 p3 = xq0Var3.f().p();
                if (p3 != null) {
                    str2 = p3.e();
                } else {
                    str2 = null;
                }
                O12.K(str2);
            }
            oo0 O13 = nadRewardSuspendDialog.O1();
            if (O13 != null) {
                xq0 xq0Var4 = this.N;
                if (xq0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qr0 p4 = xq0Var4.f().p();
                if (p4 != null) {
                    str5 = p4.g();
                }
                O13.N(str5);
            }
            nadRewardSuspendDialog.b2(new f(this, str));
            nadRewardSuspendDialog.g2(new Function0<Unit>(this, str) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $suspendCmd$inlined;
                public final /* synthetic */ NadRewardVideoActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$suspendCmd$inlined = str;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.f3();
                    }
                }
            });
            nadRewardSuspendDialog.Z1(new g(this, str));
            nadRewardSuspendDialog.j2(new Function0<Unit>(this, str) { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $suspendCmd$inlined;
                public final /* synthetic */ NadRewardVideoActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$suspendCmd$inlined = str;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.c3();
                    }
                }
            });
            return nadRewardSuspendDialog;
        }
        return (NadRewardSuspendDialog) invokeL.objValue;
    }
}
