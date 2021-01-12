package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes8.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int VJ;
    private int VK;
    private int VL;
    private int dsA;
    private int dsB;
    private int dsC;
    private int dsD;
    private String dsE;
    private boolean dsF;
    private int dsG;
    private int dsH;
    private WheelView3d dsq;
    private WheelView3d dsr;
    private WheelView3d dss;
    private a dsu;
    private Date dsv;
    private Date dsw;
    private int dsx;
    private int dsy;
    private int dsz;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public BdDatePicker(Context context) {
        super(context);
        this.VJ = FeatureCodes.SKY_SEG;
        this.VK = 1;
        this.VL = 1;
        this.dsx = FeatureCodes.SKY_SEG;
        this.dsy = 2100;
        this.dsz = 1;
        this.dsA = 12;
        this.dsB = 31;
        this.dsC = 1;
        this.dsD = this.dsB;
        this.dsG = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VJ = FeatureCodes.SKY_SEG;
        this.VK = 1;
        this.VL = 1;
        this.dsx = FeatureCodes.SKY_SEG;
        this.dsy = 2100;
        this.dsz = 1;
        this.dsA = 12;
        this.dsB = 31;
        this.dsC = 1;
        this.dsD = this.dsB;
        this.dsG = 12;
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.VJ = FeatureCodes.SKY_SEG;
        this.VK = 1;
        this.VL = 1;
        this.dsx = FeatureCodes.SKY_SEG;
        this.dsy = 2100;
        this.dsz = 1;
        this.dsA = 12;
        this.dsB = 31;
        this.dsC = 1;
        this.dsD = this.dsB;
        this.dsG = 12;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.dsG = ah.O(this.dsG);
        this.mTextSize = ah.O(16.0f);
        this.dsH = ah.O(14.0f);
        this.dsq = (WheelView3d) findViewById(a.f.wheel_year);
        this.dsq.setCenterTextSize(this.mTextSize);
        this.dsq.setOuterTextSize(this.dsH);
        this.dsq.setLineSpacingMultiplier(3.0f);
        this.dsq.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dsq.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dsq.setDividerType(WheelView3d.DividerType.FILL);
        this.dsq.setVisibleItem(7);
        this.dsq.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VJ = BdDatePicker.this.dsx + i;
                BdDatePicker.this.aGi();
                BdDatePicker.this.aGj();
            }
        });
        this.dsr = (WheelView3d) findViewById(a.f.wheel_month);
        this.dsr.setCenterTextSize(this.mTextSize);
        this.dsr.setOuterTextSize(this.dsH);
        this.dsr.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dsr.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dsr.setLineSpacingMultiplier(3.0f);
        this.dsr.setDividerType(WheelView3d.DividerType.FILL);
        this.dsr.setVisibleItem(7);
        this.dsr.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.2
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VK = BdDatePicker.this.dsz + i;
                BdDatePicker.this.aGj();
            }
        });
        this.dss = (WheelView3d) findViewById(a.f.wheel_day);
        this.dss.setCenterTextSize(this.mTextSize);
        this.dss.setOuterTextSize(this.dsH);
        this.dss.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
        this.dss.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
        this.dss.setLineSpacingMultiplier(3.0f);
        this.dss.setDividerType(WheelView3d.DividerType.FILL);
        this.dss.setVisibleItem(7);
        this.dss.setOnItemSelectedListener(new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.3
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                BdDatePicker.this.VL = BdDatePicker.this.dsC + i;
            }
        });
        aGf();
    }

    private void aGf() {
        Calendar calendar = Calendar.getInstance();
        this.VJ = calendar.get(1);
        this.VK = calendar.get(2) + 1;
        this.VL = calendar.get(5);
        aGg();
    }

    public void aGg() {
        aGh();
        aGi();
        aGj();
    }

    private void aGh() {
        if (this.VJ < this.dsx || this.VJ > this.dsy) {
            this.VJ = this.dsx;
        }
        this.dsq.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dsx, this.dsy));
        a(this.dsq, this.dsx, this.dsy);
    }

    public void aGi() {
        this.dsz = 1;
        this.dsA = 12;
        if (this.dsv != null && this.VJ == this.dsx) {
            this.dsz = this.dsv.getMonth() + 1;
        }
        if (this.dsw != null && this.VJ == this.dsy) {
            this.dsA = this.dsw.getMonth() + 1;
        }
        this.dsr.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dsz, this.dsA));
        a(this.dsr, this.dsz, this.dsA);
        setMonth(this.VK);
    }

    public void aGj() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.VK) >= 0) {
            this.dsB = 31;
        } else if (Arrays.binarySearch(iArr, this.VK) >= 0) {
            this.dsB = 30;
        } else if ((this.VJ % 4 == 0 && this.VJ % 100 != 0) || this.VJ % 400 == 0) {
            this.dsB = 29;
        } else {
            this.dsB = 28;
        }
        this.dsC = 1;
        this.dsD = this.dsB;
        if (this.dsv != null && this.VJ == this.dsx && this.VK == this.dsv.getMonth() + 1) {
            this.dsC = this.dsv.getDate();
        }
        if (this.dsw != null && this.VJ == this.dsy && this.VK == this.dsw.getMonth() + 1) {
            this.dsD = this.dsw.getDate();
        }
        this.dss.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.b(this.dsC, this.dsD));
        a(this.dss, this.dsC, this.dsD);
        setDay(this.VL);
    }

    private void a(WheelView3d wheelView3d, int i, int i2) {
        if ((i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }

    public void setOnTimeChangeListener(a aVar) {
        this.dsu = aVar;
    }

    public void setYear(int i) {
        if (i < this.dsx) {
            i = this.dsx;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dsx + " and " + this.dsy).aIb();
            }
        } else if (i > this.dsy) {
            i = this.dsy;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The year must be between " + this.dsx + " and " + this.dsy).aHZ();
            }
        }
        this.VJ = i;
        this.dsq.setCurrentItem(this.VJ - this.dsx);
    }

    public int getYear() {
        return this.VJ;
    }

    public void setMonth(int i) {
        if (i < this.dsz) {
            i = this.dsz;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dsz + " and " + this.dsA).aIb();
            }
        } else if (i > this.dsA) {
            i = this.dsA;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The month must be between " + this.dsz + " and " + this.dsA).aHZ();
            }
        }
        this.VK = i;
        this.dsr.setCurrentItem(this.VK - this.dsz);
    }

    public int getMonth() {
        return this.VK;
    }

    public void setDay(int i) {
        if (i < this.dsC || i > this.dsD) {
            i = this.dsC;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dsC + " and " + this.dsD).aHZ();
            }
        } else if (i > this.dsD) {
            i = this.dsD;
            if (DEBUG) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "The day must be between " + this.dsC + " and " + this.dsD).aIb();
            }
        }
        this.VL = i;
        this.dss.setCurrentItem(this.VL - this.dsC);
    }

    public int getDay() {
        return this.VL;
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.dsv = date;
            this.dsx = this.dsv.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dsx = FeatureCodes.SKY_SEG;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.dsw = date;
            this.dsy = this.dsw.getYear() + FeatureCodes.SKY_SEG;
            return;
        }
        this.dsy = 2100;
    }

    public void setFields(String str) {
        this.dsE = str;
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
                    this.dsq.setGravity(17);
                    this.dsr.setVisibility(8);
                    this.dss.setVisibility(8);
                    return;
                case 1:
                    this.dsq.setGravity(5);
                    this.dsq.setGravityOffset(this.dsG);
                    this.dsr.setGravity(3);
                    this.dsr.setGravityOffset(this.dsG);
                    this.dsr.setVisibility(0);
                    this.dss.setVisibility(8);
                    return;
                default:
                    this.dsq.setGravity(5);
                    this.dsq.setGravityOffset(this.dsG);
                    this.dss.setGravity(3);
                    this.dss.setGravityOffset(this.dsG);
                    this.dsr.setVisibility(0);
                    this.dss.setVisibility(0);
                    return;
            }
        }
    }

    public boolean qS(String str) {
        WheelView3d wheelView3d = null;
        char c = 65535;
        switch (str.hashCode()) {
            case 99228:
                if (str.equals(Config.TRACE_VISIT_RECENT_DAY)) {
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
                wheelView3d = this.dsq;
                break;
            case 1:
                wheelView3d = this.dsr;
                break;
            case 2:
                wheelView3d = this.dss;
                break;
        }
        return wheelView3d != null && wheelView3d.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.dsF = z;
        this.dsq.setIsOptions(z);
        this.dsr.setIsOptions(z);
        this.dss.setIsOptions(z);
    }

    public void setScrollCycle(boolean z) {
        this.dsr.setCyclic(z);
        this.dsq.setCyclic(z);
        this.dss.setCyclic(z);
    }
}
