package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f41047a;

    /* renamed from: b  reason: collision with root package name */
    public static x f41048b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f41049c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f41050d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41051e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037723996, "Lcom/baidu/location/b/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037723996, "Lcom/baidu/location/b/x;");
                return;
            }
        }
        f41047a = new Object();
    }

    public x() {
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
        this.f41051e = false;
    }

    public static x a() {
        InterceptResult invokeV;
        x xVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (f41047a) {
                if (f41048b == null) {
                    f41048b = new x();
                }
                xVar = f41048b;
            }
            return xVar;
        }
        return (x) invokeV.objValue;
    }

    public void a(Location location, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, location, i2) == null) && this.f41051e && location != null) {
            try {
                if (this.f41050d != null) {
                    Message obtainMessage = this.f41050d.obtainMessage(1);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("loc", new Location(location));
                    bundle.putInt("satnum", i2);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f41051e) {
            try {
                if (this.f41050d != null) {
                    this.f41050d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f41051e) {
            try {
                if (this.f41050d != null) {
                    this.f41050d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f41051e) {
            try {
                if (this.f41050d != null) {
                    this.f41050d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f41051e) {
            return;
        }
        this.f41051e = true;
        if (this.f41049c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f41049c = handlerThread;
            handlerThread.start();
            if (this.f41049c != null) {
                this.f41050d = new y(this, this.f41049c.getLooper());
            }
        }
        try {
            if (this.f41050d != null) {
                this.f41050d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f41050d != null) {
                this.f41050d.sendEmptyMessageDelayed(4, com.baidu.location.e.k.R);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f41051e) {
            d.a().b();
            try {
                if (this.f41050d != null) {
                    this.f41050d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f41050d = null;
            try {
                if (this.f41049c != null) {
                    this.f41049c.quit();
                    this.f41049c.interrupt();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f41049c = null;
            this.f41051e = false;
        }
    }
}
