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
    private int UU;
    private boolean cYE;
    private int cYF;
    private int cYG;
    private int cYS;
    private WheelView3d cYT;
    private WheelView3d cYU;
    private a cYV;
    private LinearLayout cYW;
    private int cYX;
    private int cYY;
    private int cYZ;
    private Date cYu;
    private Date cYv;
    private int cZa;
    private Paint cZb;
    private int mTextSize;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.cYS = 0;
        this.UU = 0;
        this.cYF = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYS = 0;
        this.UU = 0;
        this.cYF = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cYS = 0;
        this.UU = 0;
        this.cYF = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.cYF = ah.dip2px(context, this.cYF);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.cYG = ah.dip2px(context, 14.0f);
        sw();
        this.cYW = (LinearLayout) findViewById(a.f.timepicker_root);
        this.cYT = (WheelView3d) findViewById(a.f.wheel_hour);
        this.cYT.setLineSpacingMultiplier(3.0f);
        this.cYT.setCenterTextSize(this.mTextSize);
        this.cYT.setOuterTextSize(this.cYG);
        this.cYT.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cYT.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cYT.setVisibleItem(7);
        this.cYT.setGravityOffset(this.cYF);
        this.cYT.setGravity(5);
        this.cYT.setDividerType(WheelView3d.DividerType.FILL);
        this.cYT.setDividerColor(0);
        this.cYT.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.cYS = BdTimePicker.this.cYX + i;
                BdTimePicker.this.aBO();
            }
        });
        this.cYU = (WheelView3d) findViewById(a.f.wheel_minute);
        this.cYU.setLineSpacingMultiplier(3.0f);
        this.cYU.setCenterTextSize(this.mTextSize);
        this.cYU.setOuterTextSize(this.cYG);
        this.cYU.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cYU.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cYU.setGravityOffset(this.cYF);
        this.cYU.setGravity(3);
        this.cYU.setDividerType(WheelView3d.DividerType.FILL);
        this.cYU.setDividerColor(0);
        this.cYU.setVisibleItem(7);
        this.cYU.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.UU = BdTimePicker.this.cYZ + i;
            }
        });
        aBJ();
    }

    private void sw() {
        this.cZb = new Paint();
        this.cZb.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cZb.setAntiAlias(true);
        this.cZb.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.cYT.getCenterContentOffset() * 2.0f), this.cZb);
    }

    private void aBJ() {
        Calendar calendar = Calendar.getInstance();
        this.cYS = calendar.get(11);
        this.UU = calendar.get(12);
        aBK();
    }

    public void aBK() {
        aBP();
        aBO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBO() {
        this.cYZ = 0;
        this.cZa = 59;
        if (this.cYu != null && this.cYS == this.cYX) {
            this.cYZ = this.cYu.getMinutes();
        }
        if (this.cYv != null && this.cYS == this.cYY) {
            this.cZa = this.cYv.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.cZa - this.cYZ) + 1);
        for (int i = this.cYZ; i <= this.cZa; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cYU.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cYZ, this.cZa));
        a(this.cYU, this.cYZ, this.cZa);
        setMinute(this.UU);
    }

    private void aBP() {
        this.cYX = 0;
        this.cYY = 23;
        if (this.cYu != null) {
            this.cYX = this.cYu.getHours();
        }
        if (this.cYv != null) {
            this.cYY = this.cYv.getHours();
        }
        ArrayList arrayList = new ArrayList((this.cYY - this.cYX) + 1);
        for (int i = this.cYX; i <= this.cYY; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.cYT.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cYX, this.cYY));
        a(this.cYT, this.cYX, this.cYY);
        setHour(this.cYS);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.cYu = date;
    }

    public void setmEndDate(Date date) {
        this.cYv = date;
    }

    public void setDisabled(boolean z) {
        this.cYE = z;
        this.cYT.setIsOptions(z);
        this.cYU.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cYV = aVar;
    }

    public void setHour(int i) {
        if (i < this.cYX) {
            i = this.cYX;
        } else if (i > this.cYY) {
            i = this.cYY;
        }
        this.cYS = i;
        this.cYT.setCurrentItem(i - this.cYX);
    }

    public int getHour() {
        return this.cYS;
    }

    public void setMinute(int i) {
        if (i < this.cYZ) {
            i = this.cYZ;
        } else if (i > this.cZa) {
            i = this.cZa;
        }
        this.UU = i;
        this.cYU.setCurrentItem(i - this.cYZ);
    }

    public int getMinute() {
        return this.UU;
    }

    public void setScrollCycle(boolean z) {
        this.cYU.setCyclic(z);
        this.cYT.setCyclic(z);
    }
}
