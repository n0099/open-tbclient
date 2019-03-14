package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes5.dex */
public class ab {
    private static final String t = ab.class.getSimpleName();
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;
    public float a = 12.0f;
    public int b = 0;
    public int c = 0;
    public double d = 1.2958162E7d;
    public double e = 4825907.0d;
    public long h = 0;
    public long i = 0;
    public int f = -1;
    public int g = -1;
    public WinRound j = new WinRound();
    public a k = new a();
    public boolean l = false;

    /* loaded from: classes5.dex */
    public class a {
        public long a = 0;
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

    public Bundle a(e eVar) {
        if (this.a < eVar.b) {
            this.a = eVar.b;
        }
        if (this.a > eVar.a) {
            if (this.a == 1096.0f || e.d == 26.0f) {
                this.a = 26.0f;
                e.d = 26.0f;
            } else {
                this.a = eVar.a;
            }
        }
        while (this.b < 0) {
            this.b += 360;
        }
        this.b %= 360;
        if (this.c > 0) {
            this.c = 0;
        }
        if (this.c < -45) {
            this.c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.a);
        bundle.putDouble("rotation", this.b);
        bundle.putDouble("overlooking", this.c);
        bundle.putDouble("centerptx", this.d);
        bundle.putDouble("centerpty", this.e);
        bundle.putInt(CustomDialogData.POS_LEFT, this.j.left);
        bundle.putInt("right", this.j.right);
        bundle.putInt("top", this.j.top);
        bundle.putInt("bottom", this.j.bottom);
        if (this.f >= 0 && this.g >= 0 && this.f <= this.j.right && this.g <= this.j.bottom && this.j.right > 0 && this.j.bottom > 0) {
            int i = this.f - ((this.j.right - this.j.left) / 2);
            int i2 = this.g;
            this.h = i;
            this.i = -(i2 - ((this.j.bottom - this.j.top) / 2));
            bundle.putLong("xoffset", this.h);
            bundle.putLong("yoffset", this.i);
        }
        bundle.putInt("lbx", this.k.e.x);
        bundle.putInt("lby", this.k.e.y);
        bundle.putInt("ltx", this.k.f.x);
        bundle.putInt("lty", this.k.f.y);
        bundle.putInt("rtx", this.k.g.x);
        bundle.putInt("rty", this.k.g.y);
        bundle.putInt("rbx", this.k.h.x);
        bundle.putInt("rby", this.k.h.y);
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
        this.a = (float) bundle.getDouble("level");
        this.b = (int) bundle.getDouble("rotation");
        this.c = (int) bundle.getDouble("overlooking");
        this.d = bundle.getDouble("centerptx");
        this.e = bundle.getDouble("centerpty");
        this.j.left = bundle.getInt(CustomDialogData.POS_LEFT);
        this.j.right = bundle.getInt("right");
        this.j.top = bundle.getInt("top");
        this.j.bottom = bundle.getInt("bottom");
        this.h = bundle.getLong("xoffset");
        this.i = bundle.getLong("yoffset");
        if (this.j.right != 0 && this.j.bottom != 0) {
            int i = (int) (-this.i);
            this.f = ((this.j.right - this.j.left) / 2) + ((int) this.h);
            this.g = i + ((this.j.bottom - this.j.top) / 2);
        }
        this.k.a = bundle.getLong("gleft");
        this.k.b = bundle.getLong("gright");
        this.k.c = bundle.getLong("gtop");
        this.k.d = bundle.getLong("gbottom");
        if (this.k.a <= -20037508) {
            this.k.a = -20037508L;
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
        this.k.e.x = bundle.getInt("lbx");
        this.k.e.y = bundle.getInt("lby");
        this.k.f.x = bundle.getInt("ltx");
        this.k.f.y = bundle.getInt("lty");
        this.k.g.x = bundle.getInt("rtx");
        this.k.g.y = bundle.getInt("rty");
        this.k.h.x = bundle.getInt("rbx");
        this.k.h.y = bundle.getInt("rby");
        this.l = bundle.getInt("bfpp") == 1;
        this.m = bundle.getDouble("adapterzoomunit");
        this.n = bundle.getDouble("zoomunit");
        this.p = bundle.getString("panoid");
        this.q = bundle.getFloat("siangle");
        this.r = bundle.getInt("isbirdeye") != 0;
        this.s = bundle.getInt("ssext");
    }
}
