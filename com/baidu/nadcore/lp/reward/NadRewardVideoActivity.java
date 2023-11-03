package com.baidu.nadcore.lp.reward;

import android.content.Context;
import android.content.Intent;
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
import com.baidu.tieba.al0;
import com.baidu.tieba.ao0;
import com.baidu.tieba.be0;
import com.baidu.tieba.bo0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.bz0;
import com.baidu.tieba.c21;
import com.baidu.tieba.do0;
import com.baidu.tieba.fd0;
import com.baidu.tieba.fn0;
import com.baidu.tieba.fo0;
import com.baidu.tieba.gn0;
import com.baidu.tieba.hl0;
import com.baidu.tieba.i11;
import com.baidu.tieba.il0;
import com.baidu.tieba.j41;
import com.baidu.tieba.jl0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.kk0;
import com.baidu.tieba.kl0;
import com.baidu.tieba.ll0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.n31;
import com.baidu.tieba.o31;
import com.baidu.tieba.ok0;
import com.baidu.tieba.on0;
import com.baidu.tieba.pc0;
import com.baidu.tieba.pe0;
import com.baidu.tieba.pk0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.rn0;
import com.baidu.tieba.ro;
import com.baidu.tieba.si0;
import com.baidu.tieba.sk0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.t11;
import com.baidu.tieba.tk0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.ue0;
import com.baidu.tieba.uk0;
import com.baidu.tieba.v01;
import com.baidu.tieba.v11;
import com.baidu.tieba.vm0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.wk0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.xp0;
import com.baidu.tieba.y81;
import com.baidu.tieba.yp0;
import com.baidu.tieba.zi0;
import com.baidu.tieba.zk0;
import com.baidu.tieba.zn0;
import com.baidu.tieba.zw0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\bÛ\u0001\u0010\u0013J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u0013J\u000f\u0010\u001d\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001e\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010\u0013J\u000f\u0010 \u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010\u0013J\u000f\u0010!\u001a\u00020\u0011H\u0002¢\u0006\u0004\b!\u0010\u0013J\u000f\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u0013J\u000f\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u0013J\u000f\u0010$\u001a\u00020\u0011H\u0002¢\u0006\u0004\b$\u0010\u0013J\u000f\u0010%\u001a\u00020\u0011H\u0002¢\u0006\u0004\b%\u0010\u0013J\u000f\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010\u0013J\u000f\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b'\u0010\u0013J\u000f\u0010(\u001a\u00020\u0011H\u0002¢\u0006\u0004\b(\u0010\u0013J\u000f\u0010)\u001a\u00020\u0011H\u0002¢\u0006\u0004\b)\u0010\u0013J\u000f\u0010*\u001a\u00020\u0011H\u0002¢\u0006\u0004\b*\u0010\u0013J\u000f\u0010+\u001a\u00020\u0011H\u0002¢\u0006\u0004\b+\u0010\u0013J\u000f\u0010,\u001a\u00020\u0011H\u0002¢\u0006\u0004\b,\u0010\u0013J\u000f\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010\u0013J!\u00101\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u00022\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0011H\u0016¢\u0006\u0004\b5\u0010\u0013J\u000f\u00106\u001a\u00020\u0011H\u0016¢\u0006\u0004\b6\u0010\u0013J\u0019\u00109\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000107H\u0014¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0011H\u0014¢\u0006\u0004\b;\u0010\u0013J\u0019\u0010>\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010<H\u0014¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0011H\u0014¢\u0006\u0004\b@\u0010\u0013J\u000f\u0010A\u001a\u00020\u0011H\u0014¢\u0006\u0004\bA\u0010\u0013J\u000f\u0010B\u001a\u00020\u0011H\u0002¢\u0006\u0004\bB\u0010\u0013J\u000f\u0010C\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u00104J\u000f\u0010D\u001a\u00020\u0011H\u0002¢\u0006\u0004\bD\u0010\u0013JC\u0010J\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00022\"\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020Gj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`HH\u0002¢\u0006\u0004\bJ\u0010KJ\u0019\u0010L\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u000107H\u0014¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0011H\u0002¢\u0006\u0004\bN\u0010\u0013J\u000f\u0010O\u001a\u00020\u0011H\u0002¢\u0006\u0004\bO\u0010\u0013J\u000f\u0010P\u001a\u00020\u0011H\u0002¢\u0006\u0004\bP\u0010\u0013J\u000f\u0010Q\u001a\u00020\u0011H\u0002¢\u0006\u0004\bQ\u0010\u0013J\u000f\u0010R\u001a\u00020\u0011H\u0002¢\u0006\u0004\bR\u0010\u0013J\u0017\u0010T\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\u0004H\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0011H\u0002¢\u0006\u0004\bV\u0010\u0013J\u000f\u0010W\u001a\u00020\u0004H\u0002¢\u0006\u0004\bW\u00104J\u000f\u0010X\u001a\u00020\u0011H\u0002¢\u0006\u0004\bX\u0010\u0013J\u000f\u0010Y\u001a\u00020\u0004H\u0002¢\u0006\u0004\bY\u00104J\u0017\u0010\\\u001a\u00020\u00042\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0004H\u0002¢\u0006\u0004\b^\u00104J\u000f\u0010_\u001a\u00020\u0004H\u0002¢\u0006\u0004\b_\u00104J\u000f\u0010`\u001a\u00020\u0011H\u0002¢\u0006\u0004\b`\u0010\u0013J\u0017\u0010b\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u0002H\u0002¢\u0006\u0004\bb\u0010\u0016J\u000f\u0010c\u001a\u00020\u0011H\u0002¢\u0006\u0004\bc\u0010\u0013J\u0017\u0010f\u001a\u00020\u00112\u0006\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\bf\u0010gR\u001d\u0010m\u001a\u00020h8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bo\u0010pR\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00020q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u001d\u0010x\u001a\u00020t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010j\u001a\u0004\bv\u0010wR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010}\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0017\u0010\u007f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010{R\u0019\u0010\u0082\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001R\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u0093\u0001\u001a\u00030\u008f\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0001\u0010j\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\"\u0010\u0098\u0001\u001a\u00030\u0094\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0095\u0001\u0010j\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u0080\u0001R\"\u0010¡\u0001\u001a\u00030\u009d\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009e\u0001\u0010j\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001b\u0010§\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001a\u0010ª\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001b\u0010¬\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010¨\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001a\u0010°\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010«\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u0019\u0010´\u0001\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010¶\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010«\u0001R\u0019\u0010·\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010\u0080\u0001R\u001a\u0010¹\u0001\u001a\u00030¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001b\u0010»\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010½\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u0080\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001c\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\"\u0010Ë\u0001\u001a\u00030Ç\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÈ\u0001\u0010j\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010¨\u0001R\"\u0010Ñ\u0001\u001a\u00030Í\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÎ\u0001\u0010j\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u001c\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001c\u0010Ö\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\"\u0010Ú\u0001\u001a\u00030Ç\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bØ\u0001\u0010j\u001a\u0006\bÙ\u0001\u0010Ê\u0001¨\u0006Ü\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/NadRewardVideoActivity;", "Lcom/baidu/nadcore/appframework/BaseActivity;", "", "dialogDataJson", "", "isTaskDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "buildDialog", "(Ljava/lang/String;Z)Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "rewardDataJson", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "buildLottieDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "suspendCmd", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "buildSuspendDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "", "chargeClick", "()V", "suspendDialogShowMoment", "checkShowSuspendMoment", "(Ljava/lang/String;)Z", "computeDailyRewardShownIndex", "finish", "getSessionInfo", "()Ljava/lang/String;", "init", "initBigCard", "initBottomArrow", "initCloseIcon", "initCountDownView", "initCriusView", "initFloatingLayer", "initImageStyle", "initPanelPop", "initRewardTask", "initRootView", "initSessionCountByTime", "initSvButton", "initSvTitle", "initTailFrame", "initTopTag", "initTopTagText", "initUserInfoContainer", "initVideoPlayer", "scheme", "Landroid/content/Context;", "context", "isAppInstalled", "(Ljava/lang/String;Landroid/content/Context;)Z", "isDialogShowing", "()Z", "onAttachedToWindow", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreateEx", "(Landroid/os/Bundle;)V", "onDestroyEx", "Landroid/content/Intent;", "intent", "onNewIntentEx", "(Landroid/content/Intent;)V", "onPauseEx", "onResumeEx", "onTaskComplete", "parseData", "pauseVideoPlayAndCountDown", "status", "message", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "postRewardVideoNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "preCreate", "(Landroid/os/Bundle;)Z", "recomputeCountDownSecond", "registerBackForegroundEvent", "resetStatus", "resumeVideoPlayAndCountDown", "setAppInfo", "playEnd", "setVideoContainerMask", "(Z)V", "showBigCard", "showDialog", "showImageStylePage", "showLottieDialog", "", "remainSecond", "showRetainDialog", "(J)Z", "showRewardDialog", "showSuspendDialog", "showSuspendDialogDelay", "cmd", "showTaskDialog", "triggerTask", "", "progress", "updateVideoSize", "(F)V", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer$delegate", "Lkotlin/Lazy;", "getAdInfoContainer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "", "appDownloadInfoArray", "[Ljava/lang/String;", "Lcom/baidu/nadcore/widget/uiwidget/SimpleAdInfoView;", "appInfoView$delegate", "getAppInfoView", "()Lcom/baidu/nadcore/widget/uiwidget/SimpleAdInfoView;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "arrowView", "Lcom/baidu/nadcore/widget/AdImageView;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCard", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCardShown", "Z", "closeIcon", "countDownFinished", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "countDownView", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Lcom/baidu/nadcore/lp/reward/ioc/INadRewardCriusPopContainer;", "criusViewContainer", "Lcom/baidu/nadcore/lp/reward/ioc/INadRewardCriusPopContainer;", "Landroid/widget/LinearLayout;", "criusViewGroup", "Landroid/widget/LinearLayout;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFestivalContainer;", "festivalContainer", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFestivalContainer;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "flRootView$delegate", "getFlRootView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "flRootView", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFloatingLayerView;", "floatingLayer$delegate", "getFloatingLayer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardFloatingLayerView;", "floatingLayer", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "hasMore", "Lcom/baidu/nadcore/lp/reward/view/NadRewardImageView;", "imageStyleView$delegate", "getImageStyleView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardImageView;", "imageStyleView", "lottieDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "retainDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "rewardCount", "I", "rewardDialog", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardResponse", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardShownIndex", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "rewardTaskHelper", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "screenHW", "F", "sessionCount", "shouldCharge", "Ljava/lang/Runnable;", "shouldChargeTask", "Ljava/lang/Runnable;", "suspendDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "suspendDialogShown", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "svButton", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "svTitle", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "tailFrame", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "Landroid/widget/FrameLayout;", "tailFrameContainer$delegate", "getTailFrameContainer", "()Landroid/widget/FrameLayout;", "tailFrameContainer", "taskDialog", "Landroid/view/View;", "topMask$delegate", "getTopMask", "()Landroid/view/View;", "topMask", "Landroid/widget/ImageView;", "topTag", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "topTagText", "Landroid/widget/TextView;", "videoContainer$delegate", "getVideoContainer", "videoContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardVideoActivity extends BaseActivity {
    public AdImageView B;
    public ImageView C;
    public AbsRewardCountDownView D;
    public tk0 E;
    public NadHighLightTextView G;
    public NadIconTextButton H;
    public xp0 I;
    public NadRewardVideoDialog J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardSuspendDialog M;
    public NadRewardLottieDialog N;
    public NadRewardBigCardView O;
    public gn0 Q;
    public pk0 R;
    public float S;

    /* renamed from: T  reason: collision with root package name */
    public int f1050T;
    public int U;
    public boolean W;
    public NadRewardTaskHelper X;
    public Handler Y;
    public boolean Z;
    public boolean b0;
    public boolean c0;
    public boolean d0;
    public TextView e0;
    public uk0 f0;
    public NadRewardFestivalContainer g0;
    public LinearLayout h0;
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
    public final Lazy F = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardImageView>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$imageStyleView$2
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
    public final Lazy P = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardFloatingLayerView>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$floatingLayer$2
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
    public int V = 1;
    public Runnable a0 = new u();

    public final NadRewardVideoAdOverContainer H2() {
        return (NadRewardVideoAdOverContainer) this.x.getValue();
    }

    public final SimpleAdInfoView I2() {
        return (SimpleAdInfoView) this.A.getValue();
    }

    public final NadRewardInterceptFrameLayout J2() {
        return (NadRewardInterceptFrameLayout) this.u.getValue();
    }

    public final NadRewardFloatingLayerView K2() {
        return (NadRewardFloatingLayerView) this.P.getValue();
    }

    public final NadRewardImageView L2() {
        return (NadRewardImageView) this.F.getValue();
    }

    public final FrameLayout N2() {
        return (FrameLayout) this.y.getValue();
    }

    public final View O2() {
        return (View) this.w.getValue();
    }

    public final FrameLayout P2() {
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
        public static final class a implements hl0.a {
            public a() {
            }

            @Override // com.baidu.tieba.hl0.a
            public void onFail(Exception exc) {
                kl0.k(NadRewardVideoActivity.O1(j.this.b).f.d, "4");
                Toast.makeText(j.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.hl0.a
            public void a(tn0 tn0Var) {
                String str;
                NadRewardVideoActivity.O1(j.this.b).g().E(tn0Var);
                String str2 = null;
                if (tn0Var != null) {
                    str = tn0Var.f();
                } else {
                    str = null;
                }
                if (TextUtils.equals(str, "1")) {
                    j.this.a.setFestivalEntranceContainerInvisible();
                    NadRewardVideoActivity nadRewardVideoActivity = j.this.b;
                    if (tn0Var != null) {
                        str2 = tn0Var.d();
                    }
                    Toast.makeText(nadRewardVideoActivity, str2, 0).show();
                    return;
                }
                j.this.b.y3();
                String str3 = NadRewardVideoActivity.O1(j.this.b).f.d;
                if (tn0Var != null) {
                    str2 = tn0Var.a();
                }
                kl0.l(str3, "4", str2);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            String str2 = null;
            if (NadRewardVideoActivity.O1(this.b).g().k() != null) {
                tn0 k = NadRewardVideoActivity.O1(this.b).g().k();
                if (k != null) {
                    str = k.f();
                } else {
                    str = null;
                }
                if (TextUtils.equals(str, "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    tn0 k2 = NadRewardVideoActivity.O1(nadRewardVideoActivity).g().k();
                    if (k2 != null) {
                        str2 = k2.d();
                    }
                    Toast.makeText(nadRewardVideoActivity, str2, 0).show();
                    return;
                }
                this.b.y3();
                return;
            }
            hl0 hl0Var = hl0.a;
            ao0 g = NadRewardVideoActivity.O1(this.b).g();
            bo0 m = NadRewardVideoActivity.O1(this.b).g().m();
            if (m != null) {
                str2 = m.b();
            }
            hl0Var.d(g, str2, new a());
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
        public static final class a implements hl0.a {
            public a() {
            }

            @Override // com.baidu.tieba.hl0.a
            public void onFail(Exception exc) {
                kl0.k(NadRewardVideoActivity.O1(o.this.b).f.d, "4");
                Toast.makeText(o.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.hl0.a
            public void a(tn0 tn0Var) {
                String str;
                NadRewardVideoActivity.O1(o.this.b).g().E(tn0Var);
                String str2 = null;
                if (tn0Var != null) {
                    str = tn0Var.f();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "1")) {
                    o.this.a.setFestivalEntranceContainerInvisible();
                    Toast.makeText(o.this.b, tn0Var.d(), 0).show();
                    return;
                }
                o.this.b.y3();
                String str3 = NadRewardVideoActivity.O1(o.this.b).f.d;
                if (tn0Var != null) {
                    str2 = tn0Var.a();
                }
                kl0.l(str3, "4", str2);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.O1(this.b).g().k() != null) {
                tn0 k = NadRewardVideoActivity.O1(this.b).g().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    tn0 k2 = NadRewardVideoActivity.O1(nadRewardVideoActivity).g().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.y3();
                return;
            }
            hl0 hl0Var = hl0.a;
            ao0 g = NadRewardVideoActivity.O1(this.b).g();
            bo0 m = NadRewardVideoActivity.O1(this.b).g().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            hl0Var.d(g, str, new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class t extends wi0<zi0> {

        /* loaded from: classes3.dex */
        public static final class a implements hl0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.hl0.a
            public void onFail(Exception exc) {
                kl0.k(NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.hl0.a
            public void a(tn0 tn0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.H2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (tn0Var != null) {
                    str = tn0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (tn0Var != null) {
                    str2 = tn0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d;
                    if (tn0Var != null) {
                        str3 = tn0Var.a();
                    }
                    kl0.l(str4, "5", str3);
                }
            }
        }

        public t(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wi0
        public void onEvent(zi0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.O1(NadRewardVideoActivity.this).i().b()) {
                hl0 hl0Var = hl0.a;
                ao0 g = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).g();
                tn0 k = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).g().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                hl0Var.d(g, str, new a());
                NadRewardVideoActivity.O1(NadRewardVideoActivity.this).i().e(false);
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
            NadRewardVideoActivity.this.E2();
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
            sm0 sm0Var;
            rn0 e = NadRewardVideoActivity.O1(this.b).e();
            if (e != null && e.e()) {
                rn0 e2 = NadRewardVideoActivity.O1(this.b).e();
                Intrinsics.checkNotNull(e2);
                sm0Var = e2.b();
            } else {
                wm0 wm0Var = NadRewardVideoActivity.O1(this.b).m;
                if (wm0Var != null) {
                    sm0Var = wm0Var.p;
                } else {
                    sm0Var = null;
                }
            }
            si0.a().b(new fd0(sm0Var));
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
            NadRewardVideoActivity.this.E2();
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
            NadRewardVideoActivity.this.E2();
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            il0 il0Var = il0.a;
            NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
            il0.e(il0Var, nadRewardVideoActivity, NadRewardVideoActivity.O1(nadRewardVideoActivity), null, 4, null);
            kl0.f(NadRewardVideoActivity.O1(NadRewardVideoActivity.this));
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
            if (v11.a()) {
                return;
            }
            String str2 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d;
            pk0 pk0Var = NadRewardVideoActivity.this.R;
            if (pk0Var != null) {
                str = pk0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            kl0.s(str2, !z);
            if (NadRewardVideoActivity.this.w3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements sk0 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public k() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends wi0<j41> {
        public l(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wi0
        public void onEvent(j41 event) {
            Intrinsics.checkNotNullParameter(event, "event");
            int i = event.a;
            if (i != 0) {
                if (i != 5) {
                    if (i == 8) {
                        NadRewardVideoActivity.this.onBackPressed();
                        return;
                    }
                    return;
                }
                xp0 xp0Var = NadRewardVideoActivity.this.I;
                if (xp0Var != null) {
                    xp0Var.resume();
                }
                AdImageView adImageView = NadRewardVideoActivity.this.B;
                if (adImageView != null) {
                    ExtensionsKt.f(adImageView, true);
                }
                TextView textView = NadRewardVideoActivity.this.e0;
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
                TextView textView2 = NadRewardVideoActivity.this.e0;
                if (textView2 != null) {
                    textView2.bringToFront();
                    return;
                }
                return;
            }
            NadRewardVideoActivity.O1(NadRewardVideoActivity.this).i().f(true);
            xp0 xp0Var2 = NadRewardVideoActivity.this.I;
            if (xp0Var2 != null) {
                xp0Var2.pause();
            }
            AdImageView adImageView3 = NadRewardVideoActivity.this.B;
            if (adImageView3 != null) {
                ExtensionsKt.f(adImageView3, false);
            }
            TextView textView3 = NadRewardVideoActivity.this.e0;
            if (textView3 != null) {
                ExtensionsKt.f(textView3, false);
            }
            NadRewardVideoActivity.this.K2().l();
        }
    }

    /* loaded from: classes3.dex */
    public static final class m implements View.OnClickListener {
        public final /* synthetic */ o31 b;

        public m(o31 o31Var) {
            this.b = o31Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            kl0.x(NadRewardVideoActivity.O1(NadRewardVideoActivity.this));
            pe0.c(il0.a.c(this.b.c, NadRewardVideoActivity.O1(NadRewardVideoActivity.this)), NadRewardVideoActivity.this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity.O1(NadRewardVideoActivity.this).i().d(true);
            NadRewardVideoActivity.this.E2();
            if (view2 instanceof NadRewardEnhanceButtonView) {
                pe0.c(NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.c, NadRewardVideoActivity.this);
                return;
            }
            il0 il0Var = il0.a;
            NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
            il0.e(il0Var, nadRewardVideoActivity, NadRewardVideoActivity.O1(nadRewardVideoActivity), null, 4, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class p extends bq0 {
        public p() {
        }

        @Override // com.baidu.tieba.bq0, com.baidu.tieba.up0
        public void onEnd(int i) {
            String str;
            ln0 ln0Var;
            String str2;
            ln0 ln0Var2;
            ln0 ln0Var3;
            ln0 ln0Var4;
            String str3;
            Long l = null;
            if (NadRewardVideoActivity.O1(NadRewardVideoActivity.this).b() != null) {
                pn0 c = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).c();
                if (c != null && c.b()) {
                    on0 b = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).b();
                    if (b != null) {
                        str3 = b.d();
                    } else {
                        str3 = null;
                    }
                    pn0 c2 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).c();
                    if (c2 != null) {
                        l = Long.valueOf(c2.c());
                    }
                    pe0.c(i11.c(str3, l, NadRewardVideoActivity.O1(NadRewardVideoActivity.this).e), NadRewardVideoActivity.this);
                }
                NadRewardVideoActivity.this.u3(true);
                NadRewardVideoActivity.this.v3();
            } else {
                if (!NadRewardVideoActivity.this.b0) {
                    jn0 jn0Var = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).j;
                    if (jn0Var != null && (ln0Var4 = jn0Var.i) != null) {
                        ln0Var4.y = null;
                    }
                    jn0 jn0Var2 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).j;
                    if (jn0Var2 != null && (ln0Var3 = jn0Var2.i) != null) {
                        ln0Var3.x = null;
                    }
                    jn0 jn0Var3 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).j;
                    if (jn0Var3 != null && (ln0Var2 = jn0Var3.i) != null) {
                        ln0Var2.z = null;
                    }
                }
                tk0 tk0Var = NadRewardVideoActivity.this.E;
                if (tk0Var != null) {
                    tk0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView = NadRewardVideoActivity.this.O;
                if (nadRewardBigCardView != null) {
                    nadRewardBigCardView.setVisibility(false);
                }
                NadRewardVideoActivity.this.N2().bringToFront();
                NadRewardVideoActivity.O1(NadRewardVideoActivity.this).i().h(true);
                String str4 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d;
                String str5 = "0";
                if (!NadRewardVideoActivity.this.b0) {
                    str = "0";
                } else {
                    str = "1";
                }
                jn0 jn0Var4 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).j;
                if (jn0Var4 != null && (ln0Var = jn0Var4.i) != null && (str2 = ln0Var.a) != null) {
                    str5 = str2;
                }
                kl0.A(str4, str, str5);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.B;
            if (adImageView != null) {
                adImageView.bringToFront();
            }
            TextView textView = NadRewardVideoActivity.this.e0;
            if (textView != null) {
                textView.bringToFront();
            }
            NadRewardVideoActivity.this.K2().l();
        }

        @Override // com.baidu.tieba.bq0, com.baidu.tieba.up0
        public void onStart() {
            NadRewardVideoActivity.this.u3(false);
            tk0 tk0Var = NadRewardVideoActivity.this.E;
            if (tk0Var != null) {
                tk0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }

        @Override // com.baidu.tieba.bq0, com.baidu.tieba.up0
        public void onUpdateProgress(int i, int i2, int i3) {
            NadRewardVideoActivity.this.K2().j(i);
        }
    }

    /* loaded from: classes3.dex */
    public static final class q extends zw0 {
        @Override // com.baidu.tieba.zw0, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (al0.b().a()) {
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
            if (NadRewardVideoActivity.this.J2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                nadRewardVideoActivity.S = nadRewardVideoActivity.J2().getMeasuredHeight() / NadRewardVideoActivity.this.J2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class s implements zk0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public s() {
        }

        @Override // com.baidu.tieba.zk0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.R = null;
            NadRewardVideoActivity.this.b0 = false;
        }

        @Override // com.baidu.tieba.zk0.b
        public void a(pk0 pk0Var) {
            boolean z;
            View view2;
            AdDownloadStatus adDownloadStatus;
            boolean z2;
            NadRewardVideoActivity.this.R = pk0Var;
            if (pk0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.U++;
            int i = 0;
            if (pk0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.d(NadRewardVideoActivity.O1(NadRewardVideoActivity.this).g().b(pk0Var.d()));
                }
                kl0.d(NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d, pk0Var.d(), NadRewardVideoActivity.this.M2(), pk0Var.f(), pk0Var.h());
                if (pk0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    kl0.B(NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d, "2", pk0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(pk0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                }
                if (i <= 0) {
                    kl0.p(NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            kl0.g(NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d, "1", pk0Var.d(), NadRewardVideoActivity.this.M2());
            NadRewardVideoActivity.this.b0 = !pk0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.O1(NadRewardVideoActivity.this).g().t());
            NadRewardVideoActivity.this.o3("0", "任务完成回调", hashMap);
            y81<View> transitionButtonView = NadRewardVideoActivity.this.H2().getTransitionButtonView();
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
            NadRewardTaskHelper nadRewardTaskHelper = NadRewardVideoActivity.this.X;
            if (nadRewardTaskHelper != null) {
                String str = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d;
                Intrinsics.checkNotNullExpressionValue(str, "adModel.common.extraParam");
                nadRewardTaskHelper.t(pk0Var, adDownloadStatus, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardVideoActivity.this.Z = true;
        }
    }

    public final boolean B3() {
        JSONObject jSONObject;
        String f2;
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        do0 p2 = gn0Var.g().p();
        if (p2 == null || p2.f() == null || this.W || ll0.e.b()) {
            return false;
        }
        gn0 gn0Var2 = this.Q;
        if (gn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        do0 p3 = gn0Var2.g().p();
        if (p3 != null && (f2 = p3.f()) != null) {
            jSONObject = ExtensionsKt.a(f2);
        } else {
            jSONObject = null;
        }
        NadRewardSuspendDialog D2 = D2(String.valueOf(jSONObject));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        D2.show(supportFragmentManager, (String) null);
        this.W = true;
        this.M = D2;
        n3();
        return true;
    }

    public final void C3() {
        String str;
        String c2;
        Integer intOrNull;
        int i2 = 0;
        this.W = false;
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        do0 p2 = gn0Var.g().p();
        if (p2 != null && p2.f() != null) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final do0 p3 = gn0Var2.g().p();
            if (p3 != null) {
                str = p3.b();
            } else {
                str = null;
            }
            if (!F2(str)) {
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
            gn0 gn0Var3 = this.Q;
            if (gn0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = gn0Var3.g().s();
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
                        boolean B3;
                        String str2;
                        B3 = NadRewardVideoActivity.this.B3();
                        if (B3) {
                            String str3 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.d;
                            String valueOf = String.valueOf(NadRewardVideoActivity.O1(NadRewardVideoActivity.this).i().c());
                            do0 do0Var = p3;
                            if (do0Var != null) {
                                str2 = do0Var.b();
                            } else {
                                str2 = null;
                            }
                            kl0.i(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void U2() {
        if (this.D == null) {
            wk0 a2 = al0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            View inflate = LayoutInflater.from(this).inflate(a2.e(), (ViewGroup) J2(), true);
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
            gn0 gn0Var = this.Q;
            if (gn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = gn0Var.g().s();
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, gn0Var2.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$1
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
                    pn0 c2;
                    Long l2;
                    NadRewardVideoActivity.this.d0 = true;
                    NadRewardVideoActivity.this.l3();
                    Long l3 = null;
                    if (NadRewardVideoActivity.O1(NadRewardVideoActivity.this).q() && (c2 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).c()) != null && c2.l()) {
                        String f2 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f();
                        pn0 c3 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).c();
                        if (c3 != null) {
                            l2 = Long.valueOf(c3.m());
                        } else {
                            l2 = null;
                        }
                        pe0.c(i11.c(f2, l2, NadRewardVideoActivity.O1(NadRewardVideoActivity.this).e), NadRewardVideoActivity.this);
                        kl0.z(NadRewardVideoActivity.O1(NadRewardVideoActivity.this));
                    }
                    pn0 c4 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).c();
                    if (c4 != null && c4.h()) {
                        String str = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).f.c;
                        pn0 c5 = NadRewardVideoActivity.O1(NadRewardVideoActivity.this).c();
                        if (c5 != null) {
                            l3 = Long.valueOf(c5.i());
                        }
                        pe0.c(i11.e(str, l3, NadRewardVideoActivity.O1(NadRewardVideoActivity.this).e), NadRewardVideoActivity.this);
                        kl0.o(NadRewardVideoActivity.O1(NadRewardVideoActivity.this));
                    }
                }
            });
        }
    }

    public final void c3() {
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        o31 a2 = o31.a(gn0Var.k());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.H == null) {
                this.H = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((t11.c.e(this) * 9) / 16) / 2) + t11.c.a(this, 26.0f);
                J2().addView(this.H, layoutParams);
            }
            NadIconTextButton nadIconTextButton = this.H;
            if (nadIconTextButton != null) {
                nadIconTextButton.e(a2);
                nadIconTextButton.setOnClickListener(new m(a2));
                nadIconTextButton.setVisibility(0);
                return;
            }
            return;
        }
        NadIconTextButton nadIconTextButton2 = this.H;
        if (nadIconTextButton2 != null) {
            ExtensionsKt.f(nadIconTextButton2, false);
        }
    }

    public final void d3() {
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        n31 a2 = n31.a(gn0Var.l());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.G == null) {
                this.G = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((t11.c.e(this) * 9) / 16) / 2) + t11.c.a(this, 52.0f);
                layoutParams.setMarginStart(t11.c.a(this, 9.0f));
                layoutParams.setMarginEnd(t11.c.a(this, 8.0f));
                J2().addView(this.G, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.G;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(t11.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
                nadHighLightTextView.setAlpha(0.8f);
                nadHighLightTextView.setGravity(17);
                nadHighLightTextView.e(a2);
                nadHighLightTextView.setVisibility(0);
                return;
            }
            return;
        }
        NadHighLightTextView nadHighLightTextView2 = this.G;
        if (nadHighLightTextView2 != null) {
            ExtensionsKt.f(nadHighLightTextView2, false);
        }
    }

    public final void p3() {
        long j2;
        int i2;
        String d2;
        Integer intOrNull;
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        do0 p2 = gn0Var.g().p();
        if (p2 != null && p2.f() != null) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            do0 p3 = gn0Var2.g().p();
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
                gn0 gn0Var3 = this.Q;
                if (gn0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, gn0Var3.g(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
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
                        NadRewardVideoActivity.this.d0 = true;
                        NadRewardVideoActivity.this.l3();
                    }
                });
            }
        }
    }

    public final void v3() {
        if (this.c0 || ll0.e.b()) {
            return;
        }
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        pn0 c2 = gn0Var.c();
        if (c2 != null && c2.b()) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            jn0 jn0Var = gn0Var2.j;
            if (jn0Var != null) {
                int i2 = jn0Var.c;
                gn0 gn0Var3 = this.Q;
                if (gn0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == gn0Var3.g().s()) {
                    return;
                }
            }
        }
        this.c0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        NadRewardBigCardView nadRewardBigCardView2 = this.O;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.bringToFront();
        }
        tk0 tk0Var = this.E;
        if (tk0Var != null) {
            tk0Var.setVisibility(false);
        }
        NadHighLightTextView nadHighLightTextView = this.G;
        if (nadHighLightTextView != null) {
            ExtensionsKt.f(nadHighLightTextView, false);
        }
        NadIconTextButton nadIconTextButton = this.H;
        if (nadIconTextButton != null) {
            ExtensionsKt.f(nadIconTextButton, false);
        }
        K2().l();
        H2().setFestivalEntranceContainerInvisible();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void w1() {
        super.w1();
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.c();
        }
        xp0 xp0Var = this.I;
        if (xp0Var != null) {
            xp0Var.release();
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
        H2().C();
        NadRewardTaskHelper nadRewardTaskHelper = this.X;
        if (nadRewardTaskHelper != null) {
            nadRewardTaskHelper.F();
        }
        Handler handler = this.Y;
        if (handler != null) {
            handler.removeCallbacks(this.a0);
        }
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.p();
        }
        K2().l();
        uk0 uk0Var = this.f0;
        if (uk0Var != null) {
            uk0Var.release();
        }
        NadRewardFestivalContainer nadRewardFestivalContainer = this.g0;
        if (nadRewardFestivalContainer != null) {
            nadRewardFestivalContainer.f();
        }
        si0.a().a(this);
        ll0.e.a();
    }

    public static /* synthetic */ NadRewardVideoDialog B2(NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nadRewardVideoActivity.A2(str, z);
    }

    public static final /* synthetic */ gn0 O1(NadRewardVideoActivity nadRewardVideoActivity) {
        gn0 gn0Var = nadRewardVideoActivity.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return gn0Var;
    }

    public final boolean D3(String str) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        NadRewardVideoDialog A2 = A2(str, true);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        A2.show(supportFragmentManager, (String) null);
        this.J = A2;
        n3();
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean G1(Bundle bundle) {
        if (!super.G1(bundle)) {
            return false;
        }
        getWindow().setSoftInputMode(19);
        getWindow().setFormat(-3);
        requestWindowFeature(1);
        setEnableSliding(false);
        setCurrentActivityNoTransparent();
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void u1(Bundle bundle) {
        super.u1(bundle);
        setContentView(R.layout.nad_reward_video_lp_activity);
        J2().post(new r());
        this.Y = new Handler(Looper.getMainLooper());
        if (!m3()) {
            finish();
            return;
        }
        b3();
        Q2();
    }

    public final void u3(boolean z) {
        int i2;
        ViewGroup.LayoutParams layoutParams = O2().getLayoutParams();
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            i2 = nadRewardBigCardView.getHeight();
        } else {
            i2 = 0;
        }
        if (z) {
            layoutParams.height = t11.c.c(this) - i2;
        } else {
            layoutParams.height = t11.c.a(this, 33.0f);
        }
        O2().setLayoutParams(layoutParams);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void x1(Intent intent) {
        super.x1(intent);
        setIntent(intent);
        if (!m3()) {
            v01.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
            return;
        }
        Q2();
        x3();
    }

    public final NadRewardVideoDialog A2(final String str, final boolean z) {
        boolean z2;
        Integer num;
        String valueOf;
        boolean z3;
        final NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = gn0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.T2(str, str2);
        ok0 E2 = nadRewardVideoDialog.E2();
        boolean z4 = false;
        if (E2 != null) {
            if (z && !this.b0) {
                z3 = true;
            } else {
                z3 = false;
            }
            E2.L(z3);
        }
        ok0 E22 = nadRewardVideoDialog.E2();
        if (E22 != null) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            E22.K(gn0Var2.g().r());
        }
        ok0 E23 = nadRewardVideoDialog.E2();
        if (E23 != null) {
            gn0 gn0Var3 = this.Q;
            if (gn0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (gn0Var3.g().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                gn0 gn0Var4 = this.Q;
                if (gn0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = gn0Var4.g().i();
            } else {
                gn0 gn0Var5 = this.Q;
                if (gn0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fo0 q2 = gn0Var5.g().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            E23.G(valueOf);
        }
        ok0 E24 = nadRewardVideoDialog.E2();
        if (E24 != null) {
            gn0 gn0Var6 = this.Q;
            if (gn0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            rn0 e2 = gn0Var6.e();
            if (e2 != null && e2.e()) {
                z4 = true;
            }
            E24.I(z4);
        }
        nadRewardVideoDialog.R2(new a(str, z));
        nadRewardVideoDialog.W2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.s3();
            }
        });
        nadRewardVideoDialog.P2(new b(str, z));
        nadRewardVideoDialog.S2(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4
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
                il0 il0Var = il0.a;
                NadRewardVideoActivity nadRewardVideoActivity = this;
                il0Var.d(nadRewardVideoActivity, NadRewardVideoActivity.O1(nadRewardVideoActivity), str3);
                if (il0.a.b(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                }
            }
        });
        nadRewardVideoDialog.X2(new c(nadRewardVideoDialog, this, str, z));
        return nadRewardVideoDialog;
    }

    public final boolean A3() {
        String str;
        boolean z;
        if (!this.b0) {
            return false;
        }
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ao0 g2 = gn0Var.g();
        pk0 pk0Var = this.R;
        if (pk0Var != null) {
            str = pk0Var.e();
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
        NadRewardVideoDialog B2 = B2(this, l2, false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        B2.show(supportFragmentManager, (String) null);
        this.L = B2;
        n3();
        return true;
    }

    public final void E2() {
        boolean z;
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = gn0Var.e;
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
            bz0.b(monitorUrl.clickUrl);
        }
    }

    public final void T2() {
        if (this.B == null) {
            wk0 a2 = al0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            View inflate = LayoutInflater.from(this).inflate(a2.r(), (ViewGroup) J2(), true);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…youtId, flRootView, true)");
            this.B = (AdImageView) inflate.findViewById(R.id.reward_close_icon);
        }
        AdImageView adImageView = this.B;
        if (adImageView != null) {
            int a3 = t11.c.a(adImageView.getContext(), 10.0f);
            adImageView.setPadding(a3, a3, a3, a3);
            adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            adImageView.setOnClickListener(new i());
        }
    }

    public final void f3() {
        boolean z = true;
        if (this.C == null) {
            wk0 a2 = al0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            this.C = (ImageView) LayoutInflater.from(this).inflate(a2.a(), (ViewGroup) J2(), true).findViewById(R.id.top_tag);
        }
        ImageView imageView = this.C;
        if (imageView != null) {
            gn0 gn0Var = this.Q;
            if (gn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            rn0 e2 = gn0Var.e();
            if ((e2 == null || !e2.e()) ? false : false) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public final void x3() {
        Long l2;
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        rn0 e2 = gn0Var.e();
        if (e2 != null && e2.e()) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String n2 = gn0Var2.n();
            gn0 gn0Var3 = this.Q;
            if (gn0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            rn0 e3 = gn0Var3.e();
            if (e3 != null) {
                l2 = Long.valueOf(e3.a());
            } else {
                l2 = null;
            }
            gn0 gn0Var4 = this.Q;
            if (gn0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            pe0.c(i11.c(n2, l2, gn0Var4.e), this);
        }
    }

    public final NadRewardLottieDialog C2(final String str) {
        q3();
        NadRewardLottieDialog nadRewardLottieDialog = new NadRewardLottieDialog();
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = gn0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.T2(str, str2);
        gn0 gn0Var2 = this.Q;
        if (gn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.i3(gn0Var2.g().k());
        nadRewardLottieDialog.R2(new d(str));
        nadRewardLottieDialog.W2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.s3();
            }
        });
        nadRewardLottieDialog.P2(new e(str));
        nadRewardLottieDialog.Y2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.O1(NadRewardVideoActivity.this).i().e(true);
            }
        });
        return nadRewardLottieDialog;
    }

    public final boolean z3(long j2) {
        boolean z;
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (gn0Var.g().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        gn0 gn0Var2 = this.Q;
        if (gn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog B2 = B2(this, gn0Var2.g().n(j2), false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        B2.show(supportFragmentManager, (String) null);
        this.K = B2;
        n3();
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1() {
        super.D1();
        if (k3()) {
            return;
        }
        s3();
    }

    public final void E3() {
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        kl0.v(gn0Var, M2());
        G2();
        gn0 gn0Var2 = this.Q;
        if (gn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        pe0.c(gn0Var2.f.k, this);
        C3();
    }

    public final void G2() {
        int a2 = c21.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.V = a2;
        c21.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.T int), ('_' char), (wrap: int : 0x000f: IGET  (r1v2 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.U int)] */
    public final String M2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1050T);
        sb.append('_');
        sb.append(this.U);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…d(rewardCount).toString()");
        return sb2;
    }

    public final void W2() {
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (gn0Var.d() == null) {
            return;
        }
        NadRewardFloatingLayerView K2 = K2();
        gn0 gn0Var2 = this.Q;
        if (gn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        K2.setData(gn0Var2);
        K2.setTriggerCallback(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initFloatingLayer$$inlined$apply$lambda$1
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
                if (NadRewardVideoActivity.O1(NadRewardVideoActivity.this).p()) {
                    cmd = il0.a.c(cmd, NadRewardVideoActivity.O1(NadRewardVideoActivity.this));
                }
                il0 il0Var = il0.a;
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                il0Var.d(nadRewardVideoActivity, NadRewardVideoActivity.O1(nadRewardVideoActivity), cmd);
            }
        });
        K2.setVisibility(0);
    }

    public final void Y2() {
        ll0.e.a();
        si0.a().c(this, new l(j41.class));
    }

    public final void Z2() {
        if (this.X == null) {
            this.X = new NadRewardTaskHelper();
        }
        NadRewardTaskHelper nadRewardTaskHelper = this.X;
        if (nadRewardTaskHelper != null) {
            gn0 gn0Var = this.Q;
            if (gn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(gn0Var);
        }
    }

    public final void a3() {
        NadRewardInterceptFrameLayout J2 = J2();
        boolean z = true;
        J2.setClickable(true);
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!gn0Var.o()) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (!gn0Var2.q()) {
                z = false;
            }
        }
        J2.setEnableIntercept(z);
        J2.setInterceptCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initRootView$$inlined$apply$lambda$1
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
                il0 il0Var = il0.a;
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                il0.e(il0Var, nadRewardVideoActivity, NadRewardVideoActivity.O1(nadRewardVideoActivity), null, 4, null);
                kl0.y(NadRewardVideoActivity.O1(NadRewardVideoActivity.this));
            }
        });
    }

    public final void b3() {
        int a2 = c21.a("nad_reward_sp", "key_session_count", 1);
        this.f1050T = a2;
        c21.e("nad_reward_sp", "key_session_count", a2 + 1);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        gn0 gn0Var = this.Q;
        if (gn0Var != null) {
            if (gn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            qn0 f2 = gn0Var.g().f();
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
                pe0.c(str, this);
            }
        }
        super.finish();
    }

    public final void l3() {
        zk0 c2 = al0.c();
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        c2.a(gn0Var, new zn0(this.f1050T, this.U), new s());
    }

    public final void n3() {
        xp0 xp0Var = this.I;
        if (xp0Var != null) {
            xp0Var.pause();
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (v11.a() || w3()) {
            return;
        }
        try {
            super.onBackPressed();
        } catch (Exception unused) {
        }
    }

    public final void q3() {
        si0.a().c(this, new t(zi0.class));
    }

    public final void r3() {
        this.d0 = false;
        this.c0 = false;
        this.R = null;
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.c();
        }
        H2().C();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (r0 != true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s3() {
        ViewGroup view2;
        boolean z;
        if (!ll0.e.b()) {
            tk0 tk0Var = this.E;
            if (tk0Var != null && (view2 = tk0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            xp0 xp0Var = this.I;
            if (xp0Var != null) {
                xp0Var.resume();
            }
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.b();
        }
    }

    public final void t3() {
        SimpleAdInfoView I2 = I2();
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (be0.a(gn0Var.i)) {
            I2.setVisibility(0);
        } else {
            I2.setVisibility(8);
        }
        gn0 gn0Var2 = this.Q;
        if (gn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        I2.setAdInfo(gn0Var2.i);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void y1() {
        super.y1();
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        xp0 xp0Var = this.I;
        if (xp0Var != null) {
            xp0Var.pause();
        }
    }

    public final NadRewardSuspendDialog D2(final String str) {
        String str2;
        String str3;
        NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = gn0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.T2(str, str4);
        ok0 E2 = nadRewardSuspendDialog.E2();
        String str5 = null;
        if (E2 != null) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            do0 p2 = gn0Var2.g().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            E2.F(str3);
        }
        ok0 E22 = nadRewardSuspendDialog.E2();
        if (E22 != null) {
            gn0 gn0Var3 = this.Q;
            if (gn0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            do0 p3 = gn0Var3.g().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            E22.J(str2);
        }
        ok0 E23 = nadRewardSuspendDialog.E2();
        if (E23 != null) {
            gn0 gn0Var4 = this.Q;
            if (gn0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            do0 p4 = gn0Var4.g().p();
            if (p4 != null) {
                str5 = p4.g();
            }
            E23.M(str5);
        }
        nadRewardSuspendDialog.R2(new f(str));
        nadRewardSuspendDialog.W2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.s3();
            }
        });
        nadRewardSuspendDialog.P2(new g(str));
        nadRewardSuspendDialog.Z2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.this.p3();
            }
        });
        return nadRewardSuspendDialog;
    }

    public final boolean F2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null).contains(String.valueOf(this.V))) {
            return false;
        }
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        gn0Var.i().g(this.V);
        return true;
    }

    public final void F3(float f2) {
        float f3;
        boolean z;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        if (nadRewardBigCardView != null) {
            f3 = nadRewardBigCardView.getHeight();
        } else {
            f3 = 0.0f;
        }
        float e2 = ((t11.c.e(this) / t11.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        jn0 jn0Var = gn0Var.j;
        if (jn0Var != null) {
            if (jn0Var.f > 0.0f) {
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
        P2().setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        layoutParams2.bottomMargin = (int) ((f2 - 1) * f3);
        NadRewardBigCardView nadRewardBigCardView2 = this.O;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.setLayoutParams(layoutParams2);
        }
    }

    public final void Q2() {
        r3();
        a3();
        f3();
        S2();
        U2();
        i3();
        h3();
        T2();
        d3();
        c3();
        e3();
        R2();
        X2();
        W2();
        Y2();
        Z2();
        E3();
        g3();
        V2();
    }

    public final void X2() {
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (gn0Var.q()) {
            L2().setVisibility(0);
            NadRewardImageView L2 = L2();
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            L2.setData(gn0Var2);
            L2().setClickCallBack(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initImageStyle$1
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
                    il0 il0Var = il0.a;
                    NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                    il0.e(il0Var, nadRewardVideoActivity, NadRewardVideoActivity.O1(nadRewardVideoActivity), null, 4, null);
                }
            });
            t3();
            return;
        }
        L2().setVisibility(8);
        I2().setVisibility(8);
    }

    public final boolean k3() {
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
        K2().l();
        NadRewardTaskHelper nadRewardTaskHelper = this.X;
        if (nadRewardTaskHelper != null && nadRewardTaskHelper.A()) {
            gn0 gn0Var = this.Q;
            if (gn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return D3(gn0Var.g().c());
        } else if (this.d0) {
            return A3();
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            AbsRewardCountDownView absRewardCountDownView = this.D;
            if (absRewardCountDownView != null) {
                return z3(timeUnit.toSeconds(absRewardCountDownView.getMillisUntilFinished()));
            }
            return false;
        }
    }

    public final void R2() {
        String f2;
        Integer intOrNull;
        NadRewardBigCardView nadRewardBigCardView = this.O;
        int i2 = 0;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(false);
        }
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (gn0Var.b() == null) {
            this.O = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        gn0 gn0Var2 = this.Q;
        if (gn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(gn0Var2);
        nadRewardBigCardView2.setBigCardShowProgress(new Function1<Float, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initBigCard$$inlined$apply$lambda$1
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
                NadRewardVideoActivity.this.F3(f3);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.O = nadRewardBigCardView2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = -t11.c.c(this);
        J2().addView(this.O, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.O;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.O;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        gn0 gn0Var3 = this.Q;
        if (gn0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = gn0Var3.g().s();
        gn0 gn0Var4 = this.Q;
        if (gn0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        on0 b2 = gn0Var4.b();
        if (b2 != null && (f2 = b2.f()) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(f2)) != null) {
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
                    NadRewardVideoActivity.this.v3();
                }
            });
        }
    }

    public final void S2() {
        int a2;
        wk0 a3 = al0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        boolean z = true;
        View inflate = LayoutInflater.from(this).inflate(a3.v(), (ViewGroup) J2(), true);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…youtId, flRootView, true)");
        AdImageView adImageView = (AdImageView) inflate.findViewById(R.id.reward_arrow);
        this.z = adImageView;
        if (adImageView != null) {
            adImageView.setImageResource(R.drawable.nad_reward_up_arrow);
        }
        AdImageView adImageView2 = this.z;
        if (adImageView2 != null) {
            gn0 gn0Var = this.Q;
            if (gn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            pn0 c2 = gn0Var.c();
            if (c2 == null || !c2.d()) {
                gn0 gn0Var2 = this.Q;
                if (gn0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (!gn0Var2.q()) {
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
                    gn0 gn0Var3 = this.Q;
                    if (gn0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (gn0Var3.q()) {
                        a2 = t11.c.a(adImageView2.getContext(), 23.0f);
                    } else {
                        a2 = t11.c.a(adImageView2.getContext(), 4.0f);
                    }
                    layoutParams2.bottomMargin = a2;
                    adImageView2.setOnClickListener(new h());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
    }

    public final void e3() {
        ln0 ln0Var;
        ln0 ln0Var2;
        String str;
        ln0 ln0Var3;
        String str2;
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        jn0 jn0Var = gn0Var.j;
        tk0 tk0Var = null;
        if (jn0Var != null) {
            ln0Var = jn0Var.i;
        } else {
            ln0Var = null;
        }
        if (ln0Var != null) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            pn0 c2 = gn0Var2.c();
            if (c2 == null || c2.q()) {
                gn0 gn0Var3 = this.Q;
                if (gn0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                jn0 jn0Var2 = gn0Var3.j;
                if (jn0Var2 != null && (ln0Var2 = jn0Var2.i) != null) {
                    gn0 gn0Var4 = this.Q;
                    if (gn0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    jn0 jn0Var3 = gn0Var4.j;
                    if (jn0Var3 != null && (ln0Var3 = jn0Var3.i) != null && (str2 = ln0Var3.y) != null) {
                        pk0 pk0Var = this.R;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (pk0Var == null || (r4 = pk0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    ln0Var2.y = str;
                }
                tk0 tk0Var2 = this.E;
                if (tk0Var2 != null) {
                    tk0Var2.setVisibility(false);
                }
                tk0.a aVar = tk0.k0;
                gn0 gn0Var5 = this.Q;
                if (gn0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                tk0 a2 = aVar.a(gn0Var5, this);
                this.E = a2;
                if (a2 != null) {
                    gn0 gn0Var6 = this.Q;
                    if (gn0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(gn0Var6);
                }
                tk0 tk0Var3 = this.E;
                if (tk0Var3 instanceof View) {
                    tk0Var = tk0Var3;
                }
                View view2 = (View) tk0Var;
                if (view2 != null) {
                    N2().removeAllViews();
                    N2().addView(view2);
                    N2().bringToFront();
                }
                tk0 tk0Var4 = this.E;
                if (tk0Var4 != null) {
                    tk0Var4.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
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
                            tk0 tk0Var5 = NadRewardVideoActivity.this.E;
                            if (tk0Var5 != null) {
                                tk0Var5.setVisibility(false);
                            }
                            xp0 xp0Var = NadRewardVideoActivity.this.I;
                            if (xp0Var != null) {
                                xp0Var.start();
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        tk0 tk0Var5 = this.E;
        if (tk0Var5 != null) {
            tk0Var5.setVisibility(false);
        }
    }

    public final void g3() {
        String str;
        String str2;
        String str3;
        if (this.e0 == null) {
            wk0 a2 = al0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            this.e0 = (TextView) LayoutInflater.from(this).inflate(a2.p(), (ViewGroup) J2(), true).findViewById(R.id.top_tag_text);
        }
        TextView textView = this.e0;
        if (textView != null) {
            gn0 gn0Var = this.Q;
            if (gn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fn0 m2 = gn0Var.m();
            String str4 = null;
            if (m2 != null) {
                str = m2.b();
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
                gn0 gn0Var2 = this.Q;
                if (gn0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fn0 m3 = gn0Var2.m();
                if (m3 != null) {
                    str2 = m3.b();
                } else {
                    str2 = null;
                }
                textView.setText(str2);
                gn0 gn0Var3 = this.Q;
                if (gn0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fn0 m4 = gn0Var3.m();
                if (m4 != null) {
                    str3 = m4.c();
                } else {
                    str3 = null;
                }
                textView.setTextColor(Color.parseColor(str3));
                gn0 gn0Var4 = this.Q;
                if (gn0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fn0 m5 = gn0Var4.m();
                if (m5 != null) {
                    str4 = m5.a();
                }
                textView.setBackgroundColor(Color.parseColor(str4));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
        if (r0 == true) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean y3() {
        String str;
        ViewGroup view2;
        boolean z;
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (gn0Var.g().k() != null) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (gn0Var2.g().m() != null) {
                gn0 gn0Var3 = this.Q;
                if (gn0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bo0 m2 = gn0Var3.g().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !ro.a(this) && !k3() && !ll0.e.b()) {
                    tk0 tk0Var = this.E;
                    if (tk0Var != null && (view2 = tk0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    gn0 gn0Var4 = this.Q;
                    if (gn0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ao0 g2 = gn0Var4.g();
                    gn0 gn0Var5 = this.Q;
                    if (gn0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    tn0 k2 = gn0Var5.g().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    gn0 gn0Var6 = this.Q;
                    if (gn0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    tn0 k3 = gn0Var6.g().k();
                    Intrinsics.checkNotNull(k3);
                    NadRewardLottieDialog C2 = C2(g2.j(c2, k3.a()));
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    C2.show(supportFragmentManager, (String) null);
                    this.N = C2;
                    n3();
                    return true;
                }
            }
        }
        return false;
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
    public final void V2() {
        View view2;
        ViewParent viewParent;
        int a2;
        uk0 uk0Var;
        ViewParent viewParent2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ViewParent viewParent3;
        uk0 uk0Var2;
        uk0 uk0Var3;
        View view3;
        ViewParent viewParent4;
        View view4;
        View view5;
        View view6;
        boolean z;
        ViewParent viewParent5;
        J2().removeViewInLayout(this.h0);
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (gn0Var.h() == null) {
            return;
        }
        uk0 uk0Var4 = (uk0) ServiceManager.getService(uk0.a);
        this.f0 = uk0Var4;
        if (uk0Var4 == null) {
            return;
        }
        if (uk0Var4 != null) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            uk0Var4.b(gn0Var2, this);
        }
        uk0 uk0Var5 = this.f0;
        ViewParent viewParent6 = null;
        if (uk0Var5 != null) {
            view2 = uk0Var5.getView();
        } else {
            view2 = null;
        }
        if (view2 == null) {
            return;
        }
        NadRewardFestivalContainer nadRewardFestivalContainer = new NadRewardFestivalContainer(this);
        gn0 gn0Var3 = this.Q;
        if (gn0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardFestivalContainer.setData(gn0Var3);
        nadRewardFestivalContainer.setVisibility(4);
        nadRewardFestivalContainer.setContainer(H2());
        nadRewardFestivalContainer.setFestivalClickCallback(new j(nadRewardFestivalContainer, this));
        Unit unit = Unit.INSTANCE;
        this.g0 = nadRewardFestivalContainer;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = t11.c.a(this, 10.0f);
        NadRewardFestivalContainer nadRewardFestivalContainer2 = this.g0;
        if (nadRewardFestivalContainer2 != null) {
            viewParent = nadRewardFestivalContainer2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            NadRewardFestivalContainer nadRewardFestivalContainer3 = this.g0;
            if (nadRewardFestivalContainer3 != null) {
                viewParent5 = nadRewardFestivalContainer3.getParent();
            } else {
                viewParent5 = null;
            }
            if (viewParent5 != null) {
                ((ViewGroup) viewParent5).removeView(this.g0);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        LinearLayout linearLayout3 = this.h0;
        if (linearLayout3 == null) {
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.removeAllViews();
            linearLayout4.setOrientation(1);
            linearLayout4.addView(this.g0, layoutParams);
            Unit unit2 = Unit.INSTANCE;
            this.h0 = linearLayout4;
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
                a2 = t11.c.a(this, 30.0f);
                layoutParams2.bottomMargin = a2;
                uk0Var = this.f0;
                if (uk0Var == null && (view6 = uk0Var.getView()) != null) {
                    viewParent2 = view6.getParent();
                } else {
                    viewParent2 = null;
                }
                if (viewParent2 instanceof ViewGroup) {
                    uk0 uk0Var6 = this.f0;
                    if (uk0Var6 != null && (view5 = uk0Var6.getView()) != null) {
                        viewParent4 = view5.getParent();
                    } else {
                        viewParent4 = null;
                    }
                    if (viewParent4 != null) {
                        ViewGroup viewGroup = (ViewGroup) viewParent4;
                        uk0 uk0Var7 = this.f0;
                        if (uk0Var7 != null) {
                            view4 = uk0Var7.getView();
                        } else {
                            view4 = null;
                        }
                        viewGroup.removeView(view4);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                }
                linearLayout = this.h0;
                if (linearLayout != null) {
                    uk0 uk0Var8 = this.f0;
                    if (uk0Var8 != null) {
                        view3 = uk0Var8.getView();
                    } else {
                        view3 = null;
                    }
                    linearLayout.addView(view3, layoutParams2);
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = BadgeDrawable.BOTTOM_START;
                linearLayout2 = this.h0;
                if (linearLayout2 == null) {
                    viewParent3 = linearLayout2.getParent();
                } else {
                    viewParent3 = null;
                }
                if (viewParent3 instanceof ViewGroup) {
                    LinearLayout linearLayout5 = this.h0;
                    if (linearLayout5 != null) {
                        viewParent6 = linearLayout5.getParent();
                    }
                    if (viewParent6 != null) {
                        ((ViewGroup) viewParent6).removeView(this.h0);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                }
                J2().addView(this.h0, layoutParams3);
                uk0Var2 = this.f0;
                if (uk0Var2 != null) {
                    uk0Var2.a(new k());
                }
                uk0Var3 = this.f0;
                if (uk0Var3 == null) {
                    uk0Var3.show();
                    return;
                }
                return;
            }
        }
        a2 = t11.c.a(this, 7.0f);
        layoutParams2.bottomMargin = a2;
        uk0Var = this.f0;
        if (uk0Var == null) {
        }
        viewParent2 = null;
        if (viewParent2 instanceof ViewGroup) {
        }
        linearLayout = this.h0;
        if (linearLayout != null) {
        }
        FrameLayout.LayoutParams layoutParams32 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams32.gravity = BadgeDrawable.BOTTOM_START;
        linearLayout2 = this.h0;
        if (linearLayout2 == null) {
        }
        if (viewParent3 instanceof ViewGroup) {
        }
        J2().addView(this.h0, layoutParams32);
        uk0Var2 = this.f0;
        if (uk0Var2 != null) {
        }
        uk0Var3 = this.f0;
        if (uk0Var3 == null) {
        }
    }

    public final void h3() {
        int i2;
        vm0 vm0Var;
        int i3;
        ln0 ln0Var;
        NadRewardVideoAdOverContainer H2 = H2();
        H2.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
        gn0 gn0Var = this.Q;
        if (gn0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        boolean z = true;
        if (gn0Var.g().C()) {
            gn0 gn0Var2 = this.Q;
            if (gn0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = gn0Var2.f.c;
            Context context = H2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (j3(str, context)) {
                gn0 gn0Var3 = this.Q;
                if (gn0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                wm0 wm0Var = gn0Var3.m;
                if (wm0Var != null) {
                    wm0Var.g = true;
                }
                gn0 gn0Var4 = this.Q;
                if (gn0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                jn0 jn0Var = gn0Var4.j;
                if (jn0Var != null && (ln0Var = jn0Var.i) != null) {
                    ln0Var.D = true;
                }
            }
        }
        gn0 gn0Var5 = this.Q;
        if (gn0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (gn0Var5.e() != null) {
            gn0 gn0Var6 = this.Q;
            if (gn0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            wm0 wm0Var2 = gn0Var6.m;
            if (wm0Var2 != null) {
                wm0Var2.e = true;
            }
            gn0 gn0Var7 = this.Q;
            if (gn0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            wm0 wm0Var3 = gn0Var7.m;
            if (wm0Var3 != null) {
                gn0 gn0Var8 = this.Q;
                if (gn0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (gn0Var8.p()) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                wm0Var3.a = i3;
            }
            gn0 gn0Var9 = this.Q;
            if (gn0Var9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            wm0 wm0Var4 = gn0Var9.m;
            if (wm0Var4 != null) {
                gn0 gn0Var10 = this.Q;
                if (gn0Var10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                rn0 e2 = gn0Var10.e();
                Intrinsics.checkNotNull(e2);
                wm0Var4.p = e2.b();
            }
            gn0 gn0Var11 = this.Q;
            if (gn0Var11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            wm0 wm0Var5 = gn0Var11.m;
            if (wm0Var5 != null && (vm0Var = wm0Var5.q) != null) {
                gn0 gn0Var12 = this.Q;
                if (gn0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                vm0Var.d = gn0Var12.f.d;
            }
        }
        gn0 gn0Var13 = this.Q;
        if (gn0Var13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        H2.setData(gn0Var13);
        gn0 gn0Var14 = this.Q;
        if (gn0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (gn0Var14.e() != null) {
            z = false;
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        H2.setVisibility(i2);
        gn0 gn0Var15 = this.Q;
        if (gn0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (gn0Var15.o()) {
            H2.setBottomLineHeight(t11.c.a(H2.getContext(), 33.0f));
        } else {
            H2.setBottomLineHeight(t11.c.a(H2.getContext(), 10.0f));
        }
        H2.setOnUiClickListener(new n());
        H2.setFeedbackBtnVisibility(false);
        H2.setFestivalClickCallback(new o(H2, this));
    }

    public final void i3() {
        boolean z;
        JSONObject put;
        yp0 yp0Var = new yp0();
        yp0Var.a = 2;
        boolean z2 = false;
        if (this.I == null) {
            this.I = xp0.a.a(this, 0, yp0Var);
        }
        xp0 xp0Var = this.I;
        if (xp0Var != null) {
            xp0Var.attachToContainer(P2());
            q qVar = new q();
            qVar.n(true);
            xp0Var.d(qVar);
            gn0 gn0Var = this.Q;
            if (gn0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            jn0 jn0Var = gn0Var.j;
            if (jn0Var != null && jn0Var.g) {
                xp0Var.setVideoScalingMode(0);
            } else {
                xp0Var.setVideoScalingMode(2);
            }
            xp0Var.a(new p());
        }
        FrameLayout P2 = P2();
        P2.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = 0;
        P2.setLayoutParams(layoutParams);
        gn0 gn0Var2 = this.Q;
        if (gn0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        JSONObject jSONObject = null;
        if (gn0Var2.j == null) {
            P2().setVisibility(8);
            this.I = null;
            return;
        }
        gn0 gn0Var3 = this.Q;
        if (gn0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        jn0 jn0Var2 = gn0Var3.j;
        Intrinsics.checkNotNull(jn0Var2);
        String str = jn0Var2.j;
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
                    gn0 gn0Var4 = this.Q;
                    if (gn0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    jSONObject = put.put("ad_extra_param", gn0Var4.f.d);
                }
                jSONObject2.putOpt(BasicVideoParserKt.EXT_LOG, String.valueOf(jSONObject));
                gn0 gn0Var5 = this.Q;
                if (gn0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                jn0 jn0Var3 = gn0Var5.j;
                Intrinsics.checkNotNull(jn0Var3);
                jn0Var3.j = jSONObject2.toString();
            } catch (Exception unused) {
            }
        }
        xp0 xp0Var2 = this.I;
        if (xp0Var2 != null) {
            gn0 gn0Var6 = this.Q;
            if (gn0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            jn0 jn0Var4 = gn0Var6.j;
            Intrinsics.checkNotNull(jn0Var4);
            xp0Var2.c(jn0Var4);
        }
        if (NetUtil.a(this)) {
            gn0 gn0Var7 = this.Q;
            if (gn0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            pn0 c2 = gn0Var7.c();
            if (c2 != null) {
                z2 = c2.q();
            }
            xp0 xp0Var3 = this.I;
            if (xp0Var3 != null) {
                xp0Var3.setLooping(!z2);
            }
            xp0 xp0Var4 = this.I;
            if (xp0Var4 != null) {
                xp0Var4.start();
                return;
            }
            return;
        }
        v01.a().a(this, R.string.nad_reward_video_lp_no_network);
    }

    public final boolean j3(String str, Context context) {
        Object m855constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new ue0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m855constructorimpl = Result.m855constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m855constructorimpl = Result.m855constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m861isFailureimpl(m855constructorimpl)) {
            m855constructorimpl = null;
        }
        String str3 = (String) m855constructorimpl;
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

    public final boolean m3() {
        Object m855constructorimpl;
        ln0 ln0Var;
        String str;
        ln0 ln0Var2;
        Boolean bool;
        boolean z;
        ln0 ln0Var3;
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
            m855constructorimpl = Result.m855constructorimpl(ResultKt.createFailure(th));
        }
        if (serializable != null) {
            m855constructorimpl = Result.m855constructorimpl(jl0.a.d((HashMap) serializable));
            if (Result.m862isSuccessimpl(m855constructorimpl)) {
                gn0 gn0Var = (gn0) m855constructorimpl;
                this.Q = gn0Var;
                if (gn0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                jn0 jn0Var = gn0Var.j;
                if (jn0Var != null && (ln0Var3 = jn0Var.i) != null) {
                    il0 il0Var = il0.a;
                    String str3 = ln0Var3.f;
                    gn0 gn0Var2 = this.Q;
                    if (gn0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ln0Var3.f = il0Var.c(str3, gn0Var2);
                    il0 il0Var2 = il0.a;
                    String str4 = ln0Var3.g;
                    gn0 gn0Var3 = this.Q;
                    if (gn0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ln0Var3.g = il0Var2.c(str4, gn0Var3);
                }
                gn0 gn0Var4 = this.Q;
                if (gn0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                on0 b2 = gn0Var4.b();
                if (b2 != null) {
                    il0 il0Var3 = il0.a;
                    String d2 = b2.d();
                    gn0 gn0Var5 = this.Q;
                    if (gn0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    b2.h(il0Var3.c(d2, gn0Var5));
                }
                gn0 gn0Var6 = this.Q;
                if (gn0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                wm0 wm0Var = gn0Var6.m;
                boolean z2 = true;
                if (wm0Var != null) {
                    wm0Var.d = true;
                }
                gn0 gn0Var7 = this.Q;
                if (gn0Var7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                wm0 wm0Var2 = gn0Var7.m;
                if (wm0Var2 != null) {
                    gn0 gn0Var8 = this.Q;
                    if (gn0Var8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    pn0 c2 = gn0Var8.c();
                    if (c2 != null) {
                        z = c2.e();
                    } else {
                        z = false;
                    }
                    wm0Var2.f = z;
                }
                gn0 gn0Var9 = this.Q;
                if (gn0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                jn0 jn0Var2 = gn0Var9.j;
                if (jn0Var2 != null && (ln0Var2 = jn0Var2.i) != null) {
                    gn0 gn0Var10 = this.Q;
                    if (gn0Var10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    pn0 c3 = gn0Var10.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.s());
                    } else {
                        bool = null;
                    }
                    ln0Var2.E = bool;
                }
                gn0 gn0Var11 = this.Q;
                if (gn0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                jn0 jn0Var3 = gn0Var11.j;
                if (jn0Var3 != null && (ln0Var = jn0Var3.i) != null) {
                    gn0 gn0Var12 = this.Q;
                    if (gn0Var12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    pn0 c4 = gn0Var12.c();
                    if (c4 != null) {
                        str = c4.r();
                    } else {
                        str = null;
                    }
                    ln0Var.F = str;
                }
                kk0 kk0Var = (kk0) ServiceManager.getService(kk0.a);
                gn0 gn0Var13 = this.Q;
                if (gn0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (gn0Var13.g().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && kk0Var != null) {
                    gn0 gn0Var14 = this.Q;
                    if (gn0Var14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ao0 g2 = gn0Var14.g();
                    String a2 = kk0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    g2.F(a2);
                }
                gn0 gn0Var15 = this.Q;
                if (gn0Var15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                wm0 wm0Var3 = gn0Var15.m;
                if (wm0Var3 != null) {
                    gn0 gn0Var16 = this.Q;
                    if (gn0Var16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = gn0Var16.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    wm0Var3.h = list;
                }
                gn0 gn0Var17 = this.Q;
                if (gn0Var17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qn0 f2 = gn0Var17.g().f();
                if (f2 != null) {
                    str2 = f2.c();
                }
                this.b0 = Intrinsics.areEqual(str2, "0");
            }
            Throwable m858exceptionOrNullimpl = Result.m858exceptionOrNullimpl(m855constructorimpl);
            if (m858exceptionOrNullimpl != null && pc0.a) {
                v01.a().showToast(this, m858exceptionOrNullimpl.getMessage());
            }
            return Result.m862isSuccessimpl(m855constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final void o3(String str, String str2, HashMap<String, String> hashMap) {
        qk0 qk0Var = new qk0();
        qk0Var.a = str;
        qk0Var.b = hashMap;
        si0.a().b(qk0Var);
    }
}
