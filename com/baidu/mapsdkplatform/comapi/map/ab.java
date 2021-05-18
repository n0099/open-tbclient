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
    public float f7671a = 12.0f;

    /* renamed from: b  reason: collision with root package name */
    public int f7672b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f7673c = 0;

    /* renamed from: d  reason: collision with root package name */
    public double f7674d = 1.2958162E7d;

    /* renamed from: e  reason: collision with root package name */
    public double f7675e = 4825907.0d;

    /* renamed from: h  reason: collision with root package name */
    public long f7678h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f7679i = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f7676f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f7677g = -1;
    public WinRound j = new WinRound();
    public a k = new a();
    public boolean l = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f7680a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f7681b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f7682c = 0;

        /* renamed from: d  reason: collision with root package name */
        public long f7683d = 0;

        /* renamed from: e  reason: collision with root package name */
        public Point f7684e = new Point(0, 0);

        /* renamed from: f  reason: collision with root package name */
        public Point f7685f = new Point(0, 0);

        /* renamed from: g  reason: collision with root package name */
        public Point f7686g = new Point(0, 0);

        /* renamed from: h  reason: collision with root package name */
        public Point f7687h = new Point(0, 0);

        public a() {
        }
    }

    public Bundle a(e eVar) {
        int i2;
        int i3;
        WinRound winRound;
        int i4;
        int i5;
        float f2 = this.f7671a;
        float f3 = eVar.f7719b;
        if (f2 < f3) {
            this.f7671a = f3;
        }
        float f4 = this.f7671a;
        float f5 = eVar.f7718a;
        if (f4 > f5) {
            if (f4 == 1096.0f || e.f7717d == 26.0f) {
                this.f7671a = 26.0f;
                e.f7717d = 26.0f;
            } else {
                this.f7671a = f5;
            }
        }
        while (true) {
            i2 = this.f7672b;
            if (i2 >= 0) {
                break;
            }
            this.f7672b = i2 + 360;
        }
        this.f7672b = i2 % 360;
        if (this.f7673c > 0) {
            this.f7673c = 0;
        }
        if (this.f7673c < -45) {
            this.f7673c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.f7671a);
        bundle.putDouble("rotation", this.f7672b);
        bundle.putDouble("overlooking", this.f7673c);
        bundle.putDouble("centerptx", this.f7674d);
        bundle.putDouble("centerpty", this.f7675e);
        bundle.putInt(CustomDialogData.POS_LEFT, this.j.left);
        bundle.putInt("right", this.j.right);
        bundle.putInt("top", this.j.top);
        bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, this.j.bottom);
        int i6 = this.f7676f;
        if (i6 >= 0 && (i3 = this.f7677g) >= 0 && i6 <= (i4 = (winRound = this.j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
            long j = i6 - ((i4 - winRound.left) / 2);
            this.f7678h = j;
            this.f7679i = -(i3 - ((i5 - winRound.top) / 2));
            bundle.putLong("xoffset", j);
            bundle.putLong("yoffset", this.f7679i);
        }
        bundle.putInt("lbx", this.k.f7684e.x);
        bundle.putInt("lby", this.k.f7684e.y);
        bundle.putInt("ltx", this.k.f7685f.x);
        bundle.putInt("lty", this.k.f7685f.y);
        bundle.putInt("rtx", this.k.f7686g.x);
        bundle.putInt("rty", this.k.f7686g.y);
        bundle.putInt("rbx", this.k.f7687h.x);
        bundle.putInt("rby", this.k.f7687h.y);
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
        this.f7671a = (float) bundle.getDouble("level");
        this.f7672b = (int) bundle.getDouble("rotation");
        this.f7673c = (int) bundle.getDouble("overlooking");
        this.f7674d = bundle.getDouble("centerptx");
        this.f7675e = bundle.getDouble("centerpty");
        this.j.left = bundle.getInt(CustomDialogData.POS_LEFT);
        this.j.right = bundle.getInt("right");
        this.j.top = bundle.getInt("top");
        this.j.bottom = bundle.getInt(TipsConfigItem.TipConfigData.BOTTOM);
        this.f7678h = bundle.getLong("xoffset");
        long j = bundle.getLong("yoffset");
        this.f7679i = j;
        WinRound winRound = this.j;
        int i3 = winRound.right;
        if (i3 != 0 && (i2 = winRound.bottom) != 0) {
            this.f7676f = ((int) this.f7678h) + ((i3 - winRound.left) / 2);
            this.f7677g = ((int) (-j)) + ((i2 - winRound.top) / 2);
        }
        this.k.f7680a = bundle.getLong("gleft");
        this.k.f7681b = bundle.getLong("gright");
        this.k.f7682c = bundle.getLong("gtop");
        this.k.f7683d = bundle.getLong("gbottom");
        a aVar = this.k;
        if (aVar.f7680a <= -20037508) {
            aVar.f7680a = -20037508L;
        }
        a aVar2 = this.k;
        if (aVar2.f7681b >= 20037508) {
            aVar2.f7681b = 20037508L;
        }
        a aVar3 = this.k;
        if (aVar3.f7682c >= 20037508) {
            aVar3.f7682c = 20037508L;
        }
        a aVar4 = this.k;
        if (aVar4.f7683d <= -20037508) {
            aVar4.f7683d = -20037508L;
        }
        this.k.f7684e.x = bundle.getInt("lbx");
        this.k.f7684e.y = bundle.getInt("lby");
        this.k.f7685f.x = bundle.getInt("ltx");
        this.k.f7685f.y = bundle.getInt("lty");
        this.k.f7686g.x = bundle.getInt("rtx");
        this.k.f7686g.y = bundle.getInt("rty");
        this.k.f7687h.x = bundle.getInt("rbx");
        this.k.f7687h.y = bundle.getInt("rby");
        this.l = bundle.getInt("bfpp") == 1;
        this.m = bundle.getDouble("adapterzoomunit");
        this.n = bundle.getDouble("zoomunit");
        this.p = bundle.getString("panoid");
        this.q = bundle.getFloat("siangle");
        this.r = bundle.getInt("isbirdeye") != 0;
        this.s = bundle.getInt("ssext");
    }
}
