package com.baidu.swan.apps.res.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.tieba.R;
import com.baidu.tieba.d43;
import com.baidu.tieba.gj3;
import com.baidu.tieba.h43;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes4.dex */
public class BdTimePicker extends LinearLayout {
    public int a;
    public int b;
    public WheelView3d c;
    public WheelView3d d;
    public LinearLayout e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Date j;
    public Date k;
    public int l;
    public int m;
    public int n;
    public Paint o;

    /* loaded from: classes4.dex */
    public interface c {
    }

    public void setOnTimeChangeListener(c cVar) {
    }

    /* loaded from: classes4.dex */
    public class a implements h43 {
        public a() {
        }

        @Override // com.baidu.tieba.h43
        public void a(WheelView3d wheelView3d, int i) {
            BdTimePicker bdTimePicker = BdTimePicker.this;
            bdTimePicker.a = i + bdTimePicker.f;
            BdTimePicker.this.i();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h43 {
        public b() {
        }

        @Override // com.baidu.tieba.h43
        public void a(WheelView3d wheelView3d, int i) {
            BdTimePicker bdTimePicker = BdTimePicker.this;
            bdTimePicker.b = i + bdTimePicker.h;
        }
    }

    public BdTimePicker(Context context) {
        super(context);
        this.a = 0;
        this.b = 0;
        this.l = 15;
        f(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.c.getCenterContentOffset() * 2.0f), this.o);
    }

    public void setDisabled(boolean z) {
        this.c.setIsOptions(z);
        this.d.setIsOptions(z);
    }

    public void setHour(int i) {
        int i2 = this.f;
        if (i < i2 || i > (i2 = this.g)) {
            i = i2;
        }
        this.a = i;
        this.c.setCurrentItem(i - this.f);
    }

    public void setMinute(int i) {
        int i2 = this.h;
        if (i < i2 || i > (i2 = this.i)) {
            i = i2;
        }
        this.b = i;
        this.d.setCurrentItem(i - this.h);
    }

    public void setScrollCycle(boolean z) {
        this.d.setCyclic(z);
        this.c.setCyclic(z);
    }

    public void setStartDate(Date date) {
        this.j = date;
    }

    public void setmEndDate(Date date) {
        this.k = date;
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 0;
        this.l = 15;
        f(context);
    }

    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.l = 15;
        f(context);
    }

    public final void k(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public final void f(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00dc, this);
        this.l = gj3.f(context, this.l);
        this.m = gj3.f(context, 16.0f);
        this.n = gj3.f(context, 14.0f);
        j();
        this.e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092578);
        WheelView3d wheelView3d = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f092a2c);
        this.c = wheelView3d;
        wheelView3d.setLineSpacingMultiplier(3.0f);
        this.c.setCenterTextSize(this.m);
        this.c.setOuterTextSize(this.n);
        this.c.setTextColorCenter(-16777216);
        this.c.setTextColorOut(-16777216);
        this.c.setVisibleItem(7);
        this.c.setGravityOffset(this.l);
        this.c.setGravity(5);
        this.c.setDividerType(WheelView3d.DividerType.FILL);
        this.c.setDividerColor(0);
        this.c.setOnItemSelectedListener(new a());
        WheelView3d wheelView3d2 = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f092a2d);
        this.d = wheelView3d2;
        wheelView3d2.setLineSpacingMultiplier(3.0f);
        this.d.setCenterTextSize(this.m);
        this.d.setOuterTextSize(this.n);
        this.d.setTextColorCenter(-16777216);
        this.d.setTextColorOut(-16777216);
        this.d.setGravityOffset(this.l);
        this.d.setGravity(3);
        this.d.setDividerType(WheelView3d.DividerType.FILL);
        this.d.setDividerColor(0);
        this.d.setVisibleItem(7);
        this.d.setOnItemSelectedListener(new b());
        g();
    }

    public final void g() {
        Calendar calendar = Calendar.getInstance();
        this.a = calendar.get(11);
        this.b = calendar.get(12);
        l();
    }

    public int getHour() {
        return this.a;
    }

    public int getMinute() {
        return this.b;
    }

    public final void j() {
        Paint paint = new Paint();
        this.o = paint;
        paint.setColor(-16777216);
        this.o.setAntiAlias(true);
        this.o.setTextSize(this.m);
    }

    public void l() {
        h();
        i();
    }

    public final void h() {
        this.f = 0;
        this.g = 23;
        Date date = this.j;
        if (date != null) {
            this.f = date.getHours();
        }
        Date date2 = this.k;
        if (date2 != null) {
            this.g = date2.getHours();
        }
        ArrayList arrayList = new ArrayList((this.g - this.f) + 1);
        int i = this.f;
        while (true) {
            int i2 = this.g;
            if (i <= i2) {
                arrayList.add(String.format("%02d", Integer.valueOf(i)));
                i++;
            } else {
                this.c.setAdapter(new d43(this.f, i2));
                k(this.c, this.f, this.g);
                setHour(this.a);
                return;
            }
        }
    }

    public final void i() {
        this.h = 0;
        this.i = 59;
        Date date = this.j;
        if (date != null && this.a == this.f) {
            this.h = date.getMinutes();
        }
        Date date2 = this.k;
        if (date2 != null && this.a == this.g) {
            this.i = date2.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.i - this.h) + 1);
        int i = this.h;
        while (true) {
            int i2 = this.i;
            if (i <= i2) {
                arrayList.add(String.format("%02d", Integer.valueOf(i)));
                i++;
            } else {
                this.d.setAdapter(new d43(this.h, i2));
                k(this.d, this.h, this.i);
                setMinute(this.b);
                return;
            }
        }
    }
}
