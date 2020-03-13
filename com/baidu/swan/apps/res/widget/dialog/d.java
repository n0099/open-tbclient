package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes11.dex */
public class d extends h {
    private Date bJZ;
    private Date bKa;
    private String bKi;
    private boolean bKj;
    private BdDatePicker bNP;
    private int zD;
    private int zE;
    private int zF;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.zD = i;
    }

    public int getYear() {
        return this.bNP.getYear();
    }

    public void setMonth(int i) {
        this.zE = i;
    }

    public int getMonth() {
        return this.bNP.getMonth();
    }

    public void setDay(int i) {
        this.zF = i;
    }

    public int getDay() {
        return this.bNP.getDay();
    }

    private boolean kC(String str) {
        return this.bNP.kC(str);
    }

    public String acg() {
        StringBuilder sb = new StringBuilder();
        if (kC("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (kC("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (kC("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void ach() {
        this.bNP = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bNP.setLayoutParams(layoutParams);
        this.bNP.setScrollCycle(true);
        this.bNP.setStartDate(this.bJZ);
        this.bNP.setEndDate(this.bKa);
        this.bNP.setYear(this.zD);
        this.bNP.setMonth(this.zE);
        this.bNP.setDay(this.zF);
        this.bNP.abD();
        this.bNP.setFields(this.bKi);
        this.bNP.setDisabled(this.bKj);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        ach();
        acq().ao(this.bNP);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.bKi = str;
    }

    public void setDisabled(boolean z) {
        this.bKj = z;
    }

    public void setStartDate(Date date) {
        this.bJZ = date;
    }

    public void setEndDate(Date date) {
        this.bKa = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date bNQ;
        public Date bNR;
        public Date bNS;
        private String bNT;
        private boolean bNU;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cr(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.bNQ = date;
            return this;
        }

        public a e(Date date) {
            this.bNR = date;
            return this;
        }

        public a f(Date date) {
            this.bNS = date;
            return this;
        }

        public a kI(String str) {
            this.bNT = str;
            return this;
        }

        public a dy(boolean z) {
            this.bNU = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aci() {
            d dVar = (d) super.aci();
            dVar.setFields(this.bNT);
            dVar.setDisabled(this.bNU);
            if (this.bNS != null) {
                dVar.setYear(this.bNS.getYear() + 1900);
                dVar.setMonth(this.bNS.getMonth() + 1);
                dVar.setDay(this.bNS.getDate());
            }
            if (this.bNQ != null) {
                dVar.setStartDate(this.bNQ);
            }
            if (this.bNR != null) {
                dVar.setEndDate(this.bNR);
            }
            return dVar;
        }
    }
}
