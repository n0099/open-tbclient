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
    public float f7570a = 12.0f;

    /* renamed from: b  reason: collision with root package name */
    public int f7571b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f7572c = 0;

    /* renamed from: d  reason: collision with root package name */
    public double f7573d = 1.2958162E7d;

    /* renamed from: e  reason: collision with root package name */
    public double f7574e = 4825907.0d;

    /* renamed from: h  reason: collision with root package name */
    public long f7577h = 0;
    public long i = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f7575f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f7576g = -1;
    public WinRound j = new WinRound();
    public a k = new a();
    public boolean l = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f7578a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f7579b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f7580c = 0;

        /* renamed from: d  reason: collision with root package name */
        public long f7581d = 0;

        /* renamed from: e  reason: collision with root package name */
        public Point f7582e = new Point(0, 0);

        /* renamed from: f  reason: collision with root package name */
        public Point f7583f = new Point(0, 0);

        /* renamed from: g  reason: collision with root package name */
        public Point f7584g = new Point(0, 0);

        /* renamed from: h  reason: collision with root package name */
        public Point f7585h = new Point(0, 0);

        public a() {
        }
    }

    public Bundle a(e eVar) {
        int i;
        int i2;
        WinRound winRound;
        int i3;
        int i4;
        float f2 = this.f7570a;
        float f3 = eVar.f7614b;
        if (f2 < f3) {
            this.f7570a = f3;
        }
        float f4 = this.f7570a;
        float f5 = eVar.f7613a;
        if (f4 > f5) {
            if (f4 == 1096.0f || e.f7612d == 26.0f) {
                this.f7570a = 26.0f;
                e.f7612d = 26.0f;
            } else {
                this.f7570a = f5;
            }
        }
        while (true) {
            i = this.f7571b;
            if (i >= 0) {
                break;
            }
            this.f7571b = i + 360;
        }
        this.f7571b = i % 360;
        if (this.f7572c > 0) {
            this.f7572c = 0;
        }
        if (this.f7572c < -45) {
            this.f7572c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.f7570a);
        bundle.putDouble("rotation", this.f7571b);
        bundle.putDouble("overlooking", this.f7572c);
        bundle.putDouble("centerptx", this.f7573d);
        bundle.putDouble("centerpty", this.f7574e);
        bundle.putInt(CustomDialogData.POS_LEFT, this.j.left);
        bundle.putInt("right", this.j.right);
        bundle.putInt("top", this.j.top);
        bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, this.j.bottom);
        int i5 = this.f7575f;
        if (i5 >= 0 && (i2 = this.f7576g) >= 0 && i5 <= (i3 = (winRound = this.j).right) && i2 <= (i4 = winRound.bottom) && i3 > 0 && i4 > 0) {
            long j = i5 - ((i3 - winRound.left) / 2);
            this.f7577h = j;
            this.i = -(i2 - ((i4 - winRound.top) / 2));
            bundle.putLong("xoffset", j);
            bundle.putLong("yoffset", this.i);
        }
        bundle.putInt("lbx", this.k.f7582e.x);
        bundle.putInt("lby", this.k.f7582e.y);
        bundle.putInt("ltx", this.k.f7583f.x);
        bundle.putInt("lty", this.k.f7583f.y);
        bundle.putInt("rtx", this.k.f7584g.x);
        bundle.putInt("rty", this.k.f7584g.y);
        bundle.putInt("rbx", this.k.f7585h.x);
        bundle.putInt("rby", this.k.f7585h.y);
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
        int i;
        this.f7570a = (float) bundle.getDouble("level");
        this.f7571b = (int) bundle.getDouble("rotation");
        this.f7572c = (int) bundle.getDouble("overlooking");
        this.f7573d = bundle.getDouble("centerptx");
        this.f7574e = bundle.getDouble("centerpty");
        this.j.left = bundle.getInt(CustomDialogData.POS_LEFT);
        this.j.right = bundle.getInt("right");
        this.j.top = bundle.getInt("top");
        this.j.bottom = bundle.getInt(TipsConfigItem.TipConfigData.BOTTOM);
        this.f7577h = bundle.getLong("xoffset");
        long j = bundle.getLong("yoffset");
        this.i = j;
        WinRound winRound = this.j;
        int i2 = winRound.right;
        if (i2 != 0 && (i = winRound.bottom) != 0) {
            this.f7575f = ((int) this.f7577h) + ((i2 - winRound.left) / 2);
            this.f7576g = ((int) (-j)) + ((i - winRound.top) / 2);
        }
        this.k.f7578a = bundle.getLong("gleft");
        this.k.f7579b = bundle.getLong("gright");
        this.k.f7580c = bundle.getLong("gtop");
        this.k.f7581d = bundle.getLong("gbottom");
        a aVar = this.k;
        if (aVar.f7578a <= -20037508) {
            aVar.f7578a = -20037508L;
        }
        a aVar2 = this.k;
        if (aVar2.f7579b >= 20037508) {
            aVar2.f7579b = 20037508L;
        }
        a aVar3 = this.k;
        if (aVar3.f7580c >= 20037508) {
            aVar3.f7580c = 20037508L;
        }
        a aVar4 = this.k;
        if (aVar4.f7581d <= -20037508) {
            aVar4.f7581d = -20037508L;
        }
        this.k.f7582e.x = bundle.getInt("lbx");
        this.k.f7582e.y = bundle.getInt("lby");
        this.k.f7583f.x = bundle.getInt("ltx");
        this.k.f7583f.y = bundle.getInt("lty");
        this.k.f7584g.x = bundle.getInt("rtx");
        this.k.f7584g.y = bundle.getInt("rty");
        this.k.f7585h.x = bundle.getInt("rbx");
        this.k.f7585h.y = bundle.getInt("rby");
        this.l = bundle.getInt("bfpp") == 1;
        this.m = bundle.getDouble("adapterzoomunit");
        this.n = bundle.getDouble("zoomunit");
        this.p = bundle.getString("panoid");
        this.q = bundle.getFloat("siangle");
        this.r = bundle.getInt("isbirdeye") != 0;
        this.s = bundle.getInt("ssext");
    }
}
