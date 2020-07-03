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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes11.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int TG;
    private int TH;
    private int TI;
    private int czA;
    private int czB;
    private WheelView3d czl;
    private WheelView3d czm;
    private WheelView3d czn;
    private a czo;
    private Date czp;
    private Date czq;
    private int czr;
    private int czs;
    private int czt;
    private int czu;
    private int czv;
    private int czw;
    private int czx;
    private String czy;
    private boolean czz;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.TG = FeatureCodes.SKY_SEG;
        this.TH = 1;
        this.TI = 1;
        this.czr = FeatureCodes.SKY_SEG;
        this.czs = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.czt = 1;
        this.czu = 12;
        this.czv = 31;
        this.czw = 1;
        this.czx = this.czv;
        this.czA = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TG = FeatureCodes.SKY_SEG;
        this.TH = 1;
        this.TI = 1;
        this.czr = FeatureCodes.SKY_SEG;
        this.czs = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.czt = 1;
        this.czu = 12;
        this.czv = 31;
        this.czw = 1;
        this.czx = this.czv;
        this.czA = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TG = FeatureCodes.SKY_SEG;
        this.TH = 1;
        this.TI = 1;
        this.czr = FeatureCodes.SKY_SEG;
        this.czs = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.czt = 1;
        this.czu = 12;
        this.czv = 31;
        this.czw = 1;
        this.czx = this.czv;
        this.czA = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.czA = ag.D(this.czA);
        this.mTextSize = ag.D(16.0f);
        this.czB = ag.D(14.0f);
        this.czl = (WheelView3d) findViewById(a.f.wheel_year);
        this.czl.setCenterTextSize(this.mTextSize);
        this.czl.setOuterTextSize(this.czB);
        this.czl.setLineSpacingMultiplier(3.0f);
        this.czl.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.czl.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.czl.setDividerType(WheelView3d.DividerType.FILL);
        this.czl.setVisibleItem(7);
        this.czl.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.TG = BdDatePicker.this.czr + i;
                BdDatePicker.this.aoG();
                BdDatePicker.this.aoH();
            }
        });
        this.czm = (WheelView3d) findViewById(a.f.wheel_month);
        this.czm.setCenterTextSize(this.mTextSize);
        this.czm.setOuterTextSize(this.czB);
        this.czm.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.czm.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.czm.setLineSpacingMultiplier(3.0f);
        this.czm.setDividerType(WheelView3d.DividerType.FILL);
        this.czm.setVisibleItem(7);
        this.czm.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.TH = BdDatePicker.this.czt + i;
                BdDatePicker.this.aoH();
            }
        });
        this.czn = (WheelView3d) findViewById(a.f.wheel_day);
        this.czn.setCenterTextSize(this.mTextSize);
        this.czn.setOuterTextSize(this.czB);
        this.czn.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.czn.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.czn.setLineSpacingMultiplier(3.0f);
        this.czn.setDividerType(WheelView3d.DividerType.FILL);
        this.czn.setVisibleItem(7);
        this.czn.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.TI = BdDatePicker.this.czw + i;
            }
        });
        aoD();
    }

    private void aoD() {
        Calendar calendar = Calendar.getInstance();
        this.TG = calendar.get(1);
        this.TH = calendar.get(2) + 1;
        this.TI = calendar.get(5);
        aoE();
    }

    public void aoE() {
        aoF();
        aoG();
        aoH();
    }

    private void aoF() {
        if (this.TG < this.czr || this.TG > this.czs) {
            this.TG = this.czr;
        }
        this.czl.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.czr, this.czs));
        a(this.czl, this.czr, this.czs);
    }

    public void aoG() {
        this.czt = 1;
        this.czu = 12;
        if (this.czp != null && this.TG == this.czr) {
            this.czt = this.czp.getMonth() + 1;
        }
        if (this.czq != null && this.TG == this.czs) {
            this.czu = this.czq.getMonth() + 1;
        }
        this.czm.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.czt, this.czu));
        a(this.czm, this.czt, this.czu);
        setMonth(this.TH);
    }

    public void aoH() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.TH) >= 0) {
            this.czv = 31;
        } else if (Arrays.binarySearch(iArr, this.TH) >= 0) {
            this.czv = 30;
        } else if ((this.TG % 4 == 0 && this.TG % 100 != 0) || this.TG % 400 == 0) {
            this.czv = 29;
        } else {
            this.czv = 28;
        }
        this.czw = 1;
        this.czx = this.czv;
        if (this.czp != null && this.TG == this.czr && this.TH == this.czp.getMonth() + 1) {
            this.czw = this.czp.getDate();
        }
        if (this.czq != null && this.TG == this.czs && this.TH == this.czq.getMonth() + 1) {
            this.czx = this.czq.getDate();
        }
        this.czn.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.czw, this.czx));
        a(this.czn, this.czw, this.czx);
        setDay(this.TI);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.czo = aVar;
    }

    public void setYear(int i) {
        if (i < this.czr) {
            i = this.czr;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.czr + " and " + this.czs).showToastBottom();
            }
        } else if (i > this.czs) {
            i = this.czs;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.czr + " and " + this.czs).showToast();
            }
        }
        this.TG = i;
        this.czl.setCurrentItem(this.TG - this.czr);
    }

    public int getYear() {
        return this.TG;
    }

    public void setMonth(int i) {
        if (i < this.czt) {
            i = this.czt;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.czt + " and " + this.czu).showToastBottom();
            }
        } else if (i > this.czu) {
            i = this.czu;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.czt + " and " + this.czu).showToast();
            }
        }
        this.TH = i;
        this.czm.setCurrentItem(this.TH - this.czt);
    }

    public int getMonth() {
        return this.TH;
    }

    public void setDay(int i) {
        if (i < this.czw || i > this.czx) {
            i = this.czw;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.czw + " and " + this.czx).showToast();
            }
        } else if (i > this.czx) {
            i = this.czx;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.czw + " and " + this.czx).showToastBottom();
            }
        }
        this.TI = i;
        this.czn.setCurrentItem(this.TI - this.czw);
    }

    public int getDay() {
        return this.TI;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.czp = date;
            this.czr = this.czp.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.czr = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.czq = date;
            this.czs = this.czq.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.czs = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.czy = str;
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
                    this.czl.setGravity(17);
                    this.czm.setVisibility(8);
                    this.czn.setVisibility(8);
                    return;
                case 1:
                    this.czl.setGravity(5);
                    this.czl.setGravityOffset(this.czA);
                    this.czm.setGravity(3);
                    this.czm.setGravityOffset(this.czA);
                    this.czm.setVisibility(0);
                    this.czn.setVisibility(8);
                    return;
                default:
                    this.czl.setGravity(5);
                    this.czl.setGravityOffset(this.czA);
                    this.czn.setGravity(3);
                    this.czn.setGravityOffset(this.czA);
                    this.czm.setVisibility(0);
                    this.czn.setVisibility(0);
                    return;
            }
        }
    }

    public boolean nr(String str) {
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
                wheelView3d = this.czl;
                break;
            case 1:
                wheelView3d = this.czm;
                break;
            case 2:
                wheelView3d = this.czn;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.czz = z;
        this.czl.setIsOptions(z);
        this.czm.setIsOptions(z);
        this.czn.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.czm.setCyclic(z);
        this.czl.setCyclic(z);
        this.czn.setCyclic(z);
    }
}
