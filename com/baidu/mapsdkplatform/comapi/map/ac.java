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
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.m;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class ac extends TextureView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, TextureView.SurfaceTextureListener, m.a {

    /* renamed from: a  reason: collision with root package name */
    public static int f7892a;

    /* renamed from: b  reason: collision with root package name */
    public static int f7893b;

    /* renamed from: c  reason: collision with root package name */
    public static int f7894c;

    /* renamed from: d  reason: collision with root package name */
    public GestureDetector f7895d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f7896e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7897f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f7898g;

    /* renamed from: h  reason: collision with root package name */
    public m f7899h;

    /* renamed from: i  reason: collision with root package name */
    public e f7900i;

    public ac(Context context, z zVar, String str, int i2) {
        super(context);
        this.f7897f = false;
        this.f7899h = null;
        a(context, zVar, str, i2);
    }

    private void a(Context context, z zVar, String str, int i2) {
        setSurfaceTextureListener(this);
        if (context == null) {
            throw new RuntimeException("when you create an mapview, the context can not be null");
        }
        this.f7895d = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.f7900i == null) {
            this.f7900i = new e(context, str, i2);
        }
        this.f7900i.a(context.hashCode());
        this.f7900i.a();
        this.f7900i.a(zVar);
        e();
        this.f7900i.a(this.f7896e);
        this.f7900i.f();
    }

    private void e() {
        this.f7896e = new ad(this);
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.m.a
    public int a() {
        e eVar = this.f7900i;
        if (eVar == null) {
            return 0;
        }
        if (f7894c <= 1) {
            MapRenderer.nativeResize(eVar.j, f7892a, f7893b);
            f7894c++;
        }
        return MapRenderer.nativeRender(this.f7900i.j);
    }

    public void a(int i2) {
        synchronized (this.f7900i) {
            if (this.f7900i.f7927h != null) {
                for (l lVar : this.f7900i.f7927h) {
                    if (lVar != null) {
                        lVar.f();
                    }
                }
            }
            if (this.f7900i != null) {
                this.f7900i.b(this.f7896e);
                this.f7900i.b(i2);
                this.f7900i = null;
            }
            this.f7896e.removeCallbacksAndMessages(null);
            if (this.f7899h != null) {
                this.f7899h.c();
                this.f7899h = null;
            }
            if (this.f7898g != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f7898g.release();
                }
                this.f7898g = null;
            }
        }
    }

    public void a(String str, Rect rect) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        m mVar;
        e eVar = this.f7900i;
        if (eVar == null || (aVar = eVar.f7928i) == null) {
            return;
        }
        if (rect != null) {
            int i2 = rect.left;
            int i3 = f7893b;
            int i4 = rect.bottom;
            int i5 = i3 < i4 ? 0 : i3 - i4;
            int width = rect.width();
            int height = rect.height();
            if (i2 < 0 || i5 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > f7892a) {
                width = Math.abs(rect.width()) - (rect.right - f7892a);
            }
            if (height > f7893b) {
                height = Math.abs(rect.height()) - (rect.bottom - f7893b);
            }
            if (i2 > SysOSUtil.getScreenSizeX() || i5 > SysOSUtil.getScreenSizeY()) {
                this.f7900i.f7928i.a(str, (Bundle) null);
                m mVar2 = this.f7899h;
                if (mVar2 != null) {
                    mVar2.a();
                    return;
                }
                return;
            }
            f7892a = width;
            f7893b = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i2);
            bundle.putInt("y", i5);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.f7900i.f7928i.a(str, bundle);
            mVar = this.f7899h;
            if (mVar == null) {
                return;
            }
        } else {
            aVar.a(str, (Bundle) null);
            mVar = this.f7899h;
            if (mVar == null) {
                return;
            }
        }
        mVar.a();
    }

    public e b() {
        return this.f7900i;
    }

    public void c() {
        e eVar = this.f7900i;
        if (eVar == null || eVar.f7928i == null) {
            return;
        }
        List<l> list = eVar.f7927h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.d();
                }
            }
        }
        this.f7900i.f7928i.g();
        this.f7900i.f7928i.d();
        this.f7900i.f7928i.n();
        m mVar = this.f7899h;
        if (mVar != null) {
            mVar.a();
        }
        if (this.f7900i.b()) {
            this.f7897f = true;
        }
    }

    public void d() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        e eVar = this.f7900i;
        if (eVar == null || (aVar = eVar.f7928i) == null) {
            return;
        }
        this.f7897f = false;
        aVar.c();
        synchronized (this.f7900i) {
            this.f7900i.f7928i.c();
            if (this.f7899h != null) {
                this.f7899h.b();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        e eVar = this.f7900i;
        if (eVar == null || eVar.f7928i == null || !eVar.k) {
            return true;
        }
        GeoPoint b2 = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
        if (b2 != null) {
            List<l> list = this.f7900i.f7927h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.b(b2);
                    }
                }
            }
            e eVar2 = this.f7900i;
            if (eVar2.f7925f) {
                ab E = eVar2.E();
                E.f7874a += 1.0f;
                if (!this.f7900i.f7926g) {
                    E.f7877d = b2.getLongitudeE6();
                    E.f7878e = b2.getLatitudeE6();
                }
                BaiduMap.mapStatusReason |= 1;
                this.f7900i.a(E, 300);
                e.m = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        e eVar = this.f7900i;
        if (eVar == null || eVar.f7928i == null || !eVar.k) {
            return true;
        }
        if (eVar.f7924e) {
            float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
            if (sqrt <= 500.0f) {
                return false;
            }
            BaiduMap.mapStatusReason |= 1;
            this.f7900i.A();
            this.f7900i.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
            this.f7900i.L();
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        e eVar = this.f7900i;
        if (eVar == null || (aVar = eVar.f7928i) == null || !eVar.k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f7900i.l);
        if (this.f7900i.f7927h == null) {
            return;
        }
        if (a2 == null || a2.equals("")) {
            for (l lVar : this.f7900i.f7927h) {
                GeoPoint b2 = this.f7900i.b((int) motionEvent.getX(), (int) motionEvent.getY());
                if (lVar != null) {
                    lVar.c(b2);
                }
            }
            return;
        }
        for (l lVar2 : this.f7900i.f7927h) {
            if (lVar2.b(a2)) {
                this.f7900i.p = true;
            } else {
                lVar2.c(this.f7900i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        JSONObject jSONObject;
        e eVar = this.f7900i;
        if (eVar == null || (aVar = eVar.f7928i) == null || !eVar.k || eVar.f7927h == null) {
            return true;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f7900i.l);
        JSONObject jSONObject2 = null;
        if (a2 == null || a2.equals("")) {
            for (l lVar : this.f7900i.f7927h) {
                if (lVar != null) {
                    lVar.a(this.f7900i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
                    while (r7.hasNext()) {
                    }
                    return true;
                }
            } catch (JSONException e3) {
                e = e3;
            }
            for (l lVar2 : this.f7900i.f7927h) {
                if (jSONObject != null && lVar2 != null) {
                    lVar2.a(jSONObject.toString());
                }
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r0 == ((r2.left - r2.right) / 2)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r0 == ((r2.bottom - r2.top) / 2)) goto L22;
     */
    @Override // android.view.TextureView.SurfaceTextureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (this.f7900i == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.f7898g;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.f7898g = surfaceTexture;
        m mVar = new m(this.f7898g, this, new AtomicBoolean(true), this);
        this.f7899h = mVar;
        mVar.start();
        f7892a = i2;
        f7893b = i3;
        ab E = this.f7900i.E();
        if (E == null) {
            return;
        }
        int i4 = E.f7879f;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound = E.j;
        }
        E.f7879f = -1;
        int i5 = E.f7880g;
        if (i5 != 0 && i5 != -1) {
            WinRound winRound2 = E.j;
        }
        E.f7880g = -1;
        WinRound winRound3 = E.j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i3;
        winRound3.right = i2;
        this.f7900i.a(E);
        this.f7900i.a(f7892a, f7893b);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r0 == ((r2.bottom - r2.top) / 2)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r0 == ((r2.left - r2.right) / 2)) goto L18;
     */
    @Override // android.view.TextureView.SurfaceTextureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        e eVar = this.f7900i;
        if (eVar == null) {
            return;
        }
        f7892a = i2;
        f7893b = i3;
        f7894c = 1;
        ab E = eVar.E();
        int i4 = E.f7879f;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound = E.j;
        }
        E.f7879f = -1;
        int i5 = E.f7880g;
        if (i5 != 0 && i5 != -1) {
            WinRound winRound2 = E.j;
        }
        E.f7880g = -1;
        WinRound winRound3 = E.j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i3;
        winRound3.right = i2;
        this.f7900i.a(E);
        this.f7900i.a(f7892a, f7893b);
        MapRenderer.nativeResize(this.f7900i.j, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        m mVar;
        if (!this.f7897f || (mVar = this.f7899h) == null) {
            return;
        }
        mVar.a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar = this.f7900i;
        if (eVar == null || eVar.f7928i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        List<l> list = this.f7900i.f7927h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.a(motionEvent);
                }
            }
        }
        if (this.f7895d.onTouchEvent(motionEvent)) {
            return true;
        }
        return this.f7900i.a(motionEvent);
    }
}
