package c.a.o0.j0.l;

import c.a.o0.j0.b;
import c.a.p0.a4.k0.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements b<AgreeEvent> {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.j0.b
    /* renamed from: a */
    public boolean onEvent(AgreeEvent agreeEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, agreeEvent)) == null) {
            if (agreeEvent != null && agreeEvent.agreeData != null) {
                e eVar = new e();
                eVar.f12234b = agreeEvent.agreeData;
                String str = agreeEvent.agreeExtra;
                if (TbadkCoreApplication.isLogin() && TbadkCoreApplication.getInst().isMainProcess(true) && agreeEvent.agreeData.hasAgree) {
                    if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                        c.a.p0.x3.b.r().A(0, 3);
                        c.a.p0.x3.b.r().G();
                    }
                    c.a.p0.x3.b.r().z(StampMission.Type.LIKE_THREAD);
                }
                if (AgreeEvent.IS_THREAD.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
                    return true;
                } else if (AgreeEvent.IS_POST.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, eVar));
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
