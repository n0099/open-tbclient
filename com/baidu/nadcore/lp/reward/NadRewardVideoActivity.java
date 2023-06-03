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
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.R;
import com.baidu.tieba.aq0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.c61;
import com.baidu.tieba.cs0;
import com.baidu.tieba.ds0;
import com.baidu.tieba.es0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.g51;
import com.baidu.tieba.gk0;
import com.baidu.tieba.gs0;
import com.baidu.tieba.hk0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.ir0;
import com.baidu.tieba.iu0;
import com.baidu.tieba.j61;
import com.baidu.tieba.ju0;
import com.baidu.tieba.ks0;
import com.baidu.tieba.l81;
import com.baidu.tieba.li0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.lr0;
import com.baidu.tieba.ls0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.ms0;
import com.baidu.tieba.mu0;
import com.baidu.tieba.np0;
import com.baidu.tieba.o31;
import com.baidu.tieba.os0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.qe1;
import com.baidu.tieba.qs0;
import com.baidu.tieba.r81;
import com.baidu.tieba.s11;
import com.baidu.tieba.s51;
import com.baidu.tieba.s71;
import com.baidu.tieba.s81;
import com.baidu.tieba.t71;
import com.baidu.tieba.tj0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.tp0;
import com.baidu.tieba.up0;
import com.baidu.tieba.ur0;
import com.baidu.tieba.vh0;
import com.baidu.tieba.wn0;
import com.baidu.tieba.xr0;
import com.baidu.tieba.yj0;
import com.baidu.tieba.yt;
import com.baidu.tieba.zp0;
import com.baidu.tieba.zr0;
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
    public pp0 D;
    public l81 E;
    public l81 F;
    public NadHighLightTextView G;
    public NadIconTextButton H;
    public iu0 I;
    public NadRewardVideoDialog J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardSuspendDialog M;
    public NadRewardLottieDialog N;
    public NadRewardBigCardView O;
    public ur0 P;
    public mp0 Q;
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
        public static final class a implements zp0.a {
            public a() {
            }

            @Override // com.baidu.tieba.zp0.a
            public void onFail(Exception exc) {
                bq0.j(NadRewardVideoActivity.Q1(l.this.b).f.d, "4");
                Toast.makeText(l.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.zp0.a
            public void a(gs0 gs0Var) {
                String str;
                NadRewardVideoActivity.Q1(l.this.b).g().E(gs0Var);
                String str2 = null;
                if (gs0Var != null) {
                    str = gs0Var.f();
                } else {
                    str = null;
                }
                if (!Intrinsics.areEqual(str, "1")) {
                    l.this.b.m3();
                    String str3 = NadRewardVideoActivity.Q1(l.this.b).f.d;
                    if (gs0Var != null) {
                        str2 = gs0Var.a();
                    }
                    bq0.k(str3, "4", str2);
                    return;
                }
                l.this.a.setFestivalEntranceContainerInvisible();
                Toast.makeText(l.this.b, gs0Var.d(), 0).show();
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.Q1(this.b).g().k() != null) {
                gs0 k = NadRewardVideoActivity.Q1(this.b).g().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    gs0 k2 = NadRewardVideoActivity.Q1(nadRewardVideoActivity).g().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.m3();
                return;
            }
            zp0 zp0Var = zp0.a;
            ls0 g = NadRewardVideoActivity.Q1(this.b).g();
            ms0 m = NadRewardVideoActivity.Q1(this.b).g().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            zp0Var.d(g, str, new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class q extends tn0<wn0> {

        /* loaded from: classes3.dex */
        public static final class a implements zp0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.zp0.a
            public void onFail(Exception exc) {
                bq0.j(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.zp0.a
            public void a(gs0 gs0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.D2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (gs0Var != null) {
                    str = gs0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (gs0Var != null) {
                    str2 = gs0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                    if (gs0Var != null) {
                        str3 = gs0Var.a();
                    }
                    bq0.k(str4, "5", str3);
                }
            }
        }

        public q(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tn0
        public void onEvent(wn0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().b()) {
                zp0 zp0Var = zp0.a;
                ls0 g = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).g();
                gs0 k = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).g().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                zp0Var.d(g, str, new a());
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
            li0 li0Var;
            ir0 ir0Var;
            if (NadRewardVideoActivity.Q1(this.b).d() != null) {
                fs0 d = NadRewardVideoActivity.Q1(this.b).d();
                Intrinsics.checkNotNull(d);
                li0Var = new li0(d.b());
            } else {
                mr0 mr0Var = NadRewardVideoActivity.Q1(this.b).m;
                if (mr0Var != null) {
                    ir0Var = mr0Var.p;
                } else {
                    ir0Var = null;
                }
                li0Var = new li0(ir0Var);
            }
            pn0.a().a(li0Var);
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
            bq0.f(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this));
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
            mp0 mp0Var = NadRewardVideoActivity.this.Q;
            if (mp0Var != null) {
                str = mp0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            bq0.p(str2, !z);
            if (NadRewardVideoActivity.this.k3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ t71 b;

        public j(t71 t71Var) {
            this.b = t71Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            bq0.r(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this));
            if (!NadRewardVideoActivity.this.A2(this.b.c)) {
                if (Intrinsics.areEqual(this.b.c, "__CONVERT_CMD__")) {
                    if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).m()) {
                        tj0.c(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f(), NadRewardVideoActivity.this);
                        return;
                    }
                    String str2 = null;
                    if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).l()) {
                        NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                        mr0 mr0Var = NadRewardVideoActivity.Q1(nadRewardVideoActivity).m;
                        if (mr0Var != null) {
                            str = mr0Var.t;
                        } else {
                            str = null;
                        }
                        if (nadRewardVideoActivity.A2(str)) {
                            NadRewardVideoActivity.this.n3();
                            return;
                        }
                    }
                    mr0 mr0Var2 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).m;
                    if (mr0Var2 != null) {
                        str2 = mr0Var2.t;
                    }
                    tj0.c(str2, NadRewardVideoActivity.this);
                    return;
                }
                tj0.c(this.b.c, NadRewardVideoActivity.this);
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
            mr0 mr0Var;
            ir0 ir0Var;
            String str;
            boolean z;
            String str2;
            String str3;
            ir0 ir0Var2;
            ir0 ir0Var3;
            ir0 ir0Var4;
            ir0 ir0Var5;
            if (NadRewardVideoActivity.Q1(this.b).l()) {
                NadRewardVideoActivity nadRewardVideoActivity = this.b;
                if (nadRewardVideoActivity.A2(NadRewardVideoActivity.Q1(nadRewardVideoActivity).f.c)) {
                    this.b.n3();
                }
            }
            if (NadRewardVideoActivity.Q1(this.b).m() && (mr0Var = NadRewardVideoActivity.Q1(this.b).m) != null && (ir0Var = mr0Var.p) != null && ir0Var.e) {
                mr0 mr0Var2 = NadRewardVideoActivity.Q1(this.b).m;
                String str4 = null;
                if (mr0Var2 != null && (ir0Var5 = mr0Var2.p) != null) {
                    str = ir0Var5.b;
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
                    mr0 mr0Var3 = NadRewardVideoActivity.Q1(this.b).m;
                    if (mr0Var3 != null && (ir0Var4 = mr0Var3.p) != null) {
                        str2 = ir0Var4.a;
                    } else {
                        str2 = null;
                    }
                    if (!((str2 == null || str2.length() == 0) ? true : true)) {
                        mr0 mr0Var4 = NadRewardVideoActivity.Q1(this.b).m;
                        if (mr0Var4 != null && (ir0Var3 = mr0Var4.p) != null) {
                            str3 = ir0Var3.a;
                        } else {
                            str3 = null;
                        }
                        if (s51.d(str3)) {
                            Context context = this.a.getContext();
                            mr0 mr0Var5 = NadRewardVideoActivity.Q1(this.b).m;
                            if (mr0Var5 != null && (ir0Var2 = mr0Var5.p) != null) {
                                str4 = ir0Var2.a;
                            }
                            Intrinsics.checkNotNull(str4);
                            gk0.b(context, str4);
                        }
                    }
                }
                tj0.b(s51.b(NadRewardVideoActivity.Q1(this.b), NadRewardVideoActivity.Q1(this.b).f()));
            }
            this.b.z2();
            NadRewardVideoActivity.Q1(this.b).h().e(true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class m extends mu0 {
        public m() {
        }

        @Override // com.baidu.tieba.mu0, com.baidu.tieba.fu0
        public void onEnd(int i) {
            String str;
            zr0 zr0Var;
            l81 l81Var;
            NadRewardBigCardView nadRewardBigCardView;
            if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).b() == null) {
                pp0 pp0Var = NadRewardVideoActivity.this.D;
                if (pp0Var != null) {
                    pp0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardVideoActivity.this.O;
                if (nadRewardBigCardView2 != null) {
                    nadRewardBigCardView2.setVisibility(false);
                }
                NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().i(true);
                String str2 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                mp0 mp0Var = NadRewardVideoActivity.this.Q;
                String str3 = null;
                if (mp0Var != null) {
                    str = mp0Var.f();
                } else {
                    str = null;
                }
                xr0 xr0Var = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).j;
                if (xr0Var != null && (zr0Var = xr0Var.i) != null) {
                    str3 = zr0Var.a;
                }
                bq0.t(str2, str, str3);
            } else {
                ds0 c = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).c();
                if (c != null && c.b() && (((l81Var = NadRewardVideoActivity.this.E) == null || !l81Var.isShowing()) && (nadRewardBigCardView = NadRewardVideoActivity.this.O) != null)) {
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

        @Override // com.baidu.tieba.mu0, com.baidu.tieba.fu0
        public void onStart() {
            NadRewardVideoActivity.this.i3(false);
            pp0 pp0Var = NadRewardVideoActivity.this.D;
            if (pp0Var != null) {
                pp0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class n extends s11 {
        @Override // com.baidu.tieba.s11, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (up0.a().a()) {
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
    public static final class p implements tp0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public p() {
        }

        @Override // com.baidu.tieba.tp0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.Q = null;
            NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().j(false);
        }

        @Override // com.baidu.tieba.tp0.b
        public void a(mp0 mp0Var) {
            boolean z;
            AdDownloadStatus adDownloadStatus;
            boolean z2;
            NadRewardVideoActivity.this.Q = mp0Var;
            if (mp0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.f1050T++;
            int i = 0;
            if (mp0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.f(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).g().b(mp0Var.d()));
                }
                bq0.d(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, mp0Var.d(), NadRewardVideoActivity.this.G2(), mp0Var.f(), mp0Var.h());
                if (mp0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    bq0.u(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "2", mp0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(mp0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                }
                if (i <= 0) {
                    bq0.l(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            bq0.g(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "1", mp0Var.d());
            NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().j(mp0Var.c());
            NadRewardVideoActivity.this.a0 = !mp0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).g().t());
            NadRewardVideoActivity.this.d3("0", "任务完成回调", hashMap);
            qe1<View> transitionButtonView = NadRewardVideoActivity.this.D2().getTransitionButtonView();
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
                nadRewardTaskHelper.t(mp0Var, adDownloadStatus, str);
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
    public static final class s implements r81 {
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ NadRewardVideoActivity b;
        public final /* synthetic */ long c;

        @Override // com.baidu.tieba.r81
        public void a() {
        }

        @Override // com.baidu.tieba.r81
        public void dismiss() {
        }

        @Override // com.baidu.tieba.r81
        public void f() {
        }

        public s(Boolean bool, NadRewardVideoActivity nadRewardVideoActivity, long j) {
            this.a = bool;
            this.b = nadRewardVideoActivity;
            this.c = j;
        }

        @Override // com.baidu.tieba.r81
        public void b() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.r81
        public void d() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.r81
        public void c() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (this.b.Y) {
                ur0 Q1 = NadRewardVideoActivity.Q1(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                bq0.o(Q1, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                return;
            }
            ur0 Q12 = NadRewardVideoActivity.Q1(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            bq0.o(Q12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
        }

        @Override // com.baidu.tieba.r81
        public void e() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (Intrinsics.areEqual(this.a, Boolean.TRUE) && this.b.Y) {
                ur0 Q1 = NadRewardVideoActivity.Q1(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                bq0.o(Q1, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                return;
            }
            ur0 Q12 = NadRewardVideoActivity.Q1(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            bq0.o(Q12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
        }
    }

    /* loaded from: classes3.dex */
    public static final class t implements PopupWindow.OnDismissListener {
        public t() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            iu0 iu0Var = NadRewardVideoActivity.this.I;
            if (iu0Var != null) {
                iu0Var.resume();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.A;
            if (adImageView != null) {
                ExtensionsKt.e(adImageView, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class u implements r81 {
        @Override // com.baidu.tieba.r81
        public void b() {
        }

        @Override // com.baidu.tieba.r81
        public void c() {
        }

        @Override // com.baidu.tieba.r81
        public void d() {
        }

        @Override // com.baidu.tieba.r81
        public void dismiss() {
        }

        @Override // com.baidu.tieba.r81
        public void e() {
        }

        @Override // com.baidu.tieba.r81
        public void f() {
        }

        public u() {
        }

        @Override // com.baidu.tieba.r81
        public void a() {
            bq0.i(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1() {
        super.C1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        iu0 iu0Var = this.I;
        if (iu0Var != null) {
            iu0Var.release();
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
            layoutParams.topMargin = c61.c.a(this, 1.5f);
            layoutParams.setMarginEnd(c61.c.a(this, 5.0f));
            layoutParams.height = c61.c.a(this, 39.0f);
            layoutParams.width = c61.c.a(this, 39.0f);
            F2().addView(this.A, layoutParams);
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            int a2 = c61.c.a(adImageView.getContext(), 10.0f);
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
            ur0 ur0Var = this.P;
            if (ur0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = ur0Var.g().s();
            ur0 ur0Var2 = this.P;
            if (ur0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, ur0Var2.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$2
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ls0 g2 = ur0Var.g();
        mp0 mp0Var = this.Q;
        if (mp0Var != null) {
            str = mp0Var.e();
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = ur0Var.e;
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
            o31.b(monitorUrl.clickUrl);
        }
    }

    public static final /* synthetic */ ur0 Q1(NadRewardVideoActivity nadRewardVideoActivity) {
        ur0 ur0Var = nadRewardVideoActivity.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return ur0Var;
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
        if (z || !hk0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new yj0(str).a(), "rewardWebPanel");
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1(Intent intent) {
        super.D1(intent);
        setIntent(intent);
        if (!b3()) {
            g51.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
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
            layoutParams.height = c61.c.c(this) - i2;
        } else {
            layoutParams.height = c61.c.a(this, 33.0f);
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ur0Var.h().h(this.U);
        return true;
    }

    public final void C2() {
        int a2 = j61.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.U = a2;
        j61.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void E1() {
        super.E1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
        iu0 iu0Var = this.I;
        if (iu0Var != null) {
            iu0Var.pause();
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
            ur0 ur0Var = this.P;
            if (ur0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(ur0Var);
        }
    }

    public final void R2() {
        int a2 = j61.a("nad_reward_sp", "key_session_count", 1);
        this.S = a2;
        j61.e("nad_reward_sp", "key_session_count", a2 + 1);
    }

    public final void V2() {
        boolean z;
        ImageView J2 = J2();
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var.d() != null) {
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
        tp0 b2 = up0.b();
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        b2.a(ur0Var, new ks0(this.S, this.f1050T), new p());
    }

    public final void c3() {
        iu0 iu0Var = this.I;
        if (iu0Var != null) {
            iu0Var.pause();
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
    }

    public final void f3() {
        pn0.a().b(this, new q(wn0.class));
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        ur0 ur0Var = this.P;
        if (ur0Var != null) {
            if (ur0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            es0 f2 = ur0Var.g().f();
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
                tj0.c(str, this);
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
        l81 l81Var = this.E;
        if (l81Var == null || !l81Var.isShowing()) {
            pp0 pp0Var = this.D;
            if (pp0Var != null && (view2 = pp0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            iu0 iu0Var = this.I;
            if (iu0Var != null) {
                iu0Var.resume();
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        bq0.q(ur0Var);
        C2();
        ur0 ur0Var2 = this.P;
        if (ur0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        tj0.c(ur0Var2.f.m, this);
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var.b() == null) {
            this.O = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        ur0 ur0Var2 = this.P;
        if (ur0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(ur0Var2);
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
                iu0 iu0Var = NadRewardVideoActivity.this.I;
                if (iu0Var != null) {
                    iu0Var.pause();
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
                iu0 iu0Var = NadRewardVideoActivity.this.I;
                if (iu0Var != null) {
                    iu0Var.resume();
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
        layoutParams.bottomMargin = -c61.c.c(this);
        F2().addView(this.O, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.O;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.O;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        ur0 ur0Var3 = this.P;
        if (ur0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = ur0Var3.g().s();
        ur0 ur0Var4 = this.P;
        if (ur0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        cs0 b2 = ur0Var4.b();
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
        l81 l81Var;
        ViewGroup view2;
        boolean z;
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var.g().k() != null) {
            ur0 ur0Var2 = this.P;
            if (ur0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (ur0Var2.g().m() != null) {
                ur0 ur0Var3 = this.P;
                if (ur0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ms0 m2 = ur0Var3.g().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !yt.a(this) && !Z2() && ((l81Var = this.E) == null || !l81Var.isShowing())) {
                    pp0 pp0Var = this.D;
                    if (pp0Var != null && (view2 = pp0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    ur0 ur0Var4 = this.P;
                    if (ur0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ls0 g2 = ur0Var4.g();
                    ur0 ur0Var5 = this.P;
                    if (ur0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    gs0 k2 = ur0Var5.g().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    ur0 ur0Var6 = this.P;
                    if (ur0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    gs0 k3 = ur0Var6.g().k();
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var.e().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.E = null;
            return;
        }
        l81 l81Var = this.E;
        if (l81Var != null && l81Var.isShowing()) {
            return;
        }
        l81 l81Var2 = new l81(this);
        l81Var2.setOnDismissListener(new t());
        l81Var2.i(new u());
        double a2 = 1 - (c61.c.a(this, 41.0f) / c61.c.c(this));
        ur0 ur0Var2 = this.P;
        if (ur0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String e2 = ur0Var2.e();
        ur0 ur0Var3 = this.P;
        if (ur0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        s81 s81Var = new s81(e2, a2, 0, ur0Var3.f.d);
        s81Var.A(false);
        s81Var.C(true);
        s81Var.B(true);
        s81Var.y(true);
        ur0 ur0Var4 = this.P;
        if (ur0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!TextUtils.isEmpty(ur0Var4.f.m)) {
            ur0 ur0Var5 = this.P;
            if (ur0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            s81Var.v(ur0Var5.f.l);
        }
        Unit unit = Unit.INSTANCE;
        l81Var2.h(s81Var);
        l81Var2.j();
        Unit unit2 = Unit.INSTANCE;
        this.E = l81Var2;
        iu0 iu0Var = this.I;
        if (iu0Var != null) {
            iu0Var.pause();
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            ExtensionsKt.e(adImageView, false);
        }
        ur0 ur0Var6 = this.P;
        if (ur0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ur0Var6.h().g(true);
    }

    public final void N2() {
        ExpandIconView E2 = E2();
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ds0 c2 = ur0Var.c();
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
            ur0 ur0Var = this.P;
            if (ur0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return s3(ur0Var.g().c());
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        t71 a2 = t71.a(ur0Var.j());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.H == null) {
                this.H = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((c61.c.e(this) * 9) / 16) / 2) + c61.c.a(this, 26.0f);
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        s71 a2 = s71.a(ur0Var.k());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.G == null) {
                this.G = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((c61.c.e(this) * 9) / 16) / 2) + c61.c.a(this, 52.0f);
                layoutParams.setMarginStart(c61.c.a(this, 9.0f));
                layoutParams.setMarginEnd(c61.c.a(this, 8.0f));
                F2().addView(this.G, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.G;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(c61.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        os0 p2 = ur0Var.g().p();
        if (p2 != null && p2.f() != null) {
            ur0 ur0Var2 = this.P;
            if (ur0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            os0 p3 = ur0Var2.g().p();
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
                ur0 ur0Var3 = this.P;
                if (ur0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, ur0Var3.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
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
        l81 l81Var = this.E;
        if (l81Var != null && l81Var.isShowing()) {
            return;
        }
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ds0 c2 = ur0Var.c();
        if (c2 != null && c2.b()) {
            ur0 ur0Var2 = this.P;
            if (ur0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            xr0 xr0Var = ur0Var2.j;
            if (xr0Var != null) {
                int i2 = xr0Var.c;
                ur0 ur0Var3 = this.P;
                if (ur0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == ur0Var3.g().s()) {
                    return;
                }
            }
        }
        this.b0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        pp0 pp0Var = this.D;
        if (pp0Var != null) {
            pp0Var.setVisibility(false);
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        os0 p2 = ur0Var.g().p();
        if (p2 == null || p2.f() == null || this.V) {
            return false;
        }
        l81 l81Var = this.E;
        if (l81Var != null && l81Var.isShowing()) {
            return false;
        }
        ur0 ur0Var2 = this.P;
        if (ur0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        os0 p3 = ur0Var2.g().p();
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        os0 p2 = ur0Var.g().p();
        if (p2 != null && p2.f() != null) {
            ur0 ur0Var2 = this.P;
            if (ur0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final os0 p3 = ur0Var2.g().p();
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
            ur0 ur0Var3 = this.P;
            if (ur0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = ur0Var3.g().s();
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
                            os0 os0Var = p3;
                            if (os0Var != null) {
                                str2 = os0Var.b();
                            } else {
                                str2 = null;
                            }
                            bq0.h(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void U2() {
        zr0 zr0Var;
        zr0 zr0Var2;
        String str;
        zr0 zr0Var3;
        String str2;
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        xr0 xr0Var = ur0Var.j;
        NadRewardHalfTailHolder nadRewardHalfTailHolder = null;
        if (xr0Var != null) {
            zr0Var = xr0Var.i;
        } else {
            zr0Var = null;
        }
        if (zr0Var != null) {
            ur0 ur0Var2 = this.P;
            if (ur0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ds0 c2 = ur0Var2.c();
            if (c2 == null || c2.n()) {
                ur0 ur0Var3 = this.P;
                if (ur0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xr0 xr0Var2 = ur0Var3.j;
                if (xr0Var2 != null && (zr0Var2 = xr0Var2.i) != null) {
                    ur0 ur0Var4 = this.P;
                    if (ur0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    xr0 xr0Var3 = ur0Var4.j;
                    if (xr0Var3 != null && (zr0Var3 = xr0Var3.i) != null && (str2 = zr0Var3.x) != null) {
                        mp0 mp0Var = this.Q;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (mp0Var == null || (r4 = mp0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    zr0Var2.x = str;
                }
                pp0 pp0Var = this.D;
                if (pp0Var != null) {
                    pp0Var.setVisibility(false);
                }
                pp0.a aVar = pp0.k0;
                ur0 ur0Var5 = this.P;
                if (ur0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                pp0 a2 = aVar.a(ur0Var5, this);
                this.D = a2;
                if (a2 != null) {
                    ur0 ur0Var6 = this.P;
                    if (ur0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(ur0Var6);
                }
                pp0 pp0Var2 = this.D;
                if (!(pp0Var2 instanceof View)) {
                    pp0Var2 = null;
                }
                View view2 = (View) pp0Var2;
                if (view2 != null) {
                    H2().removeAllViews();
                    H2().addView(view2);
                    H2().bringToFront();
                }
                pp0 pp0Var3 = this.D;
                if (pp0Var3 != null) {
                    pp0Var3.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
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
                            pp0 pp0Var4 = NadRewardVideoActivity.this.D;
                            if (pp0Var4 != null) {
                                pp0Var4.setVisibility(false);
                            }
                            iu0 iu0Var = NadRewardVideoActivity.this.I;
                            if (iu0Var != null) {
                                iu0Var.start();
                            }
                        }
                    });
                }
                pp0 pp0Var4 = this.D;
                if (pp0Var4 instanceof NadRewardHalfTailHolder) {
                    nadRewardHalfTailHolder = pp0Var4;
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
        pp0 pp0Var5 = this.D;
        if (pp0Var5 != null) {
            pp0Var5.setVisibility(false);
        }
    }

    public final void W2() {
        boolean z;
        int i2;
        lr0 lr0Var;
        int i3;
        zr0 zr0Var;
        NadRewardVideoAdOverContainer D2 = D2();
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var.d() == null) {
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
        ur0 ur0Var2 = this.P;
        if (ur0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var2.g().C()) {
            ur0 ur0Var3 = this.P;
            if (ur0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = ur0Var3.f.c;
            Context context = D2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (Y2(str, context)) {
                ur0 ur0Var4 = this.P;
                if (ur0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                mr0 mr0Var = ur0Var4.m;
                if (mr0Var != null) {
                    mr0Var.g = true;
                }
                ur0 ur0Var5 = this.P;
                if (ur0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xr0 xr0Var = ur0Var5.j;
                if (xr0Var != null && (zr0Var = xr0Var.i) != null) {
                    zr0Var.C = true;
                }
            }
        }
        ur0 ur0Var6 = this.P;
        if (ur0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var6.d() != null) {
            ur0 ur0Var7 = this.P;
            if (ur0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            mr0 mr0Var2 = ur0Var7.m;
            if (mr0Var2 != null) {
                mr0Var2.e = true;
            }
            ur0 ur0Var8 = this.P;
            if (ur0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            mr0 mr0Var3 = ur0Var8.m;
            if (mr0Var3 != null) {
                ur0 ur0Var9 = this.P;
                if (ur0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (ur0Var9.m()) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                mr0Var3.a = i3;
            }
            ur0 ur0Var10 = this.P;
            if (ur0Var10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            mr0 mr0Var4 = ur0Var10.m;
            if (mr0Var4 != null) {
                ur0 ur0Var11 = this.P;
                if (ur0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fs0 d2 = ur0Var11.d();
                Intrinsics.checkNotNull(d2);
                mr0Var4.p = d2.b();
            }
            ur0 ur0Var12 = this.P;
            if (ur0Var12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            mr0 mr0Var5 = ur0Var12.m;
            if (mr0Var5 != null && (lr0Var = mr0Var5.q) != null) {
                ur0 ur0Var13 = this.P;
                if (ur0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                lr0Var.d = ur0Var13.f.d;
            }
        }
        ur0 ur0Var14 = this.P;
        if (ur0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        D2.setData(ur0Var14);
        ur0 ur0Var15 = this.P;
        if (ur0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var15.l()) {
            D2.setBottomLineHeight(c61.c.a(D2.getContext(), 41.0f));
        } else {
            D2.setBottomLineHeight(c61.c.a(D2.getContext(), 10.0f));
        }
        D2.setOnUiClickListener(new k(D2, this));
        D2.setFeedbackBtnVisibility(false);
        D2.setFestivalClickCallback(new l(D2, this));
    }

    public final void X2() {
        boolean z;
        if (this.I == null) {
            ju0 ju0Var = new ju0();
            ju0Var.a = 2;
            iu0 b2 = iu0.a.b(this, 0, ju0Var);
            this.I = b2;
            if (b2 != null) {
                b2.attachToContainer(K2());
            }
        }
        iu0 iu0Var = this.I;
        if (iu0Var != null) {
            iu0Var.d(new n());
            ur0 ur0Var = this.P;
            if (ur0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            xr0 xr0Var = ur0Var.j;
            if (xr0Var != null && xr0Var.g) {
                iu0Var.setVideoScalingMode(0);
            } else {
                iu0Var.setVideoScalingMode(2);
            }
            iu0Var.a(new m());
        }
        ur0 ur0Var2 = this.P;
        if (ur0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var2.j == null) {
            K2().setVisibility(8);
            this.I = null;
            return;
        }
        iu0 iu0Var2 = this.I;
        if (iu0Var2 != null) {
            ur0 ur0Var3 = this.P;
            if (ur0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            xr0 xr0Var2 = ur0Var3.j;
            Intrinsics.checkNotNull(xr0Var2);
            iu0Var2.c(xr0Var2);
        }
        if (NetUtil.a(this)) {
            ur0 ur0Var4 = this.P;
            if (ur0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ds0 c2 = ur0Var4.c();
            if (c2 != null) {
                z = c2.n();
            } else {
                z = false;
            }
            iu0 iu0Var3 = this.I;
            if (iu0Var3 != null) {
                iu0Var3.setLooping(!z);
            }
            iu0 iu0Var4 = this.I;
            if (iu0Var4 != null) {
                iu0Var4.start();
            }
        } else {
            g51.a().a(this, R.string.nad_reward_video_lp_no_network);
        }
        NadRewardInterceptFrameLayout K2 = K2();
        K2.setVisibility(0);
        ur0 ur0Var5 = this.P;
        if (ur0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        K2.setEnableIntercept(ur0Var5.l());
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
                bq0.s(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this));
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        fs0 d2 = ur0Var.d();
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
            l81 l81Var = this.F;
            if (l81Var != null) {
                l81Var.e();
            }
            this.F = null;
            return;
        }
        l81 l81Var2 = this.F;
        if (l81Var2 != null) {
            l81Var2.e();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Handler handler = this.X;
        if (handler != null) {
            Runnable runnable = this.Z;
            ur0 ur0Var2 = this.P;
            if (ur0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fs0 d3 = ur0Var2.d();
            if (d3 != null) {
                j2 = d3.a();
            } else {
                j2 = 0;
            }
            handler.postDelayed(runnable, j2);
        }
        l81 l81Var3 = new l81(this);
        ur0 ur0Var3 = this.P;
        if (ur0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        fs0 d4 = ur0Var3.d();
        if (d4 != null) {
            bool = Boolean.valueOf(d4.d());
        } else {
            bool = null;
        }
        l81Var3.i(new s(bool, this, currentTimeMillis));
        double a2 = 1 - (c61.c.a(this, 41.0f) / c61.c.c(this));
        ur0 ur0Var4 = this.P;
        if (ur0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        fs0 d5 = ur0Var4.d();
        if (d5 != null) {
            str2 = d5.c();
        }
        String str3 = str2;
        ur0 ur0Var5 = this.P;
        if (ur0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        s81 s81Var = new s81(str3, a2, 0, ur0Var5.f.d);
        s81Var.A(false);
        s81Var.C(true);
        s81Var.w(true);
        s81Var.x(true);
        Unit unit = Unit.INSTANCE;
        l81Var3.h(s81Var);
        l81Var3.j();
        Unit unit2 = Unit.INSTANCE;
        this.F = l81Var3;
    }

    public final boolean Y2(String str, Context context) {
        Object m844constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new yj0(str).d();
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
        zr0 zr0Var;
        String str;
        zr0 zr0Var2;
        Boolean bool;
        boolean z;
        String d2;
        String str2;
        String replace$default;
        String str3;
        String d3;
        zr0 zr0Var3;
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
            m844constructorimpl = Result.m844constructorimpl(aq0.a.d((HashMap) serializable));
            if (Result.m851isSuccessimpl(m844constructorimpl)) {
                ur0 ur0Var = (ur0) m844constructorimpl;
                this.P = ur0Var;
                if (ur0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xr0 xr0Var = ur0Var.j;
                String str7 = "";
                if (xr0Var != null && (zr0Var3 = xr0Var.i) != null) {
                    ur0 ur0Var2 = this.P;
                    if (ur0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (ur0Var2.m()) {
                        String str8 = zr0Var3.f;
                        if (str8 != null) {
                            ur0 ur0Var3 = this.P;
                            if (ur0Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str8, "__CONVERT_CMD__", ur0Var3.f(), false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        zr0Var3.f = replace$default2;
                    } else {
                        String str9 = zr0Var3.f;
                        if (str9 != null) {
                            ur0 ur0Var4 = this.P;
                            if (ur0Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            mr0 mr0Var = ur0Var4.m;
                            if (mr0Var == null || (str5 = mr0Var.t) == null) {
                                str4 = "";
                            } else {
                                str4 = str5;
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str9, "__CONVERT_CMD__", str4, false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        zr0Var3.f = replace$default2;
                    }
                }
                ur0 ur0Var5 = this.P;
                if (ur0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                cs0 b2 = ur0Var5.b();
                if (b2 != null) {
                    ur0 ur0Var6 = this.P;
                    if (ur0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (ur0Var6.m()) {
                        ur0 ur0Var7 = this.P;
                        if (ur0Var7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        cs0 b3 = ur0Var7.b();
                        if (b3 != null && (d3 = b3.d()) != null) {
                            ur0 ur0Var8 = this.P;
                            if (ur0Var8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d3, "__CONVERT_CMD__", ur0Var8.f(), false, 4, (Object) null);
                        }
                        b2.h(str7);
                    } else {
                        ur0 ur0Var9 = this.P;
                        if (ur0Var9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        cs0 b4 = ur0Var9.b();
                        if (b4 != null && (d2 = b4.d()) != null) {
                            ur0 ur0Var10 = this.P;
                            if (ur0Var10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            mr0 mr0Var2 = ur0Var10.m;
                            if (mr0Var2 == null || (str3 = mr0Var2.t) == null) {
                                str2 = "";
                            } else {
                                str2 = str3;
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d2, "__CONVERT_CMD__", str2, false, 4, (Object) null);
                        }
                        b2.h(str7);
                    }
                }
                ur0 ur0Var11 = this.P;
                if (ur0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                mr0 mr0Var3 = ur0Var11.m;
                boolean z2 = true;
                if (mr0Var3 != null) {
                    mr0Var3.d = true;
                }
                ur0 ur0Var12 = this.P;
                if (ur0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                mr0 mr0Var4 = ur0Var12.m;
                if (mr0Var4 != null) {
                    ur0 ur0Var13 = this.P;
                    if (ur0Var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ds0 c2 = ur0Var13.c();
                    if (c2 != null) {
                        z = c2.f();
                    } else {
                        z = false;
                    }
                    mr0Var4.f = z;
                }
                ur0 ur0Var14 = this.P;
                if (ur0Var14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xr0 xr0Var2 = ur0Var14.j;
                if (xr0Var2 != null && (zr0Var2 = xr0Var2.i) != null) {
                    ur0 ur0Var15 = this.P;
                    if (ur0Var15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ds0 c3 = ur0Var15.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.p());
                    } else {
                        bool = null;
                    }
                    zr0Var2.D = bool;
                }
                ur0 ur0Var16 = this.P;
                if (ur0Var16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xr0 xr0Var3 = ur0Var16.j;
                if (xr0Var3 != null && (zr0Var = xr0Var3.i) != null) {
                    ur0 ur0Var17 = this.P;
                    if (ur0Var17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ds0 c4 = ur0Var17.c();
                    if (c4 != null) {
                        str = c4.o();
                    } else {
                        str = null;
                    }
                    zr0Var.E = str;
                }
                hp0 hp0Var = (hp0) ServiceManager.getService(hp0.a);
                ur0 ur0Var18 = this.P;
                if (ur0Var18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (ur0Var18.g().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && hp0Var != null) {
                    ur0 ur0Var19 = this.P;
                    if (ur0Var19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ls0 g2 = ur0Var19.g();
                    String a2 = hp0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    g2.F(a2);
                }
                ur0 ur0Var20 = this.P;
                if (ur0Var20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                mr0 mr0Var5 = ur0Var20.m;
                if (mr0Var5 != null) {
                    ur0 ur0Var21 = this.P;
                    if (ur0Var21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = ur0Var21.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    mr0Var5.h = list;
                }
                ur0 ur0Var22 = this.P;
                if (ur0Var22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                es0 f2 = ur0Var22.g().f();
                if (f2 != null) {
                    str6 = f2.c();
                }
                this.a0 = Intrinsics.areEqual(str6, "0");
            }
            Throwable m847exceptionOrNullimpl = Result.m847exceptionOrNullimpl(m844constructorimpl);
            if (m847exceptionOrNullimpl != null && vh0.a) {
                g51.a().showToast(this, m847exceptionOrNullimpl.getMessage());
            }
            return Result.m851isSuccessimpl(m844constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final void d3(String str, String str2, HashMap<String, String> hashMap) {
        np0 np0Var = new np0();
        np0Var.a = str;
        np0Var.b = hashMap;
        pn0.a().a(np0Var);
    }

    public final boolean o3(long j2) {
        boolean z;
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ur0Var.g().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        ur0 ur0Var2 = this.P;
        if (ur0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog w2 = w2(this, ur0Var2.g().n(j2), false, 2, null);
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = ur0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.i2(str, str2);
        ur0 ur0Var2 = this.P;
        if (ur0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.x2(ur0Var2.g().k());
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
        float e2 = ((c61.c.e(this) / c61.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        xr0 xr0Var = ur0Var.j;
        if (xr0Var != null) {
            if (xr0Var.f > 0.0f) {
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = ur0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.i2(str, str2);
        lp0 T1 = nadRewardVideoDialog.T1();
        boolean z4 = true;
        if (T1 != null) {
            if (z) {
                ur0 ur0Var2 = this.P;
                if (ur0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (ur0Var2.h().d()) {
                    z3 = true;
                    T1.M(z3);
                }
            }
            z3 = false;
            T1.M(z3);
        }
        lp0 T12 = nadRewardVideoDialog.T1();
        if (T12 != null) {
            ur0 ur0Var3 = this.P;
            if (ur0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            T12.L(ur0Var3.g().r());
        }
        lp0 T13 = nadRewardVideoDialog.T1();
        if (T13 != null) {
            ur0 ur0Var4 = this.P;
            if (ur0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (ur0Var4.g().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                ur0 ur0Var5 = this.P;
                if (ur0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = ur0Var5.g().i();
            } else {
                ur0 ur0Var6 = this.P;
                if (ur0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qs0 q2 = ur0Var6.g().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            T13.I(valueOf);
        }
        lp0 T14 = nadRewardVideoDialog.T1();
        if (T14 != null) {
            ur0 ur0Var7 = this.P;
            if (ur0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (ur0Var7.d() == null) {
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
                mr0 mr0Var;
                ir0 ir0Var;
                String str4;
                boolean z5;
                String str5;
                String str6;
                ir0 ir0Var2;
                ir0 ir0Var3;
                ir0 ir0Var4;
                ir0 ir0Var5;
                l81 l81Var;
                ViewGroup view2;
                boolean z6;
                boolean z7 = false;
                if (NadRewardVideoActivity.Q1(this).l() && this.A2(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                    pp0 pp0Var = this.D;
                    if (pp0Var != null && (view2 = pp0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            ds0 c2 = NadRewardVideoActivity.Q1(this).c();
                            if (c2 != null) {
                            }
                        }
                    }
                    l81Var = this.F;
                    if (l81Var == null || !l81Var.isShowing()) {
                        this.n3();
                    }
                }
                if (NadRewardVideoActivity.Q1(this).m() && (mr0Var = NadRewardVideoActivity.Q1(this).m) != null && (ir0Var = mr0Var.p) != null && ir0Var.e) {
                    mr0 mr0Var2 = NadRewardVideoActivity.Q1(this).m;
                    String str7 = null;
                    if (mr0Var2 != null && (ir0Var5 = mr0Var2.p) != null) {
                        str4 = ir0Var5.b;
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && str4.length() != 0) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        mr0 mr0Var3 = NadRewardVideoActivity.Q1(this).m;
                        if (mr0Var3 != null && (ir0Var4 = mr0Var3.p) != null) {
                            str5 = ir0Var4.a;
                        } else {
                            str5 = null;
                        }
                        if (!((str5 == null || str5.length() == 0) ? true : true)) {
                            mr0 mr0Var4 = NadRewardVideoActivity.Q1(this).m;
                            if (mr0Var4 != null && (ir0Var3 = mr0Var4.p) != null) {
                                str6 = ir0Var3.a;
                            } else {
                                str6 = null;
                            }
                            if (s51.d(str6)) {
                                Context context = NadRewardVideoDialog.this.getContext();
                                if (context != null) {
                                    mr0 mr0Var5 = NadRewardVideoActivity.Q1(this).m;
                                    if (mr0Var5 != null && (ir0Var2 = mr0Var5.p) != null) {
                                        str7 = ir0Var2.a;
                                    }
                                    Intrinsics.checkNotNull(str7);
                                    gk0.b(context, str7);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    tj0.b(s51.b(NadRewardVideoActivity.Q1(this), NadRewardVideoActivity.Q1(this).f()));
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
        ur0 ur0Var = this.P;
        if (ur0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = ur0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.i2(str, str4);
        lp0 T1 = nadRewardSuspendDialog.T1();
        String str5 = null;
        if (T1 != null) {
            ur0 ur0Var2 = this.P;
            if (ur0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            os0 p2 = ur0Var2.g().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            T1.G(str3);
        }
        lp0 T12 = nadRewardSuspendDialog.T1();
        if (T12 != null) {
            ur0 ur0Var3 = this.P;
            if (ur0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            os0 p3 = ur0Var3.g().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            T12.K(str2);
        }
        lp0 T13 = nadRewardSuspendDialog.T1();
        if (T13 != null) {
            ur0 ur0Var4 = this.P;
            if (ur0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            os0 p4 = ur0Var4.g().p();
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
