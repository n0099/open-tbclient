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
import com.baidu.tieba.a71;
import com.baidu.tieba.aj0;
import com.baidu.tieba.an0;
import com.baidu.tieba.ap0;
import com.baidu.tieba.bp0;
import com.baidu.tieba.br0;
import com.baidu.tieba.ch0;
import com.baidu.tieba.dn0;
import com.baidu.tieba.er0;
import com.baidu.tieba.fj0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.gr0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.j51;
import com.baidu.tieba.jr0;
import com.baidu.tieba.kr0;
import com.baidu.tieba.lr0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.n41;
import com.baidu.tieba.nj0;
import com.baidu.tieba.nr0;
import com.baidu.tieba.oj0;
import com.baidu.tieba.oo0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.pt0;
import com.baidu.tieba.q51;
import com.baidu.tieba.qt0;
import com.baidu.tieba.rr0;
import com.baidu.tieba.s71;
import com.baidu.tieba.sh0;
import com.baidu.tieba.so0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.sr0;
import com.baidu.tieba.st;
import com.baidu.tieba.to0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.tr0;
import com.baidu.tieba.tt0;
import com.baidu.tieba.uo0;
import com.baidu.tieba.v21;
import com.baidu.tieba.vr0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.wo0;
import com.baidu.tieba.xd1;
import com.baidu.tieba.xr0;
import com.baidu.tieba.y71;
import com.baidu.tieba.z01;
import com.baidu.tieba.z41;
import com.baidu.tieba.z61;
import com.baidu.tieba.z71;
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
    public wo0 D;
    public s71 E;
    public s71 F;
    public NadHighLightTextView G;
    public NadIconTextButton H;
    public pt0 I;
    public NadRewardVideoDialog J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardSuspendDialog M;
    public NadRewardLottieDialog N;
    public NadRewardBigCardView O;
    public br0 P;
    public to0 Q;
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

    public final NadRewardVideoAdOverContainer K2() {
        return (NadRewardVideoAdOverContainer) this.x.getValue();
    }

    public final ExpandIconView L2() {
        return (ExpandIconView) this.z.getValue();
    }

    public final FrameLayout M2() {
        return (FrameLayout) this.u.getValue();
    }

    public final FrameLayout O2() {
        return (FrameLayout) this.y.getValue();
    }

    public final View P2() {
        return (View) this.w.getValue();
    }

    public final ImageView Q2() {
        return (ImageView) this.B.getValue();
    }

    public final NadRewardInterceptFrameLayout R2() {
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
        public static final class a implements gp0.a {
            public a() {
            }

            @Override // com.baidu.tieba.gp0.a
            public void onFail(Exception exc) {
                ip0.j(NadRewardVideoActivity.X1(l.this.b).f.d, "4");
                Toast.makeText(l.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.gp0.a
            public void a(nr0 nr0Var) {
                String str;
                NadRewardVideoActivity.X1(l.this.b).g().E(nr0Var);
                String str2 = null;
                if (nr0Var != null) {
                    str = nr0Var.f();
                } else {
                    str = null;
                }
                if (!Intrinsics.areEqual(str, "1")) {
                    l.this.b.t3();
                    String str3 = NadRewardVideoActivity.X1(l.this.b).f.d;
                    if (nr0Var != null) {
                        str2 = nr0Var.a();
                    }
                    ip0.k(str3, "4", str2);
                    return;
                }
                l.this.a.setFestivalEntranceContainerInvisible();
                Toast.makeText(l.this.b, nr0Var.d(), 0).show();
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.X1(this.b).g().k() != null) {
                nr0 k = NadRewardVideoActivity.X1(this.b).g().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    nr0 k2 = NadRewardVideoActivity.X1(nadRewardVideoActivity).g().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.t3();
                return;
            }
            gp0 gp0Var = gp0.a;
            sr0 g = NadRewardVideoActivity.X1(this.b).g();
            tr0 m = NadRewardVideoActivity.X1(this.b).g().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            gp0Var.d(g, str, new a());
        }
    }

    /* loaded from: classes2.dex */
    public static final class q extends an0<dn0> {

        /* loaded from: classes2.dex */
        public static final class a implements gp0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.gp0.a
            public void onFail(Exception exc) {
                ip0.j(NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.gp0.a
            public void a(nr0 nr0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.K2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (nr0Var != null) {
                    str = nr0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (nr0Var != null) {
                    str2 = nr0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d;
                    if (nr0Var != null) {
                        str3 = nr0Var.a();
                    }
                    ip0.k(str4, "5", str3);
                }
            }
        }

        public q(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.an0
        public void onEvent(dn0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.X1(NadRewardVideoActivity.this).h().b()) {
                gp0 gp0Var = gp0.a;
                sr0 g = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).g();
                nr0 k = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).g().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                gp0Var.d(g, str, new a());
                NadRewardVideoActivity.X1(NadRewardVideoActivity.this).h().f(false);
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
            NadRewardVideoActivity.this.G2();
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
            sh0 sh0Var;
            pq0 pq0Var;
            if (NadRewardVideoActivity.X1(this.b).d() != null) {
                mr0 d = NadRewardVideoActivity.X1(this.b).d();
                Intrinsics.checkNotNull(d);
                sh0Var = new sh0(d.b());
            } else {
                tq0 tq0Var = NadRewardVideoActivity.X1(this.b).m;
                if (tq0Var != null) {
                    pq0Var = tq0Var.p;
                } else {
                    pq0Var = null;
                }
                sh0Var = new sh0(pq0Var);
            }
            wm0.a().a(sh0Var);
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
            NadRewardVideoActivity.this.G2();
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
            NadRewardVideoActivity.this.G2();
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.u3();
            ip0.f(NadRewardVideoActivity.X1(NadRewardVideoActivity.this));
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
            String str2 = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d;
            to0 to0Var = NadRewardVideoActivity.this.Q;
            if (to0Var != null) {
                str = to0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            ip0.p(str2, !z);
            if (NadRewardVideoActivity.this.r3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ a71 b;

        public j(a71 a71Var) {
            this.b = a71Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ip0.r(NadRewardVideoActivity.X1(NadRewardVideoActivity.this));
            if (!NadRewardVideoActivity.this.H2(this.b.c)) {
                if (Intrinsics.areEqual(this.b.c, "__CONVERT_CMD__")) {
                    if (NadRewardVideoActivity.X1(NadRewardVideoActivity.this).m()) {
                        aj0.c(NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f(), NadRewardVideoActivity.this);
                        return;
                    }
                    String str2 = null;
                    if (NadRewardVideoActivity.X1(NadRewardVideoActivity.this).l()) {
                        NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                        tq0 tq0Var = NadRewardVideoActivity.X1(nadRewardVideoActivity).m;
                        if (tq0Var != null) {
                            str = tq0Var.t;
                        } else {
                            str = null;
                        }
                        if (nadRewardVideoActivity.H2(str)) {
                            NadRewardVideoActivity.this.u3();
                            return;
                        }
                    }
                    tq0 tq0Var2 = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).m;
                    if (tq0Var2 != null) {
                        str2 = tq0Var2.t;
                    }
                    aj0.c(str2, NadRewardVideoActivity.this);
                    return;
                }
                aj0.c(this.b.c, NadRewardVideoActivity.this);
                return;
            }
            NadRewardVideoActivity.this.u3();
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
            tq0 tq0Var;
            pq0 pq0Var;
            String str;
            boolean z;
            String str2;
            String str3;
            pq0 pq0Var2;
            pq0 pq0Var3;
            pq0 pq0Var4;
            pq0 pq0Var5;
            if (NadRewardVideoActivity.X1(this.b).l()) {
                NadRewardVideoActivity nadRewardVideoActivity = this.b;
                if (nadRewardVideoActivity.H2(NadRewardVideoActivity.X1(nadRewardVideoActivity).f.c)) {
                    this.b.u3();
                }
            }
            if (NadRewardVideoActivity.X1(this.b).m() && (tq0Var = NadRewardVideoActivity.X1(this.b).m) != null && (pq0Var = tq0Var.p) != null && pq0Var.e) {
                tq0 tq0Var2 = NadRewardVideoActivity.X1(this.b).m;
                String str4 = null;
                if (tq0Var2 != null && (pq0Var5 = tq0Var2.p) != null) {
                    str = pq0Var5.b;
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
                    tq0 tq0Var3 = NadRewardVideoActivity.X1(this.b).m;
                    if (tq0Var3 != null && (pq0Var4 = tq0Var3.p) != null) {
                        str2 = pq0Var4.a;
                    } else {
                        str2 = null;
                    }
                    if (!((str2 == null || str2.length() == 0) ? true : true)) {
                        tq0 tq0Var4 = NadRewardVideoActivity.X1(this.b).m;
                        if (tq0Var4 != null && (pq0Var3 = tq0Var4.p) != null) {
                            str3 = pq0Var3.a;
                        } else {
                            str3 = null;
                        }
                        if (z41.d(str3)) {
                            Context context = this.a.getContext();
                            tq0 tq0Var5 = NadRewardVideoActivity.X1(this.b).m;
                            if (tq0Var5 != null && (pq0Var2 = tq0Var5.p) != null) {
                                str4 = pq0Var2.a;
                            }
                            Intrinsics.checkNotNull(str4);
                            nj0.b(context, str4);
                        }
                    }
                }
                aj0.b(z41.b(NadRewardVideoActivity.X1(this.b), NadRewardVideoActivity.X1(this.b).f()));
            }
            this.b.G2();
            NadRewardVideoActivity.X1(this.b).h().e(true);
        }
    }

    /* loaded from: classes2.dex */
    public static final class m extends tt0 {
        public m() {
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onEnd(int i) {
            String str;
            gr0 gr0Var;
            s71 s71Var;
            NadRewardBigCardView nadRewardBigCardView;
            if (NadRewardVideoActivity.X1(NadRewardVideoActivity.this).b() == null) {
                wo0 wo0Var = NadRewardVideoActivity.this.D;
                if (wo0Var != null) {
                    wo0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardVideoActivity.this.O;
                if (nadRewardBigCardView2 != null) {
                    nadRewardBigCardView2.setVisibility(false);
                }
                NadRewardVideoActivity.X1(NadRewardVideoActivity.this).h().i(true);
                String str2 = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d;
                to0 to0Var = NadRewardVideoActivity.this.Q;
                String str3 = null;
                if (to0Var != null) {
                    str = to0Var.f();
                } else {
                    str = null;
                }
                er0 er0Var = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).j;
                if (er0Var != null && (gr0Var = er0Var.i) != null) {
                    str3 = gr0Var.a;
                }
                ip0.t(str2, str, str3);
            } else {
                kr0 c = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).c();
                if (c != null && c.b() && (((s71Var = NadRewardVideoActivity.this.E) == null || !s71Var.isShowing()) && (nadRewardBigCardView = NadRewardVideoActivity.this.O) != null)) {
                    nadRewardBigCardView.y(true);
                }
                NadRewardVideoActivity.this.p3(true);
                NadRewardVideoActivity.this.q3();
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

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onStart() {
            NadRewardVideoActivity.this.p3(false);
            wo0 wo0Var = NadRewardVideoActivity.this.D;
            if (wo0Var != null) {
                wo0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class n extends z01 {
        @Override // com.baidu.tieba.z01, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (bp0.a().a()) {
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
            if (NadRewardVideoActivity.this.M2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                nadRewardVideoActivity.R = nadRewardVideoActivity.M2().getMeasuredHeight() / NadRewardVideoActivity.this.M2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class p implements ap0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public p() {
        }

        @Override // com.baidu.tieba.ap0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.Q = null;
            NadRewardVideoActivity.X1(NadRewardVideoActivity.this).h().j(false);
        }

        @Override // com.baidu.tieba.ap0.b
        public void a(to0 to0Var) {
            boolean z;
            AdDownloadStatus adDownloadStatus;
            boolean z2;
            NadRewardVideoActivity.this.Q = to0Var;
            if (to0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.T++;
            int i = 0;
            if (to0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.f(NadRewardVideoActivity.X1(NadRewardVideoActivity.this).g().b(to0Var.d()));
                }
                ip0.d(NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d, to0Var.d(), NadRewardVideoActivity.this.N2(), to0Var.f(), to0Var.h());
                if (to0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    ip0.u(NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d, "2", to0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(to0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                }
                if (i <= 0) {
                    ip0.l(NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            ip0.g(NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d, "1", to0Var.d());
            NadRewardVideoActivity.X1(NadRewardVideoActivity.this).h().j(to0Var.c());
            NadRewardVideoActivity.this.a0 = !to0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.X1(NadRewardVideoActivity.this).g().t());
            NadRewardVideoActivity.this.k3("0", "任务完成回调", hashMap);
            xd1<View> transitionButtonView = NadRewardVideoActivity.this.K2().getTransitionButtonView();
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
                String str = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d;
                Intrinsics.checkNotNullExpressionValue(str, "adModel.common.extraParam");
                nadRewardTaskHelper.t(to0Var, adDownloadStatus, str);
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
    public static final class s implements y71 {
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ NadRewardVideoActivity b;
        public final /* synthetic */ long c;

        @Override // com.baidu.tieba.y71
        public void a() {
        }

        @Override // com.baidu.tieba.y71
        public void dismiss() {
        }

        @Override // com.baidu.tieba.y71
        public void f() {
        }

        public s(Boolean bool, NadRewardVideoActivity nadRewardVideoActivity, long j) {
            this.a = bool;
            this.b = nadRewardVideoActivity;
            this.c = j;
        }

        @Override // com.baidu.tieba.y71
        public void b() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.y71
        public void d() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.y71
        public void c() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (this.b.Y) {
                br0 X1 = NadRewardVideoActivity.X1(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                ip0.o(X1, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                return;
            }
            br0 X12 = NadRewardVideoActivity.X1(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            ip0.o(X12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
        }

        @Override // com.baidu.tieba.y71
        public void e() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (Intrinsics.areEqual(this.a, Boolean.TRUE) && this.b.Y) {
                br0 X1 = NadRewardVideoActivity.X1(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                ip0.o(X1, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                return;
            }
            br0 X12 = NadRewardVideoActivity.X1(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            ip0.o(X12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
        }
    }

    /* loaded from: classes2.dex */
    public static final class t implements PopupWindow.OnDismissListener {
        public t() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            pt0 pt0Var = NadRewardVideoActivity.this.I;
            if (pt0Var != null) {
                pt0Var.resume();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.A;
            if (adImageView != null) {
                ExtensionsKt.e(adImageView, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class u implements y71 {
        @Override // com.baidu.tieba.y71
        public void b() {
        }

        @Override // com.baidu.tieba.y71
        public void c() {
        }

        @Override // com.baidu.tieba.y71
        public void d() {
        }

        @Override // com.baidu.tieba.y71
        public void dismiss() {
        }

        @Override // com.baidu.tieba.y71
        public void e() {
        }

        @Override // com.baidu.tieba.y71
        public void f() {
        }

        public u() {
        }

        @Override // com.baidu.tieba.y71
        public void a() {
            ip0.i(NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d);
        }
    }

    public final void G2() {
        boolean z;
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = br0Var.e;
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
            v21.b(monitorUrl.clickUrl);
        }
    }

    public final void V2() {
        if (this.A == null) {
            this.A = new AdImageView(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = BadgeDrawable.TOP_END;
            layoutParams.topMargin = j51.c.a(this, 1.5f);
            layoutParams.setMarginEnd(j51.c.a(this, 5.0f));
            layoutParams.height = j51.c.a(this, 39.0f);
            layoutParams.width = j51.c.a(this, 39.0f);
            M2().addView(this.A, layoutParams);
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            int a2 = j51.c.a(adImageView.getContext(), 10.0f);
            adImageView.setPadding(a2, a2, a2, a2);
            adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            adImageView.setOnClickListener(new i());
        }
    }

    public final void W2() {
        if (this.C == null) {
            NadVideoRewardCountDownView nadVideoRewardCountDownView = new NadVideoRewardCountDownView(this, null, 0, 6, null);
            AbsRewardCountDownView.b(nadVideoRewardCountDownView, M2(), 0, false, null, 14, null);
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
            br0 br0Var = this.P;
            if (br0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = br0Var.g().s();
            br0 br0Var2 = this.P;
            if (br0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, br0Var2.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$2
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
        }
    }

    public final boolean w3() {
        String str;
        boolean z;
        if (!this.a0) {
            return false;
        }
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        sr0 g2 = br0Var.g();
        to0 to0Var = this.Q;
        if (to0Var != null) {
            str = to0Var.e();
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
        NadRewardVideoDialog D2 = D2(this, l2, false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        D2.show(supportFragmentManager, (String) null);
        this.L = D2;
        j3();
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void z1() {
        super.z1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        pt0 pt0Var = this.I;
        if (pt0Var != null) {
            pt0Var.release();
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
        K2().y();
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

    public static final /* synthetic */ br0 X1(NadRewardVideoActivity nadRewardVideoActivity) {
        br0 br0Var = nadRewardVideoActivity.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return br0Var;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void A1(Intent intent) {
        super.A1(intent);
        setIntent(intent);
        if (!i3()) {
            n41.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
            return;
        }
        S2();
        s3();
    }

    public final boolean H2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !oj0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new fj0(str).a(), "rewardWebPanel");
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean I1(Bundle bundle) {
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

    public final void p3(boolean z) {
        int i2;
        ViewGroup.LayoutParams layoutParams = P2().getLayoutParams();
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            i2 = nadRewardBigCardView.getHeight();
        } else {
            i2 = 0;
        }
        if (z) {
            layoutParams.height = j51.c.c(this) - i2;
        } else {
            layoutParams.height = j51.c.a(this, 33.0f);
        }
        P2().setLayoutParams(layoutParams);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void y1(Bundle bundle) {
        super.y1(bundle);
        setContentView(R.layout.nad_reward_video_lp_activity);
        M2().post(new o());
        this.X = new Handler(Looper.getMainLooper());
        if (!i3()) {
            finish();
            return;
        }
        Y2();
        S2();
    }

    public final boolean z3(String str) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        NadRewardVideoDialog C2 = C2(str, true);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        C2.show(supportFragmentManager, (String) null);
        this.J = C2;
        j3();
        return true;
    }

    public static /* synthetic */ NadRewardVideoDialog D2(NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nadRewardVideoActivity.C2(str, z);
    }

    public final void A3() {
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ip0.q(br0Var);
        J2();
        br0 br0Var2 = this.P;
        if (br0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        aj0.c(br0Var2.f.m, this);
        y3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1() {
        super.C1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
        pt0 pt0Var = this.I;
        if (pt0Var != null) {
            pt0Var.pause();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void F1() {
        super.F1();
        if (g3()) {
            return;
        }
        o3();
    }

    public final void J2() {
        int a2 = q51.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.U = a2;
        q51.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.S int), ('_' char), (wrap: int : 0x000f: IGET  (r1v2 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.T int)] */
    public final String N2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.S);
        sb.append('_');
        sb.append(this.T);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…d(rewardCount).toString()");
        return sb2;
    }

    public final void S2() {
        n3();
        c3();
        U2();
        W2();
        e3();
        d3();
        V2();
        a3();
        Z2();
        b3();
        T2();
        X2();
        A3();
    }

    public final void X2() {
        if (this.W == null) {
            this.W = new NadRewardTaskHelper();
        }
        NadRewardTaskHelper nadRewardTaskHelper = this.W;
        if (nadRewardTaskHelper != null) {
            br0 br0Var = this.P;
            if (br0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(br0Var);
        }
    }

    public final void Y2() {
        int a2 = q51.a("nad_reward_sp", "key_session_count", 1);
        this.S = a2;
        q51.e("nad_reward_sp", "key_session_count", a2 + 1);
    }

    public final void c3() {
        boolean z;
        ImageView Q2 = Q2();
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var.d() != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Q2.setVisibility(0);
        } else {
            Q2.setVisibility(8);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        br0 br0Var = this.P;
        if (br0Var != null) {
            if (br0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            lr0 f2 = br0Var.g().f();
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
                aj0.c(str, this);
            }
        }
        super.finish();
    }

    public final void h3() {
        ap0 b2 = bp0.b();
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        b2.a(br0Var, new rr0(this.S, this.T), new p());
    }

    public final void j3() {
        pt0 pt0Var = this.I;
        if (pt0Var != null) {
            pt0Var.pause();
        }
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
    }

    public final void m3() {
        wm0.a().b(this, new q(dn0.class));
    }

    public final void n3() {
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
    public final void o3() {
        ViewGroup view2;
        boolean z;
        s71 s71Var = this.E;
        if (s71Var == null || !s71Var.isShowing()) {
            wo0 wo0Var = this.D;
            if (wo0Var != null && (view2 = wo0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            pt0 pt0Var = this.I;
            if (pt0Var != null) {
                pt0Var.resume();
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
        s3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (r3()) {
            return;
        }
        super.onBackPressed();
    }

    public final void B3(float f2) {
        float f3;
        boolean z;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            f3 = nadRewardBigCardView.getHeight();
        } else {
            f3 = 0.0f;
        }
        float e2 = ((j51.c.e(this) / j51.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        er0 er0Var = br0Var.j;
        if (er0Var != null) {
            if (er0Var.f > 0.0f) {
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
        R2().setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        layoutParams2.bottomMargin = (int) ((f2 - 1) * f3);
        NadRewardBigCardView nadRewardBigCardView2 = this.O;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.setLayoutParams(layoutParams2);
        }
    }

    public final NadRewardVideoDialog C2(final String str, final boolean z) {
        boolean z2;
        Integer num;
        String valueOf;
        boolean z3;
        final NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = br0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.d2(str, str2);
        so0 O1 = nadRewardVideoDialog.O1();
        boolean z4 = true;
        if (O1 != null) {
            if (z) {
                br0 br0Var2 = this.P;
                if (br0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (br0Var2.h().d()) {
                    z3 = true;
                    O1.M(z3);
                }
            }
            z3 = false;
            O1.M(z3);
        }
        so0 O12 = nadRewardVideoDialog.O1();
        if (O12 != null) {
            br0 br0Var3 = this.P;
            if (br0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            O12.L(br0Var3.g().r());
        }
        so0 O13 = nadRewardVideoDialog.O1();
        if (O13 != null) {
            br0 br0Var4 = this.P;
            if (br0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (br0Var4.g().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                br0 br0Var5 = this.P;
                if (br0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = br0Var5.g().i();
            } else {
                br0 br0Var6 = this.P;
                if (br0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xr0 q2 = br0Var6.g().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            O13.I(valueOf);
        }
        so0 O14 = nadRewardVideoDialog.O1();
        if (O14 != null) {
            br0 br0Var7 = this.P;
            if (br0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (br0Var7.d() == null) {
                z4 = false;
            }
            O14.H(z4);
        }
        nadRewardVideoDialog.b2(new a(str, z));
        nadRewardVideoDialog.g2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2
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
        nadRewardVideoDialog.Z1(new b(str, z));
        nadRewardVideoDialog.c2(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4
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
                tq0 tq0Var;
                pq0 pq0Var;
                String str4;
                boolean z5;
                String str5;
                String str6;
                pq0 pq0Var2;
                pq0 pq0Var3;
                pq0 pq0Var4;
                pq0 pq0Var5;
                s71 s71Var;
                ViewGroup view2;
                boolean z6;
                boolean z7 = false;
                if (NadRewardVideoActivity.X1(this).l() && this.H2(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                    wo0 wo0Var = this.D;
                    if (wo0Var != null && (view2 = wo0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            kr0 c2 = NadRewardVideoActivity.X1(this).c();
                            if (c2 != null) {
                            }
                        }
                    }
                    s71Var = this.F;
                    if (s71Var == null || !s71Var.isShowing()) {
                        this.u3();
                    }
                }
                if (NadRewardVideoActivity.X1(this).m() && (tq0Var = NadRewardVideoActivity.X1(this).m) != null && (pq0Var = tq0Var.p) != null && pq0Var.e) {
                    tq0 tq0Var2 = NadRewardVideoActivity.X1(this).m;
                    String str7 = null;
                    if (tq0Var2 != null && (pq0Var5 = tq0Var2.p) != null) {
                        str4 = pq0Var5.b;
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && str4.length() != 0) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        tq0 tq0Var3 = NadRewardVideoActivity.X1(this).m;
                        if (tq0Var3 != null && (pq0Var4 = tq0Var3.p) != null) {
                            str5 = pq0Var4.a;
                        } else {
                            str5 = null;
                        }
                        if (!((str5 == null || str5.length() == 0) ? true : true)) {
                            tq0 tq0Var4 = NadRewardVideoActivity.X1(this).m;
                            if (tq0Var4 != null && (pq0Var3 = tq0Var4.p) != null) {
                                str6 = pq0Var3.a;
                            } else {
                                str6 = null;
                            }
                            if (z41.d(str6)) {
                                Context context = NadRewardVideoDialog.this.getContext();
                                if (context != null) {
                                    tq0 tq0Var5 = NadRewardVideoActivity.X1(this).m;
                                    if (tq0Var5 != null && (pq0Var2 = tq0Var5.p) != null) {
                                        str7 = pq0Var2.a;
                                    }
                                    Intrinsics.checkNotNull(str7);
                                    nj0.b(context, str7);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    aj0.b(z41.b(NadRewardVideoActivity.X1(this), NadRewardVideoActivity.X1(this).f()));
                }
            }
        });
        nadRewardVideoDialog.h2(new c(nadRewardVideoDialog, this, str, z));
        return nadRewardVideoDialog;
    }

    public final NadRewardLottieDialog E2(final String str) {
        m3();
        NadRewardLottieDialog nadRewardLottieDialog = new NadRewardLottieDialog();
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = br0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.d2(str, str2);
        br0 br0Var2 = this.P;
        if (br0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.s2(br0Var2.g().k());
        nadRewardLottieDialog.b2(new d(str));
        nadRewardLottieDialog.g2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$2
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
        nadRewardLottieDialog.Z1(new e(str));
        nadRewardLottieDialog.i2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.X1(NadRewardVideoActivity.this).h().f(true);
            }
        });
        return nadRewardLottieDialog;
    }

    public final boolean v3(long j2) {
        boolean z;
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var.g().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        br0 br0Var2 = this.P;
        if (br0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog D2 = D2(this, br0Var2.g().n(j2), false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        D2.show(supportFragmentManager, (String) null);
        this.K = D2;
        j3();
        return true;
    }

    public final NadRewardSuspendDialog F2(final String str) {
        String str2;
        String str3;
        NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = br0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.d2(str, str4);
        so0 O1 = nadRewardSuspendDialog.O1();
        String str5 = null;
        if (O1 != null) {
            br0 br0Var2 = this.P;
            if (br0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            vr0 p2 = br0Var2.g().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            O1.G(str3);
        }
        so0 O12 = nadRewardSuspendDialog.O1();
        if (O12 != null) {
            br0 br0Var3 = this.P;
            if (br0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            vr0 p3 = br0Var3.g().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            O12.K(str2);
        }
        so0 O13 = nadRewardSuspendDialog.O1();
        if (O13 != null) {
            br0 br0Var4 = this.P;
            if (br0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            vr0 p4 = br0Var4.g().p();
            if (p4 != null) {
                str5 = p4.g();
            }
            O13.N(str5);
        }
        nadRewardSuspendDialog.b2(new f(str));
        nadRewardSuspendDialog.g2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$2
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
        nadRewardSuspendDialog.Z1(new g(str));
        nadRewardSuspendDialog.j2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.this.l3();
            }
        });
        return nadRewardSuspendDialog;
    }

    public final boolean I2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null).contains(String.valueOf(this.U))) {
            return false;
        }
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        br0Var.h().h(this.U);
        return true;
    }

    public final void T2() {
        String f2;
        Integer intOrNull;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        int i2 = 0;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(false);
        }
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var.b() == null) {
            this.O = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        br0 br0Var2 = this.P;
        if (br0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(br0Var2);
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
                pt0 pt0Var = NadRewardVideoActivity.this.I;
                if (pt0Var != null) {
                    pt0Var.pause();
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
                pt0 pt0Var = NadRewardVideoActivity.this.I;
                if (pt0Var != null) {
                    pt0Var.resume();
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
                NadRewardVideoActivity.this.B3(f3);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.O = nadRewardBigCardView2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = -j51.c.c(this);
        M2().addView(this.O, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.O;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.O;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        br0 br0Var3 = this.P;
        if (br0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = br0Var3.g().s();
        br0 br0Var4 = this.P;
        if (br0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        jr0 b2 = br0Var4.b();
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
                    NadRewardVideoActivity.this.q3();
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
    public final boolean t3() {
        String str;
        s71 s71Var;
        ViewGroup view2;
        boolean z;
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var.g().k() != null) {
            br0 br0Var2 = this.P;
            if (br0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (br0Var2.g().m() != null) {
                br0 br0Var3 = this.P;
                if (br0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                tr0 m2 = br0Var3.g().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !st.a(this) && !g3() && ((s71Var = this.E) == null || !s71Var.isShowing())) {
                    wo0 wo0Var = this.D;
                    if (wo0Var != null && (view2 = wo0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    br0 br0Var4 = this.P;
                    if (br0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    sr0 g2 = br0Var4.g();
                    br0 br0Var5 = this.P;
                    if (br0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    nr0 k2 = br0Var5.g().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    br0 br0Var6 = this.P;
                    if (br0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    nr0 k3 = br0Var6.g().k();
                    Intrinsics.checkNotNull(k3);
                    NadRewardLottieDialog E2 = E2(g2.j(c2, k3.a()));
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    E2.show(supportFragmentManager, (String) null);
                    this.N = E2;
                    j3();
                    return true;
                }
            }
        }
        return false;
    }

    public final void u3() {
        boolean z;
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var.e().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.E = null;
            return;
        }
        s71 s71Var = this.E;
        if (s71Var != null && s71Var.isShowing()) {
            return;
        }
        s71 s71Var2 = new s71(this);
        s71Var2.setOnDismissListener(new t());
        s71Var2.i(new u());
        double a2 = 1 - (j51.c.a(this, 41.0f) / j51.c.c(this));
        br0 br0Var2 = this.P;
        if (br0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String e2 = br0Var2.e();
        br0 br0Var3 = this.P;
        if (br0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        z71 z71Var = new z71(e2, a2, 0, br0Var3.f.d);
        z71Var.A(false);
        z71Var.C(true);
        z71Var.B(true);
        z71Var.y(true);
        br0 br0Var4 = this.P;
        if (br0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!TextUtils.isEmpty(br0Var4.f.m)) {
            br0 br0Var5 = this.P;
            if (br0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            z71Var.v(br0Var5.f.l);
        }
        Unit unit = Unit.INSTANCE;
        s71Var2.h(z71Var);
        s71Var2.j();
        Unit unit2 = Unit.INSTANCE;
        this.E = s71Var2;
        pt0 pt0Var = this.I;
        if (pt0Var != null) {
            pt0Var.pause();
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            ExtensionsKt.e(adImageView, false);
        }
        br0 br0Var6 = this.P;
        if (br0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        br0Var6.h().g(true);
    }

    public final void U2() {
        ExpandIconView L2 = L2();
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        kr0 c2 = br0Var.c();
        boolean z = true;
        if ((c2 == null || !c2.e()) ? false : false) {
            L2.setVisibility(0);
        } else {
            L2.setVisibility(8);
            L2 = null;
        }
        if (L2 != null) {
            L2.setOnClickListener(new h());
        }
    }

    public final boolean g3() {
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

    public final boolean r3() {
        NadRewardTaskHelper nadRewardTaskHelper = this.W;
        if (nadRewardTaskHelper != null && nadRewardTaskHelper.A()) {
            br0 br0Var = this.P;
            if (br0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return z3(br0Var.g().c());
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            long seconds = timeUnit.toSeconds(absRewardCountDownView.getMillisUntilFinished());
            if (seconds <= 0) {
                return w3();
            }
            return v3(seconds);
        }
        return false;
    }

    public final void Z2() {
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        a71 a2 = a71.a(br0Var.j());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.H == null) {
                this.H = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((j51.c.e(this) * 9) / 16) / 2) + j51.c.a(this, 26.0f);
                M2().addView(this.H, layoutParams);
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

    public final void a3() {
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        z61 a2 = z61.a(br0Var.k());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.G == null) {
                this.G = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((j51.c.e(this) * 9) / 16) / 2) + j51.c.a(this, 52.0f);
                layoutParams.setMarginStart(j51.c.a(this, 9.0f));
                layoutParams.setMarginEnd(j51.c.a(this, 8.0f));
                M2().addView(this.G, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.G;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(j51.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
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

    public final void l3() {
        long j2;
        int i2;
        String d2;
        Integer intOrNull;
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        vr0 p2 = br0Var.g().p();
        if (p2 != null && p2.f() != null) {
            br0 br0Var2 = this.P;
            if (br0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            vr0 p3 = br0Var2.g().p();
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
                br0 br0Var3 = this.P;
                if (br0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, br0Var3.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
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
            }
        }
    }

    public final void q3() {
        if (this.b0) {
            return;
        }
        s71 s71Var = this.E;
        if (s71Var != null && s71Var.isShowing()) {
            return;
        }
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        kr0 c2 = br0Var.c();
        if (c2 != null && c2.b()) {
            br0 br0Var2 = this.P;
            if (br0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            er0 er0Var = br0Var2.j;
            if (er0Var != null) {
                int i2 = er0Var.c;
                br0 br0Var3 = this.P;
                if (br0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == br0Var3.g().s()) {
                    return;
                }
            }
        }
        this.b0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        wo0 wo0Var = this.D;
        if (wo0Var != null) {
            wo0Var.setVisibility(false);
        }
        NadHighLightTextView nadHighLightTextView = this.G;
        if (nadHighLightTextView != null) {
            ExtensionsKt.e(nadHighLightTextView, false);
        }
        NadIconTextButton nadIconTextButton = this.H;
        if (nadIconTextButton != null) {
            ExtensionsKt.e(nadIconTextButton, false);
        }
        K2().setFestivalEntranceContainerInvisible();
    }

    public final boolean x3() {
        JSONObject jSONObject;
        String f2;
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        vr0 p2 = br0Var.g().p();
        if (p2 == null || p2.f() == null || this.V) {
            return false;
        }
        s71 s71Var = this.E;
        if (s71Var != null && s71Var.isShowing()) {
            return false;
        }
        br0 br0Var2 = this.P;
        if (br0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        vr0 p3 = br0Var2.g().p();
        if (p3 != null && (f2 = p3.f()) != null) {
            jSONObject = ExtensionsKt.a(f2);
        } else {
            jSONObject = null;
        }
        NadRewardSuspendDialog F2 = F2(String.valueOf(jSONObject));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        F2.show(supportFragmentManager, (String) null);
        this.V = true;
        this.M = F2;
        j3();
        return true;
    }

    public final void y3() {
        String str;
        String c2;
        Integer intOrNull;
        int i2 = 0;
        this.V = false;
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        vr0 p2 = br0Var.g().p();
        if (p2 != null && p2.f() != null) {
            br0 br0Var2 = this.P;
            if (br0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final vr0 p3 = br0Var2.g().p();
            if (p3 != null) {
                str = p3.b();
            } else {
                str = null;
            }
            if (!I2(str)) {
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
            br0 br0Var3 = this.P;
            if (br0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = br0Var3.g().s();
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
                        boolean x3;
                        String str2;
                        x3 = NadRewardVideoActivity.this.x3();
                        if (x3) {
                            String str3 = NadRewardVideoActivity.X1(NadRewardVideoActivity.this).f.d;
                            String valueOf = String.valueOf(NadRewardVideoActivity.X1(NadRewardVideoActivity.this).h().c());
                            vr0 vr0Var = p3;
                            if (vr0Var != null) {
                                str2 = vr0Var.b();
                            } else {
                                str2 = null;
                            }
                            ip0.h(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void b3() {
        gr0 gr0Var;
        gr0 gr0Var2;
        String str;
        gr0 gr0Var3;
        String str2;
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        er0 er0Var = br0Var.j;
        NadRewardHalfTailHolder nadRewardHalfTailHolder = null;
        if (er0Var != null) {
            gr0Var = er0Var.i;
        } else {
            gr0Var = null;
        }
        if (gr0Var != null) {
            br0 br0Var2 = this.P;
            if (br0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            kr0 c2 = br0Var2.c();
            if (c2 == null || c2.n()) {
                br0 br0Var3 = this.P;
                if (br0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                er0 er0Var2 = br0Var3.j;
                if (er0Var2 != null && (gr0Var2 = er0Var2.i) != null) {
                    br0 br0Var4 = this.P;
                    if (br0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    er0 er0Var3 = br0Var4.j;
                    if (er0Var3 != null && (gr0Var3 = er0Var3.i) != null && (str2 = gr0Var3.x) != null) {
                        to0 to0Var = this.Q;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (to0Var == null || (r4 = to0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    gr0Var2.x = str;
                }
                wo0 wo0Var = this.D;
                if (wo0Var != null) {
                    wo0Var.setVisibility(false);
                }
                wo0.a aVar = wo0.k0;
                br0 br0Var5 = this.P;
                if (br0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                wo0 a2 = aVar.a(br0Var5, this);
                this.D = a2;
                if (a2 != null) {
                    br0 br0Var6 = this.P;
                    if (br0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(br0Var6);
                }
                wo0 wo0Var2 = this.D;
                if (!(wo0Var2 instanceof View)) {
                    wo0Var2 = null;
                }
                View view2 = (View) wo0Var2;
                if (view2 != null) {
                    O2().removeAllViews();
                    O2().addView(view2);
                    O2().bringToFront();
                }
                wo0 wo0Var3 = this.D;
                if (wo0Var3 != null) {
                    wo0Var3.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
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
                            wo0 wo0Var4 = NadRewardVideoActivity.this.D;
                            if (wo0Var4 != null) {
                                wo0Var4.setVisibility(false);
                            }
                            pt0 pt0Var = NadRewardVideoActivity.this.I;
                            if (pt0Var != null) {
                                pt0Var.start();
                            }
                        }
                    });
                }
                wo0 wo0Var4 = this.D;
                if (wo0Var4 instanceof NadRewardHalfTailHolder) {
                    nadRewardHalfTailHolder = wo0Var4;
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
        wo0 wo0Var5 = this.D;
        if (wo0Var5 != null) {
            wo0Var5.setVisibility(false);
        }
    }

    public final void d3() {
        boolean z;
        int i2;
        sq0 sq0Var;
        int i3;
        gr0 gr0Var;
        NadRewardVideoAdOverContainer K2 = K2();
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var.d() == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        K2.setVisibility(i2);
        K2.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
        br0 br0Var2 = this.P;
        if (br0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var2.g().C()) {
            br0 br0Var3 = this.P;
            if (br0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = br0Var3.f.c;
            Context context = K2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (f3(str, context)) {
                br0 br0Var4 = this.P;
                if (br0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                tq0 tq0Var = br0Var4.m;
                if (tq0Var != null) {
                    tq0Var.g = true;
                }
                br0 br0Var5 = this.P;
                if (br0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                er0 er0Var = br0Var5.j;
                if (er0Var != null && (gr0Var = er0Var.i) != null) {
                    gr0Var.C = true;
                }
            }
        }
        br0 br0Var6 = this.P;
        if (br0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var6.d() != null) {
            br0 br0Var7 = this.P;
            if (br0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            tq0 tq0Var2 = br0Var7.m;
            if (tq0Var2 != null) {
                tq0Var2.e = true;
            }
            br0 br0Var8 = this.P;
            if (br0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            tq0 tq0Var3 = br0Var8.m;
            if (tq0Var3 != null) {
                br0 br0Var9 = this.P;
                if (br0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (br0Var9.m()) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                tq0Var3.a = i3;
            }
            br0 br0Var10 = this.P;
            if (br0Var10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            tq0 tq0Var4 = br0Var10.m;
            if (tq0Var4 != null) {
                br0 br0Var11 = this.P;
                if (br0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                mr0 d2 = br0Var11.d();
                Intrinsics.checkNotNull(d2);
                tq0Var4.p = d2.b();
            }
            br0 br0Var12 = this.P;
            if (br0Var12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            tq0 tq0Var5 = br0Var12.m;
            if (tq0Var5 != null && (sq0Var = tq0Var5.q) != null) {
                br0 br0Var13 = this.P;
                if (br0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                sq0Var.d = br0Var13.f.d;
            }
        }
        br0 br0Var14 = this.P;
        if (br0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        K2.setData(br0Var14);
        br0 br0Var15 = this.P;
        if (br0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var15.l()) {
            K2.setBottomLineHeight(j51.c.a(K2.getContext(), 41.0f));
        } else {
            K2.setBottomLineHeight(j51.c.a(K2.getContext(), 10.0f));
        }
        K2.setOnUiClickListener(new k(K2, this));
        K2.setFeedbackBtnVisibility(false);
        K2.setFestivalClickCallback(new l(K2, this));
    }

    public final void e3() {
        boolean z;
        if (this.I == null) {
            qt0 qt0Var = new qt0();
            qt0Var.a = 2;
            pt0 b2 = pt0.a.b(this, 0, qt0Var);
            this.I = b2;
            if (b2 != null) {
                b2.attachToContainer(R2());
            }
        }
        pt0 pt0Var = this.I;
        if (pt0Var != null) {
            pt0Var.d(new n());
            br0 br0Var = this.P;
            if (br0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            er0 er0Var = br0Var.j;
            if (er0Var != null && er0Var.g) {
                pt0Var.setVideoScalingMode(0);
            } else {
                pt0Var.setVideoScalingMode(2);
            }
            pt0Var.a(new m());
        }
        br0 br0Var2 = this.P;
        if (br0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (br0Var2.j == null) {
            R2().setVisibility(8);
            this.I = null;
            return;
        }
        pt0 pt0Var2 = this.I;
        if (pt0Var2 != null) {
            br0 br0Var3 = this.P;
            if (br0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            er0 er0Var2 = br0Var3.j;
            Intrinsics.checkNotNull(er0Var2);
            pt0Var2.c(er0Var2);
        }
        if (NetUtil.a(this)) {
            br0 br0Var4 = this.P;
            if (br0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            kr0 c2 = br0Var4.c();
            if (c2 != null) {
                z = c2.n();
            } else {
                z = false;
            }
            pt0 pt0Var3 = this.I;
            if (pt0Var3 != null) {
                pt0Var3.setLooping(!z);
            }
            pt0 pt0Var4 = this.I;
            if (pt0Var4 != null) {
                pt0Var4.start();
            }
        } else {
            n41.a().a(this, R.string.nad_reward_video_lp_no_network);
        }
        NadRewardInterceptFrameLayout R2 = R2();
        R2.setVisibility(0);
        br0 br0Var5 = this.P;
        if (br0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        R2.setEnableIntercept(br0Var5.l());
        R2.setInterceptCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initVideoPlayer$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.u3();
                ip0.s(NadRewardVideoActivity.X1(NadRewardVideoActivity.this));
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = 0;
        R2.setLayoutParams(layoutParams);
    }

    public final void s3() {
        String str;
        boolean z;
        Boolean bool;
        long j2;
        br0 br0Var = this.P;
        if (br0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        mr0 d2 = br0Var.d();
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
            s71 s71Var = this.F;
            if (s71Var != null) {
                s71Var.e();
            }
            this.F = null;
            return;
        }
        s71 s71Var2 = this.F;
        if (s71Var2 != null) {
            s71Var2.e();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Handler handler = this.X;
        if (handler != null) {
            Runnable runnable = this.Z;
            br0 br0Var2 = this.P;
            if (br0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            mr0 d3 = br0Var2.d();
            if (d3 != null) {
                j2 = d3.a();
            } else {
                j2 = 0;
            }
            handler.postDelayed(runnable, j2);
        }
        s71 s71Var3 = new s71(this);
        br0 br0Var3 = this.P;
        if (br0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        mr0 d4 = br0Var3.d();
        if (d4 != null) {
            bool = Boolean.valueOf(d4.d());
        } else {
            bool = null;
        }
        s71Var3.i(new s(bool, this, currentTimeMillis));
        double a2 = 1 - (j51.c.a(this, 41.0f) / j51.c.c(this));
        br0 br0Var4 = this.P;
        if (br0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        mr0 d5 = br0Var4.d();
        if (d5 != null) {
            str2 = d5.c();
        }
        String str3 = str2;
        br0 br0Var5 = this.P;
        if (br0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        z71 z71Var = new z71(str3, a2, 0, br0Var5.f.d);
        z71Var.A(false);
        z71Var.C(true);
        z71Var.w(true);
        z71Var.x(true);
        Unit unit = Unit.INSTANCE;
        s71Var3.h(z71Var);
        s71Var3.j();
        Unit unit2 = Unit.INSTANCE;
        this.F = s71Var3;
    }

    public final boolean f3(String str, Context context) {
        Object m766constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new fj0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m766constructorimpl = Result.m766constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m766constructorimpl = Result.m766constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m772isFailureimpl(m766constructorimpl)) {
            m766constructorimpl = null;
        }
        String str3 = (String) m766constructorimpl;
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
    public final boolean i3() {
        Object m766constructorimpl;
        gr0 gr0Var;
        String str;
        gr0 gr0Var2;
        Boolean bool;
        boolean z;
        String d2;
        String str2;
        String replace$default;
        String str3;
        String d3;
        gr0 gr0Var3;
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
            m766constructorimpl = Result.m766constructorimpl(ResultKt.createFailure(th));
        }
        if (serializable != null) {
            m766constructorimpl = Result.m766constructorimpl(hp0.a.d((HashMap) serializable));
            if (Result.m773isSuccessimpl(m766constructorimpl)) {
                br0 br0Var = (br0) m766constructorimpl;
                this.P = br0Var;
                if (br0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                er0 er0Var = br0Var.j;
                String str7 = "";
                if (er0Var != null && (gr0Var3 = er0Var.i) != null) {
                    br0 br0Var2 = this.P;
                    if (br0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (br0Var2.m()) {
                        String str8 = gr0Var3.f;
                        if (str8 != null) {
                            br0 br0Var3 = this.P;
                            if (br0Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str8, "__CONVERT_CMD__", br0Var3.f(), false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        gr0Var3.f = replace$default2;
                    } else {
                        String str9 = gr0Var3.f;
                        if (str9 != null) {
                            br0 br0Var4 = this.P;
                            if (br0Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            tq0 tq0Var = br0Var4.m;
                            if (tq0Var == null || (str5 = tq0Var.t) == null) {
                                str4 = "";
                            } else {
                                str4 = str5;
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str9, "__CONVERT_CMD__", str4, false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        gr0Var3.f = replace$default2;
                    }
                }
                br0 br0Var5 = this.P;
                if (br0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                jr0 b2 = br0Var5.b();
                if (b2 != null) {
                    br0 br0Var6 = this.P;
                    if (br0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (br0Var6.m()) {
                        br0 br0Var7 = this.P;
                        if (br0Var7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        jr0 b3 = br0Var7.b();
                        if (b3 != null && (d3 = b3.d()) != null) {
                            br0 br0Var8 = this.P;
                            if (br0Var8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d3, "__CONVERT_CMD__", br0Var8.f(), false, 4, (Object) null);
                        }
                        b2.h(str7);
                    } else {
                        br0 br0Var9 = this.P;
                        if (br0Var9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        jr0 b4 = br0Var9.b();
                        if (b4 != null && (d2 = b4.d()) != null) {
                            br0 br0Var10 = this.P;
                            if (br0Var10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            tq0 tq0Var2 = br0Var10.m;
                            if (tq0Var2 == null || (str3 = tq0Var2.t) == null) {
                                str2 = "";
                            } else {
                                str2 = str3;
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d2, "__CONVERT_CMD__", str2, false, 4, (Object) null);
                        }
                        b2.h(str7);
                    }
                }
                br0 br0Var11 = this.P;
                if (br0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                tq0 tq0Var3 = br0Var11.m;
                boolean z2 = true;
                if (tq0Var3 != null) {
                    tq0Var3.d = true;
                }
                br0 br0Var12 = this.P;
                if (br0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                tq0 tq0Var4 = br0Var12.m;
                if (tq0Var4 != null) {
                    br0 br0Var13 = this.P;
                    if (br0Var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    kr0 c2 = br0Var13.c();
                    if (c2 != null) {
                        z = c2.f();
                    } else {
                        z = false;
                    }
                    tq0Var4.f = z;
                }
                br0 br0Var14 = this.P;
                if (br0Var14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                er0 er0Var2 = br0Var14.j;
                if (er0Var2 != null && (gr0Var2 = er0Var2.i) != null) {
                    br0 br0Var15 = this.P;
                    if (br0Var15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    kr0 c3 = br0Var15.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.p());
                    } else {
                        bool = null;
                    }
                    gr0Var2.D = bool;
                }
                br0 br0Var16 = this.P;
                if (br0Var16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                er0 er0Var3 = br0Var16.j;
                if (er0Var3 != null && (gr0Var = er0Var3.i) != null) {
                    br0 br0Var17 = this.P;
                    if (br0Var17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    kr0 c4 = br0Var17.c();
                    if (c4 != null) {
                        str = c4.o();
                    } else {
                        str = null;
                    }
                    gr0Var.E = str;
                }
                oo0 oo0Var = (oo0) ServiceManager.getService(oo0.a);
                br0 br0Var18 = this.P;
                if (br0Var18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (br0Var18.g().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && oo0Var != null) {
                    br0 br0Var19 = this.P;
                    if (br0Var19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    sr0 g2 = br0Var19.g();
                    String a2 = oo0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    g2.F(a2);
                }
                br0 br0Var20 = this.P;
                if (br0Var20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                tq0 tq0Var5 = br0Var20.m;
                if (tq0Var5 != null) {
                    br0 br0Var21 = this.P;
                    if (br0Var21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = br0Var21.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    tq0Var5.h = list;
                }
                br0 br0Var22 = this.P;
                if (br0Var22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                lr0 f2 = br0Var22.g().f();
                if (f2 != null) {
                    str6 = f2.c();
                }
                this.a0 = Intrinsics.areEqual(str6, "0");
            }
            Throwable m769exceptionOrNullimpl = Result.m769exceptionOrNullimpl(m766constructorimpl);
            if (m769exceptionOrNullimpl != null && ch0.a) {
                n41.a().showToast(this, m769exceptionOrNullimpl.getMessage());
            }
            return Result.m773isSuccessimpl(m766constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final void k3(String str, String str2, HashMap<String, String> hashMap) {
        uo0 uo0Var = new uo0();
        uo0Var.a = str;
        uo0Var.b = hashMap;
        wm0.a().a(uo0Var);
    }
}
