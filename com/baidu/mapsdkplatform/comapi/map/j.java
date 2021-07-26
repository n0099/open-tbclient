package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class j extends GLSurfaceView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderer.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7758a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f7759b;

    /* renamed from: c  reason: collision with root package name */
    public MapRenderer f7760c;

    /* renamed from: d  reason: collision with root package name */
    public int f7761d;

    /* renamed from: e  reason: collision with root package name */
    public int f7762e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f7763f;

    /* renamed from: g  reason: collision with root package name */
    public e f7764g;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f7765a;

        /* renamed from: b  reason: collision with root package name */
        public float f7766b;

        /* renamed from: c  reason: collision with root package name */
        public float f7767c;

        /* renamed from: d  reason: collision with root package name */
        public float f7768d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7769e;

        /* renamed from: f  reason: collision with root package name */
        public float f7770f;

        /* renamed from: g  reason: collision with root package name */
        public float f7771g;

        /* renamed from: h  reason: collision with root package name */
        public double f7772h;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "MultiTouch{x1=" + this.f7765a + ", x2=" + this.f7766b + ", y1=" + this.f7767c + ", y2=" + this.f7768d + ", mTwoTouch=" + this.f7769e + ", centerX=" + this.f7770f + ", centerY=" + this.f7771g + ", length=" + this.f7772h + '}';
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
        f7758a = j.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, z zVar, String str, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, zVar, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        this.f7763f = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.f7764g == null) {
            this.f7764g = new e(context, str, i2);
        }
        this.f7764g.a(context.hashCode());
        g();
        this.f7764g.a();
        this.f7764g.a(zVar);
        h();
        this.f7764g.a(this.f7759b);
        this.f7764g.f();
        setBackgroundColor(0);
    }

    public static boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            return egl10.eglChooseConfig(eglGetDisplay, new int[]{ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, i4, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, i5, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, i6, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, i7, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
        }
        return invokeCommon.booleanValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
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
            this.f7760c = mapRenderer;
            mapRenderer.a(this.f7764g.j);
            setRenderer(this.f7760c);
            setRenderMode(1);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f7759b = new k(this);
        }
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7764g : (e) invokeV.objValue;
    }

    public void a(float f2, float f3) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (eVar = this.f7764g) == null || eVar.f7741i == null) {
            return;
        }
        eVar.b(f2, f3);
    }

    public void a(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f7764g == null) {
            return;
        }
        Message message = new Message();
        message.what = 50;
        message.obj = Long.valueOf(this.f7764g.j);
        boolean q = this.f7764g.q();
        if (i2 != 3) {
            i3 = q ? 1 : 1;
            this.f7759b.sendMessage(message);
        }
        i3 = 0;
        message.arg1 = i3;
        this.f7759b.sendMessage(message);
    }

    public void a(String str, Rect rect) {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, rect) == null) || (eVar = this.f7764g) == null || (aVar = eVar.f7741i) == null) {
            return;
        }
        if (rect != null) {
            int i2 = rect.left;
            int i3 = this.f7762e;
            int i4 = rect.bottom;
            int i5 = i3 < i4 ? 0 : i3 - i4;
            int width = rect.width();
            int height = rect.height();
            if (i2 < 0 || i5 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.f7761d) {
                width = Math.abs(rect.width()) - (rect.right - this.f7761d);
            }
            if (height > this.f7762e) {
                height = Math.abs(rect.height()) - (rect.bottom - this.f7762e);
            }
            if (i2 > SysOSUtil.getScreenSizeX() || i5 > SysOSUtil.getScreenSizeY()) {
                this.f7764g.f7741i.a(str, (Bundle) null);
                requestRender();
                return;
            }
            this.f7761d = width;
            this.f7762e = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i2);
            bundle.putInt("y", i5);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.f7764g.f7741i.a(str, bundle);
        } else {
            aVar.a(str, (Bundle) null);
        }
        requestRender();
    }

    public boolean a(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            e eVar = this.f7764g;
            if (eVar == null || eVar.f7741i == null) {
                return false;
            }
            return eVar.a(f2, f3, f4, f5);
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.f7764g) == null) {
            return;
        }
        eVar.u();
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            e eVar = this.f7764g;
            if (eVar != null) {
                List<l> list = eVar.f7740h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.f();
                        }
                    }
                }
                this.f7764g.b(this.f7759b);
                this.f7764g.b(i2);
                this.f7764g = null;
            }
            Handler handler = this.f7759b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    public boolean b(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            e eVar = this.f7764g;
            if (eVar == null || eVar.f7741i == null) {
                return false;
            }
            return eVar.d(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public void c() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (eVar = this.f7764g) == null) {
            return;
        }
        eVar.v();
    }

    public boolean c(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            e eVar = this.f7764g;
            if (eVar == null || eVar.f7741i == null) {
                return false;
            }
            return eVar.c(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            getHolder().setFormat(-3);
            this.f7764g.f7741i.s();
        }
    }

    public boolean d(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            e eVar = this.f7764g;
            if (eVar == null || eVar.f7741i == null) {
                return false;
            }
            return eVar.c((int) f2, (int) f3);
        }
        return invokeCommon.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            getHolder().setFormat(-1);
            this.f7764g.f7741i.t();
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
            e eVar = this.f7764g;
            if (eVar == null || eVar.f7741i == null || !eVar.k) {
                return true;
            }
            GeoPoint b2 = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
            if (b2 != null) {
                List<l> list = this.f7764g.f7740h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.b(b2);
                        }
                    }
                }
                e eVar2 = this.f7764g;
                if (eVar2.f7738f) {
                    ab E = eVar2.E();
                    E.f7687a += 1.0f;
                    if (!this.f7764g.f7739g) {
                        E.f7690d = b2.getLongitudeE6();
                        E.f7691e = b2.getLatitudeE6();
                    }
                    BaiduMap.mapStatusReason |= 1;
                    this.f7764g.a(E, 300);
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
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            e eVar = this.f7764g;
            if (eVar == null || eVar.f7741i == null || !eVar.k) {
                return true;
            }
            if (eVar.f7737e) {
                float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
                if (sqrt <= 500.0f) {
                    return false;
                }
                BaiduMap.mapStatusReason |= 1;
                this.f7764g.A();
                this.f7764g.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
                this.f7764g.M();
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
        if (!(interceptable == null || interceptable.invokeL(1048594, this, motionEvent) == null) || (eVar = this.f7764g) == null || (aVar = eVar.f7741i) == null || !eVar.k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f7764g.l);
        if (a2 == null || a2.equals("")) {
            List<l> list = this.f7764g.f7740h;
            if (list != null) {
                for (l lVar : list) {
                    GeoPoint b2 = this.f7764g.b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.c(b2);
                    }
                }
                return;
            }
            return;
        }
        List<l> list2 = this.f7764g.f7740h;
        if (list2 != null) {
            for (l lVar2 : list2) {
                if (lVar2 != null) {
                    if (lVar2.b(a2)) {
                        this.f7764g.p = true;
                    } else {
                        lVar2.c(this.f7764g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
            e eVar = this.f7764g;
            if (eVar == null || (aVar = eVar.f7741i) == null) {
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
            e eVar = this.f7764g;
            if (eVar == null || eVar.f7741i == null) {
                return;
            }
            List<l> list = eVar.f7740h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.d();
                    }
                }
            }
            this.f7764g.f7741i.g();
            this.f7764g.f7741i.d();
            this.f7764g.f7741i.n();
            setRenderMode(1);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
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
            e eVar = this.f7764g;
            if (eVar != null && (aVar = eVar.f7741i) != null && eVar.k) {
                String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f7764g.l);
                JSONObject jSONObject2 = null;
                if (a2 == null || a2.equals("")) {
                    List<l> list2 = this.f7764g.f7740h;
                    if (list2 != null) {
                        for (l lVar : list2) {
                            if (lVar != null) {
                                lVar.a(this.f7764g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                            }
                        }
                    }
                } else {
                    try {
                        jSONObject = new JSONObject(a2);
                        try {
                            jSONObject.put("px", (int) motionEvent.getX());
                            jSONObject.put("py", (int) motionEvent.getY());
                        } catch (JSONException e2) {
                            e = e2;
                            jSONObject2 = jSONObject;
                            e.printStackTrace();
                            jSONObject = jSONObject2;
                            list = this.f7764g.f7740h;
                            if (list != null) {
                            }
                            return true;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                    }
                    list = this.f7764g.f7740h;
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
            e eVar = this.f7764g;
            if (eVar == null || eVar.f7741i == null) {
                return true;
            }
            super.onTouchEvent(motionEvent);
            List<l> list = this.f7764g.f7740h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.a(motionEvent);
                    }
                }
            }
            if (this.f7763f.onTouchEvent(motionEvent)) {
                return true;
            }
            return this.f7764g.a(motionEvent);
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
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048602, this, surfaceHolder, i2, i3, i4) == null) {
            super.surfaceChanged(surfaceHolder, i2, i3, i4);
            e eVar = this.f7764g;
            if (eVar == null || eVar.f7741i == null) {
                return;
            }
            MapRenderer mapRenderer = this.f7760c;
            mapRenderer.f7677a = i3;
            mapRenderer.f7678b = i4;
            this.f7761d = i3;
            this.f7762e = i4;
            mapRenderer.f7679c = 0;
            ab E = eVar.E();
            int i5 = E.f7692f;
            if (i5 != 0 && i5 != -1) {
                WinRound winRound = E.j;
            }
            E.f7692f = -1;
            int i6 = E.f7693g;
            if (i6 != 0 && i6 != -1) {
                WinRound winRound2 = E.j;
            }
            E.f7693g = -1;
            WinRound winRound3 = E.j;
            winRound3.left = 0;
            winRound3.top = 0;
            winRound3.bottom = i4;
            winRound3.right = i3;
            this.f7764g.a(E);
            this.f7764g.a(this.f7761d, this.f7762e);
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
