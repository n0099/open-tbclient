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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes10.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int UQ;
    private int UR;
    private int US;
    private int cYA;
    private int cYB;
    private int cYC;
    private String cYD;
    private boolean cYE;
    private int cYF;
    private int cYG;
    private WheelView3d cYq;
    private WheelView3d cYr;
    private WheelView3d cYs;
    private a cYt;
    private Date cYu;
    private Date cYv;
    private int cYw;
    private int cYx;
    private int cYy;
    private int cYz;
    private int mTextSize;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.UQ = FeatureCodes.SKY_SEG;
        this.UR = 1;
        this.US = 1;
        this.cYw = FeatureCodes.SKY_SEG;
        this.cYx = 2100;
        this.cYy = 1;
        this.cYz = 12;
        this.cYA = 31;
        this.cYB = 1;
        this.cYC = this.cYA;
        this.cYF = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UQ = FeatureCodes.SKY_SEG;
        this.UR = 1;
        this.US = 1;
        this.cYw = FeatureCodes.SKY_SEG;
        this.cYx = 2100;
        this.cYy = 1;
        this.cYz = 12;
        this.cYA = 31;
        this.cYB = 1;
        this.cYC = this.cYA;
        this.cYF = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UQ = FeatureCodes.SKY_SEG;
        this.UR = 1;
        this.US = 1;
        this.cYw = FeatureCodes.SKY_SEG;
        this.cYx = 2100;
        this.cYy = 1;
        this.cYz = 12;
        this.cYA = 31;
        this.cYB = 1;
        this.cYC = this.cYA;
        this.cYF = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.cYF = ah.J(this.cYF);
        this.mTextSize = ah.J(16.0f);
        this.cYG = ah.J(14.0f);
        this.cYq = (WheelView3d) findViewById(a.f.wheel_year);
        this.cYq.setCenterTextSize(this.mTextSize);
        this.cYq.setOuterTextSize(this.cYG);
        this.cYq.setLineSpacingMultiplier(3.0f);
        this.cYq.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cYq.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cYq.setDividerType(WheelView3d.DividerType.FILL);
        this.cYq.setVisibleItem(7);
        this.cYq.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.UQ = BdDatePicker.this.cYw + i;
                BdDatePicker.this.aBM();
                BdDatePicker.this.aBN();
            }
        });
        this.cYr = (WheelView3d) findViewById(a.f.wheel_month);
        this.cYr.setCenterTextSize(this.mTextSize);
        this.cYr.setOuterTextSize(this.cYG);
        this.cYr.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cYr.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cYr.setLineSpacingMultiplier(3.0f);
        this.cYr.setDividerType(WheelView3d.DividerType.FILL);
        this.cYr.setVisibleItem(7);
        this.cYr.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.UR = BdDatePicker.this.cYy + i;
                BdDatePicker.this.aBN();
            }
        });
        this.cYs = (WheelView3d) findViewById(a.f.wheel_day);
        this.cYs.setCenterTextSize(this.mTextSize);
        this.cYs.setOuterTextSize(this.cYG);
        this.cYs.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cYs.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cYs.setLineSpacingMultiplier(3.0f);
        this.cYs.setDividerType(WheelView3d.DividerType.FILL);
        this.cYs.setVisibleItem(7);
        this.cYs.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.US = BdDatePicker.this.cYB + i;
            }
        });
        aBJ();
    }

    private void aBJ() {
        Calendar calendar = Calendar.getInstance();
        this.UQ = calendar.get(1);
        this.UR = calendar.get(2) + 1;
        this.US = calendar.get(5);
        aBK();
    }

    public void aBK() {
        aBL();
        aBM();
        aBN();
    }

    private void aBL() {
        if (this.UQ < this.cYw || this.UQ > this.cYx) {
            this.UQ = this.cYw;
        }
        this.cYq.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cYw, this.cYx));
        a(this.cYq, this.cYw, this.cYx);
    }

    public void aBM() {
        this.cYy = 1;
        this.cYz = 12;
        if (this.cYu != null && this.UQ == this.cYw) {
            this.cYy = this.cYu.getMonth() + 1;
        }
        if (this.cYv != null && this.UQ == this.cYx) {
            this.cYz = this.cYv.getMonth() + 1;
        }
        this.cYr.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cYy, this.cYz));
        a(this.cYr, this.cYy, this.cYz);
        setMonth(this.UR);
    }

    public void aBN() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.UR) >= 0) {
            this.cYA = 31;
        } else if (Arrays.binarySearch(iArr, this.UR) >= 0) {
            this.cYA = 30;
        } else if ((this.UQ % 4 == 0 && this.UQ % 100 != 0) || this.UQ % 400 == 0) {
            this.cYA = 29;
        } else {
            this.cYA = 28;
        }
        this.cYB = 1;
        this.cYC = this.cYA;
        if (this.cYu != null && this.UQ == this.cYw && this.UR == this.cYu.getMonth() + 1) {
            this.cYB = this.cYu.getDate();
        }
        if (this.cYv != null && this.UQ == this.cYx && this.UR == this.cYv.getMonth() + 1) {
            this.cYC = this.cYv.getDate();
        }
        this.cYs.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cYB, this.cYC));
        a(this.cYs, this.cYB, this.cYC);
        setDay(this.US);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cYt = aVar;
    }

    public void setYear(int i) {
        if (i < this.cYw) {
            i = this.cYw;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cYw + " and " + this.cYx).showToastBottom();
            }
        } else if (i > this.cYx) {
            i = this.cYx;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cYw + " and " + this.cYx).showToast();
            }
        }
        this.UQ = i;
        this.cYq.setCurrentItem(this.UQ - this.cYw);
    }

    public int getYear() {
        return this.UQ;
    }

    public void setMonth(int i) {
        if (i < this.cYy) {
            i = this.cYy;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cYy + " and " + this.cYz).showToastBottom();
            }
        } else if (i > this.cYz) {
            i = this.cYz;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cYy + " and " + this.cYz).showToast();
            }
        }
        this.UR = i;
        this.cYr.setCurrentItem(this.UR - this.cYy);
    }

    public int getMonth() {
        return this.UR;
    }

    public void setDay(int i) {
        if (i < this.cYB || i > this.cYC) {
            i = this.cYB;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cYB + " and " + this.cYC).showToast();
            }
        } else if (i > this.cYC) {
            i = this.cYC;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cYB + " and " + this.cYC).showToastBottom();
            }
        }
        this.US = i;
        this.cYs.setCurrentItem(this.US - this.cYB);
    }

    public int getDay() {
        return this.US;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.cYu = date;
            this.cYw = this.cYu.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cYw = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.cYv = date;
            this.cYx = this.cYv.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cYx = 2100;
    }

    public void setFields(String str) {
        this.cYD = str;
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
                    this.cYq.setGravity(17);
                    this.cYr.setVisibility(8);
                    this.cYs.setVisibility(8);
                    return;
                case 1:
                    this.cYq.setGravity(5);
                    this.cYq.setGravityOffset(this.cYF);
                    this.cYr.setGravity(3);
                    this.cYr.setGravityOffset(this.cYF);
                    this.cYr.setVisibility(0);
                    this.cYs.setVisibility(8);
                    return;
                default:
                    this.cYq.setGravity(5);
                    this.cYq.setGravityOffset(this.cYF);
                    this.cYs.setGravity(3);
                    this.cYs.setGravityOffset(this.cYF);
                    this.cYr.setVisibility(0);
                    this.cYs.setVisibility(0);
                    return;
            }
        }
    }

    public boolean rc(String str) {
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
                wheelView3d = this.cYq;
                break;
            case 1:
                wheelView3d = this.cYr;
                break;
            case 2:
                wheelView3d = this.cYs;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.cYE = z;
        this.cYq.setIsOptions(z);
        this.cYr.setIsOptions(z);
        this.cYs.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.cYr.setCyclic(z);
        this.cYq.setCyclic(z);
        this.cYs.setCyclic(z);
    }
}
