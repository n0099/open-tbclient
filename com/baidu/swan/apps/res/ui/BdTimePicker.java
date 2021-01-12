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
    private int VN;
    private boolean dsF;
    private int dsG;
    private int dsH;
    private int dsU;
    private WheelView3d dsV;
    private WheelView3d dsW;
    private a dsX;
    private LinearLayout dsY;
    private int dsZ;
    private Date dsv;
    private Date dsw;
    private int dta;
    private int dtb;
    private int dtc;
    private Paint dtd;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.dsU = 0;
        this.VN = 0;
        this.dsG = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsU = 0;
        this.VN = 0;
        this.dsG = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dsU = 0;
        this.VN = 0;
        this.dsG = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.dsG = ah.dip2px(context, this.dsG);
        this.mTextSize = ah.dip2px(context, 16.0f);
        this.dsH = ah.dip2px(context, 14.0f);
        sa();
        this.dsY = (LinearLayout) findViewById(a.f.timepicker_root);
        this.dsV = (WheelView3d) findViewById(a.f.wheel_hour);
        this.dsV.setLineSpacingMultiplier(3.0f);
        this.dsV.setCenterTextSize(this.mTextSize);
        this.dsV.setOuterTextSize(this.dsH);
        this.dsV.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dsV.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dsV.setVisibleItem(7);
        this.dsV.setGravityOffset(this.dsG);
        this.dsV.setGravity(5);
        this.dsV.setDividerType(WheelView3d.DividerType.FILL);
        this.dsV.setDividerColor(0);
        this.dsV.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.dsU = BdTimePicker.this.dsZ + i;
                BdTimePicker.this.aGl();
            }
        });
        this.dsW = (WheelView3d) findViewById(a.f.wheel_minute);
        this.dsW.setLineSpacingMultiplier(3.0f);
        this.dsW.setCenterTextSize(this.mTextSize);
        this.dsW.setOuterTextSize(this.dsH);
        this.dsW.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dsW.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dsW.setGravityOffset(this.dsG);
        this.dsW.setGravity(3);
        this.dsW.setDividerType(WheelView3d.DividerType.FILL);
        this.dsW.setDividerColor(0);
        this.dsW.setVisibleItem(7);
        this.dsW.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.VN = BdTimePicker.this.dtb + i;
            }
        });
        aGf();
    }

    private void sa() {
        this.dtd = new Paint();
        this.dtd.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dtd.setAntiAlias(true);
        this.dtd.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.dsV.getCenterContentOffset() * 2.0f), this.dtd);
    }

    private void aGf() {
        Calendar calendar = Calendar.getInstance();
        this.dsU = calendar.get(11);
        this.VN = calendar.get(12);
        aGg();
    }

    public void aGg() {
        aGm();
        aGl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGl() {
        this.dtb = 0;
        this.dtc = 59;
        if (this.dsv != null && this.dsU == this.dsZ) {
            this.dtb = this.dsv.getMinutes();
        }
        if (this.dsw != null && this.dsU == this.dta) {
            this.dtc = this.dsw.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.dtc - this.dtb) + 1);
        for (int i = this.dtb; i <= this.dtc; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dsW.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dtb, this.dtc));
        a(this.dsW, this.dtb, this.dtc);
        setMinute(this.VN);
    }

    private void aGm() {
        this.dsZ = 0;
        this.dta = 23;
        if (this.dsv != null) {
            this.dsZ = this.dsv.getHours();
        }
        if (this.dsw != null) {
            this.dta = this.dsw.getHours();
        }
        ArrayList arrayList = new ArrayList((this.dta - this.dsZ) + 1);
        for (int i = this.dsZ; i <= this.dta; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.dsV.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dsZ, this.dta));
        a(this.dsV, this.dsZ, this.dta);
        setHour(this.dsU);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.dsv = date;
    }

    public void setmEndDate(Date date) {
        this.dsw = date;
    }

    public void setDisabled(boolean z) {
        this.dsF = z;
        this.dsV.setIsOptions(z);
        this.dsW.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dsX = aVar;
    }

    public void setHour(int i) {
        if (i < this.dsZ) {
            i = this.dsZ;
        } else if (i > this.dta) {
            i = this.dta;
        }
        this.dsU = i;
        this.dsV.setCurrentItem(i - this.dsZ);
    }

    public int getHour() {
        return this.dsU;
    }

    public void setMinute(int i) {
        if (i < this.dtb) {
            i = this.dtb;
        } else if (i > this.dtc) {
            i = this.dtc;
        }
        this.VN = i;
        this.dsW.setCurrentItem(i - this.dtb);
    }

    public int getMinute() {
        return this.VN;
    }

    public void setScrollCycle(boolean z) {
        this.dsW.setCyclic(z);
        this.dsV.setCyclic(z);
    }
}
