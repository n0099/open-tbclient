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
/* loaded from: classes11.dex */
public class BdTimePicker extends LinearLayout {
    private int bKI;
    private WheelView3d bKJ;
    private WheelView3d bKK;
    private a bKL;
    private LinearLayout bKM;
    private int bKN;
    private int bKO;
    private int bKP;
    private int bKQ;
    private Paint bKR;
    private Date bKk;
    private Date bKl;
    private boolean bKu;
    private int bKv;
    private int bKw;
    private int mTextSize;
    private int zH;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdTimePicker(Context context) {
        super(context);
        this.bKI = 0;
        this.zH = 0;
        this.bKv = 15;
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKI = 0;
        this.zH = 0;
        this.bKv = 15;
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKI = 0;
        this.zH = 0;
        this.bKv = 15;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.bKv = af.dip2px(context, this.bKv);
        this.mTextSize = af.dip2px(context, 16.0f);
        this.bKw = af.dip2px(context, 14.0f);
        lQ();
        this.bKM = (LinearLayout) findViewById(a.f.timepicker_root);
        this.bKJ = (WheelView3d) findViewById(a.f.wheel_hour);
        this.bKJ.setLineSpacingMultiplier(3.0f);
        this.bKJ.setCenterTextSize(this.mTextSize);
        this.bKJ.setOuterTextSize(this.bKw);
        this.bKJ.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKJ.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKJ.setVisibleItem(7);
        this.bKJ.setGravityOffset(this.bKv);
        this.bKJ.setGravity(5);
        this.bKJ.setDividerType(WheelView3d.DividerType.FILL);
        this.bKJ.setDividerColor(0);
        this.bKJ.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.bKI = BdTimePicker.this.bKN + i;
                BdTimePicker.this.abK();
            }
        });
        this.bKK = (WheelView3d) findViewById(a.f.wheel_minute);
        this.bKK.setLineSpacingMultiplier(3.0f);
        this.bKK.setCenterTextSize(this.mTextSize);
        this.bKK.setOuterTextSize(this.bKw);
        this.bKK.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKK.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKK.setGravityOffset(this.bKv);
        this.bKK.setGravity(3);
        this.bKK.setDividerType(WheelView3d.DividerType.FILL);
        this.bKK.setDividerColor(0);
        this.bKK.setVisibleItem(7);
        this.bKK.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdTimePicker.this.zH = BdTimePicker.this.bKP + i;
            }
        });
        abF();
    }

    private void lQ() {
        this.bKR = new Paint();
        this.bKR.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bKR.setAntiAlias(true);
        this.bKR.setTextSize(this.mTextSize);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.bKJ.getCenterContentOffset() * 2.0f), this.bKR);
    }

    private void abF() {
        Calendar calendar = Calendar.getInstance();
        this.bKI = calendar.get(11);
        this.zH = calendar.get(12);
        abG();
    }

    public void abG() {
        abL();
        abK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abK() {
        this.bKP = 0;
        this.bKQ = 59;
        if (this.bKk != null && this.bKI == this.bKN) {
            this.bKP = this.bKk.getMinutes();
        }
        if (this.bKl != null && this.bKI == this.bKO) {
            this.bKQ = this.bKl.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.bKQ - this.bKP) + 1);
        for (int i = this.bKP; i <= this.bKQ; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bKK.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKP, this.bKQ));
        a(this.bKK, this.bKP, this.bKQ);
        setMinute(this.zH);
    }

    private void abL() {
        this.bKN = 0;
        this.bKO = 23;
        if (this.bKk != null) {
            this.bKN = this.bKk.getHours();
        }
        if (this.bKl != null) {
            this.bKO = this.bKl.getHours();
        }
        ArrayList arrayList = new ArrayList((this.bKO - this.bKN) + 1);
        for (int i = this.bKN; i <= this.bKO; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        this.bKJ.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKN, this.bKO));
        a(this.bKJ, this.bKN, this.bKO);
        setHour(this.bKI);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setStartDate(Date date) {
        this.bKk = date;
    }

    public void setmEndDate(Date date) {
        this.bKl = date;
    }

    public void setDisabled(boolean z) {
        this.bKu = z;
        this.bKJ.setIsOptions(z);
        this.bKK.setIsOptions(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bKL = aVar;
    }

    public void setHour(int i) {
        if (i < this.bKN) {
            i = this.bKN;
        } else if (i > this.bKO) {
            i = this.bKO;
        }
        this.bKI = i;
        this.bKJ.setCurrentItem(i - this.bKN);
    }

    public int getHour() {
        return this.bKI;
    }

    public void setMinute(int i) {
        if (i < this.bKP) {
            i = this.bKP;
        } else if (i > this.bKQ) {
            i = this.bKQ;
        }
        this.zH = i;
        this.bKK.setCurrentItem(i - this.bKP);
    }

    public int getMinute() {
        return this.zH;
    }

    public void setScrollCycle(boolean z) {
        this.bKK.setCyclic(z);
        this.bKJ.setCyclic(z);
    }
}
