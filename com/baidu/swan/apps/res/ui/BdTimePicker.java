package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes11.dex */
public class BdTimePicker extends LinearLayout {
    private int SX;
    private WheelView3d cjA;
    private a cjB;
    private LinearLayout cjC;
    private int cjD;
    private int cjE;
    private int cjF;
    private int cjG;
    private Paint cjH;
    private Date cja;
    private Date cjb;
    private boolean cjk;
    private int cjl;
    private int cjm;
    private int cjy;
    private WheelView3d cjz;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.cjy = 0;
        this.SX = 0;
        this.cjl = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjy = 0;
        this.SX = 0;
        this.cjl = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjy = 0;
        this.SX = 0;
        this.cjl = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.cjl = af.dip2px(context, this.cjl);
        this.mTextSize = af.dip2px(context, 16.0f);
        this.cjm = af.dip2px(context, 14.0f);
        qs();
        this.cjC = (LinearLayout) findViewById(a.f.timepicker_root);
        this.cjz = (WheelView3d) findViewById(a.f.wheel_hour);
        this.cjz.setLineSpacingMultiplier(3.0f);
        this.cjz.setCenterTextSize(this.mTextSize);
        this.cjz.setOuterTextSize(this.cjm);
        this.cjz.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cjz.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cjz.setVisibleItem(7);
        this.cjz.setGravityOffset(this.cjl);
        this.cjz.setGravity(5);
        this.cjz.setDividerType(WheelView3d.DividerType.FILL);
        this.cjz.setDividerColor(0);
        this.cjz.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.cjy = BdTimePicker.this.cjD + i;
                BdTimePicker.this.ajO();
            }
        });
        this.cjA = (WheelView3d) findViewById(a.f.wheel_minute);
        this.cjA.setLineSpacingMultiplier(3.0f);
        this.cjA.setCenterTextSize(this.mTextSize);
        this.cjA.setOuterTextSize(this.cjm);
        this.cjA.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cjA.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cjA.setGravityOffset(this.cjl);
        this.cjA.setGravity(3);
        this.cjA.setDividerType(WheelView3d.DividerType.FILL);
        this.cjA.setDividerColor(0);
        this.cjA.setVisibleItem(7);
        this.cjA.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.SX = BdTimePicker.this.cjF + i;
            }
        });
        ajJ();
    }

    private void qs() {
        this.cjH = new Paint();
        this.cjH.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cjH.setAntiAlias(true);
        this.cjH.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.cjz.getCenterContentOffset() * 2.0f), this.cjH);
    }

    private void ajJ() {
        Calendar calendar = Calendar.getInstance();
        this.cjy = calendar.get(11);
        this.SX = calendar.get(12);
        ajK();
    }

    public void ajK() {
        ajP();
        ajO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajO() {
        this.cjF = 0;
        this.cjG = 59;
        if (this.cja != null && this.cjy == this.cjD) {
            this.cjF = this.cja.getMinutes();
        }
        if (this.cjb != null && this.cjy == this.cjE) {
            this.cjG = this.cjb.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.cjG - this.cjF) + 1);
        for (int i = this.cjF; i <= this.cjG; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cjA.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cjF, this.cjG));
        a(this.cjA, this.cjF, this.cjG);
        setMinute(this.SX);
    }

    private void ajP() {
        this.cjD = 0;
        this.cjE = 23;
        if (this.cja != null) {
            this.cjD = this.cja.getHours();
        }
        if (this.cjb != null) {
            this.cjE = this.cjb.getHours();
        }
        ArrayList arrayList = new ArrayList((this.cjE - this.cjD) + 1);
        for (int i = this.cjD; i <= this.cjE; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cjz.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cjD, this.cjE));
        a(this.cjz, this.cjD, this.cjE);
        setHour(this.cjy);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.cja = date;
    }

    public void setmEndDate(Date date) {
        this.cjb = date;
    }

    public void setDisabled(boolean z) {
        this.cjk = z;
        this.cjz.setIsOptions(z);
        this.cjA.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cjB = aVar;
    }

    public void setHour(int i) {
        if (i < this.cjD) {
            i = this.cjD;
        } else if (i > this.cjE) {
            i = this.cjE;
        }
        this.cjy = i;
        this.cjz.setCurrentItem(i - this.cjD);
    }

    public int getHour() {
        return this.cjy;
    }

    public void setMinute(int i) {
        if (i < this.cjF) {
            i = this.cjF;
        } else if (i > this.cjG) {
            i = this.cjG;
        }
        this.SX = i;
        this.cjA.setCurrentItem(i - this.cjF);
    }

    public int getMinute() {
        return this.SX;
    }

    public void setScrollCycle(boolean z) {
        this.cjA.setCyclic(z);
        this.cjz.setCyclic(z);
    }
}
