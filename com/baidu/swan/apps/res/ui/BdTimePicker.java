package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes8.dex */
public class BdTimePicker extends LinearLayout {
    private int Xh;
    private int dwG;
    private WheelView3d dwH;
    private WheelView3d dwI;
    private a dwJ;
    private LinearLayout dwK;
    private int dwL;
    private int dwM;
    private int dwN;
    private int dwO;
    private Paint dwP;
    private Date dwh;
    private Date dwi;
    private boolean dwr;
    private int dws;
    private int dwt;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.dwG = 0;
        this.Xh = 0;
        this.dws = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwG = 0;
        this.Xh = 0;
        this.dws = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dwG = 0;
        this.Xh = 0;
        this.dws = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.dws = ah.dip2px(context, this.dws);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.dwt = ah.dip2px(context, 14.0f);
        rX();
        this.dwK = (LinearLayout) findViewById(a.f.timepicker_root);
        this.dwH = (WheelView3d) findViewById(a.f.wheel_hour);
        this.dwH.setLineSpacingMultiplier(3.0f);
        this.dwH.setCenterTextSize(this.mTextSize);
        this.dwH.setOuterTextSize(this.dwt);
        this.dwH.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dwH.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dwH.setVisibleItem(7);
        this.dwH.setGravityOffset(this.dws);
        this.dwH.setGravity(5);
        this.dwH.setDividerType(WheelView3d.DividerType.FILL);
        this.dwH.setDividerColor(0);
        this.dwH.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.dwG = BdTimePicker.this.dwL + i;
                BdTimePicker.this.aGJ();
            }
        });
        this.dwI = (WheelView3d) findViewById(a.f.wheel_minute);
        this.dwI.setLineSpacingMultiplier(3.0f);
        this.dwI.setCenterTextSize(this.mTextSize);
        this.dwI.setOuterTextSize(this.dwt);
        this.dwI.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dwI.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dwI.setGravityOffset(this.dws);
        this.dwI.setGravity(3);
        this.dwI.setDividerType(WheelView3d.DividerType.FILL);
        this.dwI.setDividerColor(0);
        this.dwI.setVisibleItem(7);
        this.dwI.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.Xh = BdTimePicker.this.dwN + i;
            }
        });
        aGD();
    }

    private void rX() {
        this.dwP = new Paint();
        this.dwP.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dwP.setAntiAlias(true);
        this.dwP.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.dwH.getCenterContentOffset() * 2.0f), this.dwP);
    }

    private void aGD() {
        Calendar calendar = Calendar.getInstance();
        this.dwG = calendar.get(11);
        this.Xh = calendar.get(12);
        aGE();
    }

    public void aGE() {
        aGK();
        aGJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGJ() {
        this.dwN = 0;
        this.dwO = 59;
        if (this.dwh != null && this.dwG == this.dwL) {
            this.dwN = this.dwh.getMinutes();
        }
        if (this.dwi != null && this.dwG == this.dwM) {
            this.dwO = this.dwi.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.dwO - this.dwN) + 1);
        for (int i = this.dwN; i <= this.dwO; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dwI.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dwN, this.dwO));
        a(this.dwI, this.dwN, this.dwO);
        setMinute(this.Xh);
    }

    private void aGK() {
        this.dwL = 0;
        this.dwM = 23;
        if (this.dwh != null) {
            this.dwL = this.dwh.getHours();
        }
        if (this.dwi != null) {
            this.dwM = this.dwi.getHours();
        }
        ArrayList arrayList = new ArrayList((this.dwM - this.dwL) + 1);
        for (int i = this.dwL; i <= this.dwM; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dwH.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dwL, this.dwM));
        a(this.dwH, this.dwL, this.dwM);
        setHour(this.dwG);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.dwh = date;
    }

    public void setmEndDate(Date date) {
        this.dwi = date;
    }

    public void setDisabled(boolean z) {
        this.dwr = z;
        this.dwH.setIsOptions(z);
        this.dwI.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dwJ = aVar;
    }

    public void setHour(int i) {
        if (i < this.dwL) {
            i = this.dwL;
        } else if (i > this.dwM) {
            i = this.dwM;
        }
        this.dwG = i;
        this.dwH.setCurrentItem(i - this.dwL);
    }

    public int getHour() {
        return this.dwG;
    }

    public void setMinute(int i) {
        if (i < this.dwN) {
            i = this.dwN;
        } else if (i > this.dwO) {
            i = this.dwO;
        }
        this.Xh = i;
        this.dwI.setCurrentItem(i - this.dwN);
    }

    public int getMinute() {
        return this.Xh;
    }

    public void setScrollCycle(boolean z) {
        this.dwI.setCyclic(z);
        this.dwH.setCyclic(z);
    }
}
