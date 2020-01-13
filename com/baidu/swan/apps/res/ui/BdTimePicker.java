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
/* loaded from: classes10.dex */
public class BdTimePicker extends LinearLayout {
    private Date bFS;
    private Date bFT;
    private boolean bGc;
    private int bGd;
    private int bGe;
    private int bGq;
    private WheelView3d bGr;
    private WheelView3d bGs;
    private a bGt;
    private LinearLayout bGu;
    private int bGv;
    private int bGw;
    private int bGx;
    private int bGy;
    private Paint bGz;
    private int mTextSize;
    private int zp;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.bGq = 0;
        this.zp = 0;
        this.bGd = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGq = 0;
        this.zp = 0;
        this.bGd = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGq = 0;
        this.zp = 0;
        this.bGd = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.bGd = af.dip2px(context, this.bGd);
        this.mTextSize = af.dip2px(context, 16.0f);
        this.bGe = af.dip2px(context, 14.0f);
        lB();
        this.bGu = (LinearLayout) findViewById(a.f.timepicker_root);
        this.bGr = (WheelView3d) findViewById(a.f.wheel_hour);
        this.bGr.setLineSpacingMultiplier(3.0f);
        this.bGr.setCenterTextSize(this.mTextSize);
        this.bGr.setOuterTextSize(this.bGe);
        this.bGr.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bGr.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bGr.setVisibleItem(7);
        this.bGr.setGravityOffset(this.bGd);
        this.bGr.setGravity(5);
        this.bGr.setDividerType(WheelView3d.DividerType.FILL);
        this.bGr.setDividerColor(0);
        this.bGr.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.bGq = BdTimePicker.this.bGv + i;
                BdTimePicker.this.Zr();
            }
        });
        this.bGs = (WheelView3d) findViewById(a.f.wheel_minute);
        this.bGs.setLineSpacingMultiplier(3.0f);
        this.bGs.setCenterTextSize(this.mTextSize);
        this.bGs.setOuterTextSize(this.bGe);
        this.bGs.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bGs.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bGs.setGravityOffset(this.bGd);
        this.bGs.setGravity(3);
        this.bGs.setDividerType(WheelView3d.DividerType.FILL);
        this.bGs.setDividerColor(0);
        this.bGs.setVisibleItem(7);
        this.bGs.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.zp = BdTimePicker.this.bGx + i;
            }
        });
        Zm();
    }

    private void lB() {
        this.bGz = new Paint();
        this.bGz.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bGz.setAntiAlias(true);
        this.bGz.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.bGr.getCenterContentOffset() * 2.0f), this.bGz);
    }

    private void Zm() {
        Calendar calendar = Calendar.getInstance();
        this.bGq = calendar.get(11);
        this.zp = calendar.get(12);
        Zn();
    }

    public void Zn() {
        Zs();
        Zr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zr() {
        this.bGx = 0;
        this.bGy = 59;
        if (this.bFS != null && this.bGq == this.bGv) {
            this.bGx = this.bFS.getMinutes();
        }
        if (this.bFT != null && this.bGq == this.bGw) {
            this.bGy = this.bFT.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.bGy - this.bGx) + 1);
        for (int i = this.bGx; i <= this.bGy; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bGs.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bGx, this.bGy));
        a(this.bGs, this.bGx, this.bGy);
        setMinute(this.zp);
    }

    private void Zs() {
        this.bGv = 0;
        this.bGw = 23;
        if (this.bFS != null) {
            this.bGv = this.bFS.getHours();
        }
        if (this.bFT != null) {
            this.bGw = this.bFT.getHours();
        }
        ArrayList arrayList = new ArrayList((this.bGw - this.bGv) + 1);
        for (int i = this.bGv; i <= this.bGw; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bGr.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bGv, this.bGw));
        a(this.bGr, this.bGv, this.bGw);
        setHour(this.bGq);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.bFS = date;
    }

    public void setmEndDate(Date date) {
        this.bFT = date;
    }

    public void setDisabled(boolean z) {
        this.bGc = z;
        this.bGr.setIsOptions(z);
        this.bGs.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bGt = aVar;
    }

    public void setHour(int i) {
        if (i < this.bGv) {
            i = this.bGv;
        } else if (i > this.bGw) {
            i = this.bGw;
        }
        this.bGq = i;
        this.bGr.setCurrentItem(i - this.bGv);
    }

    public int getHour() {
        return this.bGq;
    }

    public void setMinute(int i) {
        if (i < this.bGx) {
            i = this.bGx;
        } else if (i > this.bGy) {
            i = this.bGy;
        }
        this.zp = i;
        this.bGs.setCurrentItem(i - this.bGx);
    }

    public int getMinute() {
        return this.zp;
    }

    public void setScrollCycle(boolean z) {
        this.bGs.setCyclic(z);
        this.bGr.setCyclic(z);
    }
}
