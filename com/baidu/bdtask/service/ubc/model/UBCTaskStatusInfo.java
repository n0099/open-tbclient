package com.baidu.bdtask.service.ubc.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/baidu/bdtask/service/ubc/model/UBCTaskStatusInfo;", "Lcom/baidu/bdtask/model/ITaskModelData;", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "", "errorMsg", "Ljava/lang/String;", "", ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, "I", TaskStatus.keyInterruptErrorNo, HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/model/info/TaskInfo;", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "taskInfoStatus", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "<init>", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;ILjava/lang/String;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public class UBCTaskStatusInfo implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String errorMsg;
    public final int errorNo;
    public final int interruptErrorNo;
    public final int statusCode;
    public final TaskInfo taskInfo;
    public final TaskStatus taskInfoStatus;

    public UBCTaskStatusInfo(TaskInfo taskInfo, TaskStatus taskStatus, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo, taskStatus, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.taskInfo = taskInfo;
        this.taskInfoStatus = taskStatus;
        this.errorNo = i;
        this.errorMsg = str;
        this.statusCode = taskStatus.getCurStatus();
        this.interruptErrorNo = this.taskInfoStatus.getInterruptErrorNo();
    }

    public /* synthetic */ UBCTaskStatusInfo(TaskInfo taskInfo, TaskStatus taskStatus, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(taskInfo, taskStatus, (i2 & 4) != 0 ? taskStatus.getCurStatusCode() : i, (i2 & 8) != 0 ? taskStatus.getCurStatusCodeMsg() : str);
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public ITaskModelData deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ITaskModelData.a.b(this);
            return this;
        }
        return (ITaskModelData) invokeV.objValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ITaskModelData.a.a(this);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, this.statusCode);
            jSONObject.put(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, this.errorNo);
            jSONObject.put("msg", this.errorMsg);
            jSONObject.put(NextActive.keyTaskInfo, new UBCTaskInfo(this.taskInfo, this.taskInfoStatus).toJson());
            int i = this.interruptErrorNo;
            if (i != 0) {
                jSONObject.put(TaskStatus.keyInterruptErrorNo, i);
            }
            if (this.taskInfoStatus.isFinished()) {
                jSONObject.put("progress", this.taskInfo.getResponse().getProcessData().toJson());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
