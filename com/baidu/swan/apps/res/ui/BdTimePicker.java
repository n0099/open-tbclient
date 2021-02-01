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
    private int VL;
    private Date duG;
    private Date duH;
    private boolean duQ;
    private int duR;
    private int duS;
    private int dvf;
    private WheelView3d dvg;
    private WheelView3d dvh;
    private a dvi;
    private LinearLayout dvj;
    private int dvk;
    private int dvl;
    private int dvm;
    private int dvn;
    private Paint dvo;
    private int mTextSize;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.dvf = 0;
        this.VL = 0;
        this.duR = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvf = 0;
        this.VL = 0;
        this.duR = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dvf = 0;
        this.VL = 0;
        this.duR = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.duR = ah.dip2px(context, this.duR);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.duS = ah.dip2px(context, 14.0f);
        rX();
        this.dvj = (LinearLayout) findViewById(a.f.timepicker_root);
        this.dvg = (WheelView3d) findViewById(a.f.wheel_hour);
        this.dvg.setLineSpacingMultiplier(3.0f);
        this.dvg.setCenterTextSize(this.mTextSize);
        this.dvg.setOuterTextSize(this.duS);
        this.dvg.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dvg.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dvg.setVisibleItem(7);
        this.dvg.setGravityOffset(this.duR);
        this.dvg.setGravity(5);
        this.dvg.setDividerType(WheelView3d.DividerType.FILL);
        this.dvg.setDividerColor(0);
        this.dvg.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.dvf = BdTimePicker.this.dvk + i;
                BdTimePicker.this.aGG();
            }
        });
        this.dvh = (WheelView3d) findViewById(a.f.wheel_minute);
        this.dvh.setLineSpacingMultiplier(3.0f);
        this.dvh.setCenterTextSize(this.mTextSize);
        this.dvh.setOuterTextSize(this.duS);
        this.dvh.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dvh.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dvh.setGravityOffset(this.duR);
        this.dvh.setGravity(3);
        this.dvh.setDividerType(WheelView3d.DividerType.FILL);
        this.dvh.setDividerColor(0);
        this.dvh.setVisibleItem(7);
        this.dvh.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.VL = BdTimePicker.this.dvm + i;
            }
        });
        aGA();
    }

    private void rX() {
        this.dvo = new Paint();
        this.dvo.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dvo.setAntiAlias(true);
        this.dvo.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.dvg.getCenterContentOffset() * 2.0f), this.dvo);
    }

    private void aGA() {
        Calendar calendar = Calendar.getInstance();
        this.dvf = calendar.get(11);
        this.VL = calendar.get(12);
        aGB();
    }

    public void aGB() {
        aGH();
        aGG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGG() {
        this.dvm = 0;
        this.dvn = 59;
        if (this.duG != null && this.dvf == this.dvk) {
            this.dvm = this.duG.getMinutes();
        }
        if (this.duH != null && this.dvf == this.dvl) {
            this.dvn = this.duH.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.dvn - this.dvm) + 1);
        for (int i = this.dvm; i <= this.dvn; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dvh.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dvm, this.dvn));
        a(this.dvh, this.dvm, this.dvn);
        setMinute(this.VL);
    }

    private void aGH() {
        this.dvk = 0;
        this.dvl = 23;
        if (this.duG != null) {
            this.dvk = this.duG.getHours();
        }
        if (this.duH != null) {
            this.dvl = this.duH.getHours();
        }
        ArrayList arrayList = new ArrayList((this.dvl - this.dvk) + 1);
        for (int i = this.dvk; i <= this.dvl; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dvg.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dvk, this.dvl));
        a(this.dvg, this.dvk, this.dvl);
        setHour(this.dvf);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.duG = date;
    }

    public void setmEndDate(Date date) {
        this.duH = date;
    }

    public void setDisabled(boolean z) {
        this.duQ = z;
        this.dvg.setIsOptions(z);
        this.dvh.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dvi = aVar;
    }

    public void setHour(int i) {
        if (i < this.dvk) {
            i = this.dvk;
        } else if (i > this.dvl) {
            i = this.dvl;
        }
        this.dvf = i;
        this.dvg.setCurrentItem(i - this.dvk);
    }

    public int getHour() {
        return this.dvf;
    }

    public void setMinute(int i) {
        if (i < this.dvm) {
            i = this.dvm;
        } else if (i > this.dvn) {
            i = this.dvn;
        }
        this.VL = i;
        this.dvh.setCurrentItem(i - this.dvm);
    }

    public int getMinute() {
        return this.VL;
    }

    public void setScrollCycle(boolean z) {
        this.dvh.setCyclic(z);
        this.dvg.setCyclic(z);
    }
}
