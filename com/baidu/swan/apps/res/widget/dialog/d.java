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
    private int SQ;
    private int SR;
    private int SS;
    private Date ciU;
    private Date ciV;
    private String cjd;
    private boolean cje;
    private BdDatePicker cmL;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.SQ = i;
    }

    public int getYear() {
        return this.cmL.getYear();
    }

    public void setMonth(int i) {
        this.SR = i;
    }

    public int getMonth() {
        return this.cmL.getMonth();
    }

    public void setDay(int i) {
        this.SS = i;
    }

    public int getDay() {
        return this.cmL.getDay();
    }

    private boolean lO(String str) {
        return this.cmL.lO(str);
    }

    public String ako() {
        StringBuilder sb = new StringBuilder();
        if (lO("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (lO("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (lO("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void akp() {
        this.cmL = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cmL.setLayoutParams(layoutParams);
        this.cmL.setScrollCycle(true);
        this.cmL.setStartDate(this.ciU);
        this.cmL.setEndDate(this.ciV);
        this.cmL.setYear(this.SQ);
        this.cmL.setMonth(this.SR);
        this.cmL.setDay(this.SS);
        this.cmL.ajL();
        this.cmL.setFields(this.cjd);
        this.cmL.setDisabled(this.cje);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        akp();
        aky().ap(this.cmL);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.cjd = str;
    }

    public void setDisabled(boolean z) {
        this.cje = z;
    }

    public void setStartDate(Date date) {
        this.ciU = date;
    }

    public void setEndDate(Date date) {
        this.ciV = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date cmM;
        public Date cmN;
        public Date cmO;
        private String cmP;
        private boolean cmQ;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h ce(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.cmM = date;
            return this;
        }

        public a e(Date date) {
            this.cmN = date;
            return this;
        }

        public a f(Date date) {
            this.cmO = date;
            return this;
        }

        public a lU(String str) {
            this.cmP = str;
            return this;
        }

        public a ev(boolean z) {
            this.cmQ = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h akq() {
            d dVar = (d) super.akq();
            dVar.setFields(this.cmP);
            dVar.setDisabled(this.cmQ);
            if (this.cmO != null) {
                dVar.setYear(this.cmO.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.cmO.getMonth() + 1);
                dVar.setDay(this.cmO.getDate());
            }
            if (this.cmM != null) {
                dVar.setStartDate(this.cmM);
            }
            if (this.cmN != null) {
                dVar.setEndDate(this.cmN);
            }
            return dVar;
        }
    }
}
