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
/* loaded from: classes10.dex */
public class BdDatePicker extends LinearLayout {
    private WheelView3d bFO;
    private WheelView3d bFP;
    private WheelView3d bFQ;
    private a bFR;
    private Date bFS;
    private Date bFT;
    private int bFU;
    private int bFV;
    private int bFW;
    private int bFX;
    private int bFY;
    private int bFZ;
    private int bGa;
    private String bGb;
    private boolean bGc;
    private int bGd;
    private int bGe;
    private int mTextSize;
    private int zl;
    private int zm;
    private int zn;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.zl = 1900;
        this.zm = 1;
        this.zn = 1;
        this.bFU = 1900;
        this.bFV = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bFW = 1;
        this.bFX = 12;
        this.bFY = 31;
        this.bFZ = 1;
        this.bGa = this.bFY;
        this.bGd = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zl = 1900;
        this.zm = 1;
        this.zn = 1;
        this.bFU = 1900;
        this.bFV = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bFW = 1;
        this.bFX = 12;
        this.bFY = 31;
        this.bFZ = 1;
        this.bGa = this.bFY;
        this.bGd = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zl = 1900;
        this.zm = 1;
        this.zn = 1;
        this.bFU = 1900;
        this.bFV = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bFW = 1;
        this.bFX = 12;
        this.bFY = 31;
        this.bFZ = 1;
        this.bGa = this.bFY;
        this.bGd = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.bGd = af.S(this.bGd);
        this.mTextSize = af.S(16.0f);
        this.bGe = af.S(14.0f);
        this.bFO = (WheelView3d) findViewById(a.f.wheel_year);
        this.bFO.setCenterTextSize(this.mTextSize);
        this.bFO.setOuterTextSize(this.bGe);
        this.bFO.setLineSpacingMultiplier(3.0f);
        this.bFO.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bFO.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bFO.setDividerType(WheelView3d.DividerType.FILL);
        this.bFO.setVisibleItem(7);
        this.bFO.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zl = BdDatePicker.this.bFU + i;
                BdDatePicker.this.Zp();
                BdDatePicker.this.Zq();
            }
        });
        this.bFP = (WheelView3d) findViewById(a.f.wheel_month);
        this.bFP.setCenterTextSize(this.mTextSize);
        this.bFP.setOuterTextSize(this.bGe);
        this.bFP.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bFP.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bFP.setLineSpacingMultiplier(3.0f);
        this.bFP.setDividerType(WheelView3d.DividerType.FILL);
        this.bFP.setVisibleItem(7);
        this.bFP.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zm = BdDatePicker.this.bFW + i;
                BdDatePicker.this.Zq();
            }
        });
        this.bFQ = (WheelView3d) findViewById(a.f.wheel_day);
        this.bFQ.setCenterTextSize(this.mTextSize);
        this.bFQ.setOuterTextSize(this.bGe);
        this.bFQ.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bFQ.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bFQ.setLineSpacingMultiplier(3.0f);
        this.bFQ.setDividerType(WheelView3d.DividerType.FILL);
        this.bFQ.setVisibleItem(7);
        this.bFQ.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zn = BdDatePicker.this.bFZ + i;
            }
        });
        Zm();
    }

    private void Zm() {
        Calendar calendar = Calendar.getInstance();
        this.zl = calendar.get(1);
        this.zm = calendar.get(2) + 1;
        this.zn = calendar.get(5);
        Zn();
    }

    public void Zn() {
        Zo();
        Zp();
        Zq();
    }

    private void Zo() {
        if (this.zl < this.bFU || this.zl > this.bFV) {
            this.zl = this.bFU;
        }
        this.bFO.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bFU, this.bFV));
        a(this.bFO, this.bFU, this.bFV);
    }

    public void Zp() {
        this.bFW = 1;
        this.bFX = 12;
        if (this.bFS != null && this.zl == this.bFU) {
            this.bFW = this.bFS.getMonth() + 1;
        }
        if (this.bFT != null && this.zl == this.bFV) {
            this.bFX = this.bFT.getMonth() + 1;
        }
        this.bFP.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bFW, this.bFX));
        a(this.bFP, this.bFW, this.bFX);
        setMonth(this.zm);
    }

    public void Zq() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.zm) >= 0) {
            this.bFY = 31;
        } else if (Arrays.binarySearch(iArr, this.zm) >= 0) {
            this.bFY = 30;
        } else if ((this.zl % 4 == 0 && this.zl % 100 != 0) || this.zl % 400 == 0) {
            this.bFY = 29;
        } else {
            this.bFY = 28;
        }
        this.bFZ = 1;
        this.bGa = this.bFY;
        if (this.bFS != null && this.zl == this.bFU && this.zm == this.bFS.getMonth() + 1) {
            this.bFZ = this.bFS.getDate();
        }
        if (this.bFT != null && this.zl == this.bFV && this.zm == this.bFT.getMonth() + 1) {
            this.bGa = this.bFT.getDate();
        }
        this.bFQ.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bFZ, this.bGa));
        a(this.bFQ, this.bFZ, this.bGa);
        setDay(this.zn);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bFR = aVar;
    }

    public void setYear(int i) {
        if (i < this.bFU) {
            i = this.bFU;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bFU + " and " + this.bFV).showToastBottom();
        } else if (i > this.bFV) {
            i = this.bFV;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bFU + " and " + this.bFV).showToast();
        }
        this.zl = i;
        this.bFO.setCurrentItem(this.zl - this.bFU);
    }

    public int getYear() {
        return this.zl;
    }

    public void setMonth(int i) {
        if (i < this.bFW) {
            i = this.bFW;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bFW + " and " + this.bFX).showToastBottom();
        } else if (i > this.bFX) {
            i = this.bFX;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bFW + " and " + this.bFX).showToast();
        }
        this.zm = i;
        this.bFP.setCurrentItem(this.zm - this.bFW);
    }

    public int getMonth() {
        return this.zm;
    }

    public void setDay(int i) {
        if (i < this.bFZ || i > this.bGa) {
            i = this.bFZ;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bFZ + " and " + this.bGa).showToast();
        } else if (i > this.bGa) {
            i = this.bGa;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bFZ + " and " + this.bGa).showToastBottom();
        }
        this.zn = i;
        this.bFQ.setCurrentItem(this.zn - this.bFZ);
    }

    public int getDay() {
        return this.zn;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.bFS = date;
            this.bFU = this.bFS.getYear() + 1900;
            return;
        }
        this.bFU = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.bFT = date;
            this.bFV = this.bFT.getYear() + 1900;
            return;
        }
        this.bFV = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.bGb = str;
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
                    this.bFO.setGravity(17);
                    this.bFP.setVisibility(8);
                    this.bFQ.setVisibility(8);
                    return;
                case 1:
                    this.bFO.setGravity(5);
                    this.bFO.setGravityOffset(this.bGd);
                    this.bFP.setGravity(3);
                    this.bFP.setGravityOffset(this.bGd);
                    this.bFP.setVisibility(0);
                    this.bFQ.setVisibility(8);
                    return;
                default:
                    this.bFO.setGravity(5);
                    this.bFO.setGravityOffset(this.bGd);
                    this.bFQ.setGravity(3);
                    this.bFQ.setGravityOffset(this.bGd);
                    this.bFP.setVisibility(0);
                    this.bFQ.setVisibility(0);
                    return;
            }
        }
    }

    public boolean kn(String str) {
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
                wheelView3d = this.bFO;
                break;
            case 1:
                wheelView3d = this.bFP;
                break;
            case 2:
                wheelView3d = this.bFQ;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.bGc = z;
        this.bFO.setIsOptions(z);
        this.bFP.setIsOptions(z);
        this.bFQ.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.bFP.setCyclic(z);
        this.bFO.setCyclic(z);
        this.bFQ.setCyclic(z);
    }
}
