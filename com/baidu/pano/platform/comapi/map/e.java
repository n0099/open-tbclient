package com.baidu.pano.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.mobstat.Config;
import com.baidu.pano.platform.comjni.JNIEngine;
import com.baidu.pano.platform.comjni.JNITool;
import com.baidu.searchbox.config.FontSizeConfig;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public class e {
    private float c;
    private float i;
    private float j;
    private Timer k;
    private TimerTask l;
    private Timer m;
    private TimerTask n;
    private Handler o;
    private Context p;
    private com.baidu.pano.platform.c.a a = new com.baidu.pano.platform.c.a();
    private int b = 0;
    private final long d = 16;
    private final int e = 1001;
    private final int f = 1002;
    private int g = 0;
    private double h = 0.0d;
    private Object q = new Object();

    public e(Context context) {
        this.p = context;
        a();
        h();
    }

    private void h() {
        this.o = new f(this);
    }

    public boolean a(MotionEvent motionEvent) {
        j();
        return true;
    }

    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.b == 1) {
            if (Math.abs(f) < 1.0f) {
                f = 0.0f;
            } else if (Math.abs(f2) < 1.0f) {
                f2 = 0.0f;
            }
            a(f, f2);
            return true;
        }
        return false;
    }

    public boolean b(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.i = f;
        this.j = f2;
        i();
        return false;
    }

    public boolean b(MotionEvent motionEvent) {
        float c = c();
        if (c < 20.0f) {
            c = 20.0f;
        } else if (c > 60.0f) {
            c = 60.0f;
        }
        if (c == 60.0f) {
            this.a.a(60.0f, 40.0f);
            c(1);
        } else if (c == 40.0f) {
            this.a.a(40.0f, 20.0f);
            c(2);
        } else if (c == 20.0f) {
            this.a.a(20.0f, 60.0f);
            c(3);
        } else if (c > 20.0f && c < 40.0f) {
            this.a.a(c, 20.0f);
            c(4);
        } else if (c > 40.0f && c < 60.0f) {
            this.a.a(c, 40.0f);
            c(5);
        }
        return true;
    }

    public boolean c(MotionEvent motionEvent) {
        float f = 60.0f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.b = 1;
                break;
            case 1:
                this.b = 0;
                break;
            case 2:
                if (this.b == 2) {
                    float d = d(motionEvent);
                    float f2 = (float) (d / this.h);
                    if (Math.abs(1.0f - f2) > 0.01f) {
                        this.h = d;
                        float c = c() / f2;
                        if (c <= 60.0f) {
                            f = c < 20.0f ? 20.0f : c;
                        }
                        Message obtainMessage = this.o.obtainMessage();
                        obtainMessage.what = 1002;
                        obtainMessage.arg1 = (int) f;
                        this.o.sendMessage(obtainMessage);
                    }
                }
                return true;
            case 5:
                this.b = 2;
                this.c = c();
                this.h = d(motionEvent);
                break;
            case 6:
                this.b = 0;
                break;
        }
        return false;
    }

    private void i() {
        if (this.l == null) {
            this.k = new Timer(true);
            this.l = new g(this);
            this.k.schedule(this.l, 16L, 16L);
        }
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

    private void c(int i) {
        if (this.n == null) {
            this.m = new Timer(true);
            this.n = new h(this, i);
            this.m.schedule(this.n, 16L, 16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
    }

    private float d(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void a() {
        JNIEngine.initEngine(this.p.getApplicationContext());
        JNIEngine.setArrowTextStyle(ViewCompat.MEASURED_STATE_MASK, 0, 437918234);
    }

    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        JNIEngine.destroySurface();
        com.baidu.pano.platform.c.g.a("start-end" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void a(float f, float f2) {
        JNIEngine.setCameraRotationBySpace(f, f2);
    }

    public void a(float f, float f2, float f3) {
        JNIEngine.setCameraRotationByAngle(f, f2, f3);
    }

    public float a(int i) {
        return JNIEngine.getCameraRotation(i);
    }

    public void a(float f) {
        JNIEngine.setCameraFOV(f);
    }

    public float c() {
        return JNIEngine.getCameraFOV();
    }

    public void b(float f, float f2) {
        JNIEngine.setPitchLimit(f, f2);
    }

    public void c(float f, float f2) {
        JNIEngine.procClickEvent(f, f2);
    }

    public void a(Object obj, int i, int i2, int i3) {
        JNIEngine.onSurfaceChanged(obj, i, i2, i3);
    }

    public void a(String str) {
        JNIEngine.setPanoramaByPid(str);
    }

    public void a(int i, int i2) {
        JNIEngine.setPanoramaByMercator(i, i2);
    }

    public void a(double d, double d2) {
        a((int) JNITool.ll2mc(d, d2).x, (int) JNITool.ll2mc(d, d2).y);
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            JNIEngine.setPanoramaByUid(str);
        }
    }

    public void b(int i) {
        JNIEngine.setTexureLevel(i);
    }

    public void d() {
        JNIEngine.resume();
    }

    public void e() {
        JNIEngine.pause();
    }

    public void a(boolean z) {
        JNIEngine.setCumtomMarkerShow(z);
    }

    public boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return JNIEngine.addCustomMarkerByURL(bundle.getString("key"), bundle.getDouble(Config.EVENT_HEAT_X), bundle.getDouble("y"), bundle.getFloat("z"), bundle.getString("image_url"), bundle.getFloat("width"), bundle.getFloat("height"));
    }

    public boolean b(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return JNIEngine.addCustomMarkerByText(bundle.getString("key"), bundle.getDouble(Config.EVENT_HEAT_X), bundle.getDouble("y"), bundle.getFloat("z"), bundle.getString("text"), bundle.getInt(FontSizeConfig.FONT_SIZE_COOKIE), bundle.getInt("fontcolor"), bundle.getInt("bgcolor"), com.baidu.pano.platform.c.d.a(bundle.getInt("paddingleft"), bundle.getInt("paddingtop"), bundle.getInt("paddingright"), bundle.getInt("paddingbottom")));
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            JNIEngine.showCertifyMarkerByText(bundle.getString("text"), bundle.getFloat(FontSizeConfig.FONT_SIZE_COOKIE), bundle.getInt("fontcolor"), bundle.getInt("bgcolor"), bundle.getLong("padding"));
        }
    }

    public boolean a(Bundle bundle, Bitmap bitmap) {
        if (bundle == null) {
            return false;
        }
        return JNIEngine.addCustomMarkerByBitmap(bundle.getString("key"), bundle.getDouble(Config.EVENT_HEAT_X), bundle.getDouble("y"), bundle.getFloat("z"), bitmap);
    }

    public void a(String str, float f, float f2) {
        JNIEngine.setCustomMarkerAnchor(str, f, f2);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return JNIEngine.removeCustomMarker(str);
    }

    public boolean f() {
        return JNIEngine.removeAllCustomMarker();
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            JNIEngine.addPoiMarker(bundle.getDouble(Config.EVENT_HEAT_X), bundle.getDouble("y"), bundle.getFloat("z"));
        }
    }

    public void a(Bitmap bitmap) {
        JNIEngine.setEntranceBitmap(bitmap);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public void b(Bitmap bitmap) {
        JNIEngine.setPoiBitmap(bitmap);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public void b(boolean z) {
        JNIEngine.setPoiMarkerVisibility(z);
    }

    public void g() {
        JNIEngine.removePoiMarker();
    }

    public boolean c(boolean z) {
        return JNIEngine.setArrowShow(z);
    }

    public boolean c(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        boolean arrowTextureByBitmap = JNIEngine.setArrowTextureByBitmap(bitmap);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
            return arrowTextureByBitmap;
        }
        return arrowTextureByBitmap;
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return JNIEngine.setArrowTextureByUrl(str);
    }

    public void d(boolean z) {
        JNIEngine.enableFastMove(z);
    }

    public double[] d(float f, float f2) {
        return JNIEngine.screenPt2Mercator(f, f2);
    }
}
