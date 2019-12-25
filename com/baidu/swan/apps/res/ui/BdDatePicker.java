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
/* loaded from: classes9.dex */
public class BdDatePicker extends LinearLayout {
    private WheelView3d bFd;
    private WheelView3d bFe;
    private WheelView3d bFf;
    private a bFg;
    private Date bFh;
    private Date bFi;
    private int bFj;
    private int bFk;
    private int bFl;
    private int bFm;
    private int bFn;
    private int bFo;
    private int bFp;
    private String bFq;
    private boolean bFr;
    private int bFs;
    private int bFt;
    private int mTextSize;
    private int zh;
    private int zi;
    private int zj;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.zh = 1900;
        this.zi = 1;
        this.zj = 1;
        this.bFj = 1900;
        this.bFk = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bFl = 1;
        this.bFm = 12;
        this.bFn = 31;
        this.bFo = 1;
        this.bFp = this.bFn;
        this.bFs = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zh = 1900;
        this.zi = 1;
        this.zj = 1;
        this.bFj = 1900;
        this.bFk = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bFl = 1;
        this.bFm = 12;
        this.bFn = 31;
        this.bFo = 1;
        this.bFp = this.bFn;
        this.bFs = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zh = 1900;
        this.zi = 1;
        this.zj = 1;
        this.bFj = 1900;
        this.bFk = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bFl = 1;
        this.bFm = 12;
        this.bFn = 31;
        this.bFo = 1;
        this.bFp = this.bFn;
        this.bFs = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.bFs = af.T(this.bFs);
        this.mTextSize = af.T(16.0f);
        this.bFt = af.T(14.0f);
        this.bFd = (WheelView3d) findViewById(a.f.wheel_year);
        this.bFd.setCenterTextSize(this.mTextSize);
        this.bFd.setOuterTextSize(this.bFt);
        this.bFd.setLineSpacingMultiplier(3.0f);
        this.bFd.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bFd.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bFd.setDividerType(WheelView3d.DividerType.FILL);
        this.bFd.setVisibleItem(7);
        this.bFd.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zh = BdDatePicker.this.bFj + i;
                BdDatePicker.this.YS();
                BdDatePicker.this.YT();
            }
        });
        this.bFe = (WheelView3d) findViewById(a.f.wheel_month);
        this.bFe.setCenterTextSize(this.mTextSize);
        this.bFe.setOuterTextSize(this.bFt);
        this.bFe.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bFe.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bFe.setLineSpacingMultiplier(3.0f);
        this.bFe.setDividerType(WheelView3d.DividerType.FILL);
        this.bFe.setVisibleItem(7);
        this.bFe.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zi = BdDatePicker.this.bFl + i;
                BdDatePicker.this.YT();
            }
        });
        this.bFf = (WheelView3d) findViewById(a.f.wheel_day);
        this.bFf.setCenterTextSize(this.mTextSize);
        this.bFf.setOuterTextSize(this.bFt);
        this.bFf.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.bFf.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.bFf.setLineSpacingMultiplier(3.0f);
        this.bFf.setDividerType(WheelView3d.DividerType.FILL);
        this.bFf.setVisibleItem(7);
        this.bFf.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.zj = BdDatePicker.this.bFo + i;
            }
        });
        YP();
    }

    private void YP() {
        Calendar calendar = Calendar.getInstance();
        this.zh = calendar.get(1);
        this.zi = calendar.get(2) + 1;
        this.zj = calendar.get(5);
        YQ();
    }

    public void YQ() {
        YR();
        YS();
        YT();
    }

    private void YR() {
        if (this.zh < this.bFj || this.zh > this.bFk) {
            this.zh = this.bFj;
        }
        this.bFd.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bFj, this.bFk));
        a(this.bFd, this.bFj, this.bFk);
    }

    public void YS() {
        this.bFl = 1;
        this.bFm = 12;
        if (this.bFh != null && this.zh == this.bFj) {
            this.bFl = this.bFh.getMonth() + 1;
        }
        if (this.bFi != null && this.zh == this.bFk) {
            this.bFm = this.bFi.getMonth() + 1;
        }
        this.bFe.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bFl, this.bFm));
        a(this.bFe, this.bFl, this.bFm);
        setMonth(this.zi);
    }

    public void YT() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.zi) >= 0) {
            this.bFn = 31;
        } else if (Arrays.binarySearch(iArr, this.zi) >= 0) {
            this.bFn = 30;
        } else if ((this.zh % 4 == 0 && this.zh % 100 != 0) || this.zh % 400 == 0) {
            this.bFn = 29;
        } else {
            this.bFn = 28;
        }
        this.bFo = 1;
        this.bFp = this.bFn;
        if (this.bFh != null && this.zh == this.bFj && this.zi == this.bFh.getMonth() + 1) {
            this.bFo = this.bFh.getDate();
        }
        if (this.bFi != null && this.zh == this.bFk && this.zi == this.bFi.getMonth() + 1) {
            this.bFp = this.bFi.getDate();
        }
        this.bFf.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.bFo, this.bFp));
        a(this.bFf, this.bFo, this.bFp);
        setDay(this.zj);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bFg = aVar;
    }

    public void setYear(int i) {
        if (i < this.bFj) {
            i = this.bFj;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bFj + " and " + this.bFk).showToastBottom();
        } else if (i > this.bFk) {
            i = this.bFk;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.bFj + " and " + this.bFk).showToast();
        }
        this.zh = i;
        this.bFd.setCurrentItem(this.zh - this.bFj);
    }

    public int getYear() {
        return this.zh;
    }

    public void setMonth(int i) {
        if (i < this.bFl) {
            i = this.bFl;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bFl + " and " + this.bFm).showToastBottom();
        } else if (i > this.bFm) {
            i = this.bFm;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.bFl + " and " + this.bFm).showToast();
        }
        this.zi = i;
        this.bFe.setCurrentItem(this.zi - this.bFl);
    }

    public int getMonth() {
        return this.zi;
    }

    public void setDay(int i) {
        if (i < this.bFo || i > this.bFp) {
            i = this.bFo;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bFo + " and " + this.bFp).showToast();
        } else if (i > this.bFp) {
            i = this.bFp;
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.bFo + " and " + this.bFp).showToastBottom();
        }
        this.zj = i;
        this.bFf.setCurrentItem(this.zj - this.bFo);
    }

    public int getDay() {
        return this.zj;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.bFh = date;
            this.bFj = this.bFh.getYear() + 1900;
            return;
        }
        this.bFj = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.bFi = date;
            this.bFk = this.bFi.getYear() + 1900;
            return;
        }
        this.bFk = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.bFq = str;
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
                    this.bFd.setGravity(17);
                    this.bFe.setVisibility(8);
                    this.bFf.setVisibility(8);
                    return;
                case 1:
                    this.bFd.setGravity(5);
                    this.bFd.setGravityOffset(this.bFs);
                    this.bFe.setGravity(3);
                    this.bFe.setGravityOffset(this.bFs);
                    this.bFe.setVisibility(0);
                    this.bFf.setVisibility(8);
                    return;
                default:
                    this.bFd.setGravity(5);
                    this.bFd.setGravityOffset(this.bFs);
                    this.bFf.setGravity(3);
                    this.bFf.setGravityOffset(this.bFs);
                    this.bFe.setVisibility(0);
                    this.bFf.setVisibility(0);
                    return;
            }
        }
    }

    public boolean kk(String str) {
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
                wheelView3d = this.bFd;
                break;
            case 1:
                wheelView3d = this.bFe;
                break;
            case 2:
                wheelView3d = this.bFf;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.bFr = z;
        this.bFd.setIsOptions(z);
        this.bFe.setIsOptions(z);
        this.bFf.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.bFe.setCyclic(z);
        this.bFd.setCyclic(z);
        this.bFf.setCyclic(z);
    }
}
