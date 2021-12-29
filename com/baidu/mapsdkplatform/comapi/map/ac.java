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
/* loaded from: classes10.dex */
public class ac extends TextureView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, TextureView.SurfaceTextureListener, m.a {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static int f37052b;

    /* renamed from: c  reason: collision with root package name */
    public static int f37053c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public GestureDetector f37054d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f37055e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37056f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f37057g;

    /* renamed from: h  reason: collision with root package name */
    public m f37058h;

    /* renamed from: i  reason: collision with root package name */
    public e f37059i;

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
        this.f37056f = false;
        this.f37058h = null;
        a(context, zVar, str, i2);
    }

    private void a(Context context, z zVar, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, this, context, zVar, str, i2) == null) {
            setSurfaceTextureListener(this);
            if (context == null) {
                throw new RuntimeException("BDMapSDKException: when you create an mapview, the context can not be null");
            }
            this.f37054d = new GestureDetector(context, this);
            EnvironmentUtilities.initAppDirectory(context);
            if (this.f37059i == null) {
                this.f37059i = new e(context, str, i2);
            }
            this.f37059i.a(context.hashCode());
            this.f37059i.a();
            this.f37059i.a(zVar);
            e();
            this.f37059i.a(this.f37055e);
            this.f37059i.f();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f37055e = new ad(this);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.m.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e eVar = this.f37059i;
            if (eVar == null) {
                return 0;
            }
            if (f37053c <= 1) {
                MapRenderer.nativeResize(eVar.f37085j, a, f37052b);
                f37053c++;
            }
            return MapRenderer.nativeRender(this.f37059i.f37085j);
        }
        return invokeV.intValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this.f37059i) {
                if (this.f37059i.f37083h != null) {
                    for (l lVar : this.f37059i.f37083h) {
                        if (lVar != null) {
                            lVar.f();
                        }
                    }
                }
                if (this.f37059i != null) {
                    this.f37059i.b(this.f37055e);
                    this.f37059i.b(i2);
                    this.f37059i = null;
                }
                this.f37055e.removeCallbacksAndMessages(null);
                if (this.f37058h != null) {
                    this.f37058h.c();
                    this.f37058h = null;
                }
                if (this.f37057g != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f37057g.release();
                    }
                    this.f37057g = null;
                }
            }
        }
    }

    public void a(String str, Rect rect) {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, rect) == null) || (eVar = this.f37059i) == null || (aVar = eVar.f37084i) == null) {
            return;
        }
        if (rect != null) {
            int i2 = rect.left;
            int i3 = f37052b;
            int i4 = rect.bottom;
            int i5 = i3 < i4 ? 0 : i3 - i4;
            int width = rect.width();
            int height = rect.height();
            if (i2 < 0 || i5 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > a) {
                width = Math.abs(rect.width()) - (rect.right - a);
            }
            if (height > f37052b) {
                height = Math.abs(rect.height()) - (rect.bottom - f37052b);
            }
            if (i2 > SysOSUtil.getScreenSizeX() || i5 > SysOSUtil.getScreenSizeY()) {
                this.f37059i.f37084i.a(str, (Bundle) null);
                m mVar2 = this.f37058h;
                if (mVar2 != null) {
                    mVar2.a();
                    return;
                }
                return;
            }
            a = width;
            f37052b = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i2);
            bundle.putInt("y", i5);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.f37059i.f37084i.a(str, bundle);
            mVar = this.f37058h;
            if (mVar == null) {
                return;
            }
        } else {
            aVar.a(str, (Bundle) null);
            mVar = this.f37058h;
            if (mVar == null) {
                return;
            }
        }
        mVar.a();
    }

    public e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37059i : (e) invokeV.objValue;
    }

    public void c() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.f37059i) == null || eVar.f37084i == null) {
            return;
        }
        List<l> list = eVar.f37083h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.d();
                }
            }
        }
        this.f37059i.f37084i.g();
        this.f37059i.f37084i.d();
        this.f37059i.f37084i.n();
        m mVar = this.f37058h;
        if (mVar != null) {
            mVar.a();
        }
        if (this.f37059i.b()) {
            this.f37056f = true;
        }
    }

    public void d() {
        e eVar;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.f37059i) == null || (aVar = eVar.f37084i) == null) {
            return;
        }
        this.f37056f = false;
        aVar.c();
        synchronized (this.f37059i) {
            this.f37059i.f37084i.c();
            if (this.f37058h != null) {
                this.f37058h.b();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            e eVar = this.f37059i;
            if (eVar == null || eVar.f37084i == null || !eVar.f37086k) {
                return true;
            }
            GeoPoint b2 = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
            if (b2 != null) {
                List<l> list = this.f37059i.f37083h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.b(b2);
                        }
                    }
                }
                e eVar2 = this.f37059i;
                if (eVar2.f37081f) {
                    ab E = eVar2.E();
                    E.a += 1.0f;
                    if (!this.f37059i.f37082g) {
                        E.f37036d = b2.getLongitudeE6();
                        E.f37037e = b2.getLatitudeE6();
                    }
                    BaiduMap.mapStatusReason |= 1;
                    this.f37059i.a(E, 300);
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
            e eVar = this.f37059i;
            if (eVar == null || eVar.f37084i == null || !eVar.f37086k) {
                return true;
            }
            if (eVar.f37080e) {
                float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
                if (sqrt <= 500.0f) {
                    return false;
                }
                BaiduMap.mapStatusReason |= 1;
                this.f37059i.A();
                this.f37059i.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
                this.f37059i.M();
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, motionEvent) == null) || (eVar = this.f37059i) == null || (aVar = eVar.f37084i) == null || !eVar.f37086k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f37059i.l);
        if (this.f37059i.f37083h == null) {
            return;
        }
        if (a2 == null || a2.equals("")) {
            for (l lVar : this.f37059i.f37083h) {
                GeoPoint b2 = this.f37059i.b((int) motionEvent.getX(), (int) motionEvent.getY());
                if (lVar != null) {
                    lVar.c(b2);
                }
            }
            return;
        }
        for (l lVar2 : this.f37059i.f37083h) {
            if (lVar2.b(a2)) {
                this.f37059i.p = true;
            } else {
                lVar2.c(this.f37059i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
            e eVar = this.f37059i;
            if (eVar == null || (aVar = eVar.f37084i) == null || !eVar.f37086k || eVar.f37083h == null) {
                return true;
            }
            String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f37059i.l);
            JSONObject jSONObject2 = null;
            if (a2 == null || a2.equals("")) {
                for (l lVar : this.f37059i.f37083h) {
                    if (lVar != null) {
                        lVar.a(this.f37059i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
                for (l lVar2 : this.f37059i.f37083h) {
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
        if (!(interceptable == null || interceptable.invokeLII(1048591, this, surfaceTexture, i2, i3) == null) || this.f37059i == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.f37057g;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.f37057g = surfaceTexture;
        m mVar = new m(this.f37057g, this, new AtomicBoolean(true), this);
        this.f37058h = mVar;
        mVar.start();
        a = i2;
        f37052b = i3;
        ab E = this.f37059i.E();
        if (E == null) {
            return;
        }
        int i4 = E.f37038f;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound = E.f37042j;
        }
        E.f37038f = -1;
        int i5 = E.f37039g;
        if (i5 != 0 && i5 != -1) {
            WinRound winRound2 = E.f37042j;
        }
        E.f37039g = -1;
        WinRound winRound3 = E.f37042j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i3;
        winRound3.right = i2;
        this.f37059i.a(E);
        this.f37059i.a(a, f37052b);
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
        if (!(interceptable == null || interceptable.invokeLII(1048593, this, surfaceTexture, i2, i3) == null) || (eVar = this.f37059i) == null) {
            return;
        }
        a = i2;
        f37052b = i3;
        f37053c = 1;
        ab E = eVar.E();
        int i4 = E.f37038f;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound = E.f37042j;
        }
        E.f37038f = -1;
        int i5 = E.f37039g;
        if (i5 != 0 && i5 != -1) {
            WinRound winRound2 = E.f37042j;
        }
        E.f37039g = -1;
        WinRound winRound3 = E.f37042j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i3;
        winRound3.right = i2;
        this.f37059i.a(E);
        this.f37059i.a(a, f37052b);
        MapRenderer.nativeResize(this.f37059i.f37085j, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, surfaceTexture) == null) && this.f37056f && (mVar = this.f37058h) != null) {
            mVar.a();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            e eVar = this.f37059i;
            if (eVar == null || eVar.f37084i == null) {
                return true;
            }
            super.onTouchEvent(motionEvent);
            List<l> list = this.f37059i.f37083h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.a(motionEvent);
                    }
                }
            }
            if (this.f37054d.onTouchEvent(motionEvent)) {
                return true;
            }
            return this.f37059i.a(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
