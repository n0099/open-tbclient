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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes7.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int TA;
    private int TB;
    private int TC;
    private WheelView3d cBV;
    private WheelView3d cBW;
    private WheelView3d cBX;
    private a cBY;
    private Date cBZ;
    private Date cCa;
    private int cCb;
    private int cCc;
    private int cCd;
    private int cCe;
    private int cCf;
    private int cCg;
    private int cCh;
    private String cCi;
    private boolean cCj;
    private int cCk;
    private int cCl;
    private int mTextSize;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.TA = FeatureCodes.SKY_SEG;
        this.TB = 1;
        this.TC = 1;
        this.cCb = FeatureCodes.SKY_SEG;
        this.cCc = 2100;
        this.cCd = 1;
        this.cCe = 12;
        this.cCf = 31;
        this.cCg = 1;
        this.cCh = this.cCf;
        this.cCk = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TA = FeatureCodes.SKY_SEG;
        this.TB = 1;
        this.TC = 1;
        this.cCb = FeatureCodes.SKY_SEG;
        this.cCc = 2100;
        this.cCd = 1;
        this.cCe = 12;
        this.cCf = 31;
        this.cCg = 1;
        this.cCh = this.cCf;
        this.cCk = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TA = FeatureCodes.SKY_SEG;
        this.TB = 1;
        this.TC = 1;
        this.cCb = FeatureCodes.SKY_SEG;
        this.cCc = 2100;
        this.cCd = 1;
        this.cCe = 12;
        this.cCf = 31;
        this.cCg = 1;
        this.cCh = this.cCf;
        this.cCk = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.cCk = ai.D(this.cCk);
        this.mTextSize = ai.D(16.0f);
        this.cCl = ai.D(14.0f);
        this.cBV = (WheelView3d) findViewById(a.f.wheel_year);
        this.cBV.setCenterTextSize(this.mTextSize);
        this.cBV.setOuterTextSize(this.cCl);
        this.cBV.setLineSpacingMultiplier(3.0f);
        this.cBV.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cBV.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cBV.setDividerType(WheelView3d.DividerType.FILL);
        this.cBV.setVisibleItem(7);
        this.cBV.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.TA = BdDatePicker.this.cCb + i;
                BdDatePicker.this.aqq();
                BdDatePicker.this.aqr();
            }
        });
        this.cBW = (WheelView3d) findViewById(a.f.wheel_month);
        this.cBW.setCenterTextSize(this.mTextSize);
        this.cBW.setOuterTextSize(this.cCl);
        this.cBW.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cBW.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cBW.setLineSpacingMultiplier(3.0f);
        this.cBW.setDividerType(WheelView3d.DividerType.FILL);
        this.cBW.setVisibleItem(7);
        this.cBW.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.TB = BdDatePicker.this.cCd + i;
                BdDatePicker.this.aqr();
            }
        });
        this.cBX = (WheelView3d) findViewById(a.f.wheel_day);
        this.cBX.setCenterTextSize(this.mTextSize);
        this.cBX.setOuterTextSize(this.cCl);
        this.cBX.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cBX.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cBX.setLineSpacingMultiplier(3.0f);
        this.cBX.setDividerType(WheelView3d.DividerType.FILL);
        this.cBX.setVisibleItem(7);
        this.cBX.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.TC = BdDatePicker.this.cCg + i;
            }
        });
        aqn();
    }

    private void aqn() {
        Calendar calendar = Calendar.getInstance();
        this.TA = calendar.get(1);
        this.TB = calendar.get(2) + 1;
        this.TC = calendar.get(5);
        aqo();
    }

    public void aqo() {
        aqp();
        aqq();
        aqr();
    }

    private void aqp() {
        if (this.TA < this.cCb || this.TA > this.cCc) {
            this.TA = this.cCb;
        }
        this.cBV.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cCb, this.cCc));
        a(this.cBV, this.cCb, this.cCc);
    }

    public void aqq() {
        this.cCd = 1;
        this.cCe = 12;
        if (this.cBZ != null && this.TA == this.cCb) {
            this.cCd = this.cBZ.getMonth() + 1;
        }
        if (this.cCa != null && this.TA == this.cCc) {
            this.cCe = this.cCa.getMonth() + 1;
        }
        this.cBW.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cCd, this.cCe));
        a(this.cBW, this.cCd, this.cCe);
        setMonth(this.TB);
    }

    public void aqr() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.TB) >= 0) {
            this.cCf = 31;
        } else if (Arrays.binarySearch(iArr, this.TB) >= 0) {
            this.cCf = 30;
        } else if ((this.TA % 4 == 0 && this.TA % 100 != 0) || this.TA % 400 == 0) {
            this.cCf = 29;
        } else {
            this.cCf = 28;
        }
        this.cCg = 1;
        this.cCh = this.cCf;
        if (this.cBZ != null && this.TA == this.cCb && this.TB == this.cBZ.getMonth() + 1) {
            this.cCg = this.cBZ.getDate();
        }
        if (this.cCa != null && this.TA == this.cCc && this.TB == this.cCa.getMonth() + 1) {
            this.cCh = this.cCa.getDate();
        }
        this.cBX.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cCg, this.cCh));
        a(this.cBX, this.cCg, this.cCh);
        setDay(this.TC);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cBY = aVar;
    }

    public void setYear(int i) {
        if (i < this.cCb) {
            i = this.cCb;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cCb + " and " + this.cCc).showToastBottom();
            }
        } else if (i > this.cCc) {
            i = this.cCc;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cCb + " and " + this.cCc).showToast();
            }
        }
        this.TA = i;
        this.cBV.setCurrentItem(this.TA - this.cCb);
    }

    public int getYear() {
        return this.TA;
    }

    public void setMonth(int i) {
        if (i < this.cCd) {
            i = this.cCd;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cCd + " and " + this.cCe).showToastBottom();
            }
        } else if (i > this.cCe) {
            i = this.cCe;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cCd + " and " + this.cCe).showToast();
            }
        }
        this.TB = i;
        this.cBW.setCurrentItem(this.TB - this.cCd);
    }

    public int getMonth() {
        return this.TB;
    }

    public void setDay(int i) {
        if (i < this.cCg || i > this.cCh) {
            i = this.cCg;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cCg + " and " + this.cCh).showToast();
            }
        } else if (i > this.cCh) {
            i = this.cCh;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cCg + " and " + this.cCh).showToastBottom();
            }
        }
        this.TC = i;
        this.cBX.setCurrentItem(this.TC - this.cCg);
    }

    public int getDay() {
        return this.TC;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.cBZ = date;
            this.cCb = this.cBZ.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cCb = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.cCa = date;
            this.cCc = this.cCa.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cCc = 2100;
    }

    public void setFields(String str) {
        this.cCi = str;
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
                    this.cBV.setGravity(17);
                    this.cBW.setVisibility(8);
                    this.cBX.setVisibility(8);
                    return;
                case 1:
                    this.cBV.setGravity(5);
                    this.cBV.setGravityOffset(this.cCk);
                    this.cBW.setGravity(3);
                    this.cBW.setGravityOffset(this.cCk);
                    this.cBW.setVisibility(0);
                    this.cBX.setVisibility(8);
                    return;
                default:
                    this.cBV.setGravity(5);
                    this.cBV.setGravityOffset(this.cCk);
                    this.cBX.setGravity(3);
                    this.cBX.setGravityOffset(this.cCk);
                    this.cBW.setVisibility(0);
                    this.cBX.setVisibility(0);
                    return;
            }
        }
    }

    public boolean nY(String str) {
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
                wheelView3d = this.cBV;
                break;
            case 1:
                wheelView3d = this.cBW;
                break;
            case 2:
                wheelView3d = this.cBX;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.cCj = z;
        this.cBV.setIsOptions(z);
        this.cBW.setIsOptions(z);
        this.cBX.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.cBW.setCyclic(z);
        this.cBV.setCyclic(z);
        this.cBX.setCyclic(z);
    }
}
