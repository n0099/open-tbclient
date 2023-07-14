package com.baidu.bdtask.service.ubc.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.tieba.qw;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B3\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/baidu/bdtask/service/ubc/model/UBCRegisterTaskInfo;", "Lcom/baidu/bdtask/service/ubc/model/UBCTaskStatusInfo;", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "taskInfoStatus", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "", "type", "Ljava/lang/String;", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "", ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, "errorMsg", "<init>", "(Ljava/lang/String;Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;ILjava/lang/String;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class UBCRegisterTaskInfo extends UBCTaskStatusInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String TASK_REGISTER_COMMON_TYPE = "from_common";
    public static final String TASK_REGISTER_PASSIVE_TYPE = "from_passive";
    public static final String TASK_REGISTER_RECOVERY_TYPE = "from_recovery";
    public transient /* synthetic */ FieldHolder $fh;
    public final TaskStatus taskInfoStatus;
    public final String type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1976679262, "Lcom/baidu/bdtask/service/ubc/model/UBCRegisterTaskInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1976679262, "Lcom/baidu/bdtask/service/ubc/model/UBCRegisterTaskInfo;");
                return;
            }
        }
        Companion = new a(null);
    }

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

        public static /* bridge */ /* synthetic */ UBCRegisterTaskInfo c(a aVar, TaskInfo taskInfo, TaskStatus taskStatus, String str, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str = "";
            }
            if ((i2 & 8) != 0) {
                i = 0;
            }
            return aVar.b(taskInfo, taskStatus, str, i);
        }

        public static /* bridge */ /* synthetic */ UBCRegisterTaskInfo e(a aVar, TaskInfo taskInfo, TaskStatus taskStatus, String str, int i, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                i = 0;
            }
            return aVar.d(taskInfo, taskStatus, str, i);
        }

        public final UBCRegisterTaskInfo a(TaskInfo taskInfo, TaskStatus taskStatus) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, taskInfo, taskStatus)) == null) {
                return new UBCRegisterTaskInfo(UBCRegisterTaskInfo.TASK_REGISTER_COMMON_TYPE, taskInfo, taskStatus, 0, null, 24, null);
            }
            return (UBCRegisterTaskInfo) invokeLL.objValue;
        }

        public final UBCRegisterTaskInfo b(TaskInfo taskInfo, TaskStatus taskStatus, String str, int i) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, taskStatus, str, i)) == null) {
                return new UBCRegisterTaskInfo(UBCRegisterTaskInfo.TASK_REGISTER_RECOVERY_TYPE, taskInfo, taskStatus, i, str);
            }
            return (UBCRegisterTaskInfo) invokeLLLI.objValue;
        }

        public final UBCRegisterTaskInfo d(TaskInfo taskInfo, TaskStatus taskStatus, String str, int i) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, taskInfo, taskStatus, str, i)) == null) {
                return new UBCRegisterTaskInfo(UBCRegisterTaskInfo.TASK_REGISTER_PASSIVE_TYPE, taskInfo, taskStatus, i, str);
            }
            return (UBCRegisterTaskInfo) invokeLLLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UBCRegisterTaskInfo(String str, TaskInfo taskInfo, TaskStatus taskStatus, int i, String str2) {
        super(taskInfo, taskStatus, i, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, taskInfo, taskStatus, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TaskInfo) objArr2[0], (TaskStatus) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = str;
        this.taskInfoStatus = taskStatus;
    }

    public /* synthetic */ UBCRegisterTaskInfo(String str, TaskInfo taskInfo, TaskStatus taskStatus, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, taskInfo, taskStatus, (i2 & 8) != 0 ? taskStatus.getCurStatusCode() : i, (i2 & 16) != 0 ? taskStatus.getCurStatusCodeMsg() : str2);
    }

    @Override // com.baidu.bdtask.service.ubc.model.UBCTaskStatusInfo, com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject json = super.toJson();
            json.put("type", this.type);
            json.put("timestamp", qw.a.a());
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
