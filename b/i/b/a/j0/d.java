package b.i.b.a.j0;

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
import b.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(16)
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WindowManager f32701a;

    /* renamed from: b  reason: collision with root package name */
    public final b f32702b;

    /* renamed from: c  reason: collision with root package name */
    public final a f32703c;

    /* renamed from: d  reason: collision with root package name */
    public long f32704d;

    /* renamed from: e  reason: collision with root package name */
    public long f32705e;

    /* renamed from: f  reason: collision with root package name */
    public long f32706f;

    /* renamed from: g  reason: collision with root package name */
    public long f32707g;

    /* renamed from: h  reason: collision with root package name */
    public long f32708h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32709i;
    public long j;
    public long k;
    public long l;

    @TargetApi(17)
    /* loaded from: classes6.dex */
    public final class a implements DisplayManager.DisplayListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final DisplayManager f32710a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f32711b;

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
            this.f32711b = dVar;
            this.f32710a = displayManager;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32710a.registerDisplayListener(this, null);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f32710a.unregisterDisplayListener(this);
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
                this.f32711b.h();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Choreographer.FrameCallback, Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public static final b j;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile long f32712e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f32713f;

        /* renamed from: g  reason: collision with root package name */
        public final HandlerThread f32714g;

        /* renamed from: h  reason: collision with root package name */
        public Choreographer f32715h;

        /* renamed from: i  reason: collision with root package name */
        public int f32716i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1739494728, "Lb/i/b/a/j0/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1739494728, "Lb/i/b/a/j0/d$b;");
                    return;
                }
            }
            j = new b();
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
            this.f32712e = -9223372036854775807L;
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.f32714g = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.f32714g.getLooper(), this);
            this.f32713f = handler;
            handler.sendEmptyMessage(0);
        }

        public static b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? j : (b) invokeV.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32713f.sendEmptyMessage(1);
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.f32716i + 1;
                this.f32716i = i2;
                if (i2 == 1) {
                    this.f32715h.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f32715h = Choreographer.getInstance();
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
                this.f32712e = j2;
                this.f32715h.postFrameCallbackDelayed(this, 500L);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f32713f.sendEmptyMessage(2);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i2 = this.f32716i - 1;
                this.f32716i = i2;
                if (i2 == 0) {
                    this.f32715h.removeFrameCallback(this);
                    this.f32712e = -9223372036854775807L;
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
        this.f32701a = windowManager;
        if (windowManager != null) {
            this.f32703c = v.f32661a >= 17 ? g(context) : null;
            this.f32702b = b.d();
        } else {
            this.f32703c = null;
            this.f32702b = null;
        }
        this.f32704d = -9223372036854775807L;
        this.f32705e = -9223372036854775807L;
    }

    public static long c(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j5 = j2 + (((j - j2) / j3) * j3);
            if (j <= j5) {
                j4 = j5 - j3;
            } else {
                j5 = j3 + j5;
                j4 = j5;
            }
            return j5 - j < j - j4 ? j5 : j4;
        }
        return invokeCommon.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(long j, long j2) {
        InterceptResult invokeCommon;
        long j3;
        long j4;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j5 = 1000 * j;
            if (this.f32709i) {
                if (j != this.f32706f) {
                    this.l++;
                    this.f32707g = this.f32708h;
                }
                long j6 = this.l;
                if (j6 >= 6) {
                    j4 = this.f32707g + ((j5 - this.k) / j6);
                    if (f(j4, j2)) {
                        this.f32709i = false;
                    } else {
                        j3 = (this.j + j4) - this.k;
                        if (!this.f32709i) {
                            this.k = j5;
                            this.j = j2;
                            this.l = 0L;
                            this.f32709i = true;
                        }
                        this.f32706f = j;
                        this.f32708h = j4;
                        bVar = this.f32702b;
                        if (bVar != null || this.f32704d == -9223372036854775807L) {
                            return j3;
                        }
                        long j7 = bVar.f32712e;
                        return j7 == -9223372036854775807L ? j3 : c(j3, j7, this.f32704d) - this.f32705e;
                    }
                } else if (f(j5, j2)) {
                    this.f32709i = false;
                }
            }
            j3 = j2;
            j4 = j5;
            if (!this.f32709i) {
            }
            this.f32706f = j;
            this.f32708h = j4;
            bVar = this.f32702b;
            if (bVar != null) {
            }
            return j3;
        }
        return invokeCommon.longValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f32701a == null) {
            return;
        }
        a aVar = this.f32703c;
        if (aVar != null) {
            aVar.b();
        }
        this.f32702b.e();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f32709i = false;
            if (this.f32701a != null) {
                this.f32702b.a();
                a aVar = this.f32703c;
                if (aVar != null) {
                    aVar.a();
                }
                h();
            }
        }
    }

    public final boolean f(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? Math.abs((j2 - this.j) - (j - this.k)) > 20000000 : invokeCommon.booleanValue;
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (defaultDisplay = this.f32701a.getDefaultDisplay()) == null) {
            return;
        }
        long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
        this.f32704d = refreshRate;
        this.f32705e = (refreshRate * 80) / 100;
    }
}
