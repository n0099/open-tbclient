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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.pano.platform.comjni.MessageProxy;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InnerPanoramaView extends BaseGLMapView {
    private HashMap<String, com.baidu.pano.platform.comapi.a.a> d;
    private PanoramaViewListener e;
    private String f;
    private com.baidu.pano.platform.comapi.a.b g;
    private PanoramaView h;
    private String i;
    private String j;
    private String k;
    private boolean l;
    private boolean m;
    private String n;
    private double o;
    private double p;
    private StatisticsCallback q;
    private boolean r;
    private boolean s;
    private Handler t;

    public InnerPanoramaView(Context context) {
        this(context, null);
    }

    public InnerPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new HashMap<>();
        this.r = true;
        this.s = true;
        this.t = new c(this);
        b = context;
        MessageProxy.registerPanoViewListener(new d(this));
    }

    @Override // com.baidu.pano.platform.comapi.map.BaseGLMapView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
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
            } catch (JSONException e) {
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }

    public String a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            if (i == 101) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, "引擎初始化失败");
            } else if (i == 102) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, "描述信息加载失败");
            } else if (i == 103) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, "全景图加载失败");
            } else if (i == 201) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, "该UID下对应的POI没有全景");
            } else if (i == 202) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, "无法显示内景相册, 因为没有引入内景相册插件");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("Type", "");
                if (optString.equals("street")) {
                    this.f2729a.b(-15.0f, 90.0f);
                } else if (optString.equals("inter")) {
                    this.f2729a.b(-25.0f, 90.0f);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str) {
        if (this.s) {
            this.r = false;
            if (this.f2729a != null) {
                this.f2729a.a(str);
            }
        }
    }

    public void a(int i, int i2) {
        if (this.s) {
            this.r = false;
            if (this.f2729a != null) {
                this.f2729a.a(i, i2);
            }
        }
    }

    public void a(double d, double d2) {
        if (this.s) {
            this.r = false;
            if (this.f2729a != null) {
                this.f2729a.a(d, d2);
            }
        }
    }

    public void b(String str) {
        if (this.s) {
            this.r = false;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("when you set the uid of panorama, it can not be null or empty string.");
            }
            if (this.f2729a != null) {
                this.f2729a.b(str);
            }
        }
    }

    public void a(float f) {
        if (this.f2729a != null) {
            if (f < -90.0f) {
                f = -90.0f;
            } else if (f > 90.0f) {
                f = 90.0f;
            }
            this.f2729a.a(f, b(), 0.0f);
        }
    }

    public float a() {
        if (this.f2729a != null) {
            return this.f2729a.a(1);
        }
        throw new NullPointerException("PanoController is null!");
    }

    public void b(float f) {
        if (this.f2729a != null) {
            while (f < 0.0f) {
                f += 360.0f;
            }
            this.f2729a.a(a(), f % 360.0f, 0.0f);
        }
    }

    public float b() {
        if (this.f2729a != null) {
            return this.f2729a.a(2);
        }
        throw new NullPointerException("PanoController is null!");
    }

    public void b(int i) {
        if (this.f2729a != null && i >= 1 && i <= 5) {
            this.f2729a.a(70 - (i * 10));
        }
    }

    public float c() {
        if (this.f2729a != null) {
            return this.f2729a.c();
        }
        throw new NullPointerException("PanoController is null!");
    }

    public void a(PanoramaView.ImageDefinition imageDefinition) {
        if (this.f2729a != null) {
            this.f2729a.b(imageDefinition.getValue());
        }
    }

    public boolean a(Bitmap bitmap) {
        if (this.f2729a == null) {
            return false;
        }
        return this.f2729a.c(bitmap);
    }

    public boolean c(String str) {
        if (this.f2729a == null) {
            return false;
        }
        return this.f2729a.d(str);
    }

    public void a(boolean z) {
        if (this.f2729a != null) {
            this.f2729a.c(z);
        }
    }

    public void b(Bitmap bitmap) {
        this.f2729a.c(bitmap);
    }

    public void d() {
        MessageProxy.unRegisterPanoViewListener();
        this.f2729a.b();
    }

    public void b(boolean z) {
        if (this.f2729a != null) {
            this.f2729a.a(z);
        }
    }

    public boolean a(com.baidu.pano.platform.comapi.a.a aVar) {
        boolean z;
        if (aVar == null) {
            throw new IllegalArgumentException("when you add an overlay item, it can not be null");
        }
        for (Map.Entry<String, com.baidu.pano.platform.comapi.a.a> entry : this.d.entrySet()) {
            if (aVar.equals(entry.getValue())) {
                throw new IllegalStateException("the overlay item have been added, you can not add it again");
            }
        }
        String str = String.valueOf(System.currentTimeMillis()) + String.valueOf(this.d.size());
        Bundle bundle = aVar.toBundle(str, new Bundle());
        if (1003 == bundle.getInt("markerType")) {
            z = this.f2729a.b(bundle);
        } else if (1001 == bundle.getInt("markerType")) {
            z = this.f2729a.a(bundle);
        } else if (1002 != bundle.getInt("markerType")) {
            z = false;
        } else {
            z = this.f2729a.a(bundle, ((ImageMarker) aVar).getMarkerBitmap());
        }
        if (z) {
            this.d.put(str, aVar);
        }
        return z;
    }

    public boolean a(String str, double d, double d2, double d3, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putDouble(Config.EVENT_HEAT_X, d * 100.0d);
        bundle.putDouble("y", d2 * 100.0d);
        bundle.putFloat("z", ((float) d3) * 100.0f);
        return this.f2729a.a(bundle, bitmap);
    }

    public void a(String str, float f, float f2) {
        if (this.f2729a != null) {
            this.f2729a.a(str, f, f2);
        }
    }

    public boolean b(com.baidu.pano.platform.comapi.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("when you remove an overlay item, it can not be null");
        }
        for (Map.Entry<String, com.baidu.pano.platform.comapi.a.a> entry : this.d.entrySet()) {
            if (aVar.mKey != null && aVar.mKey.equals(entry.getKey())) {
                boolean c = this.f2729a.c(entry.getKey());
                if (c) {
                    this.d.remove(entry.getKey());
                }
                return c;
            }
        }
        throw new IllegalStateException("the overlay item have not been added, you can not remove it.");
    }

    public boolean e() {
        boolean f = this.f2729a.f();
        if (f) {
            this.d.clear();
        }
        return f;
    }

    public void a(String str, String str2, PanoramaView panoramaView, com.baidu.pano.platform.comapi.a.b bVar) {
        this.i = str;
        this.j = str2;
        this.h = panoramaView;
        this.g = bVar;
    }

    public void a(com.baidu.pano.platform.comapi.a.b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("when you add an overlay item, it can not be null");
        }
        this.f2729a.d(bVar.toBundle("", new Bundle()));
        if (bVar.b) {
            this.f2729a.a(bVar.c);
        }
    }

    public void d(String str) {
        if (this.g != null) {
            this.g.a(str);
            this.f2729a.b(this.g.d);
        }
    }

    public void c(boolean z) {
        if (this.f2729a != null) {
            this.f2729a.b(z);
        }
    }

    public void f() {
        this.f2729a.g();
    }

    public void d(boolean z) {
        if (this.f2729a != null) {
            this.f2729a.d(z);
        }
    }

    public double[] a(float f, float f2) {
        if (this.f2729a != null) {
            return this.f2729a.d(f, f2);
        }
        return null;
    }

    public void a(PanoramaViewListener panoramaViewListener) {
        this.e = panoramaViewListener;
    }

    public String a(double d, double d2, double d3, double d4) {
        long sqrt = (long) Math.sqrt(Math.pow(d - d3, 2.0d) + Math.pow(d2 - d4, 2.0d));
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
