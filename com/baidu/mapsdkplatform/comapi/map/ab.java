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
    public float f7614a = 12.0f;

    /* renamed from: b  reason: collision with root package name */
    public int f7615b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f7616c = 0;

    /* renamed from: d  reason: collision with root package name */
    public double f7617d = 1.2958162E7d;

    /* renamed from: e  reason: collision with root package name */
    public double f7618e = 4825907.0d;

    /* renamed from: h  reason: collision with root package name */
    public long f7621h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f7622i = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f7619f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f7620g = -1;
    public WinRound j = new WinRound();
    public a k = new a();
    public boolean l = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f7623a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f7624b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f7625c = 0;

        /* renamed from: d  reason: collision with root package name */
        public long f7626d = 0;

        /* renamed from: e  reason: collision with root package name */
        public Point f7627e = new Point(0, 0);

        /* renamed from: f  reason: collision with root package name */
        public Point f7628f = new Point(0, 0);

        /* renamed from: g  reason: collision with root package name */
        public Point f7629g = new Point(0, 0);

        /* renamed from: h  reason: collision with root package name */
        public Point f7630h = new Point(0, 0);

        public a() {
        }
    }

    public Bundle a(e eVar) {
        int i2;
        int i3;
        WinRound winRound;
        int i4;
        int i5;
        float f2 = this.f7614a;
        float f3 = eVar.f7662b;
        if (f2 < f3) {
            this.f7614a = f3;
        }
        float f4 = this.f7614a;
        float f5 = eVar.f7661a;
        if (f4 > f5) {
            if (f4 == 1096.0f || e.f7660d == 26.0f) {
                this.f7614a = 26.0f;
                e.f7660d = 26.0f;
            } else {
                this.f7614a = f5;
            }
        }
        while (true) {
            i2 = this.f7615b;
            if (i2 >= 0) {
                break;
            }
            this.f7615b = i2 + 360;
        }
        this.f7615b = i2 % 360;
        if (this.f7616c > 0) {
            this.f7616c = 0;
        }
        if (this.f7616c < -45) {
            this.f7616c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.f7614a);
        bundle.putDouble("rotation", this.f7615b);
        bundle.putDouble("overlooking", this.f7616c);
        bundle.putDouble("centerptx", this.f7617d);
        bundle.putDouble("centerpty", this.f7618e);
        bundle.putInt(CustomDialogData.POS_LEFT, this.j.left);
        bundle.putInt("right", this.j.right);
        bundle.putInt("top", this.j.top);
        bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, this.j.bottom);
        int i6 = this.f7619f;
        if (i6 >= 0 && (i3 = this.f7620g) >= 0 && i6 <= (i4 = (winRound = this.j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
            long j = i6 - ((i4 - winRound.left) / 2);
            this.f7621h = j;
            this.f7622i = -(i3 - ((i5 - winRound.top) / 2));
            bundle.putLong("xoffset", j);
            bundle.putLong("yoffset", this.f7622i);
        }
        bundle.putInt("lbx", this.k.f7627e.x);
        bundle.putInt("lby", this.k.f7627e.y);
        bundle.putInt("ltx", this.k.f7628f.x);
        bundle.putInt("lty", this.k.f7628f.y);
        bundle.putInt("rtx", this.k.f7629g.x);
        bundle.putInt("rty", this.k.f7629g.y);
        bundle.putInt("rbx", this.k.f7630h.x);
        bundle.putInt("rby", this.k.f7630h.y);
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
        this.f7614a = (float) bundle.getDouble("level");
        this.f7615b = (int) bundle.getDouble("rotation");
        this.f7616c = (int) bundle.getDouble("overlooking");
        this.f7617d = bundle.getDouble("centerptx");
        this.f7618e = bundle.getDouble("centerpty");
        this.j.left = bundle.getInt(CustomDialogData.POS_LEFT);
        this.j.right = bundle.getInt("right");
        this.j.top = bundle.getInt("top");
        this.j.bottom = bundle.getInt(TipsConfigItem.TipConfigData.BOTTOM);
        this.f7621h = bundle.getLong("xoffset");
        long j = bundle.getLong("yoffset");
        this.f7622i = j;
        WinRound winRound = this.j;
        int i3 = winRound.right;
        if (i3 != 0 && (i2 = winRound.bottom) != 0) {
            this.f7619f = ((int) this.f7621h) + ((i3 - winRound.left) / 2);
            this.f7620g = ((int) (-j)) + ((i2 - winRound.top) / 2);
        }
        this.k.f7623a = bundle.getLong("gleft");
        this.k.f7624b = bundle.getLong("gright");
        this.k.f7625c = bundle.getLong("gtop");
        this.k.f7626d = bundle.getLong("gbottom");
        a aVar = this.k;
        if (aVar.f7623a <= -20037508) {
            aVar.f7623a = -20037508L;
        }
        a aVar2 = this.k;
        if (aVar2.f7624b >= 20037508) {
            aVar2.f7624b = 20037508L;
        }
        a aVar3 = this.k;
        if (aVar3.f7625c >= 20037508) {
            aVar3.f7625c = 20037508L;
        }
        a aVar4 = this.k;
        if (aVar4.f7626d <= -20037508) {
            aVar4.f7626d = -20037508L;
        }
        this.k.f7627e.x = bundle.getInt("lbx");
        this.k.f7627e.y = bundle.getInt("lby");
        this.k.f7628f.x = bundle.getInt("ltx");
        this.k.f7628f.y = bundle.getInt("lty");
        this.k.f7629g.x = bundle.getInt("rtx");
        this.k.f7629g.y = bundle.getInt("rty");
        this.k.f7630h.x = bundle.getInt("rbx");
        this.k.f7630h.y = bundle.getInt("rby");
        this.l = bundle.getInt("bfpp") == 1;
        this.m = bundle.getDouble("adapterzoomunit");
        this.n = bundle.getDouble("zoomunit");
        this.p = bundle.getString("panoid");
        this.q = bundle.getFloat("siangle");
        this.r = bundle.getInt("isbirdeye") != 0;
        this.s = bundle.getInt("ssext");
    }
}
