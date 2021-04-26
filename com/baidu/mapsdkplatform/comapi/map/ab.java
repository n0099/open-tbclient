package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.kwad.sdk.core.config.item.TipsConfigItem;
/* loaded from: classes2.dex */
public class ab {
    public static final String t = "ab";
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* renamed from: a  reason: collision with root package name */
    public float f7874a = 12.0f;

    /* renamed from: b  reason: collision with root package name */
    public int f7875b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f7876c = 0;

    /* renamed from: d  reason: collision with root package name */
    public double f7877d = 1.2958162E7d;

    /* renamed from: e  reason: collision with root package name */
    public double f7878e = 4825907.0d;

    /* renamed from: h  reason: collision with root package name */
    public long f7881h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f7882i = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f7879f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f7880g = -1;
    public WinRound j = new WinRound();
    public a k = new a();
    public boolean l = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f7883a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f7884b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f7885c = 0;

        /* renamed from: d  reason: collision with root package name */
        public long f7886d = 0;

        /* renamed from: e  reason: collision with root package name */
        public Point f7887e = new Point(0, 0);

        /* renamed from: f  reason: collision with root package name */
        public Point f7888f = new Point(0, 0);

        /* renamed from: g  reason: collision with root package name */
        public Point f7889g = new Point(0, 0);

        /* renamed from: h  reason: collision with root package name */
        public Point f7890h = new Point(0, 0);

        public a() {
        }
    }

    public Bundle a(e eVar) {
        int i2;
        int i3;
        WinRound winRound;
        int i4;
        int i5;
        float f2 = this.f7874a;
        float f3 = eVar.f7922b;
        if (f2 < f3) {
            this.f7874a = f3;
        }
        float f4 = this.f7874a;
        float f5 = eVar.f7921a;
        if (f4 > f5) {
            if (f4 == 1096.0f || e.f7920d == 26.0f) {
                this.f7874a = 26.0f;
                e.f7920d = 26.0f;
            } else {
                this.f7874a = f5;
            }
        }
        while (true) {
            i2 = this.f7875b;
            if (i2 >= 0) {
                break;
            }
            this.f7875b = i2 + 360;
        }
        this.f7875b = i2 % 360;
        if (this.f7876c > 0) {
            this.f7876c = 0;
        }
        if (this.f7876c < -45) {
            this.f7876c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.f7874a);
        bundle.putDouble("rotation", this.f7875b);
        bundle.putDouble("overlooking", this.f7876c);
        bundle.putDouble("centerptx", this.f7877d);
        bundle.putDouble("centerpty", this.f7878e);
        bundle.putInt(CustomDialogData.POS_LEFT, this.j.left);
        bundle.putInt("right", this.j.right);
        bundle.putInt("top", this.j.top);
        bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, this.j.bottom);
        int i6 = this.f7879f;
        if (i6 >= 0 && (i3 = this.f7880g) >= 0 && i6 <= (i4 = (winRound = this.j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
            long j = i6 - ((i4 - winRound.left) / 2);
            this.f7881h = j;
            this.f7882i = -(i3 - ((i5 - winRound.top) / 2));
            bundle.putLong("xoffset", j);
            bundle.putLong("yoffset", this.f7882i);
        }
        bundle.putInt("lbx", this.k.f7887e.x);
        bundle.putInt("lby", this.k.f7887e.y);
        bundle.putInt("ltx", this.k.f7888f.x);
        bundle.putInt("lty", this.k.f7888f.y);
        bundle.putInt("rtx", this.k.f7889g.x);
        bundle.putInt("rty", this.k.f7889g.y);
        bundle.putInt("rbx", this.k.f7890h.x);
        bundle.putInt("rby", this.k.f7890h.y);
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
        int i2;
        this.f7874a = (float) bundle.getDouble("level");
        this.f7875b = (int) bundle.getDouble("rotation");
        this.f7876c = (int) bundle.getDouble("overlooking");
        this.f7877d = bundle.getDouble("centerptx");
        this.f7878e = bundle.getDouble("centerpty");
        this.j.left = bundle.getInt(CustomDialogData.POS_LEFT);
        this.j.right = bundle.getInt("right");
        this.j.top = bundle.getInt("top");
        this.j.bottom = bundle.getInt(TipsConfigItem.TipConfigData.BOTTOM);
        this.f7881h = bundle.getLong("xoffset");
        long j = bundle.getLong("yoffset");
        this.f7882i = j;
        WinRound winRound = this.j;
        int i3 = winRound.right;
        if (i3 != 0 && (i2 = winRound.bottom) != 0) {
            this.f7879f = ((int) this.f7881h) + ((i3 - winRound.left) / 2);
            this.f7880g = ((int) (-j)) + ((i2 - winRound.top) / 2);
        }
        this.k.f7883a = bundle.getLong("gleft");
        this.k.f7884b = bundle.getLong("gright");
        this.k.f7885c = bundle.getLong("gtop");
        this.k.f7886d = bundle.getLong("gbottom");
        a aVar = this.k;
        if (aVar.f7883a <= -20037508) {
            aVar.f7883a = -20037508L;
        }
        a aVar2 = this.k;
        if (aVar2.f7884b >= 20037508) {
            aVar2.f7884b = 20037508L;
        }
        a aVar3 = this.k;
        if (aVar3.f7885c >= 20037508) {
            aVar3.f7885c = 20037508L;
        }
        a aVar4 = this.k;
        if (aVar4.f7886d <= -20037508) {
            aVar4.f7886d = -20037508L;
        }
        this.k.f7887e.x = bundle.getInt("lbx");
        this.k.f7887e.y = bundle.getInt("lby");
        this.k.f7888f.x = bundle.getInt("ltx");
        this.k.f7888f.y = bundle.getInt("lty");
        this.k.f7889g.x = bundle.getInt("rtx");
        this.k.f7889g.y = bundle.getInt("rty");
        this.k.f7890h.x = bundle.getInt("rbx");
        this.k.f7890h.y = bundle.getInt("rby");
        this.l = bundle.getInt("bfpp") == 1;
        this.m = bundle.getDouble("adapterzoomunit");
        this.n = bundle.getDouble("zoomunit");
        this.p = bundle.getString("panoid");
        this.q = bundle.getFloat("siangle");
        this.r = bundle.getInt("isbirdeye") != 0;
        this.s = bundle.getInt("ssext");
    }
}
