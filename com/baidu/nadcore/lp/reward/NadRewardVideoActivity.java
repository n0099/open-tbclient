package com.baidu.nadcore.lp.reward;

import android.content.Context;
import android.content.Intent;
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
import com.baidu.nadcore.lp.reward.view.NadRewardFestivalContainer;
import com.baidu.nadcore.lp.reward.view.NadRewardFloatingLayerView;
import com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder;
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
import com.baidu.tieba.ap0;
import com.baidu.tieba.as0;
import com.baidu.tieba.b61;
import com.baidu.tieba.bh0;
import com.baidu.tieba.bj0;
import com.baidu.tieba.bp0;
import com.baidu.tieba.br0;
import com.baidu.tieba.cp0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.dt;
import com.baidu.tieba.en0;
import com.baidu.tieba.ep0;
import com.baidu.tieba.er0;
import com.baidu.tieba.f81;
import com.baidu.tieba.f91;
import com.baidu.tieba.fp0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.g81;
import com.baidu.tieba.g91;
import com.baidu.tieba.gj0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.gu0;
import com.baidu.tieba.hu0;
import com.baidu.tieba.in0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.is0;
import com.baidu.tieba.js0;
import com.baidu.tieba.ks0;
import com.baidu.tieba.ku0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.m61;
import com.baidu.tieba.mp0;
import com.baidu.tieba.ms0;
import com.baidu.tieba.ni0;
import com.baidu.tieba.o51;
import com.baidu.tieba.o61;
import com.baidu.tieba.oj0;
import com.baidu.tieba.or0;
import com.baidu.tieba.os0;
import com.baidu.tieba.pj0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.q11;
import com.baidu.tieba.rh0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.sr0;
import com.baidu.tieba.tp0;
import com.baidu.tieba.u31;
import com.baidu.tieba.u61;
import com.baidu.tieba.ud1;
import com.baidu.tieba.up0;
import com.baidu.tieba.ur0;
import com.baidu.tieba.wo0;
import com.baidu.tieba.xr0;
import com.baidu.tieba.y81;
import com.baidu.tieba.yr0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\bì\u0001\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001f\u0010\u0015J\u000f\u0010 \u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010\u0015J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\"J+\u0010&\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b&\u0010'J)\u0010)\u001a\u00020\u00132\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0013¢\u0006\u0004\b+\u0010\u0015J\u000f\u0010,\u001a\u00020\u0013H\u0002¢\u0006\u0004\b,\u0010\u0015J\u000f\u0010-\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010\u0015J\u000f\u0010.\u001a\u00020\u0013H\u0002¢\u0006\u0004\b.\u0010\u0015J\u000f\u0010/\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u0010\u0015J\u000f\u00100\u001a\u00020\u0013H\u0002¢\u0006\u0004\b0\u0010\u0015J\u000f\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b1\u0010\u0015J\u000f\u00102\u001a\u00020\u0013H\u0002¢\u0006\u0004\b2\u0010\u0015J\u000f\u00103\u001a\u00020\u0013H\u0002¢\u0006\u0004\b3\u0010\u0015J\u000f\u00104\u001a\u00020\u0013H\u0002¢\u0006\u0004\b4\u0010\u0015J\u000f\u00105\u001a\u00020\u0013H\u0002¢\u0006\u0004\b5\u0010\u0015J\u000f\u00106\u001a\u00020\u0013H\u0002¢\u0006\u0004\b6\u0010\u0015J\u000f\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0004\b7\u0010\u0015J\u000f\u00108\u001a\u00020\u0013H\u0002¢\u0006\u0004\b8\u0010\u0015J\u000f\u00109\u001a\u00020\u0013H\u0002¢\u0006\u0004\b9\u0010\u0015J\u000f\u0010:\u001a\u00020\u0013H\u0002¢\u0006\u0004\b:\u0010\u0015J\u000f\u0010;\u001a\u00020\u0013H\u0002¢\u0006\u0004\b;\u0010\u0015J\u000f\u0010<\u001a\u00020\u0013H\u0002¢\u0006\u0004\b<\u0010\u0015J!\u0010=\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0002H\u0002¢\u0006\u0004\b?\u0010\u0004J\u000f\u0010@\u001a\u00020\u0013H\u0016¢\u0006\u0004\b@\u0010\u0015J\u000f\u0010A\u001a\u00020\u0013H\u0016¢\u0006\u0004\bA\u0010\u0015J\u0019\u0010D\u001a\u00020\u00132\b\u0010C\u001a\u0004\u0018\u00010BH\u0014¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0013H\u0014¢\u0006\u0004\bF\u0010\u0015J\u0019\u0010I\u001a\u00020\u00132\b\u0010H\u001a\u0004\u0018\u00010GH\u0014¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0013H\u0014¢\u0006\u0004\bK\u0010\u0015J\u000f\u0010L\u001a\u00020\u0013H\u0014¢\u0006\u0004\bL\u0010\u0015J\u000f\u0010M\u001a\u00020\u0013H\u0002¢\u0006\u0004\bM\u0010\u0015J\u000f\u0010N\u001a\u00020\u0002H\u0002¢\u0006\u0004\bN\u0010\u0004J\u000f\u0010O\u001a\u00020\u0013H\u0002¢\u0006\u0004\bO\u0010\u0015JC\u0010U\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u00052\"\u0010T\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050Rj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`SH\u0002¢\u0006\u0004\bU\u0010VJ\u0019\u0010W\u001a\u00020\u00022\b\u0010C\u001a\u0004\u0018\u00010BH\u0014¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0013H\u0002¢\u0006\u0004\bY\u0010\u0015J\u000f\u0010Z\u001a\u00020\u0013H\u0002¢\u0006\u0004\bZ\u0010\u0015J\u000f\u0010[\u001a\u00020\u0013H\u0002¢\u0006\u0004\b[\u0010\u0015J\u000f\u0010\\\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\\\u0010\u0015J\u000f\u0010]\u001a\u00020\u0013H\u0002¢\u0006\u0004\b]\u0010\u0015J\u0017\u0010_\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\u0002H\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\u0013H\u0002¢\u0006\u0004\ba\u0010\u0015J\u000f\u0010b\u001a\u00020\u0002H\u0002¢\u0006\u0004\bb\u0010\u0004J\u000f\u0010c\u001a\u00020\u0013H\u0002¢\u0006\u0004\bc\u0010\u0015J\u000f\u0010d\u001a\u00020\u0002H\u0002¢\u0006\u0004\bd\u0010\u0004J/\u0010i\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u00022\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010h\u001a\u0004\u0018\u00010gH\u0002¢\u0006\u0004\bi\u0010jJ\u0017\u0010l\u001a\u00020\u00022\u0006\u0010k\u001a\u00020gH\u0002¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\u0002H\u0002¢\u0006\u0004\bn\u0010\u0004J\u000f\u0010o\u001a\u00020\u0002H\u0002¢\u0006\u0004\bo\u0010\u0004J\u000f\u0010p\u001a\u00020\u0013H\u0002¢\u0006\u0004\bp\u0010\u0015J\u0017\u0010q\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\bq\u0010\u001cJ\u000f\u0010r\u001a\u00020\u0002H\u0002¢\u0006\u0004\br\u0010\u0004J\u000f\u0010s\u001a\u00020\u0013H\u0002¢\u0006\u0004\bs\u0010\u0015J\u0017\u0010v\u001a\u00020\u00132\u0006\u0010u\u001a\u00020tH\u0002¢\u0006\u0004\bv\u0010wR\u001d\u0010}\u001a\u00020x8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010~R\u001f\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u007f8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\"\u0010\u0086\u0001\u001a\u00030\u0082\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0083\u0001\u0010z\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0089\u0001R\u0019\u0010\u0090\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008e\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\"\u0010¡\u0001\u001a\u00030\u009d\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009e\u0001\u0010z\u001a\u0006\b\u009f\u0001\u0010 \u0001R\"\u0010¦\u0001\u001a\u00030¢\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b£\u0001\u0010z\u001a\u0006\b¤\u0001\u0010¥\u0001R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u008e\u0001R\"\u0010¯\u0001\u001a\u00030«\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¬\u0001\u0010z\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u001b\u0010°\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001c\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u001c\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001b\u0010¸\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u001a\u0010»\u0001\u001a\u00030º\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001b\u0010½\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¹\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001a\u0010Á\u0001\u001a\u00030º\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010¼\u0001R\u001c\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0019\u0010Å\u0001\u001a\u00020t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001a\u0010Ç\u0001\u001a\u00030º\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010¼\u0001R\u0019\u0010È\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010\u008e\u0001R\u001a\u0010Ê\u0001\u001a\u00030É\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Î\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u008e\u0001R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010Ï\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u001c\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001c\u0010Ö\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\"\u0010Ü\u0001\u001a\u00030Ø\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÙ\u0001\u0010z\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u001b\u0010Ý\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010¹\u0001R\"\u0010â\u0001\u001a\u00030Þ\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bß\u0001\u0010z\u001a\u0006\bà\u0001\u0010á\u0001R\u001c\u0010ä\u0001\u001a\u0005\u0018\u00010ã\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u001c\u0010ç\u0001\u001a\u0005\u0018\u00010æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R\"\u0010ë\u0001\u001a\u00030Ø\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bé\u0001\u0010z\u001a\u0006\bê\u0001\u0010Û\u0001¨\u0006í\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/NadRewardVideoActivity;", "Lcom/baidu/nadcore/appframework/BaseActivity;", "", "bigCardNineSpliteScreenShowing", "()Z", "", "dialogDataJson", "isTaskDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "buildDialog", "(Ljava/lang/String;Z)Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "rewardDataJson", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "buildLottieDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "suspendCmd", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "buildSuspendDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "", "chargeClick", "()V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "checkDownloadInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)Z", "scheme", "checkRewardPanelPop", "(Ljava/lang/String;)Z", "suspendDialogShowMoment", "checkShowSuspendMoment", "computeDailyRewardShownIndex", "finish", "getSessionInfo", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "cmd", "handleDialogRoute", "(Landroid/content/Context;Lcom/baidu/nadcore/model/AdRewardVideoLpModel;Ljava/lang/String;)V", "downloadInvokePanelPop", "handleUserInfoContainerRoute", "(Landroid/content/Context;Lcom/baidu/nadcore/model/AdRewardVideoLpModel;Z)V", "init", "initBigCard", "initBottomArrow", "initCloseIcon", "initCountDownView", "initCriusView", "initFloatingLayer", "initImageStyle", "initRewardTask", "initRootView", "initSessionCountByTime", "initSvButton", "initSvTitle", "initTailFrame", "initTopTag", "initTopTagText", "initUserInfoContainer", "initVideoPlayer", "isAppInstalled", "(Ljava/lang/String;Landroid/content/Context;)Z", "isDialogShowing", "onAttachedToWindow", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreateEx", "(Landroid/os/Bundle;)V", "onDestroyEx", "Landroid/content/Intent;", "intent", "onNewIntentEx", "(Landroid/content/Intent;)V", "onPauseEx", "onResumeEx", "onTaskComplete", "parseData", "pauseVideoPlayAndCountDown", "status", "message", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "postRewardVideoNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "preCreate", "(Landroid/os/Bundle;)Z", "recomputeCountDownSecond", "registerBackForegroundEvent", "resetStatus", "resumeVideoPlayAndCountDown", "setAppInfo", "playEnd", "setVideoContainerMask", "(Z)V", "showBigCard", "showDialog", "showImageStylePage", "showLottieDialog", "autoPopup", "chargeModify", "", "chargeDuration", "showPanelPop", "(ZLjava/lang/String;Ljava/lang/Long;)V", "remainSecond", "showRetainDialog", "(J)Z", "showRewardDialog", "showSuspendDialog", "showSuspendDialogDelay", "showTaskDialog", "tailNineSplitScreenShowing", "triggerTask", "", "progress", "updateVideoSize", "(F)V", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer$delegate", "Lkotlin/Lazy;", "getAdInfoContainer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "", "appDownloadInfoArray", "[Ljava/lang/String;", "Lcom/baidu/nadcore/widget/uiwidget/SimpleAdInfoView;", "appInfoView$delegate", "getAppInfoView", "()Lcom/baidu/nadcore/widget/uiwidget/SimpleAdInfoView;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "arrowView", "Lcom/baidu/nadcore/widget/AdImageView;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCard", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCardShown", "Z", "closeIcon", "countDownFinished", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "countDownView", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Lcom/baidu/nadcore/lp/reward/ioc/INadRewardCriusPopContainer;", "criusViewContainer", "Lcom/baidu/nadcore/lp/reward/ioc/INadRewardCriusPopContainer;", "Landroid/widget/LinearLayout;", "criusViewGroup", "Landroid/widget/LinearLayout;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFestivalContainer;", "festivalContainer", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFestivalContainer;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "flRootView$delegate", "getFlRootView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "flRootView", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFloatingLayerView;", "floatingLayer$delegate", "getFloatingLayer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardFloatingLayerView;", "floatingLayer", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "hasMore", "Lcom/baidu/nadcore/lp/reward/view/NadRewardImageView;", "imageStyleView$delegate", "getImageStyleView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardImageView;", "imageStyleView", "lottieDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "retainDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "rewardCount", "I", "rewardDialog", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardResponse", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardShownIndex", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "rewardTaskHelper", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "screenHW", "F", "sessionCount", "shouldCharge", "Ljava/lang/Runnable;", "shouldChargeTask", "Ljava/lang/Runnable;", "suspendDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "suspendDialogShown", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "svButton", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "svTitle", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "tailFrame", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "Landroid/widget/FrameLayout;", "tailFrameContainer$delegate", "getTailFrameContainer", "()Landroid/widget/FrameLayout;", "tailFrameContainer", "taskDialog", "Landroid/view/View;", "topMask$delegate", "getTopMask", "()Landroid/view/View;", "topMask", "Landroid/widget/ImageView;", "topTag", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "topTagText", "Landroid/widget/TextView;", "videoContainer$delegate", "getVideoContainer", "videoContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardVideoActivity extends BaseActivity {
    public AdImageView B;
    public ImageView C;
    public AbsRewardCountDownView D;
    public fp0 E;
    public y81 F;
    public NadHighLightTextView H;
    public NadIconTextButton I;
    public gu0 J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardVideoDialog M;
    public NadRewardSuspendDialog N;
    public NadRewardLottieDialog O;
    public NadRewardBigCardView P;
    public pr0 R;
    public bp0 S;

    /* renamed from: T  reason: collision with root package name */
    public float f1051T;
    public int U;
    public int V;
    public boolean X;
    public NadRewardTaskHelper Y;
    public Handler Z;
    public boolean a0;
    public boolean c0;
    public boolean d0;
    public boolean e0;
    public TextView f0;
    public gp0 g0;
    public NadRewardFestivalContainer h0;
    public LinearLayout i0;
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
    public int W = 1;
    public Runnable b0 = new t();

    public final NadRewardVideoAdOverContainer L2() {
        return (NadRewardVideoAdOverContainer) this.x.getValue();
    }

    public final SimpleAdInfoView M2() {
        return (SimpleAdInfoView) this.A.getValue();
    }

    public final NadRewardInterceptFrameLayout N2() {
        return (NadRewardInterceptFrameLayout) this.u.getValue();
    }

    public final NadRewardFloatingLayerView O2() {
        return (NadRewardFloatingLayerView) this.Q.getValue();
    }

    public final NadRewardImageView P2() {
        return (NadRewardImageView) this.G.getValue();
    }

    public final FrameLayout R2() {
        return (FrameLayout) this.y.getValue();
    }

    public final View S2() {
        return (View) this.w.getValue();
    }

    public final FrameLayout T2() {
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
        public static final class a implements sp0.a {
            public a() {
            }

            @Override // com.baidu.tieba.sp0.a
            public void onFail(Exception exc) {
                up0.k(NadRewardVideoActivity.P1(j.this.b).f.d, "4");
                Toast.makeText(j.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.sp0.a
            public void a(cs0 cs0Var) {
                String str;
                NadRewardVideoActivity.P1(j.this.b).h().E(cs0Var);
                String str2 = null;
                if (cs0Var != null) {
                    str = cs0Var.f();
                } else {
                    str = null;
                }
                if (TextUtils.equals(str, "1")) {
                    j.this.a.setFestivalEntranceContainerInvisible();
                    NadRewardVideoActivity nadRewardVideoActivity = j.this.b;
                    if (cs0Var != null) {
                        str2 = cs0Var.d();
                    }
                    Toast.makeText(nadRewardVideoActivity, str2, 0).show();
                    return;
                }
                j.this.b.E3();
                String str3 = NadRewardVideoActivity.P1(j.this.b).f.d;
                if (cs0Var != null) {
                    str2 = cs0Var.a();
                }
                up0.l(str3, "4", str2);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            String str2 = null;
            if (NadRewardVideoActivity.P1(this.b).h().k() != null) {
                cs0 k = NadRewardVideoActivity.P1(this.b).h().k();
                if (k != null) {
                    str = k.f();
                } else {
                    str = null;
                }
                if (TextUtils.equals(str, "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    cs0 k2 = NadRewardVideoActivity.P1(nadRewardVideoActivity).h().k();
                    if (k2 != null) {
                        str2 = k2.d();
                    }
                    Toast.makeText(nadRewardVideoActivity, str2, 0).show();
                    return;
                }
                this.b.E3();
                return;
            }
            sp0 sp0Var = sp0.a;
            js0 h = NadRewardVideoActivity.P1(this.b).h();
            ks0 m = NadRewardVideoActivity.P1(this.b).h().m();
            if (m != null) {
                str2 = m.b();
            }
            sp0Var.d(h, str2, new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class n implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public n(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        /* loaded from: classes3.dex */
        public static final class a implements sp0.a {
            public a() {
            }

            @Override // com.baidu.tieba.sp0.a
            public void onFail(Exception exc) {
                up0.k(NadRewardVideoActivity.P1(n.this.b).f.d, "4");
                Toast.makeText(n.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.sp0.a
            public void a(cs0 cs0Var) {
                String str;
                NadRewardVideoActivity.P1(n.this.b).h().E(cs0Var);
                String str2 = null;
                if (cs0Var != null) {
                    str = cs0Var.f();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "1")) {
                    n.this.a.setFestivalEntranceContainerInvisible();
                    Toast.makeText(n.this.b, cs0Var.d(), 0).show();
                    return;
                }
                n.this.b.E3();
                String str3 = NadRewardVideoActivity.P1(n.this.b).f.d;
                if (cs0Var != null) {
                    str2 = cs0Var.a();
                }
                up0.l(str3, "4", str2);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.P1(this.b).h().k() != null) {
                cs0 k = NadRewardVideoActivity.P1(this.b).h().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    cs0 k2 = NadRewardVideoActivity.P1(nadRewardVideoActivity).h().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.E3();
                return;
            }
            sp0 sp0Var = sp0.a;
            js0 h = NadRewardVideoActivity.P1(this.b).h();
            ks0 m = NadRewardVideoActivity.P1(this.b).h().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            sp0Var.d(h, str, new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class s extends in0<ln0> {

        /* loaded from: classes3.dex */
        public static final class a implements sp0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.sp0.a
            public void onFail(Exception exc) {
                up0.k(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.sp0.a
            public void a(cs0 cs0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.L2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (cs0Var != null) {
                    str = cs0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (cs0Var != null) {
                    str2 = cs0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d;
                    if (cs0Var != null) {
                        str3 = cs0Var.a();
                    }
                    up0.l(str4, "5", str3);
                }
            }
        }

        public s(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.in0
        public void onEvent(ln0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.P1(NadRewardVideoActivity.this).j().b()) {
                sp0 sp0Var = sp0.a;
                js0 h = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).h();
                cs0 k = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).h().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                sp0Var.d(h, str, new a());
                NadRewardVideoActivity.P1(NadRewardVideoActivity.this).j().e(false);
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
            NadRewardVideoActivity.this.G2();
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
            br0 br0Var;
            as0 e = NadRewardVideoActivity.P1(this.b).e();
            if (e != null && e.g()) {
                as0 e2 = NadRewardVideoActivity.P1(this.b).e();
                Intrinsics.checkNotNull(e2);
                br0Var = e2.b();
            } else {
                fr0 fr0Var = NadRewardVideoActivity.P1(this.b).m;
                if (fr0Var != null) {
                    br0Var = fr0Var.p;
                } else {
                    br0Var = null;
                }
            }
            en0.a().a(new rh0(br0Var));
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
            NadRewardVideoActivity.this.G2();
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
            NadRewardVideoActivity.this.G2();
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
            NadRewardVideoActivity.W2(nadRewardVideoActivity, context, NadRewardVideoActivity.P1(this.b), false, 4, null);
            up0.f(NadRewardVideoActivity.P1(this.b));
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
            if (o61.a()) {
                return;
            }
            String str2 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d;
            bp0 bp0Var = NadRewardVideoActivity.this.S;
            if (bp0Var != null) {
                str = bp0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            up0.r(str2, !z);
            if (NadRewardVideoActivity.this.C3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements ep0 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public k() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class l implements View.OnClickListener {
        public final /* synthetic */ g81 b;

        public l(g81 g81Var) {
            this.b = g81Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            up0.w(NadRewardVideoActivity.P1(NadRewardVideoActivity.this));
            if (NadRewardVideoActivity.this.I2(this.b.c)) {
                NadRewardVideoActivity.G3(NadRewardVideoActivity.this, false, null, null, 6, null);
            } else if (Intrinsics.areEqual(this.b.c, "__CONVERT_CMD__")) {
                if (NadRewardVideoActivity.P1(NadRewardVideoActivity.this).p()) {
                    bj0.c(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).g(), NadRewardVideoActivity.this);
                    return;
                }
                String str2 = null;
                if (NadRewardVideoActivity.P1(NadRewardVideoActivity.this).o()) {
                    NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                    fr0 fr0Var = NadRewardVideoActivity.P1(nadRewardVideoActivity).m;
                    if (fr0Var != null) {
                        str = fr0Var.t;
                    } else {
                        str = null;
                    }
                    if (nadRewardVideoActivity.I2(str)) {
                        NadRewardVideoActivity.G3(NadRewardVideoActivity.this, false, null, null, 6, null);
                        return;
                    }
                }
                fr0 fr0Var2 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).m;
                if (fr0Var2 != null) {
                    str2 = fr0Var2.t;
                }
                bj0.c(str2, NadRewardVideoActivity.this);
            } else {
                bj0.c(this.b.c, NadRewardVideoActivity.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class m implements View.OnClickListener {
        public final /* synthetic */ NadRewardVideoAdOverContainer a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public m(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer, NadRewardVideoActivity nadRewardVideoActivity) {
            this.a = nadRewardVideoAdOverContainer;
            this.b = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardVideoActivity nadRewardVideoActivity = this.b;
            Context context = this.a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            NadRewardVideoActivity.W2(nadRewardVideoActivity, context, NadRewardVideoActivity.P1(this.b), false, 4, null);
            this.b.G2();
            NadRewardVideoActivity.P1(this.b).j().d(true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class o extends ku0 {
        public o() {
        }

        @Override // com.baidu.tieba.ku0, com.baidu.tieba.du0
        public void onEnd(int i) {
            String str;
            ur0 ur0Var;
            String str2;
            ur0 ur0Var2;
            ur0 ur0Var3;
            ur0 ur0Var4;
            y81 y81Var;
            NadRewardBigCardView nadRewardBigCardView;
            if (NadRewardVideoActivity.P1(NadRewardVideoActivity.this).b() != null) {
                yr0 c = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).c();
                if (c != null && c.b() && (((y81Var = NadRewardVideoActivity.this.F) == null || !y81Var.isShowing()) && (nadRewardBigCardView = NadRewardVideoActivity.this.P) != null)) {
                    nadRewardBigCardView.y(true);
                }
                NadRewardVideoActivity.this.A3(true);
                NadRewardVideoActivity.this.B3();
            } else {
                if (!NadRewardVideoActivity.this.c0) {
                    sr0 sr0Var = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).j;
                    if (sr0Var != null && (ur0Var4 = sr0Var.i) != null) {
                        ur0Var4.x = null;
                    }
                    sr0 sr0Var2 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).j;
                    if (sr0Var2 != null && (ur0Var3 = sr0Var2.i) != null) {
                        ur0Var3.w = null;
                    }
                    sr0 sr0Var3 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).j;
                    if (sr0Var3 != null && (ur0Var2 = sr0Var3.i) != null) {
                        ur0Var2.y = null;
                    }
                }
                fp0 fp0Var = NadRewardVideoActivity.this.E;
                if (fp0Var != null) {
                    fp0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardVideoActivity.this.P;
                if (nadRewardBigCardView2 != null) {
                    nadRewardBigCardView2.setVisibility(false);
                }
                FrameLayout R2 = NadRewardVideoActivity.this.R2();
                if (R2 != null) {
                    R2.bringToFront();
                }
                NadRewardVideoActivity.P1(NadRewardVideoActivity.this).j().h(true);
                String str3 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d;
                String str4 = "0";
                if (!NadRewardVideoActivity.this.c0) {
                    str = "0";
                } else {
                    str = "1";
                }
                sr0 sr0Var4 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).j;
                if (sr0Var4 != null && (ur0Var = sr0Var4.i) != null && (str2 = ur0Var.a) != null) {
                    str4 = str2;
                }
                up0.z(str3, str, str4);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.B;
            if (adImageView != null) {
                adImageView.bringToFront();
            }
            TextView textView = NadRewardVideoActivity.this.f0;
            if (textView != null) {
                textView.bringToFront();
            }
            NadRewardVideoActivity.this.O2().l();
        }

        @Override // com.baidu.tieba.ku0, com.baidu.tieba.du0
        public void onStart() {
            NadRewardVideoActivity.this.A3(false);
            fp0 fp0Var = NadRewardVideoActivity.this.E;
            if (fp0Var != null) {
                fp0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }

        @Override // com.baidu.tieba.ku0, com.baidu.tieba.du0
        public void onUpdateProgress(int i, int i2, int i3) {
            NadRewardVideoActivity.this.O2().j(i);
        }
    }

    /* loaded from: classes3.dex */
    public static final class p extends q11 {
        @Override // com.baidu.tieba.q11, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (mp0.b().a()) {
                return 2;
            }
            return 1;
        }
    }

    /* loaded from: classes3.dex */
    public static final class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (NadRewardVideoActivity.this.N2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                nadRewardVideoActivity.f1051T = nadRewardVideoActivity.N2().getMeasuredHeight() / NadRewardVideoActivity.this.N2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class r implements lp0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public r() {
        }

        @Override // com.baidu.tieba.lp0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.S = null;
            NadRewardVideoActivity.this.c0 = false;
        }

        @Override // com.baidu.tieba.lp0.b
        public void a(bp0 bp0Var) {
            boolean z;
            View view2;
            AdDownloadStatus adDownloadStatus;
            boolean z2;
            NadRewardVideoActivity.this.S = bp0Var;
            if (bp0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.V++;
            int i = 0;
            if (bp0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.d(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).h().b(bp0Var.d()));
                }
                up0.d(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d, bp0Var.d(), NadRewardVideoActivity.this.Q2(), bp0Var.f(), bp0Var.h());
                if (bp0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    up0.A(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d, "2", bp0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(bp0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                }
                if (i <= 0) {
                    up0.o(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            up0.g(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d, "1", bp0Var.d(), NadRewardVideoActivity.this.Q2());
            NadRewardVideoActivity.this.c0 = !bp0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.P1(NadRewardVideoActivity.this).h().t());
            NadRewardVideoActivity.this.u3("0", "任务完成回调", hashMap);
            ud1<View> transitionButtonView = NadRewardVideoActivity.this.L2().getTransitionButtonView();
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
            NadRewardTaskHelper nadRewardTaskHelper = NadRewardVideoActivity.this.Y;
            if (nadRewardTaskHelper != null) {
                String str = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d;
                Intrinsics.checkNotNullExpressionValue(str, "adModel.common.extraParam");
                nadRewardTaskHelper.t(bp0Var, adDownloadStatus, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class t implements Runnable {
        public t() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardVideoActivity.this.a0 = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class u implements PopupWindow.OnDismissListener {
        public u(boolean z, long j, String str) {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            gu0 gu0Var = NadRewardVideoActivity.this.J;
            if (gu0Var != null) {
                gu0Var.resume();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.B;
            if (adImageView != null) {
                ExtensionsKt.f(adImageView, true);
            }
            TextView textView = NadRewardVideoActivity.this.f0;
            if (textView != null) {
                ExtensionsKt.f(textView, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class v implements f91 {
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public v(boolean z, long j, String str) {
            this.b = z;
            this.c = j;
            this.d = str;
        }

        @Override // com.baidu.tieba.f91
        public void a() {
            up0.j(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d);
        }

        @Override // com.baidu.tieba.f91
        public void b() {
            NadRewardVideoActivity.this.onBackPressed();
        }

        @Override // com.baidu.tieba.f91
        public void d() {
            NadRewardVideoActivity.this.onBackPressed();
        }

        @Override // com.baidu.tieba.f91
        public void dismiss() {
            AdImageView adImageView = NadRewardVideoActivity.this.B;
            if (adImageView != null) {
                ExtensionsKt.f(adImageView, true);
            }
            AdImageView adImageView2 = NadRewardVideoActivity.this.B;
            if (adImageView2 != null) {
                adImageView2.bringToFront();
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
            TextView textView = NadRewardVideoActivity.this.f0;
            if (textView != null) {
                textView.bringToFront();
            }
        }

        @Override // com.baidu.tieba.f91
        public void f() {
            up0.s(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d);
        }

        @Override // com.baidu.tieba.f91
        public void c() {
            if (!this.b) {
                return;
            }
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if ((TextUtils.equals(this.d, "1") || TextUtils.equals(this.d, "2")) && NadRewardVideoActivity.this.a0) {
                pr0 P1 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                up0.t(P1, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                return;
            }
            pr0 P12 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            up0.t(P12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
        }

        @Override // com.baidu.tieba.f91
        public void e() {
            if (!this.b) {
                return;
            }
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (TextUtils.equals(this.d, "2") && NadRewardVideoActivity.this.a0) {
                pr0 P1 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                up0.t(P1, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                return;
            }
            pr0 P12 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            up0.t(P12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B1() {
        super.B1();
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.c();
        }
        gu0 gu0Var = this.J;
        if (gu0Var != null) {
            gu0Var.release();
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
        L2().C();
        NadRewardTaskHelper nadRewardTaskHelper = this.Y;
        if (nadRewardTaskHelper != null) {
            nadRewardTaskHelper.F();
        }
        Handler handler = this.Z;
        if (handler != null) {
            handler.removeCallbacks(this.b0);
        }
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.x();
        }
        O2().l();
        gp0 gp0Var = this.g0;
        if (gp0Var != null) {
            gp0Var.release();
        }
        NadRewardFestivalContainer nadRewardFestivalContainer = this.h0;
        if (nadRewardFestivalContainer != null) {
            nadRewardFestivalContainer.f();
        }
    }

    public final void B3() {
        if (this.d0) {
            return;
        }
        y81 y81Var = this.F;
        if (y81Var != null && y81Var.isShowing()) {
            return;
        }
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        yr0 c2 = pr0Var.c();
        if (c2 != null && c2.b()) {
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            sr0 sr0Var = pr0Var2.j;
            if (sr0Var != null) {
                int i2 = sr0Var.c;
                pr0 pr0Var3 = this.R;
                if (pr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == pr0Var3.h().s()) {
                    return;
                }
            }
        }
        this.d0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        NadRewardBigCardView nadRewardBigCardView2 = this.P;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.bringToFront();
        }
        fp0 fp0Var = this.E;
        if (fp0Var != null) {
            fp0Var.setVisibility(false);
        }
        NadHighLightTextView nadHighLightTextView = this.H;
        if (nadHighLightTextView != null) {
            ExtensionsKt.f(nadHighLightTextView, false);
        }
        NadIconTextButton nadIconTextButton = this.I;
        if (nadIconTextButton != null) {
            ExtensionsKt.f(nadIconTextButton, false);
        }
        O2().l();
        L2().setFestivalEntranceContainerInvisible();
    }

    public final boolean J3() {
        JSONObject jSONObject;
        String f2;
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ms0 p2 = pr0Var.h().p();
        if (p2 == null || p2.f() == null || this.X) {
            return false;
        }
        y81 y81Var = this.F;
        if (y81Var != null && y81Var.isShowing()) {
            return false;
        }
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ms0 p3 = pr0Var2.h().p();
        if (p3 != null && (f2 = p3.f()) != null) {
            jSONObject = ExtensionsKt.a(f2);
        } else {
            jSONObject = null;
        }
        NadRewardSuspendDialog F2 = F2(String.valueOf(jSONObject));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        F2.show(supportFragmentManager, (String) null);
        this.X = true;
        this.N = F2;
        t3();
        return true;
    }

    public final void K3() {
        String str;
        String c2;
        Integer intOrNull;
        int i2 = 0;
        this.X = false;
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ms0 p2 = pr0Var.h().p();
        if (p2 != null && p2.f() != null) {
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final ms0 p3 = pr0Var2.h().p();
            if (p3 != null) {
                str = p3.b();
            } else {
                str = null;
            }
            if (!J2(str)) {
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
            pr0 pr0Var3 = this.R;
            if (pr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = pr0Var3.h().s();
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
                        boolean J3;
                        String str2;
                        J3 = NadRewardVideoActivity.this.J3();
                        if (J3) {
                            String str3 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).f.d;
                            String valueOf = String.valueOf(NadRewardVideoActivity.P1(NadRewardVideoActivity.this).j().c());
                            ms0 ms0Var = p3;
                            if (ms0Var != null) {
                                str2 = ms0Var.b();
                            } else {
                                str2 = null;
                            }
                            up0.i(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void b3() {
        if (this.D == null) {
            ip0 a2 = mp0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            View inflate = LayoutInflater.from(this).inflate(a2.e(), (ViewGroup) N2(), true);
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
            pr0 pr0Var = this.R;
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = pr0Var.h().s();
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, pr0Var2.h(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$1
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
                    yr0 c2;
                    String str;
                    NadRewardVideoActivity.this.e0 = true;
                    NadRewardVideoActivity.this.r3();
                    if (NadRewardVideoActivity.P1(NadRewardVideoActivity.this).q() && (c2 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).c()) != null && c2.l()) {
                        NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                        yr0 c3 = NadRewardVideoActivity.P1(nadRewardVideoActivity).c();
                        Long l2 = null;
                        if (c3 != null) {
                            str = c3.k();
                        } else {
                            str = null;
                        }
                        yr0 c4 = NadRewardVideoActivity.P1(NadRewardVideoActivity.this).c();
                        if (c4 != null) {
                            l2 = Long.valueOf(c4.m());
                        }
                        nadRewardVideoActivity.F3(true, str, l2);
                    }
                }
            });
        }
    }

    public final void i3() {
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        g81 a2 = g81.a(pr0Var.l());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.I == null) {
                this.I = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((m61.c.e(this) * 9) / 16) / 2) + m61.c.a(this, 26.0f);
                N2().addView(this.I, layoutParams);
            }
            NadIconTextButton nadIconTextButton = this.I;
            if (nadIconTextButton != null) {
                nadIconTextButton.update(a2);
                nadIconTextButton.setOnClickListener(new l(a2));
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

    public final void j3() {
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        f81 a2 = f81.a(pr0Var.m());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.H == null) {
                this.H = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((m61.c.e(this) * 9) / 16) / 2) + m61.c.a(this, 52.0f);
                layoutParams.setMarginStart(m61.c.a(this, 9.0f));
                layoutParams.setMarginEnd(m61.c.a(this, 8.0f));
                N2().addView(this.H, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.H;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(m61.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
                nadHighLightTextView.setAlpha(0.8f);
                nadHighLightTextView.setGravity(17);
                nadHighLightTextView.update(a2);
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

    public final void v3() {
        long j2;
        int i2;
        String d2;
        Integer intOrNull;
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ms0 p2 = pr0Var.h().p();
        if (p2 != null && p2.f() != null) {
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ms0 p3 = pr0Var2.h().p();
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
                pr0 pr0Var3 = this.R;
                if (pr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, pr0Var3.h(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
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
                        NadRewardVideoActivity.this.e0 = true;
                        NadRewardVideoActivity.this.r3();
                    }
                });
            }
        }
    }

    public static /* synthetic */ NadRewardVideoDialog D2(NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nadRewardVideoActivity.C2(str, z);
    }

    public static /* synthetic */ void G3(NadRewardVideoActivity nadRewardVideoActivity, boolean z, String str, Long l2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            l2 = 0L;
        }
        nadRewardVideoActivity.F3(z, str, l2);
    }

    public static /* synthetic */ void W2(NadRewardVideoActivity nadRewardVideoActivity, Context context, pr0 pr0Var, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        nadRewardVideoActivity.V2(context, pr0Var, z);
    }

    public static final /* synthetic */ pr0 P1(NadRewardVideoActivity nadRewardVideoActivity) {
        pr0 pr0Var = nadRewardVideoActivity.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return pr0Var;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void A1(Bundle bundle) {
        super.A1(bundle);
        setContentView(R.layout.nad_reward_video_lp_activity);
        N2().post(new q());
        this.Z = new Handler(Looper.getMainLooper());
        if (!s3()) {
            finish();
            return;
        }
        h3();
        X2();
    }

    public final void A3(boolean z) {
        int i2;
        ViewGroup.LayoutParams layoutParams = S2().getLayoutParams();
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            i2 = nadRewardBigCardView.getHeight();
        } else {
            i2 = 0;
        }
        if (z) {
            layoutParams.height = m61.c.c(this) - i2;
        } else {
            layoutParams.height = m61.c.a(this, 33.0f);
        }
        S2().setLayoutParams(layoutParams);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1(Intent intent) {
        super.C1(intent);
        setIntent(intent);
        if (!s3()) {
            o51.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
            return;
        }
        X2();
        D3();
    }

    public final boolean H2(pr0 pr0Var) {
        br0 br0Var;
        String str;
        fr0 fr0Var = pr0Var.m;
        if (fr0Var != null && (br0Var = fr0Var.p) != null && br0Var.e) {
            if (fr0Var != null && br0Var != null) {
                str = br0Var.a;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean I2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !pj0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new gj0(str).a(), "rewardWebPanel");
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean J1(Bundle bundle) {
        if (!super.J1(bundle)) {
            return false;
        }
        getWindow().setSoftInputMode(19);
        getWindow().setFormat(-3);
        requestWindowFeature(1);
        setEnableSliding(false);
        setCurrentActivityNoTransparent();
        return true;
    }

    public final boolean L3(String str) {
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
        this.K = C2;
        t3();
        return true;
    }

    public final boolean B2() {
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
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        yr0 c2 = pr0Var.c();
        if (c2 == null || !c2.b()) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1() {
        super.D1();
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        gu0 gu0Var = this.J;
        if (gu0Var != null) {
            gu0Var.pause();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void G1() {
        super.G1();
        if (q3()) {
            return;
        }
        y3();
    }

    public final void K2() {
        int a2 = u61.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.W = a2;
        u61.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
    }

    public final boolean M3() {
        ViewGroup view2;
        boolean z;
        fp0 fp0Var = this.E;
        if (fp0Var == null || (view2 = fp0Var.getView()) == null) {
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
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        yr0 c2 = pr0Var.c();
        if (c2 == null || !c2.s()) {
            return false;
        }
        return true;
    }

    public final void N3() {
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        up0.u(pr0Var, Q2());
        K2();
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        bj0.c(pr0Var2.f.m, this);
        K3();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.U int), ('_' char), (wrap: int : 0x000f: IGET  (r1v2 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.V int)] */
    public final String Q2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.U);
        sb.append('_');
        sb.append(this.V);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…d(rewardCount).toString()");
        return sb2;
    }

    public final void d3() {
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var.d() == null) {
            return;
        }
        final NadRewardFloatingLayerView O2 = O2();
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        O2.setData(pr0Var2);
        O2.setTriggerCallback(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initFloatingLayer$$inlined$apply$lambda$1
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
                if (!Intrinsics.areEqual(cmd, "__CONVERT_CMD__")) {
                    bj0.b(cmd);
                    return;
                }
                NadRewardVideoActivity nadRewardVideoActivity = this;
                Context context = NadRewardFloatingLayerView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                nadRewardVideoActivity.V2(context, NadRewardVideoActivity.P1(this), true);
            }
        });
        O2.setVisibility(0);
    }

    public final void f3() {
        if (this.Y == null) {
            this.Y = new NadRewardTaskHelper();
        }
        NadRewardTaskHelper nadRewardTaskHelper = this.Y;
        if (nadRewardTaskHelper != null) {
            pr0 pr0Var = this.R;
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(pr0Var);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        pr0 pr0Var = this.R;
        if (pr0Var != null) {
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            zr0 f2 = pr0Var.h().f();
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
                bj0.c(str, this);
            }
        }
        super.finish();
    }

    public final void g3() {
        NadRewardInterceptFrameLayout N2 = N2();
        boolean z = true;
        N2.setClickable(true);
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!pr0Var.o()) {
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (!pr0Var2.q()) {
                z = false;
            }
        }
        N2.setEnableIntercept(z);
        N2.setInterceptCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initRootView$$inlined$apply$lambda$1
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
                NadRewardVideoActivity.W2(nadRewardVideoActivity, nadRewardVideoActivity, NadRewardVideoActivity.P1(nadRewardVideoActivity), false, 4, null);
                up0.x(NadRewardVideoActivity.P1(NadRewardVideoActivity.this));
            }
        });
    }

    public final void h3() {
        int a2 = u61.a("nad_reward_sp", "key_session_count", 1);
        this.U = a2;
        u61.e("nad_reward_sp", "key_session_count", a2 + 1);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        D3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (o61.a() || C3()) {
            return;
        }
        super.onBackPressed();
    }

    public final void r3() {
        lp0 c2 = mp0.c();
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        c2.a(pr0Var, new is0(this.U, this.V), new r());
    }

    public final void t3() {
        gu0 gu0Var = this.J;
        if (gu0Var != null) {
            gu0Var.pause();
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
    }

    public final void w3() {
        en0.a().b(this, new s(ln0.class));
    }

    public final void x3() {
        this.e0 = false;
        this.d0 = false;
        this.S = null;
        this.a0 = false;
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.c();
        }
        L2().C();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r0 != true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y3() {
        ViewGroup view2;
        boolean z;
        y81 y81Var = this.F;
        if (y81Var == null || !y81Var.isShowing()) {
            fp0 fp0Var = this.E;
            if (fp0Var != null && (view2 = fp0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            gu0 gu0Var = this.J;
            if (gu0Var != null) {
                gu0Var.resume();
            }
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.b();
        }
    }

    public final void z3() {
        SimpleAdInfoView M2 = M2();
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (ni0.a(pr0Var.i)) {
            M2.setVisibility(0);
        } else {
            M2.setVisibility(8);
        }
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        M2.setAdInfo(pr0Var2.i);
    }

    public final NadRewardVideoDialog C2(final String str, final boolean z) {
        boolean z2;
        Integer num;
        String valueOf;
        boolean z3;
        final NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = pr0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.v2(str, str2);
        ap0 g2 = nadRewardVideoDialog.g2();
        boolean z4 = false;
        if (g2 != null) {
            if (z && !this.c0) {
                z3 = true;
            } else {
                z3 = false;
            }
            g2.L(z3);
        }
        ap0 g22 = nadRewardVideoDialog.g2();
        if (g22 != null) {
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            g22.K(pr0Var2.h().r());
        }
        ap0 g23 = nadRewardVideoDialog.g2();
        if (g23 != null) {
            pr0 pr0Var3 = this.R;
            if (pr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (pr0Var3.h().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                pr0 pr0Var4 = this.R;
                if (pr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = pr0Var4.h().i();
            } else {
                pr0 pr0Var5 = this.R;
                if (pr0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                os0 q2 = pr0Var5.h().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            g23.G(valueOf);
        }
        ap0 g24 = nadRewardVideoDialog.g2();
        if (g24 != null) {
            pr0 pr0Var6 = this.R;
            if (pr0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            as0 e2 = pr0Var6.e();
            if (e2 != null && e2.g()) {
                z4 = true;
            }
            g24.I(z4);
        }
        nadRewardVideoDialog.t2(new a(str, z));
        nadRewardVideoDialog.y2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.y3();
            }
        });
        nadRewardVideoDialog.r2(new b(str, z));
        nadRewardVideoDialog.u2(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4
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
                this.U2(NadRewardVideoDialog.this.getContext(), NadRewardVideoActivity.P1(this), str3);
                if (this.I2(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                }
            }
        });
        nadRewardVideoDialog.z2(new c(nadRewardVideoDialog, this, str, z));
        return nadRewardVideoDialog;
    }

    public final boolean C3() {
        O2().l();
        NadRewardTaskHelper nadRewardTaskHelper = this.Y;
        if (nadRewardTaskHelper != null && nadRewardTaskHelper.A()) {
            pr0 pr0Var = this.R;
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return L3(pr0Var.h().c());
        } else if (this.e0) {
            return I3();
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            AbsRewardCountDownView absRewardCountDownView = this.D;
            if (absRewardCountDownView != null) {
                return H3(timeUnit.toSeconds(absRewardCountDownView.getMillisUntilFinished()));
            }
            return false;
        }
    }

    public final void X2() {
        x3();
        g3();
        l3();
        Z2();
        b3();
        o3();
        n3();
        a3();
        j3();
        i3();
        k3();
        Y2();
        e3();
        d3();
        f3();
        N3();
        m3();
        c3();
    }

    public final void e3() {
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var.q()) {
            P2().setVisibility(0);
            NadRewardImageView P2 = P2();
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            P2.setData(pr0Var2);
            P2().setClickCallBack(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initImageStyle$1
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
                    NadRewardVideoActivity.W2(nadRewardVideoActivity, nadRewardVideoActivity, NadRewardVideoActivity.P1(nadRewardVideoActivity), false, 4, null);
                }
            });
            z3();
            return;
        }
        P2().setVisibility(8);
        M2().setVisibility(8);
    }

    public final boolean q3() {
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

    public final void D3() {
        String str;
        boolean z;
        String str2;
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        as0 e2 = pr0Var.e();
        Long l2 = null;
        if (e2 != null) {
            str = e2.e();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            y81 y81Var = this.F;
            if (y81Var != null) {
                y81Var.e();
            }
            this.F = null;
            return;
        }
        y81 y81Var2 = this.F;
        if (y81Var2 != null) {
            y81Var2.e();
        }
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        as0 e3 = pr0Var2.e();
        if (e3 != null) {
            str2 = e3.d();
        } else {
            str2 = null;
        }
        pr0 pr0Var3 = this.R;
        if (pr0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        as0 e4 = pr0Var3.e();
        if (e4 != null) {
            l2 = Long.valueOf(e4.a());
        }
        F3(true, str2, l2);
    }

    public final void G2() {
        boolean z;
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = pr0Var.e;
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
            u31.b(monitorUrl.clickUrl);
        }
    }

    public final boolean I3() {
        String str;
        boolean z;
        if (!this.c0) {
            return false;
        }
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        js0 h2 = pr0Var.h();
        bp0 bp0Var = this.S;
        if (bp0Var != null) {
            str = bp0Var.e();
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
        NadRewardVideoDialog D2 = D2(this, l2, false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        D2.show(supportFragmentManager, (String) null);
        this.M = D2;
        t3();
        return true;
    }

    public final void a3() {
        if (this.B == null) {
            ip0 a2 = mp0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            View inflate = LayoutInflater.from(this).inflate(a2.q(), (ViewGroup) N2(), true);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…youtId, flRootView, true)");
            this.B = (AdImageView) inflate.findViewById(R.id.reward_close_icon);
        }
        AdImageView adImageView = this.B;
        if (adImageView != null) {
            int a3 = m61.c.a(adImageView.getContext(), 10.0f);
            adImageView.setPadding(a3, a3, a3, a3);
            adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            adImageView.setOnClickListener(new i());
        }
    }

    public final void l3() {
        boolean z = true;
        if (this.C == null) {
            ip0 a2 = mp0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            this.C = (ImageView) LayoutInflater.from(this).inflate(a2.a(), (ViewGroup) N2(), true).findViewById(R.id.top_tag);
        }
        ImageView imageView = this.C;
        if (imageView != null) {
            pr0 pr0Var = this.R;
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            as0 e2 = pr0Var.e();
            if ((e2 == null || !e2.g()) ? false : false) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public final NadRewardLottieDialog E2(final String str) {
        w3();
        NadRewardLottieDialog nadRewardLottieDialog = new NadRewardLottieDialog();
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = pr0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.v2(str, str2);
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.K2(pr0Var2.h().k());
        nadRewardLottieDialog.t2(new d(str));
        nadRewardLottieDialog.y2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.y3();
            }
        });
        nadRewardLottieDialog.r2(new e(str));
        nadRewardLottieDialog.A2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildLottieDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.P1(NadRewardVideoActivity.this).j().e(true);
            }
        });
        return nadRewardLottieDialog;
    }

    public final boolean H3(long j2) {
        boolean z;
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var.h().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog D2 = D2(this, pr0Var2.h().n(j2), false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        D2.show(supportFragmentManager, (String) null);
        this.L = D2;
        t3();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
        if (r0 == true) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean E3() {
        String str;
        y81 y81Var;
        ViewGroup view2;
        boolean z;
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var.h().k() != null) {
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (pr0Var2.h().m() != null) {
                pr0 pr0Var3 = this.R;
                if (pr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ks0 m2 = pr0Var3.h().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !dt.a(this) && !q3() && ((y81Var = this.F) == null || !y81Var.isShowing())) {
                    fp0 fp0Var = this.E;
                    if (fp0Var != null && (view2 = fp0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    pr0 pr0Var4 = this.R;
                    if (pr0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    js0 h2 = pr0Var4.h();
                    pr0 pr0Var5 = this.R;
                    if (pr0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    cs0 k2 = pr0Var5.h().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    pr0 pr0Var6 = this.R;
                    if (pr0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    cs0 k3 = pr0Var6.h().k();
                    Intrinsics.checkNotNull(k3);
                    NadRewardLottieDialog E2 = E2(h2.j(c2, k3.a()));
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    E2.show(supportFragmentManager, (String) null);
                    this.O = E2;
                    t3();
                    return true;
                }
            }
        }
        return false;
    }

    public final void Y2() {
        String f2;
        Integer intOrNull;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        int i2 = 0;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(false);
        }
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var.b() == null) {
            this.P = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(pr0Var2);
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
                AdImageView adImageView = NadRewardVideoActivity.this.B;
                if (adImageView != null) {
                    ExtensionsKt.f(adImageView, z);
                }
                TextView textView = NadRewardVideoActivity.this.f0;
                if (textView != null) {
                    ExtensionsKt.f(textView, z);
                }
                gu0 gu0Var = NadRewardVideoActivity.this.J;
                if (gu0Var != null) {
                    gu0Var.pause();
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
                AdImageView adImageView = NadRewardVideoActivity.this.B;
                if (adImageView != null) {
                    ExtensionsKt.f(adImageView, true);
                }
                TextView textView = NadRewardVideoActivity.this.f0;
                if (textView != null) {
                    ExtensionsKt.f(textView, true);
                }
                AdImageView adImageView2 = NadRewardVideoActivity.this.B;
                if (adImageView2 != null) {
                    adImageView2.bringToFront();
                }
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.bringToFront();
                }
                TextView textView2 = NadRewardVideoActivity.this.f0;
                if (textView2 != null) {
                    textView2.bringToFront();
                }
                gu0 gu0Var = NadRewardVideoActivity.this.J;
                if (gu0Var != null) {
                    gu0Var.resume();
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
                NadRewardVideoActivity.this.O3(f3);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.P = nadRewardBigCardView2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = -m61.c.c(this);
        N2().addView(this.P, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.P;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.P;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        pr0 pr0Var3 = this.R;
        if (pr0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = pr0Var3.h().s();
        pr0 pr0Var4 = this.R;
        if (pr0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        xr0 b2 = pr0Var4.b();
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
                    NadRewardVideoActivity.this.B3();
                }
            });
        }
    }

    public final void Z2() {
        int a2;
        ip0 a3 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        boolean z = true;
        View inflate = LayoutInflater.from(this).inflate(a3.v(), (ViewGroup) N2(), true);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…youtId, flRootView, true)");
        AdImageView adImageView = (AdImageView) inflate.findViewById(R.id.reward_arrow);
        this.z = adImageView;
        if (adImageView != null) {
            adImageView.setImageResource(R.drawable.nad_reward_up_arrow);
        }
        AdImageView adImageView2 = this.z;
        if (adImageView2 != null) {
            pr0 pr0Var = this.R;
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            yr0 c2 = pr0Var.c();
            if (c2 == null || !c2.e()) {
                pr0 pr0Var2 = this.R;
                if (pr0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (!pr0Var2.q()) {
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
                    pr0 pr0Var3 = this.R;
                    if (pr0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (pr0Var3.q()) {
                        a2 = m61.c.a(adImageView2.getContext(), 23.0f);
                    } else {
                        a2 = m61.c.a(adImageView2.getContext(), 4.0f);
                    }
                    layoutParams2.bottomMargin = a2;
                    adImageView2.setOnClickListener(new h(adImageView2, this));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
    }

    public final void m3() {
        String str;
        String str2;
        String str3;
        if (this.f0 == null) {
            ip0 a2 = mp0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            this.f0 = (TextView) LayoutInflater.from(this).inflate(a2.o(), (ViewGroup) N2(), true).findViewById(R.id.top_tag_text);
        }
        TextView textView = this.f0;
        if (textView != null) {
            pr0 pr0Var = this.R;
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            or0 n2 = pr0Var.n();
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
                pr0 pr0Var2 = this.R;
                if (pr0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                or0 n3 = pr0Var2.n();
                if (n3 != null) {
                    str2 = n3.b();
                } else {
                    str2 = null;
                }
                textView.setText(str2);
                pr0 pr0Var3 = this.R;
                if (pr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                or0 n4 = pr0Var3.n();
                if (n4 != null) {
                    str3 = n4.c();
                } else {
                    str3 = null;
                }
                textView.setTextColor(Color.parseColor(str3));
                pr0 pr0Var4 = this.R;
                if (pr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                or0 n5 = pr0Var4.n();
                if (n5 != null) {
                    str4 = n5.a();
                }
                textView.setBackgroundColor(Color.parseColor(str4));
            }
        }
    }

    public final NadRewardSuspendDialog F2(final String str) {
        String str2;
        String str3;
        NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = pr0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.v2(str, str4);
        ap0 g2 = nadRewardSuspendDialog.g2();
        String str5 = null;
        if (g2 != null) {
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ms0 p2 = pr0Var2.h().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            g2.F(str3);
        }
        ap0 g22 = nadRewardSuspendDialog.g2();
        if (g22 != null) {
            pr0 pr0Var3 = this.R;
            if (pr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ms0 p3 = pr0Var3.h().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            g22.J(str2);
        }
        ap0 g23 = nadRewardSuspendDialog.g2();
        if (g23 != null) {
            pr0 pr0Var4 = this.R;
            if (pr0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ms0 p4 = pr0Var4.h().p();
            if (p4 != null) {
                str5 = p4.g();
            }
            g23.M(str5);
        }
        nadRewardSuspendDialog.t2(new f(str));
        nadRewardSuspendDialog.y2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$2
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
                NadRewardVideoActivity.this.y3();
            }
        });
        nadRewardSuspendDialog.r2(new g(str));
        nadRewardSuspendDialog.B2(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$buildSuspendDialog$$inlined$apply$lambda$4
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
                NadRewardVideoActivity.this.v3();
            }
        });
        return nadRewardSuspendDialog;
    }

    public final void F3(boolean z, String str, Long l2) {
        boolean z2;
        long j2;
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var.f().length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.F = null;
            return;
        }
        y81 y81Var = this.F;
        if (y81Var != null && y81Var.isShowing()) {
            return;
        }
        if (z) {
            Handler handler = this.Z;
            if (handler != null) {
                Runnable runnable = this.b0;
                if (l2 != null) {
                    j2 = l2.longValue();
                } else {
                    j2 = 0;
                }
                handler.postDelayed(runnable, j2);
            }
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (pr0Var2.q()) {
                pr0 pr0Var3 = this.R;
                if (pr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                up0.y(pr0Var3);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ip0 a2 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        y81 y81Var2 = new y81(this, a2.x());
        y81Var2.setOnDismissListener(new u(z, currentTimeMillis, str));
        y81Var2.i(new v(z, currentTimeMillis, str));
        Resources resources = getResources();
        ip0 a3 = mp0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        double dimension = 1 - (resources.getDimension(a3.s()) / m61.c.c(this));
        pr0 pr0Var4 = this.R;
        if (pr0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String f2 = pr0Var4.f();
        pr0 pr0Var5 = this.R;
        if (pr0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        g91 g91Var = new g91(f2, dimension, 0, pr0Var5.f.d);
        g91Var.J(true);
        g91Var.I(false);
        g91Var.M(true);
        g91Var.L(!z);
        g91Var.A(z);
        g91Var.B(z);
        g91Var.C(true);
        pr0 pr0Var6 = this.R;
        if (pr0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!TextUtils.isEmpty(pr0Var6.f.m)) {
            pr0 pr0Var7 = this.R;
            if (pr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            g91Var.z(pr0Var7.f.l);
        }
        Unit unit = Unit.INSTANCE;
        y81Var2.h(g91Var);
        y81Var2.j();
        Unit unit2 = Unit.INSTANCE;
        this.F = y81Var2;
        gu0 gu0Var = this.J;
        if (gu0Var != null) {
            gu0Var.pause();
        }
        AdImageView adImageView = this.B;
        if (adImageView != null) {
            ExtensionsKt.f(adImageView, false);
        }
        TextView textView = this.f0;
        if (textView != null) {
            ExtensionsKt.f(textView, false);
        }
        pr0 pr0Var8 = this.R;
        if (pr0Var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        pr0Var8.j().f(true);
        O2().l();
    }

    public final boolean J2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null).contains(String.valueOf(this.W))) {
            return false;
        }
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        pr0Var.j().g(this.W);
        return true;
    }

    public final void O3(float f2) {
        float f3;
        boolean z;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            f3 = nadRewardBigCardView.getHeight();
        } else {
            f3 = 0.0f;
        }
        float e2 = ((m61.c.e(this) / m61.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        sr0 sr0Var = pr0Var.j;
        if (sr0Var != null) {
            if (sr0Var.f > 0.0f) {
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
        T2().setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        layoutParams2.bottomMargin = (int) ((f2 - 1) * f3);
        NadRewardBigCardView nadRewardBigCardView2 = this.P;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.setLayoutParams(layoutParams2);
        }
    }

    public final void U2(Context context, pr0 pr0Var, String str) {
        String str2;
        String str3;
        br0 br0Var;
        br0 br0Var2;
        br0 br0Var3;
        boolean z = true;
        if (pr0Var.p() && H2(pr0Var)) {
            fr0 fr0Var = pr0Var.m;
            String str4 = null;
            if (fr0Var != null && (br0Var3 = fr0Var.p) != null) {
                str2 = br0Var3.a;
            } else {
                str2 = null;
            }
            if (b61.d(str2)) {
                fr0 fr0Var2 = pr0Var.m;
                if (fr0Var2 != null && (br0Var2 = fr0Var2.p) != null) {
                    str3 = br0Var2.b;
                } else {
                    str3 = null;
                }
                if (str3 != null && str3.length() != 0) {
                    z = false;
                }
                if (!z) {
                    bj0.b(str3);
                    return;
                } else if (context != null) {
                    fr0 fr0Var3 = pr0Var.m;
                    if (fr0Var3 != null && (br0Var = fr0Var3.p) != null) {
                        str4 = br0Var.a;
                    }
                    Intrinsics.checkNotNull(str4);
                    oj0.b(context, str4);
                    return;
                } else {
                    return;
                }
            }
        }
        if (I2(str)) {
            y81 y81Var = this.F;
            if ((y81Var == null || !y81Var.isShowing()) && !M3() && !B2()) {
                G3(this, false, null, null, 6, null);
                return;
            }
            return;
        }
        if (pr0Var.p()) {
            str = b61.b(pr0Var, pr0Var.g());
        }
        bj0.b(str);
    }

    public final void V2(Context context, pr0 pr0Var, boolean z) {
        String str;
        String str2;
        boolean z2;
        br0 br0Var;
        br0 br0Var2;
        br0 br0Var3;
        if (pr0Var.p()) {
            if (H2(pr0Var)) {
                fr0 fr0Var = pr0Var.m;
                String str3 = null;
                if (fr0Var != null && (br0Var3 = fr0Var.p) != null) {
                    str = br0Var3.a;
                } else {
                    str = null;
                }
                if (b61.d(str)) {
                    fr0 fr0Var2 = pr0Var.m;
                    if (fr0Var2 != null && (br0Var2 = fr0Var2.p) != null) {
                        str2 = br0Var2.b;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        bj0.b(str2);
                        return;
                    }
                    fr0 fr0Var3 = pr0Var.m;
                    if (fr0Var3 != null && (br0Var = fr0Var3.p) != null) {
                        str3 = br0Var.a;
                    }
                    Intrinsics.checkNotNull(str3);
                    oj0.b(context, str3);
                    return;
                }
            }
            if (z) {
                G3(this, false, null, null, 6, null);
            } else {
                bj0.b(b61.b(pr0Var, pr0Var.g()));
            }
        } else if (I2(pr0Var.f.c)) {
            G3(this, false, null, null, 6, null);
        } else {
            bj0.b(pr0Var.f.c);
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
    public final void c3() {
        View view2;
        ViewParent viewParent;
        int a2;
        gp0 gp0Var;
        ViewParent viewParent2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ViewParent viewParent3;
        gp0 gp0Var2;
        gp0 gp0Var3;
        View view3;
        ViewParent viewParent4;
        View view4;
        View view5;
        View view6;
        boolean z;
        ViewParent viewParent5;
        N2().removeViewInLayout(this.i0);
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var.i() == null) {
            return;
        }
        gp0 gp0Var4 = (gp0) ServiceManager.getService(gp0.a);
        this.g0 = gp0Var4;
        if (gp0Var4 == null) {
            return;
        }
        if (gp0Var4 != null) {
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            gp0Var4.b(pr0Var2, this);
        }
        gp0 gp0Var5 = this.g0;
        ViewParent viewParent6 = null;
        if (gp0Var5 != null) {
            view2 = gp0Var5.getView();
        } else {
            view2 = null;
        }
        if (view2 == null) {
            return;
        }
        NadRewardFestivalContainer nadRewardFestivalContainer = new NadRewardFestivalContainer(this);
        pr0 pr0Var3 = this.R;
        if (pr0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardFestivalContainer.setData(pr0Var3);
        nadRewardFestivalContainer.setVisibility(4);
        nadRewardFestivalContainer.setContainer(L2());
        nadRewardFestivalContainer.setFestivalClickCallback(new j(nadRewardFestivalContainer, this));
        Unit unit = Unit.INSTANCE;
        this.h0 = nadRewardFestivalContainer;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = m61.c.a(this, 10.0f);
        NadRewardFestivalContainer nadRewardFestivalContainer2 = this.h0;
        if (nadRewardFestivalContainer2 != null) {
            viewParent = nadRewardFestivalContainer2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            NadRewardFestivalContainer nadRewardFestivalContainer3 = this.h0;
            if (nadRewardFestivalContainer3 != null) {
                viewParent5 = nadRewardFestivalContainer3.getParent();
            } else {
                viewParent5 = null;
            }
            if (viewParent5 != null) {
                ((ViewGroup) viewParent5).removeView(this.h0);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        LinearLayout linearLayout3 = this.i0;
        if (linearLayout3 == null) {
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.removeAllViews();
            linearLayout4.setOrientation(1);
            linearLayout4.addView(this.h0, layoutParams);
            Unit unit2 = Unit.INSTANCE;
            this.i0 = linearLayout4;
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
                a2 = m61.c.a(this, 30.0f);
                layoutParams2.bottomMargin = a2;
                gp0Var = this.g0;
                if (gp0Var == null && (view6 = gp0Var.getView()) != null) {
                    viewParent2 = view6.getParent();
                } else {
                    viewParent2 = null;
                }
                if (viewParent2 instanceof ViewGroup) {
                    gp0 gp0Var6 = this.g0;
                    if (gp0Var6 != null && (view5 = gp0Var6.getView()) != null) {
                        viewParent4 = view5.getParent();
                    } else {
                        viewParent4 = null;
                    }
                    if (viewParent4 != null) {
                        ViewGroup viewGroup = (ViewGroup) viewParent4;
                        gp0 gp0Var7 = this.g0;
                        if (gp0Var7 != null) {
                            view4 = gp0Var7.getView();
                        } else {
                            view4 = null;
                        }
                        viewGroup.removeView(view4);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                }
                linearLayout = this.i0;
                if (linearLayout != null) {
                    gp0 gp0Var8 = this.g0;
                    if (gp0Var8 != null) {
                        view3 = gp0Var8.getView();
                    } else {
                        view3 = null;
                    }
                    linearLayout.addView(view3, layoutParams2);
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = BadgeDrawable.BOTTOM_START;
                linearLayout2 = this.i0;
                if (linearLayout2 == null) {
                    viewParent3 = linearLayout2.getParent();
                } else {
                    viewParent3 = null;
                }
                if (viewParent3 instanceof ViewGroup) {
                    LinearLayout linearLayout5 = this.i0;
                    if (linearLayout5 != null) {
                        viewParent6 = linearLayout5.getParent();
                    }
                    if (viewParent6 != null) {
                        ((ViewGroup) viewParent6).removeView(this.i0);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                }
                N2().addView(this.i0, layoutParams3);
                gp0Var2 = this.g0;
                if (gp0Var2 != null) {
                    gp0Var2.a(new k());
                }
                gp0Var3 = this.g0;
                if (gp0Var3 == null) {
                    gp0Var3.show();
                    return;
                }
                return;
            }
        }
        a2 = m61.c.a(this, 7.0f);
        layoutParams2.bottomMargin = a2;
        gp0Var = this.g0;
        if (gp0Var == null) {
        }
        viewParent2 = null;
        if (viewParent2 instanceof ViewGroup) {
        }
        linearLayout = this.i0;
        if (linearLayout != null) {
        }
        FrameLayout.LayoutParams layoutParams32 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams32.gravity = BadgeDrawable.BOTTOM_START;
        linearLayout2 = this.i0;
        if (linearLayout2 == null) {
        }
        if (viewParent3 instanceof ViewGroup) {
        }
        N2().addView(this.i0, layoutParams32);
        gp0Var2 = this.g0;
        if (gp0Var2 != null) {
        }
        gp0Var3 = this.g0;
        if (gp0Var3 == null) {
        }
    }

    public final void k3() {
        ur0 ur0Var;
        ur0 ur0Var2;
        String str;
        ur0 ur0Var3;
        String str2;
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        sr0 sr0Var = pr0Var.j;
        NadRewardHalfTailHolder nadRewardHalfTailHolder = null;
        if (sr0Var != null) {
            ur0Var = sr0Var.i;
        } else {
            ur0Var = null;
        }
        if (ur0Var != null) {
            pr0 pr0Var2 = this.R;
            if (pr0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            yr0 c2 = pr0Var2.c();
            if (c2 == null || c2.q()) {
                pr0 pr0Var3 = this.R;
                if (pr0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                sr0 sr0Var2 = pr0Var3.j;
                if (sr0Var2 != null && (ur0Var2 = sr0Var2.i) != null) {
                    pr0 pr0Var4 = this.R;
                    if (pr0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    sr0 sr0Var3 = pr0Var4.j;
                    if (sr0Var3 != null && (ur0Var3 = sr0Var3.i) != null && (str2 = ur0Var3.x) != null) {
                        bp0 bp0Var = this.S;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (bp0Var == null || (r4 = bp0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    ur0Var2.x = str;
                }
                fp0 fp0Var = this.E;
                if (fp0Var != null) {
                    fp0Var.setVisibility(false);
                }
                fp0.a aVar = fp0.k0;
                pr0 pr0Var5 = this.R;
                if (pr0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fp0 a2 = aVar.a(pr0Var5, this);
                this.E = a2;
                if (a2 != null) {
                    pr0 pr0Var6 = this.R;
                    if (pr0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(pr0Var6);
                }
                fp0 fp0Var2 = this.E;
                if (!(fp0Var2 instanceof View)) {
                    fp0Var2 = null;
                }
                View view2 = (View) fp0Var2;
                if (view2 != null) {
                    R2().removeAllViews();
                    R2().addView(view2);
                    R2().bringToFront();
                }
                fp0 fp0Var3 = this.E;
                if (fp0Var3 != null) {
                    fp0Var3.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
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
                            fp0 fp0Var4 = NadRewardVideoActivity.this.E;
                            if (fp0Var4 != null) {
                                fp0Var4.setVisibility(false);
                            }
                            gu0 gu0Var = NadRewardVideoActivity.this.J;
                            if (gu0Var != null) {
                                gu0Var.start();
                            }
                        }
                    });
                }
                fp0 fp0Var4 = this.E;
                if (fp0Var4 instanceof NadRewardHalfTailHolder) {
                    nadRewardHalfTailHolder = fp0Var4;
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
                            AdImageView adImageView = NadRewardVideoActivity.this.B;
                            if (adImageView != null) {
                                ExtensionsKt.f(adImageView, z);
                            }
                            TextView textView = NadRewardVideoActivity.this.f0;
                            if (textView != null) {
                                ExtensionsKt.f(textView, z);
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
                            AdImageView adImageView = NadRewardVideoActivity.this.B;
                            if (adImageView != null) {
                                ExtensionsKt.f(adImageView, true);
                            }
                            AdImageView adImageView2 = NadRewardVideoActivity.this.B;
                            if (adImageView2 != null) {
                                adImageView2.bringToFront();
                            }
                            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
                            if (absRewardCountDownView != null) {
                                absRewardCountDownView.bringToFront();
                            }
                            TextView textView = NadRewardVideoActivity.this.f0;
                            if (textView != null) {
                                ExtensionsKt.f(textView, true);
                            }
                            TextView textView2 = NadRewardVideoActivity.this.f0;
                            if (textView2 != null) {
                                textView2.bringToFront();
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
        fp0 fp0Var5 = this.E;
        if (fp0Var5 != null) {
            fp0Var5.setVisibility(false);
        }
    }

    public final void n3() {
        er0 er0Var;
        int i2;
        ur0 ur0Var;
        NadRewardVideoAdOverContainer L2 = L2();
        pr0 pr0Var = this.R;
        if (pr0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var.e() != null) {
            L2.setVisibility(8);
            return;
        }
        L2.setVisibility(0);
        L2.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var2.h().C()) {
            pr0 pr0Var3 = this.R;
            if (pr0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = pr0Var3.f.c;
            Context context = L2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (p3(str, context)) {
                pr0 pr0Var4 = this.R;
                if (pr0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fr0 fr0Var = pr0Var4.m;
                if (fr0Var != null) {
                    fr0Var.g = true;
                }
                pr0 pr0Var5 = this.R;
                if (pr0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                sr0 sr0Var = pr0Var5.j;
                if (sr0Var != null && (ur0Var = sr0Var.i) != null) {
                    ur0Var.C = true;
                }
            }
        }
        pr0 pr0Var6 = this.R;
        if (pr0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var6.e() != null) {
            pr0 pr0Var7 = this.R;
            if (pr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fr0 fr0Var2 = pr0Var7.m;
            if (fr0Var2 != null) {
                fr0Var2.e = true;
            }
            pr0 pr0Var8 = this.R;
            if (pr0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fr0 fr0Var3 = pr0Var8.m;
            if (fr0Var3 != null) {
                pr0 pr0Var9 = this.R;
                if (pr0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (pr0Var9.p()) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                fr0Var3.a = i2;
            }
            pr0 pr0Var10 = this.R;
            if (pr0Var10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fr0 fr0Var4 = pr0Var10.m;
            if (fr0Var4 != null) {
                pr0 pr0Var11 = this.R;
                if (pr0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                as0 e2 = pr0Var11.e();
                Intrinsics.checkNotNull(e2);
                fr0Var4.p = e2.b();
            }
            pr0 pr0Var12 = this.R;
            if (pr0Var12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            fr0 fr0Var5 = pr0Var12.m;
            if (fr0Var5 != null && (er0Var = fr0Var5.q) != null) {
                pr0 pr0Var13 = this.R;
                if (pr0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                er0Var.d = pr0Var13.f.d;
            }
        }
        pr0 pr0Var14 = this.R;
        if (pr0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        L2.setData(pr0Var14);
        pr0 pr0Var15 = this.R;
        if (pr0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (pr0Var15.o()) {
            L2.setBottomLineHeight(m61.c.a(L2.getContext(), 33.0f));
        } else {
            L2.setBottomLineHeight(m61.c.a(L2.getContext(), 10.0f));
        }
        L2.setOnUiClickListener(new m(L2, this));
        L2.setFeedbackBtnVisibility(false);
        L2.setFestivalClickCallback(new n(L2, this));
    }

    public final void o3() {
        boolean z;
        JSONObject put;
        hu0 hu0Var = new hu0();
        hu0Var.a = 2;
        boolean z2 = false;
        if (this.J == null) {
            this.J = gu0.a.b(this, 0, hu0Var);
        }
        gu0 gu0Var = this.J;
        if (gu0Var != null) {
            gu0Var.attachToContainer(T2());
            p pVar = new p();
            pVar.n(true);
            gu0Var.d(pVar);
            pr0 pr0Var = this.R;
            if (pr0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            sr0 sr0Var = pr0Var.j;
            if (sr0Var != null && sr0Var.g) {
                gu0Var.setVideoScalingMode(0);
            } else {
                gu0Var.setVideoScalingMode(2);
            }
            gu0Var.a(new o());
        }
        FrameLayout T2 = T2();
        T2.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = 0;
        T2.setLayoutParams(layoutParams);
        pr0 pr0Var2 = this.R;
        if (pr0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        JSONObject jSONObject = null;
        if (pr0Var2.j == null) {
            T2().setVisibility(8);
            this.J = null;
            return;
        }
        pr0 pr0Var3 = this.R;
        if (pr0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        sr0 sr0Var2 = pr0Var3.j;
        Intrinsics.checkNotNull(sr0Var2);
        String str = sr0Var2.j;
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
                    pr0 pr0Var4 = this.R;
                    if (pr0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    jSONObject = put.put("ad_extra_param", pr0Var4.f.d);
                }
                jSONObject2.putOpt(BasicVideoParserKt.EXT_LOG, String.valueOf(jSONObject));
                pr0 pr0Var5 = this.R;
                if (pr0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                sr0 sr0Var3 = pr0Var5.j;
                Intrinsics.checkNotNull(sr0Var3);
                sr0Var3.j = jSONObject2.toString();
            } catch (Exception unused) {
            }
        }
        gu0 gu0Var2 = this.J;
        if (gu0Var2 != null) {
            pr0 pr0Var6 = this.R;
            if (pr0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            sr0 sr0Var4 = pr0Var6.j;
            Intrinsics.checkNotNull(sr0Var4);
            gu0Var2.c(sr0Var4);
        }
        if (NetUtil.a(this)) {
            pr0 pr0Var7 = this.R;
            if (pr0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            yr0 c2 = pr0Var7.c();
            if (c2 != null) {
                z2 = c2.q();
            }
            gu0 gu0Var3 = this.J;
            if (gu0Var3 != null) {
                gu0Var3.setLooping(!z2);
            }
            gu0 gu0Var4 = this.J;
            if (gu0Var4 != null) {
                gu0Var4.start();
                return;
            }
            return;
        }
        o51.a().a(this, R.string.nad_reward_video_lp_no_network);
    }

    public final boolean p3(String str, Context context) {
        Object m849constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new gj0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m849constructorimpl = Result.m849constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m849constructorimpl = Result.m849constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m855isFailureimpl(m849constructorimpl)) {
            m849constructorimpl = null;
        }
        String str3 = (String) m849constructorimpl;
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
    public final boolean s3() {
        Object m849constructorimpl;
        ur0 ur0Var;
        String str;
        ur0 ur0Var2;
        Boolean bool;
        boolean z;
        String d2;
        String str2;
        String replace$default;
        String str3;
        String d3;
        ur0 ur0Var3;
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
            m849constructorimpl = Result.m849constructorimpl(ResultKt.createFailure(th));
        }
        if (serializable != null) {
            m849constructorimpl = Result.m849constructorimpl(tp0.a.d((HashMap) serializable));
            if (Result.m856isSuccessimpl(m849constructorimpl)) {
                pr0 pr0Var = (pr0) m849constructorimpl;
                this.R = pr0Var;
                if (pr0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                sr0 sr0Var = pr0Var.j;
                String str7 = "";
                if (sr0Var != null && (ur0Var3 = sr0Var.i) != null) {
                    pr0 pr0Var2 = this.R;
                    if (pr0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (pr0Var2.p()) {
                        String str8 = ur0Var3.f;
                        if (str8 != null) {
                            pr0 pr0Var3 = this.R;
                            if (pr0Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str8, "__CONVERT_CMD__", pr0Var3.g(), false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        ur0Var3.f = replace$default2;
                    } else {
                        String str9 = ur0Var3.f;
                        if (str9 != null) {
                            pr0 pr0Var4 = this.R;
                            if (pr0Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            fr0 fr0Var = pr0Var4.m;
                            if (fr0Var == null || (str5 = fr0Var.t) == null) {
                                str4 = "";
                            } else {
                                str4 = str5;
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str9, "__CONVERT_CMD__", str4, false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        ur0Var3.f = replace$default2;
                    }
                }
                pr0 pr0Var5 = this.R;
                if (pr0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                xr0 b2 = pr0Var5.b();
                if (b2 != null) {
                    pr0 pr0Var6 = this.R;
                    if (pr0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (pr0Var6.p()) {
                        pr0 pr0Var7 = this.R;
                        if (pr0Var7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        xr0 b3 = pr0Var7.b();
                        if (b3 != null && (d3 = b3.d()) != null) {
                            pr0 pr0Var8 = this.R;
                            if (pr0Var8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d3, "__CONVERT_CMD__", pr0Var8.g(), false, 4, (Object) null);
                        }
                        b2.h(str7);
                    } else {
                        pr0 pr0Var9 = this.R;
                        if (pr0Var9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        xr0 b4 = pr0Var9.b();
                        if (b4 != null && (d2 = b4.d()) != null) {
                            pr0 pr0Var10 = this.R;
                            if (pr0Var10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            fr0 fr0Var2 = pr0Var10.m;
                            if (fr0Var2 == null || (str3 = fr0Var2.t) == null) {
                                str2 = "";
                            } else {
                                str2 = str3;
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d2, "__CONVERT_CMD__", str2, false, 4, (Object) null);
                        }
                        b2.h(str7);
                    }
                }
                pr0 pr0Var11 = this.R;
                if (pr0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fr0 fr0Var3 = pr0Var11.m;
                boolean z2 = true;
                if (fr0Var3 != null) {
                    fr0Var3.d = true;
                }
                pr0 pr0Var12 = this.R;
                if (pr0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fr0 fr0Var4 = pr0Var12.m;
                if (fr0Var4 != null) {
                    pr0 pr0Var13 = this.R;
                    if (pr0Var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    yr0 c2 = pr0Var13.c();
                    if (c2 != null) {
                        z = c2.f();
                    } else {
                        z = false;
                    }
                    fr0Var4.f = z;
                }
                pr0 pr0Var14 = this.R;
                if (pr0Var14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                sr0 sr0Var2 = pr0Var14.j;
                if (sr0Var2 != null && (ur0Var2 = sr0Var2.i) != null) {
                    pr0 pr0Var15 = this.R;
                    if (pr0Var15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    yr0 c3 = pr0Var15.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.s());
                    } else {
                        bool = null;
                    }
                    ur0Var2.D = bool;
                }
                pr0 pr0Var16 = this.R;
                if (pr0Var16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                sr0 sr0Var3 = pr0Var16.j;
                if (sr0Var3 != null && (ur0Var = sr0Var3.i) != null) {
                    pr0 pr0Var17 = this.R;
                    if (pr0Var17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    yr0 c4 = pr0Var17.c();
                    if (c4 != null) {
                        str = c4.r();
                    } else {
                        str = null;
                    }
                    ur0Var.E = str;
                }
                wo0 wo0Var = (wo0) ServiceManager.getService(wo0.a);
                pr0 pr0Var18 = this.R;
                if (pr0Var18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (pr0Var18.h().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && wo0Var != null) {
                    pr0 pr0Var19 = this.R;
                    if (pr0Var19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    js0 h2 = pr0Var19.h();
                    String a2 = wo0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    h2.F(a2);
                }
                pr0 pr0Var20 = this.R;
                if (pr0Var20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                fr0 fr0Var5 = pr0Var20.m;
                if (fr0Var5 != null) {
                    pr0 pr0Var21 = this.R;
                    if (pr0Var21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = pr0Var21.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    fr0Var5.h = list;
                }
                pr0 pr0Var22 = this.R;
                if (pr0Var22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                zr0 f2 = pr0Var22.h().f();
                if (f2 != null) {
                    str6 = f2.c();
                }
                this.c0 = Intrinsics.areEqual(str6, "0");
            }
            Throwable m852exceptionOrNullimpl = Result.m852exceptionOrNullimpl(m849constructorimpl);
            if (m852exceptionOrNullimpl != null && bh0.a) {
                o51.a().showToast(this, m852exceptionOrNullimpl.getMessage());
            }
            return Result.m856isSuccessimpl(m849constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final void u3(String str, String str2, HashMap<String, String> hashMap) {
        cp0 cp0Var = new cp0();
        cp0Var.a = str;
        cp0Var.b = hashMap;
        en0.a().a(cp0Var);
    }
}
