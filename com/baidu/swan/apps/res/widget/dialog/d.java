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
    private Date cKn;
    private Date cKo;
    private String cKw;
    private boolean cKx;
    private BdDatePicker cOS;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.Ue = i;
    }

    public int getYear() {
        return this.cOS.getYear();
    }

    public void setMonth(int i) {
        this.Uf = i;
    }

    public int getMonth() {
        return this.cOS.getMonth();
    }

    public void setDay(int i) {
        this.Ug = i;
    }

    public int getDay() {
        return this.cOS.getDay();
    }

    private boolean pW(String str) {
        return this.cOS.pW(str);
    }

    public String azg() {
        StringBuilder sb = new StringBuilder();
        if (pW("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (pW("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (pW("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void azh() {
        this.cOS = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cOS.setLayoutParams(layoutParams);
        this.cOS.setScrollCycle(true);
        this.cOS.setStartDate(this.cKn);
        this.cOS.setEndDate(this.cKo);
        this.cOS.setYear(this.Ue);
        this.cOS.setMonth(this.Uf);
        this.cOS.setDay(this.Ug);
        this.cOS.ays();
        this.cOS.setFields(this.cKw);
        this.cOS.setDisabled(this.cKx);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        azh();
        azq().at(this.cOS);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.cKw = str;
    }

    public void setDisabled(boolean z) {
        this.cKx = z;
    }

    public void setStartDate(Date date) {
        this.cKn = date;
    }

    public void setEndDate(Date date) {
        this.cKo = date;
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public Date cOT;
        public Date cOU;
        public Date cOV;
        private String cOW;
        private boolean cOX;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.cOT = date;
            return this;
        }

        public a g(Date date) {
            this.cOU = date;
            return this;
        }

        public a h(Date date) {
            this.cOV = date;
            return this;
        }

        public a qd(String str) {
            this.cOW = str;
            return this;
        }

        public a fv(boolean z) {
            this.cOX = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h azi() {
            d dVar = (d) super.azi();
            dVar.setFields(this.cOW);
            dVar.setDisabled(this.cOX);
            if (this.cOV != null) {
                dVar.setYear(this.cOV.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.cOV.getMonth() + 1);
                dVar.setDay(this.cOV.getDate());
            }
            if (this.cOT != null) {
                dVar.setStartDate(this.cOT);
            }
            if (this.cOU != null) {
                dVar.setEndDate(this.cOU);
            }
            return dVar;
        }
    }
}
