package c.a.t0.s1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c.a.s0.a1.a a(int i2, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, cls)) == null) {
            try {
                c.a.s0.a1.a aVar = new c.a.s0.a1.a(i2, cls.newInstance());
                MessageManager.getInstance().registerTask(aVar);
                return aVar;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (c.a.s0.a1.a) invokeIL.objValue;
    }

    public static c.a.s0.a1.b b(int i2, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), cls, Boolean.valueOf(z)})) == null) {
            c.a.s0.a1.b bVar = new c.a.s0.a1.b(i2);
            bVar.setResponsedClass(cls);
            bVar.h(z);
            bVar.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(bVar);
            return bVar;
        }
        return (c.a.s0.a1.b) invokeCommon.objValue;
    }
}
