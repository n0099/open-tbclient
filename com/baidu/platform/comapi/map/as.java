package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.ai;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class as implements ah {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aq a;
    public boolean b;
    public int c;
    public a d;
    public boolean e;
    public final WeakReference<as> f;
    public WeakReference<SurfaceView> g;
    public int h;

    @Override // com.baidu.platform.comapi.map.ah
    public Bitmap a(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj, config})) == null) {
            return null;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, surfaceHolder) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as a;
        public WeakReference<as> b;
        public Object c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public int i;
        public int j;
        public int k;
        public boolean l;
        public aq m;
        public SurfaceHolder n;
        public ArrayList<Runnable> o;
        public Runnable p;
        public AtomicBoolean q;
        public long r;

        public a(as asVar, WeakReference<as> weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {asVar, weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = asVar;
            this.c = new Object();
            this.f = false;
            this.h = false;
            this.o = new ArrayList<>();
            this.q = new AtomicBoolean(false);
            this.r = 0L;
            this.d = false;
            this.i = 0;
            this.j = 0;
            this.l = true;
            this.k = 1;
            this.b = weakReference;
            as asVar2 = weakReference.get();
            this.m = asVar2.a;
            SurfaceHolder a = asVar2.a();
            this.n = a;
            this.r = VulkanDetect.getNativeWindow(a.getSurface());
            setPriority(10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
            r3 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
            if (r7.p == null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006e, code lost:
            r0 = r7.p;
            r7.p = null;
            r3 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
            if (r1 <= 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
            if (r2 <= 0) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0077, code lost:
            r0 = java.lang.System.currentTimeMillis();
            r7.m.a(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
            if (r3 == null) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0082, code lost:
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0085, code lost:
            r2 = ((com.baidu.platform.comapi.map.as) r7.a.f.get()).e();
            r3 = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:
            if (r2 >= 60) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x009d, code lost:
            if (r2 <= 0) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x009f, code lost:
            r5 = (1000 / r2) - (r3 - r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00a9, code lost:
            if (r5 <= 1) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00ab, code lost:
            r0 = r7.c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ad, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00ae, code lost:
            r7.c.wait(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
            monitor-exit(r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void f() throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                while (true) {
                    try {
                        if (this.d) {
                            break;
                        }
                        synchronized (this.c) {
                            while (true) {
                                Runnable h = h();
                                if (h == null) {
                                    break;
                                }
                                h.run();
                            }
                            while (g()) {
                                if (!this.f && !this.g) {
                                    this.g = true;
                                    this.c.notifyAll();
                                }
                                if (this.a.e && !this.h) {
                                    this.h = true;
                                    this.c.notifyAll();
                                }
                                this.c.wait();
                            }
                            if (this.d) {
                                break;
                            }
                            boolean unused = this.a.e;
                            int i = this.i;
                            int i2 = this.j;
                            this.a.e = false;
                            this.h = false;
                            this.l = false;
                            if (this.f && this.g) {
                                this.g = false;
                            }
                        }
                    } finally {
                        Log.i("VulkanSurfaceView", "destroySurface");
                    }
                }
            }
        }

        private boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.d) {
                    return false;
                }
                if (!this.e && this.f && !this.a.e && this.i > 0 && this.j > 0 && (this.l || this.k == 1)) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        private Runnable h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                synchronized (this) {
                    if (this.o.size() > 0) {
                        return this.o.remove(0);
                    }
                    return null;
                }
            }
            return (Runnable) invokeV.objValue;
        }

        public int a() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.c) {
                    i = this.k;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                synchronized (this.c) {
                    this.l = true;
                    this.c.notifyAll();
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (this.c) {
                    this.e = true;
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                synchronized (this.c) {
                    this.e = false;
                    this.c.notifyAll();
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                synchronized (this.c) {
                    this.d = true;
                    this.c.notifyAll();
                }
                try {
                    join();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                setName("VkThread " + getId());
                try {
                    f();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i >= 0 && i <= 1) {
                    synchronized (this.c) {
                        this.k = i;
                        if (i == 1) {
                            this.c.notifyAll();
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("renderMode");
            }
        }

        public void b(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, runnable) == null) {
                synchronized (this) {
                    this.o.add(runnable);
                }
            }
        }

        public void a(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
                synchronized (this.c) {
                    long nativeWindow = VulkanDetect.getNativeWindow(surfaceHolder.getSurface());
                    if (this.r != nativeWindow) {
                        this.r = nativeWindow;
                        this.q.set(true);
                        this.m.a(surfaceHolder, 1, 1, 1);
                    }
                    this.f = true;
                    this.c.notifyAll();
                }
            }
        }

        public void b(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, surfaceHolder) == null) {
                synchronized (this.c) {
                    this.f = false;
                    this.c.notifyAll();
                    while (!this.g && isAlive()) {
                        try {
                            this.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    this.m.a(surfaceHolder);
                }
            }
        }

        public void a(SurfaceHolder surfaceHolder, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, surfaceHolder, i, i2) == null) {
                synchronized (this.c) {
                    this.i = i;
                    this.j = i2;
                    this.a.e = true;
                    this.c.notifyAll();
                    while (!this.h && isAlive()) {
                        try {
                            this.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    this.m.a(i, i2);
                    this.a.e = false;
                    this.c.notifyAll();
                }
            }
        }

        public void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) {
                synchronized (this.c) {
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    this.l = true;
                    this.p = runnable;
                    this.c.notifyAll();
                }
            }
        }
    }

    public as(SurfaceView surfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surfaceView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.f = new WeakReference<>(this);
        this.a = null;
        this.h = 60;
        this.g = new WeakReference<>(surfaceView);
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.d.a(i);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, surfaceHolder) == null) {
            this.d.a(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, surfaceHolder) == null) {
            this.d.b(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, surfaceHolder, runnable) == null) && (aVar = this.d) != null) {
            aVar.a(runnable);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) || this.d == null) {
            return;
        }
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public SurfaceHolder a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g.get().getHolder();
        }
        return (SurfaceHolder) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public ai.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ai.a.b;
        }
        return (ai.a) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                if (this.d != null) {
                    this.d.e();
                }
            } finally {
                super.finalize();
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d.a();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.d.b();
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d.c();
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.d();
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a aVar = this.d;
            if (aVar != null) {
                aVar.e();
            }
            this.b = true;
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || i <= 0) {
            return;
        }
        if (i > 60) {
            i = 60;
        }
        this.h = i;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.c = i;
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void a(aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aqVar) == null) {
            c();
            this.a = aqVar;
            a aVar = new a(this, this.f);
            this.d = aVar;
            aVar.start();
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) {
            this.d.b(runnable);
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void k() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.b && this.a != null) {
                a aVar = this.d;
                if (aVar != null) {
                    i = aVar.a();
                } else {
                    i = 1;
                }
                a aVar2 = new a(this, this.f);
                this.d = aVar2;
                if (i != 1) {
                    aVar2.a(i);
                }
                this.d.start();
            }
            this.b = false;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048593, this, surfaceHolder, i, i2, i3) == null) {
            this.d.a(surfaceHolder, i2, i3);
        }
    }
}
