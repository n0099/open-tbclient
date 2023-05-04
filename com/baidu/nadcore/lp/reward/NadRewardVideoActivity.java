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
import com.baidu.tieba.ao0;
import com.baidu.tieba.aq0;
import com.baidu.tieba.bo0;
import com.baidu.tieba.co0;
import com.baidu.tieba.d41;
import com.baidu.tieba.dq0;
import com.baidu.tieba.eq0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.gq0;
import com.baidu.tieba.h31;
import com.baidu.tieba.hi0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.in0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.js0;
import com.baidu.tieba.k41;
import com.baidu.tieba.ks0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.m61;
import com.baidu.tieba.mg0;
import com.baidu.tieba.mn0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.mq0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.np0;
import com.baidu.tieba.nq0;
import com.baidu.tieba.ns0;
import com.baidu.tieba.on0;
import com.baidu.tieba.p11;
import com.baidu.tieba.pq0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.rc1;
import com.baidu.tieba.rq0;
import com.baidu.tieba.s61;
import com.baidu.tieba.t31;
import com.baidu.tieba.t51;
import com.baidu.tieba.t61;
import com.baidu.tieba.tz0;
import com.baidu.tieba.u51;
import com.baidu.tieba.uh0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.un0;
import com.baidu.tieba.vn0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.wf0;
import com.baidu.tieba.xl0;
import com.baidu.tieba.xs;
import com.baidu.tieba.yp0;
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
/* loaded from: classes2.dex */
public final class NadRewardVideoActivity extends BaseActivity {
    public AdImageView A;
    public AbsRewardCountDownView C;
    public qn0 D;
    public m61 E;
    public m61 F;
    public NadHighLightTextView G;
    public NadIconTextButton H;
    public js0 I;
    public NadRewardVideoDialog J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardSuspendDialog M;
    public NadRewardLottieDialog N;
    public NadRewardBigCardView O;
    public vp0 P;
    public nn0 Q;
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

    public final NadRewardVideoAdOverContainer P2() {
        return (NadRewardVideoAdOverContainer) this.x.getValue();
    }

    public final ExpandIconView Q2() {
        return (ExpandIconView) this.z.getValue();
    }

    public final FrameLayout R2() {
        return (FrameLayout) this.u.getValue();
    }

    public final FrameLayout T2() {
        return (FrameLayout) this.y.getValue();
    }

    public final View U2() {
        return (View) this.w.getValue();
    }

    public final ImageView V2() {
        return (ImageView) this.B.getValue();
    }

