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
    private Date bJY;
    private Date bJZ;
    private LinearLayout bKA;
    private int bKB;
    private int bKC;
    private int bKD;
    private int bKE;
    private Paint bKF;
    private boolean bKi;
    private int bKj;
    private int bKk;
    private int bKw;
    private WheelView3d bKx;
    private WheelView3d bKy;
    private a bKz;
    private int mTextSize;
    private int zH;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.bKw = 0;
        this.zH = 0;
        this.bKj = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKw = 0;
        this.zH = 0;
        this.bKj = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKw = 0;
        this.zH = 0;
        this.bKj = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.bKj = af.dip2px(context, this.bKj);
        this.mTextSize = af.dip2px(context, 16.0f);
        this.bKk = af.dip2px(context, 14.0f);
        lQ();
        this.bKA = (LinearLayout) findViewById(a.f.timepicker_root);
        this.bKx = (WheelView3d) findViewById(a.f.wheel_hour);
        this.bKx.setLineSpacingMultiplier(3.0f);
        this.bKx.setCenterTextSize(this.mTextSize);
        this.bKx.setOuterTextSize(this.bKk);
        this.bKx.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKx.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKx.setVisibleItem(7);
        this.bKx.setGravityOffset(this.bKj);
        this.bKx.setGravity(5);
        this.bKx.setDividerType(WheelView3d.DividerType.FILL);
        this.bKx.setDividerColor(0);
        this.bKx.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.bKw = BdTimePicker.this.bKB + i;
                BdTimePicker.this.abH();
            }
        });
        this.bKy = (WheelView3d) findViewById(a.f.wheel_minute);
        this.bKy.setLineSpacingMultiplier(3.0f);
        this.bKy.setCenterTextSize(this.mTextSize);
        this.bKy.setOuterTextSize(this.bKk);
        this.bKy.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKy.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKy.setGravityOffset(this.bKj);
        this.bKy.setGravity(3);
        this.bKy.setDividerType(WheelView3d.DividerType.FILL);
        this.bKy.setDividerColor(0);
        this.bKy.setVisibleItem(7);
        this.bKy.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.zH = BdTimePicker.this.bKD + i;
            }
        });
        abC();
    }

    private void lQ() {
        this.bKF = new Paint();
        this.bKF.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bKF.setAntiAlias(true);
        this.bKF.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.bKx.getCenterContentOffset() * 2.0f), this.bKF);
    }

    private void abC() {
        Calendar calendar = Calendar.getInstance();
        this.bKw = calendar.get(11);
        this.zH = calendar.get(12);
        abD();
    }

    public void abD() {
        abI();
        abH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abH() {
        this.bKD = 0;
        this.bKE = 59;
        if (this.bJY != null && this.bKw == this.bKB) {
            this.bKD = this.bJY.getMinutes();
        }
        if (this.bJZ != null && this.bKw == this.bKC) {
            this.bKE = this.bJZ.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.bKE - this.bKD) + 1);
        for (int i = this.bKD; i <= this.bKE; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bKy.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKD, this.bKE));
        a(this.bKy, this.bKD, this.bKE);
        setMinute(this.zH);
    }

    private void abI() {
        this.bKB = 0;
        this.bKC = 23;
        if (this.bJY != null) {
            this.bKB = this.bJY.getHours();
        }
        if (this.bJZ != null) {
            this.bKC = this.bJZ.getHours();
        }
        ArrayList arrayList = new ArrayList((this.bKC - this.bKB) + 1);
        for (int i = this.bKB; i <= this.bKC; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bKx.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKB, this.bKC));
        a(this.bKx, this.bKB, this.bKC);
        setHour(this.bKw);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.bJY = date;
    }

    public void setmEndDate(Date date) {
        this.bJZ = date;
    }

    public void setDisabled(boolean z) {
        this.bKi = z;
        this.bKx.setIsOptions(z);
        this.bKy.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bKz = aVar;
    }

    public void setHour(int i) {
        if (i < this.bKB) {
            i = this.bKB;
        } else if (i > this.bKC) {
            i = this.bKC;
        }
        this.bKw = i;
        this.bKx.setCurrentItem(i - this.bKB);
    }

    public int getHour() {
        return this.bKw;
    }

    public void setMinute(int i) {
        if (i < this.bKD) {
            i = this.bKD;
        } else if (i > this.bKE) {
            i = this.bKE;
        }
        this.zH = i;
        this.bKy.setCurrentItem(i - this.bKD);
    }

    public int getMinute() {
        return this.zH;
    }

    public void setScrollCycle(boolean z) {
        this.bKy.setCyclic(z);
        this.bKx.setCyclic(z);
    }
}
