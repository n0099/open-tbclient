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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class BdTimePicker extends LinearLayout {
    private int UB;
    private boolean cMB;
    private int cMC;
    private int cMD;
    private int cMP;
    private WheelView3d cMQ;
    private WheelView3d cMR;
    private a cMS;
    private LinearLayout cMT;
    private int cMU;
    private int cMV;
    private int cMW;
    private int cMX;
    private Paint cMY;
    private Date cMr;
    private Date cMs;
    private int mTextSize;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.cMP = 0;
        this.UB = 0;
        this.cMC = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cMP = 0;
        this.UB = 0;
        this.cMC = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cMP = 0;
        this.UB = 0;
        this.cMC = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.cMC = ah.dip2px(context, this.cMC);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.cMD = ah.dip2px(context, 14.0f);
        sw();
        this.cMT = (LinearLayout) findViewById(a.f.timepicker_root);
        this.cMQ = (WheelView3d) findViewById(a.f.wheel_hour);
        this.cMQ.setLineSpacingMultiplier(3.0f);
        this.cMQ.setCenterTextSize(this.mTextSize);
        this.cMQ.setOuterTextSize(this.cMD);
        this.cMQ.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cMQ.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cMQ.setVisibleItem(7);
        this.cMQ.setGravityOffset(this.cMC);
        this.cMQ.setGravity(5);
        this.cMQ.setDividerType(WheelView3d.DividerType.FILL);
        this.cMQ.setDividerColor(0);
        this.cMQ.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.cMP = BdTimePicker.this.cMU + i;
                BdTimePicker.this.azf();
            }
        });
        this.cMR = (WheelView3d) findViewById(a.f.wheel_minute);
        this.cMR.setLineSpacingMultiplier(3.0f);
        this.cMR.setCenterTextSize(this.mTextSize);
        this.cMR.setOuterTextSize(this.cMD);
        this.cMR.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cMR.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cMR.setGravityOffset(this.cMC);
        this.cMR.setGravity(3);
        this.cMR.setDividerType(WheelView3d.DividerType.FILL);
        this.cMR.setDividerColor(0);
        this.cMR.setVisibleItem(7);
        this.cMR.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.UB = BdTimePicker.this.cMW + i;
            }
        });
        aza();
    }

    private void sw() {
        this.cMY = new Paint();
        this.cMY.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cMY.setAntiAlias(true);
        this.cMY.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.cMQ.getCenterContentOffset() * 2.0f), this.cMY);
    }

    private void aza() {
        Calendar calendar = Calendar.getInstance();
        this.cMP = calendar.get(11);
        this.UB = calendar.get(12);
        azb();
    }

    public void azb() {
        azg();
        azf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azf() {
        this.cMW = 0;
        this.cMX = 59;
        if (this.cMr != null && this.cMP == this.cMU) {
            this.cMW = this.cMr.getMinutes();
        }
        if (this.cMs != null && this.cMP == this.cMV) {
            this.cMX = this.cMs.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.cMX - this.cMW) + 1);
        for (int i = this.cMW; i <= this.cMX; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cMR.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cMW, this.cMX));
        a(this.cMR, this.cMW, this.cMX);
        setMinute(this.UB);
    }

    private void azg() {
        this.cMU = 0;
        this.cMV = 23;
        if (this.cMr != null) {
            this.cMU = this.cMr.getHours();
        }
        if (this.cMs != null) {
            this.cMV = this.cMs.getHours();
        }
        ArrayList arrayList = new ArrayList((this.cMV - this.cMU) + 1);
        for (int i = this.cMU; i <= this.cMV; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cMQ.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cMU, this.cMV));
        a(this.cMQ, this.cMU, this.cMV);
        setHour(this.cMP);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.cMr = date;
    }

    public void setmEndDate(Date date) {
        this.cMs = date;
    }

    public void setDisabled(boolean z) {
        this.cMB = z;
        this.cMQ.setIsOptions(z);
        this.cMR.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cMS = aVar;
    }

    public void setHour(int i) {
        if (i < this.cMU) {
            i = this.cMU;
        } else if (i > this.cMV) {
            i = this.cMV;
        }
        this.cMP = i;
        this.cMQ.setCurrentItem(i - this.cMU);
    }

    public int getHour() {
        return this.cMP;
    }

    public void setMinute(int i) {
        if (i < this.cMW) {
            i = this.cMW;
        } else if (i > this.cMX) {
            i = this.cMX;
        }
        this.UB = i;
        this.cMR.setCurrentItem(i - this.cMW);
    }

    public int getMinute() {
        return this.UB;
    }

    public void setScrollCycle(boolean z) {
        this.cMR.setCyclic(z);
        this.cMQ.setCyclic(z);
    }
}
