package b.a.q0.s.h0.c;

import android.media.MediaPlayer;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.q.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public class e extends MediaPlayer implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static Object f13124d;

    /* renamed from: e  reason: collision with root package name */
    public static e f13125e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13126a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13127b;

    /* renamed from: c  reason: collision with root package name */
    public int f13128c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-743042748, "Lb/a/q0/s/h0/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-743042748, "Lb/a/q0/s/h0/c/e;");
                return;
            }
        }
        f13124d = new Object();
    }

    public e() {
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
        this.f13126a = false;
        this.f13127b = true;
        this.f13128c = -1;
    }

    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f13125e == null) {
                synchronized (f13124d) {
                    if (f13125e == null) {
                        f13125e = new e();
                    }
                }
            }
            return f13125e;
        }
        return (e) invokeV.objValue;
    }

    @Override // b.a.q0.s.h0.c.c
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13127b) {
            return;
        }
        stop();
        this.f13127b = true;
        this.f13126a = false;
    }

    @Override // b.a.q0.s.h0.c.c
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f13128c = -1;
            if (!this.f13126a) {
                this.f13127b = true;
                reset();
                try {
                    setDataSource(str);
                    j(h.f2076b);
                    try {
                        prepare();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        this.f13128c = 2;
                        return false;
                    } catch (IllegalStateException unused) {
                        this.f13128c = 1;
                        return false;
                    }
                } catch (IOException unused2) {
                    this.f13128c = 2;
                    return false;
                } catch (IllegalArgumentException unused3) {
                    this.f13128c = 0;
                    return false;
                } catch (IllegalStateException unused4) {
                    this.f13128c = 1;
                    return false;
                }
            }
            this.f13126a = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.q0.s.h0.c.c
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13128c : invokeV.intValue;
    }

    @Override // b.a.q0.s.h0.c.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13126a : invokeV.booleanValue;
    }

    @Override // b.a.q0.s.h0.c.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pause();
        }
    }

    @Override // b.a.q0.s.h0.c.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            reset();
            this.f13126a = false;
            this.f13127b = true;
            this.f13128c = -1;
        }
    }

    @Override // b.a.q0.s.h0.c.c
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getCurrentPosition() : invokeV.intValue;
    }

    @Override // b.a.q0.s.h0.c.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            start();
            this.f13127b = false;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            setAudioStreamType(i2);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            try {
                seekTo(i2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // b.a.q0.s.h0.c.c
    public void seek(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            k(i2);
        }
    }
}
