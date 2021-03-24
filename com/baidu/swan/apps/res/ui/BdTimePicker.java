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
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i2.h0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class BdTimePicker extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f12435e;

    /* renamed from: f  reason: collision with root package name */
    public int f12436f;

    /* renamed from: g  reason: collision with root package name */
    public WheelView3d f12437g;

    /* renamed from: h  reason: collision with root package name */
    public WheelView3d f12438h;
    public LinearLayout i;
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
    public class a implements d.b.g0.a.q1.a.f.c.b {
        public a() {
        }

        @Override // d.b.g0.a.q1.a.f.c.b
        public void a(WheelView3d wheelView3d, int i) {
            BdTimePicker bdTimePicker = BdTimePicker.this;
            bdTimePicker.f12435e = i + bdTimePicker.j;
            BdTimePicker.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.q1.a.f.c.b {
        public b() {
        }

        @Override // d.b.g0.a.q1.a.f.c.b
        public void a(WheelView3d wheelView3d, int i) {
            BdTimePicker bdTimePicker = BdTimePicker.this;
            bdTimePicker.f12436f = i + bdTimePicker.l;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.f12435e = 0;
        this.f12436f = 0;
        this.p = 15;
        f(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.f12437g.getCenterContentOffset() * 2.0f), this.s);
    }

    public final void f(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(g.aiapps_timepicker_layout, this);
        this.p = h0.e(context, this.p);
        this.q = h0.e(context, 16.0f);
        this.r = h0.e(context, 14.0f);
        j();
        this.i = (LinearLayout) findViewById(f.timepicker_root);
        WheelView3d wheelView3d = (WheelView3d) findViewById(f.wheel_hour);
        this.f12437g = wheelView3d;
        wheelView3d.setLineSpacingMultiplier(3.0f);
        this.f12437g.setCenterTextSize(this.q);
        this.f12437g.setOuterTextSize(this.r);
        this.f12437g.setTextColorCenter(-16777216);
        this.f12437g.setTextColorOut(-16777216);
        this.f12437g.setVisibleItem(7);
        this.f12437g.setGravityOffset(this.p);
        this.f12437g.setGravity(5);
        this.f12437g.setDividerType(WheelView3d.DividerType.FILL);
        this.f12437g.setDividerColor(0);
        this.f12437g.setOnItemSelectedListener(new a());
        WheelView3d wheelView3d2 = (WheelView3d) findViewById(f.wheel_minute);
        this.f12438h = wheelView3d2;
        wheelView3d2.setLineSpacingMultiplier(3.0f);
        this.f12438h.setCenterTextSize(this.q);
        this.f12438h.setOuterTextSize(this.r);
        this.f12438h.setTextColorCenter(-16777216);
        this.f12438h.setTextColorOut(-16777216);
        this.f12438h.setGravityOffset(this.p);
        this.f12438h.setGravity(3);
        this.f12438h.setDividerType(WheelView3d.DividerType.FILL);
        this.f12438h.setDividerColor(0);
        this.f12438h.setVisibleItem(7);
        this.f12438h.setOnItemSelectedListener(new b());
        g();
    }

    public final void g() {
        Calendar calendar = Calendar.getInstance();
        this.f12435e = calendar.get(11);
        this.f12436f = calendar.get(12);
        l();
    }

    public int getHour() {
        return this.f12435e;
    }

    public int getMinute() {
        return this.f12436f;
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
        int i = this.j;
        while (true) {
            int i2 = this.k;
            if (i > i2) {
                this.f12437g.setAdapter(new d.b.g0.a.q1.a.f.a.b(this.j, i2));
                k(this.f12437g, this.j, this.k);
                setHour(this.f12435e);
                return;
            }
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
            i++;
        }
    }

    public final void i() {
        this.l = 0;
        this.m = 59;
        Date date = this.n;
        if (date != null && this.f12435e == this.j) {
            this.l = date.getMinutes();
        }
        Date date2 = this.o;
        if (date2 != null && this.f12435e == this.k) {
            this.m = date2.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.m - this.l) + 1);
        int i = this.l;
        while (true) {
            int i2 = this.m;
            if (i > i2) {
                this.f12438h.setAdapter(new d.b.g0.a.q1.a.f.a.b(this.l, i2));
                k(this.f12438h, this.l, this.m);
                setMinute(this.f12436f);
                return;
            }
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
            i++;
        }
    }

    public final void j() {
        Paint paint = new Paint();
        this.s = paint;
        paint.setColor(-16777216);
        this.s.setAntiAlias(true);
        this.s.setTextSize(this.q);
    }

    public final void k(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void l() {
        h();
        i();
    }

    public void setDisabled(boolean z) {
        this.f12437g.setIsOptions(z);
        this.f12438h.setIsOptions(z);
    }

    public void setHour(int i) {
        int i2 = this.j;
        if (i < i2 || i > (i2 = this.k)) {
            i = i2;
        }
        this.f12435e = i;
        this.f12437g.setCurrentItem(i - this.j);
    }

    public void setMinute(int i) {
        int i2 = this.l;
        if (i < i2 || i > (i2 = this.m)) {
            i = i2;
        }
        this.f12436f = i;
        this.f12438h.setCurrentItem(i - this.l);
    }

    public void setOnTimeChangeListener(c cVar) {
    }

    public void setScrollCycle(boolean z) {
        this.f12438h.setCyclic(z);
        this.f12437g.setCyclic(z);
    }

    public void setStartDate(Date date) {
        this.n = date;
    }

    public void setmEndDate(Date date) {
        this.o = date;
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12435e = 0;
        this.f12436f = 0;
        this.p = 15;
        f(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12435e = 0;
        this.f12436f = 0;
        this.p = 15;
        f(context);
    }
}
