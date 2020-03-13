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
    private WheelView3d bJV;
    private WheelView3d bJW;
    private WheelView3d bJX;
    private a bJY;
    private Date bJZ;
    private Date bKa;
    private int bKb;
    private int bKc;
    private int bKd;
    private int bKe;
    private int bKf;
    private int bKg;
    private int bKh;
    private String bKi;
    private boolean bKj;
    private int bKk;
    private int bKl;
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
        this.bKb = 1900;
        this.bKc = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKd = 1;
        this.bKe = 12;
        this.bKf = 31;
        this.bKg = 1;
        this.bKh = this.bKf;
        this.bKk = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zD = 1900;
        this.zE = 1;
        this.zF = 1;
        this.bKb = 1900;
        this.bKc = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKd = 1;
        this.bKe = 12;
        this.bKf = 31;
        this.bKg = 1;
        this.bKh = this.bKf;
        this.bKk = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zD = 1900;
        this.zE = 1;
        this.zF = 1;
        this.bKb = 1900;
        this.bKc = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKd = 1;
        this.bKe = 12;
        this.bKf = 31;
        this.bKg = 1;
        this.bKh = this.bKf;
        this.bKk = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.bKk = af.S(this.bKk);
        this.mTextSize = af.S(16.0f);
        this.bKl = af.S(14.0f);
        this.bJV = (WheelView3d) findViewById(a.f.wheel_year);
        this.bJV.setCenterTextSize(this.mTextSize);
        this.bJV.setOuterTextSize(this.bKl);
        this.bJV.setLineSpacingMultiplier(3.0f);
        this.bJV.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bJV.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bJV.setDividerType(WheelView3d.DividerType.FILL);
        this.bJV.setVisibleItem(7);
        this.bJV.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zD = BdDatePicker.this.bKb + i;
                BdDatePicker.this.abF();
                BdDatePicker.this.abG();
            }
        });
        this.bJW = (WheelView3d) findViewById(a.f.wheel_month);
        this.bJW.setCenterTextSize(this.mTextSize);
        this.bJW.setOuterTextSize(this.bKl);
        this.bJW.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bJW.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bJW.setLineSpacingMultiplier(3.0f);
        this.bJW.setDividerType(WheelView3d.DividerType.FILL);
        this.bJW.setVisibleItem(7);
        this.bJW.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zE = BdDatePicker.this.bKd + i;
                BdDatePicker.this.abG();
            }
        });
        this.bJX = (WheelView3d) findViewById(a.f.wheel_day);
        this.bJX.setCenterTextSize(this.mTextSize);
        this.bJX.setOuterTextSize(this.bKl);
        this.bJX.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bJX.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bJX.setLineSpacingMultiplier(3.0f);
        this.bJX.setDividerType(WheelView3d.DividerType.FILL);
        this.bJX.setVisibleItem(7);
        this.bJX.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zF = BdDatePicker.this.bKg + i;
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
        if (this.zD < this.bKb || this.zD > this.bKc) {
            this.zD = this.bKb;
        }
        this.bJV.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKb, this.bKc));
        a(this.bJV, this.bKb, this.bKc);
    }

    public void abF() {
        this.bKd = 1;
        this.bKe = 12;
        if (this.bJZ != null && this.zD == this.bKb) {
            this.bKd = this.bJZ.getMonth() + 1;
        }
        if (this.bKa != null && this.zD == this.bKc) {
            this.bKe = this.bKa.getMonth() + 1;
        }
        this.bJW.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKd, this.bKe));
        a(this.bJW, this.bKd, this.bKe);
        setMonth(this.zE);
    }

    public void abG() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.zE) >= 0) {
            this.bKf = 31;
        } else if (Arrays.binarySearch(iArr, this.zE) >= 0) {
            this.bKf = 30;
        } else if ((this.zD % 4 == 0 && this.zD % 100 != 0) || this.zD % 400 == 0) {
            this.bKf = 29;
        } else {
            this.bKf = 28;
        }
        this.bKg = 1;
        this.bKh = this.bKf;
        if (this.bJZ != null && this.zD == this.bKb && this.zE == this.bJZ.getMonth() + 1) {
            this.bKg = this.bJZ.getDate();
        }
        if (this.bKa != null && this.zD == this.bKc && this.zE == this.bKa.getMonth() + 1) {
            this.bKh = this.bKa.getDate();
        }
        this.bJX.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKg, this.bKh));
        a(this.bJX, this.bKg, this.bKh);
        setDay(this.zF);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bJY = aVar;
    }

    public void setYear(int i) {
        if (i < this.bKb) {
            i = this.bKb;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bKb + " and " + this.bKc).showToastBottom();
        } else if (i > this.bKc) {
            i = this.bKc;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bKb + " and " + this.bKc).showToast();
        }
        this.zD = i;
        this.bJV.setCurrentItem(this.zD - this.bKb);
    }

    public int getYear() {
        return this.zD;
    }

    public void setMonth(int i) {
        if (i < this.bKd) {
            i = this.bKd;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bKd + " and " + this.bKe).showToastBottom();
        } else if (i > this.bKe) {
            i = this.bKe;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bKd + " and " + this.bKe).showToast();
        }
        this.zE = i;
        this.bJW.setCurrentItem(this.zE - this.bKd);
    }

    public int getMonth() {
        return this.zE;
    }

    public void setDay(int i) {
        if (i < this.bKg || i > this.bKh) {
            i = this.bKg;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bKg + " and " + this.bKh).showToast();
        } else if (i > this.bKh) {
            i = this.bKh;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bKg + " and " + this.bKh).showToastBottom();
        }
        this.zF = i;
        this.bJX.setCurrentItem(this.zF - this.bKg);
    }

    public int getDay() {
        return this.zF;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.bJZ = date;
            this.bKb = this.bJZ.getYear() + 1900;
            return;
        }
        this.bKb = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.bKa = date;
            this.bKc = this.bKa.getYear() + 1900;
            return;
        }
        this.bKc = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.bKi = str;
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
                    this.bJV.setGravity(17);
                    this.bJW.setVisibility(8);
                    this.bJX.setVisibility(8);
                    return;
                case 1:
                    this.bJV.setGravity(5);
                    this.bJV.setGravityOffset(this.bKk);
                    this.bJW.setGravity(3);
                    this.bJW.setGravityOffset(this.bKk);
                    this.bJW.setVisibility(0);
                    this.bJX.setVisibility(8);
                    return;
                default:
                    this.bJV.setGravity(5);
                    this.bJV.setGravityOffset(this.bKk);
                    this.bJX.setGravity(3);
                    this.bJX.setGravityOffset(this.bKk);
                    this.bJW.setVisibility(0);
                    this.bJX.setVisibility(0);
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
                wheelView3d = this.bJV;
                break;
            case 1:
                wheelView3d = this.bJW;
                break;
            case 2:
                wheelView3d = this.bJX;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.bKj = z;
        this.bJV.setIsOptions(z);
        this.bJW.setIsOptions(z);
        this.bJX.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.bJW.setCyclic(z);
        this.bJV.setCyclic(z);
        this.bJX.setCyclic(z);
    }
}
