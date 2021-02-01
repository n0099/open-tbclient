package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes9.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int VH;
    private int VI;
    private int VJ;
    private WheelView3d duC;
    private WheelView3d duD;
    private WheelView3d duE;
    private a duF;
    private Date duG;
    private Date duH;
    private int duI;
    private int duJ;
    private int duK;
    private int duL;
    private int duM;
    private int duN;
    private int duO;
    private String duP;
    private boolean duQ;
    private int duR;
    private int duS;
    private int mTextSize;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.VH = FeatureCodes.SKY_SEG;
        this.VI = 1;
        this.VJ = 1;
        this.duI = FeatureCodes.SKY_SEG;
        this.duJ = 2100;
        this.duK = 1;
        this.duL = 12;
        this.duM = 31;
        this.duN = 1;
        this.duO = this.duM;
        this.duR = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VH = FeatureCodes.SKY_SEG;
        this.VI = 1;
        this.VJ = 1;
        this.duI = FeatureCodes.SKY_SEG;
        this.duJ = 2100;
        this.duK = 1;
        this.duL = 12;
        this.duM = 31;
        this.duN = 1;
        this.duO = this.duM;
        this.duR = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.VH = FeatureCodes.SKY_SEG;
        this.VI = 1;
        this.VJ = 1;
        this.duI = FeatureCodes.SKY_SEG;
        this.duJ = 2100;
        this.duK = 1;
        this.duL = 12;
        this.duM = 31;
        this.duN = 1;
        this.duO = this.duM;
        this.duR = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.duR = ah.P(this.duR);
        this.mTextSize = ah.P(16.0f);
        this.duS = ah.P(14.0f);
        this.duC = (WheelView3d) findViewById(a.f.wheel_year);
        this.duC.setCenterTextSize(this.mTextSize);
        this.duC.setOuterTextSize(this.duS);
        this.duC.setLineSpacingMultiplier(3.0f);
        this.duC.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.duC.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.duC.setDividerType(WheelView3d.DividerType.FILL);
        this.duC.setVisibleItem(7);
        this.duC.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VH = BdDatePicker.this.duI + i;
                BdDatePicker.this.aGD();
                BdDatePicker.this.aGE();
            }
        });
        this.duD = (WheelView3d) findViewById(a.f.wheel_month);
        this.duD.setCenterTextSize(this.mTextSize);
        this.duD.setOuterTextSize(this.duS);
        this.duD.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.duD.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.duD.setLineSpacingMultiplier(3.0f);
        this.duD.setDividerType(WheelView3d.DividerType.FILL);
        this.duD.setVisibleItem(7);
        this.duD.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VI = BdDatePicker.this.duK + i;
                BdDatePicker.this.aGE();
            }
        });
        this.duE = (WheelView3d) findViewById(a.f.wheel_day);
        this.duE.setCenterTextSize(this.mTextSize);
        this.duE.setOuterTextSize(this.duS);
        this.duE.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.duE.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.duE.setLineSpacingMultiplier(3.0f);
        this.duE.setDividerType(WheelView3d.DividerType.FILL);
        this.duE.setVisibleItem(7);
        this.duE.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VJ = BdDatePicker.this.duN + i;
            }
        });
        aGA();
    }

    private void aGA() {
        Calendar calendar = Calendar.getInstance();
        this.VH = calendar.get(1);
        this.VI = calendar.get(2) + 1;
        this.VJ = calendar.get(5);
        aGB();
    }

    public void aGB() {
        aGC();
        aGD();
        aGE();
    }

    private void aGC() {
        if (this.VH < this.duI || this.VH > this.duJ) {
            this.VH = this.duI;
        }
        this.duC.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.duI, this.duJ));
        a(this.duC, this.duI, this.duJ);
    }

    public void aGD() {
        this.duK = 1;
        this.duL = 12;
        if (this.duG != null && this.VH == this.duI) {
            this.duK = this.duG.getMonth() + 1;
        }
        if (this.duH != null && this.VH == this.duJ) {
            this.duL = this.duH.getMonth() + 1;
        }
        this.duD.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.duK, this.duL));
        a(this.duD, this.duK, this.duL);
        setMonth(this.VI);
    }

    public void aGE() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.VI) >= 0) {
            this.duM = 31;
        } else if (Arrays.binarySearch(iArr, this.VI) >= 0) {
            this.duM = 30;
        } else if ((this.VH % 4 == 0 && this.VH % 100 != 0) || this.VH % 400 == 0) {
            this.duM = 29;
        } else {
            this.duM = 28;
        }
        this.duN = 1;
        this.duO = this.duM;
        if (this.duG != null && this.VH == this.duI && this.VI == this.duG.getMonth() + 1) {
            this.duN = this.duG.getDate();
        }
        if (this.duH != null && this.VH == this.duJ && this.VI == this.duH.getMonth() + 1) {
            this.duO = this.duH.getDate();
        }
        this.duE.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.duN, this.duO));
        a(this.duE, this.duN, this.duO);
        setDay(this.VJ);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.duF = aVar;
    }

    public void setYear(int i) {
        if (i < this.duI) {
            i = this.duI;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.duI + " and " + this.duJ).aIu();
            }
        } else if (i > this.duJ) {
            i = this.duJ;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.duI + " and " + this.duJ).aIs();
            }
        }
        this.VH = i;
        this.duC.setCurrentItem(this.VH - this.duI);
    }

    public int getYear() {
        return this.VH;
    }

    public void setMonth(int i) {
        if (i < this.duK) {
            i = this.duK;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.duK + " and " + this.duL).aIu();
            }
        } else if (i > this.duL) {
            i = this.duL;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.duK + " and " + this.duL).aIs();
            }
        }
        this.VI = i;
        this.duD.setCurrentItem(this.VI - this.duK);
    }

    public int getMonth() {
        return this.VI;
    }

    public void setDay(int i) {
        if (i < this.duN || i > this.duO) {
            i = this.duN;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.duN + " and " + this.duO).aIs();
            }
        } else if (i > this.duO) {
            i = this.duO;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.duN + " and " + this.duO).aIu();
            }
        }
        this.VJ = i;
        this.duE.setCurrentItem(this.VJ - this.duN);
    }

    public int getDay() {
        return this.VJ;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.duG = date;
            this.duI = this.duG.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.duI = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.duH = date;
            this.duJ = this.duH.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.duJ = 2100;
    }

    public void setFields(String str) {
        this.duP = str;
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
                    this.duC.setGravity(17);
                    this.duD.setVisibility(8);
                    this.duE.setVisibility(8);
                    return;
                case 1:
                    this.duC.setGravity(5);
                    this.duC.setGravityOffset(this.duR);
                    this.duD.setGravity(3);
                    this.duD.setGravityOffset(this.duR);
                    this.duD.setVisibility(0);
                    this.duE.setVisibility(8);
                    return;
                default:
                    this.duC.setGravity(5);
                    this.duC.setGravityOffset(this.duR);
                    this.duE.setGravity(3);
                    this.duE.setGravityOffset(this.duR);
                    this.duD.setVisibility(0);
                    this.duE.setVisibility(0);
                    return;
            }
        }
    }

    public boolean rk(String str) {
        WheelView3d wheelView3d = null;
        char c = 65535;
        switch (str.hashCode()) {
            case 99228:
                if (str.equals(Config.TRACE_VISIT_RECENT_DAY)) {
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
                wheelView3d = this.duC;
                break;
            case 1:
                wheelView3d = this.duD;
                break;
            case 2:
                wheelView3d = this.duE;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.duQ = z;
        this.duC.setIsOptions(z);
        this.duD.setIsOptions(z);
        this.duE.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.duD.setCyclic(z);
        this.duC.setCyclic(z);
        this.duE.setCyclic(z);
    }
}
