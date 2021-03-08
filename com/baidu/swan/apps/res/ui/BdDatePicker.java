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
/* loaded from: classes8.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int Xc;
    private int Xe;
    private int Xf;
    private WheelView3d dwd;
    private WheelView3d dwe;
    private WheelView3d dwf;
    private a dwg;
    private Date dwh;
    private Date dwi;
    private int dwj;
    private int dwk;
    private int dwl;
    private int dwm;
    private int dwn;
    private int dwo;
    private int dwp;
    private String dwq;
    private boolean dwr;
    private int dws;
    private int dwt;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.Xc = FeatureCodes.SKY_SEG;
        this.Xe = 1;
        this.Xf = 1;
        this.dwj = FeatureCodes.SKY_SEG;
        this.dwk = 2100;
        this.dwl = 1;
        this.dwm = 12;
        this.dwn = 31;
        this.dwo = 1;
        this.dwp = this.dwn;
        this.dws = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xc = FeatureCodes.SKY_SEG;
        this.Xe = 1;
        this.Xf = 1;
        this.dwj = FeatureCodes.SKY_SEG;
        this.dwk = 2100;
        this.dwl = 1;
        this.dwm = 12;
        this.dwn = 31;
        this.dwo = 1;
        this.dwp = this.dwn;
        this.dws = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xc = FeatureCodes.SKY_SEG;
        this.Xe = 1;
        this.Xf = 1;
        this.dwj = FeatureCodes.SKY_SEG;
        this.dwk = 2100;
        this.dwl = 1;
        this.dwm = 12;
        this.dwn = 31;
        this.dwo = 1;
        this.dwp = this.dwn;
        this.dws = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.dws = ah.T(this.dws);
        this.mTextSize = ah.T(16.0f);
        this.dwt = ah.T(14.0f);
        this.dwd = (WheelView3d) findViewById(a.f.wheel_year);
        this.dwd.setCenterTextSize(this.mTextSize);
        this.dwd.setOuterTextSize(this.dwt);
        this.dwd.setLineSpacingMultiplier(3.0f);
        this.dwd.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dwd.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dwd.setDividerType(WheelView3d.DividerType.FILL);
        this.dwd.setVisibleItem(7);
        this.dwd.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Xc = BdDatePicker.this.dwj + i;
                BdDatePicker.this.aGG();
                BdDatePicker.this.aGH();
            }
        });
        this.dwe = (WheelView3d) findViewById(a.f.wheel_month);
        this.dwe.setCenterTextSize(this.mTextSize);
        this.dwe.setOuterTextSize(this.dwt);
        this.dwe.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dwe.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dwe.setLineSpacingMultiplier(3.0f);
        this.dwe.setDividerType(WheelView3d.DividerType.FILL);
        this.dwe.setVisibleItem(7);
        this.dwe.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Xe = BdDatePicker.this.dwl + i;
                BdDatePicker.this.aGH();
            }
        });
        this.dwf = (WheelView3d) findViewById(a.f.wheel_day);
        this.dwf.setCenterTextSize(this.mTextSize);
        this.dwf.setOuterTextSize(this.dwt);
        this.dwf.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dwf.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dwf.setLineSpacingMultiplier(3.0f);
        this.dwf.setDividerType(WheelView3d.DividerType.FILL);
        this.dwf.setVisibleItem(7);
        this.dwf.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Xf = BdDatePicker.this.dwo + i;
            }
        });
        aGD();
    }

    private void aGD() {
        Calendar calendar = Calendar.getInstance();
        this.Xc = calendar.get(1);
        this.Xe = calendar.get(2) + 1;
        this.Xf = calendar.get(5);
        aGE();
    }

    public void aGE() {
        aGF();
        aGG();
        aGH();
    }

    private void aGF() {
        if (this.Xc < this.dwj || this.Xc > this.dwk) {
            this.Xc = this.dwj;
        }
        this.dwd.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dwj, this.dwk));
        a(this.dwd, this.dwj, this.dwk);
    }

    public void aGG() {
        this.dwl = 1;
        this.dwm = 12;
        if (this.dwh != null && this.Xc == this.dwj) {
            this.dwl = this.dwh.getMonth() + 1;
        }
        if (this.dwi != null && this.Xc == this.dwk) {
            this.dwm = this.dwi.getMonth() + 1;
        }
        this.dwe.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dwl, this.dwm));
        a(this.dwe, this.dwl, this.dwm);
        setMonth(this.Xe);
    }

    public void aGH() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.Xe) >= 0) {
            this.dwn = 31;
        } else if (Arrays.binarySearch(iArr, this.Xe) >= 0) {
            this.dwn = 30;
        } else if ((this.Xc % 4 == 0 && this.Xc % 100 != 0) || this.Xc % 400 == 0) {
            this.dwn = 29;
        } else {
            this.dwn = 28;
        }
        this.dwo = 1;
        this.dwp = this.dwn;
        if (this.dwh != null && this.Xc == this.dwj && this.Xe == this.dwh.getMonth() + 1) {
            this.dwo = this.dwh.getDate();
        }
        if (this.dwi != null && this.Xc == this.dwk && this.Xe == this.dwi.getMonth() + 1) {
            this.dwp = this.dwi.getDate();
        }
        this.dwf.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dwo, this.dwp));
        a(this.dwf, this.dwo, this.dwp);
        setDay(this.Xf);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dwg = aVar;
    }

    public void setYear(int i) {
        if (i < this.dwj) {
            i = this.dwj;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dwj + " and " + this.dwk).aIx();
            }
        } else if (i > this.dwk) {
            i = this.dwk;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dwj + " and " + this.dwk).aIv();
            }
        }
        this.Xc = i;
        this.dwd.setCurrentItem(this.Xc - this.dwj);
    }

    public int getYear() {
        return this.Xc;
    }

    public void setMonth(int i) {
        if (i < this.dwl) {
            i = this.dwl;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dwl + " and " + this.dwm).aIx();
            }
        } else if (i > this.dwm) {
            i = this.dwm;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dwl + " and " + this.dwm).aIv();
            }
        }
        this.Xe = i;
        this.dwe.setCurrentItem(this.Xe - this.dwl);
    }

    public int getMonth() {
        return this.Xe;
    }

    public void setDay(int i) {
        if (i < this.dwo || i > this.dwp) {
            i = this.dwo;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dwo + " and " + this.dwp).aIv();
            }
        } else if (i > this.dwp) {
            i = this.dwp;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dwo + " and " + this.dwp).aIx();
            }
        }
        this.Xf = i;
        this.dwf.setCurrentItem(this.Xf - this.dwo);
    }

    public int getDay() {
        return this.Xf;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.dwh = date;
            this.dwj = this.dwh.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dwj = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.dwi = date;
            this.dwk = this.dwi.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dwk = 2100;
    }

    public void setFields(String str) {
        this.dwq = str;
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
                    this.dwd.setGravity(17);
                    this.dwe.setVisibility(8);
                    this.dwf.setVisibility(8);
                    return;
                case 1:
                    this.dwd.setGravity(5);
                    this.dwd.setGravityOffset(this.dws);
                    this.dwe.setGravity(3);
                    this.dwe.setGravityOffset(this.dws);
                    this.dwe.setVisibility(0);
                    this.dwf.setVisibility(8);
                    return;
                default:
                    this.dwd.setGravity(5);
                    this.dwd.setGravityOffset(this.dws);
                    this.dwf.setGravity(3);
                    this.dwf.setGravityOffset(this.dws);
                    this.dwe.setVisibility(0);
                    this.dwf.setVisibility(0);
                    return;
            }
        }
    }

    public boolean rs(String str) {
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
                wheelView3d = this.dwd;
                break;
            case 1:
                wheelView3d = this.dwe;
                break;
            case 2:
                wheelView3d = this.dwf;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.dwr = z;
        this.dwd.setIsOptions(z);
        this.dwe.setIsOptions(z);
        this.dwf.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.dwe.setCyclic(z);
        this.dwd.setCyclic(z);
        this.dwf.setCyclic(z);
    }
}
