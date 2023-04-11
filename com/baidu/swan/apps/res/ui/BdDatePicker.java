package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.tieba.R;
import com.baidu.tieba.eo1;
import com.baidu.tieba.i63;
import com.baidu.tieba.ll3;
import com.baidu.tieba.m63;
import com.baidu.tieba.m73;
import com.google.gson.internal.bind.TypeAdapters;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class BdDatePicker extends LinearLayout {
    public static final boolean s = eo1.a;
    public int a;
    public int b;
    public int c;
    public WheelView3d d;
    public WheelView3d e;
    public WheelView3d f;
    public Date g;
    public Date h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* loaded from: classes3.dex */
    public interface d {
    }

    public void setOnTimeChangeListener(d dVar) {
    }

    /* loaded from: classes3.dex */
    public class a implements m63 {
        public a() {
        }

        @Override // com.baidu.tieba.m63
        public void a(WheelView3d wheelView3d, int i) {
            BdDatePicker bdDatePicker = BdDatePicker.this;
            bdDatePicker.a = i + bdDatePicker.i;
            BdDatePicker.this.j();
            BdDatePicker.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements m63 {
        public b() {
        }

        @Override // com.baidu.tieba.m63
        public void a(WheelView3d wheelView3d, int i) {
            BdDatePicker bdDatePicker = BdDatePicker.this;
            bdDatePicker.b = i + bdDatePicker.k;
            BdDatePicker.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements m63 {
        public c() {
        }

        @Override // com.baidu.tieba.m63
        public void a(WheelView3d wheelView3d, int i) {
            BdDatePicker bdDatePicker = BdDatePicker.this;
            bdDatePicker.c = i + bdDatePicker.n;
        }
    }

    public int getDay() {
        return this.c;
    }

    public int getMonth() {
        return this.b;
    }

    public int getYear() {
        return this.a;
    }

    public final void h() {
        Calendar calendar = Calendar.getInstance();
        this.a = calendar.get(1);
        this.b = calendar.get(2) + 1;
        this.c = calendar.get(5);
        n();
    }

    public final void k() {
        int i = this.a;
        if (i < this.i || i > this.j) {
            this.a = this.i;
        }
        this.d.setAdapter(new i63(this.i, this.j));
        m(this.d, this.i, this.j);
    }

    public void n() {
        k();
        j();
        i();
    }

    public BdDatePicker(Context context) {
        super(context);
        this.a = FeatureCodes.SKY_SEG;
        this.b = 1;
        this.c = 1;
        this.i = FeatureCodes.SKY_SEG;
        this.j = 2100;
        this.k = 1;
        this.l = 12;
        this.m = 31;
        this.n = 1;
        this.o = 31;
        this.p = 12;
        g(context);
    }

    public void setDisabled(boolean z) {
        this.d.setIsOptions(z);
        this.e.setIsOptions(z);
        this.f.setIsOptions(z);
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.h = date;
            this.j = date.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.j = 2100;
    }

    public void setScrollCycle(boolean z) {
        this.e.setCyclic(z);
        this.d.setCyclic(z);
        this.f.setCyclic(z);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.g = date;
            this.i = date.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.i = FeatureCodes.SKY_SEG;
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = FeatureCodes.SKY_SEG;
        this.b = 1;
        this.c = 1;
        this.i = FeatureCodes.SKY_SEG;
        this.j = 2100;
        this.k = 1;
        this.l = 12;
        this.m = 31;
        this.n = 1;
        this.o = 31;
        this.p = 12;
        g(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = FeatureCodes.SKY_SEG;
        this.b = 1;
        this.c = 1;
        this.i = FeatureCodes.SKY_SEG;
        this.j = 2100;
        this.k = 1;
        this.l = 12;
        this.m = 31;
        this.n = 1;
        this.o = 31;
        this.p = 12;
        g(context);
    }

    public final void m(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public final void g(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00a1, this);
        this.p = ll3.g(this.p);
        this.q = ll3.g(16.0f);
        this.r = ll3.g(14.0f);
        WheelView3d wheelView3d = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f09287d);
        this.d = wheelView3d;
        wheelView3d.setCenterTextSize(this.q);
        this.d.setOuterTextSize(this.r);
        this.d.setLineSpacingMultiplier(3.0f);
        this.d.setTextColorCenter(-16777216);
        this.d.setTextColorOut(-16777216);
        this.d.setDividerType(WheelView3d.DividerType.FILL);
        this.d.setVisibleItem(7);
        this.d.setOnItemSelectedListener(new a());
        WheelView3d wheelView3d2 = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f09287c);
        this.e = wheelView3d2;
        wheelView3d2.setCenterTextSize(this.q);
        this.e.setOuterTextSize(this.r);
        this.e.setTextColorCenter(-16777216);
        this.e.setTextColorOut(-16777216);
        this.e.setLineSpacingMultiplier(3.0f);
        this.e.setDividerType(WheelView3d.DividerType.FILL);
        this.e.setVisibleItem(7);
        this.e.setOnItemSelectedListener(new b());
        WheelView3d wheelView3d3 = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f092879);
        this.f = wheelView3d3;
        wheelView3d3.setCenterTextSize(this.q);
        this.f.setOuterTextSize(this.r);
        this.f.setTextColorCenter(-16777216);
        this.f.setTextColorOut(-16777216);
        this.f.setLineSpacingMultiplier(3.0f);
        this.f.setDividerType(WheelView3d.DividerType.FILL);
        this.f.setVisibleItem(7);
        this.f.setOnItemSelectedListener(new c());
        h();
    }

    public void i() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.b) >= 0) {
            this.m = 31;
        } else if (Arrays.binarySearch(iArr, this.b) >= 0) {
            this.m = 30;
        } else {
            int i = this.a;
            if ((i % 4 == 0 && i % 100 != 0) || this.a % 400 == 0) {
                this.m = 29;
            } else {
                this.m = 28;
            }
        }
        this.n = 1;
        this.o = this.m;
        Date date = this.g;
        if (date != null && this.a == this.i && this.b == date.getMonth() + 1) {
            this.n = this.g.getDate();
        }
        Date date2 = this.h;
        if (date2 != null && this.a == this.j && this.b == date2.getMonth() + 1) {
            this.o = this.h.getDate();
        }
        this.f.setAdapter(new i63(this.n, this.o));
        m(this.f, this.n, this.o);
        setDay(this.c);
    }

    public void j() {
        this.k = 1;
        this.l = 12;
        Date date = this.g;
        if (date != null && this.a == this.i) {
            this.k = date.getMonth() + 1;
        }
        Date date2 = this.h;
        if (date2 != null && this.a == this.j) {
            this.l = date2.getMonth() + 1;
        }
        this.e.setAdapter(new i63(this.k, this.l));
        m(this.e, this.k, this.l);
        setMonth(this.b);
    }

    public boolean l(String str) {
        char c2;
        WheelView3d wheelView3d;
        int hashCode = str.hashCode();
        if (hashCode != 99228) {
            if (hashCode != 3704893) {
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
        } else {
            if (str.equals("day")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    wheelView3d = null;
                } else {
                    wheelView3d = this.f;
                }
            } else {
                wheelView3d = this.e;
            }
        } else {
            wheelView3d = this.d;
        }
        if (wheelView3d == null || wheelView3d.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void setDay(int i) {
        int i2;
        if (i >= this.n && i <= (i2 = this.o)) {
            if (i > i2) {
                if (s) {
                    Context appContext = AppRuntime.getAppContext();
                    m73.g(appContext, "The day must be between " + this.n + " and " + this.o).I();
                }
                i = i2;
            }
        } else {
            i = this.n;
            if (s) {
                Context appContext2 = AppRuntime.getAppContext();
                m73.g(appContext2, "The day must be between " + this.n + " and " + this.o).G();
            }
        }
        this.c = i;
        this.f.setCurrentItem(i - this.n);
    }

    public void setFields(String str) {
        if (!TextUtils.isEmpty(str)) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3704893) {
                if (hashCode == 104080000 && str.equals(TypeAdapters.AnonymousClass27.MONTH)) {
                    c2 = 1;
                }
            } else if (str.equals(TypeAdapters.AnonymousClass27.YEAR)) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    this.d.setGravity(5);
                    this.d.setGravityOffset(this.p);
                    this.f.setGravity(3);
                    this.f.setGravityOffset(this.p);
                    this.e.setVisibility(0);
                    this.f.setVisibility(0);
                    return;
                }
                this.d.setGravity(5);
                this.d.setGravityOffset(this.p);
                this.e.setGravity(3);
                this.e.setGravityOffset(this.p);
                this.e.setVisibility(0);
                this.f.setVisibility(8);
                return;
            }
            this.d.setGravity(17);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void setMonth(int i) {
        int i2 = this.k;
        if (i < i2) {
            if (s) {
                Context appContext = AppRuntime.getAppContext();
                m73.g(appContext, "The month must be between " + this.k + " and " + this.l).I();
            }
        } else {
            i2 = this.l;
            if (i > i2) {
                if (s) {
                    Context appContext2 = AppRuntime.getAppContext();
                    m73.g(appContext2, "The month must be between " + this.k + " and " + this.l).G();
                }
            }
            this.b = i;
            this.e.setCurrentItem(i - this.k);
        }
        i = i2;
        this.b = i;
        this.e.setCurrentItem(i - this.k);
    }

    public void setYear(int i) {
        int i2 = this.i;
        if (i < i2) {
            if (s) {
                Context appContext = AppRuntime.getAppContext();
                m73.g(appContext, "The year must be between " + this.i + " and " + this.j).I();
            }
        } else {
            i2 = this.j;
            if (i > i2) {
                if (s) {
                    Context appContext2 = AppRuntime.getAppContext();
                    m73.g(appContext2, "The year must be between " + this.i + " and " + this.j).G();
                }
            }
            this.a = i;
            this.d.setCurrentItem(i - this.i);
        }
        i = i2;
        this.a = i;
        this.d.setCurrentItem(i - this.i);
    }
}
