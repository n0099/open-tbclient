package com.baidu.nadcore.lp.reward;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.baidu.tieba.ai0;
import com.baidu.tieba.ak0;
import com.baidu.tieba.aq0;
import com.baidu.tieba.as0;
import com.baidu.tieba.av0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.bs0;
import com.baidu.tieba.bu;
import com.baidu.tieba.bv0;
import com.baidu.tieba.ct0;
import com.baidu.tieba.do0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.dt0;
import com.baidu.tieba.e71;
import com.baidu.tieba.et0;
import com.baidu.tieba.ev0;
import com.baidu.tieba.fk0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.g61;
import com.baidu.tieba.g71;
import com.baidu.tieba.gt0;
import com.baidu.tieba.ho0;
import com.baidu.tieba.iq0;
import com.baidu.tieba.it0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.js0;
import com.baidu.tieba.k21;
import com.baidu.tieba.ko0;
import com.baidu.tieba.m71;
import com.baidu.tieba.me1;
import com.baidu.tieba.mj0;
import com.baidu.tieba.ms0;
import com.baidu.tieba.nk0;
import com.baidu.tieba.o41;
import com.baidu.tieba.ok0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.os0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.q91;
import com.baidu.tieba.qi0;
import com.baidu.tieba.qq0;
import com.baidu.tieba.rs0;
import com.baidu.tieba.ss0;
import com.baidu.tieba.t61;
import com.baidu.tieba.ts0;
import com.baidu.tieba.us0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.ws0;
import com.baidu.tieba.x81;
import com.baidu.tieba.x91;
import com.baidu.tieba.xr0;
import com.baidu.tieba.y81;
import com.baidu.tieba.y91;
import com.baidu.tieba.zp0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\bÛ\u0001\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001f\u0010\u0015J\u000f\u0010 \u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010\u0015J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\"J+\u0010&\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b&\u0010'J)\u0010)\u001a\u00020\u00132\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0013¢\u0006\u0004\b+\u0010\u0015J\u000f\u0010,\u001a\u00020\u0013H\u0002¢\u0006\u0004\b,\u0010\u0015J\u000f\u0010-\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010\u0015J\u000f\u0010.\u001a\u00020\u0013H\u0002¢\u0006\u0004\b.\u0010\u0015J\u000f\u0010/\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u0010\u0015J\u000f\u00100\u001a\u00020\u0013H\u0002¢\u0006\u0004\b0\u0010\u0015J\u000f\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b1\u0010\u0015J\u000f\u00102\u001a\u00020\u0013H\u0002¢\u0006\u0004\b2\u0010\u0015J\u000f\u00103\u001a\u00020\u0013H\u0002¢\u0006\u0004\b3\u0010\u0015J\u000f\u00104\u001a\u00020\u0013H\u0002¢\u0006\u0004\b4\u0010\u0015J\u000f\u00105\u001a\u00020\u0013H\u0002¢\u0006\u0004\b5\u0010\u0015J\u000f\u00106\u001a\u00020\u0013H\u0002¢\u0006\u0004\b6\u0010\u0015J\u000f\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0004\b7\u0010\u0015J\u000f\u00108\u001a\u00020\u0013H\u0002¢\u0006\u0004\b8\u0010\u0015J\u000f\u00109\u001a\u00020\u0013H\u0002¢\u0006\u0004\b9\u0010\u0015J\u000f\u0010:\u001a\u00020\u0013H\u0002¢\u0006\u0004\b:\u0010\u0015J!\u0010;\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0002H\u0002¢\u0006\u0004\b=\u0010\u0004J\u000f\u0010>\u001a\u00020\u0013H\u0016¢\u0006\u0004\b>\u0010\u0015J\u000f\u0010?\u001a\u00020\u0013H\u0016¢\u0006\u0004\b?\u0010\u0015J\u0019\u0010B\u001a\u00020\u00132\b\u0010A\u001a\u0004\u0018\u00010@H\u0014¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0013H\u0014¢\u0006\u0004\bD\u0010\u0015J\u0019\u0010G\u001a\u00020\u00132\b\u0010F\u001a\u0004\u0018\u00010EH\u0014¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0013H\u0014¢\u0006\u0004\bI\u0010\u0015J\u000f\u0010J\u001a\u00020\u0013H\u0014¢\u0006\u0004\bJ\u0010\u0015J\u000f\u0010K\u001a\u00020\u0013H\u0002¢\u0006\u0004\bK\u0010\u0015J\u000f\u0010L\u001a\u00020\u0002H\u0002¢\u0006\u0004\bL\u0010\u0004J\u000f\u0010M\u001a\u00020\u0013H\u0002¢\u0006\u0004\bM\u0010\u0015JC\u0010S\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00052\"\u0010R\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050Pj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`QH\u0002¢\u0006\u0004\bS\u0010TJ\u0019\u0010U\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010@H\u0014¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0013H\u0002¢\u0006\u0004\bW\u0010\u0015J\u000f\u0010X\u001a\u00020\u0013H\u0002¢\u0006\u0004\bX\u0010\u0015J\u000f\u0010Y\u001a\u00020\u0013H\u0002¢\u0006\u0004\bY\u0010\u0015J\u000f\u0010Z\u001a\u00020\u0013H\u0002¢\u0006\u0004\bZ\u0010\u0015J\u000f\u0010[\u001a\u00020\u0013H\u0002¢\u0006\u0004\b[\u0010\u0015J\u0017\u0010]\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u0002H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\u0013H\u0002¢\u0006\u0004\b_\u0010\u0015J\u000f\u0010`\u001a\u00020\u0002H\u0002¢\u0006\u0004\b`\u0010\u0004J\u000f\u0010a\u001a\u00020\u0013H\u0002¢\u0006\u0004\ba\u0010\u0015J\u000f\u0010b\u001a\u00020\u0002H\u0002¢\u0006\u0004\bb\u0010\u0004J/\u0010g\u001a\u00020\u00132\u0006\u0010c\u001a\u00020\u00022\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010f\u001a\u0004\u0018\u00010eH\u0002¢\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001a\u00020\u00022\u0006\u0010i\u001a\u00020eH\u0002¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u00020\u0002H\u0002¢\u0006\u0004\bl\u0010\u0004J\u000f\u0010m\u001a\u00020\u0002H\u0002¢\u0006\u0004\bm\u0010\u0004J\u000f\u0010n\u001a\u00020\u0013H\u0002¢\u0006\u0004\bn\u0010\u0015J\u0017\u0010o\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\bo\u0010\u001cJ\u000f\u0010p\u001a\u00020\u0002H\u0002¢\u0006\u0004\bp\u0010\u0004J\u000f\u0010q\u001a\u00020\u0013H\u0002¢\u0006\u0004\bq\u0010\u0015J\u0017\u0010t\u001a\u00020\u00132\u0006\u0010s\u001a\u00020rH\u0002¢\u0006\u0004\bt\u0010uR\u001d\u0010{\u001a\u00020v8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010|R\u001f\u0010\u0081\u0001\u001a\u00020}8B@\u0002X\u0082\u0084\u0002¢\u0006\r\n\u0004\b~\u0010x\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u0088\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0084\u0001R\u0019\u0010\u008b\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u0093\u0001\u001a\u00030\u008f\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0001\u0010x\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\"\u0010\u0098\u0001\u001a\u00030\u0094\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0095\u0001\u0010x\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u0089\u0001R\"\u0010¡\u0001\u001a\u00030\u009d\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009e\u0001\u0010x\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001a\u0010\u00ad\u0001\u001a\u00030¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u001b\u0010¯\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010«\u0001R\u001c\u0010±\u0001\u001a\u0005\u0018\u00010°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001a\u0010³\u0001\u001a\u00030¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010®\u0001R\u001c\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u0019\u0010·\u0001\u001a\u00020r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001a\u0010¹\u0001\u001a\u00030¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010®\u0001R\u0019\u0010º\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010\u0089\u0001R\u001a\u0010¼\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010À\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010\u0089\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001c\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001c\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\"\u0010Î\u0001\u001a\u00030Ê\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bË\u0001\u0010x\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u001b\u0010Ï\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010«\u0001R\"\u0010Ô\u0001\u001a\u00030Ð\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÑ\u0001\u0010x\u001a\u0006\bÒ\u0001\u0010Ó\u0001R\u001c\u0010Ö\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\"\u0010Ú\u0001\u001a\u00030Ê\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bØ\u0001\u0010x\u001a\u0006\bÙ\u0001\u0010Í\u0001¨\u0006Ü\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/NadRewardVideoActivity;", "Lcom/baidu/nadcore/appframework/BaseActivity;", "", "bigCardNineSpliteScreenShowing", "()Z", "", "dialogDataJson", "isTaskDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "buildDialog", "(Ljava/lang/String;Z)Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "rewardDataJson", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "buildLottieDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "suspendCmd", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "buildSuspendDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "", "chargeClick", "()V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "checkDownloadInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)Z", "scheme", "checkRewardPanelPop", "(Ljava/lang/String;)Z", "suspendDialogShowMoment", "checkShowSuspendMoment", "computeDailyRewardShownIndex", "finish", "getSessionInfo", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "cmd", "handleDialogRoute", "(Landroid/content/Context;Lcom/baidu/nadcore/model/AdRewardVideoLpModel;Ljava/lang/String;)V", "downloadInvokePanelPop", "handleUserInfoContainerRoute", "(Landroid/content/Context;Lcom/baidu/nadcore/model/AdRewardVideoLpModel;Z)V", "init", "initBigCard", "initBottomArrow", "initCloseIcon", "initCountDownView", "initFloatingLayer", "initImageStyle", "initRewardTask", "initRootView", "initSessionCountByTime", "initSvButton", "initSvTitle", "initTailFrame", "initTopTag", "initUserInfoContainer", "initVideoPlayer", "isAppInstalled", "(Ljava/lang/String;Landroid/content/Context;)Z", "isDialogShowing", "onAttachedToWindow", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreateEx", "(Landroid/os/Bundle;)V", "onDestroyEx", "Landroid/content/Intent;", "intent", "onNewIntentEx", "(Landroid/content/Intent;)V", "onPauseEx", "onResumeEx", "onTaskComplete", "parseData", "pauseVideoPlayAndCountDown", "status", "message", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "postRewardVideoNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "preCreate", "(Landroid/os/Bundle;)Z", "recomputeCountDownSecond", "registerBackForegroundEvent", "resetStatus", "resumeVideoPlayAndCountDown", "setAppInfo", "playEnd", "setVideoContainerMask", "(Z)V", "showBigCard", "showDialog", "showImageStylePage", "showLottieDialog", "autoPopup", "chargeModify", "", "chargeDuration", "showPanelPop", "(ZLjava/lang/String;Ljava/lang/Long;)V", "remainSecond", "showRetainDialog", "(J)Z", "showRewardDialog", "showSuspendDialog", "showSuspendDialogDelay", "showTaskDialog", "tailNineSplitScreenShowing", "triggerTask", "", "progress", "updateVideoSize", "(F)V", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer$delegate", "Lkotlin/Lazy;", "getAdInfoContainer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoAdOverContainer;", "adInfoContainer", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/uiwidget/SimpleAdInfoView;", "appInfoView$delegate", "getAppInfoView", "()Lcom/baidu/nadcore/widget/uiwidget/SimpleAdInfoView;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "arrowView", "Lcom/baidu/nadcore/widget/AdImageView;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCard", "Lcom/baidu/nadcore/lp/reward/view/NadRewardBigCardView;", "bigCardShown", "Z", "closeIcon", "countDownFinished", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "countDownView", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "flRootView$delegate", "getFlRootView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "flRootView", "Lcom/baidu/nadcore/lp/reward/view/NadRewardFloatingLayerView;", "floatingLayer$delegate", "getFloatingLayer", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardFloatingLayerView;", "floatingLayer", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "hasMore", "Lcom/baidu/nadcore/lp/reward/view/NadRewardImageView;", "imageStyleView$delegate", "getImageStyleView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardImageView;", "imageStyleView", "lottieDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardLottieDialog;", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "retainDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "rewardCount", "I", "rewardDialog", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardResponse", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardShownIndex", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "rewardTaskHelper", "Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "screenHW", "F", "sessionCount", "shouldCharge", "Ljava/lang/Runnable;", "shouldChargeTask", "Ljava/lang/Runnable;", "suspendDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardSuspendDialog;", "suspendDialogShown", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "svButton", "Lcom/baidu/nadcore/videoextra/NadIconTextButton;", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "svTitle", "Lcom/baidu/nadcore/videoextra/NadHighLightTextView;", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "tailFrame", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "Landroid/widget/FrameLayout;", "tailFrameContainer$delegate", "getTailFrameContainer", "()Landroid/widget/FrameLayout;", "tailFrameContainer", "taskDialog", "Landroid/view/View;", "topMask$delegate", "getTopMask", "()Landroid/view/View;", "topMask", "Landroid/widget/ImageView;", "topTag", "Landroid/widget/ImageView;", "videoContainer$delegate", "getVideoContainer", "videoContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardVideoActivity extends BaseActivity {
    public AdImageView B;
    public ImageView C;
    public AbsRewardCountDownView D;
    public dq0 E;
    public q91 F;
    public NadHighLightTextView H;
    public NadIconTextButton I;
    public av0 J;
    public NadRewardVideoDialog K;
    public NadRewardVideoDialog L;
    public NadRewardVideoDialog M;
    public NadRewardSuspendDialog N;
    public NadRewardLottieDialog O;
    public NadRewardBigCardView P;
    public js0 R;
    public aq0 S;

    /* renamed from: T  reason: collision with root package name */
    public float f1050T;
    public int U;
    public int V;
    public boolean X;
    public NadRewardTaskHelper Y;
    public Handler Z;
    public boolean a0;
    public boolean c0;
    public boolean d0;
    public boolean e0;
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
    public Runnable b0 = new r();

    public final NadRewardVideoAdOverContainer J2() {
        return (NadRewardVideoAdOverContainer) this.x.getValue();
    }

    public final SimpleAdInfoView K2() {
        return (SimpleAdInfoView) this.A.getValue();
    }

    public final NadRewardInterceptFrameLayout L2() {
        return (NadRewardInterceptFrameLayout) this.u.getValue();
    }

    public final NadRewardFloatingLayerView M2() {
        return (NadRewardFloatingLayerView) this.Q.getValue();
    }

    public final NadRewardImageView N2() {
        return (NadRewardImageView) this.G.getValue();
    }

    public final FrameLayout P2() {
        return (FrameLayout) this.y.getValue();
    }

    public final View Q2() {
        return (View) this.w.getValue();
    }

    public final FrameLayout R2() {
        return (FrameLayout) this.v.getValue();
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
        public static final class a implements oq0.a {
            public a() {
            }

            @Override // com.baidu.tieba.oq0.a
            public void onFail(Exception exc) {
                qq0.k(NadRewardVideoActivity.Q1(l.this.b).f.d, "4");
                Toast.makeText(l.this.b, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.oq0.a
            public void a(ws0 ws0Var) {
                String str;
                NadRewardVideoActivity.Q1(l.this.b).h().E(ws0Var);
                String str2 = null;
                if (ws0Var != null) {
                    str = ws0Var.f();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "1")) {
                    l.this.a.setFestivalEntranceContainerInvisible();
                    Toast.makeText(l.this.b, ws0Var.d(), 0).show();
                    return;
                }
                l.this.b.A3();
                String str3 = NadRewardVideoActivity.Q1(l.this.b).f.d;
                if (ws0Var != null) {
                    str2 = ws0Var.a();
                }
                qq0.l(str3, "4", str2);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            if (NadRewardVideoActivity.Q1(this.b).h().k() != null) {
                ws0 k = NadRewardVideoActivity.Q1(this.b).h().k();
                Intrinsics.checkNotNull(k);
                if (Intrinsics.areEqual(k.f(), "1")) {
                    NadRewardVideoActivity nadRewardVideoActivity = this.b;
                    ws0 k2 = NadRewardVideoActivity.Q1(nadRewardVideoActivity).h().k();
                    Intrinsics.checkNotNull(k2);
                    Toast.makeText(nadRewardVideoActivity, k2.d(), 0).show();
                    return;
                }
                this.b.A3();
                return;
            }
            oq0 oq0Var = oq0.a;
            dt0 h = NadRewardVideoActivity.Q1(this.b).h();
            et0 m = NadRewardVideoActivity.Q1(this.b).h().m();
            if (m != null) {
                str = m.b();
            } else {
                str = null;
            }
            oq0Var.d(h, str, new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class q extends ho0<ko0> {

        /* loaded from: classes3.dex */
        public static final class a implements oq0.a {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.oq0.a
            public void onFail(Exception exc) {
                qq0.k(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "5");
                Toast.makeText(NadRewardVideoActivity.this, (int) R.string.nad_reward_request_fail_toast, 0).show();
            }

            @Override // com.baidu.tieba.oq0.a
            public void a(ws0 ws0Var) {
                String str;
                String str2;
                NadRewardVideoActivity.this.J2().setFestivalEntranceContainerInvisible();
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                String str3 = null;
                if (ws0Var != null) {
                    str = ws0Var.d();
                } else {
                    str = null;
                }
                Toast.makeText(nadRewardVideoActivity, str, 0).show();
                if (ws0Var != null) {
                    str2 = ws0Var.f();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str2, "1")) {
                    String str4 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                    if (ws0Var != null) {
                        str3 = ws0Var.a();
                    }
                    qq0.l(str4, "5", str3);
                }
            }
        }

        public q(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ho0
        public void onEvent(ko0 event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a && NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).i().b()) {
                oq0 oq0Var = oq0.a;
                dt0 h = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h();
                ws0 k = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().k();
                if (k != null) {
                    str = k.b();
                } else {
                    str = null;
                }
                oq0Var.d(h, str, new a());
                NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).i().e(false);
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
            xr0 xr0Var;
            us0 e = NadRewardVideoActivity.Q1(this.b).e();
            if (e != null && e.g()) {
                us0 e2 = NadRewardVideoActivity.Q1(this.b).e();
                Intrinsics.checkNotNull(e2);
                xr0Var = e2.b();
            } else {
                bs0 bs0Var = NadRewardVideoActivity.Q1(this.b).m;
                if (bs0Var != null) {
                    xr0Var = bs0Var.p;
                } else {
                    xr0Var = null;
                }
            }
            do0.a().a(new qi0(xr0Var));
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
            NadRewardVideoActivity.U2(nadRewardVideoActivity, context, NadRewardVideoActivity.Q1(this.b), false, 4, null);
            qq0.f(NadRewardVideoActivity.Q1(this.b));
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
            if (g71.a()) {
                return;
            }
            String str2 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
            aq0 aq0Var = NadRewardVideoActivity.this.S;
            if (aq0Var != null) {
                str = aq0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            qq0.r(str2, !z);
            if (NadRewardVideoActivity.this.y3()) {
                return;
            }
            NadRewardVideoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements View.OnClickListener {
        public final /* synthetic */ y81 b;

        public j(y81 y81Var) {
            this.b = y81Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            qq0.w(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this));
            if (NadRewardVideoActivity.this.G2(this.b.c)) {
                NadRewardVideoActivity.C3(NadRewardVideoActivity.this, false, null, null, 6, null);
            } else if (Intrinsics.areEqual(this.b.c, "__CONVERT_CMD__")) {
                if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).n()) {
                    ak0.c(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).g(), NadRewardVideoActivity.this);
                    return;
                }
                String str2 = null;
                if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).m()) {
                    NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                    bs0 bs0Var = NadRewardVideoActivity.Q1(nadRewardVideoActivity).m;
                    if (bs0Var != null) {
                        str = bs0Var.t;
                    } else {
                        str = null;
                    }
                    if (nadRewardVideoActivity.G2(str)) {
                        NadRewardVideoActivity.C3(NadRewardVideoActivity.this, false, null, null, 6, null);
                        return;
                    }
                }
                bs0 bs0Var2 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).m;
                if (bs0Var2 != null) {
                    str2 = bs0Var2.t;
                }
                ak0.c(str2, NadRewardVideoActivity.this);
            } else {
                ak0.c(this.b.c, NadRewardVideoActivity.this);
            }
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
            NadRewardVideoActivity nadRewardVideoActivity = this.b;
            Context context = this.a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            NadRewardVideoActivity.U2(nadRewardVideoActivity, context, NadRewardVideoActivity.Q1(this.b), false, 4, null);
            this.b.E2();
            NadRewardVideoActivity.Q1(this.b).i().d(true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class m extends ev0 {
        public m() {
        }

        @Override // com.baidu.tieba.ev0, com.baidu.tieba.xu0
        public void onEnd(int i) {
            String str;
            os0 os0Var;
            String str2;
            os0 os0Var2;
            os0 os0Var3;
            os0 os0Var4;
            q91 q91Var;
            NadRewardBigCardView nadRewardBigCardView;
            if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).b() != null) {
                ss0 c = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).c();
                if (c != null && c.b() && (((q91Var = NadRewardVideoActivity.this.F) == null || !q91Var.isShowing()) && (nadRewardBigCardView = NadRewardVideoActivity.this.P) != null)) {
                    nadRewardBigCardView.y(true);
                }
                NadRewardVideoActivity.this.w3(true);
                NadRewardVideoActivity.this.x3();
            } else {
                if (!NadRewardVideoActivity.this.c0) {
                    ms0 ms0Var = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).j;
                    if (ms0Var != null && (os0Var4 = ms0Var.i) != null) {
                        os0Var4.x = null;
                    }
                    ms0 ms0Var2 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).j;
                    if (ms0Var2 != null && (os0Var3 = ms0Var2.i) != null) {
                        os0Var3.w = null;
                    }
                    ms0 ms0Var3 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).j;
                    if (ms0Var3 != null && (os0Var2 = ms0Var3.i) != null) {
                        os0Var2.y = null;
                    }
                }
                dq0 dq0Var = NadRewardVideoActivity.this.E;
                if (dq0Var != null) {
                    dq0Var.setVisibility(true);
                }
                NadRewardBigCardView nadRewardBigCardView2 = NadRewardVideoActivity.this.P;
                if (nadRewardBigCardView2 != null) {
                    nadRewardBigCardView2.setVisibility(false);
                }
                NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).i().h(true);
                String str3 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                String str4 = "0";
                if (!NadRewardVideoActivity.this.c0) {
                    str = "0";
                } else {
                    str = "1";
                }
                ms0 ms0Var4 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).j;
                if (ms0Var4 != null && (os0Var = ms0Var4.i) != null && (str2 = os0Var.a) != null) {
                    str4 = str2;
                }
                qq0.z(str3, str, str4);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.B;
            if (adImageView != null) {
                adImageView.bringToFront();
            }
            NadRewardVideoActivity.this.M2().l();
        }

        @Override // com.baidu.tieba.ev0, com.baidu.tieba.xu0
        public void onStart() {
            NadRewardVideoActivity.this.w3(false);
            dq0 dq0Var = NadRewardVideoActivity.this.E;
            if (dq0Var != null) {
                dq0Var.setVisibility(false);
            }
            AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.bringToFront();
            }
        }

        @Override // com.baidu.tieba.ev0, com.baidu.tieba.xu0
        public void onUpdateProgress(int i, int i2, int i3) {
            NadRewardVideoActivity.this.M2().j(i);
        }
    }

    /* loaded from: classes3.dex */
    public static final class n extends k21 {
        @Override // com.baidu.tieba.k21, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            if (jq0.b().a()) {
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
            if (NadRewardVideoActivity.this.L2().getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                nadRewardVideoActivity.f1050T = nadRewardVideoActivity.L2().getMeasuredHeight() / NadRewardVideoActivity.this.L2().getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class p implements iq0.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public p() {
        }

        @Override // com.baidu.tieba.iq0.b
        public void onFail(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            NadRewardVideoActivity.this.S = null;
            NadRewardVideoActivity.this.c0 = false;
        }

        @Override // com.baidu.tieba.iq0.b
        public void a(aq0 aq0Var) {
            boolean z;
            View view2;
            AdDownloadStatus adDownloadStatus;
            boolean z2;
            NadRewardVideoActivity.this.S = aq0Var;
            if (aq0Var == null) {
                return;
            }
            NadRewardVideoActivity.this.V++;
            int i = 0;
            if (aq0Var.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.d(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().b(aq0Var.d()));
                }
                qq0.d(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, aq0Var.d(), NadRewardVideoActivity.this.O2(), aq0Var.f(), aq0Var.h());
                if (aq0Var.h().length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    qq0.A(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "2", aq0Var.h());
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(aq0Var.d());
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                }
                if (i <= 0) {
                    qq0.o(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "1", "3");
                }
            }
            qq0.g(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d, "1", aq0Var.d(), NadRewardVideoActivity.this.O2());
            NadRewardVideoActivity.this.c0 = !aq0Var.c();
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).h().t());
            NadRewardVideoActivity.this.q3("0", "任务完成回调", hashMap);
            me1<View> transitionButtonView = NadRewardVideoActivity.this.J2().getTransitionButtonView();
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
                String str = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                Intrinsics.checkNotNullExpressionValue(str, "adModel.common.extraParam");
                nadRewardTaskHelper.t(aq0Var, adDownloadStatus, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardVideoActivity.this.a0 = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class s implements PopupWindow.OnDismissListener {
        public s(boolean z, long j, String str) {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            av0 av0Var = NadRewardVideoActivity.this.J;
            if (av0Var != null) {
                av0Var.resume();
            }
            AdImageView adImageView = NadRewardVideoActivity.this.B;
            if (adImageView != null) {
                ExtensionsKt.f(adImageView, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class t implements x91 {
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public t(boolean z, long j, String str) {
            this.b = z;
            this.c = j;
            this.d = str;
        }

        @Override // com.baidu.tieba.x91
        public void a() {
            qq0.j(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d);
        }

        @Override // com.baidu.tieba.x91
        public void b() {
            NadRewardVideoActivity.this.onBackPressed();
        }

        @Override // com.baidu.tieba.x91
        public void d() {
            NadRewardVideoActivity.this.onBackPressed();
        }

        @Override // com.baidu.tieba.x91
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
        }

        @Override // com.baidu.tieba.x91
        public void f() {
            qq0.s(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d);
        }

        @Override // com.baidu.tieba.x91
        public void c() {
            if (!this.b) {
                return;
            }
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if ((TextUtils.equals(this.d, "1") || TextUtils.equals(this.d, "2")) && NadRewardVideoActivity.this.a0) {
                js0 Q1 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                qq0.t(Q1, str, ClogBuilder.LogType.CLICK, valueOf, "1");
                return;
            }
            js0 Q12 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            qq0.t(Q12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "1");
        }

        @Override // com.baidu.tieba.x91
        public void e() {
            if (!this.b) {
                return;
            }
            String valueOf = String.valueOf((System.currentTimeMillis() - this.c) / 1000);
            if (TextUtils.equals(this.d, "2") && NadRewardVideoActivity.this.a0) {
                js0 Q1 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this);
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                qq0.t(Q1, str, ClogBuilder.LogType.CLICK, valueOf, "2");
                return;
            }
            js0 Q12 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this);
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            qq0.t(Q12, str2, ClogBuilder.LogType.FREE_CLICK, valueOf, "2");
        }
    }

    public final boolean F3() {
        JSONObject jSONObject;
        String f2;
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        gt0 p2 = js0Var.h().p();
        if (p2 == null || p2.f() == null || this.X) {
            return false;
        }
        q91 q91Var = this.F;
        if (q91Var != null && q91Var.isShowing()) {
            return false;
        }
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        gt0 p3 = js0Var2.h().p();
        if (p3 != null && (f2 = p3.f()) != null) {
            jSONObject = ExtensionsKt.a(f2);
        } else {
            jSONObject = null;
        }
        NadRewardSuspendDialog D2 = D2(String.valueOf(jSONObject));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        D2.show(supportFragmentManager, (String) null);
        this.X = true;
        this.N = D2;
        p3();
        return true;
    }

    public final void G3() {
        String str;
        String c2;
        Integer intOrNull;
        int i2 = 0;
        this.X = false;
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        gt0 p2 = js0Var.h().p();
        if (p2 != null && p2.f() != null) {
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            final gt0 p3 = js0Var2.h().p();
            if (p3 != null) {
                str = p3.b();
            } else {
                str = null;
            }
            if (!H2(str)) {
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
            js0 js0Var3 = this.R;
            if (js0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = js0Var3.h().s();
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
                        boolean F3;
                        String str2;
                        F3 = NadRewardVideoActivity.this.F3();
                        if (F3) {
                            String str3 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).f.d;
                            String valueOf = String.valueOf(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).i().c());
                            gt0 gt0Var = p3;
                            if (gt0Var != null) {
                                str2 = gt0Var.b();
                            } else {
                                str2 = null;
                            }
                            qq0.i(str3, "3", valueOf, str2);
                        }
                    }
                });
            }
        }
    }

    public final void Z2() {
        if (this.D == null) {
            fq0 a2 = jq0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            View inflate = LayoutInflater.from(this).inflate(a2.e(), (ViewGroup) L2(), true);
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
            js0 js0Var = this.R;
            if (js0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int s2 = js0Var.h().s();
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            absRewardCountDownView3.setData(s2, js0Var2.h(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initCountDownView$1
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
                    ss0 c2;
                    String str;
                    NadRewardVideoActivity.this.e0 = true;
                    NadRewardVideoActivity.this.n3();
                    if (NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).o() && (c2 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).c()) != null && c2.l()) {
                        NadRewardVideoActivity nadRewardVideoActivity = NadRewardVideoActivity.this;
                        ss0 c3 = NadRewardVideoActivity.Q1(nadRewardVideoActivity).c();
                        Long l2 = null;
                        if (c3 != null) {
                            str = c3.k();
                        } else {
                            str = null;
                        }
                        ss0 c4 = NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).c();
                        if (c4 != null) {
                            l2 = Long.valueOf(c4.m());
                        }
                        nadRewardVideoActivity.B3(true, str, l2);
                    }
                }
            });
        }
    }

    public final void f3() {
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        y81 a2 = y81.a(js0Var.k());
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            if (this.I == null) {
                this.I = new NadIconTextButton(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                layoutParams.topMargin = (((e71.c.e(this) * 9) / 16) / 2) + e71.c.a(this, 26.0f);
                L2().addView(this.I, layoutParams);
            }
            NadIconTextButton nadIconTextButton = this.I;
            if (nadIconTextButton != null) {
                nadIconTextButton.update(a2);
                nadIconTextButton.setOnClickListener(new j(a2));
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

    public final void g3() {
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        x81 a2 = x81.a(js0Var.l());
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            if (this.H == null) {
                this.H = new NadHighLightTextView(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = (((e71.c.e(this) * 9) / 16) / 2) + e71.c.a(this, 52.0f);
                layoutParams.setMarginStart(e71.c.a(this, 9.0f));
                layoutParams.setMarginEnd(e71.c.a(this, 8.0f));
                L2().addView(this.H, layoutParams);
            }
            NadHighLightTextView nadHighLightTextView = this.H;
            if (nadHighLightTextView != null) {
                nadHighLightTextView.setLineSpacing(e71.c.a(nadHighLightTextView.getContext(), 3.0f), 1.0f);
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

    public final void r3() {
        long j2;
        int i2;
        String d2;
        Integer intOrNull;
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        gt0 p2 = js0Var.h().p();
        if (p2 != null && p2.f() != null) {
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            gt0 p3 = js0Var2.h().p();
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
                js0 js0Var3 = this.R;
                if (js0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView3.setData(i3, js0Var3.h(), new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$recomputeCountDownSecond$1
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
                        NadRewardVideoActivity.this.n3();
                    }
                });
            }
        }
    }

    public final void x3() {
        if (this.d0) {
            return;
        }
        q91 q91Var = this.F;
        if (q91Var != null && q91Var.isShowing()) {
            return;
        }
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ss0 c2 = js0Var.c();
        if (c2 != null && c2.b()) {
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ms0 ms0Var = js0Var2.j;
            if (ms0Var != null) {
                int i2 = ms0Var.c;
                js0 js0Var3 = this.R;
                if (js0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (i2 == js0Var3.h().s()) {
                    return;
                }
            }
        }
        this.d0 = true;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(true);
        }
        dq0 dq0Var = this.E;
        if (dq0Var != null) {
            dq0Var.setVisibility(false);
        }
        NadHighLightTextView nadHighLightTextView = this.H;
        if (nadHighLightTextView != null) {
            ExtensionsKt.f(nadHighLightTextView, false);
        }
        NadIconTextButton nadIconTextButton = this.I;
        if (nadIconTextButton != null) {
            ExtensionsKt.f(nadIconTextButton, false);
        }
        M2().l();
        J2().setFestivalEntranceContainerInvisible();
    }

    public static /* synthetic */ NadRewardVideoDialog B2(NadRewardVideoActivity nadRewardVideoActivity, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nadRewardVideoActivity.A2(str, z);
    }

    public static /* synthetic */ void C3(NadRewardVideoActivity nadRewardVideoActivity, boolean z, String str, Long l2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            l2 = 0L;
        }
        nadRewardVideoActivity.B3(z, str, l2);
    }

    public static /* synthetic */ void U2(NadRewardVideoActivity nadRewardVideoActivity, Context context, js0 js0Var, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        nadRewardVideoActivity.T2(context, js0Var, z);
    }

    public static final /* synthetic */ js0 Q1(NadRewardVideoActivity nadRewardVideoActivity) {
        js0 js0Var = nadRewardVideoActivity.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return js0Var;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void A1(Bundle bundle) {
        super.A1(bundle);
        setContentView(R.layout.nad_reward_video_lp_activity);
        L2().post(new o());
        this.Z = new Handler(Looper.getMainLooper());
        if (!o3()) {
            finish();
            return;
        }
        e3();
        V2();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1(Intent intent) {
        super.D1(intent);
        setIntent(intent);
        if (!o3()) {
            g61.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
            return;
        }
        V2();
        z3();
    }

    public final boolean F2(js0 js0Var) {
        xr0 xr0Var;
        String str;
        bs0 bs0Var = js0Var.m;
        if (bs0Var != null && (xr0Var = bs0Var.p) != null && xr0Var.e) {
            if (bs0Var != null && xr0Var != null) {
                str = xr0Var.a;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean G2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !ok0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new fk0(str).a(), "rewardWebPanel");
    }

    public final boolean H3(String str) {
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
        this.K = A2;
        p3();
        return true;
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

    public final void w3(boolean z) {
        int i2;
        ViewGroup.LayoutParams layoutParams = Q2().getLayoutParams();
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            i2 = nadRewardBigCardView.getHeight();
        } else {
            i2 = 0;
        }
        if (z) {
            layoutParams.height = e71.c.c(this) - i2;
        } else {
            layoutParams.height = e71.c.a(this, 33.0f);
        }
        Q2().setLayoutParams(layoutParams);
    }

    public final NadRewardVideoDialog A2(final String str, final boolean z) {
        boolean z2;
        Integer num;
        String valueOf;
        boolean z3;
        final NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = js0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardVideoDialog.i2(str, str2);
        zp0 T1 = nadRewardVideoDialog.T1();
        boolean z4 = false;
        if (T1 != null) {
            if (z && !this.c0) {
                z3 = true;
            } else {
                z3 = false;
            }
            T1.L(z3);
        }
        zp0 T12 = nadRewardVideoDialog.T1();
        if (T12 != null) {
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            T12.K(js0Var2.h().r());
        }
        zp0 T13 = nadRewardVideoDialog.T1();
        if (T13 != null) {
            js0 js0Var3 = this.R;
            if (js0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (js0Var3.h().i().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                js0 js0Var4 = this.R;
                if (js0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                valueOf = js0Var4.h().i();
            } else {
                js0 js0Var5 = this.R;
                if (js0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                it0 q2 = js0Var5.h().q();
                if (q2 != null) {
                    num = Integer.valueOf(q2.b());
                } else {
                    num = null;
                }
                valueOf = String.valueOf(num);
            }
            T13.G(valueOf);
        }
        zp0 T14 = nadRewardVideoDialog.T1();
        if (T14 != null) {
            js0 js0Var6 = this.R;
            if (js0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            us0 e2 = js0Var6.e();
            if (e2 != null && e2.g()) {
                z4 = true;
            }
            T14.I(z4);
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
                NadRewardVideoActivity.this.u3();
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

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str3) {
                this.S2(NadRewardVideoDialog.this.getContext(), NadRewardVideoActivity.Q1(this), str3);
                if (this.G2(str3)) {
                    NadRewardVideoDialog.this.dismiss();
                }
            }
        });
        nadRewardVideoDialog.m2(new c(nadRewardVideoDialog, this, str, z));
        return nadRewardVideoDialog;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
        if (r0 == true) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A3() {
        String str;
        q91 q91Var;
        ViewGroup view2;
        boolean z;
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var.h().k() != null) {
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (js0Var2.h().m() != null) {
                js0 js0Var3 = this.R;
                if (js0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                et0 m2 = js0Var3.h().m();
                if (m2 != null) {
                    str = m2.a();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !bu.a(this) && !m3() && ((q91Var = this.F) == null || !q91Var.isShowing())) {
                    dq0 dq0Var = this.E;
                    if (dq0Var != null && (view2 = dq0Var.getView()) != null) {
                        if (view2.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    js0 js0Var4 = this.R;
                    if (js0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    dt0 h2 = js0Var4.h();
                    js0 js0Var5 = this.R;
                    if (js0Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ws0 k2 = js0Var5.h().k();
                    Intrinsics.checkNotNull(k2);
                    String c2 = k2.c();
                    js0 js0Var6 = this.R;
                    if (js0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ws0 k3 = js0Var6.h().k();
                    Intrinsics.checkNotNull(k3);
                    NadRewardLottieDialog C2 = C2(h2.j(c2, k3.a()));
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    C2.show(supportFragmentManager, (String) null);
                    this.O = C2;
                    p3();
                    return true;
                }
            }
        }
        return false;
    }

    public final void W2() {
        String f2;
        Integer intOrNull;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        int i2 = 0;
        if (nadRewardBigCardView != null) {
            nadRewardBigCardView.setVisibility(false);
        }
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var.b() == null) {
            this.P = null;
            return;
        }
        NadRewardBigCardView nadRewardBigCardView2 = new NadRewardBigCardView(this, null, 0, 6, null);
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardBigCardView2.setData(js0Var2);
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
                av0 av0Var = NadRewardVideoActivity.this.J;
                if (av0Var != null) {
                    av0Var.pause();
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
                AdImageView adImageView2 = NadRewardVideoActivity.this.B;
                if (adImageView2 != null) {
                    adImageView2.bringToFront();
                }
                AbsRewardCountDownView absRewardCountDownView = NadRewardVideoActivity.this.D;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.bringToFront();
                }
                av0 av0Var = NadRewardVideoActivity.this.J;
                if (av0Var != null) {
                    av0Var.resume();
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
                NadRewardVideoActivity.this.K3(f3);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.P = nadRewardBigCardView2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = -e71.c.c(this);
        L2().addView(this.P, layoutParams);
        NadRewardBigCardView nadRewardBigCardView3 = this.P;
        if (nadRewardBigCardView3 != null) {
            nadRewardBigCardView3.setVisibility(false);
        }
        NadRewardBigCardView nadRewardBigCardView4 = this.P;
        if (nadRewardBigCardView4 != null) {
            nadRewardBigCardView4.bringToFront();
        }
        js0 js0Var3 = this.R;
        if (js0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        int s2 = js0Var3.h().s();
        js0 js0Var4 = this.R;
        if (js0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        rs0 b2 = js0Var4.b();
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
                    NadRewardVideoActivity.this.x3();
                }
            });
        }
    }

    public final void X2() {
        int a2;
        fq0 a3 = jq0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        boolean z = true;
        View inflate = LayoutInflater.from(this).inflate(a3.t(), (ViewGroup) L2(), true);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…youtId, flRootView, true)");
        AdImageView adImageView = (AdImageView) inflate.findViewById(R.id.reward_arrow);
        this.z = adImageView;
        if (adImageView != null) {
            adImageView.setImageResource(R.drawable.nad_reward_up_arrow);
        }
        AdImageView adImageView2 = this.z;
        if (adImageView2 != null) {
            js0 js0Var = this.R;
            if (js0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ss0 c2 = js0Var.c();
            if (c2 == null || !c2.e()) {
                js0 js0Var2 = this.R;
                if (js0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (!js0Var2.o()) {
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
                    js0 js0Var3 = this.R;
                    if (js0Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (js0Var3.o()) {
                        a2 = e71.c.a(adImageView2.getContext(), 23.0f);
                    } else {
                        a2 = e71.c.a(adImageView2.getContext(), 4.0f);
                    }
                    layoutParams2.bottomMargin = a2;
                    adImageView2.setOnClickListener(new h(adImageView2, this));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
    }

    public final void B3(boolean z, String str, Long l2) {
        boolean z2;
        long j2;
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var.f().length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.F = null;
            return;
        }
        q91 q91Var = this.F;
        if (q91Var != null && q91Var.isShowing()) {
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
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (js0Var2.o()) {
                js0 js0Var3 = this.R;
                if (js0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                qq0.y(js0Var3);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        fq0 a2 = jq0.a();
        Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
        q91 q91Var2 = new q91(this, a2.v());
        q91Var2.setOnDismissListener(new s(z, currentTimeMillis, str));
        q91Var2.i(new t(z, currentTimeMillis, str));
        Resources resources = getResources();
        fq0 a3 = jq0.a();
        Intrinsics.checkNotNullExpressionValue(a3, "NadRewardVideoLpRuntime.getUIProvider()");
        double dimension = 1 - (resources.getDimension(a3.q()) / e71.c.c(this));
        js0 js0Var4 = this.R;
        if (js0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String f2 = js0Var4.f();
        js0 js0Var5 = this.R;
        if (js0Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        y91 y91Var = new y91(f2, dimension, 0, js0Var5.f.d);
        y91Var.J(true);
        y91Var.I(false);
        y91Var.M(true);
        y91Var.L(!z);
        y91Var.A(z);
        y91Var.B(z);
        y91Var.C(true);
        js0 js0Var6 = this.R;
        if (js0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!TextUtils.isEmpty(js0Var6.f.m)) {
            js0 js0Var7 = this.R;
            if (js0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            y91Var.z(js0Var7.f.l);
        }
        Unit unit = Unit.INSTANCE;
        q91Var2.h(y91Var);
        q91Var2.j();
        Unit unit2 = Unit.INSTANCE;
        this.F = q91Var2;
        av0 av0Var = this.J;
        if (av0Var != null) {
            av0Var.pause();
        }
        AdImageView adImageView = this.B;
        if (adImageView != null) {
            ExtensionsKt.f(adImageView, false);
        }
        js0 js0Var8 = this.R;
        if (js0Var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        js0Var8.i().f(true);
        M2().l();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1() {
        super.C1();
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.c();
        }
        av0 av0Var = this.J;
        if (av0Var != null) {
            av0Var.release();
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
        J2().C();
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
        M2().l();
    }

    public final void E2() {
        boolean z;
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        List<MonitorUrl> list = js0Var.e;
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
            o41.b(monitorUrl.clickUrl);
        }
    }

    public final boolean E3() {
        String str;
        boolean z;
        if (!this.c0) {
            return false;
        }
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        dt0 h2 = js0Var.h();
        aq0 aq0Var = this.S;
        if (aq0Var != null) {
            str = aq0Var.e();
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
        NadRewardVideoDialog B2 = B2(this, l2, false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        B2.show(supportFragmentManager, (String) null);
        this.M = B2;
        p3();
        return true;
    }

    public final void Y2() {
        if (this.B == null) {
            fq0 a2 = jq0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            View inflate = LayoutInflater.from(this).inflate(a2.o(), (ViewGroup) L2(), true);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…youtId, flRootView, true)");
            this.B = (AdImageView) inflate.findViewById(R.id.reward_close_icon);
        }
        AdImageView adImageView = this.B;
        if (adImageView != null) {
            int a3 = e71.c.a(adImageView.getContext(), 10.0f);
            adImageView.setPadding(a3, a3, a3, a3);
            adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            adImageView.setOnClickListener(new i());
        }
    }

    public final void i3() {
        boolean z = true;
        if (this.C == null) {
            fq0 a2 = jq0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
            this.C = (ImageView) LayoutInflater.from(this).inflate(a2.a(), (ViewGroup) L2(), true).findViewById(R.id.top_tag);
        }
        ImageView imageView = this.C;
        if (imageView != null) {
            js0 js0Var = this.R;
            if (js0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            us0 e2 = js0Var.e();
            if ((e2 == null || !e2.g()) ? false : false) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public final void z3() {
        String str;
        boolean z;
        String str2;
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        us0 e2 = js0Var.e();
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
            q91 q91Var = this.F;
            if (q91Var != null) {
                q91Var.e();
            }
            this.F = null;
            return;
        }
        q91 q91Var2 = this.F;
        if (q91Var2 != null) {
            q91Var2.e();
        }
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        us0 e3 = js0Var2.e();
        if (e3 != null) {
            str2 = e3.d();
        } else {
            str2 = null;
        }
        js0 js0Var3 = this.R;
        if (js0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        us0 e4 = js0Var3.e();
        if (e4 != null) {
            l2 = Long.valueOf(e4.a());
        }
        B3(true, str2, l2);
    }

    public final NadRewardLottieDialog C2(final String str) {
        s3();
        NadRewardLottieDialog nadRewardLottieDialog = new NadRewardLottieDialog();
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str2 = js0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
        nadRewardLottieDialog.i2(str, str2);
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        nadRewardLottieDialog.x2(js0Var2.h().k());
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
                NadRewardVideoActivity.this.u3();
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
                NadRewardVideoActivity.Q1(NadRewardVideoActivity.this).i().e(true);
            }
        });
        return nadRewardLottieDialog;
    }

    public final boolean D3(long j2) {
        boolean z;
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var.h().o().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        NadRewardVideoDialog B2 = B2(this, js0Var2.h().n(j2), false, 2, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        B2.show(supportFragmentManager, (String) null);
        this.L = B2;
        p3();
        return true;
    }

    public final NadRewardSuspendDialog D2(final String str) {
        String str2;
        String str3;
        NadRewardSuspendDialog nadRewardSuspendDialog = new NadRewardSuspendDialog();
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        String str4 = js0Var.f.d;
        Intrinsics.checkNotNullExpressionValue(str4, "adModel.common.extraParam");
        nadRewardSuspendDialog.i2(str, str4);
        zp0 T1 = nadRewardSuspendDialog.T1();
        String str5 = null;
        if (T1 != null) {
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            gt0 p2 = js0Var2.h().p();
            if (p2 != null) {
                str3 = p2.a();
            } else {
                str3 = null;
            }
            T1.F(str3);
        }
        zp0 T12 = nadRewardSuspendDialog.T1();
        if (T12 != null) {
            js0 js0Var3 = this.R;
            if (js0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            gt0 p3 = js0Var3.h().p();
            if (p3 != null) {
                str2 = p3.e();
            } else {
                str2 = null;
            }
            T12.J(str2);
        }
        zp0 T13 = nadRewardSuspendDialog.T1();
        if (T13 != null) {
            js0 js0Var4 = this.R;
            if (js0Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            gt0 p4 = js0Var4.h().p();
            if (p4 != null) {
                str5 = p4.g();
            }
            T13.M(str5);
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
                NadRewardVideoActivity.this.u3();
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
                NadRewardVideoActivity.this.r3();
            }
        });
        return nadRewardSuspendDialog;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void E1() {
        super.E1();
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
        av0 av0Var = this.J;
        if (av0Var != null) {
            av0Var.pause();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void I1() {
        super.I1();
        if (m3()) {
            return;
        }
        u3();
    }

    public final void I2() {
        int a2 = m71.a("nad_reward_sp", "key_reward_shown_index", 1);
        this.W = a2;
        m71.e("nad_reward_sp", "key_reward_shown_index", a2 + 1);
    }

    public final boolean I3() {
        ViewGroup view2;
        boolean z;
        dq0 dq0Var = this.E;
        if (dq0Var == null || (view2 = dq0Var.getView()) == null) {
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
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ss0 c2 = js0Var.c();
        if (c2 == null || !c2.s()) {
            return false;
        }
        return true;
    }

    public final void J3() {
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        qq0.u(js0Var, O2());
        I2();
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ak0.c(js0Var2.f.m, this);
        G3();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.U int), ('_' char), (wrap: int : 0x000f: IGET  (r1v2 int A[REMOVE]) = (r2v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.V int)] */
    public final String O2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.U);
        sb.append('_');
        sb.append(this.V);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…d(rewardCount).toString()");
        return sb2;
    }

    public final void V2() {
        t3();
        d3();
        i3();
        X2();
        Z2();
        k3();
        j3();
        Y2();
        g3();
        f3();
        h3();
        W2();
        b3();
        a3();
        c3();
        J3();
    }

    public final void a3() {
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var.d() == null) {
            return;
        }
        final NadRewardFloatingLayerView M2 = M2();
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        M2.setData(js0Var2);
        M2.setTriggerCallback(new Function1<String, Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initFloatingLayer$$inlined$apply$lambda$1
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
                    ak0.b(cmd);
                    return;
                }
                NadRewardVideoActivity nadRewardVideoActivity = this;
                Context context = NadRewardFloatingLayerView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                nadRewardVideoActivity.T2(context, NadRewardVideoActivity.Q1(this), true);
            }
        });
        M2.setVisibility(0);
    }

    public final void c3() {
        if (this.Y == null) {
            this.Y = new NadRewardTaskHelper();
        }
        NadRewardTaskHelper nadRewardTaskHelper = this.Y;
        if (nadRewardTaskHelper != null) {
            js0 js0Var = this.R;
            if (js0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadRewardTaskHelper.H(js0Var);
        }
    }

    public final void d3() {
        NadRewardInterceptFrameLayout L2 = L2();
        boolean z = true;
        L2.setClickable(true);
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (!js0Var.m()) {
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (!js0Var2.o()) {
                z = false;
            }
        }
        L2.setEnableIntercept(z);
        L2.setInterceptCallback(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initRootView$$inlined$apply$lambda$1
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
                NadRewardVideoActivity.U2(nadRewardVideoActivity, nadRewardVideoActivity, NadRewardVideoActivity.Q1(nadRewardVideoActivity), false, 4, null);
                qq0.x(NadRewardVideoActivity.Q1(NadRewardVideoActivity.this));
            }
        });
    }

    public final void e3() {
        int a2 = m71.a("nad_reward_sp", "key_session_count", 1);
        this.U = a2;
        m71.e("nad_reward_sp", "key_session_count", a2 + 1);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity
    public void finish() {
        String str;
        boolean z;
        js0 js0Var = this.R;
        if (js0Var != null) {
            if (js0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ts0 f2 = js0Var.h().f();
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
                ak0.c(str, this);
            }
        }
        super.finish();
    }

    public final void n3() {
        iq0 c2 = jq0.c();
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        c2.a(js0Var, new ct0(this.U, this.V), new p());
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        z3();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (g71.a() || y3()) {
            return;
        }
        super.onBackPressed();
    }

    public final void p3() {
        av0 av0Var = this.J;
        if (av0Var != null) {
            av0Var.pause();
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.e();
        }
    }

    public final void s3() {
        do0.a().b(this, new q(ko0.class));
    }

    public final void t3() {
        this.e0 = false;
        this.d0 = false;
        this.S = null;
        this.a0 = false;
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.c();
        }
        J2().C();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r0 != true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u3() {
        ViewGroup view2;
        boolean z;
        q91 q91Var = this.F;
        if (q91Var == null || !q91Var.isShowing()) {
            dq0 dq0Var = this.E;
            if (dq0Var != null && (view2 = dq0Var.getView()) != null) {
                if (view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            av0 av0Var = this.J;
            if (av0Var != null) {
                av0Var.resume();
            }
        }
        AbsRewardCountDownView absRewardCountDownView = this.D;
        if (absRewardCountDownView != null) {
            absRewardCountDownView.b();
        }
    }

    public final void v3() {
        SimpleAdInfoView K2 = K2();
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (mj0.a(js0Var.i)) {
            K2.setVisibility(0);
        } else {
            K2.setVisibility(8);
        }
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        K2.setAdInfo(js0Var2.i);
    }

    public final boolean z2() {
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
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ss0 c2 = js0Var.c();
        if (c2 == null || !c2.b()) {
            return false;
        }
        return true;
    }

    public final boolean H2(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null).contains(String.valueOf(this.W))) {
            return false;
        }
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        js0Var.i().g(this.W);
        return true;
    }

    public final void K3(float f2) {
        float f3;
        boolean z;
        NadRewardBigCardView nadRewardBigCardView = this.P;
        if (nadRewardBigCardView != null) {
            f3 = nadRewardBigCardView.getHeight();
        } else {
            f3 = 0.0f;
        }
        float e2 = ((e71.c.e(this) / e71.c.c(this)) * f3) / 2.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = (int) (f3 * f2);
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ms0 ms0Var = js0Var.j;
        if (ms0Var != null) {
            if (ms0Var.f > 0.0f) {
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
        NadRewardBigCardView nadRewardBigCardView2 = this.P;
        if (nadRewardBigCardView2 != null) {
            nadRewardBigCardView2.setLayoutParams(layoutParams2);
        }
    }

    public final void S2(Context context, js0 js0Var, String str) {
        String str2;
        String str3;
        xr0 xr0Var;
        xr0 xr0Var2;
        xr0 xr0Var3;
        boolean z = true;
        if (js0Var.n() && F2(js0Var)) {
            bs0 bs0Var = js0Var.m;
            String str4 = null;
            if (bs0Var != null && (xr0Var3 = bs0Var.p) != null) {
                str2 = xr0Var3.a;
            } else {
                str2 = null;
            }
            if (t61.d(str2)) {
                bs0 bs0Var2 = js0Var.m;
                if (bs0Var2 != null && (xr0Var2 = bs0Var2.p) != null) {
                    str3 = xr0Var2.b;
                } else {
                    str3 = null;
                }
                if (str3 != null && str3.length() != 0) {
                    z = false;
                }
                if (!z) {
                    ak0.b(str3);
                    return;
                } else if (context != null) {
                    bs0 bs0Var3 = js0Var.m;
                    if (bs0Var3 != null && (xr0Var = bs0Var3.p) != null) {
                        str4 = xr0Var.a;
                    }
                    Intrinsics.checkNotNull(str4);
                    nk0.b(context, str4);
                    return;
                } else {
                    return;
                }
            }
        }
        if (G2(str)) {
            q91 q91Var = this.F;
            if ((q91Var == null || !q91Var.isShowing()) && !I3() && !z2()) {
                C3(this, false, null, null, 6, null);
                return;
            }
            return;
        }
        if (js0Var.n()) {
            str = t61.b(js0Var, js0Var.g());
        }
        ak0.b(str);
    }

    public final void T2(Context context, js0 js0Var, boolean z) {
        String str;
        String str2;
        boolean z2;
        xr0 xr0Var;
        xr0 xr0Var2;
        xr0 xr0Var3;
        if (js0Var.n()) {
            if (F2(js0Var)) {
                bs0 bs0Var = js0Var.m;
                String str3 = null;
                if (bs0Var != null && (xr0Var3 = bs0Var.p) != null) {
                    str = xr0Var3.a;
                } else {
                    str = null;
                }
                if (t61.d(str)) {
                    bs0 bs0Var2 = js0Var.m;
                    if (bs0Var2 != null && (xr0Var2 = bs0Var2.p) != null) {
                        str2 = xr0Var2.b;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        ak0.b(str2);
                        return;
                    }
                    bs0 bs0Var3 = js0Var.m;
                    if (bs0Var3 != null && (xr0Var = bs0Var3.p) != null) {
                        str3 = xr0Var.a;
                    }
                    Intrinsics.checkNotNull(str3);
                    nk0.b(context, str3);
                    return;
                }
            }
            if (z) {
                C3(this, false, null, null, 6, null);
            } else {
                ak0.b(t61.b(js0Var, js0Var.g()));
            }
        } else if (G2(js0Var.f.c)) {
            C3(this, false, null, null, 6, null);
        } else {
            ak0.b(js0Var.f.c);
        }
    }

    public final void b3() {
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var.o()) {
            N2().setVisibility(0);
            NadRewardImageView N2 = N2();
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            N2.setData(js0Var2);
            N2().setClickCallBack(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initImageStyle$1
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
                    NadRewardVideoActivity.U2(nadRewardVideoActivity, nadRewardVideoActivity, NadRewardVideoActivity.Q1(nadRewardVideoActivity), false, 4, null);
                }
            });
            v3();
            return;
        }
        N2().setVisibility(8);
        K2().setVisibility(8);
    }

    public final boolean m3() {
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

    public final boolean y3() {
        M2().l();
        NadRewardTaskHelper nadRewardTaskHelper = this.Y;
        if (nadRewardTaskHelper != null && nadRewardTaskHelper.A()) {
            js0 js0Var = this.R;
            if (js0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            return H3(js0Var.h().c());
        } else if (this.e0) {
            return E3();
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            AbsRewardCountDownView absRewardCountDownView = this.D;
            if (absRewardCountDownView != null) {
                return D3(timeUnit.toSeconds(absRewardCountDownView.getMillisUntilFinished()));
            }
            return false;
        }
    }

    public final void h3() {
        os0 os0Var;
        os0 os0Var2;
        String str;
        os0 os0Var3;
        String str2;
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ms0 ms0Var = js0Var.j;
        NadRewardHalfTailHolder nadRewardHalfTailHolder = null;
        if (ms0Var != null) {
            os0Var = ms0Var.i;
        } else {
            os0Var = null;
        }
        if (os0Var != null) {
            js0 js0Var2 = this.R;
            if (js0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ss0 c2 = js0Var2.c();
            if (c2 == null || c2.q()) {
                js0 js0Var3 = this.R;
                if (js0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ms0 ms0Var2 = js0Var3.j;
                if (ms0Var2 != null && (os0Var2 = ms0Var2.i) != null) {
                    js0 js0Var4 = this.R;
                    if (js0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ms0 ms0Var3 = js0Var4.j;
                    if (ms0Var3 != null && (os0Var3 = ms0Var3.i) != null && (str2 = os0Var3.x) != null) {
                        aq0 aq0Var = this.S;
                        str = StringsKt__StringsJVMKt.replace$default(str2, "__COINTIPS__", (aq0Var == null || (r4 = aq0Var.e()) == null) ? "再看一个领取更多福利" : "再看一个领取更多福利", false, 4, (Object) null);
                    } else {
                        str = null;
                    }
                    os0Var2.x = str;
                }
                dq0 dq0Var = this.E;
                if (dq0Var != null) {
                    dq0Var.setVisibility(false);
                }
                dq0.a aVar = dq0.k0;
                js0 js0Var5 = this.R;
                if (js0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                dq0 a2 = aVar.a(js0Var5, this);
                this.E = a2;
                if (a2 != null) {
                    js0 js0Var6 = this.R;
                    if (js0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    a2.setData(js0Var6);
                }
                dq0 dq0Var2 = this.E;
                if (!(dq0Var2 instanceof View)) {
                    dq0Var2 = null;
                }
                View view2 = (View) dq0Var2;
                if (view2 != null) {
                    P2().removeAllViews();
                    P2().addView(view2);
                    P2().bringToFront();
                }
                dq0 dq0Var3 = this.E;
                if (dq0Var3 != null) {
                    dq0Var3.setOnReplayClickListener(new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.NadRewardVideoActivity$initTailFrame$2
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
                            dq0 dq0Var4 = NadRewardVideoActivity.this.E;
                            if (dq0Var4 != null) {
                                dq0Var4.setVisibility(false);
                            }
                            av0 av0Var = NadRewardVideoActivity.this.J;
                            if (av0Var != null) {
                                av0Var.start();
                            }
                        }
                    });
                }
                dq0 dq0Var4 = this.E;
                if (dq0Var4 instanceof NadRewardHalfTailHolder) {
                    nadRewardHalfTailHolder = dq0Var4;
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
        dq0 dq0Var5 = this.E;
        if (dq0Var5 != null) {
            dq0Var5.setVisibility(false);
        }
    }

    public final void j3() {
        as0 as0Var;
        int i2;
        os0 os0Var;
        NadRewardVideoAdOverContainer J2 = J2();
        js0 js0Var = this.R;
        if (js0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var.e() != null) {
            J2.setVisibility(8);
            return;
        }
        J2.setVisibility(0);
        J2.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var2.h().C()) {
            js0 js0Var3 = this.R;
            if (js0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str = js0Var3.f.c;
            Context context = J2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (l3(str, context)) {
                js0 js0Var4 = this.R;
                if (js0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bs0 bs0Var = js0Var4.m;
                if (bs0Var != null) {
                    bs0Var.g = true;
                }
                js0 js0Var5 = this.R;
                if (js0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ms0 ms0Var = js0Var5.j;
                if (ms0Var != null && (os0Var = ms0Var.i) != null) {
                    os0Var.C = true;
                }
            }
        }
        js0 js0Var6 = this.R;
        if (js0Var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var6.e() != null) {
            js0 js0Var7 = this.R;
            if (js0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            bs0 bs0Var2 = js0Var7.m;
            if (bs0Var2 != null) {
                bs0Var2.e = true;
            }
            js0 js0Var8 = this.R;
            if (js0Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            bs0 bs0Var3 = js0Var8.m;
            if (bs0Var3 != null) {
                js0 js0Var9 = this.R;
                if (js0Var9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (js0Var9.n()) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                bs0Var3.a = i2;
            }
            js0 js0Var10 = this.R;
            if (js0Var10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            bs0 bs0Var4 = js0Var10.m;
            if (bs0Var4 != null) {
                js0 js0Var11 = this.R;
                if (js0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                us0 e2 = js0Var11.e();
                Intrinsics.checkNotNull(e2);
                bs0Var4.p = e2.b();
            }
            js0 js0Var12 = this.R;
            if (js0Var12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            bs0 bs0Var5 = js0Var12.m;
            if (bs0Var5 != null && (as0Var = bs0Var5.q) != null) {
                js0 js0Var13 = this.R;
                if (js0Var13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                as0Var.d = js0Var13.f.d;
            }
        }
        js0 js0Var14 = this.R;
        if (js0Var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        J2.setData(js0Var14);
        js0 js0Var15 = this.R;
        if (js0Var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        if (js0Var15.m()) {
            J2.setBottomLineHeight(e71.c.a(J2.getContext(), 33.0f));
        } else {
            J2.setBottomLineHeight(e71.c.a(J2.getContext(), 10.0f));
        }
        J2.setOnUiClickListener(new k(J2, this));
        J2.setFeedbackBtnVisibility(false);
        J2.setFestivalClickCallback(new l(J2, this));
    }

    public final void k3() {
        boolean z;
        JSONObject put;
        bv0 bv0Var = new bv0();
        bv0Var.a = 2;
        boolean z2 = false;
        if (this.J == null) {
            this.J = av0.a.b(this, 0, bv0Var);
        }
        av0 av0Var = this.J;
        if (av0Var != null) {
            av0Var.attachToContainer(R2());
            n nVar = new n();
            nVar.n(true);
            av0Var.d(nVar);
            js0 js0Var = this.R;
            if (js0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ms0 ms0Var = js0Var.j;
            if (ms0Var != null && ms0Var.g) {
                av0Var.setVideoScalingMode(0);
            } else {
                av0Var.setVideoScalingMode(2);
            }
            av0Var.a(new m());
        }
        FrameLayout R2 = R2();
        R2.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = 0;
        R2.setLayoutParams(layoutParams);
        js0 js0Var2 = this.R;
        if (js0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        JSONObject jSONObject = null;
        if (js0Var2.j == null) {
            R2().setVisibility(8);
            this.J = null;
            return;
        }
        js0 js0Var3 = this.R;
        if (js0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        ms0 ms0Var2 = js0Var3.j;
        Intrinsics.checkNotNull(ms0Var2);
        String str = ms0Var2.j;
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
                    js0 js0Var4 = this.R;
                    if (js0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    jSONObject = put.put("ad_extra_param", js0Var4.f.d);
                }
                jSONObject2.putOpt(BasicVideoParserKt.EXT_LOG, String.valueOf(jSONObject));
                js0 js0Var5 = this.R;
                if (js0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ms0 ms0Var3 = js0Var5.j;
                Intrinsics.checkNotNull(ms0Var3);
                ms0Var3.j = jSONObject2.toString();
            } catch (Exception unused) {
            }
        }
        av0 av0Var2 = this.J;
        if (av0Var2 != null) {
            js0 js0Var6 = this.R;
            if (js0Var6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ms0 ms0Var4 = js0Var6.j;
            Intrinsics.checkNotNull(ms0Var4);
            av0Var2.c(ms0Var4);
        }
        if (NetUtil.a(this)) {
            js0 js0Var7 = this.R;
            if (js0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            ss0 c2 = js0Var7.c();
            if (c2 != null) {
                z2 = c2.q();
            }
            av0 av0Var3 = this.J;
            if (av0Var3 != null) {
                av0Var3.setLooping(!z2);
            }
            av0 av0Var4 = this.J;
            if (av0Var4 != null) {
                av0Var4.start();
                return;
            }
            return;
        }
        g61.a().a(this, R.string.nad_reward_video_lp_no_network);
    }

    public final boolean l3(String str, Context context) {
        Object m846constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new fk0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m846constructorimpl = Result.m846constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m846constructorimpl = Result.m846constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m852isFailureimpl(m846constructorimpl)) {
            m846constructorimpl = null;
        }
        String str3 = (String) m846constructorimpl;
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
    public final boolean o3() {
        Object m846constructorimpl;
        os0 os0Var;
        String str;
        os0 os0Var2;
        Boolean bool;
        boolean z;
        String d2;
        String str2;
        String replace$default;
        String str3;
        String d3;
        os0 os0Var3;
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
            m846constructorimpl = Result.m846constructorimpl(ResultKt.createFailure(th));
        }
        if (serializable != null) {
            m846constructorimpl = Result.m846constructorimpl(pq0.a.d((HashMap) serializable));
            if (Result.m853isSuccessimpl(m846constructorimpl)) {
                js0 js0Var = (js0) m846constructorimpl;
                this.R = js0Var;
                if (js0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ms0 ms0Var = js0Var.j;
                String str7 = "";
                if (ms0Var != null && (os0Var3 = ms0Var.i) != null) {
                    js0 js0Var2 = this.R;
                    if (js0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (js0Var2.n()) {
                        String str8 = os0Var3.f;
                        if (str8 != null) {
                            js0 js0Var3 = this.R;
                            if (js0Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str8, "__CONVERT_CMD__", js0Var3.g(), false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        os0Var3.f = replace$default2;
                    } else {
                        String str9 = os0Var3.f;
                        if (str9 != null) {
                            js0 js0Var4 = this.R;
                            if (js0Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            bs0 bs0Var = js0Var4.m;
                            if (bs0Var == null || (str5 = bs0Var.t) == null) {
                                str4 = "";
                            } else {
                                str4 = str5;
                            }
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str9, "__CONVERT_CMD__", str4, false, 4, (Object) null);
                        }
                        replace$default2 = "";
                        os0Var3.f = replace$default2;
                    }
                }
                js0 js0Var5 = this.R;
                if (js0Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                rs0 b2 = js0Var5.b();
                if (b2 != null) {
                    js0 js0Var6 = this.R;
                    if (js0Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    if (js0Var6.n()) {
                        js0 js0Var7 = this.R;
                        if (js0Var7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        rs0 b3 = js0Var7.b();
                        if (b3 != null && (d3 = b3.d()) != null) {
                            js0 js0Var8 = this.R;
                            if (js0Var8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d3, "__CONVERT_CMD__", js0Var8.g(), false, 4, (Object) null);
                        }
                        b2.h(str7);
                    } else {
                        js0 js0Var9 = this.R;
                        if (js0Var9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adModel");
                        }
                        rs0 b4 = js0Var9.b();
                        if (b4 != null && (d2 = b4.d()) != null) {
                            js0 js0Var10 = this.R;
                            if (js0Var10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            bs0 bs0Var2 = js0Var10.m;
                            if (bs0Var2 == null || (str3 = bs0Var2.t) == null) {
                                str2 = "";
                            } else {
                                str2 = str3;
                            }
                            replace$default = StringsKt__StringsJVMKt.replace$default(d2, "__CONVERT_CMD__", str2, false, 4, (Object) null);
                        }
                        b2.h(str7);
                    }
                }
                js0 js0Var11 = this.R;
                if (js0Var11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bs0 bs0Var3 = js0Var11.m;
                boolean z2 = true;
                if (bs0Var3 != null) {
                    bs0Var3.d = true;
                }
                js0 js0Var12 = this.R;
                if (js0Var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bs0 bs0Var4 = js0Var12.m;
                if (bs0Var4 != null) {
                    js0 js0Var13 = this.R;
                    if (js0Var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ss0 c2 = js0Var13.c();
                    if (c2 != null) {
                        z = c2.f();
                    } else {
                        z = false;
                    }
                    bs0Var4.f = z;
                }
                js0 js0Var14 = this.R;
                if (js0Var14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ms0 ms0Var2 = js0Var14.j;
                if (ms0Var2 != null && (os0Var2 = ms0Var2.i) != null) {
                    js0 js0Var15 = this.R;
                    if (js0Var15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ss0 c3 = js0Var15.c();
                    if (c3 != null) {
                        bool = Boolean.valueOf(c3.s());
                    } else {
                        bool = null;
                    }
                    os0Var2.D = bool;
                }
                js0 js0Var16 = this.R;
                if (js0Var16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ms0 ms0Var3 = js0Var16.j;
                if (ms0Var3 != null && (os0Var = ms0Var3.i) != null) {
                    js0 js0Var17 = this.R;
                    if (js0Var17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    ss0 c4 = js0Var17.c();
                    if (c4 != null) {
                        str = c4.r();
                    } else {
                        str = null;
                    }
                    os0Var.E = str;
                }
                vp0 vp0Var = (vp0) ServiceManager.getService(vp0.a);
                js0 js0Var18 = this.R;
                if (js0Var18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                if (js0Var18.h().u().length() != 0) {
                    z2 = false;
                }
                if (z2 && vp0Var != null) {
                    js0 js0Var19 = this.R;
                    if (js0Var19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    dt0 h2 = js0Var19.h();
                    String a2 = vp0Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "nadRewardLpBDTaskCenterImpl.taskId");
                    h2.F(a2);
                }
                js0 js0Var20 = this.R;
                if (js0Var20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                bs0 bs0Var5 = js0Var20.m;
                if (bs0Var5 != null) {
                    js0 js0Var21 = this.R;
                    if (js0Var21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    List<MonitorUrl> list = js0Var21.e;
                    Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
                    bs0Var5.h = list;
                }
                js0 js0Var22 = this.R;
                if (js0Var22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                ts0 f2 = js0Var22.h().f();
                if (f2 != null) {
                    str6 = f2.c();
                }
                this.c0 = Intrinsics.areEqual(str6, "0");
            }
            Throwable m849exceptionOrNullimpl = Result.m849exceptionOrNullimpl(m846constructorimpl);
            if (m849exceptionOrNullimpl != null && ai0.a) {
                g61.a().showToast(this, m849exceptionOrNullimpl.getMessage());
            }
            return Result.m853isSuccessimpl(m846constructorimpl);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final void q3(String str, String str2, HashMap<String, String> hashMap) {
        bq0 bq0Var = new bq0();
        bq0Var.a = str;
        bq0Var.b = hashMap;
        do0.a().a(bq0Var);
    }
}
