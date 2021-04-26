package com.baidu.pano.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.pano.platform.comjni.JNIEngine;
import com.baidu.pano.platform.comjni.JNITool;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public float f9379c;

    /* renamed from: i  reason: collision with root package name */
    public float f9385i;
    public float j;
    public Timer k;
    public TimerTask l;
    public Timer m;
    public TimerTask n;
    public Handler o;
    public Context p;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.pano.platform.c.a f9377a = new com.baidu.pano.platform.c.a();

    /* renamed from: b  reason: collision with root package name */
    public int f9378b = 0;

    /* renamed from: d  reason: collision with root package name */
    public final long f9380d = 16;

    /* renamed from: e  reason: collision with root package name */
    public final int f9381e = 1001;

    /* renamed from: f  reason: collision with root package name */
    public final int f9382f = 1002;

    /* renamed from: g  reason: collision with root package name */
    public int f9383g = 0;

    /* renamed from: h  reason: collision with root package name */
    public double f9384h = 0.0d;
    public Object q = new Object();

    public e(Context context) {
        this.p = context;
        a();
        h();
    }

    private void h() {
        this.o = new f(this);
    }

    private void i() {
        if (this.l != null) {
            return;
        }
        this.k = new Timer(true);
        g gVar = new g(this);
        this.l = gVar;
        this.k.schedule(gVar, 16L, 16L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this.q) {
            if (this.k != null) {
                this.k.cancel();
                this.k = null;
            }
            if (this.l != null) {
                this.l.cancel();
                this.l = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Timer timer = this.m;
        if (timer != null) {
            timer.cancel();
            this.m = null;
        }
        TimerTask timerTask = this.n;
        if (timerTask != null) {
            timerTask.cancel();
            this.n = null;
        }
    }

    public void g() {
        JNIEngine.removePoiMarker();
    }

    private float d(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f9378b = 1;
        } else if (action == 1) {
            this.f9378b = 0;
        } else if (action == 2) {
            if (this.f9378b == 2) {
                double d2 = d(motionEvent);
                float f2 = (float) (d2 / this.f9384h);
                if (Math.abs(1.0f - f2) > 0.01f) {
                    this.f9384h = d2;
                    float c2 = c() / f2;
                    if (c2 > 60.0f) {
                        c2 = 60.0f;
                    } else if (c2 < 20.0f) {
                        c2 = 20.0f;
                    }
                    Message obtainMessage = this.o.obtainMessage();
                    obtainMessage.what = 1002;
                    obtainMessage.arg1 = (int) c2;
                    this.o.sendMessage(obtainMessage);
                }
            }
            return true;
        } else if (action == 5) {
            this.f9378b = 2;
            this.f9379c = c();
            this.f9384h = d(motionEvent);
        } else if (action == 6) {
            this.f9378b = 0;
        }
        return false;
    }

    public void e() {
        JNIEngine.pause();
    }

    public boolean f() {
        return JNIEngine.removeAllCustomMarker();
    }

    public boolean a(MotionEvent motionEvent) {
        j();
        return true;
    }

    public boolean b(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f9385i = f2;
        this.j = f3;
        i();
        return false;
    }

    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (this.f9378b == 1) {
            if (Math.abs(f2) < 1.0f) {
                f2 = 0.0f;
            } else if (Math.abs(f3) < 1.0f) {
                f3 = 0.0f;
            }
            a(f2, f3);
            return true;
        }
        return false;
    }

    public void d() {
        JNIEngine.resume();
    }

    public boolean b(MotionEvent motionEvent) {
        float c2 = c();
        if (c2 < 20.0f) {
            c2 = 20.0f;
        } else if (c2 > 60.0f) {
            c2 = 60.0f;
        }
        if (c2 == 60.0f) {
            this.f9377a.a(60.0f, 40.0f);
            c(1);
        } else {
            int i2 = (c2 > 40.0f ? 1 : (c2 == 40.0f ? 0 : -1));
            if (i2 == 0) {
                this.f9377a.a(40.0f, 20.0f);
                c(2);
            } else {
                int i3 = (c2 > 20.0f ? 1 : (c2 == 20.0f ? 0 : -1));
                if (i3 == 0) {
                    this.f9377a.a(20.0f, 60.0f);
                    c(3);
                } else if (i3 > 0 && c2 < 40.0f) {
                    this.f9377a.a(c2, 20.0f);
                    c(4);
                } else if (i2 > 0 && c2 < 60.0f) {
                    this.f9377a.a(c2, 40.0f);
                    c(5);
                }
            }
        }
        return true;
    }

    public void d(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        JNIEngine.addPoiMarker(bundle.getDouble("x"), bundle.getDouble("y"), bundle.getFloat("z"));
    }

    public void a() {
        JNIEngine.initEngine(this.p.getApplicationContext());
        JNIEngine.setArrowTextStyle(-16777216, 0, 437918234);
    }

    public void a(float f2, float f3) {
        JNIEngine.setCameraRotationBySpace(f2, f3);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return JNIEngine.setArrowTextureByUrl(str);
    }

    public void a(float f2, float f3, float f4) {
        JNIEngine.setCameraRotationByAngle(f2, f3, f4);
    }

    public float a(int i2) {
        return JNIEngine.getCameraRotation(i2);
    }

    public void d(boolean z) {
        JNIEngine.enableFastMove(z);
    }

    public void a(float f2) {
        JNIEngine.setCameraFOV(f2);
    }

    public double[] d(float f2, float f3) {
        return JNIEngine.screenPt2Mercator(f2, f3);
    }

    public void a(Object obj, int i2, int i3, int i4) {
        JNIEngine.onSurfaceChanged(obj, i2, i3, i4);
    }

    public void a(String str) {
        JNIEngine.setPanoramaByPid(str);
    }

    public void a(int i2, int i3) {
        JNIEngine.setPanoramaByMercator(i2, i3);
    }

    public void a(double d2, double d3) {
        a((int) JNITool.ll2mc(d2, d3).x, (int) JNITool.ll2mc(d2, d3).y);
    }

    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        JNIEngine.destroySurface();
        long currentTimeMillis2 = System.currentTimeMillis();
        com.baidu.pano.platform.c.g.a("start-end" + (currentTimeMillis2 - currentTimeMillis));
    }

    private void c(int i2) {
        if (this.n != null) {
            return;
        }
        this.m = new Timer(true);
        h hVar = new h(this, i2);
        this.n = hVar;
        this.m.schedule(hVar, 16L, 16L);
    }

    public void a(boolean z) {
        JNIEngine.setCumtomMarkerShow(z);
    }

    public boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return JNIEngine.addCustomMarkerByURL(bundle.getString("key"), bundle.getDouble("x"), bundle.getDouble("y"), bundle.getFloat("z"), bundle.getString("image_url"), bundle.getFloat("width"), bundle.getFloat("height"));
    }

    public void b(float f2, float f3) {
        JNIEngine.setPitchLimit(f2, f3);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JNIEngine.setPanoramaByUid(str);
    }

    public float c() {
        return JNIEngine.getCameraFOV();
    }

    public void b(int i2) {
        JNIEngine.setTexureLevel(i2);
    }

    public void c(float f2, float f3) {
        JNIEngine.procClickEvent(f2, f3);
    }

    public boolean b(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return JNIEngine.addCustomMarkerByText(bundle.getString("key"), bundle.getDouble("x"), bundle.getDouble("y"), bundle.getFloat("z"), bundle.getString("text"), bundle.getInt("fontsize"), bundle.getInt("fontcolor"), bundle.getInt("bgcolor"), com.baidu.pano.platform.c.d.a(bundle.getInt("paddingleft"), bundle.getInt("paddingtop"), bundle.getInt("paddingright"), bundle.getInt("paddingbottom")));
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            JNIEngine.showCertifyMarkerByText(bundle.getString("text"), bundle.getFloat("fontsize"), bundle.getInt("fontcolor"), bundle.getInt("bgcolor"), bundle.getLong("padding"));
        }
    }

    public boolean a(Bundle bundle, Bitmap bitmap) {
        if (bundle == null) {
            return false;
        }
        return JNIEngine.addCustomMarkerByBitmap(bundle.getString("key"), bundle.getDouble("x"), bundle.getDouble("y"), bundle.getFloat("z"), bitmap);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return JNIEngine.removeCustomMarker(str);
    }

    public boolean c(boolean z) {
        return JNIEngine.setArrowShow(z);
    }

    public void a(String str, float f2, float f3) {
        JNIEngine.setCustomMarkerAnchor(str, f2, f3);
    }

    public boolean c(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        boolean arrowTextureByBitmap = JNIEngine.setArrowTextureByBitmap(bitmap);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return arrowTextureByBitmap;
    }

    public void a(Bitmap bitmap) {
        JNIEngine.setEntranceBitmap(bitmap);
        if (bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public void b(Bitmap bitmap) {
        JNIEngine.setPoiBitmap(bitmap);
        if (bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public void b(boolean z) {
        JNIEngine.setPoiMarkerVisibility(z);
    }
}