    public final NadRewardInterceptFrameLayout W2() {
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
        public static final class a implements ao0.a {
            public a() {
            }

            @Override // com.baidu.tieba.ao0.a
            public void onFail(Exception exc) {
                co0.j(NadRewardVideoActivity.c2(l.this.b).f.d, "4");
                Toast.makeText(l.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.ao0.a
            public void a(hq0 hq0Var) {
                String str;
                NadRewardVideoActivity.c2(l.this.b).g().E(hq0Var);
                String str2 = null;
                if (hq0Var != null) {
                    str = hq0Var.f();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "1")) {
                    l.this.a.setFestivalEntranceContainerInvisible();
                    Toast.makeText(l.this.b, hq0Var.d(), 0).show();
                    return;
                }
                l.this.b.y3();
                String str3 = NadRewardVideoActivity.c2(l.this.b).f.d;
                if (hq0Var != null) {
                    str2 = hq0Var.a();
                }
                co0.k(str3, "4", str2);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.c2(this.b).g().k() != null) {
                hq0 k = NadRewardVideoActivity.c2(this.b).g().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    hq0 k2 = NadRewardVideoActivity.c2(nadRewardVideoActivity).g().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.y3();
                return;
            }
            ao0 ao0Var = ao0.a;
            mq0 g = NadRewardVideoActivity.c2(this.b).g();
            nq0 m = NadRewardVideoActivity.c2(this.b).g().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            ao0Var.d(g, str, new a());
        }
    }

    /* loaded from: classes2.dex */
    public static final class q extends ul0<xl0> {

        /* loaded from: classes2.dex */
        public static final class a implements ao0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.ao0.a
            public void onFail(Exception exc) {
                co0.j(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.ao0.a
            public void a(hq0 hq0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.P2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (hq0Var != null) {
                    str = hq0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (hq0Var != null) {
                    str2 = hq0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d;
                    if (hq0Var != null) {
                        str3 = hq0Var.a();
                    }
                    co0.k(str4, "5", str3);
                }
            }
        }

        public q(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ul0
        public void onEvent(xl0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().b()) {
                ao0 ao0Var = ao0.a;
                mq0 g = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).g();
                hq0 k = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).g().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                ao0Var.d(g, str, new a());
                NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().f(false);
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
            NadRewardVideoActivity.this.L2();
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
            mg0 mg0Var;
            jp0 jp0Var;
            if (NadRewardVideoActivity.c2(this.b).d() != null) {
                gq0 d = NadRewardVideoActivity.c2(this.b).d();
                Intrinsics.checkNotNull(d);
                mg0Var = new mg0(d.b());
            } else {
                np0 np0Var = NadRewardVideoActivity.c2(this.b).m;
                if (np0Var != null) {
                    jp0Var = np0Var.p;
                } else {
                    jp0Var = null;
                }
                mg0Var = new mg0(jp0Var);
            }
            ql0.a().a(mg0Var);
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
            NadRewardVideoActivity.this.L2();
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
            NadRewardVideoActivity.this.L2();
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.z3();
            co0.f(NadRewardVideoActivity.c2(NadRewardVideoActivity.this));
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
            String str2 = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d;
            nn0 nn0Var = NadRewardVideoActivity.this.Q;
            if (nn0Var != null) {
                str = nn0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            co0.p(str2, !z);
            if (NadRewardVideoActivity.this.w3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ u51 b;

        public j(u51 u51Var) {
            this.b = u51Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            co0.r(NadRewardVideoActivity.c2(NadRewardVideoActivity.this));
            if (!NadRewardVideoActivity.this.M2(this.b.c)) {
                if (Intrinsics.areEqual(this.b.c, "__CONVERT_CMD__")) {
                    if (NadRewardVideoActivity.c2(NadRewardVideoActivity.this).m()) {
                        uh0.c(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f(), NadRewardVideoActivity.this);
                        return;
                    }
                    String str2 = null;
                    if (NadRewardVideoActivity.c2(NadRewardVideoActivity.this).l()) {
                        NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                        np0 np0Var = NadRewardVideoActivity.c2(nadRewardVideoActivity).m;
                        if (np0Var != null) {
                            str = np0Var.t;
                        } else {
                            str = null;
                        }
                        if (nadRewardVideoActivity.M2(str)) {
                            NadRewardVideoActivity.this.z3();
                            return;
                        }
                    }
                    np0 np0Var2 = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).m;
                    if (np0Var2 != null) {
                        str2 = np0Var2.t;
                    }
                    uh0.c(str2, NadRewardVideoActivity.this);
                    return;
                }
                uh0.c(this.b.c, NadRewardVideoActivity.this);
                return;
            }
            NadRewardVideoActivity.this.z3();
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
            np0 np0Var;
            jp0 jp0Var;
            String str;
            boolean z;
            String str2;
            String str3;
            jp0 jp0Var2;
            jp0 jp0Var3;
            jp0 jp0Var4;
            jp0 jp0Var5;
            if (NadRewardVideoActivity.c2(this.b).l()) {
                NadRewardVideoActivity nadRewardVideoActivity = this.b;
                if (nadRewardVideoActivity.M2(NadRewardVideoActivity.c2(nadRewardVideoActivity).f.c)) {
                    this.b.z3();
                }
            }
            if (NadRewardVideoActivity.c2(this.b).m() && (np0Var = NadRewardVideoActivity.c2(this.b).m) != null && (jp0Var = np0Var.p) != null && jp0Var.e) {
                np0 np0Var2 = NadRewardVideoActivity.c2(this.b).m;
                String str4 = null;
                if (np0Var2 != null && (jp0Var5 = np0Var2.p) != null) {
                    str = jp0Var5.b;
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
                    np0 np0Var3 = NadRewardVideoActivity.c2(this.b).m;
                    if (np0Var3 != null && (jp0Var4 = np0Var3.p) != null) {
                        str2 = jp0Var4.a;
                    } else {
                        str2 = null;
                    }
                    if (!((str2 == null || str2.length() == 0) ? true : true)) {
                        np0 np0Var4 = NadRewardVideoActivity.c2(this.b).m;
                        if (np0Var4 != null && (jp0Var3 = np0Var4.p) != null) {
                            str3 = jp0Var3.a;
                        } else {
                            str3 = null;
                        }
                        if (t31.d(str3)) {
                            Context context = this.a.getContext();
                            np0 np0Var5 = NadRewardVideoActivity.c2(this.b).m;
                            if (np0Var5 != null && (jp0Var2 = np0Var5.p) != null) {
                                str4 = jp0Var2.a;
                            }
                            Intrinsics.checkNotNull(str4);
                            hi0.b(context, str4);
                        }
                    }
                }
                uh0.b(t31.b(NadRewardVideoActivity.c2(this.b), NadRewardVideoActivity.c2(this.b).f()));
            }
            this.b.L2();
            NadRewardVideoActivity.c2(this.b).h().e(true);
        }
    }

    /* loaded from: classes2.dex */
    public static final class m extends ns0 {
        public m() {
        }

        @Override // com.baidu.tieba.ns0, com.baidu.tieba.gs0
        public void onEnd(int i) {
            String str;
            aq0 aq0Var;
            m61 m61Var;
            NadRewardBigCardView nadRewardBigCardView;
            if (NadRewardVideoActivity.c2(NadRewardVideoActivity.this).b() != null) {
                eq0 c = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).c();
                if (c != null && c.b() && (((m61Var = NadRewardVideoActivity.this.E) == null || !m61Var.isShowing()) && (nadRewardBigCardView = NadRewardVideoActivity.this.O) != null)) {
                    nadRewardBigCardView.y(true);
                }
                NadRewardVideoActivity.this.u3(true);
                NadRewardVideoActivity.this.v3();
            } else {
                qn0 qn0Var = NadRewardVideoActivity.this.D;
                if (qn0Var != null) {
                    qn0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardVideoActivity.this.O;
                if (nadRewardBigCardView2 != null) {
                    nadRewardBigCardView2.setVisibility(false);
                }
                NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().i(true);
                String str2 = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d;
                nn0 nn0Var = NadRewardVideoActivity.this.Q;
                String str3 = null;
                if (nn0Var != null) {
                    str = nn0Var.f();
                } else {
                    str = null;
                }
                yp0 yp0Var = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).j;
                if (yp0Var != null && (aq0Var = yp0Var.i) != null) {
                    str3 = aq0Var.a;
                }
                co0.t(str2, str, str3);
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

        @Override // com.baidu.tieba.ns0, com.baidu.tieba.gs0
        public void onStart() {
            NadRewardVideoActivity.this.u3(false);
            qn0 qn0Var = NadRewardVideoActivity.this.D;
            if (qn0Var != null) {
                qn0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class n extends tz0 {
        @Override // com.baidu.tieba.tz0, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (vn0.a().a()) {
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
            if (NadRewardVideoActivity.this.R2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                nadRewardVideoActivity.R = nadRewardVideoActivity.R2().getMeasuredHeight() / NadRewardVideoActivity.this.R2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class p implements un0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public p() {
        }

        @Override // com.baidu.tieba.un0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.Q = null;
            NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().j(false);
        }

        @Override // com.baidu.tieba.un0.b
        public void a(nn0 nn0Var) {
            boolean z;
            AdDownloadStatus adDownloadStatus;
            boolean z2;
            NadRewardVideoActivity.this.Q = nn0Var;
            if (nn0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.T++;
            int i = 0;
            if (nn0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.f(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).g().b(nn0Var.d()));
                }
                co0.d(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, nn0Var.d(), NadRewardVideoActivity.this.S2(), nn0Var.f(), nn0Var.h());
                if (nn0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    co0.u(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, "2", nn0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(nn0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                }
                if (i <= 0) {
                    co0.l(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            co0.g(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, "1", nn0Var.d());
            NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().j(nn0Var.c());
            NadRewardVideoActivity.this.a0 = !nn0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.c2(NadRewardVideoActivity.this).g().t());
            NadRewardVideoActivity.this.p3("0", "任务完成回调", hashMap);
            rc1<View> transitionButtonView = NadRewardVideoActivity.this.P2().getTransitionButtonView();
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
                String str = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d;
                Intrinsics.checkNotNullExpressionValue(str, "adModel.common.extraParam");
                nadRewardTaskHelper.t(nn0Var, adDownloadStatus, str);
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
    public static final class s implements s61 {
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ NadRewardVideoActivity b;
        public final /* synthetic */ long c;

        @Override // com.baidu.tieba.s61
        public void a() {
        }

        @Override // com.baidu.tieba.s61
        public void dismiss() {
        }

        @Override // com.baidu.tieba.s61
        public void f() {
        }

        public s(Boolean bool, NadRewardVideoActivity nadRewardVideoActivity, long j) {
            this.a = bool;
            this.b = nadRewardVideoActivity;
            this.c = j;
        }

        @Override // com.baidu.tieba.s61
        public void b() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.s61
        public void d() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.s61
        public void c() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (this.b.Y) {
                vp0 c2 = NadRewardVideoActivity.c2(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                co0.o(c2, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                return;
            }
            vp0 c22 = NadRewardVideoActivity.c2(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            co0.o(c22, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
        }

        @Override // com.baidu.tieba.s61
        public void e() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (Intrinsics.areEqual(this.a, Boolean.TRUE) && this.b.Y) {
                vp0 c2 = NadRewardVideoActivity.c2(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                co0.o(c2, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                return;
            }
            vp0 c22 = NadRewardVideoActivity.c2(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            co0.o(c22, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
        }
    }

    /* loaded from: classes2.dex */
    public static final class t implements PopupWindow.OnDismissListener {
        public t() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            js0 js0Var = NadRewardVideoActivity.this.I;
            if (js0Var != null) {
                js0Var.resume();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.A;
            if (adImageView != null) {
                ExtensionsKt.e(adImageView, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class u implements s61 {
        @Override // com.baidu.tieba.s61
        public void b() {
        }

        @Override // com.baidu.tieba.s61
        public void c() {
        }

        @Override // com.baidu.tieba.s61
        public void d() {
        }

        @Override // com.baidu.tieba.s61
        public void dismiss() {
        }

        @Override // com.baidu.tieba.s61
        public void e() {
        }

        @Override // com.baidu.tieba.s61
        public void f() {
        }

        public u() {
        }

        @Override // com.baidu.tieba.s61
        public void a() {
            co0.i(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d);
        }
    }

    public final boolean B3() {
        String str;
        boolean z;
        if (!this.a0) {
            return false;
        }
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        mq0 g2 = vp0Var.g();
        nn0 nn0Var = this.Q;
        if (nn0Var != null) {
            str = nn0Var.e();
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
        NadRewardVideoDialog I2 = I2(this, l2, false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        I2.show(supportFragmentManager, (String) null);
        this.L = I2;
        o3();
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void F1() {
        super.F1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        js0 js0Var = this.I;
        if (js0Var != null) {
            js0Var.release();
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
        P2().y();
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

    public final void L2() {
        boolean z;
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = vp0Var.e;
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
            p11.b(monitorUrl.clickUrl);
        }
    }

    public final void a3() {
        if (this.A == null) {
            this.A = new AdImageView(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = BadgeDrawable.TOP_END;
            layoutParams.topMargin = d41.c.a(this, 1.5f);
            layoutParams.setMarginEnd(d41.c.a(this, 5.0f));
            layoutParams.height = d41.c.a(this, 39.0f);
            layoutParams.width = d41.c.a(this, 39.0f);
            R2().addView(this.A, layoutParams);
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            int a2 = d41.c.a(adImageView.getContext(), 10.0f);
            adImageView.setPadding(a2, a2, a2, a2);
            adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            adImageView.setOnClickListener(new i());
        }
    }

    public final void b3() {
        if (this.C == null) {
            NadVideoRewardCountDownView nadVideoRewardCountDownView = new NadVideoRewardCountDownView(this, null, 0, 6, null);
            AbsRewardCountDownView.b(nadVideoRewardCountDownView, R2(), 0, false, null, 14, null);
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
            vp0 vp0Var = this.P;
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = vp0Var.g().s();
            vp0 vp0Var2 = this.P;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, vp0Var2.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$2
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
                    NadRewardVideoActivity.this.m3();
                }
            });
        }
    }

    public static final /* synthetic */ vp0 c2(NadRewardVideoActivity nadRewardVideoActivity) {
        vp0 vp0Var = nadRewardVideoActivity.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return vp0Var;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1(Bundle bundle) {
        super.D1(bundle);
        setContentView(R.layout.nad_reward_video_lp_activity);
        R2().post(new o());
        this.X = new Handler(Looper.getMainLooper());
        if (!n3()) {
            finish();
            return;
        }
        d3();
        X2();
    }

    public final boolean E3(String str) {
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
        this.J = H2;
        o3();
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void G1(Intent intent) {
        super.G1(intent);
        setIntent(intent);
        if (!n3()) {
            h31.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
            return;
        }
        X2();
        x3();
    }

    public final boolean M2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !ii0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new zh0(str).a(), "rewardWebPanel");
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean N1(Bundle bundle) {
        if (!super.N1(bundle)) {
            return false;
        }
        getWindow().setSoftInputMode(19);
        getWindow().setFormat(-3);
        requestWindowFeature(1);
        setEnableSliding(false);
        setCurrentActivityNoTransparent();
        return true;
    }

    public final void u3(boolean z) {
        int i2;
        ViewGroup.LayoutParams layoutParams = U2().getLayoutParams();
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            i2 = nadRewardBigCardView.getHeight();
        } else {
            i2 = 0;
        }
        if (z) {
            layoutParams.height = d41.c.c(this) - i2;
        } else {
            layoutParams.height = d41.c.a(this, 33.0f);
        }
        U2().setLayoutParams(layoutParams);
    }

    public static /* synthetic */ NadRewardVideoDialog I2(NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nadRewardVideoActivity.H2(str, z);
    }

    public final boolean A3(long j2) {
        boolean z;
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var.g().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        vp0 vp0Var2 = this.P;
        if (vp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog I2 = I2(this, vp0Var2.g().n(j2), false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        I2.show(supportFragmentManager, (String) null);
        this.K = I2;
        o3();
        return true;
    }

    public final NadRewardLottieDialog J2(final String str) {
        r3();
        NadRewardLottieDialog nadRewardLottieDialog = new NadRewardLottieDialog();
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = vp0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.g2(str, str2);
        vp0 vp0Var2 = this.P;
        if (vp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.v2(vp0Var2.g().k());
        nadRewardLottieDialog.e2(new d(str));
        nadRewardLottieDialog.j2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.t3();
            }
        });
        nadRewardLottieDialog.c2(new e(str));
        nadRewardLottieDialog.l2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().f(true);
            }
        });
        return nadRewardLottieDialog;
    }

    public final boolean C3() {
        JSONObject jSONObject;
        String f2;
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        pq0 p2 = vp0Var.g().p();
        if (p2 == null || p2.f() == null || this.V) {
            return false;
        }
        m61 m61Var = this.E;
        if (m61Var != null && m61Var.isShowing()) {
            return false;
        }
        vp0 vp0Var2 = this.P;
        if (vp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        pq0 p3 = vp0Var2.g().p();
        if (p3 != null && (f2 = p3.f()) != null) {
            jSONObject = ExtensionsKt.a(f2);
        } else {
            jSONObject = null;
        }
        NadRewardSuspendDialog K2 = K2(String.valueOf(jSONObject));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        K2.show(supportFragmentManager, (String) null);
        this.V = true;
        this.M = K2;
        o3();
        return true;
    }

    public final void D3() {
        String str;
        String c2;
        Integer intOrNull;
        int i2 = 0;
        this.V = false;
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        pq0 p2 = vp0Var.g().p();
        if (p2 != null && p2.f() != null) {
            vp0 vp0Var2 = this.P;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final pq0 p3 = vp0Var2.g().p();
            if (p3 != null) {
                str = p3.b();
            } else {
                str = null;
            }
            if (!N2(str)) {
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
            vp0 vp0Var3 = this.P;
            if (vp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = vp0Var3.g().s();
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
                        boolean C3;
                        String str2;
                        C3 = NadRewardVideoActivity.this.C3();
                        if (C3) {
                            String str3 = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d;
                            String valueOf = String.valueOf(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().c());
                            pq0 pq0Var = p3;
                            if (pq0Var != null) {
                                str2 = pq0Var.b();
                            } else {
                                str2 = null;
                            }
                            co0.h(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void e3() {
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        u51 a2 = u51.a(vp0Var.j());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.H == null) {
                this.H = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((d41.c.e(this) * 9) / 16) / 2) + d41.c.a(this, 26.0f);
                R2().addView(this.H, layoutParams);
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

    public final void f3() {
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        t51 a2 = t51.a(vp0Var.k());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.G == null) {
                this.G = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((d41.c.e(this) * 9) / 16) / 2) + d41.c.a(this, 52.0f);
                layoutParams.setMarginStart(d41.c.a(this, 9.0f));
                layoutParams.setMarginEnd(d41.c.a(this, 8.0f));
                R2().addView(this.G, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.G;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(d41.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
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

    public final void q3() {
        long j2;
        int i2;
        String d2;
        Integer intOrNull;
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        pq0 p2 = vp0Var.g().p();
        if (p2 != null && p2.f() != null) {
            vp0 vp0Var2 = this.P;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            pq0 p3 = vp0Var2.g().p();
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
                vp0 vp0Var3 = this.P;
                if (vp0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, vp0Var3.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
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
                        NadRewardVideoActivity.this.m3();
                    }
                });
            }
        }
    }

    public final void v3() {
        if (this.b0) {
            return;
        }
        m61 m61Var = this.E;
        if (m61Var != null && m61Var.isShowing()) {
            return;
        }
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        eq0 c2 = vp0Var.c();
        if (c2 != null && c2.b()) {
            vp0 vp0Var2 = this.P;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            yp0 yp0Var = vp0Var2.j;
            if (yp0Var != null) {
                int i2 = yp0Var.c;
                vp0 vp0Var3 = this.P;
                if (vp0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == vp0Var3.g().s()) {
                    return;
                }
            }
        }
        this.b0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        qn0 qn0Var = this.D;
        if (qn0Var != null) {
            qn0Var.setVisibility(false);
        }
        NadHighLightTextView nadHighLightTextView = this.G;
        if (nadHighLightTextView != null) {
            ExtensionsKt.e(nadHighLightTextView, false);
        }
        NadIconTextButton nadIconTextButton = this.H;
        if (nadIconTextButton != null) {
            ExtensionsKt.e(nadIconTextButton, false);
        }
        P2().setFestivalEntranceContainerInvisible();
    }

    public final void F3() {
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        co0.q(vp0Var);
        O2();
        vp0 vp0Var2 = this.P;
        if (vp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        uh0.c(vp0Var2.f.m, this);
        D3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void H1() {
        super.H1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
        js0 js0Var = this.I;
        if (js0Var != null) {
            js0Var.pause();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void K1() {
        super.K1();
        if (l3()) {
            return;
        }
        t3();
    }

    public final void O2() {
        int a2 = k41.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.U = a2;
        k41.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.S int), ('_' char), (wrap: int : 0x000f: IGET  (r1v2 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.T int)] */
    public final String S2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.S);
        sb.append('_');
        sb.append(this.T);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…d(rewardCount).toString()");
        return sb2;
    }

    public final void X2() {
        s3();
        h3();
        Z2();
        b3();
        j3();
        i3();
        a3();
        f3();
        e3();
        g3();
        Y2();
        c3();
        F3();
    }

    public final void c3() {
        if (this.W == null) {
            this.W = new NadRewardTaskHelper();
        }
        NadRewardTaskHelper nadRewardTaskHelper = this.W;
        if (nadRewardTaskHelper != null) {
            vp0 vp0Var = this.P;
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(vp0Var);
        }
    }

    public final void d3() {
        int a2 = k41.a("nad_reward_sp", "key_session_count", 1);
        this.S = a2;
        k41.e("nad_reward_sp", "key_session_count", a2 + 1);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        vp0 vp0Var = this.P;
        if (vp0Var != null) {
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fq0 f2 = vp0Var.g().f();
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
                uh0.c(str, this);
            }
        }
        super.finish();
    }

    public final void h3() {
        boolean z;
        ImageView V2 = V2();
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var.d() != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            V2.setVisibility(0);
        } else {
            V2.setVisibility(8);
        }
    }

    public final void m3() {
        un0 b2 = vn0.b();
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        b2.a(vp0Var, new lq0(this.S, this.T), new p());
    }

    public final void o3() {
        js0 js0Var = this.I;
        if (js0Var != null) {
            js0Var.pause();
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (w3()) {
            return;
        }
        super.onBackPressed();
    }

    public final void r3() {
        ql0.a().b(this, new q(xl0.class));
    }

    public final void s3() {
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
    public final void t3() {
        ViewGroup view2;
        boolean z;
        m61 m61Var = this.E;
        if (m61Var == null || !m61Var.isShowing()) {
            qn0 qn0Var = this.D;
            if (qn0Var != null && (view2 = qn0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            js0 js0Var = this.I;
            if (js0Var != null) {
                js0Var.resume();
            }
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.d();
        }
    }

    public final void G3(float f2) {
        float f3;
        boolean z;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            f3 = nadRewardBigCardView.getHeight();
        } else {
            f3 = 0.0f;
        }
        float e2 = ((d41.c.e(this) / d41.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        yp0 yp0Var = vp0Var.j;
        if (yp0Var != null) {
            if (yp0Var.f > 0.0f) {
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
        W2().setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        layoutParams2.bottomMargin = (int) ((f2 - 1) * f3);
        NadRewardBigCardView nadRewardBigCardView2 = this.O;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.setLayoutParams(layoutParams2);
        }
    }

    public final NadRewardVideoDialog H2(final String str, final boolean z) {
        boolean z2;
        Integer num;
        String valueOf;
        boolean z3;
        final NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = vp0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.g2(str, str2);
        mn0 R1 = nadRewardVideoDialog.R1();
        boolean z4 = true;
        if (R1 != null) {
            if (z) {
                vp0 vp0Var2 = this.P;
                if (vp0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (vp0Var2.h().d()) {
                    z3 = true;
                    R1.M(z3);
                }
            }
            z3 = false;
            R1.M(z3);
        }
        mn0 R12 = nadRewardVideoDialog.R1();
        if (R12 != null) {
            vp0 vp0Var3 = this.P;
            if (vp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            R12.L(vp0Var3.g().r());
        }
        mn0 R13 = nadRewardVideoDialog.R1();
        if (R13 != null) {
            vp0 vp0Var4 = this.P;
            if (vp0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (vp0Var4.g().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                vp0 vp0Var5 = this.P;
                if (vp0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = vp0Var5.g().i();
            } else {
                vp0 vp0Var6 = this.P;
                if (vp0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                rq0 q2 = vp0Var6.g().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            R13.I(valueOf);
        }
        mn0 R14 = nadRewardVideoDialog.R1();
        if (R14 != null) {
            vp0 vp0Var7 = this.P;
            if (vp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (vp0Var7.d() == null) {
                z4 = false;
            }
            R14.H(z4);
        }
        nadRewardVideoDialog.e2(new a(str, z));
        nadRewardVideoDialog.j2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.t3();
            }
        });
        nadRewardVideoDialog.c2(new b(str, z));
        nadRewardVideoDialog.f2(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4
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
                np0 np0Var;
                jp0 jp0Var;
                String str4;
                boolean z5;
                String str5;
                String str6;
                jp0 jp0Var2;
                jp0 jp0Var3;
                jp0 jp0Var4;
                jp0 jp0Var5;
                m61 m61Var;
                ViewGroup view2;
                boolean z6;
                boolean z7 = false;
                if (NadRewardVideoActivity.c2(this).l() && this.M2(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                    qn0 qn0Var = this.D;
                    if (qn0Var != null && (view2 = qn0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            eq0 c2 = NadRewardVideoActivity.c2(this).c();
                            if (c2 != null) {
                            }
                        }
                    }
                    m61Var = this.F;
                    if (m61Var == null || !m61Var.isShowing()) {
                        this.z3();
                    }
                }
                if (NadRewardVideoActivity.c2(this).m() && (np0Var = NadRewardVideoActivity.c2(this).m) != null && (jp0Var = np0Var.p) != null && jp0Var.e) {
                    np0 np0Var2 = NadRewardVideoActivity.c2(this).m;
                    String str7 = null;
                    if (np0Var2 != null && (jp0Var5 = np0Var2.p) != null) {
                        str4 = jp0Var5.b;
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && str4.length() != 0) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        np0 np0Var3 = NadRewardVideoActivity.c2(this).m;
                        if (np0Var3 != null && (jp0Var4 = np0Var3.p) != null) {
                            str5 = jp0Var4.a;
                        } else {
                            str5 = null;
                        }
                        if (!((str5 == null || str5.length() == 0) ? true : true)) {
                            np0 np0Var4 = NadRewardVideoActivity.c2(this).m;
                            if (np0Var4 != null && (jp0Var3 = np0Var4.p) != null) {
                                str6 = jp0Var3.a;
                            } else {
                                str6 = null;
                            }
                            if (t31.d(str6)) {
                                Context context = NadRewardVideoDialog.this.getContext();
                                if (context != null) {
                                    np0 np0Var5 = NadRewardVideoActivity.c2(this).m;
                                    if (np0Var5 != null && (jp0Var2 = np0Var5.p) != null) {
                                        str7 = jp0Var2.a;
                                    }
                                    Intrinsics.checkNotNull(str7);
                                    hi0.b(context, str7);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    uh0.b(t31.b(NadRewardVideoActivity.c2(this), NadRewardVideoActivity.c2(this).f()));
                }
            }
        });
        nadRewardVideoDialog.k2(new c(nadRewardVideoDialog, this, str, z));
        return nadRewardVideoDialog;
    }

    public final NadRewardSuspendDialog K2(final String str) {
        String str2;
        String str3;
        NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = vp0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.g2(str, str4);
        mn0 R1 = nadRewardSuspendDialog.R1();
        String str5 = null;
        if (R1 != null) {
            vp0 vp0Var2 = this.P;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            pq0 p2 = vp0Var2.g().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            R1.G(str3);
        }
        mn0 R12 = nadRewardSuspendDialog.R1();
        if (R12 != null) {
            vp0 vp0Var3 = this.P;
            if (vp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            pq0 p3 = vp0Var3.g().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            R12.K(str2);
        }
        mn0 R13 = nadRewardSuspendDialog.R1();
        if (R13 != null) {
            vp0 vp0Var4 = this.P;
            if (vp0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            pq0 p4 = vp0Var4.g().p();
            if (p4 != null) {
                str5 = p4.g();
            }
            R13.N(str5);
        }
        nadRewardSuspendDialog.e2(new f(str));
        nadRewardSuspendDialog.j2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.t3();
            }
        });
        nadRewardSuspendDialog.c2(new g(str));
        nadRewardSuspendDialog.m2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.this.q3();
            }
        });
        return nadRewardSuspendDialog;
    }

    public final boolean N2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null).contains(String.valueOf(this.U))) {
            return false;
        }
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        vp0Var.h().h(this.U);
        return true;
    }

    public final void Y2() {
        String f2;
        Integer intOrNull;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        int i2 = 0;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(false);
        }
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var.b() == null) {
            this.O = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        vp0 vp0Var2 = this.P;
        if (vp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(vp0Var2);
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
                js0 js0Var = NadRewardVideoActivity.this.I;
                if (js0Var != null) {
                    js0Var.pause();
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
                js0 js0Var = NadRewardVideoActivity.this.I;
                if (js0Var != null) {
                    js0Var.resume();
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
                NadRewardVideoActivity.this.G3(f3);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.O = nadRewardBigCardView2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = -d41.c.c(this);
        R2().addView(this.O, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.O;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.O;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        vp0 vp0Var3 = this.P;
        if (vp0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = vp0Var3.g().s();
        vp0 vp0Var4 = this.P;
        if (vp0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        dq0 b2 = vp0Var4.b();
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
                    NadRewardVideoActivity.this.v3();
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
    public final boolean y3() {
        String str;
        m61 m61Var;
        ViewGroup view2;
        boolean z;
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var.g().k() != null) {
            vp0 vp0Var2 = this.P;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (vp0Var2.g().m() != null) {
                vp0 vp0Var3 = this.P;
                if (vp0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                nq0 m2 = vp0Var3.g().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !xs.a(this) && !l3() && ((m61Var = this.E) == null || !m61Var.isShowing())) {
                    qn0 qn0Var = this.D;
                    if (qn0Var != null && (view2 = qn0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    vp0 vp0Var4 = this.P;
                    if (vp0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    mq0 g2 = vp0Var4.g();
                    vp0 vp0Var5 = this.P;
                    if (vp0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    hq0 k2 = vp0Var5.g().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    vp0 vp0Var6 = this.P;
                    if (vp0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    hq0 k3 = vp0Var6.g().k();
                    Intrinsics.checkNotNull(k3);
                    NadRewardLottieDialog J2 = J2(g2.j(c2, k3.a()));
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    J2.show(supportFragmentManager, (String) null);
                    this.N = J2;
                    o3();
                    return true;
                }
            }
        }
        return false;
    }

    public final void z3() {
        boolean z;
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var.e().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.E = null;
            return;
        }
        m61 m61Var = this.E;
        if (m61Var != null && m61Var.isShowing()) {
            return;
        }
        m61 m61Var2 = new m61(this);
        m61Var2.setOnDismissListener(new t());
        m61Var2.i(new u());
        double a2 = 1 - (d41.c.a(this, 41.0f) / d41.c.c(this));
        vp0 vp0Var2 = this.P;
        if (vp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String e2 = vp0Var2.e();
        vp0 vp0Var3 = this.P;
        if (vp0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        t61 t61Var = new t61(e2, a2, 0, vp0Var3.f.d);
        t61Var.A(false);
        t61Var.C(true);
        t61Var.B(true);
        t61Var.y(true);
        vp0 vp0Var4 = this.P;
        if (vp0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!TextUtils.isEmpty(vp0Var4.f.m)) {
            vp0 vp0Var5 = this.P;
            if (vp0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            t61Var.v(vp0Var5.f.l);
        }
        Unit unit = Unit.INSTANCE;
        m61Var2.h(t61Var);
        m61Var2.j();
        Unit unit2 = Unit.INSTANCE;
        this.E = m61Var2;
        js0 js0Var = this.I;
        if (js0Var != null) {
            js0Var.pause();
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            ExtensionsKt.e(adImageView, false);
        }
        vp0 vp0Var6 = this.P;
        if (vp0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        vp0Var6.h().g(true);
    }

    public final void Z2() {
        ExpandIconView Q2 = Q2();
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        eq0 c2 = vp0Var.c();
        boolean z = true;
        if ((c2 == null || !c2.e()) ? false : false) {
            Q2.setVisibility(0);
        } else {
            Q2.setVisibility(8);
            Q2 = null;
        }
        if (Q2 != null) {
            Q2.setOnClickListener(new h());
        }
    }

    public final boolean l3() {
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

    public final boolean w3() {
        NadRewardTaskHelper nadRewardTaskHelper = this.W;
        if (nadRewardTaskHelper != null && nadRewardTaskHelper.A()) {
            vp0 vp0Var = this.P;
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return E3(vp0Var.g().c());
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            long seconds = timeUnit.toSeconds(absRewardCountDownView.getMillisUntilFinished());
            if (seconds <= 0) {
                return B3();
            }
            return A3(seconds);
        }
        return false;
    }

    public final void g3() {
        aq0 aq0Var;
        aq0 aq0Var2;
        String str;
        aq0 aq0Var3;
        String str2;
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        yp0 yp0Var = vp0Var.j;
        NadRewardHalfTailHolder nadRewardHalfTailHolder = null;
        if (yp0Var != null) {
            aq0Var = yp0Var.i;
        } else {
            aq0Var = null;
        }
        if (aq0Var != null) {
            vp0 vp0Var2 = this.P;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            eq0 c2 = vp0Var2.c();
            if (c2 == null || c2.n()) {
                vp0 vp0Var3 = this.P;
                if (vp0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                yp0 yp0Var2 = vp0Var3.j;
                if (yp0Var2 != null && (aq0Var2 = yp0Var2.i) != null) {
                    vp0 vp0Var4 = this.P;
                    if (vp0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    yp0 yp0Var3 = vp0Var4.j;
                    if (yp0Var3 != null && (aq0Var3 = yp0Var3.i) != null && (str2 = aq0Var3.x) != null) {
                        nn0 nn0Var = this.Q;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (nn0Var == null || (r4 = nn0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    aq0Var2.x = str;
                }
                qn0 qn0Var = this.D;
                if (qn0Var != null) {
                    qn0Var.setVisibility(false);
                }
                qn0.a aVar = qn0.k0;
                vp0 vp0Var5 = this.P;
                if (vp0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qn0 a2 = aVar.a(vp0Var5, this);
                this.D = a2;
                if (a2 != null) {
                    vp0 vp0Var6 = this.P;
                    if (vp0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(vp0Var6);
                }
                qn0 qn0Var2 = this.D;
                if (!(qn0Var2 instanceof View)) {
                    qn0Var2 = null;
                }
                View view2 = (View) qn0Var2;
                if (view2 != null) {
                    T2().removeAllViews();
                    T2().addView(view2);
                    T2().bringToFront();
                }
                qn0 qn0Var3 = this.D;
                if (qn0Var3 != null) {
                    qn0Var3.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
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
                            qn0 qn0Var4 = NadRewardVideoActivity.this.D;
                            if (qn0Var4 != null) {
                                qn0Var4.setVisibility(false);
                            }
                            js0 js0Var = NadRewardVideoActivity.this.I;
                            if (js0Var != null) {
                                js0Var.start();
                            }
                        }
                    });
                }
                qn0 qn0Var4 = this.D;
                if (qn0Var4 instanceof NadRewardHalfTailHolder) {
                    nadRewardHalfTailHolder = qn0Var4;
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
        qn0 qn0Var5 = this.D;
        if (qn0Var5 != null) {
            qn0Var5.setVisibility(false);
        }
    }

    public final void i3() {
        boolean z;
        int i2;
        mp0 mp0Var;
        int i3;
        aq0 aq0Var;
        NadRewardVideoAdOverContainer P2 = P2();
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var.d() == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        P2.setVisibility(i2);
        P2.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
        vp0 vp0Var2 = this.P;
        if (vp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var2.g().C()) {
            vp0 vp0Var3 = this.P;
            if (vp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = vp0Var3.f.c;
            Context context = P2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (k3(str, context)) {
                vp0 vp0Var4 = this.P;
                if (vp0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                np0 np0Var = vp0Var4.m;
                if (np0Var != null) {
                    np0Var.g = true;
                }
                vp0 vp0Var5 = this.P;
                if (vp0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                yp0 yp0Var = vp0Var5.j;
                if (yp0Var != null && (aq0Var = yp0Var.i) != null) {
                    aq0Var.C = true;
                }
            }
        }
        vp0 vp0Var6 = this.P;
        if (vp0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var6.d() != null) {
            vp0 vp0Var7 = this.P;
            if (vp0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            np0 np0Var2 = vp0Var7.m;
            if (np0Var2 != null) {
                np0Var2.e = true;
            }
            vp0 vp0Var8 = this.P;
            if (vp0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            np0 np0Var3 = vp0Var8.m;
            if (np0Var3 != null) {
                vp0 vp0Var9 = this.P;
                if (vp0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (vp0Var9.m()) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                np0Var3.a = i3;
            }
            vp0 vp0Var10 = this.P;
            if (vp0Var10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            np0 np0Var4 = vp0Var10.m;
            if (np0Var4 != null) {
                vp0 vp0Var11 = this.P;
                if (vp0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                gq0 d2 = vp0Var11.d();
                Intrinsics.checkNotNull(d2);
                np0Var4.p = d2.b();
            }
            vp0 vp0Var12 = this.P;
            if (vp0Var12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            np0 np0Var5 = vp0Var12.m;
            if (np0Var5 != null && (mp0Var = np0Var5.q) != null) {
                vp0 vp0Var13 = this.P;
                if (vp0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                mp0Var.d = vp0Var13.f.d;
            }
        }
        vp0 vp0Var14 = this.P;
        if (vp0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        P2.setData(vp0Var14);
        vp0 vp0Var15 = this.P;
        if (vp0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var15.l()) {
            P2.setBottomLineHeight(d41.c.a(P2.getContext(), 41.0f));
        } else {
            P2.setBottomLineHeight(d41.c.a(P2.getContext(), 10.0f));
        }
        P2.setOnUiClickListener(new k(P2, this));
        P2.setFeedbackBtnVisibility(false);
        P2.setFestivalClickCallback(new l(P2, this));
    }

    public final void j3() {
        boolean z;
        if (this.I == null) {
            ks0 ks0Var = new ks0();
            ks0Var.a = 2;
            js0 b2 = js0.a.b(this, 0, ks0Var);
            this.I = b2;
            if (b2 != null) {
                b2.attachToContainer(W2());
            }
        }
        js0 js0Var = this.I;
        if (js0Var != null) {
            js0Var.d(new n());
            vp0 vp0Var = this.P;
            if (vp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            yp0 yp0Var = vp0Var.j;
            if (yp0Var != null && yp0Var.g) {
                js0Var.setVideoScalingMode(0);
            } else {
                js0Var.setVideoScalingMode(2);
            }
            js0Var.a(new m());
        }
        vp0 vp0Var2 = this.P;
        if (vp0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (vp0Var2.j == null) {
            W2().setVisibility(8);
            this.I = null;
            return;
        }
        js0 js0Var2 = this.I;
        if (js0Var2 != null) {
            vp0 vp0Var3 = this.P;
            if (vp0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            yp0 yp0Var2 = vp0Var3.j;
            Intrinsics.checkNotNull(yp0Var2);
            js0Var2.c(yp0Var2);
        }
        if (NetUtil.a(this)) {
            vp0 vp0Var4 = this.P;
            if (vp0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            eq0 c2 = vp0Var4.c();
            if (c2 != null) {
                z = c2.n();
            } else {
                z = false;
            }
            js0 js0Var3 = this.I;
            if (js0Var3 != null) {
                js0Var3.setLooping(!z);
            }
            js0 js0Var4 = this.I;
            if (js0Var4 != null) {
                js0Var4.start();
            }
        } else {
            h31.a().a(this, R.string.nad_reward_video_lp_no_network);
        }
        NadRewardInterceptFrameLayout W2 = W2();
        W2.setVisibility(0);
        vp0 vp0Var5 = this.P;
        if (vp0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        W2.setEnableIntercept(vp0Var5.l());
        W2.setInterceptCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initVideoPlayer$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.z3();
                co0.s(NadRewardVideoActivity.c2(NadRewardVideoActivity.this));
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = 0;
        W2.setLayoutParams(layoutParams);
    }

    public final void x3() {
        String str;
        boolean z;
        Boolean bool;
        long j2;
        vp0 vp0Var = this.P;
        if (vp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        gq0 d2 = vp0Var.d();
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
            m61 m61Var = this.F;
            if (m61Var != null) {
                m61Var.e();
            }
            this.F = null;
            return;
        }
        m61 m61Var2 = this.F;
        if (m61Var2 != null) {
            m61Var2.e();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Handler handler = this.X;
        if (handler != null) {
            Runnable runnable = this.Z;
            vp0 vp0Var2 = this.P;
            if (vp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            gq0 d3 = vp0Var2.d();
            if (d3 != null) {
                j2 = d3.a();
            } else {
                j2 = 0;
            }
            handler.postDelayed(runnable, j2);
        }
        m61 m61Var3 = new m61(this);
        vp0 vp0Var3 = this.P;
        if (vp0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        gq0 d4 = vp0Var3.d();
        if (d4 != null) {
            bool = Boolean.valueOf(d4.d());
        } else {
            bool = null;
        }
        m61Var3.i(new s(bool, this, currentTimeMillis));
        double a2 = 1 - (d41.c.a(this, 41.0f) / d41.c.c(this));
        vp0 vp0Var4 = this.P;
        if (vp0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        gq0 d5 = vp0Var4.d();
        if (d5 != null) {
            str2 = d5.c();
        }
        String str3 = str2;
        vp0 vp0Var5 = this.P;
        if (vp0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        t61 t61Var = new t61(str3, a2, 0, vp0Var5.f.d);
        t61Var.A(false);
        t61Var.C(true);
        t61Var.w(true);
        t61Var.x(true);
        Unit unit = Unit.INSTANCE;
        m61Var3.h(t61Var);
        m61Var3.j();
        Unit unit2 = Unit.INSTANCE;
        this.F = m61Var3;
    }

    public final boolean k3(String str, Context context) {
        Object m770constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new zh0(str).d();
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
    public final boolean n3() {
        Object m770constructorimpl;
        aq0 aq0Var;
        String str;
        aq0 aq0Var2;
        Boolean bool;
        boolean z;
        String d2;
        String str2;
        String replace$default;
        String str3;
        String d3;
        aq0 aq0Var3;
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
            m770constructorimpl = Result.m770constructorimpl(bo0.a.d((HashMap) serializable));
            if (Result.m777isSuccessimpl(m770constructorimpl)) {
                vp0 vp0Var = (vp0) m770constructorimpl;
                this.P = vp0Var;
                if (vp0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                yp0 yp0Var = vp0Var.j;
                String str7 = "";
                if (yp0Var != null && (aq0Var3 = yp0Var.i) != null) {
                    vp0 vp0Var2 = this.P;
                    if (vp0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (vp0Var2.m()) {
                        String str8 = aq0Var3.f;
                        if (str8 != null) {
                            vp0 vp0Var3 = this.P;
                            if (vp0Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str8, "__CONVERT_CMD__", vp0Var3.f(), false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        aq0Var3.f = replace$default2;
                    } else {
                        String str9 = aq0Var3.f;
                        if (str9 != null) {
                            vp0 vp0Var4 = this.P;
                            if (vp0Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            np0 np0Var = vp0Var4.m;
                            if (np0Var == null || (str5 = np0Var.t) == null) {
                                str4 = "";
                            } else {
                                str4 = str5;
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str9, "__CONVERT_CMD__", str4, false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        aq0Var3.f = replace$default2;
                    }
                }
                vp0 vp0Var5 = this.P;
                if (vp0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                dq0 b2 = vp0Var5.b();
                if (b2 != null) {
                    vp0 vp0Var6 = this.P;
                    if (vp0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (vp0Var6.m()) {
                        vp0 vp0Var7 = this.P;
                        if (vp0Var7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        dq0 b3 = vp0Var7.b();
                        if (b3 != null && (d3 = b3.d()) != null) {
                            vp0 vp0Var8 = this.P;
                            if (vp0Var8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d3, "__CONVERT_CMD__", vp0Var8.f(), false, 4, (Object) null);
                        }
                        b2.h(str7);
                    } else {
                        vp0 vp0Var9 = this.P;
                        if (vp0Var9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        dq0 b4 = vp0Var9.b();
                        if (b4 != null && (d2 = b4.d()) != null) {
                            vp0 vp0Var10 = this.P;
                            if (vp0Var10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            np0 np0Var2 = vp0Var10.m;
                            if (np0Var2 == null || (str3 = np0Var2.t) == null) {
                                str2 = "";
                            } else {
                                str2 = str3;
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d2, "__CONVERT_CMD__", str2, false, 4, (Object) null);
                        }
                        b2.h(str7);
                    }
                }
                vp0 vp0Var11 = this.P;
                if (vp0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                np0 np0Var3 = vp0Var11.m;
                boolean z2 = true;
                if (np0Var3 != null) {
                    np0Var3.d = true;
                }
                vp0 vp0Var12 = this.P;
                if (vp0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                np0 np0Var4 = vp0Var12.m;
                if (np0Var4 != null) {
                    vp0 vp0Var13 = this.P;
                    if (vp0Var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    eq0 c2 = vp0Var13.c();
                    if (c2 != null) {
                        z = c2.f();
                    } else {
                        z = false;
                    }
                    np0Var4.f = z;
                }
                vp0 vp0Var14 = this.P;
                if (vp0Var14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                yp0 yp0Var2 = vp0Var14.j;
                if (yp0Var2 != null && (aq0Var2 = yp0Var2.i) != null) {
                    vp0 vp0Var15 = this.P;
                    if (vp0Var15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    eq0 c3 = vp0Var15.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.p());
                    } else {
                        bool = null;
                    }
                    aq0Var2.D = bool;
                }
                vp0 vp0Var16 = this.P;
                if (vp0Var16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                yp0 yp0Var3 = vp0Var16.j;
                if (yp0Var3 != null && (aq0Var = yp0Var3.i) != null) {
                    vp0 vp0Var17 = this.P;
                    if (vp0Var17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    eq0 c4 = vp0Var17.c();
                    if (c4 != null) {
                        str = c4.o();
                    } else {
                        str = null;
                    }
                    aq0Var.E = str;
                }
                in0 in0Var = (in0) ServiceManager.getService(in0.a);
                vp0 vp0Var18 = this.P;
                if (vp0Var18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (vp0Var18.g().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && in0Var != null) {
                    vp0 vp0Var19 = this.P;
                    if (vp0Var19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    mq0 g2 = vp0Var19.g();
                    String a2 = in0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    g2.F(a2);
                }
                vp0 vp0Var20 = this.P;
                if (vp0Var20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                np0 np0Var5 = vp0Var20.m;
                if (np0Var5 != null) {
                    vp0 vp0Var21 = this.P;
                    if (vp0Var21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = vp0Var21.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    np0Var5.h = list;
                }
                vp0 vp0Var22 = this.P;
                if (vp0Var22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fq0 f2 = vp0Var22.g().f();
                if (f2 != null) {
                    str6 = f2.c();
                }
                this.a0 = Intrinsics.areEqual(str6, "0");
            }
            Throwable m773exceptionOrNullimpl = Result.m773exceptionOrNullimpl(m770constructorimpl);
            if (m773exceptionOrNullimpl != null && wf0.a) {
                h31.a().showToast(this, m773exceptionOrNullimpl.getMessage());
            }
            return Result.m777isSuccessimpl(m770constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final void p3(String str, String str2, HashMap<String, String> hashMap) {
        on0 on0Var = new on0();
        on0Var.a = str;
        on0Var.b = hashMap;
        ql0.a().a(on0Var);
    }
}
