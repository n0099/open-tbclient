package com.baidu.bdtask.model.info;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.guide.TaskGuideData;
import com.baidu.bdtask.model.meter.TaskMeterData;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.rule.TaskRuleData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u0000 R2\u00020\u0001:\u0001RBu\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0013\u0012\b\b\u0002\u0010!\u001a\u00020\u0016\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J~\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u00162\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0000H\u0016¢\u0006\u0004\b&\u0010'J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(H\u0096\u0002¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0002¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010\u000eJ\r\u0010/\u001a\u00020*¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020*¢\u0006\u0004\b1\u00100J\u000f\u00102\u001a\u00020*H\u0016¢\u0006\u0004\b2\u00100J\r\u00103\u001a\u00020*¢\u0006\u0004\b3\u00100J\r\u00104\u001a\u00020*¢\u0006\u0004\b4\u00100J\r\u00105\u001a\u00020*¢\u0006\u0004\b5\u00100J\r\u00106\u001a\u00020*¢\u0006\u0004\b6\u00100J\r\u00107\u001a\u00020*¢\u0006\u0004\b7\u00100J\r\u00108\u001a\u00020*¢\u0006\u0004\b8\u00100J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0002H\u0016¢\u0006\u0004\b<\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010=\u001a\u0004\b>\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010=\u001a\u0004\b?\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010@\u001a\u0004\bA\u0010\u000eR\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010=\u001a\u0004\bB\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010=\u001a\u0004\bC\u0010\u0004R\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010D\u001a\u0004\bE\u0010\n\"\u0004\bF\u0010GR\u0019\u0010!\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010H\u001a\u0004\bI\u0010\u0018R\u0019\u0010\"\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010J\u001a\u0004\bK\u0010\u0007R\u0019\u0010 \u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b \u0010L\u001a\u0004\bM\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010=\u001a\u0004\bN\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010@\u001a\u0004\bO\u0010\u000e¨\u0006S"}, d2 = {"Lcom/baidu/bdtask/model/info/TaskInfo;", "Lcom/baidu/bdtask/model/ITaskModelData;", "", "component1", "()Ljava/lang/String;", "Lcom/baidu/bdtask/model/meter/TaskMeterData;", "component10", "()Lcom/baidu/bdtask/model/meter/TaskMeterData;", "Lcom/baidu/bdtask/model/response/TaskResponseData;", "component11", "()Lcom/baidu/bdtask/model/response/TaskResponseData;", "component2", "", "component3", "()I", "component4", "component5", "component6", "component7", "Lcom/baidu/bdtask/model/rule/TaskRuleData;", "component8", "()Lcom/baidu/bdtask/model/rule/TaskRuleData;", "Lcom/baidu/bdtask/model/guide/TaskGuideData;", "component9", "()Lcom/baidu/bdtask/model/guide/TaskGuideData;", "id", "actionId", "type", "token", "behavior", TaskInfo.keyActTaskId, TaskInfo.keyFingerprint, "taskRule", "taskGuide", "taskMeter", "response", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/baidu/bdtask/model/rule/TaskRuleData;Lcom/baidu/bdtask/model/guide/TaskGuideData;Lcom/baidu/bdtask/model/meter/TaskMeterData;Lcom/baidu/bdtask/model/response/TaskResponseData;)Lcom/baidu/bdtask/model/info/TaskInfo;", "deepCopy", "()Lcom/baidu/bdtask/model/info/TaskInfo;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getSingleKey", TTDownloadField.TT_HASHCODE, "isClickAction", "()Z", "isDone", "isEmpty", "isEnableActivated", "isForceCleaned", "isInitiActiveTask", "isPassiveTask", "isValid", "isVisitAction", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "toString", "Ljava/lang/String;", "getActTaskId", "getActionId", "I", "getBehavior", "getFingerprint", "getId", "Lcom/baidu/bdtask/model/response/TaskResponseData;", "getResponse", "setResponse", "(Lcom/baidu/bdtask/model/response/TaskResponseData;)V", "Lcom/baidu/bdtask/model/guide/TaskGuideData;", "getTaskGuide", "Lcom/baidu/bdtask/model/meter/TaskMeterData;", "getTaskMeter", "Lcom/baidu/bdtask/model/rule/TaskRuleData;", "getTaskRule", "getToken", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/baidu/bdtask/model/rule/TaskRuleData;Lcom/baidu/bdtask/model/guide/TaskGuideData;Lcom/baidu/bdtask/model/meter/TaskMeterData;Lcom/baidu/bdtask/model/response/TaskResponseData;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class TaskInfo implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int TYPE_BEHAVIOR_INITIATIVE = 0;
    public static final int TYPE_BEHAVIOR_PASSIVE = 1;
    public static final String key = "info";
    public static final String keyActTaskId = "actTaskId";
    public static final String keyAid = "aid";
    public static final String keyBehavior = "behavior";
    public static final String keyFingerprint = "fingerprint";
    public static final String keyId = "id";
    public static final String keyToken = "token";
    public static final String keyType = "type";
    public transient /* synthetic */ FieldHolder $fh;
    public final String actTaskId;
    public final String actionId;
    public final int behavior;
    public final String fingerprint;
    public final String id;
    public TaskResponseData response;
    public final TaskGuideData taskGuide;
    public final TaskMeterData taskMeter;
    public final TaskRuleData taskRule;
    public final String token;
    public final int type;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1248033113, "Lcom/baidu/bdtask/model/info/TaskInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1248033113, "Lcom/baidu/bdtask/model/info/TaskInfo;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskInfo() {
        this(null, null, 0, null, 0, null, null, null, null, null, null, RevenueServerConst.GetUserCouponStoreResponse, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3], ((Integer) objArr[4]).intValue(), (String) objArr[5], (String) objArr[6], (TaskRuleData) objArr[7], (TaskGuideData) objArr[8], (TaskMeterData) objArr[9], (TaskResponseData) objArr[10], ((Integer) objArr[11]).intValue(), (DefaultConstructorMarker) objArr[12]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TaskInfo(String str, String str2, int i2, String str3, int i3, String str4, String str5, TaskRuleData taskRuleData, TaskGuideData taskGuideData, TaskMeterData taskMeterData, TaskResponseData taskResponseData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3), str4, str5, taskRuleData, taskGuideData, taskMeterData, taskResponseData};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.id = str;
        this.actionId = str2;
        this.type = i2;
        this.token = str3;
        this.behavior = i3;
        this.actTaskId = str4;
        this.fingerprint = str5;
        this.taskRule = taskRuleData;
        this.taskGuide = taskGuideData;
        this.taskMeter = taskMeterData;
        this.response = taskResponseData;
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : (String) invokeV.objValue;
    }

    public final TaskMeterData component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.taskMeter : (TaskMeterData) invokeV.objValue;
    }

    public final TaskResponseData component11() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.response : (TaskResponseData) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.actionId : (String) invokeV.objValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.type : invokeV.intValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.token : (String) invokeV.objValue;
    }

    public final int component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.behavior : invokeV.intValue;
    }

    public final String component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.actTaskId : (String) invokeV.objValue;
    }

    public final String component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.fingerprint : (String) invokeV.objValue;
    }

    public final TaskRuleData component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.taskRule : (TaskRuleData) invokeV.objValue;
    }

    public final TaskGuideData component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.taskGuide : (TaskGuideData) invokeV.objValue;
    }

    public final TaskInfo copy(String str, String str2, int i2, String str3, int i3, String str4, String str5, TaskRuleData taskRuleData, TaskGuideData taskGuideData, TaskMeterData taskMeterData, TaskResponseData taskResponseData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3), str4, str5, taskRuleData, taskGuideData, taskMeterData, taskResponseData})) == null) ? new TaskInfo(str, str2, i2, str3, i3, str4, str5, taskRuleData, taskGuideData, taskMeterData, taskResponseData) : (TaskInfo) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj != null && (obj instanceof TaskInfo)) {
                if (obj == this) {
                    return true;
                }
                return Intrinsics.areEqual(getSingleKey(), ((TaskInfo) obj).getSingleKey());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String getActTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.actTaskId : (String) invokeV.objValue;
    }

    public final String getActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.actionId : (String) invokeV.objValue;
    }

    public final int getBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.behavior : invokeV.intValue;
    }

    public final String getFingerprint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.fingerprint : (String) invokeV.objValue;
    }

    public final String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.id : (String) invokeV.objValue;
    }

    public final TaskResponseData getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.response : (TaskResponseData) invokeV.objValue;
    }

    public final String getSingleKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.actTaskId : (String) invokeV.objValue;
    }

    public final TaskGuideData getTaskGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.taskGuide : (TaskGuideData) invokeV.objValue;
    }

    public final TaskMeterData getTaskMeter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.taskMeter : (TaskMeterData) invokeV.objValue;
    }

    public final TaskRuleData getTaskRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.taskRule : (TaskRuleData) invokeV.objValue;
    }

    public final String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.token : (String) invokeV.objValue;
    }

    public final int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.type : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? getSingleKey().hashCode() : invokeV.intValue;
    }

    public final boolean isClickAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.type == 6 : invokeV.booleanValue;
    }

    public final boolean isDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? !this.response.isEmpty() && this.response.getProcessData().isDone() : invokeV.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? Intrinsics.areEqual(this.id, "") || Intrinsics.areEqual(this.actionId, "") || this.type == -1 || Intrinsics.areEqual(this.token, "") || Intrinsics.areEqual(this.actTaskId, "") : invokeV.booleanValue;
    }

    public final boolean isEnableActivated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (!isPassiveTask() || this.response.isEmpty()) {
                return true;
            }
            NextActive nextActive = this.response.getNextActive();
            return !nextActive.isForceCleaned() && System.currentTimeMillis() >= nextActive.getUntil();
        }
        return invokeV.booleanValue;
    }

    public final boolean isForceCleaned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (isPassiveTask()) {
                return this.response.getNextActive().isForceCleaned();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isInitiActiveTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.behavior == 0 : invokeV.booleanValue;
    }

    public final boolean isPassiveTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.behavior == 1 : invokeV.booleanValue;
    }

    public final boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? !isEmpty() : invokeV.booleanValue;
    }

    public final boolean isVisitAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.type == 7 : invokeV.booleanValue;
    }

    public final void setResponse(TaskResponseData taskResponseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, taskResponseData) == null) {
            this.response = taskResponseData;
        }
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.id);
            jSONObject.put("aid", this.actionId);
            jSONObject.put("type", this.type);
            jSONObject.put("token", this.token);
            jSONObject.put("behavior", this.behavior);
            jSONObject.put(keyActTaskId, this.actTaskId);
            jSONObject.put(keyFingerprint, this.fingerprint);
            jSONObject.put("rule", this.taskRule.toJson());
            jSONObject.put("guide", this.taskGuide.toJson());
            jSONObject.put(TaskMeterData.key, this.taskMeter.toJson());
            jSONObject.put("response", this.response.toJson());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            String jSONObject = toJson().toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJson().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ TaskInfo(String str, String str2, int i2, String str3, int i3, String str4, String str5, TaskRuleData taskRuleData, TaskGuideData taskGuideData, TaskMeterData taskMeterData, TaskResponseData taskResponseData, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? -1 : i2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? "" : str4, (i4 & 64) == 0 ? str5 : "", (i4 & 128) != 0 ? new TaskRuleData(null, null, 0L, 0, 0, false, false, false, 0, 0, 1023, null) : taskRuleData, (i4 & 256) != 0 ? new TaskGuideData(0, null, 3, null) : taskGuideData, (i4 & 512) != 0 ? new TaskMeterData(0, null, 3, null) : taskMeterData, (i4 & 1024) != 0 ? new TaskResponseData(0, null, null, null, 15, null) : taskResponseData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.bdtask.model.ITaskModelData
    public TaskInfo deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new TaskInfo(this.id, this.actionId, this.type, this.token, this.behavior, this.actTaskId, this.fingerprint, TaskRuleData.copy$default(this.taskRule, null, null, 0L, 0, 0, false, false, false, 0, 0, 1023, null), TaskGuideData.copy$default(this.taskGuide, 0, null, 3, null), TaskMeterData.copy$default(this.taskMeter, 0, null, 3, null), TaskResponseData.copy$default(this.response, 0, null, null, null, 15, null)) : (TaskInfo) invokeV.objValue;
    }
}
