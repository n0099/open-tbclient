package c.a.r0.j3.d0;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.z0.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f20787a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(792060386, "Lc/a/r0/j3/d0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(792060386, "Lc/a/r0/j3/d0/a;");
        }
    }

    public static String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
            return TbConfig.SERVER_ADDRESS + str + "?cmd=" + i2;
        }
        return (String) invokeLI.objValue;
    }

    public static c.a.q0.z0.a b(int i2, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, cls)) == null) {
            try {
                c.a.q0.z0.a aVar = new c.a.q0.z0.a(i2, cls.newInstance());
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
        return (c.a.q0.z0.a) invokeIL.objValue;
    }

    public static TbHttpMessageTask c(int i2, int i3, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, cls, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i3, a(str, i2));
            tbHttpMessageTask.setIsNeedLogin(z);
            tbHttpMessageTask.setIsNeedTbs(z2);
            tbHttpMessageTask.setIsNeedAddCommenParam(z3);
            tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
            tbHttpMessageTask.setResponsedClass(cls);
            MessageManager.getInstance().unRegisterTask(i3);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            return tbHttpMessageTask;
        }
        return (TbHttpMessageTask) invokeCommon.objValue;
    }

    public static void d(int i2, int i3, String str, Class<? extends HttpResponsedMessage> cls, Class<? extends SocketResponsedMessage> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, cls, cls2}) == null) {
            h(i3, cls2, false, false);
            c(i3, i2, str, cls, false, true, true, false);
        }
    }

    public static TbHttpMessageTask e(int i2, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Integer.valueOf(i2), str, cls, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i2, TbConfig.SERVER_ADDRESS + str);
            tbHttpMessageTask.setIsNeedLogin(z);
            tbHttpMessageTask.setIsNeedTbs(z2);
            tbHttpMessageTask.setIsNeedAddCommenParam(z3);
            tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
            tbHttpMessageTask.setResponsedClass(cls);
            MessageManager.getInstance().unRegisterTask(i2);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            return tbHttpMessageTask;
        }
        return (TbHttpMessageTask) invokeCommon.objValue;
    }

    public static b f(int i2, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Integer.valueOf(i2), cls, Boolean.valueOf(z)})) == null) ? g(i2, cls, z, SocketMessageTask.DupLicateMode.NONE, true) : (b) invokeCommon.objValue;
    }

    public static b g(int i2, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), cls, Boolean.valueOf(z), dupLicateMode, Boolean.valueOf(z2)})) == null) {
            b bVar = new b(i2);
            bVar.setResponsedClass(cls);
            bVar.h(z);
            bVar.f(dupLicateMode);
            bVar.setRetry(f20787a);
            MessageManager.getInstance().unRegisterTask(i2);
            MessageManager.getInstance().registerTask(bVar);
            bVar.setNeedEncrypt(z2);
            return bVar;
        }
        return (b) invokeCommon.objValue;
    }

    public static b h(int i2, Class<? extends SocketResponsedMessage> cls, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), cls, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? g(i2, cls, z, SocketMessageTask.DupLicateMode.NONE, z2) : (b) invokeCommon.objValue;
    }
}
