package com.baidu.bdtask.service.ubc.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/baidu/bdtask/service/ubc/model/UBCRecoveryTaskQueue;", "Lcom/baidu/bdtask/model/ITaskModelData;", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "Lcom/baidu/bdtask/service/ubc/model/UBCRecoveryTaskInfo;", GrowthConstant.UBC_VALUE_TYPE_DEFAULT, "Lcom/baidu/bdtask/service/ubc/model/UBCRecoveryTaskInfo;", "getActive", "()Lcom/baidu/bdtask/service/ubc/model/UBCRecoveryTaskInfo;", "setActive", "(Lcom/baidu/bdtask/service/ubc/model/UBCRecoveryTaskInfo;)V", "", "passive", "Ljava/util/List;", "getPassive", "()Ljava/util/List;", "setPassive", "(Ljava/util/List;)V", "<init>", "()V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class UBCRecoveryTaskQueue implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UBCRecoveryTaskInfo active;
    public List<UBCRecoveryTaskInfo> passive;

    public UBCRecoveryTaskQueue() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.passive = new ArrayList();
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

    public final UBCRecoveryTaskInfo getActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.active : (UBCRecoveryTaskInfo) invokeV.objValue;
    }

    public final List<UBCRecoveryTaskInfo> getPassive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.passive : (List) invokeV.objValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ITaskModelData.a.a(this) : invokeV.booleanValue;
    }

    public final void setActive(UBCRecoveryTaskInfo uBCRecoveryTaskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uBCRecoveryTaskInfo) == null) {
            this.active = uBCRecoveryTaskInfo;
        }
    }

    public final void setPassive(List<UBCRecoveryTaskInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.passive = list;
        }
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            UBCRecoveryTaskInfo uBCRecoveryTaskInfo = this.active;
            if (uBCRecoveryTaskInfo != null) {
                jSONObject.put(GrowthConstant.UBC_VALUE_TYPE_DEFAULT, uBCRecoveryTaskInfo.toJson());
            }
            for (UBCRecoveryTaskInfo uBCRecoveryTaskInfo2 : this.passive) {
                jSONArray.put(uBCRecoveryTaskInfo2.toJson());
            }
            if (jSONArray.length() != 0) {
                jSONObject.put("passive", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
