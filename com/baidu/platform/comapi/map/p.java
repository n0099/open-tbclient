package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class p implements aq {
    public static /* synthetic */ Interceptable $ic;
    public static boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public AppBaseMap e;
    public boolean f;
    public ak g;
    public WeakReference<MapSurfaceView> h;
    public WeakReference<h> i;
    public c j;
    public volatile boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public Bitmap.Config p;
    public e q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public long v;
    public boolean w;
    public volatile boolean x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(533995814, "Lcom/baidu/platform/comapi/map/p;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(533995814, "Lcom/baidu/platform/comapi/map/p;");
        }
    }

    public p(h hVar, ak akVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, akVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = null;
        this.f = false;
        this.k = false;
        this.v = 0L;
        this.w = false;
        this.x = false;
        this.c = 0;
        this.i = new WeakReference<>(hVar);
        this.g = akVar;
    }

    public p(WeakReference<MapSurfaceView> weakReference, ak akVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {weakReference, akVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = null;
        this.f = false;
        this.k = false;
        this.v = 0L;
        this.w = false;
        this.x = false;
        this.c = 0;
        this.g = akVar;
        this.h = weakReference;
    }

    private void b(Object obj) {
        h hVar;
        int i;
        int i2;
        MapSurfaceView mapSurfaceView;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj) != null) || this.j == null) {
            return;
        }
        WeakReference<MapSurfaceView> weakReference = this.h;
        if (weakReference != null && (mapSurfaceView = weakReference.get()) != null && (i3 = this.l) > 0 && (i4 = this.m) > 0) {
            com.baidu.platform.comapi.util.j.a(new r(this, mapSurfaceView.captureImageFromSurface(this.n, this.o, i3, i4, obj, this.p)), 0L);
        }
        WeakReference<h> weakReference2 = this.i;
        if (weakReference2 != null && (hVar = weakReference2.get()) != null && (i = this.l) > 0 && (i2 = this.m) > 0) {
            com.baidu.platform.comapi.util.j.a(new s(this, hVar.captureImageFromSurface(this.n, this.o, i, i2, obj, this.p)), 0L);
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.e != null && this.f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.x = false;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.x = true;
        }
    }

    @Override // com.baidu.platform.comapi.map.aq
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            AppBaseMap appBaseMap = this.e;
            if (appBaseMap != null) {
                appBaseMap.renderResize(i, i2);
            }
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b a = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
                a.a("BasicMap onSurfaceChanged width = " + i + "; height = " + i2);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.aq
    public void a(SurfaceHolder surfaceHolder) {
        Surface surface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
            if (surfaceHolder != null) {
                surface = surfaceHolder.getSurface();
            } else {
                surface = null;
            }
            AppBaseMap appBaseMap = this.e;
            if (appBaseMap != null) {
                appBaseMap.surfaceDestroyed(surface);
            }
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onSurfaceDestroyed");
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.aq
    public void a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, surfaceHolder, i, i2, i3) == null) {
            this.r = false;
            this.s = 0;
            this.u = 0;
            this.t = 0;
            if (!c()) {
                return;
            }
            Surface surface = null;
            if (surfaceHolder != null) {
                surface = surfaceHolder.getSurface();
            }
            this.e.renderInit(i, i2, surface, i3);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onSurfaceCreated ok");
            }
        }
    }

    public void a(c cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, cVar, i, i2) == null) {
            this.k = true;
            this.j = cVar;
            this.l = i;
            this.m = i2;
            this.p = null;
        }
    }

    public void a(c cVar, int i, int i2, int i3, int i4, Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{cVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), config}) == null) {
            this.k = true;
            this.j = cVar;
            this.n = i;
            this.o = i2;
            this.l = i3;
            this.m = i4;
            this.p = config;
        }
    }

    public void a(c cVar, int i, int i2, Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cVar, Integer.valueOf(i), Integer.valueOf(i2), config}) == null) {
            this.k = true;
            this.j = cVar;
            this.l = i;
            this.m = i2;
            this.p = config;
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.q = eVar;
        }
    }

    public void a(AppBaseMap appBaseMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, appBaseMap) == null) {
            this.e = appBaseMap;
        }
    }

    @Override // com.baidu.platform.comapi.map.aq
    public void a(Object obj) {
        e eVar;
        h hVar;
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, obj) != null) || !c()) {
            return;
        }
        boolean z = true;
        if (!this.w) {
            this.w = true;
            WeakReference<MapSurfaceView> weakReference = this.h;
            if (weakReference != null && (mapSurfaceView2 = weakReference.get()) != null) {
                mapSurfaceView2.post(new q(this, mapSurfaceView2));
            }
        }
        if (d) {
            d = false;
        } else if (!this.x) {
            int Draw = this.e.Draw();
            WeakReference<MapSurfaceView> weakReference2 = this.h;
            if (weakReference2 != null && (mapSurfaceView = weakReference2.get()) != null) {
                if (Draw == 1) {
                    mapSurfaceView.requestRender();
                } else if (mapSurfaceView.getRenderMode() != 0) {
                    mapSurfaceView.setRenderMode(0);
                }
            }
            WeakReference<h> weakReference3 = this.i;
            if (weakReference3 != null && (hVar = weakReference3.get()) != null) {
                if (Draw == 1) {
                    hVar.requestRender();
                } else if (hVar.getRenderMode() != 0) {
                    hVar.setRenderMode(0);
                }
            }
            if (this.k) {
                this.k = false;
                if (this.j != null) {
                    b(obj);
                }
            }
            if (!this.r) {
                int i = this.s + 1;
                this.s = i;
                if (i == 2 && (eVar = this.q) != null) {
                    eVar.a();
                    if (OpenLogUtil.isMapLogEnable()) {
                        com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onDrawFirstFrame");
                    }
                }
                if (this.s != 2) {
                    z = false;
                }
                this.r = z;
            }
            WeakReference<MapSurfaceView> weakReference4 = this.h;
            if (weakReference4 != null && weakReference4.get() != null && this.h.get().getBaseMap() != null && this.h.get().getBaseMap().h != null) {
                for (al alVar : this.h.get().getBaseMap().h) {
                    if (this.h.get().getBaseMap() == null) {
                        return;
                    }
                    com.baidu.mapsdkplatform.comapi.map.x J = this.h.get().getBaseMap().J();
                    if (alVar != null) {
                        alVar.a((GL10) null, J);
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f = z;
        }
    }
}
