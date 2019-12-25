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
/* loaded from: classes9.dex */
public class BdTimePicker extends LinearLayout {
    private int bFF;
    private WheelView3d bFG;
    private WheelView3d bFH;
    private a bFI;
    private LinearLayout bFJ;
    private int bFK;
    private int bFL;
    private int bFM;
    private int bFN;
    private Paint bFO;
    private Date bFh;
    private Date bFi;
    private boolean bFr;
    private int bFs;
    private int bFt;
    private int mTextSize;
    private int zl;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.bFF = 0;
        this.zl = 0;
        this.bFs = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFF = 0;
        this.zl = 0;
        this.bFs = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bFF = 0;
        this.zl = 0;
        this.bFs = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.bFs = af.dip2px(context, this.bFs);
        this.mTextSize = af.dip2px(context, 16.0f);
        this.bFt = af.dip2px(context, 14.0f);
        lB();
        this.bFJ = (LinearLayout) findViewById(a.f.timepicker_root);
        this.bFG = (WheelView3d) findViewById(a.f.wheel_hour);
        this.bFG.setLineSpacingMultiplier(3.0f);
        this.bFG.setCenterTextSize(this.mTextSize);
        this.bFG.setOuterTextSize(this.bFt);
        this.bFG.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bFG.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bFG.setVisibleItem(7);
        this.bFG.setGravityOffset(this.bFs);
        this.bFG.setGravity(5);
        this.bFG.setDividerType(WheelView3d.DividerType.FILL);
        this.bFG.setDividerColor(0);
        this.bFG.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.bFF = BdTimePicker.this.bFK + i;
                BdTimePicker.this.YU();
            }
        });
        this.bFH = (WheelView3d) findViewById(a.f.wheel_minute);
        this.bFH.setLineSpacingMultiplier(3.0f);
        this.bFH.setCenterTextSize(this.mTextSize);
        this.bFH.setOuterTextSize(this.bFt);
        this.bFH.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bFH.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bFH.setGravityOffset(this.bFs);
        this.bFH.setGravity(3);
        this.bFH.setDividerType(WheelView3d.DividerType.FILL);
        this.bFH.setDividerColor(0);
        this.bFH.setVisibleItem(7);
        this.bFH.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.zl = BdTimePicker.this.bFM + i;
            }
        });
        YP();
    }

    private void lB() {
        this.bFO = new Paint();
        this.bFO.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bFO.setAntiAlias(true);
        this.bFO.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.bFG.getCenterContentOffset() * 2.0f), this.bFO);
    }

    private void YP() {
        Calendar calendar = Calendar.getInstance();
        this.bFF = calendar.get(11);
        this.zl = calendar.get(12);
        YQ();
    }

    public void YQ() {
        YV();
        YU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YU() {
        this.bFM = 0;
        this.bFN = 59;
        if (this.bFh != null && this.bFF == this.bFK) {
            this.bFM = this.bFh.getMinutes();
        }
        if (this.bFi != null && this.bFF == this.bFL) {
            this.bFN = this.bFi.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.bFN - this.bFM) + 1);
        for (int i = this.bFM; i <= this.bFN; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bFH.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bFM, this.bFN));
        a(this.bFH, this.bFM, this.bFN);
        setMinute(this.zl);
    }

    private void YV() {
        this.bFK = 0;
        this.bFL = 23;
        if (this.bFh != null) {
            this.bFK = this.bFh.getHours();
        }
        if (this.bFi != null) {
            this.bFL = this.bFi.getHours();
        }
        ArrayList arrayList = new ArrayList((this.bFL - this.bFK) + 1);
        for (int i = this.bFK; i <= this.bFL; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bFG.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bFK, this.bFL));
        a(this.bFG, this.bFK, this.bFL);
        setHour(this.bFF);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.bFh = date;
    }

    public void setmEndDate(Date date) {
        this.bFi = date;
    }

    public void setDisabled(boolean z) {
        this.bFr = z;
        this.bFG.setIsOptions(z);
        this.bFH.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bFI = aVar;
    }

    public void setHour(int i) {
        if (i < this.bFK) {
            i = this.bFK;
        } else if (i > this.bFL) {
            i = this.bFL;
        }
        this.bFF = i;
        this.bFG.setCurrentItem(i - this.bFK);
    }

    public int getHour() {
        return this.bFF;
    }

    public void setMinute(int i) {
        if (i < this.bFM) {
            i = this.bFM;
        } else if (i > this.bFN) {
            i = this.bFN;
        }
        this.zl = i;
        this.bFH.setCurrentItem(i - this.bFM);
    }

    public int getMinute() {
        return this.zl;
    }

    public void setScrollCycle(boolean z) {
        this.bFH.setCyclic(z);
        this.bFG.setCyclic(z);
    }
}
