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
    private WheelView3d dgR;
    private WheelView3d dgS;
    private WheelView3d dgT;
    private a dgU;
    private Date dgV;
    private Date dgW;
    private int dgX;
    private int dgY;
    private int dgZ;
    private int dha;
    private int dhb;
    private int dhc;
    private int dhd;
    private String dhe;
    private boolean dhf;
    private int dhg;
    private int dhh;
    private int mTextSize;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.UR = FeatureCodes.SKY_SEG;
        this.US = 1;
        this.UT = 1;
        this.dgX = FeatureCodes.SKY_SEG;
        this.dgY = 2100;
        this.dgZ = 1;
        this.dha = 12;
        this.dhb = 31;
        this.dhc = 1;
        this.dhd = this.dhb;
        this.dhg = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UR = FeatureCodes.SKY_SEG;
        this.US = 1;
        this.UT = 1;
        this.dgX = FeatureCodes.SKY_SEG;
        this.dgY = 2100;
        this.dgZ = 1;
        this.dha = 12;
        this.dhb = 31;
        this.dhc = 1;
        this.dhd = this.dhb;
        this.dhg = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UR = FeatureCodes.SKY_SEG;
        this.US = 1;
        this.UT = 1;
        this.dgX = FeatureCodes.SKY_SEG;
        this.dgY = 2100;
        this.dgZ = 1;
        this.dha = 12;
        this.dhb = 31;
        this.dhc = 1;
        this.dhd = this.dhb;
        this.dhg = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.dhg = ah.L(this.dhg);
        this.mTextSize = ah.L(16.0f);
        this.dhh = ah.L(14.0f);
        this.dgR = (WheelView3d) findViewById(a.f.wheel_year);
        this.dgR.setCenterTextSize(this.mTextSize);
        this.dgR.setOuterTextSize(this.dhh);
        this.dgR.setLineSpacingMultiplier(3.0f);
        this.dgR.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dgR.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dgR.setDividerType(WheelView3d.DividerType.FILL);
        this.dgR.setVisibleItem(7);
        this.dgR.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.UR = BdDatePicker.this.dgX + i;
                BdDatePicker.this.aDG();
                BdDatePicker.this.aDH();
            }
        });
        this.dgS = (WheelView3d) findViewById(a.f.wheel_month);
        this.dgS.setCenterTextSize(this.mTextSize);
        this.dgS.setOuterTextSize(this.dhh);
        this.dgS.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dgS.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dgS.setLineSpacingMultiplier(3.0f);
        this.dgS.setDividerType(WheelView3d.DividerType.FILL);
        this.dgS.setVisibleItem(7);
        this.dgS.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.US = BdDatePicker.this.dgZ + i;
                BdDatePicker.this.aDH();
            }
        });
        this.dgT = (WheelView3d) findViewById(a.f.wheel_day);
        this.dgT.setCenterTextSize(this.mTextSize);
        this.dgT.setOuterTextSize(this.dhh);
        this.dgT.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dgT.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dgT.setLineSpacingMultiplier(3.0f);
        this.dgT.setDividerType(WheelView3d.DividerType.FILL);
        this.dgT.setVisibleItem(7);
        this.dgT.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.UT = BdDatePicker.this.dhc + i;
            }
        });
        aDD();
    }

    private void aDD() {
        Calendar calendar = Calendar.getInstance();
        this.UR = calendar.get(1);
        this.US = calendar.get(2) + 1;
        this.UT = calendar.get(5);
        aDE();
    }

    public void aDE() {
        aDF();
        aDG();
        aDH();
    }

    private void aDF() {
        if (this.UR < this.dgX || this.UR > this.dgY) {
            this.UR = this.dgX;
        }
        this.dgR.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dgX, this.dgY));
        a(this.dgR, this.dgX, this.dgY);
    }

    public void aDG() {
        this.dgZ = 1;
        this.dha = 12;
        if (this.dgV != null && this.UR == this.dgX) {
            this.dgZ = this.dgV.getMonth() + 1;
        }
        if (this.dgW != null && this.UR == this.dgY) {
            this.dha = this.dgW.getMonth() + 1;
        }
        this.dgS.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dgZ, this.dha));
        a(this.dgS, this.dgZ, this.dha);
        setMonth(this.US);
    }

    public void aDH() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.US) >= 0) {
            this.dhb = 31;
        } else if (Arrays.binarySearch(iArr, this.US) >= 0) {
            this.dhb = 30;
        } else if ((this.UR % 4 == 0 && this.UR % 100 != 0) || this.UR % 400 == 0) {
            this.dhb = 29;
        } else {
            this.dhb = 28;
        }
        this.dhc = 1;
        this.dhd = this.dhb;
        if (this.dgV != null && this.UR == this.dgX && this.US == this.dgV.getMonth() + 1) {
            this.dhc = this.dgV.getDate();
        }
        if (this.dgW != null && this.UR == this.dgY && this.US == this.dgW.getMonth() + 1) {
            this.dhd = this.dgW.getDate();
        }
        this.dgT.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dhc, this.dhd));
        a(this.dgT, this.dhc, this.dhd);
        setDay(this.UT);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dgU = aVar;
    }

    public void setYear(int i) {
        if (i < this.dgX) {
            i = this.dgX;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dgX + " and " + this.dgY).showToastBottom();
            }
        } else if (i > this.dgY) {
            i = this.dgY;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dgX + " and " + this.dgY).showToast();
            }
        }
        this.UR = i;
        this.dgR.setCurrentItem(this.UR - this.dgX);
    }

    public int getYear() {
        return this.UR;
    }

    public void setMonth(int i) {
        if (i < this.dgZ) {
            i = this.dgZ;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dgZ + " and " + this.dha).showToastBottom();
            }
        } else if (i > this.dha) {
            i = this.dha;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dgZ + " and " + this.dha).showToast();
            }
        }
        this.US = i;
        this.dgS.setCurrentItem(this.US - this.dgZ);
    }

    public int getMonth() {
        return this.US;
    }

    public void setDay(int i) {
        if (i < this.dhc || i > this.dhd) {
            i = this.dhc;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dhc + " and " + this.dhd).showToast();
            }
        } else if (i > this.dhd) {
            i = this.dhd;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dhc + " and " + this.dhd).showToastBottom();
            }
        }
        this.UT = i;
        this.dgT.setCurrentItem(this.UT - this.dhc);
    }

    public int getDay() {
        return this.UT;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.dgV = date;
            this.dgX = this.dgV.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dgX = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.dgW = date;
            this.dgY = this.dgW.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dgY = 2100;
    }

    public void setFields(String str) {
        this.dhe = str;
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
                    this.dgR.setGravity(17);
                    this.dgS.setVisibility(8);
                    this.dgT.setVisibility(8);
                    return;
                case 1:
                    this.dgR.setGravity(5);
                    this.dgR.setGravityOffset(this.dhg);
                    this.dgS.setGravity(3);
                    this.dgS.setGravityOffset(this.dhg);
                    this.dgS.setVisibility(0);
                    this.dgT.setVisibility(8);
                    return;
                default:
                    this.dgR.setGravity(5);
                    this.dgR.setGravityOffset(this.dhg);
                    this.dgT.setGravity(3);
                    this.dgT.setGravityOffset(this.dhg);
                    this.dgS.setVisibility(0);
                    this.dgT.setVisibility(0);
                    return;
            }
        }
    }

    public boolean rv(String str) {
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
                wheelView3d = this.dgR;
                break;
            case 1:
                wheelView3d = this.dgS;
                break;
            case 2:
                wheelView3d = this.dgT;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.dhf = z;
        this.dgR.setIsOptions(z);
        this.dgS.setIsOptions(z);
        this.dgT.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.dgS.setCyclic(z);
        this.dgR.setCyclic(z);
        this.dgT.setCyclic(z);
    }
}
