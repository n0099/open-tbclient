package com.baidu.bdtask;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.b;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.event.TaskBusinessEventManager;
import com.baidu.bdtask.framework.redux.d;
import com.baidu.bdtask.framework.redux.e;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.service.cache.storage.c;
import com.baidu.bdtask.service.ubc.model.UBCActionTaskInfo;
import com.baidu.bdtask.utils.UniqueId;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.tieba.du;
import com.baidu.tieba.eu;
import com.baidu.tieba.fr;
import com.baidu.tieba.fu;
import com.baidu.tieba.gq;
import com.baidu.tieba.gr;
import com.baidu.tieba.gt;
import com.baidu.tieba.hq;
import com.baidu.tieba.hs;
import com.baidu.tieba.hu;
import com.baidu.tieba.ip;
import com.baidu.tieba.iq;
import com.baidu.tieba.jp;
import com.baidu.tieba.jq;
import com.baidu.tieba.jr;
import com.baidu.tieba.js;
import com.baidu.tieba.kp;
import com.baidu.tieba.kq;
import com.baidu.tieba.kt;
import com.baidu.tieba.lp;
import com.baidu.tieba.lq;
import com.baidu.tieba.ls;
import com.baidu.tieba.lu;
import com.baidu.tieba.mp;
import com.baidu.tieba.mq;
import com.baidu.tieba.ms;
import com.baidu.tieba.nq;
import com.baidu.tieba.ns;
import com.baidu.tieba.nt;
import com.baidu.tieba.pq;
import com.baidu.tieba.qq;
import com.baidu.tieba.qt;
import com.baidu.tieba.rq;
import com.baidu.tieba.sq;
import com.baidu.tieba.uq;
import com.baidu.tieba.uu;
import com.baidu.tieba.vu;
import com.baidu.tieba.wv;
import com.baidu.tieba.xq;
import com.baidu.tieba.yq;
import com.baidu.tieba.yu;
import com.baidu.tieba.zq;
import com.baidu.tieba.zu;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0099\u0001:\u0002\u0099\u0001B\n\b\u0002¢\u0006\u0005\b\u0098\u0001\u0010\u001dJ\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0007J'\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\tJ\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\f\u0010\u000eJ/\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\f\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0001H\u0000¢\u0006\u0004\b \u0010\u0005J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0001H\u0016¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0001H\u0016¢\u0006\u0004\b$\u0010\u0005J\u0017\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010.\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00012\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b/\u0010\u001bJ5\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020403022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000100\"\u00020\u0001H\u0016¢\u0006\u0004\b5\u00106J+\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u0002072\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000100\"\u00020\u0001H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u0004\u0018\u0001042\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J%\u0010@\u001a\u0004\u0018\u0001042\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000100\"\u00020\u0001H\u0016¢\u0006\u0004\b@\u0010AJ+\u0010B\u001a\u00020\u00032\u0006\u00108\u001a\u00020=2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000100\"\u00020\u0001H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bE\u0010FJ\u0011\u0010G\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\bG\u0010HJ\u001f\u0010M\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010J\u001a\u00020IH\u0000¢\u0006\u0004\bK\u0010LJ\u001f\u0010P\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ=\u0010X\u001a\u00020\u0003\"\b\b\u0000\u0010S*\u00020R2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000T2\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000VH\u0016¢\u0006\u0004\bX\u0010YJ\u001f\u0010[\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u001f\u0010^\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010O\u001a\u00020]H\u0002¢\u0006\u0004\b^\u0010_J'\u0010^\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010O\u001a\u00020]2\u0006\u0010`\u001a\u00020\u0010H\u0002¢\u0006\u0004\b^\u0010aJ\u001f\u0010b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010O\u001a\u00020]H\u0002¢\u0006\u0004\bb\u0010_J\u001f\u0010d\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u00012\u0006\u0010O\u001a\u00020]H\u0016¢\u0006\u0004\bd\u0010eJ#\u0010f\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010O\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bf\u0010_J+\u0010f\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00020\u00102\b\u0010O\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bf\u0010hJ5\u0010f\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00020\u00102\b\u0010O\u001a\u0004\u0018\u00010]2\b\u0010j\u001a\u0004\u0018\u00010iH\u0002¢\u0006\u0004\bf\u0010kJ\u0017\u0010f\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u0001H\u0016¢\u0006\u0004\bf\u0010\u0005J!\u0010f\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u00012\b\u0010O\u001a\u0004\u0018\u00010]H\u0016¢\u0006\u0004\bf\u0010eJ+\u0010f\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u00012\b\u0010O\u001a\u0004\u0018\u00010]2\b\u0010j\u001a\u0004\u0018\u00010iH\u0016¢\u0006\u0004\bf\u0010mJ\u0017\u0010n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\bn\u0010oJ\u0017\u0010n\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\bn\u0010\u0005J\u0017\u0010q\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\bp\u0010oJ\u001f\u0010r\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010j\u001a\u00020iH\u0002¢\u0006\u0004\br\u0010sJ\u001f\u0010r\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010j\u001a\u00020iH\u0016¢\u0006\u0004\br\u0010tJ\u001f\u0010x\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010W\u001a\u00020uH\u0000¢\u0006\u0004\bv\u0010wJ\u0017\u0010y\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\by\u0010oJ/\u0010~\u001a\u00020\u00032\u0006\u0010z\u001a\u00020\u00012\u0006\u0010{\u001a\u00020\u00012\u0006\u0010|\u001a\u00020I2\u0006\u00108\u001a\u00020}H\u0016¢\u0006\u0004\b~\u0010\u007fJ<\u0010~\u001a\u00020\u00032\u0006\u0010z\u001a\u00020\u00012\u0006\u0010{\u001a\u00020\u00012\u0006\u0010|\u001a\u00020I2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u00108\u001a\u00020}H\u0016¢\u0006\u0005\b~\u0010\u0082\u0001J\u001c\u0010\u0084\u0001\u001a\u00020\u00032\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0005\b\u0084\u0001\u0010\u0005J!\u0010\u0085\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0005\b\u0085\u0001\u0010QJ2\u0010\u0086\u0001\u001a\u00020\u0003\"\b\b\u0000\u0010S*\u00020R2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000VH\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J!\u0010\u0088\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u00020ZH\u0016¢\u0006\u0005\b\u0088\u0001\u0010\\J!\u0010\u0089\u0001\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010O\u001a\u00020]H\u0002¢\u0006\u0005\b\u0089\u0001\u0010_J!\u0010\u008a\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010O\u001a\u00020]H\u0016¢\u0006\u0005\b\u008a\u0001\u0010eJ\u0019\u0010\u008b\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0005\b\u008b\u0001\u0010\u0005J\"\u0010\u008b\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u0001H\u0000¢\u0006\u0005\b\u008d\u0001\u0010\u0007R\u001a\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R'\u0010\u0096\u0001\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001¨\u0006\u009a\u0001"}, d2 = {"Lcom/baidu/bdtask/BDPTask;", "", "actionId", "", "addActionWithActionId", "(Ljava/lang/String;)V", "duplicateId", "(Ljava/lang/String;Ljava/lang/String;)V", "tag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "sliceTimeMs", "addDurationWithActionId", "(Ljava/lang/String;J)V", "(Ljava/lang/String;JLjava/lang/String;)V", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "", TTDownloadField.TT_FORCE, "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "appStateASync", "(ZLcom/baidu/bdtask/model/info/TaskInfo;)V", "Landroid/app/Activity;", "curActivity", "attachCurActivity", "(Landroid/app/Activity;)V", "cacheDuplicateId", "(Ljava/lang/String;Ljava/lang/String;)Z", "cleanAllCallbacks$lib_bdtask_business_build_release", "()V", "cleanAllCallbacks", "taskInfoKey", "cleanTaskNoClickTimes$lib_bdtask_business_build_release", "cleanTaskNoClickTimes", TaskInfo.keyActTaskId, "clearPassiveTaskByActTaskId", "clearTaskByActTaskId", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "subState", "dispatchState", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)V", "taskSingleKey", "Lcom/baidu/bdtask/utils/UniqueId;", "eventId", "dispatchTaskBusinessEvent$lib_bdtask_business_build_release", "(Ljava/lang/String;Lcom/baidu/bdtask/utils/UniqueId;)V", "dispatchTaskBusinessEvent", "duplicateIdIsRepeatedByActionId", "", "actionIds", "", "", "Lcom/baidu/bdtask/TaskState;", "findAllTaskStateByActionIds", "([Ljava/lang/String;)Ljava/util/Map;", "Lcom/baidu/bdtask/TaskAllStateCallback;", WebChromeClient.KEY_ARG_CALLBACK, "findAllTaskStateByActionIdsAsync", "(Lcom/baidu/bdtask/TaskAllStateCallback;[Ljava/lang/String;)V", "findTaskStateByActionId", "(Ljava/lang/String;)Lcom/baidu/bdtask/TaskState;", "Lcom/baidu/bdtask/TaskStateCallback;", "findTaskStateByActionIdAsync", "(Ljava/lang/String;Lcom/baidu/bdtask/TaskStateCallback;)V", "findTaskStateByActionIds", "([Ljava/lang/String;)Lcom/baidu/bdtask/TaskState;", "findTaskStateByActionIdsAsync", "(Lcom/baidu/bdtask/TaskStateCallback;[Ljava/lang/String;)V", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "getAppState", "()Lcom/baidu/bdtask/ctrl/BDPTaskState;", "getCurActiveTaskState", "()Lcom/baidu/bdtask/TaskState;", "", "errNo", "interruptPassiveTask$lib_bdtask_business_build_release", "(Lcom/baidu/bdtask/model/info/TaskInfo;I)V", "interruptPassiveTask", "Lcom/baidu/bdtask/callbacks/PassiveTaskCallback;", "taskCallback", "registerPassiveTaskListenerWithActionId", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/PassiveTaskCallback;)V", "Lcom/baidu/bdtask/event/TaskBusinessEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "eventClass", "Lcom/baidu/bdtask/event/TaskBusinessEventAction;", "action", "registerTaskBusinessEventAction", "(Ljava/lang/String;Ljava/lang/Class;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "Lcom/baidu/bdtask/event/TaskBusinessEventCallback;", "registerTaskBusinessEventListener", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventCallback;)V", "Lcom/baidu/bdtask/callbacks/TaskCallback;", "registerTaskListener", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "sticky", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/callbacks/TaskCallback;Z)V", "registerTaskListenerSticky", "actonId", "registerTaskListenerWithActionId", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "registerTaskWithInfo", "reset", "(Lcom/baidu/bdtask/model/info/TaskInfo;ZLcom/baidu/bdtask/callbacks/TaskCallback;)V", "Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;", "taskInterceptor", "(Lcom/baidu/bdtask/model/info/TaskInfo;ZLcom/baidu/bdtask/callbacks/TaskCallback;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "rawTaskStr", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/TaskCallback;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "removeTaskInterceptor", "(Lcom/baidu/bdtask/model/info/TaskInfo;)V", "resetTaskInfo2Running$lib_bdtask_business_build_release", "resetTaskInfo2Running", "setTaskInterceptor", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "(Ljava/lang/String;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "Lcom/baidu/bdtask/framework/redux/Action;", "storeDispatch$lib_bdtask_business_build_release", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/framework/redux/Action;)V", "storeDispatch", "subscribeStore", "token", "taskId", TaskInfo.keyBehavior, "Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;", "taskCompletedRequest", "(Ljava/lang/String;Ljava/lang/String;ILcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "Lorg/json/JSONObject;", LaunchStatsUtils.EXTERNAL_LAUNCH, "(Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "taskStateStr", "taskStateRestore", "unRegisterPassiveTaskListenerWithActionId", "unRegisterTaskBusinessEventAction", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "unRegisterTaskBusinessEventListener", "unRegisterTaskListener", "unRegisterTaskListenerWithActionId", "unregisterTaskWithActionId", "unRegisterMsg", "unregisterTaskWithActionId$lib_bdtask_business_build_release", "Lcom/baidu/bdtask/strategy/ExceptionStrategyImpl;", "exceptionStrategy", "Lcom/baidu/bdtask/strategy/ExceptionStrategyImpl;", "Lcom/baidu/bdtask/strategy/LifecycleStrategyImpl;", "lifecycleStrategy", "Lcom/baidu/bdtask/strategy/LifecycleStrategyImpl;", "Lcom/baidu/bdtask/framework/redux/Store;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "store", "Lcom/baidu/bdtask/framework/redux/Store;", "<init>", "INSTANCE", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class BDPTask {
    public static /* synthetic */ Interceptable $ic;
    public static final du d;
    public static BDPTask e;
    public static volatile boolean f;
    public static volatile boolean g;
    public static final ReentrantLock h;
    public static final Condition i;
    public static BDPTask j;
    public static final ConcurrentLinkedQueue<Function0<Object>> k;
    public static hu l;
    public static final INSTANCE m;
    public transient /* synthetic */ FieldHolder $fh;
    public final d<b, rq> a;
    public final yu b;
    public final vu c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u0000B\n\b\u0002¢\u0006\u0005\b¡\u0001\u0010\u0011J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0007J'\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\tJ\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\f\u0010\u000eJ/\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\f\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u001f\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ7\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0018\u00010\"2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010 \"\u00020\u0001H\u0016¢\u0006\u0004\b%\u0010&J+\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010 \"\u00020\u0001H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u0004\u0018\u00010$2\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010(\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J%\u00100\u001a\u0004\u0018\u00010$2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010 \"\u00020\u0001H\u0016¢\u0006\u0004\b0\u00101J+\u00102\u001a\u00020\u00032\u0006\u0010(\u001a\u00020-2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010 \"\u00020\u0001H\u0016¢\u0006\u0004\b2\u00103J\u0011\u00104\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0019¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u00032\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0003H\u0003¢\u0006\u0004\b?\u0010\u0011J\u001f\u0010B\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ=\u0010J\u001a\u00020\u0003\"\b\b\u0000\u0010E*\u00020D2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000F2\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000HH\u0016¢\u0006\u0004\bJ\u0010KJ\u001f\u0010M\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010(\u001a\u00020LH\u0016¢\u0006\u0004\bM\u0010NJ\u001d\u0010R\u001a\u00020\u00032\u0006\u0010P\u001a\u00020O2\u0006\u0010A\u001a\u00020Q¢\u0006\u0004\bR\u0010SJ\u001f\u0010U\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u00012\u0006\u0010A\u001a\u00020QH\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u0001H\u0016¢\u0006\u0004\bX\u0010\u0005J!\u0010X\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u00012\b\u0010A\u001a\u0004\u0018\u00010QH\u0016¢\u0006\u0004\bX\u0010VJ+\u0010X\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u00012\b\u0010A\u001a\u0004\u0018\u00010Q2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0016¢\u0006\u0004\bX\u0010[J\u000f\u0010\\\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\\\u0010\u0011J\u0017\u0010]\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b]\u0010\u0005J\u001f\u0010^\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020YH\u0016¢\u0006\u0004\b^\u0010_J/\u0010e\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00012\u0006\u0010a\u001a\u00020\u00012\u0006\u0010c\u001a\u00020b2\u0006\u0010(\u001a\u00020dH\u0016¢\u0006\u0004\be\u0010fJ9\u0010e\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00012\u0006\u0010a\u001a\u00020\u00012\u0006\u0010c\u001a\u00020b2\b\u0010h\u001a\u0004\u0018\u00010g2\u0006\u0010(\u001a\u00020dH\u0016¢\u0006\u0004\be\u0010iJ\u001f\u0010j\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bj\u0010CJ/\u0010k\u001a\u00020\u0003\"\b\b\u0000\u0010E*\u00020D2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000HH\u0016¢\u0006\u0004\bk\u0010lJ\u001f\u0010m\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010(\u001a\u00020LH\u0016¢\u0006\u0004\bm\u0010NJ\u001f\u0010n\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u00012\u0006\u0010A\u001a\u00020QH\u0016¢\u0006\u0004\bn\u0010VJ\u0017\u0010o\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\bo\u0010\u0005J1\u0010r\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010E2\b\b\u0002\u0010p\u001a\u00020\u00192\u000e\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000qH\u0002¢\u0006\u0004\br\u0010sR*\u0010v\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010u0q0t8\u0002@\u0002X\u0082\u0004¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u001c\u0010{\u001a\u00020z8\u0002@\u0002X\u0082\u0004¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R&\u0010\u007f\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0016\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u0010:\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\"\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R,\u0010\u008b\u0001\u001a\r \u008a\u0001*\u0005\u0018\u00010\u0089\u00010\u0089\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R(\u0010\u008f\u0001\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0017\n\u0006\b\u008f\u0001\u0010\u0080\u0001\u001a\u0005\b\u0090\u0001\u0010:\"\u0006\b\u0091\u0001\u0010\u0083\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R,\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u0094\u0001\u001a\u0006\b\u009a\u0001\u0010\u0096\u0001\"\u0006\b\u009b\u0001\u0010\u0098\u0001R*\u0010\u009c\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0017\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0005\b\u009e\u0001\u00108\"\u0006\b\u009f\u0001\u0010 \u0001¨\u0006¢\u0001"}, d2 = {"Lcom/baidu/bdtask/BDPTask$INSTANCE;", "", "actionId", "", "addActionWithActionId", "(Ljava/lang/String;)V", "duplicateId", "(Ljava/lang/String;Ljava/lang/String;)V", "tag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "sliceTimeMs", "addDurationWithActionId", "(Ljava/lang/String;J)V", "(Ljava/lang/String;JLjava/lang/String;)V", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "asyncLockNotify", "()V", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "asyncLockWait", "(J)V", "Landroid/app/Activity;", "curActivity", "attachCurActivity", "(Landroid/app/Activity;)V", "", "cacheDuplicateId", "(Ljava/lang/String;Ljava/lang/String;)Z", TaskInfo.keyActTaskId, "clearPassiveTaskByActTaskId", "clearTaskByActTaskId", "duplicateIdIsRepeatedByActionId", "", "actionIds", "", "", "Lcom/baidu/bdtask/TaskState;", "findAllTaskStateByActionIds", "([Ljava/lang/String;)Ljava/util/Map;", "Lcom/baidu/bdtask/TaskAllStateCallback;", WebChromeClient.KEY_ARG_CALLBACK, "findAllTaskStateByActionIdsAsync", "(Lcom/baidu/bdtask/TaskAllStateCallback;[Ljava/lang/String;)V", "findTaskStateByActionId", "(Ljava/lang/String;)Lcom/baidu/bdtask/TaskState;", "Lcom/baidu/bdtask/TaskStateCallback;", "findTaskStateByActionIdAsync", "(Ljava/lang/String;Lcom/baidu/bdtask/TaskStateCallback;)V", "findTaskStateByActionIds", "([Ljava/lang/String;)Lcom/baidu/bdtask/TaskState;", "findTaskStateByActionIdsAsync", "(Lcom/baidu/bdtask/TaskStateCallback;[Ljava/lang/String;)V", "getCurActiveTaskState", "()Lcom/baidu/bdtask/TaskState;", "Lcom/baidu/bdtask/service/base/TaskService;", "getServiceManager", "()Lcom/baidu/bdtask/service/base/TaskService;", "hasInitialized", "()Z", "Lcom/baidu/bdtask/BDPTaskConfig;", "bdpTaskConfig", "init", "(Lcom/baidu/bdtask/BDPTaskConfig;)V", "offerActionQueue", "Lcom/baidu/bdtask/callbacks/PassiveTaskCallback;", "taskCallback", "registerPassiveTaskListenerWithActionId", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/PassiveTaskCallback;)V", "Lcom/baidu/bdtask/event/TaskBusinessEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "eventType", "Lcom/baidu/bdtask/event/TaskBusinessEventAction;", "action", "registerTaskBusinessEventAction", "(Ljava/lang/String;Ljava/lang/Class;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "Lcom/baidu/bdtask/event/TaskBusinessEventCallback;", "registerTaskBusinessEventListener", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventCallback;)V", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/callbacks/TaskCallback;", "registerTaskListenerSticky", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "actonId", "registerTaskListenerWithActionId", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "rawTaskStr", "registerTaskWithInfo", "Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;", "taskInterceptor", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/TaskCallback;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "release", "removeTaskInterceptor", "setTaskInterceptor", "(Ljava/lang/String;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "token", "taskId", "", TaskInfo.keyBehavior, "Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;", "taskCompletedRequest", "(Ljava/lang/String;Ljava/lang/String;ILcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "Lorg/json/JSONObject;", LaunchStatsUtils.EXTERNAL_LAUNCH, "(Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "unRegisterPassiveTaskListenerWithActionId", "unRegisterTaskBusinessEventAction", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "unRegisterTaskBusinessEventListener", "unRegisterTaskListenerWithActionId", "unregisterTaskWithActionId", "aSync", "Lkotlin/Function0;", "withCheck", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "actionQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getActionQueue", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/baidu/bdtask/service/env/TaskActivityLifecycleCallbacks;", "activityLifecycleCallbacks", "Lcom/baidu/bdtask/service/env/TaskActivityLifecycleCallbacks;", "getActivityLifecycleCallbacks", "()Lcom/baidu/bdtask/service/env/TaskActivityLifecycleCallbacks;", "asyncLoaded", "Z", "getAsyncLoaded", "setAsyncLoaded", "(Z)V", "Ljava/util/concurrent/locks/ReentrantLock;", "asyncLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getAsyncLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "asyncLockCondition", "Ljava/util/concurrent/locks/Condition;", "getAsyncLockCondition", "()Ljava/util/concurrent/locks/Condition;", "initialized", "getInitialized", "setInitialized", "Lcom/baidu/bdtask/BDPTask;", "innerInstance", "Lcom/baidu/bdtask/BDPTask;", "getInnerInstance$lib_bdtask_business_build_release", "()Lcom/baidu/bdtask/BDPTask;", "setInnerInstance$lib_bdtask_business_build_release", "(Lcom/baidu/bdtask/BDPTask;)V", Transition.MATCH_INSTANCE_STR, "getInstance", "setInstance", "taskServiceManager", "Lcom/baidu/bdtask/service/base/TaskService;", "getTaskServiceManager", "setTaskServiceManager", "(Lcom/baidu/bdtask/service/base/TaskService;)V", "<init>", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes.dex */
    public static final class INSTANCE {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static final class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public static final a a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(821377662, "Lcom/baidu/bdtask/BDPTask$INSTANCE$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(821377662, "Lcom/baidu/bdtask/BDPTask$INSTANCE$a;");
                        return;
                    }
                }
                a = new a();
            }

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    c.i.a().m();
                    BDPTask.m.E(new BDPTask(null));
                    INSTANCE instance = BDPTask.m;
                    instance.D(instance.u());
                    String a2 = com.baidu.bdtask.service.cache.b.e.a().a();
                    BDPTask u = BDPTask.m.u();
                    if (u != null) {
                        u.n0(a2);
                    }
                    BDPTask.m.B(true);
                    BDPTask.m.j();
                    BDPTask.m.y();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("async init cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public static final b a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(821377693, "Lcom/baidu/bdtask/BDPTask$INSTANCE$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(821377693, "Lcom/baidu/bdtask/BDPTask$INSTANCE$b;");
                        return;
                    }
                }
                a = new b();
            }

            public b() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    while (!BDPTask.m.n().isEmpty()) {
                        Function0 function0 = (Function0) BDPTask.m.n().poll();
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }
                }
            }
        }

        public INSTANCE() {
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

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                ReentrantLock q = q();
                q.lock();
                try {
                    BDPTask.m.r().signalAll();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    q.unlock();
                }
            }
        }

        public final ConcurrentLinkedQueue<Function0<Object>> n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048592, this)) != null) {
                return (ConcurrentLinkedQueue) invokeV.objValue;
            }
            return BDPTask.k;
        }

        public final du o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048593, this)) != null) {
                return (du) invokeV.objValue;
            }
            return BDPTask.d;
        }

        public final boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048594, this)) != null) {
                return invokeV.booleanValue;
            }
            return BDPTask.g;
        }

        public final ReentrantLock q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048595, this)) != null) {
                return (ReentrantLock) invokeV.objValue;
            }
            return BDPTask.h;
        }

        public final Condition r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048596, this)) != null) {
                return (Condition) invokeV.objValue;
            }
            return BDPTask.i;
        }

        public final boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048597, this)) != null) {
                return invokeV.booleanValue;
            }
            return BDPTask.f;
        }

        public final BDPTask t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048598, this)) != null) {
                return (BDPTask) invokeV.objValue;
            }
            return BDPTask.e;
        }

        public final BDPTask u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048599, this)) != null) {
                return (BDPTask) invokeV.objValue;
            }
            return BDPTask.j;
        }

        public final hu v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                if (s()) {
                    return w();
                }
                return null;
            }
            return (hu) invokeV.objValue;
        }

        public final hu w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048601, this)) != null) {
                return (hu) invokeV.objValue;
            }
            return BDPTask.l;
        }

        public final synchronized void y() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
                synchronized (this) {
                    if (p() && !n().isEmpty()) {
                        kt.c(b.a);
                    }
                }
            }
        }

        public /* synthetic */ INSTANCE(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void B(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) {
                return;
            }
            BDPTask.g = z;
        }

        public final void C(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
                return;
            }
            BDPTask.f = z;
        }

        public final void D(BDPTask bDPTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, bDPTask) != null) {
                return;
            }
            BDPTask.e = bDPTask;
        }

        public final void E(BDPTask bDPTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048580, this, bDPTask) != null) {
                return;
            }
            BDPTask.j = bDPTask;
        }

        public final void F(hu huVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048581, this, huVar) != null) {
                return;
            }
            BDPTask.l = huVar;
        }

        public void I(final String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                K(this, false, new Function0<Unit>(str) { // from class: com.baidu.bdtask.BDPTask$INSTANCE$unregisterTaskWithActionId$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $actionId;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$actionId = str;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            BDPTask u = BDPTask.m.u();
                            if (u != null) {
                                u.t0(this.$actionId);
                                return Unit.INSTANCE;
                            }
                            return null;
                        }
                        return (Unit) invokeV.objValue;
                    }
                }, 1, null);
            }
        }

        public void h(final String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                K(this, false, new Function0<Unit>(str) { // from class: com.baidu.bdtask.BDPTask$INSTANCE$addActionWithActionId$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $actionId;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$actionId = str;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            BDPTask u = BDPTask.m.u();
                            if (u != null) {
                                u.s(this.$actionId);
                                return Unit.INSTANCE;
                            }
                            return null;
                        }
                        return (Unit) invokeV.objValue;
                    }
                }, 1, null);
            }
        }

        public final void k(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
                ReentrantLock q = q();
                q.lock();
                try {
                    BDPTask.m.r().await(j, TimeUnit.MILLISECONDS);
                } finally {
                    q.unlock();
                }
            }
        }

        public TaskState m(final String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
                return (TaskState) J(false, new Function0<TaskState>(str) { // from class: com.baidu.bdtask.BDPTask$INSTANCE$findTaskStateByActionId$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $actionId;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$actionId = str;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TaskState invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                            return (TaskState) invokeV.objValue;
                        }
                        BDPTask u = BDPTask.m.u();
                        if (u != null) {
                            return u.K(this.$actionId);
                        }
                        return null;
                    }
                });
            }
            return (TaskState) invokeL.objValue;
        }

        public static /* synthetic */ Object K(INSTANCE instance, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return instance.J(z, function0);
        }

        public void A(final String str, final mp mpVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, mpVar) == null) {
                K(this, false, new Function0<Unit>(str, mpVar) { // from class: com.baidu.bdtask.BDPTask$INSTANCE$registerTaskWithInfo$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $rawTaskStr;
                    public final /* synthetic */ mp $taskCallback;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, mpVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$rawTaskStr = str;
                        this.$taskCallback = mpVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            BDPTask u = BDPTask.m.u();
                            if (u != null) {
                                u.c0(this.$rawTaskStr, this.$taskCallback);
                                return Unit.INSTANCE;
                            }
                            return null;
                        }
                        return (Unit) invokeV.objValue;
                    }
                }, 1, null);
            }
        }

        public void H(final String str, final mp mpVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, mpVar) == null) {
                K(this, false, new Function0<Unit>(str, mpVar) { // from class: com.baidu.bdtask.BDPTask$INSTANCE$unRegisterTaskListenerWithActionId$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $actonId;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ mp $taskCallback;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, mpVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$actonId = str;
                        this.$taskCallback = mpVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            BDPTask u = BDPTask.m.u();
                            if (u != null) {
                                u.s0(this.$actonId, this.$taskCallback);
                                return Unit.INSTANCE;
                            }
                            return null;
                        }
                        return (Unit) invokeV.objValue;
                    }
                }, 1, null);
            }
        }

        public boolean l(final String str, final String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
                Boolean bool = (Boolean) K(this, false, new Function0<Boolean>(str, str2) { // from class: com.baidu.bdtask.BDPTask$INSTANCE$duplicateIdIsRepeatedByActionId$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $actionId;
                    public final /* synthetic */ String $duplicateId;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$actionId = str;
                        this.$duplicateId = str2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                            return (Boolean) invokeV.objValue;
                        }
                        BDPTask u = BDPTask.m.u();
                        if (u != null) {
                            return Boolean.valueOf(u.H(this.$actionId, this.$duplicateId));
                        }
                        return null;
                    }
                }, 1, null);
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            }
            return invokeLL.booleanValue;
        }

        public final void z(final TaskInfo taskInfo, final mp mpVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048604, this, taskInfo, mpVar) == null) {
                K(this, false, new Function0<Unit>(taskInfo, mpVar) { // from class: com.baidu.bdtask.BDPTask$INSTANCE$registerTaskListenerSticky$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ mp $taskCallback;
                    public final /* synthetic */ TaskInfo $taskInfo;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {taskInfo, mpVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$taskInfo = taskInfo;
                        this.$taskCallback = mpVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            BDPTask u = BDPTask.m.u();
                            if (u == null) {
                                return null;
                            }
                            u.W(this.$taskInfo, this.$taskCallback);
                            return Unit.INSTANCE;
                        }
                        return (Unit) invokeV.objValue;
                    }
                }, 1, null);
            }
        }

        public void G(final String str, final String str2, final int i, final JSONObject jSONObject, final uq uqVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), jSONObject, uqVar}) == null) {
                K(this, false, new Function0<Unit>(str, str2, i, jSONObject, uqVar) { // from class: com.baidu.bdtask.BDPTask$INSTANCE$taskCompletedRequest$2
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ int $behavior;
                    public final /* synthetic */ uq $callback;
                    public final /* synthetic */ JSONObject $external;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $taskId;
                    public final /* synthetic */ String $token;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, str2, Integer.valueOf(i), jSONObject, uqVar};
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
                        this.$token = str;
                        this.$taskId = str2;
                        this.$behavior = i;
                        this.$external = jSONObject;
                        this.$callback = uqVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            BDPTask u = BDPTask.m.u();
                            if (u != null) {
                                u.m0(this.$token, this.$taskId, this.$behavior, this.$external, this.$callback);
                                return Unit.INSTANCE;
                            }
                            return null;
                        }
                        return (Unit) invokeV.objValue;
                    }
                }, 1, null);
            }
        }

        public final <T> T J(boolean z, Function0<? extends T> function0) {
            InterceptResult invokeZL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048585, this, z, function0)) == null) {
                if (!s()) {
                    Log.d("bdptask_sdk", "bdptask sdk is not inited!");
                    return null;
                } else if (p()) {
                    y();
                    return function0.invoke();
                } else if (z) {
                    n().add(function0);
                    return null;
                } else {
                    try {
                        if (kt.b()) {
                            k(2000L);
                        } else {
                            k(5000L);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!p()) {
                        DebugTrace debugTrace = DebugTrace.a;
                        debugTrace.a("async lock released by timeOut, thread " + Thread.currentThread());
                        return null;
                    }
                    y();
                    return function0.invoke();
                }
            }
            return (T) invokeZL.objValue;
        }

        public void i(final String str, final long j, final String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Long.valueOf(j), str2}) == null) {
                K(this, false, new Function0<Unit>(str, j, str2) { // from class: com.baidu.bdtask.BDPTask$INSTANCE$addDurationWithActionId$2
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $actionId;
                    public final /* synthetic */ String $duplicateId;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long $sliceTimeMs;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, Long.valueOf(j), str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$actionId = str;
                        this.$sliceTimeMs = j;
                        this.$duplicateId = str2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            BDPTask u = BDPTask.m.u();
                            if (u != null) {
                                u.w(this.$actionId, this.$sliceTimeMs, this.$duplicateId);
                                return Unit.INSTANCE;
                            }
                            return null;
                        }
                        return (Unit) invokeV.objValue;
                    }
                }, 1, null);
            }
        }

        public final synchronized void x(ip ipVar) {
            Context context;
            hu w;
            hs h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, ipVar) == null) {
                synchronized (this) {
                    if (s()) {
                        return;
                    }
                    Context context2 = ipVar.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context2, "bdpTaskConfig.context");
                    Context applicationContext = context2.getApplicationContext();
                    if (applicationContext != null) {
                        Application application = (Application) applicationContext;
                        eu euVar = new eu(ipVar);
                        js m = ipVar.m();
                        Intrinsics.checkExpressionValueIsNotNull(m, "bdpTaskConfig.httpService");
                        ns p = ipVar.p();
                        Intrinsics.checkExpressionValueIsNotNull(p, "bdpTaskConfig.schemeService");
                        uu uuVar = new uu(ipVar);
                        ls n = ipVar.n();
                        Intrinsics.checkExpressionValueIsNotNull(n, "bdpTaskConfig.imageService");
                        lu luVar = new lu();
                        ms j = ipVar.j();
                        Intrinsics.checkExpressionValueIsNotNull(j, "bdpTaskConfig.appLifecycle");
                        F(new fu(euVar, m, p, uuVar, n, luVar, j, null, null, 384, null));
                        jr.a aVar = jr.c;
                        hu w2 = w();
                        if (w2 == null) {
                            Intrinsics.throwNpe();
                        }
                        aVar.j(w2);
                        if (ipVar.o() != null) {
                            WeakReference<Context> o = ipVar.o();
                            if (o != null) {
                                context = o.get();
                            } else {
                                context = null;
                            }
                            if ((context instanceof Activity) && !gt.a((Activity) context) && (w = w()) != null && (h = w.h()) != null) {
                                h.b((Activity) context);
                            }
                        }
                        application.registerActivityLifecycleCallbacks(o());
                        C(true);
                        new Thread(a.a, "taskSdkInit").start();
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"com/baidu/bdtask/BDPTask$subscribeStore$2", "Lcom/baidu/tieba/gr;", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "state", "", "newState", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)V", "<init>", "(Lcom/baidu/bdtask/BDPTask;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes.dex */
    public static final class a implements gr<SubTaskState> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BDPTask a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(BDPTask bDPTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDPTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bDPTask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gr
        public void a(final SubTaskState subTaskState) {
            TaskStatus taskStatus;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, subTaskState) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                StringBuilder sb = new StringBuilder();
                sb.append("get newState: ");
                TaskInfo taskInfo = null;
                if (subTaskState != null) {
                    taskStatus = subTaskState.getTaskStatus();
                } else {
                    taskStatus = null;
                }
                sb.append(taskStatus);
                sb.append(",taskInfo:");
                if (subTaskState != null) {
                    taskInfo = subTaskState.getTaskInfo();
                }
                sb.append(taskInfo);
                DebugTrace.d(debugTrace, sb.toString(), "state", null, 4, null);
                if (subTaskState != null) {
                    Function0<Unit> function0 = new Function0<Unit>(this, subTaskState) { // from class: com.baidu.bdtask.BDPTask$subscribeStore$2$newState$$inlined$let$lambda$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SubTaskState $state$inlined;
                        public final /* synthetic */ BDPTask.a this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, subTaskState};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.$state$inlined = subTaskState;
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
                            if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                                return;
                            }
                            this.this$0.a.F(this.$state$inlined);
                        }
                    };
                    sq interceptor = subTaskState.getInterceptor();
                    if (interceptor != null) {
                        interceptor.b(new TaskState(subTaskState.getTaskInfo(), subTaskState.getTaskStatus()), function0);
                    } else {
                        function0.invoke();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1921600290, "Lcom/baidu/bdtask/BDPTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1921600290, "Lcom/baidu/bdtask/BDPTask;");
                return;
            }
        }
        m = new INSTANCE(null);
        nt.a(INSTANCE.AnonymousClass1.INSTANCE);
        d = new du();
        h = new ReentrantLock();
        i = m.q().newCondition();
        k = new ConcurrentLinkedQueue<>();
    }

    public BDPTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d<b, rq> dVar = new d<>(new BDPTask$store$1(new gq()), new b(), CollectionsKt__CollectionsKt.listOf((Object[]) new Function2[]{new com.baidu.bdtask.ctrl.actions.exitstrategy.b().a(), new com.baidu.bdtask.ctrl.actions.duplicate.duplicate.b().a(), new com.baidu.bdtask.ctrl.actions.interrupt.b().a(), new com.baidu.bdtask.ctrl.actions.register.b().a(), new com.baidu.bdtask.ctrl.actions.dotask.visit.b().a(), new com.baidu.bdtask.ctrl.actions.dotask.click.b().a(), new com.baidu.bdtask.ctrl.actions.finishreq.b().b()}));
        this.a = dVar;
        this.b = yu.d.a(dVar);
        this.c = vu.c.a();
    }

    public /* synthetic */ BDPTask(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public void A(Activity activity) {
        hu v;
        hs h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (v = m.v()) != null && (h2 = v.h()) != null) {
            h2.b(activity);
        }
    }

    public Map<String, List<TaskState>> I(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr)) == null) {
            return O().g((String[]) Arrays.copyOf(strArr, strArr.length));
        }
        return (Map) invokeL.objValue;
    }

    public TaskState M(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, strArr)) == null) {
            for (String str : strArr) {
                TaskState K = K(str);
                if (K != null) {
                    return K.deepCopy();
                }
            }
            return null;
        }
        return (TaskState) invokeL.objValue;
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            Y(new qt(str).a(), null);
        }
    }

    public final void e0(TaskInfo taskInfo) {
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, taskInfo) == null) && (k2 = O().k(taskInfo.getSingleKey())) != null) {
            k2.setInterceptor(null);
        }
    }

    public void f0(String str) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && (K = K(str)) != null && (taskInfo = K.getTaskInfo()) != null) {
            e0(taskInfo);
        }
    }

    public final void g0(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, taskInfo) == null) {
            j0(taskInfo, new hq(taskInfo, null, 0, null, null, 30, null));
        }
    }

    public final void k0(final TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, taskInfo) == null) {
            if (!taskInfo.isValid()) {
                DebugTrace.a.c(new Function0<String>(taskInfo) { // from class: com.baidu.bdtask.BDPTask$subscribeStore$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskInfo $taskInfo;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {taskInfo};
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
                        this.$taskInfo = taskInfo;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "subscribe task is invalid:" + this.$taskInfo;
                        }
                        return (String) invokeV.objValue;
                    }
                });
            } else {
                this.a.c(new a(this), new Function1<e<b, rq>, e<SubTaskState, rq>>(this) { // from class: com.baidu.bdtask.BDPTask$subscribeStore$3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BDPTask this$0;

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

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.baidu.bdtask.framework.redux.e<Substate, com.baidu.tieba.rq>, com.baidu.bdtask.framework.redux.e<com.baidu.bdtask.ctrl.SubTaskState, com.baidu.tieba.rq> */
                    @Override // kotlin.jvm.functions.Function1
                    public final e<SubTaskState, rq> invoke(e<b, rq> eVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, eVar)) == null) {
                            return eVar.a(new Function2<b, rq, Pair<? extends SubTaskState, ? extends rq>>(this) { // from class: com.baidu.bdtask.BDPTask$subscribeStore$3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ BDPTask$subscribeStore$3 this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            super(((Integer) newInitContext.callArgs[0]).intValue());
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // kotlin.jvm.functions.Function2
                                public final Pair<SubTaskState, rq> invoke(b bVar, rq rqVar) {
                                    InterceptResult invokeLL;
                                    b O;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || (invokeLL = interceptable3.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, rqVar)) == null) {
                                        if (rqVar == null) {
                                            return new Pair<>(null, rqVar);
                                        }
                                        O = this.this$0.this$0.O();
                                        SubTaskState k2 = O.k(rqVar.f());
                                        DebugTrace.a.c(new Function0<String>(k2) { // from class: com.baidu.bdtask.BDPTask.subscribeStore.3.1.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ SubTaskState $subState;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                                Interceptable interceptable4 = $ic;
                                                if (interceptable4 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {k2};
                                                    interceptable4.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                                        newInitContext.thisArg = this;
                                                        interceptable4.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.$subState = k2;
                                            }

                                            /* JADX DEBUG: Method merged with bridge method */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final String invoke() {
                                                InterceptResult invokeV;
                                                TaskInfo taskInfo2;
                                                Interceptable interceptable4 = $ic;
                                                if (interceptable4 == null || (invokeV = interceptable4.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("subscribeStore:subState:");
                                                    SubTaskState subTaskState = this.$subState;
                                                    TaskStatus taskStatus = null;
                                                    if (subTaskState != null) {
                                                        taskInfo2 = subTaskState.getTaskInfo();
                                                    } else {
                                                        taskInfo2 = null;
                                                    }
                                                    sb.append(taskInfo2);
                                                    sb.append("\n ");
                                                    SubTaskState subTaskState2 = this.$subState;
                                                    if (subTaskState2 != null) {
                                                        taskStatus = subTaskState2.getTaskStatus();
                                                    }
                                                    sb.append(taskStatus);
                                                    return sb.toString();
                                                }
                                                return (String) invokeV.objValue;
                                            }
                                        });
                                        return new Pair<>(k2, rqVar);
                                    }
                                    return (Pair) invokeLL.objValue;
                                }
                            });
                        }
                        return (e) invokeL.objValue;
                    }
                });
            }
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            t(str, "");
        }
    }

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            u0(str, "common unregister");
        }
    }

    public final void G(String str, UniqueId uniqueId) {
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, uniqueId) == null) {
            SubTaskState k2 = O().k(str);
            if (k2 != null) {
                taskInfo = k2.getTaskInfo();
            } else {
                taskInfo = null;
            }
            if (taskInfo != null) {
                TaskBusinessEventManager.c.c(taskInfo, uniqueId);
            } else {
                TaskBusinessEventManager.c.d(str, uniqueId);
            }
        }
    }

    public boolean H(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            return !com.baidu.bdtask.service.cache.b.e.a().f(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public void J(jp jpVar, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, jpVar, strArr) == null) {
            jpVar.a(I((String[]) Arrays.copyOf(strArr, strArr.length)));
        }
    }

    public void N(kp kpVar, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, kpVar, strArr) == null) {
            TaskState M = M((String[]) Arrays.copyOf(strArr, strArr.length));
            if (M == null) {
                kpVar.a(null);
            } else {
                kpVar.a(M.deepCopy());
            }
        }
    }

    public final void Q(TaskInfo taskInfo, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048592, this, taskInfo, i2) != null) || !taskInfo.isPassiveTask()) {
            return;
        }
        j0(taskInfo, pq.g.a(taskInfo, i2));
    }

    public void T(String str, zq zqVar) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, zqVar) == null) && (K = K(str)) != null && (taskInfo = K.getTaskInfo()) != null) {
            TaskBusinessEventManager.c.b(taskInfo, zqVar);
        }
    }

    public final void U(TaskInfo taskInfo, mp mpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, taskInfo, mpVar) == null) {
            V(taskInfo, mpVar, false);
        }
    }

    public final void W(TaskInfo taskInfo, mp mpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, taskInfo, mpVar) == null) {
            V(taskInfo, mpVar, true);
        }
    }

    public final void Y(TaskInfo taskInfo, mp mpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, taskInfo, mpVar) == null) {
            Z(taskInfo, true, mpVar);
        }
    }

    public void c0(String str, mp mpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, mpVar) == null) {
            Y(new qt(str).a(), mpVar);
        }
    }

    public final void h0(TaskInfo taskInfo, sq sqVar) {
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048609, this, taskInfo, sqVar) == null) && (k2 = O().k(taskInfo.getSingleKey())) != null) {
            k2.setInterceptor(sqVar);
        }
    }

    public void i0(String str, sq sqVar) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048610, this, str, sqVar) == null) && (K = K(str)) != null && (taskInfo = K.getTaskInfo()) != null) {
            h0(taskInfo, sqVar);
        }
    }

    public final void j0(TaskInfo taskInfo, final fr frVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048611, this, taskInfo, frVar) != null) || !taskInfo.isValid()) {
            return;
        }
        k0(taskInfo);
        DebugTrace.a.c(new Function0<String>(frVar) { // from class: com.baidu.bdtask.BDPTask$storeDispatch$1
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ fr $action;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {frVar};
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
                this.$action = frVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return "storeDispatch:" + this.$action.e();
                }
                return (String) invokeV.objValue;
            }
        });
        this.a.b(frVar);
    }

    public void o0(String str, lp lpVar) {
        SubTaskState t;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048616, this, str, lpVar) == null) && (t = O().t(str)) != null && (taskInfo = t.getTaskInfo()) != null) {
            r0(taskInfo, lpVar);
        }
    }

    public <T extends xq> void p0(String str, yq<T> yqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, yqVar) == null) {
            TaskBusinessEventManager.c.g(str, yqVar);
        }
    }

    public void q0(String str, zq zqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, str, zqVar) == null) {
            TaskBusinessEventManager.c.h(str, zqVar);
        }
    }

    public final void r0(TaskInfo taskInfo, mp mpVar) {
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048619, this, taskInfo, mpVar) == null) && (k2 = O().k(taskInfo.getSingleKey())) != null) {
            k2.removeCallback(mpVar);
        }
    }

    public void s0(String str, mp mpVar) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048621, this, str, mpVar) == null) && (K = K(str)) != null && (taskInfo = K.getTaskInfo()) != null) {
            r0(taskInfo, mpVar);
        }
    }

    public void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, str, str2) == null) {
            u(str, str2, "");
        }
    }

    public final void u0(String str, String str2) {
        TaskInfo s;
        TaskInfo deepCopy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048625, this, str, str2) == null) && (s = O().s(str)) != null && (deepCopy = s.deepCopy()) != null) {
            j0(deepCopy, iq.f.a(deepCopy, str2));
        }
    }

    public void v(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048626, this, str, j2) == null) {
            w(str, j2, "");
        }
    }

    public final void y(boolean z, TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048629, this, z, taskInfo) == null) {
            com.baidu.bdtask.service.cache.b.e.a().c(O(), taskInfo, z);
        }
    }

    public final b O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.a.a();
        }
        return (b) invokeV.objValue;
    }

    public <T extends xq> void S(String str, Class<T> cls, yq<T> yqVar) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048594, this, str, cls, yqVar) == null) && (K = K(str)) != null && (taskInfo = K.getTaskInfo()) != null) {
            TaskBusinessEventManager.c.a(taskInfo, cls, yqVar);
        }
    }

    public final void Z(TaskInfo taskInfo, boolean z, mp mpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{taskInfo, Boolean.valueOf(z), mpVar}) == null) {
            a0(taskInfo, z, mpVar, null);
        }
    }

    public void d0(String str, mp mpVar, sq sqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, str, mpVar, sqVar) == null) {
            a0(new qt(str).a(), true, mpVar, sqVar);
        }
    }

    public void w(String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{str, Long.valueOf(j2), str2}) == null) {
            x(str, j2, str2, "");
        }
    }

    public static /* synthetic */ void z(BDPTask bDPTask, boolean z, TaskInfo taskInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            taskInfo = null;
        }
        bDPTask.y(z, taskInfo);
    }

    public boolean B(String str, final String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            TaskState K = K(str);
            if (K != null) {
                final TaskInfo taskInfo = K.getTaskInfo();
                if (taskInfo.getTaskRule().isNeedUnique() && !TextUtils.isEmpty(str2)) {
                    j0(taskInfo, lq.f.a(taskInfo, str2));
                    return true;
                }
                DebugTrace.a.c(new Function0<String>(taskInfo, str2) { // from class: com.baidu.bdtask.BDPTask$cacheDuplicateId$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $duplicateId;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskInfo $taskInfo;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {taskInfo, str2};
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
                        this.$taskInfo = taskInfo;
                        this.$duplicateId = str2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "isNeedUnique:" + this.$taskInfo.getTaskRule().isNeedUnique() + " duplicateId:" + this.$duplicateId;
                        }
                        return (String) invokeV.objValue;
                    }
                });
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void R(String str, lp lpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, lpVar) == null) {
            SubTaskState t = O().t(str);
            if (t == null) {
                lpVar.b(new TaskInfo(null, null, 0, null, 0, null, null, null, null, null, null, 2047, null), 101, "task was not existed");
            } else {
                U(t.getTaskInfo(), lpVar);
            }
        }
    }

    public void X(String str, mp mpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, mpVar) == null) {
            TaskState K = K(str);
            if (K == null) {
                mpVar.b(new TaskInfo(null, null, 0, null, 0, null, null, null, null, null, null, 2047, null), 101, "task was not existed");
            } else {
                U(K.getTaskInfo(), mpVar);
            }
        }
    }

    public final void C(String str) {
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (k2 = O().k(str)) == null || !k2.getTaskInfo().isPassiveTask()) {
            return;
        }
        j0(k2.getTaskInfo(), nq.e.a(k2.getTaskInfo(), k2.getTaskStatus().getCurStatus()));
    }

    public void D(String str) {
        TaskInfo u;
        TaskInfo deepCopy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (u = O().u(str)) != null && (deepCopy = u.deepCopy()) != null && deepCopy.isPassiveTask()) {
            O().b(deepCopy, 306, "clean passive task by force");
            j0(deepCopy, iq.f.a(deepCopy, "clean passive task by force"));
        }
    }

    public void E(String str) {
        TaskInfo u;
        TaskInfo deepCopy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (u = O().u(str)) != null && (deepCopy = u.deepCopy()) != null) {
            O().b(deepCopy, 307, "clean task by force");
            j0(deepCopy, iq.f.a(deepCopy, "clean task by force"));
        }
    }

    public TaskState K(String str) {
        InterceptResult invokeL;
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            TaskInfo p = O().p(str);
            if (p == null || (k2 = O().k(p.getSingleKey())) == null) {
                return null;
            }
            return new TaskState(k2.getTaskInfo().deepCopy(), k2.getTaskStatus().deepCopy());
        }
        return (TaskState) invokeL.objValue;
    }

    public final void F(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, subTaskState) == null) {
            final TaskStatus taskStatus = subTaskState.getTaskStatus();
            final TaskInfo taskInfo = subTaskState.getTaskInfo();
            DebugTrace.a.c(new Function0<String>(taskInfo, taskStatus) { // from class: com.baidu.bdtask.BDPTask$dispatchState$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskStatus $status;
                public final /* synthetic */ TaskInfo $taskInfo;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {taskInfo, taskStatus};
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
                    this.$taskInfo = taskInfo;
                    this.$status = taskStatus;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "dispatchState:taskInfo:" + this.$taskInfo + "\n status:" + this.$status;
                    }
                    return (String) invokeV.objValue;
                }
            });
            try {
                if (taskStatus.hasErrorCode()) {
                    DebugTrace.a.c(new Function0<String>(taskStatus) { // from class: com.baidu.bdtask.BDPTask$dispatchState$2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TaskStatus $status;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {taskStatus};
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
                            this.$status = taskStatus;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return "errorNo:" + this.$status.getCurStatusCode() + " errorMsg:" + this.$status.getCurStatusCodeMsg();
                            }
                            return (String) invokeV.objValue;
                        }
                    });
                    O().b(taskInfo, taskStatus.getCurStatusCode(), taskStatus.getCurStatusCodeMsg());
                    if (!this.c.b(taskInfo, taskStatus.getCurStatusCode())) {
                        this.c.c(subTaskState);
                        return;
                    }
                } else {
                    O().a(taskInfo, taskStatus);
                }
                if (taskStatus.isFinished()) {
                    this.b.c(subTaskState);
                } else if (taskStatus.isRunning()) {
                    this.b.b(subTaskState);
                } else if (taskStatus.isRegistered()) {
                    this.b.a(subTaskState);
                } else if (taskStatus.isInterrupted()) {
                    this.b.d(subTaskState);
                } else if (taskStatus.isUnRegistered()) {
                    this.b.e(subTaskState);
                }
            } finally {
                z(this, false, taskInfo, 1, null);
            }
        }
    }

    public void L(String str, kp kpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, kpVar) == null) {
            TaskInfo p = O().p(str);
            if (p == null) {
                kpVar.a(null);
                return;
            }
            SubTaskState k2 = O().k(p.getSingleKey());
            if (k2 == null) {
                kpVar.a(null);
            } else {
                kpVar.a(new TaskState(k2.getTaskInfo().deepCopy(), k2.getTaskStatus().deepCopy()));
            }
        }
    }

    public TaskState P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SubTaskState c = b.c(O(), null, 1, null);
            if (c == null) {
                return null;
            }
            return new TaskState(c.getTaskInfo().deepCopy(), c.getTaskStatus().deepCopy());
        }
        return (TaskState) invokeV.objValue;
    }

    public final void V(TaskInfo taskInfo, mp mpVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048597, this, taskInfo, mpVar, z) == null) {
            SubTaskState k2 = O().k(taskInfo.getSingleKey());
            if (k2 == null) {
                mpVar.b(taskInfo, 101, "task was not existed");
                return;
            }
            if (z) {
                mpVar.a(k2.getTaskInfo(), k2.getTaskStatus());
            }
            k2.addCallback(mpVar);
        }
    }

    public final void a0(TaskInfo taskInfo, boolean z, mp mpVar, sq sqVar) {
        TaskInfo copy;
        TaskState K;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{taskInfo, Boolean.valueOf(z), mpVar, sqVar}) == null) {
            if (taskInfo == null) {
                if (mpVar != null) {
                    mpVar.b(new TaskInfo(null, null, 0, null, 0, null, null, null, null, null, null, 2047, null), 201, "task info parse failed");
                }
            } else if (!taskInfo.isValid()) {
                if (mpVar != null) {
                    mpVar.b(taskInfo, 201, "task info parse failed");
                }
            } else if (!wv.a.c(taskInfo.getTaskRule().getExpireTime())) {
                if (mpVar != null) {
                    mpVar.b(taskInfo, 103, "task is expired");
                }
            } else {
                final SubTaskState c = b.c(O(), null, 1, null);
                if (c != null) {
                    O().b(c.getTaskInfo(), 102, "task is abandoned by new task registered");
                    if (c.getTaskInfo().isInitiActiveTask()) {
                        DebugTrace.a.c(new Function0<String>(c) { // from class: com.baidu.bdtask.BDPTask$registerTaskWithInfo$1$1$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SubTaskState $it;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {c};
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
                                this.$it = c;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                InterceptResult invokeV;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                    return "interrupt initiActiveTask " + this.$it.getTaskInfo();
                                }
                                return (String) invokeV.objValue;
                            }
                        });
                        u0(c.getTaskInfo().getActionId(), "task is abandoned by new task registered");
                    } else if (c.getTaskInfo().isPassiveTask()) {
                        DebugTrace.a.c(new Function0<String>(c) { // from class: com.baidu.bdtask.BDPTask$registerTaskWithInfo$1$1$2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SubTaskState $it;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {c};
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
                                this.$it = c;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                InterceptResult invokeV;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                    return "interrupt passiveTask " + this.$it.getTaskInfo();
                                }
                                return (String) invokeV.objValue;
                            }
                        });
                        Q(c.getTaskInfo(), 102);
                    }
                }
                if (!z && (K = K(taskInfo.getActionId())) != null && K.getTaskInfo().isValid() && K.getTaskStatus().isEnable() && mpVar != null) {
                    if (sqVar != null) {
                        h0(taskInfo, sqVar);
                    }
                    W(taskInfo, mpVar);
                    return;
                }
                copy = taskInfo.copy((r24 & 1) != 0 ? taskInfo.id : null, (r24 & 2) != 0 ? taskInfo.actionId : null, (r24 & 4) != 0 ? taskInfo.type : 0, (r24 & 8) != 0 ? taskInfo.token : null, (r24 & 16) != 0 ? taskInfo.behavior : 0, (r24 & 32) != 0 ? taskInfo.actTaskId : null, (r24 & 64) != 0 ? taskInfo.fingerprint : null, (r24 & 128) != 0 ? taskInfo.taskRule : null, (r24 & 256) != 0 ? taskInfo.taskGuide : null, (r24 & 512) != 0 ? taskInfo.taskMeter : null, (r24 & 1024) != 0 ? taskInfo.response : null);
                j0(taskInfo, new qq(copy, mpVar, sqVar, null, null, null, 56, null));
            }
        }
    }

    public void l0(String str, String str2, int i2, uq uqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048613, this, str, str2, i2, uqVar) == null) {
            m0(str, str2, i2, null, uqVar);
        }
    }

    public void m0(String str, String str2, int i2, JSONObject jSONObject, uq uqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, Integer.valueOf(i2), jSONObject, uqVar}) == null) {
            com.baidu.bdtask.ctrl.repo.api.a.b.a(str, str2, i2, jSONObject, uqVar);
        }
    }

    public final void n0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        O().o(str);
        final SubTaskState j2 = O().j();
        if (j2 != null) {
            DebugTrace.a.c(new Function0<String>(j2) { // from class: com.baidu.bdtask.BDPTask$taskStateRestore$1$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SubTaskState $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {j2};
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
                    this.$it = j2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "active : " + this.$it.toJson();
                    }
                    return (String) invokeV.objValue;
                }
            });
            g0(j2.getTaskInfo());
            DebugTrace.a.c(new Function0<String>(this) { // from class: com.baidu.bdtask.BDPTask$taskStateRestore$$inlined$let$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDPTask this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    b O;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("getCurActive:");
                        O = this.this$0.O();
                        JSONObject jSONObject = null;
                        SubTaskState c = b.c(O, null, 1, null);
                        if (c != null) {
                            jSONObject = c.toJson();
                        }
                        sb.append(jSONObject);
                        return sb.toString();
                    }
                    return (String) invokeV.objValue;
                }
            });
        }
        z(this, true, null, 2, null);
        SubTaskState c = b.c(O(), null, 1, null);
        if (c != null) {
            k0(c.getTaskInfo());
        }
    }

    public void u(String str, String str2, String str3) {
        final TaskInfo taskInfo;
        TaskInfo taskInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048624, this, str, str2, str3) == null) {
            SubTaskState q = O().q(str);
            final TaskStatus taskStatus = null;
            if (q != null) {
                taskInfo = q.getTaskInfo();
            } else {
                taskInfo = null;
            }
            if (q != null) {
                taskStatus = q.getTaskStatus();
            }
            DebugTrace.a.c(new Function0<String>(taskInfo, taskStatus) { // from class: com.baidu.bdtask.BDPTask$addActionWithActionId$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskInfo $taskInfo;
                public final /* synthetic */ TaskStatus $taskStatus;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {taskInfo, taskStatus};
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
                    this.$taskInfo = taskInfo;
                    this.$taskStatus = taskStatus;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "addActionWithActionId:" + this.$taskInfo + WebvttCueParser.CHAR_SPACE + this.$taskStatus;
                    }
                    return (String) invokeV.objValue;
                }
            });
            if (taskInfo != null && taskStatus != null) {
                zu.c.d(UBCActionTaskInfo.Companion.b(str2, taskInfo, taskStatus));
                if (!taskInfo.isClickAction()) {
                    return;
                }
                if (H(str, str2)) {
                    TaskState K = K(str);
                    if (K != null && (taskInfo2 = K.getTaskInfo()) != null) {
                        j0(taskInfo2, mq.f.a(taskInfo2));
                        return;
                    }
                    return;
                }
                j0(taskInfo, new jq(taskInfo.getSingleKey(), str2, str3, null, null, 24, null));
            }
        }
    }

    public void x(String str, long j2, String str2, String str3) {
        final TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{str, Long.valueOf(j2), str2, str3}) == null) {
            SubTaskState q = O().q(str);
            TaskStatus taskStatus = null;
            if (q != null) {
                taskInfo = q.getTaskInfo();
            } else {
                taskInfo = null;
            }
            if (q != null) {
                taskStatus = q.getTaskStatus();
            }
            final TaskStatus taskStatus2 = taskStatus;
            DebugTrace.a.c(new Function0<String>(taskInfo, taskStatus2) { // from class: com.baidu.bdtask.BDPTask$addDurationWithActionId$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskInfo $taskInfo;
                public final /* synthetic */ TaskStatus $taskStatus;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {taskInfo, taskStatus2};
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
                    this.$taskInfo = taskInfo;
                    this.$taskStatus = taskStatus2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "addDurationWithActionId:" + this.$taskInfo + WebvttCueParser.CHAR_SPACE + this.$taskStatus;
                    }
                    return (String) invokeV.objValue;
                }
            });
            if (taskInfo != null && taskStatus2 != null) {
                zu.c.d(UBCActionTaskInfo.Companion.a(j2, str2, taskInfo, taskStatus2));
                if (!taskInfo.isVisitAction()) {
                    return;
                }
                if (H(str, str2)) {
                    j0(taskInfo, mq.f.b(taskInfo));
                } else {
                    j0(taskInfo, new kq(j2, taskInfo.getSingleKey(), str2, str3, null, null, 48, null));
                }
            }
        }
    }
}
