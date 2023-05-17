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
import com.baidu.tieba.a51;
import com.baidu.tieba.at0;
import com.baidu.tieba.br0;
import com.baidu.tieba.c71;
import com.baidu.tieba.ch0;
import com.baidu.tieba.co0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.cr0;
import com.baidu.tieba.do0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.dr0;
import com.baidu.tieba.dt0;
import com.baidu.tieba.eo0;
import com.baidu.tieba.f21;
import com.baidu.tieba.fr0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.go0;
import com.baidu.tieba.gt;
import com.baidu.tieba.hd1;
import com.baidu.tieba.hr0;
import com.baidu.tieba.i71;
import com.baidu.tieba.j01;
import com.baidu.tieba.j41;
import com.baidu.tieba.j61;
import com.baidu.tieba.j71;
import com.baidu.tieba.k61;
import com.baidu.tieba.ki0;
import com.baidu.tieba.km0;
import com.baidu.tieba.ko0;
import com.baidu.tieba.lo0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.mg0;
import com.baidu.tieba.nm0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.pi0;
import com.baidu.tieba.qo0;
import com.baidu.tieba.qq0;
import com.baidu.tieba.ro0;
import com.baidu.tieba.so0;
import com.baidu.tieba.t41;
import com.baidu.tieba.tq0;
import com.baidu.tieba.uq0;
import com.baidu.tieba.vq0;
import com.baidu.tieba.wq0;
import com.baidu.tieba.x31;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xq0;
import com.baidu.tieba.yi0;
import com.baidu.tieba.yn0;
import com.baidu.tieba.zp0;
import com.baidu.tieba.zs0;
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
    public go0 D;
    public c71 E;
    public c71 F;
    public NadHighLightTextView G;
    public NadIconTextButton H;
    public zs0 I;
    public NadRewardVideoDialog J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardSuspendDialog M;
    public NadRewardLottieDialog N;
    public NadRewardBigCardView O;
    public lq0 P;
    public do0 Q;
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

    /* loaded from: classes3.dex */
    public static final class l implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public l(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        /* loaded from: classes3.dex */
        public static final class a implements qo0.a {
            public a() {
            }

            @Override // com.baidu.tieba.qo0.a
            public void onFail(Exception exc) {
                so0.j(NadRewardVideoActivity.c2(l.this.b).f.d, "4");
                Toast.makeText(l.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.qo0.a
            public void a(xq0 xq0Var) {
                String str;
                NadRewardVideoActivity.c2(l.this.b).g().E(xq0Var);
                String str2 = null;
                if (xq0Var != null) {
                    str = xq0Var.f();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "1")) {
                    l.this.a.setFestivalEntranceContainerInvisible();
                    Toast.makeText(l.this.b, xq0Var.d(), 0).show();
                    return;
                }
                l.this.b.y3();
                String str3 = NadRewardVideoActivity.c2(l.this.b).f.d;
                if (xq0Var != null) {
                    str2 = xq0Var.a();
                }
                so0.k(str3, "4", str2);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.c2(this.b).g().k() != null) {
                xq0 k = NadRewardVideoActivity.c2(this.b).g().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    xq0 k2 = NadRewardVideoActivity.c2(nadRewardVideoActivity).g().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.y3();
                return;
            }
            qo0 qo0Var = qo0.a;
            cr0 g = NadRewardVideoActivity.c2(this.b).g();
            dr0 m = NadRewardVideoActivity.c2(this.b).g().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            qo0Var.d(g, str, new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class q extends km0<nm0> {

        /* loaded from: classes3.dex */
        public static final class a implements qo0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.qo0.a
            public void onFail(Exception exc) {
                so0.j(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.qo0.a
            public void a(xq0 xq0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.P2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (xq0Var != null) {
                    str = xq0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (xq0Var != null) {
                    str2 = xq0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d;
                    if (xq0Var != null) {
                        str3 = xq0Var.a();
                    }
                    so0.k(str4, "5", str3);
                }
            }
        }

        public q(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.km0
        public void onEvent(nm0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().b()) {
                qo0 qo0Var = qo0.a;
                cr0 g = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).g();
                xq0 k = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).g().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                qo0Var.d(g, str, new a());
                NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().f(false);
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
            ch0 ch0Var;
            zp0 zp0Var;
            if (NadRewardVideoActivity.c2(this.b).d() != null) {
                wq0 d = NadRewardVideoActivity.c2(this.b).d();
                Intrinsics.checkNotNull(d);
                ch0Var = new ch0(d.b());
            } else {
                dq0 dq0Var = NadRewardVideoActivity.c2(this.b).m;
                if (dq0Var != null) {
                    zp0Var = dq0Var.p;
                } else {
                    zp0Var = null;
                }
                ch0Var = new ch0(zp0Var);
            }
            gm0.a().a(ch0Var);
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
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.this.z3();
            so0.f(NadRewardVideoActivity.c2(NadRewardVideoActivity.this));
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
            String str2 = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d;
            do0 do0Var = NadRewardVideoActivity.this.Q;
            if (do0Var != null) {
                str = do0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            so0.p(str2, !z);
            if (NadRewardVideoActivity.this.w3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ k61 b;

        public j(k61 k61Var) {
            this.b = k61Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            so0.r(NadRewardVideoActivity.c2(NadRewardVideoActivity.this));
            if (!NadRewardVideoActivity.this.M2(this.b.c)) {
                if (Intrinsics.areEqual(this.b.c, "__CONVERT_CMD__")) {
                    if (NadRewardVideoActivity.c2(NadRewardVideoActivity.this).m()) {
                        ki0.c(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f(), NadRewardVideoActivity.this);
                        return;
                    }
                    String str2 = null;
                    if (NadRewardVideoActivity.c2(NadRewardVideoActivity.this).l()) {
                        NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                        dq0 dq0Var = NadRewardVideoActivity.c2(nadRewardVideoActivity).m;
                        if (dq0Var != null) {
                            str = dq0Var.t;
                        } else {
                            str = null;
                        }
                        if (nadRewardVideoActivity.M2(str)) {
                            NadRewardVideoActivity.this.z3();
                            return;
                        }
                    }
                    dq0 dq0Var2 = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).m;
                    if (dq0Var2 != null) {
                        str2 = dq0Var2.t;
                    }
                    ki0.c(str2, NadRewardVideoActivity.this);
                    return;
                }
                ki0.c(this.b.c, NadRewardVideoActivity.this);
                return;
            }
            NadRewardVideoActivity.this.z3();
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
            dq0 dq0Var;
            zp0 zp0Var;
            String str;
            boolean z;
            String str2;
            String str3;
            zp0 zp0Var2;
            zp0 zp0Var3;
            zp0 zp0Var4;
            zp0 zp0Var5;
            if (NadRewardVideoActivity.c2(this.b).l()) {
                NadRewardVideoActivity nadRewardVideoActivity = this.b;
                if (nadRewardVideoActivity.M2(NadRewardVideoActivity.c2(nadRewardVideoActivity).f.c)) {
                    this.b.z3();
                }
            }
            if (NadRewardVideoActivity.c2(this.b).m() && (dq0Var = NadRewardVideoActivity.c2(this.b).m) != null && (zp0Var = dq0Var.p) != null && zp0Var.e) {
                dq0 dq0Var2 = NadRewardVideoActivity.c2(this.b).m;
                String str4 = null;
                if (dq0Var2 != null && (zp0Var5 = dq0Var2.p) != null) {
                    str = zp0Var5.b;
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
                    dq0 dq0Var3 = NadRewardVideoActivity.c2(this.b).m;
                    if (dq0Var3 != null && (zp0Var4 = dq0Var3.p) != null) {
                        str2 = zp0Var4.a;
                    } else {
                        str2 = null;
                    }
                    if (!((str2 == null || str2.length() == 0) ? true : true)) {
                        dq0 dq0Var4 = NadRewardVideoActivity.c2(this.b).m;
                        if (dq0Var4 != null && (zp0Var3 = dq0Var4.p) != null) {
                            str3 = zp0Var3.a;
                        } else {
                            str3 = null;
                        }
                        if (j41.d(str3)) {
                            Context context = this.a.getContext();
                            dq0 dq0Var5 = NadRewardVideoActivity.c2(this.b).m;
                            if (dq0Var5 != null && (zp0Var2 = dq0Var5.p) != null) {
                                str4 = zp0Var2.a;
                            }
                            Intrinsics.checkNotNull(str4);
                            xi0.b(context, str4);
                        }
                    }
                }
                ki0.b(j41.b(NadRewardVideoActivity.c2(this.b), NadRewardVideoActivity.c2(this.b).f()));
            }
            this.b.L2();
            NadRewardVideoActivity.c2(this.b).h().e(true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class m extends dt0 {
        public m() {
        }

        @Override // com.baidu.tieba.dt0, com.baidu.tieba.ws0
        public void onEnd(int i) {
            String str;
            qq0 qq0Var;
            c71 c71Var;
            NadRewardBigCardView nadRewardBigCardView;
            if (NadRewardVideoActivity.c2(NadRewardVideoActivity.this).b() != null) {
                uq0 c = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).c();
                if (c != null && c.b() && (((c71Var = NadRewardVideoActivity.this.E) == null || !c71Var.isShowing()) && (nadRewardBigCardView = NadRewardVideoActivity.this.O) != null)) {
                    nadRewardBigCardView.y(true);
                }
                NadRewardVideoActivity.this.u3(true);
                NadRewardVideoActivity.this.v3();
            } else {
                go0 go0Var = NadRewardVideoActivity.this.D;
                if (go0Var != null) {
                    go0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardVideoActivity.this.O;
                if (nadRewardBigCardView2 != null) {
                    nadRewardBigCardView2.setVisibility(false);
                }
                NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().i(true);
                String str2 = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d;
                do0 do0Var = NadRewardVideoActivity.this.Q;
                String str3 = null;
                if (do0Var != null) {
                    str = do0Var.f();
                } else {
                    str = null;
                }
                oq0 oq0Var = NadRewardVideoActivity.c2(NadRewardVideoActivity.this).j;
                if (oq0Var != null && (qq0Var = oq0Var.i) != null) {
                    str3 = qq0Var.a;
                }
                so0.t(str2, str, str3);
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

        @Override // com.baidu.tieba.dt0, com.baidu.tieba.ws0
        public void onStart() {
            NadRewardVideoActivity.this.u3(false);
            go0 go0Var = NadRewardVideoActivity.this.D;
            if (go0Var != null) {
                go0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class n extends j01 {
        @Override // com.baidu.tieba.j01, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (lo0.a().a()) {
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
            if (NadRewardVideoActivity.this.R2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                nadRewardVideoActivity.R = nadRewardVideoActivity.R2().getMeasuredHeight() / NadRewardVideoActivity.this.R2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class p implements ko0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public p() {
        }

        @Override // com.baidu.tieba.ko0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.Q = null;
            NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().j(false);
        }

        @Override // com.baidu.tieba.ko0.b
        public void a(do0 do0Var) {
            boolean z;
            AdDownloadStatus adDownloadStatus;
            boolean z2;
            NadRewardVideoActivity.this.Q = do0Var;
            if (do0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.T++;
            int i = 0;
            if (do0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.C;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.f(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).g().b(do0Var.d()));
                }
                so0.d(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, do0Var.d(), NadRewardVideoActivity.this.S2(), do0Var.f(), do0Var.h());
                if (do0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    so0.u(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, "2", do0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(do0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                }
                if (i <= 0) {
                    so0.l(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            so0.g(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d, "1", do0Var.d());
            NadRewardVideoActivity.c2(NadRewardVideoActivity.this).h().j(do0Var.c());
            NadRewardVideoActivity.this.a0 = !do0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.c2(NadRewardVideoActivity.this).g().t());
            NadRewardVideoActivity.this.p3("0", "任务完成回调", hashMap);
            hd1<View> transitionButtonView = NadRewardVideoActivity.this.P2().getTransitionButtonView();
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
                nadRewardTaskHelper.t(do0Var, adDownloadStatus, str);
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
    public static final class s implements i71 {
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ NadRewardVideoActivity b;
        public final /* synthetic */ long c;

        @Override // com.baidu.tieba.i71
        public void a() {
        }

        @Override // com.baidu.tieba.i71
        public void dismiss() {
        }

        @Override // com.baidu.tieba.i71
        public void f() {
        }

        public s(Boolean bool, NadRewardVideoActivity nadRewardVideoActivity, long j) {
            this.a = bool;
            this.b = nadRewardVideoActivity;
            this.c = j;
        }

        @Override // com.baidu.tieba.i71
        public void b() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.i71
        public void d() {
            this.b.onBackPressed();
        }

        @Override // com.baidu.tieba.i71
        public void c() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (this.b.Y) {
                lq0 c2 = NadRewardVideoActivity.c2(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                so0.o(c2, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                return;
            }
            lq0 c22 = NadRewardVideoActivity.c2(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            so0.o(c22, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
        }

        @Override // com.baidu.tieba.i71
        public void e() {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (Intrinsics.areEqual(this.a, Boolean.TRUE) && this.b.Y) {
                lq0 c2 = NadRewardVideoActivity.c2(this.b);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                so0.o(c2, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                return;
            }
            lq0 c22 = NadRewardVideoActivity.c2(this.b);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            so0.o(c22, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
        }
    }

    /* loaded from: classes3.dex */
    public static final class t implements PopupWindow.OnDismissListener {
        public t() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            zs0 zs0Var = NadRewardVideoActivity.this.I;
            if (zs0Var != null) {
                zs0Var.resume();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.A;
            if (adImageView != null) {
                ExtensionsKt.e(adImageView, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class u implements i71 {
        @Override // com.baidu.tieba.i71
        public void b() {
        }

        @Override // com.baidu.tieba.i71
        public void c() {
        }

        @Override // com.baidu.tieba.i71
        public void d() {
        }

        @Override // com.baidu.tieba.i71
        public void dismiss() {
        }

        @Override // com.baidu.tieba.i71
        public void e() {
        }

        @Override // com.baidu.tieba.i71
        public void f() {
        }

        public u() {
        }

        @Override // com.baidu.tieba.i71
        public void a() {
            so0.i(NadRewardVideoActivity.c2(NadRewardVideoActivity.this).f.d);
        }
    }

    public final boolean B3() {
        String str;
        boolean z;
        if (!this.a0) {
            return false;
        }
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        cr0 g2 = lq0Var.g();
        do0 do0Var = this.Q;
        if (do0Var != null) {
            str = do0Var.e();
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
    public void E1() {
        super.E1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        zs0 zs0Var = this.I;
        if (zs0Var != null) {
            zs0Var.release();
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = lq0Var.e;
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
            f21.b(monitorUrl.clickUrl);
        }
    }

    public final void a3() {
        if (this.A == null) {
            this.A = new AdImageView(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = BadgeDrawable.TOP_END;
            layoutParams.topMargin = t41.c.a(this, 1.5f);
            layoutParams.setMarginEnd(t41.c.a(this, 5.0f));
            layoutParams.height = t41.c.a(this, 39.0f);
            layoutParams.width = t41.c.a(this, 39.0f);
            R2().addView(this.A, layoutParams);
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            int a2 = t41.c.a(adImageView.getContext(), 10.0f);
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
            lq0 lq0Var = this.P;
            if (lq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = lq0Var.g().s();
            lq0 lq0Var2 = this.P;
            if (lq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, lq0Var2.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$2
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

    public static final /* synthetic */ lq0 c2(NadRewardVideoActivity nadRewardVideoActivity) {
        lq0 lq0Var = nadRewardVideoActivity.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return lq0Var;
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
            x31.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
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
        if (z || !yi0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new pi0(str).a(), "rewardWebPanel");
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
            layoutParams.height = t41.c.c(this) - i2;
        } else {
            layoutParams.height = t41.c.a(this, 33.0f);
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var.g().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        lq0 lq0Var2 = this.P;
        if (lq0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog I2 = I2(this, lq0Var2.g().n(j2), false, 2, null);
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = lq0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.h2(str, str2);
        lq0 lq0Var2 = this.P;
        if (lq0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.w2(lq0Var2.g().k());
        nadRewardLottieDialog.f2(new d(str));
        nadRewardLottieDialog.k2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$2
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
        nadRewardLottieDialog.d2(new e(str));
        nadRewardLottieDialog.m2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$4
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        fr0 p2 = lq0Var.g().p();
        if (p2 == null || p2.f() == null || this.V) {
            return false;
        }
        c71 c71Var = this.E;
        if (c71Var != null && c71Var.isShowing()) {
            return false;
        }
        lq0 lq0Var2 = this.P;
        if (lq0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        fr0 p3 = lq0Var2.g().p();
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        fr0 p2 = lq0Var.g().p();
        if (p2 != null && p2.f() != null) {
            lq0 lq0Var2 = this.P;
            if (lq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final fr0 p3 = lq0Var2.g().p();
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
            lq0 lq0Var3 = this.P;
            if (lq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = lq0Var3.g().s();
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
                            fr0 fr0Var = p3;
                            if (fr0Var != null) {
                                str2 = fr0Var.b();
                            } else {
                                str2 = null;
                            }
                            so0.h(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void e3() {
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        k61 a2 = k61.a(lq0Var.j());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.H == null) {
                this.H = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((t41.c.e(this) * 9) / 16) / 2) + t41.c.a(this, 26.0f);
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        j61 a2 = j61.a(lq0Var.k());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.G == null) {
                this.G = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((t41.c.e(this) * 9) / 16) / 2) + t41.c.a(this, 52.0f);
                layoutParams.setMarginStart(t41.c.a(this, 9.0f));
                layoutParams.setMarginEnd(t41.c.a(this, 8.0f));
                R2().addView(this.G, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.G;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(t41.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        fr0 p2 = lq0Var.g().p();
        if (p2 != null && p2.f() != null) {
            lq0 lq0Var2 = this.P;
            if (lq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fr0 p3 = lq0Var2.g().p();
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
                lq0 lq0Var3 = this.P;
                if (lq0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, lq0Var3.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
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
        c71 c71Var = this.E;
        if (c71Var != null && c71Var.isShowing()) {
            return;
        }
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        uq0 c2 = lq0Var.c();
        if (c2 != null && c2.b()) {
            lq0 lq0Var2 = this.P;
            if (lq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            oq0 oq0Var = lq0Var2.j;
            if (oq0Var != null) {
                int i2 = oq0Var.c;
                lq0 lq0Var3 = this.P;
                if (lq0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == lq0Var3.g().s()) {
                    return;
                }
            }
        }
        this.b0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        go0 go0Var = this.D;
        if (go0Var != null) {
            go0Var.setVisibility(false);
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        so0.q(lq0Var);
        O2();
        lq0 lq0Var2 = this.P;
        if (lq0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ki0.c(lq0Var2.f.m, this);
        D3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void H1() {
        super.H1();
        AbsRewardCountDownView absRewardCountDownView = this.C;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.g();
        }
        zs0 zs0Var = this.I;
        if (zs0Var != null) {
            zs0Var.pause();
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
        int a2 = a51.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.U = a2;
        a51.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
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
            lq0 lq0Var = this.P;
            if (lq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(lq0Var);
        }
    }

    public final void d3() {
        int a2 = a51.a("nad_reward_sp", "key_session_count", 1);
        this.S = a2;
        a51.e("nad_reward_sp", "key_session_count", a2 + 1);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        lq0 lq0Var = this.P;
        if (lq0Var != null) {
            if (lq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            vq0 f2 = lq0Var.g().f();
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
                ki0.c(str, this);
            }
        }
        super.finish();
    }

    public final void h3() {
        boolean z;
        ImageView V2 = V2();
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var.d() != null) {
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
        ko0 b2 = lo0.b();
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        b2.a(lq0Var, new br0(this.S, this.T), new p());
    }

    public final void o3() {
        zs0 zs0Var = this.I;
        if (zs0Var != null) {
            zs0Var.pause();
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
        gm0.a().b(this, new q(nm0.class));
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
        c71 c71Var = this.E;
        if (c71Var == null || !c71Var.isShowing()) {
            go0 go0Var = this.D;
            if (go0Var != null && (view2 = go0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            zs0 zs0Var = this.I;
            if (zs0Var != null) {
                zs0Var.resume();
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
        float e2 = ((t41.c.e(this) / t41.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        oq0 oq0Var = lq0Var.j;
        if (oq0Var != null) {
            if (oq0Var.f > 0.0f) {
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = lq0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.h2(str, str2);
        co0 S1 = nadRewardVideoDialog.S1();
        boolean z4 = true;
        if (S1 != null) {
            if (z) {
                lq0 lq0Var2 = this.P;
                if (lq0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (lq0Var2.h().d()) {
                    z3 = true;
                    S1.M(z3);
                }
            }
            z3 = false;
            S1.M(z3);
        }
        co0 S12 = nadRewardVideoDialog.S1();
        if (S12 != null) {
            lq0 lq0Var3 = this.P;
            if (lq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            S12.L(lq0Var3.g().r());
        }
        co0 S13 = nadRewardVideoDialog.S1();
        if (S13 != null) {
            lq0 lq0Var4 = this.P;
            if (lq0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (lq0Var4.g().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                lq0 lq0Var5 = this.P;
                if (lq0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = lq0Var5.g().i();
            } else {
                lq0 lq0Var6 = this.P;
                if (lq0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                hr0 q2 = lq0Var6.g().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            S13.I(valueOf);
        }
        co0 S14 = nadRewardVideoDialog.S1();
        if (S14 != null) {
            lq0 lq0Var7 = this.P;
            if (lq0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (lq0Var7.d() == null) {
                z4 = false;
            }
            S14.H(z4);
        }
        nadRewardVideoDialog.f2(new a(str, z));
        nadRewardVideoDialog.k2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2
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
        nadRewardVideoDialog.d2(new b(str, z));
        nadRewardVideoDialog.g2(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4
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
                dq0 dq0Var;
                zp0 zp0Var;
                String str4;
                boolean z5;
                String str5;
                String str6;
                zp0 zp0Var2;
                zp0 zp0Var3;
                zp0 zp0Var4;
                zp0 zp0Var5;
                c71 c71Var;
                ViewGroup view2;
                boolean z6;
                boolean z7 = false;
                if (NadRewardVideoActivity.c2(this).l() && this.M2(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                    go0 go0Var = this.D;
                    if (go0Var != null && (view2 = go0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            uq0 c2 = NadRewardVideoActivity.c2(this).c();
                            if (c2 != null) {
                            }
                        }
                    }
                    c71Var = this.F;
                    if (c71Var == null || !c71Var.isShowing()) {
                        this.z3();
                    }
                }
                if (NadRewardVideoActivity.c2(this).m() && (dq0Var = NadRewardVideoActivity.c2(this).m) != null && (zp0Var = dq0Var.p) != null && zp0Var.e) {
                    dq0 dq0Var2 = NadRewardVideoActivity.c2(this).m;
                    String str7 = null;
                    if (dq0Var2 != null && (zp0Var5 = dq0Var2.p) != null) {
                        str4 = zp0Var5.b;
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && str4.length() != 0) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        dq0 dq0Var3 = NadRewardVideoActivity.c2(this).m;
                        if (dq0Var3 != null && (zp0Var4 = dq0Var3.p) != null) {
                            str5 = zp0Var4.a;
                        } else {
                            str5 = null;
                        }
                        if (!((str5 == null || str5.length() == 0) ? true : true)) {
                            dq0 dq0Var4 = NadRewardVideoActivity.c2(this).m;
                            if (dq0Var4 != null && (zp0Var3 = dq0Var4.p) != null) {
                                str6 = zp0Var3.a;
                            } else {
                                str6 = null;
                            }
                            if (j41.d(str6)) {
                                Context context = NadRewardVideoDialog.this.getContext();
                                if (context != null) {
                                    dq0 dq0Var5 = NadRewardVideoActivity.c2(this).m;
                                    if (dq0Var5 != null && (zp0Var2 = dq0Var5.p) != null) {
                                        str7 = zp0Var2.a;
                                    }
                                    Intrinsics.checkNotNull(str7);
                                    xi0.b(context, str7);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    ki0.b(j41.b(NadRewardVideoActivity.c2(this), NadRewardVideoActivity.c2(this).f()));
                }
            }
        });
        nadRewardVideoDialog.l2(new c(nadRewardVideoDialog, this, str, z));
        return nadRewardVideoDialog;
    }

    public final NadRewardSuspendDialog K2(final String str) {
        String str2;
        String str3;
        NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = lq0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.h2(str, str4);
        co0 S1 = nadRewardSuspendDialog.S1();
        String str5 = null;
        if (S1 != null) {
            lq0 lq0Var2 = this.P;
            if (lq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fr0 p2 = lq0Var2.g().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            S1.G(str3);
        }
        co0 S12 = nadRewardSuspendDialog.S1();
        if (S12 != null) {
            lq0 lq0Var3 = this.P;
            if (lq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fr0 p3 = lq0Var3.g().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            S12.K(str2);
        }
        co0 S13 = nadRewardSuspendDialog.S1();
        if (S13 != null) {
            lq0 lq0Var4 = this.P;
            if (lq0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fr0 p4 = lq0Var4.g().p();
            if (p4 != null) {
                str5 = p4.g();
            }
            S13.N(str5);
        }
        nadRewardSuspendDialog.f2(new f(str));
        nadRewardSuspendDialog.k2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$2
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
        nadRewardSuspendDialog.d2(new g(str));
        nadRewardSuspendDialog.n2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$4
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        lq0Var.h().h(this.U);
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var.b() == null) {
            this.O = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        lq0 lq0Var2 = this.P;
        if (lq0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(lq0Var2);
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
                zs0 zs0Var = NadRewardVideoActivity.this.I;
                if (zs0Var != null) {
                    zs0Var.pause();
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
                zs0 zs0Var = NadRewardVideoActivity.this.I;
                if (zs0Var != null) {
                    zs0Var.resume();
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
        layoutParams.bottomMargin = -t41.c.c(this);
        R2().addView(this.O, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.O;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.O;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        lq0 lq0Var3 = this.P;
        if (lq0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = lq0Var3.g().s();
        lq0 lq0Var4 = this.P;
        if (lq0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        tq0 b2 = lq0Var4.b();
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
        c71 c71Var;
        ViewGroup view2;
        boolean z;
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var.g().k() != null) {
            lq0 lq0Var2 = this.P;
            if (lq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (lq0Var2.g().m() != null) {
                lq0 lq0Var3 = this.P;
                if (lq0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                dr0 m2 = lq0Var3.g().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !gt.a(this) && !l3() && ((c71Var = this.E) == null || !c71Var.isShowing())) {
                    go0 go0Var = this.D;
                    if (go0Var != null && (view2 = go0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    lq0 lq0Var4 = this.P;
                    if (lq0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    cr0 g2 = lq0Var4.g();
                    lq0 lq0Var5 = this.P;
                    if (lq0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    xq0 k2 = lq0Var5.g().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    lq0 lq0Var6 = this.P;
                    if (lq0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    xq0 k3 = lq0Var6.g().k();
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var.e().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.E = null;
            return;
        }
        c71 c71Var = this.E;
        if (c71Var != null && c71Var.isShowing()) {
            return;
        }
        c71 c71Var2 = new c71(this);
        c71Var2.setOnDismissListener(new t());
        c71Var2.i(new u());
        double a2 = 1 - (t41.c.a(this, 41.0f) / t41.c.c(this));
        lq0 lq0Var2 = this.P;
        if (lq0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String e2 = lq0Var2.e();
        lq0 lq0Var3 = this.P;
        if (lq0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        j71 j71Var = new j71(e2, a2, 0, lq0Var3.f.d);
        j71Var.A(false);
        j71Var.C(true);
        j71Var.B(true);
        j71Var.y(true);
        lq0 lq0Var4 = this.P;
        if (lq0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!TextUtils.isEmpty(lq0Var4.f.m)) {
            lq0 lq0Var5 = this.P;
            if (lq0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            j71Var.v(lq0Var5.f.l);
        }
        Unit unit = Unit.INSTANCE;
        c71Var2.h(j71Var);
        c71Var2.j();
        Unit unit2 = Unit.INSTANCE;
        this.E = c71Var2;
        zs0 zs0Var = this.I;
        if (zs0Var != null) {
            zs0Var.pause();
        }
        AdImageView adImageView = this.A;
        if (adImageView != null) {
            ExtensionsKt.e(adImageView, false);
        }
        lq0 lq0Var6 = this.P;
        if (lq0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        lq0Var6.h().g(true);
    }

    public final void Z2() {
        ExpandIconView Q2 = Q2();
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        uq0 c2 = lq0Var.c();
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
            lq0 lq0Var = this.P;
            if (lq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return E3(lq0Var.g().c());
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
        qq0 qq0Var;
        qq0 qq0Var2;
        String str;
        qq0 qq0Var3;
        String str2;
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        oq0 oq0Var = lq0Var.j;
        NadRewardHalfTailHolder nadRewardHalfTailHolder = null;
        if (oq0Var != null) {
            qq0Var = oq0Var.i;
        } else {
            qq0Var = null;
        }
        if (qq0Var != null) {
            lq0 lq0Var2 = this.P;
            if (lq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            uq0 c2 = lq0Var2.c();
            if (c2 == null || c2.n()) {
                lq0 lq0Var3 = this.P;
                if (lq0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                oq0 oq0Var2 = lq0Var3.j;
                if (oq0Var2 != null && (qq0Var2 = oq0Var2.i) != null) {
                    lq0 lq0Var4 = this.P;
                    if (lq0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    oq0 oq0Var3 = lq0Var4.j;
                    if (oq0Var3 != null && (qq0Var3 = oq0Var3.i) != null && (str2 = qq0Var3.x) != null) {
                        do0 do0Var = this.Q;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (do0Var == null || (r4 = do0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    qq0Var2.x = str;
                }
                go0 go0Var = this.D;
                if (go0Var != null) {
                    go0Var.setVisibility(false);
                }
                go0.a aVar = go0.k0;
                lq0 lq0Var5 = this.P;
                if (lq0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                go0 a2 = aVar.a(lq0Var5, this);
                this.D = a2;
                if (a2 != null) {
                    lq0 lq0Var6 = this.P;
                    if (lq0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(lq0Var6);
                }
                go0 go0Var2 = this.D;
                if (!(go0Var2 instanceof View)) {
                    go0Var2 = null;
                }
                View view2 = (View) go0Var2;
                if (view2 != null) {
                    T2().removeAllViews();
                    T2().addView(view2);
                    T2().bringToFront();
                }
                go0 go0Var3 = this.D;
                if (go0Var3 != null) {
                    go0Var3.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
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
                            go0 go0Var4 = NadRewardVideoActivity.this.D;
                            if (go0Var4 != null) {
                                go0Var4.setVisibility(false);
                            }
                            zs0 zs0Var = NadRewardVideoActivity.this.I;
                            if (zs0Var != null) {
                                zs0Var.start();
                            }
                        }
                    });
                }
                go0 go0Var4 = this.D;
                if (go0Var4 instanceof NadRewardHalfTailHolder) {
                    nadRewardHalfTailHolder = go0Var4;
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
        go0 go0Var5 = this.D;
        if (go0Var5 != null) {
            go0Var5.setVisibility(false);
        }
    }

    public final void i3() {
        boolean z;
        int i2;
        cq0 cq0Var;
        int i3;
        qq0 qq0Var;
        NadRewardVideoAdOverContainer P2 = P2();
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var.d() == null) {
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
        lq0 lq0Var2 = this.P;
        if (lq0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var2.g().C()) {
            lq0 lq0Var3 = this.P;
            if (lq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = lq0Var3.f.c;
            Context context = P2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (k3(str, context)) {
                lq0 lq0Var4 = this.P;
                if (lq0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                dq0 dq0Var = lq0Var4.m;
                if (dq0Var != null) {
                    dq0Var.g = true;
                }
                lq0 lq0Var5 = this.P;
                if (lq0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                oq0 oq0Var = lq0Var5.j;
                if (oq0Var != null && (qq0Var = oq0Var.i) != null) {
                    qq0Var.C = true;
                }
            }
        }
        lq0 lq0Var6 = this.P;
        if (lq0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var6.d() != null) {
            lq0 lq0Var7 = this.P;
            if (lq0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            dq0 dq0Var2 = lq0Var7.m;
            if (dq0Var2 != null) {
                dq0Var2.e = true;
            }
            lq0 lq0Var8 = this.P;
            if (lq0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            dq0 dq0Var3 = lq0Var8.m;
            if (dq0Var3 != null) {
                lq0 lq0Var9 = this.P;
                if (lq0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (lq0Var9.m()) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                dq0Var3.a = i3;
            }
            lq0 lq0Var10 = this.P;
            if (lq0Var10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            dq0 dq0Var4 = lq0Var10.m;
            if (dq0Var4 != null) {
                lq0 lq0Var11 = this.P;
                if (lq0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                wq0 d2 = lq0Var11.d();
                Intrinsics.checkNotNull(d2);
                dq0Var4.p = d2.b();
            }
            lq0 lq0Var12 = this.P;
            if (lq0Var12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            dq0 dq0Var5 = lq0Var12.m;
            if (dq0Var5 != null && (cq0Var = dq0Var5.q) != null) {
                lq0 lq0Var13 = this.P;
                if (lq0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                cq0Var.d = lq0Var13.f.d;
            }
        }
        lq0 lq0Var14 = this.P;
        if (lq0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        P2.setData(lq0Var14);
        lq0 lq0Var15 = this.P;
        if (lq0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var15.l()) {
            P2.setBottomLineHeight(t41.c.a(P2.getContext(), 41.0f));
        } else {
            P2.setBottomLineHeight(t41.c.a(P2.getContext(), 10.0f));
        }
        P2.setOnUiClickListener(new k(P2, this));
        P2.setFeedbackBtnVisibility(false);
        P2.setFestivalClickCallback(new l(P2, this));
    }

    public final void j3() {
        boolean z;
        if (this.I == null) {
            at0 at0Var = new at0();
            at0Var.a = 2;
            zs0 b2 = zs0.a.b(this, 0, at0Var);
            this.I = b2;
            if (b2 != null) {
                b2.attachToContainer(W2());
            }
        }
        zs0 zs0Var = this.I;
        if (zs0Var != null) {
            zs0Var.d(new n());
            lq0 lq0Var = this.P;
            if (lq0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            oq0 oq0Var = lq0Var.j;
            if (oq0Var != null && oq0Var.g) {
                zs0Var.setVideoScalingMode(0);
            } else {
                zs0Var.setVideoScalingMode(2);
            }
            zs0Var.a(new m());
        }
        lq0 lq0Var2 = this.P;
        if (lq0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (lq0Var2.j == null) {
            W2().setVisibility(8);
            this.I = null;
            return;
        }
        zs0 zs0Var2 = this.I;
        if (zs0Var2 != null) {
            lq0 lq0Var3 = this.P;
            if (lq0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            oq0 oq0Var2 = lq0Var3.j;
            Intrinsics.checkNotNull(oq0Var2);
            zs0Var2.c(oq0Var2);
        }
        if (NetUtil.a(this)) {
            lq0 lq0Var4 = this.P;
            if (lq0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            uq0 c2 = lq0Var4.c();
            if (c2 != null) {
                z = c2.n();
            } else {
                z = false;
            }
            zs0 zs0Var3 = this.I;
            if (zs0Var3 != null) {
                zs0Var3.setLooping(!z);
            }
            zs0 zs0Var4 = this.I;
            if (zs0Var4 != null) {
                zs0Var4.start();
            }
        } else {
            x31.a().a(this, R.string.nad_reward_video_lp_no_network);
        }
        NadRewardInterceptFrameLayout W2 = W2();
        W2.setVisibility(0);
        lq0 lq0Var5 = this.P;
        if (lq0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        W2.setEnableIntercept(lq0Var5.l());
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
                so0.s(NadRewardVideoActivity.c2(NadRewardVideoActivity.this));
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
        lq0 lq0Var = this.P;
        if (lq0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        wq0 d2 = lq0Var.d();
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
            c71 c71Var = this.F;
            if (c71Var != null) {
                c71Var.e();
            }
            this.F = null;
            return;
        }
        c71 c71Var2 = this.F;
        if (c71Var2 != null) {
            c71Var2.e();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Handler handler = this.X;
        if (handler != null) {
            Runnable runnable = this.Z;
            lq0 lq0Var2 = this.P;
            if (lq0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            wq0 d3 = lq0Var2.d();
            if (d3 != null) {
                j2 = d3.a();
            } else {
                j2 = 0;
            }
            handler.postDelayed(runnable, j2);
        }
        c71 c71Var3 = new c71(this);
        lq0 lq0Var3 = this.P;
        if (lq0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        wq0 d4 = lq0Var3.d();
        if (d4 != null) {
            bool = Boolean.valueOf(d4.d());
        } else {
            bool = null;
        }
        c71Var3.i(new s(bool, this, currentTimeMillis));
        double a2 = 1 - (t41.c.a(this, 41.0f) / t41.c.c(this));
        lq0 lq0Var4 = this.P;
        if (lq0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        wq0 d5 = lq0Var4.d();
        if (d5 != null) {
            str2 = d5.c();
        }
        String str3 = str2;
        lq0 lq0Var5 = this.P;
        if (lq0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        j71 j71Var = new j71(str3, a2, 0, lq0Var5.f.d);
        j71Var.A(false);
        j71Var.C(true);
        j71Var.w(true);
        j71Var.x(true);
        Unit unit = Unit.INSTANCE;
        c71Var3.h(j71Var);
        c71Var3.j();
        Unit unit2 = Unit.INSTANCE;
        this.F = c71Var3;
    }

    public final boolean k3(String str, Context context) {
        Object m789constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new pi0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m789constructorimpl = Result.m789constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m789constructorimpl = Result.m789constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m795isFailureimpl(m789constructorimpl)) {
            m789constructorimpl = null;
        }
        String str3 = (String) m789constructorimpl;
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
        Object m789constructorimpl;
        qq0 qq0Var;
        String str;
        qq0 qq0Var2;
        Boolean bool;
        boolean z;
        String d2;
        String str2;
        String replace$default;
        String str3;
        String d3;
        qq0 qq0Var3;
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
            m789constructorimpl = Result.m789constructorimpl(ResultKt.createFailure(th));
        }
        if (serializable != null) {
            m789constructorimpl = Result.m789constructorimpl(ro0.a.d((HashMap) serializable));
            if (Result.m796isSuccessimpl(m789constructorimpl)) {
                lq0 lq0Var = (lq0) m789constructorimpl;
                this.P = lq0Var;
                if (lq0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                oq0 oq0Var = lq0Var.j;
                String str7 = "";
                if (oq0Var != null && (qq0Var3 = oq0Var.i) != null) {
                    lq0 lq0Var2 = this.P;
                    if (lq0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (lq0Var2.m()) {
                        String str8 = qq0Var3.f;
                        if (str8 != null) {
                            lq0 lq0Var3 = this.P;
                            if (lq0Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str8, "__CONVERT_CMD__", lq0Var3.f(), false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        qq0Var3.f = replace$default2;
                    } else {
                        String str9 = qq0Var3.f;
                        if (str9 != null) {
                            lq0 lq0Var4 = this.P;
                            if (lq0Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            dq0 dq0Var = lq0Var4.m;
                            if (dq0Var == null || (str5 = dq0Var.t) == null) {
                                str4 = "";
                            } else {
                                str4 = str5;
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str9, "__CONVERT_CMD__", str4, false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        qq0Var3.f = replace$default2;
                    }
                }
                lq0 lq0Var5 = this.P;
                if (lq0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                tq0 b2 = lq0Var5.b();
                if (b2 != null) {
                    lq0 lq0Var6 = this.P;
                    if (lq0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (lq0Var6.m()) {
                        lq0 lq0Var7 = this.P;
                        if (lq0Var7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        tq0 b3 = lq0Var7.b();
                        if (b3 != null && (d3 = b3.d()) != null) {
                            lq0 lq0Var8 = this.P;
                            if (lq0Var8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d3, "__CONVERT_CMD__", lq0Var8.f(), false, 4, (Object) null);
                        }
                        b2.h(str7);
                    } else {
                        lq0 lq0Var9 = this.P;
                        if (lq0Var9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        tq0 b4 = lq0Var9.b();
                        if (b4 != null && (d2 = b4.d()) != null) {
                            lq0 lq0Var10 = this.P;
                            if (lq0Var10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            dq0 dq0Var2 = lq0Var10.m;
                            if (dq0Var2 == null || (str3 = dq0Var2.t) == null) {
                                str2 = "";
                            } else {
                                str2 = str3;
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d2, "__CONVERT_CMD__", str2, false, 4, (Object) null);
                        }
                        b2.h(str7);
                    }
                }
                lq0 lq0Var11 = this.P;
                if (lq0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                dq0 dq0Var3 = lq0Var11.m;
                boolean z2 = true;
                if (dq0Var3 != null) {
                    dq0Var3.d = true;
                }
                lq0 lq0Var12 = this.P;
                if (lq0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                dq0 dq0Var4 = lq0Var12.m;
                if (dq0Var4 != null) {
                    lq0 lq0Var13 = this.P;
                    if (lq0Var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    uq0 c2 = lq0Var13.c();
                    if (c2 != null) {
                        z = c2.f();
                    } else {
                        z = false;
                    }
                    dq0Var4.f = z;
                }
                lq0 lq0Var14 = this.P;
                if (lq0Var14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                oq0 oq0Var2 = lq0Var14.j;
                if (oq0Var2 != null && (qq0Var2 = oq0Var2.i) != null) {
                    lq0 lq0Var15 = this.P;
                    if (lq0Var15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    uq0 c3 = lq0Var15.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.p());
                    } else {
                        bool = null;
                    }
                    qq0Var2.D = bool;
                }
                lq0 lq0Var16 = this.P;
                if (lq0Var16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                oq0 oq0Var3 = lq0Var16.j;
                if (oq0Var3 != null && (qq0Var = oq0Var3.i) != null) {
                    lq0 lq0Var17 = this.P;
                    if (lq0Var17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    uq0 c4 = lq0Var17.c();
                    if (c4 != null) {
                        str = c4.o();
                    } else {
                        str = null;
                    }
                    qq0Var.E = str;
                }
                yn0 yn0Var = (yn0) ServiceManager.getService(yn0.a);
                lq0 lq0Var18 = this.P;
                if (lq0Var18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (lq0Var18.g().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && yn0Var != null) {
                    lq0 lq0Var19 = this.P;
                    if (lq0Var19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    cr0 g2 = lq0Var19.g();
                    String a2 = yn0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    g2.F(a2);
                }
                lq0 lq0Var20 = this.P;
                if (lq0Var20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                dq0 dq0Var5 = lq0Var20.m;
                if (dq0Var5 != null) {
                    lq0 lq0Var21 = this.P;
                    if (lq0Var21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = lq0Var21.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    dq0Var5.h = list;
                }
                lq0 lq0Var22 = this.P;
                if (lq0Var22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                vq0 f2 = lq0Var22.g().f();
                if (f2 != null) {
                    str6 = f2.c();
                }
                this.a0 = Intrinsics.areEqual(str6, "0");
            }
            Throwable m792exceptionOrNullimpl = Result.m792exceptionOrNullimpl(m789constructorimpl);
            if (m792exceptionOrNullimpl != null && mg0.a) {
                x31.a().showToast(this, m792exceptionOrNullimpl.getMessage());
            }
            return Result.m796isSuccessimpl(m789constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final void p3(String str, String str2, HashMap<String, String> hashMap) {
        eo0 eo0Var = new eo0();
        eo0Var.a = str;
        eo0Var.b = hashMap;
        gm0.a().a(eo0Var);
    }
}
