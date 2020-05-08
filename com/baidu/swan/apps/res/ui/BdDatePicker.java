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
    private int ST;
    private int SU;
    private int SV;
    private WheelView3d ciW;
    private WheelView3d ciX;
    private WheelView3d ciY;
    private a ciZ;
    private Date cja;
    private Date cjb;
    private int cjc;
    private int cjd;
    private int cje;
    private int cjf;
    private int cjg;
    private int cjh;
    private int cji;
    private String cjj;
    private boolean cjk;
    private int cjl;
    private int cjm;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.ST = FeatureCodes.SKY_SEG;
        this.SU = 1;
        this.SV = 1;
        this.cjc = FeatureCodes.SKY_SEG;
        this.cjd = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.cje = 1;
        this.cjf = 12;
        this.cjg = 31;
        this.cjh = 1;
        this.cji = this.cjg;
        this.cjl = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ST = FeatureCodes.SKY_SEG;
        this.SU = 1;
        this.SV = 1;
        this.cjc = FeatureCodes.SKY_SEG;
        this.cjd = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.cje = 1;
        this.cjf = 12;
        this.cjg = 31;
        this.cjh = 1;
        this.cji = this.cjg;
        this.cjl = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ST = FeatureCodes.SKY_SEG;
        this.SU = 1;
        this.SV = 1;
        this.cjc = FeatureCodes.SKY_SEG;
        this.cjd = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.cje = 1;
        this.cjf = 12;
        this.cjg = 31;
        this.cjh = 1;
        this.cji = this.cjg;
        this.cjl = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.cjl = af.C(this.cjl);
        this.mTextSize = af.C(16.0f);
        this.cjm = af.C(14.0f);
        this.ciW = (WheelView3d) findViewById(a.f.wheel_year);
        this.ciW.setCenterTextSize(this.mTextSize);
        this.ciW.setOuterTextSize(this.cjm);
        this.ciW.setLineSpacingMultiplier(3.0f);
        this.ciW.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.ciW.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.ciW.setDividerType(WheelView3d.DividerType.FILL);
        this.ciW.setVisibleItem(7);
        this.ciW.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.ST = BdDatePicker.this.cjc + i;
                BdDatePicker.this.ajM();
                BdDatePicker.this.ajN();
            }
        });
        this.ciX = (WheelView3d) findViewById(a.f.wheel_month);
        this.ciX.setCenterTextSize(this.mTextSize);
        this.ciX.setOuterTextSize(this.cjm);
        this.ciX.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.ciX.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.ciX.setLineSpacingMultiplier(3.0f);
        this.ciX.setDividerType(WheelView3d.DividerType.FILL);
        this.ciX.setVisibleItem(7);
        this.ciX.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.SU = BdDatePicker.this.cje + i;
                BdDatePicker.this.ajN();
            }
        });
        this.ciY = (WheelView3d) findViewById(a.f.wheel_day);
        this.ciY.setCenterTextSize(this.mTextSize);
        this.ciY.setOuterTextSize(this.cjm);
        this.ciY.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.ciY.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.ciY.setLineSpacingMultiplier(3.0f);
        this.ciY.setDividerType(WheelView3d.DividerType.FILL);
        this.ciY.setVisibleItem(7);
        this.ciY.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.SV = BdDatePicker.this.cjh + i;
            }
        });
        ajJ();
    }

    private void ajJ() {
        Calendar calendar = Calendar.getInstance();
        this.ST = calendar.get(1);
        this.SU = calendar.get(2) + 1;
        this.SV = calendar.get(5);
        ajK();
    }

    public void ajK() {
        ajL();
        ajM();
        ajN();
    }

    private void ajL() {
        if (this.ST < this.cjc || this.ST > this.cjd) {
            this.ST = this.cjc;
        }
        this.ciW.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cjc, this.cjd));
        a(this.ciW, this.cjc, this.cjd);
    }

    public void ajM() {
        this.cje = 1;
        this.cjf = 12;
        if (this.cja != null && this.ST == this.cjc) {
            this.cje = this.cja.getMonth() + 1;
        }
        if (this.cjb != null && this.ST == this.cjd) {
            this.cjf = this.cjb.getMonth() + 1;
        }
        this.ciX.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cje, this.cjf));
        a(this.ciX, this.cje, this.cjf);
        setMonth(this.SU);
    }

    public void ajN() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.SU) >= 0) {
            this.cjg = 31;
        } else if (Arrays.binarySearch(iArr, this.SU) >= 0) {
            this.cjg = 30;
        } else if ((this.ST % 4 == 0 && this.ST % 100 != 0) || this.ST % 400 == 0) {
            this.cjg = 29;
        } else {
            this.cjg = 28;
        }
        this.cjh = 1;
        this.cji = this.cjg;
        if (this.cja != null && this.ST == this.cjc && this.SU == this.cja.getMonth() + 1) {
            this.cjh = this.cja.getDate();
        }
        if (this.cjb != null && this.ST == this.cjd && this.SU == this.cjb.getMonth() + 1) {
            this.cji = this.cjb.getDate();
        }
        this.ciY.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.cjh, this.cji));
        a(this.ciY, this.cjh, this.cji);
        setDay(this.SV);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.ciZ = aVar;
    }

    public void setYear(int i) {
        if (i < this.cjc) {
            i = this.cjc;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cjc + " and " + this.cjd).showToastBottom();
        } else if (i > this.cjd) {
            i = this.cjd;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.cjc + " and " + this.cjd).showToast();
        }
        this.ST = i;
        this.ciW.setCurrentItem(this.ST - this.cjc);
    }

    public int getYear() {
        return this.ST;
    }

    public void setMonth(int i) {
        if (i < this.cje) {
            i = this.cje;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cje + " and " + this.cjf).showToastBottom();
        } else if (i > this.cjf) {
            i = this.cjf;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.cje + " and " + this.cjf).showToast();
        }
        this.SU = i;
        this.ciX.setCurrentItem(this.SU - this.cje);
    }

    public int getMonth() {
        return this.SU;
    }

    public void setDay(int i) {
        if (i < this.cjh || i > this.cji) {
            i = this.cjh;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cjh + " and " + this.cji).showToast();
        } else if (i > this.cji) {
            i = this.cji;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.cjh + " and " + this.cji).showToastBottom();
        }
        this.SV = i;
        this.ciY.setCurrentItem(this.SV - this.cjh);
    }

    public int getDay() {
        return this.SV;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.cja = date;
            this.cjc = this.cja.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cjc = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.cjb = date;
            this.cjd = this.cjb.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.cjd = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.cjj = str;
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
                    this.ciW.setGravity(17);
                    this.ciX.setVisibility(8);
                    this.ciY.setVisibility(8);
                    return;
                case 1:
                    this.ciW.setGravity(5);
                    this.ciW.setGravityOffset(this.cjl);
                    this.ciX.setGravity(3);
                    this.ciX.setGravityOffset(this.cjl);
                    this.ciX.setVisibility(0);
                    this.ciY.setVisibility(8);
                    return;
                default:
                    this.ciW.setGravity(5);
                    this.ciW.setGravityOffset(this.cjl);
                    this.ciY.setGravity(3);
                    this.ciY.setGravityOffset(this.cjl);
                    this.ciX.setVisibility(0);
                    this.ciY.setVisibility(0);
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
                wheelView3d = this.ciW;
                break;
            case 1:
                wheelView3d = this.ciX;
                break;
            case 2:
                wheelView3d = this.ciY;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.cjk = z;
        this.ciW.setIsOptions(z);
        this.ciX.setIsOptions(z);
        this.ciY.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.ciX.setCyclic(z);
        this.ciW.setCyclic(z);
        this.ciY.setCyclic(z);
    }
}
