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
import androidx.fragment.app.FragmentManager;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.business.uitemplate.NadEnhanceButtonDownloadView;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper;
import com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView;
import com.baidu.nadcore.lp.reward.view.NadRewardBigCardView;
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
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.R;
import com.baidu.tieba.ao0;
import com.baidu.tieba.au;
import com.baidu.tieba.bs0;
import com.baidu.tieba.ck0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.ds0;
import com.baidu.tieba.eq0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.g61;
import com.baidu.tieba.gs0;
import com.baidu.tieba.hs0;
import com.baidu.tieba.is0;
import com.baidu.tieba.js0;
import com.baidu.tieba.k51;
import com.baidu.tieba.kk0;
import com.baidu.tieba.ks0;
import com.baidu.tieba.lk0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.mu0;
import com.baidu.tieba.n61;
import com.baidu.tieba.nu0;
import com.baidu.tieba.os0;
import com.baidu.tieba.p81;
import com.baidu.tieba.pi0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.ps0;
import com.baidu.tieba.qp0;
import com.baidu.tieba.qr0;
import com.baidu.tieba.qs0;
import com.baidu.tieba.qu0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.s31;
import com.baidu.tieba.ss0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.tp0;
import com.baidu.tieba.ue1;
import com.baidu.tieba.us0;
import com.baidu.tieba.v81;
import com.baidu.tieba.w11;
import com.baidu.tieba.w51;
import com.baidu.tieba.w71;
import com.baidu.tieba.w81;
import com.baidu.tieba.x71;
import com.baidu.tieba.xj0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.xp0;
import com.baidu.tieba.yp0;
import com.baidu.tieba.yr0;
import com.baidu.tieba.zh0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\bÁ\u0001\u0010\u0013J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u0013J\u000f\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001e\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010\u0013J\u000f\u0010 \u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010\u0013J\u000f\u0010!\u001a\u00020\u0011H\u0002¢\u0006\u0004\b!\u0010\u0013J\u000f\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u0013J\u000f\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u0013J\u000f\u0010$\u001a\u00020\u0011H\u0002¢\u0006\u0004\b$\u0010\u0013J\u000f\u0010%\u001a\u00020\u0011H\u0002¢\u0006\u0004\b%\u0010\u0013J\u000f\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010\u0013J\u000f\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b'\u0010\u0013J\u000f\u0010(\u001a\u00020\u0011H\u0002¢\u0006\u0004\b(\u0010\u0013J\u000f\u0010)\u001a\u00020\u0011H\u0002¢\u0006\u0004\b)\u0010\u0013J!\u0010,\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0011H\u0016¢\u0006\u0004\b0\u0010\u0013J\u000f\u00101\u001a\u00020\u0011H\u0016¢\u0006\u0004\b1\u0010\u0013J\u0019\u00104\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0011H\u0014¢\u0006\u0004\b6\u0010\u0013J\u0019\u00109\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000107H\u0014¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0011H\u0014¢\u0006\u0004\b;\u0010\u0013J\u000f\u0010<\u001a\u00020\u0011H\u0014¢\u0006\u0004\b<\u0010\u0013J\u000f\u0010=\u001a\u00020\u0011H\u0002¢\u0006\u0004\b=\u0010\u0013J\u000f\u0010>\u001a\u00020\u0004H\u0002¢\u0006\u0004\b>\u0010/J\u000f\u0010?\u001a\u00020\u0011H\u0002¢\u0006\u0004\b?\u0010\u0013JC\u0010E\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u00022\"\u0010D\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020Bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`CH\u0002¢\u0006\u0004\bE\u0010FJ\u0019\u0010G\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0011H\u0002¢\u0006\u0004\bI\u0010\u0013J\u000f\u0010J\u001a\u00020\u0011H\u0002¢\u0006\u0004\bJ\u0010\u0013J\u000f\u0010K\u001a\u00020\u0011H\u0002¢\u0006\u0004\bK\u0010\u0013J\u000f\u0010L\u001a\u00020\u0011H\u0002¢\u0006\u0004\bL\u0010\u0013J\u0017\u0010N\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\u0004H\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0011H\u0002¢\u0006\u0004\bP\u0010\u0013J\u000f\u0010Q\u001a\u00020\u0004H\u0002¢\u0006\u0004\bQ\u0010/J\u000f\u0010R\u001a\u00020\u0011H\u0002¢\u0006\u0004\bR\u0010\u0013J\u000f\u0010S\u001a\u00020\u0004H\u0002¢\u0006\u0004\bS\u0010/J\u000f\u0010T\u001a\u00020\u0011H\u0002¢\u0006\u0004\bT\u0010\u0013J\u0017\u0010W\u001a\u00020\u00042\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0004H\u0002¢\u0006\u0004\bY\u0010/J\u000f\u0010Z\u001a\u00020\u0004H\u0002¢\u0006\u0004\bZ\u0010/J\u000f\u0010[\u001a\u00020\u0011H\u0002¢\u0006\u0004\b[\u0010\u0013J\u0017\u0010]\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u0002H\u0002¢\u0006\u0004\b]\u0010\u0016J\u000f\u0010^\u001a\u00020\u0011H\u0002¢\u0006\u0004\b^\u0010\u0013J\u0017\u0010a\u001a\u00020\u00112\u0006\u0010`\u001a\u00020_H\u0002¢\u0006\u0004\ba\u0010bR\u001d\u0010h\u001a\u00020c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020i8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bj\u0010kR\u001d\u0010p\u001a\u00020l8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010e\u001a\u0004\bn\u0010oR\u0018\u0010r\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u001e\u0010\u0080\u0001\u001a\u00020|8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b}\u0010e\u001a\u0004\b~\u0010\u007fR\u001c\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010uR\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u008f\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0092\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009b\u0001\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\u009d\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u0092\u0001R\u0018\u0010\u009e\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010uR\u001a\u0010 \u0001\u001a\u00030\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010uR\u001c\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001c\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R \u0010°\u0001\u001a\u00020|8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b®\u0001\u0010e\u001a\u0005\b¯\u0001\u0010\u007fR\u001b\u0010±\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010\u008f\u0001R\"\u0010¶\u0001\u001a\u00030²\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b³\u0001\u0010e\u001a\u0006\b´\u0001\u0010µ\u0001R\"\u0010»\u0001\u001a\u00030·\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¸\u0001\u0010e\u001a\u0006\b¹\u0001\u0010º\u0001R\"\u0010À\u0001\u001a\u00030¼\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b½\u0001\u0010e\u001a\u0006\b¾\u0001\u0010¿\u0001¨\u0006Â\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/NadRewardVideoActivity;", "Lcom/baidu/nadcore/appframework/BaseActivity;", "", "dialogDataJson", "", "isTaskDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "buildDialog", "(Ljava/lang/String;Z)Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "rewardDataJson", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "buildLottieDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "suspendCmd", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "buildSuspendDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "", "chargeClick", "()V", "scheme", "checkRewardPanelPop", "(Ljava/lang/String;)Z", "suspendDialogShowMoment", "checkShowSuspendMoment", "computeDailyRewardShownIndex", "finish", "getSessionInfo", "()Ljava/lang/String;", "init", "initBigCard", "initBottomArrow", "initCloseIcon", "initCountDownView", "initRewardTask", "initSessionCountByTime", "initSvButton", "initSvTitle", "initTailFrame", "initTopTag", "initUserInfoContainer", "initVideoPlayer", "Landroid/content/Context;", "context", "isAppInstalled", "(Ljava/lang/String;Landroid/content/Context;)Z", "isDialogShowing", "()Z", "onAttachedToWindow", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreateEx", "(Landroid/os/Bundle;)V", "onDestroyEx", "Landroid/content/Intent;", "intent", "onNewIntentEx", "(Landroid/content/Intent;)V", "onPauseEx", "onResumeEx", "onTaskComplete", "parseData", "pauseVideoPlayAndCountDown", "status", "message", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "postRewardVideoNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "preCreate", "(Landroid/os/Bundle;)Z", "recomputeCountDownSecond", "registerBackForegroundEvent", "resetStatus", "resumeVideoPlayAndCountDown", "playEnd", "setVideoContainerMask", "(Z)V", "showBigCard", "showDialog", "showImageStylePage", "showLottieDialog", "showPanelPop", "", "remainSecond", "showRetainDialog", "(J)Z", "showRewardDialog", "showSuspendDialog", "showSuspendDialogDelay", "cmd", "showTaskDialog", "triggerTask", "", "progress", "updateVideoSize", "(F)V", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer$delegate", "Lkotlin/Lazy;", "getAdInfoContainer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/uiwidget/ExpandIconView;", "arrowView$delegate", "getArrowView", "()Lcom/baidu/nadcore/widget/uiwidget/ExpandIconView;", "arrowView", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCard", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCardShown", "Z", "Lcom/baidu/nadcore/widget/AdImageView;", "closeIcon", "Lcom/baidu/nadcore/widget/AdImageView;", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "countDownView", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Landroid/widget/FrameLayout;", "flRootView$delegate", "getFlRootView", "()Landroid/widget/FrameLayout;", "flRootView", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "hasMore", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "imageStylePanelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "lottieDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "panelPop", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "retainDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "rewardCount", "I", "rewardDialog", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardResponse", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardShownIndex", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "rewardTaskHelper", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "screenHW", "F", "sessionCount", "shouldCharge", "Ljava/lang/Runnable;", "shouldChargeTask", "Ljava/lang/Runnable;", "suspendDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "suspendDialogShown", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "svButton", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "svTitle", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "tailFrame", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "tailFrameContainer$delegate", "getTailFrameContainer", "tailFrameContainer", "taskDialog", "Landroid/view/View;", "topMask$delegate", "getTopMask", "()Landroid/view/View;", "topMask", "Landroid/widget/ImageView;", "topTag$delegate", "getTopTag", "()Landroid/widget/ImageView;", "topTag", "Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "videoContainer$delegate", "getVideoContainer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "videoContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardVideoActivity extends BaseActivity {
    public AdImageView A;
    public AbsRewardCountDownView C;
    public tp0 D;
    public p81 E;
    public p81 F;
    public NadHighLightTextView G;
    public NadIconTextButton H;
    public mu0 I;
    public NadRewardVideoDialog J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardSuspendDialog M;
    public NadRewardLottieDialog N;
    public NadRewardBigCardView O;
    public yr0 P;
    public qp0 Q;
    public float R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public int f1050T;
    public boolean V;
    public NadRewardTaskHelper W;
    public Handler X;
    public boolean Y;
    public boolean a0;
    public boolean b0;
    public final Lazy u = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$flRootView$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FrameLayout invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.fl_root);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fl_root)");
            return (FrameLayout) findViewById;
        }
    });
    public final Lazy v = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardInterceptFrameLayout>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$videoContainer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NadRewardInterceptFrameLayout invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.fl_video_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fl_video_container)");
            return (NadRewardInterceptFrameLayout) findViewById;
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
    public final Lazy z = LazyKt__LazyJVMKt.lazy(new Function0<ExpandIconView>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$arrowView$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExpandIconView invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.iv_arrow);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_arrow)");
            return (ExpandIconView) findViewById;
        }
    });
    public final Lazy B = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$topTag$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            View findViewById = NadRewardVideoActivity.this.findViewById(R.id.top_tag);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.top_tag)");
            return (ImageView) findViewById;
        }
    });
    public int U = 1;
    public Runnable Z = new r();

    public final NadRewardVideoAdOverContainer D2() {
        return (NadRewardVideoAdOverContainer) this.x.getValue();
    }

    public final ExpandIconView E2() {
        return (ExpandIconView) this.z.getValue();
    }

    public final FrameLayout F2() {
        return (FrameLayout) this.u.getValue();
    }

    public final FrameLayout H2() {
        return (FrameLayout) this.y.getValue();
    }

    public final View I2() {
        return (View) this.w.getValue();
    }

    public final ImageView J2() {
        return (ImageView) this.B.getValue();
    }

    public final NadRewardInterceptFrameLayout K2() {
        return (NadRewardInterceptFrameLayout) this.v.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class l implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public l(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        /* loaded from: classes3.dex */
        public static final class a implements dq0.a {
            public a() {
            }

            @Override // com.baidu.tieba.dq0.a
            public void onFail(Exception exc) {
                fq0.j(NadRewardVideoActivity.Q1(l.this.b).f.d, "4");
                Toast.makeText(l.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.dq0.a
            public void a(ks0 ks0Var) {
                String str;
                NadRewardVideoActivity.Q1(l.this.b).g().E(ks0Var);
                String str2 = null;
                if (ks0Var != null) {
                    str = ks0Var.f();
                } else {
                    str = null;
                }
                if (!Intrinsics.areEqual(str, "1")) {
                    l.this.b.m3();
                    String str3 = NadRewardVideoActivity.Q1(l.this.b).f.d;
                    if (ks0Var != null) {
                        str2 = ks0Var.a();
                    }
                    fq0.k(str3, "4", str2);
                    return;
                }
                l.this.a.setFestivalEntranceContainerInvisible();
                Toast.makeText(l.this.b, ks0Var.d(), 0).show();
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.Q1(this.b).g().k() != null) {
                ks0 k = NadRewardVideoActivity.Q1(this.b).g().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    ks0 k2 = NadRewardVideoActivity.Q1(nadRewardVideoActivity).g().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.m3();
                return;
            }
            dq0 dq0Var = dq0.a;
            ps0 g = NadRewardVideoActivity.Q1(this.b).g();
            qs0 m = NadRewardVideoActivity.Q1(this.b).g().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            dq0Var.d(g, str, new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class q extends xn0<ao0> {

        /* loaded from: classes3.dex */
        public static final class a implements dq0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.dq0.a
            public void onFail(Exception exc) {
                fq0.j(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.dq0.a
            public void a(ks0 ks0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.D2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (ks0Var != null) {
                    str = ks0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (ks0Var != null) {
                    str2 = ks0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                    if (ks0Var != null) {
                        str3 = ks0Var.a();
                    }
                    fq0.k(str4, "5", str3);
                }
            }
        }

        public q(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xn0
        public void onEvent(ao0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().b()) {
                dq0 dq0Var = dq0.a;
                ps0 g = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).g();
                ks0 k = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).g().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                dq0Var.d(g, str, new a());
                NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().f(false);
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
            NadRewardVideoActivity.this.z2();
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
            pi0 pi0Var;
            mr0 mr0Var;
            if (NadRewardVideoActivity.Q1(this.b).d() != null) {
                js0 d = NadRewardVideoActivity.Q1(this.b).d();
                Intrinsics.checkNotNull(d);
                pi0Var = new pi0(d.b());
            } else {
                qr0 qr0Var = NadRewardVideoActivity.Q1(this.b).m;
                if (qr0Var != null) {
                    mr0Var = qr0Var.p;
                } else {
                    mr0Var = null;
                }
                pi0Var = new pi0(mr0Var);
            }
            tn0.a().a(pi0Var);
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
            NadRewardVideoActivity.this.z2();
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
            NadRewardVideoActivity.this.z2();
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.n3();
            fq0.f(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this));
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
            String str2 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
            qp0 qp0Var = NadRewardVideoActivity.this.Q;
            if (qp0Var != null) {
                str = qp0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            fq0.p(str2, !z);
            if (NadRewardVideoActivity.this.k3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ x71 b;

        public j(x71 x71Var) {
            this.b = x71Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            fq0.r(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this));
            if (!NadRewardVideoActivity.this.A2(this.b.c)) {
                if (Intrinsics.areEqual(this.b.c, "__CONVERT_CMD__")) {
                    if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).m()) {
                        xj0.c(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f(), NadRewardVideoActivity.this);
                        return;
                    }
                    String str2 = null;
                    if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).l()) {
                        NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                        qr0 qr0Var = NadRewardVideoActivity.Q1(nadRewardVideoActivity).m;
                        if (qr0Var != null) {
                            str = qr0Var.t;
                        } else {
                            str = null;
                        }
                        if (nadRewardVideoActivity.A2(str)) {
                            NadRewardVideoActivity.this.n3();
                            return;
                        }
                    }
                    qr0 qr0Var2 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).m;
                    if (qr0Var2 != null) {
                        str2 = qr0Var2.t;
                    }
                    xj0.c(str2, NadRewardVideoActivity.this);
                    return;
                }
                xj0.c(this.b.c, NadRewardVideoActivity.this);
                return;
            }
            NadRewardVideoActivity.this.n3();
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public k(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            qr0 qr0Var;
            mr0 mr0Var;
            String str;
            boolean z;
            String str2;
            String str3;
            mr0 mr0Var2;
            mr0 mr0Var3;
            mr0 mr0Var4;
            mr0 mr0Var5;
            if (NadRewardVideoActivity.Q1(this.b).l()) {
                NadRewardVideoActivity nadRewardVideoActivity = this.b;
                if (nadRewardVideoActivity.A2(NadRewardVideoActivity.Q1(nadRewardVideoActivity).f.c)) {
                    this.b.n3();
                }
            }
            if (NadRewardVideoActivity.Q1(this.b).m() && (qr0Var = NadRewardVideoActivity.Q1(this.b).m) != null && (mr0Var = qr0Var.p) != null && mr0Var.e) {
                qr0 qr0Var2 = NadRewardVideoActivity.Q1(this.b).m;
                String str4 = null;
                if (qr0Var2 != null && (mr0Var5 = qr0Var2.p) != null) {
                    str = mr0Var5.b;
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
                    qr0 qr0Var3 = NadRewardVideoActivity.Q1(this.b).m;
                    if (qr0Var3 != null && (mr0Var4 = qr0Var3.p) != null) {
                        str2 = mr0Var4.a;
                    } else {
                        str2 = null;
                    }
                    if (!((str2 == null || str2.length() == 0) ? true : true)) {
                        qr0 qr0Var4 = NadRewardVideoActivity.Q1(this.b).m;
                        if (qr0Var4 != null && (mr0Var3 = qr0Var4.p) != null) {
                            str3 = mr0Var3.a;
                        } else {
                            str3 = null;
                        }
                        if (w51.d(str3)) {
                            Context context = this.a.getContext();
                            qr0 qr0Var5 = NadRewardVideoActivity.Q1(this.b).m;
                            if (qr0Var5 != null && (mr0Var2 = qr0Var5.p) != null) {
                                str4 = mr0Var2.a;
                            }
                            Intrinsics.checkNotNull(str4);
                            kk0.b(context, str4);
                        }
                    }
                }
                xj0.b(w51.b(NadRewardVideoActivity.Q1(this.b), NadRewardVideoActivity.Q1(this.b).f()));
            }
            this.b.z2();
            NadRewardVideoActivity.Q1(this.b).h().e(true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class m extends qu0 {
        public m() {
        }

        @Override // com.baidu.tieba.qu0, com.baidu.tieba.ju0
        public void onEnd(int i) {
            String str;
            ds0 ds0Var;
            p81 p81Var;
            NadRewardBigCardView nadRewardBigCardView;
            if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).b() == null) {
                tp0 tp0Var = NadRewardVideoActivity.this.D;
                if (tp0Var != null) {
                    tp0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardVideoActivity.this.O;
                if (nadRewardBigCardView2 != null) {
                    nadRewardBigCardView2.setVisibility(false);
                }
                NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().i(true);
                String str2 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                qp0 qp0Var = NadRewardVideoActivity.this.Q;
                String str3 = null;
                if (qp0Var != null) {
                    str = qp0Var.f();
                } else {
                    str = null;
                }
                bs0 bs0Var = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).j;
                if (bs0Var != null && (ds0Var = bs0Var.i) != null) {
                    str3 = ds0Var.a;
                }
                fq0.t(str2, str, str3);
            } else {
                hs0 c = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).c();
                if (c != null && c.b() && (((p81Var = NadRewardVideoActivity.this.E) == null || !p81Var.isShowing()) && (nadRewardBigCardView = NadRewardVideoActivity.this.O) != null)) {
                    nadRewardBigCardView.y(true);
                }
                NadRewardVideoActivity.this.i3(true);
                NadRewardVideoActivity.this.j3();
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.A;
            if (adImageView != null) {
                adImageView.bringToFront();
            }
        }

        @Override // com.baidu.tieba.qu0, com.baidu.tieba.ju0
        public void onStart() {
            NadRewardVideoActivity.this.i3(false);
            tp0 tp0Var = NadRewardVideoActivity.this.D;
            if (tp0Var != null) {
                tp0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class n extends w11 {
        @Override // com.baidu.tieba.w11, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (yp0.a().a()) {
                return 2;
            }
            return 1;
        }
    }

    /* loaded from: classes3.dex */
    public static final class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (NadRewardVideoActivity.this.F2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                nadRewardVideoActivity.R = nadRewardVideoActivity.F2().getMeasuredHeight() / NadRewardVideoActivity.this.F2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class p implements xp0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public p() {
        }

        @Override // com.baidu.tieba.xp0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.Q = null;
            NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().j(false);
        }

        @Override // com.baidu.tieba.xp0.b
        public void a(qp0 qp0Var) {
            boolean z;
            AdDownloadStatus adDownloadStatus;
            boolean z2;
            NadRewardVideoActivity.this.Q = qp0Var;
            if (qp0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.f1050T++;
            int i = 0;
            if (qp0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.f(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).g().b(qp0Var.d()));
                }
                fq0.d(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, qp0Var.d(), NadRewardVideoActivity.this.G2(), qp0Var.f(), qp0Var.h());
                if (qp0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    fq0.u(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "2", qp0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(qp0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                }
                if (i <= 0) {
                    fq0.l(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            fq0.g(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "1", qp0Var.d());
            NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().j(qp0Var.c());
            NadRewardVideoActivity.this.a0 = !qp0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).g().t());
            NadRewardVideoActivity.this.d3("0", "任务完成回调", hashMap);
            ue1<View> transitionButtonView = NadRewardVideoActivity.this.D2().getTransitionButtonView();
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
            NadRewardTaskHelper nadRewardTaskHelper = NadRewardVideoActivity.this.W;
            if (nadRewardTaskHelper != null) {
                String str = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                Intrinsics.checkNotNullExpressionValue(str, "adModel.common.extraParam");
                nadRewardTaskHelper.t(qp0Var, adDownloadStatus, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardVideoActivity.this.Y = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class s implements v81 {
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ NadRewardVideoActivity b;
        public final /* synthetic */ long c;

        @Override // com.baidu.tieba.v81
        public void a() {
        }

        @Override // com.baidu.tieba.v81
        public void dismiss() {
        }

        @Override // com.baidu.tieba.v81
        public void f() {
        }

        public s(Boolean bool, NadRewardVideoActivity nadRewardVideoActivity, long j) {
            this.a = bool;
            this.b = nadRewardVideoActivity;
            this.c = j;
        }

        @Override // com.baidu.tieba.v81
        public void b() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.v81
        public void d() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.v81
        public void c() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (this.b.Y) {
                yr0 Q1 = NadRewardVideoActivity.Q1(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                fq0.o(Q1, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                return;
            }
            yr0 Q12 = NadRewardVideoActivity.Q1(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            fq0.o(Q12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
        }

        @Override // com.baidu.tieba.v81
        public void e() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (Intrinsics.areEqual(this.a, Boolean.TRUE) && this.b.Y) {
                yr0 Q1 = NadRewardVideoActivity.Q1(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                fq0.o(Q1, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                return;
            }
            yr0 Q12 = NadRewardVideoActivity.Q1(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            fq0.o(Q12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
        }
    }

    /* loaded from: classes3.dex */
    public static final class t implements PopupWindow.OnDismissListener {
        public t() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            mu0 mu0Var = NadRewardVideoActivity.this.I;
            if (mu0Var != null) {
                mu0Var.resume();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.A;
            if (adImageView != null) {
                ExtensionsKt.e(adImageView, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class u implements v81 {
        @Override // com.baidu.tieba.v81
        public void b() {
        }

        @Override // com.baidu.tieba.v81
        public void c() {
        }

        @Override // com.baidu.tieba.v81
        public void d() {
        }

        @Override // com.baidu.tieba.v81
        public void dismiss() {
        }

        @Override // com.baidu.tieba.v81
        public void e() {
        }

        @Override // com.baidu.tieba.v81
        public void f() {
        }

        public u() {
        }

        @Override // com.baidu.tieba.v81
        public void a() {
            fq0.i(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1() {
        super.C1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        mu0 mu0Var = this.I;
        if (mu0Var != null) {
            mu0Var.release();
        }
        this.I = null;
        NadRewardVideoDialog nadRewardVideoDialog = this.J;
        if (nadRewardVideoDialog != null) {
            nadRewardVideoDialog.onDestroy();
        }
        NadRewardVideoDialog nadRewardVideoDialog2 = this.K;
        if (nadRewardVideoDialog2 != null) {
            nadRewardVideoDialog2.onDestroy();
        }
        NadRewardVideoDialog nadRewardVideoDialog3 = this.L;
        if (nadRewardVideoDialog3 != null) {
            nadRewardVideoDialog3.onDestroy();
        }
        NadRewardSuspendDialog nadRewardSuspendDialog = this.M;
        if (nadRewardSuspendDialog != null) {
            nadRewardSuspendDialog.onDestroy();
        }
        NadRewardLottieDialog nadRewardLottieDialog = this.N;
        if (nadRewardLottieDialog != null) {
            nadRewardLottieDialog.onDestroy();
        }
        D2().y();
        NadRewardTaskHelper nadRewardTaskHelper = this.W;
        if (nadRewardTaskHelper != null) {
            nadRewardTaskHelper.F();
        }
        Handler handler = this.X;
        if (handler != null) {
            handler.removeCallbacks(this.Z);
        }
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.x();
        }
    }

    public final void O2() {
        if (this.A == null) {
            this.A = new AdImageView(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = BadgeDrawable.TOP_END;
            layoutParams.topMargin = g61.c.a(this, 1.5f);
            layoutParams.setMarginEnd(g61.c.a(this, 5.0f));
            layoutParams.height = g61.c.a(this, 39.0f);
            layoutParams.width = g61.c.a(this, 39.0f);
            F2().addView(this.A, layoutParams);
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            int a2 = g61.c.a(adImageView.getContext(), 10.0f);
            adImageView.setPadding(a2, a2, a2, a2);
            adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            adImageView.setOnClickListener(new i());
        }
    }

    public final void P2() {
        if (this.C == null) {
            NadVideoRewardCountDownView nadVideoRewardCountDownView = new NadVideoRewardCountDownView(this, null, 0, 6, null);
            AbsRewardCountDownView.b(nadVideoRewardCountDownView, F2(), 0, false, null, 14, null);
            Unit unit = Unit.INSTANCE;
            this.C = nadVideoRewardCountDownView;
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.bringToFront();
        }
        AbsRewardCountDownView absRewardCountDownView2 = this.C;
        if (absRewardCountDownView2 != null) {
            absRewardCountDownView2.e();
        }
        AbsRewardCountDownView absRewardCountDownView3 = this.C;
        if (absRewardCountDownView3 != null) {
            yr0 yr0Var = this.P;
            if (yr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = yr0Var.g().s();
            yr0 yr0Var2 = this.P;
            if (yr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, yr0Var2.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$2
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
                    NadRewardVideoActivity.this.a3();
                }
            });
        }
    }

    public final boolean p3() {
        String str;
        boolean z;
        if (!this.a0) {
            return false;
        }
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ps0 g2 = yr0Var.g();
        qp0 qp0Var = this.Q;
        if (qp0Var != null) {
            str = qp0Var.e();
        } else {
            str = null;
        }
        String l2 = g2.l(str);
        if (l2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || Intrinsics.areEqual(l2, "{}")) {
            return false;
        }
        NadRewardVideoDialog w2 = w2(this, l2, false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        w2.show(supportFragmentManager, (String) null);
        this.L = w2;
        c3();
        return true;
    }

    public final void z2() {
        boolean z;
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = yr0Var.e;
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
            s31.b(monitorUrl.clickUrl);
        }
    }

    public static final /* synthetic */ yr0 Q1(NadRewardVideoActivity nadRewardVideoActivity) {
        yr0 yr0Var = nadRewardVideoActivity.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return yr0Var;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void A1(Bundle bundle) {
        super.A1(bundle);
        setContentView(R.layout.nad_reward_video_lp_activity);
        F2().post(new o());
        this.X = new Handler(Looper.getMainLooper());
        if (!b3()) {
            finish();
            return;
        }
        R2();
        L2();
    }

    public final boolean A2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !lk0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new ck0(str).a(), "rewardWebPanel");
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1(Intent intent) {
        super.D1(intent);
        setIntent(intent);
        if (!b3()) {
            k51.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
            return;
        }
        L2();
        l3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean L1(Bundle bundle) {
        if (!super.L1(bundle)) {
            return false;
        }
        getWindow().setSoftInputMode(19);
        getWindow().setFormat(-3);
        requestWindowFeature(1);
        setEnableSliding(false);
        setCurrentActivityNoTransparent();
        return true;
    }

    public final void i3(boolean z) {
        int i2;
        ViewGroup.LayoutParams layoutParams = I2().getLayoutParams();
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            i2 = nadRewardBigCardView.getHeight();
        } else {
            i2 = 0;
        }
        if (z) {
            layoutParams.height = g61.c.c(this) - i2;
        } else {
            layoutParams.height = g61.c.a(this, 33.0f);
        }
        I2().setLayoutParams(layoutParams);
    }

    public final boolean s3(String str) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        NadRewardVideoDialog v2 = v2(str, true);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        v2.show(supportFragmentManager, (String) null);
        this.J = v2;
        c3();
        return true;
    }

    public static /* synthetic */ NadRewardVideoDialog w2(NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nadRewardVideoActivity.v2(str, z);
    }

    public final boolean B2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null).contains(String.valueOf(this.U))) {
            return false;
        }
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        yr0Var.h().h(this.U);
        return true;
    }

    public final void C2() {
        int a2 = n61.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.U = a2;
        n61.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void E1() {
        super.E1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
        mu0 mu0Var = this.I;
        if (mu0Var != null) {
            mu0Var.pause();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.S int), ('_' char), (wrap: int : 0x000f: IGET  (r1v2 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.T int)] */
    public final String G2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.S);
        sb.append('_');
        sb.append(this.f1050T);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…d(rewardCount).toString()");
        return sb2;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void I1() {
        super.I1();
        if (Z2()) {
            return;
        }
        h3();
    }

    public final void L2() {
        g3();
        V2();
        N2();
        P2();
        X2();
        W2();
        O2();
        T2();
        S2();
        U2();
        M2();
        Q2();
        t3();
    }

    public final void Q2() {
        if (this.W == null) {
            this.W = new NadRewardTaskHelper();
        }
        NadRewardTaskHelper nadRewardTaskHelper = this.W;
        if (nadRewardTaskHelper != null) {
            yr0 yr0Var = this.P;
            if (yr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(yr0Var);
        }
    }

    public final void R2() {
        int a2 = n61.a("nad_reward_sp", "key_session_count", 1);
        this.S = a2;
        n61.e("nad_reward_sp", "key_session_count", a2 + 1);
    }

    public final void V2() {
        boolean z;
        ImageView J2 = J2();
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var.d() != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            J2.setVisibility(0);
        } else {
            J2.setVisibility(8);
        }
    }

    public final void a3() {
        xp0 b2 = yp0.b();
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        b2.a(yr0Var, new os0(this.S, this.f1050T), new p());
    }

    public final void c3() {
        mu0 mu0Var = this.I;
        if (mu0Var != null) {
            mu0Var.pause();
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
    }

    public final void f3() {
        tn0.a().b(this, new q(ao0.class));
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        yr0 yr0Var = this.P;
        if (yr0Var != null) {
            if (yr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            is0 f2 = yr0Var.g().f();
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
                xj0.c(str, this);
            }
        }
        super.finish();
    }

    public final void g3() {
        this.b0 = false;
        this.Q = null;
        this.Y = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r0 != true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h3() {
        ViewGroup view2;
        boolean z;
        p81 p81Var = this.E;
        if (p81Var == null || !p81Var.isShowing()) {
            tp0 tp0Var = this.D;
            if (tp0Var != null && (view2 = tp0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            mu0 mu0Var = this.I;
            if (mu0Var != null) {
                mu0Var.resume();
            }
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.d();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (k3()) {
            return;
        }
        super.onBackPressed();
    }

    public final void t3() {
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        fq0.q(yr0Var);
        C2();
        yr0 yr0Var2 = this.P;
        if (yr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        xj0.c(yr0Var2.f.m, this);
        r3();
    }

    public final void M2() {
        String f2;
        Integer intOrNull;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        int i2 = 0;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(false);
        }
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var.b() == null) {
            this.O = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        yr0 yr0Var2 = this.P;
        if (yr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(yr0Var2);
        nadRewardBigCardView2.setShowPanelPopCallback(new Function1<Boolean, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initBigCard$$inlined$apply$lambda$1
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                AdImageView adImageView = NadRewardVideoActivity.this.A;
                if (adImageView != null) {
                    ExtensionsKt.e(adImageView, z);
                }
                mu0 mu0Var = NadRewardVideoActivity.this.I;
                if (mu0Var != null) {
                    mu0Var.pause();
                }
            }
        });
        nadRewardBigCardView2.setPanelPopDismissCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initBigCard$$inlined$apply$lambda$2
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
                AdImageView adImageView = NadRewardVideoActivity.this.A;
                if (adImageView != null) {
                    ExtensionsKt.e(adImageView, true);
                }
                AdImageView adImageView2 = NadRewardVideoActivity.this.A;
                if (adImageView2 != null) {
                    adImageView2.bringToFront();
                }
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.bringToFront();
                }
                mu0 mu0Var = NadRewardVideoActivity.this.I;
                if (mu0Var != null) {
                    mu0Var.resume();
                }
            }
        });
        nadRewardBigCardView2.setBackBtnCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initBigCard$$inlined$apply$lambda$3
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
                NadRewardVideoActivity.this.onBackPressed();
            }
        });
        nadRewardBigCardView2.setCloseClickCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initBigCard$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.this.onBackPressed();
            }
        });
        nadRewardBigCardView2.setBigCardShowProgress(new Function1<Float, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initBigCard$$inlined$apply$lambda$5
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f3) {
                invoke(f3.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f3) {
                NadRewardVideoActivity.this.u3(f3);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.O = nadRewardBigCardView2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = -g61.c.c(this);
        F2().addView(this.O, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.O;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.O;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        yr0 yr0Var3 = this.P;
        if (yr0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = yr0Var3.g().s();
        yr0 yr0Var4 = this.P;
        if (yr0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        gs0 b2 = yr0Var4.b();
        if (b2 != null && (f2 = b2.f()) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(f2)) != null) {
            i2 = intOrNull.intValue();
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.c(s2 - i2, new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initBigCard$2
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
                    NadRewardVideoActivity.this.j3();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
        if (r0 == true) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m3() {
        String str;
        p81 p81Var;
        ViewGroup view2;
        boolean z;
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var.g().k() != null) {
            yr0 yr0Var2 = this.P;
            if (yr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (yr0Var2.g().m() != null) {
                yr0 yr0Var3 = this.P;
                if (yr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qs0 m2 = yr0Var3.g().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !au.a(this) && !Z2() && ((p81Var = this.E) == null || !p81Var.isShowing())) {
                    tp0 tp0Var = this.D;
                    if (tp0Var != null && (view2 = tp0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    yr0 yr0Var4 = this.P;
                    if (yr0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ps0 g2 = yr0Var4.g();
                    yr0 yr0Var5 = this.P;
                    if (yr0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ks0 k2 = yr0Var5.g().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    yr0 yr0Var6 = this.P;
                    if (yr0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ks0 k3 = yr0Var6.g().k();
                    Intrinsics.checkNotNull(k3);
                    NadRewardLottieDialog x2 = x2(g2.j(c2, k3.a()));
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    x2.show(supportFragmentManager, (String) null);
                    this.N = x2;
                    c3();
                    return true;
                }
            }
        }
        return false;
    }

    public final void n3() {
        boolean z;
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var.e().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.E = null;
            return;
        }
        p81 p81Var = this.E;
        if (p81Var != null && p81Var.isShowing()) {
            return;
        }
        p81 p81Var2 = new p81(this);
        p81Var2.setOnDismissListener(new t());
        p81Var2.i(new u());
        double a2 = 1 - (g61.c.a(this, 41.0f) / g61.c.c(this));
        yr0 yr0Var2 = this.P;
        if (yr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String e2 = yr0Var2.e();
        yr0 yr0Var3 = this.P;
        if (yr0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        w81 w81Var = new w81(e2, a2, 0, yr0Var3.f.d);
        w81Var.A(false);
        w81Var.C(true);
        w81Var.B(true);
        w81Var.y(true);
        yr0 yr0Var4 = this.P;
        if (yr0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!TextUtils.isEmpty(yr0Var4.f.m)) {
            yr0 yr0Var5 = this.P;
            if (yr0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            w81Var.v(yr0Var5.f.l);
        }
        Unit unit = Unit.INSTANCE;
        p81Var2.h(w81Var);
        p81Var2.j();
        Unit unit2 = Unit.INSTANCE;
        this.E = p81Var2;
        mu0 mu0Var = this.I;
        if (mu0Var != null) {
            mu0Var.pause();
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            ExtensionsKt.e(adImageView, false);
        }
        yr0 yr0Var6 = this.P;
        if (yr0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        yr0Var6.h().g(true);
    }

    public final void N2() {
        ExpandIconView E2 = E2();
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        hs0 c2 = yr0Var.c();
        boolean z = true;
        if ((c2 == null || !c2.e()) ? false : false) {
            E2.setVisibility(0);
        } else {
            E2.setVisibility(8);
            E2 = null;
        }
        if (E2 != null) {
            E2.setOnClickListener(new h());
        }
    }

    public final boolean Z2() {
        NadRewardVideoDialog nadRewardVideoDialog = this.K;
        if (nadRewardVideoDialog != null && nadRewardVideoDialog.isVisible()) {
            return true;
        }
        NadRewardVideoDialog nadRewardVideoDialog2 = this.L;
        if (nadRewardVideoDialog2 != null && nadRewardVideoDialog2.isVisible()) {
            return true;
        }
        NadRewardSuspendDialog nadRewardSuspendDialog = this.M;
        if (nadRewardSuspendDialog != null && nadRewardSuspendDialog.isVisible()) {
            return true;
        }
        NadRewardLottieDialog nadRewardLottieDialog = this.N;
        if (nadRewardLottieDialog != null && nadRewardLottieDialog.isVisible()) {
            return true;
        }
        NadRewardVideoDialog nadRewardVideoDialog3 = this.J;
        if (nadRewardVideoDialog3 != null && nadRewardVideoDialog3.isVisible()) {
            return true;
        }
        return false;
    }

    public final boolean k3() {
        NadRewardTaskHelper nadRewardTaskHelper = this.W;
        if (nadRewardTaskHelper != null && nadRewardTaskHelper.A()) {
            yr0 yr0Var = this.P;
            if (yr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return s3(yr0Var.g().c());
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            long seconds = timeUnit.toSeconds(absRewardCountDownView.getMillisUntilFinished());
            if (seconds <= 0) {
                return p3();
            }
            return o3(seconds);
        }
        return false;
    }

    public final void S2() {
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        x71 a2 = x71.a(yr0Var.j());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.H == null) {
                this.H = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((g61.c.e(this) * 9) / 16) / 2) + g61.c.a(this, 26.0f);
                F2().addView(this.H, layoutParams);
            }
            NadIconTextButton nadIconTextButton = this.H;
            if (nadIconTextButton != null) {
                nadIconTextButton.update(a2);
                nadIconTextButton.setOnClickListener(new j(a2));
                nadIconTextButton.setVisibility(0);
                return;
            }
            return;
        }
        NadIconTextButton nadIconTextButton2 = this.H;
        if (nadIconTextButton2 != null) {
            ExtensionsKt.e(nadIconTextButton2, false);
        }
    }

    public final void T2() {
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        w71 a2 = w71.a(yr0Var.k());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.G == null) {
                this.G = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((g61.c.e(this) * 9) / 16) / 2) + g61.c.a(this, 52.0f);
                layoutParams.setMarginStart(g61.c.a(this, 9.0f));
                layoutParams.setMarginEnd(g61.c.a(this, 8.0f));
                F2().addView(this.G, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.G;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(g61.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
                nadHighLightTextView.setAlpha(0.8f);
                nadHighLightTextView.setGravity(17);
                nadHighLightTextView.update(a2);
                nadHighLightTextView.setVisibility(0);
                return;
            }
            return;
        }
        NadHighLightTextView nadHighLightTextView2 = this.G;
        if (nadHighLightTextView2 != null) {
            ExtensionsKt.e(nadHighLightTextView2, false);
        }
    }

    public final void e3() {
        long j2;
        int i2;
        String d2;
        Integer intOrNull;
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ss0 p2 = yr0Var.g().p();
        if (p2 != null && p2.f() != null) {
            yr0 yr0Var2 = this.P;
            if (yr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ss0 p3 = yr0Var2.g().p();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            AbsRewardCountDownView absRewardCountDownView = this.C;
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
            AbsRewardCountDownView absRewardCountDownView2 = this.C;
            if (absRewardCountDownView2 != null) {
                absRewardCountDownView2.e();
            }
            AbsRewardCountDownView absRewardCountDownView3 = this.C;
            if (absRewardCountDownView3 != null) {
                yr0 yr0Var3 = this.P;
                if (yr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, yr0Var3.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
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
                        NadRewardVideoActivity.this.a3();
                    }
                });
            }
        }
    }

    public final void j3() {
        if (this.b0) {
            return;
        }
        p81 p81Var = this.E;
        if (p81Var != null && p81Var.isShowing()) {
            return;
        }
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        hs0 c2 = yr0Var.c();
        if (c2 != null && c2.b()) {
            yr0 yr0Var2 = this.P;
            if (yr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            bs0 bs0Var = yr0Var2.j;
            if (bs0Var != null) {
                int i2 = bs0Var.c;
                yr0 yr0Var3 = this.P;
                if (yr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == yr0Var3.g().s()) {
                    return;
                }
            }
        }
        this.b0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        tp0 tp0Var = this.D;
        if (tp0Var != null) {
            tp0Var.setVisibility(false);
        }
        NadHighLightTextView nadHighLightTextView = this.G;
        if (nadHighLightTextView != null) {
            ExtensionsKt.e(nadHighLightTextView, false);
        }
        NadIconTextButton nadIconTextButton = this.H;
        if (nadIconTextButton != null) {
            ExtensionsKt.e(nadIconTextButton, false);
        }
        D2().setFestivalEntranceContainerInvisible();
    }

    public final boolean q3() {
        JSONObject jSONObject;
        String f2;
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ss0 p2 = yr0Var.g().p();
        if (p2 == null || p2.f() == null || this.V) {
            return false;
        }
        p81 p81Var = this.E;
        if (p81Var != null && p81Var.isShowing()) {
            return false;
        }
        yr0 yr0Var2 = this.P;
        if (yr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ss0 p3 = yr0Var2.g().p();
        if (p3 != null && (f2 = p3.f()) != null) {
            jSONObject = ExtensionsKt.a(f2);
        } else {
            jSONObject = null;
        }
        NadRewardSuspendDialog y2 = y2(String.valueOf(jSONObject));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        y2.show(supportFragmentManager, (String) null);
        this.V = true;
        this.M = y2;
        c3();
        return true;
    }

    public final void r3() {
        String str;
        String c2;
        Integer intOrNull;
        int i2 = 0;
        this.V = false;
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ss0 p2 = yr0Var.g().p();
        if (p2 != null && p2.f() != null) {
            yr0 yr0Var2 = this.P;
            if (yr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final ss0 p3 = yr0Var2.g().p();
            if (p3 != null) {
                str = p3.b();
            } else {
                str = null;
            }
            if (!B2(str)) {
                AbsRewardCountDownView absRewardCountDownView = this.C;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.setSuspendShowTime(-1);
                }
                AbsRewardCountDownView absRewardCountDownView2 = this.C;
                if (absRewardCountDownView2 != null) {
                    absRewardCountDownView2.setSuspendShowCallback(null);
                    return;
                }
                return;
            }
            yr0 yr0Var3 = this.P;
            if (yr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = yr0Var3.g().s();
            if (p3 != null && (c2 = p3.c()) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(c2)) != null) {
                i2 = intOrNull.intValue();
            }
            AbsRewardCountDownView absRewardCountDownView3 = this.C;
            if (absRewardCountDownView3 != null) {
                absRewardCountDownView3.h(s2 - i2, new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$showSuspendDialogDelay$1
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
                        boolean q3;
                        String str2;
                        q3 = NadRewardVideoActivity.this.q3();
                        if (q3) {
                            String str3 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                            String valueOf = String.valueOf(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().c());
                            ss0 ss0Var = p3;
                            if (ss0Var != null) {
                                str2 = ss0Var.b();
                            } else {
                                str2 = null;
                            }
                            fq0.h(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void U2() {
        ds0 ds0Var;
        ds0 ds0Var2;
        String str;
        ds0 ds0Var3;
        String str2;
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        bs0 bs0Var = yr0Var.j;
        NadRewardHalfTailHolder nadRewardHalfTailHolder = null;
        if (bs0Var != null) {
            ds0Var = bs0Var.i;
        } else {
            ds0Var = null;
        }
        if (ds0Var != null) {
            yr0 yr0Var2 = this.P;
            if (yr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            hs0 c2 = yr0Var2.c();
            if (c2 == null || c2.n()) {
                yr0 yr0Var3 = this.P;
                if (yr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bs0 bs0Var2 = yr0Var3.j;
                if (bs0Var2 != null && (ds0Var2 = bs0Var2.i) != null) {
                    yr0 yr0Var4 = this.P;
                    if (yr0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    bs0 bs0Var3 = yr0Var4.j;
                    if (bs0Var3 != null && (ds0Var3 = bs0Var3.i) != null && (str2 = ds0Var3.x) != null) {
                        qp0 qp0Var = this.Q;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (qp0Var == null || (r4 = qp0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    ds0Var2.x = str;
                }
                tp0 tp0Var = this.D;
                if (tp0Var != null) {
                    tp0Var.setVisibility(false);
                }
                tp0.a aVar = tp0.k0;
                yr0 yr0Var5 = this.P;
                if (yr0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                tp0 a2 = aVar.a(yr0Var5, this);
                this.D = a2;
                if (a2 != null) {
                    yr0 yr0Var6 = this.P;
                    if (yr0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(yr0Var6);
                }
                tp0 tp0Var2 = this.D;
                if (!(tp0Var2 instanceof View)) {
                    tp0Var2 = null;
                }
                View view2 = (View) tp0Var2;
                if (view2 != null) {
                    H2().removeAllViews();
                    H2().addView(view2);
                    H2().bringToFront();
                }
                tp0 tp0Var3 = this.D;
                if (tp0Var3 != null) {
                    tp0Var3.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
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
                            tp0 tp0Var4 = NadRewardVideoActivity.this.D;
                            if (tp0Var4 != null) {
                                tp0Var4.setVisibility(false);
                            }
                            mu0 mu0Var = NadRewardVideoActivity.this.I;
                            if (mu0Var != null) {
                                mu0Var.start();
                            }
                        }
                    });
                }
                tp0 tp0Var4 = this.D;
                if (tp0Var4 instanceof NadRewardHalfTailHolder) {
                    nadRewardHalfTailHolder = tp0Var4;
                }
                NadRewardHalfTailHolder nadRewardHalfTailHolder2 = nadRewardHalfTailHolder;
                if (nadRewardHalfTailHolder2 != null) {
                    nadRewardHalfTailHolder2.setShowPanelPopCallback(new Function1<Boolean, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$$inlined$run$lambda$1
                        {
                            super(1);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            AdImageView adImageView = NadRewardVideoActivity.this.A;
                            if (adImageView != null) {
                                ExtensionsKt.e(adImageView, z);
                            }
                        }
                    });
                    nadRewardHalfTailHolder2.setPanelPopDismissCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$$inlined$run$lambda$2
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
                            AdImageView adImageView = NadRewardVideoActivity.this.A;
                            if (adImageView != null) {
                                ExtensionsKt.e(adImageView, true);
                            }
                            AdImageView adImageView2 = NadRewardVideoActivity.this.A;
                            if (adImageView2 != null) {
                                adImageView2.bringToFront();
                            }
                            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
                            if (absRewardCountDownView != null) {
                                absRewardCountDownView.bringToFront();
                            }
                        }
                    });
                    nadRewardHalfTailHolder2.setBackBtnCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$$inlined$run$lambda$3
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
                            NadRewardVideoActivity.this.onBackPressed();
                        }
                    });
                    nadRewardHalfTailHolder2.setCloseClickCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$$inlined$run$lambda$4
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
                            NadRewardVideoActivity.this.onBackPressed();
                        }
                    });
                    return;
                }
                return;
            }
        }
        tp0 tp0Var5 = this.D;
        if (tp0Var5 != null) {
            tp0Var5.setVisibility(false);
        }
    }

    public final void W2() {
        boolean z;
        int i2;
        pr0 pr0Var;
        int i3;
        ds0 ds0Var;
        NadRewardVideoAdOverContainer D2 = D2();
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var.d() == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        D2.setVisibility(i2);
        D2.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
        yr0 yr0Var2 = this.P;
        if (yr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var2.g().C()) {
            yr0 yr0Var3 = this.P;
            if (yr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = yr0Var3.f.c;
            Context context = D2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (Y2(str, context)) {
                yr0 yr0Var4 = this.P;
                if (yr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qr0 qr0Var = yr0Var4.m;
                if (qr0Var != null) {
                    qr0Var.g = true;
                }
                yr0 yr0Var5 = this.P;
                if (yr0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bs0 bs0Var = yr0Var5.j;
                if (bs0Var != null && (ds0Var = bs0Var.i) != null) {
                    ds0Var.C = true;
                }
            }
        }
        yr0 yr0Var6 = this.P;
        if (yr0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var6.d() != null) {
            yr0 yr0Var7 = this.P;
            if (yr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qr0 qr0Var2 = yr0Var7.m;
            if (qr0Var2 != null) {
                qr0Var2.e = true;
            }
            yr0 yr0Var8 = this.P;
            if (yr0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qr0 qr0Var3 = yr0Var8.m;
            if (qr0Var3 != null) {
                yr0 yr0Var9 = this.P;
                if (yr0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (yr0Var9.m()) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                qr0Var3.a = i3;
            }
            yr0 yr0Var10 = this.P;
            if (yr0Var10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qr0 qr0Var4 = yr0Var10.m;
            if (qr0Var4 != null) {
                yr0 yr0Var11 = this.P;
                if (yr0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                js0 d2 = yr0Var11.d();
                Intrinsics.checkNotNull(d2);
                qr0Var4.p = d2.b();
            }
            yr0 yr0Var12 = this.P;
            if (yr0Var12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qr0 qr0Var5 = yr0Var12.m;
            if (qr0Var5 != null && (pr0Var = qr0Var5.q) != null) {
                yr0 yr0Var13 = this.P;
                if (yr0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                pr0Var.d = yr0Var13.f.d;
            }
        }
        yr0 yr0Var14 = this.P;
        if (yr0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        D2.setData(yr0Var14);
        yr0 yr0Var15 = this.P;
        if (yr0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var15.l()) {
            D2.setBottomLineHeight(g61.c.a(D2.getContext(), 41.0f));
        } else {
            D2.setBottomLineHeight(g61.c.a(D2.getContext(), 10.0f));
        }
        D2.setOnUiClickListener(new k(D2, this));
        D2.setFeedbackBtnVisibility(false);
        D2.setFestivalClickCallback(new l(D2, this));
    }

    public final void X2() {
        boolean z;
        if (this.I == null) {
            nu0 nu0Var = new nu0();
            nu0Var.a = 2;
            mu0 b2 = mu0.a.b(this, 0, nu0Var);
            this.I = b2;
            if (b2 != null) {
                b2.attachToContainer(K2());
            }
        }
        mu0 mu0Var = this.I;
        if (mu0Var != null) {
            mu0Var.d(new n());
            yr0 yr0Var = this.P;
            if (yr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            bs0 bs0Var = yr0Var.j;
            if (bs0Var != null && bs0Var.g) {
                mu0Var.setVideoScalingMode(0);
            } else {
                mu0Var.setVideoScalingMode(2);
            }
            mu0Var.a(new m());
        }
        yr0 yr0Var2 = this.P;
        if (yr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var2.j == null) {
            K2().setVisibility(8);
            this.I = null;
            return;
        }
        mu0 mu0Var2 = this.I;
        if (mu0Var2 != null) {
            yr0 yr0Var3 = this.P;
            if (yr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            bs0 bs0Var2 = yr0Var3.j;
            Intrinsics.checkNotNull(bs0Var2);
            mu0Var2.c(bs0Var2);
        }
        if (NetUtil.a(this)) {
            yr0 yr0Var4 = this.P;
            if (yr0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            hs0 c2 = yr0Var4.c();
            if (c2 != null) {
                z = c2.n();
            } else {
                z = false;
            }
            mu0 mu0Var3 = this.I;
            if (mu0Var3 != null) {
                mu0Var3.setLooping(!z);
            }
            mu0 mu0Var4 = this.I;
            if (mu0Var4 != null) {
                mu0Var4.start();
            }
        } else {
            k51.a().a(this, R.string.nad_reward_video_lp_no_network);
        }
        NadRewardInterceptFrameLayout K2 = K2();
        K2.setVisibility(0);
        yr0 yr0Var5 = this.P;
        if (yr0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        K2.setEnableIntercept(yr0Var5.l());
        K2.setInterceptCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initVideoPlayer$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.n3();
                fq0.s(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this));
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = 0;
        K2.setLayoutParams(layoutParams);
    }

    public final void l3() {
        String str;
        boolean z;
        Boolean bool;
        long j2;
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        js0 d2 = yr0Var.d();
        String str2 = null;
        if (d2 != null) {
            str = d2.c();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            p81 p81Var = this.F;
            if (p81Var != null) {
                p81Var.e();
            }
            this.F = null;
            return;
        }
        p81 p81Var2 = this.F;
        if (p81Var2 != null) {
            p81Var2.e();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Handler handler = this.X;
        if (handler != null) {
            Runnable runnable = this.Z;
            yr0 yr0Var2 = this.P;
            if (yr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            js0 d3 = yr0Var2.d();
            if (d3 != null) {
                j2 = d3.a();
            } else {
                j2 = 0;
            }
            handler.postDelayed(runnable, j2);
        }
        p81 p81Var3 = new p81(this);
        yr0 yr0Var3 = this.P;
        if (yr0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        js0 d4 = yr0Var3.d();
        if (d4 != null) {
            bool = Boolean.valueOf(d4.d());
        } else {
            bool = null;
        }
        p81Var3.i(new s(bool, this, currentTimeMillis));
        double a2 = 1 - (g61.c.a(this, 41.0f) / g61.c.c(this));
        yr0 yr0Var4 = this.P;
        if (yr0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        js0 d5 = yr0Var4.d();
        if (d5 != null) {
            str2 = d5.c();
        }
        String str3 = str2;
        yr0 yr0Var5 = this.P;
        if (yr0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        w81 w81Var = new w81(str3, a2, 0, yr0Var5.f.d);
        w81Var.A(false);
        w81Var.C(true);
        w81Var.w(true);
        w81Var.x(true);
        Unit unit = Unit.INSTANCE;
        p81Var3.h(w81Var);
        p81Var3.j();
        Unit unit2 = Unit.INSTANCE;
        this.F = p81Var3;
    }

    public final boolean Y2(String str, Context context) {
        Object m844constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new ck0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m844constructorimpl = Result.m844constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m844constructorimpl = Result.m844constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m850isFailureimpl(m844constructorimpl)) {
            m844constructorimpl = null;
        }
        String str3 = (String) m844constructorimpl;
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str3));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0096, code lost:
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00dd, code lost:
        if (r5 != null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00df, code lost:
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x010f, code lost:
        if (r5 != null) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b3() {
        Object m844constructorimpl;
        ds0 ds0Var;
        String str;
        ds0 ds0Var2;
        Boolean bool;
        boolean z;
        String d2;
        String str2;
        String replace$default;
        String str3;
        String d3;
        ds0 ds0Var3;
        String str4;
        String replace$default2;
        String str5;
        Serializable serializable;
        String str6 = null;
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
            m844constructorimpl = Result.m844constructorimpl(ResultKt.createFailure(th));
        }
        if (serializable != null) {
            m844constructorimpl = Result.m844constructorimpl(eq0.a.d((HashMap) serializable));
            if (Result.m851isSuccessimpl(m844constructorimpl)) {
                yr0 yr0Var = (yr0) m844constructorimpl;
                this.P = yr0Var;
                if (yr0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bs0 bs0Var = yr0Var.j;
                String str7 = "";
                if (bs0Var != null && (ds0Var3 = bs0Var.i) != null) {
                    yr0 yr0Var2 = this.P;
                    if (yr0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (yr0Var2.m()) {
                        String str8 = ds0Var3.f;
                        if (str8 != null) {
                            yr0 yr0Var3 = this.P;
                            if (yr0Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str8, "__CONVERT_CMD__", yr0Var3.f(), false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        ds0Var3.f = replace$default2;
                    } else {
                        String str9 = ds0Var3.f;
                        if (str9 != null) {
                            yr0 yr0Var4 = this.P;
                            if (yr0Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            qr0 qr0Var = yr0Var4.m;
                            if (qr0Var == null || (str5 = qr0Var.t) == null) {
                                str4 = "";
                            } else {
                                str4 = str5;
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str9, "__CONVERT_CMD__", str4, false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        ds0Var3.f = replace$default2;
                    }
                }
                yr0 yr0Var5 = this.P;
                if (yr0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                gs0 b2 = yr0Var5.b();
                if (b2 != null) {
                    yr0 yr0Var6 = this.P;
                    if (yr0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (yr0Var6.m()) {
                        yr0 yr0Var7 = this.P;
                        if (yr0Var7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        gs0 b3 = yr0Var7.b();
                        if (b3 != null && (d3 = b3.d()) != null) {
                            yr0 yr0Var8 = this.P;
                            if (yr0Var8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d3, "__CONVERT_CMD__", yr0Var8.f(), false, 4, (Object) null);
                        }
                        b2.h(str7);
                    } else {
                        yr0 yr0Var9 = this.P;
                        if (yr0Var9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        gs0 b4 = yr0Var9.b();
                        if (b4 != null && (d2 = b4.d()) != null) {
                            yr0 yr0Var10 = this.P;
                            if (yr0Var10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            qr0 qr0Var2 = yr0Var10.m;
                            if (qr0Var2 == null || (str3 = qr0Var2.t) == null) {
                                str2 = "";
                            } else {
                                str2 = str3;
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d2, "__CONVERT_CMD__", str2, false, 4, (Object) null);
                        }
                        b2.h(str7);
                    }
                }
                yr0 yr0Var11 = this.P;
                if (yr0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qr0 qr0Var3 = yr0Var11.m;
                boolean z2 = true;
                if (qr0Var3 != null) {
                    qr0Var3.d = true;
                }
                yr0 yr0Var12 = this.P;
                if (yr0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qr0 qr0Var4 = yr0Var12.m;
                if (qr0Var4 != null) {
                    yr0 yr0Var13 = this.P;
                    if (yr0Var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    hs0 c2 = yr0Var13.c();
                    if (c2 != null) {
                        z = c2.f();
                    } else {
                        z = false;
                    }
                    qr0Var4.f = z;
                }
                yr0 yr0Var14 = this.P;
                if (yr0Var14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bs0 bs0Var2 = yr0Var14.j;
                if (bs0Var2 != null && (ds0Var2 = bs0Var2.i) != null) {
                    yr0 yr0Var15 = this.P;
                    if (yr0Var15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    hs0 c3 = yr0Var15.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.p());
                    } else {
                        bool = null;
                    }
                    ds0Var2.D = bool;
                }
                yr0 yr0Var16 = this.P;
                if (yr0Var16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bs0 bs0Var3 = yr0Var16.j;
                if (bs0Var3 != null && (ds0Var = bs0Var3.i) != null) {
                    yr0 yr0Var17 = this.P;
                    if (yr0Var17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    hs0 c4 = yr0Var17.c();
                    if (c4 != null) {
                        str = c4.o();
                    } else {
                        str = null;
                    }
                    ds0Var.E = str;
                }
                lp0 lp0Var = (lp0) ServiceManager.getService(lp0.a);
                yr0 yr0Var18 = this.P;
                if (yr0Var18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (yr0Var18.g().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && lp0Var != null) {
                    yr0 yr0Var19 = this.P;
                    if (yr0Var19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ps0 g2 = yr0Var19.g();
                    String a2 = lp0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    g2.F(a2);
                }
                yr0 yr0Var20 = this.P;
                if (yr0Var20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qr0 qr0Var5 = yr0Var20.m;
                if (qr0Var5 != null) {
                    yr0 yr0Var21 = this.P;
                    if (yr0Var21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = yr0Var21.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    qr0Var5.h = list;
                }
                yr0 yr0Var22 = this.P;
                if (yr0Var22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                is0 f2 = yr0Var22.g().f();
                if (f2 != null) {
                    str6 = f2.c();
                }
                this.a0 = Intrinsics.areEqual(str6, "0");
            }
            Throwable m847exceptionOrNullimpl = Result.m847exceptionOrNullimpl(m844constructorimpl);
            if (m847exceptionOrNullimpl != null && zh0.a) {
                k51.a().showToast(this, m847exceptionOrNullimpl.getMessage());
            }
            return Result.m851isSuccessimpl(m844constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final void d3(String str, String str2, HashMap<String, String> hashMap) {
        rp0 rp0Var = new rp0();
        rp0Var.a = str;
        rp0Var.b = hashMap;
        tn0.a().a(rp0Var);
    }

    public final boolean o3(long j2) {
        boolean z;
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (yr0Var.g().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        yr0 yr0Var2 = this.P;
        if (yr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog w2 = w2(this, yr0Var2.g().n(j2), false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        w2.show(supportFragmentManager, (String) null);
        this.K = w2;
        c3();
        return true;
    }

    public final NadRewardLottieDialog x2(final String str) {
        f3();
        NadRewardLottieDialog nadRewardLottieDialog = new NadRewardLottieDialog();
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = yr0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.i2(str, str2);
        yr0 yr0Var2 = this.P;
        if (yr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.x2(yr0Var2.g().k());
        nadRewardLottieDialog.g2(new d(str));
        nadRewardLottieDialog.l2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.h3();
            }
        });
        nadRewardLottieDialog.e2(new e(str));
        nadRewardLottieDialog.n2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().f(true);
            }
        });
        return nadRewardLottieDialog;
    }

    public final void u3(float f2) {
        float f3;
        boolean z;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            f3 = nadRewardBigCardView.getHeight();
        } else {
            f3 = 0.0f;
        }
        float e2 = ((g61.c.e(this) / g61.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        bs0 bs0Var = yr0Var.j;
        if (bs0Var != null) {
            if (bs0Var.f > 0.0f) {
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
        K2().setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        layoutParams2.bottomMargin = (int) ((f2 - 1) * f3);
        NadRewardBigCardView nadRewardBigCardView2 = this.O;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.setLayoutParams(layoutParams2);
        }
    }

    public final NadRewardVideoDialog v2(final String str, final boolean z) {
        boolean z2;
        Integer num;
        String valueOf;
        boolean z3;
        final NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = yr0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.i2(str, str2);
        pp0 T1 = nadRewardVideoDialog.T1();
        boolean z4 = true;
        if (T1 != null) {
            if (z) {
                yr0 yr0Var2 = this.P;
                if (yr0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (yr0Var2.h().d()) {
                    z3 = true;
                    T1.M(z3);
                }
            }
            z3 = false;
            T1.M(z3);
        }
        pp0 T12 = nadRewardVideoDialog.T1();
        if (T12 != null) {
            yr0 yr0Var3 = this.P;
            if (yr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            T12.L(yr0Var3.g().r());
        }
        pp0 T13 = nadRewardVideoDialog.T1();
        if (T13 != null) {
            yr0 yr0Var4 = this.P;
            if (yr0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (yr0Var4.g().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                yr0 yr0Var5 = this.P;
                if (yr0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = yr0Var5.g().i();
            } else {
                yr0 yr0Var6 = this.P;
                if (yr0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                us0 q2 = yr0Var6.g().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            T13.I(valueOf);
        }
        pp0 T14 = nadRewardVideoDialog.T1();
        if (T14 != null) {
            yr0 yr0Var7 = this.P;
            if (yr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (yr0Var7.d() == null) {
                z4 = false;
            }
            T14.H(z4);
        }
        nadRewardVideoDialog.g2(new a(str, z));
        nadRewardVideoDialog.l2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.h3();
            }
        });
        nadRewardVideoDialog.e2(new b(str, z));
        nadRewardVideoDialog.h2(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4
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

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
                if (r4.p() == true) goto L23;
             */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(String str3) {
                qr0 qr0Var;
                mr0 mr0Var;
                String str4;
                boolean z5;
                String str5;
                String str6;
                mr0 mr0Var2;
                mr0 mr0Var3;
                mr0 mr0Var4;
                mr0 mr0Var5;
                p81 p81Var;
                ViewGroup view2;
                boolean z6;
                boolean z7 = false;
                if (NadRewardVideoActivity.Q1(this).l() && this.A2(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                    tp0 tp0Var = this.D;
                    if (tp0Var != null && (view2 = tp0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            hs0 c2 = NadRewardVideoActivity.Q1(this).c();
                            if (c2 != null) {
                            }
                        }
                    }
                    p81Var = this.F;
                    if (p81Var == null || !p81Var.isShowing()) {
                        this.n3();
                    }
                }
                if (NadRewardVideoActivity.Q1(this).m() && (qr0Var = NadRewardVideoActivity.Q1(this).m) != null && (mr0Var = qr0Var.p) != null && mr0Var.e) {
                    qr0 qr0Var2 = NadRewardVideoActivity.Q1(this).m;
                    String str7 = null;
                    if (qr0Var2 != null && (mr0Var5 = qr0Var2.p) != null) {
                        str4 = mr0Var5.b;
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && str4.length() != 0) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        qr0 qr0Var3 = NadRewardVideoActivity.Q1(this).m;
                        if (qr0Var3 != null && (mr0Var4 = qr0Var3.p) != null) {
                            str5 = mr0Var4.a;
                        } else {
                            str5 = null;
                        }
                        if (!((str5 == null || str5.length() == 0) ? true : true)) {
                            qr0 qr0Var4 = NadRewardVideoActivity.Q1(this).m;
                            if (qr0Var4 != null && (mr0Var3 = qr0Var4.p) != null) {
                                str6 = mr0Var3.a;
                            } else {
                                str6 = null;
                            }
                            if (w51.d(str6)) {
                                Context context = NadRewardVideoDialog.this.getContext();
                                if (context != null) {
                                    qr0 qr0Var5 = NadRewardVideoActivity.Q1(this).m;
                                    if (qr0Var5 != null && (mr0Var2 = qr0Var5.p) != null) {
                                        str7 = mr0Var2.a;
                                    }
                                    Intrinsics.checkNotNull(str7);
                                    kk0.b(context, str7);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    xj0.b(w51.b(NadRewardVideoActivity.Q1(this), NadRewardVideoActivity.Q1(this).f()));
                }
            }
        });
        nadRewardVideoDialog.m2(new c(nadRewardVideoDialog, this, str, z));
        return nadRewardVideoDialog;
    }

    public final NadRewardSuspendDialog y2(final String str) {
        String str2;
        String str3;
        NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
        yr0 yr0Var = this.P;
        if (yr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = yr0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.i2(str, str4);
        pp0 T1 = nadRewardSuspendDialog.T1();
        String str5 = null;
        if (T1 != null) {
            yr0 yr0Var2 = this.P;
            if (yr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ss0 p2 = yr0Var2.g().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            T1.G(str3);
        }
        pp0 T12 = nadRewardSuspendDialog.T1();
        if (T12 != null) {
            yr0 yr0Var3 = this.P;
            if (yr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ss0 p3 = yr0Var3.g().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            T12.K(str2);
        }
        pp0 T13 = nadRewardSuspendDialog.T1();
        if (T13 != null) {
            yr0 yr0Var4 = this.P;
            if (yr0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ss0 p4 = yr0Var4.g().p();
            if (p4 != null) {
                str5 = p4.g();
            }
            T13.N(str5);
        }
        nadRewardSuspendDialog.g2(new f(str));
        nadRewardSuspendDialog.l2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.h3();
            }
        });
        nadRewardSuspendDialog.e2(new g(str));
        nadRewardSuspendDialog.o2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.this.e3();
            }
        });
        return nadRewardSuspendDialog;
    }
}
