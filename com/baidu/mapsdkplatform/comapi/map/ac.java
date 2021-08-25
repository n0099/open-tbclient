package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class ac extends TextureView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, TextureView.SurfaceTextureListener, m.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f42082a;

    /* renamed from: b  reason: collision with root package name */
    public static int f42083b;

    /* renamed from: c  reason: collision with root package name */
    public static int f42084c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public GestureDetector f42085d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f42086e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42087f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f42088g;

    /* renamed from: h  reason: collision with root package name */
    public m f42089h;

    /* renamed from: i  reason: collision with root package name */
    public e f42090i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(Context context, z zVar, String str, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, zVar, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42087f = false;
        this.f42089h = null;
        a(context, zVar, str, i2);
    }

    private void a(Context context, z zVar, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, this, context, zVar, str, i2) == null) {
            setSurfaceTextureListener(this);
            if (context == null) {
                throw new RuntimeException("BDMapSDKException: when you create an mapview, the context can not be null");
            }
            this.f42085d = new GestureDetector(context, this);
            EnvironmentUtilities.initAppDirectory(context);
            if (this.f42090i == null) {
                this.f42090i = new e(context, str, i2);
            }
            this.f42090i.a(context.hashCode());
            this.f42090i.a();
            this.f42090i.a(zVar);
            e();
            this.f42090i.a(this.f42086e);
            this.f42090i.f();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f42086e = new ad(this);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.m.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e eVar = this.f42090i;
            if (eVar == null) {
                return 0;
            }
            if (f42084c <= 1) {
                MapRenderer.nativeResize(eVar.f42120j, f42082a, f42083b);
                f42084c++;
            }
            return MapRenderer.nativeRender(this.f42090i.f42120j);
        }
        return invokeV.intValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this.f42090i) {
                if (this.f42090i.f42118h != null) {
                    for (l lVar : this.f42090i.f42118h) {
                        if (lVar != null) {
                            lVar.f();
                        }
                    }
                }
                if (this.f42090i != null) {
                    this.f42090i.b(this.f42086e);
                    this.f42090i.b(i2);
                    this.f42090i = null;
                }
                this.f42086e.removeCallbacksAndMessages(null);
                if (this.f42089h != null) {
                    this.f42089h.c();
                    this.f42089h = null;
                }
                if (this.f42088g != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f42088g.release();
                    }
                    this.f42088g = null;
                }
            }
        }
    }

    public void a(String str, Rect rect) {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, rect) == null) || (eVar = this.f42090i) == null || (aVar = eVar.f42119i) == null) {
            return;
        }
        if (rect != null) {
            int i2 = rect.left;
            int i3 = f42083b;
            int i4 = rect.bottom;
            int i5 = i3 < i4 ? 0 : i3 - i4;
            int width = rect.width();
            int height = rect.height();
            if (i2 < 0 || i5 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > f42082a) {
                width = Math.abs(rect.width()) - (rect.right - f42082a);
            }
            if (height > f42083b) {
                height = Math.abs(rect.height()) - (rect.bottom - f42083b);
            }
            if (i2 > SysOSUtil.getScreenSizeX() || i5 > SysOSUtil.getScreenSizeY()) {
                this.f42090i.f42119i.a(str, (Bundle) null);
                m mVar2 = this.f42089h;
                if (mVar2 != null) {
                    mVar2.a();
                    return;
                }
                return;
            }
            f42082a = width;
            f42083b = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i2);
            bundle.putInt("y", i5);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.f42090i.f42119i.a(str, bundle);
            mVar = this.f42089h;
            if (mVar == null) {
                return;
            }
        } else {
            aVar.a(str, (Bundle) null);
            mVar = this.f42089h;
            if (mVar == null) {
                return;
            }
        }
        mVar.a();
    }

    public e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f42090i : (e) invokeV.objValue;
    }

    public void c() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.f42090i) == null || eVar.f42119i == null) {
            return;
        }
        List<l> list = eVar.f42118h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.d();
                }
            }
        }
        this.f42090i.f42119i.g();
        this.f42090i.f42119i.d();
        this.f42090i.f42119i.n();
        m mVar = this.f42089h;
        if (mVar != null) {
            mVar.a();
        }
        if (this.f42090i.b()) {
            this.f42087f = true;
        }
    }

    public void d() {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.f42090i) == null || (aVar = eVar.f42119i) == null) {
            return;
        }
        this.f42087f = false;
        aVar.c();
        synchronized (this.f42090i) {
            this.f42090i.f42119i.c();
            if (this.f42089h != null) {
                this.f42089h.b();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            e eVar = this.f42090i;
            if (eVar == null || eVar.f42119i == null || !eVar.k) {
                return true;
            }
            GeoPoint b2 = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
            if (b2 != null) {
                List<l> list = this.f42090i.f42118h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.b(b2);
                        }
                    }
                }
                e eVar2 = this.f42090i;
                if (eVar2.f42116f) {
                    ab E = eVar2.E();
                    E.f42063a += 1.0f;
                    if (!this.f42090i.f42117g) {
                        E.f42066d = b2.getLongitudeE6();
                        E.f42067e = b2.getLatitudeE6();
                    }
                    BaiduMap.mapStatusReason |= 1;
                    this.f42090i.a(E, 300);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            e eVar = this.f42090i;
            if (eVar == null || eVar.f42119i == null || !eVar.k) {
                return true;
            }
            if (eVar.f42115e) {
                float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
                if (sqrt <= 500.0f) {
                    return false;
                }
                BaiduMap.mapStatusReason |= 1;
                this.f42090i.A();
                this.f42090i.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
                this.f42090i.M();
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, motionEvent) == null) || (eVar = this.f42090i) == null || (aVar = eVar.f42119i) == null || !eVar.k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f42090i.l);
        if (this.f42090i.f42118h == null) {
            return;
        }
        if (a2 == null || a2.equals("")) {
            for (l lVar : this.f42090i.f42118h) {
                GeoPoint b2 = this.f42090i.b((int) motionEvent.getX(), (int) motionEvent.getY());
                if (lVar != null) {
                    lVar.c(b2);
                }
            }
            return;
        }
        for (l lVar2 : this.f42090i.f42118h) {
            if (lVar2.b(a2)) {
                this.f42090i.p = true;
            } else {
                lVar2.c(this.f42090i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, motionEvent) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        InterceptResult invokeL;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            e eVar = this.f42090i;
            if (eVar == null || (aVar = eVar.f42119i) == null || !eVar.k || eVar.f42118h == null) {
                return true;
            }
            String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f42090i.l);
            JSONObject jSONObject2 = null;
            if (a2 == null || a2.equals("")) {
                for (l lVar : this.f42090i.f42118h) {
                    if (lVar != null) {
                        lVar.a(this.f42090i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                    }
                }
            } else {
                try {
                    jSONObject = new JSONObject(a2);
                } catch (JSONException e2) {
                    e = e2;
                }
                try {
                    jSONObject.put("px", (int) motionEvent.getX());
                    jSONObject.put("py", (int) motionEvent.getY());
                } catch (JSONException e3) {
                    e = e3;
                    jSONObject2 = jSONObject;
                    e.printStackTrace();
                    jSONObject = jSONObject2;
                    while (r7.hasNext()) {
                    }
                    return true;
                }
                for (l lVar2 : this.f42090i.f42118h) {
                    if (jSONObject != null && lVar2 != null) {
                        lVar2.a(jSONObject.toString());
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r0 == ((r2.left - r2.right) / 2)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r0 == ((r2.bottom - r2.top) / 2)) goto L24;
     */
    @Override // android.view.TextureView.SurfaceTextureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048591, this, surfaceTexture, i2, i3) == null) || this.f42090i == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.f42088g;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.f42088g = surfaceTexture;
        m mVar = new m(this.f42088g, this, new AtomicBoolean(true), this);
        this.f42089h = mVar;
        mVar.start();
        f42082a = i2;
        f42083b = i3;
        ab E = this.f42090i.E();
        if (E == null) {
            return;
        }
        int i4 = E.f42068f;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound = E.f42072j;
        }
        E.f42068f = -1;
        int i5 = E.f42069g;
        if (i5 != 0 && i5 != -1) {
            WinRound winRound2 = E.f42072j;
        }
        E.f42069g = -1;
        WinRound winRound3 = E.f42072j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i3;
        winRound3.right = i2;
        this.f42090i.a(E);
        this.f42090i.a(f42082a, f42083b);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, surfaceTexture)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r0 == ((r2.left - r2.right) / 2)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r0 == ((r2.bottom - r2.top) / 2)) goto L19;
     */
    @Override // android.view.TextureView.SurfaceTextureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048593, this, surfaceTexture, i2, i3) == null) || (eVar = this.f42090i) == null) {
            return;
        }
        f42082a = i2;
        f42083b = i3;
        f42084c = 1;
        ab E = eVar.E();
        int i4 = E.f42068f;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound = E.f42072j;
        }
        E.f42068f = -1;
        int i5 = E.f42069g;
        if (i5 != 0 && i5 != -1) {
            WinRound winRound2 = E.f42072j;
        }
        E.f42069g = -1;
        WinRound winRound3 = E.f42072j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i3;
        winRound3.right = i2;
        this.f42090i.a(E);
        this.f42090i.a(f42082a, f42083b);
        MapRenderer.nativeResize(this.f42090i.f42120j, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, surfaceTexture) == null) && this.f42087f && (mVar = this.f42089h) != null) {
            mVar.a();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            e eVar = this.f42090i;
            if (eVar == null || eVar.f42119i == null) {
                return true;
            }
            super.onTouchEvent(motionEvent);
            List<l> list = this.f42090i.f42118h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.a(motionEvent);
                    }
                }
            }
            if (this.f42085d.onTouchEvent(motionEvent)) {
                return true;
            }
            return this.f42090i.a(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
