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
import com.baidu.android.common.others.lang.StringUtil;
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
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.R;
import com.baidu.tieba.a41;
import com.baidu.tieba.aq0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.e31;
import com.baidu.tieba.ei0;
import com.baidu.tieba.eq0;
import com.baidu.tieba.fi0;
import com.baidu.tieba.fn0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.gs0;
import com.baidu.tieba.h41;
import com.baidu.tieba.hs0;
import com.baidu.tieba.iq0;
import com.baidu.tieba.j61;
import com.baidu.tieba.jg0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.kn0;
import com.baidu.tieba.kp0;
import com.baidu.tieba.kq0;
import com.baidu.tieba.ks0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.m11;
import com.baidu.tieba.mq0;
import com.baidu.tieba.nl0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.oc1;
import com.baidu.tieba.oq0;
import com.baidu.tieba.p61;
import com.baidu.tieba.q31;
import com.baidu.tieba.q51;
import com.baidu.tieba.q61;
import com.baidu.tieba.qz0;
import com.baidu.tieba.r51;
import com.baidu.tieba.rh0;
import com.baidu.tieba.rl0;
import com.baidu.tieba.rn0;
import com.baidu.tieba.sn0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.tf0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.wh0;
import com.baidu.tieba.ws;
import com.baidu.tieba.xn0;
import com.baidu.tieba.xp0;
import com.baidu.tieba.yn0;
import com.baidu.tieba.zn0;
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
/* loaded from: classes2.dex */
public final class NadRewardVideoActivity extends BaseActivity {
    public AdImageView A;
    public AbsRewardCountDownView C;
    public nn0 D;
    public j61 E;
    public j61 F;
    public NadHighLightTextView G;
    public NadIconTextButton H;
    public gs0 I;
    public NadRewardVideoDialog J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardSuspendDialog M;
    public NadRewardLottieDialog N;
    public NadRewardBigCardView O;
    public sp0 P;
    public kn0 Q;
    public float R;
    public int S;
    public int T;
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

    public final NadRewardVideoAdOverContainer N2() {
        return (NadRewardVideoAdOverContainer) this.x.getValue();
    }

    public final ExpandIconView O2() {
        return (ExpandIconView) this.z.getValue();
    }

    public final FrameLayout P2() {
        return (FrameLayout) this.u.getValue();
    }

    public final FrameLayout R2() {
        return (FrameLayout) this.y.getValue();
    }

    public final View S2() {
        return (View) this.w.getValue();
    }

    public final ImageView T2() {
        return (ImageView) this.B.getValue();
    }

    public final NadRewardInterceptFrameLayout U2() {
        return (NadRewardInterceptFrameLayout) this.v.getValue();
    }

