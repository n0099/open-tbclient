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
/* loaded from: classes7.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f39088a;

    /* renamed from: b  reason: collision with root package name */
    public static x f39089b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f39090c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f39091d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39092e;

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
        f39088a = new Object();
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
        this.f39092e = false;
    }

    public static x a() {
        InterceptResult invokeV;
        x xVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (f39088a) {
                if (f39089b == null) {
                    f39089b = new x();
                }
                xVar = f39089b;
            }
            return xVar;
        }
        return (x) invokeV.objValue;
    }

    public void a(Location location, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, location, i2) == null) && this.f39092e && location != null) {
            try {
                if (this.f39091d != null) {
                    Message obtainMessage = this.f39091d.obtainMessage(1);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f39092e) {
            try {
                if (this.f39091d != null) {
                    this.f39091d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f39092e) {
            try {
                if (this.f39091d != null) {
                    this.f39091d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f39092e) {
            try {
                if (this.f39091d != null) {
                    this.f39091d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f39092e) {
            return;
        }
        this.f39092e = true;
        if (this.f39090c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f39090c = handlerThread;
            handlerThread.start();
            if (this.f39090c != null) {
                this.f39091d = new y(this, this.f39090c.getLooper());
            }
        }
        try {
            if (this.f39091d != null) {
                this.f39091d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f39091d != null) {
                this.f39091d.sendEmptyMessageDelayed(4, com.baidu.location.e.k.R);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f39092e) {
            d.a().b();
            try {
                if (this.f39091d != null) {
                    this.f39091d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f39091d = null;
            try {
                if (this.f39090c != null) {
                    this.f39090c.quit();
                    this.f39090c.interrupt();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f39090c = null;
            this.f39092e = false;
        }
    }
}
