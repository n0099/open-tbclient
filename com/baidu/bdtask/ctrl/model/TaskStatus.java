package com.baidu.bdtask.ctrl.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u0000 [2\u00020\u0001:\u0001[BK\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u0016¢\u0006\u0004\bY\u0010ZJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÂ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JV\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\"\u0010#J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020&¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b+\u0010\nJ\r\u0010,\u001a\u00020&¢\u0006\u0004\b,\u0010*J\u000f\u0010-\u001a\u00020&H\u0007¢\u0006\u0004\b-\u0010*J\r\u0010.\u001a\u00020&¢\u0006\u0004\b.\u0010*J\r\u0010/\u001a\u00020&¢\u0006\u0004\b/\u0010*J\r\u00100\u001a\u00020&¢\u0006\u0004\b0\u0010*J\r\u00101\u001a\u00020&¢\u0006\u0004\b1\u0010*J\r\u00102\u001a\u00020&¢\u0006\u0004\b2\u0010*J\r\u00103\u001a\u00020&¢\u0006\u0004\b3\u0010*J\r\u00104\u001a\u00020&¢\u0006\u0004\b4\u0010*J\r\u00105\u001a\u00020&¢\u0006\u0004\b5\u0010*J\r\u00106\u001a\u00020&¢\u0006\u0004\b6\u0010*J\r\u00107\u001a\u00020&¢\u0006\u0004\b7\u0010*J\r\u00108\u001a\u00020\u0002¢\u0006\u0004\b8\u0010\u0004J\u0017\u00109\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020&¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0002¢\u0006\u0004\b;\u0010\u0004J\r\u0010<\u001a\u00020\u0002¢\u0006\u0004\b<\u0010\u0004J\r\u0010=\u001a\u00020&¢\u0006\u0004\b=\u0010*J\u0017\u0010?\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\bH\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\fH\u0016¢\u0006\u0004\bD\u0010\u000eR\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010ER\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010F\u001a\u0004\bG\u0010\u0012\"\u0004\bH\u0010IR*\u0010J\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010@R\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010E\u001a\u0004\bM\u0010\n\"\u0004\bN\u0010@R\"\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010O\u001a\u0004\bP\u0010\u000e\"\u0004\bQ\u0010RR\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010E\u001a\u0004\bS\u0010\n\"\u0004\bT\u0010@R\u0019\u0010\u001f\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010U\u001a\u0004\bV\u0010\u0018R\u0019\u0010\u001e\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010W\u001a\u0004\bX\u0010\u0015¨\u0006\\"}, d2 = {"Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "Lcom/baidu/bdtask/model/ITaskModelData;", "", "cleanDuplicateId", "()V", "cleanNoClickTime", "clear", "clearProcess", "", "component1", "()I", "component2", "", "component3", "()Ljava/lang/String;", "component4", "", "component5", "()J", "Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;", "component6", "()Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;", "Lcom/baidu/bdtask/ctrl/model/TaskProcess;", "component7", "()Lcom/baidu/bdtask/ctrl/model/TaskProcess;", "_curStatus", TaskStatus.keyCurStatusCode, TaskStatus.keyCurStatusCodeMsg, TaskStatus.keyInterruptErrorNo, TaskStatus.keyCurActiveTime, "taskStatusRuntime", "process", "copy", "(IILjava/lang/String;IJLcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;Lcom/baidu/bdtask/ctrl/model/TaskProcess;)Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "deepCopy", "()Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hasErrorCode", "()Z", TTDownloadField.TT_HASHCODE, "isActivated", "isCompleted", "isDuplicated", "isEnable", "isFinished", "isInited", "isInterrupted", "isLocalCompleted", "isOffLined", "isRegistered", "isRunning", "isUnRegistered", "reset2Interrupted", "reset2Running", "(Z)V", "reset2RunningStatus", "resetStatus", "responseDataIsCache", "value", "statusUpdate", "(I)V", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "toString", "I", "J", "getCurActiveTime", "setCurActiveTime", "(J)V", TaskStatus.keyCurStatus, "getCurStatus", "setCurStatus", "getCurStatusCode", "setCurStatusCode", "Ljava/lang/String;", "getCurStatusCodeMsg", "setCurStatusCodeMsg", "(Ljava/lang/String;)V", "getInterruptErrorNo", "setInterruptErrorNo", "Lcom/baidu/bdtask/ctrl/model/TaskProcess;", "getProcess", "Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;", "getTaskStatusRuntime", "<init>", "(IILjava/lang/String;IJLcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;Lcom/baidu/bdtask/ctrl/model/TaskProcess;)V", "INS", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class TaskStatus implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_ACTION_TYPE_CLICK = 6;
    public static final int CODE_ACTION_TYPE_VISIT = 7;
    public static final int CODE_ERROR_DEFAULT = -1;
    public static final a INS;
    public static final int STATUS_TASK_ERROR_NORMAL_CODE = 0;
    public static final int STATUS_TASK_INFO_FINISHED = 22;
    public static final int STATUS_TASK_INFO_INIT = 1;
    public static final int STATUS_TASK_INFO_INTERRUPTED = 50;
    public static final int STATUS_TASK_INFO_REGISTER = 2;
    public static final int STATUS_TASK_INFO_RUNNING = 8;
    public static final int STATUS_TASK_INFO_UNREGISTER = 4;
    public static final String key = "taskStatus";
    public static final String keyCurActiveTime = "curActiveTime";
    public static final String keyCurStatus = "curStatus";
    public static final String keyCurStatusCode = "curStatusCode";
    public static final String keyCurStatusCodeMsg = "curStatusCodeMsg";
    public static final String keyInterruptErrorNo = "interruptErrorNo";
    public static final String keyProcess = "process";
    public transient /* synthetic */ FieldHolder $fh;
    public int _curStatus;
    public long curActiveTime;
    public int curStatus;
    public int curStatusCode;
    public String curStatusCodeMsg;
    public int interruptErrorNo;
    public final TaskProcess process;
    public final TaskStatusRuntime taskStatusRuntime;

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-274297196, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-274297196, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;");
                return;
            }
        }
        INS = new a(null);
    }

    public TaskStatus(int i, int i2, String str, int i3, long j, TaskStatusRuntime taskStatusRuntime, TaskProcess taskProcess) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Long.valueOf(j), taskStatusRuntime, taskProcess};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this._curStatus = i;
        this.curStatusCode = i2;
        this.curStatusCodeMsg = str;
        this.interruptErrorNo = i3;
        this.curActiveTime = j;
        this.taskStatusRuntime = taskStatusRuntime;
        this.process = taskProcess;
        this.curStatus = i;
    }

    private final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this._curStatus : invokeV.intValue;
    }

    public static /* synthetic */ void reset2Running$default(TaskStatus taskStatus, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        taskStatus.reset2Running(z);
    }

    private final void statusUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            if (i == 2 || i == 8) {
                this.curActiveTime = System.currentTimeMillis();
            }
            this.taskStatusRuntime.onStatusChanged(i);
        }
    }

    public final void cleanDuplicateId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.process.cleanDuplicateId();
        }
    }

    public final void cleanNoClickTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.process.cleanNoClickTimes();
        }
    }

    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            clearProcess();
            cleanDuplicateId();
            cleanNoClickTime();
            resetStatus();
        }
    }

    public final void clearProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.process.clearClickNumber();
            this.process.clearStayTime();
            this.process.clearTags();
        }
    }

    public final int component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.curStatusCode : invokeV.intValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.curStatusCodeMsg : (String) invokeV.objValue;
    }

    public final int component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.interruptErrorNo : invokeV.intValue;
    }

    public final long component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.curActiveTime : invokeV.longValue;
    }

    public final TaskStatusRuntime component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.taskStatusRuntime : (TaskStatusRuntime) invokeV.objValue;
    }

    public final TaskProcess component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.process : (TaskProcess) invokeV.objValue;
    }

    public final TaskStatus copy(int i, int i2, String str, int i3, long j, TaskStatusRuntime taskStatusRuntime, TaskProcess taskProcess) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Long.valueOf(j), taskStatusRuntime, taskProcess})) == null) ? new TaskStatus(i, i2, str, i3, j, taskStatusRuntime, taskProcess) : (TaskStatus) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof TaskStatus) {
                    TaskStatus taskStatus = (TaskStatus) obj;
                    if (this._curStatus == taskStatus._curStatus) {
                        if ((this.curStatusCode == taskStatus.curStatusCode) && Intrinsics.areEqual(this.curStatusCodeMsg, taskStatus.curStatusCodeMsg)) {
                            if (this.interruptErrorNo == taskStatus.interruptErrorNo) {
                                if (!(this.curActiveTime == taskStatus.curActiveTime) || !Intrinsics.areEqual(this.taskStatusRuntime, taskStatus.taskStatusRuntime) || !Intrinsics.areEqual(this.process, taskStatus.process)) {
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final long getCurActiveTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.curActiveTime : invokeV.longValue;
    }

    public final int getCurStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.curStatus : invokeV.intValue;
    }

    public final int getCurStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.curStatusCode : invokeV.intValue;
    }

    public final String getCurStatusCodeMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.curStatusCodeMsg : (String) invokeV.objValue;
    }

    public final int getInterruptErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.interruptErrorNo : invokeV.intValue;
    }

    public final TaskProcess getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.process : (TaskProcess) invokeV.objValue;
    }

    public final TaskStatusRuntime getTaskStatusRuntime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.taskStatusRuntime : (TaskStatusRuntime) invokeV.objValue;
    }

    public final boolean hasErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.curStatusCode != 0 : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i = ((this._curStatus * 31) + this.curStatusCode) * 31;
            String str = this.curStatusCodeMsg;
            int hashCode = str != null ? str.hashCode() : 0;
            long j = this.curActiveTime;
            int i2 = (((((i + hashCode) * 31) + this.interruptErrorNo) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            TaskStatusRuntime taskStatusRuntime = this.taskStatusRuntime;
            int hashCode2 = (i2 + (taskStatusRuntime != null ? taskStatusRuntime.hashCode() : 0)) * 31;
            TaskProcess taskProcess = this.process;
            return hashCode2 + (taskProcess != null ? taskProcess.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public final boolean isActivated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? !isInterrupted() : invokeV.booleanValue;
    }

    @Deprecated(message = "replaced by isLocalCompleted", replaceWith = @ReplaceWith(expression = "status.isCompleted()", imports = {}))
    public final boolean isCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.process.isCompleted() : invokeV.booleanValue;
    }

    public final boolean isDuplicated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.taskStatusRuntime.getDuplicated() : invokeV.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? ITaskModelData.a.a(this) : invokeV.booleanValue;
    }

    public final boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? isActivated() && !isUnRegistered() : invokeV.booleanValue;
    }

    public final boolean isFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.curStatus == 22 : invokeV.booleanValue;
    }

    public final boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.curStatus == 1 : invokeV.booleanValue;
    }

    public final boolean isInterrupted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.curStatus == 50 : invokeV.booleanValue;
    }

    public final boolean isLocalCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? isCompleted() : invokeV.booleanValue;
    }

    public final boolean isOffLined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            int i = this.curStatusCode;
            return i == 11002 || i == 13002 || i == 12002 || i == 19004;
        }
        return invokeV.booleanValue;
    }

    public final boolean isRegistered() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.curStatus == 2 : invokeV.booleanValue;
    }

    public final boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.curStatus == 8 : invokeV.booleanValue;
    }

    public final boolean isUnRegistered() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.curStatus == 4 : invokeV.booleanValue;
    }

    public final void reset2Interrupted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            setCurStatus(50);
        }
    }

    public final void reset2Running(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            resetStatus();
            clearProcess();
            if (z) {
                cleanDuplicateId();
            }
            setCurStatus(8);
        }
    }

    public final void reset2RunningStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            resetStatus();
            setCurStatus(8);
        }
    }

    public final void resetStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            setCurStatus(1);
            this.curStatusCode = 0;
            this.curStatusCodeMsg = "";
        }
    }

    public final boolean responseDataIsCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.taskStatusRuntime.getResponseDataIsCache() : invokeV.booleanValue;
    }

    public final void setCurActiveTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048617, this, j) == null) {
            this.curActiveTime = j;
        }
    }

    public final void setCurStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.curStatus = i;
            statusUpdate(i);
        }
    }

    public final void setCurStatusCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.curStatusCode = i;
        }
    }

    public final void setCurStatusCodeMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.curStatusCodeMsg = str;
        }
    }

    public final void setInterruptErrorNo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.interruptErrorNo = i;
        }
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(keyCurStatus, this.curStatus);
            jSONObject.put(keyCurStatusCode, this.curStatusCode);
            jSONObject.put(keyCurStatusCodeMsg, this.curStatusCodeMsg);
            jSONObject.put(keyInterruptErrorNo, this.interruptErrorNo);
            jSONObject.put(keyCurActiveTime, this.curActiveTime);
            jSONObject.put("process", this.process.toJson());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            String jSONObject = toJson().toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJson().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.bdtask.model.ITaskModelData
    public TaskStatus deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new TaskStatus(this.curStatus, this.curStatusCode, this.curStatusCodeMsg, this.interruptErrorNo, this.curActiveTime, this.taskStatusRuntime.deepCopy(), this.process.deepCopy()) : (TaskStatus) invokeV.objValue;
    }

    public /* synthetic */ TaskStatus(int i, int i2, String str, int i3, long j, TaskStatusRuntime taskStatusRuntime, TaskProcess taskProcess, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 1 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? System.currentTimeMillis() : j, (i4 & 32) != 0 ? TaskStatusRuntime.Companion.a() : taskStatusRuntime, taskProcess);
    }
}
