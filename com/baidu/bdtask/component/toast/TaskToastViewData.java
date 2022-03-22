package com.baidu.bdtask.component.toast;

import c.a.j.h.c.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.ui.toast.ToastViewData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/baidu/bdtask/component/toast/TaskToastViewData;", "Lcom/baidu/bdtask/framework/ui/toast/ToastViewData;", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/model/info/TaskInfo;", "getTaskInfo", "()Lcom/baidu/bdtask/model/info/TaskInfo;", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", TaskStatus.key, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "getTaskStatus", "()Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "", "showType", "", "backColor", TaskUIData.keyBgUrl, "message", "duration", TaskUIData.keyTxtColor, "backBtnColor", "backBtnTxt", "backBtnBgUrl", "backBtnTxtColor", "backBtnSchema", "Lcom/baidu/bdtask/framework/ui/toast/ToastLayoutParams;", "toastLayoutParams", "<init>", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/bdtask/framework/ui/toast/ToastLayoutParams;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class TaskToastViewData extends ToastViewData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TaskInfo taskInfo;
    public final TaskStatus taskStatus;

    public /* synthetic */ TaskToastViewData(TaskInfo taskInfo, TaskStatus taskStatus, int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, String str9, c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(taskInfo, taskStatus, i, str, str2, str3, i2, str4, str5, str6, str7, str8, str9, (i3 & 8192) != 0 ? null : cVar);
    }

    public final TaskInfo getTaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.taskInfo : (TaskInfo) invokeV.objValue;
    }

    public final TaskStatus getTaskStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.taskStatus : (TaskStatus) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskToastViewData(TaskInfo taskInfo, TaskStatus taskStatus, int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, String str9, c cVar) {
        super(taskInfo.getSingleKey(), i, str, str2, str3, i2, str4, str5, str6, str7, str8, str9, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {taskInfo, taskStatus, Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), str4, str5, str6, str7, str8, str9, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], ((Integer) objArr2[5]).intValue(), (String) objArr2[6], (String) objArr2[7], (String) objArr2[8], (String) objArr2[9], (String) objArr2[10], (String) objArr2[11], (c) objArr2[12]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.taskInfo = taskInfo;
        this.taskStatus = taskStatus;
    }
}
