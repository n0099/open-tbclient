package com.baidu.bdtask.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0003\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/bdtask/model/ITaskModelData;", "Ljava/io/Serializable;", "Lkotlin/Any;", "deepCopy", "()Lcom/baidu/bdtask/model/ITaskModelData;", "", "isEmpty", "()Z", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public interface ITaskModelData extends Serializable {

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(ITaskModelData iTaskModelData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iTaskModelData)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public static ITaskModelData b(ITaskModelData iTaskModelData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iTaskModelData)) == null) ? iTaskModelData : (ITaskModelData) invokeL.objValue;
        }
    }

    ITaskModelData deepCopy();

    boolean isEmpty();

    JSONObject toJson();
}
