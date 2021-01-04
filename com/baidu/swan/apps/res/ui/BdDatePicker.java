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
    private int VL;
    private int VM;
    private int VN;
    private WheelView3d dxe;
    private WheelView3d dxf;
    private WheelView3d dxg;
    private a dxh;
    private Date dxi;
    private Date dxj;
    private int dxk;
    private int dxl;
    private int dxm;
    private int dxn;
    private int dxo;
    private int dxp;
    private int dxq;
    private String dxr;
    private boolean dxs;
    private int dxt;
    private int dxu;
    private int mTextSize;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.VL = FeatureCodes.SKY_SEG;
        this.VM = 1;
        this.VN = 1;
        this.dxk = FeatureCodes.SKY_SEG;
        this.dxl = 2100;
        this.dxm = 1;
        this.dxn = 12;
        this.dxo = 31;
        this.dxp = 1;
        this.dxq = this.dxo;
        this.dxt = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VL = FeatureCodes.SKY_SEG;
        this.VM = 1;
        this.VN = 1;
        this.dxk = FeatureCodes.SKY_SEG;
        this.dxl = 2100;
        this.dxm = 1;
        this.dxn = 12;
        this.dxo = 31;
        this.dxp = 1;
        this.dxq = this.dxo;
        this.dxt = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.VL = FeatureCodes.SKY_SEG;
        this.VM = 1;
        this.VN = 1;
        this.dxk = FeatureCodes.SKY_SEG;
        this.dxl = 2100;
        this.dxm = 1;
        this.dxn = 12;
        this.dxo = 31;
        this.dxp = 1;
        this.dxq = this.dxo;
        this.dxt = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.dxt = ah.O(this.dxt);
        this.mTextSize = ah.O(16.0f);
        this.dxu = ah.O(14.0f);
        this.dxe = (WheelView3d) findViewById(a.f.wheel_year);
        this.dxe.setCenterTextSize(this.mTextSize);
        this.dxe.setOuterTextSize(this.dxu);
        this.dxe.setLineSpacingMultiplier(3.0f);
        this.dxe.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dxe.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dxe.setDividerType(WheelView3d.DividerType.FILL);
        this.dxe.setVisibleItem(7);
        this.dxe.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VL = BdDatePicker.this.dxk + i;
                BdDatePicker.this.aKb();
                BdDatePicker.this.aKc();
            }
        });
        this.dxf = (WheelView3d) findViewById(a.f.wheel_month);
        this.dxf.setCenterTextSize(this.mTextSize);
        this.dxf.setOuterTextSize(this.dxu);
        this.dxf.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dxf.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dxf.setLineSpacingMultiplier(3.0f);
        this.dxf.setDividerType(WheelView3d.DividerType.FILL);
        this.dxf.setVisibleItem(7);
        this.dxf.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VM = BdDatePicker.this.dxm + i;
                BdDatePicker.this.aKc();
            }
        });
        this.dxg = (WheelView3d) findViewById(a.f.wheel_day);
        this.dxg.setCenterTextSize(this.mTextSize);
        this.dxg.setOuterTextSize(this.dxu);
        this.dxg.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dxg.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dxg.setLineSpacingMultiplier(3.0f);
        this.dxg.setDividerType(WheelView3d.DividerType.FILL);
        this.dxg.setVisibleItem(7);
        this.dxg.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VN = BdDatePicker.this.dxp + i;
            }
        });
        aJY();
    }

    private void aJY() {
        Calendar calendar = Calendar.getInstance();
        this.VL = calendar.get(1);
        this.VM = calendar.get(2) + 1;
        this.VN = calendar.get(5);
        aJZ();
    }

    public void aJZ() {
        aKa();
        aKb();
        aKc();
    }

    private void aKa() {
        if (this.VL < this.dxk || this.VL > this.dxl) {
            this.VL = this.dxk;
        }
        this.dxe.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dxk, this.dxl));
        a(this.dxe, this.dxk, this.dxl);
    }

    public void aKb() {
        this.dxm = 1;
        this.dxn = 12;
        if (this.dxi != null && this.VL == this.dxk) {
            this.dxm = this.dxi.getMonth() + 1;
        }
        if (this.dxj != null && this.VL == this.dxl) {
            this.dxn = this.dxj.getMonth() + 1;
        }
        this.dxf.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dxm, this.dxn));
        a(this.dxf, this.dxm, this.dxn);
        setMonth(this.VM);
    }

    public void aKc() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.VM) >= 0) {
            this.dxo = 31;
        } else if (Arrays.binarySearch(iArr, this.VM) >= 0) {
            this.dxo = 30;
        } else if ((this.VL % 4 == 0 && this.VL % 100 != 0) || this.VL % 400 == 0) {
            this.dxo = 29;
        } else {
            this.dxo = 28;
        }
        this.dxp = 1;
        this.dxq = this.dxo;
        if (this.dxi != null && this.VL == this.dxk && this.VM == this.dxi.getMonth() + 1) {
            this.dxp = this.dxi.getDate();
        }
        if (this.dxj != null && this.VL == this.dxl && this.VM == this.dxj.getMonth() + 1) {
            this.dxq = this.dxj.getDate();
        }
        this.dxg.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dxp, this.dxq));
        a(this.dxg, this.dxp, this.dxq);
        setDay(this.VN);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dxh = aVar;
    }

    public void setYear(int i) {
        if (i < this.dxk) {
            i = this.dxk;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dxk + " and " + this.dxl).aLU();
            }
        } else if (i > this.dxl) {
            i = this.dxl;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dxk + " and " + this.dxl).aLS();
            }
        }
        this.VL = i;
        this.dxe.setCurrentItem(this.VL - this.dxk);
    }

    public int getYear() {
        return this.VL;
    }

    public void setMonth(int i) {
        if (i < this.dxm) {
            i = this.dxm;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dxm + " and " + this.dxn).aLU();
            }
        } else if (i > this.dxn) {
            i = this.dxn;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dxm + " and " + this.dxn).aLS();
            }
        }
        this.VM = i;
        this.dxf.setCurrentItem(this.VM - this.dxm);
    }

    public int getMonth() {
        return this.VM;
    }

    public void setDay(int i) {
        if (i < this.dxp || i > this.dxq) {
            i = this.dxp;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dxp + " and " + this.dxq).aLS();
            }
        } else if (i > this.dxq) {
            i = this.dxq;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dxp + " and " + this.dxq).aLU();
            }
        }
        this.VN = i;
        this.dxg.setCurrentItem(this.VN - this.dxp);
    }

    public int getDay() {
        return this.VN;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.dxi = date;
            this.dxk = this.dxi.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dxk = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.dxj = date;
            this.dxl = this.dxj.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dxl = 2100;
    }

    public void setFields(String str) {
        this.dxr = str;
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
                    this.dxe.setGravity(17);
                    this.dxf.setVisibility(8);
                    this.dxg.setVisibility(8);
                    return;
                case 1:
                    this.dxe.setGravity(5);
                    this.dxe.setGravityOffset(this.dxt);
                    this.dxf.setGravity(3);
                    this.dxf.setGravityOffset(this.dxt);
                    this.dxf.setVisibility(0);
                    this.dxg.setVisibility(8);
                    return;
                default:
                    this.dxe.setGravity(5);
                    this.dxe.setGravityOffset(this.dxt);
                    this.dxg.setGravity(3);
                    this.dxg.setGravityOffset(this.dxt);
                    this.dxf.setVisibility(0);
                    this.dxg.setVisibility(0);
                    return;
            }
        }
    }

    public boolean sd(String str) {
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
                wheelView3d = this.dxe;
                break;
            case 1:
                wheelView3d = this.dxf;
                break;
            case 2:
                wheelView3d = this.dxg;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.dxs = z;
        this.dxe.setIsOptions(z);
        this.dxf.setIsOptions(z);
        this.dxg.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.dxf.setCyclic(z);
        this.dxe.setCyclic(z);
        this.dxg.setCyclic(z);
    }
}
