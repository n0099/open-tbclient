package c.f.a.g;

import android.os.Handler;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes3.dex */
public class b implements InvocationHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Object f28232e;

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

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new b() : (b) invokeV.objValue;
    }

    public final void b(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, layoutParams) == null) {
            c(layoutParams, 8192, 8192);
        }
    }

    public final void c(WindowManager.LayoutParams layoutParams, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutParams, i2, i3) == null) || layoutParams == null) {
            return;
        }
        try {
            layoutParams.flags = (i2 & i3) | (layoutParams.flags & (~i3));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d(PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, popupWindow) == null) || popupWindow == null) {
            return;
        }
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mWindowManager");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(popupWindow);
            this.f28232e = obj;
            if (obj == null) {
                return;
            }
            declaredField.set(popupWindow, Proxy.newProxyInstance(Handler.class.getClassLoader(), new Class[]{WindowManager.class}, this));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, obj, method, objArr)) == null) {
            if (method != null) {
                try {
                    if (method.getName() != null && method.getName().equals("addView") && objArr != null && objArr.length == 2) {
                        b((WindowManager.LayoutParams) objArr[1]);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return method.invoke(this.f28232e, objArr);
        }
        return invokeLLL.objValue;
    }
}
