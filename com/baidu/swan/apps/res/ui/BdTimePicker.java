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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes7.dex */
public class BdTimePicker extends LinearLayout {
    private int TF;
    private Date cBZ;
    private a cCA;
    private LinearLayout cCB;
    private int cCC;
    private int cCD;
    private int cCE;
    private int cCF;
    private Paint cCG;
    private Date cCa;
    private boolean cCj;
    private int cCk;
    private int cCl;
    private int cCx;
    private WheelView3d cCy;
    private WheelView3d cCz;
    private int mTextSize;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.cCx = 0;
        this.TF = 0;
        this.cCk = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cCx = 0;
        this.TF = 0;
        this.cCk = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cCx = 0;
        this.TF = 0;
        this.cCk = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.cCk = ai.dip2px(context, this.cCk);
        this.mTextSize = ai.dip2px(context, 16.0f);
        this.cCl = ai.dip2px(context, 14.0f);
        qS();
        this.cCB = (LinearLayout) findViewById(a.f.timepicker_root);
        this.cCy = (WheelView3d) findViewById(a.f.wheel_hour);
        this.cCy.setLineSpacingMultiplier(3.0f);
        this.cCy.setCenterTextSize(this.mTextSize);
        this.cCy.setOuterTextSize(this.cCl);
        this.cCy.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cCy.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cCy.setVisibleItem(7);
        this.cCy.setGravityOffset(this.cCk);
        this.cCy.setGravity(5);
        this.cCy.setDividerType(WheelView3d.DividerType.FILL);
        this.cCy.setDividerColor(0);
        this.cCy.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.cCx = BdTimePicker.this.cCC + i;
                BdTimePicker.this.aqs();
            }
        });
        this.cCz = (WheelView3d) findViewById(a.f.wheel_minute);
        this.cCz.setLineSpacingMultiplier(3.0f);
        this.cCz.setCenterTextSize(this.mTextSize);
        this.cCz.setOuterTextSize(this.cCl);
        this.cCz.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cCz.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cCz.setGravityOffset(this.cCk);
        this.cCz.setGravity(3);
        this.cCz.setDividerType(WheelView3d.DividerType.FILL);
        this.cCz.setDividerColor(0);
        this.cCz.setVisibleItem(7);
        this.cCz.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.TF = BdTimePicker.this.cCE + i;
            }
        });
        aqn();
    }

    private void qS() {
        this.cCG = new Paint();
        this.cCG.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cCG.setAntiAlias(true);
        this.cCG.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.cCy.getCenterContentOffset() * 2.0f), this.cCG);
    }

    private void aqn() {
        Calendar calendar = Calendar.getInstance();
        this.cCx = calendar.get(11);
        this.TF = calendar.get(12);
        aqo();
    }

    public void aqo() {
        aqt();
        aqs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqs() {
        this.cCE = 0;
        this.cCF = 59;
        if (this.cBZ != null && this.cCx == this.cCC) {
            this.cCE = this.cBZ.getMinutes();
        }
        if (this.cCa != null && this.cCx == this.cCD) {
            this.cCF = this.cCa.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.cCF - this.cCE) + 1);
        for (int i = this.cCE; i <= this.cCF; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cCz.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cCE, this.cCF));
        a(this.cCz, this.cCE, this.cCF);
        setMinute(this.TF);
    }

    private void aqt() {
        this.cCC = 0;
        this.cCD = 23;
        if (this.cBZ != null) {
            this.cCC = this.cBZ.getHours();
        }
        if (this.cCa != null) {
            this.cCD = this.cCa.getHours();
        }
        ArrayList arrayList = new ArrayList((this.cCD - this.cCC) + 1);
        for (int i = this.cCC; i <= this.cCD; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cCy.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cCC, this.cCD));
        a(this.cCy, this.cCC, this.cCD);
        setHour(this.cCx);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.cBZ = date;
    }

    public void setmEndDate(Date date) {
        this.cCa = date;
    }

    public void setDisabled(boolean z) {
        this.cCj = z;
        this.cCy.setIsOptions(z);
        this.cCz.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cCA = aVar;
    }

    public void setHour(int i) {
        if (i < this.cCC) {
            i = this.cCC;
        } else if (i > this.cCD) {
            i = this.cCD;
        }
        this.cCx = i;
        this.cCy.setCurrentItem(i - this.cCC);
    }

    public int getHour() {
        return this.cCx;
    }

    public void setMinute(int i) {
        if (i < this.cCE) {
            i = this.cCE;
        } else if (i > this.cCF) {
            i = this.cCF;
        }
        this.TF = i;
        this.cCz.setCurrentItem(i - this.cCE);
    }

    public int getMinute() {
        return this.TF;
    }

    public void setScrollCycle(boolean z) {
        this.cCz.setCyclic(z);
        this.cCy.setCyclic(z);
    }
}
