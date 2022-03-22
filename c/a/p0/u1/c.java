package c.a.p0.u1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c.a.o0.z0.a a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, cls)) == null) {
            try {
                c.a.o0.z0.a aVar = new c.a.o0.z0.a(i, cls.newInstance());
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
        return (c.a.o0.z0.a) invokeIL.objValue;
    }

    public static c.a.o0.z0.b b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            c.a.o0.z0.b bVar = new c.a.o0.z0.b(i);
            bVar.setResponsedClass(cls);
            bVar.h(z);
            bVar.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(bVar);
            return bVar;
        }
        return (c.a.o0.z0.b) invokeCommon.objValue;
    }
}
