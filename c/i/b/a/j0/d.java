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
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WindowManager a;

    /* renamed from: b  reason: collision with root package name */
    public final b f29801b;

    /* renamed from: c  reason: collision with root package name */
    public final a f29802c;

    /* renamed from: d  reason: collision with root package name */
    public long f29803d;

    /* renamed from: e  reason: collision with root package name */
    public long f29804e;

    /* renamed from: f  reason: collision with root package name */
    public long f29805f;

    /* renamed from: g  reason: collision with root package name */
    public long f29806g;

    /* renamed from: h  reason: collision with root package name */
    public long f29807h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29808i;

    /* renamed from: j  reason: collision with root package name */
    public long f29809j;
    public long k;
    public long l;

    @TargetApi(17)
    /* loaded from: classes9.dex */
    public final class a implements DisplayManager.DisplayListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DisplayManager a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f29810b;

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
            this.f29810b = dVar;
            this.a = displayManager;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.registerDisplayListener(this, null);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.unregisterDisplayListener(this);
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
                this.f29810b.h();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements Choreographer.FrameCallback, Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: j  reason: collision with root package name */
        public static final b f29811j;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile long f29812e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f29813f;

        /* renamed from: g  reason: collision with root package name */
        public final HandlerThread f29814g;

        /* renamed from: h  reason: collision with root package name */
        public Choreographer f29815h;

        /* renamed from: i  reason: collision with root package name */
        public int f29816i;

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
            f29811j = new b();
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
            this.f29812e = -9223372036854775807L;
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.f29814g = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.f29814g.getLooper(), this);
            this.f29813f = handler;
            handler.sendEmptyMessage(0);
        }

        public static b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f29811j : (b) invokeV.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29813f.sendEmptyMessage(1);
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.f29816i + 1;
                this.f29816i = i2;
                if (i2 == 1) {
                    this.f29815h.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f29815h = Choreographer.getInstance();
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
                this.f29812e = j2;
                this.f29815h.postFrameCallbackDelayed(this, 500L);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f29813f.sendEmptyMessage(2);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i2 = this.f29816i - 1;
                this.f29816i = i2;
                if (i2 == 0) {
                    this.f29815h.removeFrameCallback(this);
                    this.f29812e = -9223372036854775807L;
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
        this.a = windowManager;
        if (windowManager != null) {
            this.f29802c = v.a >= 17 ? g(context) : null;
            this.f29801b = b.d();
        } else {
            this.f29802c = null;
            this.f29801b = null;
        }
        this.f29803d = -9223372036854775807L;
        this.f29804e = -9223372036854775807L;
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
            if (this.f29808i) {
                if (j2 != this.f29805f) {
                    this.l++;
                    this.f29806g = this.f29807h;
                }
                long j7 = this.l;
                if (j7 >= 6) {
                    j5 = this.f29806g + ((j6 - this.k) / j7);
                    if (f(j5, j3)) {
                        this.f29808i = false;
                    } else {
                        j4 = (this.f29809j + j5) - this.k;
                        if (!this.f29808i) {
                            this.k = j6;
                            this.f29809j = j3;
                            this.l = 0L;
                            this.f29808i = true;
                        }
                        this.f29805f = j2;
                        this.f29807h = j5;
                        bVar = this.f29801b;
                        if (bVar != null || this.f29803d == -9223372036854775807L) {
                            return j4;
                        }
                        long j8 = bVar.f29812e;
                        return j8 == -9223372036854775807L ? j4 : c(j4, j8, this.f29803d) - this.f29804e;
                    }
                } else if (f(j6, j3)) {
                    this.f29808i = false;
                }
            }
            j4 = j3;
            j5 = j6;
            if (!this.f29808i) {
            }
            this.f29805f = j2;
            this.f29807h = j5;
            bVar = this.f29801b;
            if (bVar != null) {
            }
            return j4;
        }
        return invokeCommon.longValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        a aVar = this.f29802c;
        if (aVar != null) {
            aVar.b();
        }
        this.f29801b.e();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29808i = false;
            if (this.a != null) {
                this.f29801b.a();
                a aVar = this.f29802c;
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? Math.abs((j3 - this.f29809j) - (j2 - this.k)) > 20000000 : invokeCommon.booleanValue;
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (defaultDisplay = this.a.getDefaultDisplay()) == null) {
            return;
        }
        long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
        this.f29803d = refreshRate;
        this.f29804e = (refreshRate * 80) / 100;
    }
}
