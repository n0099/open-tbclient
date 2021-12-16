package c.a.j.i.e;

import c.a.j.i.d;
import c.a.j.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskEnvTag;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.ctrl.model.TaskStatusRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a extends d<TaskStatus> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TaskStatus.key : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.j.i.d
    /* renamed from: c */
    public TaskStatus a(String str) {
        InterceptResult invokeL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt(TaskStatus.keyCurStatus);
                int i3 = jSONObject.getInt(TaskStatus.keyCurStatusCode);
                String curStatusCodeMsg = jSONObject.getString(TaskStatus.keyCurStatusCodeMsg);
                int i4 = jSONObject.getInt(TaskStatus.keyInterruptErrorNo);
                long j3 = jSONObject.getLong(TaskStatus.keyCurActiveTime);
                JSONObject jSONObject2 = jSONObject.getJSONObject("process");
                int i5 = jSONObject2.getInt(TaskProcess.keyClickNumber);
                long j4 = jSONObject2.getLong(TaskProcess.keyStayDurTimeMs);
                long j5 = jSONObject2.getLong(TaskProcess.keyMaxStayTime);
                int i6 = jSONObject2.getInt(TaskProcess.keyMaxRepeatTimes);
                int i7 = jSONObject2.getInt(TaskProcess.keyMaxNoClickTimes);
                int i8 = jSONObject2.getInt(TaskProcess.keyCurNoClickTimes);
                JSONArray optJSONArray = jSONObject2.optJSONArray(TaskProcess.keyDuplicateIds);
                HashSet hashSet = new HashSet();
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    j2 = j3;
                    for (int i9 = 0; i9 < length; i9++) {
                        hashSet.add(optJSONArray.optString(i9));
                    }
                } else {
                    j2 = j3;
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("tags");
                HashSet hashSet2 = new HashSet();
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    int i10 = 0;
                    while (i10 < length2) {
                        int i11 = length2;
                        TaskEnvTag b2 = TaskEnvTag.Companion.b(optJSONArray2.optString(i10));
                        if (b2 != null) {
                            hashSet2.add(b2);
                        }
                        i10++;
                        length2 = i11;
                    }
                }
                Intrinsics.checkExpressionValueIsNotNull(curStatusCodeMsg, "curStatusCodeMsg");
                return new TaskStatus(i2, i3, curStatusCodeMsg, i4, j2, TaskStatusRuntime.Companion.a(), new TaskProcess(i5, j4, i8, j5, i6, i7, hashSet2, hashSet));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (TaskStatus) invokeL.objValue;
    }
}
