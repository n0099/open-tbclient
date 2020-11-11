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
    private int UR;
    private int US;
    private int UT;
    private WheelView3d dmM;
    private WheelView3d dmN;
    private WheelView3d dmO;
    private a dmP;
    private Date dmQ;
    private Date dmR;
    private int dmS;
    private int dmT;
    private int dmU;
    private int dmV;
    private int dmW;
    private int dmX;
    private int dmY;
    private String dmZ;
    private boolean dna;
    private int dnb;
    private int dnc;
    private int mTextSize;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.UR = FeatureCodes.SKY_SEG;
        this.US = 1;
        this.UT = 1;
        this.dmS = FeatureCodes.SKY_SEG;
        this.dmT = 2100;
        this.dmU = 1;
        this.dmV = 12;
        this.dmW = 31;
        this.dmX = 1;
        this.dmY = this.dmW;
        this.dnb = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UR = FeatureCodes.SKY_SEG;
        this.US = 1;
        this.UT = 1;
        this.dmS = FeatureCodes.SKY_SEG;
        this.dmT = 2100;
        this.dmU = 1;
        this.dmV = 12;
        this.dmW = 31;
        this.dmX = 1;
        this.dmY = this.dmW;
        this.dnb = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UR = FeatureCodes.SKY_SEG;
        this.US = 1;
        this.UT = 1;
        this.dmS = FeatureCodes.SKY_SEG;
        this.dmT = 2100;
        this.dmU = 1;
        this.dmV = 12;
        this.dmW = 31;
        this.dmX = 1;
        this.dmY = this.dmW;
        this.dnb = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.dnb = ah.N(this.dnb);
        this.mTextSize = ah.N(16.0f);
        this.dnc = ah.N(14.0f);
        this.dmM = (WheelView3d) findViewById(a.f.wheel_year);
        this.dmM.setCenterTextSize(this.mTextSize);
        this.dmM.setOuterTextSize(this.dnc);
        this.dmM.setLineSpacingMultiplier(3.0f);
        this.dmM.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dmM.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dmM.setDividerType(WheelView3d.DividerType.FILL);
        this.dmM.setVisibleItem(7);
        this.dmM.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.UR = BdDatePicker.this.dmS + i;
                BdDatePicker.this.aGg();
                BdDatePicker.this.aGh();
            }
        });
        this.dmN = (WheelView3d) findViewById(a.f.wheel_month);
        this.dmN.setCenterTextSize(this.mTextSize);
        this.dmN.setOuterTextSize(this.dnc);
        this.dmN.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dmN.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dmN.setLineSpacingMultiplier(3.0f);
        this.dmN.setDividerType(WheelView3d.DividerType.FILL);
        this.dmN.setVisibleItem(7);
        this.dmN.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.US = BdDatePicker.this.dmU + i;
                BdDatePicker.this.aGh();
            }
        });
        this.dmO = (WheelView3d) findViewById(a.f.wheel_day);
        this.dmO.setCenterTextSize(this.mTextSize);
        this.dmO.setOuterTextSize(this.dnc);
        this.dmO.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dmO.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dmO.setLineSpacingMultiplier(3.0f);
        this.dmO.setDividerType(WheelView3d.DividerType.FILL);
        this.dmO.setVisibleItem(7);
        this.dmO.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.UT = BdDatePicker.this.dmX + i;
            }
        });
        aGd();
    }

    private void aGd() {
        Calendar calendar = Calendar.getInstance();
        this.UR = calendar.get(1);
        this.US = calendar.get(2) + 1;
        this.UT = calendar.get(5);
        aGe();
    }

    public void aGe() {
        aGf();
        aGg();
        aGh();
    }

    private void aGf() {
        if (this.UR < this.dmS || this.UR > this.dmT) {
            this.UR = this.dmS;
        }
        this.dmM.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dmS, this.dmT));
        a(this.dmM, this.dmS, this.dmT);
    }

    public void aGg() {
        this.dmU = 1;
        this.dmV = 12;
        if (this.dmQ != null && this.UR == this.dmS) {
            this.dmU = this.dmQ.getMonth() + 1;
        }
        if (this.dmR != null && this.UR == this.dmT) {
            this.dmV = this.dmR.getMonth() + 1;
        }
        this.dmN.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dmU, this.dmV));
        a(this.dmN, this.dmU, this.dmV);
        setMonth(this.US);
    }

    public void aGh() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.US) >= 0) {
            this.dmW = 31;
        } else if (Arrays.binarySearch(iArr, this.US) >= 0) {
            this.dmW = 30;
        } else if ((this.UR % 4 == 0 && this.UR % 100 != 0) || this.UR % 400 == 0) {
            this.dmW = 29;
        } else {
            this.dmW = 28;
        }
        this.dmX = 1;
        this.dmY = this.dmW;
        if (this.dmQ != null && this.UR == this.dmS && this.US == this.dmQ.getMonth() + 1) {
            this.dmX = this.dmQ.getDate();
        }
        if (this.dmR != null && this.UR == this.dmT && this.US == this.dmR.getMonth() + 1) {
            this.dmY = this.dmR.getDate();
        }
        this.dmO.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dmX, this.dmY));
        a(this.dmO, this.dmX, this.dmY);
        setDay(this.UT);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dmP = aVar;
    }

    public void setYear(int i) {
        if (i < this.dmS) {
            i = this.dmS;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dmS + " and " + this.dmT).showToastBottom();
            }
        } else if (i > this.dmT) {
            i = this.dmT;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dmS + " and " + this.dmT).showToast();
            }
        }
        this.UR = i;
        this.dmM.setCurrentItem(this.UR - this.dmS);
    }

    public int getYear() {
        return this.UR;
    }

    public void setMonth(int i) {
        if (i < this.dmU) {
            i = this.dmU;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dmU + " and " + this.dmV).showToastBottom();
            }
        } else if (i > this.dmV) {
            i = this.dmV;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dmU + " and " + this.dmV).showToast();
            }
        }
        this.US = i;
        this.dmN.setCurrentItem(this.US - this.dmU);
    }

    public int getMonth() {
        return this.US;
    }

    public void setDay(int i) {
        if (i < this.dmX || i > this.dmY) {
            i = this.dmX;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dmX + " and " + this.dmY).showToast();
            }
        } else if (i > this.dmY) {
            i = this.dmY;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dmX + " and " + this.dmY).showToastBottom();
            }
        }
        this.UT = i;
        this.dmO.setCurrentItem(this.UT - this.dmX);
    }

    public int getDay() {
        return this.UT;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.dmQ = date;
            this.dmS = this.dmQ.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dmS = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.dmR = date;
            this.dmT = this.dmR.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dmT = 2100;
    }

    public void setFields(String str) {
        this.dmZ = str;
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
                    this.dmM.setGravity(17);
                    this.dmN.setVisibility(8);
                    this.dmO.setVisibility(8);
                    return;
                case 1:
                    this.dmM.setGravity(5);
                    this.dmM.setGravityOffset(this.dnb);
                    this.dmN.setGravity(3);
                    this.dmN.setGravityOffset(this.dnb);
                    this.dmN.setVisibility(0);
                    this.dmO.setVisibility(8);
                    return;
                default:
                    this.dmM.setGravity(5);
                    this.dmM.setGravityOffset(this.dnb);
                    this.dmO.setGravity(3);
                    this.dmO.setGravityOffset(this.dnb);
                    this.dmN.setVisibility(0);
                    this.dmO.setVisibility(0);
                    return;
            }
        }
    }

    public boolean rJ(String str) {
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
                wheelView3d = this.dmM;
                break;
            case 1:
                wheelView3d = this.dmN;
                break;
            case 2:
                wheelView3d = this.dmO;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.dna = z;
        this.dmM.setIsOptions(z);
        this.dmN.setIsOptions(z);
        this.dmO.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.dmN.setCyclic(z);
        this.dmM.setCyclic(z);
        this.dmO.setCyclic(z);
    }
}
