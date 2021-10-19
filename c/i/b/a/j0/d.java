package c.i.b.a.j0;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(16)
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WindowManager f33907a;

    /* renamed from: b  reason: collision with root package name */
    public final b f33908b;

    /* renamed from: c  reason: collision with root package name */
    public final a f33909c;

    /* renamed from: d  reason: collision with root package name */
    public long f33910d;

    /* renamed from: e  reason: collision with root package name */
    public long f33911e;

    /* renamed from: f  reason: collision with root package name */
    public long f33912f;

    /* renamed from: g  reason: collision with root package name */
    public long f33913g;

    /* renamed from: h  reason: collision with root package name */
    public long f33914h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33915i;

    /* renamed from: j  reason: collision with root package name */
    public long f33916j;
    public long k;
    public long l;

    @TargetApi(17)
    /* loaded from: classes4.dex */
    public final class a implements DisplayManager.DisplayListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final DisplayManager f33917a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33918b;

        public a(d dVar, DisplayManager displayManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, displayManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33918b = dVar;
            this.f33917a = displayManager;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33917a.registerDisplayListener(this, null);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f33917a.unregisterDisplayListener(this);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && i2 == 0) {
                this.f33918b.h();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements Choreographer.FrameCallback, Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: j  reason: collision with root package name */
        public static final b f33919j;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile long f33920e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f33921f;

        /* renamed from: g  reason: collision with root package name */
        public final HandlerThread f33922g;

        /* renamed from: h  reason: collision with root package name */
        public Choreographer f33923h;

        /* renamed from: i  reason: collision with root package name */
        public int f33924i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1047920759, "Lc/i/b/a/j0/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1047920759, "Lc/i/b/a/j0/d$b;");
                    return;
                }
            }
            f33919j = new b();
        }

        public b() {
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
            this.f33920e = -9223372036854775807L;
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.f33922g = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.f33922g.getLooper(), this);
            this.f33921f = handler;
            handler.sendEmptyMessage(0);
        }

        public static b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f33919j : (b) invokeV.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33921f.sendEmptyMessage(1);
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.f33924i + 1;
                this.f33924i = i2;
                if (i2 == 1) {
                    this.f33923h.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f33923h = Choreographer.getInstance();
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
                this.f33920e = j2;
                this.f33923h.postFrameCallbackDelayed(this, 500L);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f33921f.sendEmptyMessage(2);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i2 = this.f33924i - 1;
                this.f33924i = i2;
                if (i2 == 0) {
                    this.f33923h.removeFrameCallback(this);
                    this.f33920e = -9223372036854775807L;
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    c();
                    return true;
                } else if (i2 == 1) {
                    b();
                    return true;
                } else if (i2 != 2) {
                    return false;
                } else {
                    f();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    public d(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        WindowManager windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        this.f33907a = windowManager;
        if (windowManager != null) {
            this.f33909c = v.f33865a >= 17 ? g(context) : null;
            this.f33908b = b.d();
        } else {
            this.f33909c = null;
            this.f33908b = null;
        }
        this.f33910d = -9223372036854775807L;
        this.f33911e = -9223372036854775807L;
    }

    public static long c(long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        long j5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            long j6 = j3 + (((j2 - j3) / j4) * j4);
            if (j2 <= j6) {
                j5 = j6 - j4;
            } else {
                j6 = j4 + j6;
                j5 = j6;
            }
            return j6 - j2 < j2 - j5 ? j6 : j5;
        }
        return invokeCommon.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(long j2, long j3) {
        InterceptResult invokeCommon;
        long j4;
        long j5;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j6 = 1000 * j2;
            if (this.f33915i) {
                if (j2 != this.f33912f) {
                    this.l++;
                    this.f33913g = this.f33914h;
                }
                long j7 = this.l;
                if (j7 >= 6) {
                    j5 = this.f33913g + ((j6 - this.k) / j7);
                    if (f(j5, j3)) {
                        this.f33915i = false;
                    } else {
                        j4 = (this.f33916j + j5) - this.k;
                        if (!this.f33915i) {
                            this.k = j6;
                            this.f33916j = j3;
                            this.l = 0L;
                            this.f33915i = true;
                        }
                        this.f33912f = j2;
                        this.f33914h = j5;
                        bVar = this.f33908b;
                        if (bVar != null || this.f33910d == -9223372036854775807L) {
                            return j4;
                        }
                        long j8 = bVar.f33920e;
                        return j8 == -9223372036854775807L ? j4 : c(j4, j8, this.f33910d) - this.f33911e;
                    }
                } else if (f(j6, j3)) {
                    this.f33915i = false;
                }
            }
            j4 = j3;
            j5 = j6;
            if (!this.f33915i) {
            }
            this.f33912f = j2;
            this.f33914h = j5;
            bVar = this.f33908b;
            if (bVar != null) {
            }
            return j4;
        }
        return invokeCommon.longValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f33907a == null) {
            return;
        }
        a aVar = this.f33909c;
        if (aVar != null) {
            aVar.b();
        }
        this.f33908b.e();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f33915i = false;
            if (this.f33907a != null) {
                this.f33908b.a();
                a aVar = this.f33909c;
                if (aVar != null) {
                    aVar.a();
                }
                h();
            }
        }
    }

    public final boolean f(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? Math.abs((j3 - this.f33916j) - (j2 - this.k)) > 20000000 : invokeCommon.booleanValue;
    }

    @TargetApi(17)
    public final a g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager == null) {
                return null;
            }
            return new a(this, displayManager);
        }
        return (a) invokeL.objValue;
    }

    public final void h() {
        Display defaultDisplay;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (defaultDisplay = this.f33907a.getDefaultDisplay()) == null) {
            return;
        }
        long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
        this.f33910d = refreshRate;
        this.f33911e = (refreshRate * 80) / 100;
    }
}
