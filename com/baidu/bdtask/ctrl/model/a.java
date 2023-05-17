package com.baidu.bdtask.ctrl.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.service.cache.b;
import com.baidu.bdtask.service.ubc.model.UBCRecoveryTaskInfo;
import com.baidu.bdtask.service.ubc.model.UBCRecoveryTaskQueue;
import com.baidu.bdtask.service.ubc.model.UBCRegisterTaskInfo;
import com.baidu.tieba.st;
import com.baidu.tieba.tq;
import com.baidu.tieba.ut;
import com.baidu.tieba.wv;
import com.baidu.tieba.zu;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 H:\u0001HB\t\b\u0016¢\u0006\u0004\bD\u0010EB\u0011\b\u0016\u0012\u0006\u0010F\u001a\u00020\u0000¢\u0006\u0004\bD\u0010GJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\fJ>\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00192'\b\u0002\u0010\u0018\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00192\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001c\"\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J-\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060(2\u0006\u0010&\u001a\u00020\u00012\b\b\u0002\u0010'\u001a\u00020\u0017H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b+\u0010!J\u0015\u0010,\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b.\u0010-J'\u0010/\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00060(2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b/\u00100J6\u00101\u001a\u0004\u0018\u00010\u00012#\u0010\u0018\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0012H\u0002¢\u0006\u0004\b1\u00102J[\u00101\u001a\u0004\u0018\u00010\u00012#\u00103\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u00122#\u00104\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0012H\u0002¢\u0006\u0004\b1\u00105J\u001b\u00107\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0004\b7\u00108R$\u00109\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010!\"\u0004\b<\u0010\u0005R(\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006I"}, d2 = {"Lcom/baidu/bdtask/ctrl/model/TaskStateQueue;", "Lcom/baidu/bdtask/ctrl/SubTaskState;", TaskState.key, "", "addIfPresent", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)V", "", "rawString", "deserializeFromJson", "(Ljava/lang/String;)V", "actionId", "findPassiveSubTaskByActionId", "(Ljava/lang/String;)Lcom/baidu/bdtask/ctrl/SubTaskState;", TaskInfo.keyActTaskId, "findSubTaskByActTaskId", "findSubTaskByActionId", "singleKey", "findSubTaskBySingleKey", "Lkotlin/Function1;", "Lcom/baidu/bdtask/model/info/TaskInfo;", "Lkotlin/ParameterName;", "name", NextActive.keyTaskInfo, "", "filter", "", "getAllSubTask", "(Lkotlin/Function1;)Ljava/util/List;", "", "actionIds", "getAllSubTaskByActionIds", "([Ljava/lang/String;)Ljava/util/List;", "getCurActive", "()Lcom/baidu/bdtask/ctrl/SubTaskState;", "getSerializeJson", "()Ljava/lang/String;", "isEmpty", "()Z", "tempItem", "forceJudgeInterrupted", "Lkotlin/Pair;", "passiveTaskCanActiveAble", "(Lcom/baidu/bdtask/ctrl/SubTaskState;Z)Lkotlin/Pair;", "peekPassiveTask", "remove", "(Lcom/baidu/bdtask/model/info/TaskInfo;)V", "removePassiveTask", "restoreTaskCheck", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)Lkotlin/Pair;", "subTaskFilter", "(Lkotlin/Function1;)Lcom/baidu/bdtask/ctrl/SubTaskState;", "initiativeTaskFilter", "passiveTaskFilter", "(Lkotlin/Function1;Lkotlin/Function1;)Lcom/baidu/bdtask/ctrl/SubTaskState;", "Lcom/baidu/bdtask/TaskState;", "taskState2subTaskState", "(Lcom/baidu/bdtask/TaskState;)Lcom/baidu/bdtask/ctrl/SubTaskState;", "initiativeTask", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "getInitiativeTask", "setInitiativeTask", "Ljava/util/PriorityQueue;", "passiveTaskQueue", "Ljava/util/PriorityQueue;", "getPassiveTaskQueue", "()Ljava/util/PriorityQueue;", "setPassiveTaskQueue", "(Ljava/util/PriorityQueue;)V", "<init>", "()V", "other", "(Lcom/baidu/bdtask/ctrl/model/TaskStateQueue;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final ReentrantLock c;
    public static final C0073a d;
    public transient /* synthetic */ FieldHolder $fh;
    public SubTaskState a;
    public PriorityQueue<SubTaskState> b;

    /* renamed from: com.baidu.bdtask.ctrl.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0073a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0073a() {
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

        public final ReentrantLock a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return a.c;
            }
            return (ReentrantLock) invokeV.objValue;
        }

        public /* synthetic */ C0073a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2001500022, "Lcom/baidu/bdtask/ctrl/model/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2001500022, "Lcom/baidu/bdtask/ctrl/model/a;");
                return;
            }
        }
        d = new C0073a(null);
        c = new ReentrantLock(true);
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
                return;
            }
        }
        this.b = tq.a(5);
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.a == null && this.b.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public a(a aVar) {
        SubTaskState subTaskState;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = tq.a(5);
        SubTaskState subTaskState2 = aVar.a;
        if (subTaskState2 != null) {
            subTaskState = subTaskState2.deepCopy();
        } else {
            subTaskState = null;
        }
        this.a = subTaskState;
        PriorityQueue<SubTaskState> a = tq.a(5);
        a.addAll(aVar.b);
        while (!a.isEmpty()) {
            SubTaskState poll = a.poll();
            if (poll != null) {
                tq.b(this.b, poll.deepCopy(), 5);
            }
        }
    }

    public static /* bridge */ /* synthetic */ Pair h(a aVar, SubTaskState subTaskState, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return aVar.g(subTaskState, z);
    }

    public final SubTaskState a() {
        InterceptResult invokeV;
        SubTaskState subTaskState;
        SubTaskState subTaskState2;
        TaskStatus taskStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                if (this.a != null && (subTaskState2 = this.a) != null && (taskStatus = subTaskState2.getTaskStatus()) != null && taskStatus.isActivated()) {
                    subTaskState = this.a;
                } else {
                    Iterator<SubTaskState> it = this.b.iterator();
                    while (it.hasNext()) {
                        SubTaskState next = it.next();
                        if (next.getTaskStatus().isActivated()) {
                            return next;
                        }
                    }
                    subTaskState = null;
                }
                return subTaskState;
            } finally {
                a.unlock();
            }
        }
        return (SubTaskState) invokeV.objValue;
    }

    public final SubTaskState b(TaskState taskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskState)) == null) {
            if (taskState == null) {
                return null;
            }
            return new SubTaskState(taskState.getTaskInfo(), taskState.getTaskStatus(), null, 4, null);
        }
        return (SubTaskState) invokeL.objValue;
    }

    public final SubTaskState c(final String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                return m(new Function1<TaskInfo, Boolean>(this, str) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$findSubTaskBySingleKey$$inlined$withLock$lambda$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $singleKey$inlined;
                    public final /* synthetic */ a this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.$singleKey$inlined = str;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Boolean invoke(TaskInfo taskInfo) {
                        return Boolean.valueOf(invoke2(taskInfo));
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final boolean invoke2(TaskInfo taskInfo) {
                        InterceptResult invokeL2;
                        String str2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo)) == null) {
                            if (taskInfo != null) {
                                str2 = taskInfo.getSingleKey();
                            } else {
                                str2 = null;
                            }
                            return Intrinsics.areEqual(str2, this.$singleKey$inlined);
                        }
                        return invokeL2.booleanValue;
                    }
                });
            } finally {
                a.unlock();
            }
        }
        return (SubTaskState) invokeL.objValue;
    }

    public final List<SubTaskState> f(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
            final HashSet hashSet = new HashSet();
            for (String str : strArr) {
                hashSet.add(str);
            }
            return e(new Function1<TaskInfo, Boolean>(hashSet) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$getAllSubTaskByActionIds$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashSet $hashSet;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {hashSet};
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
                    this.$hashSet = hashSet;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(TaskInfo taskInfo) {
                    return Boolean.valueOf(invoke2(taskInfo));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(TaskInfo taskInfo) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo)) == null) {
                        if (taskInfo != null && this.$hashSet.contains(taskInfo.getActionId())) {
                            return true;
                        }
                        return false;
                    }
                    return invokeL2.booleanValue;
                }
            });
        }
        return (List) invokeL.objValue;
    }

    public final SubTaskState l(final String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                return m(new Function1<TaskInfo, Boolean>(this, str) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$findSubTaskByActionId$$inlined$withLock$lambda$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $actionId$inlined;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.$actionId$inlined = str;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Boolean invoke(TaskInfo taskInfo) {
                        return Boolean.valueOf(invoke2(taskInfo));
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final boolean invoke2(TaskInfo taskInfo) {
                        InterceptResult invokeL2;
                        String str2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo)) == null) {
                            if (taskInfo != null) {
                                str2 = taskInfo.getActionId();
                            } else {
                                str2 = null;
                            }
                            return Intrinsics.areEqual(str2, this.$actionId$inlined);
                        }
                        return invokeL2.booleanValue;
                    }
                });
            } finally {
                a.unlock();
            }
        }
        return (SubTaskState) invokeL.objValue;
    }

    public final SubTaskState m(Function1<? super TaskInfo, Boolean> function1) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, function1)) == null) {
            return d(function1, function1);
        }
        return (SubTaskState) invokeL.objValue;
    }

    public final SubTaskState p(final String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                return m(new Function1<TaskInfo, Boolean>(this, str) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$findSubTaskByActTaskId$$inlined$withLock$lambda$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $actTaskId$inlined;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.$actTaskId$inlined = str;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Boolean invoke(TaskInfo taskInfo) {
                        return Boolean.valueOf(invoke2(taskInfo));
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final boolean invoke2(TaskInfo taskInfo) {
                        InterceptResult invokeL2;
                        String str2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo)) == null) {
                            if (taskInfo != null) {
                                str2 = taskInfo.getActTaskId();
                            } else {
                                str2 = null;
                            }
                            return Intrinsics.areEqual(str2, this.$actTaskId$inlined);
                        }
                        return invokeL2.booleanValue;
                    }
                });
            } finally {
                a.unlock();
            }
        }
        return (SubTaskState) invokeL.objValue;
    }

    public final SubTaskState d(Function1<? super TaskInfo, Boolean> function1, Function1<? super TaskInfo, Boolean> function12) {
        InterceptResult invokeLL;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, function1, function12)) == null) {
            SubTaskState subTaskState = this.a;
            if (subTaskState != null) {
                if (subTaskState != null) {
                    taskInfo = subTaskState.getTaskInfo();
                } else {
                    taskInfo = null;
                }
                if (function1.invoke(taskInfo).booleanValue()) {
                    return this.a;
                }
            }
            Iterator<SubTaskState> it = this.b.iterator();
            while (it.hasNext()) {
                SubTaskState next = it.next();
                if (function12.invoke(next.getTaskInfo()).booleanValue()) {
                    return next;
                }
            }
            return null;
        }
        return (SubTaskState) invokeLL.objValue;
    }

    public final List<SubTaskState> e(Function1<? super TaskInfo, Boolean> function1) {
        InterceptResult invokeL;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, function1)) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                ArrayList arrayList = new ArrayList();
                if (this.a != null) {
                    if (function1 == null) {
                        arrayList.add(this.a);
                    } else {
                        SubTaskState subTaskState = this.a;
                        if (subTaskState != null) {
                            taskInfo = subTaskState.getTaskInfo();
                        } else {
                            taskInfo = null;
                        }
                        if (function1.invoke(taskInfo).booleanValue()) {
                            arrayList.add(this.a);
                        }
                    }
                }
                Iterator<SubTaskState> it = this.b.iterator();
                while (it.hasNext()) {
                    SubTaskState next = it.next();
                    if (next != null) {
                        if (function1 == null) {
                            arrayList.add(next);
                        } else if (function1.invoke(next.getTaskInfo()).booleanValue()) {
                            arrayList.add(next);
                        }
                    }
                }
                return arrayList;
            } finally {
                a.unlock();
            }
        }
        return (List) invokeL.objValue;
    }

    public final Pair<Boolean, String> g(final SubTaskState subTaskState, final boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, subTaskState, z)) == null) {
            DebugTrace.a.c(new Function0<String>(subTaskState, z) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$passiveTaskCanActiveAble$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean $forceJudgeInterrupted;
                public final /* synthetic */ SubTaskState $tempItem;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {subTaskState, Boolean.valueOf(z)};
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
                    this.$tempItem = subTaskState;
                    this.$forceJudgeInterrupted = z;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    boolean z3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("isEnableActivated:");
                        sb.append(this.$tempItem.getTaskInfo().isEnableActivated());
                        sb.append(" isInterrupted ");
                        if (this.$forceJudgeInterrupted && !this.$tempItem.getTaskStatus().isInterrupted()) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        sb.append(z3);
                        sb.append(" !isDone:");
                        sb.append(!this.$tempItem.getTaskInfo().isDone());
                        sb.append(" !hasFailed:");
                        sb.append(!this.$tempItem.getTaskStatus().getTaskStatusRuntime().getHasFailed());
                        return sb.toString();
                    }
                    return (String) invokeV.objValue;
                }
            });
            if (subTaskState.getTaskInfo().isEnableActivated() && ((!z || subTaskState.getTaskStatus().isInterrupted()) && !subTaskState.getTaskInfo().isDone() && !subTaskState.getTaskStatus().getTaskStatusRuntime().getHasFailed())) {
                return new Pair<>(Boolean.TRUE, "");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("isEnableActivated:");
            sb.append(subTaskState.getTaskInfo().isEnableActivated());
            sb.append(" isInterrupted ");
            if (z && !subTaskState.getTaskStatus().isInterrupted()) {
                z2 = false;
            } else {
                z2 = true;
            }
            sb.append(z2);
            sb.append(" !isDone:");
            sb.append(!subTaskState.getTaskInfo().isDone());
            sb.append(" !hasFailed:");
            sb.append(!subTaskState.getTaskStatus().getTaskStatusRuntime().getHasFailed());
            return new Pair<>(Boolean.FALSE, sb.toString());
        }
        return (Pair) invokeLZ.objValue;
    }

    public final void i(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, subTaskState) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                TaskInfo taskInfo = subTaskState.getTaskInfo();
                if (taskInfo.isInitiActiveTask()) {
                    this.a = subTaskState;
                } else if (taskInfo.isPassiveTask()) {
                    o(subTaskState.getTaskInfo());
                    tq.b(this.b, subTaskState, 5);
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                a.unlock();
            }
        }
    }

    public final void j(TaskInfo taskInfo) {
        TaskInfo taskInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, taskInfo) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                if (taskInfo.isPassiveTask()) {
                    o(taskInfo);
                }
                if (taskInfo.isInitiActiveTask()) {
                    SubTaskState subTaskState = this.a;
                    if (subTaskState != null) {
                        taskInfo2 = subTaskState.getTaskInfo();
                    } else {
                        taskInfo2 = null;
                    }
                    if (Intrinsics.areEqual(taskInfo2, taskInfo)) {
                        this.a = null;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                a.unlock();
            }
        }
    }

    public final void o(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, taskInfo) == null) {
            Iterator<SubTaskState> it = this.b.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getTaskInfo().getId(), taskInfo.getId())) {
                    it.remove();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
        com.baidu.bdtask.framework.utils.DebugTrace.a.c(com.baidu.bdtask.ctrl.model.TaskStateQueue$peekPassiveTask$1$2.INSTANCE);
        com.baidu.tieba.zu.c.f(com.baidu.bdtask.service.ubc.model.UBCRegisterTaskInfo.a.e(com.baidu.bdtask.service.ubc.model.UBCRegisterTaskInfo.Companion, r3.getTaskInfo(), r3.getTaskStatus(), (java.lang.String) r4.getSecond(), 0, 8, null));
        r2 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SubTaskState k() {
        InterceptResult invokeV;
        final SubTaskState poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                SubTaskState a2 = a();
                SubTaskState subTaskState = null;
                if (a2 == null || !a2.getTaskStatus().isActivated() || a2.getTaskStatus().isInterrupted()) {
                    PriorityQueue<SubTaskState> d2 = tq.d(5);
                    d2.addAll(this.b);
                    while (true) {
                        if (d2.isEmpty() || (poll = d2.poll()) == null) {
                            break;
                        }
                        DebugTrace.a.c(new Function0<String>(poll) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$peekPassiveTask$1$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SubTaskState $tempItem;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {poll};
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
                                this.$tempItem = poll;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                InterceptResult invokeV2;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                    return "try active " + this.$tempItem.toJson();
                                }
                                return (String) invokeV2.objValue;
                            }
                        });
                        Pair h = h(this, poll, false, 2, null);
                        if (((Boolean) h.getFirst()).booleanValue()) {
                            break;
                        }
                        zu.c.f(UBCRegisterTaskInfo.Companion.d(poll.getTaskInfo(), poll.getTaskStatus(), (String) h.getSecond(), 0));
                        DebugTrace.a.c(TaskStateQueue$peekPassiveTask$1$3.INSTANCE);
                        poll.getTaskStatus().reset2Interrupted();
                    }
                }
                return subTaskState;
            } finally {
                a.unlock();
            }
        }
        return (SubTaskState) invokeV.objValue;
    }

    public final String q() {
        InterceptResult invokeV;
        TaskInfo taskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<SubTaskState> it = this.b.iterator();
                while (it.hasNext()) {
                    SubTaskState next = it.next();
                    if (b.e.a().e(next.getTaskInfo())) {
                        jSONArray.put(next.toJson());
                    }
                }
                JSONObject jSONObject = new JSONObject();
                if (this.a != null) {
                    b a2 = b.e.a();
                    SubTaskState subTaskState = this.a;
                    if (subTaskState != null) {
                        taskInfo = subTaskState.getTaskInfo();
                    } else {
                        taskInfo = null;
                    }
                    if (a2.e(taskInfo)) {
                        SubTaskState subTaskState2 = this.a;
                        if (subTaskState2 == null) {
                            Intrinsics.throwNpe();
                        }
                        TaskInfo taskInfo2 = subTaskState2.getTaskInfo();
                        SubTaskState subTaskState3 = this.a;
                        if (subTaskState3 == null) {
                            Intrinsics.throwNpe();
                        }
                        jSONObject.put("initiativeTask", new TaskState(taskInfo2, subTaskState3.getTaskStatus()).toJson());
                    }
                }
                jSONObject.put("passiveTaskQueue", jSONArray);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "JSONObject().apply {\n   …ray)\n        }.toString()");
                return jSONObject2;
            } finally {
                a.unlock();
            }
        }
        return (String) invokeV.objValue;
    }

    public final Pair<SubTaskState, String> n(SubTaskState subTaskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, subTaskState)) == null) {
            if (subTaskState == null) {
                return new Pair<>(null, "taskState is null");
            }
            final TaskInfo taskInfo = subTaskState.getTaskInfo();
            final TaskStatus taskStatus = subTaskState.getTaskStatus();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            if (!wv.a.c(taskInfo.getTaskRule().getExpireTime())) {
                objectRef.element = "skipCache by expireTime error";
                DebugTrace.a.c(new Function0<String>(objectRef, taskInfo) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$restoreTaskCheck$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Ref.ObjectRef $errorMsg;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskInfo $taskInfo;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {objectRef, taskInfo};
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
                        this.$errorMsg = objectRef;
                        this.$taskInfo = taskInfo;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "" + ((String) this.$errorMsg.element) + ", task info :" + this.$taskInfo;
                        }
                        return (String) invokeV.objValue;
                    }
                });
                return new Pair<>(null, (String) objectRef.element);
            } else if (!taskStatus.isUnRegistered() && !subTaskState.isForceCleaned()) {
                if (!taskInfo.isValid()) {
                    objectRef.element = "skipCache by taskinfo is invalid";
                    DebugTrace.a.c(new Function0<String>(objectRef, taskInfo) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$restoreTaskCheck$3
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ Ref.ObjectRef $errorMsg;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TaskInfo $taskInfo;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {objectRef, taskInfo};
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
                            this.$errorMsg = objectRef;
                            this.$taskInfo = taskInfo;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return "" + ((String) this.$errorMsg.element) + " task info :" + this.$taskInfo;
                            }
                            return (String) invokeV.objValue;
                        }
                    });
                    return new Pair<>(null, (String) objectRef.element);
                } else if (taskInfo.isDone() && taskInfo.isInitiActiveTask()) {
                    objectRef.element = "skipCache by initiactive task has done";
                    DebugTrace.a.c(new Function0<String>(objectRef, taskInfo) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$restoreTaskCheck$4
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ Ref.ObjectRef $errorMsg;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TaskInfo $taskInfo;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {objectRef, taskInfo};
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
                            this.$errorMsg = objectRef;
                            this.$taskInfo = taskInfo;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return "" + ((String) this.$errorMsg.element) + " , task info :" + this.$taskInfo;
                            }
                            return (String) invokeV.objValue;
                        }
                    });
                    return new Pair<>(null, (String) objectRef.element);
                } else if (subTaskState.isGotMaxNoClickTimes()) {
                    objectRef.element = "skipCache by get isGotMaxNoClickTimes";
                    DebugTrace.a.c(new Function0<String>(objectRef, taskInfo, taskStatus) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$restoreTaskCheck$5
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ Ref.ObjectRef $errorMsg;
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
                                Object[] objArr = {objectRef, taskInfo, taskStatus};
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
                            this.$errorMsg = objectRef;
                            this.$taskInfo = taskInfo;
                            this.$taskStatus = taskStatus;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return "" + ((String) this.$errorMsg.element) + " , task info :" + this.$taskInfo + " errorno:" + this.$taskStatus + ".curStatusCode";
                            }
                            return (String) invokeV.objValue;
                        }
                    });
                    return new Pair<>(null, (String) objectRef.element);
                } else {
                    return new Pair<>(subTaskState, (String) objectRef.element);
                }
            } else {
                objectRef.element = "skipCache by UnRegistered or ForceCleaned";
                DebugTrace.a.c(new Function0<String>(objectRef, taskInfo) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$restoreTaskCheck$2
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Ref.ObjectRef $errorMsg;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskInfo $taskInfo;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {objectRef, taskInfo};
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
                        this.$errorMsg = objectRef;
                        this.$taskInfo = taskInfo;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "" + ((String) this.$errorMsg.element) + ", task info :" + this.$taskInfo;
                        }
                        return (String) invokeV.objValue;
                    }
                });
                return new Pair<>(null, (String) objectRef.element);
            }
        }
        return (Pair) invokeL.objValue;
    }

    public final void r(final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            DebugTrace.a.c(new Function0<String>(str) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$deserializeFromJson$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $rawString;

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
                    this.$rawString = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "deserializeFromJson from " + this.$rawString;
                    }
                    return (String) invokeV.objValue;
                }
            });
            ReentrantLock a = d.a();
            a.lock();
            try {
                try {
                    UBCRecoveryTaskQueue uBCRecoveryTaskQueue = new UBCRecoveryTaskQueue();
                    ut utVar = new ut();
                    JSONObject jSONObject = new JSONObject(str);
                    a aVar = new a();
                    String initiativeTaskJsonStr = jSONObject.optString("initiativeTask");
                    if (!TextUtils.isEmpty(initiativeTaskJsonStr)) {
                        st a2 = utVar.a(TaskState.key);
                        Intrinsics.checkExpressionValueIsNotNull(initiativeTaskJsonStr, "initiativeTaskJsonStr");
                        aVar.a = b((TaskState) a2.a(initiativeTaskJsonStr));
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("passiveTaskQueue");
                    int i = 0;
                    if (optJSONArray != null) {
                        PriorityQueue<SubTaskState> a3 = tq.a(5);
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            SubTaskState b = b((TaskState) utVar.a(TaskState.key).a(optJSONArray.get(i2).toString()));
                            if (b != null) {
                                tq.b(a3, b, 5);
                            }
                        }
                        aVar.b = a3;
                    }
                    if (!aVar.s()) {
                        if (aVar.a != null) {
                            Pair<SubTaskState, String> n = n(aVar.a);
                            UBCRecoveryTaskInfo.a aVar2 = UBCRecoveryTaskInfo.Companion;
                            String second = n.getSecond();
                            SubTaskState first = n.getFirst();
                            if (first == null && (first = aVar.a) == null) {
                                Intrinsics.throwNpe();
                            }
                            uBCRecoveryTaskQueue.setActive(aVar2.a(second, first));
                            SubTaskState first2 = n.getFirst();
                            if (first2 != null) {
                                i(first2);
                            }
                        }
                        while (!aVar.b.isEmpty()) {
                            SubTaskState subTaskState = aVar.b.poll();
                            Pair<SubTaskState, String> n2 = n(subTaskState);
                            List<UBCRecoveryTaskInfo> passive = uBCRecoveryTaskQueue.getPassive();
                            UBCRecoveryTaskInfo.a aVar3 = UBCRecoveryTaskInfo.Companion;
                            String second2 = n2.getSecond();
                            SubTaskState first3 = n2.getFirst();
                            if (first3 != null) {
                                subTaskState = first3;
                            } else {
                                Intrinsics.checkExpressionValueIsNotNull(subTaskState, "subTaskState");
                            }
                            passive.add(aVar3.a(second2, subTaskState));
                            SubTaskState first4 = n2.getFirst();
                            if (first4 != null) {
                                i(first4);
                            }
                        }
                    }
                    zu.c.e(uBCRecoveryTaskQueue);
                    SubTaskState a4 = a();
                    if (a4 != null && a4.getTaskInfo().isPassiveTask()) {
                        Pair<Boolean, String> g = g(a4, false);
                        if (!g.getFirst().booleanValue()) {
                            a4.getTaskStatus().reset2Interrupted();
                            i = 500;
                        }
                        zu.c.f(UBCRegisterTaskInfo.Companion.b(a4.getTaskInfo(), a4.getTaskStatus(), g.getSecond(), i));
                    }
                    if (a4 != null && a4.getTaskInfo().isInitiActiveTask()) {
                        zu.c.f(UBCRegisterTaskInfo.a.c(UBCRegisterTaskInfo.Companion, a4.getTaskInfo(), a4.getTaskStatus(), null, 0, 12, null));
                    }
                    DebugTrace.a.c(new Function0<String>(this, str) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$deserializeFromJson$$inlined$withLock$lambda$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String $rawString$inlined;
                        public final /* synthetic */ a this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.$rawString$inlined = str;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            InterceptResult invokeV;
                            TaskInfo taskInfo;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("curRestoreActive:taskInfo: ");
                                SubTaskState a5 = this.this$0.a();
                                TaskStatus taskStatus = null;
                                if (a5 != null) {
                                    taskInfo = a5.getTaskInfo();
                                } else {
                                    taskInfo = null;
                                }
                                sb.append(taskInfo);
                                sb.append("\n taskStatus:");
                                SubTaskState a6 = this.this$0.a();
                                if (a6 != null) {
                                    taskStatus = a6.getTaskStatus();
                                }
                                sb.append(taskStatus);
                                return sb.toString();
                            }
                            return (String) invokeV.objValue;
                        }
                    });
                } catch (Exception e) {
                    DebugTrace.a.c(new Function0<String>(e) { // from class: com.baidu.bdtask.ctrl.model.TaskStateQueue$deserializeFromJson$2$4
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ Exception $e;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {e};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.$e = e;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return "deserializeFromJson error:" + this.$e.getMessage();
                            }
                            return (String) invokeV.objValue;
                        }
                    });
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                a.unlock();
            }
        }
    }
}
