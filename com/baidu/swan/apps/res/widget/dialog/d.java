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
    private int ST;
    private int SU;
    private int SV;
    private Date cja;
    private Date cjb;
    private String cjj;
    private boolean cjk;
    private BdDatePicker cmR;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.ST = i;
    }

    public int getYear() {
        return this.cmR.getYear();
    }

    public void setMonth(int i) {
        this.SU = i;
    }

    public int getMonth() {
        return this.cmR.getMonth();
    }

    public void setDay(int i) {
        this.SV = i;
    }

    public int getDay() {
        return this.cmR.getDay();
    }

    private boolean lO(String str) {
        return this.cmR.lO(str);
    }

    public String akn() {
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

    private void ako() {
        this.cmR = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cmR.setLayoutParams(layoutParams);
        this.cmR.setScrollCycle(true);
        this.cmR.setStartDate(this.cja);
        this.cmR.setEndDate(this.cjb);
        this.cmR.setYear(this.ST);
        this.cmR.setMonth(this.SU);
        this.cmR.setDay(this.SV);
        this.cmR.ajK();
        this.cmR.setFields(this.cjj);
        this.cmR.setDisabled(this.cjk);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        ako();
        akx().ap(this.cmR);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.cjj = str;
    }

    public void setDisabled(boolean z) {
        this.cjk = z;
    }

    public void setStartDate(Date date) {
        this.cja = date;
    }

    public void setEndDate(Date date) {
        this.cjb = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date cmS;
        public Date cmT;
        public Date cmU;
        private String cmV;
        private boolean cmW;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h bS(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.cmS = date;
            return this;
        }

        public a e(Date date) {
            this.cmT = date;
            return this;
        }

        public a f(Date date) {
            this.cmU = date;
            return this;
        }

        public a lU(String str) {
            this.cmV = str;
            return this;
        }

        public a ev(boolean z) {
            this.cmW = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h akp() {
            d dVar = (d) super.akp();
            dVar.setFields(this.cmV);
            dVar.setDisabled(this.cmW);
            if (this.cmU != null) {
                dVar.setYear(this.cmU.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.cmU.getMonth() + 1);
                dVar.setDay(this.cmU.getDate());
            }
            if (this.cmS != null) {
                dVar.setStartDate(this.cmS);
            }
            if (this.cmT != null) {
                dVar.setEndDate(this.cmT);
            }
            return dVar;
        }
    }
}
