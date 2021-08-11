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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class j extends GLSurfaceView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderer.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f42031a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f42032b;

    /* renamed from: c  reason: collision with root package name */
    public MapRenderer f42033c;

    /* renamed from: d  reason: collision with root package name */
    public int f42034d;

    /* renamed from: e  reason: collision with root package name */
    public int f42035e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f42036f;

    /* renamed from: g  reason: collision with root package name */
    public e f42037g;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f42038a;

        /* renamed from: b  reason: collision with root package name */
        public float f42039b;

        /* renamed from: c  reason: collision with root package name */
        public float f42040c;

        /* renamed from: d  reason: collision with root package name */
        public float f42041d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42042e;

        /* renamed from: f  reason: collision with root package name */
        public float f42043f;

        /* renamed from: g  reason: collision with root package name */
        public float f42044g;

        /* renamed from: h  reason: collision with root package name */
        public double f42045h;

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
                return "MultiTouch{x1=" + this.f42038a + ", x2=" + this.f42039b + ", y1=" + this.f42040c + ", y2=" + this.f42041d + ", mTwoTouch=" + this.f42042e + ", centerX=" + this.f42043f + ", centerY=" + this.f42044g + ", length=" + this.f42045h + ExtendedMessageFormat.END_FE;
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
        f42031a = j.class.getSimpleName();
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
        this.f42036f = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.f42037g == null) {
            this.f42037g = new e(context, str, i2);
        }
        this.f42037g.a(context.hashCode());
        g();
        this.f42037g.a();
        this.f42037g.a(zVar);
        h();
        this.f42037g.a(this.f42032b);
        this.f42037g.f();
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
            this.f42033c = mapRenderer;
            mapRenderer.a(this.f42037g.f42013j);
            setRenderer(this.f42033c);
            setRenderMode(1);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f42032b = new k(this);
        }
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42037g : (e) invokeV.objValue;
    }

    public void a(float f2, float f3) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (eVar = this.f42037g) == null || eVar.f42012i == null) {
            return;
        }
        eVar.b(f2, f3);
    }

    public void a(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f42037g == null) {
            return;
        }
        Message message = new Message();
        message.what = 50;
        message.obj = Long.valueOf(this.f42037g.f42013j);
        boolean q = this.f42037g.q();
        if (i2 != 3) {
            i3 = q ? 1 : 1;
            this.f42032b.sendMessage(message);
        }
        i3 = 0;
        message.arg1 = i3;
        this.f42032b.sendMessage(message);
    }

    public void a(String str, Rect rect) {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, rect) == null) || (eVar = this.f42037g) == null || (aVar = eVar.f42012i) == null) {
            return;
        }
        if (rect != null) {
            int i2 = rect.left;
            int i3 = this.f42035e;
            int i4 = rect.bottom;
            int i5 = i3 < i4 ? 0 : i3 - i4;
            int width = rect.width();
            int height = rect.height();
            if (i2 < 0 || i5 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.f42034d) {
                width = Math.abs(rect.width()) - (rect.right - this.f42034d);
            }
            if (height > this.f42035e) {
                height = Math.abs(rect.height()) - (rect.bottom - this.f42035e);
            }
            if (i2 > SysOSUtil.getScreenSizeX() || i5 > SysOSUtil.getScreenSizeY()) {
                this.f42037g.f42012i.a(str, (Bundle) null);
                requestRender();
                return;
            }
            this.f42034d = width;
            this.f42035e = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i2);
            bundle.putInt("y", i5);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.f42037g.f42012i.a(str, bundle);
        } else {
            aVar.a(str, (Bundle) null);
        }
        requestRender();
    }

    public boolean a(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            e eVar = this.f42037g;
            if (eVar == null || eVar.f42012i == null) {
                return false;
            }
            return eVar.a(f2, f3, f4, f5);
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.f42037g) == null) {
            return;
        }
        eVar.u();
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            e eVar = this.f42037g;
            if (eVar != null) {
                List<l> list = eVar.f42011h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.f();
                        }
                    }
                }
                this.f42037g.b(this.f42032b);
                this.f42037g.b(i2);
                this.f42037g = null;
            }
            Handler handler = this.f42032b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    public boolean b(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            e eVar = this.f42037g;
            if (eVar == null || eVar.f42012i == null) {
                return false;
            }
            return eVar.d(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public void c() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (eVar = this.f42037g) == null) {
            return;
        }
        eVar.v();
    }

    public boolean c(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            e eVar = this.f42037g;
            if (eVar == null || eVar.f42012i == null) {
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
            this.f42037g.f42012i.s();
        }
    }

    public boolean d(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            e eVar = this.f42037g;
            if (eVar == null || eVar.f42012i == null) {
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
            this.f42037g.f42012i.t();
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
            e eVar = this.f42037g;
            if (eVar == null || eVar.f42012i == null || !eVar.k) {
                return true;
            }
            GeoPoint b2 = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
            if (b2 != null) {
                List<l> list = this.f42037g.f42011h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.b(b2);
                        }
                    }
                }
                e eVar2 = this.f42037g;
                if (eVar2.f42009f) {
                    ab E = eVar2.E();
                    E.f41956a += 1.0f;
                    if (!this.f42037g.f42010g) {
                        E.f41959d = b2.getLongitudeE6();
                        E.f41960e = b2.getLatitudeE6();
                    }
                    BaiduMap.mapStatusReason |= 1;
                    this.f42037g.a(E, 300);
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
            e eVar = this.f42037g;
            if (eVar == null || eVar.f42012i == null || !eVar.k) {
                return true;
            }
            if (eVar.f42008e) {
                float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
                if (sqrt <= 500.0f) {
                    return false;
                }
                BaiduMap.mapStatusReason |= 1;
                this.f42037g.A();
                this.f42037g.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
                this.f42037g.M();
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
        if (!(interceptable == null || interceptable.invokeL(1048594, this, motionEvent) == null) || (eVar = this.f42037g) == null || (aVar = eVar.f42012i) == null || !eVar.k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f42037g.l);
        if (a2 == null || a2.equals("")) {
            List<l> list = this.f42037g.f42011h;
            if (list != null) {
                for (l lVar : list) {
                    GeoPoint b2 = this.f42037g.b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.c(b2);
                    }
                }
                return;
            }
            return;
        }
        List<l> list2 = this.f42037g.f42011h;
        if (list2 != null) {
            for (l lVar2 : list2) {
                if (lVar2 != null) {
                    if (lVar2.b(a2)) {
                        this.f42037g.p = true;
                    } else {
                        lVar2.c(this.f42037g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
            e eVar = this.f42037g;
            if (eVar == null || (aVar = eVar.f42012i) == null) {
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
            e eVar = this.f42037g;
            if (eVar == null || eVar.f42012i == null) {
                return;
            }
            List<l> list = eVar.f42011h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.d();
                    }
                }
            }
            this.f42037g.f42012i.g();
            this.f42037g.f42012i.d();
            this.f42037g.f42012i.n();
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
            e eVar = this.f42037g;
            if (eVar != null && (aVar = eVar.f42012i) != null && eVar.k) {
                String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f42037g.l);
                JSONObject jSONObject2 = null;
                if (a2 == null || a2.equals("")) {
                    List<l> list2 = this.f42037g.f42011h;
                    if (list2 != null) {
                        for (l lVar : list2) {
                            if (lVar != null) {
                                lVar.a(this.f42037g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
                            list = this.f42037g.f42011h;
                            if (list != null) {
                            }
                            return true;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                    }
                    list = this.f42037g.f42011h;
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
            e eVar = this.f42037g;
            if (eVar == null || eVar.f42012i == null) {
                return true;
            }
            super.onTouchEvent(motionEvent);
            List<l> list = this.f42037g.f42011h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.a(motionEvent);
                    }
                }
            }
            if (this.f42036f.onTouchEvent(motionEvent)) {
                return true;
            }
            return this.f42037g.a(motionEvent);
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
            e eVar = this.f42037g;
            if (eVar == null || eVar.f42012i == null) {
                return;
            }
            MapRenderer mapRenderer = this.f42033c;
            mapRenderer.f41946a = i3;
            mapRenderer.f41947b = i4;
            this.f42034d = i3;
            this.f42035e = i4;
            mapRenderer.f41948c = 0;
            ab E = eVar.E();
            int i5 = E.f41961f;
            if (i5 != 0 && i5 != -1) {
                WinRound winRound = E.f41965j;
            }
            E.f41961f = -1;
            int i6 = E.f41962g;
            if (i6 != 0 && i6 != -1) {
                WinRound winRound2 = E.f41965j;
            }
            E.f41962g = -1;
            WinRound winRound3 = E.f41965j;
            winRound3.left = 0;
            winRound3.top = 0;
            winRound3.bottom = i4;
            winRound3.right = i3;
            this.f42037g.a(E);
            this.f42037g.a(this.f42034d, this.f42035e);
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
