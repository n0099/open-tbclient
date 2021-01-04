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
/* loaded from: classes9.dex */
public class BdTimePicker extends LinearLayout {
    private int VQ;
    private int dxH;
    private WheelView3d dxI;
    private WheelView3d dxJ;
    private a dxK;
    private LinearLayout dxL;
    private int dxM;
    private int dxN;
    private int dxO;
    private int dxP;
    private Paint dxQ;
    private Date dxi;
    private Date dxj;
    private boolean dxs;
    private int dxt;
    private int dxu;
    private int mTextSize;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.dxH = 0;
        this.VQ = 0;
        this.dxt = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxH = 0;
        this.VQ = 0;
        this.dxt = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxH = 0;
        this.VQ = 0;
        this.dxt = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.dxt = ah.dip2px(context, this.dxt);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.dxu = ah.dip2px(context, 14.0f);
        sa();
        this.dxL = (LinearLayout) findViewById(a.f.timepicker_root);
        this.dxI = (WheelView3d) findViewById(a.f.wheel_hour);
        this.dxI.setLineSpacingMultiplier(3.0f);
        this.dxI.setCenterTextSize(this.mTextSize);
        this.dxI.setOuterTextSize(this.dxu);
        this.dxI.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dxI.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dxI.setVisibleItem(7);
        this.dxI.setGravityOffset(this.dxt);
        this.dxI.setGravity(5);
        this.dxI.setDividerType(WheelView3d.DividerType.FILL);
        this.dxI.setDividerColor(0);
        this.dxI.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.dxH = BdTimePicker.this.dxM + i;
                BdTimePicker.this.aKe();
            }
        });
        this.dxJ = (WheelView3d) findViewById(a.f.wheel_minute);
        this.dxJ.setLineSpacingMultiplier(3.0f);
        this.dxJ.setCenterTextSize(this.mTextSize);
        this.dxJ.setOuterTextSize(this.dxu);
        this.dxJ.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dxJ.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dxJ.setGravityOffset(this.dxt);
        this.dxJ.setGravity(3);
        this.dxJ.setDividerType(WheelView3d.DividerType.FILL);
        this.dxJ.setDividerColor(0);
        this.dxJ.setVisibleItem(7);
        this.dxJ.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.VQ = BdTimePicker.this.dxO + i;
            }
        });
        aJY();
    }

    private void sa() {
        this.dxQ = new Paint();
        this.dxQ.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dxQ.setAntiAlias(true);
        this.dxQ.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.dxI.getCenterContentOffset() * 2.0f), this.dxQ);
    }

    private void aJY() {
        Calendar calendar = Calendar.getInstance();
        this.dxH = calendar.get(11);
        this.VQ = calendar.get(12);
        aJZ();
    }

    public void aJZ() {
        aKf();
        aKe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKe() {
        this.dxO = 0;
        this.dxP = 59;
        if (this.dxi != null && this.dxH == this.dxM) {
            this.dxO = this.dxi.getMinutes();
        }
        if (this.dxj != null && this.dxH == this.dxN) {
            this.dxP = this.dxj.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.dxP - this.dxO) + 1);
        for (int i = this.dxO; i <= this.dxP; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dxJ.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dxO, this.dxP));
        a(this.dxJ, this.dxO, this.dxP);
        setMinute(this.VQ);
    }

    private void aKf() {
        this.dxM = 0;
        this.dxN = 23;
        if (this.dxi != null) {
            this.dxM = this.dxi.getHours();
        }
        if (this.dxj != null) {
            this.dxN = this.dxj.getHours();
        }
        ArrayList arrayList = new ArrayList((this.dxN - this.dxM) + 1);
        for (int i = this.dxM; i <= this.dxN; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dxI.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dxM, this.dxN));
        a(this.dxI, this.dxM, this.dxN);
        setHour(this.dxH);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.dxi = date;
    }

    public void setmEndDate(Date date) {
        this.dxj = date;
    }

    public void setDisabled(boolean z) {
        this.dxs = z;
        this.dxI.setIsOptions(z);
        this.dxJ.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dxK = aVar;
    }

    public void setHour(int i) {
        if (i < this.dxM) {
            i = this.dxM;
        } else if (i > this.dxN) {
            i = this.dxN;
        }
        this.dxH = i;
        this.dxI.setCurrentItem(i - this.dxM);
    }

    public int getHour() {
        return this.dxH;
    }

    public void setMinute(int i) {
        if (i < this.dxO) {
            i = this.dxO;
        } else if (i > this.dxP) {
            i = this.dxP;
        }
        this.VQ = i;
        this.dxJ.setCurrentItem(i - this.dxO);
    }

    public int getMinute() {
        return this.VQ;
    }

    public void setScrollCycle(boolean z) {
        this.dxJ.setCyclic(z);
        this.dxI.setCyclic(z);
    }
}
