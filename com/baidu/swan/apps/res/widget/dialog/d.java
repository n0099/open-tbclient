package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes10.dex */
public class d extends h {
    private int UR;
    private int US;
    private int UT;
    private Date dgV;
    private Date dgW;
    private String dhe;
    private boolean dhf;
    private BdDatePicker dlD;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.UR = i;
    }

    public int getYear() {
        return this.dlD.getYear();
    }

    public void setMonth(int i) {
        this.US = i;
    }

    public int getMonth() {
        return this.dlD.getMonth();
    }

    public void setDay(int i) {
        this.UT = i;
    }

    public int getDay() {
        return this.dlD.getDay();
    }

    private boolean rv(String str) {
        return this.dlD.rv(str);
    }

    public String aEs() {
        StringBuilder sb = new StringBuilder();
        if (rv("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (rv("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (rv("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aEt() {
        this.dlD = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dlD.setLayoutParams(layoutParams);
        this.dlD.setScrollCycle(true);
        this.dlD.setStartDate(this.dgV);
        this.dlD.setEndDate(this.dgW);
        this.dlD.setYear(this.UR);
        this.dlD.setMonth(this.US);
        this.dlD.setDay(this.UT);
        this.dlD.aDE();
        this.dlD.setFields(this.dhe);
        this.dlD.setDisabled(this.dhf);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aEt();
        aEC().ax(this.dlD);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.dhe = str;
    }

    public void setDisabled(boolean z) {
        this.dhf = z;
    }

    public void setStartDate(Date date) {
        this.dgV = date;
    }

    public void setEndDate(Date date) {
        this.dgW = date;
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public Date dlE;
        public Date dlF;
        public Date dlG;
        private String dlH;
        private boolean dlI;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.dlE = date;
            return this;
        }

        public a g(Date date) {
            this.dlF = date;
            return this;
        }

        public a h(Date date) {
            this.dlG = date;
            return this;
        }

        public a rC(String str) {
            this.dlH = str;
            return this;
        }

        public a gd(boolean z) {
            this.dlI = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aEu() {
            d dVar = (d) super.aEu();
            dVar.setFields(this.dlH);
            dVar.setDisabled(this.dlI);
            if (this.dlG != null) {
                dVar.setYear(this.dlG.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.dlG.getMonth() + 1);
                dVar.setDay(this.dlG.getDate());
            }
            if (this.dlE != null) {
                dVar.setStartDate(this.dlE);
            }
            if (this.dlF != null) {
                dVar.setEndDate(this.dlF);
            }
            return dVar;
        }
    }
}
