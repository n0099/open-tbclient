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
/* loaded from: classes2.dex */
public class ac extends TextureView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, TextureView.SurfaceTextureListener, m.a {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;
    public GestureDetector d;
    public Handler e;
    public boolean f;
    public SurfaceTexture g;
    public m h;
    public e i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(Context context, z zVar, String str, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, zVar, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.h = null;
        a(context, zVar, str, i);
    }

    private void a(Context context, z zVar, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, this, context, zVar, str, i) == null) {
            setSurfaceTextureListener(this);
            if (context == null) {
                throw new RuntimeException("BDMapSDKException: when you create an mapview, the context can not be null");
            }
            this.d = new GestureDetector(context, this);
            EnvironmentUtilities.initAppDirectory(context);
            if (this.i == null) {
                this.i = new e(context, str, i);
            }
            this.i.a(context.hashCode());
            this.i.a();
            this.i.a(zVar);
            e();
            this.i.a(this.e);
            this.i.f();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.e = new ad(this);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.m.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e eVar = this.i;
            if (eVar == null) {
                return 0;
            }
            if (c <= 1) {
                MapRenderer.nativeResize(eVar.j, a, b);
                c++;
            }
            return MapRenderer.nativeRender(this.i.j);
        }
        return invokeV.intValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this.i) {
                if (this.i.h != null) {
                    for (l lVar : this.i.h) {
                        if (lVar != null) {
                            lVar.f();
                        }
                    }
                }
                if (this.i != null) {
                    this.i.b(this.e);
                    this.i.b(i);
                    this.i = null;
                }
                this.e.removeCallbacksAndMessages(null);
                if (this.h != null) {
                    this.h.c();
                    this.h = null;
                }
                if (this.g != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.g.release();
                    }
                    this.g = null;
                }
            }
        }
    }

    public void a(String str, Rect rect) {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, rect) == null) || (eVar = this.i) == null || (aVar = eVar.i) == null) {
            return;
        }
        if (rect != null) {
            int i = rect.left;
            int i2 = b;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i4 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > a) {
                width = Math.abs(rect.width()) - (rect.right - a);
            }
            if (height > b) {
                height = Math.abs(rect.height()) - (rect.bottom - b);
            }
            if (i > SysOSUtil.getScreenSizeX() || i4 > SysOSUtil.getScreenSizeY()) {
                this.i.i.a(str, (Bundle) null);
                m mVar2 = this.h;
                if (mVar2 != null) {
                    mVar2.a();
                    return;
                }
                return;
            }
            a = width;
            b = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i);
            bundle.putInt("y", i4);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.i.i.a(str, bundle);
            mVar = this.h;
            if (mVar == null) {
                return;
            }
        } else {
            aVar.a(str, (Bundle) null);
            mVar = this.h;
            if (mVar == null) {
                return;
            }
        }
        mVar.a();
    }

    public e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (e) invokeV.objValue;
    }

    public void c() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.i) == null || eVar.i == null) {
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
        this.i.i.g();
        this.i.i.d();
        this.i.i.n();
        m mVar = this.h;
        if (mVar != null) {
            mVar.a();
        }
        if (this.i.b()) {
            this.f = true;
        }
    }

    public void d() {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.i) == null || (aVar = eVar.i) == null) {
            return;
        }
        this.f = false;
        aVar.c();
        synchronized (this.i) {
            this.i.i.c();
            if (this.h != null) {
                this.h.b();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            e eVar = this.i;
            if (eVar == null || eVar.i == null || !eVar.k) {
                return true;
            }
            GeoPoint b2 = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
            if (b2 != null) {
                List<l> list = this.i.h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.b(b2);
                        }
                    }
                }
                e eVar2 = this.i;
                if (eVar2.f) {
                    ab E = eVar2.E();
                    E.a += 1.0f;
                    if (!this.i.g) {
                        E.d = b2.getLongitudeE6();
                        E.e = b2.getLatitudeE6();
                    }
                    BaiduMap.mapStatusReason |= 1;
                    this.i.a(E, 300);
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
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            e eVar = this.i;
            if (eVar == null || eVar.i == null || !eVar.k) {
                return true;
            }
            if (eVar.e) {
                float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                if (sqrt <= 500.0f) {
                    return false;
                }
                BaiduMap.mapStatusReason |= 1;
                this.i.A();
                this.i.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
                this.i.M();
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, motionEvent) == null) || (eVar = this.i) == null || (aVar = eVar.i) == null || !eVar.k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.i.l);
        if (this.i.h == null) {
            return;
        }
        if (a2 == null || a2.equals("")) {
            for (l lVar : this.i.h) {
                GeoPoint b2 = this.i.b((int) motionEvent.getX(), (int) motionEvent.getY());
                if (lVar != null) {
                    lVar.c(b2);
                }
            }
            return;
        }
        for (l lVar2 : this.i.h) {
            if (lVar2.b(a2)) {
                this.i.p = true;
            } else {
                lVar2.c(this.i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
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
            e eVar = this.i;
            if (eVar == null || (aVar = eVar.i) == null || !eVar.k || eVar.h == null) {
                return true;
            }
            String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.i.l);
            JSONObject jSONObject2 = null;
            if (a2 == null || a2.equals("")) {
                for (l lVar : this.i.h) {
                    if (lVar != null) {
                        lVar.a(this.i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                    }
                }
            } else {
                try {
                    jSONObject = new JSONObject(a2);
                } catch (JSONException e) {
                    e = e;
                }
                try {
                    jSONObject.put("px", (int) motionEvent.getX());
                    jSONObject.put("py", (int) motionEvent.getY());
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = jSONObject;
                    e.printStackTrace();
                    jSONObject = jSONObject2;
                    while (r7.hasNext()) {
                    }
                    return true;
                }
                for (l lVar2 : this.i.h) {
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
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048591, this, surfaceTexture, i, i2) == null) || this.i == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.g;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.g = surfaceTexture;
        m mVar = new m(this.g, this, new AtomicBoolean(true), this);
        this.h = mVar;
        mVar.start();
        a = i;
        b = i2;
        ab E = this.i.E();
        if (E == null) {
            return;
        }
        int i3 = E.f;
        if (i3 != 0 && i3 != -1) {
            WinRound winRound = E.j;
        }
        E.f = -1;
        int i4 = E.g;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound2 = E.j;
        }
        E.g = -1;
        WinRound winRound3 = E.j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i2;
        winRound3.right = i;
        this.i.a(E);
        this.i.a(a, b);
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
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048593, this, surfaceTexture, i, i2) == null) || (eVar = this.i) == null) {
            return;
        }
        a = i;
        b = i2;
        c = 1;
        ab E = eVar.E();
        int i3 = E.f;
        if (i3 != 0 && i3 != -1) {
            WinRound winRound = E.j;
        }
        E.f = -1;
        int i4 = E.g;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound2 = E.j;
        }
        E.g = -1;
        WinRound winRound3 = E.j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i2;
        winRound3.right = i;
        this.i.a(E);
        this.i.a(a, b);
        MapRenderer.nativeResize(this.i.j, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, surfaceTexture) == null) && this.f && (mVar = this.h) != null) {
            mVar.a();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            e eVar = this.i;
            if (eVar == null || eVar.i == null) {
                return true;
            }
            super.onTouchEvent(motionEvent);
            List<l> list = this.i.h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.a(motionEvent);
                    }
                }
            }
            if (this.d.onTouchEvent(motionEvent)) {
                return true;
            }
            return this.i.a(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
