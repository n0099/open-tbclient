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
/* loaded from: classes25.dex */
public class BdTimePicker extends LinearLayout {
    private int VN;
    private int dsI;
    private WheelView3d dsJ;
    private WheelView3d dsK;
    private a dsL;
    private LinearLayout dsM;
    private int dsN;
    private int dsO;
    private int dsP;
    private int dsQ;
    private Paint dsR;
    private Date dsj;
    private Date dsk;
    private boolean dsu;
    private int dsv;
    private int dsw;
    private int mTextSize;

    /* loaded from: classes25.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.dsI = 0;
        this.VN = 0;
        this.dsv = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsI = 0;
        this.VN = 0;
        this.dsv = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dsI = 0;
        this.VN = 0;
        this.dsv = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.dsv = ah.dip2px(context, this.dsv);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.dsw = ah.dip2px(context, 14.0f);
        sz();
        this.dsM = (LinearLayout) findViewById(a.f.timepicker_root);
        this.dsJ = (WheelView3d) findViewById(a.f.wheel_hour);
        this.dsJ.setLineSpacingMultiplier(3.0f);
        this.dsJ.setCenterTextSize(this.mTextSize);
        this.dsJ.setOuterTextSize(this.dsw);
        this.dsJ.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dsJ.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dsJ.setVisibleItem(7);
        this.dsJ.setGravityOffset(this.dsv);
        this.dsJ.setGravity(5);
        this.dsJ.setDividerType(WheelView3d.DividerType.FILL);
        this.dsJ.setDividerColor(0);
        this.dsJ.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.dsI = BdTimePicker.this.dsN + i;
                BdTimePicker.this.aII();
            }
        });
        this.dsK = (WheelView3d) findViewById(a.f.wheel_minute);
        this.dsK.setLineSpacingMultiplier(3.0f);
        this.dsK.setCenterTextSize(this.mTextSize);
        this.dsK.setOuterTextSize(this.dsw);
        this.dsK.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dsK.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dsK.setGravityOffset(this.dsv);
        this.dsK.setGravity(3);
        this.dsK.setDividerType(WheelView3d.DividerType.FILL);
        this.dsK.setDividerColor(0);
        this.dsK.setVisibleItem(7);
        this.dsK.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.VN = BdTimePicker.this.dsP + i;
            }
        });
        aID();
    }

    private void sz() {
        this.dsR = new Paint();
        this.dsR.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dsR.setAntiAlias(true);
        this.dsR.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.dsJ.getCenterContentOffset() * 2.0f), this.dsR);
    }

    private void aID() {
        Calendar calendar = Calendar.getInstance();
        this.dsI = calendar.get(11);
        this.VN = calendar.get(12);
        aIE();
    }

    public void aIE() {
        aIJ();
        aII();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aII() {
        this.dsP = 0;
        this.dsQ = 59;
        if (this.dsj != null && this.dsI == this.dsN) {
            this.dsP = this.dsj.getMinutes();
        }
        if (this.dsk != null && this.dsI == this.dsO) {
            this.dsQ = this.dsk.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.dsQ - this.dsP) + 1);
        for (int i = this.dsP; i <= this.dsQ; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dsK.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dsP, this.dsQ));
        a(this.dsK, this.dsP, this.dsQ);
        setMinute(this.VN);
    }

    private void aIJ() {
        this.dsN = 0;
        this.dsO = 23;
        if (this.dsj != null) {
            this.dsN = this.dsj.getHours();
        }
        if (this.dsk != null) {
            this.dsO = this.dsk.getHours();
        }
        ArrayList arrayList = new ArrayList((this.dsO - this.dsN) + 1);
        for (int i = this.dsN; i <= this.dsO; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dsJ.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dsN, this.dsO));
        a(this.dsJ, this.dsN, this.dsO);
        setHour(this.dsI);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.dsj = date;
    }

    public void setmEndDate(Date date) {
        this.dsk = date;
    }

    public void setDisabled(boolean z) {
        this.dsu = z;
        this.dsJ.setIsOptions(z);
        this.dsK.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dsL = aVar;
    }

    public void setHour(int i) {
        if (i < this.dsN) {
            i = this.dsN;
        } else if (i > this.dsO) {
            i = this.dsO;
        }
        this.dsI = i;
        this.dsJ.setCurrentItem(i - this.dsN);
    }

    public int getHour() {
        return this.dsI;
    }

    public void setMinute(int i) {
        if (i < this.dsP) {
            i = this.dsP;
        } else if (i > this.dsQ) {
            i = this.dsQ;
        }
        this.VN = i;
        this.dsK.setCurrentItem(i - this.dsP);
    }

    public int getMinute() {
        return this.VN;
    }

    public void setScrollCycle(boolean z) {
        this.dsK.setCyclic(z);
        this.dsJ.setCyclic(z);
    }
}
