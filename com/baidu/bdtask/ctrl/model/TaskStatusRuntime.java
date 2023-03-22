package com.baidu.bdtask.ctrl.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.uq;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u0001;BE\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJN\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b&\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010*R\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010.R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u0010\u0004\"\u0004\b1\u00102R\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010+\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010.R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010/\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u00102R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010/\u001a\u0004\b7\u0010\u0004\"\u0004\b8\u00102¨\u0006<"}, d2 = {"Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;", "Lcom/baidu/bdtask/model/ITaskModelData;", "", "component1", "()Z", "component2", "component3", "", "component4", "()Ljava/lang/String;", "component5", "Lcom/baidu/bdtask/framework/redux/Action;", "component6", "()Lcom/baidu/bdtask/framework/redux/Action;", "hasFailed", "duplicated", "responseDataIsCache", "curDuplicateId", "extraUnRegisterMsg", "curAction", "copy", "(ZZZLjava/lang/String;Ljava/lang/String;Lcom/baidu/bdtask/framework/redux/Action;)Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;", "deepCopy", "()Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;", "", ImageViewerConfig.FROM_OTHER, "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "status", "", "onStatusChanged", "(I)V", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "toString", "Lcom/baidu/bdtask/framework/redux/Action;", "getCurAction", "setCurAction", "(Lcom/baidu/bdtask/framework/redux/Action;)V", "Ljava/lang/String;", "getCurDuplicateId", "setCurDuplicateId", "(Ljava/lang/String;)V", "Z", "getDuplicated", "setDuplicated", "(Z)V", "getExtraUnRegisterMsg", "setExtraUnRegisterMsg", "getHasFailed", "setHasFailed", "getResponseDataIsCache", "setResponseDataIsCache", "<init>", "(ZZZLjava/lang/String;Ljava/lang/String;Lcom/baidu/bdtask/framework/redux/Action;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TaskStatusRuntime implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic;
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public uq curAction;
    public String curDuplicateId;
    public boolean duplicated;
    public String extraUnRegisterMsg;
    public boolean hasFailed;
    public boolean responseDataIsCache;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2090280182, "Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2090280182, "Lcom/baidu/bdtask/ctrl/model/TaskStatusRuntime;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskStatusRuntime() {
        this(false, false, false, null, null, null, 63, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], (String) objArr[4], (uq) objArr[5], ((Integer) objArr[6]).intValue(), (DefaultConstructorMarker) objArr[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ TaskStatusRuntime copy$default(TaskStatusRuntime taskStatusRuntime, boolean z, boolean z2, boolean z3, String str, String str2, uq uqVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z = taskStatusRuntime.hasFailed;
        }
        if ((i & 2) != 0) {
            z2 = taskStatusRuntime.duplicated;
        }
        boolean z4 = z2;
        if ((i & 4) != 0) {
            z3 = taskStatusRuntime.responseDataIsCache;
        }
        boolean z5 = z3;
        if ((i & 8) != 0) {
            str = taskStatusRuntime.curDuplicateId;
        }
        String str3 = str;
        if ((i & 16) != 0) {
            str2 = taskStatusRuntime.extraUnRegisterMsg;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            uqVar = taskStatusRuntime.curAction;
        }
        return taskStatusRuntime.copy(z, z4, z5, str3, str4, uqVar);
    }

    public final boolean component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.hasFailed : invokeV.booleanValue;
    }

    public final boolean component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.duplicated : invokeV.booleanValue;
    }

    public final boolean component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.responseDataIsCache : invokeV.booleanValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.curDuplicateId : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.extraUnRegisterMsg : (String) invokeV.objValue;
    }

    public final uq component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.curAction : (uq) invokeV.objValue;
    }

    public final TaskStatusRuntime copy(boolean z, boolean z2, boolean z3, String str, String str2, uq uqVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str, str2, uqVar})) == null) ? new TaskStatusRuntime(z, z2, z3, str, str2, uqVar) : (TaskStatusRuntime) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof TaskStatusRuntime) {
                    TaskStatusRuntime taskStatusRuntime = (TaskStatusRuntime) obj;
                    if (this.hasFailed == taskStatusRuntime.hasFailed) {
                        if (this.duplicated == taskStatusRuntime.duplicated) {
                            if (!(this.responseDataIsCache == taskStatusRuntime.responseDataIsCache) || !Intrinsics.areEqual(this.curDuplicateId, taskStatusRuntime.curDuplicateId) || !Intrinsics.areEqual(this.extraUnRegisterMsg, taskStatusRuntime.extraUnRegisterMsg) || !Intrinsics.areEqual(this.curAction, taskStatusRuntime.curAction)) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            boolean z = this.hasFailed;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.duplicated;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z2 = this.responseDataIsCache;
            int i4 = (i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
            String str = this.curDuplicateId;
            int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.extraUnRegisterMsg;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            uq uqVar = this.curAction;
            return hashCode2 + (uqVar != null ? uqVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return "TaskStatusRuntime(hasFailed=" + this.hasFailed + ", duplicated=" + this.duplicated + ", responseDataIsCache=" + this.responseDataIsCache + ", curDuplicateId=" + this.curDuplicateId + ", extraUnRegisterMsg=" + this.extraUnRegisterMsg + ", curAction=" + this.curAction + SmallTailInfo.EMOTION_SUFFIX;
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

        public final TaskStatusRuntime a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new TaskStatusRuntime(false, false, false, null, null, null, 63, null);
            }
            return (TaskStatusRuntime) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TaskStatusRuntime(boolean z, boolean z2, boolean z3, String str, String str2, uq uqVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str, str2, uqVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.hasFailed = z;
        this.duplicated = z2;
        this.responseDataIsCache = z3;
        this.curDuplicateId = str;
        this.extraUnRegisterMsg = str2;
        this.curAction = uqVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TaskStatusRuntime(boolean z, boolean z2, boolean z3, String str, String str2, uq uqVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r12, r1, r0, r2, r3, (i & 32) != 0 ? null : uqVar);
        boolean z4;
        boolean z5;
        String str3;
        String str4;
        if ((i & 1) != 0) {
            z4 = false;
        } else {
            z4 = z;
        }
        if ((i & 2) != 0) {
            z5 = false;
        } else {
            z5 = z2;
        }
        boolean z6 = (i & 4) == 0 ? z3 : false;
        if ((i & 8) != 0) {
            str3 = "";
        } else {
            str3 = str;
        }
        if ((i & 16) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.bdtask.model.ITaskModelData
    public TaskStatusRuntime deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new TaskStatusRuntime(this.hasFailed, this.duplicated, this.responseDataIsCache, this.curDuplicateId, this.extraUnRegisterMsg, this.curAction);
        }
        return (TaskStatusRuntime) invokeV.objValue;
    }

    public final uq getCurAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.curAction;
        }
        return (uq) invokeV.objValue;
    }

    public final String getCurDuplicateId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.curDuplicateId;
        }
        return (String) invokeV.objValue;
    }

    public final boolean getDuplicated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.duplicated;
        }
        return invokeV.booleanValue;
    }

    public final String getExtraUnRegisterMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.extraUnRegisterMsg;
        }
        return (String) invokeV.objValue;
    }

    public final boolean getHasFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.hasFailed;
        }
        return invokeV.booleanValue;
    }

    public final boolean getResponseDataIsCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.responseDataIsCache;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return ITaskModelData.a.a(this);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void onStatusChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.duplicated = false;
        }
    }

    public final void setCurAction(uq uqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, uqVar) == null) {
            this.curAction = uqVar;
        }
    }

    public final void setCurDuplicateId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.curDuplicateId = str;
        }
    }

    public final void setDuplicated(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.duplicated = z;
        }
    }

    public final void setExtraUnRegisterMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.extraUnRegisterMsg = str;
        }
    }

    public final void setHasFailed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.hasFailed = z;
        }
    }

    public final void setResponseDataIsCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.responseDataIsCache = z;
        }
    }
}
