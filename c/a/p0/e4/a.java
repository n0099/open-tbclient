package c.a.p0.e4;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC1047a mICrabSdk;

    /* renamed from: c.a.p0.e4.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1047a {
        void a(Application application);

        void b(Exception exc);

        void c(String str);

        void d(String str);

        void e(String str);

        void f(MotionEvent motionEvent, Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

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
                return;
            }
        }
        this.mICrabSdk = getCrabSdk();
    }

    private InterfaceC1047a getCrabSdk() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (!isCrabSdkSwitchOn() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC1047a.class)) == null) {
                return null;
            }
            return (InterfaceC1047a) runTask.getData();
        }
        return (InterfaceC1047a) invokeV.objValue;
    }

    public static a getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (a.class) {
                    if (mInstance == null) {
                        mInstance = new a();
                    }
                }
            }
            return mInstance;
        }
        return (a) invokeV.objValue;
    }

    private boolean isCrabSdkSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? c.a.o0.r.j0.b.k().l("pref_key_crab_sdk_enable", 1) == 1 : invokeV.booleanValue;
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        InterfaceC1047a interfaceC1047a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, motionEvent, activity) == null) || (interfaceC1047a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1047a.f(motionEvent, activity);
    }

    public void initSdk(Application application) {
        InterfaceC1047a interfaceC1047a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, application) == null) || (interfaceC1047a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1047a.a(application);
    }

    public void onPause(Activity activity) {
        InterfaceC1047a interfaceC1047a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || (interfaceC1047a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1047a.onPause(activity);
    }

    public void onResume(Activity activity) {
        InterfaceC1047a interfaceC1047a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, activity) == null) || (interfaceC1047a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1047a.onResume(activity);
    }

    public void setFlutterPath(String str) {
        InterfaceC1047a interfaceC1047a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (interfaceC1047a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1047a.c(str);
    }

    public void setLastFlutterPage(String str) {
        InterfaceC1047a interfaceC1047a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (interfaceC1047a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1047a.e(str);
    }

    public void setOpenFlutterPage(String str) {
        InterfaceC1047a interfaceC1047a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (interfaceC1047a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1047a.d(str);
    }

    public void uploadException(Exception exc) {
        InterfaceC1047a interfaceC1047a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, exc) == null) || (interfaceC1047a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1047a.b(exc);
    }
}
