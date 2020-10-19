package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapapi.map.WinRound;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes7.dex */
public class w {
    private static final String t = w.class.getSimpleName();
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* renamed from: a  reason: collision with root package name */
    public float f2240a = 12.0f;
    public int b = 0;
    public int c = 0;
    public double d = 1.2958162E7d;
    public double e = 4825907.0d;
    public float h = 0.0f;
    public float i = 0.0f;
    public int f = -1;
    public int g = -1;
    public WinRound j = new WinRound();
    public a k = new a();
    public boolean l = false;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f2241a = 0;
        public long b = 0;
        public long c = 0;
        public long d = 0;
        public Point e = new Point(0, 0);
        public Point f = new Point(0, 0);
        public Point g = new Point(0, 0);
        public Point h = new Point(0, 0);

        public a() {
        }
    }

    public Bundle a(d dVar) {
        if (this.f2240a < dVar.b) {
            this.f2240a = dVar.b;
        }
        if (this.f2240a > dVar.f2222a) {
            if (this.f2240a == 1096.0f || d.d == 26.0f) {
                this.f2240a = 26.0f;
                d.d = 26.0f;
            } else {
                this.f2240a = dVar.f2222a;
            }
        }
        while (this.b < 0) {
            this.b += EncoderTextureDrawer.X264_WIDTH;
        }
        this.b %= EncoderTextureDrawer.X264_WIDTH;
        if (this.c > 0) {
            this.c = 0;
        }
        if (this.c < -45) {
            this.c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.f2240a);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, this.b);
        bundle.putDouble("overlooking", this.c);
        bundle.putDouble("centerptx", this.d);
        bundle.putDouble("centerpty", this.e);
        bundle.putInt("left", this.j.left);
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, this.j.right);
        bundle.putInt(VerticalTranslateLayout.TOP, this.j.top);
        bundle.putInt(VerticalTranslateLayout.BOTTOM, this.j.bottom);
        if (this.f >= 0 && this.g >= 0 && this.f <= this.j.right && this.g <= this.j.bottom && this.j.right > 0 && this.j.bottom > 0) {
            int i = this.f - ((this.j.right - this.j.left) / 2);
            int i2 = this.g;
            this.h = i;
            this.i = -(i2 - ((this.j.bottom - this.j.top) / 2));
            bundle.putFloat("xoffset", this.h);
            bundle.putFloat("yoffset", this.i);
        }
        bundle.putInt("lbx", this.k.e.getIntX());
        bundle.putInt("lby", this.k.e.getIntY());
        bundle.putInt("ltx", this.k.f.getIntX());
        bundle.putInt("lty", this.k.f.getIntY());
        bundle.putInt("rtx", this.k.g.getIntX());
        bundle.putInt("rty", this.k.g.getIntY());
        bundle.putInt("rbx", this.k.h.getIntX());
        bundle.putInt("rby", this.k.h.getIntY());
        bundle.putLong("gleft", this.k.f2241a);
        bundle.putLong("gbottom", this.k.d);
        bundle.putLong("gtop", this.k.c);
        bundle.putLong("gright", this.k.b);
        bundle.putInt("bfpp", this.l ? 1 : 0);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", this.o);
        bundle.putString("panoid", this.p);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", this.q);
        bundle.putInt("isbirdeye", this.r ? 1 : 0);
        bundle.putInt("ssext", this.s);
        return bundle;
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.f2240a = (float) bundle.getDouble("level");
        this.b = (int) bundle.getDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION);
        this.c = (int) bundle.getDouble("overlooking");
        this.d = bundle.getDouble("centerptx");
        this.e = bundle.getDouble("centerpty");
        this.j.left = bundle.getInt("left");
        this.j.right = bundle.getInt(HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.j.top = bundle.getInt(VerticalTranslateLayout.TOP);
        this.j.bottom = bundle.getInt(VerticalTranslateLayout.BOTTOM);
        this.h = bundle.getFloat("xoffset");
        this.i = bundle.getFloat("yoffset");
        if (this.j.right != 0 && this.j.bottom != 0) {
            int i = (int) (-this.i);
            this.f = ((this.j.right - this.j.left) / 2) + ((int) this.h);
            this.g = i + ((this.j.bottom - this.j.top) / 2);
        }
        this.k.f2241a = bundle.getLong("gleft");
        this.k.b = bundle.getLong("gright");
        this.k.c = bundle.getLong("gtop");
        this.k.d = bundle.getLong("gbottom");
        if (this.k.f2241a <= -20037508) {
            this.k.f2241a = -20037508L;
        }
        if (this.k.b >= 20037508) {
            this.k.b = 20037508L;
        }
        if (this.k.c >= 20037508) {
            this.k.c = 20037508L;
        }
        if (this.k.d <= -20037508) {
            this.k.d = -20037508L;
        }
        this.k.e.doubleX = this.k.f2241a;
        this.k.e.doubleY = this.k.d;
        this.k.f.doubleX = this.k.f2241a;
        this.k.f.doubleY = this.k.c;
        this.k.g.doubleX = this.k.b;
        this.k.g.doubleY = this.k.c;
        this.k.h.doubleX = this.k.b;
        this.k.h.doubleY = this.k.d;
        this.l = bundle.getInt("bfpp") == 1;
        this.m = bundle.getDouble("adapterzoomunit");
        this.n = bundle.getDouble("zoomunit");
        this.p = bundle.getString("panoid");
        this.q = bundle.getFloat("siangle");
        this.r = bundle.getInt("isbirdeye") != 0;
        this.s = bundle.getInt("ssext");
    }
}
