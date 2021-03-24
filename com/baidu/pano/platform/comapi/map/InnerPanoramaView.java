package com.baidu.pano.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.lbsapi.panoramaview.ImageMarker;
import com.baidu.lbsapi.panoramaview.PanoramaView;
import com.baidu.lbsapi.panoramaview.PanoramaViewListener;
import com.baidu.lbsapi.panoramaview.StatisticsCallback;
import com.baidu.pano.platform.comjni.MessageProxy;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class InnerPanoramaView extends BaseGLMapView {

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, com.baidu.pano.platform.comapi.a.a> f9477d;

    /* renamed from: e  reason: collision with root package name */
    public PanoramaViewListener f9478e;

    /* renamed from: f  reason: collision with root package name */
    public String f9479f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.pano.platform.comapi.a.b f9480g;

    /* renamed from: h  reason: collision with root package name */
    public PanoramaView f9481h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public String n;
    public double o;
    public double p;
    public StatisticsCallback q;
    public boolean r;
    public boolean s;
    public Handler t;

    public InnerPanoramaView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.pano.platform.comapi.map.BaseGLMapView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public InnerPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9477d = new HashMap<>();
        this.r = true;
        this.s = true;
        this.t = new c(this);
        BaseGLMapView.f9471b = context;
        MessageProxy.registerPanoViewListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("Type", "");
            if (optString.equals("street")) {
                this.f9473a.b(-15.0f, 90.0f);
            } else if (optString.equals("inter")) {
                this.f9473a.b(-25.0f, 90.0f);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("X");
                int optInt2 = jSONObject.optInt("RX");
                int optInt3 = jSONObject.optInt("Y");
                int optInt4 = jSONObject.optInt("RY");
                if (optInt > 100000000) {
                    jSONObject.remove("X");
                    jSONObject.put("X", optInt / 100);
                }
                if (optInt2 > 100000000) {
                    jSONObject.remove("RX");
                    jSONObject.put("RX", optInt2 / 100);
                }
                if (optInt3 > 10000000) {
                    jSONObject.remove("Y");
                    jSONObject.put("Y", optInt3 / 100);
                }
                if (optInt4 > 10000000) {
                    jSONObject.remove("RY");
                    jSONObject.put("RY", optInt4 / 100);
                }
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public void d() {
        MessageProxy.unRegisterPanoViewListener();
        this.f9473a.b();
    }

    public float c() {
        e eVar = this.f9473a;
        if (eVar != null) {
            return eVar.c();
        }
        throw new NullPointerException("PanoController is null!");
    }

    public void b(String str) {
        if (this.s) {
            this.r = false;
            if (!TextUtils.isEmpty(str)) {
                e eVar = this.f9473a;
                if (eVar != null) {
                    eVar.b(str);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("when you set the uid of panorama, it can not be null or empty string.");
        }
    }

    public void d(String str) {
        com.baidu.pano.platform.comapi.a.b bVar = this.f9480g;
        if (bVar != null) {
            bVar.a(str);
            this.f9473a.b(this.f9480g.f9466d);
        }
    }

    public String a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            if (i == 101) {
                jSONObject.put("error", "引擎初始化失败");
            } else if (i == 102) {
                jSONObject.put("error", "描述信息加载失败");
            } else if (i == 103) {
                jSONObject.put("error", "全景图加载失败");
            } else if (i == 201) {
                jSONObject.put("error", "该UID下对应的POI没有全景");
            } else if (i == 202) {
                jSONObject.put("error", "无法显示内景相册, 因为没有引入内景相册插件");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean c(String str) {
        e eVar = this.f9473a;
        if (eVar == null) {
            return false;
        }
        return eVar.d(str);
    }

    public void d(boolean z) {
        e eVar = this.f9473a;
        if (eVar != null) {
            eVar.d(z);
        }
    }

    public void c(boolean z) {
        e eVar = this.f9473a;
        if (eVar != null) {
            eVar.b(z);
        }
    }

    public void f() {
        this.f9473a.g();
    }

    public void b(float f2) {
        if (this.f9473a != null) {
            while (f2 < 0.0f) {
                f2 += 360.0f;
            }
            this.f9473a.a(a(), f2 % 360.0f, 0.0f);
        }
    }

    public float b() {
        e eVar = this.f9473a;
        if (eVar != null) {
            return eVar.a(2);
        }
        throw new NullPointerException("PanoController is null!");
    }

    public void a(String str) {
        if (this.s) {
            this.r = false;
            e eVar = this.f9473a;
            if (eVar != null) {
                eVar.a(str);
            }
        }
    }

    public void b(int i) {
        e eVar = this.f9473a;
        if (eVar == null || i < 1 || i > 5) {
            return;
        }
        eVar.a(70 - (i * 10));
    }

    public void b(Bitmap bitmap) {
        this.f9473a.c(bitmap);
    }

    public void a(int i, int i2) {
        if (this.s) {
            this.r = false;
            e eVar = this.f9473a;
            if (eVar != null) {
                eVar.a(i, i2);
            }
        }
    }

    public void b(boolean z) {
        e eVar = this.f9473a;
        if (eVar != null) {
            eVar.a(z);
        }
    }

    public boolean b(com.baidu.pano.platform.comapi.a.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, com.baidu.pano.platform.comapi.a.a> entry : this.f9477d.entrySet()) {
                String str = aVar.mKey;
                if (str != null && str.equals(entry.getKey())) {
                    boolean c2 = this.f9473a.c(entry.getKey());
                    if (c2) {
                        this.f9477d.remove(entry.getKey());
                    }
                    return c2;
                }
            }
            throw new IllegalStateException("the overlay item have not been added, you can not remove it.");
        }
        throw new IllegalArgumentException("when you remove an overlay item, it can not be null");
    }

    public void a(double d2, double d3) {
        if (this.s) {
            this.r = false;
            e eVar = this.f9473a;
            if (eVar != null) {
                eVar.a(d2, d3);
            }
        }
    }

    public boolean e() {
        boolean f2 = this.f9473a.f();
        if (f2) {
            this.f9477d.clear();
        }
        return f2;
    }

    public void a(float f2) {
        if (this.f9473a != null) {
            if (f2 < -90.0f) {
                f2 = -90.0f;
            } else if (f2 > 90.0f) {
                f2 = 90.0f;
            }
            this.f9473a.a(f2, b(), 0.0f);
        }
    }

    public float a() {
        e eVar = this.f9473a;
        if (eVar != null) {
            return eVar.a(1);
        }
        throw new NullPointerException("PanoController is null!");
    }

    public void a(PanoramaView.ImageDefinition imageDefinition) {
        e eVar = this.f9473a;
        if (eVar != null) {
            eVar.b(imageDefinition.getValue());
        }
    }

    public boolean a(Bitmap bitmap) {
        e eVar = this.f9473a;
        if (eVar == null) {
            return false;
        }
        return eVar.c(bitmap);
    }

    public void a(boolean z) {
        e eVar = this.f9473a;
        if (eVar != null) {
            eVar.c(z);
        }
    }

    public boolean a(com.baidu.pano.platform.comapi.a.a aVar) {
        boolean a2;
        if (aVar != null) {
            for (Map.Entry<String, com.baidu.pano.platform.comapi.a.a> entry : this.f9477d.entrySet()) {
                if (aVar.equals(entry.getValue())) {
                    throw new IllegalStateException("the overlay item have been added, you can not add it again");
                }
            }
            String str = String.valueOf(System.currentTimeMillis()) + String.valueOf(this.f9477d.size());
            Bundle bundle = aVar.toBundle(str, new Bundle());
            if (1003 == bundle.getInt("markerType")) {
                a2 = this.f9473a.b(bundle);
            } else if (1001 == bundle.getInt("markerType")) {
                a2 = this.f9473a.a(bundle);
            } else {
                a2 = 1002 == bundle.getInt("markerType") ? this.f9473a.a(bundle, ((ImageMarker) aVar).getMarkerBitmap()) : false;
            }
            if (a2) {
                this.f9477d.put(str, aVar);
            }
            return a2;
        }
        throw new IllegalArgumentException("when you add an overlay item, it can not be null");
    }

    public boolean a(String str, double d2, double d3, double d4, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putDouble("x", d2 * 100.0d);
        bundle.putDouble("y", d3 * 100.0d);
        bundle.putFloat("z", ((float) d4) * 100.0f);
        return this.f9473a.a(bundle, bitmap);
    }

    public void a(String str, float f2, float f3) {
        e eVar = this.f9473a;
        if (eVar != null) {
            eVar.a(str, f2, f3);
        }
    }

    public void a(String str, String str2, PanoramaView panoramaView, com.baidu.pano.platform.comapi.a.b bVar) {
        this.i = str;
        this.j = str2;
        this.f9481h = panoramaView;
        this.f9480g = bVar;
    }

    public void a(com.baidu.pano.platform.comapi.a.b bVar) {
        if (bVar != null) {
            this.f9473a.d(bVar.toBundle("", new Bundle()));
            if (bVar.f9464b) {
                this.f9473a.a(bVar.f9465c);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("when you add an overlay item, it can not be null");
    }

    public double[] a(float f2, float f3) {
        e eVar = this.f9473a;
        if (eVar != null) {
            return eVar.d(f2, f3);
        }
        return null;
    }

    public void a(PanoramaViewListener panoramaViewListener) {
        this.f9478e = panoramaViewListener;
    }

    public String a(double d2, double d3, double d4, double d5) {
        long sqrt = (long) Math.sqrt(Math.pow(d2 - d4, 2.0d) + Math.pow(d3 - d5, 2.0d));
        if (sqrt > 10000) {
            return "";
        }
        if (sqrt <= 10000 && sqrt > 1000) {
            return (sqrt / 1000) + "km";
        }
        return sqrt + "m";
    }

    public void a(StatisticsCallback statisticsCallback) {
        this.q = statisticsCallback;
    }
}
