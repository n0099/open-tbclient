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
    public final WindowManager f33880a;

    /* renamed from: b  reason: collision with root package name */
    public final b f33881b;

    /* renamed from: c  reason: collision with root package name */
    public final a f33882c;

    /* renamed from: d  reason: collision with root package name */
    public long f33883d;

    /* renamed from: e  reason: collision with root package name */
    public long f33884e;

    /* renamed from: f  reason: collision with root package name */
    public long f33885f;

    /* renamed from: g  reason: collision with root package name */
    public long f33886g;

    /* renamed from: h  reason: collision with root package name */
    public long f33887h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33888i;

    /* renamed from: j  reason: collision with root package name */
    public long f33889j;
    public long k;
    public long l;

    @TargetApi(17)
    /* loaded from: classes4.dex */
    public final class a implements DisplayManager.DisplayListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final DisplayManager f33890a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33891b;

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
            this.f33891b = dVar;
            this.f33890a = displayManager;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33890a.registerDisplayListener(this, null);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f33890a.unregisterDisplayListener(this);
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
                this.f33891b.h();
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
        public static final b f33892j;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile long f33893e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f33894f;

        /* renamed from: g  reason: collision with root package name */
        public final HandlerThread f33895g;

        /* renamed from: h  reason: collision with root package name */
        public Choreographer f33896h;

        /* renamed from: i  reason: collision with root package name */
        public int f33897i;

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
            f33892j = new b();
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
            this.f33893e = -9223372036854775807L;
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.f33895g = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.f33895g.getLooper(), this);
            this.f33894f = handler;
            handler.sendEmptyMessage(0);
        }

        public static b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f33892j : (b) invokeV.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33894f.sendEmptyMessage(1);
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.f33897i + 1;
                this.f33897i = i2;
                if (i2 == 1) {
                    this.f33896h.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f33896h = Choreographer.getInstance();
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
                this.f33893e = j2;
                this.f33896h.postFrameCallbackDelayed(this, 500L);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f33894f.sendEmptyMessage(2);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i2 = this.f33897i - 1;
                this.f33897i = i2;
                if (i2 == 0) {
                    this.f33896h.removeFrameCallback(this);
                    this.f33893e = -9223372036854775807L;
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
        this.f33880a = windowManager;
        if (windowManager != null) {
            this.f33882c = v.f33838a >= 17 ? g(context) : null;
            this.f33881b = b.d();
        } else {
            this.f33882c = null;
            this.f33881b = null;
        }
        this.f33883d = -9223372036854775807L;
        this.f33884e = -9223372036854775807L;
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
            if (this.f33888i) {
                if (j2 != this.f33885f) {
                    this.l++;
                    this.f33886g = this.f33887h;
                }
                long j7 = this.l;
                if (j7 >= 6) {
                    j5 = this.f33886g + ((j6 - this.k) / j7);
                    if (f(j5, j3)) {
                        this.f33888i = false;
                    } else {
                        j4 = (this.f33889j + j5) - this.k;
                        if (!this.f33888i) {
                            this.k = j6;
                            this.f33889j = j3;
                            this.l = 0L;
                            this.f33888i = true;
                        }
                        this.f33885f = j2;
                        this.f33887h = j5;
                        bVar = this.f33881b;
                        if (bVar != null || this.f33883d == -9223372036854775807L) {
                            return j4;
                        }
                        long j8 = bVar.f33893e;
                        return j8 == -9223372036854775807L ? j4 : c(j4, j8, this.f33883d) - this.f33884e;
                    }
                } else if (f(j6, j3)) {
                    this.f33888i = false;
                }
            }
            j4 = j3;
            j5 = j6;
            if (!this.f33888i) {
            }
            this.f33885f = j2;
            this.f33887h = j5;
            bVar = this.f33881b;
            if (bVar != null) {
            }
            return j4;
        }
        return invokeCommon.longValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f33880a == null) {
            return;
        }
        a aVar = this.f33882c;
        if (aVar != null) {
            aVar.b();
        }
        this.f33881b.e();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f33888i = false;
            if (this.f33880a != null) {
                this.f33881b.a();
                a aVar = this.f33882c;
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? Math.abs((j3 - this.f33889j) - (j2 - this.k)) > 20000000 : invokeCommon.booleanValue;
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (defaultDisplay = this.f33880a.getDefaultDisplay()) == null) {
            return;
        }
        long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
        this.f33883d = refreshRate;
        this.f33884e = (refreshRate * 80) / 100;
    }
}
