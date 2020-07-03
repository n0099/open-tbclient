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
/* loaded from: classes11.dex */
public class d extends h {
    private int TG;
    private int TH;
    private int TI;
    private BdDatePicker cDh;
    private Date czp;
    private Date czq;
    private String czy;
    private boolean czz;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.TG = i;
    }

    public int getYear() {
        return this.cDh.getYear();
    }

    public void setMonth(int i) {
        this.TH = i;
    }

    public int getMonth() {
        return this.cDh.getMonth();
    }

    public void setDay(int i) {
        this.TI = i;
    }

    public int getDay() {
        return this.cDh.getDay();
    }

    private boolean nr(String str) {
        return this.cDh.nr(str);
    }

    public String apl() {
        StringBuilder sb = new StringBuilder();
        if (nr("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (nr("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (nr("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void apm() {
        this.cDh = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cDh.setLayoutParams(layoutParams);
        this.cDh.setScrollCycle(true);
        this.cDh.setStartDate(this.czp);
        this.cDh.setEndDate(this.czq);
        this.cDh.setYear(this.TG);
        this.cDh.setMonth(this.TH);
        this.cDh.setDay(this.TI);
        this.cDh.aoE();
        this.cDh.setFields(this.czy);
        this.cDh.setDisabled(this.czz);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        apm();
        apv().ap(this.cDh);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.czy = str;
    }

    public void setDisabled(boolean z) {
        this.czz = z;
    }

    public void setStartDate(Date date) {
        this.czp = date;
    }

    public void setEndDate(Date date) {
        this.czq = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date cDi;
        public Date cDj;
        public Date cDk;
        private String cDl;
        private boolean cDm;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h ce(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.cDi = date;
            return this;
        }

        public a e(Date date) {
            this.cDj = date;
            return this;
        }

        public a f(Date date) {
            this.cDk = date;
            return this;
        }

        public a nx(String str) {
            this.cDl = str;
            return this;
        }

        public a eT(boolean z) {
            this.cDm = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h apn() {
            d dVar = (d) super.apn();
            dVar.setFields(this.cDl);
            dVar.setDisabled(this.cDm);
            if (this.cDk != null) {
                dVar.setYear(this.cDk.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.cDk.getMonth() + 1);
                dVar.setDay(this.cDk.getDate());
            }
            if (this.cDi != null) {
                dVar.setStartDate(this.cDi);
            }
            if (this.cDj != null) {
                dVar.setEndDate(this.cDj);
            }
            return dVar;
        }
    }
}
