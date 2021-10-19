package c.a.r0.x1.u.a;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b implements ThirdPartAliRechargeService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService
    public String aliRecharge(Activity activity, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, activity, str, z)) == null) {
            c.a.q0.e.a aVar = new c.a.q0.e.a();
            aVar.f13046a = activity;
            aVar.f13047b = str;
            aVar.f13048c = z;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921539, String.class, aVar);
            return runTask == null ? "" : (String) runTask.getData();
        }
        return (String) invokeLLZ.objValue;
    }
}
