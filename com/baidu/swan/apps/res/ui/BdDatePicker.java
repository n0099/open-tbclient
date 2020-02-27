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
    private WheelView3d bJT;
    private WheelView3d bJU;
    private WheelView3d bJV;
    private a bJW;
    private Date bJX;
    private Date bJY;
    private int bJZ;
    private int bKa;
    private int bKb;
    private int bKc;
    private int bKd;
    private int bKe;
    private int bKf;
    private String bKg;
    private boolean bKh;
    private int bKi;
    private int bKj;
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
        this.bJZ = 1900;
        this.bKa = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKb = 1;
        this.bKc = 12;
        this.bKd = 31;
        this.bKe = 1;
        this.bKf = this.bKd;
        this.bKi = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zD = 1900;
        this.zE = 1;
        this.zF = 1;
        this.bJZ = 1900;
        this.bKa = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKb = 1;
        this.bKc = 12;
        this.bKd = 31;
        this.bKe = 1;
        this.bKf = this.bKd;
        this.bKi = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zD = 1900;
        this.zE = 1;
        this.zF = 1;
        this.bJZ = 1900;
        this.bKa = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bKb = 1;
        this.bKc = 12;
        this.bKd = 31;
        this.bKe = 1;
        this.bKf = this.bKd;
        this.bKi = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.bKi = af.S(this.bKi);
        this.mTextSize = af.S(16.0f);
        this.bKj = af.S(14.0f);
        this.bJT = (WheelView3d) findViewById(a.f.wheel_year);
        this.bJT.setCenterTextSize(this.mTextSize);
        this.bJT.setOuterTextSize(this.bKj);
        this.bJT.setLineSpacingMultiplier(3.0f);
        this.bJT.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bJT.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bJT.setDividerType(WheelView3d.DividerType.FILL);
        this.bJT.setVisibleItem(7);
        this.bJT.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zD = BdDatePicker.this.bJZ + i;
                BdDatePicker.this.abD();
                BdDatePicker.this.abE();
            }
        });
        this.bJU = (WheelView3d) findViewById(a.f.wheel_month);
        this.bJU.setCenterTextSize(this.mTextSize);
        this.bJU.setOuterTextSize(this.bKj);
        this.bJU.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bJU.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bJU.setLineSpacingMultiplier(3.0f);
        this.bJU.setDividerType(WheelView3d.DividerType.FILL);
        this.bJU.setVisibleItem(7);
        this.bJU.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zE = BdDatePicker.this.bKb + i;
                BdDatePicker.this.abE();
            }
        });
        this.bJV = (WheelView3d) findViewById(a.f.wheel_day);
        this.bJV.setCenterTextSize(this.mTextSize);
        this.bJV.setOuterTextSize(this.bKj);
        this.bJV.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bJV.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bJV.setLineSpacingMultiplier(3.0f);
        this.bJV.setDividerType(WheelView3d.DividerType.FILL);
        this.bJV.setVisibleItem(7);
        this.bJV.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zF = BdDatePicker.this.bKe + i;
            }
        });
        abA();
    }

    private void abA() {
        Calendar calendar = Calendar.getInstance();
        this.zD = calendar.get(1);
        this.zE = calendar.get(2) + 1;
        this.zF = calendar.get(5);
        abB();
    }

    public void abB() {
        abC();
        abD();
        abE();
    }

    private void abC() {
        if (this.zD < this.bJZ || this.zD > this.bKa) {
            this.zD = this.bJZ;
        }
        this.bJT.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bJZ, this.bKa));
        a(this.bJT, this.bJZ, this.bKa);
    }

    public void abD() {
        this.bKb = 1;
        this.bKc = 12;
        if (this.bJX != null && this.zD == this.bJZ) {
            this.bKb = this.bJX.getMonth() + 1;
        }
        if (this.bJY != null && this.zD == this.bKa) {
            this.bKc = this.bJY.getMonth() + 1;
        }
        this.bJU.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKb, this.bKc));
        a(this.bJU, this.bKb, this.bKc);
        setMonth(this.zE);
    }

    public void abE() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.zE) >= 0) {
            this.bKd = 31;
        } else if (Arrays.binarySearch(iArr, this.zE) >= 0) {
            this.bKd = 30;
        } else if ((this.zD % 4 == 0 && this.zD % 100 != 0) || this.zD % 400 == 0) {
            this.bKd = 29;
        } else {
            this.bKd = 28;
        }
        this.bKe = 1;
        this.bKf = this.bKd;
        if (this.bJX != null && this.zD == this.bJZ && this.zE == this.bJX.getMonth() + 1) {
            this.bKe = this.bJX.getDate();
        }
        if (this.bJY != null && this.zD == this.bKa && this.zE == this.bJY.getMonth() + 1) {
            this.bKf = this.bJY.getDate();
        }
        this.bJV.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bKe, this.bKf));
        a(this.bJV, this.bKe, this.bKf);
        setDay(this.zF);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bJW = aVar;
    }

    public void setYear(int i) {
        if (i < this.bJZ) {
            i = this.bJZ;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bJZ + " and " + this.bKa).showToastBottom();
        } else if (i > this.bKa) {
            i = this.bKa;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bJZ + " and " + this.bKa).showToast();
        }
        this.zD = i;
        this.bJT.setCurrentItem(this.zD - this.bJZ);
    }

    public int getYear() {
        return this.zD;
    }

    public void setMonth(int i) {
        if (i < this.bKb) {
            i = this.bKb;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bKb + " and " + this.bKc).showToastBottom();
        } else if (i > this.bKc) {
            i = this.bKc;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bKb + " and " + this.bKc).showToast();
        }
        this.zE = i;
        this.bJU.setCurrentItem(this.zE - this.bKb);
    }

    public int getMonth() {
        return this.zE;
    }

    public void setDay(int i) {
        if (i < this.bKe || i > this.bKf) {
            i = this.bKe;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bKe + " and " + this.bKf).showToast();
        } else if (i > this.bKf) {
            i = this.bKf;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bKe + " and " + this.bKf).showToastBottom();
        }
        this.zF = i;
        this.bJV.setCurrentItem(this.zF - this.bKe);
    }

    public int getDay() {
        return this.zF;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.bJX = date;
            this.bJZ = this.bJX.getYear() + 1900;
            return;
        }
        this.bJZ = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.bJY = date;
            this.bKa = this.bJY.getYear() + 1900;
            return;
        }
        this.bKa = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.bKg = str;
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
                    this.bJT.setGravity(17);
                    this.bJU.setVisibility(8);
                    this.bJV.setVisibility(8);
                    return;
                case 1:
                    this.bJT.setGravity(5);
                    this.bJT.setGravityOffset(this.bKi);
                    this.bJU.setGravity(3);
                    this.bJU.setGravityOffset(this.bKi);
                    this.bJU.setVisibility(0);
                    this.bJV.setVisibility(8);
                    return;
                default:
                    this.bJT.setGravity(5);
                    this.bJT.setGravityOffset(this.bKi);
                    this.bJV.setGravity(3);
                    this.bJV.setGravityOffset(this.bKi);
                    this.bJU.setVisibility(0);
                    this.bJV.setVisibility(0);
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
                wheelView3d = this.bJT;
                break;
            case 1:
                wheelView3d = this.bJU;
                break;
            case 2:
                wheelView3d = this.bJV;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.bKh = z;
        this.bJT.setIsOptions(z);
        this.bJU.setIsOptions(z);
        this.bJV.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.bJU.setCyclic(z);
        this.bJT.setCyclic(z);
        this.bJV.setCyclic(z);
    }
}
