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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes11.dex */
public class BdDatePicker extends LinearLayout {
    private int SQ;
    private int SR;
    private int SS;
    private WheelView3d ciQ;
    private WheelView3d ciR;
    private WheelView3d ciS;
    private a ciT;
    private Date ciU;
    private Date ciV;
    private int ciW;
    private int ciX;
    private int ciY;
    private int ciZ;
    private int cja;
    private int cjb;
    private int cjc;
    private String cjd;
    private boolean cje;
    private int cjf;
    private int cjg;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.SQ = FeatureCodes.SKY_SEG;
        this.SR = 1;
        this.SS = 1;
        this.ciW = FeatureCodes.SKY_SEG;
        this.ciX = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.ciY = 1;
        this.ciZ = 12;
        this.cja = 31;
        this.cjb = 1;
        this.cjc = this.cja;
        this.cjf = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SQ = FeatureCodes.SKY_SEG;
        this.SR = 1;
        this.SS = 1;
        this.ciW = FeatureCodes.SKY_SEG;
        this.ciX = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.ciY = 1;
        this.ciZ = 12;
        this.cja = 31;
        this.cjb = 1;
        this.cjc = this.cja;
        this.cjf = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.SQ = FeatureCodes.SKY_SEG;
        this.SR = 1;
        this.SS = 1;
        this.ciW = FeatureCodes.SKY_SEG;
        this.ciX = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.ciY = 1;
        this.ciZ = 12;
        this.cja = 31;
        this.cjb = 1;
        this.cjc = this.cja;
        this.cjf = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.cjf = af.C(this.cjf);
        this.mTextSize = af.C(16.0f);
        this.cjg = af.C(14.0f);
        this.ciQ = (WheelView3d) findViewById(a.f.wheel_year);
        this.ciQ.setCenterTextSize(this.mTextSize);
        this.ciQ.setOuterTextSize(this.cjg);
        this.ciQ.setLineSpacingMultiplier(3.0f);
        this.ciQ.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.ciQ.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.ciQ.setDividerType(WheelView3d.DividerType.FILL);
        this.ciQ.setVisibleItem(7);
        this.ciQ.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.SQ = BdDatePicker.this.ciW + i;
                BdDatePicker.this.ajN();
                BdDatePicker.this.ajO();
            }
        });
        this.ciR = (WheelView3d) findViewById(a.f.wheel_month);
        this.ciR.setCenterTextSize(this.mTextSize);
        this.ciR.setOuterTextSize(this.cjg);
        this.ciR.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.ciR.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.ciR.setLineSpacingMultiplier(3.0f);
        this.ciR.setDividerType(WheelView3d.DividerType.FILL);
        this.ciR.setVisibleItem(7);
        this.ciR.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.SR = BdDatePicker.this.ciY + i;
                BdDatePicker.this.ajO();
            }
        });
        this.ciS = (WheelView3d) findViewById(a.f.wheel_day);
        this.ciS.setCenterTextSize(this.mTextSize);
        this.ciS.setOuterTextSize(this.cjg);
        this.ciS.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.ciS.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.ciS.setLineSpacingMultiplier(3.0f);
        this.ciS.setDividerType(WheelView3d.DividerType.FILL);
        this.ciS.setVisibleItem(7);
        this.ciS.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.SS = BdDatePicker.this.cjb + i;
            }
        });
        ajK();
    }

    private void ajK() {
        Calendar calendar = Calendar.getInstance();
        this.SQ = calendar.get(1);
        this.SR = calendar.get(2) + 1;
        this.SS = calendar.get(5);
        ajL();
    }

    public void ajL() {
        ajM();
        ajN();
        ajO();
    }

    private void ajM() {
        if (this.SQ < this.ciW || this.SQ > this.ciX) {
            this.SQ = this.ciW;
        }
        this.ciQ.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.ciW, this.ciX));
        a(this.ciQ, this.ciW, this.ciX);
    }

    public void ajN() {
        this.ciY = 1;
        this.ciZ = 12;
        if (this.ciU != null && this.SQ == this.ciW) {
            this.ciY = this.ciU.getMonth() + 1;
        }
        if (this.ciV != null && this.SQ == this.ciX) {
            this.ciZ = this.ciV.getMonth() + 1;
        }
        this.ciR.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.ciY, this.ciZ));
        a(this.ciR, this.ciY, this.ciZ);
        setMonth(this.SR);
    }

    public void ajO() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.SR) >= 0) {
            this.cja = 31;
        } else if (Arrays.binarySearch(iArr, this.SR) >= 0) {
            this.cja = 30;
        } else if ((this.SQ % 4 == 0 && this.SQ % 100 != 0) || this.SQ % 400 == 0) {
            this.cja = 29;
        } else {
            this.cja = 28;
        }
        this.cjb = 1;
        this.cjc = this.cja;
        if (this.ciU != null && this.SQ == this.ciW && this.SR == this.ciU.getMonth() + 1) {
            this.cjb = this.ciU.getDate();
        }
        if (this.ciV != null && this.SQ == this.ciX && this.SR == this.ciV.getMonth() + 1) {
            this.cjc = this.ciV.getDate();
        }
        this.ciS.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cjb, this.cjc));
        a(this.ciS, this.cjb, this.cjc);
        setDay(this.SS);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.ciT = aVar;
    }

    public void setYear(int i) {
        if (i < this.ciW) {
            i = this.ciW;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.ciW + " and " + this.ciX).showToastBottom();
        } else if (i > this.ciX) {
            i = this.ciX;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.ciW + " and " + this.ciX).showToast();
        }
        this.SQ = i;
        this.ciQ.setCurrentItem(this.SQ - this.ciW);
    }

    public int getYear() {
        return this.SQ;
    }

    public void setMonth(int i) {
        if (i < this.ciY) {
            i = this.ciY;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.ciY + " and " + this.ciZ).showToastBottom();
        } else if (i > this.ciZ) {
            i = this.ciZ;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.ciY + " and " + this.ciZ).showToast();
        }
        this.SR = i;
        this.ciR.setCurrentItem(this.SR - this.ciY);
    }

    public int getMonth() {
        return this.SR;
    }

    public void setDay(int i) {
        if (i < this.cjb || i > this.cjc) {
            i = this.cjb;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cjb + " and " + this.cjc).showToast();
        } else if (i > this.cjc) {
            i = this.cjc;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cjb + " and " + this.cjc).showToastBottom();
        }
        this.SS = i;
        this.ciS.setCurrentItem(this.SS - this.cjb);
    }

    public int getDay() {
        return this.SS;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.ciU = date;
            this.ciW = this.ciU.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.ciW = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.ciV = date;
            this.ciX = this.ciV.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.ciX = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.cjd = str;
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
                    this.ciQ.setGravity(17);
                    this.ciR.setVisibility(8);
                    this.ciS.setVisibility(8);
                    return;
                case 1:
                    this.ciQ.setGravity(5);
                    this.ciQ.setGravityOffset(this.cjf);
                    this.ciR.setGravity(3);
                    this.ciR.setGravityOffset(this.cjf);
                    this.ciR.setVisibility(0);
                    this.ciS.setVisibility(8);
                    return;
                default:
                    this.ciQ.setGravity(5);
                    this.ciQ.setGravityOffset(this.cjf);
                    this.ciS.setGravity(3);
                    this.ciS.setGravityOffset(this.cjf);
                    this.ciR.setVisibility(0);
                    this.ciS.setVisibility(0);
                    return;
            }
        }
    }

    public boolean lO(String str) {
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
                wheelView3d = this.ciQ;
                break;
            case 1:
                wheelView3d = this.ciR;
                break;
            case 2:
                wheelView3d = this.ciS;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.cje = z;
        this.ciQ.setIsOptions(z);
        this.ciR.setIsOptions(z);
        this.ciS.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.ciR.setCyclic(z);
        this.ciQ.setCyclic(z);
        this.ciS.setCyclic(z);
    }
}
