package c.a.q0.j0.r;

import c.a.q0.a.d;
import c.a.q0.j0.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements b<MissionEvent> {
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
    @Override // c.a.q0.j0.b
    /* renamed from: a */
    public boolean onEvent(MissionEvent missionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, missionEvent)) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                int i2 = missionEvent.pageId;
                int i3 = missionEvent.pageType;
                long j2 = missionEvent.tid;
                String str = missionEvent.actionType;
                if ("onResume".equals(str)) {
                    d.y().K(i2, j2);
                    d.y().P(i3, j2);
                } else if (MissionEvent.MESSAGE_PAUSE.equals(str)) {
                    d.y().E();
                } else if (MissionEvent.MESSAGE_TOUCH.equals(str)) {
                    d.y().F();
                } else if (MissionEvent.MESSAGE_ACTIVITY.equals(str)) {
                    d.y().K(i2, j2);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
