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
    private Date dgV;
    private Date dgW;
    private int dhA;
    private int dhB;
    private Paint dhC;
    private boolean dhf;
    private int dhg;
    private int dhh;
    private int dht;
    private WheelView3d dhu;
    private WheelView3d dhv;
    private a dhw;
    private LinearLayout dhx;
    private int dhy;
    private int dhz;
    private int mTextSize;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.dht = 0;
        this.UV = 0;
        this.dhg = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dht = 0;
        this.UV = 0;
        this.dhg = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dht = 0;
        this.UV = 0;
        this.dhg = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.dhg = ah.dip2px(context, this.dhg);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.dhh = ah.dip2px(context, 14.0f);
        sw();
        this.dhx = (LinearLayout) findViewById(a.f.timepicker_root);
        this.dhu = (WheelView3d) findViewById(a.f.wheel_hour);
        this.dhu.setLineSpacingMultiplier(3.0f);
        this.dhu.setCenterTextSize(this.mTextSize);
        this.dhu.setOuterTextSize(this.dhh);
        this.dhu.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dhu.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dhu.setVisibleItem(7);
        this.dhu.setGravityOffset(this.dhg);
        this.dhu.setGravity(5);
        this.dhu.setDividerType(WheelView3d.DividerType.FILL);
        this.dhu.setDividerColor(0);
        this.dhu.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.dht = BdTimePicker.this.dhy + i;
                BdTimePicker.this.aDI();
            }
        });
        this.dhv = (WheelView3d) findViewById(a.f.wheel_minute);
        this.dhv.setLineSpacingMultiplier(3.0f);
        this.dhv.setCenterTextSize(this.mTextSize);
        this.dhv.setOuterTextSize(this.dhh);
        this.dhv.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dhv.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dhv.setGravityOffset(this.dhg);
        this.dhv.setGravity(3);
        this.dhv.setDividerType(WheelView3d.DividerType.FILL);
        this.dhv.setDividerColor(0);
        this.dhv.setVisibleItem(7);
        this.dhv.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.UV = BdTimePicker.this.dhA + i;
            }
        });
        aDD();
    }

    private void sw() {
        this.dhC = new Paint();
        this.dhC.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dhC.setAntiAlias(true);
        this.dhC.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.dhu.getCenterContentOffset() * 2.0f), this.dhC);
    }

    private void aDD() {
        Calendar calendar = Calendar.getInstance();
        this.dht = calendar.get(11);
        this.UV = calendar.get(12);
        aDE();
    }

    public void aDE() {
        aDJ();
        aDI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDI() {
        this.dhA = 0;
        this.dhB = 59;
        if (this.dgV != null && this.dht == this.dhy) {
            this.dhA = this.dgV.getMinutes();
        }
        if (this.dgW != null && this.dht == this.dhz) {
            this.dhB = this.dgW.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.dhB - this.dhA) + 1);
        for (int i = this.dhA; i <= this.dhB; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dhv.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dhA, this.dhB));
        a(this.dhv, this.dhA, this.dhB);
        setMinute(this.UV);
    }

    private void aDJ() {
        this.dhy = 0;
        this.dhz = 23;
        if (this.dgV != null) {
            this.dhy = this.dgV.getHours();
        }
        if (this.dgW != null) {
            this.dhz = this.dgW.getHours();
        }
        ArrayList arrayList = new ArrayList((this.dhz - this.dhy) + 1);
        for (int i = this.dhy; i <= this.dhz; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dhu.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dhy, this.dhz));
        a(this.dhu, this.dhy, this.dhz);
        setHour(this.dht);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.dgV = date;
    }

    public void setmEndDate(Date date) {
        this.dgW = date;
    }

    public void setDisabled(boolean z) {
        this.dhf = z;
        this.dhu.setIsOptions(z);
        this.dhv.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dhw = aVar;
    }

    public void setHour(int i) {
        if (i < this.dhy) {
            i = this.dhy;
        } else if (i > this.dhz) {
            i = this.dhz;
        }
        this.dht = i;
        this.dhu.setCurrentItem(i - this.dhy);
    }

    public int getHour() {
        return this.dht;
    }

    public void setMinute(int i) {
        if (i < this.dhA) {
            i = this.dhA;
        } else if (i > this.dhB) {
            i = this.dhB;
        }
        this.UV = i;
        this.dhv.setCurrentItem(i - this.dhA);
    }

    public int getMinute() {
        return this.UV;
    }

    public void setScrollCycle(boolean z) {
        this.dhv.setCyclic(z);
        this.dhu.setCyclic(z);
    }
}
