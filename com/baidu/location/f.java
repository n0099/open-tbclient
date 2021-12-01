package com.baidu.location;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.location.e.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public class f extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean isServing = false;
    public static boolean isStartedServing = false;
    public static Context mC = null;
    public static String replaceFileName = "repll.jar";
    public transient /* synthetic */ FieldHolder $fh;
    public LLSInterface a;

    /* renamed from: b  reason: collision with root package name */
    public LLSInterface f35723b;

    /* renamed from: c  reason: collision with root package name */
    public LLSInterface f35724c;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f35723b = null;
        this.f35724c = null;
    }

    private boolean a(File file) {
        InterceptResult invokeL;
        int readInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, file)) == null) {
            boolean z = false;
            try {
                File file2 = new File(k.j() + "/grtcfrsa.dat");
                if (file2.exists()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                    randomAccessFile.seek(200L);
                    if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean() && (readInt = randomAccessFile.readInt()) != 0) {
                        byte[] bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        String str = new String(bArr);
                        String a = k.a(file, "SHA-256");
                        if (a != null && k.b(a, str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                            z = true;
                        }
                    }
                    randomAccessFile.close();
                }
            } catch (Exception unused) {
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static float getFrameVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 7.93f;
        }
        return invokeV.floatValue;
    }

    public static String getJarFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "app.jar" : (String) invokeV.objValue;
    }

    public static Context getServiceContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? mC : (Context) invokeV.objValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            LLSInterface lLSInterface = this.f35724c;
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
                String str = "baidu location service can not start again ...20190306..." + Process.myPid();
                return;
            }
            mC = getApplicationContext();
            System.currentTimeMillis();
            this.f35723b = new com.baidu.location.d.a();
            try {
                File file = new File(k.j() + File.separator + replaceFileName);
                File file2 = new File(k.j() + File.separator + "app.jar");
                if (file.exists()) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file.renameTo(file2);
                }
                if (file2.exists()) {
                    if (a(new File(k.j() + File.separator + "app.jar"))) {
                        this.a = (LLSInterface) new DexClassLoader(k.j() + File.separator + "app.jar", k.j(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
                    }
                }
            } catch (Exception unused) {
                this.a = null;
            }
            LLSInterface lLSInterface = this.a;
            if (lLSInterface == null || lLSInterface.getVersion() < this.f35723b.getVersion()) {
                this.f35724c = this.f35723b;
                this.a = null;
            } else {
                this.f35724c = this.a;
                this.f35723b = null;
            }
            isServing = true;
            this.f35724c.onCreate(this);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            isServing = false;
            LLSInterface lLSInterface = this.f35724c;
            if (lLSInterface != null) {
                lLSInterface.onDestroy();
            }
            if (isStartedServing) {
                stopForeground(true);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i2, i3)) == null) {
            if (intent != null) {
                try {
                    int intExtra = intent.getIntExtra("command", 0);
                    if (intExtra == 1) {
                        startForeground(intent.getIntExtra("id", 0), (Notification) intent.getParcelableExtra(ActionJsonData.TAG_NOTIFICATION));
                        isStartedServing = true;
                    } else if (intExtra == 2) {
                        stopForeground(intent.getBooleanExtra("removenotify", true));
                        isStartedServing = false;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.f35724c.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        LLSInterface lLSInterface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, intent) == null) || (lLSInterface = this.f35724c) == null) {
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
