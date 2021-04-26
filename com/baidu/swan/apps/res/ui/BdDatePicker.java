package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.google.gson.internal.bind.TypeAdapters;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.i2.h0;
import d.a.h0.a.k;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class BdDatePicker extends LinearLayout {
    public static final boolean w = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public int f11934e;

    /* renamed from: f  reason: collision with root package name */
    public int f11935f;

    /* renamed from: g  reason: collision with root package name */
    public int f11936g;

    /* renamed from: h  reason: collision with root package name */
    public WheelView3d f11937h;

    /* renamed from: i  reason: collision with root package name */
    public WheelView3d f11938i;
    public WheelView3d j;
    public Date k;
    public Date l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.q1.a.f.c.b {
        public a() {
        }

        @Override // d.a.h0.a.q1.a.f.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            BdDatePicker bdDatePicker = BdDatePicker.this;
            bdDatePicker.f11934e = i2 + bdDatePicker.m;
            BdDatePicker.this.j();
            BdDatePicker.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.q1.a.f.c.b {
        public b() {
        }

        @Override // d.a.h0.a.q1.a.f.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            BdDatePicker bdDatePicker = BdDatePicker.this;
            bdDatePicker.f11935f = i2 + bdDatePicker.o;
            BdDatePicker.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.q1.a.f.c.b {
        public c() {
        }

        @Override // d.a.h0.a.q1.a.f.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            BdDatePicker bdDatePicker = BdDatePicker.this;
            bdDatePicker.f11936g = i2 + bdDatePicker.r;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.f11934e = 1900;
        this.f11935f = 1;
        this.f11936g = 1;
        this.m = 1900;
        this.n = 2100;
        this.o = 1;
        this.p = 12;
        this.q = 31;
        this.r = 1;
        this.s = 31;
        this.t = 12;
        g(context);
    }

    public final void g(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(g.aiapps_datepicker_layout, this);
        this.t = h0.f(this.t);
        this.u = h0.f(16.0f);
        this.v = h0.f(14.0f);
        WheelView3d wheelView3d = (WheelView3d) findViewById(f.wheel_year);
        this.f11937h = wheelView3d;
        wheelView3d.setCenterTextSize(this.u);
        this.f11937h.setOuterTextSize(this.v);
        this.f11937h.setLineSpacingMultiplier(3.0f);
        this.f11937h.setTextColorCenter(-16777216);
        this.f11937h.setTextColorOut(-16777216);
        this.f11937h.setDividerType(WheelView3d.DividerType.FILL);
        this.f11937h.setVisibleItem(7);
        this.f11937h.setOnItemSelectedListener(new a());
        WheelView3d wheelView3d2 = (WheelView3d) findViewById(f.wheel_month);
        this.f11938i = wheelView3d2;
        wheelView3d2.setCenterTextSize(this.u);
        this.f11938i.setOuterTextSize(this.v);
        this.f11938i.setTextColorCenter(-16777216);
        this.f11938i.setTextColorOut(-16777216);
        this.f11938i.setLineSpacingMultiplier(3.0f);
        this.f11938i.setDividerType(WheelView3d.DividerType.FILL);
        this.f11938i.setVisibleItem(7);
        this.f11938i.setOnItemSelectedListener(new b());
        WheelView3d wheelView3d3 = (WheelView3d) findViewById(f.wheel_day);
        this.j = wheelView3d3;
        wheelView3d3.setCenterTextSize(this.u);
        this.j.setOuterTextSize(this.v);
        this.j.setTextColorCenter(-16777216);
        this.j.setTextColorOut(-16777216);
        this.j.setLineSpacingMultiplier(3.0f);
        this.j.setDividerType(WheelView3d.DividerType.FILL);
        this.j.setVisibleItem(7);
        this.j.setOnItemSelectedListener(new c());
        h();
    }

    public int getDay() {
        return this.f11936g;
    }

    public int getMonth() {
        return this.f11935f;
    }

    public int getYear() {
        return this.f11934e;
    }

    public final void h() {
        Calendar calendar = Calendar.getInstance();
        this.f11934e = calendar.get(1);
        this.f11935f = calendar.get(2) + 1;
        this.f11936g = calendar.get(5);
        n();
    }

    public void i() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.f11935f) >= 0) {
            this.q = 31;
        } else if (Arrays.binarySearch(iArr, this.f11935f) >= 0) {
            this.q = 30;
        } else {
            int i2 = this.f11934e;
            if ((i2 % 4 == 0 && i2 % 100 != 0) || this.f11934e % 400 == 0) {
                this.q = 29;
            } else {
                this.q = 28;
            }
        }
        this.r = 1;
        this.s = this.q;
        Date date = this.k;
        if (date != null && this.f11934e == this.m && this.f11935f == date.getMonth() + 1) {
            this.r = this.k.getDate();
        }
        Date date2 = this.l;
        if (date2 != null && this.f11934e == this.n && this.f11935f == date2.getMonth() + 1) {
            this.s = this.l.getDate();
        }
        this.j.setAdapter(new d.a.h0.a.q1.a.f.a.b(this.r, this.s));
        m(this.j, this.r, this.s);
        setDay(this.f11936g);
    }

    public void j() {
        this.o = 1;
        this.p = 12;
        Date date = this.k;
        if (date != null && this.f11934e == this.m) {
            this.o = date.getMonth() + 1;
        }
        Date date2 = this.l;
        if (date2 != null && this.f11934e == this.n) {
            this.p = date2.getMonth() + 1;
        }
        this.f11938i.setAdapter(new d.a.h0.a.q1.a.f.a.b(this.o, this.p));
        m(this.f11938i, this.o, this.p);
        setMonth(this.f11935f);
    }

    public final void k() {
        int i2 = this.f11934e;
        if (i2 < this.m || i2 > this.n) {
            this.f11934e = this.m;
        }
        this.f11937h.setAdapter(new d.a.h0.a.q1.a.f.a.b(this.m, this.n));
        m(this.f11937h, this.m, this.n);
    }

    public boolean l(String str) {
        char c2;
        WheelView3d wheelView3d;
        int hashCode = str.hashCode();
        if (hashCode == 99228) {
            if (str.equals(Config.TRACE_VISIT_RECENT_DAY)) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 3704893) {
            if (hashCode == 104080000 && str.equals(TypeAdapters.AnonymousClass27.MONTH)) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals(TypeAdapters.AnonymousClass27.YEAR)) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            wheelView3d = this.f11937h;
        } else if (c2 != 1) {
            wheelView3d = c2 != 2 ? null : this.j;
        } else {
            wheelView3d = this.f11938i;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public final void m(WheelView3d wheelView3d, int i2, int i3) {
        if ((i3 - i2) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void n() {
        k();
        j();
        i();
    }

    public void setDay(int i2) {
        int i3;
        if (i2 < this.r || i2 > (i3 = this.s)) {
            i2 = this.r;
            if (w) {
                Context appContext = AppRuntime.getAppContext();
                d.a.h0.a.q1.b.f.d.f(appContext, "The day must be between " + this.r + " and " + this.s).C();
            }
        } else if (i2 > i3) {
            if (w) {
                Context appContext2 = AppRuntime.getAppContext();
                d.a.h0.a.q1.b.f.d.f(appContext2, "The day must be between " + this.r + " and " + this.s).E();
            }
            i2 = i3;
        }
        this.f11936g = i2;
        this.j.setCurrentItem(i2 - this.r);
    }

    public void setDisabled(boolean z) {
        this.f11937h.setIsOptions(z);
        this.f11938i.setIsOptions(z);
        this.j.setIsOptions(z);
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.l = date;
            this.n = date.getYear() + 1900;
            return;
        }
        this.n = 2100;
    }

    public void setFields(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 3704893) {
            if (hashCode == 104080000 && str.equals(TypeAdapters.AnonymousClass27.MONTH)) {
                c2 = 1;
            }
        } else if (str.equals(TypeAdapters.AnonymousClass27.YEAR)) {
            c2 = 0;
        }
        if (c2 == 0) {
            this.f11937h.setGravity(17);
            this.f11938i.setVisibility(8);
            this.j.setVisibility(8);
        } else if (c2 != 1) {
            this.f11937h.setGravity(5);
            this.f11937h.setGravityOffset(this.t);
            this.j.setGravity(3);
            this.j.setGravityOffset(this.t);
            this.f11938i.setVisibility(0);
            this.j.setVisibility(0);
        } else {
            this.f11937h.setGravity(5);
            this.f11937h.setGravityOffset(this.t);
            this.f11938i.setGravity(3);
            this.f11938i.setGravityOffset(this.t);
            this.f11938i.setVisibility(0);
            this.j.setVisibility(8);
        }
    }

    public void setMonth(int i2) {
        int i3 = this.o;
        if (i2 < i3) {
            if (w) {
                Context appContext = AppRuntime.getAppContext();
                d.a.h0.a.q1.b.f.d.f(appContext, "The month must be between " + this.o + " and " + this.p).E();
            }
        } else {
            i3 = this.p;
            if (i2 > i3) {
                if (w) {
                    Context appContext2 = AppRuntime.getAppContext();
                    d.a.h0.a.q1.b.f.d.f(appContext2, "The month must be between " + this.o + " and " + this.p).C();
                }
            }
            this.f11935f = i2;
            this.f11938i.setCurrentItem(i2 - this.o);
        }
        i2 = i3;
        this.f11935f = i2;
        this.f11938i.setCurrentItem(i2 - this.o);
    }

    public void setOnTimeChangeListener(d dVar) {
    }

    public void setScrollCycle(boolean z) {
        this.f11938i.setCyclic(z);
        this.f11937h.setCyclic(z);
        this.j.setCyclic(z);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.k = date;
            this.m = date.getYear() + 1900;
            return;
        }
        this.m = 1900;
    }

    public void setYear(int i2) {
        int i3 = this.m;
        if (i2 < i3) {
            if (w) {
                Context appContext = AppRuntime.getAppContext();
                d.a.h0.a.q1.b.f.d.f(appContext, "The year must be between " + this.m + " and " + this.n).E();
            }
        } else {
            i3 = this.n;
            if (i2 > i3) {
                if (w) {
                    Context appContext2 = AppRuntime.getAppContext();
                    d.a.h0.a.q1.b.f.d.f(appContext2, "The year must be between " + this.m + " and " + this.n).C();
                }
            }
            this.f11934e = i2;
            this.f11937h.setCurrentItem(i2 - this.m);
        }
        i2 = i3;
        this.f11934e = i2;
        this.f11937h.setCurrentItem(i2 - this.m);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11934e = 1900;
        this.f11935f = 1;
        this.f11936g = 1;
        this.m = 1900;
        this.n = 2100;
        this.o = 1;
        this.p = 12;
        this.q = 31;
        this.r = 1;
        this.s = 31;
        this.t = 12;
        g(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11934e = 1900;
        this.f11935f = 1;
        this.f11936g = 1;
        this.m = 1900;
        this.n = 2100;
        this.o = 1;
        this.p = 12;
        this.q = 31;
        this.r = 1;
        this.s = 31;
        this.t = 12;
        g(context);
    }
}
