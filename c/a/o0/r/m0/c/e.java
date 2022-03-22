package c.a.o0.r.m0.c;

import android.media.MediaPlayer;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.q.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e extends MediaPlayer implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static Object f10752d;

    /* renamed from: e  reason: collision with root package name */
    public static e f10753e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10754b;

    /* renamed from: c  reason: collision with root package name */
    public int f10755c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(438263209, "Lc/a/o0/r/m0/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(438263209, "Lc/a/o0/r/m0/c/e;");
                return;
            }
        }
        f10752d = new Object();
    }

    public e() {
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
        this.a = false;
        this.f10754b = true;
        this.f10755c = -1;
    }

    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f10753e == null) {
                synchronized (f10752d) {
                    if (f10753e == null) {
                        f10753e = new e();
                    }
                }
            }
            return f10753e;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.a.o0.r.m0.c.c
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.booleanValue;
    }

    @Override // c.a.o0.r.m0.c.c
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10754b) {
            return;
        }
        stop();
        this.f10754b = true;
        this.a = false;
    }

    @Override // c.a.o0.r.m0.c.c
    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f10755c = -1;
            if (!this.a) {
                this.f10754b = true;
                reset();
                try {
                    setDataSource(str);
                    j(h.f2366b);
                    try {
                        prepare();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        this.f10755c = 2;
                        return false;
                    } catch (IllegalStateException unused) {
                        this.f10755c = 1;
                        return false;
                    }
                } catch (IOException unused2) {
                    this.f10755c = 2;
                    return false;
                } catch (IllegalArgumentException unused3) {
                    this.f10755c = 0;
                    return false;
                } catch (IllegalStateException unused4) {
                    this.f10755c = 1;
                    return false;
                }
            }
            this.a = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.r.m0.c.c
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10755c : invokeV.intValue;
    }

    @Override // c.a.o0.r.m0.c.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pause();
        }
    }

    @Override // c.a.o0.r.m0.c.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            reset();
            this.a = false;
            this.f10754b = true;
            this.f10755c = -1;
        }
    }

    @Override // c.a.o0.r.m0.c.c
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.o0.r.m0.c.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            start();
            this.f10754b = false;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            setAudioStreamType(i);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            try {
                seekTo(i);
            } catch (Exception unused) {
            }
        }
    }

    @Override // c.a.o0.r.m0.c.c
    public void seek(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            k(i);
        }
    }
}
