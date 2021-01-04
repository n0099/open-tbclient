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
    private int VL;
    private int VM;
    private int VN;
    private BdDatePicker dEB;
    private Date dxi;
    private Date dxj;
    private String dxr;
    private boolean dxs;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.VL = i;
    }

    public int getYear() {
        return this.dEB.getYear();
    }

    public void setMonth(int i) {
        this.VM = i;
    }

    public int getMonth() {
        return this.dEB.getMonth();
    }

    public void setDay(int i) {
        this.VN = i;
    }

    public int getDay() {
        return this.dEB.getDay();
    }

    private boolean sd(String str) {
        return this.dEB.sd(str);
    }

    public String aLn() {
        StringBuilder sb = new StringBuilder();
        if (sd("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (sd("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (sd(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aLo() {
        this.dEB = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dEB.setLayoutParams(layoutParams);
        this.dEB.setScrollCycle(true);
        this.dEB.setStartDate(this.dxi);
        this.dEB.setEndDate(this.dxj);
        this.dEB.setYear(this.VL);
        this.dEB.setMonth(this.VM);
        this.dEB.setDay(this.VN);
        this.dEB.aJZ();
        this.dEB.setFields(this.dxr);
        this.dEB.setDisabled(this.dxs);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aLo();
        aLB().aL(this.dEB);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.dxr = str;
    }

    public void setDisabled(boolean z) {
        this.dxs = z;
    }

    public void setStartDate(Date date) {
        this.dxi = date;
    }

    public void setEndDate(Date date) {
        this.dxj = date;
    }

    /* loaded from: classes9.dex */
    public static class a extends h.a {
        public Date dEC;
        public Date dED;
        public Date dEE;
        private String dEF;
        private boolean dEG;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h dk(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.dEC = date;
            return this;
        }

        public a g(Date date) {
            this.dED = date;
            return this;
        }

        public a h(Date date) {
            this.dEE = date;
            return this;
        }

        public a so(String str) {
            this.dEF = str;
            return this;
        }

        public a gQ(boolean z) {
            this.dEG = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aLp() {
            d dVar = (d) super.aLp();
            dVar.setFields(this.dEF);
            dVar.setDisabled(this.dEG);
            if (this.dEE != null) {
                dVar.setYear(this.dEE.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.dEE.getMonth() + 1);
                dVar.setDay(this.dEE.getDate());
            }
            if (this.dEC != null) {
                dVar.setStartDate(this.dEC);
            }
            if (this.dED != null) {
                dVar.setEndDate(this.dED);
            }
            return dVar;
        }
    }
}
