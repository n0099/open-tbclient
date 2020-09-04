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
    private boolean cKB;
    private int cKC;
    private int cKD;
    private int cKP;
    private WheelView3d cKQ;
    private WheelView3d cKR;
    private a cKS;
    private LinearLayout cKT;
    private int cKU;
    private int cKV;
    private int cKW;
    private int cKX;
    private Paint cKY;
    private Date cKr;
    private Date cKs;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.cKP = 0;
        this.Ui = 0;
        this.cKC = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKP = 0;
        this.Ui = 0;
        this.cKC = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKP = 0;
        this.Ui = 0;
        this.cKC = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.cKC = ah.dip2px(context, this.cKC);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.cKD = ah.dip2px(context, 14.0f);
        sr();
        this.cKT = (LinearLayout) findViewById(a.f.timepicker_root);
        this.cKQ = (WheelView3d) findViewById(a.f.wheel_hour);
        this.cKQ.setLineSpacingMultiplier(3.0f);
        this.cKQ.setCenterTextSize(this.mTextSize);
        this.cKQ.setOuterTextSize(this.cKD);
        this.cKQ.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKQ.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKQ.setVisibleItem(7);
        this.cKQ.setGravityOffset(this.cKC);
        this.cKQ.setGravity(5);
        this.cKQ.setDividerType(WheelView3d.DividerType.FILL);
        this.cKQ.setDividerColor(0);
        this.cKQ.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.cKP = BdTimePicker.this.cKU + i;
                BdTimePicker.this.ayw();
            }
        });
        this.cKR = (WheelView3d) findViewById(a.f.wheel_minute);
        this.cKR.setLineSpacingMultiplier(3.0f);
        this.cKR.setCenterTextSize(this.mTextSize);
        this.cKR.setOuterTextSize(this.cKD);
        this.cKR.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKR.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKR.setGravityOffset(this.cKC);
        this.cKR.setGravity(3);
        this.cKR.setDividerType(WheelView3d.DividerType.FILL);
        this.cKR.setDividerColor(0);
        this.cKR.setVisibleItem(7);
        this.cKR.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.Ui = BdTimePicker.this.cKW + i;
            }
        });
        ayr();
    }

    private void sr() {
        this.cKY = new Paint();
        this.cKY.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cKY.setAntiAlias(true);
        this.cKY.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.cKQ.getCenterContentOffset() * 2.0f), this.cKY);
    }

    private void ayr() {
        Calendar calendar = Calendar.getInstance();
        this.cKP = calendar.get(11);
        this.Ui = calendar.get(12);
        ays();
    }

    public void ays() {
        ayx();
        ayw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayw() {
        this.cKW = 0;
        this.cKX = 59;
        if (this.cKr != null && this.cKP == this.cKU) {
            this.cKW = this.cKr.getMinutes();
        }
        if (this.cKs != null && this.cKP == this.cKV) {
            this.cKX = this.cKs.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.cKX - this.cKW) + 1);
        for (int i = this.cKW; i <= this.cKX; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cKR.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKW, this.cKX));
        a(this.cKR, this.cKW, this.cKX);
        setMinute(this.Ui);
    }

    private void ayx() {
        this.cKU = 0;
        this.cKV = 23;
        if (this.cKr != null) {
            this.cKU = this.cKr.getHours();
        }
        if (this.cKs != null) {
            this.cKV = this.cKs.getHours();
        }
        ArrayList arrayList = new ArrayList((this.cKV - this.cKU) + 1);
        for (int i = this.cKU; i <= this.cKV; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cKQ.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKU, this.cKV));
        a(this.cKQ, this.cKU, this.cKV);
        setHour(this.cKP);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.cKr = date;
    }

    public void setmEndDate(Date date) {
        this.cKs = date;
    }

    public void setDisabled(boolean z) {
        this.cKB = z;
        this.cKQ.setIsOptions(z);
        this.cKR.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cKS = aVar;
    }

    public void setHour(int i) {
        if (i < this.cKU) {
            i = this.cKU;
        } else if (i > this.cKV) {
            i = this.cKV;
        }
        this.cKP = i;
        this.cKQ.setCurrentItem(i - this.cKU);
    }

    public int getHour() {
        return this.cKP;
    }

    public void setMinute(int i) {
        if (i < this.cKW) {
            i = this.cKW;
        } else if (i > this.cKX) {
            i = this.cKX;
        }
        this.Ui = i;
        this.cKR.setCurrentItem(i - this.cKW);
    }

    public int getMinute() {
        return this.Ui;
    }

    public void setScrollCycle(boolean z) {
        this.cKR.setCyclic(z);
        this.cKQ.setCyclic(z);
    }
}
