package com.baidu.bdtask;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "", "Lcom/baidu/bdtask/TaskState;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class BDPTask$INSTANCE$findAllTaskStateByActionIds$1 extends Lambda implements Function0<Map<String, ? extends List<? extends TaskState>>> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ String[] $actionIds;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDPTask$INSTANCE$findAllTaskStateByActionIds$1(String[] strArr) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$actionIds = strArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'java.util.Map<java.lang.String, java.util.List<com.baidu.bdtask.TaskState>>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends List<? extends TaskState>> invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BDPTask u = BDPTask.m.u();
            if (u != null) {
                String[] strArr = this.$actionIds;
                return u.I((String[]) Arrays.copyOf(strArr, strArr.length));
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }
}
