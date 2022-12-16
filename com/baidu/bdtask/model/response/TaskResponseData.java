package com.baidu.bdtask.model.response;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/B/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\rR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b*\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010\u0004¨\u00060"}, d2 = {"Lcom/baidu/bdtask/model/response/TaskResponseData;", "Lcom/baidu/bdtask/model/ITaskModelData;", "", "component1", "()I", "Lcom/baidu/bdtask/model/response/TaskProcessData;", "component2", "()Lcom/baidu/bdtask/model/response/TaskProcessData;", "Lcom/baidu/bdtask/model/ui/TaskUIData;", "component3", "()Lcom/baidu/bdtask/model/ui/TaskUIData;", "Lcom/baidu/bdtask/model/response/NextActive;", "component4", "()Lcom/baidu/bdtask/model/response/NextActive;", TaskResponseData.keyUiType, "processData", TaskUIData.key, TaskResponseData.keyNextActive, "copy", "(ILcom/baidu/bdtask/model/response/TaskProcessData;Lcom/baidu/bdtask/model/ui/TaskUIData;Lcom/baidu/bdtask/model/response/NextActive;)Lcom/baidu/bdtask/model/response/TaskResponseData;", "deepCopy", "()Lcom/baidu/bdtask/model/response/TaskResponseData;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "isEmpty", "()Z", "isLayer", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "", "toString", "()Ljava/lang/String;", "Lcom/baidu/bdtask/model/response/NextActive;", "getNextActive", "Lcom/baidu/bdtask/model/response/TaskProcessData;", "getProcessData", "Lcom/baidu/bdtask/model/ui/TaskUIData;", "getUi", "I", "getUiType", "<init>", "(ILcom/baidu/bdtask/model/response/TaskProcessData;Lcom/baidu/bdtask/model/ui/TaskUIData;Lcom/baidu/bdtask/model/response/NextActive;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TaskResponseData implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int ERROR_NO_TASK_OFFLINE_01 = 11002;
    public static final int ERROR_NO_TASK_OFFLINE_02 = 13002;
    public static final int ERROR_NO_TASK_OFFLINE_03 = 12002;
    public static final int ERROR_NO_TASK_OFFLINE_04 = 19004;
    public static final String key = "response";
    public static final String keyNextActive = "nextActive";
    public static final String keyUiType = "uiType";
    public transient /* synthetic */ FieldHolder $fh;
    public final NextActive nextActive;
    public final TaskProcessData processData;
    public final TaskUIData ui;
    public final int uiType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1609883197, "Lcom/baidu/bdtask/model/response/TaskResponseData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1609883197, "Lcom/baidu/bdtask/model/response/TaskResponseData;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskResponseData() {
        this(0, null, null, null, 15, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), (TaskProcessData) objArr[1], (TaskUIData) objArr[2], (NextActive) objArr[3], ((Integer) objArr[4]).intValue(), (DefaultConstructorMarker) objArr[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ TaskResponseData copy$default(TaskResponseData taskResponseData, int i, TaskProcessData taskProcessData, TaskUIData taskUIData, NextActive nextActive, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = taskResponseData.uiType;
        }
        if ((i2 & 2) != 0) {
            taskProcessData = taskResponseData.processData;
        }
        if ((i2 & 4) != 0) {
            taskUIData = taskResponseData.ui;
        }
        if ((i2 & 8) != 0) {
            nextActive = taskResponseData.nextActive;
        }
        return taskResponseData.copy(i, taskProcessData, taskUIData, nextActive);
    }

    public final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.uiType : invokeV.intValue;
    }

    public final TaskProcessData component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.processData : (TaskProcessData) invokeV.objValue;
    }

    public final TaskUIData component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ui : (TaskUIData) invokeV.objValue;
    }

    public final NextActive component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.nextActive : (NextActive) invokeV.objValue;
    }

    public final TaskResponseData copy(int i, TaskProcessData taskProcessData, TaskUIData taskUIData, NextActive nextActive) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), taskProcessData, taskUIData, nextActive})) == null) ? new TaskResponseData(i, taskProcessData, taskUIData, nextActive) : (TaskResponseData) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof TaskResponseData) {
                    TaskResponseData taskResponseData = (TaskResponseData) obj;
                    if (!(this.uiType == taskResponseData.uiType) || !Intrinsics.areEqual(this.processData, taskResponseData.processData) || !Intrinsics.areEqual(this.ui, taskResponseData.ui) || !Intrinsics.areEqual(this.nextActive, taskResponseData.nextActive)) {
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.uiType * 31;
            TaskProcessData taskProcessData = this.processData;
            int hashCode = (i + (taskProcessData != null ? taskProcessData.hashCode() : 0)) * 31;
            TaskUIData taskUIData = this.ui;
            int hashCode2 = (hashCode + (taskUIData != null ? taskUIData.hashCode() : 0)) * 31;
            NextActive nextActive = this.nextActive;
            return hashCode2 + (nextActive != null ? nextActive.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "TaskResponseData(uiType=" + this.uiType + ", processData=" + this.processData + ", ui=" + this.ui + ", nextActive=" + this.nextActive + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes.dex */
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

    public TaskResponseData(int i, TaskProcessData taskProcessData, TaskUIData taskUIData, NextActive nextActive) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), taskProcessData, taskUIData, nextActive};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.uiType = i;
        this.processData = taskProcessData;
        this.ui = taskUIData;
        this.nextActive = nextActive;
    }

    public /* synthetic */ TaskResponseData(int i, TaskProcessData taskProcessData, TaskUIData taskUIData, NextActive nextActive, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i3;
        TaskProcessData taskProcessData2;
        TaskUIData taskUIData2;
        TaskResponseData taskResponseData;
        NextActive nextActive2;
        if ((i2 & 1) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            taskProcessData2 = new TaskProcessData(0, 0, false, 7, null);
        } else {
            taskProcessData2 = taskProcessData;
        }
        if ((i2 & 4) != 0) {
            taskUIData2 = new TaskUIData(null, null, 0, null, null, null, null, null, null, 0, null, null, 4095, null);
        } else {
            taskUIData2 = taskUIData;
        }
        if ((i2 & 8) != 0) {
            nextActive2 = new NextActive(0L, null, 3, null);
            taskResponseData = this;
        } else {
            taskResponseData = this;
            nextActive2 = nextActive;
        }
        new TaskResponseData(i3, taskProcessData2, taskUIData2, nextActive2);
    }

    public final NextActive getNextActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.nextActive;
        }
        return (NextActive) invokeV.objValue;
    }

    public final TaskProcessData getProcessData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.processData;
        }
        return (TaskProcessData) invokeV.objValue;
    }

    public final TaskUIData getUi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.ui;
        }
        return (TaskUIData) invokeV.objValue;
    }

    public final int getUiType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.uiType;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.uiType != -1 && !this.ui.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean isLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i = this.uiType;
            if (i != 2 && i != 4) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public TaskResponseData deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new TaskResponseData(this.uiType, this.processData.deepCopy(), this.ui.deepCopy(), this.nextActive.deepCopy());
        }
        return (TaskResponseData) invokeV.objValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(keyUiType, this.uiType);
            jSONObject.put("progress", this.processData.toJson());
            jSONObject.put(TaskUIData.key, this.ui.toJson());
            jSONObject.put(keyNextActive, this.nextActive.toJson());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
