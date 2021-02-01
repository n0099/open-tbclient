package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes9.dex */
public class d extends h {
    private int VH;
    private int VI;
    private int VJ;
    private BdDatePicker dBU;
    private Date duG;
    private Date duH;
    private String duP;
    private boolean duQ;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.VH = i;
    }

    public int getYear() {
        return this.dBU.getYear();
    }

    public void setMonth(int i) {
        this.VI = i;
    }

    public int getMonth() {
        return this.dBU.getMonth();
    }

    public void setDay(int i) {
        this.VJ = i;
    }

    public int getDay() {
        return this.dBU.getDay();
    }

    private boolean rk(String str) {
        return this.dBU.rk(str);
    }

    public String aHN() {
        StringBuilder sb = new StringBuilder();
        if (rk("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (rk("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (rk(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aHO() {
        this.dBU = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dBU.setLayoutParams(layoutParams);
        this.dBU.setScrollCycle(true);
        this.dBU.setStartDate(this.duG);
        this.dBU.setEndDate(this.duH);
        this.dBU.setYear(this.VH);
        this.dBU.setMonth(this.VI);
        this.dBU.setDay(this.VJ);
        this.dBU.aGB();
        this.dBU.setFields(this.duP);
        this.dBU.setDisabled(this.duQ);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aHO();
        aIb().aH(this.dBU);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.duP = str;
    }

    public void setDisabled(boolean z) {
        this.duQ = z;
    }

    public void setStartDate(Date date) {
        this.duG = date;
    }

    public void setEndDate(Date date) {
        this.duH = date;
    }

    /* loaded from: classes9.dex */
    public static class a extends h.a {
        public Date dBV;
        public Date dBW;
        public Date dBX;
        private String dBY;
        private boolean dBZ;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h di(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.dBV = date;
            return this;
        }

        public a g(Date date) {
            this.dBW = date;
            return this;
        }

        public a h(Date date) {
            this.dBX = date;
            return this;
        }

        public a rw(String str) {
            this.dBY = str;
            return this;
        }

        public a gO(boolean z) {
            this.dBZ = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aHP() {
            d dVar = (d) super.aHP();
            dVar.setFields(this.dBY);
            dVar.setDisabled(this.dBZ);
            if (this.dBX != null) {
                dVar.setYear(this.dBX.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.dBX.getMonth() + 1);
                dVar.setDay(this.dBX.getDate());
            }
            if (this.dBV != null) {
                dVar.setStartDate(this.dBV);
            }
            if (this.dBW != null) {
                dVar.setEndDate(this.dBW);
            }
            return dVar;
        }
    }
}
