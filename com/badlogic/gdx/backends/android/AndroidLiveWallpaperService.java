package com.badlogic.gdx.backends.android;

import android.app.WallpaperColors;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tieba.b2;
import com.baidu.tieba.d7;
import com.baidu.tieba.e3;
import com.baidu.tieba.n2;
import com.baidu.tieba.u2;
import com.baidu.tieba.v0;
import com.baidu.tieba.y0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class AndroidLiveWallpaperService extends WallpaperService {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "WallpaperService";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile n2 app;
    public int engines;
    public volatile boolean isPreviewNotified;
    public volatile a linkedEngine;
    public volatile boolean notifiedPreviewState;
    public volatile int[] sync;

    /* renamed from: view  reason: collision with root package name */
    public SurfaceHolder.Callback f1029view;
    public int viewFormat;
    public int viewHeight;
    public int viewWidth;
    public int visibleEngines;

    /* loaded from: classes.dex */
    public class a extends WallpaperService.Engine {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public int f;
        public int g;
        public boolean h;
        public float i;
        public float j;
        public float k;
        public float l;
        public int m;
        public int n;
        public final /* synthetic */ AndroidLiveWallpaperService o;

        /* renamed from: com.badlogic.gdx.backends.android.AndroidLiveWallpaperService$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0005a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0005a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.a.o.sync) {
                        if (this.a.o.linkedEngine == this.a) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        a aVar = this.a;
                        ((u2) this.a.o.app.g).b(aVar.f, aVar.g);
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.a.o.sync) {
                        if (this.a.o.linkedEngine == this.a) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        u2 u2Var = (u2) this.a.o.app.g;
                        a aVar = this.a;
                        u2Var.a(aVar.i, aVar.j, aVar.k, aVar.l, aVar.m, aVar.n);
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ a b;

            public c(a aVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                n2 n2Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.b.o.sync) {
                        z = true;
                        if (this.b.o.isPreviewNotified && this.b.o.notifiedPreviewState == this.a) {
                            z = false;
                        }
                        this.b.o.notifiedPreviewState = this.a;
                        this.b.o.isPreviewNotified = true;
                    }
                    if (z && (n2Var = this.b.o.app) != null) {
                        ((u2) n2Var.g).c(this.a);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AndroidLiveWallpaperService androidLiveWallpaperService) {
            super(androidLiveWallpaperService);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidLiveWallpaperService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((WallpaperService) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = androidLiveWallpaperService;
            this.a = false;
            this.e = true;
            this.h = true;
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0;
            this.n = 0;
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidWallpaperEngine() " + hashCode());
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
            SurfaceHolder.Callback callback;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, surfaceHolder) == null) {
                boolean z = true;
                this.o.engines--;
                if (AndroidLiveWallpaperService.DEBUG) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" > AndroidWallpaperEngine - onSurfaceDestroyed() ");
                    sb.append(hashCode());
                    sb.append(", running: ");
                    sb.append(this.o.engines);
                    sb.append(" ,linked: ");
                    if (this.o.linkedEngine != this) {
                        z = false;
                    }
                    sb.append(z);
                    sb.append(", isVisible: ");
                    sb.append(this.a);
                    Log.d(AndroidLiveWallpaperService.TAG, sb.toString());
                }
                Log.i(AndroidLiveWallpaperService.TAG, "engine surface destroyed");
                AndroidLiveWallpaperService androidLiveWallpaperService = this.o;
                if (androidLiveWallpaperService.engines == 0) {
                    androidLiveWallpaperService.onDeepPauseApplication();
                }
                if (this.o.linkedEngine == this && (callback = this.o.f1029view) != null) {
                    callback.surfaceDestroyed(surfaceHolder);
                }
                this.b = 0;
                this.c = 0;
                this.d = 0;
                AndroidLiveWallpaperService androidLiveWallpaperService2 = this.o;
                if (androidLiveWallpaperService2.engines == 0) {
                    androidLiveWallpaperService2.linkedEngine = null;
                }
                super.onSurfaceDestroyed(surfaceHolder);
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onVisibilityChanged(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
                boolean isVisible = isVisible();
                if (AndroidLiveWallpaperService.DEBUG) {
                    Log.d(AndroidLiveWallpaperService.TAG, " > AndroidWallpaperEngine - onVisibilityChanged(paramVisible: " + z + " reportedVisible: " + isVisible + ") " + hashCode() + ", sufcace valid: " + getSurfaceHolder().getSurface().isValid());
                }
                super.onVisibilityChanged(z);
                if (!isVisible && z) {
                    if (AndroidLiveWallpaperService.DEBUG) {
                        Log.d(AndroidLiveWallpaperService.TAG, " > fake visibilityChanged event! Android WallpaperService likes do that!");
                        return;
                    }
                    return;
                }
                e(z);
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.o.linkedEngine == this && (this.o.app.g instanceof u2) && !this.e) {
                this.e = true;
                this.o.app.postRunnable(new RunnableC0005a(this));
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                super.onDestroy();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.o.linkedEngine == this && (this.o.app.g instanceof u2) && !this.h) {
                this.h = true;
                this.o.app.postRunnable(new b(this));
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.o.linkedEngine == this && (this.o.app.g instanceof u2)) {
                this.o.app.postRunnable(new c(this, this.o.linkedEngine.isPreview()));
            }
        }

        public final void d(int i, int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
                if (!z) {
                    AndroidLiveWallpaperService androidLiveWallpaperService = this.o;
                    if (i == androidLiveWallpaperService.viewFormat && i2 == androidLiveWallpaperService.viewWidth && i3 == androidLiveWallpaperService.viewHeight) {
                        if (AndroidLiveWallpaperService.DEBUG) {
                            Log.d(AndroidLiveWallpaperService.TAG, " > surface is current, skipping surfaceChanged event");
                            return;
                        }
                        return;
                    }
                }
                this.b = i;
                this.c = i2;
                this.d = i3;
                if (this.o.linkedEngine == this) {
                    AndroidLiveWallpaperService androidLiveWallpaperService2 = this.o;
                    androidLiveWallpaperService2.viewFormat = this.b;
                    androidLiveWallpaperService2.viewWidth = this.c;
                    androidLiveWallpaperService2.viewHeight = this.d;
                    SurfaceHolder.Callback callback = androidLiveWallpaperService2.f1029view;
                    SurfaceHolder surfaceHolder = getSurfaceHolder();
                    AndroidLiveWallpaperService androidLiveWallpaperService3 = this.o;
                    callback.surfaceChanged(surfaceHolder, androidLiveWallpaperService3.viewFormat, androidLiveWallpaperService3.viewWidth, androidLiveWallpaperService3.viewHeight);
                } else if (AndroidLiveWallpaperService.DEBUG) {
                    Log.d(AndroidLiveWallpaperService.TAG, " > engine is not active, skipping surfaceChanged event");
                }
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048588, this, surfaceHolder, i, i2, i3) == null) {
                if (AndroidLiveWallpaperService.DEBUG) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" > AndroidWallpaperEngine - onSurfaceChanged() isPreview: ");
                    sb.append(isPreview());
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(hashCode());
                    sb.append(", running: ");
                    sb.append(this.o.engines);
                    sb.append(", linked: ");
                    if (this.o.linkedEngine == this) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    sb.append(", sufcace valid: ");
                    sb.append(getSurfaceHolder().getSurface().isValid());
                    Log.d(AndroidLiveWallpaperService.TAG, sb.toString());
                }
                Log.i(AndroidLiveWallpaperService.TAG, "engine surface changed");
                super.onSurfaceChanged(surfaceHolder, i, i2, i3);
                d(i, i2, i3, true);
            }
        }

        public final void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                if (this.a != z) {
                    this.a = z;
                    if (z) {
                        g();
                    } else {
                        f();
                    }
                } else if (AndroidLiveWallpaperService.DEBUG) {
                    Log.d(AndroidLiveWallpaperService.TAG, " > visible state is current, skipping visibilityChanged event!");
                }
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onTouchEvent(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048591, this, motionEvent) == null) && this.o.linkedEngine == this) {
                this.o.app.c.onTouch(null, motionEvent);
            }
        }

        public void f() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.o.visibleEngines--;
                if (AndroidLiveWallpaperService.DEBUG) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" > AndroidWallpaperEngine - onPause() ");
                    sb.append(hashCode());
                    sb.append(", running: ");
                    sb.append(this.o.engines);
                    sb.append(", linked: ");
                    if (this.o.linkedEngine == this) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    sb.append(", visible: ");
                    sb.append(this.o.visibleEngines);
                    Log.d(AndroidLiveWallpaperService.TAG, sb.toString());
                }
                Log.i(AndroidLiveWallpaperService.TAG, "engine paused");
                AndroidLiveWallpaperService androidLiveWallpaperService = this.o;
                if (androidLiveWallpaperService.visibleEngines >= androidLiveWallpaperService.engines) {
                    Log.e(AndroidLiveWallpaperService.TAG, "wallpaper lifecycle error, counted too many visible engines! repairing..");
                    AndroidLiveWallpaperService androidLiveWallpaperService2 = this.o;
                    androidLiveWallpaperService2.visibleEngines = Math.max(androidLiveWallpaperService2.engines - 1, 0);
                }
                if (this.o.linkedEngine != null) {
                    AndroidLiveWallpaperService androidLiveWallpaperService3 = this.o;
                    if (androidLiveWallpaperService3.visibleEngines == 0) {
                        androidLiveWallpaperService3.app.i();
                    }
                }
                if (AndroidLiveWallpaperService.DEBUG) {
                    Log.d(AndroidLiveWallpaperService.TAG, " > AndroidWallpaperEngine - onPause() done!");
                }
            }
        }

        public void g() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.o.visibleEngines++;
                if (AndroidLiveWallpaperService.DEBUG) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" > AndroidWallpaperEngine - onResume() ");
                    sb.append(hashCode());
                    sb.append(", running: ");
                    sb.append(this.o.engines);
                    sb.append(", linked: ");
                    if (this.o.linkedEngine == this) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    sb.append(", visible: ");
                    sb.append(this.o.visibleEngines);
                    Log.d(AndroidLiveWallpaperService.TAG, sb.toString());
                }
                Log.i(AndroidLiveWallpaperService.TAG, "engine resumed");
                if (this.o.linkedEngine != null) {
                    if (this.o.linkedEngine != this) {
                        this.o.setLinkedEngine(this);
                        this.o.f1029view.surfaceDestroyed(getSurfaceHolder());
                        d(this.b, this.c, this.d, false);
                        this.o.f1029view.surfaceCreated(getSurfaceHolder());
                    } else {
                        d(this.b, this.c, this.d, false);
                    }
                    AndroidLiveWallpaperService androidLiveWallpaperService = this.o;
                    if (androidLiveWallpaperService.visibleEngines == 1) {
                        androidLiveWallpaperService.app.j();
                    }
                    c();
                    b();
                    if (!y0.b.d()) {
                        y0.b.c();
                    }
                }
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public Bundle onCommand(String str, int i, int i2, int i3, Bundle bundle, boolean z) {
            InterceptResult invokeCommon;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bundle, Boolean.valueOf(z)})) == null) {
                if (AndroidLiveWallpaperService.DEBUG) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" > AndroidWallpaperEngine - onCommand(");
                    sb.append(str);
                    sb.append(" ");
                    sb.append(i);
                    sb.append(" ");
                    sb.append(i2);
                    sb.append(" ");
                    sb.append(i3);
                    sb.append(" ");
                    sb.append(bundle);
                    sb.append(" ");
                    sb.append(z);
                    sb.append("), linked: ");
                    if (this.o.linkedEngine == this) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    sb.append(z2);
                    Log.d(AndroidLiveWallpaperService.TAG, sb.toString());
                }
                if (str.equals("android.home.drop")) {
                    this.e = false;
                    this.f = i;
                    this.g = i2;
                    a();
                }
                return super.onCommand(str, i, i2, i3, bundle, z);
            }
            return (Bundle) invokeCommon.objValue;
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public WallpaperColors onComputeColors() {
            InterceptResult invokeV;
            e3[] e3VarArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Application application = y0.a;
                if (Build.VERSION.SDK_INT >= 27 && (application instanceof n2) && (e3VarArr = ((n2) application).n) != null) {
                    return new WallpaperColors(Color.valueOf(e3VarArr[0].a, e3VarArr[0].b, e3VarArr[0].c, e3VarArr[0].d), Color.valueOf(e3VarArr[1].a, e3VarArr[1].b, e3VarArr[1].c, e3VarArr[1].d), Color.valueOf(e3VarArr[2].a, e3VarArr[2].b, e3VarArr[2].c, e3VarArr[2].d));
                }
                return super.onComputeColors();
            }
            return (WallpaperColors) invokeV.objValue;
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onCreate(SurfaceHolder surfaceHolder) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, surfaceHolder) == null) {
                if (AndroidLiveWallpaperService.DEBUG) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" > AndroidWallpaperEngine - onCreate() ");
                    sb.append(hashCode());
                    sb.append(" running: ");
                    sb.append(this.o.engines);
                    sb.append(", linked: ");
                    if (this.o.linkedEngine == this) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    sb.append(", thread: ");
                    sb.append(Thread.currentThread().toString());
                    Log.d(AndroidLiveWallpaperService.TAG, sb.toString());
                }
                super.onCreate(surfaceHolder);
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onOffsetsChanged(float f, float f2, float f3, float f4, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                this.h = false;
                this.i = f;
                this.j = f2;
                this.k = f3;
                this.l = f4;
                this.m = i;
                this.n = i2;
                b();
                if (!y0.b.d()) {
                    y0.b.c();
                }
                super.onOffsetsChanged(f, f2, f3, f4, i, i2);
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
                AndroidLiveWallpaperService androidLiveWallpaperService = this.o;
                androidLiveWallpaperService.engines++;
                androidLiveWallpaperService.setLinkedEngine(this);
                if (AndroidLiveWallpaperService.DEBUG) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" > AndroidWallpaperEngine - onSurfaceCreated() ");
                    sb.append(hashCode());
                    sb.append(", running: ");
                    sb.append(this.o.engines);
                    sb.append(", linked: ");
                    if (this.o.linkedEngine == this) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    Log.d(AndroidLiveWallpaperService.TAG, sb.toString());
                }
                Log.i(AndroidLiveWallpaperService.TAG, "engine surface created");
                super.onSurfaceCreated(surfaceHolder);
                AndroidLiveWallpaperService androidLiveWallpaperService2 = this.o;
                if (androidLiveWallpaperService2.engines == 1) {
                    androidLiveWallpaperService2.visibleEngines = 0;
                }
                AndroidLiveWallpaperService androidLiveWallpaperService3 = this.o;
                if (androidLiveWallpaperService3.engines == 1 && androidLiveWallpaperService3.app == null) {
                    AndroidLiveWallpaperService androidLiveWallpaperService4 = this.o;
                    androidLiveWallpaperService4.viewFormat = 0;
                    androidLiveWallpaperService4.viewWidth = 0;
                    androidLiveWallpaperService4.viewHeight = 0;
                    androidLiveWallpaperService4.app = new n2(this.o);
                    this.o.onCreateApplication();
                    if (this.o.app.b == null) {
                        throw new Error("You must override 'AndroidLiveWallpaperService.onCreateApplication' method and call 'initialize' from its body.");
                    }
                }
                AndroidLiveWallpaperService androidLiveWallpaperService5 = this.o;
                androidLiveWallpaperService5.f1029view = androidLiveWallpaperService5.app.b.a;
                getSurfaceHolder().removeCallback(this.o.f1029view);
                AndroidLiveWallpaperService androidLiveWallpaperService6 = this.o;
                this.b = androidLiveWallpaperService6.viewFormat;
                this.c = androidLiveWallpaperService6.viewWidth;
                this.d = androidLiveWallpaperService6.viewHeight;
                if (androidLiveWallpaperService6.engines == 1) {
                    androidLiveWallpaperService6.f1029view.surfaceCreated(surfaceHolder);
                } else {
                    androidLiveWallpaperService6.f1029view.surfaceDestroyed(surfaceHolder);
                    d(this.b, this.c, this.d, false);
                    this.o.f1029view.surfaceCreated(surfaceHolder);
                }
                c();
                b();
                if (!y0.b.d()) {
                    y0.b.c();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1147232173, "Lcom/badlogic/gdx/backends/android/AndroidLiveWallpaperService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1147232173, "Lcom/badlogic/gdx/backends/android/AndroidLiveWallpaperService;");
                return;
            }
        }
        d7.a();
        DEBUG = false;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.i(TAG, "service finalized");
            super.finalize();
        }
    }

    public n2 getLiveWallpaper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.app;
        }
        return (n2) invokeV.objValue;
    }

    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (WindowManager) getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        }
        return (WindowManager) invokeV.objValue;
    }

    public void onCreateApplication() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && DEBUG) {
            Log.d(TAG, " > AndroidLiveWallpaperService - onCreateApplication()");
        }
    }

    @Override // android.service.wallpaper.WallpaperService
    public WallpaperService.Engine onCreateEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (DEBUG) {
                Log.d(TAG, " > AndroidLiveWallpaperService - onCreateEngine()");
            }
            Log.i(TAG, "engine created");
            return new a(this);
        }
        return (WallpaperService.Engine) invokeV.objValue;
    }

    public void onDeepPauseApplication() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (DEBUG) {
                Log.d(TAG, " > AndroidLiveWallpaperService - onDeepPauseApplication()");
            }
            if (this.app != null) {
                this.app.b.h();
            }
        }
    }

    public AndroidLiveWallpaperService() {
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
        this.app = null;
        this.f1029view = null;
        this.engines = 0;
        this.visibleEngines = 0;
        this.linkedEngine = null;
        this.isPreviewNotified = false;
        this.notifiedPreviewState = false;
        this.sync = new int[0];
    }

    public SurfaceHolder getSurfaceHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (DEBUG) {
                Log.d(TAG, " > AndroidLiveWallpaperService - getSurfaceHolder()");
            }
            synchronized (this.sync) {
                if (this.linkedEngine == null) {
                    return null;
                }
                return this.linkedEngine.getSurfaceHolder();
            }
        }
        return (SurfaceHolder) invokeV.objValue;
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (DEBUG) {
                Log.d(TAG, " > AndroidLiveWallpaperService - onCreate() " + hashCode());
            }
            Log.i(TAG, "service created");
            super.onCreate();
        }
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (DEBUG) {
                Log.d(TAG, " > AndroidLiveWallpaperService - onDestroy() " + hashCode());
            }
            Log.i(TAG, "service destroyed");
            super.onDestroy();
            if (this.app != null) {
                this.app.h();
                this.app = null;
                this.f1029view = null;
            }
        }
    }

    public void initialize(v0 v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v0Var) == null) {
            initialize(v0Var, new b2());
        }
    }

    public void setLinkedEngine(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            synchronized (this.sync) {
                this.linkedEngine = aVar;
            }
        }
    }

    public void initialize(v0 v0Var, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, v0Var, b2Var) == null) {
            if (DEBUG) {
                Log.d(TAG, " > AndroidLiveWallpaperService - initialize()");
            }
            this.app.g(v0Var, b2Var);
            if (b2Var.s && Integer.parseInt(Build.VERSION.SDK) >= 7) {
                this.linkedEngine.setTouchEventsEnabled(true);
            }
        }
    }
}
