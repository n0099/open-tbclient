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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes11.dex */
public class BdTimePicker extends LinearLayout {
    private int TK;
    private int czA;
    private int czB;
    private int czN;
    private WheelView3d czO;
    private WheelView3d czP;
    private a czQ;
    private LinearLayout czR;
    private int czS;
    private int czT;
    private int czU;
    private int czV;
    private Paint czW;
    private Date czp;
    private Date czq;
    private boolean czz;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.czN = 0;
        this.TK = 0;
        this.czA = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czN = 0;
        this.TK = 0;
        this.czA = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czN = 0;
        this.TK = 0;
        this.czA = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.czA = ag.dip2px(context, this.czA);
        this.mTextSize = ag.dip2px(context, 16.0f);
        this.czB = ag.dip2px(context, 14.0f);
        qP();
        this.czR = (LinearLayout) findViewById(a.f.timepicker_root);
        this.czO = (WheelView3d) findViewById(a.f.wheel_hour);
        this.czO.setLineSpacingMultiplier(3.0f);
        this.czO.setCenterTextSize(this.mTextSize);
        this.czO.setOuterTextSize(this.czB);
        this.czO.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.czO.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.czO.setVisibleItem(7);
        this.czO.setGravityOffset(this.czA);
        this.czO.setGravity(5);
        this.czO.setDividerType(WheelView3d.DividerType.FILL);
        this.czO.setDividerColor(0);
        this.czO.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.czN = BdTimePicker.this.czS + i;
                BdTimePicker.this.aoI();
            }
        });
        this.czP = (WheelView3d) findViewById(a.f.wheel_minute);
        this.czP.setLineSpacingMultiplier(3.0f);
        this.czP.setCenterTextSize(this.mTextSize);
        this.czP.setOuterTextSize(this.czB);
        this.czP.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.czP.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.czP.setGravityOffset(this.czA);
        this.czP.setGravity(3);
        this.czP.setDividerType(WheelView3d.DividerType.FILL);
        this.czP.setDividerColor(0);
        this.czP.setVisibleItem(7);
        this.czP.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.TK = BdTimePicker.this.czU + i;
            }
        });
        aoD();
    }

    private void qP() {
        this.czW = new Paint();
        this.czW.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.czW.setAntiAlias(true);
        this.czW.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.czO.getCenterContentOffset() * 2.0f), this.czW);
    }

    private void aoD() {
        Calendar calendar = Calendar.getInstance();
        this.czN = calendar.get(11);
        this.TK = calendar.get(12);
        aoE();
    }

    public void aoE() {
        aoJ();
        aoI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoI() {
        this.czU = 0;
        this.czV = 59;
        if (this.czp != null && this.czN == this.czS) {
            this.czU = this.czp.getMinutes();
        }
        if (this.czq != null && this.czN == this.czT) {
            this.czV = this.czq.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.czV - this.czU) + 1);
        for (int i = this.czU; i <= this.czV; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.czP.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.czU, this.czV));
        a(this.czP, this.czU, this.czV);
        setMinute(this.TK);
    }

    private void aoJ() {
        this.czS = 0;
        this.czT = 23;
        if (this.czp != null) {
            this.czS = this.czp.getHours();
        }
        if (this.czq != null) {
            this.czT = this.czq.getHours();
        }
        ArrayList arrayList = new ArrayList((this.czT - this.czS) + 1);
        for (int i = this.czS; i <= this.czT; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.czO.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.czS, this.czT));
        a(this.czO, this.czS, this.czT);
        setHour(this.czN);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.czp = date;
    }

    public void setmEndDate(Date date) {
        this.czq = date;
    }

    public void setDisabled(boolean z) {
        this.czz = z;
        this.czO.setIsOptions(z);
        this.czP.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.czQ = aVar;
    }

    public void setHour(int i) {
        if (i < this.czS) {
            i = this.czS;
        } else if (i > this.czT) {
            i = this.czT;
        }
        this.czN = i;
        this.czO.setCurrentItem(i - this.czS);
    }

    public int getHour() {
        return this.czN;
    }

    public void setMinute(int i) {
        if (i < this.czU) {
            i = this.czU;
        } else if (i > this.czV) {
            i = this.czV;
        }
        this.TK = i;
        this.czP.setCurrentItem(i - this.czU);
    }

    public int getMinute() {
        return this.TK;
    }

    public void setScrollCycle(boolean z) {
        this.czP.setCyclic(z);
        this.czO.setCyclic(z);
    }
}
