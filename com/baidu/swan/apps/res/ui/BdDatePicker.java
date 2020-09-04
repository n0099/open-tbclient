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
    private String cKA;
    private boolean cKB;
    private int cKC;
    private int cKD;
    private WheelView3d cKn;
    private WheelView3d cKo;
    private WheelView3d cKp;
    private a cKq;
    private Date cKr;
    private Date cKs;
    private int cKt;
    private int cKu;
    private int cKv;
    private int cKw;
    private int cKx;
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
        this.cKt = FeatureCodes.SKY_SEG;
        this.cKu = 2100;
        this.cKv = 1;
        this.cKw = 12;
        this.cKx = 31;
        this.cKy = 1;
        this.cKz = this.cKx;
        this.cKC = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ue = FeatureCodes.SKY_SEG;
        this.Uf = 1;
        this.Ug = 1;
        this.cKt = FeatureCodes.SKY_SEG;
        this.cKu = 2100;
        this.cKv = 1;
        this.cKw = 12;
        this.cKx = 31;
        this.cKy = 1;
        this.cKz = this.cKx;
        this.cKC = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ue = FeatureCodes.SKY_SEG;
        this.Uf = 1;
        this.Ug = 1;
        this.cKt = FeatureCodes.SKY_SEG;
        this.cKu = 2100;
        this.cKv = 1;
        this.cKw = 12;
        this.cKx = 31;
        this.cKy = 1;
        this.cKz = this.cKx;
        this.cKC = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.cKC = ah.H(this.cKC);
        this.mTextSize = ah.H(16.0f);
        this.cKD = ah.H(14.0f);
        this.cKn = (WheelView3d) findViewById(a.f.wheel_year);
        this.cKn.setCenterTextSize(this.mTextSize);
        this.cKn.setOuterTextSize(this.cKD);
        this.cKn.setLineSpacingMultiplier(3.0f);
        this.cKn.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKn.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKn.setDividerType(WheelView3d.DividerType.FILL);
        this.cKn.setVisibleItem(7);
        this.cKn.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Ue = BdDatePicker.this.cKt + i;
                BdDatePicker.this.ayu();
                BdDatePicker.this.ayv();
            }
        });
        this.cKo = (WheelView3d) findViewById(a.f.wheel_month);
        this.cKo.setCenterTextSize(this.mTextSize);
        this.cKo.setOuterTextSize(this.cKD);
        this.cKo.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKo.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKo.setLineSpacingMultiplier(3.0f);
        this.cKo.setDividerType(WheelView3d.DividerType.FILL);
        this.cKo.setVisibleItem(7);
        this.cKo.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Uf = BdDatePicker.this.cKv + i;
                BdDatePicker.this.ayv();
            }
        });
        this.cKp = (WheelView3d) findViewById(a.f.wheel_day);
        this.cKp.setCenterTextSize(this.mTextSize);
        this.cKp.setOuterTextSize(this.cKD);
        this.cKp.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.cKp.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.cKp.setLineSpacingMultiplier(3.0f);
        this.cKp.setDividerType(WheelView3d.DividerType.FILL);
        this.cKp.setVisibleItem(7);
        this.cKp.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.Ug = BdDatePicker.this.cKy + i;
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
        if (this.Ue < this.cKt || this.Ue > this.cKu) {
            this.Ue = this.cKt;
        }
        this.cKn.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKt, this.cKu));
        a(this.cKn, this.cKt, this.cKu);
    }

    public void ayu() {
        this.cKv = 1;
        this.cKw = 12;
        if (this.cKr != null && this.Ue == this.cKt) {
            this.cKv = this.cKr.getMonth() + 1;
        }
        if (this.cKs != null && this.Ue == this.cKu) {
            this.cKw = this.cKs.getMonth() + 1;
        }
        this.cKo.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKv, this.cKw));
        a(this.cKo, this.cKv, this.cKw);
        setMonth(this.Uf);
    }

    public void ayv() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.Uf) >= 0) {
            this.cKx = 31;
        } else if (Arrays.binarySearch(iArr, this.Uf) >= 0) {
            this.cKx = 30;
        } else if ((this.Ue % 4 == 0 && this.Ue % 100 != 0) || this.Ue % 400 == 0) {
            this.cKx = 29;
        } else {
            this.cKx = 28;
        }
        this.cKy = 1;
        this.cKz = this.cKx;
        if (this.cKr != null && this.Ue == this.cKt && this.Uf == this.cKr.getMonth() + 1) {
            this.cKy = this.cKr.getDate();
        }
        if (this.cKs != null && this.Ue == this.cKu && this.Uf == this.cKs.getMonth() + 1) {
            this.cKz = this.cKs.getDate();
        }
        this.cKp.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cKy, this.cKz));
        a(this.cKp, this.cKy, this.cKz);
        setDay(this.Ug);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.cKq = aVar;
    }

    public void setYear(int i) {
        if (i < this.cKt) {
            i = this.cKt;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cKt + " and " + this.cKu).showToastBottom();
            }
        } else if (i > this.cKu) {
            i = this.cKu;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cKt + " and " + this.cKu).showToast();
            }
        }
        this.Ue = i;
        this.cKn.setCurrentItem(this.Ue - this.cKt);
    }

    public int getYear() {
        return this.Ue;
    }

    public void setMonth(int i) {
        if (i < this.cKv) {
            i = this.cKv;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cKv + " and " + this.cKw).showToastBottom();
            }
        } else if (i > this.cKw) {
            i = this.cKw;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cKv + " and " + this.cKw).showToast();
            }
        }
        this.Uf = i;
        this.cKo.setCurrentItem(this.Uf - this.cKv);
    }

    public int getMonth() {
        return this.Uf;
    }

    public void setDay(int i) {
        if (i < this.cKy || i > this.cKz) {
            i = this.cKy;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cKy + " and " + this.cKz).showToast();
            }
        } else if (i > this.cKz) {
            i = this.cKz;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cKy + " and " + this.cKz).showToastBottom();
            }
        }
        this.Ug = i;
        this.cKp.setCurrentItem(this.Ug - this.cKy);
    }

    public int getDay() {
        return this.Ug;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.cKr = date;
            this.cKt = this.cKr.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cKt = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.cKs = date;
            this.cKu = this.cKs.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cKu = 2100;
    }

    public void setFields(String str) {
        this.cKA = str;
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
                    this.cKn.setGravity(17);
                    this.cKo.setVisibility(8);
                    this.cKp.setVisibility(8);
                    return;
                case 1:
                    this.cKn.setGravity(5);
                    this.cKn.setGravityOffset(this.cKC);
                    this.cKo.setGravity(3);
                    this.cKo.setGravityOffset(this.cKC);
                    this.cKo.setVisibility(0);
                    this.cKp.setVisibility(8);
                    return;
                default:
                    this.cKn.setGravity(5);
                    this.cKn.setGravityOffset(this.cKC);
                    this.cKp.setGravity(3);
                    this.cKp.setGravityOffset(this.cKC);
                    this.cKo.setVisibility(0);
                    this.cKp.setVisibility(0);
                    return;
            }
        }
    }

    public boolean pX(String str) {
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
                wheelView3d = this.cKn;
                break;
            case 1:
                wheelView3d = this.cKo;
                break;
            case 2:
                wheelView3d = this.cKp;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.cKB = z;
        this.cKn.setIsOptions(z);
        this.cKo.setIsOptions(z);
        this.cKp.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.cKo.setCyclic(z);
        this.cKn.setCyclic(z);
        this.cKp.setCyclic(z);
    }
}