    /* loaded from: classes2.dex */
    public static final class l implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public l(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        /* loaded from: classes2.dex */
        public static final class a implements xn0.a {
            public a() {
            }

            @Override // com.baidu.tieba.xn0.a
            public void onFail(Exception exc) {
                zn0.j(NadRewardVideoActivity.a2(l.this.b).f.d, "4");
                Toast.makeText(l.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.xn0.a
            public void a(eq0 eq0Var) {
                String str;
                NadRewardVideoActivity.a2(l.this.b).g().E(eq0Var);
                String str2 = null;
                if (eq0Var != null) {
                    str = eq0Var.f();
                } else {
                    str = null;
                }
                if (!Intrinsics.areEqual(str, "1")) {
                    l.this.b.w3();
                    String str3 = NadRewardVideoActivity.a2(l.this.b).f.d;
                    if (eq0Var != null) {
                        str2 = eq0Var.a();
                    }
                    zn0.k(str3, "4", str2);
                    return;
                }
                l.this.a.setFestivalEntranceContainerInvisible();
                Toast.makeText(l.this.b, eq0Var.d(), 0).show();
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.a2(this.b).g().k() != null) {
                eq0 k = NadRewardVideoActivity.a2(this.b).g().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    eq0 k2 = NadRewardVideoActivity.a2(nadRewardVideoActivity).g().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.w3();
                return;
            }
            xn0 xn0Var = xn0.a;
            jq0 g = NadRewardVideoActivity.a2(this.b).g();
            kq0 m = NadRewardVideoActivity.a2(this.b).g().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            xn0Var.d(g, str, new a());
        }
    }

    /* loaded from: classes2.dex */
    public static final class q extends rl0<ul0> {

        /* loaded from: classes2.dex */
        public static final class a implements xn0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.xn0.a
            public void onFail(Exception exc) {
                zn0.j(NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.xn0.a
            public void a(eq0 eq0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.N2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (eq0Var != null) {
                    str = eq0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (eq0Var != null) {
                    str2 = eq0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d;
                    if (eq0Var != null) {
                        str3 = eq0Var.a();
                    }
                    zn0.k(str4, "5", str3);
                }
            }
        }

        public q(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rl0
        public void onEvent(ul0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.a2(NadRewardVideoActivity.this).h().b()) {
                xn0 xn0Var = xn0.a;
                jq0 g = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).g();
                eq0 k = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).g().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                xn0Var.d(g, str, new a());
                NadRewardVideoActivity.a2(NadRewardVideoActivity.this).h().f(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public a(String str, boolean z) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements NadRewardVideoDialog.a {
        public b(String str, boolean z) {
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.a
        public final void a() {
            NadRewardVideoActivity.this.J2();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoDialog a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public c(NadRewardVideoDialog nadRewardVideoDialog, NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z) {
            this.a = nadRewardVideoDialog;
            this.b = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            jg0 jg0Var;
            gp0 gp0Var;
            if (NadRewardVideoActivity.a2(this.b).d() != null) {
                dq0 d = NadRewardVideoActivity.a2(this.b).d();
                Intrinsics.checkNotNull(d);
                jg0Var = new jg0(d.b());
            } else {
                kp0 kp0Var = NadRewardVideoActivity.a2(this.b).m;
                if (kp0Var != null) {
                    gp0Var = kp0Var.p;
                } else {
                    gp0Var = null;
                }
                jg0Var = new jg0(gp0Var);
            }
            nl0.a().a(jg0Var);
            this.a.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        public d(String str) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements NadRewardVideoDialog.a {
        public e(String str) {
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.a
        public final void a() {
            NadRewardVideoActivity.this.J2();
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        public f(String str) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements NadRewardVideoDialog.a {
        public g(String str) {
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.a
        public final void a() {
            NadRewardVideoActivity.this.J2();
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.x3();
            zn0.f(NadRewardVideoActivity.a2(NadRewardVideoActivity.this));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            boolean z;
            String str2 = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d;
            kn0 kn0Var = NadRewardVideoActivity.this.Q;
            if (kn0Var != null) {
                str = kn0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            zn0.p(str2, !z);
            if (NadRewardVideoActivity.this.u3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ r51 b;

        public j(r51 r51Var) {
            this.b = r51Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            zn0.r(NadRewardVideoActivity.a2(NadRewardVideoActivity.this));
            if (!NadRewardVideoActivity.this.K2(this.b.c)) {
                if (Intrinsics.areEqual(this.b.c, "__CONVERT_CMD__")) {
                    if (NadRewardVideoActivity.a2(NadRewardVideoActivity.this).m()) {
                        rh0.c(NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f(), NadRewardVideoActivity.this);
                        return;
                    }
                    String str2 = null;
                    if (NadRewardVideoActivity.a2(NadRewardVideoActivity.this).l()) {
                        NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                        kp0 kp0Var = NadRewardVideoActivity.a2(nadRewardVideoActivity).m;
                        if (kp0Var != null) {
                            str = kp0Var.t;
                        } else {
                            str = null;
                        }
                        if (nadRewardVideoActivity.K2(str)) {
                            NadRewardVideoActivity.this.x3();
                            return;
                        }
                    }
                    kp0 kp0Var2 = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).m;
                    if (kp0Var2 != null) {
                        str2 = kp0Var2.t;
                    }
                    rh0.c(str2, NadRewardVideoActivity.this);
                    return;
                }
                rh0.c(this.b.c, NadRewardVideoActivity.this);
                return;
            }
            NadRewardVideoActivity.this.x3();
        }
    }

    /* loaded from: classes2.dex */
    public static final class k implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public k(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            kp0 kp0Var;
            gp0 gp0Var;
            String str;
            boolean z;
            String str2;
            String str3;
            gp0 gp0Var2;
            gp0 gp0Var3;
            gp0 gp0Var4;
            gp0 gp0Var5;
            if (NadRewardVideoActivity.a2(this.b).l()) {
                NadRewardVideoActivity nadRewardVideoActivity = this.b;
                if (nadRewardVideoActivity.K2(NadRewardVideoActivity.a2(nadRewardVideoActivity).f.c)) {
                    this.b.x3();
                }
            }
            if (NadRewardVideoActivity.a2(this.b).m() && (kp0Var = NadRewardVideoActivity.a2(this.b).m) != null && (gp0Var = kp0Var.p) != null && gp0Var.e) {
                kp0 kp0Var2 = NadRewardVideoActivity.a2(this.b).m;
                String str4 = null;
                if (kp0Var2 != null && (gp0Var5 = kp0Var2.p) != null) {
                    str = gp0Var5.b;
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
                    kp0 kp0Var3 = NadRewardVideoActivity.a2(this.b).m;
                    if (kp0Var3 != null && (gp0Var4 = kp0Var3.p) != null) {
                        str2 = gp0Var4.a;
                    } else {
                        str2 = null;
                    }
                    if (!((str2 == null || str2.length() == 0) ? true : true)) {
                        kp0 kp0Var4 = NadRewardVideoActivity.a2(this.b).m;
                        if (kp0Var4 != null && (gp0Var3 = kp0Var4.p) != null) {
                            str3 = gp0Var3.a;
                        } else {
                            str3 = null;
                        }
                        if (q31.d(str3)) {
                            Context context = this.a.getContext();
                            kp0 kp0Var5 = NadRewardVideoActivity.a2(this.b).m;
                            if (kp0Var5 != null && (gp0Var2 = kp0Var5.p) != null) {
                                str4 = gp0Var2.a;
                            }
                            Intrinsics.checkNotNull(str4);
                            ei0.b(context, str4);
                        }
                    }
                }
                rh0.b(q31.b(NadRewardVideoActivity.a2(this.b), NadRewardVideoActivity.a2(this.b).f()));
            }
            this.b.J2();
            NadRewardVideoActivity.a2(this.b).h().e(true);
        }
    }

    /* loaded from: classes2.dex */
    public static final class m extends ks0 {
        public m() {
        }

        @Override // com.baidu.tieba.ks0, com.baidu.tieba.ds0
        public void onEnd(int i) {
            String str;
            xp0 xp0Var;
            j61 j61Var;
            NadRewardBigCardView nadRewardBigCardView;
            if (NadRewardVideoActivity.a2(NadRewardVideoActivity.this).b() == null) {
                nn0 nn0Var = NadRewardVideoActivity.this.D;
                if (nn0Var != null) {
                    nn0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardVideoActivity.this.O;
                if (nadRewardBigCardView2 != null) {
                    nadRewardBigCardView2.setVisibility(false);
                }
                NadRewardVideoActivity.a2(NadRewardVideoActivity.this).h().i(true);
                String str2 = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d;
                kn0 kn0Var = NadRewardVideoActivity.this.Q;
                String str3 = null;
                if (kn0Var != null) {
                    str = kn0Var.f();
                } else {
                    str = null;
                }
                vp0 vp0Var = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).j;
                if (vp0Var != null && (xp0Var = vp0Var.i) != null) {
                    str3 = xp0Var.a;
                }
                zn0.t(str2, str, str3);
            } else {
                bq0 c = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).c();
                if (c != null && c.b() && (((j61Var = NadRewardVideoActivity.this.E) == null || !j61Var.isShowing()) && (nadRewardBigCardView = NadRewardVideoActivity.this.O) != null)) {
                    nadRewardBigCardView.y(true);
                }
                NadRewardVideoActivity.this.s3(true);
                NadRewardVideoActivity.this.t3();
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

        @Override // com.baidu.tieba.ks0, com.baidu.tieba.ds0
        public void onStart() {
            NadRewardVideoActivity.this.s3(false);
            nn0 nn0Var = NadRewardVideoActivity.this.D;
            if (nn0Var != null) {
                nn0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class n extends qz0 {
        @Override // com.baidu.tieba.qz0, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (sn0.a().a()) {
                return 2;
            }
            return 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (NadRewardVideoActivity.this.P2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                nadRewardVideoActivity.R = nadRewardVideoActivity.P2().getMeasuredHeight() / NadRewardVideoActivity.this.P2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class p implements rn0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public p() {
        }

        @Override // com.baidu.tieba.rn0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.Q = null;
            NadRewardVideoActivity.a2(NadRewardVideoActivity.this).h().j(false);
        }

        @Override // com.baidu.tieba.rn0.b
        public void a(kn0 kn0Var) {
            boolean z;
            AdDownloadStatus adDownloadStatus;
            boolean z2;
            NadRewardVideoActivity.this.Q = kn0Var;
            if (kn0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.T++;
            int i = 0;
            if (kn0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.f(NadRewardVideoActivity.a2(NadRewardVideoActivity.this).g().b(kn0Var.d()));
                }
                zn0.d(NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d, kn0Var.d(), NadRewardVideoActivity.this.Q2(), kn0Var.f(), kn0Var.h());
                if (kn0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    zn0.u(NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d, "2", kn0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(kn0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                }
                if (i <= 0) {
                    zn0.l(NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            zn0.g(NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d, "1", kn0Var.d());
            NadRewardVideoActivity.a2(NadRewardVideoActivity.this).h().j(kn0Var.c());
            NadRewardVideoActivity.this.a0 = !kn0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.a2(NadRewardVideoActivity.this).g().t());
            NadRewardVideoActivity.this.n3("0", "任务完成回调", hashMap);
            oc1<View> transitionButtonView = NadRewardVideoActivity.this.N2().getTransitionButtonView();
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
                String str = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d;
                Intrinsics.checkNotNullExpressionValue(str, "adModel.common.extraParam");
                nadRewardTaskHelper.t(kn0Var, adDownloadStatus, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardVideoActivity.this.Y = true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class s implements p61 {
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ NadRewardVideoActivity b;
        public final /* synthetic */ long c;

        @Override // com.baidu.tieba.p61
        public void a() {
        }

        @Override // com.baidu.tieba.p61
        public void dismiss() {
        }

        @Override // com.baidu.tieba.p61
        public void f() {
        }

        public s(Boolean bool, NadRewardVideoActivity nadRewardVideoActivity, long j) {
            this.a = bool;
            this.b = nadRewardVideoActivity;
            this.c = j;
        }

        @Override // com.baidu.tieba.p61
        public void b() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.p61
        public void d() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.p61
        public void c() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (this.b.Y) {
                sp0 a2 = NadRewardVideoActivity.a2(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                zn0.o(a2, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                return;
            }
            sp0 a22 = NadRewardVideoActivity.a2(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            zn0.o(a22, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
        }

        @Override // com.baidu.tieba.p61
        public void e() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (Intrinsics.areEqual(this.a, Boolean.TRUE) && this.b.Y) {
                sp0 a2 = NadRewardVideoActivity.a2(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                zn0.o(a2, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                return;
            }
            sp0 a22 = NadRewardVideoActivity.a2(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            zn0.o(a22, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
        }
    }

    /* loaded from: classes2.dex */
    public static final class t implements PopupWindow.OnDismissListener {
        public t() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            gs0 gs0Var = NadRewardVideoActivity.this.I;
            if (gs0Var != null) {
                gs0Var.resume();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.A;
            if (adImageView != null) {
                ExtensionsKt.e(adImageView, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class u implements p61 {
        @Override // com.baidu.tieba.p61
        public void b() {
        }

        @Override // com.baidu.tieba.p61
        public void c() {
        }

        @Override // com.baidu.tieba.p61
        public void d() {
        }

        @Override // com.baidu.tieba.p61
        public void dismiss() {
        }

        @Override // com.baidu.tieba.p61
        public void e() {
        }

        @Override // com.baidu.tieba.p61
        public void f() {
        }

        public u() {
        }

        @Override // com.baidu.tieba.p61
        public void a() {
            zn0.i(NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1() {
        super.C1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        gs0 gs0Var = this.I;
        if (gs0Var != null) {
            gs0Var.release();
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
        N2().y();
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

    public final void J2() {
        boolean z;
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = sp0Var.e;
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
            m11.b(monitorUrl.clickUrl);
        }
    }

    public final void Y2() {
        if (this.A == null) {
            this.A = new AdImageView(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = BadgeDrawable.TOP_END;
            layoutParams.topMargin = a41.c.a(this, 1.5f);
            layoutParams.setMarginEnd(a41.c.a(this, 5.0f));
            layoutParams.height = a41.c.a(this, 39.0f);
            layoutParams.width = a41.c.a(this, 39.0f);
            P2().addView(this.A, layoutParams);
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            int a2 = a41.c.a(adImageView.getContext(), 10.0f);
            adImageView.setPadding(a2, a2, a2, a2);
            adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            adImageView.setOnClickListener(new i());
        }
    }

    public final void Z2() {
        if (this.C == null) {
            NadVideoRewardCountDownView nadVideoRewardCountDownView = new NadVideoRewardCountDownView(this, null, 0, 6, null);
            AbsRewardCountDownView.b(nadVideoRewardCountDownView, P2(), 0, false, null, 14, null);
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
            sp0 sp0Var = this.P;
            if (sp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = sp0Var.g().s();
            sp0 sp0Var2 = this.P;
            if (sp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, sp0Var2.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$2
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
                    NadRewardVideoActivity.this.k3();
                }
            });
        }
    }

    public final boolean z3() {
        String str;
        boolean z;
        if (!this.a0) {
            return false;
        }
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        jq0 g2 = sp0Var.g();
        kn0 kn0Var = this.Q;
        if (kn0Var != null) {
            str = kn0Var.e();
        } else {
            str = null;
        }
        String l2 = g2.l(str);
        if (l2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || Intrinsics.areEqual(l2, StringUtil.EMPTY_ARRAY)) {
            return false;
        }
        NadRewardVideoDialog G2 = G2(this, l2, false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        G2.show(supportFragmentManager, (String) null);
        this.L = G2;
        m3();
        return true;
    }

    public static final /* synthetic */ sp0 a2(NadRewardVideoActivity nadRewardVideoActivity) {
        sp0 sp0Var = nadRewardVideoActivity.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return sp0Var;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B1(Bundle bundle) {
        super.B1(bundle);
        setContentView(R.layout.nad_reward_video_lp_activity);
        P2().post(new o());
        this.X = new Handler(Looper.getMainLooper());
        if (!l3()) {
            finish();
            return;
        }
        b3();
        V2();
    }

    public final boolean C3(String str) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        NadRewardVideoDialog F2 = F2(str, true);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        F2.show(supportFragmentManager, (String) null);
        this.J = F2;
        m3();
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void E1(Intent intent) {
        super.E1(intent);
        setIntent(intent);
        if (!l3()) {
            e31.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
            return;
        }
        V2();
        v3();
    }

    public final boolean K2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !fi0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new wh0(str).a(), "rewardWebPanel");
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

    public final void s3(boolean z) {
        int i2;
        ViewGroup.LayoutParams layoutParams = S2().getLayoutParams();
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            i2 = nadRewardBigCardView.getHeight();
        } else {
            i2 = 0;
        }
        if (z) {
            layoutParams.height = a41.c.c(this) - i2;
        } else {
            layoutParams.height = a41.c.a(this, 33.0f);
        }
        S2().setLayoutParams(layoutParams);
    }

    public static /* synthetic */ NadRewardVideoDialog G2(NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nadRewardVideoActivity.F2(str, z);
    }

    public final boolean A3() {
        JSONObject jSONObject;
        String f2;
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        mq0 p2 = sp0Var.g().p();
        if (p2 == null || p2.f() == null || this.V) {
            return false;
        }
        j61 j61Var = this.E;
        if (j61Var != null && j61Var.isShowing()) {
            return false;
        }
        sp0 sp0Var2 = this.P;
        if (sp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        mq0 p3 = sp0Var2.g().p();
        if (p3 != null && (f2 = p3.f()) != null) {
            jSONObject = ExtensionsKt.a(f2);
        } else {
            jSONObject = null;
        }
        NadRewardSuspendDialog I2 = I2(String.valueOf(jSONObject));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        I2.show(supportFragmentManager, (String) null);
        this.V = true;
        this.M = I2;
        m3();
        return true;
    }

    public final void B3() {
        String str;
        String c2;
        Integer intOrNull;
        int i2 = 0;
        this.V = false;
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        mq0 p2 = sp0Var.g().p();
        if (p2 != null && p2.f() != null) {
            sp0 sp0Var2 = this.P;
            if (sp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final mq0 p3 = sp0Var2.g().p();
            if (p3 != null) {
                str = p3.b();
            } else {
                str = null;
            }
            if (!L2(str)) {
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
            sp0 sp0Var3 = this.P;
            if (sp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = sp0Var3.g().s();
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
                        boolean A3;
                        String str2;
                        A3 = NadRewardVideoActivity.this.A3();
                        if (A3) {
                            String str3 = NadRewardVideoActivity.a2(NadRewardVideoActivity.this).f.d;
                            String valueOf = String.valueOf(NadRewardVideoActivity.a2(NadRewardVideoActivity.this).h().c());
                            mq0 mq0Var = p3;
                            if (mq0Var != null) {
                                str2 = mq0Var.b();
                            } else {
                                str2 = null;
                            }
                            zn0.h(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void c3() {
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        r51 a2 = r51.a(sp0Var.j());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.H == null) {
                this.H = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((a41.c.e(this) * 9) / 16) / 2) + a41.c.a(this, 26.0f);
                P2().addView(this.H, layoutParams);
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

    public final void d3() {
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        q51 a2 = q51.a(sp0Var.k());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.G == null) {
                this.G = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((a41.c.e(this) * 9) / 16) / 2) + a41.c.a(this, 52.0f);
                layoutParams.setMarginStart(a41.c.a(this, 9.0f));
                layoutParams.setMarginEnd(a41.c.a(this, 8.0f));
                P2().addView(this.G, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.G;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(a41.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
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

    public final void o3() {
        long j2;
        int i2;
        String d2;
        Integer intOrNull;
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        mq0 p2 = sp0Var.g().p();
        if (p2 != null && p2.f() != null) {
            sp0 sp0Var2 = this.P;
            if (sp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            mq0 p3 = sp0Var2.g().p();
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
                sp0 sp0Var3 = this.P;
                if (sp0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, sp0Var3.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
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
                        NadRewardVideoActivity.this.k3();
                    }
                });
            }
        }
    }

    public final void t3() {
        if (this.b0) {
            return;
        }
        j61 j61Var = this.E;
        if (j61Var != null && j61Var.isShowing()) {
            return;
        }
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        bq0 c2 = sp0Var.c();
        if (c2 != null && c2.b()) {
            sp0 sp0Var2 = this.P;
            if (sp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            vp0 vp0Var = sp0Var2.j;
            if (vp0Var != null) {
                int i2 = vp0Var.c;
                sp0 sp0Var3 = this.P;
                if (sp0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == sp0Var3.g().s()) {
                    return;
                }
            }
        }
        this.b0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        nn0 nn0Var = this.D;
        if (nn0Var != null) {
            nn0Var.setVisibility(false);
        }
        NadHighLightTextView nadHighLightTextView = this.G;
        if (nadHighLightTextView != null) {
            ExtensionsKt.e(nadHighLightTextView, false);
        }
        NadIconTextButton nadIconTextButton = this.H;
        if (nadIconTextButton != null) {
            ExtensionsKt.e(nadIconTextButton, false);
        }
        N2().setFestivalEntranceContainerInvisible();
    }

    public final void D3() {
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        zn0.q(sp0Var);
        M2();
        sp0 sp0Var2 = this.P;
        if (sp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        rh0.c(sp0Var2.f.m, this);
        B3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void F1() {
        super.F1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
        gs0 gs0Var = this.I;
        if (gs0Var != null) {
            gs0Var.pause();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void I1() {
        super.I1();
        if (j3()) {
            return;
        }
        r3();
    }

    public final void M2() {
        int a2 = h41.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.U = a2;
        h41.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.S int), ('_' char), (wrap: int : 0x000f: IGET  (r1v2 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.T int)] */
    public final String Q2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.S);
        sb.append('_');
        sb.append(this.T);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…d(rewardCount).toString()");
        return sb2;
    }

    public final void V2() {
        q3();
        f3();
        X2();
        Z2();
        h3();
        g3();
        Y2();
        d3();
        c3();
        e3();
        W2();
        a3();
        D3();
    }

    public final void a3() {
        if (this.W == null) {
            this.W = new NadRewardTaskHelper();
        }
        NadRewardTaskHelper nadRewardTaskHelper = this.W;
        if (nadRewardTaskHelper != null) {
            sp0 sp0Var = this.P;
            if (sp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(sp0Var);
        }
    }

    public final void b3() {
        int a2 = h41.a("nad_reward_sp", "key_session_count", 1);
        this.S = a2;
        h41.e("nad_reward_sp", "key_session_count", a2 + 1);
    }

    public final void f3() {
        boolean z;
        ImageView T2 = T2();
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var.d() != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            T2.setVisibility(0);
        } else {
            T2.setVisibility(8);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        sp0 sp0Var = this.P;
        if (sp0Var != null) {
            if (sp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            cq0 f2 = sp0Var.g().f();
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
                rh0.c(str, this);
            }
        }
        super.finish();
    }

    public final void k3() {
        rn0 b2 = sn0.b();
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        b2.a(sp0Var, new iq0(this.S, this.T), new p());
    }

    public final void m3() {
        gs0 gs0Var = this.I;
        if (gs0Var != null) {
            gs0Var.pause();
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        v3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (u3()) {
            return;
        }
        super.onBackPressed();
    }

    public final void p3() {
        nl0.a().b(this, new q(ul0.class));
    }

    public final void q3() {
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
    public final void r3() {
        ViewGroup view2;
        boolean z;
        j61 j61Var = this.E;
        if (j61Var == null || !j61Var.isShowing()) {
            nn0 nn0Var = this.D;
            if (nn0Var != null && (view2 = nn0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            gs0 gs0Var = this.I;
            if (gs0Var != null) {
                gs0Var.resume();
            }
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.d();
        }
    }

    public final void E3(float f2) {
        float f3;
        boolean z;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            f3 = nadRewardBigCardView.getHeight();
        } else {
            f3 = 0.0f;
        }
        float e2 = ((a41.c.e(this) / a41.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        vp0 vp0Var = sp0Var.j;
        if (vp0Var != null) {
            if (vp0Var.f > 0.0f) {
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
        U2().setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        layoutParams2.bottomMargin = (int) ((f2 - 1) * f3);
        NadRewardBigCardView nadRewardBigCardView2 = this.O;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.setLayoutParams(layoutParams2);
        }
    }

    public final NadRewardVideoDialog F2(final String str, final boolean z) {
        boolean z2;
        Integer num;
        String valueOf;
        boolean z3;
        final NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = sp0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.f2(str, str2);
        jn0 Q1 = nadRewardVideoDialog.Q1();
        boolean z4 = true;
        if (Q1 != null) {
            if (z) {
                sp0 sp0Var2 = this.P;
                if (sp0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (sp0Var2.h().d()) {
                    z3 = true;
                    Q1.M(z3);
                }
            }
            z3 = false;
            Q1.M(z3);
        }
        jn0 Q12 = nadRewardVideoDialog.Q1();
        if (Q12 != null) {
            sp0 sp0Var3 = this.P;
            if (sp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            Q12.L(sp0Var3.g().r());
        }
        jn0 Q13 = nadRewardVideoDialog.Q1();
        if (Q13 != null) {
            sp0 sp0Var4 = this.P;
            if (sp0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (sp0Var4.g().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                sp0 sp0Var5 = this.P;
                if (sp0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = sp0Var5.g().i();
            } else {
                sp0 sp0Var6 = this.P;
                if (sp0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                oq0 q2 = sp0Var6.g().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            Q13.I(valueOf);
        }
        jn0 Q14 = nadRewardVideoDialog.Q1();
        if (Q14 != null) {
            sp0 sp0Var7 = this.P;
            if (sp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (sp0Var7.d() == null) {
                z4 = false;
            }
            Q14.H(z4);
        }
        nadRewardVideoDialog.d2(new a(str, z));
        nadRewardVideoDialog.i2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.r3();
            }
        });
        nadRewardVideoDialog.b2(new b(str, z));
        nadRewardVideoDialog.e2(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4
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
                kp0 kp0Var;
                gp0 gp0Var;
                String str4;
                boolean z5;
                String str5;
                String str6;
                gp0 gp0Var2;
                gp0 gp0Var3;
                gp0 gp0Var4;
                gp0 gp0Var5;
                j61 j61Var;
                ViewGroup view2;
                boolean z6;
                boolean z7 = false;
                if (NadRewardVideoActivity.a2(this).l() && this.K2(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                    nn0 nn0Var = this.D;
                    if (nn0Var != null && (view2 = nn0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            bq0 c2 = NadRewardVideoActivity.a2(this).c();
                            if (c2 != null) {
                            }
                        }
                    }
                    j61Var = this.F;
                    if (j61Var == null || !j61Var.isShowing()) {
                        this.x3();
                    }
                }
                if (NadRewardVideoActivity.a2(this).m() && (kp0Var = NadRewardVideoActivity.a2(this).m) != null && (gp0Var = kp0Var.p) != null && gp0Var.e) {
                    kp0 kp0Var2 = NadRewardVideoActivity.a2(this).m;
                    String str7 = null;
                    if (kp0Var2 != null && (gp0Var5 = kp0Var2.p) != null) {
                        str4 = gp0Var5.b;
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && str4.length() != 0) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        kp0 kp0Var3 = NadRewardVideoActivity.a2(this).m;
                        if (kp0Var3 != null && (gp0Var4 = kp0Var3.p) != null) {
                            str5 = gp0Var4.a;
                        } else {
                            str5 = null;
                        }
                        if (!((str5 == null || str5.length() == 0) ? true : true)) {
                            kp0 kp0Var4 = NadRewardVideoActivity.a2(this).m;
                            if (kp0Var4 != null && (gp0Var3 = kp0Var4.p) != null) {
                                str6 = gp0Var3.a;
                            } else {
                                str6 = null;
                            }
                            if (q31.d(str6)) {
                                Context context = NadRewardVideoDialog.this.getContext();
                                if (context != null) {
                                    kp0 kp0Var5 = NadRewardVideoActivity.a2(this).m;
                                    if (kp0Var5 != null && (gp0Var2 = kp0Var5.p) != null) {
                                        str7 = gp0Var2.a;
                                    }
                                    Intrinsics.checkNotNull(str7);
                                    ei0.b(context, str7);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    rh0.b(q31.b(NadRewardVideoActivity.a2(this), NadRewardVideoActivity.a2(this).f()));
                }
            }
        });
        nadRewardVideoDialog.j2(new c(nadRewardVideoDialog, this, str, z));
        return nadRewardVideoDialog;
    }

    public final NadRewardLottieDialog H2(final String str) {
        p3();
        NadRewardLottieDialog nadRewardLottieDialog = new NadRewardLottieDialog();
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = sp0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.f2(str, str2);
        sp0 sp0Var2 = this.P;
        if (sp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.u2(sp0Var2.g().k());
        nadRewardLottieDialog.d2(new d(str));
        nadRewardLottieDialog.i2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.r3();
            }
        });
        nadRewardLottieDialog.b2(new e(str));
        nadRewardLottieDialog.k2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.a2(NadRewardVideoActivity.this).h().f(true);
            }
        });
        return nadRewardLottieDialog;
    }

    public final boolean y3(long j2) {
        boolean z;
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var.g().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        sp0 sp0Var2 = this.P;
        if (sp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog G2 = G2(this, sp0Var2.g().n(j2), false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        G2.show(supportFragmentManager, (String) null);
        this.K = G2;
        m3();
        return true;
    }

    public final NadRewardSuspendDialog I2(final String str) {
        String str2;
        String str3;
        NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = sp0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.f2(str, str4);
        jn0 Q1 = nadRewardSuspendDialog.Q1();
        String str5 = null;
        if (Q1 != null) {
            sp0 sp0Var2 = this.P;
            if (sp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            mq0 p2 = sp0Var2.g().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            Q1.G(str3);
        }
        jn0 Q12 = nadRewardSuspendDialog.Q1();
        if (Q12 != null) {
            sp0 sp0Var3 = this.P;
            if (sp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            mq0 p3 = sp0Var3.g().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            Q12.K(str2);
        }
        jn0 Q13 = nadRewardSuspendDialog.Q1();
        if (Q13 != null) {
            sp0 sp0Var4 = this.P;
            if (sp0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            mq0 p4 = sp0Var4.g().p();
            if (p4 != null) {
                str5 = p4.g();
            }
            Q13.N(str5);
        }
        nadRewardSuspendDialog.d2(new f(str));
        nadRewardSuspendDialog.i2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.r3();
            }
        });
        nadRewardSuspendDialog.b2(new g(str));
        nadRewardSuspendDialog.l2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.this.o3();
            }
        });
        return nadRewardSuspendDialog;
    }

    public final boolean L2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null).contains(String.valueOf(this.U))) {
            return false;
        }
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        sp0Var.h().h(this.U);
        return true;
    }

    public final void W2() {
        String f2;
        Integer intOrNull;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        int i2 = 0;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(false);
        }
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var.b() == null) {
            this.O = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        sp0 sp0Var2 = this.P;
        if (sp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(sp0Var2);
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
                gs0 gs0Var = NadRewardVideoActivity.this.I;
                if (gs0Var != null) {
                    gs0Var.pause();
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
                gs0 gs0Var = NadRewardVideoActivity.this.I;
                if (gs0Var != null) {
                    gs0Var.resume();
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
                NadRewardVideoActivity.this.E3(f3);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.O = nadRewardBigCardView2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = -a41.c.c(this);
        P2().addView(this.O, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.O;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.O;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        sp0 sp0Var3 = this.P;
        if (sp0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = sp0Var3.g().s();
        sp0 sp0Var4 = this.P;
        if (sp0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        aq0 b2 = sp0Var4.b();
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
                    NadRewardVideoActivity.this.t3();
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
    public final boolean w3() {
        String str;
        j61 j61Var;
        ViewGroup view2;
        boolean z;
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var.g().k() != null) {
            sp0 sp0Var2 = this.P;
            if (sp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (sp0Var2.g().m() != null) {
                sp0 sp0Var3 = this.P;
                if (sp0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                kq0 m2 = sp0Var3.g().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !ws.a(this) && !j3() && ((j61Var = this.E) == null || !j61Var.isShowing())) {
                    nn0 nn0Var = this.D;
                    if (nn0Var != null && (view2 = nn0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    sp0 sp0Var4 = this.P;
                    if (sp0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    jq0 g2 = sp0Var4.g();
                    sp0 sp0Var5 = this.P;
                    if (sp0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    eq0 k2 = sp0Var5.g().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    sp0 sp0Var6 = this.P;
                    if (sp0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    eq0 k3 = sp0Var6.g().k();
                    Intrinsics.checkNotNull(k3);
                    NadRewardLottieDialog H2 = H2(g2.j(c2, k3.a()));
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    H2.show(supportFragmentManager, (String) null);
                    this.N = H2;
                    m3();
                    return true;
                }
            }
        }
        return false;
    }

    public final void x3() {
        boolean z;
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var.e().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.E = null;
            return;
        }
        j61 j61Var = this.E;
        if (j61Var != null && j61Var.isShowing()) {
            return;
        }
        j61 j61Var2 = new j61(this);
        j61Var2.setOnDismissListener(new t());
        j61Var2.i(new u());
        double a2 = 1 - (a41.c.a(this, 41.0f) / a41.c.c(this));
        sp0 sp0Var2 = this.P;
        if (sp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String e2 = sp0Var2.e();
        sp0 sp0Var3 = this.P;
        if (sp0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        q61 q61Var = new q61(e2, a2, 0, sp0Var3.f.d);
        q61Var.A(false);
        q61Var.C(true);
        q61Var.B(true);
        q61Var.y(true);
        sp0 sp0Var4 = this.P;
        if (sp0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!TextUtils.isEmpty(sp0Var4.f.m)) {
            sp0 sp0Var5 = this.P;
            if (sp0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            q61Var.v(sp0Var5.f.l);
        }
        Unit unit = Unit.INSTANCE;
        j61Var2.h(q61Var);
        j61Var2.j();
        Unit unit2 = Unit.INSTANCE;
        this.E = j61Var2;
        gs0 gs0Var = this.I;
        if (gs0Var != null) {
            gs0Var.pause();
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            ExtensionsKt.e(adImageView, false);
        }
        sp0 sp0Var6 = this.P;
        if (sp0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        sp0Var6.h().g(true);
    }

    public final void X2() {
        ExpandIconView O2 = O2();
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        bq0 c2 = sp0Var.c();
        boolean z = true;
        if ((c2 == null || !c2.e()) ? false : false) {
            O2.setVisibility(0);
        } else {
            O2.setVisibility(8);
            O2 = null;
        }
        if (O2 != null) {
            O2.setOnClickListener(new h());
        }
    }

    public final boolean j3() {
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

    public final boolean u3() {
        NadRewardTaskHelper nadRewardTaskHelper = this.W;
        if (nadRewardTaskHelper != null && nadRewardTaskHelper.A()) {
            sp0 sp0Var = this.P;
            if (sp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return C3(sp0Var.g().c());
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            long seconds = timeUnit.toSeconds(absRewardCountDownView.getMillisUntilFinished());
            if (seconds <= 0) {
                return z3();
            }
            return y3(seconds);
        }
        return false;
    }

    public final void e3() {
        xp0 xp0Var;
        xp0 xp0Var2;
        String str;
        xp0 xp0Var3;
        String str2;
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        vp0 vp0Var = sp0Var.j;
        NadRewardHalfTailHolder nadRewardHalfTailHolder = null;
        if (vp0Var != null) {
            xp0Var = vp0Var.i;
        } else {
            xp0Var = null;
        }
        if (xp0Var != null) {
            sp0 sp0Var2 = this.P;
            if (sp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            bq0 c2 = sp0Var2.c();
            if (c2 == null || c2.n()) {
                sp0 sp0Var3 = this.P;
                if (sp0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                vp0 vp0Var2 = sp0Var3.j;
                if (vp0Var2 != null && (xp0Var2 = vp0Var2.i) != null) {
                    sp0 sp0Var4 = this.P;
                    if (sp0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    vp0 vp0Var3 = sp0Var4.j;
                    if (vp0Var3 != null && (xp0Var3 = vp0Var3.i) != null && (str2 = xp0Var3.x) != null) {
                        kn0 kn0Var = this.Q;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (kn0Var == null || (r4 = kn0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    xp0Var2.x = str;
                }
                nn0 nn0Var = this.D;
                if (nn0Var != null) {
                    nn0Var.setVisibility(false);
                }
                nn0.a aVar = nn0.k0;
                sp0 sp0Var5 = this.P;
                if (sp0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                nn0 a2 = aVar.a(sp0Var5, this);
                this.D = a2;
                if (a2 != null) {
                    sp0 sp0Var6 = this.P;
                    if (sp0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(sp0Var6);
                }
                nn0 nn0Var2 = this.D;
                if (!(nn0Var2 instanceof View)) {
                    nn0Var2 = null;
                }
                View view2 = (View) nn0Var2;
                if (view2 != null) {
                    R2().removeAllViews();
                    R2().addView(view2);
                    R2().bringToFront();
                }
                nn0 nn0Var3 = this.D;
                if (nn0Var3 != null) {
                    nn0Var3.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
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
                            nn0 nn0Var4 = NadRewardVideoActivity.this.D;
                            if (nn0Var4 != null) {
                                nn0Var4.setVisibility(false);
                            }
                            gs0 gs0Var = NadRewardVideoActivity.this.I;
                            if (gs0Var != null) {
                                gs0Var.start();
                            }
                        }
                    });
                }
                nn0 nn0Var4 = this.D;
                if (nn0Var4 instanceof NadRewardHalfTailHolder) {
                    nadRewardHalfTailHolder = nn0Var4;
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
        nn0 nn0Var5 = this.D;
        if (nn0Var5 != null) {
            nn0Var5.setVisibility(false);
        }
    }

    public final void g3() {
        boolean z;
        int i2;
        jp0 jp0Var;
        int i3;
        xp0 xp0Var;
        NadRewardVideoAdOverContainer N2 = N2();
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var.d() == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        N2.setVisibility(i2);
        N2.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
        sp0 sp0Var2 = this.P;
        if (sp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var2.g().C()) {
            sp0 sp0Var3 = this.P;
            if (sp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = sp0Var3.f.c;
            Context context = N2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (i3(str, context)) {
                sp0 sp0Var4 = this.P;
                if (sp0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                kp0 kp0Var = sp0Var4.m;
                if (kp0Var != null) {
                    kp0Var.g = true;
                }
                sp0 sp0Var5 = this.P;
                if (sp0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                vp0 vp0Var = sp0Var5.j;
                if (vp0Var != null && (xp0Var = vp0Var.i) != null) {
                    xp0Var.C = true;
                }
            }
        }
        sp0 sp0Var6 = this.P;
        if (sp0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var6.d() != null) {
            sp0 sp0Var7 = this.P;
            if (sp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            kp0 kp0Var2 = sp0Var7.m;
            if (kp0Var2 != null) {
                kp0Var2.e = true;
            }
            sp0 sp0Var8 = this.P;
            if (sp0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            kp0 kp0Var3 = sp0Var8.m;
            if (kp0Var3 != null) {
                sp0 sp0Var9 = this.P;
                if (sp0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (sp0Var9.m()) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                kp0Var3.a = i3;
            }
            sp0 sp0Var10 = this.P;
            if (sp0Var10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            kp0 kp0Var4 = sp0Var10.m;
            if (kp0Var4 != null) {
                sp0 sp0Var11 = this.P;
                if (sp0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                dq0 d2 = sp0Var11.d();
                Intrinsics.checkNotNull(d2);
                kp0Var4.p = d2.b();
            }
            sp0 sp0Var12 = this.P;
            if (sp0Var12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            kp0 kp0Var5 = sp0Var12.m;
            if (kp0Var5 != null && (jp0Var = kp0Var5.q) != null) {
                sp0 sp0Var13 = this.P;
                if (sp0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                jp0Var.d = sp0Var13.f.d;
            }
        }
        sp0 sp0Var14 = this.P;
        if (sp0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        N2.setData(sp0Var14);
        sp0 sp0Var15 = this.P;
        if (sp0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var15.l()) {
            N2.setBottomLineHeight(a41.c.a(N2.getContext(), 41.0f));
        } else {
            N2.setBottomLineHeight(a41.c.a(N2.getContext(), 10.0f));
        }
        N2.setOnUiClickListener(new k(N2, this));
        N2.setFeedbackBtnVisibility(false);
        N2.setFestivalClickCallback(new l(N2, this));
    }

    public final void h3() {
        boolean z;
        if (this.I == null) {
            hs0 hs0Var = new hs0();
            hs0Var.a = 2;
            gs0 b2 = gs0.a.b(this, 0, hs0Var);
            this.I = b2;
            if (b2 != null) {
                b2.attachToContainer(U2());
            }
        }
        gs0 gs0Var = this.I;
        if (gs0Var != null) {
            gs0Var.d(new n());
            sp0 sp0Var = this.P;
            if (sp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            vp0 vp0Var = sp0Var.j;
            if (vp0Var != null && vp0Var.g) {
                gs0Var.setVideoScalingMode(0);
            } else {
                gs0Var.setVideoScalingMode(2);
            }
            gs0Var.a(new m());
        }
        sp0 sp0Var2 = this.P;
        if (sp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (sp0Var2.j == null) {
            U2().setVisibility(8);
            this.I = null;
            return;
        }
        gs0 gs0Var2 = this.I;
        if (gs0Var2 != null) {
            sp0 sp0Var3 = this.P;
            if (sp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            vp0 vp0Var2 = sp0Var3.j;
            Intrinsics.checkNotNull(vp0Var2);
            gs0Var2.c(vp0Var2);
        }
        if (NetUtil.a(this)) {
            sp0 sp0Var4 = this.P;
            if (sp0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            bq0 c2 = sp0Var4.c();
            if (c2 != null) {
                z = c2.n();
            } else {
                z = false;
            }
            gs0 gs0Var3 = this.I;
            if (gs0Var3 != null) {
                gs0Var3.setLooping(!z);
            }
            gs0 gs0Var4 = this.I;
            if (gs0Var4 != null) {
                gs0Var4.start();
            }
        } else {
            e31.a().a(this, R.string.nad_reward_video_lp_no_network);
        }
        NadRewardInterceptFrameLayout U2 = U2();
        U2.setVisibility(0);
        sp0 sp0Var5 = this.P;
        if (sp0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        U2.setEnableIntercept(sp0Var5.l());
        U2.setInterceptCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initVideoPlayer$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.x3();
                zn0.s(NadRewardVideoActivity.a2(NadRewardVideoActivity.this));
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = 0;
        U2.setLayoutParams(layoutParams);
    }

    public final void v3() {
        String str;
        boolean z;
        Boolean bool;
        long j2;
        sp0 sp0Var = this.P;
        if (sp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        dq0 d2 = sp0Var.d();
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
            j61 j61Var = this.F;
            if (j61Var != null) {
                j61Var.e();
            }
            this.F = null;
            return;
        }
        j61 j61Var2 = this.F;
        if (j61Var2 != null) {
            j61Var2.e();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Handler handler = this.X;
        if (handler != null) {
            Runnable runnable = this.Z;
            sp0 sp0Var2 = this.P;
            if (sp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            dq0 d3 = sp0Var2.d();
            if (d3 != null) {
                j2 = d3.a();
            } else {
                j2 = 0;
            }
            handler.postDelayed(runnable, j2);
        }
        j61 j61Var3 = new j61(this);
        sp0 sp0Var3 = this.P;
        if (sp0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        dq0 d4 = sp0Var3.d();
        if (d4 != null) {
            bool = Boolean.valueOf(d4.d());
        } else {
            bool = null;
        }
        j61Var3.i(new s(bool, this, currentTimeMillis));
        double a2 = 1 - (a41.c.a(this, 41.0f) / a41.c.c(this));
        sp0 sp0Var4 = this.P;
        if (sp0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        dq0 d5 = sp0Var4.d();
        if (d5 != null) {
            str2 = d5.c();
        }
        String str3 = str2;
        sp0 sp0Var5 = this.P;
        if (sp0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        q61 q61Var = new q61(str3, a2, 0, sp0Var5.f.d);
        q61Var.A(false);
        q61Var.C(true);
        q61Var.w(true);
        q61Var.x(true);
        Unit unit = Unit.INSTANCE;
        j61Var3.h(q61Var);
        j61Var3.j();
        Unit unit2 = Unit.INSTANCE;
        this.F = j61Var3;
    }

    public final boolean i3(String str, Context context) {
        Object m770constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new wh0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m770constructorimpl = Result.m770constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m770constructorimpl = Result.m770constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m776isFailureimpl(m770constructorimpl)) {
            m770constructorimpl = null;
        }
        String str3 = (String) m770constructorimpl;
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

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0097, code lost:
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00de, code lost:
        if (r5 != null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e0, code lost:
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0110, code lost:
        if (r5 != null) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l3() {
        Object m770constructorimpl;
        xp0 xp0Var;
        String str;
        xp0 xp0Var2;
        Boolean bool;
        boolean z;
        String d2;
        String str2;
        String replace$default;
        String str3;
        String d3;
        xp0 xp0Var3;
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
            m770constructorimpl = Result.m770constructorimpl(ResultKt.createFailure(th));
        }
        if (serializable != null) {
            m770constructorimpl = Result.m770constructorimpl(yn0.a.d((HashMap) serializable));
            if (Result.m777isSuccessimpl(m770constructorimpl)) {
                sp0 sp0Var = (sp0) m770constructorimpl;
                this.P = sp0Var;
                if (sp0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                vp0 vp0Var = sp0Var.j;
                String str7 = "";
                if (vp0Var != null && (xp0Var3 = vp0Var.i) != null) {
                    sp0 sp0Var2 = this.P;
                    if (sp0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (sp0Var2.m()) {
                        String str8 = xp0Var3.f;
                        if (str8 != null) {
                            sp0 sp0Var3 = this.P;
                            if (sp0Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str8, "__CONVERT_CMD__", sp0Var3.f(), false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        xp0Var3.f = replace$default2;
                    } else {
                        String str9 = xp0Var3.f;
                        if (str9 != null) {
                            sp0 sp0Var4 = this.P;
                            if (sp0Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            kp0 kp0Var = sp0Var4.m;
                            if (kp0Var == null || (str5 = kp0Var.t) == null) {
                                str4 = "";
                            } else {
                                str4 = str5;
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str9, "__CONVERT_CMD__", str4, false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        xp0Var3.f = replace$default2;
                    }
                }
                sp0 sp0Var5 = this.P;
                if (sp0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                aq0 b2 = sp0Var5.b();
                if (b2 != null) {
                    sp0 sp0Var6 = this.P;
                    if (sp0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (sp0Var6.m()) {
                        sp0 sp0Var7 = this.P;
                        if (sp0Var7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        aq0 b3 = sp0Var7.b();
                        if (b3 != null && (d3 = b3.d()) != null) {
                            sp0 sp0Var8 = this.P;
                            if (sp0Var8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d3, "__CONVERT_CMD__", sp0Var8.f(), false, 4, (Object) null);
                        }
                        b2.h(str7);
                    } else {
                        sp0 sp0Var9 = this.P;
                        if (sp0Var9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        aq0 b4 = sp0Var9.b();
                        if (b4 != null && (d2 = b4.d()) != null) {
                            sp0 sp0Var10 = this.P;
                            if (sp0Var10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            kp0 kp0Var2 = sp0Var10.m;
                            if (kp0Var2 == null || (str3 = kp0Var2.t) == null) {
                                str2 = "";
                            } else {
                                str2 = str3;
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d2, "__CONVERT_CMD__", str2, false, 4, (Object) null);
                        }
                        b2.h(str7);
                    }
                }
                sp0 sp0Var11 = this.P;
                if (sp0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                kp0 kp0Var3 = sp0Var11.m;
                boolean z2 = true;
                if (kp0Var3 != null) {
                    kp0Var3.d = true;
                }
                sp0 sp0Var12 = this.P;
                if (sp0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                kp0 kp0Var4 = sp0Var12.m;
                if (kp0Var4 != null) {
                    sp0 sp0Var13 = this.P;
                    if (sp0Var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    bq0 c2 = sp0Var13.c();
                    if (c2 != null) {
                        z = c2.f();
                    } else {
                        z = false;
                    }
                    kp0Var4.f = z;
                }
                sp0 sp0Var14 = this.P;
                if (sp0Var14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                vp0 vp0Var2 = sp0Var14.j;
                if (vp0Var2 != null && (xp0Var2 = vp0Var2.i) != null) {
                    sp0 sp0Var15 = this.P;
                    if (sp0Var15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    bq0 c3 = sp0Var15.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.p());
                    } else {
                        bool = null;
                    }
                    xp0Var2.D = bool;
                }
                sp0 sp0Var16 = this.P;
                if (sp0Var16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                vp0 vp0Var3 = sp0Var16.j;
                if (vp0Var3 != null && (xp0Var = vp0Var3.i) != null) {
                    sp0 sp0Var17 = this.P;
                    if (sp0Var17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    bq0 c4 = sp0Var17.c();
                    if (c4 != null) {
                        str = c4.o();
                    } else {
                        str = null;
                    }
                    xp0Var.E = str;
                }
                fn0 fn0Var = (fn0) ServiceManager.getService(fn0.a);
                sp0 sp0Var18 = this.P;
                if (sp0Var18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (sp0Var18.g().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && fn0Var != null) {
                    sp0 sp0Var19 = this.P;
                    if (sp0Var19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    jq0 g2 = sp0Var19.g();
                    String a2 = fn0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    g2.F(a2);
                }
                sp0 sp0Var20 = this.P;
                if (sp0Var20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                kp0 kp0Var5 = sp0Var20.m;
                if (kp0Var5 != null) {
                    sp0 sp0Var21 = this.P;
                    if (sp0Var21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = sp0Var21.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    kp0Var5.h = list;
                }
                sp0 sp0Var22 = this.P;
                if (sp0Var22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                cq0 f2 = sp0Var22.g().f();
                if (f2 != null) {
                    str6 = f2.c();
                }
                this.a0 = Intrinsics.areEqual(str6, "0");
            }
            Throwable m773exceptionOrNullimpl = Result.m773exceptionOrNullimpl(m770constructorimpl);
            if (m773exceptionOrNullimpl != null && tf0.a) {
                e31.a().showToast(this, m773exceptionOrNullimpl.getMessage());
            }
            return Result.m777isSuccessimpl(m770constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final void n3(String str, String str2, HashMap<String, String> hashMap) {
        ln0 ln0Var = new ln0();
        ln0Var.a = str;
        ln0Var.b = hashMap;
        nl0.a().a(ln0Var);
    }
}
