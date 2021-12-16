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
/* loaded from: classes10.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;

    /* renamed from: b  reason: collision with root package name */
    public static x f36095b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f36096c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f36097d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36098e;

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
        a = new Object();
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
        this.f36098e = false;
    }

    public static x a() {
        InterceptResult invokeV;
        x xVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (a) {
                if (f36095b == null) {
                    f36095b = new x();
                }
                xVar = f36095b;
            }
            return xVar;
        }
        return (x) invokeV.objValue;
    }

    public void a(Location location, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, location, i2) == null) && this.f36098e && location != null) {
            try {
                if (this.f36097d != null) {
                    Message obtainMessage = this.f36097d.obtainMessage(1);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f36098e) {
            try {
                if (this.f36097d != null) {
                    this.f36097d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f36098e) {
            try {
                if (this.f36097d != null) {
                    this.f36097d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f36098e) {
            try {
                if (this.f36097d != null) {
                    this.f36097d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f36098e) {
            return;
        }
        this.f36098e = true;
        if (this.f36096c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f36096c = handlerThread;
            handlerThread.start();
            if (this.f36096c != null) {
                this.f36097d = new y(this, this.f36096c.getLooper());
            }
        }
        try {
            if (this.f36097d != null) {
                this.f36097d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f36097d != null) {
                this.f36097d.sendEmptyMessageDelayed(4, com.baidu.location.e.k.R);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f36098e) {
            d.a().b();
            try {
                if (this.f36097d != null) {
                    this.f36097d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f36097d = null;
            try {
                if (this.f36096c != null) {
                    this.f36096c.quit();
                    this.f36096c.interrupt();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f36096c = null;
            this.f36098e = false;
        }
    }
}
