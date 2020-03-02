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
    private WheelView3d bJU;
    private WheelView3d bJV;
    private WheelView3d bJW;
    private a bJX;
    private Date bJY;
    private Date bJZ;
    private int bKa;
    private int bKb;
    private int bKc;
    private int bKd;
    private int bKe;
    private int bKf;
    private int bKg;
    private String bKh;
    private boolean bKi;
    private int bKj;
    private int bKk;
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
        this.bKa = 1900;
        this.bKb = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKc = 1;
        this.bKd = 12;
        this.bKe = 31;
        this.bKf = 1;
        this.bKg = this.bKe;
        this.bKj = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zD = 1900;
        this.zE = 1;
        this.zF = 1;
        this.bKa = 1900;
        this.bKb = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKc = 1;
        this.bKd = 12;
        this.bKe = 31;
        this.bKf = 1;
        this.bKg = this.bKe;
        this.bKj = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zD = 1900;
        this.zE = 1;
        this.zF = 1;
        this.bKa = 1900;
        this.bKb = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKc = 1;
        this.bKd = 12;
        this.bKe = 31;
        this.bKf = 1;
        this.bKg = this.bKe;
        this.bKj = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.bKj = af.S(this.bKj);
        this.mTextSize = af.S(16.0f);
        this.bKk = af.S(14.0f);
        this.bJU = (WheelView3d) findViewById(a.f.wheel_year);
        this.bJU.setCenterTextSize(this.mTextSize);
        this.bJU.setOuterTextSize(this.bKk);
        this.bJU.setLineSpacingMultiplier(3.0f);
        this.bJU.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bJU.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bJU.setDividerType(WheelView3d.DividerType.FILL);
        this.bJU.setVisibleItem(7);
        this.bJU.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zD = BdDatePicker.this.bKa + i;
                BdDatePicker.this.abF();
                BdDatePicker.this.abG();
            }
        });
        this.bJV = (WheelView3d) findViewById(a.f.wheel_month);
        this.bJV.setCenterTextSize(this.mTextSize);
        this.bJV.setOuterTextSize(this.bKk);
        this.bJV.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bJV.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bJV.setLineSpacingMultiplier(3.0f);
        this.bJV.setDividerType(WheelView3d.DividerType.FILL);
        this.bJV.setVisibleItem(7);
        this.bJV.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zE = BdDatePicker.this.bKc + i;
                BdDatePicker.this.abG();
            }
        });
        this.bJW = (WheelView3d) findViewById(a.f.wheel_day);
        this.bJW.setCenterTextSize(this.mTextSize);
        this.bJW.setOuterTextSize(this.bKk);
        this.bJW.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bJW.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bJW.setLineSpacingMultiplier(3.0f);
        this.bJW.setDividerType(WheelView3d.DividerType.FILL);
        this.bJW.setVisibleItem(7);
        this.bJW.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zF = BdDatePicker.this.bKf + i;
            }
        });
        abC();
    }

    private void abC() {
        Calendar calendar = Calendar.getInstance();
        this.zD = calendar.get(1);
        this.zE = calendar.get(2) + 1;
        this.zF = calendar.get(5);
        abD();
    }

    public void abD() {
        abE();
        abF();
        abG();
    }

    private void abE() {
        if (this.zD < this.bKa || this.zD > this.bKb) {
            this.zD = this.bKa;
        }
        this.bJU.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKa, this.bKb));
        a(this.bJU, this.bKa, this.bKb);
    }

    public void abF() {
        this.bKc = 1;
        this.bKd = 12;
        if (this.bJY != null && this.zD == this.bKa) {
            this.bKc = this.bJY.getMonth() + 1;
        }
        if (this.bJZ != null && this.zD == this.bKb) {
            this.bKd = this.bJZ.getMonth() + 1;
        }
        this.bJV.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKc, this.bKd));
        a(this.bJV, this.bKc, this.bKd);
        setMonth(this.zE);
    }

    public void abG() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.zE) >= 0) {
            this.bKe = 31;
        } else if (Arrays.binarySearch(iArr, this.zE) >= 0) {
            this.bKe = 30;
        } else if ((this.zD % 4 == 0 && this.zD % 100 != 0) || this.zD % 400 == 0) {
            this.bKe = 29;
        } else {
            this.bKe = 28;
        }
        this.bKf = 1;
        this.bKg = this.bKe;
        if (this.bJY != null && this.zD == this.bKa && this.zE == this.bJY.getMonth() + 1) {
            this.bKf = this.bJY.getDate();
        }
        if (this.bJZ != null && this.zD == this.bKb && this.zE == this.bJZ.getMonth() + 1) {
            this.bKg = this.bJZ.getDate();
        }
        this.bJW.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKf, this.bKg));
        a(this.bJW, this.bKf, this.bKg);
        setDay(this.zF);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bJX = aVar;
    }

    public void setYear(int i) {
        if (i < this.bKa) {
            i = this.bKa;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bKa + " and " + this.bKb).showToastBottom();
        } else if (i > this.bKb) {
            i = this.bKb;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bKa + " and " + this.bKb).showToast();
        }
        this.zD = i;
        this.bJU.setCurrentItem(this.zD - this.bKa);
    }

    public int getYear() {
        return this.zD;
    }

    public void setMonth(int i) {
        if (i < this.bKc) {
            i = this.bKc;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bKc + " and " + this.bKd).showToastBottom();
        } else if (i > this.bKd) {
            i = this.bKd;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bKc + " and " + this.bKd).showToast();
        }
        this.zE = i;
        this.bJV.setCurrentItem(this.zE - this.bKc);
    }

    public int getMonth() {
        return this.zE;
    }

    public void setDay(int i) {
        if (i < this.bKf || i > this.bKg) {
            i = this.bKf;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bKf + " and " + this.bKg).showToast();
        } else if (i > this.bKg) {
            i = this.bKg;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bKf + " and " + this.bKg).showToastBottom();
        }
        this.zF = i;
        this.bJW.setCurrentItem(this.zF - this.bKf);
    }

    public int getDay() {
        return this.zF;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.bJY = date;
            this.bKa = this.bJY.getYear() + 1900;
            return;
        }
        this.bKa = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.bJZ = date;
            this.bKb = this.bJZ.getYear() + 1900;
            return;
        }
        this.bKb = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.bKh = str;
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
                    this.bJU.setGravity(17);
                    this.bJV.setVisibility(8);
                    this.bJW.setVisibility(8);
                    return;
                case 1:
                    this.bJU.setGravity(5);
                    this.bJU.setGravityOffset(this.bKj);
                    this.bJV.setGravity(3);
                    this.bJV.setGravityOffset(this.bKj);
                    this.bJV.setVisibility(0);
                    this.bJW.setVisibility(8);
                    return;
                default:
                    this.bJU.setGravity(5);
                    this.bJU.setGravityOffset(this.bKj);
                    this.bJW.setGravity(3);
                    this.bJW.setGravityOffset(this.bKj);
                    this.bJV.setVisibility(0);
                    this.bJW.setVisibility(0);
                    return;
            }
        }
    }

    public boolean kC(String str) {
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
                wheelView3d = this.bJU;
                break;
            case 1:
                wheelView3d = this.bJV;
                break;
            case 2:
                wheelView3d = this.bJW;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.bKi = z;
        this.bJU.setIsOptions(z);
        this.bJV.setIsOptions(z);
        this.bJW.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.bJV.setCyclic(z);
        this.bJU.setCyclic(z);
        this.bJW.setCyclic(z);
    }
}
