package com.baidu.bdtask;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import c.a.j.h.b.b;
import c.a.j.h.d.e;
import c.a.j.h.d.h;
import c.a.j.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.b;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.event.TaskBusinessEventManager;
import com.baidu.bdtask.framework.redux.d;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.service.cache.storage.c;
import com.baidu.bdtask.service.ubc.model.UBCActionTaskInfo;
import com.baidu.bdtask.utils.UniqueId;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0099\u0001:\u0002\u0099\u0001B\n\b\u0002¢\u0006\u0005\b\u0098\u0001\u0010\u001dJ\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0007J'\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\tJ\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\f\u0010\u000eJ/\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\f\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0001H\u0000¢\u0006\u0004\b \u0010\u0005J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0001H\u0016¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0001H\u0016¢\u0006\u0004\b$\u0010\u0005J\u0017\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010.\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00012\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b/\u0010\u001bJ5\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020403022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000100\"\u00020\u0001H\u0016¢\u0006\u0004\b5\u00106J+\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u0002072\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000100\"\u00020\u0001H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u0004\u0018\u0001042\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J%\u0010@\u001a\u0004\u0018\u0001042\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000100\"\u00020\u0001H\u0016¢\u0006\u0004\b@\u0010AJ+\u0010B\u001a\u00020\u00032\u0006\u00108\u001a\u00020=2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000100\"\u00020\u0001H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bE\u0010FJ\u0011\u0010G\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\bG\u0010HJ\u001f\u0010M\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010J\u001a\u00020IH\u0000¢\u0006\u0004\bK\u0010LJ\u001f\u0010P\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ=\u0010X\u001a\u00020\u0003\"\b\b\u0000\u0010S*\u00020R2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000T2\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000VH\u0016¢\u0006\u0004\bX\u0010YJ\u001f\u0010[\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u001f\u0010^\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010O\u001a\u00020]H\u0002¢\u0006\u0004\b^\u0010_J'\u0010^\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010O\u001a\u00020]2\u0006\u0010`\u001a\u00020\u0010H\u0002¢\u0006\u0004\b^\u0010aJ\u001f\u0010b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010O\u001a\u00020]H\u0002¢\u0006\u0004\bb\u0010_J\u001f\u0010d\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u00012\u0006\u0010O\u001a\u00020]H\u0016¢\u0006\u0004\bd\u0010eJ#\u0010f\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010O\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bf\u0010_J+\u0010f\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00020\u00102\b\u0010O\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bf\u0010hJ5\u0010f\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00020\u00102\b\u0010O\u001a\u0004\u0018\u00010]2\b\u0010j\u001a\u0004\u0018\u00010iH\u0002¢\u0006\u0004\bf\u0010kJ\u0017\u0010f\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u0001H\u0016¢\u0006\u0004\bf\u0010\u0005J!\u0010f\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u00012\b\u0010O\u001a\u0004\u0018\u00010]H\u0016¢\u0006\u0004\bf\u0010eJ+\u0010f\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u00012\b\u0010O\u001a\u0004\u0018\u00010]2\b\u0010j\u001a\u0004\u0018\u00010iH\u0016¢\u0006\u0004\bf\u0010mJ\u0017\u0010n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\bn\u0010oJ\u0017\u0010n\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\bn\u0010\u0005J\u0017\u0010q\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\bp\u0010oJ\u001f\u0010r\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010j\u001a\u00020iH\u0002¢\u0006\u0004\br\u0010sJ\u001f\u0010r\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010j\u001a\u00020iH\u0016¢\u0006\u0004\br\u0010tJ\u001f\u0010x\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010W\u001a\u00020uH\u0000¢\u0006\u0004\bv\u0010wJ\u0017\u0010y\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\by\u0010oJ/\u0010~\u001a\u00020\u00032\u0006\u0010z\u001a\u00020\u00012\u0006\u0010{\u001a\u00020\u00012\u0006\u0010|\u001a\u00020I2\u0006\u00108\u001a\u00020}H\u0016¢\u0006\u0004\b~\u0010\u007fJ<\u0010~\u001a\u00020\u00032\u0006\u0010z\u001a\u00020\u00012\u0006\u0010{\u001a\u00020\u00012\u0006\u0010|\u001a\u00020I2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u00108\u001a\u00020}H\u0016¢\u0006\u0005\b~\u0010\u0082\u0001J\u001c\u0010\u0084\u0001\u001a\u00020\u00032\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0005\b\u0084\u0001\u0010\u0005J!\u0010\u0085\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0005\b\u0085\u0001\u0010QJ2\u0010\u0086\u0001\u001a\u00020\u0003\"\b\b\u0000\u0010S*\u00020R2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000VH\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J!\u0010\u0088\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u00020ZH\u0016¢\u0006\u0005\b\u0088\u0001\u0010\\J!\u0010\u0089\u0001\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010O\u001a\u00020]H\u0002¢\u0006\u0005\b\u0089\u0001\u0010_J!\u0010\u008a\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010O\u001a\u00020]H\u0016¢\u0006\u0005\b\u008a\u0001\u0010eJ\u0019\u0010\u008b\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0005\b\u008b\u0001\u0010\u0005J\"\u0010\u008b\u0001\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u0001H\u0000¢\u0006\u0005\b\u008d\u0001\u0010\u0007R\u001a\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R'\u0010\u0096\u0001\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001¨\u0006\u009a\u0001"}, d2 = {"Lcom/baidu/bdtask/BDPTask;", "", "actionId", "", "addActionWithActionId", "(Ljava/lang/String;)V", "duplicateId", "(Ljava/lang/String;Ljava/lang/String;)V", "tag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "sliceTimeMs", "addDurationWithActionId", "(Ljava/lang/String;J)V", "(Ljava/lang/String;JLjava/lang/String;)V", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "", TTDownloadField.TT_FORCE, "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "appStateASync", "(ZLcom/baidu/bdtask/model/info/TaskInfo;)V", "Landroid/app/Activity;", "curActivity", "attachCurActivity", "(Landroid/app/Activity;)V", "cacheDuplicateId", "(Ljava/lang/String;Ljava/lang/String;)Z", "cleanAllCallbacks$lib_bdtask_business_build_release", "()V", "cleanAllCallbacks", "taskInfoKey", "cleanTaskNoClickTimes$lib_bdtask_business_build_release", "cleanTaskNoClickTimes", TaskInfo.keyActTaskId, "clearPassiveTaskByActTaskId", "clearTaskByActTaskId", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "subState", "dispatchState", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)V", "taskSingleKey", "Lcom/baidu/bdtask/utils/UniqueId;", TbEnum.SystemMessage.KEY_EVENT_ID, "dispatchTaskBusinessEvent$lib_bdtask_business_build_release", "(Ljava/lang/String;Lcom/baidu/bdtask/utils/UniqueId;)V", "dispatchTaskBusinessEvent", "duplicateIdIsRepeatedByActionId", "", "actionIds", "", "", "Lcom/baidu/bdtask/TaskState;", "findAllTaskStateByActionIds", "([Ljava/lang/String;)Ljava/util/Map;", "Lcom/baidu/bdtask/TaskAllStateCallback;", WebChromeClient.KEY_ARG_CALLBACK, "findAllTaskStateByActionIdsAsync", "(Lcom/baidu/bdtask/TaskAllStateCallback;[Ljava/lang/String;)V", "findTaskStateByActionId", "(Ljava/lang/String;)Lcom/baidu/bdtask/TaskState;", "Lcom/baidu/bdtask/TaskStateCallback;", "findTaskStateByActionIdAsync", "(Ljava/lang/String;Lcom/baidu/bdtask/TaskStateCallback;)V", "findTaskStateByActionIds", "([Ljava/lang/String;)Lcom/baidu/bdtask/TaskState;", "findTaskStateByActionIdsAsync", "(Lcom/baidu/bdtask/TaskStateCallback;[Ljava/lang/String;)V", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "getAppState", "()Lcom/baidu/bdtask/ctrl/BDPTaskState;", "getCurActiveTaskState", "()Lcom/baidu/bdtask/TaskState;", "", "errNo", "interruptPassiveTask$lib_bdtask_business_build_release", "(Lcom/baidu/bdtask/model/info/TaskInfo;I)V", "interruptPassiveTask", "Lcom/baidu/bdtask/callbacks/PassiveTaskCallback;", "taskCallback", "registerPassiveTaskListenerWithActionId", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/PassiveTaskCallback;)V", "Lcom/baidu/bdtask/event/TaskBusinessEvent;", "T", "Ljava/lang/Class;", "eventClass", "Lcom/baidu/bdtask/event/TaskBusinessEventAction;", "action", "registerTaskBusinessEventAction", "(Ljava/lang/String;Ljava/lang/Class;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "Lcom/baidu/bdtask/event/TaskBusinessEventCallback;", "registerTaskBusinessEventListener", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventCallback;)V", "Lcom/baidu/bdtask/callbacks/TaskCallback;", "registerTaskListener", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "sticky", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/callbacks/TaskCallback;Z)V", "registerTaskListenerSticky", "actonId", "registerTaskListenerWithActionId", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "registerTaskWithInfo", "reset", "(Lcom/baidu/bdtask/model/info/TaskInfo;ZLcom/baidu/bdtask/callbacks/TaskCallback;)V", "Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;", "taskInterceptor", "(Lcom/baidu/bdtask/model/info/TaskInfo;ZLcom/baidu/bdtask/callbacks/TaskCallback;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "rawTaskStr", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/TaskCallback;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "removeTaskInterceptor", "(Lcom/baidu/bdtask/model/info/TaskInfo;)V", "resetTaskInfo2Running$lib_bdtask_business_build_release", "resetTaskInfo2Running", "setTaskInterceptor", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "(Ljava/lang/String;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "Lcom/baidu/bdtask/framework/redux/Action;", "storeDispatch$lib_bdtask_business_build_release", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/framework/redux/Action;)V", "storeDispatch", "subscribeStore", "token", "taskId", "behavior", "Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;", "taskCompletedRequest", "(Ljava/lang/String;Ljava/lang/String;ILcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "Lorg/json/JSONObject;", LaunchStatsUtils.EXTERNAL_LAUNCH, "(Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "taskStateStr", "taskStateRestore", "unRegisterPassiveTaskListenerWithActionId", "unRegisterTaskBusinessEventAction", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "unRegisterTaskBusinessEventListener", "unRegisterTaskListener", "unRegisterTaskListenerWithActionId", "unregisterTaskWithActionId", "unRegisterMsg", "unregisterTaskWithActionId$lib_bdtask_business_build_release", "Lcom/baidu/bdtask/strategy/ExceptionStrategyImpl;", "exceptionStrategy", "Lcom/baidu/bdtask/strategy/ExceptionStrategyImpl;", "Lcom/baidu/bdtask/strategy/LifecycleStrategyImpl;", "lifecycleStrategy", "Lcom/baidu/bdtask/strategy/LifecycleStrategyImpl;", "Lcom/baidu/bdtask/framework/redux/Store;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "store", "Lcom/baidu/bdtask/framework/redux/Store;", "<init>", "INSTANCE", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class BDPTask {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final c.a.j.j.a.a f24903d;

    /* renamed from: e  reason: collision with root package name */
    public static BDPTask f24904e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f24905f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f24906g;

    /* renamed from: h  reason: collision with root package name */
    public static final ReentrantLock f24907h;
    public static final Condition i;
    public static BDPTask j;
    public static final ConcurrentLinkedQueue<Function0<Object>> k;
    public static c.a.j.j.d.a l;
    public static final INSTANCE m;
    public transient /* synthetic */ FieldHolder $fh;
    public final d<b, c.a.j.f.d> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.j.k.d f24908b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.j.k.a f24909c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u0000B\n\b\u0002¢\u0006\u0005\b¡\u0001\u0010\u0011J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0007J'\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\tJ\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\f\u0010\u000eJ/\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\f\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u001f\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ7\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0018\u00010\"2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010 \"\u00020\u0001H\u0016¢\u0006\u0004\b%\u0010&J+\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010 \"\u00020\u0001H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u0004\u0018\u00010$2\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010(\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J%\u00100\u001a\u0004\u0018\u00010$2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010 \"\u00020\u0001H\u0016¢\u0006\u0004\b0\u00101J+\u00102\u001a\u00020\u00032\u0006\u0010(\u001a\u00020-2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010 \"\u00020\u0001H\u0016¢\u0006\u0004\b2\u00103J\u0011\u00104\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0019¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u00032\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0003H\u0003¢\u0006\u0004\b?\u0010\u0011J\u001f\u0010B\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ=\u0010J\u001a\u00020\u0003\"\b\b\u0000\u0010E*\u00020D2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000F2\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000HH\u0016¢\u0006\u0004\bJ\u0010KJ\u001f\u0010M\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010(\u001a\u00020LH\u0016¢\u0006\u0004\bM\u0010NJ\u001d\u0010R\u001a\u00020\u00032\u0006\u0010P\u001a\u00020O2\u0006\u0010A\u001a\u00020Q¢\u0006\u0004\bR\u0010SJ\u001f\u0010U\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u00012\u0006\u0010A\u001a\u00020QH\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u0001H\u0016¢\u0006\u0004\bX\u0010\u0005J!\u0010X\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u00012\b\u0010A\u001a\u0004\u0018\u00010QH\u0016¢\u0006\u0004\bX\u0010VJ+\u0010X\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u00012\b\u0010A\u001a\u0004\u0018\u00010Q2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0016¢\u0006\u0004\bX\u0010[J\u000f\u0010\\\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\\\u0010\u0011J\u0017\u0010]\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b]\u0010\u0005J\u001f\u0010^\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020YH\u0016¢\u0006\u0004\b^\u0010_J/\u0010e\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00012\u0006\u0010a\u001a\u00020\u00012\u0006\u0010c\u001a\u00020b2\u0006\u0010(\u001a\u00020dH\u0016¢\u0006\u0004\be\u0010fJ9\u0010e\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00012\u0006\u0010a\u001a\u00020\u00012\u0006\u0010c\u001a\u00020b2\b\u0010h\u001a\u0004\u0018\u00010g2\u0006\u0010(\u001a\u00020dH\u0016¢\u0006\u0004\be\u0010iJ\u001f\u0010j\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bj\u0010CJ/\u0010k\u001a\u00020\u0003\"\b\b\u0000\u0010E*\u00020D2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000HH\u0016¢\u0006\u0004\bk\u0010lJ\u001f\u0010m\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010(\u001a\u00020LH\u0016¢\u0006\u0004\bm\u0010NJ\u001f\u0010n\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u00012\u0006\u0010A\u001a\u00020QH\u0016¢\u0006\u0004\bn\u0010VJ\u0017\u0010o\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\bo\u0010\u0005J1\u0010r\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010E2\b\b\u0002\u0010p\u001a\u00020\u00192\u000e\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000qH\u0002¢\u0006\u0004\br\u0010sR*\u0010v\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010u0q0t8\u0002@\u0002X\u0082\u0004¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u001c\u0010{\u001a\u00020z8\u0002@\u0002X\u0082\u0004¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R&\u0010\u007f\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0016\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u0010:\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\"\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R,\u0010\u008b\u0001\u001a\r \u008a\u0001*\u0005\u0018\u00010\u0089\u00010\u0089\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R(\u0010\u008f\u0001\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0017\n\u0006\b\u008f\u0001\u0010\u0080\u0001\u001a\u0005\b\u0090\u0001\u0010:\"\u0006\b\u0091\u0001\u0010\u0083\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R,\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u0094\u0001\u001a\u0006\b\u009a\u0001\u0010\u0096\u0001\"\u0006\b\u009b\u0001\u0010\u0098\u0001R*\u0010\u009c\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0017\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0005\b\u009e\u0001\u00108\"\u0006\b\u009f\u0001\u0010 \u0001¨\u0006¢\u0001"}, d2 = {"Lcom/baidu/bdtask/BDPTask$INSTANCE;", "", "actionId", "", "addActionWithActionId", "(Ljava/lang/String;)V", "duplicateId", "(Ljava/lang/String;Ljava/lang/String;)V", "tag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "sliceTimeMs", "addDurationWithActionId", "(Ljava/lang/String;J)V", "(Ljava/lang/String;JLjava/lang/String;)V", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "asyncLockNotify", "()V", "waitTime", "asyncLockWait", "(J)V", "Landroid/app/Activity;", "curActivity", "attachCurActivity", "(Landroid/app/Activity;)V", "", "cacheDuplicateId", "(Ljava/lang/String;Ljava/lang/String;)Z", TaskInfo.keyActTaskId, "clearPassiveTaskByActTaskId", "clearTaskByActTaskId", "duplicateIdIsRepeatedByActionId", "", "actionIds", "", "", "Lcom/baidu/bdtask/TaskState;", "findAllTaskStateByActionIds", "([Ljava/lang/String;)Ljava/util/Map;", "Lcom/baidu/bdtask/TaskAllStateCallback;", WebChromeClient.KEY_ARG_CALLBACK, "findAllTaskStateByActionIdsAsync", "(Lcom/baidu/bdtask/TaskAllStateCallback;[Ljava/lang/String;)V", "findTaskStateByActionId", "(Ljava/lang/String;)Lcom/baidu/bdtask/TaskState;", "Lcom/baidu/bdtask/TaskStateCallback;", "findTaskStateByActionIdAsync", "(Ljava/lang/String;Lcom/baidu/bdtask/TaskStateCallback;)V", "findTaskStateByActionIds", "([Ljava/lang/String;)Lcom/baidu/bdtask/TaskState;", "findTaskStateByActionIdsAsync", "(Lcom/baidu/bdtask/TaskStateCallback;[Ljava/lang/String;)V", "getCurActiveTaskState", "()Lcom/baidu/bdtask/TaskState;", "Lcom/baidu/bdtask/service/base/TaskService;", "getServiceManager", "()Lcom/baidu/bdtask/service/base/TaskService;", "hasInitialized", "()Z", "Lcom/baidu/bdtask/BDPTaskConfig;", "bdpTaskConfig", "init", "(Lcom/baidu/bdtask/BDPTaskConfig;)V", "offerActionQueue", "Lcom/baidu/bdtask/callbacks/PassiveTaskCallback;", "taskCallback", "registerPassiveTaskListenerWithActionId", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/PassiveTaskCallback;)V", "Lcom/baidu/bdtask/event/TaskBusinessEvent;", "T", "Ljava/lang/Class;", "eventType", "Lcom/baidu/bdtask/event/TaskBusinessEventAction;", "action", "registerTaskBusinessEventAction", "(Ljava/lang/String;Ljava/lang/Class;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "Lcom/baidu/bdtask/event/TaskBusinessEventCallback;", "registerTaskBusinessEventListener", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventCallback;)V", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/callbacks/TaskCallback;", "registerTaskListenerSticky", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "actonId", "registerTaskListenerWithActionId", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/TaskCallback;)V", "rawTaskStr", "registerTaskWithInfo", "Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;", "taskInterceptor", "(Ljava/lang/String;Lcom/baidu/bdtask/callbacks/TaskCallback;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "release", "removeTaskInterceptor", "setTaskInterceptor", "(Ljava/lang/String;Lcom/baidu/bdtask/ctrl/interceptor/BaseTaskInterceptor;)V", "token", "taskId", "", "behavior", "Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;", "taskCompletedRequest", "(Ljava/lang/String;Ljava/lang/String;ILcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "Lorg/json/JSONObject;", LaunchStatsUtils.EXTERNAL_LAUNCH, "(Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "unRegisterPassiveTaskListenerWithActionId", "unRegisterTaskBusinessEventAction", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "unRegisterTaskBusinessEventListener", "unRegisterTaskListenerWithActionId", "unregisterTaskWithActionId", "aSync", "Lkotlin/Function0;", "withCheck", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "actionQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getActionQueue", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/baidu/bdtask/service/env/TaskActivityLifecycleCallbacks;", "activityLifecycleCallbacks", "Lcom/baidu/bdtask/service/env/TaskActivityLifecycleCallbacks;", "getActivityLifecycleCallbacks", "()Lcom/baidu/bdtask/service/env/TaskActivityLifecycleCallbacks;", "asyncLoaded", "Z", "getAsyncLoaded", "setAsyncLoaded", "(Z)V", "Ljava/util/concurrent/locks/ReentrantLock;", "asyncLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getAsyncLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "asyncLockCondition", "Ljava/util/concurrent/locks/Condition;", "getAsyncLockCondition", "()Ljava/util/concurrent/locks/Condition;", "initialized", "getInitialized", "setInitialized", "Lcom/baidu/bdtask/BDPTask;", "innerInstance", "Lcom/baidu/bdtask/BDPTask;", "getInnerInstance$lib_bdtask_business_build_release", "()Lcom/baidu/bdtask/BDPTask;", "setInnerInstance$lib_bdtask_business_build_release", "(Lcom/baidu/bdtask/BDPTask;)V", Transition.MATCH_INSTANCE_STR, "getInstance", "setInstance", "taskServiceManager", "Lcom/baidu/bdtask/service/base/TaskService;", "getTaskServiceManager", "setTaskServiceManager", "(Lcom/baidu/bdtask/service/base/TaskService;)V", "<init>", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class INSTANCE {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
        /* renamed from: com.baidu.bdtask.BDPTask$INSTANCE$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public static /* synthetic */ Interceptable $ic;
            public static final AnonymousClass1 INSTANCE;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(821376174, "Lcom/baidu/bdtask/BDPTask$INSTANCE$1;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(821376174, "Lcom/baidu/bdtask/BDPTask$INSTANCE$1;");
                        return;
                    }
                }
                INSTANCE = new AnonymousClass1();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1() {
                super(0);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    System.loadLibrary("bdptask");
                }
            }
        }

        /* loaded from: classes3.dex */
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
                    String a2 = com.baidu.bdtask.service.cache.b.f24944e.a().a();
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

        /* loaded from: classes3.dex */
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

        public static /* synthetic */ Object J(INSTANCE instance, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return instance.I(z, function0);
        }

        public void A(String str, c.a.j.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) {
                J(this, false, new BDPTask$INSTANCE$registerTaskWithInfo$2(str, bVar), 1, null);
            }
        }

        public final void B(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                BDPTask.f24906g = z;
            }
        }

        public final void C(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                BDPTask.f24905f = z;
            }
        }

        public final void D(BDPTask bDPTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bDPTask) == null) {
                BDPTask.f24904e = bDPTask;
            }
        }

        public final void E(BDPTask bDPTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bDPTask) == null) {
                BDPTask.j = bDPTask;
            }
        }

        public final void F(c.a.j.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
                BDPTask.l = aVar;
            }
        }

        public void G(String str, c.a.j.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, str, bVar) == null) {
                J(this, false, new BDPTask$INSTANCE$unRegisterTaskListenerWithActionId$1(str, bVar), 1, null);
            }
        }

        public void H(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                J(this, false, new BDPTask$INSTANCE$unregisterTaskWithActionId$1(str), 1, null);
            }
        }

        public final <T> T I(boolean z, Function0<? extends T> function0) {
            InterceptResult invokeZL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, function0)) == null) {
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
                        if (e.b()) {
                            k(2000L);
                        } else {
                            k(5000L);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
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

        public void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                J(this, false, new BDPTask$INSTANCE$addActionWithActionId$1(str), 1, null);
            }
        }

        public void i(String str, long j, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Long.valueOf(j), str2}) == null) {
                J(this, false, new BDPTask$INSTANCE$addDurationWithActionId$2(str, j, str2), 1, null);
            }
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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

        public final void k(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
                ReentrantLock q = q();
                q.lock();
                try {
                    BDPTask.m.r().await(j, TimeUnit.MILLISECONDS);
                } finally {
                    q.unlock();
                }
            }
        }

        public boolean l(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
                Boolean bool = (Boolean) J(this, false, new BDPTask$INSTANCE$duplicateIdIsRepeatedByActionId$1(str, str2), 1, null);
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public TaskState m(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? (TaskState) I(false, new BDPTask$INSTANCE$findTaskStateByActionId$1(str)) : (TaskState) invokeL.objValue;
        }

        public final ConcurrentLinkedQueue<Function0<Object>> n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? BDPTask.k : (ConcurrentLinkedQueue) invokeV.objValue;
        }

        public final c.a.j.j.a.a o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? BDPTask.f24903d : (c.a.j.j.a.a) invokeV.objValue;
        }

        public final boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? BDPTask.f24906g : invokeV.booleanValue;
        }

        public final ReentrantLock q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? BDPTask.f24907h : (ReentrantLock) invokeV.objValue;
        }

        public final Condition r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? BDPTask.i : (Condition) invokeV.objValue;
        }

        public final boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? BDPTask.f24905f : invokeV.booleanValue;
        }

        public final BDPTask t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? BDPTask.f24904e : (BDPTask) invokeV.objValue;
        }

        public final BDPTask u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? BDPTask.j : (BDPTask) invokeV.objValue;
        }

        public final c.a.j.j.d.a v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                if (s()) {
                    return w();
                }
                return null;
            }
            return (c.a.j.j.d.a) invokeV.objValue;
        }

        public final c.a.j.j.d.a w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? BDPTask.l : (c.a.j.j.d.a) invokeV.objValue;
        }

        public final synchronized void x(c.a.j.a aVar) {
            c.a.j.j.d.a w;
            c.a.j.h.b.d.a h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, aVar) == null) {
                synchronized (this) {
                    if (s()) {
                        return;
                    }
                    Context context = aVar.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "bdpTaskConfig.context");
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        Application application = (Application) applicationContext;
                        c.a.j.j.a.b bVar = new c.a.j.j.a.b(aVar);
                        c.a.j.h.b.e.a m = aVar.m();
                        Intrinsics.checkExpressionValueIsNotNull(m, "bdpTaskConfig.httpService");
                        c.a.j.h.b.h.a p = aVar.p();
                        Intrinsics.checkExpressionValueIsNotNull(p, "bdpTaskConfig.schemeService");
                        c.a.j.j.j.a aVar2 = new c.a.j.j.j.a(aVar);
                        c.a.j.h.b.f.b n = aVar.n();
                        Intrinsics.checkExpressionValueIsNotNull(n, "bdpTaskConfig.imageService");
                        c.a.j.j.g.a aVar3 = new c.a.j.j.g.a();
                        c.a.j.h.b.g.a j = aVar.j();
                        Intrinsics.checkExpressionValueIsNotNull(j, "bdpTaskConfig.appLifecycle");
                        F(new c.a.j.j.b(bVar, m, p, aVar2, n, aVar3, j, null, null, 384, null));
                        b.a aVar4 = c.a.j.h.b.b.f3162c;
                        c.a.j.j.d.a w2 = w();
                        if (w2 == null) {
                            Intrinsics.throwNpe();
                        }
                        aVar4.j(w2);
                        if (aVar.o() != null) {
                            WeakReference<Context> o = aVar.o();
                            Context context2 = o != null ? o.get() : null;
                            if ((context2 instanceof Activity) && !c.a.j.h.d.a.a((Activity) context2) && (w = w()) != null && (h2 = w.h()) != null) {
                                h2.c((Activity) context2);
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

        public final synchronized void y() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
                synchronized (this) {
                    if (p() && !n().isEmpty()) {
                        e.c(b.a);
                    }
                }
            }
        }

        public final void z(TaskInfo taskInfo, c.a.j.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048603, this, taskInfo, bVar) == null) {
                J(this, false, new BDPTask$INSTANCE$registerTaskListenerSticky$1(taskInfo, bVar), 1, null);
            }
        }

        public /* synthetic */ INSTANCE(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"com/baidu/bdtask/BDPTask$subscribeStore$2", "Lc/a/j/h/a/b;", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "state", "", "newState", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)V", "<init>", "(Lcom/baidu/bdtask/BDPTask;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class a implements c.a.j.h.a.b<SubTaskState> {
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
        @Override // c.a.j.h.a.b
        public void a(SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, subTaskState) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                StringBuilder sb = new StringBuilder();
                sb.append("get newState: ");
                sb.append(subTaskState != null ? subTaskState.getTaskStatus() : null);
                sb.append(",taskInfo:");
                sb.append(subTaskState != null ? subTaskState.getTaskInfo() : null);
                DebugTrace.d(debugTrace, sb.toString(), "state", null, 4, null);
                if (subTaskState != null) {
                    BDPTask$subscribeStore$2$newState$$inlined$let$lambda$1 bDPTask$subscribeStore$2$newState$$inlined$let$lambda$1 = new BDPTask$subscribeStore$2$newState$$inlined$let$lambda$1(this, subTaskState);
                    c.a.j.f.e.a interceptor = subTaskState.getInterceptor();
                    if (interceptor != null) {
                        interceptor.b(new TaskState(subTaskState.getTaskInfo(), subTaskState.getTaskStatus()), bDPTask$subscribeStore$2$newState$$inlined$let$lambda$1);
                    } else {
                        bDPTask$subscribeStore$2$newState$$inlined$let$lambda$1.invoke();
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
        h.a(INSTANCE.AnonymousClass1.INSTANCE);
        f24903d = new c.a.j.j.a.a();
        f24907h = new ReentrantLock();
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
        d<com.baidu.bdtask.ctrl.b, c.a.j.f.d> dVar = new d<>(new BDPTask$store$1(new c.a.j.f.b()), new com.baidu.bdtask.ctrl.b(), CollectionsKt__CollectionsKt.listOf((Object[]) new Function2[]{new com.baidu.bdtask.ctrl.actions.exitstrategy.b().a(), new com.baidu.bdtask.ctrl.actions.duplicate.duplicate.b().a(), new com.baidu.bdtask.ctrl.actions.interrupt.b().a(), new com.baidu.bdtask.ctrl.actions.register.b().a(), new com.baidu.bdtask.ctrl.actions.dotask.visit.b().a(), new com.baidu.bdtask.ctrl.actions.dotask.click.b().a(), new com.baidu.bdtask.ctrl.actions.finishreq.b().b()}));
        this.a = dVar;
        this.f24908b = c.a.j.k.d.f3251d.a(dVar);
        this.f24909c = c.a.j.k.a.f3249c.a();
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

    public void A(Activity activity) {
        c.a.j.j.d.a v;
        c.a.j.h.b.d.a h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, activity) == null) || (v = m.v()) == null || (h2 = v.h()) == null) {
            return;
        }
        h2.c(activity);
    }

    public boolean B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            TaskState K = K(str);
            if (K != null) {
                TaskInfo taskInfo = K.getTaskInfo();
                if (taskInfo.getTaskRule().isNeedUnique() && !TextUtils.isEmpty(str2)) {
                    j0(taskInfo, c.a.j.f.c.d.a.a.f3128f.a(taskInfo, str2));
                    return true;
                }
                DebugTrace.a.c(new BDPTask$cacheDuplicateId$1(taskInfo, str2));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void C(String str) {
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (k2 = O().k(str)) != null && k2.getTaskInfo().isPassiveTask()) {
            j0(k2.getTaskInfo(), c.a.j.f.c.e.a.f3134e.a(k2.getTaskInfo(), k2.getTaskStatus().getCurStatus()));
        }
    }

    public void D(String str) {
        TaskInfo u;
        TaskInfo deepCopy;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (u = O().u(str)) == null || (deepCopy = u.deepCopy()) == null || !deepCopy.isPassiveTask()) {
            return;
        }
        O().b(deepCopy, 306, "clean passive task by force");
        j0(deepCopy, c.a.j.f.c.b.a.f3118f.a(deepCopy, "clean passive task by force"));
    }

    public void E(String str) {
        TaskInfo u;
        TaskInfo deepCopy;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (u = O().u(str)) == null || (deepCopy = u.deepCopy()) == null) {
            return;
        }
        O().b(deepCopy, 307, "clean task by force");
        j0(deepCopy, c.a.j.f.c.b.a.f3118f.a(deepCopy, "clean task by force"));
    }

    public final void F(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, subTaskState) == null) {
            TaskStatus taskStatus = subTaskState.getTaskStatus();
            TaskInfo taskInfo = subTaskState.getTaskInfo();
            DebugTrace.a.c(new BDPTask$dispatchState$1(taskInfo, taskStatus));
            try {
                if (taskStatus.hasErrorCode()) {
                    DebugTrace.a.c(new BDPTask$dispatchState$2(taskStatus));
                    O().b(taskInfo, taskStatus.getCurStatusCode(), taskStatus.getCurStatusCodeMsg());
                    if (!this.f24909c.b(taskInfo, taskStatus.getCurStatusCode())) {
                        this.f24909c.c(subTaskState);
                        return;
                    }
                } else {
                    O().a(taskInfo, taskStatus);
                }
                if (taskStatus.isFinished()) {
                    this.f24908b.c(subTaskState);
                } else if (taskStatus.isRunning()) {
                    this.f24908b.b(subTaskState);
                } else if (taskStatus.isRegistered()) {
                    this.f24908b.a(subTaskState);
                } else if (taskStatus.isInterrupted()) {
                    this.f24908b.d(subTaskState);
                } else if (taskStatus.isUnRegistered()) {
                    this.f24908b.e(subTaskState);
                }
            } finally {
                z(this, false, taskInfo, 1, null);
            }
        }
    }

    public final void G(String str, UniqueId uniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, uniqueId) == null) {
            SubTaskState k2 = O().k(str);
            TaskInfo taskInfo = k2 != null ? k2.getTaskInfo() : null;
            if (taskInfo != null) {
                TaskBusinessEventManager.f24938c.c(taskInfo, uniqueId);
            } else {
                TaskBusinessEventManager.f24938c.d(str, uniqueId);
            }
        }
    }

    public boolean H(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) ? !com.baidu.bdtask.service.cache.b.f24944e.a().f(str, str2) : invokeLL.booleanValue;
    }

    public Map<String, List<TaskState>> I(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr)) == null) ? O().g((String[]) Arrays.copyOf(strArr, strArr.length)) : (Map) invokeL.objValue;
    }

    public void J(c.a.j.b bVar, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bVar, strArr) == null) {
            bVar.a(I((String[]) Arrays.copyOf(strArr, strArr.length)));
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

    public void L(String str, c.a.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, cVar) == null) {
            TaskInfo p = O().p(str);
            if (p == null) {
                cVar.a(null);
                return;
            }
            SubTaskState k2 = O().k(p.getSingleKey());
            if (k2 == null) {
                cVar.a(null);
            } else {
                cVar.a(new TaskState(k2.getTaskInfo().deepCopy(), k2.getTaskStatus().deepCopy()));
            }
        }
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

    public void N(c.a.j.c cVar, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, cVar, strArr) == null) {
            TaskState M = M((String[]) Arrays.copyOf(strArr, strArr.length));
            if (M == null) {
                cVar.a(null);
            } else {
                cVar.a(M.deepCopy());
            }
        }
    }

    public final com.baidu.bdtask.ctrl.b O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a.a() : (com.baidu.bdtask.ctrl.b) invokeV.objValue;
    }

    public TaskState P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(O(), null, 1, null);
            if (c2 != null) {
                return new TaskState(c2.getTaskInfo().deepCopy(), c2.getTaskStatus().deepCopy());
            }
            return null;
        }
        return (TaskState) invokeV.objValue;
    }

    public final void Q(TaskInfo taskInfo, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048592, this, taskInfo, i2) == null) && taskInfo.isPassiveTask()) {
            j0(taskInfo, c.a.j.f.c.g.a.f3140g.a(taskInfo, i2));
        }
    }

    public void R(String str, c.a.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, aVar) == null) {
            SubTaskState t = O().t(str);
            if (t == null) {
                aVar.b(new TaskInfo(null, null, 0, null, 0, null, null, null, null, null, null, RevenueServerConst.GetUserCouponStoreResponse, null), 101, "task was not existed");
            } else {
                U(t.getTaskInfo(), aVar);
            }
        }
    }

    public <T extends c.a.j.g.a> void S(String str, Class<T> cls, c.a.j.g.b<T> bVar) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, str, cls, bVar) == null) || (K = K(str)) == null || (taskInfo = K.getTaskInfo()) == null) {
            return;
        }
        TaskBusinessEventManager.f24938c.a(taskInfo, cls, bVar);
    }

    public void T(String str, c.a.j.g.c cVar) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, cVar) == null) || (K = K(str)) == null || (taskInfo = K.getTaskInfo()) == null) {
            return;
        }
        TaskBusinessEventManager.f24938c.b(taskInfo, cVar);
    }

    public final void U(TaskInfo taskInfo, c.a.j.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, taskInfo, bVar) == null) {
            V(taskInfo, bVar, false);
        }
    }

    public final void V(TaskInfo taskInfo, c.a.j.d.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048597, this, taskInfo, bVar, z) == null) {
            SubTaskState k2 = O().k(taskInfo.getSingleKey());
            if (k2 == null) {
                bVar.b(taskInfo, 101, "task was not existed");
                return;
            }
            if (z) {
                bVar.a(k2.getTaskInfo(), k2.getTaskStatus());
            }
            k2.addCallback(bVar);
        }
    }

    public final void W(TaskInfo taskInfo, c.a.j.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, taskInfo, bVar) == null) {
            V(taskInfo, bVar, true);
        }
    }

    public void X(String str, c.a.j.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, bVar) == null) {
            TaskState K = K(str);
            if (K == null) {
                bVar.b(new TaskInfo(null, null, 0, null, 0, null, null, null, null, null, null, RevenueServerConst.GetUserCouponStoreResponse, null), 101, "task was not existed");
            } else {
                U(K.getTaskInfo(), bVar);
            }
        }
    }

    public final void Y(TaskInfo taskInfo, c.a.j.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, taskInfo, bVar) == null) {
            Z(taskInfo, true, bVar);
        }
    }

    public final void Z(TaskInfo taskInfo, boolean z, c.a.j.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{taskInfo, Boolean.valueOf(z), bVar}) == null) {
            a0(taskInfo, z, bVar, null);
        }
    }

    public final void a0(TaskInfo taskInfo, boolean z, c.a.j.d.b bVar, c.a.j.f.e.a aVar) {
        TaskInfo copy;
        TaskState K;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{taskInfo, Boolean.valueOf(z), bVar, aVar}) == null) {
            if (taskInfo == null) {
                if (bVar != null) {
                    bVar.b(new TaskInfo(null, null, 0, null, 0, null, null, null, null, null, null, RevenueServerConst.GetUserCouponStoreResponse, null), 201, "task info parse failed");
                }
            } else if (!taskInfo.isValid()) {
                if (bVar != null) {
                    bVar.b(taskInfo, 201, "task info parse failed");
                }
            } else if (!g.a.c(taskInfo.getTaskRule().getExpireTime())) {
                if (bVar != null) {
                    bVar.b(taskInfo, 103, "task is expired");
                }
            } else {
                SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(O(), null, 1, null);
                if (c2 != null) {
                    O().b(c2.getTaskInfo(), 102, "task is abandoned by new task registered");
                    if (c2.getTaskInfo().isInitiActiveTask()) {
                        DebugTrace.a.c(new BDPTask$registerTaskWithInfo$1$1$1(c2));
                        u0(c2.getTaskInfo().getActionId(), "task is abandoned by new task registered");
                    } else if (c2.getTaskInfo().isPassiveTask()) {
                        DebugTrace.a.c(new BDPTask$registerTaskWithInfo$1$1$2(c2));
                        Q(c2.getTaskInfo(), 102);
                    }
                }
                if (!z && (K = K(taskInfo.getActionId())) != null && K.getTaskInfo().isValid() && K.getTaskStatus().isEnable() && bVar != null) {
                    if (aVar != null) {
                        h0(taskInfo, aVar);
                    }
                    W(taskInfo, bVar);
                    return;
                }
                copy = taskInfo.copy((r24 & 1) != 0 ? taskInfo.id : null, (r24 & 2) != 0 ? taskInfo.actionId : null, (r24 & 4) != 0 ? taskInfo.type : 0, (r24 & 8) != 0 ? taskInfo.token : null, (r24 & 16) != 0 ? taskInfo.behavior : 0, (r24 & 32) != 0 ? taskInfo.actTaskId : null, (r24 & 64) != 0 ? taskInfo.fingerprint : null, (r24 & 128) != 0 ? taskInfo.taskRule : null, (r24 & 256) != 0 ? taskInfo.taskGuide : null, (r24 & 512) != 0 ? taskInfo.taskMeter : null, (r24 & 1024) != 0 ? taskInfo.response : null);
                j0(taskInfo, new c.a.j.f.c.h.a(copy, bVar, aVar, null, null, null, 56, null));
            }
        }
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            Y(new c.a.j.i.b(str).a(), null);
        }
    }

    public void c0(String str, c.a.j.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, bVar) == null) {
            Y(new c.a.j.i.b(str).a(), bVar);
        }
    }

    public void d0(String str, c.a.j.d.b bVar, c.a.j.f.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, str, bVar, aVar) == null) {
            a0(new c.a.j.i.b(str).a(), true, bVar, aVar);
        }
    }

    public final void e0(TaskInfo taskInfo) {
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, taskInfo) == null) || (k2 = O().k(taskInfo.getSingleKey())) == null) {
            return;
        }
        k2.setInterceptor(null);
    }

    public void f0(String str) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || (K = K(str)) == null || (taskInfo = K.getTaskInfo()) == null) {
            return;
        }
        e0(taskInfo);
    }

    public final void g0(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, taskInfo) == null) {
            j0(taskInfo, new c.a.j.f.c.a.a(taskInfo, null, 0, null, null, 30, null));
        }
    }

    public final void h0(TaskInfo taskInfo, c.a.j.f.e.a aVar) {
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, taskInfo, aVar) == null) || (k2 = O().k(taskInfo.getSingleKey())) == null) {
            return;
        }
        k2.setInterceptor(aVar);
    }

    public void i0(String str, c.a.j.f.e.a aVar) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048610, this, str, aVar) == null) || (K = K(str)) == null || (taskInfo = K.getTaskInfo()) == null) {
            return;
        }
        h0(taskInfo, aVar);
    }

    public final void j0(TaskInfo taskInfo, c.a.j.h.a.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, taskInfo, aVar) == null) && taskInfo.isValid()) {
            k0(taskInfo);
            DebugTrace.a.c(new BDPTask$storeDispatch$1(aVar));
            this.a.b(aVar);
        }
    }

    public final void k0(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, taskInfo) == null) {
            if (!taskInfo.isValid()) {
                DebugTrace.a.c(new BDPTask$subscribeStore$1(taskInfo));
            } else {
                this.a.c(new a(this), new BDPTask$subscribeStore$3(this));
            }
        }
    }

    public void l0(String str, String str2, int i2, c.a.j.f.g.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048613, this, str, str2, i2, aVar) == null) {
            m0(str, str2, i2, null, aVar);
        }
    }

    public void m0(String str, String str2, int i2, JSONObject jSONObject, c.a.j.f.g.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, Integer.valueOf(i2), jSONObject, aVar}) == null) {
            com.baidu.bdtask.ctrl.repo.api.a.f24936b.a(str, str2, i2, jSONObject, aVar);
        }
    }

    public final void n0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        O().o(str);
        SubTaskState j2 = O().j();
        if (j2 != null) {
            DebugTrace.a.c(new BDPTask$taskStateRestore$1$1(j2));
            g0(j2.getTaskInfo());
            DebugTrace.a.c(new BDPTask$taskStateRestore$$inlined$let$lambda$1(this));
        }
        z(this, true, null, 2, null);
        SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(O(), null, 1, null);
        if (c2 != null) {
            k0(c2.getTaskInfo());
        }
    }

    public void o0(String str, c.a.j.d.a aVar) {
        SubTaskState t;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, str, aVar) == null) || (t = O().t(str)) == null || (taskInfo = t.getTaskInfo()) == null) {
            return;
        }
        r0(taskInfo, aVar);
    }

    public <T extends c.a.j.g.a> void p0(String str, c.a.j.g.b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, bVar) == null) {
            TaskBusinessEventManager.f24938c.g(str, bVar);
        }
    }

    public void q0(String str, c.a.j.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, str, cVar) == null) {
            TaskBusinessEventManager.f24938c.h(str, cVar);
        }
    }

    public final void r0(TaskInfo taskInfo, c.a.j.d.b bVar) {
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048619, this, taskInfo, bVar) == null) || (k2 = O().k(taskInfo.getSingleKey())) == null) {
            return;
        }
        k2.removeCallback(bVar);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            t(str, "");
        }
    }

    public void s0(String str, c.a.j.d.b bVar) {
        TaskState K;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, str, bVar) == null) || (K = K(str)) == null || (taskInfo = K.getTaskInfo()) == null) {
            return;
        }
        r0(taskInfo, bVar);
    }

    public void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, str, str2) == null) {
            u(str, str2, "");
        }
    }

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            u0(str, "common unregister");
        }
    }

    public void u(String str, String str2, String str3) {
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048624, this, str, str2, str3) == null) {
            SubTaskState q = O().q(str);
            TaskInfo taskInfo2 = q != null ? q.getTaskInfo() : null;
            TaskStatus taskStatus = q != null ? q.getTaskStatus() : null;
            DebugTrace.a.c(new BDPTask$addActionWithActionId$1(taskInfo2, taskStatus));
            if (taskInfo2 == null || taskStatus == null) {
                return;
            }
            c.a.j.k.e.a.a.f3255c.d(UBCActionTaskInfo.Companion.b(str2, taskInfo2, taskStatus));
            if (taskInfo2.isClickAction()) {
                if (H(str, str2)) {
                    TaskState K = K(str);
                    if (K == null || (taskInfo = K.getTaskInfo()) == null) {
                        return;
                    }
                    j0(taskInfo, c.a.j.f.c.d.b.a.f3131f.a(taskInfo));
                    return;
                }
                j0(taskInfo2, new c.a.j.f.c.c.a.a(taskInfo2.getSingleKey(), str2, str3, null, null, 24, null));
            }
        }
    }

    public final void u0(String str, String str2) {
        TaskInfo s;
        TaskInfo deepCopy;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048625, this, str, str2) == null) || (s = O().s(str)) == null || (deepCopy = s.deepCopy()) == null) {
            return;
        }
        j0(deepCopy, c.a.j.f.c.b.a.f3118f.a(deepCopy, str2));
    }

    public void v(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048626, this, str, j2) == null) {
            w(str, j2, "");
        }
    }

    public void w(String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{str, Long.valueOf(j2), str2}) == null) {
            x(str, j2, str2, "");
        }
    }

    public void x(String str, long j2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{str, Long.valueOf(j2), str2, str3}) == null) {
            SubTaskState q = O().q(str);
            TaskInfo taskInfo = q != null ? q.getTaskInfo() : null;
            TaskStatus taskStatus = q != null ? q.getTaskStatus() : null;
            DebugTrace.a.c(new BDPTask$addDurationWithActionId$1(taskInfo, taskStatus));
            if (taskInfo == null || taskStatus == null) {
                return;
            }
            c.a.j.k.e.a.a.f3255c.d(UBCActionTaskInfo.Companion.a(j2, str2, taskInfo, taskStatus));
            if (taskInfo.isVisitAction()) {
                if (H(str, str2)) {
                    j0(taskInfo, c.a.j.f.c.d.b.a.f3131f.b(taskInfo));
                } else {
                    j0(taskInfo, new c.a.j.f.c.c.b.a(j2, taskInfo.getSingleKey(), str2, str3, null, null, 48, null));
                }
            }
        }
    }

    public final void y(boolean z, TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048629, this, z, taskInfo) == null) {
            com.baidu.bdtask.service.cache.b.f24944e.a().c(O(), taskInfo, z);
        }
    }

    public /* synthetic */ BDPTask(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
