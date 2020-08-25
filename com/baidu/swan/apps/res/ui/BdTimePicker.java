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
/* loaded from: classes8.dex */
public class BdTimePicker extends LinearLayout {
    private int Ui;
    private int cKL;
    private WheelView3d cKM;
    private WheelView3d cKN;
    private a cKO;
    private LinearLayout cKP;
    private int cKQ;
    private int cKR;
    private int cKS;
    private int cKT;
    private Paint cKU;
    private Date cKn;
    private Date cKo;
    private boolean cKx;
    private int cKy;
    private int cKz;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.cKL = 0;
        this.Ui = 0;
        this.cKy = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKL = 0;
        this.Ui = 0;
        this.cKy = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKL = 0;
        this.Ui = 0;
        this.cKy = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.cKy = ah.dip2px(context, this.cKy);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.cKz = ah.dip2px(context, 14.0f);
        sr();
        this.cKP = (LinearLayout) findViewById(a.f.timepicker_root);
        this.cKM = (WheelView3d) findViewById(a.f.wheel_hour);
        this.cKM.setLineSpacingMultiplier(3.0f);
        this.cKM.setCenterTextSize(this.mTextSize);
        this.cKM.setOuterTextSize(this.cKz);
        this.cKM.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKM.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKM.setVisibleItem(7);
        this.cKM.setGravityOffset(this.cKy);
        this.cKM.setGravity(5);
        this.cKM.setDividerType(WheelView3d.DividerType.FILL);
        this.cKM.setDividerColor(0);
        this.cKM.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.cKL = BdTimePicker.this.cKQ + i;
                BdTimePicker.this.ayw();
            }
        });
        this.cKN = (WheelView3d) findViewById(a.f.wheel_minute);
        this.cKN.setLineSpacingMultiplier(3.0f);
        this.cKN.setCenterTextSize(this.mTextSize);
        this.cKN.setOuterTextSize(this.cKz);
        this.cKN.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKN.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKN.setGravityOffset(this.cKy);
        this.cKN.setGravity(3);
        this.cKN.setDividerType(WheelView3d.DividerType.FILL);
        this.cKN.setDividerColor(0);
        this.cKN.setVisibleItem(7);
        this.cKN.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.Ui = BdTimePicker.this.cKS + i;
            }
        });
        ayr();
    }

    private void sr() {
        this.cKU = new Paint();
        this.cKU.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cKU.setAntiAlias(true);
        this.cKU.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.cKM.getCenterContentOffset() * 2.0f), this.cKU);
    }

    private void ayr() {
        Calendar calendar = Calendar.getInstance();
        this.cKL = calendar.get(11);
        this.Ui = calendar.get(12);
        ays();
    }

    public void ays() {
        ayx();
        ayw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayw() {
        this.cKS = 0;
        this.cKT = 59;
        if (this.cKn != null && this.cKL == this.cKQ) {
            this.cKS = this.cKn.getMinutes();
        }
        if (this.cKo != null && this.cKL == this.cKR) {
            this.cKT = this.cKo.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.cKT - this.cKS) + 1);
        for (int i = this.cKS; i <= this.cKT; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cKN.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKS, this.cKT));
        a(this.cKN, this.cKS, this.cKT);
        setMinute(this.Ui);
    }

    private void ayx() {
        this.cKQ = 0;
        this.cKR = 23;
        if (this.cKn != null) {
            this.cKQ = this.cKn.getHours();
        }
        if (this.cKo != null) {
            this.cKR = this.cKo.getHours();
        }
        ArrayList arrayList = new ArrayList((this.cKR - this.cKQ) + 1);
        for (int i = this.cKQ; i <= this.cKR; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cKM.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKQ, this.cKR));
        a(this.cKM, this.cKQ, this.cKR);
        setHour(this.cKL);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.cKn = date;
    }

    public void setmEndDate(Date date) {
        this.cKo = date;
    }

    public void setDisabled(boolean z) {
        this.cKx = z;
        this.cKM.setIsOptions(z);
        this.cKN.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cKO = aVar;
    }

    public void setHour(int i) {
        if (i < this.cKQ) {
            i = this.cKQ;
        } else if (i > this.cKR) {
            i = this.cKR;
        }
        this.cKL = i;
        this.cKM.setCurrentItem(i - this.cKQ);
    }

    public int getHour() {
        return this.cKL;
    }

    public void setMinute(int i) {
        if (i < this.cKS) {
            i = this.cKS;
        } else if (i > this.cKT) {
            i = this.cKT;
        }
        this.Ui = i;
        this.cKN.setCurrentItem(i - this.cKS);
    }

    public int getMinute() {
        return this.Ui;
    }

    public void setScrollCycle(boolean z) {
        this.cKN.setCyclic(z);
        this.cKM.setCyclic(z);
    }
}
