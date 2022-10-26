package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.MapRenderer;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends GLSurfaceView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderer.a {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler b;
    public MapRenderer c;
    public int d;
    public int e;
    public GestureDetector f;
    public e g;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public float c;
        public float d;
        public boolean e;
        public float f;
        public float g;
        public double h;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "MultiTouch{x1=" + this.a + ", x2=" + this.b + ", y1=" + this.c + ", y2=" + this.d + ", mTwoTouch=" + this.e + ", centerX=" + this.f + ", centerY=" + this.g + ", length=" + this.h + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724782282, "Lcom/baidu/mapsdkplatform/comapi/map/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(724782282, "Lcom/baidu/mapsdkplatform/comapi/map/j;");
                return;
            }
        }
        a = j.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, z zVar, String str, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, zVar, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new RuntimeException("BDMapSDKException: when you create an mapview, the context can not be null");
        }
        setEGLContextClientVersion(2);
        this.f = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.g == null) {
            this.g = new e(context, str, i);
        }
        this.g.a(context.hashCode());
        g();
        this.g.a();
        this.g.a(zVar);
        h();
        this.g.a(this.b);
        this.g.f();
        setBackgroundColor(0);
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            return egl10.eglChooseConfig(eglGetDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
        }
        return invokeCommon.booleanValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            try {
                if (a(8, 8, 8, 8, 24, 0)) {
                    setEGLConfigChooser(8, 8, 8, 8, 24, 0);
                } else if (a(5, 6, 5, 0, 24, 0)) {
                    setEGLConfigChooser(5, 6, 5, 0, 24, 0);
                } else {
                    setEGLConfigChooser(true);
                }
            } catch (IllegalArgumentException unused) {
                setEGLConfigChooser(true);
            }
            MapRenderer mapRenderer = new MapRenderer(this, this);
            this.c = mapRenderer;
            mapRenderer.a(this.g.j);
            setRenderer(this.c);
            setRenderMode(1);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.b = new k(this);
        }
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (e) invokeV.objValue;
    }

    public void a(float f, float f2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (eVar = this.g) == null || eVar.i == null) {
            return;
        }
        eVar.b(f, f2);
    }

    public void a(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.g == null) {
            return;
        }
        Message message = new Message();
        message.what = 50;
        message.obj = Long.valueOf(this.g.j);
        boolean q = this.g.q();
        if (i != 3) {
            i2 = q ? 1 : 1;
            this.b.sendMessage(message);
        }
        i2 = 0;
        message.arg1 = i2;
        this.b.sendMessage(message);
    }

    public void a(String str, Rect rect) {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, rect) == null) || (eVar = this.g) == null || (aVar = eVar.i) == null) {
            return;
        }
        if (rect != null) {
            int i = rect.left;
            int i2 = this.e;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i4 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.d) {
                width = Math.abs(rect.width()) - (rect.right - this.d);
            }
            if (height > this.e) {
                height = Math.abs(rect.height()) - (rect.bottom - this.e);
            }
            if (i > SysOSUtil.getScreenSizeX() || i4 > SysOSUtil.getScreenSizeY()) {
                this.g.i.a(str, (Bundle) null);
                requestRender();
                return;
            }
            this.d = width;
            this.e = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i);
            bundle.putInt("y", i4);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.g.i.a(str, bundle);
        } else {
            aVar.a(str, (Bundle) null);
        }
        requestRender();
    }

    public boolean a(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            e eVar = this.g;
            if (eVar == null || eVar.i == null) {
                return false;
            }
            return eVar.a(f, f2, f3, f4);
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.g) == null) {
            return;
        }
        eVar.u();
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            e eVar = this.g;
            if (eVar != null) {
                List<l> list = eVar.h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.f();
                        }
                    }
                }
                this.g.b(this.b);
                this.g.b(i);
                this.g = null;
            }
            Handler handler = this.b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    public boolean b(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            e eVar = this.g;
            if (eVar == null || eVar.i == null) {
                return false;
            }
            return eVar.d(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    public void c() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (eVar = this.g) == null) {
            return;
        }
        eVar.v();
    }

    public boolean c(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            e eVar = this.g;
            if (eVar == null || eVar.i == null) {
                return false;
            }
            return eVar.c(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            getHolder().setFormat(-3);
            this.g.i.s();
        }
    }

    public boolean d(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            e eVar = this.g;
            if (eVar == null || eVar.i == null) {
                return false;
            }
            return eVar.c((int) f, (int) f2);
        }
        return invokeCommon.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            getHolder().setFormat(-1);
            this.g.i.t();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.MapRenderer.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            e eVar = this.g;
            if (eVar == null || eVar.i == null || !eVar.k) {
                return true;
            }
            GeoPoint b = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
            if (b != null) {
                List<l> list = this.g.h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.b(b);
                        }
                    }
                }
                e eVar2 = this.g;
                if (eVar2.f) {
                    ab E = eVar2.E();
                    E.a += 1.0f;
                    if (!this.g.g) {
                        E.d = b.getLongitudeE6();
                        E.e = b.getLatitudeE6();
                    }
                    BaiduMap.mapStatusReason |= 1;
                    this.g.a(E, 300);
                    e.m = System.currentTimeMillis();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            e eVar = this.g;
            if (eVar == null || eVar.i == null || !eVar.k) {
                return true;
            }
            if (eVar.e) {
                float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                if (sqrt <= 500.0f) {
                    return false;
                }
                BaiduMap.mapStatusReason |= 1;
                this.g.A();
                this.g.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
                this.g.M();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, motionEvent) == null) || (eVar = this.g) == null || (aVar = eVar.i) == null || !eVar.k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.g.l);
        if (a2 == null || a2.equals("")) {
            List<l> list = this.g.h;
            if (list != null) {
                for (l lVar : list) {
                    GeoPoint b = this.g.b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.c(b);
                    }
                }
                return;
            }
            return;
        }
        List<l> list2 = this.g.h;
        if (list2 != null) {
            for (l lVar2 : list2) {
                if (lVar2 != null) {
                    if (lVar2.b(a2)) {
                        this.g.p = true;
                    } else {
                        lVar2.c(this.g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                    }
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            e eVar = this.g;
            if (eVar == null || (aVar = eVar.i) == null) {
                return;
            }
            aVar.c();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            e eVar = this.g;
            if (eVar == null || eVar.i == null) {
                return;
            }
            List<l> list = eVar.h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.d();
                    }
                }
            }
            this.g.i.g();
            this.g.i.d();
            this.g.i.n();
            setRenderMode(1);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, motionEvent) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        InterceptResult invokeL;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        JSONObject jSONObject;
        List<l> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) {
            e eVar = this.g;
            if (eVar != null && (aVar = eVar.i) != null && eVar.k) {
                String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.g.l);
                JSONObject jSONObject2 = null;
                if (a2 == null || a2.equals("")) {
                    List<l> list2 = this.g.h;
                    if (list2 != null) {
                        for (l lVar : list2) {
                            if (lVar != null) {
                                lVar.a(this.g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                            }
                        }
                    }
                } else {
                    try {
                        jSONObject = new JSONObject(a2);
                        try {
                            jSONObject.put("px", (int) motionEvent.getX());
                            jSONObject.put(Config.PY, (int) motionEvent.getY());
                        } catch (JSONException e) {
                            e = e;
                            jSONObject2 = jSONObject;
                            e.printStackTrace();
                            jSONObject = jSONObject2;
                            list = this.g.h;
                            if (list != null) {
                            }
                            return true;
                        }
                    } catch (JSONException e2) {
                        e = e2;
                    }
                    list = this.g.h;
                    if (list != null) {
                        for (l lVar2 : list) {
                            if (jSONObject != null && lVar2 != null) {
                                lVar2.a(jSONObject.toString());
                            }
                        }
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            e eVar = this.g;
            if (eVar == null || eVar.i == null) {
                return true;
            }
            super.onTouchEvent(motionEvent);
            List<l> list = this.g.h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.a(motionEvent);
                    }
                }
            }
            if (this.f.onTouchEvent(motionEvent)) {
                return true;
            }
            return this.g.a(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r6 == ((r2.left - r2.right) / 2)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r6 == ((r2.bottom - r2.top) / 2)) goto L20;
     */
    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048602, this, surfaceHolder, i, i2, i3) == null) {
            super.surfaceChanged(surfaceHolder, i, i2, i3);
            e eVar = this.g;
            if (eVar == null || eVar.i == null) {
                return;
            }
            MapRenderer mapRenderer = this.c;
            mapRenderer.a = i2;
            mapRenderer.b = i3;
            this.d = i2;
            this.e = i3;
            mapRenderer.c = 0;
            ab E = eVar.E();
            int i4 = E.f;
            if (i4 != 0 && i4 != -1) {
                WinRound winRound = E.j;
            }
            E.f = -1;
            int i5 = E.g;
            if (i5 != 0 && i5 != -1) {
                WinRound winRound2 = E.j;
            }
            E.g = -1;
            WinRound winRound3 = E.j;
            winRound3.left = 0;
            winRound3.top = 0;
            winRound3.bottom = i3;
            winRound3.right = i2;
            this.g.a(E);
            this.g.a(this.d, this.e);
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, surfaceHolder) == null) {
            super.surfaceCreated(surfaceHolder);
            if (surfaceHolder == null || surfaceHolder.getSurface().isValid()) {
                return;
            }
            surfaceDestroyed(surfaceHolder);
        }
    }
}
