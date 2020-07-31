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
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.mobstat.Config;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public class ac extends TextureView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, TextureView.SurfaceTextureListener, m.a {
    public static int a;
    public static int b;
    public static int c;
    private GestureDetector d;
    private Handler e;
    private boolean f;
    private SurfaceTexture g;
    private m h;
    private e i;

    public ac(Context context, z zVar, String str, int i) {
        super(context);
        this.f = false;
        this.h = null;
        a(context, zVar, str, i);
    }

    private void a(Context context, z zVar, String str, int i) {
        setSurfaceTextureListener(this);
        if (context == null) {
            throw new RuntimeException("when you create an mapview, the context can not be null");
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

    private void e() {
        this.e = new ad(this);
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.m.a
    public int a() {
        if (this.i == null) {
            return 0;
        }
        if (c <= 1) {
            MapRenderer.nativeResize(this.i.j, a, b);
            c++;
        }
        return MapRenderer.nativeRender(this.i.j);
    }

    public void a(int i) {
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

    public void a(String str, Rect rect) {
        if (this.i == null || this.i.i == null) {
            return;
        }
        if (rect == null) {
            this.i.i.a(str, (Bundle) null);
            if (this.h != null) {
                this.h.a();
                return;
            }
            return;
        }
        int i = rect.left;
        int i2 = b < rect.bottom ? 0 : b - rect.bottom;
        int width = rect.width();
        int height = rect.height();
        if (i < 0 || i2 < 0 || width <= 0 || height <= 0) {
            return;
        }
        if (width > a) {
            width = Math.abs(rect.width()) - (rect.right - a);
        }
        if (height > b) {
            height = Math.abs(rect.height()) - (rect.bottom - b);
        }
        if (i > SysOSUtil.getScreenSizeX() || i2 > SysOSUtil.getScreenSizeY()) {
            this.i.i.a(str, (Bundle) null);
            if (this.h != null) {
                this.h.a();
                return;
            }
            return;
        }
        a = width;
        b = height;
        Bundle bundle = new Bundle();
        bundle.putInt(Config.EVENT_HEAT_X, i);
        bundle.putInt("y", i2);
        bundle.putInt("width", width);
        bundle.putInt("height", height);
        this.i.i.a(str, bundle);
        if (this.h != null) {
            this.h.a();
        }
    }

    public e b() {
        return this.i;
    }

    public void c() {
        if (this.i == null || this.i.i == null) {
            return;
        }
        if (this.i.h != null) {
            for (l lVar : this.i.h) {
                if (lVar != null) {
                    lVar.d();
                }
            }
        }
        this.i.i.g();
        this.i.i.d();
        this.i.i.n();
        if (this.h != null) {
            this.h.a();
        }
        if (this.i.b()) {
            this.f = true;
        }
    }

    public void d() {
        if (this.i == null || this.i.i == null) {
            return;
        }
        this.f = false;
        this.i.i.c();
        synchronized (this.i) {
            this.i.i.c();
            if (this.h != null) {
                this.h.b();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.i == null || this.i.i == null || !this.i.k) {
            return true;
        }
        GeoPoint b2 = this.i.b((int) motionEvent.getX(), (int) motionEvent.getY());
        if (b2 != null) {
            if (this.i.h != null) {
                for (l lVar : this.i.h) {
                    if (lVar != null) {
                        lVar.b(b2);
                    }
                }
            }
            if (this.i.f) {
                ab E = this.i.E();
                E.a += 1.0f;
                if (!this.i.g) {
                    E.d = b2.getLongitudeE6();
                    E.e = b2.getLatitudeE6();
                }
                BaiduMap.mapStatusReason |= 1;
                this.i.a(E, 300);
                e eVar = this.i;
                e.m = System.currentTimeMillis();
                return true;
            }
            return false;
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
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.i == null || this.i.i == null || !this.i.k) {
            return true;
        }
        if (this.i.e) {
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            if (sqrt > 500.0f) {
                BaiduMap.mapStatusReason |= 1;
                this.i.A();
                this.i.a(34, (int) (sqrt * 0.6f), (((int) motionEvent2.getY()) << 16) | ((int) motionEvent2.getX()));
                this.i.L();
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.i == null || this.i.i == null || !this.i.k) {
            return;
        }
        String a2 = this.i.i.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.i.l);
        if (this.i.h != null) {
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
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2;
        if (this.i != null && this.i.i != null && this.i.k && this.i.h != null) {
            String a2 = this.i.i.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.i.l);
            if (a2 == null || a2.equals("")) {
                for (l lVar : this.i.h) {
                    if (lVar != null) {
                        lVar.a(this.i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                    }
                }
            } else {
                try {
                    jSONObject = new JSONObject(a2);
                } catch (JSONException e2) {
                    jSONObject = null;
                    e = e2;
                }
                try {
                    jSONObject.put("px", (int) motionEvent.getX());
                    jSONObject.put("py", (int) motionEvent.getY());
                    jSONObject2 = jSONObject;
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    jSONObject2 = jSONObject;
                    while (r2.hasNext()) {
                    }
                    return true;
                }
                for (l lVar2 : this.i.h) {
                    if (jSONObject2 != null && lVar2 != null) {
                        lVar2.a(jSONObject2.toString());
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.i == null) {
            return;
        }
        if (this.g != null) {
            setSurfaceTexture(this.g);
            return;
        }
        this.g = surfaceTexture;
        this.h = new m(this.g, this, new AtomicBoolean(true), this);
        this.h.start();
        a = i;
        b = i2;
        ab E = this.i.E();
        if (E != null) {
            if (E.f == 0 || E.f == -1 || E.f == (E.j.left - E.j.right) / 2) {
                E.f = -1;
            }
            if (E.g == 0 || E.g == -1 || E.g == (E.j.bottom - E.j.top) / 2) {
                E.g = -1;
            }
            E.j.left = 0;
            E.j.top = 0;
            E.j.bottom = i2;
            E.j.right = i;
            this.i.a(E);
            this.i.a(a, b);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.i == null) {
            return;
        }
        a = i;
        b = i2;
        c = 1;
        ab E = this.i.E();
        if (E.f == 0 || E.f == -1 || E.f == (E.j.left - E.j.right) / 2) {
            E.f = -1;
        }
        if (E.g == 0 || E.g == -1 || E.g == (E.j.bottom - E.j.top) / 2) {
            E.g = -1;
        }
        E.j.left = 0;
        E.j.top = 0;
        E.j.bottom = i2;
        E.j.right = i;
        this.i.a(E);
        this.i.a(a, b);
        MapRenderer.nativeResize(this.i.j, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (!this.f || this.h == null) {
            return;
        }
        this.h.a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i == null || this.i.i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        if (this.i.h != null) {
            for (l lVar : this.i.h) {
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
}
