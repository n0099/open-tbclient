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
    public float f7605a = 12.0f;

    /* renamed from: b  reason: collision with root package name */
    public int f7606b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f7607c = 0;

    /* renamed from: d  reason: collision with root package name */
    public double f7608d = 1.2958162E7d;

    /* renamed from: e  reason: collision with root package name */
    public double f7609e = 4825907.0d;

    /* renamed from: h  reason: collision with root package name */
    public long f7612h = 0;
    public long i = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f7610f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f7611g = -1;
    public WinRound j = new WinRound();
    public a k = new a();
    public boolean l = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f7613a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f7614b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f7615c = 0;

        /* renamed from: d  reason: collision with root package name */
        public long f7616d = 0;

        /* renamed from: e  reason: collision with root package name */
        public Point f7617e = new Point(0, 0);

        /* renamed from: f  reason: collision with root package name */
        public Point f7618f = new Point(0, 0);

        /* renamed from: g  reason: collision with root package name */
        public Point f7619g = new Point(0, 0);

        /* renamed from: h  reason: collision with root package name */
        public Point f7620h = new Point(0, 0);

        public a() {
        }
    }

    public Bundle a(e eVar) {
        int i;
        int i2;
        WinRound winRound;
        int i3;
        int i4;
        float f2 = this.f7605a;
        float f3 = eVar.f7649b;
        if (f2 < f3) {
            this.f7605a = f3;
        }
        float f4 = this.f7605a;
        float f5 = eVar.f7648a;
        if (f4 > f5) {
            if (f4 == 1096.0f || e.f7647d == 26.0f) {
                this.f7605a = 26.0f;
                e.f7647d = 26.0f;
            } else {
                this.f7605a = f5;
            }
        }
        while (true) {
            i = this.f7606b;
            if (i >= 0) {
                break;
            }
            this.f7606b = i + 360;
        }
        this.f7606b = i % 360;
        if (this.f7607c > 0) {
            this.f7607c = 0;
        }
        if (this.f7607c < -45) {
            this.f7607c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.f7605a);
        bundle.putDouble("rotation", this.f7606b);
        bundle.putDouble("overlooking", this.f7607c);
        bundle.putDouble("centerptx", this.f7608d);
        bundle.putDouble("centerpty", this.f7609e);
        bundle.putInt(CustomDialogData.POS_LEFT, this.j.left);
        bundle.putInt("right", this.j.right);
        bundle.putInt("top", this.j.top);
        bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, this.j.bottom);
        int i5 = this.f7610f;
        if (i5 >= 0 && (i2 = this.f7611g) >= 0 && i5 <= (i3 = (winRound = this.j).right) && i2 <= (i4 = winRound.bottom) && i3 > 0 && i4 > 0) {
            long j = i5 - ((i3 - winRound.left) / 2);
            this.f7612h = j;
            this.i = -(i2 - ((i4 - winRound.top) / 2));
            bundle.putLong("xoffset", j);
            bundle.putLong("yoffset", this.i);
        }
        bundle.putInt("lbx", this.k.f7617e.x);
        bundle.putInt("lby", this.k.f7617e.y);
        bundle.putInt("ltx", this.k.f7618f.x);
        bundle.putInt("lty", this.k.f7618f.y);
        bundle.putInt("rtx", this.k.f7619g.x);
        bundle.putInt("rty", this.k.f7619g.y);
        bundle.putInt("rbx", this.k.f7620h.x);
        bundle.putInt("rby", this.k.f7620h.y);
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
        this.f7605a = (float) bundle.getDouble("level");
        this.f7606b = (int) bundle.getDouble("rotation");
        this.f7607c = (int) bundle.getDouble("overlooking");
        this.f7608d = bundle.getDouble("centerptx");
        this.f7609e = bundle.getDouble("centerpty");
        this.j.left = bundle.getInt(CustomDialogData.POS_LEFT);
        this.j.right = bundle.getInt("right");
        this.j.top = bundle.getInt("top");
        this.j.bottom = bundle.getInt(TipsConfigItem.TipConfigData.BOTTOM);
        this.f7612h = bundle.getLong("xoffset");
        long j = bundle.getLong("yoffset");
        this.i = j;
        WinRound winRound = this.j;
        int i2 = winRound.right;
        if (i2 != 0 && (i = winRound.bottom) != 0) {
            this.f7610f = ((int) this.f7612h) + ((i2 - winRound.left) / 2);
            this.f7611g = ((int) (-j)) + ((i - winRound.top) / 2);
        }
        this.k.f7613a = bundle.getLong("gleft");
        this.k.f7614b = bundle.getLong("gright");
        this.k.f7615c = bundle.getLong("gtop");
        this.k.f7616d = bundle.getLong("gbottom");
        a aVar = this.k;
        if (aVar.f7613a <= -20037508) {
            aVar.f7613a = -20037508L;
        }
        a aVar2 = this.k;
        if (aVar2.f7614b >= 20037508) {
            aVar2.f7614b = 20037508L;
        }
        a aVar3 = this.k;
        if (aVar3.f7615c >= 20037508) {
            aVar3.f7615c = 20037508L;
        }
        a aVar4 = this.k;
        if (aVar4.f7616d <= -20037508) {
            aVar4.f7616d = -20037508L;
        }
        this.k.f7617e.x = bundle.getInt("lbx");
        this.k.f7617e.y = bundle.getInt("lby");
        this.k.f7618f.x = bundle.getInt("ltx");
        this.k.f7618f.y = bundle.getInt("lty");
        this.k.f7619g.x = bundle.getInt("rtx");
        this.k.f7619g.y = bundle.getInt("rty");
        this.k.f7620h.x = bundle.getInt("rbx");
        this.k.f7620h.y = bundle.getInt("rby");
        this.l = bundle.getInt("bfpp") == 1;
        this.m = bundle.getDouble("adapterzoomunit");
        this.n = bundle.getDouble("zoomunit");
        this.p = bundle.getString("panoid");
        this.q = bundle.getFloat("siangle");
        this.r = bundle.getInt("isbirdeye") != 0;
        this.s = bundle.getInt("ssext");
    }
}
