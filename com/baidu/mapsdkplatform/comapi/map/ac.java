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
    public static int f7585a;

    /* renamed from: b  reason: collision with root package name */
    public static int f7586b;

    /* renamed from: c  reason: collision with root package name */
    public static int f7587c;

    /* renamed from: d  reason: collision with root package name */
    public GestureDetector f7588d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f7589e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7590f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f7591g;

    /* renamed from: h  reason: collision with root package name */
    public m f7592h;
    public e i;

    public ac(Context context, z zVar, String str, int i) {
        super(context);
        this.f7590f = false;
        this.f7592h = null;
        a(context, zVar, str, i);
    }

    private void a(Context context, z zVar, String str, int i) {
        setSurfaceTextureListener(this);
        if (context == null) {
            throw new RuntimeException("when you create an mapview, the context can not be null");
        }
        this.f7588d = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.i == null) {
            this.i = new e(context, str, i);
        }
        this.i.a(context.hashCode());
        this.i.a();
        this.i.a(zVar);
        e();
        this.i.a(this.f7589e);
        this.i.f();
    }

    private void e() {
        this.f7589e = new ad(this);
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.m.a
    public int a() {
        e eVar = this.i;
        if (eVar == null) {
            return 0;
        }
        if (f7587c <= 1) {
            MapRenderer.nativeResize(eVar.j, f7585a, f7586b);
            f7587c++;
        }
        return MapRenderer.nativeRender(this.i.j);
    }

    public void a(int i) {
        synchronized (this.i) {
            if (this.i.f7618h != null) {
                for (l lVar : this.i.f7618h) {
                    if (lVar != null) {
                        lVar.f();
                    }
                }
            }
            if (this.i != null) {
                this.i.b(this.f7589e);
                this.i.b(i);
                this.i = null;
            }
            this.f7589e.removeCallbacksAndMessages(null);
            if (this.f7592h != null) {
                this.f7592h.c();
                this.f7592h = null;
            }
            if (this.f7591g != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f7591g.release();
                }
                this.f7591g = null;
            }
        }
    }

    public void a(String str, Rect rect) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        m mVar;
        e eVar = this.i;
        if (eVar == null || (aVar = eVar.i) == null) {
            return;
        }
        if (rect != null) {
            int i = rect.left;
            int i2 = f7586b;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i4 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > f7585a) {
                width = Math.abs(rect.width()) - (rect.right - f7585a);
            }
            if (height > f7586b) {
                height = Math.abs(rect.height()) - (rect.bottom - f7586b);
            }
            if (i > SysOSUtil.getScreenSizeX() || i4 > SysOSUtil.getScreenSizeY()) {
                this.i.i.a(str, (Bundle) null);
                m mVar2 = this.f7592h;
                if (mVar2 != null) {
                    mVar2.a();
                    return;
                }
                return;
            }
            f7585a = width;
            f7586b = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i);
            bundle.putInt("y", i4);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.i.i.a(str, bundle);
            mVar = this.f7592h;
            if (mVar == null) {
                return;
            }
        } else {
            aVar.a(str, (Bundle) null);
            mVar = this.f7592h;
            if (mVar == null) {
                return;
            }
        }
        mVar.a();
    }

    public e b() {
        return this.i;
    }

    public void c() {
        e eVar = this.i;
        if (eVar == null || eVar.i == null) {
            return;
        }
        List<l> list = eVar.f7618h;
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
        m mVar = this.f7592h;
        if (mVar != null) {
            mVar.a();
        }
        if (this.i.b()) {
            this.f7590f = true;
        }
    }

    public void d() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        e eVar = this.i;
        if (eVar == null || (aVar = eVar.i) == null) {
            return;
        }
        this.f7590f = false;
        aVar.c();
        synchronized (this.i) {
            this.i.i.c();
            if (this.f7592h != null) {
                this.f7592h.b();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        e eVar = this.i;
        if (eVar == null || eVar.i == null || !eVar.k) {
            return true;
        }
        GeoPoint b2 = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
        if (b2 != null) {
            List<l> list = this.i.f7618h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.b(b2);
                    }
                }
            }
            e eVar2 = this.i;
            if (eVar2.f7616f) {
                ab E = eVar2.E();
                E.f7569a += 1.0f;
                if (!this.i.f7617g) {
                    E.f7572d = b2.getLongitudeE6();
                    E.f7573e = b2.getLatitudeE6();
                }
                BaiduMap.mapStatusReason |= 1;
                this.i.a(E, 300);
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
        e eVar = this.i;
        if (eVar == null || eVar.i == null || !eVar.k) {
            return true;
        }
        if (eVar.f7615e) {
            float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
            if (sqrt <= 500.0f) {
                return false;
            }
            BaiduMap.mapStatusReason |= 1;
            this.i.A();
            this.i.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
            this.i.L();
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        e eVar = this.i;
        if (eVar == null || (aVar = eVar.i) == null || !eVar.k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.i.l);
        if (this.i.f7618h == null) {
            return;
        }
        if (a2 == null || a2.equals("")) {
            for (l lVar : this.i.f7618h) {
                GeoPoint b2 = this.i.b((int) motionEvent.getX(), (int) motionEvent.getY());
                if (lVar != null) {
                    lVar.c(b2);
                }
            }
            return;
        }
        for (l lVar2 : this.i.f7618h) {
            if (lVar2.b(a2)) {
                this.i.p = true;
            } else {
                lVar2.c(this.i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
        e eVar = this.i;
        if (eVar == null || (aVar = eVar.i) == null || !eVar.k || eVar.f7618h == null) {
            return true;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.i.l);
        JSONObject jSONObject2 = null;
        if (a2 == null || a2.equals("")) {
            for (l lVar : this.i.f7618h) {
                if (lVar != null) {
                    lVar.a(this.i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
            for (l lVar2 : this.i.f7618h) {
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
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.i == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.f7591g;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.f7591g = surfaceTexture;
        m mVar = new m(this.f7591g, this, new AtomicBoolean(true), this);
        this.f7592h = mVar;
        mVar.start();
        f7585a = i;
        f7586b = i2;
        ab E = this.i.E();
        if (E == null) {
            return;
        }
        int i3 = E.f7574f;
        if (i3 != 0 && i3 != -1) {
            WinRound winRound = E.j;
        }
        E.f7574f = -1;
        int i4 = E.f7575g;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound2 = E.j;
        }
        E.f7575g = -1;
        WinRound winRound3 = E.j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i2;
        winRound3.right = i;
        this.i.a(E);
        this.i.a(f7585a, f7586b);
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
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        e eVar = this.i;
        if (eVar == null) {
            return;
        }
        f7585a = i;
        f7586b = i2;
        f7587c = 1;
        ab E = eVar.E();
        int i3 = E.f7574f;
        if (i3 != 0 && i3 != -1) {
            WinRound winRound = E.j;
        }
        E.f7574f = -1;
        int i4 = E.f7575g;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound2 = E.j;
        }
        E.f7575g = -1;
        WinRound winRound3 = E.j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i2;
        winRound3.right = i;
        this.i.a(E);
        this.i.a(f7585a, f7586b);
        MapRenderer.nativeResize(this.i.j, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        m mVar;
        if (!this.f7590f || (mVar = this.f7592h) == null) {
            return;
        }
        mVar.a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar = this.i;
        if (eVar == null || eVar.i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        List<l> list = this.i.f7618h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.a(motionEvent);
                }
            }
        }
        if (this.f7588d.onTouchEvent(motionEvent)) {
            return true;
        }
        return this.i.a(motionEvent);
    }
}
