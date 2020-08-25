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
/* loaded from: classes8.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int Ue;
    private int Uf;
    private int Ug;
    private WheelView3d cKj;
    private WheelView3d cKk;
    private WheelView3d cKl;
    private a cKm;
    private Date cKn;
    private Date cKo;
    private int cKp;
    private int cKq;
    private int cKr;
    private int cKs;
    private int cKt;
    private int cKu;
    private int cKv;
    private String cKw;
    private boolean cKx;
    private int cKy;
    private int cKz;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.Ue = FeatureCodes.SKY_SEG;
        this.Uf = 1;
        this.Ug = 1;
        this.cKp = FeatureCodes.SKY_SEG;
        this.cKq = 2100;
        this.cKr = 1;
        this.cKs = 12;
        this.cKt = 31;
        this.cKu = 1;
        this.cKv = this.cKt;
        this.cKy = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ue = FeatureCodes.SKY_SEG;
        this.Uf = 1;
        this.Ug = 1;
        this.cKp = FeatureCodes.SKY_SEG;
        this.cKq = 2100;
        this.cKr = 1;
        this.cKs = 12;
        this.cKt = 31;
        this.cKu = 1;
        this.cKv = this.cKt;
        this.cKy = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ue = FeatureCodes.SKY_SEG;
        this.Uf = 1;
        this.Ug = 1;
        this.cKp = FeatureCodes.SKY_SEG;
        this.cKq = 2100;
        this.cKr = 1;
        this.cKs = 12;
        this.cKt = 31;
        this.cKu = 1;
        this.cKv = this.cKt;
        this.cKy = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.cKy = ah.H(this.cKy);
        this.mTextSize = ah.H(16.0f);
        this.cKz = ah.H(14.0f);
        this.cKj = (WheelView3d) findViewById(a.f.wheel_year);
        this.cKj.setCenterTextSize(this.mTextSize);
        this.cKj.setOuterTextSize(this.cKz);
        this.cKj.setLineSpacingMultiplier(3.0f);
        this.cKj.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKj.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKj.setDividerType(WheelView3d.DividerType.FILL);
        this.cKj.setVisibleItem(7);
        this.cKj.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Ue = BdDatePicker.this.cKp + i;
                BdDatePicker.this.ayu();
                BdDatePicker.this.ayv();
            }
        });
        this.cKk = (WheelView3d) findViewById(a.f.wheel_month);
        this.cKk.setCenterTextSize(this.mTextSize);
        this.cKk.setOuterTextSize(this.cKz);
        this.cKk.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKk.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKk.setLineSpacingMultiplier(3.0f);
        this.cKk.setDividerType(WheelView3d.DividerType.FILL);
        this.cKk.setVisibleItem(7);
        this.cKk.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Uf = BdDatePicker.this.cKr + i;
                BdDatePicker.this.ayv();
            }
        });
        this.cKl = (WheelView3d) findViewById(a.f.wheel_day);
        this.cKl.setCenterTextSize(this.mTextSize);
        this.cKl.setOuterTextSize(this.cKz);
        this.cKl.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKl.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKl.setLineSpacingMultiplier(3.0f);
        this.cKl.setDividerType(WheelView3d.DividerType.FILL);
        this.cKl.setVisibleItem(7);
        this.cKl.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Ug = BdDatePicker.this.cKu + i;
            }
        });
        ayr();
    }

    private void ayr() {
        Calendar calendar = Calendar.getInstance();
        this.Ue = calendar.get(1);
        this.Uf = calendar.get(2) + 1;
        this.Ug = calendar.get(5);
        ays();
    }

    public void ays() {
        ayt();
        ayu();
        ayv();
    }

    private void ayt() {
        if (this.Ue < this.cKp || this.Ue > this.cKq) {
            this.Ue = this.cKp;
        }
        this.cKj.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKp, this.cKq));
        a(this.cKj, this.cKp, this.cKq);
    }

    public void ayu() {
        this.cKr = 1;
        this.cKs = 12;
        if (this.cKn != null && this.Ue == this.cKp) {
            this.cKr = this.cKn.getMonth() + 1;
        }
        if (this.cKo != null && this.Ue == this.cKq) {
            this.cKs = this.cKo.getMonth() + 1;
        }
        this.cKk.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKr, this.cKs));
        a(this.cKk, this.cKr, this.cKs);
        setMonth(this.Uf);
    }

    public void ayv() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.Uf) >= 0) {
            this.cKt = 31;
        } else if (Arrays.binarySearch(iArr, this.Uf) >= 0) {
            this.cKt = 30;
        } else if ((this.Ue % 4 == 0 && this.Ue % 100 != 0) || this.Ue % 400 == 0) {
            this.cKt = 29;
        } else {
            this.cKt = 28;
        }
        this.cKu = 1;
        this.cKv = this.cKt;
        if (this.cKn != null && this.Ue == this.cKp && this.Uf == this.cKn.getMonth() + 1) {
            this.cKu = this.cKn.getDate();
        }
        if (this.cKo != null && this.Ue == this.cKq && this.Uf == this.cKo.getMonth() + 1) {
            this.cKv = this.cKo.getDate();
        }
        this.cKl.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKu, this.cKv));
        a(this.cKl, this.cKu, this.cKv);
        setDay(this.Ug);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cKm = aVar;
    }

    public void setYear(int i) {
        if (i < this.cKp) {
            i = this.cKp;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cKp + " and " + this.cKq).showToastBottom();
            }
        } else if (i > this.cKq) {
            i = this.cKq;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cKp + " and " + this.cKq).showToast();
            }
        }
        this.Ue = i;
        this.cKj.setCurrentItem(this.Ue - this.cKp);
    }

    public int getYear() {
        return this.Ue;
    }

    public void setMonth(int i) {
        if (i < this.cKr) {
            i = this.cKr;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cKr + " and " + this.cKs).showToastBottom();
            }
        } else if (i > this.cKs) {
            i = this.cKs;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cKr + " and " + this.cKs).showToast();
            }
        }
        this.Uf = i;
        this.cKk.setCurrentItem(this.Uf - this.cKr);
    }

    public int getMonth() {
        return this.Uf;
    }

    public void setDay(int i) {
        if (i < this.cKu || i > this.cKv) {
            i = this.cKu;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cKu + " and " + this.cKv).showToast();
            }
        } else if (i > this.cKv) {
            i = this.cKv;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cKu + " and " + this.cKv).showToastBottom();
            }
        }
        this.Ug = i;
        this.cKl.setCurrentItem(this.Ug - this.cKu);
    }

    public int getDay() {
        return this.Ug;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.cKn = date;
            this.cKp = this.cKn.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cKp = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.cKo = date;
            this.cKq = this.cKo.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cKq = 2100;
    }

    public void setFields(String str) {
        this.cKw = str;
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
                    this.cKj.setGravity(17);
                    this.cKk.setVisibility(8);
                    this.cKl.setVisibility(8);
                    return;
                case 1:
                    this.cKj.setGravity(5);
                    this.cKj.setGravityOffset(this.cKy);
                    this.cKk.setGravity(3);
                    this.cKk.setGravityOffset(this.cKy);
                    this.cKk.setVisibility(0);
                    this.cKl.setVisibility(8);
                    return;
                default:
                    this.cKj.setGravity(5);
                    this.cKj.setGravityOffset(this.cKy);
                    this.cKl.setGravity(3);
                    this.cKl.setGravityOffset(this.cKy);
                    this.cKk.setVisibility(0);
                    this.cKl.setVisibility(0);
                    return;
            }
        }
    }

    public boolean pW(String str) {
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
                wheelView3d = this.cKj;
                break;
            case 1:
                wheelView3d = this.cKk;
                break;
            case 2:
                wheelView3d = this.cKl;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.cKx = z;
        this.cKj.setIsOptions(z);
        this.cKk.setIsOptions(z);
        this.cKl.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.cKk.setCyclic(z);
        this.cKj.setCyclic(z);
        this.cKl.setCyclic(z);
    }
}
