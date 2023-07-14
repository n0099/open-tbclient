package com.baidu.bdtask.model.guide;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.ku;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010\bR\u0019\u0010\t\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010\u0005¨\u0006("}, d2 = {"Lcom/baidu/bdtask/model/guide/TaskGuideData;", "Lcom/baidu/bdtask/model/ITaskModelData;", "Lcom/baidu/tieba/ku;", "", "component1", "()I", "Lcom/baidu/bdtask/model/ui/TaskUIData;", "component2", "()Lcom/baidu/bdtask/model/ui/TaskUIData;", TaskResponseData.keyUiType, TaskUIData.key, CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(ILcom/baidu/bdtask/model/ui/TaskUIData;)Lcom/baidu/bdtask/model/guide/TaskGuideData;", "deepCopy", "()Lcom/baidu/bdtask/model/guide/TaskGuideData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "isEmpty", "()Z", "isLayer", "isModal", "isSilence", "isToast", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "", "toString", "()Ljava/lang/String;", "Lcom/baidu/bdtask/model/ui/TaskUIData;", "getUi", "I", "getUiType", "<init>", "(ILcom/baidu/bdtask/model/ui/TaskUIData;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class TaskGuideData implements ITaskModelData, ku {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String key = "guide";
    public transient /* synthetic */ FieldHolder $fh;
    public final TaskUIData ui;
    public final int uiType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1305523021, "Lcom/baidu/bdtask/model/guide/TaskGuideData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1305523021, "Lcom/baidu/bdtask/model/guide/TaskGuideData;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskGuideData() {
        this(0, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), (TaskUIData) objArr[1], ((Integer) objArr[2]).intValue(), (DefaultConstructorMarker) objArr[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ TaskGuideData copy$default(TaskGuideData taskGuideData, int i, TaskUIData taskUIData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = taskGuideData.uiType;
        }
        if ((i2 & 2) != 0) {
            taskUIData = taskGuideData.ui;
        }
        return taskGuideData.copy(i, taskUIData);
    }

    public final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.uiType : invokeV.intValue;
    }

    public final TaskUIData component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.ui : (TaskUIData) invokeV.objValue;
    }

    public final TaskGuideData copy(int i, TaskUIData taskUIData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, taskUIData)) == null) ? new TaskGuideData(i, taskUIData) : (TaskGuideData) invokeIL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof TaskGuideData) {
                    TaskGuideData taskGuideData = (TaskGuideData) obj;
                    if (!(this.uiType == taskGuideData.uiType) || !Intrinsics.areEqual(this.ui, taskGuideData.ui)) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.uiType * 31;
            TaskUIData taskUIData = this.ui;
            return i + (taskUIData != null ? taskUIData.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public final boolean b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == 2 : invokeI.booleanValue;
        }

        public final boolean c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i == 4 : invokeI.booleanValue;
        }

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

        public final boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (!b(i) && !c(i)) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    public TaskGuideData(int i, TaskUIData taskUIData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), taskUIData};
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
        this.ui = taskUIData;
    }

    public /* synthetic */ TaskGuideData(int i, TaskUIData taskUIData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i3;
        TaskGuideData taskGuideData;
        TaskUIData taskUIData2;
        if ((i2 & 1) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            taskUIData2 = new TaskUIData(null, null, 0, null, null, null, null, null, null, 0, null, null, 4095, null);
            taskGuideData = this;
        } else {
            taskGuideData = this;
            taskUIData2 = taskUIData;
        }
        new TaskGuideData(i3, taskUIData2);
    }

    public final TaskUIData getUi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.ui;
        }
        return (TaskUIData) invokeV.objValue;
    }

    public final int getUiType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.uiType;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.uiType != -1 && !this.ui.isEmpty() && !isSilence()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return Companion.a(this.uiType);
        }
        return invokeV.booleanValue;
    }

    public boolean isModal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.uiType == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSilence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.uiType == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.uiType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TaskResponseData.keyUiType, this.uiType);
            jSONObject.put(TaskUIData.key, this.ui.toJson());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String jSONObject = toJson().toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJson().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public TaskGuideData deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new TaskGuideData(this.uiType, this.ui.deepCopy());
        }
        return (TaskGuideData) invokeV.objValue;
    }
}
