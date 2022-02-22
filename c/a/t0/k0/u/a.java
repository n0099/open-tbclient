package c.a.t0.k0.u;

import c.a.t0.b.d;
import c.a.t0.k0.b;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.replay.ReplayEvent;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a implements b<ReplayEvent> {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.k0.b
    /* renamed from: a */
    public boolean onEvent(ReplayEvent replayEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, replayEvent)) == null) {
            if (replayEvent != null && TbadkCoreApplication.isLogin() && TbadkCoreApplication.getInst().isMainProcess(true)) {
                if (TbSingleton.getInstance().showStampMissionDialog && d.t0()) {
                    c.a.u0.w3.b.r().A(0, 3);
                    c.a.u0.w3.b.r().G();
                }
                c.a.u0.w3.b.r().z(StampMission.Type.REPLAY_THREAD);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
