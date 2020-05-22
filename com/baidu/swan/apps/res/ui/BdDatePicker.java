package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes11.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int Te;
    private int Tf;
    private int Tg;
    private WheelView3d cuA;
    private WheelView3d cuB;
    private WheelView3d cuC;
    private a cuD;
    private Date cuE;
    private Date cuF;
    private int cuG;
    private int cuH;
    private int cuI;
    private int cuJ;
    private int cuK;
    private int cuL;
    private int cuM;
    private String cuN;
    private boolean cuO;
    private int cuP;
    private int cuQ;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.Te = FeatureCodes.SKY_SEG;
        this.Tf = 1;
        this.Tg = 1;
        this.cuG = FeatureCodes.SKY_SEG;
        this.cuH = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.cuI = 1;
        this.cuJ = 12;
        this.cuK = 31;
        this.cuL = 1;
        this.cuM = this.cuK;
        this.cuP = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Te = FeatureCodes.SKY_SEG;
        this.Tf = 1;
        this.Tg = 1;
        this.cuG = FeatureCodes.SKY_SEG;
        this.cuH = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.cuI = 1;
        this.cuJ = 12;
        this.cuK = 31;
        this.cuL = 1;
        this.cuM = this.cuK;
        this.cuP = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Te = FeatureCodes.SKY_SEG;
        this.Tf = 1;
        this.Tg = 1;
        this.cuG = FeatureCodes.SKY_SEG;
        this.cuH = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.cuI = 1;
        this.cuJ = 12;
        this.cuK = 31;
        this.cuL = 1;
        this.cuM = this.cuK;
        this.cuP = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.cuP = ag.B(this.cuP);
        this.mTextSize = ag.B(16.0f);
        this.cuQ = ag.B(14.0f);
        this.cuA = (WheelView3d) findViewById(a.f.wheel_year);
        this.cuA.setCenterTextSize(this.mTextSize);
        this.cuA.setOuterTextSize(this.cuQ);
        this.cuA.setLineSpacingMultiplier(3.0f);
        this.cuA.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cuA.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cuA.setDividerType(WheelView3d.DividerType.FILL);
        this.cuA.setVisibleItem(7);
        this.cuA.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Te = BdDatePicker.this.cuG + i;
                BdDatePicker.this.anA();
                BdDatePicker.this.anB();
            }
        });
        this.cuB = (WheelView3d) findViewById(a.f.wheel_month);
        this.cuB.setCenterTextSize(this.mTextSize);
        this.cuB.setOuterTextSize(this.cuQ);
        this.cuB.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cuB.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cuB.setLineSpacingMultiplier(3.0f);
        this.cuB.setDividerType(WheelView3d.DividerType.FILL);
        this.cuB.setVisibleItem(7);
        this.cuB.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Tf = BdDatePicker.this.cuI + i;
                BdDatePicker.this.anB();
            }
        });
        this.cuC = (WheelView3d) findViewById(a.f.wheel_day);
        this.cuC.setCenterTextSize(this.mTextSize);
        this.cuC.setOuterTextSize(this.cuQ);
        this.cuC.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cuC.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cuC.setLineSpacingMultiplier(3.0f);
        this.cuC.setDividerType(WheelView3d.DividerType.FILL);
        this.cuC.setVisibleItem(7);
        this.cuC.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Tg = BdDatePicker.this.cuL + i;
            }
        });
        anx();
    }

    private void anx() {
        Calendar calendar = Calendar.getInstance();
        this.Te = calendar.get(1);
        this.Tf = calendar.get(2) + 1;
        this.Tg = calendar.get(5);
        any();
    }

    public void any() {
        anz();
        anA();
        anB();
    }

    private void anz() {
        if (this.Te < this.cuG || this.Te > this.cuH) {
            this.Te = this.cuG;
        }
        this.cuA.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cuG, this.cuH));
        a(this.cuA, this.cuG, this.cuH);
    }

    public void anA() {
        this.cuI = 1;
        this.cuJ = 12;
        if (this.cuE != null && this.Te == this.cuG) {
            this.cuI = this.cuE.getMonth() + 1;
        }
        if (this.cuF != null && this.Te == this.cuH) {
            this.cuJ = this.cuF.getMonth() + 1;
        }
        this.cuB.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cuI, this.cuJ));
        a(this.cuB, this.cuI, this.cuJ);
        setMonth(this.Tf);
    }

    public void anB() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.Tf) >= 0) {
            this.cuK = 31;
        } else if (Arrays.binarySearch(iArr, this.Tf) >= 0) {
            this.cuK = 30;
        } else if ((this.Te % 4 == 0 && this.Te % 100 != 0) || this.Te % 400 == 0) {
            this.cuK = 29;
        } else {
            this.cuK = 28;
        }
        this.cuL = 1;
        this.cuM = this.cuK;
        if (this.cuE != null && this.Te == this.cuG && this.Tf == this.cuE.getMonth() + 1) {
            this.cuL = this.cuE.getDate();
        }
        if (this.cuF != null && this.Te == this.cuH && this.Tf == this.cuF.getMonth() + 1) {
            this.cuM = this.cuF.getDate();
        }
        this.cuC.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cuL, this.cuM));
        a(this.cuC, this.cuL, this.cuM);
        setDay(this.Tg);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cuD = aVar;
    }

    public void setYear(int i) {
        if (i < this.cuG) {
            i = this.cuG;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cuG + " and " + this.cuH).showToastBottom();
            }
        } else if (i > this.cuH) {
            i = this.cuH;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cuG + " and " + this.cuH).showToast();
            }
        }
        this.Te = i;
        this.cuA.setCurrentItem(this.Te - this.cuG);
    }

    public int getYear() {
        return this.Te;
    }

    public void setMonth(int i) {
        if (i < this.cuI) {
            i = this.cuI;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cuI + " and " + this.cuJ).showToastBottom();
            }
        } else if (i > this.cuJ) {
            i = this.cuJ;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cuI + " and " + this.cuJ).showToast();
            }
        }
        this.Tf = i;
        this.cuB.setCurrentItem(this.Tf - this.cuI);
    }

    public int getMonth() {
        return this.Tf;
    }

    public void setDay(int i) {
        if (i < this.cuL || i > this.cuM) {
            i = this.cuL;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cuL + " and " + this.cuM).showToast();
            }
        } else if (i > this.cuM) {
            i = this.cuM;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cuL + " and " + this.cuM).showToastBottom();
            }
        }
        this.Tg = i;
        this.cuC.setCurrentItem(this.Tg - this.cuL);
    }

    public int getDay() {
        return this.Tg;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.cuE = date;
            this.cuG = this.cuE.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cuG = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.cuF = date;
            this.cuH = this.cuF.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cuH = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.cuN = str;
        if (!TextUtils.isEmpty(str)) {
            char c = 65535;
            switch (str.hashCode()) {
                case 3704893:
                    if (str.equals("year")) {
                        c = 0;
                        break;
                    }
                    break;
                case 104080000:
                    if (str.equals("month")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.cuA.setGravity(17);
                    this.cuB.setVisibility(8);
                    this.cuC.setVisibility(8);
                    return;
                case 1:
                    this.cuA.setGravity(5);
                    this.cuA.setGravityOffset(this.cuP);
                    this.cuB.setGravity(3);
                    this.cuB.setGravityOffset(this.cuP);
                    this.cuB.setVisibility(0);
                    this.cuC.setVisibility(8);
                    return;
                default:
                    this.cuA.setGravity(5);
                    this.cuA.setGravityOffset(this.cuP);
                    this.cuC.setGravity(3);
                    this.cuC.setGravityOffset(this.cuP);
                    this.cuB.setVisibility(0);
                    this.cuC.setVisibility(0);
                    return;
            }
        }
    }

    public boolean nj(String str) {
        WheelView3d wheelView3d = null;
        char c = 65535;
        switch (str.hashCode()) {
            case 99228:
                if (str.equals("day")) {
                    c = 2;
                    break;
                }
                break;
            case 3704893:
                if (str.equals("year")) {
                    c = 0;
                    break;
                }
                break;
            case 104080000:
                if (str.equals("month")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                wheelView3d = this.cuA;
                break;
            case 1:
                wheelView3d = this.cuB;
                break;
            case 2:
                wheelView3d = this.cuC;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.cuO = z;
        this.cuA.setIsOptions(z);
        this.cuB.setIsOptions(z);
        this.cuC.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.cuB.setCyclic(z);
        this.cuA.setCyclic(z);
        this.cuC.setCyclic(z);
    }
}
