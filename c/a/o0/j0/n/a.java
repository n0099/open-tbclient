package c.a.o0.j0.n;

import android.app.Activity;
import c.a.o0.a.p;
import c.a.o0.j0.b;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements b<CompeteTaskEvent> {
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
    public boolean onEvent(CompeteTaskEvent competeTaskEvent) {
        InterceptResult invokeL;
        CompleteTaskToastData completeTaskToastData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, competeTaskEvent)) == null) {
            if (competeTaskEvent != null && (completeTaskToastData = competeTaskEvent.taskToastData) != null) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity instanceof p) {
                    ((p) currentActivity).onMissionCompleted(completeTaskToastData);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
