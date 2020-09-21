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
/* loaded from: classes3.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int Uw;
    private int Ux;
    private int Uy;
    private String cMA;
    private boolean cMB;
    private int cMC;
    private int cMD;
    private WheelView3d cMn;
    private WheelView3d cMo;
    private WheelView3d cMp;
    private a cMq;
    private Date cMr;
    private Date cMs;
    private int cMt;
    private int cMu;
    private int cMv;
    private int cMw;
    private int cMx;
    private int cMy;
    private int cMz;
    private int mTextSize;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.Uw = FeatureCodes.SKY_SEG;
        this.Ux = 1;
        this.Uy = 1;
        this.cMt = FeatureCodes.SKY_SEG;
        this.cMu = 2100;
        this.cMv = 1;
        this.cMw = 12;
        this.cMx = 31;
        this.cMy = 1;
        this.cMz = this.cMx;
        this.cMC = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Uw = FeatureCodes.SKY_SEG;
        this.Ux = 1;
        this.Uy = 1;
        this.cMt = FeatureCodes.SKY_SEG;
        this.cMu = 2100;
        this.cMv = 1;
        this.cMw = 12;
        this.cMx = 31;
        this.cMy = 1;
        this.cMz = this.cMx;
        this.cMC = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Uw = FeatureCodes.SKY_SEG;
        this.Ux = 1;
        this.Uy = 1;
        this.cMt = FeatureCodes.SKY_SEG;
        this.cMu = 2100;
        this.cMv = 1;
        this.cMw = 12;
        this.cMx = 31;
        this.cMy = 1;
        this.cMz = this.cMx;
        this.cMC = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.cMC = ah.H(this.cMC);
        this.mTextSize = ah.H(16.0f);
        this.cMD = ah.H(14.0f);
        this.cMn = (WheelView3d) findViewById(a.f.wheel_year);
        this.cMn.setCenterTextSize(this.mTextSize);
        this.cMn.setOuterTextSize(this.cMD);
        this.cMn.setLineSpacingMultiplier(3.0f);
        this.cMn.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cMn.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cMn.setDividerType(WheelView3d.DividerType.FILL);
        this.cMn.setVisibleItem(7);
        this.cMn.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Uw = BdDatePicker.this.cMt + i;
                BdDatePicker.this.azd();
                BdDatePicker.this.aze();
            }
        });
        this.cMo = (WheelView3d) findViewById(a.f.wheel_month);
        this.cMo.setCenterTextSize(this.mTextSize);
        this.cMo.setOuterTextSize(this.cMD);
        this.cMo.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cMo.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cMo.setLineSpacingMultiplier(3.0f);
        this.cMo.setDividerType(WheelView3d.DividerType.FILL);
        this.cMo.setVisibleItem(7);
        this.cMo.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Ux = BdDatePicker.this.cMv + i;
                BdDatePicker.this.aze();
            }
        });
        this.cMp = (WheelView3d) findViewById(a.f.wheel_day);
        this.cMp.setCenterTextSize(this.mTextSize);
        this.cMp.setOuterTextSize(this.cMD);
        this.cMp.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cMp.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cMp.setLineSpacingMultiplier(3.0f);
        this.cMp.setDividerType(WheelView3d.DividerType.FILL);
        this.cMp.setVisibleItem(7);
        this.cMp.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Uy = BdDatePicker.this.cMy + i;
            }
        });
        aza();
    }

    private void aza() {
        Calendar calendar = Calendar.getInstance();
        this.Uw = calendar.get(1);
        this.Ux = calendar.get(2) + 1;
        this.Uy = calendar.get(5);
        azb();
    }

    public void azb() {
        azc();
        azd();
        aze();
    }

    private void azc() {
        if (this.Uw < this.cMt || this.Uw > this.cMu) {
            this.Uw = this.cMt;
        }
        this.cMn.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cMt, this.cMu));
        a(this.cMn, this.cMt, this.cMu);
    }

    public void azd() {
        this.cMv = 1;
        this.cMw = 12;
        if (this.cMr != null && this.Uw == this.cMt) {
            this.cMv = this.cMr.getMonth() + 1;
        }
        if (this.cMs != null && this.Uw == this.cMu) {
            this.cMw = this.cMs.getMonth() + 1;
        }
        this.cMo.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cMv, this.cMw));
        a(this.cMo, this.cMv, this.cMw);
        setMonth(this.Ux);
    }

    public void aze() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.Ux) >= 0) {
            this.cMx = 31;
        } else if (Arrays.binarySearch(iArr, this.Ux) >= 0) {
            this.cMx = 30;
        } else if ((this.Uw % 4 == 0 && this.Uw % 100 != 0) || this.Uw % 400 == 0) {
            this.cMx = 29;
        } else {
            this.cMx = 28;
        }
        this.cMy = 1;
        this.cMz = this.cMx;
        if (this.cMr != null && this.Uw == this.cMt && this.Ux == this.cMr.getMonth() + 1) {
            this.cMy = this.cMr.getDate();
        }
        if (this.cMs != null && this.Uw == this.cMu && this.Ux == this.cMs.getMonth() + 1) {
            this.cMz = this.cMs.getDate();
        }
        this.cMp.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cMy, this.cMz));
        a(this.cMp, this.cMy, this.cMz);
        setDay(this.Uy);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cMq = aVar;
    }

    public void setYear(int i) {
        if (i < this.cMt) {
            i = this.cMt;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cMt + " and " + this.cMu).showToastBottom();
            }
        } else if (i > this.cMu) {
            i = this.cMu;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cMt + " and " + this.cMu).showToast();
            }
        }
        this.Uw = i;
        this.cMn.setCurrentItem(this.Uw - this.cMt);
    }

    public int getYear() {
        return this.Uw;
    }

    public void setMonth(int i) {
        if (i < this.cMv) {
            i = this.cMv;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cMv + " and " + this.cMw).showToastBottom();
            }
        } else if (i > this.cMw) {
            i = this.cMw;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cMv + " and " + this.cMw).showToast();
            }
        }
        this.Ux = i;
        this.cMo.setCurrentItem(this.Ux - this.cMv);
    }

    public int getMonth() {
        return this.Ux;
    }

    public void setDay(int i) {
        if (i < this.cMy || i > this.cMz) {
            i = this.cMy;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cMy + " and " + this.cMz).showToast();
            }
        } else if (i > this.cMz) {
            i = this.cMz;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cMy + " and " + this.cMz).showToastBottom();
            }
        }
        this.Uy = i;
        this.cMp.setCurrentItem(this.Uy - this.cMy);
    }

    public int getDay() {
        return this.Uy;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.cMr = date;
            this.cMt = this.cMr.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cMt = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.cMs = date;
            this.cMu = this.cMs.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cMu = 2100;
    }

    public void setFields(String str) {
        this.cMA = str;
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
                    this.cMn.setGravity(17);
                    this.cMo.setVisibility(8);
                    this.cMp.setVisibility(8);
                    return;
                case 1:
                    this.cMn.setGravity(5);
                    this.cMn.setGravityOffset(this.cMC);
                    this.cMo.setGravity(3);
                    this.cMo.setGravityOffset(this.cMC);
                    this.cMo.setVisibility(0);
                    this.cMp.setVisibility(8);
                    return;
                default:
                    this.cMn.setGravity(5);
                    this.cMn.setGravityOffset(this.cMC);
                    this.cMp.setGravity(3);
                    this.cMp.setGravityOffset(this.cMC);
                    this.cMo.setVisibility(0);
                    this.cMp.setVisibility(0);
                    return;
            }
        }
    }

    public boolean qq(String str) {
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
                wheelView3d = this.cMn;
                break;
            case 1:
                wheelView3d = this.cMo;
                break;
            case 2:
                wheelView3d = this.cMp;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.cMB = z;
        this.cMn.setIsOptions(z);
        this.cMo.setIsOptions(z);
        this.cMp.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.cMo.setCyclic(z);
        this.cMn.setCyclic(z);
        this.cMp.setCyclic(z);
    }
}
