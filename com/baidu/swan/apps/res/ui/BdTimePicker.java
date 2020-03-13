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
    private Date bJZ;
    private a bKA;
    private LinearLayout bKB;
    private int bKC;
    private int bKD;
    private int bKE;
    private int bKF;
    private Paint bKG;
    private Date bKa;
    private boolean bKj;
    private int bKk;
    private int bKl;
    private int bKx;
    private WheelView3d bKy;
    private WheelView3d bKz;
    private int mTextSize;
    private int zH;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.bKx = 0;
        this.zH = 0;
        this.bKk = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKx = 0;
        this.zH = 0;
        this.bKk = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKx = 0;
        this.zH = 0;
        this.bKk = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.bKk = af.dip2px(context, this.bKk);
        this.mTextSize = af.dip2px(context, 16.0f);
        this.bKl = af.dip2px(context, 14.0f);
        lQ();
        this.bKB = (LinearLayout) findViewById(a.f.timepicker_root);
        this.bKy = (WheelView3d) findViewById(a.f.wheel_hour);
        this.bKy.setLineSpacingMultiplier(3.0f);
        this.bKy.setCenterTextSize(this.mTextSize);
        this.bKy.setOuterTextSize(this.bKl);
        this.bKy.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKy.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKy.setVisibleItem(7);
        this.bKy.setGravityOffset(this.bKk);
        this.bKy.setGravity(5);
        this.bKy.setDividerType(WheelView3d.DividerType.FILL);
        this.bKy.setDividerColor(0);
        this.bKy.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.bKx = BdTimePicker.this.bKC + i;
                BdTimePicker.this.abH();
            }
        });
        this.bKz = (WheelView3d) findViewById(a.f.wheel_minute);
        this.bKz.setLineSpacingMultiplier(3.0f);
        this.bKz.setCenterTextSize(this.mTextSize);
        this.bKz.setOuterTextSize(this.bKl);
        this.bKz.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKz.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKz.setGravityOffset(this.bKk);
        this.bKz.setGravity(3);
        this.bKz.setDividerType(WheelView3d.DividerType.FILL);
        this.bKz.setDividerColor(0);
        this.bKz.setVisibleItem(7);
        this.bKz.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.zH = BdTimePicker.this.bKE + i;
            }
        });
        abC();
    }

    private void lQ() {
        this.bKG = new Paint();
        this.bKG.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bKG.setAntiAlias(true);
        this.bKG.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.bKy.getCenterContentOffset() * 2.0f), this.bKG);
    }

    private void abC() {
        Calendar calendar = Calendar.getInstance();
        this.bKx = calendar.get(11);
        this.zH = calendar.get(12);
        abD();
    }

    public void abD() {
        abI();
        abH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abH() {
        this.bKE = 0;
        this.bKF = 59;
        if (this.bJZ != null && this.bKx == this.bKC) {
            this.bKE = this.bJZ.getMinutes();
        }
        if (this.bKa != null && this.bKx == this.bKD) {
            this.bKF = this.bKa.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.bKF - this.bKE) + 1);
        for (int i = this.bKE; i <= this.bKF; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bKz.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKE, this.bKF));
        a(this.bKz, this.bKE, this.bKF);
        setMinute(this.zH);
    }

    private void abI() {
        this.bKC = 0;
        this.bKD = 23;
        if (this.bJZ != null) {
            this.bKC = this.bJZ.getHours();
        }
        if (this.bKa != null) {
            this.bKD = this.bKa.getHours();
        }
        ArrayList arrayList = new ArrayList((this.bKD - this.bKC) + 1);
        for (int i = this.bKC; i <= this.bKD; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bKy.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKC, this.bKD));
        a(this.bKy, this.bKC, this.bKD);
        setHour(this.bKx);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.bJZ = date;
    }

    public void setmEndDate(Date date) {
        this.bKa = date;
    }

    public void setDisabled(boolean z) {
        this.bKj = z;
        this.bKy.setIsOptions(z);
        this.bKz.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bKA = aVar;
    }

    public void setHour(int i) {
        if (i < this.bKC) {
            i = this.bKC;
        } else if (i > this.bKD) {
            i = this.bKD;
        }
        this.bKx = i;
        this.bKy.setCurrentItem(i - this.bKC);
    }

    public int getHour() {
        return this.bKx;
    }

    public void setMinute(int i) {
        if (i < this.bKE) {
            i = this.bKE;
        } else if (i > this.bKF) {
            i = this.bKF;
        }
        this.zH = i;
        this.bKz.setCurrentItem(i - this.bKE);
    }

    public int getMinute() {
        return this.zH;
    }

    public void setScrollCycle(boolean z) {
        this.bKz.setCyclic(z);
        this.bKy.setCyclic(z);
    }
}
