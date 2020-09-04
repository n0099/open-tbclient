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
/* loaded from: classes8.dex */
public class d extends h {
    private int Ue;
    private int Uf;
    private int Ug;
    private String cKA;
    private boolean cKB;
    private Date cKr;
    private Date cKs;
    private BdDatePicker cOW;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.Ue = i;
    }

    public int getYear() {
        return this.cOW.getYear();
    }

    public void setMonth(int i) {
        this.Uf = i;
    }

    public int getMonth() {
        return this.cOW.getMonth();
    }

    public void setDay(int i) {
        this.Ug = i;
    }

    public int getDay() {
        return this.cOW.getDay();
    }

    private boolean pX(String str) {
        return this.cOW.pX(str);
    }

    public String azg() {
        StringBuilder sb = new StringBuilder();
        if (pX("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (pX("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (pX("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void azh() {
        this.cOW = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cOW.setLayoutParams(layoutParams);
        this.cOW.setScrollCycle(true);
        this.cOW.setStartDate(this.cKr);
        this.cOW.setEndDate(this.cKs);
        this.cOW.setYear(this.Ue);
        this.cOW.setMonth(this.Uf);
        this.cOW.setDay(this.Ug);
        this.cOW.ays();
        this.cOW.setFields(this.cKA);
        this.cOW.setDisabled(this.cKB);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        azh();
        azq().at(this.cOW);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.cKA = str;
    }

    public void setDisabled(boolean z) {
        this.cKB = z;
    }

    public void setStartDate(Date date) {
        this.cKr = date;
    }

    public void setEndDate(Date date) {
        this.cKs = date;
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public Date cOX;
        public Date cOY;
        public Date cOZ;
        private String cPa;
        private boolean cPb;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.cOX = date;
            return this;
        }

        public a g(Date date) {
            this.cOY = date;
            return this;
        }

        public a h(Date date) {
            this.cOZ = date;
            return this;
        }

        public a qe(String str) {
            this.cPa = str;
            return this;
        }

        public a fw(boolean z) {
            this.cPb = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h azi() {
            d dVar = (d) super.azi();
            dVar.setFields(this.cPa);
            dVar.setDisabled(this.cPb);
            if (this.cOZ != null) {
                dVar.setYear(this.cOZ.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.cOZ.getMonth() + 1);
                dVar.setDay(this.cOZ.getDate());
            }
            if (this.cOX != null) {
                dVar.setStartDate(this.cOX);
            }
            if (this.cOY != null) {
                dVar.setEndDate(this.cOY);
            }
            return dVar;
        }
    }
}
