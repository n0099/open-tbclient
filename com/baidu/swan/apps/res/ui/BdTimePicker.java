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
/* loaded from: classes7.dex */
public class BdTimePicker extends LinearLayout {
    private int UW;
    private int dlH;
    private WheelView3d dlI;
    private WheelView3d dlJ;
    private a dlK;
    private LinearLayout dlL;
    private int dlM;
    private int dlN;
    private int dlO;
    private int dlP;
    private Paint dlQ;
    private Date dlj;
    private Date dlk;
    private boolean dlt;
    private int dlu;
    private int dlv;
    private int mTextSize;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.dlH = 0;
        this.UW = 0;
        this.dlu = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dlH = 0;
        this.UW = 0;
        this.dlu = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dlH = 0;
        this.UW = 0;
        this.dlu = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.dlu = ah.dip2px(context, this.dlu);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.dlv = ah.dip2px(context, 14.0f);
        sw();
        this.dlL = (LinearLayout) findViewById(a.f.timepicker_root);
        this.dlI = (WheelView3d) findViewById(a.f.wheel_hour);
        this.dlI.setLineSpacingMultiplier(3.0f);
        this.dlI.setCenterTextSize(this.mTextSize);
        this.dlI.setOuterTextSize(this.dlv);
        this.dlI.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dlI.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dlI.setVisibleItem(7);
        this.dlI.setGravityOffset(this.dlu);
        this.dlI.setGravity(5);
        this.dlI.setDividerType(WheelView3d.DividerType.FILL);
        this.dlI.setDividerColor(0);
        this.dlI.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.dlH = BdTimePicker.this.dlM + i;
                BdTimePicker.this.aFA();
            }
        });
        this.dlJ = (WheelView3d) findViewById(a.f.wheel_minute);
        this.dlJ.setLineSpacingMultiplier(3.0f);
        this.dlJ.setCenterTextSize(this.mTextSize);
        this.dlJ.setOuterTextSize(this.dlv);
        this.dlJ.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dlJ.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dlJ.setGravityOffset(this.dlu);
        this.dlJ.setGravity(3);
        this.dlJ.setDividerType(WheelView3d.DividerType.FILL);
        this.dlJ.setDividerColor(0);
        this.dlJ.setVisibleItem(7);
        this.dlJ.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.UW = BdTimePicker.this.dlO + i;
            }
        });
        aFv();
    }

    private void sw() {
        this.dlQ = new Paint();
        this.dlQ.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dlQ.setAntiAlias(true);
        this.dlQ.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.dlI.getCenterContentOffset() * 2.0f), this.dlQ);
    }

    private void aFv() {
        Calendar calendar = Calendar.getInstance();
        this.dlH = calendar.get(11);
        this.UW = calendar.get(12);
        aFw();
    }

    public void aFw() {
        aFB();
        aFA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFA() {
        this.dlO = 0;
        this.dlP = 59;
        if (this.dlj != null && this.dlH == this.dlM) {
            this.dlO = this.dlj.getMinutes();
        }
        if (this.dlk != null && this.dlH == this.dlN) {
            this.dlP = this.dlk.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.dlP - this.dlO) + 1);
        for (int i = this.dlO; i <= this.dlP; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dlJ.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dlO, this.dlP));
        a(this.dlJ, this.dlO, this.dlP);
        setMinute(this.UW);
    }

    private void aFB() {
        this.dlM = 0;
        this.dlN = 23;
        if (this.dlj != null) {
            this.dlM = this.dlj.getHours();
        }
        if (this.dlk != null) {
            this.dlN = this.dlk.getHours();
        }
        ArrayList arrayList = new ArrayList((this.dlN - this.dlM) + 1);
        for (int i = this.dlM; i <= this.dlN; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dlI.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dlM, this.dlN));
        a(this.dlI, this.dlM, this.dlN);
        setHour(this.dlH);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.dlj = date;
    }

    public void setmEndDate(Date date) {
        this.dlk = date;
    }

    public void setDisabled(boolean z) {
        this.dlt = z;
        this.dlI.setIsOptions(z);
        this.dlJ.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dlK = aVar;
    }

    public void setHour(int i) {
        if (i < this.dlM) {
            i = this.dlM;
        } else if (i > this.dlN) {
            i = this.dlN;
        }
        this.dlH = i;
        this.dlI.setCurrentItem(i - this.dlM);
    }

    public int getHour() {
        return this.dlH;
    }

    public void setMinute(int i) {
        if (i < this.dlO) {
            i = this.dlO;
        } else if (i > this.dlP) {
            i = this.dlP;
        }
        this.UW = i;
        this.dlJ.setCurrentItem(i - this.dlO);
    }

    public int getMinute() {
        return this.UW;
    }

    public void setScrollCycle(boolean z) {
        this.dlJ.setCyclic(z);
        this.dlI.setCyclic(z);
    }
}
