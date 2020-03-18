package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes11.dex */
public class BdDatePicker extends LinearLayout {
    private WheelView3d bKg;
    private WheelView3d bKh;
    private WheelView3d bKi;
    private a bKj;
    private Date bKk;
    private Date bKl;
    private int bKm;
    private int bKn;
    private int bKo;
    private int bKp;
    private int bKq;
    private int bKr;
    private int bKs;
    private String bKt;
    private boolean bKu;
    private int bKv;
    private int bKw;
    private int mTextSize;
    private int zD;
    private int zE;
    private int zF;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.zD = 1900;
        this.zE = 1;
        this.zF = 1;
        this.bKm = 1900;
        this.bKn = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKo = 1;
        this.bKp = 12;
        this.bKq = 31;
        this.bKr = 1;
        this.bKs = this.bKq;
        this.bKv = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zD = 1900;
        this.zE = 1;
        this.zF = 1;
        this.bKm = 1900;
        this.bKn = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKo = 1;
        this.bKp = 12;
        this.bKq = 31;
        this.bKr = 1;
        this.bKs = this.bKq;
        this.bKv = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zD = 1900;
        this.zE = 1;
        this.zF = 1;
        this.bKm = 1900;
        this.bKn = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKo = 1;
        this.bKp = 12;
        this.bKq = 31;
        this.bKr = 1;
        this.bKs = this.bKq;
        this.bKv = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.bKv = af.S(this.bKv);
        this.mTextSize = af.S(16.0f);
        this.bKw = af.S(14.0f);
        this.bKg = (WheelView3d) findViewById(a.f.wheel_year);
        this.bKg.setCenterTextSize(this.mTextSize);
        this.bKg.setOuterTextSize(this.bKw);
        this.bKg.setLineSpacingMultiplier(3.0f);
        this.bKg.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKg.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKg.setDividerType(WheelView3d.DividerType.FILL);
        this.bKg.setVisibleItem(7);
        this.bKg.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zD = BdDatePicker.this.bKm + i;
                BdDatePicker.this.abI();
                BdDatePicker.this.abJ();
            }
        });
        this.bKh = (WheelView3d) findViewById(a.f.wheel_month);
        this.bKh.setCenterTextSize(this.mTextSize);
        this.bKh.setOuterTextSize(this.bKw);
        this.bKh.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKh.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKh.setLineSpacingMultiplier(3.0f);
        this.bKh.setDividerType(WheelView3d.DividerType.FILL);
        this.bKh.setVisibleItem(7);
        this.bKh.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zE = BdDatePicker.this.bKo + i;
                BdDatePicker.this.abJ();
            }
        });
        this.bKi = (WheelView3d) findViewById(a.f.wheel_day);
        this.bKi.setCenterTextSize(this.mTextSize);
        this.bKi.setOuterTextSize(this.bKw);
        this.bKi.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bKi.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bKi.setLineSpacingMultiplier(3.0f);
        this.bKi.setDividerType(WheelView3d.DividerType.FILL);
        this.bKi.setVisibleItem(7);
        this.bKi.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zF = BdDatePicker.this.bKr + i;
            }
        });
        abF();
    }

    private void abF() {
        Calendar calendar = Calendar.getInstance();
        this.zD = calendar.get(1);
        this.zE = calendar.get(2) + 1;
        this.zF = calendar.get(5);
        abG();
    }

    public void abG() {
        abH();
        abI();
        abJ();
    }

    private void abH() {
        if (this.zD < this.bKm || this.zD > this.bKn) {
            this.zD = this.bKm;
        }
        this.bKg.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKm, this.bKn));
        a(this.bKg, this.bKm, this.bKn);
    }

    public void abI() {
        this.bKo = 1;
        this.bKp = 12;
        if (this.bKk != null && this.zD == this.bKm) {
            this.bKo = this.bKk.getMonth() + 1;
        }
        if (this.bKl != null && this.zD == this.bKn) {
            this.bKp = this.bKl.getMonth() + 1;
        }
        this.bKh.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKo, this.bKp));
        a(this.bKh, this.bKo, this.bKp);
        setMonth(this.zE);
    }

    public void abJ() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.zE) >= 0) {
            this.bKq = 31;
        } else if (Arrays.binarySearch(iArr, this.zE) >= 0) {
            this.bKq = 30;
        } else if ((this.zD % 4 == 0 && this.zD % 100 != 0) || this.zD % 400 == 0) {
            this.bKq = 29;
        } else {
            this.bKq = 28;
        }
        this.bKr = 1;
        this.bKs = this.bKq;
        if (this.bKk != null && this.zD == this.bKm && this.zE == this.bKk.getMonth() + 1) {
            this.bKr = this.bKk.getDate();
        }
        if (this.bKl != null && this.zD == this.bKn && this.zE == this.bKl.getMonth() + 1) {
            this.bKs = this.bKl.getDate();
        }
        this.bKi.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKr, this.bKs));
        a(this.bKi, this.bKr, this.bKs);
        setDay(this.zF);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bKj = aVar;
    }

    public void setYear(int i) {
        if (i < this.bKm) {
            i = this.bKm;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bKm + " and " + this.bKn).showToastBottom();
        } else if (i > this.bKn) {
            i = this.bKn;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bKm + " and " + this.bKn).showToast();
        }
        this.zD = i;
        this.bKg.setCurrentItem(this.zD - this.bKm);
    }

    public int getYear() {
        return this.zD;
    }

    public void setMonth(int i) {
        if (i < this.bKo) {
            i = this.bKo;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bKo + " and " + this.bKp).showToastBottom();
        } else if (i > this.bKp) {
            i = this.bKp;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bKo + " and " + this.bKp).showToast();
        }
        this.zE = i;
        this.bKh.setCurrentItem(this.zE - this.bKo);
    }

    public int getMonth() {
        return this.zE;
    }

    public void setDay(int i) {
        if (i < this.bKr || i > this.bKs) {
            i = this.bKr;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bKr + " and " + this.bKs).showToast();
        } else if (i > this.bKs) {
            i = this.bKs;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bKr + " and " + this.bKs).showToastBottom();
        }
        this.zF = i;
        this.bKi.setCurrentItem(this.zF - this.bKr);
    }

    public int getDay() {
        return this.zF;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.bKk = date;
            this.bKm = this.bKk.getYear() + 1900;
            return;
        }
        this.bKm = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.bKl = date;
            this.bKn = this.bKl.getYear() + 1900;
            return;
        }
        this.bKn = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.bKt = str;
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
                    this.bKg.setGravity(17);
                    this.bKh.setVisibility(8);
                    this.bKi.setVisibility(8);
                    return;
                case 1:
                    this.bKg.setGravity(5);
                    this.bKg.setGravityOffset(this.bKv);
                    this.bKh.setGravity(3);
                    this.bKh.setGravityOffset(this.bKv);
                    this.bKh.setVisibility(0);
                    this.bKi.setVisibility(8);
                    return;
                default:
                    this.bKg.setGravity(5);
                    this.bKg.setGravityOffset(this.bKv);
                    this.bKi.setGravity(3);
                    this.bKi.setGravityOffset(this.bKv);
                    this.bKh.setVisibility(0);
                    this.bKi.setVisibility(0);
                    return;
            }
        }
    }

    public boolean kB(String str) {
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
                wheelView3d = this.bKg;
                break;
            case 1:
                wheelView3d = this.bKh;
                break;
            case 2:
                wheelView3d = this.bKi;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.bKu = z;
        this.bKg.setIsOptions(z);
        this.bKh.setIsOptions(z);
        this.bKi.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.bKh.setCyclic(z);
        this.bKg.setCyclic(z);
        this.bKi.setCyclic(z);
    }
}
