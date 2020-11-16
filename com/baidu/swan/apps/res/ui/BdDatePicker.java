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
/* loaded from: classes7.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int US;
    private int UT;
    private int UU;
    private WheelView3d dlf;
    private WheelView3d dlg;
    private WheelView3d dlh;
    private a dli;
    private Date dlj;
    private Date dlk;
    private int dll;
    private int dlm;
    private int dln;
    private int dlo;
    private int dlp;
    private int dlq;
    private int dlr;
    private String dls;
    private boolean dlt;
    private int dlu;
    private int dlv;
    private int mTextSize;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.US = FeatureCodes.SKY_SEG;
        this.UT = 1;
        this.UU = 1;
        this.dll = FeatureCodes.SKY_SEG;
        this.dlm = 2100;
        this.dln = 1;
        this.dlo = 12;
        this.dlp = 31;
        this.dlq = 1;
        this.dlr = this.dlp;
        this.dlu = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.US = FeatureCodes.SKY_SEG;
        this.UT = 1;
        this.UU = 1;
        this.dll = FeatureCodes.SKY_SEG;
        this.dlm = 2100;
        this.dln = 1;
        this.dlo = 12;
        this.dlp = 31;
        this.dlq = 1;
        this.dlr = this.dlp;
        this.dlu = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.US = FeatureCodes.SKY_SEG;
        this.UT = 1;
        this.UU = 1;
        this.dll = FeatureCodes.SKY_SEG;
        this.dlm = 2100;
        this.dln = 1;
        this.dlo = 12;
        this.dlp = 31;
        this.dlq = 1;
        this.dlr = this.dlp;
        this.dlu = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.dlu = ah.M(this.dlu);
        this.mTextSize = ah.M(16.0f);
        this.dlv = ah.M(14.0f);
        this.dlf = (WheelView3d) findViewById(a.f.wheel_year);
        this.dlf.setCenterTextSize(this.mTextSize);
        this.dlf.setOuterTextSize(this.dlv);
        this.dlf.setLineSpacingMultiplier(3.0f);
        this.dlf.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dlf.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dlf.setDividerType(WheelView3d.DividerType.FILL);
        this.dlf.setVisibleItem(7);
        this.dlf.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.US = BdDatePicker.this.dll + i;
                BdDatePicker.this.aFy();
                BdDatePicker.this.aFz();
            }
        });
        this.dlg = (WheelView3d) findViewById(a.f.wheel_month);
        this.dlg.setCenterTextSize(this.mTextSize);
        this.dlg.setOuterTextSize(this.dlv);
        this.dlg.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dlg.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dlg.setLineSpacingMultiplier(3.0f);
        this.dlg.setDividerType(WheelView3d.DividerType.FILL);
        this.dlg.setVisibleItem(7);
        this.dlg.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.UT = BdDatePicker.this.dln + i;
                BdDatePicker.this.aFz();
            }
        });
        this.dlh = (WheelView3d) findViewById(a.f.wheel_day);
        this.dlh.setCenterTextSize(this.mTextSize);
        this.dlh.setOuterTextSize(this.dlv);
        this.dlh.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dlh.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dlh.setLineSpacingMultiplier(3.0f);
        this.dlh.setDividerType(WheelView3d.DividerType.FILL);
        this.dlh.setVisibleItem(7);
        this.dlh.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.UU = BdDatePicker.this.dlq + i;
            }
        });
        aFv();
    }

    private void aFv() {
        Calendar calendar = Calendar.getInstance();
        this.US = calendar.get(1);
        this.UT = calendar.get(2) + 1;
        this.UU = calendar.get(5);
        aFw();
    }

    public void aFw() {
        aFx();
        aFy();
        aFz();
    }

    private void aFx() {
        if (this.US < this.dll || this.US > this.dlm) {
            this.US = this.dll;
        }
        this.dlf.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dll, this.dlm));
        a(this.dlf, this.dll, this.dlm);
    }

    public void aFy() {
        this.dln = 1;
        this.dlo = 12;
        if (this.dlj != null && this.US == this.dll) {
            this.dln = this.dlj.getMonth() + 1;
        }
        if (this.dlk != null && this.US == this.dlm) {
            this.dlo = this.dlk.getMonth() + 1;
        }
        this.dlg.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dln, this.dlo));
        a(this.dlg, this.dln, this.dlo);
        setMonth(this.UT);
    }

    public void aFz() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.UT) >= 0) {
            this.dlp = 31;
        } else if (Arrays.binarySearch(iArr, this.UT) >= 0) {
            this.dlp = 30;
        } else if ((this.US % 4 == 0 && this.US % 100 != 0) || this.US % 400 == 0) {
            this.dlp = 29;
        } else {
            this.dlp = 28;
        }
        this.dlq = 1;
        this.dlr = this.dlp;
        if (this.dlj != null && this.US == this.dll && this.UT == this.dlj.getMonth() + 1) {
            this.dlq = this.dlj.getDate();
        }
        if (this.dlk != null && this.US == this.dlm && this.UT == this.dlk.getMonth() + 1) {
            this.dlr = this.dlk.getDate();
        }
        this.dlh.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dlq, this.dlr));
        a(this.dlh, this.dlq, this.dlr);
        setDay(this.UU);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dli = aVar;
    }

    public void setYear(int i) {
        if (i < this.dll) {
            i = this.dll;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dll + " and " + this.dlm).showToastBottom();
            }
        } else if (i > this.dlm) {
            i = this.dlm;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dll + " and " + this.dlm).showToast();
            }
        }
        this.US = i;
        this.dlf.setCurrentItem(this.US - this.dll);
    }

    public int getYear() {
        return this.US;
    }

    public void setMonth(int i) {
        if (i < this.dln) {
            i = this.dln;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dln + " and " + this.dlo).showToastBottom();
            }
        } else if (i > this.dlo) {
            i = this.dlo;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dln + " and " + this.dlo).showToast();
            }
        }
        this.UT = i;
        this.dlg.setCurrentItem(this.UT - this.dln);
    }

    public int getMonth() {
        return this.UT;
    }

    public void setDay(int i) {
        if (i < this.dlq || i > this.dlr) {
            i = this.dlq;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dlq + " and " + this.dlr).showToast();
            }
        } else if (i > this.dlr) {
            i = this.dlr;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dlq + " and " + this.dlr).showToastBottom();
            }
        }
        this.UU = i;
        this.dlh.setCurrentItem(this.UU - this.dlq);
    }

    public int getDay() {
        return this.UU;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.dlj = date;
            this.dll = this.dlj.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dll = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.dlk = date;
            this.dlm = this.dlk.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dlm = 2100;
    }

    public void setFields(String str) {
        this.dls = str;
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
                    this.dlf.setGravity(17);
                    this.dlg.setVisibility(8);
                    this.dlh.setVisibility(8);
                    return;
                case 1:
                    this.dlf.setGravity(5);
                    this.dlf.setGravityOffset(this.dlu);
                    this.dlg.setGravity(3);
                    this.dlg.setGravityOffset(this.dlu);
                    this.dlg.setVisibility(0);
                    this.dlh.setVisibility(8);
                    return;
                default:
                    this.dlf.setGravity(5);
                    this.dlf.setGravityOffset(this.dlu);
                    this.dlh.setGravity(3);
                    this.dlh.setGravityOffset(this.dlu);
                    this.dlg.setVisibility(0);
                    this.dlh.setVisibility(0);
                    return;
            }
        }
    }

    public boolean rD(String str) {
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
                wheelView3d = this.dlf;
                break;
            case 1:
                wheelView3d = this.dlg;
                break;
            case 2:
                wheelView3d = this.dlh;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.dlt = z;
        this.dlf.setIsOptions(z);
        this.dlg.setIsOptions(z);
        this.dlh.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.dlg.setCyclic(z);
        this.dlf.setCyclic(z);
        this.dlh.setCyclic(z);
    }
}
