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
    private Date bJX;
    private Date bJY;
    private int bKA;
    private int bKB;
    private int bKC;
    private int bKD;
    private Paint bKE;
    private boolean bKh;
    private int bKi;
    private int bKj;
    private int bKv;
    private WheelView3d bKw;
    private WheelView3d bKx;
    private a bKy;
    private LinearLayout bKz;
    private int mTextSize;
    private int zH;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.bKv = 0;
        this.zH = 0;
        this.bKi = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKv = 0;
        this.zH = 0;
        this.bKi = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKv = 0;
        this.zH = 0;
        this.bKi = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.bKi = af.dip2px(context, this.bKi);
        this.mTextSize = af.dip2px(context, 16.0f);
        this.bKj = af.dip2px(context, 14.0f);
        lQ();
        this.bKz = (LinearLayout) findViewById(a.f.timepicker_root);
        this.bKw = (WheelView3d) findViewById(a.f.wheel_hour);
        this.bKw.setLineSpacingMultiplier(3.0f);
        this.bKw.setCenterTextSize(this.mTextSize);
        this.bKw.setOuterTextSize(this.bKj);
        this.bKw.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKw.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKw.setVisibleItem(7);
        this.bKw.setGravityOffset(this.bKi);
        this.bKw.setGravity(5);
        this.bKw.setDividerType(WheelView3d.DividerType.FILL);
        this.bKw.setDividerColor(0);
        this.bKw.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.bKv = BdTimePicker.this.bKA + i;
                BdTimePicker.this.abF();
            }
        });
        this.bKx = (WheelView3d) findViewById(a.f.wheel_minute);
        this.bKx.setLineSpacingMultiplier(3.0f);
        this.bKx.setCenterTextSize(this.mTextSize);
        this.bKx.setOuterTextSize(this.bKj);
        this.bKx.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKx.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKx.setGravityOffset(this.bKi);
        this.bKx.setGravity(3);
        this.bKx.setDividerType(WheelView3d.DividerType.FILL);
        this.bKx.setDividerColor(0);
        this.bKx.setVisibleItem(7);
        this.bKx.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.zH = BdTimePicker.this.bKC + i;
            }
        });
        abA();
    }

    private void lQ() {
        this.bKE = new Paint();
        this.bKE.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bKE.setAntiAlias(true);
        this.bKE.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.bKw.getCenterContentOffset() * 2.0f), this.bKE);
    }

    private void abA() {
        Calendar calendar = Calendar.getInstance();
        this.bKv = calendar.get(11);
        this.zH = calendar.get(12);
        abB();
    }

    public void abB() {
        abG();
        abF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abF() {
        this.bKC = 0;
        this.bKD = 59;
        if (this.bJX != null && this.bKv == this.bKA) {
            this.bKC = this.bJX.getMinutes();
        }
        if (this.bJY != null && this.bKv == this.bKB) {
            this.bKD = this.bJY.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.bKD - this.bKC) + 1);
        for (int i = this.bKC; i <= this.bKD; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bKx.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKC, this.bKD));
        a(this.bKx, this.bKC, this.bKD);
        setMinute(this.zH);
    }

    private void abG() {
        this.bKA = 0;
        this.bKB = 23;
        if (this.bJX != null) {
            this.bKA = this.bJX.getHours();
        }
        if (this.bJY != null) {
            this.bKB = this.bJY.getHours();
        }
        ArrayList arrayList = new ArrayList((this.bKB - this.bKA) + 1);
        for (int i = this.bKA; i <= this.bKB; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bKw.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKA, this.bKB));
        a(this.bKw, this.bKA, this.bKB);
        setHour(this.bKv);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.bJX = date;
    }

    public void setmEndDate(Date date) {
        this.bJY = date;
    }

    public void setDisabled(boolean z) {
        this.bKh = z;
        this.bKw.setIsOptions(z);
        this.bKx.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bKy = aVar;
    }

    public void setHour(int i) {
        if (i < this.bKA) {
            i = this.bKA;
        } else if (i > this.bKB) {
            i = this.bKB;
        }
        this.bKv = i;
        this.bKw.setCurrentItem(i - this.bKA);
    }

    public int getHour() {
        return this.bKv;
    }

    public void setMinute(int i) {
        if (i < this.bKC) {
            i = this.bKC;
        } else if (i > this.bKD) {
            i = this.bKD;
        }
        this.zH = i;
        this.bKx.setCurrentItem(i - this.bKC);
    }

    public int getMinute() {
        return this.zH;
    }

    public void setScrollCycle(boolean z) {
        this.bKx.setCyclic(z);
        this.bKw.setCyclic(z);
    }
}
