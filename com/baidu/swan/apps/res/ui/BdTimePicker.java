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
/* loaded from: classes10.dex */
public class BdTimePicker extends LinearLayout {
    private int UV;
    private Date dmQ;
    private Date dmR;
    private boolean dna;
    private int dnb;
    private int dnc;
    private int dno;
    private WheelView3d dnp;
    private WheelView3d dnq;
    private a dnr;
    private LinearLayout dnt;
    private int dnu;
    private int dnv;
    private int dnw;
    private int dnx;
    private Paint dny;
    private int mTextSize;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.dno = 0;
        this.UV = 0;
        this.dnb = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dno = 0;
        this.UV = 0;
        this.dnb = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dno = 0;
        this.UV = 0;
        this.dnb = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.dnb = ah.dip2px(context, this.dnb);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.dnc = ah.dip2px(context, 14.0f);
        sw();
        this.dnt = (LinearLayout) findViewById(a.f.timepicker_root);
        this.dnp = (WheelView3d) findViewById(a.f.wheel_hour);
        this.dnp.setLineSpacingMultiplier(3.0f);
        this.dnp.setCenterTextSize(this.mTextSize);
        this.dnp.setOuterTextSize(this.dnc);
        this.dnp.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dnp.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dnp.setVisibleItem(7);
        this.dnp.setGravityOffset(this.dnb);
        this.dnp.setGravity(5);
        this.dnp.setDividerType(WheelView3d.DividerType.FILL);
        this.dnp.setDividerColor(0);
        this.dnp.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.dno = BdTimePicker.this.dnu + i;
                BdTimePicker.this.aGi();
            }
        });
        this.dnq = (WheelView3d) findViewById(a.f.wheel_minute);
        this.dnq.setLineSpacingMultiplier(3.0f);
        this.dnq.setCenterTextSize(this.mTextSize);
        this.dnq.setOuterTextSize(this.dnc);
        this.dnq.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dnq.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dnq.setGravityOffset(this.dnb);
        this.dnq.setGravity(3);
        this.dnq.setDividerType(WheelView3d.DividerType.FILL);
        this.dnq.setDividerColor(0);
        this.dnq.setVisibleItem(7);
        this.dnq.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.UV = BdTimePicker.this.dnw + i;
            }
        });
        aGd();
    }

    private void sw() {
        this.dny = new Paint();
        this.dny.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dny.setAntiAlias(true);
        this.dny.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.dnp.getCenterContentOffset() * 2.0f), this.dny);
    }

    private void aGd() {
        Calendar calendar = Calendar.getInstance();
        this.dno = calendar.get(11);
        this.UV = calendar.get(12);
        aGe();
    }

    public void aGe() {
        aGj();
        aGi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGi() {
        this.dnw = 0;
        this.dnx = 59;
        if (this.dmQ != null && this.dno == this.dnu) {
            this.dnw = this.dmQ.getMinutes();
        }
        if (this.dmR != null && this.dno == this.dnv) {
            this.dnx = this.dmR.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.dnx - this.dnw) + 1);
        for (int i = this.dnw; i <= this.dnx; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dnq.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dnw, this.dnx));
        a(this.dnq, this.dnw, this.dnx);
        setMinute(this.UV);
    }

    private void aGj() {
        this.dnu = 0;
        this.dnv = 23;
        if (this.dmQ != null) {
            this.dnu = this.dmQ.getHours();
        }
        if (this.dmR != null) {
            this.dnv = this.dmR.getHours();
        }
        ArrayList arrayList = new ArrayList((this.dnv - this.dnu) + 1);
        for (int i = this.dnu; i <= this.dnv; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dnp.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dnu, this.dnv));
        a(this.dnp, this.dnu, this.dnv);
        setHour(this.dno);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.dmQ = date;
    }

    public void setmEndDate(Date date) {
        this.dmR = date;
    }

    public void setDisabled(boolean z) {
        this.dna = z;
        this.dnp.setIsOptions(z);
        this.dnq.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dnr = aVar;
    }

    public void setHour(int i) {
        if (i < this.dnu) {
            i = this.dnu;
        } else if (i > this.dnv) {
            i = this.dnv;
        }
        this.dno = i;
        this.dnp.setCurrentItem(i - this.dnu);
    }

    public int getHour() {
        return this.dno;
    }

    public void setMinute(int i) {
        if (i < this.dnw) {
            i = this.dnw;
        } else if (i > this.dnx) {
            i = this.dnx;
        }
        this.UV = i;
        this.dnq.setCurrentItem(i - this.dnw);
    }

    public int getMinute() {
        return this.UV;
    }

    public void setScrollCycle(boolean z) {
        this.dnq.setCyclic(z);
        this.dnp.setCyclic(z);
    }
}
