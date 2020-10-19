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
import com.baidu.pano.platform.comjni.MessageProxy;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
    private String t;
    private PanoramaView.ImageDefinition u;
    private PanoramaView.ImageDefinition v;
    private Handler w;

    public InnerPanoramaView(Context context) {
        this(context, null);
    }

    public InnerPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new HashMap<>();
        this.r = true;
        this.s = true;
        this.t = "street";
        this.w = new c(this);
        this.b = context;
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
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("Type", "");
                String optString2 = jSONObject.optString("ImgVmax");
                String optString3 = jSONObject.optString("ImgVmin");
                if (optString.equals("street")) {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        float floatValue = (float) (Float.valueOf(optString3).floatValue() * 0.31d);
                        this.f2676a.b(floatValue, (float) (Float.valueOf(optString2).floatValue() * 0.31d));
                    } else {
                        this.f2676a.b(-15.0f, 90.0f);
                    }
                    if (this.u == PanoramaView.ImageDefinition.ImageDefinitionHigh) {
                        this.u = PanoramaView.ImageDefinition.ImageDefinitionMiddle;
                        this.f2676a.b(this.u.getValue());
                    }
                } else if (optString.equals("inter")) {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        float floatValue2 = (float) (Float.valueOf(optString3).floatValue() * 0.31d);
                        this.f2676a.b(floatValue2, (float) (Float.valueOf(optString2).floatValue() * 0.31d));
                    } else {
                        this.f2676a.b(-25.0f, 90.0f);
                    }
                    if ("street".equals(this.t) && this.v == PanoramaView.ImageDefinition.ImageDefinitionHigh) {
                        this.u = PanoramaView.ImageDefinition.ImageDefinitionHigh;
                        this.f2676a.b(this.u.getValue());
                    }
                }
                this.t = optString;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str) {
        if (this.s) {
            this.r = false;
            if (this.f2676a != null) {
                this.f2676a.a(str);
            }
        }
    }

    public void a(int i, int i2) {
        if (this.s) {
            this.r = false;
            if (this.f2676a != null) {
                this.f2676a.a(i, i2);
            }
        }
    }

    public void a(double d, double d2) {
        if (this.s) {
            this.r = false;
            if (this.f2676a != null) {
                this.f2676a.a(d, d2);
            }
        }
    }

    public void b(String str) {
        if (this.s) {
            this.r = false;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("when you set the uid of panorama, it can not be null or empty string.");
            }
            if (this.f2676a != null) {
                this.f2676a.b(str);
            }
        }
    }

    public void a(float f) {
        if (this.f2676a != null) {
            if (f < -90.0f) {
                f = -90.0f;
            } else if (f > 90.0f) {
                f = 90.0f;
            }
            this.f2676a.a(f, b(), 0.0f);
        }
    }

    public float a() {
        if (this.f2676a != null) {
            return this.f2676a.a(1);
        }
        throw new NullPointerException("PanoController is null!");
    }

    public void b(float f) {
        if (this.f2676a != null) {
            while (f < 0.0f) {
                f += 360.0f;
            }
            this.f2676a.a(a(), f % 360.0f, 0.0f);
        }
    }

    public float b() {
        if (this.f2676a != null) {
            return this.f2676a.a(2);
        }
        throw new NullPointerException("PanoController is null!");
    }

    public void b(int i) {
        if (this.f2676a != null && i >= 1 && i <= 5) {
            this.f2676a.a(70 - (i * 10));
        }
    }

    public float c() {
        if (this.f2676a != null) {
            return this.f2676a.c();
        }
        throw new NullPointerException("PanoController is null!");
    }

    public void a(PanoramaView.ImageDefinition imageDefinition) {
        if (this.f2676a != null) {
            this.v = imageDefinition;
            this.u = imageDefinition;
            this.f2676a.b(imageDefinition.getValue());
        }
    }

    public boolean a(Bitmap bitmap) {
        if (this.f2676a == null) {
            return false;
        }
        return this.f2676a.c(bitmap);
    }

    public boolean c(String str) {
        if (this.f2676a == null) {
            return false;
        }
        return this.f2676a.d(str);
    }

    public void a(boolean z) {
        if (this.f2676a != null) {
            this.f2676a.c(z);
        }
    }

    public void b(Bitmap bitmap) {
        this.f2676a.c(bitmap);
    }

    public void d() {
        MessageProxy.unRegisterPanoViewListener();
        this.f2676a.b();
    }

    public void b(boolean z) {
        if (this.f2676a != null) {
            this.f2676a.a(z);
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
            z = this.f2676a.b(bundle);
        } else if (1001 == bundle.getInt("markerType")) {
            z = this.f2676a.a(bundle);
        } else if (1002 != bundle.getInt("markerType")) {
            z = false;
        } else {
            z = this.f2676a.a(bundle, ((ImageMarker) aVar).getMarkerBitmap());
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
        bundle.putDouble("x", d * 100.0d);
        bundle.putDouble("y", d2 * 100.0d);
        bundle.putFloat(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, ((float) d3) * 100.0f);
        return this.f2676a.a(bundle, bitmap);
    }

    public void a(String str, float f, float f2) {
        if (this.f2676a != null) {
            this.f2676a.a(str, f, f2);
        }
    }

    public boolean b(com.baidu.pano.platform.comapi.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("when you remove an overlay item, it can not be null");
        }
        for (Map.Entry<String, com.baidu.pano.platform.comapi.a.a> entry : this.d.entrySet()) {
            if (aVar.mKey != null && aVar.mKey.equals(entry.getKey())) {
                boolean c = this.f2676a.c(entry.getKey());
                if (c) {
                    this.d.remove(entry.getKey());
                }
                return c;
            }
        }
        throw new IllegalStateException("the overlay item have not been added, you can not remove it.");
    }

    public boolean e() {
        boolean f = this.f2676a.f();
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
        this.f2676a.d(bVar.toBundle("", new Bundle()));
        if (bVar.b) {
            this.f2676a.a(bVar.c);
        }
    }

    public void d(String str) {
        if (this.g != null) {
            this.g.a(str);
            this.f2676a.b(this.g.d);
        }
    }

    public void c(boolean z) {
        if (this.f2676a != null) {
            this.f2676a.b(z);
        }
    }

    public void f() {
        this.f2676a.g();
    }

    public void d(boolean z) {
        if (this.f2676a != null) {
            this.f2676a.d(z);
        }
    }

    public double[] a(float f, float f2) {
        if (this.f2676a != null) {
            return this.f2676a.d(f, f2);
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
