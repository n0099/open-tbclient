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
    private int Ti;
    private Date cuE;
    private Date cuF;
    private boolean cuO;
    private int cuP;
    private int cuQ;
    private int cvc;
    private WheelView3d cvd;
    private WheelView3d cve;
    private a cvf;
    private LinearLayout cvg;
    private int cvh;
    private int cvi;
    private int cvj;
    private int cvk;
    private Paint cvl;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.cvc = 0;
        this.Ti = 0;
        this.cuP = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvc = 0;
        this.Ti = 0;
        this.cuP = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvc = 0;
        this.Ti = 0;
        this.cuP = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.cuP = ag.dip2px(context, this.cuP);
        this.mTextSize = ag.dip2px(context, 16.0f);
        this.cuQ = ag.dip2px(context, 14.0f);
        qy();
        this.cvg = (LinearLayout) findViewById(a.f.timepicker_root);
        this.cvd = (WheelView3d) findViewById(a.f.wheel_hour);
        this.cvd.setLineSpacingMultiplier(3.0f);
        this.cvd.setCenterTextSize(this.mTextSize);
        this.cvd.setOuterTextSize(this.cuQ);
        this.cvd.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cvd.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cvd.setVisibleItem(7);
        this.cvd.setGravityOffset(this.cuP);
        this.cvd.setGravity(5);
        this.cvd.setDividerType(WheelView3d.DividerType.FILL);
        this.cvd.setDividerColor(0);
        this.cvd.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.cvc = BdTimePicker.this.cvh + i;
                BdTimePicker.this.anC();
            }
        });
        this.cve = (WheelView3d) findViewById(a.f.wheel_minute);
        this.cve.setLineSpacingMultiplier(3.0f);
        this.cve.setCenterTextSize(this.mTextSize);
        this.cve.setOuterTextSize(this.cuQ);
        this.cve.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cve.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cve.setGravityOffset(this.cuP);
        this.cve.setGravity(3);
        this.cve.setDividerType(WheelView3d.DividerType.FILL);
        this.cve.setDividerColor(0);
        this.cve.setVisibleItem(7);
        this.cve.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.Ti = BdTimePicker.this.cvj + i;
            }
        });
        anx();
    }

    private void qy() {
        this.cvl = new Paint();
        this.cvl.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cvl.setAntiAlias(true);
        this.cvl.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.cvd.getCenterContentOffset() * 2.0f), this.cvl);
    }

    private void anx() {
        Calendar calendar = Calendar.getInstance();
        this.cvc = calendar.get(11);
        this.Ti = calendar.get(12);
        any();
    }

    public void any() {
        anD();
        anC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anC() {
        this.cvj = 0;
        this.cvk = 59;
        if (this.cuE != null && this.cvc == this.cvh) {
            this.cvj = this.cuE.getMinutes();
        }
        if (this.cuF != null && this.cvc == this.cvi) {
            this.cvk = this.cuF.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.cvk - this.cvj) + 1);
        for (int i = this.cvj; i <= this.cvk; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cve.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cvj, this.cvk));
        a(this.cve, this.cvj, this.cvk);
        setMinute(this.Ti);
    }

    private void anD() {
        this.cvh = 0;
        this.cvi = 23;
        if (this.cuE != null) {
            this.cvh = this.cuE.getHours();
        }
        if (this.cuF != null) {
            this.cvi = this.cuF.getHours();
        }
        ArrayList arrayList = new ArrayList((this.cvi - this.cvh) + 1);
        for (int i = this.cvh; i <= this.cvi; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cvd.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cvh, this.cvi));
        a(this.cvd, this.cvh, this.cvi);
        setHour(this.cvc);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.cuE = date;
    }

    public void setmEndDate(Date date) {
        this.cuF = date;
    }

    public void setDisabled(boolean z) {
        this.cuO = z;
        this.cvd.setIsOptions(z);
        this.cve.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cvf = aVar;
    }

    public void setHour(int i) {
        if (i < this.cvh) {
            i = this.cvh;
        } else if (i > this.cvi) {
            i = this.cvi;
        }
        this.cvc = i;
        this.cvd.setCurrentItem(i - this.cvh);
    }

    public int getHour() {
        return this.cvc;
    }

    public void setMinute(int i) {
        if (i < this.cvj) {
            i = this.cvj;
        } else if (i > this.cvk) {
            i = this.cvk;
        }
        this.Ti = i;
        this.cve.setCurrentItem(i - this.cvj);
    }

    public int getMinute() {
        return this.Ti;
    }

    public void setScrollCycle(boolean z) {
        this.cve.setCyclic(z);
        this.cvd.setCyclic(z);
    }
}
