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
/* loaded from: classes25.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int VJ;
    private int VK;
    private int VL;
    private WheelView3d dsf;
    private WheelView3d dsg;
    private WheelView3d dsh;
    private a dsi;
    private Date dsj;
    private Date dsk;
    private int dsl;
    private int dsm;
    private int dsn;
    private int dso;
    private int dsp;
    private int dsq;
    private int dsr;
    private String dss;
    private boolean dsu;
    private int dsv;
    private int dsw;
    private int mTextSize;

    /* loaded from: classes25.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.VJ = FeatureCodes.SKY_SEG;
        this.VK = 1;
        this.VL = 1;
        this.dsl = FeatureCodes.SKY_SEG;
        this.dsm = 2100;
        this.dsn = 1;
        this.dso = 12;
        this.dsp = 31;
        this.dsq = 1;
        this.dsr = this.dsp;
        this.dsv = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VJ = FeatureCodes.SKY_SEG;
        this.VK = 1;
        this.VL = 1;
        this.dsl = FeatureCodes.SKY_SEG;
        this.dsm = 2100;
        this.dsn = 1;
        this.dso = 12;
        this.dsp = 31;
        this.dsq = 1;
        this.dsr = this.dsp;
        this.dsv = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.VJ = FeatureCodes.SKY_SEG;
        this.VK = 1;
        this.VL = 1;
        this.dsl = FeatureCodes.SKY_SEG;
        this.dsm = 2100;
        this.dsn = 1;
        this.dso = 12;
        this.dsp = 31;
        this.dsq = 1;
        this.dsr = this.dsp;
        this.dsv = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.dsv = ah.M(this.dsv);
        this.mTextSize = ah.M(16.0f);
        this.dsw = ah.M(14.0f);
        this.dsf = (WheelView3d) findViewById(a.f.wheel_year);
        this.dsf.setCenterTextSize(this.mTextSize);
        this.dsf.setOuterTextSize(this.dsw);
        this.dsf.setLineSpacingMultiplier(3.0f);
        this.dsf.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dsf.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dsf.setDividerType(WheelView3d.DividerType.FILL);
        this.dsf.setVisibleItem(7);
        this.dsf.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VJ = BdDatePicker.this.dsl + i;
                BdDatePicker.this.aIG();
                BdDatePicker.this.aIH();
            }
        });
        this.dsg = (WheelView3d) findViewById(a.f.wheel_month);
        this.dsg.setCenterTextSize(this.mTextSize);
        this.dsg.setOuterTextSize(this.dsw);
        this.dsg.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dsg.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dsg.setLineSpacingMultiplier(3.0f);
        this.dsg.setDividerType(WheelView3d.DividerType.FILL);
        this.dsg.setVisibleItem(7);
        this.dsg.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VK = BdDatePicker.this.dsn + i;
                BdDatePicker.this.aIH();
            }
        });
        this.dsh = (WheelView3d) findViewById(a.f.wheel_day);
        this.dsh.setCenterTextSize(this.mTextSize);
        this.dsh.setOuterTextSize(this.dsw);
        this.dsh.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dsh.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dsh.setLineSpacingMultiplier(3.0f);
        this.dsh.setDividerType(WheelView3d.DividerType.FILL);
        this.dsh.setVisibleItem(7);
        this.dsh.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VL = BdDatePicker.this.dsq + i;
            }
        });
        aID();
    }

    private void aID() {
        Calendar calendar = Calendar.getInstance();
        this.VJ = calendar.get(1);
        this.VK = calendar.get(2) + 1;
        this.VL = calendar.get(5);
        aIE();
    }

    public void aIE() {
        aIF();
        aIG();
        aIH();
    }

    private void aIF() {
        if (this.VJ < this.dsl || this.VJ > this.dsm) {
            this.VJ = this.dsl;
        }
        this.dsf.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dsl, this.dsm));
        a(this.dsf, this.dsl, this.dsm);
    }

    public void aIG() {
        this.dsn = 1;
        this.dso = 12;
        if (this.dsj != null && this.VJ == this.dsl) {
            this.dsn = this.dsj.getMonth() + 1;
        }
        if (this.dsk != null && this.VJ == this.dsm) {
            this.dso = this.dsk.getMonth() + 1;
        }
        this.dsg.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dsn, this.dso));
        a(this.dsg, this.dsn, this.dso);
        setMonth(this.VK);
    }

    public void aIH() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.VK) >= 0) {
            this.dsp = 31;
        } else if (Arrays.binarySearch(iArr, this.VK) >= 0) {
            this.dsp = 30;
        } else if ((this.VJ % 4 == 0 && this.VJ % 100 != 0) || this.VJ % 400 == 0) {
            this.dsp = 29;
        } else {
            this.dsp = 28;
        }
        this.dsq = 1;
        this.dsr = this.dsp;
        if (this.dsj != null && this.VJ == this.dsl && this.VK == this.dsj.getMonth() + 1) {
            this.dsq = this.dsj.getDate();
        }
        if (this.dsk != null && this.VJ == this.dsm && this.VK == this.dsk.getMonth() + 1) {
            this.dsr = this.dsk.getDate();
        }
        this.dsh.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dsq, this.dsr));
        a(this.dsh, this.dsq, this.dsr);
        setDay(this.VL);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dsi = aVar;
    }

    public void setYear(int i) {
        if (i < this.dsl) {
            i = this.dsl;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dsl + " and " + this.dsm).showToastBottom();
            }
        } else if (i > this.dsm) {
            i = this.dsm;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dsl + " and " + this.dsm).showToast();
            }
        }
        this.VJ = i;
        this.dsf.setCurrentItem(this.VJ - this.dsl);
    }

    public int getYear() {
        return this.VJ;
    }

    public void setMonth(int i) {
        if (i < this.dsn) {
            i = this.dsn;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dsn + " and " + this.dso).showToastBottom();
            }
        } else if (i > this.dso) {
            i = this.dso;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dsn + " and " + this.dso).showToast();
            }
        }
        this.VK = i;
        this.dsg.setCurrentItem(this.VK - this.dsn);
    }

    public int getMonth() {
        return this.VK;
    }

    public void setDay(int i) {
        if (i < this.dsq || i > this.dsr) {
            i = this.dsq;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dsq + " and " + this.dsr).showToast();
            }
        } else if (i > this.dsr) {
            i = this.dsr;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dsq + " and " + this.dsr).showToastBottom();
            }
        }
        this.VL = i;
        this.dsh.setCurrentItem(this.VL - this.dsq);
    }

    public int getDay() {
        return this.VL;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.dsj = date;
            this.dsl = this.dsj.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dsl = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.dsk = date;
            this.dsm = this.dsk.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dsm = 2100;
    }

    public void setFields(String str) {
        this.dss = str;
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
                    this.dsf.setGravity(17);
                    this.dsg.setVisibility(8);
                    this.dsh.setVisibility(8);
                    return;
                case 1:
                    this.dsf.setGravity(5);
                    this.dsf.setGravityOffset(this.dsv);
                    this.dsg.setGravity(3);
                    this.dsg.setGravityOffset(this.dsv);
                    this.dsg.setVisibility(0);
                    this.dsh.setVisibility(8);
                    return;
                default:
                    this.dsf.setGravity(5);
                    this.dsf.setGravityOffset(this.dsv);
                    this.dsh.setGravity(3);
                    this.dsh.setGravityOffset(this.dsv);
                    this.dsg.setVisibility(0);
                    this.dsh.setVisibility(0);
                    return;
            }
        }
    }

    public boolean sk(String str) {
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
                wheelView3d = this.dsf;
                break;
            case 1:
                wheelView3d = this.dsg;
                break;
            case 2:
                wheelView3d = this.dsh;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.dsu = z;
        this.dsf.setIsOptions(z);
        this.dsg.setIsOptions(z);
        this.dsh.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.dsg.setCyclic(z);
        this.dsf.setCyclic(z);
        this.dsh.setCyclic(z);
    }
}
