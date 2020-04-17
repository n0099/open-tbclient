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
    private int SU;
    private Date ciU;
    private Date ciV;
    private int cjA;
    private Paint cjB;
    private boolean cje;
    private int cjf;
    private int cjg;
    private int cjs;
    private WheelView3d cjt;
    private WheelView3d cju;
    private a cjv;
    private LinearLayout cjw;
    private int cjx;
    private int cjy;
    private int cjz;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.cjs = 0;
        this.SU = 0;
        this.cjf = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjs = 0;
        this.SU = 0;
        this.cjf = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjs = 0;
        this.SU = 0;
        this.cjf = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.cjf = af.dip2px(context, this.cjf);
        this.mTextSize = af.dip2px(context, 16.0f);
        this.cjg = af.dip2px(context, 14.0f);
        qs();
        this.cjw = (LinearLayout) findViewById(a.f.timepicker_root);
        this.cjt = (WheelView3d) findViewById(a.f.wheel_hour);
        this.cjt.setLineSpacingMultiplier(3.0f);
        this.cjt.setCenterTextSize(this.mTextSize);
        this.cjt.setOuterTextSize(this.cjg);
        this.cjt.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cjt.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cjt.setVisibleItem(7);
        this.cjt.setGravityOffset(this.cjf);
        this.cjt.setGravity(5);
        this.cjt.setDividerType(WheelView3d.DividerType.FILL);
        this.cjt.setDividerColor(0);
        this.cjt.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.cjs = BdTimePicker.this.cjx + i;
                BdTimePicker.this.ajP();
            }
        });
        this.cju = (WheelView3d) findViewById(a.f.wheel_minute);
        this.cju.setLineSpacingMultiplier(3.0f);
        this.cju.setCenterTextSize(this.mTextSize);
        this.cju.setOuterTextSize(this.cjg);
        this.cju.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cju.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cju.setGravityOffset(this.cjf);
        this.cju.setGravity(3);
        this.cju.setDividerType(WheelView3d.DividerType.FILL);
        this.cju.setDividerColor(0);
        this.cju.setVisibleItem(7);
        this.cju.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.SU = BdTimePicker.this.cjz + i;
            }
        });
        ajK();
    }

    private void qs() {
        this.cjB = new Paint();
        this.cjB.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cjB.setAntiAlias(true);
        this.cjB.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.cjt.getCenterContentOffset() * 2.0f), this.cjB);
    }

    private void ajK() {
        Calendar calendar = Calendar.getInstance();
        this.cjs = calendar.get(11);
        this.SU = calendar.get(12);
        ajL();
    }

    public void ajL() {
        ajQ();
        ajP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajP() {
        this.cjz = 0;
        this.cjA = 59;
        if (this.ciU != null && this.cjs == this.cjx) {
            this.cjz = this.ciU.getMinutes();
        }
        if (this.ciV != null && this.cjs == this.cjy) {
            this.cjA = this.ciV.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.cjA - this.cjz) + 1);
        for (int i = this.cjz; i <= this.cjA; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cju.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cjz, this.cjA));
        a(this.cju, this.cjz, this.cjA);
        setMinute(this.SU);
    }

    private void ajQ() {
        this.cjx = 0;
        this.cjy = 23;
        if (this.ciU != null) {
            this.cjx = this.ciU.getHours();
        }
        if (this.ciV != null) {
            this.cjy = this.ciV.getHours();
        }
        ArrayList arrayList = new ArrayList((this.cjy - this.cjx) + 1);
        for (int i = this.cjx; i <= this.cjy; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cjt.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cjx, this.cjy));
        a(this.cjt, this.cjx, this.cjy);
        setHour(this.cjs);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.ciU = date;
    }

    public void setmEndDate(Date date) {
        this.ciV = date;
    }

    public void setDisabled(boolean z) {
        this.cje = z;
        this.cjt.setIsOptions(z);
        this.cju.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cjv = aVar;
    }

    public void setHour(int i) {
        if (i < this.cjx) {
            i = this.cjx;
        } else if (i > this.cjy) {
            i = this.cjy;
        }
        this.cjs = i;
        this.cjt.setCurrentItem(i - this.cjx);
    }

    public int getHour() {
        return this.cjs;
    }

    public void setMinute(int i) {
        if (i < this.cjz) {
            i = this.cjz;
        } else if (i > this.cjA) {
            i = this.cjA;
        }
        this.SU = i;
        this.cju.setCurrentItem(i - this.cjz);
    }

    public int getMinute() {
        return this.SU;
    }

    public void setScrollCycle(boolean z) {
        this.cju.setCyclic(z);
        this.cjt.setCyclic(z);
    }
}
