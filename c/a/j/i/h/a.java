package c.a.j.i.h;

import c.a.j.i.d;
import c.a.j.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.guide.TaskGuideData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.meter.TaskMeterData;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.rule.TaskRuleData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a extends d<TaskInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fVar;
    }

    public final <T extends ITaskModelData> T b(f fVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, str, str2)) == null) ? fVar.a(str).a(str2) : (T) invokeLLL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "info" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.j.i.d
    /* renamed from: d */
    public TaskInfo a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String id = jSONObject.optString("id");
                String aid = jSONObject.optString("aid");
                int optInt = jSONObject.optInt("type");
                String token = jSONObject.optString("token");
                int optInt2 = jSONObject.optInt("behavior", 0);
                String actTaskId = jSONObject.optString(TaskInfo.keyActTaskId);
                String fingerprint = jSONObject.optString(TaskInfo.keyFingerprint);
                f fVar = this.a;
                String optString = jSONObject.optString("rule");
                Intrinsics.checkExpressionValueIsNotNull(optString, "infoObj.optString(TaskRuleData.key)");
                TaskRuleData taskRuleData = (TaskRuleData) b(fVar, "rule", optString);
                if (taskRuleData != null) {
                    f fVar2 = this.a;
                    String optString2 = jSONObject.optString("guide");
                    Intrinsics.checkExpressionValueIsNotNull(optString2, "infoObj.optString(TaskGuideData.key)");
                    TaskGuideData taskGuideData = (TaskGuideData) b(fVar2, "guide", optString2);
                    if (taskGuideData != null) {
                        f fVar3 = this.a;
                        String optString3 = jSONObject.optString(TaskMeterData.key);
                        Intrinsics.checkExpressionValueIsNotNull(optString3, "infoObj.optString(TaskMeterData.key)");
                        TaskMeterData taskMeterData = (TaskMeterData) b(fVar3, TaskMeterData.key, optString3);
                        if (taskMeterData != null) {
                            f fVar4 = this.a;
                            String optString4 = jSONObject.optString("response");
                            Intrinsics.checkExpressionValueIsNotNull(optString4, "infoObj.optString(TaskResponseData.key)");
                            TaskResponseData taskResponseData = (TaskResponseData) b(fVar4, "response", optString4);
                            if (taskResponseData != null) {
                                Intrinsics.checkExpressionValueIsNotNull(id, "id");
                                Intrinsics.checkExpressionValueIsNotNull(aid, "aid");
                                Intrinsics.checkExpressionValueIsNotNull(token, "token");
                                Intrinsics.checkExpressionValueIsNotNull(actTaskId, "actTaskId");
                                Intrinsics.checkExpressionValueIsNotNull(fingerprint, "fingerprint");
                                return new TaskInfo(id, aid, optInt, token, optInt2, actTaskId, fingerprint, taskRuleData, taskGuideData, taskMeterData, taskResponseData);
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (TaskInfo) invokeL.objValue;
    }
}
