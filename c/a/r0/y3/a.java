package c.a.r0.y3;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC1472a mICrabSdk;

    /* renamed from: c.a.r0.y3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1472a {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mICrabSdk = getCrabSdk();
    }

    private InterfaceC1472a getCrabSdk() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (!isCrabSdkSwitchOn() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC1472a.class)) == null) {
                return null;
            }
            return (InterfaceC1472a) runTask.getData();
        }
        return (InterfaceC1472a) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? c.a.q0.s.e0.b.j().k("pref_key_crab_sdk_enable", 1) == 1 : invokeV.booleanValue;
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        InterfaceC1472a interfaceC1472a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, motionEvent, activity) == null) || (interfaceC1472a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1472a.f(motionEvent, activity);
    }

    public void initSdk(Application application) {
        InterfaceC1472a interfaceC1472a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, application) == null) || (interfaceC1472a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1472a.a(application);
    }

    public void onPause(Activity activity) {
        InterfaceC1472a interfaceC1472a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || (interfaceC1472a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1472a.onPause(activity);
    }

    public void onResume(Activity activity) {
        InterfaceC1472a interfaceC1472a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, activity) == null) || (interfaceC1472a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1472a.onResume(activity);
    }

    public void setFlutterPath(String str) {
        InterfaceC1472a interfaceC1472a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (interfaceC1472a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1472a.c(str);
    }

    public void setLastFlutterPage(String str) {
        InterfaceC1472a interfaceC1472a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (interfaceC1472a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1472a.e(str);
    }

    public void setOpenFlutterPage(String str) {
        InterfaceC1472a interfaceC1472a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (interfaceC1472a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1472a.d(str);
    }

    public void uploadException(Exception exc) {
        InterfaceC1472a interfaceC1472a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, exc) == null) || (interfaceC1472a = this.mICrabSdk) == null) {
            return;
        }
        interfaceC1472a.b(exc);
    }
}
