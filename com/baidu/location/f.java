package com.baidu.location;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean isServing = false;
    public static boolean isStartedServing = false;
    public static Context mC = null;
    public static String replaceFileName = "repll.jar";
    public transient /* synthetic */ FieldHolder $fh;
    public LLSInterface a;
    public LLSInterface b;
    public LLSInterface c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-508416671, "Lcom/baidu/location/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-508416671, "Lcom/baidu/location/f;");
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public static float getFrameVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return 9.363f;
        }
        return invokeV.floatValue;
    }

    public static String getJarFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "app.jar" : (String) invokeV.objValue;
    }

    public static Context getServiceContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? mC : (Context) invokeV.objValue;
    }

    public static void setServiceContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            mC = context;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            LLSInterface lLSInterface = this.c;
            if (lLSInterface != null) {
                return lLSInterface.onBind(intent);
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (isServing) {
                Log.d("baidu_location_service", "baidu location service can not start again ...20190306..." + Process.myPid());
                return;
            }
            mC = getApplicationContext();
            System.currentTimeMillis();
            this.b = new com.baidu.location.d.a();
            LLSInterface lLSInterface = this.a;
            if (lLSInterface == null || lLSInterface.getVersion() < this.b.getVersion()) {
                this.c = this.b;
                this.a = null;
            } else {
                this.c = this.a;
                this.b = null;
            }
            isServing = true;
            this.c.onCreate(this);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            isServing = false;
            LLSInterface lLSInterface = this.c;
            if (lLSInterface != null) {
                lLSInterface.onDestroy();
            }
            if (isStartedServing) {
                stopForeground(true);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i, i2)) == null) {
            if (intent != null) {
                try {
                    int intExtra = intent.getIntExtra("command", 0);
                    if (intExtra == 1) {
                        startForeground(intent.getIntExtra("id", 0), (Notification) intent.getParcelableExtra("notification"));
                        isStartedServing = true;
                    } else if (intExtra == 2) {
                        stopForeground(intent.getBooleanExtra("removenotify", true));
                        isStartedServing = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LLSInterface lLSInterface = this.c;
            if (lLSInterface == null) {
                return 2;
            }
            return lLSInterface.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        LLSInterface lLSInterface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, intent) == null) || (lLSInterface = this.c) == null) {
            return;
        }
        lLSInterface.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, intent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
