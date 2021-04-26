package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.i2.h0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class BdTimePicker extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f11949e;

    /* renamed from: f  reason: collision with root package name */
    public int f11950f;

    /* renamed from: g  reason: collision with root package name */
    public WheelView3d f11951g;

    /* renamed from: h  reason: collision with root package name */
    public WheelView3d f11952h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f11953i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Date n;
    public Date o;
    public int p;
    public int q;
    public int r;
    public Paint s;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.q1.a.f.c.b {
        public a() {
        }

        @Override // d.a.h0.a.q1.a.f.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            BdTimePicker bdTimePicker = BdTimePicker.this;
            bdTimePicker.f11949e = i2 + bdTimePicker.j;
            BdTimePicker.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.q1.a.f.c.b {
        public b() {
        }

        @Override // d.a.h0.a.q1.a.f.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            BdTimePicker bdTimePicker = BdTimePicker.this;
            bdTimePicker.f11950f = i2 + bdTimePicker.l;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.f11949e = 0;
        this.f11950f = 0;
        this.p = 15;
        f(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.f11951g.getCenterContentOffset() * 2.0f), this.s);
    }

    public final void f(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(g.aiapps_timepicker_layout, this);
        this.p = h0.e(context, this.p);
        this.q = h0.e(context, 16.0f);
        this.r = h0.e(context, 14.0f);
        j();
        this.f11953i = (LinearLayout) findViewById(f.timepicker_root);
        WheelView3d wheelView3d = (WheelView3d) findViewById(f.wheel_hour);
        this.f11951g = wheelView3d;
        wheelView3d.setLineSpacingMultiplier(3.0f);
        this.f11951g.setCenterTextSize(this.q);
        this.f11951g.setOuterTextSize(this.r);
        this.f11951g.setTextColorCenter(-16777216);
        this.f11951g.setTextColorOut(-16777216);
        this.f11951g.setVisibleItem(7);
        this.f11951g.setGravityOffset(this.p);
        this.f11951g.setGravity(5);
        this.f11951g.setDividerType(WheelView3d.DividerType.FILL);
        this.f11951g.setDividerColor(0);
        this.f11951g.setOnItemSelectedListener(new a());
        WheelView3d wheelView3d2 = (WheelView3d) findViewById(f.wheel_minute);
        this.f11952h = wheelView3d2;
        wheelView3d2.setLineSpacingMultiplier(3.0f);
        this.f11952h.setCenterTextSize(this.q);
        this.f11952h.setOuterTextSize(this.r);
        this.f11952h.setTextColorCenter(-16777216);
        this.f11952h.setTextColorOut(-16777216);
        this.f11952h.setGravityOffset(this.p);
        this.f11952h.setGravity(3);
        this.f11952h.setDividerType(WheelView3d.DividerType.FILL);
        this.f11952h.setDividerColor(0);
        this.f11952h.setVisibleItem(7);
        this.f11952h.setOnItemSelectedListener(new b());
        g();
    }

    public final void g() {
        Calendar calendar = Calendar.getInstance();
        this.f11949e = calendar.get(11);
        this.f11950f = calendar.get(12);
        l();
    }

    public int getHour() {
        return this.f11949e;
    }

    public int getMinute() {
        return this.f11950f;
    }

    public final void h() {
        this.j = 0;
        this.k = 23;
        Date date = this.n;
        if (date != null) {
            this.j = date.getHours();
        }
        Date date2 = this.o;
        if (date2 != null) {
            this.k = date2.getHours();
        }
        ArrayList arrayList = new ArrayList((this.k - this.j) + 1);
        int i2 = this.j;
        while (true) {
            int i3 = this.k;
            if (i2 > i3) {
                this.f11951g.setAdapter(new d.a.h0.a.q1.a.f.a.b(this.j, i3));
                k(this.f11951g, this.j, this.k);
                setHour(this.f11949e);
                return;
            }
            arrayList.add(String.format("%02d", Integer.valueOf(i2)));
            i2++;
        }
    }

    public final void i() {
        this.l = 0;
        this.m = 59;
        Date date = this.n;
        if (date != null && this.f11949e == this.j) {
            this.l = date.getMinutes();
        }
        Date date2 = this.o;
        if (date2 != null && this.f11949e == this.k) {
            this.m = date2.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.m - this.l) + 1);
        int i2 = this.l;
        while (true) {
            int i3 = this.m;
            if (i2 > i3) {
                this.f11952h.setAdapter(new d.a.h0.a.q1.a.f.a.b(this.l, i3));
                k(this.f11952h, this.l, this.m);
                setMinute(this.f11950f);
                return;
            }
            arrayList.add(String.format("%02d", Integer.valueOf(i2)));
            i2++;
        }
    }

    public final void j() {
        Paint paint = new Paint();
        this.s = paint;
        paint.setColor(-16777216);
        this.s.setAntiAlias(true);
        this.s.setTextSize(this.q);
    }

    public final void k(WheelView3d wheelView3d, int i2, int i3) {
        if ((i3 - i2) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void l() {
        h();
        i();
    }

    public void setDisabled(boolean z) {
        this.f11951g.setIsOptions(z);
        this.f11952h.setIsOptions(z);
    }

    public void setHour(int i2) {
        int i3 = this.j;
        if (i2 < i3 || i2 > (i3 = this.k)) {
            i2 = i3;
        }
        this.f11949e = i2;
        this.f11951g.setCurrentItem(i2 - this.j);
    }

    public void setMinute(int i2) {
        int i3 = this.l;
        if (i2 < i3 || i2 > (i3 = this.m)) {
            i2 = i3;
        }
        this.f11950f = i2;
        this.f11952h.setCurrentItem(i2 - this.l);
    }

    public void setOnTimeChangeListener(c cVar) {
    }

    public void setScrollCycle(boolean z) {
        this.f11952h.setCyclic(z);
        this.f11951g.setCyclic(z);
    }

    public void setStartDate(Date date) {
        this.n = date;
    }

    public void setmEndDate(Date date) {
        this.o = date;
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11949e = 0;
        this.f11950f = 0;
        this.p = 15;
        f(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11949e = 0;
        this.f11950f = 0;
        this.p = 15;
        f(context);
    }
}
